package mig.oracle8i;

import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;



import mig.connnection.Connection8i;
import mig.resources.*;

public class Sql8i {
	public static void loadAccountCycleToFile(String path , int cycle) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		try {
			System.out.println("Load cycle"+Integer.toString(cycle)+"...");
			conn = Connection8i.getConnection();
			ResultSet rset = null;
			stmt= conn.createStatement();
			String sql2 = " select a.ban from billing_account a,product b where a.ban=b.ban and a.bill_cycle=";
			sql2 += "'"+Integer.toString(cycle)+"'";
			sql2+= " and a.ban_status not in ('N','C') and a.ban_company='TR' and b.product_type in ('A','D','F') order by a.ban ";
			rset = stmt.executeQuery(sql2);
			BufferedWriter writer_temp = Files.newBufferedWriter(Paths.get(path + "Cycle"+Integer.toString(cycle)+".txt"),
					Constants.UTF_8);
			int i = 0;
			String ban = "";
			while(rset.next()){
				ban = rset.getString("ban");
				writer_temp.write(ban);
				writer_temp.newLine();
				i++;
			}
			
			writer_temp.close();
			System.out.println("Cycle"+Integer.toString(cycle)+" size " +i);
			System.out.println("End cycle ");
		
		} catch (Exception e) {
			throw e;
		}finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e2) {
			}
		}
		return ;
	}
	
	public static void getBanByCycle( Connection conn,int cycle,ArrayList<String> BanList) throws Exception{
		
		Statement stmt = null;
		try {
			System.out.println("Load cycle"+Integer.toString(cycle)+"...");
			
			ResultSet rset = null;
			stmt= conn.createStatement();
			String sql2 = " select a.ban from billing_account a,product b where a.ban=b.ban and a.bill_cycle=";
			sql2 += "'"+Integer.toString(cycle)+"'";
			sql2+= " and a.ban_status not in ('N','C') and a.ban_company='TR' and b.product_type in ('A','D','F') order by a.ban ";
			rset = stmt.executeQuery(sql2);
			while(rset.next()){
				
				BanList.add(rset.getString("ban"));
				
			}

		} catch (Exception e) {
			throw e;
		}finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e2) {
			}
		}
		return ;
	}
	
	public static int loadServiceFeature(Connection conn,String accountIdList, ArrayList<SERVICE_FEATURE> stSERVICE_FEATURE) throws Exception{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
	    	strSQL="SELECT " +
	    			"BAN ACCOUNT_ID," +
	    			"to_char(SYS_CREATION_DATE,'YYYYMMDDHH24MISS') SYS_CREATION_DATE," +
	    			"to_char(SYS_UPDATE_DATE,'YYYYMMDDHH24MISS') SYS_UPDATE_DATE," +
	    			"PRODUCT_TYPE," +
	    			"PRODUCT_ID PRODUCT_NO," +
	    			"PRICE_PLAN," +
	    			"FEATURE_CODE," +
	    			"to_char(FTR_EFFECTIVE_DATE,'YYYYMMDDHH24MISS') EFFECTIVE_DATE," +
	    			"to_char(FTR_EXPIRATION_DATE,'YYYYMMDDHH24MISS') EXPIRATION_DATE," +
	    			"FIRST_VAR_RATE_QTY," +
	    			"to_char(FTR_ISSUE_DATE,'YYYYMMDDHH24MISS') ISSUE_DATE " +
	    			"FROM SERVICE_FEATURE WHERE PRODUCT_TYPE in('A','D','F') and BAN IN ("
	    			+accountIdList+
	    			")";
	    	//System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	        while (rset.next()){                            	        	
	        	stSERVICE_FEATURE.add(new SERVICE_FEATURE(
	        			rset.getString("ACCOUNT_ID"),
	        			rset.getString("SYS_CREATION_DATE"),
	        			rset.getString("SYS_UPDATE_DATE"),
	        			rset.getString("PRODUCT_TYPE"),
	        			rset.getString("PRODUCT_NO"),
	        			rset.getString("PRICE_PLAN"),
	        			rset.getString("FEATURE_CODE"),
	        			rset.getString("EFFECTIVE_DATE"),
	        			rset.getString("EXPIRATION_DATE"),
	        			rset.getInt("FIRST_VAR_RATE_QTY"),
	        			rset.getString("ISSUE_DATE")
	        			));
	        	
	        }
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
	
	public static int getCharge(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,String accountIdList, ArrayList<CHARGE> stCHARGE) throws Exception{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
	    	strSQL="SELECT " +
	    			"BAN," +
	    			"PRODUCT_ID," +
	    			"ACTV_CODE," +
	    			"ACTV_REASON_CODE," +
	    			"ACTV_AMT," +
	    			"VAT_AMT," +
	    			"VAT_RATE ," +
	    			"PRICE_PLAN," +
	    			"FEATURE_CODE " +
	    			"FROM CHARGE WHERE CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_RUN_MONTH='"+CYCLE_MONTH+"' and CYCLE_RUN_YEAR='"+CYCLE_YEAR+"' " +
    				"and ACTV_REASON_CODE='R' and SOURCE_APPL_CODE='B' " +
    				"and BAN ='"+accountIdList+"' " ;//+
    				//"and ACTV_REASON_CODE='R' and SOURCE_APPL_CODE='B'";
	    	//System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	        while (rset.next()){                            	        	
	        	stCHARGE.add(new CHARGE(
	        			rset.getString("BAN"),
	        			rset.getString("PRODUCT_ID"),
	        			rset.getString("ACTV_CODE"),
	        			rset.getString("ACTV_REASON_CODE"),
	        			rset.getString("ACTV_AMT"),
	        			rset.getString("VAT_AMT"),
	        			rset.getString("VAT_RATE"),
	        			rset.getString("PRICE_PLAN"),
	        			rset.getString("FEATURE_CODE")
	        			));
	        	
	        }
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
	
	public static int getBILL_PRINT_INFO(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,String accountIdList, ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO) throws Exception{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	   
	    try {
	    	strSQL="SELECT " +	    			
	    			"BAN," +
	    			"PREV_BALANCE_AMT," +
	    			"PYM_RECEIVED_AMT," +
	    			"ACTUAL_BALANCE_AMT," +
	    			"TOTAL_DUE_AMT " +	    			
	    			"FROM BILL WHERE CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_RUN_MONTH='"+CYCLE_MONTH+"' and CYCLE_RUN_YEAR='"+CYCLE_YEAR+"' " +   				
    				"and BAN ='"+accountIdList+"' " ;
    				
	    	//System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	        while (rset.next()){                            	        	
	        	stBILL_PRINT_INFO.add(new BILL_PRINT_INFO(
	        			rset.getString("BAN"),
	        			rset.getString("PREV_BALANCE_AMT"),
	        			rset.getString("PYM_RECEIVED_AMT"),
	        			rset.getString("ACTUAL_BALANCE_AMT"),
	        			rset.getString("TOTAL_DUE_AMT")
	        			));
	        	
	        }
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
	
	
	public static int load(Connection conn ,String sql, ArrayList<String> lst) throws Exception{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
	    	String text = "";
	    	rset = stmt.executeQuery(sql);
	    	if(rset != null){
	    		ResultSetMetaData rsmd = null;
	    		while (rset.next()){                            	        	
	    			 rsmd = rset.getMetaData();
	    			 text = "";
				        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				        	int type = rsmd.getColumnType(i);
				        	 if( type == Types.DATE) {
				        		 if(rset.getDate(i) != null){
//				        			 String sysDateTime=dateFormat.format(rset.getDate(i).getTime());
				        			 String sysDateTime = rset.getString(i).substring(0, rset.getString(i).length()-2);
				        			 text += ",to_date('"+sysDateTime+"','YYYY-MM-DD HH24:MI:SS')";
				        		 }else{
				        			 text += ", null ";
				        		 }
				        	}else if(type == Types.CHAR || type == Types.VARCHAR){
				        		if(rset.getString(i) != null){
				        			text += ",'"+ rset.getString(i).trim()+"'";
				        		}else{
				        			text += ", null ";
				        		}
				        	}else if(type == Types.INTEGER || type == Types.NUMERIC){
				        		
				        		if(rset.getBigDecimal(i) != null){
				        			text += ","+ rset.getString(i).trim();
				        		}else{
				        			text += ", null ";
				        		}
				        	}else if(type == Types.DOUBLE){
				        		text += ","+ Double.toString(rset.getDouble(i));
				        	}else if(type == Types.DECIMAL){
				        		if(rset.getBigDecimal(i) != null){
				        			text += ","+ Double.toString(rset.getBigDecimal(i).doubleValue());
				        		}else{
				        			text += ", null ";
				        		}
				        	}else{
				        		if(rset.getString(i) != null){
				        			text += ",'"+ rset.getString(i).trim()+"'";
				        		}else{
				        			text += ", null ";
				        		}
				        	}
				        }
				    //    text=text.substring(1, )
				        lst.add(text.substring(1));
	    		}
	    	}
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
	
	public static int wirteValueSql(Connection conn ,String sql,String path) throws Exception{
		Statement stmt ;
	    ResultSet rset = null;
	    stmt = conn.createStatement();
	    int count = 0;
	    
	    try (BufferedWriter writer_temp = Files.newBufferedWriter(Paths.get(path), Constants.UTF_8);){
	    	String text = "";
	    	rset = stmt.executeQuery(sql);
	    	if(rset != null){
	    		ResultSetMetaData rsmd = null;
	    		while (rset.next()){  
	    			count ++;
	    			 rsmd = rset.getMetaData();
	    			 text = "";
				        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				        	int type = rsmd.getColumnType(i);
				        	 if( type == Types.DATE) {
				        		 if(rset.getDate(i) != null){
//				        			 String sysDateTime=dateFormat.format(rset.getDate(i).getTime());
				        			 String sysDateTime = rset.getString(i).substring(0, rset.getString(i).length()-2);
				        			 text += ",to_date('"+sysDateTime+"','YYYY-MM-DD HH24:MI:SS')";
				        		 }else{
				        			 text += ", null ";
				        		 }
				        	}else if(type == Types.CHAR || type == Types.VARCHAR){
				        		if(rset.getString(i) != null){
				        			text += ",'"+ rset.getString(i).trim()+"'";
				        		}else{
				        			text += ", null ";
				        		}
				        	}else if(type == Types.INTEGER || type == Types.NUMERIC){
				        		
				        		if(rset.getBigDecimal(i) != null){
				        			text += ","+ rset.getString(i).trim();
				        		}else{
				        			text += ", null ";
				        		}
				        	}else if(type == Types.DOUBLE){
				        		text += ","+ Double.toString(rset.getDouble(i));
				        	}else if(type == Types.DECIMAL){
				        		if(rset.getBigDecimal(i) != null){
				        			text += ","+ Double.toString(rset.getBigDecimal(i).doubleValue());
				        		}else{
				        			text += ", null ";
				        		}
				        	}else{
				        		if(rset.getString(i) != null){
				        			text += ",'"+ rset.getString(i).trim()+"'";
				        		}else{
				        			text += ", null ";
				        		}
				        	}
				        }
				        if(text != null && text.length() > 1){
				        	writer_temp.write(text.substring(1));
				        	writer_temp.newLine();
				        	
				        }
	    		}
	    	}
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return count;
	}
	
}
