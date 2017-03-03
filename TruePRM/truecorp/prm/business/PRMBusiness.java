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
import truecorp.prm.dao.IcRatedDestinationBaseDAO;
import truecorp.prm.dao.IcRatesAddlInfoBaseDAO;
import truecorp.prm.dao.IcRatesBaseDAO;
import truecorp.prm.dao.IcRatesSlabsBaseDAO;
import truecorp.prm.dao.IcRatingDictBaseDAO;
import truecorp.prm.dao.IcSubjectVersionsBaseDAO;
import truecorp.prm.dao.IcgDestinationAddresBaseDAO;
import truecorp.prm.dao.IcgDestinationBaseDAO;
import truecorp.prm.model.Address;
import truecorp.prm.model.Country;
import truecorp.prm.model.Destination;
import truecorp.prm.model.RateCodePack;
import truecorp.prm.model.RateSheet;
import truecorp.prm.model.TransactionPartner;
import truecorp.prm.table.IcDestinationDict;
import truecorp.prm.table.IcRateCode;
import truecorp.prm.table.IcRateCodeRates;
import truecorp.prm.table.IcRatedDestination;
import truecorp.prm.table.IcRates;
import truecorp.prm.table.IcRatesAddlInfo;
import truecorp.prm.table.IcRatesSlabs;
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
                  
                  
                    ////Clear IC Rate Destination
                    new IcRatedDestinationBaseDAO().deleteAllBy(tranPartner.getPrmCd(), tranPartner.getRatePlanCode());
                    System.out.println("Clear IC_Rated_Destination -->  Pass");
                    
                    ////Add new IcRatedDestination
                    addIcRatedDestination(tranPartner);
                   
                    ////Clear IC Rates
                    new IcRatesBaseDAO().deleteAllBy(tranPartner.getPrmCd(), tranPartner.getRatePlanCode());
                    System.out.println("Clear IC_Rates -->  Pass");
                    
                    ////Add new IcRates
                    addIcRates(tranPartner);
                    
                    ////Clear Ic Rates Addl Info
                    new IcRatesAddlInfoBaseDAO().deleteAllBy(tranPartner.getPrmCd(), tranPartner.getRatePlanCode());
                    System.out.println("Clear Ic Rates Addl Info -->  Pass");
                    
                    
                    ////Add new Ic Rated Addl Info
                    addIcRatesAddlInfo(tranPartner);
                    
                    
                    ////Clear Ic Rate Slabs
                    new IcRatesSlabsBaseDAO().deleteAllBy(tranPartner.getPrmCd(), tranPartner.getRatePlanCode());
                    System.out.println("Clear Ic Rates Slabs -->  Pass");
                    
                    ////Add new Ic Rates Slabs
                    addIcRatesSlabs(tranPartner);
                    
                    
        }
        public static void processHalfMonth(TransactionPartner  tranPartner) throws Exception{
            
                List<String> addrList = new IcgDestinationAddresBaseDAO().getAddrStringByPrmCd(tranPartner.getPrmCd());/// List of address(Prefix) on PrmCd for check contain
                List<String> countryList = new IcDestinationDictBaseDAO().getStringCountry(tranPartner.getPrmCd());/// List of Country(Description) on PrmCd for check contain
                List<Double> costList = new IcRateCodeRatesBaseDAO().getRates(tranPartner.getPrmCd()); /// List of Rate on PrmCd for check contain
                List<Address>addressModelList = new IcgDestinationAddresBaseDAO().getAddressByPrmCd("L9");
               
                
                Map<String,Address>  addrCdMap = new HashMap<String,Address>(); ///AddressCode , Address Model
                Map<String,Address>  countryAddressMap = new HashMap<String,Address>();///Country name , Address Model
                
                for(Address address : addressModelList){ //Setup mapper
                        addrCdMap.put(address.getAddress(), address);
                        countryAddressMap.put(address.getDescription(), address);
                }
                
                for(RateSheet rateSheet : tranPartner.getRateSheetList()){
                       
                        boolean oldAddress = addrList.contains(rateSheet.getPrefix().trim());
                        System.out.println(""+rateSheet.getPrefix()+"\t"+rateSheet.getCost()+"\t"+rateSheet.getDescription());
                        if(oldAddress){
                                //Old Address
                                Address addr1 =addrCdMap.get(rateSheet.getPrefix().trim());//Get model for compare
                                if(addr1.getDescription().equals(rateSheet.getDescription().trim())){
                                        //OldAddress and Old Description
                                        if(Double.valueOf(addr1.getCost()) == Double.valueOf(rateSheet.getCost())){
                                                //Old Address and Old Description and Old Rate
                                                //DO NOTHNIG!!!!

                                        }else{
                                               //Old Address and Old Description and Change Rate
                                                if(costList.contains(Double.valueOf(rateSheet.getCost()))){
                                                            //if  is have rate in Database
                                                           //Go generate new Destination code


                                                }else{
                                                            //if isn't have rate  in Database
                                                            //Generate new Rate code then Go generate new Destination code

                                                            costList = new IcRateCodeRatesBaseDAO().getRates(tranPartner.getPrmCd());//refresh costList
                                                }

                                        }
                                
                                
                                }else{
                                        //OldAddress and new Description
                                        if(Double.valueOf(addr1.getCost()) == Double.valueOf(rateSheet.getCost())){
                                                //OldAddress and new Description and Old rate
                                                //Go update only IC_destination_dict
                                        
                                        }else{
                                                //OldAddress and new Description and Change rate
                                                if(costList.contains(Double.valueOf(rateSheet.getCost()))){
                                                       //if  is have rate in Database
                                                       //Go generate new Destination code
                                                       //Go insert ic_destinaion_dict 
                                                    
                                                }else{
                                                       //if isn't have rate  in Database
                                                       //Generate new Rate code then Go generate new Destination code and Insert IC_DESTINATION_ADDRES

                                                       costList = new IcRateCodeRatesBaseDAO().getRates(tranPartner.getPrmCd());//refresh costList 
                                                }
                                        
                                        }
                                
                                }
                            
                        
                        }else{
                                //new Address
                                boolean oldDescription = countryList.contains(rateSheet.getDescription().trim());
                                if(oldDescription){
                                        //new Address and Old Description
                                        Address addr1 =countryAddressMap.get(rateSheet.getDescription().trim());//Get model for compare
                                        if(Double.valueOf(addr1.getCost())==Double.valueOf(rateSheet.getCost())){
                                                //new Address and Old Description and Old Rate
                                                //Go insert only IC_DESTINATION_ADDRES
                                                
                                        
                                        }else{
                                                //new Address and Old Description and Change Rate
                                                if(costList.contains(Double.valueOf(rateSheet.getCost()))){
                                                        //if  is have rate in Database
                                                       //Go generate new Destination code
                                                    
                                                }else{
                                                        //if isn't have rate  in Database
                                                        //Generate new Rate code then Go generate new Destination code
                                                    
                                                        costList = new IcRateCodeRatesBaseDAO().getRates(tranPartner.getPrmCd());//refresh costList
                                                }
                                        
                                        }
                                    
                                }else{
                                        //new Address and new Description
                                        if(costList.contains(Double.valueOf(rateSheet.getCost()))){
                                                        //if  is have rate in Database
                                                       //Go generate new Destination code
                                                    
                                        }else{
                                                        //if isn't have rate  in Database
                                                        //Generate new Rate code then Go generate new Destination code and Insert IC_DESTINATION_ADDRES
                                            
                                            
                                        }
                                    
                                
                                }
                            
                        }
                
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
        
        public static void addIcRatedDestination(TransactionPartner  tranPartner) throws Exception{
            System.out.println("Start addIcRatedDestination ");
            IcRatedDestinationBaseDAO dao = new IcRatedDestinationBaseDAO();
            
            for(Destination dest : tranPartner.getDestinationList()){
                
                IcRatedDestination  ratedDest = new IcRatedDestination();
                
                ratedDest.setRatePlanCd(tranPartner.getRatePlanCode());
                ratedDest.setDestinationCd(dest.getCode());
                ratedDest.setChrgParamId(BigDecimal.valueOf(16l));
                ratedDest.setEffectiveDate(new Date(dest.getEffectiveDate().getTime()));
                ratedDest.setSysCreationDate(new Date(new java.util.Date().getTime()));
                ratedDest.setOperatorId(BigDecimal.valueOf(41l));
                ratedDest.setDlServiceCode("BASE");
                ratedDest.setDlUpdateStamp(BigDecimal.ZERO);
                ratedDest.setQualParam1Id(BigDecimal.ZERO);
                ratedDest.setQualParam2Id(BigDecimal.ZERO);
                ratedDest.setQualParam3Id(BigDecimal.ZERO);
                ratedDest.setQualParam4Id(BigDecimal.ZERO);
                ratedDest.setQualParam5Id(BigDecimal.ZERO);
                ratedDest.setQualParam6Id(BigDecimal.ZERO);
                ratedDest.setQualParam7Id(BigDecimal.ZERO);
                ratedDest.setDestSortOrderCd(BigDecimal.ZERO);
                ratedDest.setRatesPresInd("Y");
                ratedDest.setUom("MI");
                ratedDest.setRoundingUnit(BigDecimal.valueOf(Long.valueOf(dest.getRoundingUnit())));
                ratedDest.setRatingUnit(BigDecimal.ONE);
                ratedDest.setRateSchemeInd("F");
                ratedDest.setMinChrg(BigDecimal.valueOf(Long.valueOf(dest.getMinCharge())));
                long expirationTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("31-12-3000").getTime();
                ratedDest.setExpirationDate(new Date(expirationTime));
                
                
                dao.insert(ratedDest);
            }
            System.out.println("Success addIcRatedDestination");
        }
        public static void addIcRates(TransactionPartner  tranPartner) throws Exception{
            System.out.println("Start addIcRates");
        
            IcRatesBaseDAO  dao = new IcRatesBaseDAO();
            for(Destination dest : tranPartner.getDestinationList()){
                
                IcRates   rates = new IcRates();
                rates.setRatePlanCd(tranPartner.getRatePlanCode());
                rates.setDestinationCd(dest.getCode());
                rates.setChrgParamId(BigDecimal.valueOf(16l));
                rates.setEffectiveDate(new Date(dest.getEffectiveDate().getTime()));
                rates.setSysCreationDate(new Date(new java.util.Date().getTime()));
                rates.setOperatorId(BigDecimal.valueOf(41l));
                rates.setDlServiceCode("BASE");
                rates.setDlUpdateStamp(BigDecimal.ZERO);
                rates.setQualParam1Id(BigDecimal.ZERO);
                rates.setQualParam2Id(BigDecimal.ZERO);
                rates.setQualParam3Id(BigDecimal.ZERO);
                rates.setQualParam4Id(BigDecimal.ZERO);
                rates.setQualParam5Id(BigDecimal.ZERO);
                rates.setQualParam6Id(BigDecimal.ZERO);
                rates.setQualParam7Id(BigDecimal.ZERO);
                rates.setQualParam1Cd(" ");
                rates.setQualParam2Cd(" ");
                rates.setQualParam3Cd(" ");
                rates.setQualParam4Cd(" ");
                rates.setQualParam5Cd(" ");
                rates.setQualParam6Cd(" ");
                rates.setQualParam7Cd(" ");
                rates.setSlabNum(BigDecimal.ONE);
                rates.setRatingUnit(BigDecimal.ONE);
                rates.setRatePerUnit(BigDecimal.ZERO);
                rates.setRatingUnit(BigDecimal.ONE);
                rates.setRatePerUnitSeq(BigDecimal.valueOf(Long.valueOf(dest.getRateCodePack().getReteCdSeq())));
                rates.setOneTimeChrg(BigDecimal.ZERO);
                rates.setOneTimeChrgSeq(BigDecimal.ZERO);
                long expirationTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("31-12-3000").getTime();
                rates.setExpirationDate(new Date(expirationTime));
            
                dao.insert(rates);
            }
            System.out.println("Success addIcRates");
        }
        
        public static void addIcRatesAddlInfo(TransactionPartner  tranPartner) throws Exception{
            System.out.println("Start addIcRatesAddlInfo");
            
            IcRatesAddlInfoBaseDAO dao = new IcRatesAddlInfoBaseDAO();
            for(Destination dest : tranPartner.getDestinationList()){
            
                     IcRatesAddlInfo ratesAd = new IcRatesAddlInfo();
                        ratesAd.setRatePlanCd(tranPartner.getRatePlanCode());
                        ratesAd.setDestinationCd(dest.getCode());
                        ratesAd.setChrgParamId(BigDecimal.valueOf(16l));
                        ratesAd.setEffectiveDate(new Date(dest.getEffectiveDate().getTime()));
                        ratesAd.setSysCreationDate(new Date(new java.util.Date().getTime()));
                        ratesAd.setOperatorId(BigDecimal.valueOf(41l));
                        ratesAd.setDlServiceCode("BASE");
                        ratesAd.setDlUpdateStamp(BigDecimal.ZERO);
                        ratesAd.setQualParam1Id(BigDecimal.ZERO);
                        ratesAd.setQualParam2Id(BigDecimal.ZERO);
                        ratesAd.setQualParam3Id(BigDecimal.ZERO);
                        ratesAd.setQualParam4Id(BigDecimal.ZERO);
                        ratesAd.setQualParam5Id(BigDecimal.ZERO);
                        ratesAd.setQualParam6Id(BigDecimal.ZERO);
                        ratesAd.setQualParam7Id(BigDecimal.ZERO);
                        ratesAd.setQualParam1Cd(" ");
                        ratesAd.setQualParam2Cd(" ");
                        ratesAd.setQualParam3Cd(" ");
                        ratesAd.setQualParam4Cd(" ");
                        ratesAd.setQualParam5Cd(" ");
                        ratesAd.setQualParam6Cd(" ");
                        ratesAd.setQualParam7Cd(" ");
                        ratesAd.setRoundingUnit(BigDecimal.valueOf(Long.valueOf(dest.getRoundingUnit())));
                        ratesAd.setMinChrg(BigDecimal.ZERO);
                        ratesAd.setMinChrgParam(BigDecimal.valueOf(Long.valueOf(dest.getMinCharge())));
                        ratesAd.setAccesChrg(BigDecimal.ZERO);
                        ratesAd.setAccesChrgSeq(BigDecimal.ZERO);
                        long expirationTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("31-12-3000").getTime();
                        ratesAd.setExpirationDate(new Date(expirationTime));
                     
            
                        dao.insert(ratesAd);
            
            }
        
            System.out.println("Success addIcRatesAddlInfo");
        }
          
        public static void addIcRatesSlabs(TransactionPartner  tranPartner) throws Exception{
            System.out.println("Start addIcRatesSlabs");
            
            IcRatesSlabsBaseDAO dao = new IcRatesSlabsBaseDAO();
            for(Destination dest : tranPartner.getDestinationList()){
            
                     IcRatesSlabs slabs = new IcRatesSlabs();
                        slabs.setRatePlanCd(tranPartner.getRatePlanCode());
                        slabs.setDestinationCd(dest.getCode());
                        slabs.setChrgParamId(BigDecimal.valueOf(16l));
                        slabs.setSlabNum(BigDecimal.ONE);
                        slabs.setOperatorId(BigDecimal.valueOf(41l));
                        slabs.setDlUpdateStamp(BigDecimal.ZERO);
                        slabs.setFromSlab(BigDecimal.ZERO);
                        slabs.setToSlab(BigDecimal.ZERO);
                        slabs.setEffectiveDate(new Date(dest.getEffectiveDate().getTime()));
                        slabs.setSysCreationDate(new Date(new java.util.Date().getTime()));
                        slabs.setOperatorId(BigDecimal.valueOf(41l));
                        slabs.setDlServiceCode("BASE");
                        long expirationTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("31-12-3000").getTime();
                        slabs.setExpirationDate(new Date(expirationTime));
            
                        dao.insert(slabs);
            }
       
            System.out.println("Success addIcRatesSlabs");
        }
    
}
