package tot.bill.process;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import tot.bill.dao.CHARGE_DB;
import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.service.CheckEffExpDate;
import tot.bill.table.ACCUM_USAGE_XX;
import tot.bill.table.CHARGE;
import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.DISCOUNT;
import tot.bill.table.FEATURE;
import tot.bill.table.TAX_RATE;

public class CreateCharge {

	public static int CreateCharge (ArrayList<CHARGE> stCHARGE) throws SQLException, IOException{
		Connection conBILL = null;
		conBILL=createConnectionDB.openConnectBillDB();
		//get system datetime
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.ENGLISH);
		Calendar cal = Calendar.getInstance();		
		String sysDateTime=dateFormat.format(cal.getTime());
		
		DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd",Locale.ENGLISH);
		Calendar cal2 = Calendar.getInstance();		
		String sysDate=dateFormat2.format(cal2.getTime());
		
		ArrayList<TAX_RATE> stTAX_RATE=new ArrayList<TAX_RATE>(); 
		SelectDB.selectTAX_RATE(conBILL, stTAX_RATE);
		
		ArrayList<String> idFEATURE  = new ArrayList<String>();
	    ArrayList<FEATURE> stFEATURE =new ArrayList<FEATURE>();   
	        
	    SelectDB.selectFEATURE(conBILL, idFEATURE, stFEATURE);
		
		System.out.println("Create Charge  ="+stCHARGE.size());
		
		for(int i=0;i<stCHARGE.size();i++){
			
			//validate 1
			stCHARGE.get(i).setSYS_CREATION_DATE(sysDateTime);
			if(stCHARGE.get(i).getACCOUNT_ID()==null){
				System.out.println("Error ACCOUNT_ID is null ");
				return -1;
			}
			if(stCHARGE.get(i).getCHG_CREATION_DATE()==null){
				System.out.println("Error CHG_CREATION_DATE is null ");
				return -1;
			}
			
			//validate 3
			if(stCHARGE.get(i).getCHARGE_TYPE()==null){
				System.out.println("Error CHARGE_TYPE not valid");
				return -1;
			}else if(stCHARGE.get(i).getCHARGE_TYPE().equals("DBT")){
				double actv=Double.parseDouble(stCHARGE.get(i).getACTV_AMT());
				if(actv<0){
					System.out.println("fail validate 3 DBT, ACTV_AMT <0");
					return -1;
				}
				
			}else if(stCHARGE.get(i).getCHARGE_TYPE().equals("CRD")){
				double actv=Double.parseDouble(stCHARGE.get(i).getACTV_AMT());
				if(actv>0){
					System.out.println("fail validate 3 CRD, ACTV_AMT >0");
					return -1;
				}
			}else if(stCHARGE.get(i).getCHARGE_TYPE().equals("DSC")){
				double actv=Double.parseDouble(stCHARGE.get(i).getACTV_AMT());
				if(actv>0){
					System.out.println("fail validate 3 DSC, ACTV_AMT >0");
					return -1;
				}
				//validate 5
				if(stCHARGE.get(i).getDISCOUNT_CODE()==null||
					stCHARGE.get(i).getDISCOUNT_CODE().equals("")				   
						){
					System.out.println("fail validate 5 DSC,DISCOUNT_CODE is null ");
					return -1;
				}
			}else{
				System.out.println("Error CHARGE_TYPE not valid");
				return -1;
			}
			
			//validate 4
			if(!(stCHARGE.get(i).getREVENUE_CODE().equals("R") ||
			   stCHARGE.get(i).getREVENUE_CODE().equals("O") ||
			   stCHARGE.get(i).getREVENUE_CODE().equals("U")					
				)){
				System.out.println("fail validate 4 REVENUE_CODE not valid ");
				return -1;
			}
		
			//validate 6
			if(stCHARGE.get(i).getCHARGE_START_DATE()!=null && stCHARGE.get(i).getCHARGE_END_DATE()!=null){
				if(stCHARGE.get(i).getCHARGE_START_DATE().compareTo(stCHARGE.get(i).getCHARGE_END_DATE())>0){
					System.out.println("fail validate 6 CHARGE_START_DATE > CHARGE_END_DATE");
					return -1;
				}
				
			}
			//validate 7
			
			if(!(stCHARGE.get(i).getIMMEDIATE_IND().equals("Y")||stCHARGE.get(i).getIMMEDIATE_IND().equals("N"))){
				System.out.println("fail validate 7 IMMEDIATE_IND not valid");
				return -1;
			}
			//validate 8
			int status_getTax_rate=0;
			for(int y=0;y<stTAX_RATE.size();y++){
				//System.out.println(stTAX_RATE.get(y).getTAX_CODE());
				//System.out.println(stTAX_RATE.get(y).getTAX_RATE());
				if(stTAX_RATE.get(y).getTAX_CODE().equals(stCHARGE.get(i).getTAX_CODE())){
					
					double actv_amt=Double.parseDouble(stCHARGE.get(i).getACTV_AMT());
					double tax_rate=Double.parseDouble(stTAX_RATE.get(y).getTAX_RATE());
					double tax_amt=actv_amt*tax_rate/100;
					if(stCHARGE.get(i).getTAX_AMT()==null){
						stCHARGE.get(i).setTAX_AMT(String.valueOf(tax_amt));
					}
					status_getTax_rate=1;
					break;					
				}				
			}
			if(status_getTax_rate==0){
				System.out.println("fail validate 8 TAX_CODE not valid ");
				return -1;
			}
			
			//add CATEGORY_CODE
			if(idFEATURE.contains(stCHARGE.get(i).getFEATURE_CODE())){
				int indexFirstFEATURE=idFEATURE.indexOf(stCHARGE.get(i).getFEATURE_CODE());
    			int indexLastFEATURE=idFEATURE.lastIndexOf(stCHARGE.get(i).getFEATURE_CODE());
    			int status_match=0;
    			
    			for(int x=indexFirstFEATURE;x<=indexLastFEATURE;x++){
    				if(CheckEffExpDate.checkByBetweenDate(
    						stFEATURE.get(x).getEFFECTIVE_DATE(),
    						stFEATURE.get(x).getEXPIRATION_DATE(),
    						sysDate) 
    				   ){
    					stCHARGE.get(i).setCATEGORY_CODE(stFEATURE.get(x).getCATEGORY_CODE());
    					status_match=1;
    					break;
    				}
    			}
    			
    			if(status_match==0){
    				System.out.println("fail add CATEGORY_CODE  , FEATURE_CODE not found 1");
    				return -1;
    			}
				
			}else{
				System.out.println("fail add CATEGORY_CODE  , FEATURE_CODE not found ,"+stCHARGE.get(i).getFEATURE_CODE());
				return -1;
			}
			
			
			
		}
		
		//insert data
		int CHARGE_1SQ=0;
		int count_insert=0;
		for(int i=0;i<stCHARGE.size();i++){
			 System.out.println("Insert record="+(i+1));
			 CHARGE_1SQ=CHARGE_DB.InsertCHARGE(conBILL, stCHARGE.get(i));
			 System.out.println("CHARGE_1SQ="+CHARGE_1SQ);
		}
		
		try { conBILL.close(); } catch (Exception ignore) {}
		return CHARGE_1SQ;
		//return 0;
	}
	public static void main(String[] args) throws IOException, SQLException {
		String ACCOUNT_ID=args[0];	
		String INVOICE_SEQ_NO=args[1];
		String CYCLE_CODE=args[2];
		String CYCLE_YEAR=args[3];
		String CYCLE_MONTH=args[4];
		String PRODUCT_TYPE=args[5];
		String PRODUCT_NO=args[6];
		String CHG_CREATION_DATE=args[7];
		String CHARGE_TYPE=args[8];
		String IMMEDIATE_IND=args[9];
		String PRICE_PLAN=args[10];
		String FEATURE_CODE=args[11];
		String REVENUE_CODE=args[12];
		String DISCOUNT_CODE=args[13];
		String CATEGORY_CODE=args[14];
		String CHARGE_START_DATE=args[15];
		String CHARGE_END_DATE=args[16];
		String ACTV_DATE=args[17];
		String ACTV_AMT=args[18];
		String TAX_CODE=args[19];		
		String TOTAL_NUMBER_OF_CALLS=args[20];
		
		
		
		
		ArrayList<CHARGE> stCHARGE=new ArrayList<CHARGE>();    
		
		stCHARGE.add(new CHARGE(ACCOUNT_ID,null,INVOICE_SEQ_NO, 
				null, " ", CYCLE_CODE, 
				CYCLE_YEAR, CYCLE_MONTH, PRODUCT_TYPE, PRODUCT_NO, 
				CHG_CREATION_DATE, CHARGE_TYPE, IMMEDIATE_IND, 
				PRICE_PLAN, FEATURE_CODE, REVENUE_CODE, 
				DISCOUNT_CODE, CATEGORY_CODE, CHARGE_START_DATE, 
				CHARGE_END_DATE, ACTV_DATE, ACTV_AMT, TAX_CODE, 
				null, TOTAL_NUMBER_OF_CALLS));
		
		
		int exitValue=0;
		
		exitValue=CreateCharge(stCHARGE);
		System.out.println(exitValue);
		
		//System.exit(exitValue);
		
		
		
		
	}

}
