/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.test;

import java.util.ArrayList;
import java.util.List;
import truecorp.prm.dao.IcDestinationDictBaseDAO;
import truecorp.prm.dao.IcRateCodeRatesBaseDAO;
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
    
    
        
        double timeSelectA = System.currentTimeMillis();
        List<Address> addressList = new IcgDestinationAddresBaseDAO().getAddressByPrmCd("L9");
        double timeSelectB = System.currentTimeMillis();
        double timeA = System.currentTimeMillis();
        
       
        for(Address addr:addressList){
        
            System.out.println(addr.getAddress()+"\t"+Double.valueOf(addr.getCost())+"\t"+addr.getDescription());
            
        }
        
        double timeB = System.currentTimeMillis();
        
        
        System.out.println("Select database time used:"+(timeSelectB-timeSelectA)/1000+" sec");
        System.out.println("Check time used:"+(timeB-timeA)/1000+" sec");
    }
    
}
