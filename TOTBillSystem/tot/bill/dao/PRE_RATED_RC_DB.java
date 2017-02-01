package tot.bill.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import tot.bill.service.GetSystemDate;
import tot.bill.table.PRE_RATED_RC;
import tot.bill.table.SERVICE_FEATURE;


public class PRE_RATED_RC_DB {
	public static int UpdatePRR_LAST_BILL_IND_Y (Connection conn,PRE_RATED_RC stPRE_RATED_RC,Double charge_amt,SERVICE_FEATURE stSERVICE_FEATURE) throws SQLException{
		Statement stmt ;
	    //ResultSet rset = null;
	    String strSQL="";
	    
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.ENGLISH);
	    Calendar cal = Calendar.getInstance();
		//System.out.println(dateFormat.format(cal.getTime()));
		String sysDateTime=dateFormat.format(cal.getTime());
 
	    //System.out.println(stPRE_RATED_RC.getACCOUNT_ID());
	    stmt = conn.createStatement();
	    //rset = null;
	    int x=0;
	    try {
	    	strSQL="update PRE_RATED_RC set LAST_BILL_IND='Y',CHARGE_AMT='"+charge_amt+"'," +
	    			"SYS_UPDATE_DATE=to_date('"+sysDateTime+"','YYYYMMDDHH24MISS') " +
	    			"where ACCOUNT_ID='"+stSERVICE_FEATURE.getACCOUNT_ID()+"' " +
	    			"and PRODUCT_TYPE='"+stSERVICE_FEATURE.getPRODUCT_TYPE()+"' " +
	    			"and PRODUCT_NO='"+stSERVICE_FEATURE.getPRODUCT_NO()+"' " +
	    			"and CYCLE_CODE='"+stPRE_RATED_RC.getCYCLE_CODE()+"' " +
	    			"and PRICE_PLAN='"+stSERVICE_FEATURE.getPRICE_PLAN()+"' " +
	    			"and FEATURE_CODE='"+stSERVICE_FEATURE.getFEATURE_CODE()+"'";
	    	System.out.println(strSQL);
	    	//rset = stmt.executeQuery(strSQL);
	    	x=stmt.executeUpdate(strSQL);
	    	//conn.setAutoCommit(false);
	    	//conn.commit();
	    	//conn.rollback();
	        
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
	        try { 
	        	//rset.close(); 
	        	stmt.close(); 
	        } catch (Exception ignore) {}
	    }
	    
		return x;
	}
	public static int UpdatePRR_FIRST_BILL_IND_N (Connection conn,PRE_RATED_RC stPRE_RATED_RC,Double charge_amt,SERVICE_FEATURE stSERVICE_FEATURE) throws SQLException{
		Statement stmt ;
	   // ResultSet rset = null;
	    String strSQL="";
	    
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.ENGLISH);
	    Calendar cal = Calendar.getInstance();
		//System.out.println(dateFormat.format(cal.getTime()));
		String sysDateTime=dateFormat.format(cal.getTime());
 
	    //System.out.println(stPRE_RATED_RC.getACCOUNT_ID());
	    stmt = conn.createStatement();
	    //rset = null;
	    int x=0;
	    try {
	    	strSQL="update PRE_RATED_RC set FIRST_BILL_IND='N',CHARGE_AMT='"+charge_amt+"'," +
	    			"SYS_UPDATE_DATE=to_date('"+sysDateTime+"','YYYYMMDDHH24MISS') " +
	    			"where ACCOUNT_ID='"+stSERVICE_FEATURE.getACCOUNT_ID()+"' " +
	    			"and PRODUCT_TYPE='"+stSERVICE_FEATURE.getPRODUCT_TYPE()+"' " +
	    			"and PRODUCT_NO='"+stSERVICE_FEATURE.getPRODUCT_NO()+"' " +
	    			"and CYCLE_CODE='"+stPRE_RATED_RC.getCYCLE_CODE()+"' " +
	    			"and PRICE_PLAN='"+stSERVICE_FEATURE.getPRICE_PLAN()+"' " +
	    			"and FEATURE_CODE='"+stSERVICE_FEATURE.getFEATURE_CODE()+"'";
	    	System.out.println(strSQL);
	   
	    	x=stmt.executeUpdate(strSQL);
	    	
	    			
	    	//conn.setAutoCommit(false);
	    	//conn.commit();
	    	//conn.rollback();
	        
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
	        try { 
	        	//rset.close(); 
	        	stmt.close(); 
	        } catch (Exception ignore) {}
	    }
	    
		return x;
	}
	public static int UpdatePRR_IGNORE_IND_D (Connection conn,PRE_RATED_RC stPRE_RATED_RC) throws SQLException{
		Statement stmt ;
	   // ResultSet rset = null;
	    String strSQL="";
	    
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.ENGLISH);
	    Calendar cal = Calendar.getInstance();
		//System.out.println(dateFormat.format(cal.getTime()));
		String sysDateTime=dateFormat.format(cal.getTime());
 
	    //System.out.println(stPRE_RATED_RC.getACCOUNT_ID());
	    stmt = conn.createStatement();
	    //rset = null;
	    int x=0;
	    try {
	    	strSQL="update PRE_RATED_RC set IGNORE_IND='D'," +
	    			"SYS_UPDATE_DATE=to_date('"+sysDateTime+"','YYYYMMDDHH24MISS') " +
	    			"where ACCOUNT_ID='"+stPRE_RATED_RC.getACCOUNT_ID()+"' " +
	    			"and PRODUCT_TYPE='"+stPRE_RATED_RC.getPRODUCT_TYPE()+"' " +
	    			"and PRODUCT_NO='"+stPRE_RATED_RC.getPRODUCT_NO()+"' " +
	    			"and CYCLE_CODE='"+stPRE_RATED_RC.getCYCLE_CODE()+"' " +
	    			"and PRICE_PLAN='"+stPRE_RATED_RC.getPRICE_PLAN()+"' " +
	    			"and FEATURE_CODE='"+stPRE_RATED_RC.getFEATURE_CODE()+"'";
	    	System.out.println(strSQL);
	   
	    	x=stmt.executeUpdate(strSQL);
	    	
	    			
	    	//conn.setAutoCommit(false);
	    	//conn.commit();
	    	//conn.rollback();
	        
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
	        try { 
	        	//rset.close(); 
	        	stmt.close(); 
	        } catch (Exception ignore) {}
	    }
	    
		return x;
	}
	public static int InsertPRR_FIRST_BILL_IND_Y (Connection conn,String ACCOUNT_ID,String PRODUCT_TYPE,
			String PRODUCT_NO,String CYCLE_CODE,String PRICE_PLAN,String FEATURE_CODE,
			Double CHARGE_AMT) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.ENGLISH);
	    Calendar cal = Calendar.getInstance();
		//System.out.println(dateFormat.format(cal.getTime()));
		String sysDateTime=dateFormat.format(cal.getTime());
 
	   
	    stmt = conn.createStatement();
	    rset = null;
	    int x=0;
	    try {
	    	strSQL="INSERT INTO PRE_RATED_RC (ACCOUNT_ID,PRODUCT_TYPE,PRODUCT_NO" +
	    			",CYCLE_CODE,PRICE_PLAN,FEATURE_CODE,SYS_CREATION_DATE,CHARGE_AMT,FIRST_BILL_IND) " +
	    			"VALUES (" +
	    			"'"+ACCOUNT_ID+"'," +
	    			"'"+PRODUCT_TYPE+"'," +
	    			"'"+PRODUCT_NO+"'," +
	    			"'"+CYCLE_CODE+"'," +
	    			"'"+PRICE_PLAN+"'," +
	    			"'"+FEATURE_CODE+"'," +
	    			"to_date('"+sysDateTime+"','YYYYMMDDHH24MISS')," +
	    			"'"+CHARGE_AMT+"'," +
	    			"'Y')";
	    	System.out.println(strSQL);
	    	
	    	//rset = stmt.executeQuery(strSQL);
	    	x=stmt.executeUpdate(strSQL);
	    	//conn.setAutoCommit(false);
	    	//conn.commit();
	    	//conn.rollback();
	        
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
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
		return x;
	}
	public static int InsertPRR_LAST_BILL_IND_Y (Connection conn,String ACCOUNT_ID,String PRODUCT_TYPE,
			String PRODUCT_NO,String CYCLE_CODE,String PRICE_PLAN,String FEATURE_CODE,
			Double CHARGE_AMT) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.ENGLISH);
	    Calendar cal = Calendar.getInstance();
		//System.out.println(dateFormat.format(cal.getTime()));
		String sysDateTime=dateFormat.format(cal.getTime());
 
	   
	    stmt = conn.createStatement();
	    rset = null;
	    int x=0;
	    try {
	    	strSQL="INSERT INTO PRE_RATED_RC (ACCOUNT_ID,PRODUCT_TYPE,PRODUCT_NO" +
	    			",CYCLE_CODE,PRICE_PLAN,FEATURE_CODE,SYS_CREATION_DATE,CHARGE_AMT,LAST_BILL_IND) " +
	    			"VALUES (" +
	    			"'"+ACCOUNT_ID+"'," +
	    			"'"+PRODUCT_TYPE+"'," +
	    			"'"+PRODUCT_NO+"'," +
	    			"'"+CYCLE_CODE+"'," +
	    			"'"+PRICE_PLAN+"'," +
	    			"'"+FEATURE_CODE+"'," +
	    			"to_date('"+sysDateTime+"','YYYYMMDDHH24MISS')," +
	    			"'"+CHARGE_AMT+"'," +
	    			"'Y')";
	    	System.out.println(strSQL);
	    	
	    	//rset = stmt.executeQuery(strSQL);
	    	x=stmt.executeUpdate(strSQL);
	    	//conn.setAutoCommit(false);
	    	//conn.commit();
	    	//conn.rollback();
	        
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
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
		return x;
	}
	public static int InsertPRR_FIRST_BILL_IND (Connection conn,String ACCOUNT_ID,String PRODUCT_TYPE,
			String PRODUCT_NO,String CYCLE_CODE,String PRICE_PLAN,String FEATURE_CODE,
			Double CHARGE_AMT) throws SQLException{
		Statement stmt ;
	    //ResultSet rset = null;
	    String strSQL="";
	    
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.ENGLISH);
	    Calendar cal = Calendar.getInstance();
		//System.out.println(dateFormat.format(cal.getTime()));
		String sysDateTime=dateFormat.format(cal.getTime());
 
	   
	    stmt = conn.createStatement();
	    //rset = null;
	    int x=0;
	    try {
	    	strSQL="INSERT INTO PRE_RATED_RC (ACCOUNT_ID,PRODUCT_TYPE,PRODUCT_NO" +
	    			",CYCLE_CODE,PRICE_PLAN,FEATURE_CODE,SYS_CREATION_DATE,CHARGE_AMT) " +
	    			"VALUES (" +
	    			"'"+ACCOUNT_ID+"'," +
	    			"'"+PRODUCT_TYPE+"'," +
	    			"'"+PRODUCT_NO+"'," +
	    			"'"+CYCLE_CODE+"'," +
	    			"'"+PRICE_PLAN+"'," +
	    			"'"+FEATURE_CODE+"'," +
	    			"to_date('"+sysDateTime+"','YYYYMMDDHH24MISS')," +
	    			"'"+CHARGE_AMT+"'" +
	    			")";
	    	System.out.println(strSQL);
	    	
	    	//rset = stmt.executeQuery(strSQL);
	    	x=stmt.executeUpdate(strSQL);
	    	//conn.setAutoCommit(false);
	    	//conn.commit();
	    	//conn.rollback();
	        
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
	        try { 
	        	//rset.close(); 
	        	stmt.close(); 
	        } catch (Exception ignore) {}
	    }
	    
		return x;
	}
	
	
}
