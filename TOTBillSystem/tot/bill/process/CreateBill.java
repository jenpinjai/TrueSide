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
import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.model.BillUnknowValue;
import tot.bill.service.findBillUnknowValue;
import tot.bill.service.getCycleBefore;
import tot.bill.table.ACCOUNT_LIST_XX;
import tot.bill.table.ACCOUNT_PYM_MTD;
import tot.bill.table.BILL;
import tot.bill.table.CHARGE;
import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.PAYMENT_ACTIVITY;

public class CreateBill {

	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("CreateBill Start");
		
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
        System.out.println("get CYCLE_CONTROL BEFORE");
        //get CYCLE_CONTROL BEFORE
        CYCLE_CONTROL stCYCLE_CONTROL_Before=new  CYCLE_CONTROL(
        		CYCLE_CODE, CYCLE_YEAR, CYCLE_MONTH, null, null, null, null, null, null, null, null, null, null, null);
        getCycleBefore.getCycleBefore(stCYCLE_CONTROL_Before);
        System.out.println("get ACCT LIST ");
        // get ACCT LIST 
        ArrayList<String> idACCOUNT_LIST_XX = new ArrayList<String>();
        ArrayList<ACCOUNT_LIST_XX> stACCOUNT_LIST_XX=new ArrayList<ACCOUNT_LIST_XX>();   
        
        SelectDB.selectACCOUNT_LIST_XX(conBILL, stCYCLE_CONTROL.get(0).getACCT_LIST_NAME(), 
        		idACCOUNT_LIST_XX, stACCOUNT_LIST_XX);
        System.out.println("get CHARGE");
        // get CHARGE
        ArrayList<String> idCHARGE = new ArrayList<String>();
        ArrayList<CHARGE> stCHARGE=new ArrayList<CHARGE>(); 
        
        SelectDB.selectCHARGE(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idCHARGE, stCHARGE);
        System.out.println("get BILL BEFORE");
        // get BILL BEFORE
        ArrayList<String> idBILL_Before = new ArrayList<String>();
        ArrayList<BILL> stBILL_Before=new ArrayList<BILL>(); 
        
        SelectDB.selectBILL(conBILL, stCYCLE_CONTROL_Before.getCYCLE_CODE(), stCYCLE_CONTROL_Before.getCYCLE_MONTH(),
        		stCYCLE_CONTROL_Before.getCYCLE_YEAR(), idBILL_Before,stBILL_Before);
        
        System.out.println("get ACCOUNT_PYM_MTD");
        // get ACCOUNT_PYM_MTD
        ArrayList<String> idACCOUNT_PYM_MTD = new ArrayList<String>();
        ArrayList<ACCOUNT_PYM_MTD> stACCOUNT_PYM_MTD=new ArrayList<ACCOUNT_PYM_MTD>(); 
        SelectDB.selectACCOUNT_PYM_MTD_ByACL(conBILL, idACCOUNT_PYM_MTD, stACCOUNT_PYM_MTD,stCYCLE_CONTROL.get(0).getACCT_LIST_NAME());
        
        System.out.println("get PAYMENT_ACTIVITY");
        // get PAYMENT_ACTIVITY
        ArrayList<String> idPAYMENT_ACTIVITY = new ArrayList<String>();
        ArrayList<PAYMENT_ACTIVITY> stPAYMENT_ACTIVITY=new ArrayList<PAYMENT_ACTIVITY>(); 
        SelectDB.selectPAYMENT_ACTIVITY(conBILL, idPAYMENT_ACTIVITY, stPAYMENT_ACTIVITY);
        
        //get logical_date
        String logical_date="";
        logical_date=SelectDB.selectLOGICAL_DATE(conBILL, logical_date);
        System.out.println(logical_date);
        
        System.out.println(idACCOUNT_LIST_XX.size());
        
        ArrayList<BILL> stBILL=new ArrayList<BILL>();   
        
        
		
        for(int i=0;i<idACCOUNT_LIST_XX.size();i++){
        	
        	BillUnknowValue stBillUnknowValue=new BillUnknowValue(
        			stACCOUNT_LIST_XX.get(i).getACCOUNT_ID(),CYCLE_CODE,CYCLE_MONTH,CYCLE_YEAR, 
        			null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,null);
            
        	findBillUnknowValue.findPREVIOUS_AMT(stBillUnknowValue, idBILL_Before, stBILL_Before,stACCOUNT_LIST_XX.get(i));
        	findBillUnknowValue.findPAYMENT_ACTIVITY(stBillUnknowValue, stCYCLE_CONTROL.get(0), idPAYMENT_ACTIVITY, stPAYMENT_ACTIVITY);
        	findBillUnknowValue.findCHARGE(stBillUnknowValue, idCHARGE, stCHARGE);
        	findBillUnknowValue.findACCOUNT_PYM_MTD(stBillUnknowValue, stCYCLE_CONTROL.get(0), idACCOUNT_PYM_MTD, stACCOUNT_PYM_MTD);
        	findBillUnknowValue.findDUE_DATE(stBillUnknowValue, stCYCLE_CONTROL.get(0));
        	//System.out.println(stBillUnknowValue.getDUE_DATE());
        	String iNVOICE_NUMBER=SelectDB.selectInvoiceNoSeq(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR);
        	
        	//System.out.println(iNVOICE_NUMBER);
        	stBILL.add(new BILL(
        			stACCOUNT_LIST_XX.get(i).getACCOUNT_ID(), 	//	aCCOUNT_ID, 
        			CYCLE_CODE, 	//	cYCLE_CODE, 
        			CYCLE_MONTH, 	//	cYCLE_MONTH, 
        			CYCLE_YEAR, 	//	cYCLE_YEAR, 
        			sysDateTime, 	//	sYS_CREATION_DATE, 
        			null, 	//	sYS_UPDATE_DATE, 
        			logical_date, 	//	bILL_CREATE_DATE, 
        			null, 	//	bILL_EXTRACT_DATE, 
        			null, 	//	bILL_CONFIRM_DATE, 
        			stBillUnknowValue.getPREVIOUS_AMT(), 	//	pREVIOUS_AMT, 
        			stBillUnknowValue.getPAYMENT_AMT(), 	//	pAYMENT_AMT, 
        			stBillUnknowValue.getCUR_CHARGE_AMT(), 	//	cUR_CHARGE_AMT, 
        			stBillUnknowValue.getCUR_CREDIT_AMT(), 	//	cUR_CREDIT_AMT, 
        			stBillUnknowValue.getCUR_DISCOUNT_AMT(), 	//	cUR_DISCOUNT_AMT, 
        			stBillUnknowValue.getCUR_RC_AMT(), 	//	cUR_RC_AMT, 
        			stBillUnknowValue.getCUR_OC_AMT(), 	//	cUR_OC_AMT, 
        			stBillUnknowValue.getCUR_UC_AMT(), 	//	cUR_UC_AMT, 
        			stBillUnknowValue.getTOTAL_CHARGE_AMT(), 	//	tOTAL_CHARGE_AMT, 
        			stBillUnknowValue.getTOTAL_TAX_AMT(), 	//	tOTAL_TAX_AMT, 
        			stBillUnknowValue.getTOTAL_NET_AMT(), 	//	tOTAL_NET_AMT, 
        			stBillUnknowValue.getTOTAL_ADJUST_AMT(), 	//	tOTAL_ADJUST_AMT, 
        			stBillUnknowValue.getTOTAL_ADJUST_TAX_AMT(), 	//	tOTAL_ADJUST_TAX_AMT, 
        			stBillUnknowValue.getTOTAL_ADJUST_NET_AMT(), 	//	tOTAL_ADJUST_NET_AMT, 
        			stBillUnknowValue.getOUTSTANDING_AMT(), 	//	oUTSTANDING_AMT, 
        			iNVOICE_NUMBER, 	//	iNVOICE_NUMBER, 
        			stACCOUNT_LIST_XX.get(i).getACCOUNT_TYPE(), 	//	aCCOUNT_TYPE, 
        			stACCOUNT_LIST_XX.get(i).getACCOUNT_SUB_TYPE(), 	//	aCCOUNT_SUB_TYPE, 
        			stACCOUNT_LIST_XX.get(i).getPYM_MTD(), 	//	pYM_MTD, 
        			stBillUnknowValue.getBANK_CODE(), 	//	bANK_CODE, 
        			stBillUnknowValue.getBANK_ACCOUNT_NO(), 	//	bANK_ACCOUNT_NO, 
        			stBillUnknowValue.getDUE_DATE(), 	//	dUE_DATE, 
        			stBillUnknowValue.getBILL_TYPE(), 	//	bILL_TYPE, 
        			stBillUnknowValue.getPRESENT_PRODUCT_NO(), 	//	pRESENT_PRODUCT_NO, 
        			"N"	//	bILL_STATUS
        			));
        }
        
        int record_insert=BILL_DB.InsertBILL(conBILL, stBILL);
        System.out.println("Record in put="+stBILL.size());
        System.out.println("Record in insert="+record_insert);
        
        try { conPRM.close(); } catch (Exception ignore) {}
	    try { conBILL.close(); } catch (Exception ignore) {}
	    
	    if(stBILL.size()!=record_insert){
	    	System.out.println("Fail!!");
	    	System.exit(-1);
	    }
	   
	    System.out.println("END");
	}

}
