package mig.oracle8i;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.codec.Charsets;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import mig.connnection.Connection11g;
import mig.resources.BILL_PRINT_INFO;
import mig.resources.CHARGE;
import mig.resources.Constants;
import mig.resources.SERVICE_FEATURE;



public class Sql11g {
	public static int InsertBILL (Connection conn, ArrayList<SERVICE_FEATURE> stSERVICE_FEATURE) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    

	    stmt = conn.createStatement();
	    rset = null;
	    int x=0;
	    for(int i=0;i<stSERVICE_FEATURE.size();i++){
	    try {
	    	if(stSERVICE_FEATURE.get(i).getSYS_CREATION_DATE()==null)stSERVICE_FEATURE.get(i).setSYS_CREATION_DATE("");
	    	if(stSERVICE_FEATURE.get(i).getSYS_UPDATE_DATE()==null)stSERVICE_FEATURE.get(i).setSYS_UPDATE_DATE("");
	    	if(stSERVICE_FEATURE.get(i).getEFFECTIVE_DATE()==null)stSERVICE_FEATURE.get(i).setEFFECTIVE_DATE("");
	    	if(stSERVICE_FEATURE.get(i).getEXPIRATION_DATE()==null)stSERVICE_FEATURE.get(i).setEXPIRATION_DATE("");
	    	if(stSERVICE_FEATURE.get(i).getISSUE_DATE()==null)stSERVICE_FEATURE.get(i).setISSUE_DATE("");
	    	
	    	strSQL="INSERT INTO SERVICE_FEATURE (" +	    			
	    			"ACCOUNT_ID," +
	    			"SYS_CREATION_DATE," +
	    			"SYS_UPDATE_DATE," +
	    			"PRODUCT_TYPE," +
	    			"PRODUCT_NO," +
	    			"PRICE_PLAN," +
	    			"FEATURE_CODE," +
	    			"EFFECTIVE_DATE," +
	    			"EXPIRATION_DATE," +
	    			"FIRST_VAR_RATE_QTY," +
	    			"ISSUE_DATE" +	    			
	    			") VALUES (" +	    			
	    			"'"+stSERVICE_FEATURE.get(i).getACCOUNT_ID()+"'," +	    			
	    			"to_date('"+stSERVICE_FEATURE.get(i).getSYS_CREATION_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"to_date('"+stSERVICE_FEATURE.get(i).getSYS_UPDATE_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"'"+stSERVICE_FEATURE.get(i).getPRODUCT_TYPE()+"'," +	    
	    			"'"+stSERVICE_FEATURE.get(i).getPRODUCT_NO()+"'," +	    
	    			"'"+stSERVICE_FEATURE.get(i).getPRICE_PLAN()+"'," +	    
	    			"'"+stSERVICE_FEATURE.get(i).getFEATURE_CODE()+"'," +	
	    			"to_date('"+stSERVICE_FEATURE.get(i).getEFFECTIVE_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"to_date('"+stSERVICE_FEATURE.get(i).getEXPIRATION_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"'"+stSERVICE_FEATURE.get(i).getFIRST_VAR_RATE_QTY()+"'," +	    
	    			"to_date('"+stSERVICE_FEATURE.get(i).getISSUE_DATE()+"','YYYYMMDDHH24MISS')" +	
	    			")" ;	    			
	
	    	
	    	
	    	//System.out.println(strSQL);
	    	
	    	x=x+stmt.executeUpdate(strSQL);
	    	
	    	
	        
	    }catch (SQLException ex) {
            System.out.println("*** SQLException caught ***");
            System.out.println("SQLERROR="+strSQL);
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
	
	public static int insert(Connection conn , String sql , ArrayList<String> lst) throws SQLException {
		Statement stmt;
		String strSQL = "";

		stmt = conn.createStatement();
		int x = 0;
		for (int i = 0; i < lst.size(); i++) {
			try {
				strSQL = sql + "values ("+lst.get(i)+") ";
				x = x + stmt.executeUpdate(strSQL);

			} catch (SQLException ex) {
				System.out.println("*** SQLException caught ***");
				System.out.println("SQLERROR=" + strSQL);
				while (ex != null) {
					System.out.println("Message: " + ex.getMessage());
					System.out.println("SQLState: " + ex.getSQLState());
					System.out.println("ErrorCode: " + ex.getErrorCode());
					ex = ex.getNextException();

				}

			} catch (java.lang.Exception ex) {
				System.out.println("*** Exception caught *** <br>");

			} finally {

			}
		}
		
		try {
			// rset.close();
			stmt.close();
		} catch (Exception ignore) {
		}
		return x;
	}
	
	public static int insertFromFile(Connection conn , String sql , String path) throws Exception {
		Statement stmt;
		String strSQL = "";
		BufferedReader reader = null;

		stmt = conn.createStatement();
		int x = 0;
		reader = Files.newBufferedReader(Paths.get(path), Constants.UTF_8);
		String line = "";
		while((line = reader.readLine()) != null){
			try {
				strSQL = sql + "values ("+line+") ";
				x = x + stmt.executeUpdate(strSQL);

			} catch (SQLException ex) {
				System.out.println("*** SQLException caught ***");
				System.out.println("SQLERROR=" + strSQL);
				while (ex != null) {
					System.out.println("Message: " + ex.getMessage());
					System.out.println("SQLState: " + ex.getSQLState());
					System.out.println("ErrorCode: " + ex.getErrorCode());
					ex = ex.getNextException();

				}

			} catch (java.lang.Exception ex) {
				System.out.println("*** Exception caught *** <br>");

			} finally {

			}
		}
		
		try {
			// rset.close();
			stmt.close();
		} catch (Exception ignore) {
		}
		return x;
	}
	
	public static int executeCommand(Connection conn , String path) throws Exception {
		Statement stmt;
		String strSQL = "";
		BufferedReader reader = null;

		stmt = conn.createStatement();
		int x = 0;
		reader = Files.newBufferedReader(Paths.get(path), Charset.defaultCharset());
		String line = "";
		String command = "";
		while((line = reader.readLine()) != null){
			command += line;
		}
			try {
				System.out.println(command);
				stmt.executeUpdate(command);

			} catch (SQLException ex) {
				System.out.println("*** SQLException caught ***");
				System.out.println("SQLERROR=" + strSQL);
				while (ex != null) {
					System.out.println("Message: " + ex.getMessage());
					System.out.println("SQLState: " + ex.getSQLState());
					System.out.println("ErrorCode: " + ex.getErrorCode());
					ex = ex.getNextException();

				}

			} catch (java.lang.Exception ex) {
				System.out.println("*** Exception caught *** <br>");

			} finally {

			}
		
		try {
			// rset.close();
			stmt.close();
		} catch (Exception ignore) {
		}
		return x;
	}
	public static int getCharge(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,String accountIdList, ArrayList<CHARGE> stCHARGE) throws Exception{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	  
	    try {
	    	strSQL="SELECT " +
	    			"ACCOUNT_ID," +
	    			"PRODUCT_NO," +
	    			"CHARGE_TYPE," +
	    			"REVENUE_CODE," +
	    			"ACTV_AMT," +
	    			"TAX_AMT," +
	    			"TAX_CODE," +
	    			"PRICE_PLAN," +
	    			"FEATURE_CODE " +
	    			"FROM CHARGE WHERE CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' " +
    				"and ACCOUNT_ID ='"+accountIdList+"'";
	    	//System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	        while (rset.next()){                            	        	
	        	stCHARGE.add(new CHARGE(
	        			rset.getString("ACCOUNT_ID"),
	        			rset.getString("PRODUCT_NO"),
	        			rset.getString("CHARGE_TYPE"),
	        			rset.getString("REVENUE_CODE"),
	        			rset.getString("ACTV_AMT"),
	        			rset.getString("TAX_AMT"),
	        			rset.getString("TAX_CODE"),
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
	    			"ACCOUNT_ID," +
	    			"PREVIOUS_BALANCE," +
	    			"PAID_AMOUNT," +
	    			"TOTAL_CURRENT_CHARGES," +
	    			"OUTSTANDING_BALANCE  " +	    			
	    			"FROM BILL_PRINT_INFO WHERE CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' " +   				
    				"and ACCOUNT_ID ='"+accountIdList+"' " ;
    				
	    	//System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	        while (rset.next()){                            	        	
	        	stBILL_PRINT_INFO.add(new BILL_PRINT_INFO(
	        			rset.getString("ACCOUNT_ID"),
	        			rset.getString("PREVIOUS_BALANCE"),
	        			rset.getString("PAID_AMOUNT"),
	        			rset.getString("TOTAL_CURRENT_CHARGES"),
	        			rset.getString("OUTSTANDING_BALANCE")
	        			));
	        	
	        }
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
	public static int getBILL(Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,String accountIdList, ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO) throws Exception{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	   
	    try {
	    	
	    	strSQL="SELECT " +	    			
	    			"ACCOUNT_ID," +
	    			"PREVIOUS_AMT," +
	    			"PAYMENT_AMT," +
	    			"TOTAL_NET_AMT," +
	    			"OUTSTANDING_AMT " +	    			
	    			"FROM BILL WHERE CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' and CYCLE_YEAR='"+CYCLE_YEAR+"' " +   				
    				"and ACCOUNT_ID ='"+accountIdList+"' " ;
    				
	    	//System.out.println(strSQL);
	    	rset = stmt.executeQuery(strSQL);
	        while (rset.next()){                            	        	
	        	stBILL_PRINT_INFO.add(new BILL_PRINT_INFO(
	        			rset.getString("ACCOUNT_ID"),
	        			rset.getString("PREVIOUS_AMT"),
	        			rset.getString("PAYMENT_AMT"),
	        			rset.getString("TOTAL_NET_AMT"),
	        			rset.getString("OUTSTANDING_AMT")
	        			));
	        	
	        }
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}
	
	
}
