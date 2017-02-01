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
import tot.bill.table.DISCOUNT;
import tot.bill.table.RATED_RC;

public class CreateChargeDiscount {

	
	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("CreateChargeDiscount");
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
      
        System.out.println("Table Discount ");	    

        // get DISCOUNT
        ArrayList<String> idDISCOUNT  = new ArrayList<String>();
        ArrayList<DISCOUNT> stDISCOUNT =new ArrayList<DISCOUNT>();
        SelectDB.selectDISCOUNT(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idDISCOUNT, stDISCOUNT);
        
        // get CUSTOMER_ACCOUNT
        
        ArrayList<String> idCUSTOMER_ACCOUNT  = new ArrayList<String>();
        ArrayList<CUSTOMER_ACCOUNT> stCUSTOMER_ACCOUNT =new ArrayList<CUSTOMER_ACCOUNT>();
        
        SelectDB.selectCUSTOMER_ACCOUNT(conBILL, CYCLE_CODE, idCUSTOMER_ACCOUNT, stCUSTOMER_ACCOUNT);
        
        //get logical_date
        String logical_date="";
        logical_date=SelectDB.selectLOGICAL_DATE(conBILL, logical_date);
        System.out.println(logical_date);
        
        ArrayList<CHARGE> stCHARGE=new ArrayList<CHARGE>();
        
        for(int i=0;i<idDISCOUNT.size();i++){
        	System.out.println(stDISCOUNT.get(i).getACCOUNT_ID());
        	// map CUSTOMER_ACCOUNT
        	int indexCUSTOMER_ACCOUNT=idCUSTOMER_ACCOUNT.indexOf(idDISCOUNT.get(i));
        	if(indexCUSTOMER_ACCOUNT>=0){
        		stCHARGE.add(new CHARGE(
            			stDISCOUNT.get(i).getACCOUNT_ID(), 
            			null, 
            			null, 
            			sysDateTime, 
            			null, 
            			CYCLE_CODE, 
            			CYCLE_YEAR, 
            			CYCLE_MONTH, 
            			stDISCOUNT.get(i).getPRODUCT_TYPE(), 
            			stDISCOUNT.get(i).getPRODUCT_NO(), 
            			logical_date, 
            			"DSC", 
            			"N", 
            			stDISCOUNT.get(i).getPRICE_PLAN(), 
            			stDISCOUNT.get(i).getFEATURE_CODE(), 
            			stDISCOUNT.get(i).getREVENUE_CODE(), 
            			stDISCOUNT.get(i).getDISCOUNT_CODE(), 
            			null, 
            			null, 
            			null, 
            			null, 
            			stDISCOUNT.get(i).getDISCOUNT_AMT(), 
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
