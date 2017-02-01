package mig.process;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import mig.connnection.runCommand;
import mig.oracle8i.ProcessSQL;
import mig.resources.Constants;
//CreateCustomerAccount_sh /home/appadm/var/tea/MigData/COSTOMER_ACCOUNT/input/process01/ xx 01
/*1078  CreateCustomerAccount_sh /home/appadm/var/tea/MigData/COSTOMER_ACCOUNT/input/process01/ xx 01 & 
1079  CreateCustomerAccount_sh /home/appadm/var/tea/MigData/COSTOMER_ACCOUNT/input/process02/ xx 02 &
1080  CreateCustomerAccount_sh /home/appadm/var/tea/MigData/COSTOMER_ACCOUNT/input/process03/ xx 03 &
1081  CreateCustomerAccount_sh /home/appadm/var/tea/MigData/COSTOMER_ACCOUNT/input/process04/ xx 04 &
1082  CreateCustomerAccount_sh /home/appadm/var/tea/MigData/COSTOMER_ACCOUNT/input/process05/ xx 05 &
1083  CreateCustomerAccount_sh /home/appadm/var/tea/MigData/COSTOMER_ACCOUNT/input/process06/ xx 06 &
1084  CreateCustomerAccount_sh /home/appadm/var/tea/MigData/COSTOMER_ACCOUNT/input/process07/ xx 07 &
1085  CreateCustomerAccount_sh /home/appadm/var/tea/MigData/COSTOMER_ACCOUNT/input/process08/ xx 08 &
1086  CreateCustomerAccount_sh /home/appadm/var/tea/MigData/COSTOMER_ACCOUNT/input/process09/ xx 09 &
1087   CreateCustomerAccount_sh /home/appadm/var/tea/MigData/COSTOMER_ACCOUNT/input/process10/ xx 10 &
*/
public class CreateCustomerAccount {
	public static void main(String[] args) throws Exception {
		String pathFileInput=args[0];
		String pathOutput=args[1];
		String pidFile=args[2];
		
		String runOutput = runCommand.executeCommand("touch "+Constants.customerAccountPid+"CreateCustomerAccount_"+pidFile+".pid");
		System.out.println(runOutput);

		Path pathPid = Paths.get(Constants.customerAccountPid+"CreateCustomerAccount_"+pidFile+".pid");

		while (Files.exists(pathPid)) {
		 
		
		
		ArrayList<String> listFile = new ArrayList<String>();
		File[] files = new File(pathFileInput).listFiles();
		
		for (File file : files) {
		    if (file.isFile()) {
		    	//System.out.println(file.getName());
		        listFile.add(file.getName());
		    }
		}
		
		String sql=ProcessSQL.readSql(Constants.customerAccountXLS);
		for(int i=0;i<listFile.size();i++){
			if(Files.notExists(pathPid)){
				break;
			}
			try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathFileInput+listFile.get(i)), Constants.UTF_8);){
				String line = "";
				
				while((line = reader.readLine()) != null){
					
				
					System.out.println("File "+listFile.get(i)+" Process ");
					int staturProcess=ProcessSQL.loadValues(Constants.customerAccountOutput+listFile.get(i), line, sql);
					if(staturProcess==0){
						runOutput = runCommand.executeCommand("mv "+pathFileInput+listFile.get(i)+" "+Constants.customerAccountBackUp);
						System.out.println(runOutput);
					}
					
					
				}
				
			} catch (Exception e) {
				throw e;
			}
			
		}
		
	
		
		
		


		}//while 
		System.out.println("End");
	}
}
