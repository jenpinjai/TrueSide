/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.process;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import truecorp.prm.business.FileBusiness;
import truecorp.prm.business.PRMBusiness;
import truecorp.prm.core.dao.SystemBaseDao;
import truecorp.prm.dao.TiticPartnerRefBaseDAO;
import truecorp.prm.model.TransactionPartner;
import truecorp.prm.resource.setEnv;
import truecorp.prm.table.TiticPartnerRef;
import truecorp.prm.test.MyUnitTest;

/**
 *
 * @author Jennarong Pinjai
 */
public class ProcessPRMData {
    
    public static void main(String[] args) throws Exception {
        System.out.println(new Date().toLocaleString()+"\t"+"Start ProcessPRMData");
        try{
            MyUnitTest.main(null);
            //List<TransactionPartner> transactionList  =  FileBusiness.readRateSheet();
            File autoSheetFolder = new File(setEnv.EXCEL_RATESHEET_file_INPUT);
            File[] fileArray      = autoSheetFolder.listFiles();
            List<File>     fileList= new ArrayList<File>();
            
            for(File file : fileArray){if(file.isFile())fileList.add(file);}
            ///Sort file
            Comparator<File>  comFile = new Comparator<File>() {

                @Override
                public int compare(File csvFile1, File csvFile2) {
                    
                    String fileName1 = csvFile1.getName().replace(".ctrl", "");
                    String fileName2 = csvFile2.getName().replace(".ctrl", "");
                    
                    Integer day1 = Integer.valueOf(fileName1.substring(fileName1.length()-6, fileName1.length()-4));
                    Integer day2 = Integer.valueOf(fileName2.substring(fileName2.length()-6, fileName2.length()-4));
                
                    return day1.compareTo(day2);
                }
            };
            Collections.sort(fileList,comFile);
            
            
            for(File ctrlFile : fileList){
                    if(ctrlFile.getName().contains(".csv.ctrl")){
                        TransactionPartner  transactionPartner = new TransactionPartner();
                        
                        System.out.println("Current file :"+ctrlFile.getName());
                        File csvFile = new File(setEnv.EXCEL_RATESHEET_file_INPUT+"/"+ctrlFile.getName().replace(".ctrl", ""));
                        
                        
                        if(Integer.valueOf(csvFile.getName().substring(csvFile.getName().length()-6, csvFile.getName().length()-4))==1){
                              System.out.println(new Date().toLocaleString()+"\t"+"Begin process ErlyMonth file name :"+transactionPartner.getFileName());
                              transactionPartner = FileBusiness.readRateSheet(csvFile);
                              transactionPartner.setEalyMonth(true);
//                              PRMBusiness.processEarlyMonth(transactionPartner);
//                              FileBusiness.moveFinshedFiile(transactionPartner.getControlFileName());
//                              FileBusiness.moveFinshedFiile(transactionPartner.getFileName());
                              System.out.println(new Date().toLocaleString()+"\t"+"End process ErlyMonth file name :"+transactionPartner.getFileName());
                        }else{
                              System.out.println(new Date().toLocaleString()+"\t"+"Begin process HalfMonth file name :"+transactionPartner.getFileName());
                              transactionPartner = FileBusiness.readRateSheetChanged(csvFile);
                              PRMBusiness.processHalfMonth(transactionPartner);
                              //FileBusiness.moveFinshedFiile(transactionPartner.getControlFileName());
                              //FileBusiness.moveFinshedFiile(transactionPartner.getFileName());
                              System.out.println(new Date().toLocaleString()+"\t"+"End process HalfMonth file name :"+transactionPartner.getFileName());
                        }
                        
                        
                    }
            
            }
            System.out.println(new Date().toLocaleString()+"\t"+"Success ProcessPRMData ");
        }catch(Exception ex){
            System.out.println(new Date().toLocaleString()+"\t"+"Exception ProcessPRMData :"+ex.getMessage());
            ex.printStackTrace();
        
        }finally{
            ///For close main transaction
            SystemBaseDao.getPrmConnection().close(); //Close DB connection
            
        }
        
    }
}
