package tot.bill.process;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import tot.bill.dao.ACCOUNT_LIST_XX_DB;
import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.resources.setEnv;
import tot.bill.service.CreatePathCMY;
import tot.bill.service.GenAccountListBackup;
import tot.bill.table.ACCOUNT_LIST_XX;
import tot.bill.table.CUSTOMER_ACCOUNT;
import tot.bill.table.CYCLE_CONTROL;

public class ExtractAccountList {

	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("Extract Account List Start");
		
		//get args 
		String CYCLE_CODE=args[0];
		String CYCLE_MONTH=args[1];
		String CYCLE_YEAR=args[2];
				
		System.out.print("CYCLE_CODE="+CYCLE_CODE);
		System.out.print(",CYCLE_MONTH="+CYCLE_MONTH);
		System.out.println(",CYCLE_YEAR="+CYCLE_YEAR);	
		
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
        
        // get ACCT LIST 
        ArrayList<String> idACCOUNT_LIST_XX = new ArrayList<String>();
        ArrayList<ACCOUNT_LIST_XX> stACCOUNT_LIST_XX=new ArrayList<ACCOUNT_LIST_XX>();   
        
        SelectDB.selectACCOUNT_LIST_XX(conBILL, stCYCLE_CONTROL.get(0).getACCT_LIST_NAME(), 
        		idACCOUNT_LIST_XX, stACCOUNT_LIST_XX);
        
        // get CUSTOMER_ACCOUNT 
        ArrayList<String> idCUSTOMER_ACCOUNT = new ArrayList<String>();
        ArrayList<CUSTOMER_ACCOUNT> stCUSTOMER_ACCOUNT=new ArrayList<CUSTOMER_ACCOUNT>();   
        
        SelectDB.selectCUSTOMER_ACCOUNT(conBILL, CYCLE_CODE, idCUSTOMER_ACCOUNT, stCUSTOMER_ACCOUNT);
        
        //backup account list to file
        
        String homePath=setEnv.homeBK;	
        String PathBackup="";
        if(CreatePathCMY.byCMY(homePath, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)==0){
        	 PathBackup=CreatePathCMY.byCMYString(homePath, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)+setEnv.folderErrEAL;
        	 ACCOUNT_LIST_XX_DB.truncateTable(conBILL, stCYCLE_CONTROL.get(0).getACCT_LIST_NAME());
        }else{
        	System.out.println("Can't Create Path");
        	System.exit(-1);
        }
       
      //create Back Up file
        Writer writerBackUpFile = null;
        try {
        	writerBackUpFile = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(PathBackup+"BackUp"+stCYCLE_CONTROL.get(0).getACCT_LIST_NAME()+".txt"), "utf-8")); 
        } catch (IOException ex) {
            // report
        } 
        
        GenAccountListBackup.backUpToFile(stCYCLE_CONTROL.get(0).getACCT_LIST_NAME(), stACCOUNT_LIST_XX,writerBackUpFile);
        try {	    	 
        	writerBackUpFile.close();	      
	    }catch (Exception ex) 
	    {/*ignore*/}
        
        //create ACCOUNT_LIST_XX for insert
        ArrayList<ACCOUNT_LIST_XX> stACCOUNT_LIST_XX_new=new ArrayList<ACCOUNT_LIST_XX>();   
        for(int i=0;i<idCUSTOMER_ACCOUNT.size();i++){
        	stACCOUNT_LIST_XX_new.add(new ACCOUNT_LIST_XX(
        			stCUSTOMER_ACCOUNT.get(i).getACCOUNT_ID(), 
        			sysDateTime, 
        			null, 
        			stCUSTOMER_ACCOUNT.get(i).getACCOUNT_TYPE(), 
        			stCUSTOMER_ACCOUNT.get(i).getACCOUNT_SUB_TYPE(), 
        			stCUSTOMER_ACCOUNT.get(i).getAR_BALANCE(), 
        			stCUSTOMER_ACCOUNT.get(i).getACCOUNT_STATUS(), 
        			stCUSTOMER_ACCOUNT.get(i).getSTATUS_LAST_DATE(), 
        			stCUSTOMER_ACCOUNT.get(i).getSTATUS_ACTV_RSN_CODE(), 
        			stCUSTOMER_ACCOUNT.get(i).getWRITE_OFF_IND(), 
        			stCUSTOMER_ACCOUNT.get(i).getCYCLE_CODE(), 
        			stCUSTOMER_ACCOUNT.get(i).getTAX_CODE(), 
        			stCUSTOMER_ACCOUNT.get(i).getPYM_MTD(), 
        			stCUSTOMER_ACCOUNT.get(i).getIDENTITY_TYPE(), 
        			stCUSTOMER_ACCOUNT.get(i).getIDENTITY(), 
        			stCUSTOMER_ACCOUNT.get(i).getPAYER_IND(), 
        			stCUSTOMER_ACCOUNT.get(i).getPARENT_ACCOUNT_ID(), 
        			stCUSTOMER_ACCOUNT.get(i).getGOVERNMENT_CODE(), 
        			stCUSTOMER_ACCOUNT.get(i).getSUB_GOV_CODE(), 
        			stCUSTOMER_ACCOUNT.get(i).getDEPOSIT_BALANCE_AMT(), 
        			stCUSTOMER_ACCOUNT.get(i).getDEPOSIT_REFUND_CHOICE(), 
        			stCUSTOMER_ACCOUNT.get(i).getDEPOSIT_STS_DATE(), 
        			stCUSTOMER_ACCOUNT.get(i).getCUST_TAX_ID(), 
        			stCUSTOMER_ACCOUNT.get(i).getCUST_BRANCH_NO(), 
        			null, 
        			null, 
        			"S", 
        			null, 
        			null,
        			stCUSTOMER_ACCOUNT.get(i).getPRINT_CATEGORY()
        			));
        	
        }
        
        
        int record_insert=ACCOUNT_LIST_XX_DB.InsertACCOUNT_LIST_XX(conBILL, stCYCLE_CONTROL.get(0).getACCT_LIST_NAME(), stACCOUNT_LIST_XX_new);
        
        System.out.println("Record in put="+stACCOUNT_LIST_XX_new.size());
        System.out.println("Record in insert="+record_insert);
        
        try { conPRM.close(); } catch (Exception ignore) {}
	    try { conBILL.close(); } catch (Exception ignore) {}

	    if(stACCOUNT_LIST_XX_new.size()!=record_insert){
	    	System.out.println("Fail!!");
	    	System.exit(-1);
	    }
	    System.out.println("END");
	}

}
