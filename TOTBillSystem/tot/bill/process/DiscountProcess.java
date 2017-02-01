package tot.bill.process;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import tot.bill.dao.*;
import tot.bill.resources.setEnv;
import tot.bill.service.*;
import tot.bill.table.*;


public class DiscountProcess {

	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("Discount Process Start");
		//get args 
		String CYCLE_CODE=args[0];
		String CYCLE_MONTH=args[1];
		String CYCLE_YEAR=args[2];
				
		System.out.print("CYCLE_CODE="+CYCLE_CODE);
		System.out.print(",CYCLE_MONTH="+CYCLE_MONTH);
		System.out.println(",CYCLE_YEAR="+CYCLE_YEAR);
		
		//get system datetime
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
        
        // get ACCUM_USAGE_XX  
        ArrayList<String> idACCUM_USAGE_XX  = new ArrayList<String>();
        ArrayList<ACCUM_USAGE_XX> stACCUM_USAGE_XX =new ArrayList<ACCUM_USAGE_XX>();   
        
        SelectDB.selectACCUM_USAGE_XX(conBILL, CYCLE_CODE,CYCLE_MONTH, CYCLE_YEAR, 
        		stCYCLE_CONTROL.get(0).getACCUM_BUCKET(), idACCUM_USAGE_XX, stACCUM_USAGE_XX);
        
        // get RATED_RC   
        ArrayList<String> idRATED_RC  = new ArrayList<String>();
        ArrayList<RATED_RC> stRATED_RC =new ArrayList<RATED_RC>();   
        
        SelectDB.selectRATED_RC(conBILL, CYCLE_CODE,CYCLE_MONTH, CYCLE_YEAR, 
        		idRATED_RC, stRATED_RC);
		
        // get SERVICE_DISCOUNT
        ArrayList<String> idSERVICE_DISCOUNT = new ArrayList<String>();
        ArrayList<SERVICE_DISCOUNT> stSERVICE_DISCOUNT=new ArrayList<SERVICE_DISCOUNT>();  
        
        SERVICE_DISCOUNT_DB.selectSERVICE_DISCOUNT(conBILL, idSERVICE_DISCOUNT, stSERVICE_DISCOUNT);
        
     // get DISCOUNT_RATE
        ArrayList<String> idDISCOUNT_RATE = new ArrayList<String>();
        ArrayList<DISCOUNT_RATE> stDISCOUNT_RATE=new ArrayList<DISCOUNT_RATE>();  
        
        SelectDB.selectDISCOUNT_RATE(conBILL, idDISCOUNT_RATE, stDISCOUNT_RATE);
        
        ArrayList<DISCOUNT> stDISCOUNT=new ArrayList<DISCOUNT>();  
        
      //create ERR file
        Writer writerErrorRateNotFound = null;
        Writer writerErrorRatedRCNotFound = null;
        BufferedWriter writerErrorParentNotFound = null;
        BufferedWriter writerErrorRateRcParentNotFound = null;
        
        
        try {
       	
        	String ErrPath=setEnv.ErrPathDc;	
        	
        	String folderErr=CreatePathCMY.byCMYString("", CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)+setEnv.folderErrRC;       	
        	new File(ErrPath+folderErr).mkdir();
        	
        	writerErrorRateNotFound = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(ErrPath+folderErr+"ErrorRateNotFound.txt"), "utf-8")); 
        	writerErrorRatedRCNotFound = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(ErrPath+folderErr+"ErrorRatedRCNotFound.txt"), "utf-8"));
        	writerErrorParentNotFound = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(ErrPath+folderErr+"ErrorRateParentNotFound.txt"), "utf-8"));
        	writerErrorRateRcParentNotFound = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(ErrPath+folderErr+"writerErrorRateRcParentNotFound.txt"), "utf-8"));
        	
                   
        } catch (IOException ex) {
          // report
        } 
        
        for(int i=0;i<idSERVICE_DISCOUNT.size();i++){
        	System.out.println("======================="+idSERVICE_DISCOUNT.get(i)+"===========================");
        	System.out.print("=Check ACCOUNT_LIST_XX=");
        	if(idACCOUNT_LIST_XX.contains(idSERVICE_DISCOUNT.get(i))&&
        			CheckEffExpDate.checkByStartEndDate(
        				stSERVICE_DISCOUNT.get(i).getEFFECTIVE_DATE(),
        				stSERVICE_DISCOUNT.get(i).getEXPIRATION_DATE(),
        				stCYCLE_CONTROL.get(0).getCYCLE_START_DATE(),
        				stCYCLE_CONTROL.get(0).getCYCLE_END_DATE()
        			)
        	   ){
        		System.out.println("Found");
        		System.out.print("Calculate DISCOUNT Account id=");
        		String processID=stSERVICE_DISCOUNT.get(i).getACCOUNT_ID();
        		System.out.println(processID);
        		
        		//System.out.println(stSERVICE_DISCOUNT.get(i).getDISCOUNT_CODE());
        		//System.out.println(stSERVICE_DISCOUNT.get(i).getDISCOUNT_TYPE());
        		
        		//get record accu
        		System.out.println("=get ACCUM_USAGE_XX=================");
        		int indexFirstACCUM_USAGE_XX=0;
    			int indexLastACCUM_USAGE_XX=0;
        		BigDecimal sum = new BigDecimal(0);
        		if(idACCUM_USAGE_XX.contains(processID)){
        			System.out.println(" Found record in ACCUM_USAGE_XX");
        			indexFirstACCUM_USAGE_XX=idACCUM_USAGE_XX.indexOf(processID);
        			indexLastACCUM_USAGE_XX=idACCUM_USAGE_XX.lastIndexOf(processID); 
        			
        			for(int countACCUM=indexFirstACCUM_USAGE_XX;countACCUM<=indexLastACCUM_USAGE_XX;countACCUM++){
        				
        				if(stSERVICE_DISCOUNT.get(i).getPRODUCT_TYPE().equals(stACCUM_USAGE_XX.get(countACCUM).getPRODUCT_TYPE()) &&
             				   stSERVICE_DISCOUNT.get(i).getPRODUCT_NO().equals(stACCUM_USAGE_XX.get(countACCUM).getPRODUCT_NO())){
        					
        					if(idDISCOUNT_RATE.contains(stSERVICE_DISCOUNT.get(i).getDISCOUNT_CODE()+
        							stSERVICE_DISCOUNT.get(i).getDISCOUNT_TYPE()+"U")){
        						sum = sum.add(new BigDecimal(stACCUM_USAGE_XX.get(countACCUM).getCHARGE_AMT()));
        					}
        				}
        			}
        			
        			for(int countACCUM=indexFirstACCUM_USAGE_XX;countACCUM<=indexLastACCUM_USAGE_XX;countACCUM++){
        				
        				if(stSERVICE_DISCOUNT.get(i).getPRODUCT_TYPE().equals(stACCUM_USAGE_XX.get(countACCUM).getPRODUCT_TYPE()) &&
        				   stSERVICE_DISCOUNT.get(i).getPRODUCT_NO().equals(stACCUM_USAGE_XX.get(countACCUM).getPRODUCT_NO())        				   
        				  ){
        					System.out.print("  PRODUCT_TYPE,PRODUCT_NO match");
        					System.out.print(",ACCUM Charge AMT="+stACCUM_USAGE_XX.get(countACCUM).getCHARGE_AMT());
        					System.out.print(" ,Discount code="+stSERVICE_DISCOUNT.get(i).getDISCOUNT_CODE());
        					System.out.println(" ,Discount type="+stSERVICE_DISCOUNT.get(i).getDISCOUNT_TYPE());
        					if(idDISCOUNT_RATE.contains(stSERVICE_DISCOUNT.get(i).getDISCOUNT_CODE()+
        							stSERVICE_DISCOUNT.get(i).getDISCOUNT_TYPE()+"U")
        					   ){
        						System.out.println("  DISCOUNT_RATE found ");
        						int indexFirstDISCOUNT_RATE=idDISCOUNT_RATE.indexOf(stSERVICE_DISCOUNT.get(i).getDISCOUNT_CODE()+
            							stSERVICE_DISCOUNT.get(i).getDISCOUNT_TYPE()+"U");
        						
								double discountAMT=DiscountFN.findDiscountAcuuAVG(stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE), stACCUM_USAGE_XX.get(countACCUM),sum.doubleValue());
								
								System.out.println("     DiscountAMT="+discountAMT);
								stDISCOUNT.add(new DISCOUNT(
										CYCLE_CODE, 
										CYCLE_MONTH, 
										CYCLE_YEAR, 
										stACCUM_USAGE_XX.get(countACCUM).getACCOUNT_ID(), 
										stACCUM_USAGE_XX.get(countACCUM).getPRODUCT_TYPE(), 
										stACCUM_USAGE_XX.get(countACCUM).getPRODUCT_NO(), 
										stACCUM_USAGE_XX.get(countACCUM).getPRICE_PLAN(), 
										stACCUM_USAGE_XX.get(countACCUM).getFEATURE_CODE(), 
										stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getREVENUE_CODE(), 
										stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getDISCOUNT_CODE(), 
										stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getDISCOUNT_TYPE(), 
										sysDateTime, 
										sysDateTime, 
										String.valueOf(discountAMT * -1)
										));
								
								// insert parent
								if(stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getDISCOUNT_CODE().startsWith("UTC")){
									int indexAccList = idACCOUNT_LIST_XX.indexOf(idSERVICE_DISCOUNT.get(i));
									if(stACCOUNT_LIST_XX.get(indexAccList) != null &&
											stACCOUNT_LIST_XX.get(indexAccList).getPARENT_ACCOUNT_ID() != null){
										stDISCOUNT.add(new DISCOUNT(
												CYCLE_CODE, 
												CYCLE_MONTH, 
												CYCLE_YEAR, 
												stACCOUNT_LIST_XX.get(indexAccList).getPARENT_ACCOUNT_ID(), 
												stACCUM_USAGE_XX.get(countACCUM).getPRODUCT_TYPE(), 
												stACCUM_USAGE_XX.get(countACCUM).getPRODUCT_NO(), 
												stACCUM_USAGE_XX.get(countACCUM).getPRICE_PLAN(), 
												stACCUM_USAGE_XX.get(countACCUM).getFEATURE_CODE(), 
												stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getREVENUE_CODE(), 
												stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getDISCOUNT_CODE(), 
												stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getDISCOUNT_TYPE(), 
												sysDateTime, 
												sysDateTime, 
												String.valueOf(discountAMT)
												));
									}else{
										System.out.println("    Error : Parent not found");
										writerErrorParentNotFound.write(stACCOUNT_LIST_XX.get(indexAccList).getPARENT_ACCOUNT_ID());
										writerErrorParentNotFound.newLine();
									}
								}
        					}else{
        						System.out.println("      Error DISCOUNT_RATE not found ");
        						writerErrorRateNotFound.write(idSERVICE_DISCOUNT.get(i)+"\r\n");
        					}
        				}else{
        					System.out.println("  PRODUCT_TYPE,PRODUCT_NO not match");
        				}
        			}
        			
        		}else{
        			System.out.println(" Not Found record in ACCUM_USAGE_XX");
        		}
        		//get record rated_rc
        		System.out.println("=get RATED_RC=======================");
        		
        		int indexFirstRATED_RC=0;
    			int indexLastRATED_RC=0;
    			if(idRATED_RC.contains(processID)){
    				System.out.println(" Found record in RATED RC");
    				indexFirstRATED_RC=idRATED_RC.indexOf(processID);
        			indexLastRATED_RC=idRATED_RC.lastIndexOf(processID); 
        			
        			sum = new BigDecimal(0);
        			for(int countRATED_RC=indexFirstRATED_RC;countRATED_RC<=indexLastRATED_RC;countRATED_RC++){
        				if(stSERVICE_DISCOUNT.get(i).getPRODUCT_TYPE().equals(stRATED_RC.get(countRATED_RC).getPRODUCT_TYPE()) &&
              				   stSERVICE_DISCOUNT.get(i).getPRODUCT_NO().equals(stRATED_RC.get(countRATED_RC).getPRODUCT_NO())        				   
              				  ){
        					if(idDISCOUNT_RATE.contains(stSERVICE_DISCOUNT.get(i).getDISCOUNT_CODE()+
        							stSERVICE_DISCOUNT.get(i).getDISCOUNT_TYPE()+"R")
        					   ){
        						sum = sum.add(new BigDecimal(stRATED_RC.get(countRATED_RC).getCHARGE_AMT()));
        					}
        				}
        			}
        			for(int countRATED_RC=indexFirstRATED_RC;countRATED_RC<=indexLastRATED_RC;countRATED_RC++){
        				
        				if(stSERVICE_DISCOUNT.get(i).getPRODUCT_TYPE().equals(stRATED_RC.get(countRATED_RC).getPRODUCT_TYPE()) &&
             				   stSERVICE_DISCOUNT.get(i).getPRODUCT_NO().equals(stRATED_RC.get(countRATED_RC).getPRODUCT_NO())        				   
             				  ){
        					System.out.print("  PRODUCT_TYPE,PRODUCT_NO match");
        					System.out.print(" ,RATED_RC Charge AMT="+stRATED_RC.get(countRATED_RC).getCHARGE_AMT());
        					System.out.print(" ,Discount code="+stSERVICE_DISCOUNT.get(i).getDISCOUNT_CODE());
        					System.out.println(" ,Discount type="+stSERVICE_DISCOUNT.get(i).getDISCOUNT_TYPE());
        					if(idDISCOUNT_RATE.contains(stSERVICE_DISCOUNT.get(i).getDISCOUNT_CODE()+
        							stSERVICE_DISCOUNT.get(i).getDISCOUNT_TYPE()+"R")
        					   ){
        						System.out.println("  DISCOUNT_RATE found ");
        						int indexFirstDISCOUNT_RATE=idDISCOUNT_RATE.indexOf(stSERVICE_DISCOUNT.get(i).getDISCOUNT_CODE()+stSERVICE_DISCOUNT.get(i).getDISCOUNT_TYPE()+"R");
								double discountAMT=DiscountFN.findDiscountRatedRCAVG(stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE)
										, stRATED_RC.get(countRATED_RC),sum.doubleValue());
        						System.out.println("     DiscountAMT="+discountAMT);
        						stDISCOUNT.add(new DISCOUNT(
        								CYCLE_CODE, 
        								CYCLE_MONTH, 
        								CYCLE_YEAR, 
        								stRATED_RC.get(countRATED_RC).getACCOUNT_ID(), 
        								stRATED_RC.get(countRATED_RC).getPRODUCT_TYPE(), 
        								stRATED_RC.get(countRATED_RC).getPRODUCT_NO(), 
        								stRATED_RC.get(countRATED_RC).getPRICE_PLAN(), 
        								stRATED_RC.get(countRATED_RC).getFEATURE_CODE(), 
        								stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getREVENUE_CODE(), 
        								stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getDISCOUNT_CODE(), 
        								stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getDISCOUNT_TYPE(), 
        								sysDateTime, 
        								sysDateTime, 
        								String.valueOf(discountAMT * -1)
        								));
        						
        						// insert parent
        						if(stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getDISCOUNT_CODE().startsWith("UTC")){
        							int indexAccList = idACCOUNT_LIST_XX.indexOf(idSERVICE_DISCOUNT.get(i));
        							if(stACCOUNT_LIST_XX.get(indexAccList) != null &&
        									stACCOUNT_LIST_XX.get(indexAccList).getPARENT_ACCOUNT_ID() != null){
        								stDISCOUNT.add(new DISCOUNT(
                								CYCLE_CODE, 
                								CYCLE_MONTH, 
                								CYCLE_YEAR, 
                								stACCOUNT_LIST_XX.get(indexAccList).getPARENT_ACCOUNT_ID(), 
                								stRATED_RC.get(countRATED_RC).getPRODUCT_TYPE(), 
                								stRATED_RC.get(countRATED_RC).getPRODUCT_NO(), 
                								stRATED_RC.get(countRATED_RC).getPRICE_PLAN(), 
                								stRATED_RC.get(countRATED_RC).getFEATURE_CODE(), 
                								stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getREVENUE_CODE(), 
                								stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getDISCOUNT_CODE(), 
                								stDISCOUNT_RATE.get(indexFirstDISCOUNT_RATE).getDISCOUNT_TYPE(), 
                								sysDateTime, 
                								sysDateTime, 
                								String.valueOf(discountAMT)
                								));
        							}else{
        								System.out.println("    Error : Parent not found");
        								writerErrorRateRcParentNotFound.write(stACCOUNT_LIST_XX.get(indexAccList).getPARENT_ACCOUNT_ID());
        								writerErrorRateRcParentNotFound.newLine();
        							}
        						}
        					}else{
        						System.out.println("Error DISCOUNT_RATE not found ");
        						writerErrorRateNotFound.write(idSERVICE_DISCOUNT.get(i)+"\r\n");
        					}
        				}else{
        					System.out.println("  PRODUCT_TYPE,PRODUCT_NO not match");
        				}
        			}
    			}else{
    				System.out.println(" Not Found record in RATED RC");
    				writerErrorRatedRCNotFound.write(idSERVICE_DISCOUNT.get(i)+"\r\n");
    			}
        		//get record discount rate
        		
        	}else{
        		System.out.println("Not Found");
        		System.out.println("Discount Account "+idSERVICE_DISCOUNT.get(i)+" not found in " +
        				stCYCLE_CONTROL.get(0).getACCT_LIST_NAME()+" or Eff Exp not in Cycle");
        	}
        }
        System.out.println("==================================================");
        System.out.println("Insert record to DISCOUNT table");
        
        int recordInsert=DISCOUNT_DB.UpdateDISCOUNT(conBILL, stDISCOUNT);
        
        System.out.println("================================");
        System.out.println("SUMMARY RECORD="+stDISCOUNT.size());
        System.out.println("SUMMARY RECORD Insert="+recordInsert);
        
        try { conPRM.close(); } catch (Exception ignore) {}
	    try { conBILL.close(); } catch (Exception ignore) {}
	    
	    try {
	    	 
		    writerErrorRateNotFound.close();
		    writerErrorRatedRCNotFound.close();
		    writerErrorParentNotFound.flush();
		    writerErrorParentNotFound.close();
		    writerErrorRateRcParentNotFound.flush();
		    writerErrorRateRcParentNotFound.close();
	       
	    }catch (Exception ex) 
	    {/*ignore*/}
		
		System.out.println("END");
	}

}
