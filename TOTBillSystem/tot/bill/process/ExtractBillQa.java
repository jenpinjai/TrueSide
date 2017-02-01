package tot.bill.process;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import tot.bill.dao.BILL_PRINT_INFO_DB;
import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.table.BILL_QA;
import tot.bill.table.CYCLE_CONTROL;

public class ExtractBillQa {

	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("Extract Bill QA Start");
		
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
        // get BILL_QA   
        ArrayList<BILL_QA> stBILL_QA=new ArrayList<BILL_QA>();
        SelectDB.selectBILL_QA(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, stBILL_QA);
        
        int record_insert=BILL_PRINT_INFO_DB.InsertQA_ACCOUNT_IND(conBILL, stBILL_QA, "QA");
        
        System.out.println("Record in put="+stBILL_QA.size());
        System.out.println("Record in insert="+record_insert);
        
        try { conPRM.close(); } catch (Exception ignore) {}
	    try { conBILL.close(); } catch (Exception ignore) {}
	    
	    System.out.println("END");
	}

}
