/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.process;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import truecorp.prm.business.AccrueBusiness;
import truecorp.prm.core.dao.SystemBaseDao;

/**
 *
 * @author Jennarong Pinjai
 */
public class MigrateAccrueData {
    
    
    
    public static void main(String[] args) throws Exception{
        System.out.println(currentTime()+"Start MigrateAccrueData");
    
        try{
                Locale.setDefault(Locale.US);
                AccrueBusiness.migrateData("INBOUND");
                
                AccrueBusiness.migrateData("OUTBOUND");
                
        }catch(Exception ex){
            System.out.println(currentTime()+"Exception MigrateAccrueData :"+ex.getMessage());
            ex.printStackTrace();
        }finally{
            SystemBaseDao.getPrmAppConnection().close();
        }    
        
        System.out.println(currentTime()+"End MigrateAccrueData");
    }
    
    public static String currentTime(){
    
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss ",Locale.US).format(new Date());
        
    }
    
}
