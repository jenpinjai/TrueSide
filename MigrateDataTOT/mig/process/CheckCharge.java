package mig.process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.ArrayList;

import mig.connnection.Connection11g;
import mig.connnection.Connection8i;
import mig.oracle8i.Sql11g;
import mig.oracle8i.Sql8i;
import mig.resources.CHARGE;
import mig.resources.Constants;

public class CheckCharge {
//CheckCharge_sh 1 12 2016 /home/appadm/var/tea/MigData/ListAccount/Cycle1.txt
	public static void main(String[] args) throws Exception {		
		//get args 
		String CYCLE_CODE=args[0];
		String CYCLE_MONTH=args[1];
		String CYCLE_YEAR=args[2];
		String pathFileInput=args[3];
		
		
		Connection conn8i = null;		
		conn8i = Connection8i.getConnection();
		
		Connection conn11g = null;		
		conn11g = Connection11g.getConnection();
		
		
		ArrayList<String> BanList = new ArrayList<String>();
		ArrayList<String> BanList100 = new ArrayList<String>();
		
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathFileInput), Constants.UTF_8);){
			String line = "";
			String recordSplit="";
			int countRecord=0;
			while((line = reader.readLine()) != null){
				BanList.add(line);
				countRecord++;
				if(recordSplit.equals("")){
					recordSplit=line;
				}else{
					recordSplit=recordSplit+","+line;
				}
				if(countRecord % 100 ==0){									
					//System.out.println(recordSplit);
					BanList100.add(recordSplit);
					
					recordSplit="";
				}
				
			}
			//System.out.println(recordSplit);			
			BanList100.add(recordSplit);
		} catch (Exception e) {
			throw e;
		}
		
		double actv8i=0;
		double actv11g=0;
		double tax8i=0;
		double tax11g=0;
		int countErr=0;
		for(int i=0;i<BanList.size();i++){
			
			ArrayList<CHARGE> stCHARGE8i = new ArrayList<CHARGE>();
			ArrayList<CHARGE> stCHARGE11g = new ArrayList<CHARGE>();
			actv8i=0;
			actv11g=0;
			tax8i=0;
			tax11g=0;
			
			Sql8i.getCharge(conn8i, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR,  BanList.get(i), stCHARGE8i);
			Sql11g.getCharge(conn11g, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, BanList.get(i), stCHARGE11g);
			
			
			
			for(int x=0;x<stCHARGE8i.size();x++){	
				if(stCHARGE8i.get(x).getACTV_AMT()==null||stCHARGE8i.get(x).getACTV_AMT().equals("null")){
					
				}else{
					actv8i =actv8i + Double.parseDouble(stCHARGE8i.get(x).getACTV_AMT());
				}
				if(stCHARGE8i.get(x).getTAX_AMT()==null||stCHARGE8i.get(x).getTAX_AMT().equals("null")){
					
				}else{
					tax8i = tax8i + Double.parseDouble(stCHARGE8i.get(x).getTAX_AMT());
				}				
			}
			
			for(int x=0;x<stCHARGE11g.size();x++){	
				if(stCHARGE11g.get(x).getACTV_AMT()==null||stCHARGE11g.get(x).getACTV_AMT().equals("null")){
					
				}else{
					actv11g =actv11g + Double.parseDouble(stCHARGE11g.get(x).getACTV_AMT());
				}
				if(stCHARGE11g.get(x).getACTV_AMT()==null||stCHARGE11g.get(x).getACTV_AMT().equals("null")){
					
				}else{
					tax11g = tax11g + Double.parseDouble(stCHARGE11g.get(x).getTAX_AMT());		
				}
			}
			
			if(actv8i != actv11g || tax8i != tax11g){
				countErr++;
				System.out.println("========== Record "+i+" ==========");
				System.out.println("  ==8i ==");
				for(int x=0;x<stCHARGE8i.size();x++){	
					
					System.out.print(stCHARGE8i.get(x).getACCOUNT_ID());
					System.out.print("\t");
					System.out.print(stCHARGE8i.get(x).getPRODUCT_NO());
					System.out.print("\t");
					System.out.print(stCHARGE8i.get(x).getCHARGE_TYPE());
					System.out.print("\t");
					System.out.print(stCHARGE8i.get(x).getREVENUE_CODE());
					System.out.print("\t");
					System.out.print(stCHARGE8i.get(x).getACTV_AMT());
					System.out.print("\t");
					System.out.print(stCHARGE8i.get(x).getTAX_AMT());
					System.out.print("\t");
					System.out.print(stCHARGE8i.get(x).getTAX_CODE());
					System.out.print("\t");
					System.out.print(stCHARGE8i.get(x).getPRICE_PLAN());
					System.out.print("\t");
					System.out.println(stCHARGE8i.get(x).getFEATURE_CODE());
				}
				System.out.println("  ==11g==");
				for(int x=0;x<stCHARGE11g.size();x++){						
					System.out.print(stCHARGE11g.get(x).getACCOUNT_ID());
					System.out.print("\t");
					System.out.print(stCHARGE11g.get(x).getPRODUCT_NO());
					System.out.print("\t");
					System.out.print(stCHARGE11g.get(x).getCHARGE_TYPE());
					System.out.print("\t");
					System.out.print(stCHARGE11g.get(x).getREVENUE_CODE());
					System.out.print("\t");
					System.out.print(stCHARGE11g.get(x).getACTV_AMT());
					System.out.print("\t");
					System.out.print(stCHARGE11g.get(x).getTAX_AMT());
					System.out.print("\t");
					System.out.print(stCHARGE11g.get(x).getTAX_CODE());
					System.out.print("\t");
					System.out.print(stCHARGE11g.get(x).getPRICE_PLAN());
					System.out.print("\t");
					System.out.println(stCHARGE11g.get(x).getFEATURE_CODE());
				}
				
			}
			
		}
		
		
		System.out.println("SUMMARY Record in="+BanList.size());
		System.out.println("        Record Error="+countErr);
		
		try {
			conn8i.close();	
			conn11g.close();	
		} catch (Exception e2) {
		}
		System.out.println("End");
		
		
	}

}
