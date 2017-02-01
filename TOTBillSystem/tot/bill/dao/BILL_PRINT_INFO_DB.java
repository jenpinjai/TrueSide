package tot.bill.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tot.bill.table.BILL;
import tot.bill.table.BILL_PRINT_INFO;
import tot.bill.table.BILL_QA;

public class BILL_PRINT_INFO_DB {
	public static int InsertBILL_PRINT_INFO (Connection conn,ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO) throws SQLException{
		
		//select * from BILL_PRINT_INFO where due_date is null
		//update BILL_PRINT_INFO set product_no='123456789' where product_no is null;
		//update BILL_PRINT_INFO set bank_name='xxxxxxx',credit_card_no='1234567890' where pym_mtd='DD' and bank_name is null;
		//update BILL_PRINT_INFO set due_date=to_date('20161201','YYYYMMDD') where due_date is null;
		//commit;
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    

	    stmt = conn.createStatement();
	    rset = null;
	    int x=0;
	    for(int i=0;i<stBILL_PRINT_INFO.size();i++){
	    try {
	    	if(stBILL_PRINT_INFO.get(i).getACCOUNT_ID()==null)stBILL_PRINT_INFO.get(i).setACCOUNT_ID("");
	    	if(stBILL_PRINT_INFO.get(i).getACCOUNT_ID()==null)stBILL_PRINT_INFO.get(i).setACCOUNT_ID("");
	    	if(stBILL_PRINT_INFO.get(i).getCYCLE_CODE()==null)stBILL_PRINT_INFO.get(i).setCYCLE_CODE("");
	    	if(stBILL_PRINT_INFO.get(i).getCYCLE_YEAR()==null)stBILL_PRINT_INFO.get(i).setCYCLE_YEAR("");
	    	if(stBILL_PRINT_INFO.get(i).getCYCLE_MONTH()==null)stBILL_PRINT_INFO.get(i).setCYCLE_MONTH("");
	    	if(stBILL_PRINT_INFO.get(i).getSYS_CREATION_DATE()==null)stBILL_PRINT_INFO.get(i).setSYS_CREATION_DATE("");
	    	if(stBILL_PRINT_INFO.get(i).getSYS_UPDATE_DATE()==null)stBILL_PRINT_INFO.get(i).setSYS_UPDATE_DATE("");
	    	if(stBILL_PRINT_INFO.get(i).getZIP_CODE()==null)stBILL_PRINT_INFO.get(i).setZIP_CODE("");
	    	if(stBILL_PRINT_INFO.get(i).getPYM_MTD()==null)stBILL_PRINT_INFO.get(i).setPYM_MTD(""); 
	    	if(stBILL_PRINT_INFO.get(i).getBILL_TYPE()==null)stBILL_PRINT_INFO.get(i).setBILL_TYPE("");
	    	if(stBILL_PRINT_INFO.get(i).getMAX_PAGE()==null)stBILL_PRINT_INFO.get(i).setMAX_PAGE("");
	    	if(stBILL_PRINT_INFO.get(i).getNAME()==null)stBILL_PRINT_INFO.get(i).setNAME("");
	    	if(stBILL_PRINT_INFO.get(i).getADDRESS1()==null)stBILL_PRINT_INFO.get(i).setADDRESS1("");
	    	if(stBILL_PRINT_INFO.get(i).getADDRESS2()==null)stBILL_PRINT_INFO.get(i).setADDRESS2("");
	    	if(stBILL_PRINT_INFO.get(i).getADDRESS3()==null)stBILL_PRINT_INFO.get(i).setADDRESS3("");
	    	if(stBILL_PRINT_INFO.get(i).getADDRESS4()==null)stBILL_PRINT_INFO.get(i).setADDRESS4("");
	    	
	    	if(stBILL_PRINT_INFO.get(i).getNAME_R()==null)stBILL_PRINT_INFO.get(i).setNAME_R("");
	    	if(stBILL_PRINT_INFO.get(i).getADDRESS1_R()==null)stBILL_PRINT_INFO.get(i).setADDRESS1_R("");
	    	if(stBILL_PRINT_INFO.get(i).getADDRESS2_R()==null)stBILL_PRINT_INFO.get(i).setADDRESS2_R("");
	    	if(stBILL_PRINT_INFO.get(i).getADDRESS3_R()==null)stBILL_PRINT_INFO.get(i).setADDRESS3_R("");
	    	if(stBILL_PRINT_INFO.get(i).getADDRESS4_R()==null)stBILL_PRINT_INFO.get(i).setADDRESS4_R("");
	    	
	    	if(stBILL_PRINT_INFO.get(i).getPRODUCT_NO()==null)stBILL_PRINT_INFO.get(i).setPRODUCT_NO("");
	    	if(stBILL_PRINT_INFO.get(i).getINVOICE_NO()==null)stBILL_PRINT_INFO.get(i).setINVOICE_NO("");
	    	if(stBILL_PRINT_INFO.get(i).getACCOUNT_TYPE_DES()==null)stBILL_PRINT_INFO.get(i).setACCOUNT_TYPE_DES("");
	    	if(stBILL_PRINT_INFO.get(i).getBILL_DATE()==null)stBILL_PRINT_INFO.get(i).setBILL_DATE("");
	    	if(stBILL_PRINT_INFO.get(i).getPREVIOUS_BALANCE()==null)stBILL_PRINT_INFO.get(i).setPREVIOUS_BALANCE("");
	    	if(stBILL_PRINT_INFO.get(i).getPAID_AMOUNT()==null)stBILL_PRINT_INFO.get(i).setPAID_AMOUNT("");
	    	if(stBILL_PRINT_INFO.get(i).getPOST_BILL_ADJUSTMENT()==null)stBILL_PRINT_INFO.get(i).setPOST_BILL_ADJUSTMENT("");
	    	if(stBILL_PRINT_INFO.get(i).getTOTAL_CURRENT_CHARGES()==null)stBILL_PRINT_INFO.get(i).setTOTAL_CURRENT_CHARGES("");
	    	if(stBILL_PRINT_INFO.get(i).getOUTSTANDING_BALANCE()==null)stBILL_PRINT_INFO.get(i).setOUTSTANDING_BALANCE(""); 
	    	if(stBILL_PRINT_INFO.get(i).getBANK_NAME()==null)stBILL_PRINT_INFO.get(i).setBANK_NAME("");
	    	if(stBILL_PRINT_INFO.get(i).getCREDIT_CARD_NO()==null)stBILL_PRINT_INFO.get(i).setCREDIT_CARD_NO("");
	    	if(stBILL_PRINT_INFO.get(i).getDUE_DATE()==null)stBILL_PRINT_INFO.get(i).setDUE_DATE("");
	    	if(stBILL_PRINT_INFO.get(i).getBILL_EXTRACT_DATE()==null)stBILL_PRINT_INFO.get(i).setBILL_EXTRACT_DATE("");
	    	if(stBILL_PRINT_INFO.get(i).getQA_ACCOUNT_IND()==null)stBILL_PRINT_INFO.get(i).setQA_ACCOUNT_IND("");
	    	if(stBILL_PRINT_INFO.get(i).getBILL_PRINT_IND()==null)stBILL_PRINT_INFO.get(i).setBILL_PRINT_IND("");
	    	if(stBILL_PRINT_INFO.get(i).getGOVERNMENT_CODE()==null)stBILL_PRINT_INFO.get(i).setGOVERNMENT_CODE("");
	    	if(stBILL_PRINT_INFO.get(i).getSUB_GOV_CODE()==null)stBILL_PRINT_INFO.get(i).setSUB_GOV_CODE("");
	    	if(stBILL_PRINT_INFO.get(i).getPRINT_CATEGORY()==null)stBILL_PRINT_INFO.get(i).setPRINT_CATEGORY("");
	    	
	    	
	    	

	    	
	    	strSQL="INSERT INTO BILL_PRINT_INFO (" +
	    			"ACCOUNT_ID,"+
	    			"CYCLE_CODE,"+
	    			"CYCLE_YEAR,"+
	    			"CYCLE_MONTH,"+
	    			"SYS_CREATION_DATE,"+
	    			"SYS_UPDATE_DATE,"+
	    			"ZIP_CODE,"+
	    			"PYM_MTD ,"+
	    			"BILL_TYPE,"+
	    			"MAX_PAGE,"+
	    			"NAME,"+
	    			"ADDRESS1,"+
	    			"ADDRESS2,"+
	    			"ADDRESS3,"+
	    			"ADDRESS4,"+
	    			"NAME_R,"+
	    			"ADDRESS1_R,"+
	    			"ADDRESS2_R,"+
	    			"ADDRESS3_R,"+
	    			"ADDRESS4_R,"+
	    			"PRODUCT_NO,"+
	    			"INVOICE_NO,"+
	    			"ACCOUNT_TYPE_DES,"+
	    			"BILL_DATE,"+
	    			"PREVIOUS_BALANCE,"+
	    			"PAID_AMOUNT,"+
	    			"POST_BILL_ADJUSTMENT,"+
	    			"TOTAL_CURRENT_CHARGES,"+
	    			"OUTSTANDING_BALANCE,"+
	    			"BANK_NAME,"+
	    			"CREDIT_CARD_NO,"+
	    			"DUE_DATE,"+
	    			"BILL_EXTRACT_DATE,"+
	    			"QA_ACCOUNT_IND,"+
	    			"BILL_PRINT_IND,"+
	    			"GOVERNMENT_CODE,"+
	    			"SUB_GOV_CODE,"+
	    			"PRINT_CATEGORY"+
	    			") VALUES (" +		    				    			
	    			"'"+stBILL_PRINT_INFO.get(i).getACCOUNT_ID()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getCYCLE_CODE()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getCYCLE_YEAR()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getCYCLE_MONTH()+"'," +
	    			"to_date('"+stBILL_PRINT_INFO.get(i).getSYS_CREATION_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"to_date('"+stBILL_PRINT_INFO.get(i).getSYS_UPDATE_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"'"+stBILL_PRINT_INFO.get(i).getZIP_CODE()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getPYM_MTD()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getBILL_TYPE()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getMAX_PAGE()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getNAME()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getADDRESS1()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getADDRESS2()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getADDRESS3()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getADDRESS4()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getNAME_R()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getADDRESS1_R()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getADDRESS2_R()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getADDRESS3_R()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getADDRESS4_R()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getPRODUCT_NO()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getINVOICE_NO()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getACCOUNT_TYPE_DES()+"'," +
	    			"to_date('"+stBILL_PRINT_INFO.get(i).getBILL_DATE()+"','YYYYMMDD')," +
	    			"'"+stBILL_PRINT_INFO.get(i).getPREVIOUS_BALANCE()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getPAID_AMOUNT()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getPOST_BILL_ADJUSTMENT()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getTOTAL_CURRENT_CHARGES()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getOUTSTANDING_BALANCE()+"'," + 
	    			"'"+stBILL_PRINT_INFO.get(i).getBANK_NAME()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getCREDIT_CARD_NO()+"'," +
	    			"to_date('"+stBILL_PRINT_INFO.get(i).getDUE_DATE()+"','YYYYMMDD')," +
	    			"to_date('"+stBILL_PRINT_INFO.get(i).getBILL_EXTRACT_DATE()+"','YYYYMMDD')," +
	    			"'"+stBILL_PRINT_INFO.get(i).getQA_ACCOUNT_IND()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getBILL_PRINT_IND()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getGOVERNMENT_CODE()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getSUB_GOV_CODE()+"'," +
	    			"'"+stBILL_PRINT_INFO.get(i).getPRINT_CATEGORY()+"'" +
	    			")" ;
	    	
	    	
	    	

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
	public static int InsertQA_ACCOUNT_IND (Connection conn,ArrayList<BILL_QA> stBILL_QA,String QA_ACCOUNT_IND) throws SQLException{
		
	
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    

	    stmt = conn.createStatement();
	    rset = null;
	    int x=0;
	    for(int i=0;i<stBILL_QA.size();i++){
	    try {	    	
	    	
	    	strSQL="UPDATE BILL_PRINT_INFO set QA_ACCOUNT_IND='"+QA_ACCOUNT_IND+"' " +	
	    			"where ACCOUNT_ID='"+stBILL_QA.get(i).getACCOUNT_ID()+"' " +
	    			"and CYCLE_CODE='"+stBILL_QA.get(i).getCYCLE_CODE()+"' " +
    				"and CYCLE_MONTH='"+stBILL_QA.get(i).getCYCLE_MONTH()+"' " +
    				"and CYCLE_YEAR='"+stBILL_QA.get(i).getCYCLE_YEAR()+"'";

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
	public static int InsertCF_ACCOUNT_IND (Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,String ACCOUNT_ID) throws SQLException{
		
		
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    

	    stmt = conn.createStatement();
	    rset = null;
	    int x=0;
	   
	    try {	    	
	    	
	    	strSQL="UPDATE BILL_PRINT_INFO set BILL_PRINT_IND='CF' " +	
	    			"where ACCOUNT_ID='"+ACCOUNT_ID+"' " +
	    			"and CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' " +
    				"and CYCLE_YEAR='"+CYCLE_YEAR+"' " ;

	    	System.out.println(strSQL);
	    	
	    	
	    	x=stmt.executeUpdate(strSQL);
	    	
	    	
	        
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
	   
	    try { 
        	//rset.close(); 
        	stmt.close(); 
        } catch (Exception ignore) {}
		return x;
	}
}
