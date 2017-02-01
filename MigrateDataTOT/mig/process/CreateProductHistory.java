package mig.process;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.ArrayList;

import mig.connnection.Connection11g;
import mig.connnection.Connection8i;
import mig.connnection.runCommand;
import mig.oracle8i.ProcessSQL;
import mig.oracle8i.Sql11g;
import mig.oracle8i.Sql8i;
import mig.resources.Constants;

public class CreateProductHistory  {
	// CreateProductHistory_sh /home/appadm/var/tea/MigData/PRODUCT_HISTORY/input/process01/ 01
	public static void main(String[] args) throws Exception {
		String pathFileInput=args[0];		
		String pidFile=args[1];
		
		String runOutput = runCommand.executeCommand("touch "+Constants.productHistoryPid+"CreateProductHistory_"+pidFile+".pid");
		System.out.println(runOutput);

		Path pathPid = Paths.get(Constants.productHistoryPid+"CreateProductHistory_"+pidFile+".pid");
		
		Connection conn8i = null;		
		conn8i = Connection8i.getConnection();
		
		Connection conn11g = null;		
		conn11g = Connection11g.getConnection();
		
		//while (Files.exists(pathPid)) {
			
			ArrayList<String> listFile = new ArrayList<String>();
			File[] files = new File(pathFileInput).listFiles();
			
			for (File file : files) {
			    if (file.isFile()) {
			    	//System.out.println(file.getName());
			        listFile.add(file.getName());
			    }
			}
			
			for(int i=0;i<listFile.size();i++){
				if(Files.notExists(pathPid)){
					break;
				}
				try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathFileInput+listFile.get(i)), Constants.UTF_8);){
					String accountIdList = "";
					
					while((accountIdList = reader.readLine()) != null){
					
						System.out.println("File "+listFile.get(i)+" Process ");
						int staturProcess=0;
						int recordSelect=0;
						int recordInsert=0;
						//System.out.println(accountIdList);
						ArrayList<String> lst=new ArrayList<String>();
						String sql = ProcessSQL.readSql(Constants.productHistoryXLS);
						sql += " ( " + accountIdList + ") ";
						Sql8i.load(conn8i, sql, lst);
						
						sql = ProcessSQL.readSqlInsert(Constants.productHistoryXLS);
						recordInsert=Sql11g.insert(conn11g, sql, lst);
						recordSelect=lst.size();
						if(recordInsert!=recordSelect){
							staturProcess=-1;
						}
						
						if(staturProcess==0){
							runOutput = runCommand.executeCommand("mv "+pathFileInput+listFile.get(i)+" "+Constants.productHistoryBackUp);
							System.out.println(runOutput);
						}
					}
					
				} catch (Exception e) {
					throw e;
				}
				
			}

		//}//while 
		try {
			conn8i.close();	
			conn11g.close();	
		} catch (Exception e2) {
		}
			System.out.println("End");
	}
}

