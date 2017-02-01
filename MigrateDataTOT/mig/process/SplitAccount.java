package mig.process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import mig.resources.Constants;
//SplitAccount_sh /home/appadm/var/tea/MigData/ListAccount/ Cycle1.txt /home/appadm/var/tea/MigData/NAME_ADDRESS_INFO/input/process01/

public class SplitAccount {

	public static void main(String[] args) throws Exception {
		System.out.println("Start SplitAccount");
		//get args 
		String pathFileInput=args[0];
		String fileInput=args[1];
		String pathOutput=args[2];
		
		
		String[] parts = fileInput.split("\\.");
		String fileInputWithOutDot = parts[0];
		
		
		
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathFileInput+fileInput), Constants.UTF_8);){
			String line = "";
			String recordSplit="";
			int countRecord=0;
			while((line = reader.readLine()) != null){
				countRecord++;
				if(recordSplit.equals("")){
					recordSplit=line;
				}else{
					recordSplit=recordSplit+","+line;
				}
				if(countRecord % 100 ==0){
					String countRecordStr = String.format("%07d",countRecord);
					BufferedWriter writer_temp = Files.newBufferedWriter(Paths.get(pathOutput+fileInputWithOutDot+"_"+countRecordStr+".txt"),Constants.UTF_8);
					writer_temp.write(recordSplit);
					writer_temp.newLine();
					writer_temp.close();
					//System.out.println(countRecordStr+"="+recordSplit);
					recordSplit="";
				}
				
			}
			//System.out.println(recordSplit);
			String countRecordStr = String.format("%07d",countRecord);
			BufferedWriter writer_temp = Files.newBufferedWriter(Paths.get(pathOutput+fileInputWithOutDot+"_"+countRecordStr+".txt"),Constants.UTF_8);
			writer_temp.write(recordSplit);
			writer_temp.newLine();
			writer_temp.close();
		} catch (Exception e) {
			throw e;
		}
		
		System.out.println("End SplitAccount");

	}

}
