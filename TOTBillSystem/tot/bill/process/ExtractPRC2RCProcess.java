package tot.bill.process;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import tot.bill.dao.PRE_RATED_RC_DB;
import tot.bill.dao.RATED_RC_DB;
import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.service.CheckEffExpDate;
import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.PRE_RATED_RC;
import tot.bill.table.RATED_RC;
import tot.bill.table.SERVICE_FEATURE;

public class ExtractPRC2RCProcess {
	public static void main(String[] args) throws  FileNotFoundException, IOException, SQLException{
		System.out.println("ExtractPRE_RATED_RC_to_RATED_RC Start");
		
		//get args 
		String CYCLE_CODE=args[0];
		String CYCLE_MONTH=args[1];
		String CYCLE_YEAR=args[2];
		
        System.out.print("CYCLE_CODE="+CYCLE_CODE);
        System.out.print(",CYCLE_MONTH="+CYCLE_MONTH);
        System.out.println(",CYCLE_YEAR="+CYCLE_YEAR);
        
        //get ENV
        
        System.out.println(System.getenv("home"));
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
        
        // get SERVICE_FEATURE
        ArrayList<String> idSERVICE_FEATURE = new ArrayList<String>();
        ArrayList<SERVICE_FEATURE> stSERVICE_FEATURE=new ArrayList<SERVICE_FEATURE>();    
	    
        SelectDB.selectSERVICE_FEATURE_ByACL(conBILL, idSERVICE_FEATURE, stSERVICE_FEATURE,stCYCLE_CONTROL.get(0).getACCT_LIST_NAME());
        
        //SelectDB.selectSERVICE_FEATURE(conBILL, idSERVICE_FEATURE, stSERVICE_FEATURE);
        
        // get PRE_RATED_RC       
        ArrayList<String> idPRE_RATED_RC = new ArrayList<String>();
        ArrayList<PRE_RATED_RC> stPRE_RATED_RC=new ArrayList<PRE_RATED_RC>(); 
        ArrayList<RATED_RC> stRATED_RC=new ArrayList<RATED_RC>(); 
        ArrayList<PRE_RATED_RC> stPRE_RATED_LAST_BILL=new ArrayList<PRE_RATED_RC>(); 
        SelectDB.selectPRE_RATED_RC_NO_D(conPRM, CYCLE_CODE, idPRE_RATED_RC, stPRE_RATED_RC);
        
        for(int i=0;i<stPRE_RATED_RC.size();i++){
        	System.out.println("================================");
        	System.out.print("Account=");
        	System.out.print(stPRE_RATED_RC.get(i).getACCOUNT_ID());
        	System.out.print(",Charge=");
        	System.out.println(stPRE_RATED_RC.get(i).getCHARGE_AMT());
        	
        	
        	if(stPRE_RATED_RC.get(i).getLAST_BILL_IND()!=null && stPRE_RATED_RC.get(i).getLAST_BILL_IND().equals("Y")){
        		System.out.println("find service feature"+stPRE_RATED_RC.get(i).getACCOUNT_ID());       		
        		int indexFirstSERVICE_FEATURE=idSERVICE_FEATURE.indexOf(stPRE_RATED_RC.get(i).getACCOUNT_ID());
    			int indexLastSERVICE_FEATURE=idSERVICE_FEATURE.lastIndexOf(stPRE_RATED_RC.get(i).getACCOUNT_ID());
        		for(int x=indexFirstSERVICE_FEATURE;x<=indexLastSERVICE_FEATURE;x++){
        			if(stPRE_RATED_RC.get(i).getPRODUCT_TYPE().equals(stSERVICE_FEATURE.get(x).getPRODUCT_TYPE()) &&
        			   stPRE_RATED_RC.get(i).getPRODUCT_NO().equals(stSERVICE_FEATURE.get(x).getPRODUCT_NO()) &&
        			   stPRE_RATED_RC.get(i).getPRICE_PLAN().equals(stSERVICE_FEATURE.get(x).getPRICE_PLAN()) &&
        			   stPRE_RATED_RC.get(i).getFEATURE_CODE().equals(stSERVICE_FEATURE.get(x).getFEATURE_CODE()) &&
        			   CheckEffExpDate.checkByBetweenDate(stCYCLE_CONTROL.get(0).getCYCLE_START_DATE(),stCYCLE_CONTROL.get(0).getCYCLE_END_DATE(),stSERVICE_FEATURE.get(x).getISSUE_DATE())
        			   ){
        				System.out.println("cycle control start date="+stCYCLE_CONTROL.get(0).getCYCLE_START_DATE());
        				System.out.println("service exp date="+stSERVICE_FEATURE.get(x).getEXPIRATION_DATE());
        				stRATED_RC.add(new RATED_RC(stCYCLE_CONTROL.get(0).getCYCLE_CODE(),
                				stCYCLE_CONTROL.get(0).getCYCLE_MONTH(), 
                				stCYCLE_CONTROL.get(0).getCYCLE_YEAR(), 
                				stPRE_RATED_RC.get(i).getACCOUNT_ID(), 
                				stPRE_RATED_RC.get(i).getPRODUCT_TYPE(), 
                				stPRE_RATED_RC.get(i).getPRODUCT_NO(), 
                				stPRE_RATED_RC.get(i).getPRICE_PLAN(), 
                				stPRE_RATED_RC.get(i).getFEATURE_CODE(), 
                				stCYCLE_CONTROL.get(0).getCYCLE_START_DATE(), 
                				stSERVICE_FEATURE.get(x).getEXPIRATION_DATE(), 
                				sysDateTime, 
                				sysDateTime, 
                				stPRE_RATED_RC.get(i).getCHARGE_AMT()));
        				stPRE_RATED_LAST_BILL.add(stPRE_RATED_RC.get(i));
        			}
        		}
	
        	}else if(stPRE_RATED_RC.get(i).getFIRST_BILL_IND()!=null && stPRE_RATED_RC.get(i).getFIRST_BILL_IND().equals("Y")){
        		System.out.println("find service feature");       		
        		int indexFirstSERVICE_FEATURE=idSERVICE_FEATURE.indexOf(stPRE_RATED_RC.get(i).getACCOUNT_ID());
    			int indexLastSERVICE_FEATURE=idSERVICE_FEATURE.lastIndexOf(stPRE_RATED_RC.get(i).getACCOUNT_ID());
        		for(int x=indexFirstSERVICE_FEATURE;x<=indexLastSERVICE_FEATURE;x++){
        			if(stPRE_RATED_RC.get(i).getPRODUCT_TYPE().equals(stSERVICE_FEATURE.get(x).getPRODUCT_TYPE()) &&
        			   stPRE_RATED_RC.get(i).getPRODUCT_NO().equals(stSERVICE_FEATURE.get(x).getPRODUCT_NO()) &&
        			   stPRE_RATED_RC.get(i).getPRICE_PLAN().equals(stSERVICE_FEATURE.get(x).getPRICE_PLAN()) &&
        			   stPRE_RATED_RC.get(i).getFEATURE_CODE().equals(stSERVICE_FEATURE.get(x).getFEATURE_CODE()) &&
        			   CheckEffExpDate.checkByBetweenDate(stCYCLE_CONTROL.get(0).getCYCLE_START_DATE(),stCYCLE_CONTROL.get(0).getCYCLE_END_DATE(),stSERVICE_FEATURE.get(x).getISSUE_DATE())
        			   ){
        				System.out.println("cycle control end date="+stCYCLE_CONTROL.get(0).getCYCLE_END_DATE());
        				System.out.println("service start date="+stSERVICE_FEATURE.get(x).getEFFECTIVE_DATE());
        				
        				stRATED_RC.add(new RATED_RC(stCYCLE_CONTROL.get(0).getCYCLE_CODE(),
                				stCYCLE_CONTROL.get(0).getCYCLE_MONTH(), 
                				stCYCLE_CONTROL.get(0).getCYCLE_YEAR(), 
                				stPRE_RATED_RC.get(i).getACCOUNT_ID(), 
                				stPRE_RATED_RC.get(i).getPRODUCT_TYPE(), 
                				stPRE_RATED_RC.get(i).getPRODUCT_NO(), 
                				stPRE_RATED_RC.get(i).getPRICE_PLAN(), 
                				stPRE_RATED_RC.get(i).getFEATURE_CODE(), 
                				stSERVICE_FEATURE.get(x).getEFFECTIVE_DATE(), 
                				stCYCLE_CONTROL.get(0).getCYCLE_END_DATE(), 
                				sysDateTime, 
                				sysDateTime, 
                				stPRE_RATED_RC.get(i).getCHARGE_AMT()));
        			}
        		}
        	}else{
        		System.out.println("cycle control end date="+stCYCLE_CONTROL.get(0).getCYCLE_START_DATE());
        		System.out.println("cycle control end date="+stCYCLE_CONTROL.get(0).getCYCLE_END_DATE());
        		
        		stRATED_RC.add(new RATED_RC(stCYCLE_CONTROL.get(0).getCYCLE_CODE(),
        				stCYCLE_CONTROL.get(0).getCYCLE_MONTH(), 
        				stCYCLE_CONTROL.get(0).getCYCLE_YEAR(), 
        				stPRE_RATED_RC.get(i).getACCOUNT_ID(), 
        				stPRE_RATED_RC.get(i).getPRODUCT_TYPE(), 
        				stPRE_RATED_RC.get(i).getPRODUCT_NO(), 
        				stPRE_RATED_RC.get(i).getPRICE_PLAN(), 
        				stPRE_RATED_RC.get(i).getFEATURE_CODE(), 
        				stCYCLE_CONTROL.get(0).getCYCLE_START_DATE(), 
        				stCYCLE_CONTROL.get(0).getCYCLE_END_DATE(), 
        				sysDateTime, 
        				sysDateTime, 
        				stPRE_RATED_RC.get(i).getCHARGE_AMT()));
				
        	}
        	
        }
        
        
       
        int recordInsert=RATED_RC_DB.UpdateRATED_RC(conBILL,stRATED_RC);
        
        
        System.out.println("================================");
        System.out.println("SUMMARY RECORD="+stPRE_RATED_RC.size());
        System.out.println("SUMMARY RECORD Insert="+recordInsert);
        int updateResult=0;
        for(int i=0;i<stPRE_RATED_LAST_BILL.size();i++){
        	updateResult=updateResult+PRE_RATED_RC_DB.UpdatePRR_IGNORE_IND_D(conPRM,
        			stPRE_RATED_LAST_BILL.get(i));
        	
        }
        System.out.println("================================");
        System.out.println("SUMMARY RECORD D="+stPRE_RATED_LAST_BILL.size());
        System.out.println("SUMMARY RECORD Insert D="+updateResult);
	    try { conPRM.close(); } catch (Exception ignore) {}
	    try { conBILL.close(); } catch (Exception ignore) {}
	    
	    System.out.println("END");
	}

}
