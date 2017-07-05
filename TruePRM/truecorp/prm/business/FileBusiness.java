/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import truecorp.prm.dao.CustomerAccountDAO;
import truecorp.prm.dao.IcDestinationDictBaseDAO;
import truecorp.prm.dao.IcRateCodeBaseDAO;
import truecorp.prm.dao.IcRatingDictBaseDAO;
import truecorp.prm.dao.PaymentDAO;
import truecorp.prm.dao.ProdLookupDAO;
import truecorp.prm.dao.TiticPartnerRefBaseDAO;
import truecorp.prm.model.Country;
import truecorp.prm.model.Destination;
import truecorp.prm.model.PRMInterface;
import truecorp.prm.model.RateCodePack;
import truecorp.prm.model.RateSheet;
import truecorp.prm.model.TransactionPartner;
import truecorp.prm.resource.setEnv;
import truecorp.prm.table.IcDestinationDict;
import truecorp.prm.table.TiticPartnerRef;

/**
 *
 * @author Jennarong Pinjai
 */
public class FileBusiness {
    
    public static TransactionPartner readRateSheet(File csvFile,TransactionPartner  partner ) throws Exception{
        String lineError="";
        try{
            
            
            //////Mapping prmCd
            Map<String,String>    partnerCdMap  = new HashMap<String,String>(); /// <partnerCd,prmCd>
            TiticPartnerRefBaseDAO  titicDao = new TiticPartnerRefBaseDAO();
            List<String> addressList = new ArrayList<String>();
            
                        partner.setPartnerCd(csvFile.getName().substring(0,2).trim());
                        if(isNumber(String.valueOf(csvFile.getName().charAt(2)))){
                        
                            partner.setPartnerCd(csvFile.getName().substring(0,3).trim());
                        
                        }
                        partner.setFileName(csvFile.getName());
                        partner.setControlFileName(csvFile.getName()+".ctrl");
                        System.out.println("Then read file :"+csvFile.getName());
                        
                        System.out.println("Partner code :"+partner.getPartnerCd());
                        
                        String splitBy = ",";
                        String line;
                        BufferedReader br = new BufferedReader(new FileReader(csvFile));
                        int rowNum=0;
                        while((line = br.readLine()) != null){
                             rowNum++;
                            // System.out.println("Line num:"+rowNum);
                             String[] b = line.split(splitBy);
                             lineError = line;
                             if(rowNum==1||line.split(splitBy).length<2)continue;
                             RateSheet  rateSheet = new RateSheet();
                             //for(String text:b){ System.out.print(text+"\t\t");}
                             rateSheet.setPrmPartnerCd(b[0]);
                             rateSheet.setPrefix(b[1]);
                             rateSheet.setDescription(b[2].trim());
                             rateSheet.setCost(b[3]);
                             rateSheet.setEffective(new SimpleDateFormat("yyyy-MM-dd",Locale.US).parse(b[4]));
                             rateSheet.setServiceType(b[5]);
                             rateSheet.setMinChrg(b[9]);
                             rateSheet.setRoundingUnit(b[10]);
                             rateSheet.setIsChange(b[11]);
                             partner.setServiceType(rateSheet.getServiceType());
                             partner.getRateSheetList().add(rateSheet);
                             
                             if(addressList.contains(rateSheet.getPrefix())){
                                 throw new Exception("ADDRDUP");
                             
                             }else{
                                 addressList.add(rateSheet.getPrefix());
                             }
                             
                        }
                        List<TiticPartnerRef>  titicPartnerRefList = titicDao.findByProductCd(partner.getServiceType());
                        
                        if(titicPartnerRefList==null||titicPartnerRefList.isEmpty()){
                                titicPartnerRefList = titicDao.findByProductCd(String.format("%-4s", partner.getServiceType()));
                        }
                        
                        for(TiticPartnerRef titic:titicPartnerRefList){
            
                            partnerCdMap.put(titic.getPartnerCd().trim(), titic.getPrmCd().trim());
                        }      
                        partner.setPrmCd(partnerCdMap.get(partner.getPartnerCd()));
                        System.out.println("PRM code :"+partner.getPrmCd());
                        String ratePlanCode = "";
                        if(partner.getServiceType().equals("IDD")){
                       
                           ratePlanCode = "ID01-"+partner.getPartnerCd()+" ";
                           
                        }else if(partner.getServiceType().equals("ISDN")){
                       
                           ratePlanCode = "ID06-"+partner.getPartnerCd()+" ";
                        }
                        partner.setRatePlanCode(ratePlanCode);
                        System.out.println("Service type :"+partner.getServiceType());
                        br.close();
//                        for(RateSheet rate  : partner.getRateSheetList()){
//                            
//                            System.out.println(rate.getPrmPartnerCd()+
//                                          "\t"+rate.getPrefix()+
//                                    "\t"+rate.getDescription()+
//                                    "\t"+rate.getCost()+
//                                    "\t"+new SimpleDateFormat("dd/MM/yyyy",Locale.US).format(rate.getEffective())+
//                                    "\t"+rate.getServiceType()+
//                                    "\t"+rate.getMinChrg()+
//                                    "\t"+rate.getRoundingUnit()+
//                                    "\t"+rate.getIsChange());
//                            
//                        }
                       
                        Comparator<RateSheet> rateCompare = new Comparator<RateSheet>() {

                            @Override
                            public int compare(RateSheet o1, RateSheet o2) {
                                
                                return o1.getDescription().compareTo(o2.getDescription());
                            
                            }
                        };
                        Collections.sort(partner.getRateSheetList(),rateCompare);
                
            
            return partner;
                
        }catch(Exception ex){
            System.out.println("===================================LINE ERROR:"+lineError);
            throw ex;
        }
    
    }
        public static TransactionPartner readRateSheetChanged(File csvFile, TransactionPartner  partner ) throws Exception{
        String lineError="";
        try{
           
            
            //////Mapping prmCd
            Map<String,String>    partnerCdMap  = new HashMap<String,String>(); /// <partnerCd,prmCd>
            TiticPartnerRefBaseDAO  titicDao = new TiticPartnerRefBaseDAO();
            partner.setPartnerCd(csvFile.getName().substring(0,2).trim());
            if(isNumber(String.valueOf(csvFile.getName().charAt(2)))){
                        
                            partner.setPartnerCd(csvFile.getName().substring(0,3).trim());
                        
            }
            
                        partner.setFileName(csvFile.getName());
                        partner.setControlFileName(csvFile.getName()+".ctrl");
                        System.out.println("Then read file :"+csvFile.getName());
                        System.out.println("Partner code :"+partner.getPartnerCd());
                        
                        String splitBy = ",";
                        String line;
                        BufferedReader br = new BufferedReader(new FileReader(csvFile));
                        int rowNum=0;
                        while((line = br.readLine()) != null){
                             rowNum++;
                            // System.out.println("Line num:"+rowNum);
                             String[] b = line.split(splitBy);
                             lineError = line;
                             if(rowNum==1||line.split(splitBy).length<2||Integer.valueOf(b[11])==0)continue;
                             RateSheet  rateSheet = new RateSheet();
                             //for(String text:b){ System.out.print(text+"\t\t");}
                             rateSheet.setPrmPartnerCd(b[0]);
                             rateSheet.setPrefix(b[1]);
                             rateSheet.setDescription(b[2]);
                             rateSheet.setCost(b[3]);
                             rateSheet.setEffective(new SimpleDateFormat("yyyy-MM-dd",Locale.US).parse(b[4]));
                             rateSheet.setServiceType(b[5]);
                             rateSheet.setMinChrg(b[9]);
                             rateSheet.setRoundingUnit(b[10]);
                             rateSheet.setIsChange(b[11]);
                             partner.setServiceType(rateSheet.getServiceType());
                             partner.getRateSheetList().add(rateSheet);
                        }
                        if(partner.getRateSheetList().isEmpty()){
                                throw new Exception("NOCHANGE");
                        }
                        List<TiticPartnerRef>  titicPartnerRefList = titicDao.findByProductCd(partner.getServiceType());
                        
                        if(titicPartnerRefList==null||titicPartnerRefList.isEmpty()){
                                titicPartnerRefList = titicDao.findByProductCd(String.format("%-4s", partner.getServiceType()));
                        }
                        
                        for(TiticPartnerRef titic:titicPartnerRefList){
            
                            partnerCdMap.put(titic.getPartnerCd().trim(), titic.getPrmCd().trim());
                        }      
                        partner.setPrmCd(partnerCdMap.get(partner.getPartnerCd()));
                        System.out.println("PRM code :"+partner.getPrmCd());
                        
                        String ratePlanCode = "";
                        if(partner.getServiceType().equals("IDD")){
                       
                           ratePlanCode = "ID01-"+partner.getPartnerCd()+" ";
                           
                        }else if(partner.getServiceType().equals("ISDN")){
                       
                           ratePlanCode = "ID06-"+partner.getPartnerCd()+" ";
                        }
                        partner.setRatePlanCode(ratePlanCode);
                        System.out.println("Service type :"+partner.getServiceType());
                        br.close();
//                        for(RateSheet rate  : partner.getRateSheetList()){
//                            
//                            System.out.println(rate.getPrmPartnerCd()+
//                                          "\t"+rate.getPrefix()+
//                                    "\t"+rate.getDescription()+
//                                    "\t"+rate.getCost()+
//                                    "\t"+new SimpleDateFormat("dd/MM/yyyy",Locale.US).format(rate.getEffective())+
//                                    "\t"+rate.getServiceType()+
//                                    "\t"+rate.getMinChrg()+
//                                    "\t"+rate.getRoundingUnit()+
//                                    "\t"+rate.getIsChange());
//                            
//                        }
                       
                    
                
            
            return partner;
                
        }catch(Exception ex){
            System.out.println("===================================LINE ERROR:"+lineError);
            throw ex;
            
        }
    
    }
   
    public static List<RateCodePack> genRateCodePackList(TransactionPartner tranPartner) throws Exception{
        try{
            List<RateCodePack> rateCodePackList = new ArrayList<RateCodePack>();
            Set<Double>        rateCostSet      = new HashSet<Double>();
            Map<Double,String> rateTypeMap      = new HashMap<Double,String>();
            for(RateSheet rateSheet :tranPartner.getRateSheetList()){
                
                rateCostSet.add(Double.valueOf(rateSheet.getCost()));
                rateTypeMap.put(Double.valueOf(rateSheet.getCost()), rateSheet.getServiceType());
                
            }
            System.out.println("------Rate cost sorted------");
            //Add rate set
            DecimalFormat df = new DecimalFormat("#.##");
            df.setMaximumFractionDigits(10);
           for(Double rateCost : rateCostSet){
               RateCodePack  codePack = new RateCodePack();
               codePack.setRate(df.format(rateCost));
               rateCodePackList.add(codePack);
           }
           //Sort rate
           Comparator<RateCodePack>   rateComp = new Comparator<RateCodePack>() {
                @Override
                public int compare(RateCodePack o1, RateCodePack o2) {
                    
                    return  Double.valueOf(o1.getRate()).compareTo(Double.valueOf(o2.getRate()));
                
                }
            };
            
            Collections.sort(rateCodePackList, rateComp);
            
            int rowNum=0;
            int rateCodeSeq=new IcRateCodeBaseDAO().getMaxRateCdSeq()+1;
            int descriptionSeq=new IcRatingDictBaseDAO().getMaxDescriptionSeq()+1;
            for(RateCodePack codePack : rateCodePackList){
                    rowNum++;
                    codePack.setCd(genRateCd(rowNum));
                    codePack.setRateCd(rateTypeMap.get(Double.valueOf(codePack.getRate()))+""+tranPartner.getPrmCd()+""+codePack.getCd());
                    codePack.setRateCdSeq(String.valueOf(rateCodeSeq));
                    codePack.setDescriptionSeq(String.valueOf(descriptionSeq));
                    codePack.setText(tranPartner.getServiceType()+" "+tranPartner.getPartnerCd()+" Termination Rate "+codePack.getCd());
                    
                    //System.out.println("CD:"+codePack.getCd()+"\t\t"+codePack.getRate()+"\t\t"+codePack.getRateCd()+"\t\t"+codePack.getReteCdSeq()+"\t\t"+codePack.getDescriptionSeq());
                    
                    descriptionSeq++;
                    rateCodeSeq++;
            }
           
           
           return rateCodePackList;
        }catch(Exception ex){
        
            ex.printStackTrace();
            return null;
        
        }
    
       
    }
    public static List<Country> genCountryCdList(TransactionPartner tranPartner) throws Exception{
        
        try{
               List<Country>  countryCdList = new ArrayList<Country>();
               Set<String>    countryNameSet = new HashSet<String>();
               
               for(RateSheet rateSheet : tranPartner.getRateSheetList()){
                   countryNameSet.add(rateSheet.getDescription());
                   
               }
               for(String countryName:countryNameSet){
                   Country country = new Country();
                   country.setName(countryName);
                   countryCdList.add(country);
               
               }
               Comparator<Country>  countryComparetor = new Comparator<Country>() {

                   @Override
                   public int compare(Country o1, Country o2) {
                       
                       return o1.getName().compareTo(o2.getName());
                   
                   }
               };
               Collections.sort(countryCdList,countryComparetor);
               System.out.println("-----Country name set sorted-----");
               
               int loopNum=1;
               int codeNum=1;
               int charNum=64;
               for(Country coun : countryCdList){
               
                     String countryCd="";
                     
                     if(loopNum<=999){
                            countryCd = String.format("%03d", codeNum);
                     }else{
                           if(codeNum>99){
                               codeNum=1;
                               charNum++;
                           }
                           countryCd = String.format("%c%02d", charNum,codeNum);
                     }
                     coun.setCd(countryCd);
                     //System.out.println(coun.getCd()+"    "+coun.getName());
                     codeNum++;
                     loopNum++;
               
               }
               return countryCdList;
        }catch(Exception ex){
        
            ex.printStackTrace();
            return null;
        }
    }
    public static boolean generateDestinationCode(TransactionPartner tranPartner ,Map<String,Country> countryCdMapper ,Map<Double,RateCodePack> rateCdMapper)throws Exception{
        
        try{
            System.out.println("-----Start Generate Destination code-----");
            int nextSequenceNo = new IcDestinationDictBaseDAO().getMaxSequenceNo()+1;
            String destinationCdPreviuos="";
            for(RateSheet rateSheet:tranPartner.getRateSheetList()){
                   
                    
                  String countryCode =countryCdMapper.get(rateSheet.getDescription().trim()).getCd();
                  String rateCode =rateCdMapper.get(Double.valueOf(rateSheet.getCost())).getCd();
                
                   String destinationCd = tranPartner.getPrmCd()+countryCode+rateCode;
                   rateSheet.setDestinationCd(destinationCd);
                   
                   if(!destinationCdPreviuos.equals(destinationCd)){
                       Destination dest = new Destination();
                       dest.setCode(destinationCd);
                       dest.setEffectiveDate(rateSheet.getEffective());
                       dest.setSequenceNo(nextSequenceNo);
                       dest.setCountry(countryCdMapper.get(rateSheet.getDescription().trim()));
                       dest.setRateCodePack(rateCdMapper.get(Double.valueOf(rateSheet.getCost())));
                       dest.setMinCharge(rateSheet.getMinChrg());
                       dest.setRoundingUnit(rateSheet.getRoundingUnit());
                       String ratePlanCode = "";
                       if(tranPartner.getServiceType().equals("IDD")){
                       
                           ratePlanCode = "ID01-"+tranPartner.getPartnerCd()+" ";
                           
                       }else if(tranPartner.getServiceType().equals("ISDN")){
                       
                           ratePlanCode = "ID06-"+tranPartner.getPartnerCd()+" ";
                       }
                       dest.setRatePlanCode(ratePlanCode);
                       
                       destinationCdPreviuos = destinationCd;
                       tranPartner.getDestinationList().add(dest);
                       nextSequenceNo++;
                         System.out.println(rateSheet.getDestinationCd()+"\t"+rateSheet.getCost()+"\t"+rateSheet.getPrefix()+"\t\t"+rateSheet.getDescription()+"");
               
                   }
                  
                     
                
            }
            
            
            System.out.println("-----Success Generate Destination code-----");
            return true;
        }catch(Exception ex){
        
            ex.printStackTrace();
            return false;
            
        }
        
        
    }
    public static void readPRMInterfaceFile(File file,List<PRMInterface>  prmInterfaceList) throws Exception{
            try{
                 BufferedReader br = new BufferedReader(new FileReader(file));
                 int rowNum=0;
                 String line;
                 SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMdd",Locale.US);
                 while((line = br.readLine()) != null&&!line.trim().isEmpty()){
                 
                        String[] array = line.split("\\|");
                        PRMInterface  prmInterface = new PRMInterface();
                        prmInterface.setAccountId(array[0]);
                        prmInterface.setProductType(array[1]);
                        prmInterface.setProductId(array[2]);
                        prmInterface.setPymSeqNo(array[3]);
                        prmInterface.setFeatureCode(array[4]);
                        prmInterface.setRevenueCode(array[5]);
                        prmInterface.setActvDate(dateForm.parse(array[6]));
                        prmInterface.setActvCode(array[7]);
                        prmInterface.setActvAmt(array[8]);
                        prmInterface.setTaxAmt(array[9]);
                        prmInterface.setPhaseCode(array[10]);
                        prmInterfaceList.add(prmInterface);
                 }
                br.close();
            }catch(Exception ex){
                throw ex;
            }
    
        
        
        
    }
    
    public static SimpleDateFormat prmActvDateFileFormat = new SimpleDateFormat("yyyyMMdd",Locale.US);
    public static ProdLookupDAO prodLookupDao = new ProdLookupDAO();
    public static CustomerAccountDAO cusDao = new CustomerAccountDAO();
    public static PaymentDAO payDao = new PaymentDAO();
    public static boolean convertPRMInterfaceToIEFile(PRMInterface prmInterface,Writer writerOutputFile){
           
        try{
            
            //String payType = getPRMInterfaceTypeDesc(prmInterface.getActvCode());
          
            //String resultParam1 =prodLookupDao.getResultParam1(prmInterface.getProductId());
            String resultParam1 =prmInterface.getPhaseCode();
            String pymMtd = cusDao.getPymMtd(prmInterface.getAccountId());
            String bankCode= cusDao.getBankCode(prmInterface.getAccountId());
            String pymSubMtd = cusDao.getPymSubMtd(prmInterface.getAccountId());
            String drPymSrcCd = getSrcCd(payDao.getSourceId(prmInterface.getAccountId(), prmInterface.getPymSeqNo()));
            String taxCode = cusDao.getTaxCode(prmInterface.getAccountId());
            String partnerCd="     ";
            String amt      = formatAmt(prmInterface);
            String paymentDate = payDao.getPaymentDate(prmInterface.getAccountId(), prmInterface.getPymSeqNo());
            String billMonth = payDao.getBillMonth(prmInterface.getAccountId(), prmInterface.getPymSeqNo());
            String outletCode=payDao.getOutletCode(prmInterface.getAccountId(), prmInterface.getPymSeqNo());
            String dcpNo = payDao.getDCPNo(prmInterface.getAccountId(), prmInterface.getPymSeqNo());
            String pymChrgInd = "Y";
            String accFullType = cusDao.getAccountFullType(prmInterface.getAccountId());
            String recSeqNo =String.format("%-4s",prmInterface.getActvCode())+String.format("%-12s",prmInterface.getPymSeqNo()+"00");
            String callDuration="0000000000000";
            String firstField =prmActvDateFileFormat.format(prmInterface.getActvDate()) + String.format("%-12s", prmInterface.getAccountId() ) + String.format("%-16s", prmInterface.getProductId()) +
                               String.format("%-3s",prmInterface.getProductType())+String.format("%-1s",resultParam1)+String.format("%-6s",prmInterface.getFeatureCode())+
                               String.format("%-3s",prmInterface.getRevenueCode())+String.format("%-2s",pymMtd)+String.format("%-10s",bankCode)+String.format("%-2s",pymSubMtd)+
                               String.format("%-1s",drPymSrcCd)+String.format("%-1s",taxCode)+partnerCd+String.format("%-6s",prmInterface.getFeatureCode())+
                               String.format("%-3s",prmInterface.getRevenueCode())+String.format("%-2s",pymMtd)+String.format("%-10s",bankCode)+String.format("%-2s",pymSubMtd)+
                               String.format("%-1s",drPymSrcCd)+String.format("%-1s",taxCode)+partnerCd+String.format("%-4s",prmInterface.getActvCode())+
                               amt+String.format("%-8s",paymentDate)+String.format("%-8s",paymentDate)+String.format("%-6s", billMonth)+
                               String.format("%-4s", outletCode)+String.format("%-7s", dcpNo)+pymChrgInd+String.format("%-3s", accFullType)+
                               recSeqNo+callDuration+"";
            
            
            String vatAmtPos =String.format("%011d", Integer.valueOf(prmInterface.getTaxAmt().replace(".", "")));
            String glCode =payDao.getGLCode(prmInterface.getAccountId(), prmInterface.getPymSeqNo());
            String receiptNumPos = payDao.getReceiptNumPos(prmInterface.getAccountId(), prmInterface.getPymSeqNo());
            String batchNo =payDao.getBatchNo(prmInterface.getAccountId(), prmInterface.getPymSeqNo());
            String batchType=payDao.getBatchType(prmInterface.getAccountId(), prmInterface.getPymSeqNo());
            String zonePos=payDao.getZone(prmInterface.getAccountId(), prmInterface.getPymSeqNo());
            String IE20Form =firstField+"01;   ;          ; ;  ;      ;      ;      ;      ;         ;"
                                      + "      ;          ;  ;          ;      ; ;          ; ;  ;      ;      ;"
                    + "      ;      ;         ;      ;          ;  ;          ;      ; ; ; ;        ;   ;"
                    + "            ;               ;  ;           ;           ;     ; ;   ;        ;            ;"
                    + "                ;   ; ;          ; ;  ;      ;      ;      ;      ;      ;   ;         ;      ;  ;"
                    + "          ;          ;  ;  ; ;          ; ;      ; ;     ;          ; ;  ;      ;      ;      ;      ;"
                    + "      ;   ;         ;      ;  ;          ;          ;  ;  ; ;          ; ;      ; ;     ;    ;         ;   ;"
                    + "              ;              ;         ;      ;     ;    ;"+String.format("%-11s", vatAmtPos)+"; ; ;        ;   ;"
                    + "            ;               ;  ;           ;           ;     ;             ;"+String.format("%-10s", glCode)+String.format("%-7s", receiptNumPos)+String.format("%-5s", batchNo)+String.format("%-1s", batchType)+
                    String.format("%-1s", zonePos)+";"
                    + "                                                                                                          "
                    + "                                                                                                           "
                    + "                                                                                                            "
                    + "                         ;";
            
            writerOutputFile.write(IE20Form);
             return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        
    }
    public static String getSrcCd(String sourceId){
            String srcCd="";
            try{
                if(sourceId.equals("POSO")){
                    srcCd="O";
                }else{
                    srcCd="B";
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return srcCd;
    }
    public static String getPRMInterfaceTypeDesc(String ActcCode){
            String payType="";
            if(ActcCode.trim().equals("PYM")){
                   payType ="payment";
            }else if(ActcCode.trim().equals("BCK")){
                    payType ="backout";
            }else if(!ActcCode.trim().equals("null")&&!ActcCode.trim().equals("NULL")){
                    payType =ActcCode;
            }
            return payType;
    }
    public static String formatAmt(PRMInterface prm){
            String amtFormat="";
            try{
                if(prm.getActvCode().trim().equals("PYM")){
                       amtFormat="+"+String.format("%010d", Integer.valueOf(prm.getActvAmt().replace(".", "")));
                }else if(prm.getActvCode().trim().equals("BCK")){
                     amtFormat="-"+String.format("%010d", Integer.valueOf(prm.getActvAmt().replace(".", "")));
                }else{
                    amtFormat=" "+String.format("%010d", Integer.valueOf(prm.getActvAmt().replace(".", "")));
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return amtFormat;
    }
    public static  boolean moveFinshedFiile(String fileName){
        try{
        
           moveFile(setEnv.EXCEL_RATESHEET_file_INPUT+"/"+fileName,setEnv.EXCEL_RATESHEET_OUTPUT);
            
            
           return true;
        }catch(Exception ex){
        
            ex.printStackTrace();
            return false;
        
        }
        
    }
    
    public static String genRateCd(int genNumLoop){
    
              int charLoop=65;
              int genNumTail=0;
              
              genNumTail = genNumLoop%1000;
              
              if(genNumLoop>999){
                  
                  genNumTail = genNumLoop%100;
                  charLoop+=(genNumLoop/100)-10;
              }
              
              
              String  numgen ;
              if(genNumLoop<=999){
                 
                  numgen = String.format("%03d",genNumTail);
                 
              }else{
                  
                  numgen = String.format("%c%02d",charLoop,genNumTail);
               
             }
    
    
        return numgen;
    }
    public static int moveFile(String filePath,String folderPath){
    
        try{
                File destinationFolder = new File(folderPath);
                File file = new File(filePath);

                if (!destinationFolder.exists())
                {
                    destinationFolder.mkdirs();
                }
                // Check weather source exists and it is folder.
                if (file.exists())
                {
                    if (file != null)
                    {
                       
                            // Move files to destination folder
                            file.renameTo(new File(destinationFolder + "/" + file.getName()));
                        
                        // Add if you want to delete the source folder 
                        file.delete();
                    }
                }
                else
                {
                    System.out.println(file + "  Folder does not exists");
                }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    public static boolean isNumber(String text){
    
        try{
            
            Double test = Double.valueOf(text);
        
            return true;
        }catch(Exception ex){
        
            return false;
            
        }
        
        
    }
}
