/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.process;

import java.util.Date;
import java.util.List;
import truecorp.prm.business.FileBusiness;
import truecorp.prm.business.PRMBusiness;
import truecorp.prm.core.dao.SystemBaseDao;
import truecorp.prm.model.TransactionPartner;
import truecorp.prm.test.MyUnitTest;

/**
 *
 * @author Jennarong Pinjai
 */
public class ProcessPRMData {
    
    public static void main(String[] args) throws Exception {
    
        try{
            MyUnitTest.main(null);
            List<TransactionPartner> transactionList  =  FileBusiness.readRateSheet();
         
            for(TransactionPartner transactionPartner:transactionList){
          
                if(transactionPartner.isEalyMonth()){
              
                    PRMBusiness.processEarlyMonth(transactionPartner);
              
                }else{
              
                    PRMBusiness.processHalfMonth(transactionPartner);
              
                }
              
            }
        }catch(Exception ex){
        
            ex.printStackTrace();
        
        }finally{
            ///For close main transaction
            SystemBaseDao.getPrmConnection().close(); //Close DB connection
            
        }
     
    }
}
