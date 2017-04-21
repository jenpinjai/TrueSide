/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.core.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jennarong Pinjai
 */
public class SystemBaseDao {
    
        public static Connection prmConnection;
        public static Connection prmAppConnection;
    public static Connection openConnectPRMDB()throws  IOException {
		
                    String ipBILL=System.getenv("ipPRM");
    //		String userBILL=System.getenv("userPRM");
    //		String passwordBILL=System.getenv("passwordPRM");
                    String userBILL="prmuatref";
                    String passwordBILL="prmdb#01";
            Connection result;
            try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    result = DriverManager.getConnection(ipBILL, userBILL,passwordBILL);
            } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(), e);
            }
            setPrmConnection(result);
            return result;
    }
    public static Connection openConnectPRMAPPDB()throws  IOException {
		
                    String ipBILL=System.getenv("ipPRM");
    //		String userBILL=System.getenv("userPRM");
    //		String passwordBILL=System.getenv("passwordPRM");
                    String userBILL="prmuatapp";
                    String passwordBILL="prmdb#01";
            Connection result;
            try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    result = DriverManager.getConnection(ipBILL, userBILL,passwordBILL);
            } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(), e);
            }
            setPrmAppConnection(result);
            return result;
    }
    public static Connection getPrmConnection() throws SQLException, IOException {
        
        if(prmConnection == null){
        
             openConnectPRMDB();
             return prmConnection;
        
        }else if(prmConnection.isClosed()){
        
            openConnectPRMDB();
            return prmConnection;
        
        }else {
        
            return prmConnection;
            
        }
    }

    public static void setPrmConnection(Connection prmConnection) {
        SystemBaseDao.prmConnection = prmConnection;
    }

    public static Connection getPrmAppConnection()throws SQLException, IOException  {
        
        if(prmAppConnection == null){
        
             openConnectPRMAPPDB();
             return prmAppConnection;
        
        }else if(prmAppConnection.isClosed()){
        
            openConnectPRMAPPDB();
            return prmAppConnection;
        
        }else {
        
            return prmAppConnection;
            
        }
       
    }

    public static void setPrmAppConnection(Connection prmAppConnection) {
        SystemBaseDao.prmAppConnection = prmAppConnection;
    }

    
        
}
