package tot.bill.process;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import tot.bill.dao.*;
import tot.bill.resources.setEnv;
import tot.bill.service.*;
import tot.bill.table.*;


public class RcProcess {
	public static void main(String[] args) throws  FileNotFoundException, IOException, SQLException{
		System.out.println("RC Process Start");
		
		//get args 
		String CYCLE_CODE=args[0];
		String CYCLE_MONTH=args[1];
		String CYCLE_YEAR=args[2];
		
        System.out.print("CYCLE_CODE="+CYCLE_CODE);
        System.out.print(",CYCLE_MONTH="+CYCLE_MONTH);
        System.out.println(",CYCLE_YEAR="+CYCLE_YEAR);
               
        //connect DB
        Connection conPRM = null;
        Connection conBILL = null;
        
        conBILL=createConnectionDB.openConnectBillDB();
        conPRM=createConnectionDB.openConnectPRMDB();
         
        //===============get REF and Data from DB=========================
       
             
        // get CYCLE_CONTROL        
        ArrayList<CYCLE_CONTROL> stCYCLE_CONTROL=new ArrayList<CYCLE_CONTROL>();    
        SelectDB.selectCYCLE_CONTROL(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, stCYCLE_CONTROL);
      
        System.out.println("Table ACCT LIST="+stCYCLE_CONTROL.get(0).getACCT_LIST_NAME());
        
        
        // get SERVICE_FEATURE
        System.out.println("get SERVICE_FEATURE");
        ArrayList<String> idSERVICE_FEATURE = new ArrayList<String>();
        ArrayList<SERVICE_FEATURE> stSERVICE_FEATURE=new ArrayList<SERVICE_FEATURE>();    
	    
        SelectDB.selectSERVICE_FEATURE_ByACL(conBILL, idSERVICE_FEATURE, stSERVICE_FEATURE,stCYCLE_CONTROL.get(0).getACCT_LIST_NAME());
        //SelectDB.selectSERVICE_FEATURE(conBILL, idSERVICE_FEATURE, stSERVICE_FEATURE);
                
        // get ACCT LIST 
        System.out.println("get ACCOUNT_LIST_XX");
        ArrayList<String> idACCOUNT_LIST_XX = new ArrayList<String>();
        ArrayList<ACCOUNT_LIST_XX> stACCOUNT_LIST_XX=new ArrayList<ACCOUNT_LIST_XX>();   
        
        SelectDB.selectACCOUNT_LIST_XX(conBILL, stCYCLE_CONTROL.get(0).getACCT_LIST_NAME(), 
        		idACCOUNT_LIST_XX, stACCOUNT_LIST_XX);
                    
        // get RC RATE 
        System.out.println("get RC RATE");
        ArrayList<String> idRC_RATE = new ArrayList<String>();
        ArrayList<RC_RATE> stRC_RATE=new ArrayList<RC_RATE>(); 
        
        SelectDB.selectRC_RATE(conBILL, idRC_RATE, stRC_RATE);
        
        // get PRE_RATED_RC  
        System.out.println("get PRE_RATED_RC");
        ArrayList<String> idPRE_RATED_RC = new ArrayList<String>();
        ArrayList<PRE_RATED_RC> stPRE_RATED_RC=new ArrayList<PRE_RATED_RC>(); 
        
        SelectDB.selectPRE_RATED_RC(conPRM, CYCLE_CODE, idPRE_RATED_RC, stPRE_RATED_RC);
        
        //create ERR file
        System.out.println("create ERR file");
        Writer writerErrorSFNotFound = null;
        Writer writerErrorRateNotFound = null;
        Writer writerErrorCanNotInsert = null;
        Writer writerErrorCanNotUpdate = null;
        Writer writerErrorNeedToInsert = null;
        
        try {
       	
        	String ErrPath=setEnv.ErrPathRc;	
        	String folderErr=CreatePathCMY.byCMYString("", CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)+setEnv.folderErrRC;
        	System.out.println(ErrPath+folderErr);
        	new File(ErrPath+folderErr).mkdir();
        	
        	writerErrorSFNotFound = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(ErrPath+folderErr+"ErrorSFNotFound.txt"), "utf-8"));                 
        	writerErrorRateNotFound = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(ErrPath+folderErr+"ErrorRateNotFound.txt"), "utf-8"));
        	writerErrorCanNotInsert = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(ErrPath+folderErr+"ErrorCanNotInsert.txt"), "utf-8"));                   
        	writerErrorCanNotUpdate = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(ErrPath+folderErr+"ErrorCanNotUpdate.txt"), "utf-8"));                   
        	writerErrorNeedToInsert = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(ErrPath+folderErr+"ErrorNeedToInsert.txt"), "utf-8"));
        	
                   
        } catch (IOException ex) {
          // report
        } 
        System.out.println("Start process");   
	    //3.2.1 
        
	    for (int i=0;i<idACCOUNT_LIST_XX.size();i++){
	    	System.out.println("======================="+idACCOUNT_LIST_XX.get(i)+"=================");
	    	String conALX_ID=idACCOUNT_LIST_XX.get(i);
	    	
	    	if( idPRE_RATED_RC.contains(conALX_ID)==false ){ // Not found in PRE_RATED_RC
	    		if( idSERVICE_FEATURE.contains(conALX_ID)==true ){
	    			int indexFirstSERVICE_FEATURE=idSERVICE_FEATURE.indexOf(conALX_ID);
	    			int indexLastSERVICE_FEATURE=idSERVICE_FEATURE.lastIndexOf(conALX_ID);
	    			for(int x=indexFirstSERVICE_FEATURE;x<=indexLastSERVICE_FEATURE;x++){
	    				
	    				System.out.println(stSERVICE_FEATURE.get(x).getACCOUNT_ID()
	    						+",Eff="+stSERVICE_FEATURE.get(x).getEFFECTIVE_DATE()
	    						+",EXP="+stSERVICE_FEATURE.get(x).getEXPIRATION_DATE()
	    						+",ISSUE="+stSERVICE_FEATURE.get(x).getISSUE_DATE());
	    				if(stSERVICE_FEATURE.get(x).getEXPIRATION_DATE()==null ||CheckEffExpDate.checkByBetweenDate(
	    						stCYCLE_CONTROL.get(0).getCYCLE_START_DATE(),
	    						stCYCLE_CONTROL.get(0).getCYCLE_END_DATE(),
	    						stSERVICE_FEATURE.get(x).getEXPIRATION_DATE()) 
	    				   ){

	    					System.out.println("  Account in cycle");
	    					if(CheckEffExpDate.checkByBetweenDate(
		    						stCYCLE_CONTROL.get(0).getCYCLE_START_DATE(),
		    						stCYCLE_CONTROL.get(0).getCYCLE_END_DATE(),
		    						stSERVICE_FEATURE.get(x).getISSUE_DATE()) 
		    				   ){
	    						System.out.println("    ISSUE_DATE in cycle");
	    						
	    						if(stSERVICE_FEATURE.get(x).getEXPIRATION_DATE()==null){
	    							System.out.println("      EXPIRATION_DATE is null Calculate Pro_rate New");
	    							
	    							Double resultRate=calRCRate.calProRate(stSERVICE_FEATURE.get(x).getEFFECTIVE_DATE()
				    						,stCYCLE_CONTROL.get(0).getCYCLE_END_DATE()
				    						,stCYCLE_CONTROL.get(0).getCYCLE_START_DATE()
				    						,stCYCLE_CONTROL.get(0).getCYCLE_END_DATE()
				    						,getRCRate.getRCRateDouble(stSERVICE_FEATURE.get(x).getPRICE_PLAN(),stSERVICE_FEATURE.get(x).getFEATURE_CODE(),idRC_RATE,stRC_RATE,stCYCLE_CONTROL)
				    						,stSERVICE_FEATURE.get(x).getFIRST_VAR_RATE_QTY());
				    				System.out.println("RATE="+resultRate);
				    				if(resultRate<0){
				    					System.out.println("Rate not found");
				    					writerErrorRateNotFound.write(conALX_ID+"\r\n");
				    				}else{
				    					int updateResult=PRE_RATED_RC_DB.InsertPRR_FIRST_BILL_IND_Y(conPRM,conALX_ID,
					    						stSERVICE_FEATURE.get(x).getPRODUCT_TYPE(),
					    						stSERVICE_FEATURE.get(x).getPRODUCT_NO(),
					    						stCYCLE_CONTROL.get(0).getCYCLE_CODE(),
					    						stSERVICE_FEATURE.get(x).getPRICE_PLAN(),
					    						stSERVICE_FEATURE.get(x).getFEATURE_CODE(),
					    						resultRate
					    						);
					    				if(updateResult!=1){
					    					System.out.println("Can't insert record");
			    							writerErrorCanNotInsert.write(conALX_ID+"\r\n");
			    						}
				    				}
	    							
	    							
	    							
	    						}else{
	    							System.out.println("      EXPIRATION_DATE is not null Calculate Pro_rate Expire");
	    							
	    							Double resultRate=calRCRate.calProRate(stCYCLE_CONTROL.get(0).getCYCLE_START_DATE()
				    						,stSERVICE_FEATURE.get(x).getEXPIRATION_DATE()
				    						,stCYCLE_CONTROL.get(0).getCYCLE_START_DATE()
				    						,stCYCLE_CONTROL.get(0).getCYCLE_END_DATE()
				    						,getRCRate.getRCRateDouble(stSERVICE_FEATURE.get(x).getPRICE_PLAN(),stSERVICE_FEATURE.get(x).getFEATURE_CODE(),idRC_RATE,stRC_RATE,stCYCLE_CONTROL)
				    						,stSERVICE_FEATURE.get(x).getFIRST_VAR_RATE_QTY());
				    				System.out.println("resultRate="+resultRate);
				    				
				    				if(resultRate<0){
				    					System.out.println("Rate not found");
				    					writerErrorRateNotFound.write(conALX_ID+"\r\n");
				    				}else{
				    					int updateResult=PRE_RATED_RC_DB.InsertPRR_LAST_BILL_IND_Y(conPRM,conALX_ID,
					    						stSERVICE_FEATURE.get(x).getPRODUCT_TYPE(),
					    						stSERVICE_FEATURE.get(x).getPRODUCT_NO(),
					    						stCYCLE_CONTROL.get(0).getCYCLE_CODE(),
					    						stSERVICE_FEATURE.get(x).getPRICE_PLAN(),
					    						stSERVICE_FEATURE.get(x).getFEATURE_CODE(),
					    						resultRate
					    						);
					    				if(updateResult!=1){
					    					System.out.println("Can't insert record");
			    							writerErrorCanNotInsert.write(conALX_ID+"\r\n");
			    						}
				    				}
				    				
				    				
				    				
	    						}
	    						
	    					}else{
	    						System.out.println("    ISSUE_DATE not in cycle Calculate RC_CHARGE");
	    						Double resultRate=calRCRate.calRateNormal(
	    								getRCRate.getRCRateDouble(stSERVICE_FEATURE.get(x).getPRICE_PLAN(),
	    								stSERVICE_FEATURE.get(x).getFEATURE_CODE(),
	    								idRC_RATE,stRC_RATE,stCYCLE_CONTROL)
			    						,stSERVICE_FEATURE.get(x).getFIRST_VAR_RATE_QTY());
			    				System.out.println("resultRate="+resultRate);
			    				if(resultRate<0){
			    					System.out.println("Rate not found");
			    					writerErrorRateNotFound.write(conALX_ID+"\r\n");
			    				}else{
				    				int updateResult=PRE_RATED_RC_DB.InsertPRR_FIRST_BILL_IND(conPRM,conALX_ID,
				    						stSERVICE_FEATURE.get(x).getPRODUCT_TYPE(),
				    						stSERVICE_FEATURE.get(x).getPRODUCT_NO(),
				    						stCYCLE_CONTROL.get(0).getCYCLE_CODE(),
				    						stSERVICE_FEATURE.get(x).getPRICE_PLAN(),
				    						stSERVICE_FEATURE.get(x).getFEATURE_CODE(),
				    						resultRate
				    						);
				    				if(updateResult!=1){
				    					System.out.println("Can't insert record");
		    							writerErrorCanNotInsert.write(conALX_ID+"\r\n");
		    						}
			    				}
	    					
	    					}
	    					
	    				}else{
	    					System.out.println("    Old record not use");
	    				}
	    			}
	    		}else{
	    			System.out.println("Error Servicer feature not found");
	    			writerErrorSFNotFound.write(conALX_ID+"\r\n");
	    		}
	    		
	    	}else{ // found in PRE_RATED_RC
	    		if( idSERVICE_FEATURE.contains(conALX_ID)==true ){
	    			int indexFirstSERVICE_FEATURE=idSERVICE_FEATURE.indexOf(conALX_ID);
	    			int indexLastSERVICE_FEATURE=idSERVICE_FEATURE.lastIndexOf(conALX_ID);
	    			System.out.println("Check SERVICE_FEATURE active");
	    			ArrayList<SERVICE_FEATURE> stSERVICE_FEATURE_Active=new ArrayList<SERVICE_FEATURE>();   
	    			ArrayList<SERVICE_FEATURE> stSERVICE_FEATURE_=new ArrayList<SERVICE_FEATURE>();   
	    			for(int x=indexFirstSERVICE_FEATURE;x<=indexLastSERVICE_FEATURE;x++){
	    				System.out.print(stSERVICE_FEATURE.get(x).getACCOUNT_ID()
	    						+",Eff="+stSERVICE_FEATURE.get(x).getEFFECTIVE_DATE()
	    						+",EXP="+stSERVICE_FEATURE.get(x).getEXPIRATION_DATE()
	    						+",ISSUE="+stSERVICE_FEATURE.get(x).getISSUE_DATE());
	    				if(stSERVICE_FEATURE.get(x).getEXPIRATION_DATE()==null ||CheckEffExpDate.checkByBetweenDate(
	    						stCYCLE_CONTROL.get(0).getCYCLE_START_DATE(),
	    						stCYCLE_CONTROL.get(0).getCYCLE_END_DATE(),
	    						stSERVICE_FEATURE.get(x).getEXPIRATION_DATE()) 
	    				   ){
	    					System.out.println("  Active");
	    					stSERVICE_FEATURE_Active.add(stSERVICE_FEATURE.get(x));
	    				
	    				}else{
	    					System.out.println("  UnActive");
	    					
	    					//update D
	    					//stSERVICE_FEATURE_Active.add(stSERVICE_FEATURE.get(x));
	    				}
	    			}
	    			
	    			ArrayList<PRE_RATED_RC> stPRE_RATED_RC_Active=new ArrayList<PRE_RATED_RC>(); 
	    			 
	    			int indexFirstPRE_RATED_RC=idPRE_RATED_RC.indexOf(conALX_ID);
        			int indexLastPRE_RATED_RC=idPRE_RATED_RC.lastIndexOf(conALX_ID);
        			for(int x=indexFirstPRE_RATED_RC;x<=indexLastPRE_RATED_RC;x++){
        				stPRE_RATED_RC_Active.add(stPRE_RATED_RC.get(x));
        				//System.out.println(stPRE_RATED_RC.get(x).getACCOUNT_ID());
        				//System.out.println(stPRE_RATED_RC.get(x).getLAST_BILL_IND());
        				
        			}
        			
        			
	    			if(stSERVICE_FEATURE_Active.size()!=0){
	    				System.out.println("Check record PRE_RATED_RC with SERVICE_FEATURE_Active ");
	    				for(int x=0;x<stSERVICE_FEATURE_Active.size();x++){
	    					System.out.print(stSERVICE_FEATURE_Active.get(x).getACCOUNT_ID());
	    					System.out.print(",PRODUCT_TYPE="+stSERVICE_FEATURE_Active.get(x).getPRODUCT_TYPE());
	    					System.out.print(",PRODUCT_NO="+stSERVICE_FEATURE_Active.get(x).getPRODUCT_NO());
	    					System.out.print(",PRICE_PLAN="+stSERVICE_FEATURE_Active.get(x).getPRICE_PLAN());
	    					System.out.println(",FEATURE_CODE="+stSERVICE_FEATURE_Active.get(x).getFEATURE_CODE());
	    					int status_match_record=0;
	    					for(int y=0;y<stPRE_RATED_RC_Active.size();y++){
	    						
	    						System.out.print(" "+stPRE_RATED_RC_Active.get(y).getACCOUNT_ID());
		    					System.out.print(",PRODUCT_TYPE="+stPRE_RATED_RC_Active.get(y).getPRODUCT_TYPE());
		    					System.out.print(",PRODUCT_NO="+stPRE_RATED_RC_Active.get(y).getPRODUCT_NO());
		    					System.out.print(",PRICE_PLAN="+stPRE_RATED_RC_Active.get(y).getPRICE_PLAN());
		    					System.out.println(",FEATURE_CODE="+stPRE_RATED_RC_Active.get(y).getFEATURE_CODE());
	    						if(stSERVICE_FEATURE_Active.get(x).getPRODUCT_TYPE().equals(stPRE_RATED_RC_Active.get(y).getPRODUCT_TYPE()) &&
	    						   stSERVICE_FEATURE_Active.get(x).getPRODUCT_NO().equals(stPRE_RATED_RC_Active.get(y).getPRODUCT_NO()) &&
	    						   stSERVICE_FEATURE_Active.get(x).getPRICE_PLAN().equals(stPRE_RATED_RC_Active.get(y).getPRICE_PLAN()) &&
	    						   stSERVICE_FEATURE_Active.get(x).getFEATURE_CODE().equals(stPRE_RATED_RC_Active.get(y).getFEATURE_CODE()) 
	    						  ){
	    							System.out.println(" Check");
	    							if(stPRE_RATED_RC_Active.get(y).getFIRST_BILL_IND()!=null &&
	    							   stPRE_RATED_RC_Active.get(y).getFIRST_BILL_IND().equals("Y")		    							   
	    							   ){
	    								System.out.println("  FIRST_BILL_IND=Y,Calculate RC_CHARGE Normal");
	    								
	    								Double resultRate=calRCRate.calRateNormal(getRCRate.getRCRateDouble(
	    										stSERVICE_FEATURE_Active.get(x).getPRICE_PLAN(),
	    										stSERVICE_FEATURE_Active.get(x).getFEATURE_CODE(),
	    										idRC_RATE,stRC_RATE,stCYCLE_CONTROL),
	    			    						stSERVICE_FEATURE_Active.get(x).getFIRST_VAR_RATE_QTY());
	    				    			if(resultRate<0){
	    			    					System.out.println("Rate not found");
	    			    					writerErrorRateNotFound.write(conALX_ID+"\r\n");
	    			    				}else{			    			
	    					    			int updateResult=PRE_RATED_RC_DB.UpdatePRR_FIRST_BILL_IND_N(
	    					    					conPRM,stPRE_RATED_RC_Active.get(y),
	    					    					resultRate,stSERVICE_FEATURE_Active.get(x));
	    					    			if(updateResult!=1){
    					    					System.out.println("Can't insert record");
    			    							writerErrorCanNotUpdate.write(conALX_ID+"\r\n");
    			    						}
	    			    				}
	    								
	    								
	    								
	    								status_match_record++;
	    							}else{
	    								if(CheckEffExpDate.checkByBetweenDate(
				    						stCYCLE_CONTROL.get(0).getCYCLE_START_DATE(),
				    						stCYCLE_CONTROL.get(0).getCYCLE_END_DATE(),
				    						stSERVICE_FEATURE_Active.get(x).getISSUE_DATE()) 
	    								   ){
	    									System.out.println("  Calculate Pro_rate Expire");
	    									Double resultRate=calRCRate.calProRate(stCYCLE_CONTROL.get(0).getCYCLE_START_DATE()
	    				    						,stSERVICE_FEATURE_Active.get(x).getEXPIRATION_DATE()
	    				    						,stCYCLE_CONTROL.get(0).getCYCLE_START_DATE()
	    				    						,stCYCLE_CONTROL.get(0).getCYCLE_END_DATE()
	    				    						,getRCRate.getRCRateDouble(stSERVICE_FEATURE_Active.get(x).getPRICE_PLAN(),stSERVICE_FEATURE_Active.get(x).getFEATURE_CODE(),idRC_RATE,stRC_RATE,stCYCLE_CONTROL)
	    				    						,stSERVICE_FEATURE_Active.get(x).getFIRST_VAR_RATE_QTY());
	    				    				System.out.println("resultRate="+resultRate);
	    				    				if(resultRate<0){
	    				    					System.out.println("Rate not found");
	    				    					writerErrorRateNotFound.write(conALX_ID+"\r\n");
	    				    				}else{
	    					    				int updateResult=PRE_RATED_RC_DB.UpdatePRR_LAST_BILL_IND_Y(conPRM,
	    					    						stPRE_RATED_RC_Active.get(y),resultRate,
	    					    						stSERVICE_FEATURE_Active.get(x));
	    					    				if(updateResult!=1){
	    					    					System.out.println("Can't update record");
	    			    							writerErrorCanNotUpdate.write(conALX_ID+"\r\n");
	    			    						}
	    				    				}
	    									
	    									status_match_record++;
	    								}else{
	    									System.out.println("  Record ok");
	    									status_match_record++;
	    								}
	    								
	    								
	    							}
	    							stPRE_RATED_RC_Active.remove(y);
	    							break;	    								
	    						}
	    						
	    					}
	    					System.out.println("status_match_record="+status_match_record);
	    					if(status_match_record==0){
	    						
	    						System.out.println("  SERVICE_FEATURE need to Insert");
	    						writerErrorNeedToInsert.write(stSERVICE_FEATURE_Active.get(x).getACCOUNT_ID()+"\r\n");
	    					}
	    					
	    				}
	    				if(stPRE_RATED_RC_Active.size()!=0){
	    					System.out.println("Mark IGNORE_IND='D'");
	    					for(int z=0;z<stPRE_RATED_RC_Active.size();z++){
	    						int updateResult=PRE_RATED_RC_DB.UpdatePRR_IGNORE_IND_D(conPRM,
	    								stPRE_RATED_RC_Active.get(z));
	    						if(updateResult!=1){
			    					System.out.println("Can't update record");
	    							writerErrorCanNotUpdate.write(conALX_ID+"\r\n");
	    						}
	    					}
	    					
	    				}
	    				
	    				
	    			}else{
	    				System.out.println("Error Servicer feature not found xx");
	    				
	    				writerErrorSFNotFound.write(conALX_ID+"\r\n");
	    			}
	    			
	    			
	    		}else{
	    			System.out.println("Error Servicer feature not found");
	    			writerErrorSFNotFound.write(conALX_ID+"\r\n");
	    		}
	    		
	    	}
	    }
	    
	    
	    try { conPRM.close(); } catch (Exception ignore) {}
	    try { conBILL.close(); } catch (Exception ignore) {}
	   
	    try {
	    	 
		    writerErrorSFNotFound.close();
	        writerErrorRateNotFound.close();
	        writerErrorCanNotInsert.close();
	        writerErrorCanNotUpdate.close();
	        writerErrorNeedToInsert.close();
	    }catch (Exception ex) 
	    {/*ignore*/}

	    System.out.println("END");
	}
	
}
