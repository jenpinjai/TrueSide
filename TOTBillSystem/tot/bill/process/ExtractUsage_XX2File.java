package tot.bill.process;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import tot.bill.afp.AccountIDExtract;
import tot.bill.dao.ACCOUNT_LIST_XX_DB;
import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.resources.setEnv;
import tot.bill.service.ChangeDateEnglishToThai;
import tot.bill.service.CreatePathCMY;
import tot.bill.table.ACCOUNT_LIST_XX;
import tot.bill.table.ACCOUNT_TYPE;
import tot.bill.table.BILL_PRINT_INFO;
import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.USAGE_XX;


public class ExtractUsage_XX2File {

	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("ExtractBillPrintInfo2File Start");
		
		//get args 
		String CYCLE_CODE=args[0];
		String CYCLE_MONTH=args[1];
		String CYCLE_YEAR=args[2];
		
		String statusQa =args[3];
		String statusBillType =args[4];
		
		System.out.print("CYCLE_CODE="+CYCLE_CODE);
		System.out.print(",CYCLE_MONTH="+CYCLE_MONTH);
		System.out.println(",CYCLE_YEAR="+CYCLE_YEAR);	
		System.out.println("QA Status="+statusQa);
		
		//get local time
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.ENGLISH);
	    Calendar cal = Calendar.getInstance();
		//System.out.println(dateFormat.format(cal.getTime()));
		String sysDateTime=dateFormat.format(cal.getTime());
		
		 //connect DB
        Connection conPRM = null;
        Connection conBILL = null;
        
        conBILL=createConnectionDB.openConnectBillDB();
        conPRM=createConnectionDB.openConnectPRMDB();
        
        // get CYCLE_CONTROL        
        ArrayList<CYCLE_CONTROL> stCYCLE_CONTROL=new ArrayList<CYCLE_CONTROL>();    
        SelectDB.selectCYCLE_CONTROL(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, stCYCLE_CONTROL);
      
        System.out.println("Table ACCT LIST="+stCYCLE_CONTROL.get(0).getACCT_LIST_NAME());

        // get BILL_PRINT_INFO
//        ArrayList<String> idBILL_PRINT_INFO = new ArrayList<String>();
//        ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO=new ArrayList<BILL_PRINT_INFO>();   
//        
//        if(statusQa.equals("Y")){
//        	if(statusBillType.equals("REG")){
//        		SelectDB.selectBILL_PRINT_INFO_Regular_QA(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idBILL_PRINT_INFO, stBILL_PRINT_INFO, "QA");
//        	}else{
//        		SelectDB.selectBILL_PRINT_INFO_GOV_QA(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idBILL_PRINT_INFO, stBILL_PRINT_INFO, "QA");            	
//        	}
//        }else{
//        	if(statusBillType.equals("REG")){
//        		SelectDB.selectBILL_PRINT_INFO_Regular(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idBILL_PRINT_INFO, stBILL_PRINT_INFO);
//        	}else{
//        		SelectDB.selectBILL_PRINT_INFO_GOV(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idBILL_PRINT_INFO, stBILL_PRINT_INFO);               
//        	}
//        }
        
        ArrayList<String> idUsage = new ArrayList<String>();
        ArrayList<USAGE_XX> stUSAGE_XX=new ArrayList<USAGE_XX>();   
        
        SelectDB.selectUSAGE_XX_U(conBILL,stCYCLE_CONTROL.get(0).getUSG_BUCKET(), CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idUsage, stUSAGE_XX); 
        
        ArrayList<AccountIDExtract> stAccountIDExtract=new ArrayList<AccountIDExtract>();   
        
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
    	decimalFormatSymbols.setDecimalSeparator('.');
    	decimalFormatSymbols.setGroupingSeparator(',');
    	DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", decimalFormatSymbols);
    	String changeFormatVal="";
//        for(int i=0;i<idBILL_PRINT_INFO.size();i++){
//             try{
//        	
//        	
//               
//            }catch(Exception ex){
//                
//                    System.out.println("Acc id error :"+stBILL_PRINT_INFO.get(i).getACCOUNT_ID() );
//                    
//            }
//        	
//        }
        
        //gen file Usage_file
        
        String homePath=setEnv.Usage_file_gen;	
        String PathOutput="";
        if(CreatePathCMY.byCMY(homePath, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)==0){
        	 PathOutput=CreatePathCMY.byCMYString(homePath, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)+setEnv.folderUsage_file_gen;
        	 //System.out.println( PathBackup);
        }else{
        	System.out.println("Can't Create Path");
        	System.exit(-1);
        }
       
        //create  file
        Writer writerOutputFile = null;
        try {
        	writerOutputFile = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(PathOutput+"exBan.txt"),"TIS620")); 
        } catch (IOException ex) {
            // report
        } 
        double maxNum = idUsage.size();
        
        for(int i=0;i<idUsage.size();i++){
               // double percen = (i/maxNum)*100;
               // System.out.println(percen+"%");
        	writerOutputFile.write(stUSAGE_XX.get(i).getACCOUNT_ID()+"|");          	
        	writerOutputFile.write(stUSAGE_XX.get(i).getDIALED_TN()+"|");
        	writerOutputFile.write(stUSAGE_XX.get(i).getCONNECT_DATE()+"|");
        	writerOutputFile.write(stUSAGE_XX.get(i).getDESTINATION_ON_BILL()+"|");
        	writerOutputFile.write(stUSAGE_XX.get(i).getCALL_VOL_ROUNDED()+"|");
        	writerOutputFile.write(stUSAGE_XX.get(i).getCHARGE_AMT()+"\r\n");
        	
        }
        
        
        
        try {	    	 
        	writerOutputFile.close();	      
	    }catch (Exception ex) 
	    {/*ignore*/}
        
        try { conPRM.close(); } catch (Exception ignore) {}
	    try { conBILL.close(); } catch (Exception ignore) {}
	    
	    
	  
	    
	    System.out.println("END");
	}

}
