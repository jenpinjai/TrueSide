package mig.process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import mig.connnection.Connection11g;
import mig.resources.Constants;
//LoadNameAddressInfo_sh /home/appadm/var/tea/MigData/NAME_ADDRESS_INFO/configNameAddressInfo.xlsx /home/appadm/var/tea/MigData/NAME_ADDRESS_INFO/output/
public class LoadNameAddressInfo {
	public static void extractData(String excel_path, String text_path) {
		Connection conn = null;
		try {
			System.out.println("Start process ExtractAddressInfo...");
			long startTime = System.currentTimeMillis();
			BufferedReader reader = null;
			String line = null;
			String sql = "";
			Workbook workbook = null;
			FileInputStream fis = null;
			File excel = new File(excel_path);
			fis = new FileInputStream(excel);
			if (excel_path.endsWith("xlsx")) {
				workbook = new XSSFWorkbook(fis);
			} else if (excel_path.endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);
			} else {
				System.out.println(" ExtractAddressInfo The specified file is not Excel file");
			}
			Sheet sheet = workbook.getSheetAt(0);

			Row row = null;
			conn = Connection11g.getConnection();
			Statement stmt = null;
			int countRowTable = 0, countError = 0 , total = 0;
			stmt = conn.createStatement();
			System.out.println(" ExtractAddressInfo In process please wiat....");
			File folder = new File(text_path);
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					row = sheet.getRow(1);
					reader = Files.newBufferedReader(Paths.get(text_path + listOfFiles[i].getName()),
							Constants.UTF_8);
					if (row != null && row.getCell(0) != null) {
						while ((line = reader.readLine()) != null) {
							sql = "insert into " + row.getCell(4).getStringCellValue() + " ( "
									+ row.getCell(3).getStringCellValue() + " )" + " VALUES (";
							sql += line + " )";
							total++;
							try {
								stmt.executeUpdate(sql);
								countRowTable++;
							} catch (Exception e) {
								countError++;
								System.out.println(" ExtractAddressInfo Eror Table : Name_Address_info  sql : " + sql);
							}
						}
					}
					reader.close();
				}
			}
			System.out.println(" ExtractAddressInfo total row : " + total);
			System.out.println(" ExtractAddressInfo Success Insert Table :Name_Address_info  Count row : " + countRowTable);
			System.out.println(" ExtractAddressInfo Error Insert Table : Name_Address_info  Count row : " + countError);

			// }
			workbook.close();
			stmt.close();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			elapsedTime = (elapsedTime / 1000l) / 60;
			System.out.println("ExtractAddressInfo Timme use " + elapsedTime + " minute");
			System.out.println("End process ExtractAddressInfo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
	}
	
	
	public static void main(String args[]){
		try {
			String excel_path = args[0];
			String text_path = args[1];
			extractData(excel_path, text_path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
