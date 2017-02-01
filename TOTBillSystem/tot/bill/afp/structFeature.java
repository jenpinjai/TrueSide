package tot.bill.afp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tot.bill.table.FEATURE;


public class structFeature {
	private int ORDER;
	private String CATEGORY_CODE;
	private String FEATURE_DESC;

	public structFeature(int oRDER, String cATEGORY_CODE, String fEATURE_DESC) {
		super();
		ORDER = oRDER;
		CATEGORY_CODE = cATEGORY_CODE;
		FEATURE_DESC = fEATURE_DESC;
	}


	public int getORDER() {
		return ORDER;
	}





	public void setORDER(int oRDER) {
		ORDER = oRDER;
	}





	public String getCATEGORY_CODE() {
		return CATEGORY_CODE;
	}





	public void setCATEGORY_CODE(String cATEGORY_CODE) {
		CATEGORY_CODE = cATEGORY_CODE;
	}





	public String getFEATURE_DESC() {
		return FEATURE_DESC;
	}





	public void setFEATURE_DESC(String fEATURE_DESC) {
		FEATURE_DESC = fEATURE_DESC;
	}





	public static int selectFEATURE (Connection conn,ArrayList<structFeature> stFeature ) throws SQLException{
		Statement stmt ;
	    ResultSet rset = null;
	    String strSQL="";
	    stmt = conn.createStatement();
	    
	    try {
    		strSQL="select " +    				
    				"CATEGORY_CODE," +
    				"CHARGE_DESC" +
    				" from feature group by charge_desc,category_code order by category_code ";		
    		//System.out.println(strSQL);
    		rset = stmt.executeQuery(strSQL);
    		int x=0;
            while (rset.next()){            	
            	stFeature.add(new structFeature(
            			x, 
            			rset.getString("CATEGORY_CODE"),    
                		rset.getString("CHARGE_DESC")                		            		
                		)); 
            	x++;
            	
            }

	    }finally {
	            try { rset.close(); stmt.close(); } catch (Exception ignore) {}
	    }
	    return 0;
	}
    

}
