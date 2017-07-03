/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import truecorp.prm.business.FileBusiness;
import static truecorp.prm.business.FileBusiness.moveFile;
import truecorp.prm.core.dao.SystemBaseDao;
import truecorp.prm.model.PRMInterface;
import static truecorp.prm.process.ProcessPRMData.sysDateForm;
import truecorp.prm.resource.setEnv;

/**
 *
 * @author Jennarong Pinjai
 */
public class ConvertARToPRMInterface {
    public static  SimpleDateFormat sysDateForm = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss",Locale.US);
    public static  SimpleDateFormat prmDateFileFormat = new SimpleDateFormat("yyyyMMdd_hhmmss",Locale.US);
    public static void main(String[] args) throws Exception{
            System.out.println(sysDateForm.format(new Date())+"\t"+"Start ConvertARToPRMInterface");
            try{
                File arFolder = new File(setEnv.AR_file_INPUT);
                if(!arFolder.isDirectory()){arFolder.mkdirs();}
                File[] fileArray      = arFolder.listFiles();
                List<File>     fileList= new ArrayList<File>();

                for(File file : fileArray){if(file.isFile())fileList.add(file);}
                
                int processFileCount=0;
            for(File ctrlFile : fileList){
                    if(ctrlFile.getName().contains(".AUD")){
                         System.out.println("Current file :"+ctrlFile.getName());
                         File arFile = new File(setEnv.AR_file_INPUT+"/"+ctrlFile.getName().replace(".AUD", ""));
                         System.out.println("Start read :"+arFile.getName());
                         List<PRMInterface> prmInterfaceList = new ArrayList<PRMInterface>();
                         String fileSeq = arFile.getName().substring(arFile.getName().length()-6, arFile.getName().length());
                         FileBusiness.readPRMInterfaceFile(arFile, prmInterfaceList);
                         String dateText = prmDateFileFormat.format(new Date());
                         String fileName="IE02_"+"payment"+"_"+dateText+"_"+String.format("%09d", Integer.valueOf(fileSeq))+".ASC";

                         Writer writerOutputFile = new BufferedWriter(new OutputStreamWriter(
                                            new FileOutputStream(setEnv.PRM_OUTPUT+"/"+fileName),"TIS620")); 
                         
                         int rowCount=1;
                         for(PRMInterface prmInterface : prmInterfaceList){
                             
                                System.out.println(""+prmInterface.getAccountId()+"  "+prmInterface.getProductId()+"  "+prmInterface.getProductType()+"  "+prmInterface.getFeatureCode()+"  "+prmInterface.getActvCode()+"  "+prmInterface.getPymSeqNo());
                                FileBusiness.convertPRMInterfaceToIEFile(prmInterface, writerOutputFile);
                                if(rowCount<prmInterfaceList.size()){
                                    writerOutputFile.write("\r\n");
                                }
                                rowCount++;
                         }
                          processFileCount++;
                         writerOutputFile.close();
                         moveFile(setEnv.AR_file_INPUT+"/"+ctrlFile.getName(),setEnv.PRM_OLD_FILES);
                         moveFile(setEnv.AR_file_INPUT+"/"+arFile.getName(),setEnv.PRM_OLD_FILES);
                    }
            
            
            }
                
                
                
                
            }catch(Exception ex){
                ex.printStackTrace();
            }finally{
                SystemBaseDao.getBillingConnection().close();
            }
            System.out.println(sysDateForm.format(new Date())+"\t"+"End ConvertARToPRMInterface");
    }
}
