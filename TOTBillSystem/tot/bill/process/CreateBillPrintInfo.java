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
import tot.bill.model.BILL_PRINT_INFOUnknowValue;
import tot.bill.service.findBILL_PRINT_INFOUnknowValue;
import tot.bill.table.ACCOUNT_LIST_XX;
import tot.bill.table.ACCOUNT_TYPE;
import tot.bill.table.BANK;
import tot.bill.table.BILL;
import tot.bill.table.BILL_PRINT_INFO;
import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.NAME_ADDRESS_INFO;
import tot.bill.table.PRINT_CATEGORY;
import tot.bill.table.USAGE_S;

public class CreateBillPrintInfo {

	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("Create Bill Print Info Start");
		
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
        
        // get BILL
        ArrayList<String> idBILL = new ArrayList<String>();
        ArrayList<BILL> stBILL=new ArrayList<BILL>(); 
        
        SelectDB.selectBILL(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idBILL, stBILL);
        
        // get NAME_ADDRESS_INFO
        ArrayList<String> idNAME_ADDRESS_INFO = new ArrayList<String>();
        ArrayList<NAME_ADDRESS_INFO> stNAME_ADDRESS_INFO=new ArrayList<NAME_ADDRESS_INFO>(); 
        
        SelectDB.selectNAME_ADDRESS_INFO(conBILL, "B", idNAME_ADDRESS_INFO, stNAME_ADDRESS_INFO);
        
        ArrayList<String> idNAME_ADDRESS_INFO_R = new ArrayList<String>();
        ArrayList<NAME_ADDRESS_INFO> stNAME_ADDRESS_INFO_R=new ArrayList<NAME_ADDRESS_INFO>(); 
        
        SelectDB.selectNAME_ADDRESS_INFO(conBILL, "R", idNAME_ADDRESS_INFO_R, stNAME_ADDRESS_INFO_R);
        
        // get BANK
        ArrayList<String> idBANK = new ArrayList<String>();
        ArrayList<BANK> stBANK=new ArrayList<BANK>(); 
        
        SelectDB.selectBANK(conBILL, idBANK, stBANK);
        
        // get USAGE_S
        ArrayList<String> idUSAGE_S = new ArrayList<String>();
        ArrayList<USAGE_S> stUSAGE_S=new ArrayList<USAGE_S>();
        SelectDB.selectUSAGE_S(conBILL, stCYCLE_CONTROL.get(0).getUSG_BUCKET(), CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idUSAGE_S, stUSAGE_S);
     
        // get ACCT LIST 
        ArrayList<String> idACCOUNT_LIST_XX = new ArrayList<String>();
        ArrayList<ACCOUNT_LIST_XX> stACCOUNT_LIST_XX=new ArrayList<ACCOUNT_LIST_XX>();   
        
        SelectDB.selectACCOUNT_LIST_XX(conBILL, stCYCLE_CONTROL.get(0).getACCT_LIST_NAME(), 
        		idACCOUNT_LIST_XX, stACCOUNT_LIST_XX);
        
        // get ACCOUNT_TYPE
        ArrayList<String> idACCOUNT_TYPE = new ArrayList<String>();
        ArrayList<ACCOUNT_TYPE> stACCOUNT_TYPE=new ArrayList<ACCOUNT_TYPE>();   
        
        SelectDB.selectACCOUNT_TYPE(conBILL, idACCOUNT_TYPE, stACCOUNT_TYPE);
        
     // get PRINT_CATEGORY
        ArrayList<String> idPRINT_CATEGORY = new ArrayList<String>();
        ArrayList<PRINT_CATEGORY> stPRINT_CATEGORY=new ArrayList<PRINT_CATEGORY>();
        
        SelectDB.selectPRINT_CATEGORY(conBILL, idPRINT_CATEGORY, stPRINT_CATEGORY);
        
        ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO=new ArrayList<BILL_PRINT_INFO>();  
        
        for(int i=0;i<idBILL.size();i++){
        	BILL_PRINT_INFOUnknowValue BPIUnkonwValue=new BILL_PRINT_INFOUnknowValue(stBILL.get(i).getACCOUNT_ID(),CYCLE_CODE, CYCLE_YEAR, CYCLE_MONTH,null, null, null, null, null, null, null,null, null, null, null, null,stBILL.get(i).getBANK_CODE(),null,null,null,null );
        	
        	findBILL_PRINT_INFOUnknowValue.findNAME_ADDRESS_INFO(BPIUnkonwValue, stCYCLE_CONTROL.get(0), idNAME_ADDRESS_INFO, stNAME_ADDRESS_INFO);
        	
        	findBILL_PRINT_INFOUnknowValue.findNAME_ADDRESS_INFO_R(BPIUnkonwValue, stCYCLE_CONTROL.get(0), idNAME_ADDRESS_INFO_R, stNAME_ADDRESS_INFO_R);
        	
        	findBILL_PRINT_INFOUnknowValue.findBANK(BPIUnkonwValue, idBANK, stBANK);
        	
        	findBILL_PRINT_INFOUnknowValue.findMAX_PAGE(BPIUnkonwValue, idUSAGE_S, stUSAGE_S);
        	
        	findBILL_PRINT_INFOUnknowValue.findACCOUNT_LIST_XX(BPIUnkonwValue, idACCOUNT_LIST_XX, stACCOUNT_LIST_XX);
        	
        	findBILL_PRINT_INFOUnknowValue.findACCOUNT_TYPE(BPIUnkonwValue, stBILL.get(i).getACCOUNT_TYPE()+stBILL.get(i).getACCOUNT_SUB_TYPE(), idACCOUNT_TYPE, stACCOUNT_TYPE);
        	
        	if(idPRINT_CATEGORY.contains(BPIUnkonwValue.getPRINT_CATEGORY())){
        		
        		stBILL.get(i).setBILL_TYPE(stPRINT_CATEGORY.get(idPRINT_CATEGORY.indexOf(BPIUnkonwValue.getPRINT_CATEGORY())).getGOV_FORMAT());
        	}else{
        		stBILL.get(i).setBILL_TYPE("X");
        	}
        		stBILL_PRINT_INFO.add(new BILL_PRINT_INFO(
        			stBILL.get(i).getACCOUNT_ID(), //aCCOUNT_ID, 
        			CYCLE_CODE, //cYCLE_CODE, 
        			CYCLE_YEAR, //cYCLE_YEAR, 
        			CYCLE_MONTH, //cYCLE_MONTH, 
        			sysDateTime, //sYS_CREATION_DATE, 
        			null, //sYS_UPDATE_DATE, 
        			BPIUnkonwValue.getZIP_CODE(), //zIP_CODE, 
        			stBILL.get(i).getPYM_MTD(), //pYM_MTD, 
        			stBILL.get(i).getBILL_TYPE(), //bILL_TYPE, 
        			BPIUnkonwValue.getMAX_PAGE(), //mAX_PAGE, 
        			BPIUnkonwValue.getNAME(), //nAME, 
        			BPIUnkonwValue.getADDRESS1(), //aDDRESS1, 
        			BPIUnkonwValue.getADDRESS2(), //aDDRESS2, 
        			BPIUnkonwValue.getADDRESS3(), //aDDRESS3, 
        			BPIUnkonwValue.getADDRESS4(), //aDDRESS4, 
        			BPIUnkonwValue.getNAME_R(), //nAME, 
        			BPIUnkonwValue.getADDRESS1_R(), //aDDRESS1, 
        			BPIUnkonwValue.getADDRESS2_R(), //aDDRESS2, 
        			BPIUnkonwValue.getADDRESS3_R(), //aDDRESS3, 
        			BPIUnkonwValue.getADDRESS4_R(), //aDDRESS4, 
        			stBILL.get(i).getPRESENT_PRODUCT_NO(), //pRODUCT_NO, 
        			stBILL.get(i).getINVOICE_NUMBER(), //iNVOICE_NO, 
        			BPIUnkonwValue.getACCOUNT_TYPE_DES(), //aCCOUNT_TYPE_DES, 
        			stBILL.get(i).getDUE_DATE(), //bILL_DATE, 
        			stBILL.get(i).getPREVIOUS_AMT(), //PREVIOUS_BALANCE, 
        			stBILL.get(i).getPAYMENT_AMT(), //PAID_AMOUNT, 
        			stBILL.get(i).getTOTAL_ADJUST_NET_AMT(), //POST_BILL_ADJUSTMENT, 
        			stBILL.get(i).getTOTAL_NET_AMT(), //TOTAL_CURRENT_CHARGES, 
        			stBILL.get(i).getOUTSTANDING_AMT(), //OUTSTANDING_BALANCE, 
        			BPIUnkonwValue.getBANK_NO(), //bANK_NO, 
        			stBILL.get(i).getBANK_ACCOUNT_NO(), //cREDIT_CARD_NO, 
        			stBILL.get(i).getDUE_DATE(), //dUE_DATE, 
        			stBILL.get(i).getBILL_EXTRACT_DATE(), //bILL_EXTRACT_DATE, 
        			null, //qA_ACCOUNT_IND, 
        			null, //bILL_PRINT_IND
        			BPIUnkonwValue.getGOVERNMENT_CODE(),
        			BPIUnkonwValue.getSUB_GOV_CODE(),
        			BPIUnkonwValue.getPRINT_CATEGORY()
        			));
        	
        	
        }
        
        int record_insert=BILL_PRINT_INFO_DB.InsertBILL_PRINT_INFO(conBILL, stBILL_PRINT_INFO);
        System.out.println("Record in put="+stBILL_PRINT_INFO.size());
        System.out.println("Record in insert="+record_insert);
        
        try { conPRM.close(); } catch (Exception ignore) {}
	    try { conBILL.close(); } catch (Exception ignore) {}
	    if(stBILL_PRINT_INFO.size()!=record_insert){
	    	System.out.println("Fail!!");
	    	System.exit(-1);
	    }
	   
	    System.out.println("END");
	}

}
