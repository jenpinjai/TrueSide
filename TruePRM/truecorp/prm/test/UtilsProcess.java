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
    
               createAUDFileOfAllFile();
    
    }
    
    public static void createAUDFileOfAllFile() throws Exception{
    
            String path ="D:\\OnSide\\TRUE\\visualHome\\var\\ARPayment\\prm";
        
             File  desFolder = new File(path);
        
                File[] files = desFolder.listFiles();
    
                for(File  file: files){
                    String audName = file.getName()+".AUD";
                    File audFile = new File(path+"\\"+audName);
                    if(!audFile.exists()){
                        
                            audFile.createNewFile();
                    }
                    
                }
        
    
    }
    
}
