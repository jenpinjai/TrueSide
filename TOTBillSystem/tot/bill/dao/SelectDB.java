package tot.bill.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tot.bill.table.*;


public class SelectDB {
	public static int selectSERVICE_FEATURE (Connection conn, ArrayList<String> idSERVICE_FEATURE,ArrayList<SERVICE_FEATURE> stSERVICE_FEATURE) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
	    	strSQL="select " +
	    			"ACCOUNT_ID," +
	    			"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
	    			"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
	    			"PRODUCT_TYPE," +
	    			"PRODUCT_NO," +
	    			"PRICE_PLAN," +
	    			"FEATURE_CODE," +
	    			"to_char(EFFECTIVE_DATE,'YYYYMMDD')," +
	    			"to_char(EXPIRATION_DATE,'YYYYMMDD')," +
	    			"FIRST_VAR_RATE_QTY," +
	    			"to_char(ISSUE_DATE,'YYYYMMDD')" +
	    			" from SERVICE_FEATURE order by ACCOUNT_ID";
	    	//System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	        while (rset.next()){                            
	        	idSERVICE_FEATURE.add(rset.getString("ACCOUNT_ID"));
	        	stSERVICE_FEATURE.add(new SERVICE_FEATURE(
	        			rset.getString("ACCOUNT_ID"),
	        			rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"),
	        			rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"),
	        			rset.getString("PRODUCT_TYPE"),
	        			rset.getString("PRODUCT_NO"),
	        			rset.getString("PRICE_PLAN"),
	        			rset.getString("FEATURE_CODE"),
	        			rset.getString("to_char(EFFECTIVE_DATE,'YYYYMMDD')"),
	        			rset.getString("to_char(EXPIRATION_DATE,'YYYYMMDD')"),
	        			rset.getInt("FIRST_VAR_RATE_QTY"),
	        			rset.getString("to_char(ISSUE_DATE,'YYYYMMDD')")
	        			));
	        	
	        }
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
	public static int selectSERVICE_FEATURE_ByACL (Connection conn, ArrayList<String> idSERVICE_FEATURE,ArrayList<SERVICE_FEATURE> stSERVICE_FEATURE,String ACCOUNT_LIST) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
	    	strSQL="select " +
	    			"a.ACCOUNT_ID," +
	    			"to_char(a.SYS_CREATION_DATE,'YYYYMMDD')," +
	    			"to_char(a.SYS_UPDATE_DATE,'YYYYMMDD')," +
	    			"a.PRODUCT_TYPE," +
	    			"a.PRODUCT_NO," +
	    			"a.PRICE_PLAN," +
	    			"a.FEATURE_CODE," +
	    			"to_char(a.EFFECTIVE_DATE,'YYYYMMDD')," +
	    			"to_char(a.EXPIRATION_DATE,'YYYYMMDD')," +
	    			"a.FIRST_VAR_RATE_QTY," +
	    			"to_char(a.ISSUE_DATE,'YYYYMMDD')" +
	    			" from SERVICE_FEATURE a,"+ACCOUNT_LIST+" b where a.ACCOUNT_ID=b.ACCOUNT_ID order by a.ACCOUNT_ID";
	    	System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	        while (rset.next()){                            
	        	idSERVICE_FEATURE.add(rset.getString("ACCOUNT_ID"));
	        	stSERVICE_FEATURE.add(new SERVICE_FEATURE(
	        			rset.getString("ACCOUNT_ID"),
	        			rset.getString("to_char(a.SYS_CREATION_DATE,'YYYYMMDD')"),
	        			rset.getString("to_char(a.SYS_UPDATE_DATE,'YYYYMMDD')"),
	        			rset.getString("PRODUCT_TYPE"),
	        			rset.getString("PRODUCT_NO"),
	        			rset.getString("PRICE_PLAN"),
	        			rset.getString("FEATURE_CODE"),
	        			rset.getString("to_char(a.EFFECTIVE_DATE,'YYYYMMDD')"),
	        			rset.getString("to_char(a.EXPIRATION_DATE,'YYYYMMDD')"),
	        			rset.getInt("FIRST_VAR_RATE_QTY"),
	        			rset.getString("to_char(a.ISSUE_DATE,'YYYYMMDD')")
	        			));
	        	
	        }
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
	
	public static int selectCYCLE_CONTROL (Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<CYCLE_CONTROL> stCYCLE_CONTROL) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"to_char(CYCLE_START_DATE,'YYYYMMDD')," +
    				"to_char(CYCLE_END_DATE,'YYYYMMDD')," +
    				"CYCLE_RUN_STATUS , " +
    				"to_char(CYCLE_STATUS_DATE,'YYYYMMDD')," +
    				"ACCT_LIST_NAME," +
    				"USG_BUCKET," +
    				"ACCUM_BUCKET," +
    				"to_char(CYCLE_DUE_DATE,'YYYYMMDD')," +
    				"to_char(DD_DUE_DATE,'YYYYMMDD') " +
    				"from cycle_control where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"'";
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
                stCYCLE_CONTROL.add(new CYCLE_CONTROL(
                		rset.getString("CYCLE_CODE"), 
                		rset.getString("CYCLE_YEAR"), 
                		rset.getString("CYCLE_MONTH"), 
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(CYCLE_START_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(CYCLE_END_DATE,'YYYYMMDD')"), 
                		rset.getString("CYCLE_RUN_STATUS"), 
                		rset.getString("to_char(CYCLE_STATUS_DATE,'YYYYMMDD')"), 
                		rset.getString("ACCT_LIST_NAME"), 
                		rset.getString("USG_BUCKET"),
                		rset.getString("ACCUM_BUCKET"),
                		rset.getString("to_char(CYCLE_DUE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(DD_DUE_DATE,'YYYYMMDD')") 
                		));  
            	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	
	public static int selectACCOUNT_LIST_XX (Connection conn,String tableName,ArrayList<String> idACCOUNT_LIST_XX,ArrayList<ACCOUNT_LIST_XX> stACCOUNT_LIST_XX) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
        	strSQL="select " +
        			"ACCOUNT_ID,"+
        			"to_char(SYS_CREATION_DATE,'YYYYMMDD'),"+
        			"to_char(SYS_UPDATE_DATE,'YYYYMMDD'),"+
        			"ACCOUNT_TYPE,"+
        			"ACCOUNT_SUB_TYPE,"+
        			"AR_BALANCE,"+
        			"ACCOUNT_STATUS,"+
        			"to_char(STATUS_LAST_DATE,'YYYYMMDD'),"+
        			"STATUS_ACTV_RSN_CODE,"+
        			"WRITE_OFF_IND,"+
        			"CYCLE_CODE,"+
        			"TAX_CODE,"+
        			"PYM_MTD,"+
        			"IDENTITY_TYPE,"+
        			"IDENTITY,"+
        			"PAYER_IND,"+
        			"PARENT_ACCOUNT_ID,"+
        			"GOVERNMENT_CODE,"+
        			"SUB_GOV_CODE,"+
        			"DEPOSIT_BALANCE_AMT,"+
        			"DEPOSIT_REFUND_CHOICE,"+
        			"to_char(DEPOSIT_STS_DATE,'YYYYMMDD'),"+
        			"CUST_TAX_ID,"+
        			"CUST_BRANCH_NO,"+
        			"LAST_CYCLE_MONTH,"+
        			"LAST_CYCLE_YEAR,"+
        			"BILL_RUN_STATUS,"+
        			"to_char(BILL_COMPLETE_DATE,'YYYYMMDD')," +
        			"PROFILE_CHANGE_IND,"+
        			"PRINT_CATEGORY "+
        			"from "+tableName+" order by ACCOUNT_ID";

        	//System.out.println(strSQL);
        	rset = stmt.executeQuery(strSQL);
                		
                while (rset.next()){
                	idACCOUNT_LIST_XX.add(rset.getString("ACCOUNT_ID"));   
                	stACCOUNT_LIST_XX.add(new ACCOUNT_LIST_XX(
                			rset.getString("ACCOUNT_ID"), 
                			rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"),
                			rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"),
                			rset.getString("ACCOUNT_TYPE"),
                			rset.getString("ACCOUNT_SUB_TYPE"),
                			rset.getString("AR_BALANCE"),
                			rset.getString("ACCOUNT_STATUS"),
                			rset.getString("to_char(STATUS_LAST_DATE,'YYYYMMDD')"),
                			rset.getString("STATUS_ACTV_RSN_CODE"),
                			rset.getString("WRITE_OFF_IND"),
                			rset.getString("CYCLE_CODE"),
                			rset.getString("TAX_CODE"),
                			rset.getString("PYM_MTD"),
                			rset.getString("IDENTITY_TYPE"),
                			rset.getString("IDENTITY"),
                			rset.getString("PAYER_IND"),
                			rset.getString("PARENT_ACCOUNT_ID"),
                			rset.getString("GOVERNMENT_CODE"),
                			rset.getString("SUB_GOV_CODE"),
                			rset.getString("DEPOSIT_BALANCE_AMT"),
                			rset.getString("DEPOSIT_REFUND_CHOICE"),
                			rset.getString("to_char(DEPOSIT_STS_DATE,'YYYYMMDD')"),
                			rset.getString("CUST_TAX_ID"),
                			rset.getString("CUST_BRANCH_NO"),
                			rset.getString("LAST_CYCLE_MONTH"),
                			rset.getString("LAST_CYCLE_YEAR"),
                			rset.getString("BILL_RUN_STATUS"),
                			rset.getString("to_char(BILL_COMPLETE_DATE,'YYYYMMDD')"),
                			rset.getString("PROFILE_CHANGE_IND"),
                			rset.getString("PRINT_CATEGORY")
                			));
		
                	
                }
                
                

        }finally {
                try { rset.close(); stmt.close(); } catch (Exception ignore) {}
        }
        
	    
	    
	    return 0;
	}
	public static int selectPRE_RATED_RC (Connection conn,String CYCLE_CODE,ArrayList<String> idPRE_RATED_RC,ArrayList<PRE_RATED_RC> stPRE_RATED_RC) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {               
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"PRODUCT_TYPE," +
    				"PRODUCT_NO," +
    				"CYCLE_CODE," +
    				"PRICE_PLAN," +
    				"FEATURE_CODE," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"CHARGE_AMT," +
    				"FIRST_BILL_IND," +
    				"LAST_BILL_IND," +
    				"IGNORE_IND " +
    				"from PRE_RATED_RC where CYCLE_CODE='"+CYCLE_CODE+"' order by ACCOUNT_ID ";

            rset = stmt.executeQuery(strSQL);
    		
            while (rset.next()){
            	idPRE_RATED_RC.add(rset.getString("ACCOUNT_ID"));  
            	stPRE_RATED_RC.add(new PRE_RATED_RC(
            			rset.getString("ACCOUNT_ID"), 
            			rset.getString("PRODUCT_TYPE"), 
            			rset.getString("PRODUCT_NO"), 
            			rset.getString("CYCLE_CODE"), 
            			rset.getString("PRICE_PLAN"), 
            			rset.getString("FEATURE_CODE"), 
            			rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
            			rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
            			rset.getString("CHARGE_AMT"), 
            			rset.getString("FIRST_BILL_IND"), 
            			rset.getString("LAST_BILL_IND"), 
            			rset.getString("IGNORE_IND")
            			));
            	
            }

    }finally {
            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
    }
    
	    
	    return 0;
	}
	public static int selectPRE_RATED_RC_NO_D (Connection conn,String CYCLE_CODE,ArrayList<String> idPRE_RATED_RC,ArrayList<PRE_RATED_RC> stPRE_RATED_RC) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {               
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"PRODUCT_TYPE," +
    				"PRODUCT_NO," +
    				"CYCLE_CODE," +
    				"PRICE_PLAN," +
    				"FEATURE_CODE," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"CHARGE_AMT," +
    				"FIRST_BILL_IND," +
    				"LAST_BILL_IND," +
    				"IGNORE_IND " +
    				"from PRE_RATED_RC where CYCLE_CODE='"+CYCLE_CODE+"' and IGNORE_IND is null  order by ACCOUNT_ID ";

            rset = stmt.executeQuery(strSQL);
    		
            while (rset.next()){
            	idPRE_RATED_RC.add(rset.getString("ACCOUNT_ID"));  
            	stPRE_RATED_RC.add(new PRE_RATED_RC(
            			rset.getString("ACCOUNT_ID"), 
            			rset.getString("PRODUCT_TYPE"), 
            			rset.getString("PRODUCT_NO"), 
            			rset.getString("CYCLE_CODE"), 
            			rset.getString("PRICE_PLAN"), 
            			rset.getString("FEATURE_CODE"), 
            			rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
            			rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
            			rset.getString("CHARGE_AMT"), 
            			rset.getString("FIRST_BILL_IND"), 
            			rset.getString("LAST_BILL_IND"), 
            			rset.getString("IGNORE_IND")
            			));
            	
            }

    }finally {
            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
    }
    
	    
	    return 0;
	}
	public static int selectRC_RATE (Connection conn,ArrayList<String> idRC_RATE,ArrayList<RC_RATE> stRC_RATE) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try { 
    		strSQL="select " +
    				"PRICE_PLAN,"+
    				"FEATURE_CODE,"+
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD'),"+
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD'),"+
    				"to_char(EFFECTIVE_DATE,'YYYYMMDD'),"+
    				"to_char(EXPIRATION_DATE,'YYYYMMDD'),"+
    				"RATE "+
    				"from RC_RATE order by PRICE_PLAN ";
    		//System.out.println(strSQL);
            rset = stmt.executeQuery(strSQL);
    		
            while (rset.next()){
            	idRC_RATE.add(rset.getString("PRICE_PLAN"));  
            	stRC_RATE.add(new RC_RATE(
            			rset.getString("PRICE_PLAN"), 
            			rset.getString("FEATURE_CODE"), 
            			rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
            			rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
            			rset.getString("to_char(EFFECTIVE_DATE,'YYYYMMDD')"), 
            			rset.getString("to_char(EXPIRATION_DATE,'YYYYMMDD')"), 
            			Double.parseDouble(rset.getString("RATE"))
            			));
            	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
        
	    
	    
	    return 0;
	}
	public static int selectSERVICE_DISCOUNT (Connection conn, ArrayList<String> idSERVICE_DISCOUNT,ArrayList<SERVICE_DISCOUNT> stSERVICE_DISCOUNT) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
	    	strSQL="select " +	    
					"ACCOUNT_ID," +
					"PRODUCT_TYPE," +
					"PRODUCT_NO," +
					"DISCOUNT_CODE," +
					"DISCOUNT_TYPE," +
					"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
					"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
					"to_char(EFFECTIVE_DATE,'YYYYMMDD')," +
	    			"to_char(EXPIRATION_DATE,'YYYYMMDD')" +
	    			" from SERVICE_DISCOUNT order by ACCOUNT_ID";
	    	//System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	        while (rset.next()){                            
	        	idSERVICE_DISCOUNT.add(rset.getString("ACCOUNT_ID"));
	        	
	        	stSERVICE_DISCOUNT.add(new SERVICE_DISCOUNT(
	        			rset.getString("ACCOUNT_ID"), 
	        			rset.getString("PRODUCT_TYPE"), 
	        			rset.getString("PRODUCT_NO"), 
	        			rset.getString("DISCOUNT_CODE"), 
	        			rset.getString("DISCOUNT_TYPE"), 
	        			rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
	        			rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
	        			rset.getString("to_char(EFFECTIVE_DATE,'YYYYMMDD')"), 
	        			rset.getString("to_char(EXPIRATION_DATE,'YYYYMMDD')")
	        			));
	        	
	        	
	        }
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
	public static int selectDISCOUNT_RATE (Connection conn, ArrayList<String> idDISCOUNT_RATE,ArrayList<DISCOUNT_RATE> stDISCOUNT_RATE) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
	    	strSQL="select " +	 
	    			"DISCOUNT_CODE," +
	    			"DISCOUNT_TYPE," +
	    			"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
	    			"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
	    			"REVENUE_CODE," +
	    			"PLAN_RANK," +
	    			"DISCOUNT_VALUE," +
	    			"DISCOUNT_MAX" +
	    			" from DISCOUNT_RATE order by DISCOUNT_CODE,DISCOUNT_TYPE ";
	    	//System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	        while (rset.next()){                            
	        	idDISCOUNT_RATE.add(rset.getString("DISCOUNT_CODE")+rset.getString("DISCOUNT_TYPE")+rset.getString("REVENUE_CODE"));
	        	stDISCOUNT_RATE.add(new DISCOUNT_RATE(
	        			rset.getString("DISCOUNT_CODE"), 
	        			rset.getString("DISCOUNT_TYPE"), 	        			
	        			rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
	        			rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
	        			rset.getString("REVENUE_CODE"), 
	        			rset.getString("PLAN_RANK"), 
	        			rset.getString("DISCOUNT_VALUE"), 	
	        			rset.getString("DISCOUNT_MAX")	        			
	        			));
	        	
	        	
	        }
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
	public static int selectACCUM_USAGE_XX (Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,String tableName,ArrayList<String> idACCUM_USAGE_XX,ArrayList<ACCUM_USAGE_XX> stACCUM_USAGE_XX) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"ACCOUNT_ID," +
    				"PRODUCT_TYPE," +
    				"PRODUCT_NO," +
    				"PRICE_PLAN," +
    				"FEATURE_CODE," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"CHARGE_AMT," +
    				"INCLUSIVE_IND," +
    				"TOTAL_NUMBER_OF_CALLS " +
    				"from "+tableName+" where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' order by ACCOUNT_ID";
    		System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idACCUM_USAGE_XX.add(rset.getString("ACCOUNT_ID"));
                stACCUM_USAGE_XX.add(new ACCUM_USAGE_XX(
                		rset.getString("CYCLE_CODE"), 
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("ACCOUNT_ID"), 
                		rset.getString("PRODUCT_TYPE"), 
                		rset.getString("PRODUCT_NO"),
                		rset.getString("PRICE_PLAN"),
                		rset.getString("FEATURE_CODE"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"),
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("CHARGE_AMT"),
                		rset.getString("INCLUSIVE_IND"),
                		rset.getString("TOTAL_NUMBER_OF_CALLS")
                		));
            	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectRATED_RC (Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<String> idRATED_RC,ArrayList<RATED_RC> stRATED_RC ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"CYCLE_CODE," +    				
    				"CYCLE_MONTH," +
    				"CYCLE_YEAR," +
    				"ACCOUNT_ID," +
    				"PRODUCT_TYPE," +
    				"PRODUCT_NO," +
    				"PRICE_PLAN," +
    				"FEATURE_CODE," +
    				"to_char(RC_START_DATE,'YYYYMMDD')," +
    				"to_char(RC_END_DATE,'YYYYMMDD')," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"CHARGE_AMT " +
    				"from RATED_RC where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' order by ACCOUNT_ID";
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idRATED_RC.add(rset.getString("ACCOUNT_ID"));
                stRATED_RC.add(new RATED_RC(
                		rset.getString("CYCLE_CODE"),  
                		rset.getString("CYCLE_MONTH"),  
                		rset.getString("CYCLE_YEAR"),  
                		rset.getString("ACCOUNT_ID"),  
                		rset.getString("PRODUCT_TYPE"),  
                		rset.getString("PRODUCT_NO"),  
                		rset.getString("PRICE_PLAN"), 
                		rset.getString("FEATURE_CODE"),  
                		rset.getString("to_char(RC_START_DATE,'YYYYMMDD')"),  
                		rset.getString("to_char(RC_END_DATE,'YYYYMMDD')"),  
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"),  
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"),  
                		rset.getString("CHARGE_AMT")
                		));
            	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectTAX_RATE (Connection conn,ArrayList<TAX_RATE> stTAX_RATE) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
	    	strSQL="select " +
	    			"TAX_CODE," +
	    			"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
	    			"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
	    			"TAX_RATE" +	    			
	    			" from TAX_RATE ";
	    	//System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	        while (rset.next()){                            
	        	
	        	stTAX_RATE.add(new TAX_RATE(	        				        			
	        			rset.getString("TAX_CODE"),
	        			rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"),
	        			rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"),
	        			rset.getString("TAX_RATE")
	        			));
	        	
	        }
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
	public static String selectLOGICAL_DATE (Connection conn,String logical_date) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
	    	strSQL="select to_char(max(logical_date),'YYYYMMDD') LOGICAL_DATE from logical_date";
	    	//System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	        while (rset.next()){                            
	        	
	        	logical_date=rset.getString("LOGICAL_DATE");
	        	
	        }
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return logical_date;
	}
	public static int selectDISCOUNT(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR, ArrayList<String> idDISCOUNT,ArrayList<DISCOUNT> stDISCOUNT) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
	    	strSQL="select " +
	    			"CYCLE_CODE," +
	    			"CYCLE_MONTH," +
	    			"CYCLE_YEAR," +
	    			"ACCOUNT_ID," +
	    			"PRODUCT_TYPE," +
	    			"PRODUCT_NO," +
	    			"PRICE_PLAN," +
	    			"FEATURE_CODE," +
	    			"REVENUE_CODE," +
	    			"DISCOUNT_CODE," +
	    			"DISCOUNT_TYPE," +
	    			"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
	    			"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
	    			"DISCOUNT_AMT" +
	    			" from DISCOUNT where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' order by ACCOUNT_ID";	    			
	    			
	    	//System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	        while (rset.next()){                            
	        	idDISCOUNT.add(rset.getString("ACCOUNT_ID"));
	        	stDISCOUNT.add(new DISCOUNT(
	        			rset.getString("CYCLE_CODE"),
	        			rset.getString("CYCLE_MONTH"),
	        			rset.getString("CYCLE_YEAR"),
	        			rset.getString("ACCOUNT_ID"),
	        			rset.getString("PRODUCT_TYPE"),
	        			rset.getString("PRODUCT_NO"),
	        			rset.getString("PRICE_PLAN"),
	        			rset.getString("FEATURE_CODE"),
	        			rset.getString("REVENUE_CODE"),
	        			rset.getString("DISCOUNT_CODE"),
	        			rset.getString("DISCOUNT_TYPE"),
	        			rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
	        			rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
	        			rset.getString("DISCOUNT_AMT")
	        			));
     	
	        }
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
	public static int selectFEATURE (Connection conn,ArrayList<String> idFEATURE,ArrayList<FEATURE> stFEATURE ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"FEATURE_CODE," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"FEATURE_DESC," +
    				"CHARGE_DESC," +
    				"CATEGORY_CODE," +
    				"to_char(EFFECTIVE_DATE,'YYYYMMDD')," +
    				"to_char(EXPIRATION_DATE,'YYYYMMDD')" +
    				" from FEATURE order by FEATURE_CODE ";

    				
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idFEATURE.add(rset.getString("FEATURE_CODE"));
                stFEATURE.add(new FEATURE(
                		rset.getString("FEATURE_CODE"), 
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"),  
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"),  
                		rset.getString("FEATURE_DESC"), 
                		rset.getString("CHARGE_DESC"), 
                		rset.getString("CATEGORY_CODE"),  
                		rset.getString("to_char(EFFECTIVE_DATE,'YYYYMMDD')"),  
                		rset.getString("to_char(EXPIRATION_DATE,'YYYYMMDD')") 
                		)); 		
            	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectCUSTOMER_ACCOUNT (Connection conn,String CYCLE_CODE,ArrayList<String> idCUSTOMER_ACCOUNT,ArrayList<CUSTOMER_ACCOUNT> stCUSTOMER_ACCOUNT ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"ACCOUNT_TYPE," +
    				"ACCOUNT_SUB_TYPE," +
    				"AR_BALANCE," +
    				"ACCOUNT_STATUS," +
    				"to_char(STATUS_LAST_DATE,'YYYYMMDD')," +
    				"STATUS_ACTV_RSN_CODE," +
    				"WRITE_OFF_IND," +
    				"COLLECTION_INDICATOR," +
    				"to_char(COLL_LAST_UPD_DATE,'YYYYMMDD')," +
    				"COL_PATH_CODE," +
    				"COL_NEXT_STEP_NO," +
    				"to_char(COL_NEXT_STEP_DATE,'YYYYMMDD')," +
    				"COL_NEXT_STP_APR_CODE," +
    				"COL_FIXED_PATH," +
    				"CYCLE_CODE," +
    				"TAX_CODE," +
    				"PYM_MTD," +
    				"IDENTITY_TYPE," +
    				"IDENTITY," +
    				"PAYER_IND," +
    				"PARENT_ACCOUNT_ID," +
    				"GOVERNMENT_CODE," +
    				"SUB_GOV_CODE," +
    				"CUST_TAX_ID," +
    				"CUST_BRANCH_NO," +
    				"BILL_RUN_STATUS," +
    				"to_char(BILL_COMPLETE_DATE,'YYYYMMDD')," +
    				"LAST_CYCLE_RUN_YEAR," +
    				"LAST_CYCLE_RUN_MONTH," +
    				"DEPOSIT_BALANCE_AMT," +
    				"DEPOSIT_REFUND_CHOICE," +
    				"to_char(DEPOSIT_STS_DATE,'YYYYMMDD')," +
    				"PRINT_CATEGORY" +
    				" from CUSTOMER_ACCOUNT where CYCLE_CODE='"+CYCLE_CODE+"' order by ACCOUNT_ID ";
		
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idCUSTOMER_ACCOUNT.add(rset.getString("ACCOUNT_ID"));
                stCUSTOMER_ACCOUNT.add(new CUSTOMER_ACCOUNT(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"),  
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"),
                		rset.getString("ACCOUNT_TYPE"),
                		rset.getString("ACCOUNT_SUB_TYPE"),
                		rset.getString("AR_BALANCE"),
                		rset.getString("ACCOUNT_STATUS"),
                		rset.getString("to_char(STATUS_LAST_DATE,'YYYYMMDD')"),
                		rset.getString("STATUS_ACTV_RSN_CODE"),
                		rset.getString("WRITE_OFF_IND"),
                		rset.getString("COLLECTION_INDICATOR"),
                		rset.getString("to_char(COLL_LAST_UPD_DATE,'YYYYMMDD')"),
                		rset.getString("COL_PATH_CODE"),
                		rset.getString("COL_NEXT_STEP_NO"),
                		rset.getString("to_char(COL_NEXT_STEP_DATE,'YYYYMMDD')"),
                		rset.getString("COL_NEXT_STP_APR_CODE"),
                		rset.getString("COL_FIXED_PATH"),
                		rset.getString("CYCLE_CODE"),
                		rset.getString("TAX_CODE"),
                		rset.getString("PYM_MTD"),
                		rset.getString("IDENTITY_TYPE"),
                		rset.getString("IDENTITY"),
                		rset.getString("PAYER_IND"),
                		rset.getString("PARENT_ACCOUNT_ID"),
                		rset.getString("GOVERNMENT_CODE"),
                		rset.getString("SUB_GOV_CODE"),
                		rset.getString("CUST_TAX_ID"),
                		rset.getString("CUST_BRANCH_NO"),
                		rset.getString("BILL_RUN_STATUS"),
                		rset.getString("to_char(BILL_COMPLETE_DATE,'YYYYMMDD')"),
                		rset.getString("LAST_CYCLE_RUN_YEAR"),
                		rset.getString("LAST_CYCLE_RUN_MONTH"),
                		rset.getString("DEPOSIT_BALANCE_AMT"),
                		rset.getString("DEPOSIT_REFUND_CHOICE"),
                		rset.getString("to_char(DEPOSIT_STS_DATE,'YYYYMMDD')"),
                		rset.getString("PRINT_CATEGORY")
                		)); 

            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectBILL (Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<String> idBILL,ArrayList<BILL> stBILL ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"CYCLE_CODE," +
    				"CYCLE_MONTH," +
    				"CYCLE_YEAR," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"to_char(BILL_CREATE_DATE,'YYYYMMDD')," +
    				"to_char(BILL_EXTRACT_DATE,'YYYYMMDD')," +
    				"to_char(BILL_CONFIRM_DATE,'YYYYMMDD')," +
    				"PREVIOUS_AMT," +
    				"PAYMENT_AMT," +
    				"CUR_CHARGE_AMT," +
    				"CUR_CREDIT_AMT," +
    				"CUR_DISCOUNT_AMT," +
    				"CUR_RC_AMT," +
    				"CUR_OC_AMT," +
    				"CUR_UC_AMT," +
    				"TOTAL_CHARGE_AMT," +
    				"TOTAL_TAX_AMT," +
    				"TOTAL_NET_AMT," +
    				"TOTAL_ADJUST_AMT," +
    				"TOTAL_ADJUST_TAX_AMT," +
    				"TOTAL_ADJUST_NET_AMT," + 
    				"OUTSTANDING_AMT," + 
    				"INVOICE_NUMBER ," +
    				"ACCOUNT_TYPE ," +
    				"ACCOUNT_SUB_TYPE ," +
    				"PYM_MTD ," +
    				"BANK_CODE," +
    				"BANK_ACCOUNT_NO," + 
    				"to_char(DUE_DATE,'YYYYMMDD')," +
    				"BILL_TYPE," + 
    				"PRESENT_PRODUCT_NO ," +
    				"BILL_STATUS" + 
    				" from BILL where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' order by ACCOUNT_ID";

    				
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idBILL.add(rset.getString("ACCOUNT_ID"));
                stBILL.add(new BILL(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("CYCLE_CODE"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(BILL_CREATE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(BILL_EXTRACT_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(BILL_CONFIRM_DATE,'YYYYMMDD')"), 
                		rset.getString("PREVIOUS_AMT"),
                		rset.getString("PAYMENT_AMT"),
                		rset.getString("CUR_CHARGE_AMT"),
                		rset.getString("CUR_CREDIT_AMT"),
                		rset.getString("CUR_DISCOUNT_AMT"),
                		rset.getString("CUR_RC_AMT"),
                		rset.getString("CUR_OC_AMT"),
                		rset.getString("CUR_UC_AMT"),
                		rset.getString("TOTAL_CHARGE_AMT"),
                		rset.getString("TOTAL_TAX_AMT"),
                		rset.getString("TOTAL_NET_AMT"),
                		rset.getString("TOTAL_ADJUST_AMT"),
                		rset.getString("TOTAL_ADJUST_TAX_AMT"),  
                		rset.getString("TOTAL_ADJUST_NET_AMT"), 
                		rset.getString("OUTSTANDING_AMT"), 
                		rset.getString("INVOICE_NUMBER"), 
                		rset.getString("ACCOUNT_TYPE"), 
                		rset.getString("ACCOUNT_SUB_TYPE"), 
                		rset.getString("PYM_MTD"), 
                		rset.getString("BANK_CODE"),
                		rset.getString("BANK_ACCOUNT_NO"), 
                		rset.getString("to_char(DUE_DATE,'YYYYMMDD')"), 
                		rset.getString("BILL_TYPE"), 
                		rset.getString("PRESENT_PRODUCT_NO"), 
                		rset.getString("BILL_STATUS")
                		)); 

            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	
	public static int selectCHARGE (Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<String> idCHARGE,ArrayList<CHARGE> stCHARGE ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"CHARGE_SEQ_NO," +
    				"INVOICE_SEQ_NO," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"PRODUCT_TYPE," +
    				"PRODUCT_NO," +
    				"to_char(CHG_CREATION_DATE,'YYYYMMDD')," +
    				"CHARGE_TYPE," +
    				"IMMEDIATE_IND," +
    				"PRICE_PLAN," +
    				"FEATURE_CODE," +
    				"REVENUE_CODE," +
    				"DISCOUNT_CODE," +
    				"CATEGORY_CODE," +
    				"to_char(CHARGE_START_DATE,'YYYYMMDD')," +
    				"to_char(CHARGE_END_DATE,'YYYYMMDD')," +
    				"to_char(ACTV_DATE,'YYYYMMDD')," +
    				"ACTV_AMT," +
    				"TAX_CODE," +
    				"TAX_AMT," +
    				"TOTAL_NUMBER_OF_CALLS" +
    				" from CHARGE where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' order by ACCOUNT_ID";

    				
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idCHARGE.add(rset.getString("ACCOUNT_ID"));
                stCHARGE.add(new CHARGE(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("CHARGE_SEQ_NO"),
                		rset.getString("INVOICE_SEQ_NO"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("CYCLE_CODE"),
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("PRODUCT_TYPE"),
                		rset.getString("PRODUCT_NO"),
                		rset.getString("to_char(CHG_CREATION_DATE,'YYYYMMDD')"),
                		rset.getString("CHARGE_TYPE"),
                		rset.getString("IMMEDIATE_IND"),
                		rset.getString("PRICE_PLAN"),
                		rset.getString("FEATURE_CODE"),
                		rset.getString("REVENUE_CODE"),
                		rset.getString("DISCOUNT_CODE"),
                		rset.getString("CATEGORY_CODE"),
                		rset.getString("to_char(CHARGE_START_DATE,'YYYYMMDD')"),
                		rset.getString("to_char(CHARGE_END_DATE,'YYYYMMDD')"),
                		rset.getString("to_char(ACTV_DATE,'YYYYMMDD')"),
                		rset.getString("ACTV_AMT"),
                		rset.getString("TAX_CODE"),
                		rset.getString("TAX_AMT"),
                		rset.getString("TOTAL_NUMBER_OF_CALLS")
                		));
                
                	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectACCOUNT_PYM_MTD(Connection conn,ArrayList<String> idACCOUNT_PYM_MTD,ArrayList<ACCOUNT_PYM_MTD> stACCOUNT_PYM_MTD) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"PYM_MTD," +
    				"to_char(EFFECTIVE_DATE,'YYYYMMDD')," +
    				"to_char(EXPIRATION_DATE,'YYYYMMDD')," +
    				"DD_BANK_CR_CARD_NO ," +
    				"DD_ACC_NAME ," +
    				"BANK_CODE," +
    				"WITHHOLDING_IND," +
    				"to_char(WITHHOLDING_EFF_DATE,'YYYYMMDD')," +
    				"to_char(WITHHOLDING_EXP_DATE,'YYYYMMDD')," +
    				"WITHHOLDING_TAX_ID" +
    				" from ACCOUNT_PYM_MTD   order by ACCOUNT_ID";

    				
    				
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idACCOUNT_PYM_MTD.add(rset.getString("ACCOUNT_ID"));
                stACCOUNT_PYM_MTD.add(new ACCOUNT_PYM_MTD(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("PYM_MTD"),
                		rset.getString("to_char(EFFECTIVE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(EXPIRATION_DATE,'YYYYMMDD')"), 
                		rset.getString("DD_BANK_CR_CARD_NO"),
                		rset.getString("DD_ACC_NAME"),
                		rset.getString("BANK_CODE"),
                		rset.getString("WITHHOLDING_IND"),
                		rset.getString("to_char(WITHHOLDING_EFF_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(WITHHOLDING_EXP_DATE,'YYYYMMDD')"), 
                		rset.getString("WITHHOLDING_TAX_ID")
                		));

                	
                	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	
	public static int selectACCOUNT_PYM_MTD_ByACL(Connection conn,ArrayList<String> idACCOUNT_PYM_MTD,ArrayList<ACCOUNT_PYM_MTD> stACCOUNT_PYM_MTD,String ACCOUNT_LIST  ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"a.ACCOUNT_ID," +
    				"to_char(a.SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(a.SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"a.PYM_MTD," +
    				"to_char(a.EFFECTIVE_DATE,'YYYYMMDD')," +
    				"to_char(a.EXPIRATION_DATE,'YYYYMMDD')," +
    				"a.DD_BANK_CR_CARD_NO ," +
    				"a.DD_ACC_NAME ," +
    				"a.BANK_CODE," +
    				"a.WITHHOLDING_IND," +
    				"to_char(a.WITHHOLDING_EFF_DATE,'YYYYMMDD')," +
    				"to_char(a.WITHHOLDING_EXP_DATE,'YYYYMMDD')," +
    				"a.WITHHOLDING_TAX_ID" +
    				" from ACCOUNT_PYM_MTD a,"+ACCOUNT_LIST+" b where a.ACCOUNT_ID=b.ACCOUNT_ID order by a.ACCOUNT_ID"; 

    				
    				
    		System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idACCOUNT_PYM_MTD.add(rset.getString("ACCOUNT_ID"));
                stACCOUNT_PYM_MTD.add(new ACCOUNT_PYM_MTD(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("to_char(a.SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(a.SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("PYM_MTD"),
                		rset.getString("to_char(a.EFFECTIVE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(a.EXPIRATION_DATE,'YYYYMMDD')"), 
                		rset.getString("DD_BANK_CR_CARD_NO"),
                		rset.getString("DD_ACC_NAME"),
                		rset.getString("BANK_CODE"),
                		rset.getString("WITHHOLDING_IND"),
                		rset.getString("to_char(a.WITHHOLDING_EFF_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(a.WITHHOLDING_EXP_DATE,'YYYYMMDD')"), 
                		rset.getString("WITHHOLDING_TAX_ID")
                		));

                	
                	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	
	public static int selectPAYMENT_ACTIVITY(Connection conn,ArrayList<String> idPAYMENT_ACTIVITY,ArrayList<PAYMENT_ACTIVITY> stPAYMENT_ACTIVITY ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"PYM_SEQ_NO," +
    				"ACTV_SEQ_NO," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"to_char(ACTV_DATE,'YYYYMMDD')," +
    				"ACTV_CODE," +
    				"ACTV_AMT," +
    				"ACTV_RSN_CODE," +
    				"FNT_ACCOUNT," +
    				"TAX_INV_NUMBER" +
    				" from PAYMENT_ACTIVITY  order by ACCOUNT_ID";

		
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idPAYMENT_ACTIVITY.add(rset.getString("ACCOUNT_ID"));
                stPAYMENT_ACTIVITY.add(new PAYMENT_ACTIVITY(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("PYM_SEQ_NO"),
                		rset.getString("ACTV_SEQ_NO"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(ACTV_DATE,'YYYYMMDD')"), 
                		rset.getString("ACTV_CODE"),
                		rset.getString("ACTV_AMT"),
                		rset.getString("ACTV_RSN_CODE"),
                		rset.getString("FNT_ACCOUNT"),
                		rset.getString("TAX_INV_NUMBER")
                		));

            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectBILL_PRINT_INFO(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<String> idBILL_PRINT_INFO,ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"ZIP_CODE," +
    				"PYM_MTD," +
    				"BILL_TYPE," +
    				"MAX_PAGE," +
    				"NAME," +
    				"ADDRESS1," +
    				"ADDRESS2," +
    				"ADDRESS3," +
    				"ADDRESS4," +
    				"NAME_R," +
    				"ADDRESS1_R," +
    				"ADDRESS2_R," +
    				"ADDRESS3_R," +
    				"ADDRESS4_R," +
    				"PRODUCT_NO," +
    				"INVOICE_NO," +
    				"ACCOUNT_TYPE_DES," +
    				"to_char(BILL_DATE,'YYYYMMDD')," +
    				"PREVIOUS_BALANCE," +
    				"PAID_AMOUNT," +
    				"POST_BILL_ADJUSTMENT," +
    				"TOTAL_CURRENT_CHARGES," +
    				"OUTSTANDING_BALANCE," +
    				"BANK_NAME," +
    				"CREDIT_CARD_NO," +
    				"to_char(DUE_DATE,'YYYYMMDD')," +
    				"to_char(BILL_EXTRACT_DATE,'YYYYMMDD')," +
    				"QA_ACCOUNT_IND," +
    				"BILL_PRINT_IND," +
    				"GOVERNMENT_CODE," +
    				"SUB_GOV_CODE," +
    				"PRINT_CATEGORY" +
    				" from BILL_PRINT_INFO  where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' order by max_page,zip_code,pym_mtd,account_id";
    				
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idBILL_PRINT_INFO.add(rset.getString("ACCOUNT_ID"));
                stBILL_PRINT_INFO.add(new BILL_PRINT_INFO(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("CYCLE_CODE"),
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("ZIP_CODE"),
                		rset.getString("PYM_MTD"), 
                		rset.getString("BILL_TYPE"),
                		rset.getString("MAX_PAGE"),
                		rset.getString("NAME"),
                		rset.getString("ADDRESS1"),
                		rset.getString("ADDRESS2"),
                		rset.getString("ADDRESS3"),
                		rset.getString("ADDRESS4"),
                		rset.getString("NAME_R"),
                		rset.getString("ADDRESS1_R"),
                		rset.getString("ADDRESS2_R"),
                		rset.getString("ADDRESS3_R"),
                		rset.getString("ADDRESS4_R"),
                		rset.getString("PRODUCT_NO"),
                		rset.getString("INVOICE_NO"),
                		rset.getString("ACCOUNT_TYPE_DES"),
                		rset.getString("to_char(BILL_DATE,'YYYYMMDD')"), 
                		rset.getString("PREVIOUS_BALANCE"),
                		rset.getString("PAID_AMOUNT"),
                		rset.getString("POST_BILL_ADJUSTMENT"),
                		rset.getString("TOTAL_CURRENT_CHARGES"),
                		rset.getString("OUTSTANDING_BALANCE"),
                		rset.getString("BANK_NAME"),
                		rset.getString("CREDIT_CARD_NO"),
                		rset.getString("to_char(DUE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(BILL_EXTRACT_DATE,'YYYYMMDD')"), 
                		rset.getString("QA_ACCOUNT_IND"),
                		rset.getString("BILL_PRINT_IND"),
                		rset.getString("GOVERNMENT_CODE"),
                		rset.getString("SUB_GOV_CODE"),
                		rset.getString("PRINT_CATEGORY")
                		));
                	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectBILL_PRINT_INFO_CF(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<String> idBILL_PRINT_INFO,ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"ZIP_CODE," +
    				"PYM_MTD," +
    				"BILL_TYPE," +
    				"MAX_PAGE," +
    				"NAME," +
    				"ADDRESS1," +
    				"ADDRESS2," +
    				"ADDRESS3," +
    				"ADDRESS4," +
    				"NAME_R," +
    				"ADDRESS1_R," +
    				"ADDRESS2_R," +
    				"ADDRESS3_R," +
    				"ADDRESS4_R," +
    				"PRODUCT_NO," +
    				"INVOICE_NO," +
    				"ACCOUNT_TYPE_DES," +
    				"to_char(BILL_DATE,'YYYYMMDD')," +
    				"PREVIOUS_BALANCE," +
    				"PAID_AMOUNT," +
    				"POST_BILL_ADJUSTMENT," +
    				"TOTAL_CURRENT_CHARGES," +
    				"OUTSTANDING_BALANCE," +
    				"BANK_NAME," +
    				"CREDIT_CARD_NO," +
    				"to_char(DUE_DATE,'YYYYMMDD')," +
    				"to_char(BILL_EXTRACT_DATE,'YYYYMMDD')," +
    				"QA_ACCOUNT_IND," +
    				"BILL_PRINT_IND," +
    				"GOVERNMENT_CODE," +
    				"SUB_GOV_CODE," +
    				"PRINT_CATEGORY" +
    				" from BILL_PRINT_INFO  where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' " +
    				"and BILL_PRINT_IND is null order by max_page,zip_code,pym_mtd,account_id";
    				
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idBILL_PRINT_INFO.add(rset.getString("ACCOUNT_ID"));
                stBILL_PRINT_INFO.add(new BILL_PRINT_INFO(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("CYCLE_CODE"),
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("ZIP_CODE"),
                		rset.getString("PYM_MTD"), 
                		rset.getString("BILL_TYPE"),
                		rset.getString("MAX_PAGE"),
                		rset.getString("NAME"),
                		rset.getString("ADDRESS1"),
                		rset.getString("ADDRESS2"),
                		rset.getString("ADDRESS3"),
                		rset.getString("ADDRESS4"),
                		rset.getString("NAME_R"),
                		rset.getString("ADDRESS1_R"),
                		rset.getString("ADDRESS2_R"),
                		rset.getString("ADDRESS3_R"),
                		rset.getString("ADDRESS4_R"),
                		rset.getString("PRODUCT_NO"),
                		rset.getString("INVOICE_NO"),
                		rset.getString("ACCOUNT_TYPE_DES"),
                		rset.getString("to_char(BILL_DATE,'YYYYMMDD')"), 
                		rset.getString("PREVIOUS_BALANCE"),
                		rset.getString("PAID_AMOUNT"),
                		rset.getString("POST_BILL_ADJUSTMENT"),
                		rset.getString("TOTAL_CURRENT_CHARGES"),
                		rset.getString("OUTSTANDING_BALANCE"),
                		rset.getString("BANK_NAME"),
                		rset.getString("CREDIT_CARD_NO"),
                		rset.getString("to_char(DUE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(BILL_EXTRACT_DATE,'YYYYMMDD')"), 
                		rset.getString("QA_ACCOUNT_IND"),
                		rset.getString("BILL_PRINT_IND"),
                		rset.getString("GOVERNMENT_CODE"),
                		rset.getString("SUB_GOV_CODE"),
                		rset.getString("PRINT_CATEGORY")
                		));
                	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectBILL_PRINT_INFO_Regular(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<String> idBILL_PRINT_INFO,ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"ZIP_CODE," +
    				"PYM_MTD," +
    				"BILL_TYPE," +
    				"MAX_PAGE," +
    				"NAME," +
    				"ADDRESS1," +
    				"ADDRESS2," +
    				"ADDRESS3," +
    				"ADDRESS4," +
    				"NAME_R," +
    				"ADDRESS1_R," +
    				"ADDRESS2_R," +
    				"ADDRESS3_R," +
    				"ADDRESS4_R," +
    				"PRODUCT_NO," +
    				"INVOICE_NO," +
    				"ACCOUNT_TYPE_DES," +
    				"to_char(BILL_DATE,'YYYYMMDD')," +
    				"PREVIOUS_BALANCE," +
    				"PAID_AMOUNT," +
    				"POST_BILL_ADJUSTMENT," +
    				"TOTAL_CURRENT_CHARGES," +
    				"OUTSTANDING_BALANCE," +
    				"BANK_NAME," +
    				"CREDIT_CARD_NO," +
    				"to_char(DUE_DATE,'YYYYMMDD')," +
    				"to_char(BILL_EXTRACT_DATE,'YYYYMMDD')," +
    				"QA_ACCOUNT_IND," +
    				"BILL_PRINT_IND," +
    				"GOVERNMENT_CODE," +
    				"SUB_GOV_CODE," +
    				"PRINT_CATEGORY" +
    				" from BILL_PRINT_INFO  where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' and BILL_TYPE='N' and BILL_PRINT_IND='CF' " +
    				"order by max_page,zip_code,pym_mtd,account_id";
    				
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idBILL_PRINT_INFO.add(rset.getString("ACCOUNT_ID"));
                stBILL_PRINT_INFO.add(new BILL_PRINT_INFO(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("CYCLE_CODE"),
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("ZIP_CODE"),
                		rset.getString("PYM_MTD"), 
                		rset.getString("BILL_TYPE"),
                		rset.getString("MAX_PAGE"),
                		rset.getString("NAME"),
                		rset.getString("ADDRESS1"),
                		rset.getString("ADDRESS2"),
                		rset.getString("ADDRESS3"),
                		rset.getString("ADDRESS4"),
                		rset.getString("NAME_R"),
                		rset.getString("ADDRESS1_R"),
                		rset.getString("ADDRESS2_R"),
                		rset.getString("ADDRESS3_R"),
                		rset.getString("ADDRESS4_R"),
                		rset.getString("PRODUCT_NO"),
                		rset.getString("INVOICE_NO"),
                		rset.getString("ACCOUNT_TYPE_DES"),
                		rset.getString("to_char(BILL_DATE,'YYYYMMDD')"), 
                		rset.getString("PREVIOUS_BALANCE"),
                		rset.getString("PAID_AMOUNT"),
                		rset.getString("POST_BILL_ADJUSTMENT"),
                		rset.getString("TOTAL_CURRENT_CHARGES"),
                		rset.getString("OUTSTANDING_BALANCE"),
                		rset.getString("BANK_NAME"),
                		rset.getString("CREDIT_CARD_NO"),
                		rset.getString("to_char(DUE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(BILL_EXTRACT_DATE,'YYYYMMDD')"), 
                		rset.getString("QA_ACCOUNT_IND"),
                		rset.getString("BILL_PRINT_IND"),
                		rset.getString("GOVERNMENT_CODE"),
                		rset.getString("SUB_GOV_CODE"),
                		rset.getString("PRINT_CATEGORY")
                		));
                	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
        public static BILL_PRINT_INFO selectBILL_PRINT_INFO_Regular_by_ACCID(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,String accId) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO =new ArrayList<BILL_PRINT_INFO>();
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"ZIP_CODE," +
    				"PYM_MTD," +
    				"BILL_TYPE," +
    				"MAX_PAGE," +
    				"NAME," +
    				"ADDRESS1," +
    				"ADDRESS2," +
    				"ADDRESS3," +
    				"ADDRESS4," +
    				"NAME_R," +
    				"ADDRESS1_R," +
    				"ADDRESS2_R," +
    				"ADDRESS3_R," +
    				"ADDRESS4_R," +
    				"PRODUCT_NO," +
    				"INVOICE_NO," +
    				"ACCOUNT_TYPE_DES," +
    				"to_char(BILL_DATE,'YYYYMMDD')," +
    				"PREVIOUS_BALANCE," +
    				"PAID_AMOUNT," +
    				"POST_BILL_ADJUSTMENT," +
    				"TOTAL_CURRENT_CHARGES," +
    				"OUTSTANDING_BALANCE," +
    				"BANK_NAME," +
    				"CREDIT_CARD_NO," +
    				"to_char(DUE_DATE,'YYYYMMDD')," +
    				"to_char(BILL_EXTRACT_DATE,'YYYYMMDD')," +
    				"QA_ACCOUNT_IND," +
    				"BILL_PRINT_IND," +
    				"GOVERNMENT_CODE," +
    				"SUB_GOV_CODE," +
    				"PRINT_CATEGORY" +
    				" from BILL_PRINT_INFO  where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' and BILL_TYPE='N' and BILL_PRINT_IND='CF' and ACCOUNT_ID='"+accId+"' " +
    				"order by max_page,zip_code,pym_mtd,account_id";
    				
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
                stBILL_PRINT_INFO.add(new BILL_PRINT_INFO(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("CYCLE_CODE"),
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("ZIP_CODE"),
                		rset.getString("PYM_MTD"), 
                		rset.getString("BILL_TYPE"),
                		rset.getString("MAX_PAGE"),
                		rset.getString("NAME"),
                		rset.getString("ADDRESS1"),
                		rset.getString("ADDRESS2"),
                		rset.getString("ADDRESS3"),
                		rset.getString("ADDRESS4"),
                		rset.getString("NAME_R"),
                		rset.getString("ADDRESS1_R"),
                		rset.getString("ADDRESS2_R"),
                		rset.getString("ADDRESS3_R"),
                		rset.getString("ADDRESS4_R"),
                		rset.getString("PRODUCT_NO"),
                		rset.getString("INVOICE_NO"),
                		rset.getString("ACCOUNT_TYPE_DES"),
                		rset.getString("to_char(BILL_DATE,'YYYYMMDD')"), 
                		rset.getString("PREVIOUS_BALANCE"),
                		rset.getString("PAID_AMOUNT"),
                		rset.getString("POST_BILL_ADJUSTMENT"),
                		rset.getString("TOTAL_CURRENT_CHARGES"),
                		rset.getString("OUTSTANDING_BALANCE"),
                		rset.getString("BANK_NAME"),
                		rset.getString("CREDIT_CARD_NO"),
                		rset.getString("to_char(DUE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(BILL_EXTRACT_DATE,'YYYYMMDD')"), 
                		rset.getString("QA_ACCOUNT_IND"),
                		rset.getString("BILL_PRINT_IND"),
                		rset.getString("GOVERNMENT_CODE"),
                		rset.getString("SUB_GOV_CODE"),
                		rset.getString("PRINT_CATEGORY")
                		));
                	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return stBILL_PRINT_INFO.get(0);
	}
	public static int selectBILL_PRINT_INFO_GOV(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<String> idBILL_PRINT_INFO,ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"ZIP_CODE," +
    				"PYM_MTD," +
    				"BILL_TYPE," +
    				"MAX_PAGE," +
    				"NAME," +
    				"ADDRESS1," +
    				"ADDRESS2," +
    				"ADDRESS3," +
    				"ADDRESS4," +
    				"NAME_R," +
    				"ADDRESS1_R," +
    				"ADDRESS2_R," +
    				"ADDRESS3_R," +
    				"ADDRESS4_R," +
    				"PRODUCT_NO," +
    				"INVOICE_NO," +
    				"ACCOUNT_TYPE_DES," +
    				"to_char(BILL_DATE,'YYYYMMDD')," +
    				"PREVIOUS_BALANCE," +
    				"PAID_AMOUNT," +
    				"POST_BILL_ADJUSTMENT," +
    				"TOTAL_CURRENT_CHARGES," +
    				"OUTSTANDING_BALANCE," +
    				"BANK_NAME," +
    				"CREDIT_CARD_NO," +
    				"to_char(DUE_DATE,'YYYYMMDD')," +
    				"to_char(BILL_EXTRACT_DATE,'YYYYMMDD')," +
    				"QA_ACCOUNT_IND," +
    				"BILL_PRINT_IND," +
    				"GOVERNMENT_CODE," +
    				"SUB_GOV_CODE," +
    				"PRINT_CATEGORY" +
    				" from BILL_PRINT_INFO  where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' and BILL_TYPE='Y' and BILL_PRINT_IND='CF' " +
    				"order by max_page,zip_code,pym_mtd,account_id";
    				
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idBILL_PRINT_INFO.add(rset.getString("ACCOUNT_ID"));
                stBILL_PRINT_INFO.add(new BILL_PRINT_INFO(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("CYCLE_CODE"),
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("ZIP_CODE"),
                		rset.getString("PYM_MTD"), 
                		rset.getString("BILL_TYPE"),
                		rset.getString("MAX_PAGE"),
                		rset.getString("NAME"),
                		rset.getString("ADDRESS1"),
                		rset.getString("ADDRESS2"),
                		rset.getString("ADDRESS3"),
                		rset.getString("ADDRESS4"),
                		rset.getString("NAME_R"),
                		rset.getString("ADDRESS1_R"),
                		rset.getString("ADDRESS2_R"),
                		rset.getString("ADDRESS3_R"),
                		rset.getString("ADDRESS4_R"),
                		rset.getString("PRODUCT_NO"),
                		rset.getString("INVOICE_NO"),
                		rset.getString("ACCOUNT_TYPE_DES"),
                		rset.getString("to_char(BILL_DATE,'YYYYMMDD')"), 
                		rset.getString("PREVIOUS_BALANCE"),
                		rset.getString("PAID_AMOUNT"),
                		rset.getString("POST_BILL_ADJUSTMENT"),
                		rset.getString("TOTAL_CURRENT_CHARGES"),
                		rset.getString("OUTSTANDING_BALANCE"),
                		rset.getString("BANK_NAME"),
                		rset.getString("CREDIT_CARD_NO"),
                		rset.getString("to_char(DUE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(BILL_EXTRACT_DATE,'YYYYMMDD')"), 
                		rset.getString("QA_ACCOUNT_IND"),
                		rset.getString("BILL_PRINT_IND"),
                		rset.getString("GOVERNMENT_CODE"),
                		rset.getString("SUB_GOV_CODE"),
                		rset.getString("PRINT_CATEGORY")
                		));
                	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectBILL_PRINT_INFO_Regular_QA(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<String> idBILL_PRINT_INFO,ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO ,String QA_ACCOUNT_IND) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"ZIP_CODE," +
    				"PYM_MTD," +
    				"BILL_TYPE," +
    				"MAX_PAGE," +
    				"NAME," +
    				"ADDRESS1," +
    				"ADDRESS2," +
    				"ADDRESS3," +
    				"ADDRESS4," +
    				"NAME_R," +
    				"ADDRESS1_R," +
    				"ADDRESS2_R," +
    				"ADDRESS3_R," +
    				"ADDRESS4_R," +
    				"PRODUCT_NO," +
    				"INVOICE_NO," +
    				"ACCOUNT_TYPE_DES," +
    				"to_char(BILL_DATE,'YYYYMMDD')," +
    				"PREVIOUS_BALANCE," +
    				"PAID_AMOUNT," +
    				"POST_BILL_ADJUSTMENT," +
    				"TOTAL_CURRENT_CHARGES," +
    				"OUTSTANDING_BALANCE," +
    				"BANK_NAME," +
    				"CREDIT_CARD_NO," +
    				"to_char(DUE_DATE,'YYYYMMDD')," +
    				"to_char(BILL_EXTRACT_DATE,'YYYYMMDD')," +
    				"QA_ACCOUNT_IND," +
    				"BILL_PRINT_IND," +
    				"GOVERNMENT_CODE," +
    				"SUB_GOV_CODE," +
    				"PRINT_CATEGORY" +
    				" from BILL_PRINT_INFO  where QA_ACCOUNT_IND='"+QA_ACCOUNT_IND+"' and CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' and BILL_TYPE='N'  order by max_page,zip_code,pym_mtd,account_id";
    				
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idBILL_PRINT_INFO.add(rset.getString("ACCOUNT_ID"));
                stBILL_PRINT_INFO.add(new BILL_PRINT_INFO(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("CYCLE_CODE"),
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("ZIP_CODE"),
                		rset.getString("PYM_MTD"), 
                		rset.getString("BILL_TYPE"),
                		rset.getString("MAX_PAGE"),
                		rset.getString("NAME"),
                		rset.getString("ADDRESS1"),
                		rset.getString("ADDRESS2"),
                		rset.getString("ADDRESS3"),
                		rset.getString("ADDRESS4"),
                		rset.getString("NAME_R"),
                		rset.getString("ADDRESS1_R"),
                		rset.getString("ADDRESS2_R"),
                		rset.getString("ADDRESS3_R"),
                		rset.getString("ADDRESS4_R"),
                		rset.getString("PRODUCT_NO"),
                		rset.getString("INVOICE_NO"),
                		rset.getString("ACCOUNT_TYPE_DES"),
                		rset.getString("to_char(BILL_DATE,'YYYYMMDD')"), 
                		rset.getString("PREVIOUS_BALANCE"),
                		rset.getString("PAID_AMOUNT"),
                		rset.getString("POST_BILL_ADJUSTMENT"),
                		rset.getString("TOTAL_CURRENT_CHARGES"),
                		rset.getString("OUTSTANDING_BALANCE"),
                		rset.getString("BANK_NAME"),
                		rset.getString("CREDIT_CARD_NO"),
                		rset.getString("to_char(DUE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(BILL_EXTRACT_DATE,'YYYYMMDD')"), 
                		rset.getString("QA_ACCOUNT_IND"),
                		rset.getString("BILL_PRINT_IND"),
                		rset.getString("GOVERNMENT_CODE"),
                		rset.getString("SUB_GOV_CODE"),
                		rset.getString("PRINT_CATEGORY")
                		));
                	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectBILL_PRINT_INFO_GOV_QA(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<String> idBILL_PRINT_INFO,ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO ,String QA_ACCOUNT_IND) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"ZIP_CODE," +
    				"PYM_MTD," +
    				"BILL_TYPE," +
    				"MAX_PAGE," +
    				"NAME," +
    				"ADDRESS1," +
    				"ADDRESS2," +
    				"ADDRESS3," +
    				"ADDRESS4," +
    				"NAME_R," +
    				"ADDRESS1_R," +
    				"ADDRESS2_R," +
    				"ADDRESS3_R," +
    				"ADDRESS4_R," +
    				"PRODUCT_NO," +
    				"INVOICE_NO," +
    				"ACCOUNT_TYPE_DES," +
    				"to_char(BILL_DATE,'YYYYMMDD')," +
    				"PREVIOUS_BALANCE," +
    				"PAID_AMOUNT," +
    				"POST_BILL_ADJUSTMENT," +
    				"TOTAL_CURRENT_CHARGES," +
    				"OUTSTANDING_BALANCE," +
    				"BANK_NAME," +
    				"CREDIT_CARD_NO," +
    				"to_char(DUE_DATE,'YYYYMMDD')," +
    				"to_char(BILL_EXTRACT_DATE,'YYYYMMDD')," +
    				"QA_ACCOUNT_IND," +
    				"BILL_PRINT_IND," +
    				"GOVERNMENT_CODE," +
    				"SUB_GOV_CODE," +
    				"PRINT_CATEGORY" +
    				" from BILL_PRINT_INFO  where QA_ACCOUNT_IND='"+QA_ACCOUNT_IND+"' and CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' and BILL_TYPE='Y'  order by max_page,zip_code,pym_mtd,account_id";
    				
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idBILL_PRINT_INFO.add(rset.getString("ACCOUNT_ID"));
                stBILL_PRINT_INFO.add(new BILL_PRINT_INFO(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("CYCLE_CODE"),
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("ZIP_CODE"),
                		rset.getString("PYM_MTD"), 
                		rset.getString("BILL_TYPE"),
                		rset.getString("MAX_PAGE"),
                		rset.getString("NAME"),
                		rset.getString("ADDRESS1"),
                		rset.getString("ADDRESS2"),
                		rset.getString("ADDRESS3"),
                		rset.getString("ADDRESS4"),
                		rset.getString("NAME_R"),
                		rset.getString("ADDRESS1_R"),
                		rset.getString("ADDRESS2_R"),
                		rset.getString("ADDRESS3_R"),
                		rset.getString("ADDRESS4_R"),
                		rset.getString("PRODUCT_NO"),
                		rset.getString("INVOICE_NO"),
                		rset.getString("ACCOUNT_TYPE_DES"),
                		rset.getString("to_char(BILL_DATE,'YYYYMMDD')"), 
                		rset.getString("PREVIOUS_BALANCE"),
                		rset.getString("PAID_AMOUNT"),
                		rset.getString("POST_BILL_ADJUSTMENT"),
                		rset.getString("TOTAL_CURRENT_CHARGES"),
                		rset.getString("OUTSTANDING_BALANCE"),
                		rset.getString("BANK_NAME"),
                		rset.getString("CREDIT_CARD_NO"),
                		rset.getString("to_char(DUE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(BILL_EXTRACT_DATE,'YYYYMMDD')"), 
                		rset.getString("QA_ACCOUNT_IND"),
                		rset.getString("BILL_PRINT_IND"),
                		rset.getString("GOVERNMENT_CODE"),
                		rset.getString("SUB_GOV_CODE"),
                		rset.getString("PRINT_CATEGORY")
                		));
                	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectNAME_ADDRESS_INFO(Connection conn,String link_type ,ArrayList<String> idNAME_ADDRESS_INFO,ArrayList<NAME_ADDRESS_INFO> stNAME_ADDRESS_INFO ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +
    				"LINK_SEQ_NO," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"LINK_TYPE," +
    				"to_char(EFFECTIVE_DATE,'YYYYMMDD')," +
    				"to_char(EXPIRATION_DATE,'YYYYMMDD')," +
    				"FIRST_NAME," +
    				"LAST_NAME," +
    				"NAME_TITLE," +
    				"NAME_TITLE_REF," +
    				"ADR_CITY," +
    				"ADR_CITY_REF," +
    				"ADR_SUBURB," +
    				"ADR_SUBURB_REF," +
    				"ADR_KHWANG," +
    				"ADR_KHWANG_REF," +
    				"ADR_STREET_NAME," +
    				"ADR_FLAT," +
    				"ADR_FLOOR," +
    				"BUILDING_NAME," + 
    				"ADR_SOI," +
    				"ADR_MOO," +
    				"ADR_HOUSE_NO," +
    				"ADR_ZIP," +
    				"LANGUAGE_ID" +
    				" from NAME_ADDRESS_INFO where LINK_TYPE='"+link_type+"' order by ACCOUNT_ID";

    				
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idNAME_ADDRESS_INFO.add(rset.getString("ACCOUNT_ID"));
                stNAME_ADDRESS_INFO.add(new NAME_ADDRESS_INFO(
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("LINK_SEQ_NO"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("LINK_TYPE"),
                		rset.getString("to_char(EFFECTIVE_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(EXPIRATION_DATE,'YYYYMMDD')"), 
                		rset.getString("FIRST_NAME"),
                		rset.getString("LAST_NAME"),
                		rset.getString("NAME_TITLE"),
                		rset.getString("NAME_TITLE_REF"),
                		rset.getString("ADR_CITY"),
                		rset.getString("ADR_CITY_REF"),
                		rset.getString("ADR_SUBURB"),
                		rset.getString("ADR_SUBURB_REF"),
                		rset.getString("ADR_KHWANG"),
                		rset.getString("ADR_KHWANG_REF"),
                		rset.getString("ADR_STREET_NAME"),
                		rset.getString("ADR_FLAT"),
                		rset.getString("ADR_FLOOR"),
                		rset.getString("BUILDING_NAME"),
                		rset.getString("ADR_SOI"),
                		rset.getString("ADR_MOO"),
                		rset.getString("ADR_HOUSE_NO"),
                		rset.getString("ADR_ZIP"),
                		rset.getString("LANGUAGE_ID") 
                		));  	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectBANK(Connection conn,ArrayList<String> idBANK,ArrayList<BANK> stBANK ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"BANK_CODE," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"BANK_DESC ," +
    				"COMPANY_ACC_NO," +
    				"COMPANY_ACC_NAME," +
    				"CREDIT_CARD_IND" +
    				" from BANK order by BANK_CODE";
 	
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idBANK.add(rset.getString("BANK_CODE"));
                stBANK.add(new BANK(
                		rset.getString("BANK_CODE"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("BANK_DESC"),
                		rset.getString("COMPANY_ACC_NO"),
                		rset.getString("COMPANY_ACC_NAME"),
                		rset.getString("CREDIT_CARD_IND")
                		));  	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectUSAGE_XX(Connection conn,String tableName,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<String> idUSAGE_XX,ArrayList<USAGE_XX> stUSAGE_XX ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"ACCOUNT_ID," +
    				"ORIG_TN," +
    				"to_char(CONNECT_DATE,'YYYYMMDDHH24MISS')," +
    				"CALL_DURATION," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"CALL_VOL_ROUNDED," +
    				"PRODUCT_TYPE," +
    				"PRODUCT_NO," +
    				"DIALED_TN," +
    				"PRICE_PLAN_CODE," +
    				"FEATURE_CODE," +
    				"CHARGE_AMT," +
    				"CALL_ADJUSTMENT_IND," +
    				"DESTINATION_ON_BILL," +
    				"BILL_STATUS" +
    				" from "+tableName+"  where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' order by ACCOUNT_ID";
 	
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idUSAGE_XX.add(rset.getString("ACCOUNT_ID"));
                stUSAGE_XX.add(new USAGE_XX(
                		rset.getString("CYCLE_CODE"),
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("ORIG_TN"),
                		rset.getString("to_char(CONNECT_DATE,'YYYYMMDDHH24MISS')"), 
                		rset.getString("CALL_DURATION"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("CALL_VOL_ROUNDED"),
                		rset.getString("PRODUCT_TYPE"),
                		rset.getString("PRODUCT_NO"),
                		rset.getString("DIALED_TN"),
                		rset.getString("PRICE_PLAN_CODE"),
                		rset.getString("FEATURE_CODE"),
                		rset.getString("CHARGE_AMT"),
                		rset.getString("CALL_ADJUSTMENT_IND"),
                		rset.getString("DESTINATION_ON_BILL"),
                		rset.getString("BILL_STATUS")               	
                		));  	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
        public static int selectUSAGE_XX_U(Connection conn,String tableName,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<String> idUSAGE_XX,ArrayList<USAGE_XX> stUSAGE_XX ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"ACCOUNT_ID," +
    				"ORIG_TN," +
    				"to_char(CONNECT_DATE,'YYYYMMDDHH24MISS')," +
    				"CALL_DURATION," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"CALL_VOL_ROUNDED," +
    				"PRODUCT_TYPE," +
    				"PRODUCT_NO," +
    				"DIALED_TN," +
    				"PRICE_PLAN_CODE," +
    				"FEATURE_CODE," +
    				"CHARGE_AMT," +
    				"CALL_ADJUSTMENT_IND," +
    				"DESTINATION_ON_BILL," +
    				"BILL_STATUS" +
    				" from "+tableName+"  where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' and BILL_STATUS = 'U' order by ACCOUNT_ID";
 	
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idUSAGE_XX.add(rset.getString("ACCOUNT_ID"));
                stUSAGE_XX.add(new USAGE_XX(
                		rset.getString("CYCLE_CODE"),
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("ORIG_TN"),
                		rset.getString("to_char(CONNECT_DATE,'YYYYMMDDHH24MISS')"), 
                		rset.getString("CALL_DURATION"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("CALL_VOL_ROUNDED"),
                		rset.getString("PRODUCT_TYPE"),
                		rset.getString("PRODUCT_NO"),
                		rset.getString("DIALED_TN"),
                		rset.getString("PRICE_PLAN_CODE"),
                		rset.getString("FEATURE_CODE"),
                		rset.getString("CHARGE_AMT"),
                		rset.getString("CALL_ADJUSTMENT_IND"),
                		rset.getString("DESTINATION_ON_BILL"),
                		rset.getString("BILL_STATUS")               	
                		));  	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
        public static int selectUSAGE_XX_UByAccId(Connection conn,String tableName,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,String AccountId,ArrayList<String> idUSAGE_XX,ArrayList<USAGE_XX> stUSAGE_XX ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"ACCOUNT_ID," +
    				"ORIG_TN," +
    				"to_char(CONNECT_DATE,'YYYYMMDDHH24MISS')," +
    				"CALL_DURATION," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"CALL_VOL_ROUNDED," +
    				"PRODUCT_TYPE," +
    				"PRODUCT_NO," +
    				"DIALED_TN," +
    				"PRICE_PLAN_CODE," +
    				"FEATURE_CODE," +
    				"CHARGE_AMT," +
    				"CALL_ADJUSTMENT_IND," +
    				"DESTINATION_ON_BILL," +
    				"BILL_STATUS" +
    				" from "+tableName+"  where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' and BILL_STATUS = 'U' and ACCOUNT_ID ='"+AccountId+"'  order by ACCOUNT_ID";
 	
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idUSAGE_XX.add(rset.getString("ACCOUNT_ID"));
                stUSAGE_XX.add(new USAGE_XX(
                		rset.getString("CYCLE_CODE"),
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("ORIG_TN"),
                		rset.getString("to_char(CONNECT_DATE,'YYYYMMDDHH24MISS')"), 
                		rset.getString("CALL_DURATION"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("CALL_VOL_ROUNDED"),
                		rset.getString("PRODUCT_TYPE"),
                		rset.getString("PRODUCT_NO"),
                		rset.getString("DIALED_TN"),
                		rset.getString("PRICE_PLAN_CODE"),
                		rset.getString("FEATURE_CODE"),
                		rset.getString("CHARGE_AMT"),
                		rset.getString("CALL_ADJUSTMENT_IND"),
                		rset.getString("DESTINATION_ON_BILL"),
                		rset.getString("BILL_STATUS")               	
                		));  	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectUSAGE_S(Connection conn,String tableName,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<String> idUSAGE_S,ArrayList<USAGE_S> stUSAGE_S ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +   				
    				"ACCOUNT_ID," +
    				"count(ACCOUNT_ID)" +   				
    				" from "+tableName+"  where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' and BILL_STATUS='B' group by ACCOUNT_ID order by ACCOUNT_ID";
 	
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idUSAGE_S.add(rset.getString("ACCOUNT_ID"));
                stUSAGE_S.add(new USAGE_S (              		
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("count(ACCOUNT_ID)")               		             	
                		));  	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static int selectACCOUNT_TYPE(Connection conn,ArrayList<String> idACCOUNT_TYPE,ArrayList<ACCOUNT_TYPE> stACCOUNT_TYPE ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +   				    				
    				"ACCOUNT_TYPE," +
    				"ACCOUNT_SUB_TYPE," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"DESCRIPTION," +
    				"GOVERNMENT_ACC_IND ," +
    				"TAX_CODE" +
    				" from ACCOUNT_TYPE";
    				
 	
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	idACCOUNT_TYPE.add(rset.getString("ACCOUNT_TYPE")+rset.getString("ACCOUNT_SUB_TYPE"));
                stACCOUNT_TYPE.add(new ACCOUNT_TYPE ( 
                		rset.getString("ACCOUNT_TYPE"),
                		rset.getString("ACCOUNT_SUB_TYPE"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("DESCRIPTION"),
                		rset.getString("GOVERNMENT_ACC_IND"),
                		rset.getString("TAX_CODE")        		             	
                		));  	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
	public static String selectInvoiceNoSeq(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    String seqReturn="";
	    try {
    		strSQL="select substr(CYCLE_YEAR,4,1)||to_char(CYCLE_MONTH,'00')||to_char(CYCLE_CODE,'00')||to_char(InvoiceNo_seq.NEXTVAL,'000000000') invoiceSeq " +
    				"from cycle_control where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"'";
    				
 	
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	seqReturn=rset.getString("invoiceSeq");
            	//System.out.println("out1="+seqReturn);
            	seqReturn=seqReturn.replace(" ", "");
            	//System.out.println("out2="+seqReturn);
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return seqReturn;
	}
	public static int selectBILL_QA(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<BILL_QA> stBILL_QA ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +  
    				"ACCOUNT_ID," +
    				"CYCLE_CODE," +
    				"CYCLE_YEAR," +
    				"CYCLE_MONTH," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"DESCRIPTION " +   								
    				"from BILL_QA  where CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' order by ACCOUNT_ID";
 	
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	
                stBILL_QA.add(new BILL_QA (   
                		rset.getString("ACCOUNT_ID"),
                		rset.getString("CYCLE_CODE"),
                		rset.getString("CYCLE_YEAR"),
                		rset.getString("CYCLE_MONTH"),
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"), 
                		rset.getString("DESCRIPTION")             		             	
                		));  	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
	public static int selectPRINT_CATEGORY(Connection conn,ArrayList<String> idPRINT_CATEGORY,ArrayList<PRINT_CATEGORY> stPRINT_CATEGORY ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +  
    				"PRINT_CATEGORIES," +
    				"to_char(SYS_CREATION_DATE,'YYYYMMDD')," +
    				"to_char(SYS_UPDATE_DATE,'YYYYMMDD')," +
    				"PRINT_CAT_DESC," +
    				"GOV_FORMAT " +    				  								
    				"from PRINT_CATEGORY ";
 	
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	
            	idPRINT_CATEGORY.add(rset.getString("PRINT_CATEGORIES"));
                stPRINT_CATEGORY.add(new PRINT_CATEGORY(
                		rset.getString("PRINT_CATEGORIES"), 
                		rset.getString("to_char(SYS_CREATION_DATE,'YYYYMMDD')"), 
                		rset.getString("to_char(SYS_UPDATE_DATE,'YYYYMMDD')"),  
                		rset.getString("PRINT_CAT_DESC"),
                		rset.getString("GOV_FORMAT")
                		));                         	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
}
