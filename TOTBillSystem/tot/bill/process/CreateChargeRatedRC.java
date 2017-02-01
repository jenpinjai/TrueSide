package tot.bill.process;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.table.CHARGE;
import tot.bill.table.CUSTOMER_ACCOUNT;
import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.RATED_RC;

public class CreateChargeRatedRC {

	
	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("CreateChargeRatedRC");
		String CYCLE_CODE=args[0];
		String CYCLE_MONTH=args[1];
		String CYCLE_YEAR=args[2];
		
		System.out.print("CYCLE_CODE="+CYCLE_CODE);
	    System.out.print(",CYCLE_MONTH="+CYCLE_MONTH);
	    System.out.println(",CYCLE_YEAR="+CYCLE_YEAR);
		
		//get system datetime
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.ENGLISH);
		Calendar cal = Calendar.getInstance();
		String sysDateTime=dateFormat.format(cal.getTime());
		
		 //connect DB
       
        Connection conBILL = null;
        Connection conPRM = null;
        conBILL=createConnectionDB.openConnectBillDB();
        conPRM=createConnectionDB.openConnectPRMDB();
        
        // get CYCLE_CONTROL        
        ArrayList<CYCLE_CONTROL> stCYCLE_CONTROL=new ArrayList<CYCLE_CONTROL>();    
        SelectDB.selectCYCLE_CONTROL(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, stCYCLE_CONTROL);
      
        System.out.println("Table RATED RC ");
        
        // get RATED_RC   
        ArrayList<String> idRATED_RC  = new ArrayList<String>();
        ArrayList<RATED_RC> stRATED_RC =new ArrayList<RATED_RC>();   
        
        SelectDB.selectRATED_RC(conBILL, CYCLE_CODE,CYCLE_MONTH, CYCLE_YEAR, 
        		idRATED_RC, stRATED_RC);
        
        // get CUSTOMER_ACCOUNT
        
        ArrayList<String> idCUSTOMER_ACCOUNT  = new ArrayList<String>();
        ArrayList<CUSTOMER_ACCOUNT> stCUSTOMER_ACCOUNT =new ArrayList<CUSTOMER_ACCOUNT>();
        
        SelectDB.selectCUSTOMER_ACCOUNT(conBILL, CYCLE_CODE, idCUSTOMER_ACCOUNT, stCUSTOMER_ACCOUNT);
        
        //get logical_date
        String logical_date="";
        logical_date=SelectDB.selectLOGICAL_DATE(conBILL, logical_date);
        System.out.println(logical_date);
        
        ArrayList<CHARGE> stCHARGE=new ArrayList<CHARGE>();  
        
        for(int i=0;i<idRATED_RC.size();i++){
        	System.out.println(stRATED_RC.get(i).getACCOUNT_ID());
        	// map CUSTOMER_ACCOUNT
        	int indexCUSTOMER_ACCOUNT=idCUSTOMER_ACCOUNT.indexOf(idRATED_RC.get(i));
        	if(indexCUSTOMER_ACCOUNT>=0){
        		stCHARGE.add(new CHARGE(
            			stRATED_RC.get(i).getACCOUNT_ID(), 
            			null, 
            			null, 
            			sysDateTime, 
            			null, 
            			CYCLE_CODE, 
            			CYCLE_YEAR, 
            			CYCLE_MONTH, 
            			stRATED_RC.get(i).getPRODUCT_TYPE(), 
            			stRATED_RC.get(i).getPRODUCT_NO(), 
            			logical_date, 
            			"DBT", 
            			"N", 
            			stRATED_RC.get(i).getPRICE_PLAN(), 
            			stRATED_RC.get(i).getFEATURE_CODE(), 
            			"R", 
            			null, 
            			null, 
            			stRATED_RC.get(i).getRC_START_DATE(), 
            			stRATED_RC.get(i).getRC_END_DATE(), 
            			null, 
            			stRATED_RC.get(i).getCHARGE_AMT(), 
            			stCUSTOMER_ACCOUNT.get(indexCUSTOMER_ACCOUNT).getTAX_CODE(), 
            			null, 
            			null
            			));
        		
        	}else{
				System.out.println("fail map CUSTOMER_ACCOUNT");
				
			}
        	
        	
        }
        
       
        CreateCharge.CreateCharge(stCHARGE);        	
        
        
        try { conPRM.close(); } catch (Exception ignore) {}
	    try { conBILL.close(); } catch (Exception ignore) {}
	    System.out.println("END");

	}

}
