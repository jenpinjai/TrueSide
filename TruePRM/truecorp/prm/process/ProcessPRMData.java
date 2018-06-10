/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.process;

import truecorp.prm.core.dao.SystemBaseDao;

/**
 *
 * @author Jennarong Pinjai
 */
public class ProcessPRMData {
    
    public static void main(String[] args) throws Exception {
    
        try{
        
        
        
        
        
        }catch(Exception ex){
        
            ex.printStackTrace();
        
        }finally{
            
            SystemBaseDao.getPrmConnection().close();
            
        }
     
    }
}
