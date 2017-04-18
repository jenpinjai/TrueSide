/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.business;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import sun.util.calendar.CalendarUtils;
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
        
        public static Integer rateCodeSeq;
        public static Integer descriptionSeq;
        public static Integer destination_sequence_no ;
        public static void processEarlyMonth(TransactionPartner  tranPartner) throws Exception {
        
                    List<RateCodePack>  rateCodePackList = FileBusiness.genRateCodePackList(tranPartner);
                    Map<Double,RateCodePack>  rateCodeMapper   = new HashMap<Double,RateCodePack>();
                    ////Set rateCode Mapper
                    for(RateCodePack rateCode : rateCodePackList){rateCodeMapper.put(Double.valueOf(rateCode.getRate()),rateCode);}
                          
                  
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
                List<Address>addressModelList = new IcgDestinationAddresBaseDAO().getAddressByPrmCd(tranPartner.getPrmCd());
                List<RateCodePack>  rateCodePackList = new IcRatingDictBaseDAO().getRateCodePackByPrmCd(tranPartner.getServiceType(),tranPartner.getPrmCd());
                rateCodeSeq=new IcRateCodeBaseDAO().getMaxRateCdSeq()+1;
                descriptionSeq=new IcRatingDictBaseDAO().getMaxDescriptionSeq()+1;
                destination_sequence_no = new IcDestinationDictBaseDAO().getMaxSequenceNo()+1;
                
//                rateCodeSeq=300000;
//                descriptionSeq=300000;
//                destination_sequence_no = 300000;
                Map<String,Address>  addrCdMap = new HashMap<String,Address>(); ///AddressCode , Address Model
                Map<String,Address>  countryAddressMap = new HashMap<String,Address>();///Country name , Address Model
                Map<String,Address>  countryRateMap = new HashMap<String,Address>();
                Map<Double,RateCodePack>   rateMap   = new HashMap<Double,RateCodePack>();
                Map<String,Integer>  countDestinationCdMap = new HashMap<String,Integer>();
                for(Address address : addressModelList){ //Setup mapper
                    
                    try{
                            addrCdMap.put(address.getAddress(), address);
                            countryAddressMap.put(address.getDescription(), address);
                            countryRateMap.put(address.getDescription().trim()+String.format("%.10f", Double.valueOf(address.getCost())), address);
                            if(!countDestinationCdMap.containsKey(address.getDestinationCd())){
                                    int numOfDestinationCd=1;
                                    countDestinationCdMap.put(address.getDestinationCd(), numOfDestinationCd);
                            }else{
                                    int numOfDestinationCd=countDestinationCdMap.get(address.getDestinationCd());
                                    numOfDestinationCd++;
                                    countDestinationCdMap.put(address.getDestinationCd(), numOfDestinationCd);
                            }
                        
                    }catch(Exception ex){
                    
                        System.out.println("Error Intitail Address Mapper.");
                        throw ex; 
                        
                    }    
                }
                //Setup rateMap
                for(RateCodePack ratePack:rateCodePackList){
                
                        rateMap.put(Double.valueOf(ratePack.getRate()), ratePack);
                }
                
                for(RateSheet rateSheet : tranPartner.getRateSheetList()){
                       
                        boolean oldAddress = addrList.contains(rateSheet.getPrefix().trim());
                        System.out.println("From Sheet    : "+rateSheet.getPrefix()+"\t"+rateSheet.getCost()+"\t"+rateSheet.getDescription());
                        
                        if(oldAddress){
                                //Old Address
                                Address addr1 =addrCdMap.get(rateSheet.getPrefix().trim());//Get model for compare
                                System.out.println("From DataBase : "+addr1.getAddress()+"\t"+addr1.getCost()+"\t"+addr1.getDescription());
                                if(addr1.getDescription().equals(rateSheet.getDescription().trim())){
                                        //OldAddress and Old Description
                                        if(Double.valueOf(addr1.getCost()).compareTo(Double.valueOf(rateSheet.getCost()))==0){
                                                //Old Address and Old Description and Old Rate
                                                //DO NOTHNIG!!!!
                                                System.out.println("Old Address and Old Description and Old Rate DO NOTHNIG!!!!");
                                        }else{
                                               //Old Address and Old Description and Change Rate
                                                System.out.print("Old Address and Old Description and Change Rate");
                                                if(costList.contains(Double.valueOf(rateSheet.getCost()))){
                                                            //if  is have rate in Database
                                                           //Go generate new Destination code
                                                           System.out.println(" and is have rate in Database");
                                                           System.out.println("Continue generate new Destination code and update....");
                                                           expireDestinationCode(countDestinationCdMap,addr1,rateSheet.getEffective());
                                                           generateAndUpdateDestinationCode(countDestinationCdMap,rateMap,countryAddressMap,rateSheet,tranPartner);
                                                }else{
                                                            //if isn't have rate  in Database
                                                            //Generate new Rate code then Go generate new Destination code
                                                            System.out.println(" isn't have rate  in Database");
                                                            System.out.println("Continue generate new Rate code then Go generate new Destination code and update....");
                                                            RateCodePack ratePack = generateNewRateCode(rateMap,rateSheet, tranPartner);
                                                            expireDestinationCode(countDestinationCdMap,addr1,rateSheet.getEffective());
                                                            generateAndUpdateDestinationCode(countDestinationCdMap,rateMap,countryAddressMap,rateSheet,tranPartner);
                                                            costList.add(Double.valueOf(ratePack.getRate())); //add new  costList
                                                }

                                        }
                                
                                
                                }else{
                                        //Old Address and new Description
                                        if(Double.valueOf(addr1.getCost()).compareTo(Double.valueOf(rateSheet.getCost()))==0 ){
                                                //Old Address and new Description and Old rate
                                                //Go update only IC_destination_dict
                                                System.out.println("OldAddress and new Description and Old rate");
                                                System.out.println("Continue update only IC_destination_dict...");
                                                IcDestinationDictBaseDAO destDictDao = new IcDestinationDictBaseDAO();
                                                IcDestinationDict  destDict = destDictDao.findByPK(BigDecimal.valueOf(Long.valueOf(addr1.getBillingNameSeq())), "E");
                                                destDict.setText(destDict.getText().substring(0, 8)+rateSheet.getDescription());
                                                destDictDao.update(destDict);
                                        }else{
                                                //OldAddress and new Description and Change rate
                                               System.out.print("OldAddress and new Description and Change rate");
                                                if(costList.contains(Double.valueOf(rateSheet.getCost()))){
                                                       //if  is have rate in Database
                                                       //Go generate new Destination code
                                                       //Go insert ic_destinaion_dict 
                                                       System.out.println(" and is have rate in Database");
                                                       System.out.println("Continue generate new Destination code and update...");
                                                       expireDestinationCode(countDestinationCdMap,addr1,rateSheet.getEffective());
                                                       generateAndUpdateDestinationCode(countDestinationCdMap,rateMap,countryAddressMap,rateSheet,tranPartner);
                                                    
                                                }else{
                                                       //if isn't have rate  in Database
                                                       //Generate new Rate code then Go generate new Destination code and Insert IC_DESTINATION_ADDRES
                                                       System.out.println(" and isn't have rate  in Database"); 
                                                       System.out.println("Continue generate new Rate code then go generate new Destination code and Insert and update...");
                                                       RateCodePack ratePack = generateNewRateCode(rateMap,rateSheet, tranPartner);
                                                       expireDestinationCode(countDestinationCdMap,addr1,rateSheet.getEffective());
                                                       generateAndUpdateDestinationCode(countDestinationCdMap,rateMap,countryAddressMap,rateSheet,tranPartner);
                                                       costList.add(Double.valueOf(ratePack.getRate())); //add new  costList
                                                }
                                        
                                        }
                                
                                }
                            
                        
                        }else{
                                //new Address
                                boolean oldDescription = countryList.contains(rateSheet.getDescription().trim());
                                if(oldDescription){
                                        //new Address and Old Description
                                        Address addr1 =countryAddressMap.get(rateSheet.getDescription().trim());//Get model for compare
                                        System.out.println("From DataBase : "+addr1.getAddress()+"\t"+addr1.getCost()+"\t"+addr1.getDescription());
                                        if(countryRateMap.containsKey(rateSheet.getDescription().trim()+String.format("%.10f", Double.valueOf(rateSheet.getCost())))){
                                                //new Address and Old Description and Old Rate
                                                //Go insert only IC_DESTINATION_ADDRES
                                                System.out.println("new Address and Old Description and Old Rate");
                                                System.out.println("Continue insert only IC_DESTINATION_ADDRES...");
                                                Address newAddress = countryRateMap.get(rateSheet.getDescription().trim()+String.format("%.10f", Double.valueOf(rateSheet.getCost())));
                                                
                                                IcgDestinationAddresBaseDAO  destAddDao = new IcgDestinationAddresBaseDAO();
                                                IcgDestinationAddres  destAdd = new IcgDestinationAddres();
                    
                                                destAdd.setDestinationCd(newAddress.getDestinationCd());
                                                destAdd.setAddress(rateSheet.getPrefix().trim());
                                                destAdd.setEffectiveDate(new Date(rateSheet.getEffective().getTime()));
                                                destAdd.setSysCreationDate(new Date(new java.util.Date().getTime()));
                                                destAdd.setOperatorId(BigDecimal.valueOf(41l));
                                                destAdd.setDlServiceCode("BASE");
                                                destAdd.setDlUpdateStamp(BigDecimal.ZERO);
                                                long expirationTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("31-12-3000").getTime();
                                                destAdd.setExpirationDate(new Date(expirationTime));

                                                destAddDao.insert(destAdd);
                                                ///Add numOf DestinationCode's Children (Address Code)
                                                int numOfDestinationCd=countDestinationCdMap.get(newAddress.getDestinationCd());
                                                numOfDestinationCd++;
                                                countDestinationCdMap.put(newAddress.getDestinationCd(), numOfDestinationCd);
                                                
                                        }else{
                                                //new Address and Old Description and Change Rate
                                                System.out.print("new Address and Old Description and Change Rate");
                                                if(costList.contains(Double.valueOf(rateSheet.getCost()))){
                                                        //if  is have rate in Database
                                                       //Go generate new Destination code
                                                       System.out.println(" and is have rate in Database");
                                                       System.out.println("Continue generate new Destination code and update...");
                                                       generateAndUpdateDestinationCode(countDestinationCdMap,rateMap,countryAddressMap,rateSheet,tranPartner);
                                                }else{
                                                        //if isn't have rate  in Database
                                                        //Generate new Rate code then Go generate new Destination code
                                                        System.out.println(" and isn't have rate  in Database");
                                                        System.out.println("Continue generate new Rate code then go generate new Destination code and update...");
                                                        
                                                        RateCodePack ratePack = generateNewRateCode(rateMap,rateSheet, tranPartner);
                                                        generateAndUpdateDestinationCode(countDestinationCdMap,rateMap,countryAddressMap,rateSheet,tranPartner);
                                                        costList.add(Double.valueOf(ratePack.getRate())); //add new  costList
                                                }
                                        
                                        }
                                    
                                }else{
                                        //new Address and new Description
                                        System.out.print("new Address and new Description then ignore rate");
                                        if(costList.contains(Double.valueOf(rateSheet.getCost()))){
                                                        //if  is have rate in Database
                                                       //Go generate new Destination code
                                                       System.out.println(" and is have rate in Database");
                                                       System.out.println("Continue go generate new Destination code and update...");
                                                       generateAndUpdateDestinationCode(countDestinationCdMap,rateMap,countryAddressMap,rateSheet,tranPartner);
                                        }else{
                                                        //if isn't have rate  in Database
                                                        //Generate new Rate code then Go generate new Destination code and Insert IC_DESTINATION_ADDRES
                                                        System.out.println(" and isn't have rate  in Database");
                                                        System.out.println("Continue generate new Rate code then go generate new Destination cod and update...");
                                                        RateCodePack ratePack = generateNewRateCode(rateMap,rateSheet, tranPartner);
                                                        generateAndUpdateDestinationCode(countDestinationCdMap,rateMap,countryAddressMap,rateSheet,tranPartner);
                                                        ////////////////////
                                                        costList.add(Double.valueOf(ratePack.getRate())); //add new  costList
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
                icRateCode.setRateCdSeq(BigDecimal.valueOf(Long.valueOf(ratePack.getRateCdSeq())));
                long effectiveTime = new SimpleDateFormat("dd-MM-yyyy",Locale.US).parse("01-01-2002").getTime();
                icRateCode.setEffectiveDate(new Date(effectiveTime));
                icRateCode.setSysCreationDate(new Date(new java.util.Date().getTime()));
                icRateCode.setOperatorId(BigDecimal.valueOf(41l));
                icRateCode.setDlServiceCode("BASE");
                icRateCode.setRateCd(ratePack.getRateCd().trim());
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
                    rcr.setRateCdSeq(BigDecimal.valueOf(Long.valueOf(ratePack.getRateCdSeq())));
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
                    dict.setText(ratePack.getText().trim());
            
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
                sub.setCode(ratePack.getRateCd().trim());
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
                
                icDest.setDestinationCd(dest.getCode().trim());
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
                    
                    destAdd.setDestinationCd(rateSheet.getDestinationCd().trim());
                    destAdd.setAddress(rateSheet.getPrefix().trim());
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
                sub.setCode(dest.getCode().trim());
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
                ratedDest.setDestinationCd(dest.getCode().trim());
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
                rates.setDestinationCd(dest.getCode().trim());
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
                rates.setRatePerUnitSeq(BigDecimal.valueOf(Long.valueOf(dest.getRateCodePack().getRateCdSeq())));
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
                        ratesAd.setDestinationCd(dest.getCode().trim());
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
                        slabs.setDestinationCd(dest.getCode().trim());
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
        public static RateCodePack generateNewRateCode(Map<Double,RateCodePack>   rateMap,RateSheet rateSheet ,TransactionPartner tranPartner ) throws Exception{
            
            try{
                  RateCodePack rateCode = new RateCodePack();
                  int  rateCount       = rateMap.size();
                  String rateCd        = FileBusiness.genRateCd(rateCount+1);
                  rateCode.setCd(rateCd);
                  rateCode.setRateCd(rateSheet.getServiceType()+tranPartner.getPrmCd()+rateCode.getCd());
                  rateCode.setRateCdSeq(String.valueOf(rateCodeSeq));
                  rateCode.setDescriptionSeq(String.valueOf(descriptionSeq));
                  rateCode.setRate(rateSheet.getCost());
                  rateCode.setText(tranPartner.getServiceType()+" "+tranPartner.getPartnerCd()+" Termination Rate "+rateCode.getCd());
                  
                  
                 List<RateCodePack>  rateCodePackList = new ArrayList<RateCodePack>();
                 rateCodePackList.add(rateCode);
                   
                 //// Add new IcRateCode
                 addIcRateCode(rateCodePackList); 
                 
                 //// Add new IcRateCodeRates
                 addIcRateCodeRates(rateCodePackList, tranPartner);
                           
                 ////Add new IcRatingDict
                 addIcRatingDict(rateCodePackList);
                        
                 ////Add new IcSubjectVersions
                 addIcSubjectVersions(rateCodePackList);
                  
                 System.out.println("Success generate RateCd:"+rateCode.getRate()+" "+rateCode.getText());
                 rateCodeSeq=rateCodeSeq+1;
                 descriptionSeq=descriptionSeq+1;
                  
                 rateMap.put(Double.valueOf(rateCode.getRate()), rateCode);
                 return rateCode;
            }catch(Exception ex){
            
                ex.printStackTrace();
                return null;
            
            }
           
        }
        public static Destination generateAndUpdateDestinationCode(Map<String,Integer>  countDestinationCdMap,Map<Double,RateCodePack>   rateMap,Map<String,Address>  countryAddressMap,RateSheet rateSheet ,TransactionPartner tranPartner) throws Exception{
        
            try{
                    
                    String countryCd="";
                    boolean isNewCountry=false;
                    if(countryAddressMap.containsKey(rateSheet.getDescription().trim())){
                    
                            countryCd = countryAddressMap.get(rateSheet.getDescription().trim()).getDestinationCd().substring(2, 5);
                        
                    }else{
                            int nextCountryNumber = countryAddressMap.size()+1;
                            isNewCountry=true;
                            //new CountryCode
                            int loopNum=1;
                            int codeNum=1;
                            int charNum=64;
                            for(int i=1;i<=nextCountryNumber;i++){
                                  if(loopNum<=999){
                                         countryCd = String.format("%03d", codeNum);
                                  }else{
                                        if(codeNum>99){
                                            codeNum=1;
                                            charNum++;
                                        }
                                        countryCd = String.format("%c%02d", charNum,codeNum);
                                  }
                                  //System.out.println(coun.getCd()+"    "+coun.getName());
                                  codeNum++;
                                  loopNum++;
                            }
                        
                    }
                    String rateCd    = rateMap.get(Double.valueOf(rateSheet.getCost())).getCd();
                    String newDestinationCd = tranPartner.getPrmCd()+countryCd+rateCd;
                    
                    boolean  isDuplicateDestination=false;
                    if(countDestinationCdMap.containsKey(newDestinationCd)){
                            isDuplicateDestination=true;
                    }
                    
                    Destination dest = new Destination();
                    
                    Country     country = new Country();
                    country.setCd(countryCd);
                    country.setName(rateSheet.getDescription());
                    dest.setCountry(country);
                    
                    RateCodePack  rateCodePack = new RateCodePack();
                    rateCodePack.setCd(rateCd);
                    rateCodePack.setRate(rateSheet.getCost());
                    rateCodePack.setRateCdSeq(rateMap.get(Double.valueOf(rateSheet.getCost())).getRateCdSeq());
                    rateCodePack.setDescriptionSeq(rateMap.get(Double.valueOf(rateSheet.getCost())).getDescriptionSeq());
                    dest.setRateCodePack(rateCodePack);
                    
                    dest.setCode(newDestinationCd);
                    dest.setEffectiveDate(rateSheet.getEffective());
                    dest.setMinCharge(rateSheet.getMinChrg());
                    dest.setRoundingUnit(rateSheet.getRoundingUnit());
                    dest.setSequenceNo(destination_sequence_no);
                    
                    TransactionPartner  insertTranTemp = new TransactionPartner();
                    rateSheet.setDestinationCd(newDestinationCd);
                    insertTranTemp.getDestinationList().add(dest);
                    insertTranTemp.getRateSheetList().add(rateSheet);
                    insertTranTemp.setPrmCd(tranPartner.getPrmCd());
                    insertTranTemp.setPartnerCd(tranPartner.getPartnerCd());
                    insertTranTemp.setEalyMonth(tranPartner.isEalyMonth());
                    insertTranTemp.setServiceType(tranPartner.getServiceType());
                    insertTranTemp.setRatePlanCode(tranPartner.getRatePlanCode());
                    insertTranTemp.setFileName(tranPartner.getFileName());
                    
                    ////Add new ICG_Destination
                    if(!isDuplicateDestination)addIcgDestination(insertTranTemp);

                    ////Add new Icg Destination Addres
                    addIcgDestinationAddres(insertTranTemp);

                    ////Add new IcDestinaionDict
                    if(!isDuplicateDestination)addIcDestinationDict(insertTranTemp);

                    ////Add new Ic Subjct versions
                    if(!isDuplicateDestination)addIcSubjectVersions(insertTranTemp);

                    ////Add new IcRatedDestination
                    if(!isDuplicateDestination)addIcRatedDestination(insertTranTemp);

                    ////Add new IcRates
                    if(!isDuplicateDestination)addIcRates(insertTranTemp);

                    ////Add new Ic Rated Addl Info
                    if(!isDuplicateDestination)addIcRatesAddlInfo(insertTranTemp);

                    ////Add new Ic Rates Slabs
                    if(!isDuplicateDestination)addIcRatesSlabs(insertTranTemp);
                    
                    
                    if(isNewCountry){
                    
                        Address  newAddress = new Address();
                        
                        newAddress.setAddress(rateSheet.getPrefix().trim());
                        newAddress.setBillingNameSeq(String.valueOf(destination_sequence_no));
                        newAddress.setCost(rateSheet.getCost());
                        newAddress.setDescription(rateSheet.getDescription());
                        newAddress.setDestinationCd(newDestinationCd);
                        newAddress.setRateCdSeq(rateCodePack.getRateCdSeq());
                        
                        countryAddressMap.put(rateSheet.getDescription().trim(), newAddress);
                        
                    }
                    if(!isDuplicateDestination){
                    
                        int countDestinationCd = 1;
                        countDestinationCdMap.put(newDestinationCd, countDestinationCd);
                        destination_sequence_no=destination_sequence_no+1;
                    }else{
                    
                        int countDestinationCd = countDestinationCdMap.get(newDestinationCd);
                        countDestinationCd++;
                        countDestinationCdMap.put(newDestinationCd, countDestinationCd);
                    
                    }
                    
                    return dest;
            }catch(Exception ex){
            
                ex.printStackTrace();
                return null;
            
            }
        
            
        }
        public static void expireDestinationCode(Map<String,Integer>  countDestinationCdMap,Address addr1,java.util.Date expireDate) throws Exception{
        
                Calendar cal = Calendar.getInstance();
                cal.setTime(expireDate);
                cal.add(Calendar.DATE, -1);
                java.util.Date beforeExpireDate = cal.getTime();
            
                beforeExpireDate.setHours(23);
                beforeExpireDate.setMinutes(59);
                beforeExpireDate.setSeconds(59);
                int destinationCdCount = countDestinationCdMap.get(addr1.getDestinationCd())==null?0:countDestinationCdMap.get(addr1.getDestinationCd());
                if(destinationCdCount>1){
                    //Only expire at Icg destination address
                    new IcgDestinationAddresBaseDAO().expireDestinationCd(addr1.getDestinationCd(), addr1.getAddress(), beforeExpireDate);
                
                
                    destinationCdCount--;
                    countDestinationCdMap.put(addr1.getDestinationCd(), destinationCdCount);
                }else if(destinationCdCount==1){
                    new IcgDestinationAddresBaseDAO().expireDestinationCd(addr1.getDestinationCd(), addr1.getAddress(), beforeExpireDate);
                
                    new IcgDestinationBaseDAO().expireDestinationCd(addr1.getDestinationCd(), beforeExpireDate);
                    
                    new IcSubjectVersionsBaseDAO().expireDestinationCd(addr1.getDestinationCd(), beforeExpireDate);
                    
                    new IcRatedDestinationBaseDAO().expireDestinationCd(addr1.getDestinationCd(), beforeExpireDate);
                    
                    new IcRatesBaseDAO().expireDestinationCd(addr1.getDestinationCd(), beforeExpireDate);
                    
                    new IcRatesAddlInfoBaseDAO().expireDestinationCd(addr1.getDestinationCd(), beforeExpireDate);
                    
                    new IcRatesSlabsBaseDAO().expireDestinationCd(addr1.getDestinationCd(), beforeExpireDate);
                    
                    destinationCdCount--;
                    countDestinationCdMap.put(addr1.getDestinationCd(), destinationCdCount);
                }else if(destinationCdCount==0){
                    //nothing
                }
                //new IcgDestinationBaseDAO().expireDestinationCd(addr1.getDestinationCd(), expireDate);
                
                
                
        }

    
}
