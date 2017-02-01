package mig.connnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection8i {
	public static Connection getConnection(){
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@172.18.53.8:1521:BCVCUST01", "CSMAPPC", "csmoct19");
					    	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
