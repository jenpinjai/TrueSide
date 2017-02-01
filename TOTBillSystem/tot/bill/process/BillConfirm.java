package tot.bill.process;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import tot.bill.dao.BILL_DB;
import tot.bill.dao.BILL_PRINT_INFO_DB;
import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.table.BILL_PRINT_INFO;
import tot.bill.table.CYCLE_CONTROL;

public class BillConfirm {

	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("BillConfirm Start");
		
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
      
        System.out.println("Table USAGE LIST="+stCYCLE_CONTROL.get(0).getUSG_BUCKET());

        // get BILL_PRINT_INFO
        ArrayList<String> idBILL_PRINT_INFO = new ArrayList<String>();
        ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO=new ArrayList<BILL_PRINT_INFO>(); 
        
        SelectDB.selectBILL_PRINT_INFO_CF(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idBILL_PRINT_INFO, stBILL_PRINT_INFO);
        
        for(int i=0;i<idBILL_PRINT_INFO.size();i++){
        	int create_invoice_status=0;
        	
        	//call create_invoice
        	
        	if(create_invoice_status==0){
        		//update Bill_print_info
        		BILL_PRINT_INFO_DB.InsertCF_ACCOUNT_IND(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idBILL_PRINT_INFO.get(i));
        		//update Bill     		
        		BILL_DB.InsertCF_ACCOUNT_IND(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idBILL_PRINT_INFO.get(i));
        		//update account_list
        		//update customer Account
        		
        	}else{
        		
        	}
        	
        	
        	
        }
        
        try { conPRM.close(); } catch (Exception ignore) {}
	    try { conBILL.close(); } catch (Exception ignore) {}
	    System.out.println("END");
	}

}
