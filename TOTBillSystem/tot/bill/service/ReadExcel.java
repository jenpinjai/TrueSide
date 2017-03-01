/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tot.bill.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import tot.bill.table.BILL_QA;

/**
 *
 * @author Jennarong Pinjai
 */
public class ReadExcel {
    
    public static int readQABill(String filePath,ArrayList<BILL_QA> billQaList){
         System.out.println("ReadExcel.readQABill Start");
        try{
        
            FileInputStream inputStreamFile = new FileInputStream(filePath);
            Workbook wb = WorkbookFactory.create(inputStreamFile);
            Sheet firstSheet = wb.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.rowIterator();
            Row firstRow = iterator.next();
            int reccordNum=0;
            while (iterator.hasNext()) {
                       reccordNum++;
                       Row nextRow = iterator.next();
                       BILL_QA bill = new BILL_QA();
                       System.out.println("ReadExcel.readQABill-->Record "+reccordNum+" acc_id:"+nextRow.getCell(0).toString());
                       if (nextRow.getCell(0).toString().trim().length() == 0) {
                                break;
                       }
                       bill.setACCOUNT_ID(nextRow.getCell(0)==null?"":nextRow.getCell(0).toString());
                       bill.setCYCLE_CODE(nextRow.getCell(1)==null?"":nextRow.getCell(1).toString());
                       bill.setCYCLE_YEAR(nextRow.getCell(2)==null?"":nextRow.getCell(2).toString());
                       bill.setCYCLE_MONTH(nextRow.getCell(3)==null?"":nextRow.getCell(3).toString());
                       bill.setSYS_CREATION_DATE(nextRow.getCell(4)==null?"":nextRow.getCell(4).toString());
                       bill.setSYS_UPDATE_DATE(nextRow.getCell(5)==null?"":nextRow.getCell(5).toString());
                       bill.setDESCRIPTION(nextRow.getCell(6)==null?"":nextRow.getCell(6).toString());
                       
                       billQaList.add(bill);
            }
            System.out.println("ReadExcel.readQABill End");
        }catch(Exception ex){
        
            ex.printStackTrace();
        
        }
    
        return 0;
    }
    
    public static int moveFile(String filePath,String folderPath){
    
        try{
                File destinationFolder = new File(folderPath);
                File file = new File(filePath);

                if (!destinationFolder.exists())
                {
                    destinationFolder.mkdirs();
                }

                // Check weather source exists and it is folder.
                if (file.exists())
                {
                    if (file != null)
                    {
                       
                            // Move files to destination folder
                            file.renameTo(new File(destinationFolder + "/" + file.getName()));
                        
                        // Add if you want to delete the source folder 
                        file.delete();
                    }
                }
                else
                {
                    System.out.println(file + "  Folder does not exists");
                }
        
        
            
            
            
        }catch(Exception ex){
        
            ex.printStackTrace();
        
        }
        return 0;
    }
    
}
