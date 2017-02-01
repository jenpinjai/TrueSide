package mig.oracle8i;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;

import mig.connnection.Connection8i;
import mig.resources.Constants;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProcessSQL {
	public static String readSql(String pathFilename) {
		Workbook workbook = null;
		String sql = "";
		try {

			/* ############# Read excel ############## */
			FileInputStream fis = null;
			File excel = new File(pathFilename);
			fis = new FileInputStream(excel);
			if (pathFilename.endsWith("xlsx")) {
				workbook = new XSSFWorkbook(fis);
			} else if (pathFilename.endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);
			} else {
				System.out.println("The specified file is not Excel file");
			}
			Sheet sheet = workbook.getSheetAt(0);

			Row row = null;
			int countRow = sheet.getLastRowNum();
			String tableName;
			if (countRow >= 1) {
				row = sheet.getRow(1);
				if (row != null && row.getCell(0) != null) {
					tableName = row.getCell(0).getStringCellValue();
					sql = "select " + row.getCell(1).getStringCellValue();
					sql += " from " + tableName;
					if (row.getCell(2) != null && !"".equals(row.getCell(2).getStringCellValue())) {
						sql += " where " + row.getCell(2).getStringCellValue();
					}
				}
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql;
	}
	
	public static String readSqlInsert(String pathFilename) {
		Workbook workbook = null;
		String sql = "";
		try {

			/* ############# Read excel ############## */
			FileInputStream fis = null;
			File excel = new File(pathFilename);
			fis = new FileInputStream(excel);
			if (pathFilename.endsWith("xlsx")) {
				workbook = new XSSFWorkbook(fis);
			} else if (pathFilename.endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);
			} else {
				System.out.println("The specified file is not Excel file");
			}
			Sheet sheet = workbook.getSheetAt(0);

			Row row = null;
			int countRow = sheet.getLastRowNum();
			String tableName;
			if (countRow >= 1) {
				row = sheet.getRow(1);
				if (row != null && row.getCell(0) != null) {
					tableName = row.getCell(4).getStringCellValue();
					sql = "insert into "+tableName +" (" + row.getCell(3).getStringCellValue()+" )";
				}
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql;
	}


	public static int loadValues(String pathFilename, String index, String sql) {
		Connection conn = null;
		try {

			/* ############# Read excel ############## */
			BufferedWriter writer_temp = null;

			conn = Connection8i.getConnection();
			ResultSet rset = null;
			Statement stmt = conn.createStatement();

			String text = "";
			System.out.println("In process please wiat....");

			rset = stmt.executeQuery(sql + " (" + index + ")");
			if (rset != null) {
				writer_temp = Files.newBufferedWriter(Paths.get(pathFilename), Constants.UTF_8);
				while (rset.next()) {
					ResultSetMetaData rsmd = rset.getMetaData();
					text = "";
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						int type = rsmd.getColumnType(i);
						if (type == Types.DATE) {
							if (rset.getDate(i) != null) {
								// String
								// sysDateTime=dateFormat.format(rset.getDate(i).getTime());
								String sysDateTime = rset.getString(i).substring(0, rset.getString(i).length() - 2);
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
			if (writer_temp != null) {
				writer_temp.close();
			}

			if (rset != null) {
				rset.close();
			}
			if (stmt != null) {
				stmt.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
		return 0;
	}

}
