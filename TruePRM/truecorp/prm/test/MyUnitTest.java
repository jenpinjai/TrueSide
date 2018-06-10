/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import truecorp.prm.core.dao.SystemBaseDao;
import truecorp.prm.dao.IcDestinationDictBaseDAO;
import truecorp.prm.table.IcDestinationDict;

/**
 *
 * @author Jennarong Pinjai
 */
public class MyUnitTest {
    
    public static void main(String[] args) throws Exception{
    
    
    
        System.out.println("=========Start My Unit test===========");
        int sucessNum=0;
        int errorNum=0;
        int totalNum=0;
        ////////////////////////////////////////////////////////////////
        try{ testPrmConnection(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        try{ testSelectAllIcDestinationDict(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        
        ////////////////////////////////////////////////////////////////
        SystemBaseDao.getPrmConnection().close();
        System.out.println("=========End My Unit test===========");
        System.out.println("=========Test Result================");
        System.out.println("Success :"+sucessNum);
        System.out.println("Error :"+errorNum);
        System.out.println("Total :"+totalNum);
        
        
    }
    
    public static void testPrmConnection() throws SQLException, IOException{
    
        System.out.println("Start testPrmConnection");
        
        
        System.out.println("IP :"+System.getenv("ipPRM"));
        System.out.println("User name :"+System.getenv("userPRM"));
        System.out.println("Password :"+System.getenv("passwordPRM"));
        
        SystemBaseDao.getPrmConnection();
        
        System.out.println("Succcess testPrmConnection");
        
    
    }
    public static void testSelectAllIcDestinationDict() throws SQLException{
        
        System.out.println("Start testSelectAllIcDestinationDict");
    
        List<IcDestinationDict>  icDestDictList = new ArrayList<IcDestinationDict>();
        
        IcDestinationDictBaseDAO   icDestiantionDictBaseDAO = new IcDestinationDictBaseDAO();
        
        icDestDictList = icDestiantionDictBaseDAO.findAll();
        
        System.out.println("Succcess testSelectAllIcDestinationDict");
    
    }
    
    
}
