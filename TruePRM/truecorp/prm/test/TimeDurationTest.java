/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static truecorp.prm.business.PRMBusiness.descriptionSeq;
import static truecorp.prm.business.PRMBusiness.rateCodeSeq;
import truecorp.prm.dao.IcDestinationDictBaseDAO;
import truecorp.prm.dao.IcRateCodeBaseDAO;
import truecorp.prm.dao.IcRateCodeRatesBaseDAO;
import truecorp.prm.dao.IcRatingDictBaseDAO;
import truecorp.prm.dao.IcgDestinationAddresBaseDAO;
import truecorp.prm.model.Address;
import truecorp.prm.table.IcRateCodeRates;
import truecorp.prm.table.IcgDestinationAddres;

/**
 *
 * @author Jennarong Pinjai
 */
public class TimeDurationTest {
    
    public static void main(String[] args) throws Exception{
    
    
        
//        double timeSelectA = System.currentTimeMillis();
//        List<Address> addressList = new IcgDestinationAddresBaseDAO().getAddressByPrmCd("L9");
//        double timeSelectB = System.currentTimeMillis();
//        double timeA = System.currentTimeMillis();
//        
//       
//        for(Address addr:addressList){
//        
//            System.out.println(addr.getAddress()+"\t"+Double.valueOf(addr.getCost())+"\t"+addr.getDescription());
//            
//        }
//        
//        double timeB = System.currentTimeMillis();
//        
//        
//        System.out.println("Select database time used:"+(timeSelectB-timeSelectA)/1000+" sec");
//        System.out.println("Check time used:"+(timeB-timeA)/1000+" sec");
        
//         List<Address>addressModelList = new IcgDestinationAddresBaseDAO().getAddressByPrmCd("L9");
//         rateCodeSeq=new IcRateCodeBaseDAO().getMaxRateCdSeq()+1;
//         descriptionSeq=new IcRatingDictBaseDAO().getMaxDescriptionSeq()+1;
//         Map<String,Address>  addrCdMap = new HashMap<String,Address>(); ///AddressCode , Address Model
//         Map<String,Address>  countryAddressMap = new HashMap<String,Address>();///Country name , Address Model
//         Map<Double,Address>   rateMap   = new HashMap<Double,Address>();
//         for(Address address : addressModelList){ //Setup mapper
//                    addrCdMap.put(address.getAddress(), address);
//                    countryAddressMap.put(address.getDescription(), address);
//                    rateMap.put(Double.valueOf(address.getCost()), address);
//         }
//         
//         Address  add =countryAddressMap.get("Cambodia-Mobile Mobitel");
//         Address  addRate = rateMap.get(Double.valueOf("0.002"));
//         System.out.println(addRate.getDestinationCd().substring(5, 8));
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        cal.add(Calendar.DATE, -2);
//        Date dateBefore30Days = cal.getTime();
//        
//        
//        dateBefore30Days.setHours(23);
//        dateBefore30Days.setMinutes(59);
//        dateBefore30Days.setSeconds(59);
//        
//        System.out.println(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dateBefore30Days));
        
//         int result = new IcgDestinationAddresBaseDAO().expireDestinationCd("L9686333","95995" , new Date());
//         System.out.println(result);
            String ss="L9 T038 Denmark-Mobile Telenor";
            
            System.out.println(ss.substring(0, 8)+"Thailand-Grand");
        
        
    }
    
}