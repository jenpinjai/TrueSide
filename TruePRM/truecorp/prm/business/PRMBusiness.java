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
import java.util.List;
import java.util.Locale;
import truecorp.prm.dao.IcRateCodeBaseDAO;
import truecorp.prm.dao.IcRateCodeRatesBaseDAO;
import truecorp.prm.dao.IcRatingDictBaseDAO;
import truecorp.prm.dao.IcSubjectVersionsBaseDAO;
import truecorp.prm.model.RateCodePack;
import truecorp.prm.model.TransactionPartner;
import truecorp.prm.table.IcRateCode;
import truecorp.prm.table.IcRateCodeRates;
import truecorp.prm.table.IcRatingDict;
import truecorp.prm.table.IcSubjectVersions;

/**
 *
 * @author Jennarong Pinjai
 */
public class PRMBusiness {
    
    
        public static void processEarlyMonth(List<TransactionPartner>  transactionPartnerList) throws Exception {
        
                    
                for(TransactionPartner tranPartner:transactionPartnerList){
                
                        List<RateCodePack>  rateCodePackList = FileBusiness.genRateCodePackList(tranPartner);
                        
                        //Clear old rate data
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
                }
            
        }
        public static void processHalfMonth(List<TransactionPartner>  transactionPartnerList){
        
        
                for(TransactionPartner tranParter:transactionPartnerList){
                
                
                }
        
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
          
    
}
