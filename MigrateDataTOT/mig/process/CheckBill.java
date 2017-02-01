package mig.process;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.ArrayList;

import mig.connnection.Connection11g;
import mig.connnection.Connection8i;
import mig.oracle8i.Sql11g;
import mig.oracle8i.Sql8i;
import mig.resources.BILL_PRINT_INFO;
import mig.resources.Constants;

public class CheckBill {
	//CheckBill_sh 1 12 2016 /home/appadm/var/tea/MigData/ListAccount/Cycle1.txt
public static void main(String[] args) throws Exception {
		
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
		
		
		 
		double PREVIOUS_BALANCE_8i;
		double PAID_AMOUNT_8i;	
		double TOTAL_CURRENT_CHARGES_8i;
		double OUTSTANDING_BALANCE_8i;
		
		double PREVIOUS_BALANCE_11g;
		double PAID_AMOUNT_11g;	
		double TOTAL_CURRENT_CHARGES_11g;
		double OUTSTANDING_BALANCE_11g;
		
		int countErr=0;
		
		for(int i=0;i<BanList.size();i++){
			ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO8i = new ArrayList<BILL_PRINT_INFO>();
			ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO11g = new ArrayList<BILL_PRINT_INFO>();
			
			Sql8i.getBILL_PRINT_INFO(conn8i, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR,  BanList.get(i), stBILL_PRINT_INFO8i);
			Sql11g.getBILL(conn11g, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, BanList.get(i), stBILL_PRINT_INFO11g);
			
			PREVIOUS_BALANCE_8i=0;
			PAID_AMOUNT_8i=0;	
			TOTAL_CURRENT_CHARGES_8i=0;
			OUTSTANDING_BALANCE_8i=0;
			
			PREVIOUS_BALANCE_11g=0;
			PAID_AMOUNT_11g=0;	
			TOTAL_CURRENT_CHARGES_11g=0;
			OUTSTANDING_BALANCE_11g=0;
			
			for(int x=0;x<stBILL_PRINT_INFO8i.size();x++){	
				if(stBILL_PRINT_INFO8i.get(x).getPREVIOUS_BALANCE()==null||stBILL_PRINT_INFO8i.get(x).getPREVIOUS_BALANCE().equals("null")){					
				}else{
					PREVIOUS_BALANCE_8i =PREVIOUS_BALANCE_8i + Double.parseDouble(stBILL_PRINT_INFO8i.get(x).getPREVIOUS_BALANCE());
				}
				
				if(stBILL_PRINT_INFO8i.get(x).getPAID_AMOUNT()==null||stBILL_PRINT_INFO8i.get(x).getPAID_AMOUNT().equals("null")){					
				}else{
					PAID_AMOUNT_8i =PAID_AMOUNT_8i + Double.parseDouble(stBILL_PRINT_INFO8i.get(x).getPAID_AMOUNT());
				}
				
				if(stBILL_PRINT_INFO8i.get(x).getTOTAL_CURRENT_CHARGES()==null||stBILL_PRINT_INFO8i.get(x).getTOTAL_CURRENT_CHARGES().equals("null")){					
				}else{
					TOTAL_CURRENT_CHARGES_8i =TOTAL_CURRENT_CHARGES_8i + Double.parseDouble(stBILL_PRINT_INFO8i.get(x).getTOTAL_CURRENT_CHARGES());
				}
				
				if(stBILL_PRINT_INFO8i.get(x).getOUTSTANDING_BALANCE()==null||stBILL_PRINT_INFO8i.get(x).getOUTSTANDING_BALANCE().equals("null")){					
				}else{
					OUTSTANDING_BALANCE_8i =OUTSTANDING_BALANCE_8i + Double.parseDouble(stBILL_PRINT_INFO8i.get(x).getOUTSTANDING_BALANCE());	
				}
			}
		
			for(int x=0;x<stBILL_PRINT_INFO11g.size();x++){	
				if(stBILL_PRINT_INFO11g.get(x).getPREVIOUS_BALANCE()==null||stBILL_PRINT_INFO11g.get(x).getPREVIOUS_BALANCE().equals("null")){					
				}else{
					PREVIOUS_BALANCE_11g =PREVIOUS_BALANCE_11g + Double.parseDouble(stBILL_PRINT_INFO11g.get(x).getPREVIOUS_BALANCE());
				}
				
				if(stBILL_PRINT_INFO11g.get(x).getPAID_AMOUNT()==null||stBILL_PRINT_INFO11g.get(x).getPAID_AMOUNT().equals("null")){					
				}else{
					PAID_AMOUNT_11g =PAID_AMOUNT_11g + Double.parseDouble(stBILL_PRINT_INFO11g.get(x).getPAID_AMOUNT());
				}
				
				if(stBILL_PRINT_INFO11g.get(x).getTOTAL_CURRENT_CHARGES()==null||stBILL_PRINT_INFO11g.get(x).getTOTAL_CURRENT_CHARGES().equals("null")){					
				}else{
					TOTAL_CURRENT_CHARGES_11g =TOTAL_CURRENT_CHARGES_11g + Double.parseDouble(stBILL_PRINT_INFO11g.get(x).getTOTAL_CURRENT_CHARGES());
				}
				
				if(stBILL_PRINT_INFO11g.get(x).getOUTSTANDING_BALANCE()==null||stBILL_PRINT_INFO11g.get(x).getOUTSTANDING_BALANCE().equals("null")){					
				}else{
					OUTSTANDING_BALANCE_11g =OUTSTANDING_BALANCE_11g + Double.parseDouble(stBILL_PRINT_INFO11g.get(x).getOUTSTANDING_BALANCE());	
				}
			}
			
			if(PREVIOUS_BALANCE_8i != PREVIOUS_BALANCE_11g || 
			   PAID_AMOUNT_8i != PAID_AMOUNT_11g ||
			   TOTAL_CURRENT_CHARGES_8i != TOTAL_CURRENT_CHARGES_11g ||
			   OUTSTANDING_BALANCE_8i != OUTSTANDING_BALANCE_11g
			   ){
				countErr++;
				System.out.println("========== Record "+i+" ==========");
				System.out.println("  ==8i ==");
				for(int x=0;x<stBILL_PRINT_INFO8i.size();x++){	
					System.out.print(stBILL_PRINT_INFO8i.get(x).getACCOUNT_ID());
					System.out.print("\t");
					System.out.print(stBILL_PRINT_INFO8i.get(x).getPREVIOUS_BALANCE());
					System.out.print("\t");
					System.out.print(stBILL_PRINT_INFO8i.get(x).getPAID_AMOUNT());
					System.out.print("\t");
					System.out.print(stBILL_PRINT_INFO8i.get(x).getTOTAL_CURRENT_CHARGES());
					System.out.print("\t");
					System.out.println(stBILL_PRINT_INFO8i.get(x).getOUTSTANDING_BALANCE());
										
					
				}
				System.out.println("  ==11g==");
				for(int x=0;x<stBILL_PRINT_INFO11g.size();x++){	
					System.out.print(stBILL_PRINT_INFO11g.get(x).getACCOUNT_ID());
					System.out.print("\t");
					System.out.print(stBILL_PRINT_INFO11g.get(x).getPREVIOUS_BALANCE());
					System.out.print("\t");
					System.out.print(stBILL_PRINT_INFO11g.get(x).getPAID_AMOUNT());
					System.out.print("\t");
					System.out.print(stBILL_PRINT_INFO11g.get(x).getTOTAL_CURRENT_CHARGES());
					System.out.print("\t");
					System.out.println(stBILL_PRINT_INFO11g.get(x).getOUTSTANDING_BALANCE());
					
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
