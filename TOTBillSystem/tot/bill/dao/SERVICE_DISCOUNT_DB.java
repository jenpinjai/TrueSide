package tot.bill.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tot.bill.table.SERVICE_DISCOUNT;

public class SERVICE_DISCOUNT_DB {
	public static int selectSERVICE_DISCOUNT (Connection conn, ArrayList<String> idSERVICE_DISCOUNT,ArrayList<SERVICE_DISCOUNT> stSERVICE_DISCOUNT) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
	    	strSQL="select " +	    
					"sd.ACCOUNT_ID," +
					"sd.PRODUCT_TYPE," +
					"sd.PRODUCT_NO," +
					"sd.DISCOUNT_CODE," +
					"sd.DISCOUNT_TYPE," +
					"to_char(sd.SYS_CREATION_DATE,'YYYYMMDD') as SYS_CREATION_DATE," +
					"to_char(sd.SYS_UPDATE_DATE,'YYYYMMDD') as SYS_UPDATE_DATE," +
					"to_char(sd.EFFECTIVE_DATE,'YYYYMMDD') as EFFECTIVE_DATE," +
	    			"to_char(sd.EXPIRATION_DATE,'YYYYMMDD') as EXPIRATION_DATE" +
	    			" from SERVICE_DISCOUNT sd , DISCOUNT_RATE dr "
	    			+ " where sd.discount_code = dr.discount_code  order by sd.ACCOUNT_ID , dr.PLAN_RANK , dr.discount_code";
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
	        			rset.getString("SYS_CREATION_DATE"), 
	        			rset.getString("SYS_UPDATE_DATE"), 
	        			rset.getString("EFFECTIVE_DATE"), 
	        			rset.getString("EXPIRATION_DATE")
	        			));
	        }
	
	    }finally {
	        try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    
	    return 0;
	}

}
