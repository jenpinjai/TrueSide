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

/**
 *
 * @author Jennarong Pinjai
 */
public class ProcessPRMData {
    
    public static void main(String[] args) throws Exception {
    
        try{
        
          List<TransactionPartner> transactionList  =  FileBusiness.readRateSheet();
          if(new Date().getDate()<10||true){
              PRMBusiness.processEarlyMonth(transactionList);
              
          }else{
              PRMBusiness.processHalfMonth(transactionList);
          }
            
        
          
          
        }catch(Exception ex){
        
            ex.printStackTrace();
        
        }finally{
            ///For close main transaction
            SystemBaseDao.getPrmConnection().close(); //Close DB connection
            
        }
     
    }
}