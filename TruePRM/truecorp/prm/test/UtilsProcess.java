/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.test;

import java.io.File;

/**
 *
 * @author Jennarong Pinjai
 */
public class UtilsProcess {
    
    public static void main(String[] args) throws Exception{
            
            int switchNum = Integer.valueOf(args[0]);
        
            switch(switchNum){
            
                case 1 :{
                         createAUDFileOfAllFile("D:\\OnSide\\TRUE\\visualHome\\var\\ARPayment\\prm");
                        }break;
                
                case 2 :{
                         createAUDFileOfAllFile("D:\\OnSide\\TRUE\\visualHome\\var\\tea\\SWITCHCDR\\SIEMENSV9");
                        }break;
                    
                case 3:{
                        createCTRLFileOfAllFile("D:\\OnSide\\TRUE\\visualHome\\var\\tea\\SWITCHCDR\\TS9");
                       }break;
                    
                case 4 :{
                         createAUDFileOfAllFile("D:\\OnSide\\TRUE\\visualHome\\var\\tea\\SWITCHCDR\\SIEMENSV15");
                        }break;
            }
            
            
    
    }
    
    public static void createAUDFileOfAllFile(String path) throws Exception{
    
           
        
             File  desFolder = new File(path);
        
                File[] files = desFolder.listFiles();
    
                for(File  file: files){
                    String oldFileName = file.getName();
                    String[] namePart  = oldFileName.split("\\.");
                    if(namePart.length>0&&namePart[namePart.length-1].toUpperCase().equals("ZIP")){
                            if(namePart[namePart.length-1].equals("zip")){
                                oldFileName = oldFileName.replace(".zip", "");
                            }else if(namePart[namePart.length-1].equals("ZIP")){
                                oldFileName = oldFileName.replace(".ZIP", "");
                            }
                    }
                    String audName = oldFileName+".AUD";
                    File audFile = new File(path+"\\"+audName);
                    if(!audFile.exists()){
                        
                            audFile.createNewFile();
                    }
                    
                }
        
    
    }
     public static void createCTRLFileOfAllFile(String path) throws Exception{
    
           
        
             File  desFolder = new File(path);
        
                File[] files = desFolder.listFiles();
    
                for(File  file: files){
                    String oldFileName = file.getName();
                    String[] namePart  = oldFileName.split("\\.");
                    if(namePart.length>0&&namePart[namePart.length-1].toUpperCase().equals("ZIP")){
                            if(namePart[namePart.length-1].equals("zip")){
                                oldFileName = oldFileName.replace(".zip", "");
                            }else if(namePart[namePart.length-1].equals("ZIP")){
                                oldFileName = oldFileName.replace(".ZIP", "");
                            }
                    }
                    String audName = oldFileName+".ctrl";
                    File audFile = new File(path+"\\"+audName);
                    if(!audFile.exists()){
                        
                            audFile.createNewFile();
                    }
                    
                }
        
    
    }
}
