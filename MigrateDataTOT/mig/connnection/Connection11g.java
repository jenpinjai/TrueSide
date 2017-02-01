package mig.connnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection11g {
	public static Connection getConnection(){
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@172.19.208.69:1555:SBLDEV", "SBLAPPC", "SBLAPPC_DEV");
					    	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
