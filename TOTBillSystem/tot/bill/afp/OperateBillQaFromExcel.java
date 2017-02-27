package tot.bill.afp;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import tot.bill.afp.AccountIDExtract;

import tot.bill.dao.BILL_PRINT_INFO_DB;
import tot.bill.dao.CHARGE_DB;
import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.model.SumCharge;
import tot.bill.model.SumChargeOnBill;
import tot.bill.process.ExtractCharge2File;
import tot.bill.process.ExtractUsage_XX2File;
import tot.bill.resources.setEnv;
import tot.bill.service.ChangeDateEnglishToThai;
import tot.bill.service.CreatePathCMY;
import tot.bill.service.ReadExcel;
import tot.bill.service.readCharge2mini;
import tot.bill.table.BILL_PRINT_INFO;
import tot.bill.table.BILL_QA;
import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.TAX_RATE;
import tot.bill.table.USAGE_XX;

public class OperateBillQaFromExcel {

	public static void main(String[] args) throws Exception,IOException, SQLException, FileNotFoundException, IllegalAccessException {
		System.out.println("Extract Bill QA Start");
		
		//get args 
		String CYCLE_CODE=args[0];
		String CYCLE_MONTH=args[1];
		String CYCLE_YEAR=args[2];
                
                String fileNameInput  =args[3];
               
				
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
        // get BILL_QA From Read Excelfile
        ArrayList<BILL_QA> stBILL_QA=new ArrayList<BILL_QA>();
        ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO=new ArrayList<BILL_PRINT_INFO>();   
        ArrayList<String> idBILL_PRINT_INFO = new ArrayList<String>();
        //SelectDB.selectBILL_QA(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, stBILL_QA);
        String PathOutputBillPrintInfo=setEnv.EXCEL_BILL_QA_file_INPUT+setEnv.folderEXEL_BILL_QA_file_input;
        String execlFilePath = PathOutputBillPrintInfo+fileNameInput;
        ReadExcel.readQABill(execlFilePath, stBILL_QA);
        
        
        for(BILL_QA billQa : stBILL_QA){
        
              BILL_PRINT_INFO billPrintinfo = SelectDB.selectBILL_PRINT_INFO_Regular_by_ACCID(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, billQa.getACCOUNT_ID());
              idBILL_PRINT_INFO.add(billPrintinfo.getACCOUNT_ID());
              stBILL_PRINT_INFO.add(billPrintinfo);
              
            
        }
        
        ArrayList<AccountIDExtract> stAccountIDExtract=new ArrayList<AccountIDExtract>();   
        
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
    	decimalFormatSymbols.setDecimalSeparator('.');
    	decimalFormatSymbols.setGroupingSeparator(',');
    	DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", decimalFormatSymbols);
    	String changeFormatVal="";
        for(int i=0;i<idBILL_PRINT_INFO.size();i++){
             try{
        	changeFormatVal="";
        	String phoneNumber=stBILL_PRINT_INFO.get(i).getPRODUCT_NO().substring(0, 1)+"-"+stBILL_PRINT_INFO.get(i).getPRODUCT_NO().substring(1, 5)+"-"+stBILL_PRINT_INFO.get(i).getPRODUCT_NO().substring(5, 9);       	
        	String accountNo=stBILL_PRINT_INFO.get(i).getACCOUNT_ID().substring(0, 2)+"-"+stBILL_PRINT_INFO.get(i).getACCOUNT_ID().substring(2, 7)+"-"+stBILL_PRINT_INFO.get(i).getACCOUNT_ID().substring(7, 12);
        	String invoiceNo=stBILL_PRINT_INFO.get(i).getINVOICE_NO()+"("+stBILL_PRINT_INFO.get(i).getACCOUNT_TYPE_DES()+")";
        			
        	if(stBILL_PRINT_INFO.get(i).getPYM_MTD().endsWith("CS")){
        		stBILL_PRINT_INFO.get(i).setPYM_MTD("CH");
        	}
        	
        	if(stBILL_PRINT_INFO.get(i).getPREVIOUS_BALANCE()==null || stBILL_PRINT_INFO.get(i).getPREVIOUS_BALANCE().equals("0")){
        		stBILL_PRINT_INFO.get(i).setPREVIOUS_BALANCE("0.00");
        	}else{
        		Double.parseDouble(stBILL_PRINT_INFO.get(i).getPREVIOUS_BALANCE());
        		changeFormatVal=decimalFormat.format(Double.parseDouble(stBILL_PRINT_INFO.get(i).getPREVIOUS_BALANCE()));
        		stBILL_PRINT_INFO.get(i).setPREVIOUS_BALANCE(changeFormatVal);
        	}
        	
        	if(stBILL_PRINT_INFO.get(i).getPAID_AMOUNT()==null || stBILL_PRINT_INFO.get(i).getPAID_AMOUNT().equals("0")){
        		stBILL_PRINT_INFO.get(i).setPAID_AMOUNT("0.00");
        	}else{
        		Double.parseDouble(stBILL_PRINT_INFO.get(i).getPAID_AMOUNT());
        		changeFormatVal=decimalFormat.format(Double.parseDouble(stBILL_PRINT_INFO.get(i).getPAID_AMOUNT()));
        		stBILL_PRINT_INFO.get(i).setPAID_AMOUNT(changeFormatVal);
        	}
        	
        	if(stBILL_PRINT_INFO.get(i).getPOST_BILL_ADJUSTMENT()==null || stBILL_PRINT_INFO.get(i).getPOST_BILL_ADJUSTMENT().equals("0")){
        		stBILL_PRINT_INFO.get(i).setPOST_BILL_ADJUSTMENT("0.00");
        	}else{
        		Double.parseDouble(stBILL_PRINT_INFO.get(i).getPOST_BILL_ADJUSTMENT());
        		changeFormatVal=decimalFormat.format(Double.parseDouble(stBILL_PRINT_INFO.get(i).getPOST_BILL_ADJUSTMENT()));
        		stBILL_PRINT_INFO.get(i).setPOST_BILL_ADJUSTMENT(changeFormatVal);
        	}
        	
        	if(stBILL_PRINT_INFO.get(i).getTOTAL_CURRENT_CHARGES()==null || stBILL_PRINT_INFO.get(i).getTOTAL_CURRENT_CHARGES().equals("0")){
        		stBILL_PRINT_INFO.get(i).setTOTAL_CURRENT_CHARGES("0.00");
        	}else{
        		Double.parseDouble(stBILL_PRINT_INFO.get(i).getTOTAL_CURRENT_CHARGES());
        		changeFormatVal=decimalFormat.format(Double.parseDouble(stBILL_PRINT_INFO.get(i).getTOTAL_CURRENT_CHARGES()));
        		stBILL_PRINT_INFO.get(i).setTOTAL_CURRENT_CHARGES(changeFormatVal);
        	}
        	
        	if(stBILL_PRINT_INFO.get(i).getOUTSTANDING_BALANCE()!=null && Double.parseDouble(stBILL_PRINT_INFO.get(i).getOUTSTANDING_BALANCE())<0){
        		stBILL_PRINT_INFO.get(i).setOUTSTANDING_BALANCE("0.00");
        	}
        	if(stBILL_PRINT_INFO.get(i).getOUTSTANDING_BALANCE()==null || stBILL_PRINT_INFO.get(i).getOUTSTANDING_BALANCE().equals("0")){
        		stBILL_PRINT_INFO.get(i).setOUTSTANDING_BALANCE("0.00");
        	}else{
        		Double.parseDouble(stBILL_PRINT_INFO.get(i).getOUTSTANDING_BALANCE());
        		changeFormatVal=decimalFormat.format(Double.parseDouble(stBILL_PRINT_INFO.get(i).getOUTSTANDING_BALANCE()));
        		stBILL_PRINT_INFO.get(i).setOUTSTANDING_BALANCE(changeFormatVal);
        	}
        	
               
                    stAccountIDExtract.add(new AccountIDExtract(
                                    stBILL_PRINT_INFO.get(i).getACCOUNT_ID(), //	accountID, 
                                    stBILL_PRINT_INFO.get(i).getMAX_PAGE(),//maxPage,
                                    stBILL_PRINT_INFO.get(i).getNAME(), //inputName, 
                                    stBILL_PRINT_INFO.get(i).getADDRESS1(), //aDDRESS_BILLING1, 
                                    stBILL_PRINT_INFO.get(i).getADDRESS2(), //aDDRESS_BILLING2, 
                                    stBILL_PRINT_INFO.get(i).getADDRESS3(), //aDDRESS_BILLING3, 
                                    stBILL_PRINT_INFO.get(i).getADDRESS4(), //aDDRESS_BILLING4, 
                                    phoneNumber, //phoneNumber, 
                                    accountNo, //accountNo, 
                                    invoiceNo, //invoiceNo, 
                                    ChangeDateEnglishToThai.YYYYMMDD2DDMMYYY(stCYCLE_CONTROL.get(0).getCYCLE_END_DATE()), //billDate, 
                                    stBILL_PRINT_INFO.get(i).getPYM_MTD(), //groupNo, 
                                    stBILL_PRINT_INFO.get(i).getPREVIOUS_BALANCE(), //previousBalance, 
                                    stBILL_PRINT_INFO.get(i).getPAID_AMOUNT(), //paidAmount, 
                                    stBILL_PRINT_INFO.get(i).getPOST_BILL_ADJUSTMENT(), //postBillAdjustment, 
                                    stBILL_PRINT_INFO.get(i).getTOTAL_CURRENT_CHARGES(), //totalCurrentCharges, 
                                    stBILL_PRINT_INFO.get(i).getOUTSTANDING_BALANCE(), //outstandingBalance, 
                                    ChangeDateEnglishToThai.YYYYMMDD2DDMMYYY(stBILL_PRINT_INFO.get(i).getDUE_DATE()), //dueDate
                                    stBILL_PRINT_INFO.get(i).getBANK_NAME(),
                                    stBILL_PRINT_INFO.get(i).getCREDIT_CARD_NO()
                                    ));
            }catch(Exception ex){
                
                    System.out.println("Acc id error :"+stBILL_PRINT_INFO.get(i).getACCOUNT_ID() );
                    
            }
        	
        }
        
        
        //gen file BillPrintInfo_file
        
        String homePath=setEnv.BillPrintInfo_file_gen;	
        String PathOutput="";
        if(CreatePathCMY.byCMY(homePath, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)==0){
        	 PathOutput=CreatePathCMY.byCMYString(homePath, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)+setEnv.folderBillPrintInfo_file_gen;
        	 //System.out.println( PathBackup);
        }else{
        	System.out.println("Can't Create Path");
        	System.exit(-1);
        }
       
        //create  file
        Writer writerOutputFile = null;
        try {
        	writerOutputFile = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(PathOutput+"exBan.txt"),"TIS620")); 
        } catch (IOException ex) {
            // report
        } 
       
        for(int i=0;i<stAccountIDExtract.size();i++){
        	writerOutputFile.write(stAccountIDExtract.get(i).getAccountID()+"|");          	
        	writerOutputFile.write(stAccountIDExtract.get(i).getMaxPage()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getInputName()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getADDRESS_BILLING1()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getADDRESS_BILLING2()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getADDRESS_BILLING3()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getADDRESS_BILLING4()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getPhoneNumber()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getAccountNo()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getInvoiceNo()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getBillDate()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getGroupNo()+"|");      	
        	writerOutputFile.write(stAccountIDExtract.get(i).getPreviousBalance()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getPaidAmount()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getPostBillAdjustment()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getTotalCurrentCharges()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getOutstandingBalance()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getDueDate()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getBANK_NAME()+"|");
        	writerOutputFile.write(stAccountIDExtract.get(i).getCREDIT_CARD_NO()+"\r\n");
        	
        }
        
        
        
        try {	    	 
        	writerOutputFile.close();	      
	    }catch (Exception ex) 
	    {/*ignore*/}
        
        
       // int record_insert=BILL_PRINT_INFO_DB.InsertQA_ACCOUNT_IND(conBILL, stBILL_QA, "QA");
        
        System.out.println("Record in put="+stBILL_QA.size());
        
        try { conPRM.close(); } catch (Exception ignore) {}
	try { conBILL.close(); } catch (Exception ignore) {}
	    
	//ExtractCharge2File.main(args);
        extracChargeToFile(args,stAccountIDExtract);
        SortFile1key.main(args);
        
        //ExtractUsage_XX2File.main(args);
        extractUsage_XXToFile(args, stAccountIDExtract);
        args[3] = "Y"; //set status QA
        GenBillRegular.main(args);
        
        ReadExcel.moveFile(execlFilePath, setEnv.EXCEL_BILL_QA_file_OUTPUT);    
        System.out.println("END OperateBillQaFromExcel");
        
        
	}
        
        public static void extracChargeToFile(String[] args,ArrayList<AccountIDExtract> stAccountIDExtract) throws Exception{ 
                System.out.println("ExtractCharge2File Start");

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

                   
                ArrayList<SumCharge> stSumCharge_SC=new ArrayList<SumCharge>();    
                   
                ArrayList<SumCharge> stSumCharge_DC=new ArrayList<SumCharge>();  
                
                for(AccountIDExtract accEx : stAccountIDExtract){
                        // get SumCharge  DSC
                        CHARGE_DB.selectSUM_CHARGE_SeviceChargeByAccId(conBILL, "in('DBT','CRD')", CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR,accEx.getAccountID(), stSumCharge_SC);
                        // get SumCharge  DBT  - CRD 
                        CHARGE_DB.selectSUM_CHARGE_SeviceChargeByAccId(conBILL, "='DSC'", CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR,accEx.getAccountID(), stSumCharge_DC);
                
                }
                

                // get Group Feature        
                ArrayList<structFeature> stFeature=new ArrayList<structFeature>();   
                structFeature.selectFEATURE(conBILL, stFeature);

                //get TAX_RATE
                ArrayList<TAX_RATE> stTAX_RATE=new ArrayList<TAX_RATE>(); 
                        SelectDB.selectTAX_RATE(conBILL, stTAX_RATE);

                ArrayList<SumChargeOnBill> stSumChargeOnBill=new ArrayList<SumChargeOnBill>();  
                ArrayList<SumChargeOnBill> stSumChargeOnBillMini=new ArrayList<SumChargeOnBill>();
                for(int i=0;i<stFeature.size();i++){    	
                        stSumChargeOnBillMini.add(new SumChargeOnBill(null,  stFeature.get(i).getCATEGORY_CODE(), null, null, null, null,null,null));
                }



                while((stSumCharge_SC.size()!=0 || stSumCharge_DC.size()!=0)){

                        if(stSumCharge_SC.size()!=0 && stSumCharge_DC.size()!=0){
                                if(stSumCharge_SC.get(0).getACCOUNT_ID().equals(stSumCharge_DC.get(0).getACCOUNT_ID())){
                                        readCharge2mini.readbyAccountID_DC(stSumCharge_SC.get(0).getACCOUNT_ID(), stSumChargeOnBillMini, stSumCharge_DC,stTAX_RATE);
                                        readCharge2mini.readbyAccountID_SC(stSumCharge_SC.get(0).getACCOUNT_ID(), stSumChargeOnBillMini, stSumCharge_SC,stTAX_RATE);


                                        readCharge2mini.addChargeOnBill(stSumChargeOnBillMini, stSumChargeOnBill);
                                }else{
                                        if(Long.parseLong(stSumCharge_SC.get(0).getACCOUNT_ID())<Long.parseLong(stSumCharge_DC.get(0).getACCOUNT_ID())){
                                                readCharge2mini.readbyAccountID_SC(stSumCharge_SC.get(0).getACCOUNT_ID(), stSumChargeOnBillMini, stSumCharge_SC,stTAX_RATE);
                                                readCharge2mini.addChargeOnBill(stSumChargeOnBillMini, stSumChargeOnBill);
                                        }else{
                                                readCharge2mini.readbyAccountID_DC(stSumCharge_SC.get(0).getACCOUNT_ID(), stSumChargeOnBillMini, stSumCharge_DC,stTAX_RATE);
                                                readCharge2mini.addChargeOnBill(stSumChargeOnBillMini, stSumChargeOnBill);
                                        }

                                }
                        }else{
                                if(stSumCharge_SC.size()!=0){
                                        readCharge2mini.readbyAccountID_SC(stSumCharge_SC.get(0).getACCOUNT_ID(), stSumChargeOnBillMini, stSumCharge_SC,stTAX_RATE);		        	
                                        readCharge2mini.addChargeOnBill(stSumChargeOnBillMini, stSumChargeOnBill);
                                }
                                if(stSumCharge_DC.size()!=0){
                                        readCharge2mini.readbyAccountID_DC(stSumCharge_SC.get(0).getACCOUNT_ID(), stSumChargeOnBillMini, stSumCharge_DC,stTAX_RATE);			        
                                        readCharge2mini.addChargeOnBill(stSumChargeOnBillMini, stSumChargeOnBill);
                                }
                        }


                }


                //gen file Charge_file

                String homePath=setEnv.Charge_file_gen;	
                String PathOutput="";
                if(CreatePathCMY.byCMY(homePath, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)==0){
                         PathOutput=CreatePathCMY.byCMYString(homePath, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)+setEnv.folderCharge_file_gen;
                         //System.out.println( PathOutput);
                }else{
                        System.out.println("Can't Create Path");
                        System.exit(-1);
                }

                //create  file
                Writer writerOutputFile = null;
                try {
                        writerOutputFile = new BufferedWriter(new OutputStreamWriter(
                                        new FileOutputStream(PathOutput+"chargeSummary.txt"),"TIS620")); 
                } catch (IOException ex) {
                    // report
                } 

                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator('.');
                decimalFormatSymbols.setGroupingSeparator(',');
                DecimalFormat decimalFormat = new DecimalFormat("#0.00", decimalFormatSymbols);
                String changeFormatVal="";


                for(int i=0;i<stSumChargeOnBill.size();i++){

                        writerOutputFile.write(stSumChargeOnBill.get(i).getACCOUNT_ID()+"|"); 
                        writerOutputFile.write(stSumChargeOnBill.get(i).getCATEGORY_CODE()+"|"); 
                        /*writerOutputFile.write(stSumChargeOnBill.get(i).getSUM_SC_ACTV_AMT()+"|"); 
                        writerOutputFile.write(stSumChargeOnBill.get(i).getSUM_SC_TAX_AMT()+"|"); 
                        writerOutputFile.write(stSumChargeOnBill.get(i).getSUM_DC_ACTV_AMT()+"|"); 
                        writerOutputFile.write(stSumChargeOnBill.get(i).getSUM_DC_TAX_AMT()+"\r\n"); 
                        */

                        if(stSumChargeOnBill.get(i).getSUM_SC_ACTV_AMT()==null){
                                writerOutputFile.write("0.00"+"|");
                        }else{
                                changeFormatVal=decimalFormat.format(Double.parseDouble(stSumChargeOnBill.get(i).getSUM_SC_ACTV_AMT()));
                                writerOutputFile.write(changeFormatVal+"|");
                        }

                        if(stSumChargeOnBill.get(i).getSUM_SC_TAX_AMT()==null){
                                writerOutputFile.write("0.00"+"|");
                        }else{
                                changeFormatVal=decimalFormat.format(Double.parseDouble(stSumChargeOnBill.get(i).getSUM_SC_TAX_AMT()));
                                writerOutputFile.write(changeFormatVal+"|");
                        }

                        if(stSumChargeOnBill.get(i).getSUM_DC_ACTV_AMT()==null){
                                writerOutputFile.write("0.00"+"|");
                        }else{
                                changeFormatVal=decimalFormat.format(Double.parseDouble(stSumChargeOnBill.get(i).getSUM_DC_ACTV_AMT()));
                                writerOutputFile.write(changeFormatVal+"|");
                        }

                        if(stSumChargeOnBill.get(i).getSUM_DC_TAX_AMT()==null){
                                writerOutputFile.write("0.00"+"|");
                        }else{
                                changeFormatVal=decimalFormat.format(Double.parseDouble(stSumChargeOnBill.get(i).getSUM_DC_TAX_AMT()));
                                writerOutputFile.write(changeFormatVal+"|");
                        }
                        writerOutputFile.write(stSumChargeOnBill.get(i).getTAX()+"|"); 
                        writerOutputFile.write(stSumChargeOnBill.get(i).getTAX_CODE()+"\r\n"); 

                }

                try {	    	 
                        writerOutputFile.close();	      
                    }catch (Exception ex) 
                    {/*ignore*/}
                try { conPRM.close(); } catch (Exception ignore) {}
                    try { conBILL.close(); } catch (Exception ignore) {}




                    System.out.println("END");
            
            
            
        
        
        }
        public static void extractUsage_XXToFile(String[] args ,ArrayList<AccountIDExtract> stAccountIDExtract) throws Exception{
                System.out.println("ExtractBillPrintInfo2File Start");

                        //get args 
                        String CYCLE_CODE=args[0];
                        String CYCLE_MONTH=args[1];
                        String CYCLE_YEAR=args[2];

                        //String statusQa =args[3];
                        //String statusBillType =args[4];

                        System.out.print("CYCLE_CODE="+CYCLE_CODE);
                        System.out.print(",CYCLE_MONTH="+CYCLE_MONTH);
                        System.out.println(",CYCLE_YEAR="+CYCLE_YEAR);	
                        //System.out.println("QA Status="+statusQa);

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

                // get BILL_PRINT_INFO
        //        ArrayList<String> idBILL_PRINT_INFO = new ArrayList<String>();
        //        ArrayList<BILL_PRINT_INFO> stBILL_PRINT_INFO=new ArrayList<BILL_PRINT_INFO>();   
        //        
        //        if(statusQa.equals("Y")){
        //        	if(statusBillType.equals("REG")){
        //        		SelectDB.selectBILL_PRINT_INFO_Regular_QA(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idBILL_PRINT_INFO, stBILL_PRINT_INFO, "QA");
        //        	}else{
        //        		SelectDB.selectBILL_PRINT_INFO_GOV_QA(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idBILL_PRINT_INFO, stBILL_PRINT_INFO, "QA");            	
        //        	}
        //        }else{
        //        	if(statusBillType.equals("REG")){
        //        		SelectDB.selectBILL_PRINT_INFO_Regular(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idBILL_PRINT_INFO, stBILL_PRINT_INFO);
        //        	}else{
        //        		SelectDB.selectBILL_PRINT_INFO_GOV(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, idBILL_PRINT_INFO, stBILL_PRINT_INFO);               
        //        	}
        //        }

                ArrayList<String> idUsage = new ArrayList<String>();
                ArrayList<USAGE_XX> stUSAGE_XX=new ArrayList<USAGE_XX>();   

                for(AccountIDExtract accEx : stAccountIDExtract){
                
                        SelectDB.selectUSAGE_XX_UByAccId(conBILL,stCYCLE_CONTROL.get(0).getUSG_BUCKET(), CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR,accEx.getAccountID(), idUsage, stUSAGE_XX); 

                }
                
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator('.');
                decimalFormatSymbols.setGroupingSeparator(',');
                DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", decimalFormatSymbols);
                String changeFormatVal="";
        //        for(int i=0;i<idBILL_PRINT_INFO.size();i++){
        //             try{
        //        	
        //        	
        //               
        //            }catch(Exception ex){
        //                
        //                    System.out.println("Acc id error :"+stBILL_PRINT_INFO.get(i).getACCOUNT_ID() );
        //                    
        //            }
        //        	
        //        }

                //gen file Usage_file

                String homePath=setEnv.Usage_file_gen;	
                String PathOutput="";
                if(CreatePathCMY.byCMY(homePath, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)==0){
                         PathOutput=CreatePathCMY.byCMYString(homePath, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)+setEnv.folderUsage_file_gen;
                         //System.out.println( PathBackup);
                }else{
                        System.out.println("Can't Create Path");
                        System.exit(-1);
                }

                //create  file
                Writer writerOutputFile = null;
                try {
                        writerOutputFile = new BufferedWriter(new OutputStreamWriter(
                                        new FileOutputStream(PathOutput+"exBan.txt"),"TIS620")); 
                } catch (IOException ex) {
                    // report
                } 
                double maxNum = idUsage.size();

                for(int i=0;i<idUsage.size();i++){
                       // double percen = (i/maxNum)*100;
                       // System.out.println(percen+"%");
                        writerOutputFile.write(stUSAGE_XX.get(i).getACCOUNT_ID()+"|");          	
                        writerOutputFile.write(stUSAGE_XX.get(i).getDIALED_TN()+"|");
                        writerOutputFile.write(stUSAGE_XX.get(i).getCONNECT_DATE()+"|");
                        writerOutputFile.write(stUSAGE_XX.get(i).getDESTINATION_ON_BILL()+"|");
                        writerOutputFile.write(stUSAGE_XX.get(i).getCALL_VOL_ROUNDED()+"|");
                        writerOutputFile.write(stUSAGE_XX.get(i).getCHARGE_AMT()+"\r\n");

                }



                try {	    	 
                        writerOutputFile.close();	      
                    }catch (Exception ex) 
                    {/*ignore*/}

                try { conPRM.close(); } catch (Exception ignore) {}
                    try { conBILL.close(); } catch (Exception ignore) {}




                    System.out.println("END");

            
        }
        
        

}
