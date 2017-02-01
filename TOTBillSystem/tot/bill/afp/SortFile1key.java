package tot.bill.afp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import tot.bill.resources.setEnv;
import tot.bill.service.CreatePathCMY;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

public class SortFile1key {
	
	public void sortFile(String fileInput , String fileTemplate , String fileOutput , String otherFile , String path){
		try {
			fileInput = path + fileInput;
			fileTemplate = path + fileTemplate;
			fileOutput = path + fileOutput;
			otherFile = path + otherFile;
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileTemplate)));
			String line = null;
			String sortKey = "";
			ListMultimap<String, String> multimap = ArrayListMultimap.create();
			ListMultimap<String, String> multimap2 = ArrayListMultimap.create();
			int count = 0;
			
			/**read template file to multi map */
			while((line = reader.readLine()) != null){
				sortKey = line.split("\\|")[0];
				multimap.put(sortKey, line);
				multimap2.put(sortKey, line);
				count++;
			}
			Set<String> over = multimap2.keySet();
			System.out.println("count template file :" + count);

			BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileInput)));
			
			BufferedWriter  writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOutput)));
			BufferedWriter  writerNever = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(otherFile)));
			String line2 = null;
			List<String> data = new ArrayList<String>();
			count = 0;
			int countOutput = 0;
			
			/** compare input file with template*/
			while((line2 = reader2.readLine()) != null){
				
				sortKey = line2.split("\\|")[0];
				data = multimap.get(sortKey);
				if(data != null && data.size() > 0){
					
					over.remove(sortKey);
					if(data.size() == 1){
						/** write file*/
						writer.write(data.get(0));
						writer.newLine();
						countOutput++;
					}else{
						for (String s : data) {
							writer.write(s);
							writer.newLine();
							countOutput++;
						}
					}
				}
				count++;
			}
			data.clear();
			
			/** write file case can't compare*/
			for (String val : over) {
				data = multimap.get(val);
				
				if(data.size() == 1){
					writerNever.write(data.get(0));
					writerNever.newLine();
				}else{
					for (String string : data) {
						writer.write(string);
						writer.newLine();
						countOutput++;
					}
				}
			}
			
			writer.flush();
			writer.close();
			writerNever.flush();
			writerNever.close();
			reader.close();
			reader2.close();
			System.out.println("count input file : "+ count);
			System.out.println("count output file : "+ countOutput);
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws IOException{
		
		//get args 
				String CYCLE_CODE=args[0];
				String CYCLE_MONTH=args[1];
				String CYCLE_YEAR=args[2];
				
				String runDate=CreatePathCMY.byCMYString("", CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR);
				
				//System.out.println(CreatePathCMY.byCMYString("", CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR));
		try {
			SortFile1key call = new SortFile1key();
			System.out.println("Sort File");
			String path = setEnv.homePath;
			//windows
			/*
			String inputPath = "BillPrintInfo\\"+runDate+"\\exBan.txt";
			String templatePath = "Charge\\"+runDate+"\\chargeSummary.txt";
			String outputPath = "Charge\\"+runDate+"\\chargeSummary_sort.txt";
			String otherFile = "Charge\\"+runDate+"\\otherFile.txt";
			*/
			//linux
			String inputPath = "var/tea/BillPrintInfo/"+runDate+"/exBan.txt";
			String templatePath = "var/tea/Charge/"+runDate+"/chargeSummary.txt";
			String outputPath = "var/tea/Charge/"+runDate+"/chargeSummary_sort.txt";
			String otherFile = "var/tea/Charge/"+runDate+"/otherFile.txt";
			call.sortFile(inputPath, templatePath, outputPath , otherFile , path);
		} catch (Exception e) {
		}
	}
	

}
