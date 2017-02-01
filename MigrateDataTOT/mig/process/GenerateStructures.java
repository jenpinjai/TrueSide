package mig.process;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import mig.resources.Constants;

public class GenerateStructures {
	
	public static void generate(String pathFilename , String pathFileCreateTable , String pathFileDropTable ,
			String pathFileCreateIndex , String pathFileDropIndex ,int index_start){
		Workbook workbook = null;
		try {
			BufferedWriter  writer_Create = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathFileCreateTable)));
			BufferedWriter  writer_CreateIndex = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathFileCreateIndex)));
			BufferedWriter  writer_Drop = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathFileDropTable)));
			BufferedWriter  writer_DropIndex = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathFileDropIndex)));
			FileInputStream fis = null; 
			File excel = new File(pathFilename);
			fis = new FileInputStream(excel); 
			int countSheet = 0;
			if (pathFilename.endsWith("xlsx")) {
		        workbook = new XSSFWorkbook(fis);
		    } else if (pathFilename.endsWith("xls")) {
		        workbook = new HSSFWorkbook(fis);
		    } else {
		       System.out.println("The specified file is not Excel file");
		    }
			
			countSheet = workbook.getNumberOfSheets(); 
	
			String sheetName_File = "";
			boolean writeSheetName = true;
			int numSheet = 0;
			String sheetNames = "";
			for (int i = index_start; i < countSheet; i++) {
				
				Sheet sheet = workbook.getSheetAt(i); 
				numSheet ++;
				sheetName_File = sheet.getSheetName();
				sheetNames += sheetName_File + " || ";
				writeSheetName = true;
				Row row = null;
				int countRow = sheet.getLastRowNum();
				String tableName = "";
				String pk  = "";
				String indexTable = "";
				String data = "";
				int countRowTable = 0;
			
				for (int j = 0; j < countRow; j++) {
					row = sheet.getRow(j);
					if((sheet.getRow(j) != null && sheet.getRow(j+1) != null )
							&&(sheet.getRow(j).getCell(0) != null && !"".equals(sheet.getRow(j).getCell(0).getStringCellValue()) )
							&&(sheet.getRow(j).getCell(1) == null || "".equals(sheet.getRow(j).getCell(1).getStringCellValue()))
							&&(sheet.getRow(j+1).getCell(0) != null && !"".equals(sheet.getRow(j+1).getCell(0).getStringCellValue()) )){
						tableName = row.getCell(0).getStringCellValue();
						System.out.println(tableName);
						countRowTable = 0;
						data = "";
						pk = "";
						indexTable = "";
						for(int k = j+2; k <= countRow+1 ; k++){
							
							if((sheet.getRow(k) != null) && (sheet.getRow(k).getCell(0) != null) 
									&& (!"".equals(sheet.getRow(k).getCell(0).getStringCellValue()))){
								if(sheet.getRow(k).getCell(0) != null 
										&& sheet.getRow(k).getCell(1) != null){
									data += ","+sheet.getRow(k).getCell(0).getStringCellValue().trim()+" "
											+sheet.getRow(k).getCell(1).getStringCellValue().trim();
									if(sheet.getRow(k).getCell(2) != null 
											&& "Y".equalsIgnoreCase(sheet.getRow(k).getCell(2).getStringCellValue())){
										data += " NOT NULL \r\n";
									}else{
										data += "\r\n";
									}
									if(sheet.getRow(k).getCell(3) != null 
											&& "Y".equalsIgnoreCase(sheet.getRow(k).getCell(3).getStringCellValue())){
										pk += ","+sheet.getRow(k).getCell(0).getStringCellValue();
									}
//									if(sheet.getRow(k).getCell(4) != null 
//											&& "Y".equalsIgnoreCase(sheet.getRow(k).getCell(4).getStringCellValue())){
//										indexTable += ","+sheet.getRow(k).getCell(0).getStringCellValue();
//									}
									countRowTable++;
								}
							}else{
								if(writeSheetName){
									writer_Create.write("/*********** "+ sheetName_File +" *******************/");
									writer_Create.newLine();
									writer_Create.newLine();
									writer_CreateIndex.write("/*********** "+ sheetName_File +" *******************/");
									writer_CreateIndex.newLine();
									writer_CreateIndex.newLine();
									writer_Drop.write("/*********** "+ sheetName_File +" *******************/");
									writer_Drop.newLine();
									writer_Drop.newLine();
									writer_DropIndex.write("/*********** "+ sheetName_File +" *******************/");
									writer_DropIndex.newLine();
									writer_DropIndex.newLine();
									writeSheetName = false;
								}
								writer_Drop.write("DROP TABLE "+ tableName+";");
								writer_Drop.newLine();
								writer_Create.write("CREATE TABLE "+ tableName +" ( ");
								writer_Create.newLine();
								writer_Create.write(data.substring(1));
								if(!pk.equals("")){
									writer_Create.write(" , PRIMARY KEY ( "+pk.substring(1)+" )");
									writer_Create.newLine();
								}
								writer_Create.write(");");
								writer_Create.newLine();
								writer_Create.newLine();
								
								if(!indexTable.equals("")){
									writer_CreateIndex.write(" CREATE INDEX "+tableName+"_idx ON "+tableName+" ("+indexTable.substring(1)+");");
									writer_CreateIndex.newLine();
									writer_CreateIndex.newLine();
									
									writer_DropIndex.write(" DROP INDEX "+tableName+"_idx;");
									writer_DropIndex.newLine();
									writer_DropIndex.newLine();
								}
								
								j += countRowTable ;
								break;
							}
						}
					}
				}
			}
			
			System.out.println("Process sheet : " + numSheet);
			System.out.println("Sheet name : " + sheetNames);
			  workbook.close();
			  writer_Create.flush();
			  writer_Create.close();
			  writer_Drop.flush();
			  writer_Drop.close();
			  writer_CreateIndex.flush();
			  writer_CreateIndex.close();
			  writer_DropIndex.flush();
			  writer_DropIndex.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String args[]){
// GenerateStructures_sh /home/appadm/var/tea/MigData/Generate/TOdb.xlsx 5
		try {
			String pathFile = args[0];
			int index_start = Integer.parseInt(args[1]);
			
			generate(pathFile,Constants.pathFileCreate , Constants.pathFileDrop ,Constants.pathFileCreateIndex , Constants.pathFileDropIndex,index_start);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
