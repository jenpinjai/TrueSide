/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.business;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import truecorp.prm.dao.IotAccrueBaseDAO;
import truecorp.prm.dao.IotAgreementBaseDAO;
import truecorp.prm.dao.IotMasterBaseDAO;
import truecorp.prm.dao.IotSdrRateBaseDAO;
import static truecorp.prm.process.MigrateAccrueData.currentTime;
import truecorp.prm.table.IotAccrue;
import truecorp.prm.table.IotAgreement;
import truecorp.prm.table.IotMaster;
import truecorp.prm.table.IotSdrRate;

/**
 *
 * @author Jennarong Pinjai
 */
public class AccrueBusiness {
    
    public static  void migrateData(String direction) throws Exception{
        System.out.println(currentTime()+"Process migrateData "+direction);
    
        try{
        
                List<IotMaster>  masterList = new IotMasterBaseDAO().findByDirection(direction); //Input
                
                List<IotMaster>  masterListValidated = new ArrayList<IotMaster>();
                
                
                for(IotMaster master : masterList){
                    if(master.getAgreementId()!=null){
                        masterListValidated.add(master);
                    }
                }
                
                
                List<IotAccrue>  accrueList = new ArrayList<IotAccrue>(); //Output
            
                Date systemDate = new Date();
                SimpleDateFormat reportDateFormat = new SimpleDateFormat("yyyyMMdd",Locale.US);
                SimpleDateFormat reportMonthFormat = new SimpleDateFormat("yyyyMM",Locale.US);
                String systemYear = new SimpleDateFormat("yyyy",Locale.US).format(systemDate);
                String systemMonth= new SimpleDateFormat("MM",Locale.US).format(systemDate);
                String prevGroupTadig ="";
                int loopCount=0;
                double THACA_callTadig=0;
                double THACT_callTadig=0;
                double THAMY_callTadig=0;
                
                double THACA_chargeLocal=0;
                double THACT_chargeLocal=0;
                double THAMY_chargeLocal=0;
                
                double THACA_net=0;
                double THACT_net=0;
                double THAMY_net=0;
                
                double THACA_CN=0;
                double THACT_CN=0;
                double THAMY_CN=0;
                
                double THACA_DN=0;
                double THACT_DN=0;
                double THAMY_DN=0;
                
                boolean isFirstProcess=true;
                IotMaster prevMaster = new IotMaster();
                for(IotMaster master : masterListValidated){
                    loopCount++;
                    
                    if(isFirstProcess){
                        
                        prevGroupTadig = master.getGroupTadig();
                        prevMaster = master;
                        isFirstProcess=false;
                    }
                    if(!prevGroupTadig.equals(master.getGroupTadig())||loopCount==masterListValidated.size()){////Start process Agreement when end group tadig
                       
                        prevGroupTadig = master.getGroupTadig();
                        if(loopCount==masterListValidated.size()){
                           
                            prevMaster = master;
                            if(master.getMyTadig().equals("THACA")){
                        
                                    THACA_callTadig = master.getCallTadig()==null?0d:master.getCallTadig().doubleValue();
                                    THACA_chargeLocal = master.getChargeLocal()==null?0d:master.getChargeLocal().doubleValue();
                                    THACA_net = master.getNet()==null?0d:master.getNet().doubleValue();
                            }else if(master.getMyTadig().equals("THACT")){

                                    THACT_callTadig = master.getCallTadig()==null?0d:master.getCallTadig().doubleValue();
                                    THACT_chargeLocal = master.getChargeLocal()==null?0d:master.getChargeLocal().doubleValue();
                                    THACT_net = master.getNet()==null?0d:master.getNet().doubleValue();

                            }else if(master.getMyTadig().equals("THAMY")){

                                    THAMY_callTadig = master.getCallTadig()==null?0d:master.getCallTadig().doubleValue();
                                    THAMY_chargeLocal = master.getChargeLocal()==null?0d:master.getChargeLocal().doubleValue();
                                    THAMY_net = master.getNet()==null?0d:master.getNet().doubleValue();
                            }
                        }
                        
                        IotAgreementBaseDAO agmntDAO = new IotAgreementBaseDAO();
                        String conditionDAO = " agreement_id = '"+prevMaster.getAgreementId()+"' and plmn_group_id = '"+prevMaster.getPlmnGroupId()+"' ";
                        IotAgreement  agreement =  agmntDAO.findByWhereCondisions(conditionDAO).get(0);

                        Calendar cal1 = Calendar.getInstance();
                        cal1.setTime(new Date(agreement.getEffectiveDate().getTime()));

                        Calendar cal2 = Calendar.getInstance();
                        cal2.setTime(new Date(agreement.getExpireDate().getTime()));

                        Calendar cal3 = Calendar.getInstance();
                        cal3.setTime(new java.util.Date());

                        int yearDiffExpire  =  cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
                        int dayDiffExpire   =  cal2.get(Calendar.DAY_OF_MONTH) - cal1.get(Calendar.DAY_OF_MONTH);

                        int yearDiffCurrent =  cal3.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
                        int dayDiffCurrent  =  cal3.get(Calendar.DAY_OF_MONTH) - cal1.get(Calendar.DAY_OF_MONTH);

                        int monthDiffExpire =  yearDiffExpire*12 +  cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH) + (dayDiffExpire/25);//____1
                        int monthDiffCurrent =  yearDiffCurrent*12 +  cal3.get(Calendar.MONTH) - cal1.get(Calendar.MONTH) ;//____2
                        double ib_commitment_amt =0;
                        if(direction.equals("INBOUND")){
                                ib_commitment_amt =   agreement.getIbCommitmentAmt()==null?0d:agreement.getIbCommitmentAmt().doubleValue();//____4
                        }else if(direction.equals("OUTBOUND")){
                                ib_commitment_amt =   agreement.getObCommitmentAmt()==null?0d:agreement.getObCommitmentAmt().doubleValue();//____4
                        }
                        if(agreement.getIbCurrencyCd()!=null&&!agreement.getIbCurrencyCd().equals("THB")){

                            double sdrTHB=0;
                            double sdrOther=0;
                            double sdrRateResult =0;
                            String sdrWhereCon = "currency_cd in ('THB','"+agreement.getIbCurrencyCd()+"') and sdr_year = '"+systemYear+"' and sdr_month = '"+(Integer.valueOf(systemMonth))+"' ";
                            List<IotSdrRate> sdrRatePack = new IotSdrRateBaseDAO().findByWhereCondisions(sdrWhereCon);
                            for(IotSdrRate sdrRate : sdrRatePack){
                                 if(sdrRate.getCurrencyCd()!=null&&sdrRate.getCurrencyCd().equals("THB")){
                                            sdrTHB   = sdrRate.getSdrRate()==null?0d:sdrRate.getSdrRate().doubleValue();
                                 }else{
                                            sdrOther = sdrRate.getSdrRate()==null?0d:sdrRate.getSdrRate().doubleValue();
                                 }
                            }
                            sdrRateResult = sdrTHB/sdrOther ;//____3
                            ib_commitment_amt = sdrRateResult*ib_commitment_amt;
                        }else{

                        }
                        if(monthDiffCurrent==0){
                            monthDiffCurrent = 1 ;
                        }
                        ib_commitment_amt = (ib_commitment_amt/monthDiffExpire)*monthDiffCurrent;
                        
                        
                        double  sumTadig = THACA_callTadig + THACT_callTadig + THAMY_callTadig;
                        double  percen_THACA_callTadig=(THACA_callTadig/sumTadig)*100;
                        double  percen_THACT_callTadig=(THACT_callTadig/sumTadig)*100;
                        double  percen_THAMY_callTadig=(THAMY_callTadig/sumTadig)*100;
                        
                        
                        double  TAP_sumChargeLocal =THACA_chargeLocal + THACT_chargeLocal + THAMY_chargeLocal;
                        double  IOT_sumNet=THACA_net+ THACT_net + THAMY_net;
                        
                        double  CN=0;
                        double  DN=0;
                        
                        if(IOT_sumNet >ib_commitment_amt){
                        
                            if(TAP_sumChargeLocal>IOT_sumNet){
                            
                                CN = Math.abs(IOT_sumNet-TAP_sumChargeLocal);
                            
                            }else if(TAP_sumChargeLocal<IOT_sumNet){
                            
                                DN = IOT_sumNet - TAP_sumChargeLocal;
                                
                            }
                        }else if(IOT_sumNet <ib_commitment_amt){
                        
                            if(TAP_sumChargeLocal>ib_commitment_amt){
                            
                                CN = Math.abs(ib_commitment_amt-TAP_sumChargeLocal);
                                
                            }else if(TAP_sumChargeLocal<ib_commitment_amt){
                                
                                DN = ib_commitment_amt - TAP_sumChargeLocal;
                            
                            }
                        }
                        THACA_CN = (percen_THACA_callTadig*CN)/100;
                        THACT_CN = (percen_THACT_callTadig*CN)/100;
                        THAMY_CN = (percen_THAMY_callTadig*CN)/100;
                        
                        THACA_DN = (percen_THACA_callTadig*DN)/100;
                        THACT_DN = (percen_THACT_callTadig*DN)/100;
                        THAMY_DN = (percen_THAMY_callTadig*DN)/100;
                        
                       
                        IotAccrue  accrue = new IotAccrue();
                        
                        accrue.setDirection(direction);
                        accrue.setGroupTadig(prevMaster.getGroupTadig());
                        if(prevMaster.getGroupTadig().contains("Group")){
                            accrue.setCountryName(" ");
                            accrue.setOperatorName(" ");
                        }else{
                            accrue.setCountryName(prevMaster.getCountryName());
                            accrue.setOperatorName(prevMaster.getOperatorName());
                        }
                        accrue.setAgreementId(prevMaster.getAgreementId());
                        accrue.setPlmnGroupId(prevMaster.getPlmnGroupId());
                        accrue.setCommitment(BigDecimal.valueOf(ib_commitment_amt));
                        accrue.setReportMonth(reportMonthFormat.format(systemDate));
                        accrue.setParamDate(reportDateFormat.format(systemDate)+accrue.getReportMonth());
                        accrue.setSysCreationDate(new java.sql.Date(systemDate.getTime()));
                        accrue.setDlServiceCode("LOAD");
                        if(percen_THACA_callTadig>0){
                                accrue.setMyTadig("THACA");
                                accrue.setCallTadig(BigDecimal.valueOf(THACA_callTadig));
                                accrue.setSharingRate(BigDecimal.valueOf(percen_THACA_callTadig));
                                accrue.setChargeTap(BigDecimal.valueOf(THACA_chargeLocal));
                                accrue.setChargeIot(BigDecimal.valueOf(THACA_net));
                                accrue.setCn(BigDecimal.valueOf(THACA_CN));
                                accrue.setDn(BigDecimal.valueOf(THACA_DN));
                                System.out.println(currentTime()+"Add IOT_AGREEMENT : "+accrue.getAgreementId()+" "+accrue.getGroupTadig()+" "+accrue.getMyTadig()+" "+accrue.getCountryName());
                                new IotAccrueBaseDAO().insert(accrue);
                        }
                        if(percen_THACT_callTadig>0){
                                accrue.setMyTadig("THACT");
                                accrue.setCallTadig(BigDecimal.valueOf(THACT_callTadig));
                                accrue.setSharingRate(BigDecimal.valueOf(percen_THACT_callTadig));
                                accrue.setChargeTap(BigDecimal.valueOf(THACT_chargeLocal));
                                accrue.setChargeIot(BigDecimal.valueOf(THACT_net));
                                accrue.setCn(BigDecimal.valueOf(THACT_CN));
                                accrue.setDn(BigDecimal.valueOf(THACT_DN));
                                System.out.println(currentTime()+"Add IOT_AGREEMENT : "+accrue.getAgreementId()+" "+accrue.getGroupTadig()+" "+accrue.getMyTadig()+" "+accrue.getCountryName());
                                new IotAccrueBaseDAO().insert(accrue);
                        }
                        if(percen_THAMY_callTadig>0){
                                accrue.setMyTadig("THAMY");
                                accrue.setCallTadig(BigDecimal.valueOf(THAMY_callTadig));
                                accrue.setSharingRate(BigDecimal.valueOf(percen_THAMY_callTadig));
                                accrue.setChargeTap(BigDecimal.valueOf(THAMY_chargeLocal));
                                accrue.setChargeIot(BigDecimal.valueOf(THAMY_net));
                                accrue.setCn(BigDecimal.valueOf(THAMY_CN));
                                accrue.setDn(BigDecimal.valueOf(THAMY_DN));
                                System.out.println(currentTime()+"Add IOT_AGREEMENT : "+accrue.getAgreementId()+" "+accrue.getGroupTadig()+" "+accrue.getMyTadig()+" "+accrue.getCountryName());
                                new IotAccrueBaseDAO().insert(accrue);
                        }
                        
                        
                        //reset
                        THACA_callTadig=0;THACA_chargeLocal=0;THACA_net=0;
                        THACT_callTadig=0;THACT_chargeLocal=0;THACT_net=0;
                        THAMY_callTadig=0;THAMY_chargeLocal=0;THAMY_net=0;

                        THACA_CN=0;THACA_DN=0;
                        THACT_CN=0;THACT_DN=0;
                        THAMY_CN=0;THAMY_DN=0;
                        
                        
                        prevMaster = master;
                    }else{  
                        
                    }
                    if(master.getMyTadig().equals("THACA")){
                        
                            THACA_callTadig += master.getCallTadig()==null?0d:master.getCallTadig().doubleValue();
                            THACA_chargeLocal += master.getChargeLocal()==null?0d:master.getChargeLocal().doubleValue();
                            THACA_net += master.getNet()==null?0d:master.getNet().doubleValue();
                    }else if(master.getMyTadig().equals("THACT")){
                        
                            THACT_callTadig += master.getCallTadig()==null?0d:master.getCallTadig().doubleValue();
                            THACT_chargeLocal += master.getChargeLocal()==null?0d:master.getChargeLocal().doubleValue();
                            THACT_net += master.getNet()==null?0d:master.getNet().doubleValue();
                            
                    }else if(master.getMyTadig().equals("THAMY")){
                        
                            THAMY_callTadig += master.getCallTadig()==null?0d:master.getCallTadig().doubleValue();
                            THAMY_chargeLocal += master.getChargeLocal()==null?0d:master.getChargeLocal().doubleValue();
                            THAMY_net += master.getNet()==null?0d:master.getNet().doubleValue();
                    }
                }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        System.out.println(currentTime()+"Finish migrateData "+direction);
    }
 
    
}
