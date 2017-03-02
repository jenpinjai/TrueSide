/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.business;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import truecorp.prm.dao.IcDestinationDictBaseDAO;
import truecorp.prm.dao.IcRateCodeBaseDAO;
import truecorp.prm.dao.IcRateCodeRatesBaseDAO;
import truecorp.prm.dao.IcRatingDictBaseDAO;
import truecorp.prm.dao.IcSubjectVersionsBaseDAO;
import truecorp.prm.dao.IcgDestinationAddresBaseDAO;
import truecorp.prm.dao.IcgDestinationBaseDAO;
import truecorp.prm.model.Country;
import truecorp.prm.model.Destination;
import truecorp.prm.model.RateCodePack;
import truecorp.prm.model.RateSheet;
import truecorp.prm.model.TransactionPartner;
import truecorp.prm.table.IcDestinationDict;
import truecorp.prm.table.IcRateCode;
import truecorp.prm.table.IcRateCodeRates;
import truecorp.prm.table.IcRatingDict;
import truecorp.prm.table.IcSubjectVersions;
import truecorp.prm.table.IcgDestination;
import truecorp.prm.table.IcgDestinationAddres;

/**
 *
 * @author Jennarong Pinjai
 */
public class PRMBusiness {
    
    
        public static void processEarlyMonth(TransactionPartner  tranPartner) throws Exception {
        
                    List<RateCodePack>  rateCodePackList = FileBusiness.genRateCodePackList(tranPartner);
                    Map<String,RateCodePack>  rateCodeMapper   = new HashMap<String,RateCodePack>();
                    ////Set rateCode Mapper
                    for(RateCodePack rateCode : rateCodePackList){rateCodeMapper.put(rateCode.getRate().trim(),rateCode);}
                          
                  
                  //// Clear IcRateCode
                  new  IcRateCodeBaseDAO().deleteAllBy(tranPartner.getServiceType(), tranPartner.getPrmCd());
                  System.out.println("Clear IC_RATE_CODE  -->  Pass");
                  //// Add new IcRateCode
                  addIcRateCode(rateCodePackList);
                
                  //// Clear IcRateCodeRates
                  new IcRateCodeRatesBaseDAO().deleteAllBy(tranPartner.getServiceType(), tranPartner.getPrmCd());
                  System.out.println("Clear IC_RATE_CODE_RATE  -->  Pass");
                        
                  //// Add new IcRateCodeRates
                  addIcRateCodeRates(rateCodePackList, tranPartner);
                        
                        
                  ////Clear IcRatingDict
                  new IcRatingDictBaseDAO().deleteAllBy(tranPartner.getServiceType(), tranPartner.getPartnerCd());
                  System.out.println("Clear IC_RATING_DICT  -->  Pass");
                        
                  ////Add new IcRatingDict
                  addIcRatingDict(rateCodePackList);
                        
                  ////Clear IcSubjectVersion
                  new IcSubjectVersionsBaseDAO().deleteAllBy(tranPartner.getServiceType(), tranPartner.getPrmCd());
                  System.out.println("Clear IC_SUBJECT_VERSIONS  -->  Pass");
                        
                  ////Add new IcSubjectVersions
                  addIcSubjectVersions(rateCodePackList);
                        
                  ////Set Country code Mapper
                  List<Country>  countrySortedList =  FileBusiness.genCountryCdList(tranPartner);
                  Map<String,Country>  coountryMapper = new HashMap<String, Country>(); // CountryName , Country Code
                  for(Country coun : countrySortedList){coountryMapper.put(coun.getName().trim(), coun);}
                          
                  ////Generate Destination Code  to TransactionPartner's RateSheetList 
                  FileBusiness.generateDestinationCode(tranPartner, coountryMapper, rateCodeMapper);
                          
                    
                  ////Clear ICG Destination
                  new IcgDestinationBaseDAO().deleteAllBy(tranPartner.getPrmCd());
                  System.out.println("Clear ICG_Destination  -->  Pass");
                    
                  ////Add new ICG_Destination
                  addIcgDestination(tranPartner);
                  
                  
                  ////Clear Icg Destination Addres
                  new IcgDestinationAddresBaseDAO().deleteAllBy(tranPartner.getPrmCd());
                  System.out.println("Clear ICG_Destination_Addres  -->  Pass");
                  
                  ////Add new Icg Destination Addres
                  addIcgDestinationAddres(tranPartner);
                   
                  
                    ////Clear Ic Destination Dict
                   new IcDestinationDictBaseDAO().deleteAllBy(tranPartner.getPrmCd());
                   System.out.println("Clear IC_Destination_Dict  -->  Pass");
                   
                   ////Add new IcDestinaionDict
                   addIcDestinationDict(tranPartner);
                   
                   
                   ////Clear Ic Subject version by Destination
                   new IcSubjectVersionsBaseDAO().deleteAllDestinationBy(tranPartner.getPrmCd());
                   System.out.println("Clear IC_Subject_versions of Destination  -->  Pass");
                  
                   ////Add new Ic Subjct versions
                   addIcSubjectVersions(tranPartner);
                   
        }
        public static void processHalfMonth(TransactionPartner  tranPartner){
        
        
               
        
        }
        
        public static void addIcRateCode(List<RateCodePack>  rateCodePackList) throws Exception{
            System.out.println("Start addIcRateCode");
            IcRateCodeBaseDAO   dao  = new  IcRateCodeBaseDAO();
            for(RateCodePack ratePack:rateCodePackList){
            
                IcRateCode  icRateCode = new IcRateCode();
                icRateCode.setRateCdSeq(BigDecimal.valueOf(Long.valueOf(ratePack.getReteCdSeq())));
                long effectiveTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("01-01-2002").getTime();
                icRateCode.setEffectiveDate(new Date(effectiveTime));
                icRateCode.setSysCreationDate(new Date(new java.util.Date().getTime()));
                icRateCode.setOperatorId(BigDecimal.valueOf(41l));
                icRateCode.setDlServiceCode("BASE");
                icRateCode.setRateCd(ratePack.getRateCd());
                icRateCode.setDescriptionSeq(BigDecimal.valueOf(Long.valueOf(ratePack.getDescriptionSeq())));
                long expirationTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("31-12-3000").getTime();
                icRateCode.setExpirationDate(new Date(expirationTime));
                
                dao.insert(icRateCode);
            }
            
            System.out.println("Success addIcRateCode");
        }
        public static void addIcRateCodeRates(List<RateCodePack>  rateCodePackList,TransactionPartner tranPartner) throws Exception{
             System.out.println("Start addIcRateCodeRates");
             
              IcRateCodeRatesBaseDAO dao = new IcRateCodeRatesBaseDAO();
              for(RateCodePack ratePack:rateCodePackList){
                    IcRateCodeRates rcr = new IcRateCodeRates();
                    
                    rcr.setRateClassSetCd(tranPartner.getServiceType().substring(0,2)+tranPartner.getPrmCd());
                    rcr.setRateCdSeq(BigDecimal.valueOf(Long.valueOf(ratePack.getReteCdSeq())));
                    long effectiveTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("01-01-2002").getTime();
                    rcr.setEffectiveDate(new Date(effectiveTime));
                    rcr.setSysCreationDate(new Date(new java.util.Date().getTime()));
                    rcr.setOperatorId(BigDecimal.valueOf(41l));
                    rcr.setDlServiceCode("BASE");
                    rcr.setRatingUnit(BigDecimal.valueOf(60l));
                    rcr.setRate(BigDecimal.valueOf(Double.valueOf(ratePack.getRate())));
                    rcr.setUom("SS");
                    long expirationTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("31-12-3000").getTime();
                    rcr.setExpirationDate(new Date(expirationTime));
                    
                    dao.insert(rcr);
              
              }
             System.out.println("Success addIcRateCodeRates");
        }
        
        public static void addIcRatingDict(List<RateCodePack>  rateCodePackList) throws Exception {
            System.out.println("Start addIcRatingDict");
            IcRatingDictBaseDAO  dao = new IcRatingDictBaseDAO();
            for(RateCodePack ratePack:rateCodePackList){
                    IcRatingDict dict= new IcRatingDict();
                    
                    dict.setSequenceNo(BigDecimal.valueOf(Long.valueOf(ratePack.getDescriptionSeq())));
                    dict.setLanguageCode("E");
                    dict.setSysCreationDate(new Date(new java.util.Date().getTime()));
                    dict.setOperatorId(BigDecimal.valueOf(41l));
                    dict.setDlServiceCode("BASE");
                    dict.setText(ratePack.getText());
            
                    dao.insert(dict);
            }
            
            System.out.println("Success addIcRatingDict");
        }
        
        public static void addIcSubjectVersions(List<RateCodePack>  rateCodePackList) throws Exception{
            System.out.println("Start addIcSubjectVersions");
            IcSubjectVersionsBaseDAO dao = new IcSubjectVersionsBaseDAO();
            for(RateCodePack ratePack:rateCodePackList){
                IcSubjectVersions sub = new IcSubjectVersions();
                
                sub.setSubject("global rate");
                sub.setCode(ratePack.getRateCd());
                long effectiveTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("01-01-2002").getTime();
                sub.setEffectiveDate(new Date(effectiveTime));
                sub.setSysCreationDate(new Date(new java.util.Date().getTime()));
                sub.setOperatorId(BigDecimal.valueOf(41l));
                sub.setDlServiceCode("BASE");
                long expirationTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("31-12-3000").getTime();
                sub.setExpirationDate(new Date(expirationTime));
                
                dao.insert(sub);
            }
            System.out.println("Success addIcSubjectVersions");
        }
        
        public static void addIcgDestination(TransactionPartner  tranPartner) throws Exception{
            System.out.println("Start addIcgDestination");
            
            IcgDestinationBaseDAO dao = new IcgDestinationBaseDAO();
            for(Destination dest:tranPartner.getDestinationList()){
            
                IcgDestination   icDest = new IcgDestination();
                
                icDest.setDestinationCd(dest.getCode());
                icDest.setEffectiveDate(new Date(dest.getEffectiveDate().getTime()));
                icDest.setSysCreationDate(new Date(new java.util.Date().getTime()));
                icDest.setDlServiceCode("BASE");
                icDest.setDlUpdateStamp(BigDecimal.ZERO);
                icDest.setBillingNameSeq(BigDecimal.valueOf(dest.getSequenceNo()));
                icDest.setJurisdiction("I");
                icDest.setGuiDspInd("Y");
                long expirationTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("31-12-3000").getTime();
                icDest.setExpirationDate(new Date(expirationTime));
                //System.out.println(dest.getCode()+"\t"+dest.getSequenceNo()+"\t"+dest.getCountry().getName());
                
                dao.insert(icDest);
            }
            System.out.println("Success addIcgDestination");
        
        }
        public static void addIcgDestinationAddres(TransactionPartner  tranPartner) throws Exception{
            System.out.println("Start addIcgDestinationAddres");
            IcgDestinationAddresBaseDAO dao = new IcgDestinationAddresBaseDAO();
            for(RateSheet rateSheet : tranPartner.getRateSheetList()){
            
                    IcgDestinationAddres destAdd = new IcgDestinationAddres();
                    
                    destAdd.setDestinationCd(rateSheet.getDestinationCd());
                    destAdd.setAddress(rateSheet.getPrefix());
                    destAdd.setEffectiveDate(new Date(rateSheet.getEffective().getTime()));
                    destAdd.setSysCreationDate(new Date(new java.util.Date().getTime()));
                    destAdd.setOperatorId(BigDecimal.valueOf(41l));
                    destAdd.setDlServiceCode("BASE");
                    destAdd.setDlUpdateStamp(BigDecimal.ZERO);
                    long expirationTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("31-12-3000").getTime();
                    destAdd.setExpirationDate(new Date(expirationTime));
                
                    dao.insert(destAdd);
            
            }
            
            System.out.println("Success addIcgDestinationAddres");
        }
        public static void addIcDestinationDict(TransactionPartner  tranPartner) throws Exception{
            System.out.println("Start addIcDestinationDict");
            IcDestinationDictBaseDAO dao = new IcDestinationDictBaseDAO();
            for(Destination dest : tranPartner.getDestinationList()){
            
                IcDestinationDict   destDict = new IcDestinationDict();
                
                
                destDict.setSequenceNo(BigDecimal.valueOf(dest.getSequenceNo()));
                destDict.setLanguageCode("E");
                destDict.setSysCreationDate(new Date(new java.util.Date().getTime()));
                destDict.setOperatorId(BigDecimal.valueOf(41l));
                destDict.setDlServiceCode("BASE");
                destDict.setDlUpdateStamp(BigDecimal.ZERO);
                String destDictText = tranPartner.getPrmCd()+" "+"T"+dest.getCode().substring(5)+" "+dest.getCountry().getName();
                destDict.setText(destDictText);
                
                //System.out.println(dest.getSequenceNo()+" "+destDictText);
                dao.insert(destDict);
            }
            System.out.println("Success addIcDestinationDict");
        }
        public static void addIcSubjectVersions(TransactionPartner  tranPartner) throws Exception {
            System.out.println("Start addIcSubjectVersions of Destination");
            
            IcSubjectVersionsBaseDAO dao = new IcSubjectVersionsBaseDAO();
            for(Destination dest : tranPartner.getDestinationList()){
                IcSubjectVersions sub = new IcSubjectVersions();
            
                sub.setSubject("destination");
                sub.setCode(dest.getCode());
                sub.setEffectiveDate(new Date(dest.getEffectiveDate().getTime()));
                sub.setSysCreationDate(new Date(new java.util.Date().getTime()));
                sub.setOperatorId(BigDecimal.valueOf(41l));
                sub.setDlServiceCode("BASE");
                long expirationTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("31-12-3000").getTime();
                sub.setExpirationDate(new Date(expirationTime));
                
                dao.insert(sub);
            }
            
            
            System.out.println("Success addIcSubjectVersions of Destination");
        }
          
    
}
