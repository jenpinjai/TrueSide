package tot.bill.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class createConnectionDB {
	
    public static Connection openConnectBillDB()throws  IOException {
		
		String ipBILL=System.getenv("ipBILL");
		String userBILL=System.getenv("userBILL");
		String passwordBILL=System.getenv("passwordBILL");
        Connection result;
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	result = DriverManager.getConnection(ipBILL, userBILL,passwordBILL);
        } catch (Exception e) {
        	throw new RuntimeException(e.getMessage(), e);
        }
        
        return result;
    }
public static Connection openConnectPRMDB()throws  IOException {
		String ipPRM=System.getenv("ipPRM");
	    String userPRM=System.getenv("userPRM");
	    String passwordPRM=System.getenv("passwordPRM");
        Connection result;
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	result = DriverManager.getConnection(ipPRM, userPRM,passwordPRM);
        } catch (Exception e) {
        	throw new RuntimeException(e.getMessage(), e);
        }
        
        return result;
    }

}
