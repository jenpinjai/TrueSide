package mig.oracle8i;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;

import mig.connnection.Connection8i;
import mig.resources.Constants;

public class CreateNameAddressINFOSql {
	public static int createSql(String index ) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		conn = Connection8i.getConnection();
		ResultSet rset = null;
		stmt= conn.createStatement();
		String sql="";
		String text="";
		rset = stmt.executeQuery(sql+" (" + index.substring(1) + ")");
		if (rset != null) {
			BufferedWriter writer_temp = Files.newBufferedWriter(
					Paths.get("/home/appadm/var/tea/MigData/NAME_ADDRESS_INFO/output/xxx.txt"), 
					Constants.UTF_8);
			while (rset.next()) {
				
				ResultSetMetaData rsmd = rset.getMetaData();
				text = "";
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					int type = rsmd.getColumnType(i);
					if (type == Types.DATE) {
						if (rset.getDate(i) != null) {
							// String
							// sysDateTime=dateFormat.format(rset.getDate(i).getTime());
							String sysDateTime = rset.getString(i).substring(0,
									rset.getString(i).length() - 2);
							text += ",to_date('" + sysDateTime + "','YYYY-MM-DD HH24:MI:SS')";
						} else {
							text += ", null ";
						}
					} else if (type == Types.CHAR || type == Types.VARCHAR) {
						if (rset.getString(i) != null) {
							text += ",'" + rset.getString(i).trim() + "'";
						} else {
							text += ", null ";
						}
					} else if (type == Types.INTEGER || type == Types.NUMERIC) {

						if (rset.getBigDecimal(i) != null) {
							text += "," + rset.getString(i).trim();
						} else {
							text += ", null ";
						}
					} else if (type == Types.DOUBLE) {
						text += "," + Double.toString(rset.getDouble(i));
					} else if (type == Types.DECIMAL) {
						if (rset.getBigDecimal(i) != null) {
							text += "," + Double.toString(rset.getBigDecimal(i).doubleValue());
						} else {
							text += ", null ";
						}
					} else {
						if (rset.getString(i) != null) {
							text += ",'" + rset.getString(i).trim() + "'";
						} else {
							text += ", null ";
						}
					}

				}
				if (text != null && text.length() > 1) {
					writer_temp.write(text.substring(1));
					writer_temp.newLine();

				}
			}
			writer_temp.close();
		}
		index = "";
		return 0;
	}
}
