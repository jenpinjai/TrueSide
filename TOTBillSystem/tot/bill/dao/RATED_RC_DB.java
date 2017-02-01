package tot.bill.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import tot.bill.service.GetSystemDate;
import tot.bill.table.RATED_RC;


public class RATED_RC_DB {
	public static int UpdateRATED_RC (Connection conn,ArrayList<RATED_RC> stRATED_RC) throws SQLException{
		Statement stmt ;
	    //ResultSet rset = null;
	    String strSQL="";

	    //System.out.println(stPRE_RATED_RC.getACCOUNT_ID());
	    stmt = conn.createStatement();
	    //rset = null;
	    int x=0;
	    for(int i=0;i<stRATED_RC.size();i++){
	    try {
	    	
		    	strSQL="INSERT INTO RATED_RC (" +
		    			"CYCLE_CODE,CYCLE_MONTH,CYCLE_YEAR," +
		    			"ACCOUNT_ID,PRODUCT_TYPE,PRODUCT_NO,PRICE_PLAN," +
		    			"FEATURE_CODE,RC_START_DATE,RC_END_DATE," +
		    			"SYS_CREATION_DATE,CHARGE_AMT" +
		    			") " +
		    			"VALUES (" +
		    			"'"+stRATED_RC.get(i).getCYCLE_CODE()+"','"+stRATED_RC.get(i).getCYCLE_MONTH()+"','"+stRATED_RC.get(i).getCYCLE_YEAR()+"'," +
		    			"'"+stRATED_RC.get(i).getACCOUNT_ID()+"','"+stRATED_RC.get(i).getPRODUCT_TYPE()+"','"+stRATED_RC.get(i).getPRODUCT_NO()+"','"+stRATED_RC.get(i).getPRICE_PLAN()+"'," +
		    			"'"+stRATED_RC.get(i).getFEATURE_CODE()+"',to_date('"+stRATED_RC.get(i).getRC_START_DATE()+"','YYYYMMDDHH24MISS'),to_date('"+stRATED_RC.get(i).getRC_END_DATE()+"','YYYYMMDDHH24MISS')," +
		    			"to_date('"+stRATED_RC.get(i).getSYS_CREATION_DATE()+"','YYYYMMDDHH24MISS'),'"+stRATED_RC.get(i).getCHARGE_AMT()+"'" +
		    			")";
		    	
		    	System.out.println(strSQL);
		    	
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
