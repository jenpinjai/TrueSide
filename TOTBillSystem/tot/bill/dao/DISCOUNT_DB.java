package tot.bill.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import tot.bill.service.GetSystemDate;
import tot.bill.table.DISCOUNT;


public class DISCOUNT_DB {
	public static int UpdateDISCOUNT (Connection conn,ArrayList<DISCOUNT> stDISCOUNT) throws SQLException{
		Statement stmt ;
	    //ResultSet rset = null;
	    String strSQL="";

	    //System.out.println(stPRE_RATED_RC.getACCOUNT_ID());
	    stmt = conn.createStatement();
	    //rset = null;
	    int x=0;
	    for(int i=0;i<stDISCOUNT.size();i++){
	    try {
	    	
		    	strSQL="INSERT INTO DISCOUNT (" +		    			
		    			"CYCLE_CODE,CYCLE_MONTH,CYCLE_YEAR," +
		    			"ACCOUNT_ID,PRODUCT_TYPE,PRODUCT_NO,PRICE_PLAN," +
		    			"FEATURE_CODE,REVENUE_CODE,DISCOUNT_CODE,DISCOUNT_TYPE," +
		    			"SYS_CREATION_DATE,SYS_UPDATE_DATE,DISCOUNT_AMT" +
		    			") " +
		    			"VALUES (" +
		    			"'"+stDISCOUNT.get(i).getCYCLE_CODE()+"','"+stDISCOUNT.get(i).getCYCLE_MONTH()+"','"+stDISCOUNT.get(i).getCYCLE_YEAR()+"'," +
		    			"'"+stDISCOUNT.get(i).getACCOUNT_ID()+"','"+stDISCOUNT.get(i).getPRODUCT_TYPE()+"','"+stDISCOUNT.get(i).getPRODUCT_NO()+"','"+stDISCOUNT.get(i).getPRICE_PLAN()+"'," +
		    			"'"+stDISCOUNT.get(i).getFEATURE_CODE()+"','"+stDISCOUNT.get(i).getREVENUE_CODE()+"','"+stDISCOUNT.get(i).getDISCOUNT_CODE()+"','"+stDISCOUNT.get(i).getDISCOUNT_TYPE()+"'," +
		    			"to_date('"+stDISCOUNT.get(i).getSYS_CREATION_DATE()+"','YYYYMMDDHH24MISS'),to_date('"+stDISCOUNT.get(i).getSYS_UPDATE_DATE()+"','YYYYMMDDHH24MISS'),'"+stDISCOUNT.get(i).getDISCOUNT_AMT()+"'" +		    			
		    			")";
		    	
		    	//System.out.println(strSQL);
		    	
		    	x=x+stmt.executeUpdate(strSQL);
		    	
	    	
	        
	    }catch (SQLException ex) {
               System.out.println("*** SQLException caught ***");
                while (ex != null)
                {
                	System.out.println("Message: " + ex.getMessage ());
                	System.out.println("SQLState: " + ex.getSQLState ());
                	System.out.println("ErrorCode: " + ex.getErrorCode ());
                	ex = ex.getNextException ();
                }
                
        } catch (java.lang.Exception ex) {
        	System.out.println("*** Exception caught *** <br>");
     
	    }finally {
	        
	    }
	    
	    }//for
	    
	    try { 
        	//rset.close(); 
        	stmt.close(); 
        } catch (Exception ignore) {}
	    
		return x;
	}
	
}