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
import truecorp.prm.dao.*;
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
import truecorp.prm.table.TiticPartnerRef;

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
        
        try{ testSelectIcDestinationDict(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        try{ testSelectIcRateCode(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        try{ testSelectIcRateCodeRates(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        try{ testSelectIcRatedDestination(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        try{ testSelectIcRatesAddlinfo(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        try{ testSelectIcRates(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        try{ testSelectIcRatesSlabs(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        try{ testSelectIcRatingDict(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        
        try{ testSelectIcSubjectVersions(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        
        try{ testSelectIcgDestinationAddres(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        
        try{ testSelectIcgDestination(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        
        try{ testSelectTiticPartnerRef(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        try{ testSelectMaxRateCdSeq(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
        totalNum++;
        
        
        try{ testSelectMaxDescriptionSeq(); sucessNum++; }catch(Exception ex){ex.printStackTrace();errorNum++;}
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
    
       // System.out.println("Start testPrmConnection");
        
        
        System.out.println("IP :"+System.getenv("ipPRM"));
        System.out.println("User name :"+System.getenv("userPRM"));
        System.out.println("Password :"+System.getenv("passwordPRM"));
        
        SystemBaseDao.getPrmConnection();
        
        System.out.println("Success testPrmConnection");
        
    
    }
    public static void testSelectIcDestinationDict() throws SQLException{
        
        //System.out.println("Start testSelectAllIcDestinationDict");
    
        List<IcDestinationDict>  icDestDictList = new ArrayList<IcDestinationDict>();
        
        IcDestinationDictBaseDAO   icDestiantionDictBaseDAO = new IcDestinationDictBaseDAO();
        
        icDestDictList = icDestiantionDictBaseDAO.findByWhereCondisions(" ROWNUM < 2");
        
        System.out.println("Success testSelectIcDestinationDict");
    
    }
    
    public static void testSelectIcRateCode() throws SQLException{
        //System.out.println("Start testSelectAllIcRateCode");
    
         List<IcRateCode>  icRateCodeList = new ArrayList<IcRateCode>();
         
         IcRateCodeBaseDAO   icRateCodeDao = new IcRateCodeBaseDAO();
         
         icRateCodeList = icRateCodeDao.findByWhereCondisions(" ROWNUM < 2");
        
        
        System.out.println("Success testSelectIcRateCode");
    }
    public static void testSelectIcRateCodeRates() throws SQLException{
        //System.out.println("Start testSelectAllIcRateCode");
    
         List<IcRateCodeRates>  icRateCodeRatesList = new ArrayList<IcRateCodeRates>();
         
         IcRateCodeRatesBaseDAO   icRateCodeDao = new IcRateCodeRatesBaseDAO();
         
         icRateCodeRatesList = icRateCodeDao.findByWhereCondisions(" ROWNUM < 2");
        
        
        System.out.println("Success testSelectIcRateCodeRates");
    }
    
    public static void testSelectIcRatedDestination() throws SQLException{
        //System.out.println("Start testSelectAllIcRateCode");
    
         List<IcRatedDestination>  icRatedDestinationList = new ArrayList<IcRatedDestination>();
         
        IcRatedDestinationBaseDAO   dao = new IcRatedDestinationBaseDAO();
         
         icRatedDestinationList = dao.findByWhereCondisions(" ROWNUM < 2");
        
        
        System.out.println("Success testSelectIcRatedDestination");
    }
    
    public static void testSelectIcRatesAddlinfo() throws SQLException{
        //System.out.println("Start testSelectAllIcRateCode");
    
         List<IcRatesAddlInfo>  icRatesAddlInfoList = new ArrayList<IcRatesAddlInfo>();
         
       IcRatesAddlInfoBaseDAO   dao = new IcRatesAddlInfoBaseDAO();
         
         icRatesAddlInfoList = dao.findByWhereCondisions(" ROWNUM < 2");
        
        
        System.out.println("Success testSelectIcRatesAddlinfo");
    }
    public static void testSelectIcRates() throws SQLException{
        //System.out.println("Start testSelectAllIcRateCode");
    
         List<IcRates>  icRatesList = new ArrayList<IcRates>();
         
         IcRatesBaseDAO   dao = new IcRatesBaseDAO();
         
         icRatesList = dao.findByWhereCondisions(" ROWNUM < 2");
        
        
        System.out.println("Success testSelectIcRates");
    }
    public static void testSelectIcRatesSlabs() throws SQLException{
        //System.out.println("Start testSelectAllIcRateCode");
    
         List<IcRatesSlabs>  icRatesSlabsList = new ArrayList<IcRatesSlabs>();
         
         IcRatesBaseDAO   dao = new IcRatesBaseDAO();
         
         icRatesSlabsList = dao.findByWhereCondisions(" ROWNUM < 2");
        
        
        System.out.println("Success testSelectIcRatesSlabs");
    }
    public static void testSelectIcRatingDict() throws SQLException{
        //System.out.println("Start testSelectAllIcRateCode");
    
         List<IcRatingDict>  icRatingDictList = new ArrayList<IcRatingDict>();
         
         IcRatingDictBaseDAO   dao = new IcRatingDictBaseDAO();
         
         icRatingDictList = dao.findByWhereCondisions(" ROWNUM < 2");
        
        
        System.out.println("Success testSelectIcRatingDict");
    }
    
    public static void testSelectIcSubjectVersions() throws SQLException{
        //System.out.println("Start testSelectAllIcRateCode");
    
         List<IcSubjectVersions>  icSubjectVersionsList = new ArrayList<IcSubjectVersions>();
         
         IcSubjectVersionsBaseDAO   dao = new IcSubjectVersionsBaseDAO();
         
         icSubjectVersionsList = dao.findByWhereCondisions(" ROWNUM < 2");
        
        
        System.out.println("Success testSelectIcSubjectVersions");
    }
    public static void testSelectIcgDestinationAddres() throws SQLException{
        //System.out.println("Start testSelectAllIcRateCode");
    
         List<IcgDestinationAddres>  list = new ArrayList<IcgDestinationAddres>();
         
         IcgDestinationAddresBaseDAO   dao = new IcgDestinationAddresBaseDAO();
         
         list = dao.findByWhereCondisions(" ROWNUM < 2");
        
        
        System.out.println("Success testSelectIcgDestinationAddres");
    }
    public static void testSelectIcgDestination() throws SQLException{
        //System.out.println("Start testSelectAllIcRateCode");
    
         List<IcgDestination>  list = new ArrayList<IcgDestination>();
         
         IcgDestinationBaseDAO   dao = new IcgDestinationBaseDAO();
         
         list = dao.findByWhereCondisions(" ROWNUM < 2");
        
        
         System.out.println("Success testSelectIcgDestination");
    }
    public static void testSelectTiticPartnerRef() throws SQLException{
        //System.out.println("Start testSelectAllIcRateCode");
    
         List<TiticPartnerRef>  list = new ArrayList<TiticPartnerRef>();
         
         TiticPartnerRefBaseDAO   dao = new TiticPartnerRefBaseDAO();
         
         list = dao.findByWhereCondisions(" ROWNUM < 2");
        
        
         System.out.println("Success testSelectTiticPartnerRef");
    }
    public static void testSelectMaxRateCdSeq() throws SQLException{
        //System.out.println("Start testSelectAllIcRateCode");
    
         List<TiticPartnerRef>  list = new ArrayList<TiticPartnerRef>();
         
         IcRateCodeBaseDAO   dao = new IcRateCodeBaseDAO();
         
         int result = dao.getMaxRateCdSeq();
        
        
         System.out.println("Success testSelectMaxRateCdSeq :"+result);
    }
    public static void testSelectMaxDescriptionSeq() throws SQLException{
        //System.out.println("Start testSelectAllIcRateCode");
    
         List<TiticPartnerRef>  list = new ArrayList<TiticPartnerRef>();
         
         IcRatingDictBaseDAO   dao = new IcRatingDictBaseDAO();
         
         int result = dao.getMaxDescriptionSeq();
        
        
         System.out.println("Success testSelectMaxDescriptionSeq :"+result);
    }
    
    
}
