package tot.bill.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import tot.bill.model.SumCharge;
import tot.bill.table.CHARGE;
import tot.bill.table.USAGE_XX;

public class CHARGE_DB {
	public static int InsertCHARGE (Connection conn,CHARGE stCHARGE) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    

	    stmt = conn.createStatement();
	    rset = null;
	    int x=0;
	    try {
	    	
	    	strSQL="select CHARGE_1SQ.NEXTVAL CHARGE_1SQ from dual" ;
	    			
	    	System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	    	String CHARGE_1SQ="";
	        if(rset.next()){ 
	        	CHARGE_1SQ=rset.getString("CHARGE_1SQ");
	        }else{
	        	 try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	        	 return -1;
	        }
	        
	        if(stCHARGE.getACCOUNT_ID()==null)stCHARGE.setACCOUNT_ID("");
	        if(stCHARGE.getCHARGE_SEQ_NO()==null)stCHARGE.setCHARGE_SEQ_NO("");
	        if(stCHARGE.getINVOICE_SEQ_NO()==null)stCHARGE.setINVOICE_SEQ_NO("");
	        if(stCHARGE.getSYS_CREATION_DATE()==null)stCHARGE.setSYS_CREATION_DATE("");
	        if(stCHARGE.getSYS_UPDATE_DATE()==null)stCHARGE.setSYS_UPDATE_DATE("");
	        if(stCHARGE.getCYCLE_CODE()==null)stCHARGE.setCYCLE_CODE("");
	        if(stCHARGE.getCYCLE_YEAR()==null)stCHARGE.setCYCLE_YEAR("");
	        if(stCHARGE.getCYCLE_MONTH()==null)stCHARGE.setCYCLE_MONTH("");
	        if(stCHARGE.getPRODUCT_TYPE()==null)stCHARGE.setPRODUCT_TYPE("");
	        if(stCHARGE.getPRODUCT_NO()==null)stCHARGE.setPRODUCT_NO("");
	        if(stCHARGE.getCHG_CREATION_DATE()==null)stCHARGE.setCHG_CREATION_DATE("");
	        if(stCHARGE.getCHARGE_TYPE()==null)stCHARGE.setCHARGE_TYPE("");
	        if(stCHARGE.getIMMEDIATE_IND()==null)stCHARGE.setIMMEDIATE_IND("");
	        if(stCHARGE.getPRICE_PLAN()==null)stCHARGE.setPRICE_PLAN("");
	        if(stCHARGE.getFEATURE_CODE()==null)stCHARGE.setFEATURE_CODE("");
	        if(stCHARGE.getREVENUE_CODE()==null)stCHARGE.setREVENUE_CODE("");
	        if(stCHARGE.getDISCOUNT_CODE()==null)stCHARGE.setDISCOUNT_CODE("");
	        if(stCHARGE.getCATEGORY_CODE()==null)stCHARGE.setCATEGORY_CODE("");
	        if(stCHARGE.getCHARGE_START_DATE()==null)stCHARGE.setCHARGE_START_DATE("");
	        if(stCHARGE.getCHARGE_END_DATE()==null)stCHARGE.setCHARGE_END_DATE("");
	        if(stCHARGE.getACTV_DATE()==null)stCHARGE.setACTV_DATE("");
	        if(stCHARGE.getACTV_AMT()==null)stCHARGE.setACTV_AMT("");
	        if(stCHARGE.getTAX_CODE()==null)stCHARGE.setTAX_CODE("");
	        if(stCHARGE.getTAX_AMT()==null)stCHARGE.setTAX_AMT("");
	        if(stCHARGE.getTOTAL_NUMBER_OF_CALLS()==null)stCHARGE.setTOTAL_NUMBER_OF_CALLS("");

	        
	    	strSQL="INSERT INTO CHARGE (" +
	    			"ACCOUNT_ID,"+
	    			"CHARGE_SEQ_NO,"+
	    			"INVOICE_SEQ_NO,"+
	    			"SYS_CREATION_DATE,"+
	    			//"SYS_UPDATE_DATE,"+
	    			"CYCLE_CODE,"+
	    			"CYCLE_YEAR,"+
	    			"CYCLE_MONTH,"+
	    			"PRODUCT_TYPE,"+
	    			"PRODUCT_NO,"+
	    			"CHG_CREATION_DATE,"+
	    			"CHARGE_TYPE,"+
	    			"IMMEDIATE_IND,"+
	    			"PRICE_PLAN,"+
	    			"FEATURE_CODE,"+
	    			"REVENUE_CODE,"+
	    			"DISCOUNT_CODE,"+
	    			"CATEGORY_CODE,"+
	    			"CHARGE_START_DATE,"+
	    			"CHARGE_END_DATE,"+
	    			"ACTV_DATE,"+
	    			"ACTV_AMT,"+
	    			"TAX_CODE,"+
	    			"TAX_AMT,"+
	    			"TOTAL_NUMBER_OF_CALLS"+
	    			") VALUES (" +
	    			"'"+stCHARGE.getACCOUNT_ID()+"'," +
	    			"'"+CHARGE_1SQ+"'," +
	    			"'"+stCHARGE.getINVOICE_SEQ_NO()+"'," +
	    			"to_date('"+stCHARGE.getSYS_CREATION_DATE()+"','YYYYMMDDHH24MISS')," +
	    			//"to_date('"+stCHARGE.getSYS_UPDATE_DATE()+"','YYYYMMDD')," +
	    			"'"+stCHARGE.getCYCLE_CODE()+"'," +
	    			"'"+stCHARGE.getCYCLE_YEAR()+"'," +
	    			"'"+stCHARGE.getCYCLE_MONTH()+"'," +
	    			"'"+stCHARGE.getPRODUCT_TYPE()+"'," +
	    			"'"+stCHARGE.getPRODUCT_NO()+"'," +
	    			"to_date('"+stCHARGE.getCHG_CREATION_DATE()+"','YYYYMMDD')," +
	    			"'"+stCHARGE.getCHARGE_TYPE()+"'," +
	    			"'"+stCHARGE.getIMMEDIATE_IND()+"'," +
	    			"'"+stCHARGE.getPRICE_PLAN()+"'," +
	    			"'"+stCHARGE.getFEATURE_CODE()+"'," +
	    			"'"+stCHARGE.getREVENUE_CODE()+"'," +
	    			"'"+stCHARGE.getDISCOUNT_CODE()+"'," +
	    			"'"+stCHARGE.getCATEGORY_CODE()+"'," +
	    			"to_date('"+stCHARGE.getCHARGE_START_DATE()+"','YYYYMMDD')," +
	    			"to_date('"+stCHARGE.getCHARGE_END_DATE()+"','YYYYMMDD')," +
	    			"to_date('"+stCHARGE.getACTV_DATE()+"','YYYYMMDD')," +
	    			"'"+stCHARGE.getACTV_AMT()+"'," +
	    			"'"+stCHARGE.getTAX_CODE()+"'," +
	    			"'"+stCHARGE.getTAX_AMT()+"'," +
	    			"'"+stCHARGE.getTOTAL_NUMBER_OF_CALLS()+"'" +
	    			")" ;
	    			
	    	
	    		
	    	System.out.println(strSQL);
	    	
	    	
	    	x=stmt.executeUpdate(strSQL);
	    	if(x==1){
	    		x=Integer.parseInt(CHARGE_1SQ);
	    	}else{
	    		x=-1;
	    	}
	    	
	        
	    }catch (SQLException ex) {
            System.out.println("*** SQLException caught ***");
             while (ex != null)
             {
             	System.out.println("Message: " + ex.getMessage ());
             	System.out.println("SQLState: " + ex.getSQLState ());
             	System.out.println("ErrorCode: " + ex.getErrorCode ());
             	ex = ex.getNextException ();
             	
             }
             x=-1;
	    } catch (java.lang.Exception ex) {
     		System.out.println("*** Exception caught *** <br>");
     		x=-1;
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
		return x;
	}
	public static int selectSUM_CHARGE_SeviceCharge(Connection conn,String charge_type,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,ArrayList<SumCharge> stSumCharge ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +    				
    				"CATEGORY_CODE," +
    				"sum(ACTV_AMT)," +
    				"sum(TAX_AMT), " +
    				"TAX_CODE " +
    				"from CHARGE "+
    				"where CHARGE_TYPE "+charge_type+" and "+
    				"CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' "+ 
    				"group by ACCOUNT_ID,CATEGORY_CODE,TAX_CODE "+
    				"order by ACCOUNT_ID,CATEGORY_CODE";
    				    				
 	
    		System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	
                stSumCharge.add(new SumCharge(
                		rset.getString("ACCOUNT_ID"),               		
                		rset.getString("CATEGORY_CODE"),
                		rset.getString("sum(ACTV_AMT)"),
                		rset.getString("sum(TAX_AMT)"),
                		rset.getString("TAX_CODE")                		
                		));  	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
        public static int selectSUM_CHARGE_SeviceChargeByAccId(Connection conn,String charge_type,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,String AccountId,ArrayList<SumCharge> stSumCharge ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +
    				"ACCOUNT_ID," +    				
    				"CATEGORY_CODE," +
    				"sum(ACTV_AMT)," +
    				"sum(TAX_AMT), " +
    				"TAX_CODE " +
    				"from CHARGE "+
    				"where CHARGE_TYPE "+charge_type+" and "+
    				"CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' and ACCOUNT_ID='"+AccountId+"' "+ 
    				"group by ACCOUNT_ID,CATEGORY_CODE,TAX_CODE "+
    				"order by ACCOUNT_ID,CATEGORY_CODE";
    				    				
 	
    		System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
            while (rset.next()){
            	
                stSumCharge.add(new SumCharge(
                		rset.getString("ACCOUNT_ID"),               		
                		rset.getString("CATEGORY_CODE"),
                		rset.getString("sum(ACTV_AMT)"),
                		rset.getString("sum(TAX_AMT)"),
                		rset.getString("TAX_CODE")                		
                		));  	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
}
