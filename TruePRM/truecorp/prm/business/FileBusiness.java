/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import truecorp.prm.dao.IcRateCodeBaseDAO;
import truecorp.prm.dao.IcRatingDictBaseDAO;
import truecorp.prm.dao.TiticPartnerRefBaseDAO;
import truecorp.prm.model.RateCodePack;
import truecorp.prm.model.RateSheet;
import truecorp.prm.model.TransactionPartner;
import truecorp.prm.resource.setEnv;
import truecorp.prm.table.TiticPartnerRef;

/**
 *
 * @author Jennarong Pinjai
 */
public class FileBusiness {
    
    public static List<TransactionPartner> readRateSheet() throws Exception{
    
        try{
            List<TransactionPartner>  partnerList = new ArrayList<TransactionPartner>();
            File autoSheetFolder = new File(setEnv.EXCEL_RATESHEET_file_INPUT);
            
            //////Mapping prmCd
            Map<String,String>    partnerCdMap  = new HashMap<String,String>(); /// <partnerCd,prmCd>
            TiticPartnerRefBaseDAO  titicDao = new TiticPartnerRefBaseDAO();
            
            for(TiticPartnerRef titic:(List<TiticPartnerRef>)titicDao.findAll()){
            
                partnerCdMap.put(titic.getPartnerCd().trim(), titic.getPrmCd().trim());
            
            }
            
            for(File ctrlFile : autoSheetFolder.listFiles()){
            
            
                    
                    if(ctrlFile.getName().contains(".csv.ctrl")){
                        TransactionPartner  partner = new TransactionPartner();
                        
                        System.out.println("Current file :"+ctrlFile.getName());
                        File csvFile = new File(setEnv.EXCEL_RATESHEET_file_INPUT+"/"+ctrlFile.getName().replace(".ctrl", ""));
                        System.out.println("Then read file :"+csvFile.getName());
                        
                        partner.setPartnerCd(csvFile.getName().substring(0,3).trim());
                        partner.setPrmCd(partnerCdMap.get(csvFile.getName().substring(0,3).trim()));
                        System.out.println("Partner code :"+partner.getPartnerCd());
                        System.out.println("PRM code :"+partner.getPrmCd());
                        String splitBy = ",";
                        String line;
                        BufferedReader br = new BufferedReader(new FileReader(csvFile));
                        int rowNum=0;
                        while((line = br.readLine()) != null&&line.length()>0){
                             rowNum++;
                             String[] b = line.split(splitBy);
                             if(rowNum==1)continue;
                             RateSheet  rateSheet = new RateSheet();
                             //for(String text:b){ System.out.print(text+"\t\t");}
                             rateSheet.setPrmPartnerCd(b[0]);
                             rateSheet.setPrefix(b[1]);
                             rateSheet.setDescription(b[2]);
                             rateSheet.setCost(b[3]);
                             rateSheet.setEffective(new SimpleDateFormat("dd-MM-yy",Locale.US).parse(b[4]));
                             rateSheet.setServiceType(b[5]);
                             rateSheet.setMinChrg(b[9]);
                             rateSheet.setRoundingUnit(b[10]);
                             rateSheet.setIsChange(b[10]);
                             partner.setServiceType(rateSheet.getServiceType());
                             partner.getRateSheetList().add(rateSheet);
                        }
                        System.out.println("Service type :"+partner.getServiceType());
                        br.close();
                        partnerList.add(partner);
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
                       
                    }
                
            }
            return partnerList;
                
        }catch(Exception ex){
        
            ex.printStackTrace();
            return null;
        }
    
    }
   
    public static List<RateCodePack> genRateCodePackList(TransactionPartner tranPartner) throws Exception{
        try{
            List<RateCodePack> rateCodePackList = new ArrayList<RateCodePack>();
            Set<Double>        rateCostSet      = new HashSet<Double>();
            Map<String,String> rateTypeMap      = new HashMap<String,String>();
            for(RateSheet rateSheet :tranPartner.getRateSheetList()){
                
                rateCostSet.add(Double.valueOf(rateSheet.getCost()));
                rateTypeMap.put(rateSheet.getCost().trim(), rateSheet.getServiceType());
                
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
                    codePack.setRateCd(rateTypeMap.get(codePack.getRate())+""+tranPartner.getPrmCd()+""+codePack.getCd());
                    codePack.setReteCdSeq(String.valueOf(rateCodeSeq));
                    codePack.setDescriptionSeq(String.valueOf(descriptionSeq));
                    codePack.setText(tranPartner.getServiceType()+" "+tranPartner.getPartnerCd()+" Termination Rate "+codePack.getCd());
                    
                    System.out.println("CD:"+codePack.getCd()+"\t\t"+codePack.getRate()+"\t\t"+codePack.getRateCd()+"\t\t"+codePack.getReteCdSeq()+"\t\t"+codePack.getDescriptionSeq());
                    
                    descriptionSeq++;
                    rateCodeSeq++;
            }
           
           
           return rateCodePackList;
        }catch(Exception ex){
        
            ex.printStackTrace();
            return null;
        
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
    
}
