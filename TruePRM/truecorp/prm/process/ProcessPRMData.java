/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import truecorp.prm.business.FileBusiness;
import truecorp.prm.business.PRMBusiness;
import truecorp.prm.core.dao.SystemBaseDao;
import truecorp.prm.model.TransactionPartner;
import truecorp.prm.resource.setEnv;
import truecorp.prm.test.MyUnitTest;

/**
 *
 * @author Jennarong Pinjai
 */
public class ProcessPRMData {
    
    public static  Writer logWriter = createLogWriter();
    public static  SimpleDateFormat sysDateForm = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss",Locale.US);
    public static void main(String[] args) throws Exception {
        System.out.println(sysDateForm.format(new Date())+"\t"+"Start ProcessPRMData");
        try{
            MyUnitTest.main(null);
            //List<TransactionPartner> transactionList  =  FileBusiness.readRateSheet();
            File autoSheetFolder = new File(setEnv.EXCEL_RATESHEET_file_INPUT);
            File[] fileArray      = autoSheetFolder.listFiles();
            List<File>     fileList= new ArrayList<File>();
            List<String> partnerCdErrorList = new ArrayList<String>();
            
            for(File file : fileArray){if(file.isFile())fileList.add(file);}
            ///Sort file
            Comparator<File>  comFile = new Comparator<File>() {

                @Override
                public int compare(File csvFile1, File csvFile2) {
                    
                    String fileName1 = csvFile1.getName().replace(".ctrl", "");
                    String fileName2 = csvFile2.getName().replace(".ctrl", "");
                    
                    Integer day1 = Integer.valueOf(fileName1.substring(fileName1.length()-13, fileName1.length()-11));
                    Integer day2 = Integer.valueOf(fileName2.substring(fileName2.length()-13, fileName2.length()-11));
                   
                    return day1.compareTo(day2);
                }
            };
            Collections.sort(fileList,comFile);
            
            int processFileCount=0;
            for(File ctrlFile : fileList){
                    if(ctrlFile.getName().contains(".csv.ctrl")){
                        TransactionPartner  transactionPartner = new TransactionPartner();
                        
                        System.out.println("Current file :"+ctrlFile.getName());
                        File csvFile = new File(setEnv.EXCEL_RATESHEET_file_INPUT+"/"+ctrlFile.getName().replace(".ctrl", ""));
                        
                        processFileCount++;
                        if(!csvFile.isFile())continue;
                        if(Integer.valueOf(csvFile.getName().substring(csvFile.getName().length()-13, csvFile.getName().length()-11))==1){
                              System.out.println(sysDateForm.format(new Date())+"\t"+"Begin process ErlyMonth file name :"+csvFile.getName());
                              try{
                                    FileBusiness.readRateSheet(csvFile,transactionPartner);
                                    if(partnerCdErrorList.contains(transactionPartner.getPartnerCd()+transactionPartner.getServiceType())){
                                            System.out.println(sysDateForm.format(new Date())+"\t"+"Skip file :"+csvFile.getName());
                                            continue;
                                    }
                              }catch(Exception ex){
                                    if(ex.getMessage().equals("ADDRDUP")){
                                        logWriter.write("ERROR "+csvFile.getName()+"_adddup"+"\r\n");
                                        System.out.println(sysDateForm.format(new Date())+"ERROR "+csvFile.getName()+"_adddup");
                                        System.out.println(sysDateForm.format(new Date())+"\t"+"Skip file :"+csvFile.getName());
                                        partnerCdErrorList.add(transactionPartner.getPartnerCd()+transactionPartner.getServiceType());
                                        continue;
                                        
                                    }else{
                                    
                                        throw ex;
                                    
                                    }
                                  
                              }
                              if(transactionPartner.getPrmCd()==null){
                                  System.out.println(sysDateForm.format(new Date())+"\t"+"ERROR PRMCD not found ,file name :"+csvFile.getName());
                                  logWriter.write("ERROR "+csvFile.getName()+"_nomatch"+"\r\n");
                                  System.out.println(sysDateForm.format(new Date())+"\t"+"Skip file :"+csvFile.getName());
                                  partnerCdErrorList.add(transactionPartner.getPartnerCd()+transactionPartner.getServiceType());
                                  continue;
                              }
                              transactionPartner.setEalyMonth(true);
                              PRMBusiness.processEarlyMonth(transactionPartner);
                              FileBusiness.moveFinshedFiile(transactionPartner.getControlFileName());
                              FileBusiness.moveFinshedFiile(transactionPartner.getFileName());
                              System.out.println(sysDateForm.format(new Date())+"\t"+"End process ErlyMonth <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                              
                        }else{
                              System.out.println(sysDateForm.format(new Date())+"\t"+"Begin process HalfMonth file name :"+csvFile.getName());
                              
                              try{      
                                    FileBusiness.readRateSheetChanged(csvFile,transactionPartner);
                                    if(partnerCdErrorList.contains(transactionPartner.getPartnerCd()+transactionPartner.getServiceType())){
                                            System.out.println(sysDateForm.format(new Date())+"\t"+"Skip file :"+csvFile.getName());
                                            continue;
                                    }
                              }catch(Exception ex){
                                    ex.printStackTrace();
                                    if(ex.getMessage().equals("NOCHANGE")){
                                         logWriter.write("INFORM "+csvFile.getName()+"_nochange"+"\r\n");
                                         System.out.println(sysDateForm.format(new Date())+"\t"+"Skip file :"+csvFile.getName());
                                         continue;
                                    }else{
                                        throw ex;
                                    }
                              }
                              if(transactionPartner.getRateSheetList().isEmpty()){
                                    logWriter.write("INFORM "+csvFile.getName()+"_nochange"+"\r\n");
                                    System.out.println(sysDateForm.format(new Date())+"\t"+"Skip file :"+csvFile.getName());
                                    continue;
                              }
                              if(transactionPartner.getPrmCd()==null){
                                  System.out.println(sysDateForm.format(new Date())+"\t"+"ERROR PRMCD not found file name :"+csvFile.getName());
                                  logWriter.write("ERROR "+csvFile.getName()+"_nomatch"+"\r\n");
                                  System.out.println(sysDateForm.format(new Date())+"\t"+"Skip file :"+csvFile.getName());
                                  partnerCdErrorList.add(transactionPartner.getPartnerCd()+transactionPartner.getServiceType());
                                  continue;
                              }
                              PRMBusiness.processHalfMonth(transactionPartner);
                              FileBusiness.moveFinshedFiile(transactionPartner.getControlFileName());
                              FileBusiness.moveFinshedFiile(transactionPartner.getFileName());
                              System.out.println(sysDateForm.format(new Date())+"\t"+"End process HalfMonth <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        }
                        
                        
                    }
            
            }
            if(processFileCount==0)System.out.println(sysDateForm.format(new Date())+"\tDidn't have file for process !!!!!!!!");
            System.out.println(sysDateForm.format(new Date())+"\t"+"Success ProcessPRMData ");
        }catch(Exception ex){
            System.out.println(sysDateForm.format(new Date())+"\t"+"Exception ProcessPRMData :"+ex.getMessage());
            ex.printStackTrace();
        
        }finally{
            ///For close main transaction
            SystemBaseDao.getPrmConnection().close(); //Close DB connection
            logWriter.close();
        }
        
    }
    public static Writer createLogWriter(){
        
         Writer writerOutputFile=null;
         try {
                String dateSystem = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        	if(Files.exists(Paths.get(setEnv.EXCEL_RATESHEET_OUTPUT+"/"+"error"+dateSystem+".log"))){
        		Files.delete(Paths.get(setEnv.EXCEL_RATESHEET_OUTPUT+"/"+"error"+dateSystem+".log"));
        	}
        	writerOutputFile = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(setEnv.EXCEL_RATESHEET_OUTPUT+"/"+"error"+dateSystem+".log"),"TIS620")); 
            return writerOutputFile;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;  
        } 
    }
}
