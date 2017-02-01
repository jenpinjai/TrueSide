package mig.process;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


import mig.connnection.runCommand;
import mig.oracle8i.ProcessSQL;
import mig.resources.Constants;
// CreateNameAddressInfo_sh /home/appadm/var/tea/MigData/NAME_ADDRESS_INFO/input/process01/ xx 01
public class CreateNameAddressInfo {

	
	public static void main(String[] args) throws Exception {
		String pathFileInput=args[0];
		String pathOutput=args[1];
		String pidFile=args[2];
		
		String runOutput = runCommand.executeCommand("touch "+Constants.nameAddressInfoPid+"CreateNameAddressInfo_"+pidFile+".pid");
		System.out.println(runOutput);

		Path pathPid = Paths.get(Constants.nameAddressInfoPid+"CreateNameAddressInfo_"+pidFile+".pid");

		while (Files.exists(pathPid)) {
		 
		
		
		ArrayList<String> listFile = new ArrayList<String>();
		File[] files = new File(pathFileInput).listFiles();
		
		for (File file : files) {
		    if (file.isFile()) {
		    	//System.out.println(file.getName());
		        listFile.add(file.getName());
		    }
		}
		
		String sql=ProcessSQL.readSql(Constants.nameAddressInfoXLS);
		for(int i=0;i<listFile.size();i++){
			if(Files.notExists(pathPid)){
				break;
			}
			try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathFileInput+listFile.get(i)), Constants.UTF_8);){
				String line = "";
				
				while((line = reader.readLine()) != null){
					
					/*String[] parts = listFile.get(i).split("\\.");
					String fileInputWithOutDot = parts[0];
					System.out.println(fileInputWithOutDot+"="+line);
					*/
					System.out.println("File "+listFile.get(i)+" Process ");
					int staturProcess=ProcessSQL.loadValues(Constants.nameAddressInfoOutput+listFile.get(i), line, sql);
					if(staturProcess==0){
						runOutput = runCommand.executeCommand("mv "+pathFileInput+listFile.get(i)+" "+Constants.nameAddressInfoBackUp);
						System.out.println(runOutput);
					}

					
					
				}
				
			} catch (Exception e) {
				throw e;
			}
			
		}
		
	//	System.out.println(sql);
	//	ProcessSQL.loadValues("/home/appadm/var/tea/MigData/NAME_ADDRESS_INFO/output/xxx.txt", line_temp, sql);
		
		
		//CreateNameAddressINFOSql.createSql(line_temp) ;
		
		
		


		}//while 
		System.out.println("End");
	}

}
