package tot.bill.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tot.bill.table.ACCOUNT_LIST_XX;
import tot.bill.table.BILL;

public class BILL_DB {
	public static int InsertBILL (Connection conn,ArrayList<BILL> stBILL) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    

	    stmt = conn.createStatement();
	    rset = null;
	    int x=0;
	    for(int i=0;i<stBILL.size();i++){
	    try {
	    	
	    
	    	if(stBILL.get(i).getACCOUNT_ID()==null)stBILL.get(i).setACCOUNT_ID("");
	    	if(stBILL.get(i).getCYCLE_CODE()==null)stBILL.get(i).setCYCLE_CODE("");
	    	if(stBILL.get(i).getCYCLE_MONTH()==null)stBILL.get(i).setCYCLE_MONTH("");
	    	if(stBILL.get(i).getCYCLE_YEAR()==null)stBILL.get(i).setCYCLE_YEAR("");
	    	if(stBILL.get(i).getSYS_CREATION_DATE()==null)stBILL.get(i).setSYS_CREATION_DATE("");
	    	if(stBILL.get(i).getSYS_UPDATE_DATE()==null)stBILL.get(i).setSYS_UPDATE_DATE("");
	    	if(stBILL.get(i).getBILL_CREATE_DATE()==null)stBILL.get(i).setBILL_CREATE_DATE("");
	    	if(stBILL.get(i).getBILL_EXTRACT_DATE()==null)stBILL.get(i).setBILL_EXTRACT_DATE("");
	    	if(stBILL.get(i).getBILL_CONFIRM_DATE()==null)stBILL.get(i).setBILL_CONFIRM_DATE("");
	    	if(stBILL.get(i).getPREVIOUS_AMT()==null)stBILL.get(i).setPREVIOUS_AMT("");
	    	if(stBILL.get(i).getPAYMENT_AMT()==null)stBILL.get(i).setPAYMENT_AMT("");
	    	if(stBILL.get(i).getCUR_CHARGE_AMT()==null)stBILL.get(i).setCUR_CHARGE_AMT("");
	    	if(stBILL.get(i).getCUR_CREDIT_AMT()==null)stBILL.get(i).setCUR_CREDIT_AMT("");
	    	if(stBILL.get(i).getCUR_DISCOUNT_AMT()==null)stBILL.get(i).setCUR_DISCOUNT_AMT("");
	    	if(stBILL.get(i).getCUR_RC_AMT()==null)stBILL.get(i).setCUR_RC_AMT("");
	    	if(stBILL.get(i).getCUR_OC_AMT()==null)stBILL.get(i).setCUR_OC_AMT("");
	    	if(stBILL.get(i).getCUR_UC_AMT()==null)stBILL.get(i).setCUR_UC_AMT("");
	    	if(stBILL.get(i).getTOTAL_CHARGE_AMT()==null)stBILL.get(i).setTOTAL_CHARGE_AMT("");
	    	if(stBILL.get(i).getTOTAL_TAX_AMT()==null)stBILL.get(i).setTOTAL_TAX_AMT("");
	    	if(stBILL.get(i).getTOTAL_NET_AMT()==null)stBILL.get(i).setTOTAL_NET_AMT("");
	    	if(stBILL.get(i).getTOTAL_ADJUST_AMT()==null)stBILL.get(i).setTOTAL_ADJUST_AMT("");
	    	if(stBILL.get(i).getTOTAL_ADJUST_TAX_AMT()==null)stBILL.get(i).setTOTAL_ADJUST_TAX_AMT("");
	    	if(stBILL.get(i).getTOTAL_ADJUST_NET_AMT()==null)stBILL.get(i).setTOTAL_ADJUST_NET_AMT(""); 
	    	if(stBILL.get(i).getOUTSTANDING_AMT()==null)stBILL.get(i).setOUTSTANDING_AMT(""); 
	    	if(stBILL.get(i).getINVOICE_NUMBER()==null)stBILL.get(i).setINVOICE_NUMBER(""); 
	    	if(stBILL.get(i).getACCOUNT_TYPE()==null)stBILL.get(i).setACCOUNT_TYPE("");
	    	if(stBILL.get(i).getACCOUNT_SUB_TYPE()==null)stBILL.get(i).setACCOUNT_SUB_TYPE(""); 
	    	if(stBILL.get(i).getPYM_MTD()==null)stBILL.get(i).setPYM_MTD(""); 
	    	if(stBILL.get(i).getBANK_CODE()==null)stBILL.get(i).setBANK_CODE("");
	    	if(stBILL.get(i).getBANK_ACCOUNT_NO()==null)stBILL.get(i).setBANK_ACCOUNT_NO(""); 
	    	if(stBILL.get(i).getDUE_DATE()==null)stBILL.get(i).setDUE_DATE(""); 
	    	if(stBILL.get(i).getBILL_TYPE()==null)stBILL.get(i).setBILL_TYPE(""); 
	    	if(stBILL.get(i).getPRESENT_PRODUCT_NO()==null)stBILL.get(i).setPRESENT_PRODUCT_NO(""); 
	    	if(stBILL.get(i).getBILL_STATUS()==null)stBILL.get(i).setBILL_STATUS(""); 

	    	
	    	
	    	strSQL="INSERT INTO BILL (" +
	    			"ACCOUNT_ID,"+
	    			"CYCLE_CODE,"+
	    			"CYCLE_MONTH,"+
	    			"CYCLE_YEAR,"+
	    			"SYS_CREATION_DATE,"+
	    			"SYS_UPDATE_DATE,"+
	    			"BILL_CREATE_DATE,"+
	    			"BILL_EXTRACT_DATE,"+
	    			"BILL_CONFIRM_DATE,"+
	    			"PREVIOUS_AMT,"+
	    			"PAYMENT_AMT,"+
	    			"CUR_CHARGE_AMT,"+
	    			"CUR_CREDIT_AMT,"+
	    			"CUR_DISCOUNT_AMT,"+
	    			"CUR_RC_AMT,"+
	    			"CUR_OC_AMT,"+
	    			"CUR_UC_AMT,"+
	    			"TOTAL_CHARGE_AMT,"+
	    			"TOTAL_TAX_AMT,"+
	    			"TOTAL_NET_AMT,"+
	    			"TOTAL_ADJUST_AMT,"+
	    			"TOTAL_ADJUST_TAX_AMT,"+  
	    			"TOTAL_ADJUST_NET_AMT,"+ 
	    			"OUTSTANDING_AMT,"+ 
	    			"INVOICE_NUMBER,"+ 
	    			"ACCOUNT_TYPE,"+ 
	    			"ACCOUNT_SUB_TYPE,"+ 
	    			"PYM_MTD,"+ 
	    			"BANK_CODE,"+
	    			"BANK_ACCOUNT_NO,"+ 
	    			"DUE_DATE,"+ 
	    			"BILL_TYPE,"+ 
	    			"PRESENT_PRODUCT_NO,"+ 
	    			"BILL_STATUS"+ 
	    			") VALUES (" +	    			
	    			"'"+stBILL.get(i).getACCOUNT_ID()+"'," +
	    			"'"+stBILL.get(i).getCYCLE_CODE()+"'," +
	    			"'"+stBILL.get(i).getCYCLE_MONTH()+"'," +
	    			"'"+stBILL.get(i).getCYCLE_YEAR()+"'," +
	    			"to_date('"+stBILL.get(i).getSYS_CREATION_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"to_date('"+stBILL.get(i).getSYS_UPDATE_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"to_date('"+stBILL.get(i).getBILL_CREATE_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"to_date('"+stBILL.get(i).getBILL_EXTRACT_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"to_date('"+stBILL.get(i).getBILL_CONFIRM_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"'"+stBILL.get(i).getPREVIOUS_AMT()+"'," +
	    			"'"+stBILL.get(i).getPAYMENT_AMT()+"'," +
	    			"'"+stBILL.get(i).getCUR_CHARGE_AMT()+"'," +
	    			"'"+stBILL.get(i).getCUR_CREDIT_AMT()+"'," +
	    			"'"+stBILL.get(i).getCUR_DISCOUNT_AMT()+"'," +
	    			"'"+stBILL.get(i).getCUR_RC_AMT()+"'," +
	    			"'"+stBILL.get(i).getCUR_OC_AMT()+"'," +
	    			"'"+stBILL.get(i).getCUR_UC_AMT()+"'," +
	    			"'"+stBILL.get(i).getTOTAL_CHARGE_AMT()+"'," +
	    			"'"+stBILL.get(i).getTOTAL_TAX_AMT()+"'," +
	    			"'"+stBILL.get(i).getTOTAL_NET_AMT()+"'," +
	    			"'"+stBILL.get(i).getTOTAL_ADJUST_AMT()+"'," +
	    			"'"+stBILL.get(i).getTOTAL_ADJUST_TAX_AMT()+"'," +  
	    			"'"+stBILL.get(i).getTOTAL_ADJUST_NET_AMT()+"'," + 
	    			"'"+stBILL.get(i).getOUTSTANDING_AMT()+"'," + 
	    			"'"+stBILL.get(i).getINVOICE_NUMBER()+"'," + 
	    			"'"+stBILL.get(i).getACCOUNT_TYPE()+"'," + 
	    			"'"+stBILL.get(i).getACCOUNT_SUB_TYPE()+"'," + 
	    			"'"+stBILL.get(i).getPYM_MTD()+"'," + 
	    			"'"+stBILL.get(i).getBANK_CODE()+"'," +
	    			"'"+stBILL.get(i).getBANK_ACCOUNT_NO()+"'," + 
	    			"to_date('"+stBILL.get(i).getDUE_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"'"+stBILL.get(i).getBILL_TYPE()+"'," + 
	    			"'"+stBILL.get(i).getPRESENT_PRODUCT_NO()+"'," +
	    			"'"+stBILL.get(i).getBILL_STATUS()+"'" + 
	    			")" ;	    			
	
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
public static int InsertCF_ACCOUNT_IND (Connection conn,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR,String ACCOUNT_ID) throws SQLException{
		
		
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    

	    stmt = conn.createStatement();
	    rset = null;
	    int x=0;
	   
	    try {	    	
	    	
	    	strSQL="UPDATE BILL set BILL_STATUS='C' " +	
	    			"where ACCOUNT_ID='"+ACCOUNT_ID+"' " +
	    			"and CYCLE_CODE='"+CYCLE_CODE+"' " +
    				"and CYCLE_MONTH='"+CYCLE_MONTH+"' " +
    				"and CYCLE_YEAR='"+CYCLE_YEAR+"'";

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
