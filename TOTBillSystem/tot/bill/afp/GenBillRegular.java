package tot.bill.afp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.afplib.afplib.*;
import org.afplib.io.AfpOutputStream;
import org.apache.commons.beanutils.BeanComparator;
import static tot.bill.afp.GenBillGovernor.miniteToHHmmssFormat;

import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.model.SumChargeOnBill;
import tot.bill.resources.setEnv;
import tot.bill.service.ChangeDateEnglishToThai;
import tot.bill.service.CreatePathCMY;
import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.USAGE_XX;

public class GenBillRegular {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, FileNotFoundException, IOException, SQLException {
		System.out.println("GenBillRegular");
		
		//get args 
		String CYCLE_CODE=args[0];
		String CYCLE_MONTH=args[1];
		String CYCLE_YEAR=args[2];
		String statusQa =args[3];
		System.out.print("CYCLE_CODE="+CYCLE_CODE);
		System.out.print(",CYCLE_MONTH="+CYCLE_MONTH);
		System.out.println(",CYCLE_YEAR="+CYCLE_YEAR);	
		System.out.println("QA Status="+statusQa);
		 //connect DB
        Connection conPRM = null;
        Connection conBILL = null;
        
        conBILL=createConnectionDB.openConnectBillDB();
        conPRM=createConnectionDB.openConnectPRMDB();
        
        // get CYCLE_CONTROL        
        ArrayList<CYCLE_CONTROL> stCYCLE_CONTROL=new ArrayList<CYCLE_CONTROL>();    
        SelectDB.selectCYCLE_CONTROL(conBILL, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, stCYCLE_CONTROL);
      
        System.out.println("Table ACCT LIST="+stCYCLE_CONTROL.get(0).getACCT_LIST_NAME());
        
        // get Group Feature        
        ArrayList<structFeature> stFeature=new ArrayList<structFeature>();   
        structFeature.selectFEATURE(conBILL, stFeature);
        
        
		long startTime = System.currentTimeMillis();

		ArrayList<AccountIDExtract> exBan=new ArrayList<AccountIDExtract>();
		ArrayList<SumChargeOnBill> stCharge=new ArrayList<SumChargeOnBill>();
                Map<String,ArrayList<SumChargeOnBill>> stChargeMap = new HashMap<String, ArrayList<SumChargeOnBill>>();
                Map<String,ArrayList<USAGE_XX>> stUsageMap = new HashMap<String, ArrayList<USAGE_XX>>();
                Map<String,String> featureMap = new HashMap<String,String>();
                ArrayList<String>  idUsages = new ArrayList<String>();
		
		 ArrayList<String> AFPConfig = new ArrayList<String>();
		//read configAFP.txt
		try(BufferedReader readerexban = new BufferedReader(new InputStreamReader(new FileInputStream(setEnv.AFP_Config_file), "TIS620"));){
			String line = null;
			while((line = readerexban.readLine()) != null){
				String[] array = line.split("\\|"); 
				AFPConfig.add(array[0]);
				
			}
		}finally {
			//readerexban.close();
		}
		
				
		String[] ThaiMonth=new String[]{AFPConfig.get(0),AFPConfig.get(1),AFPConfig.get(2),AFPConfig.get(3),AFPConfig.get(4),AFPConfig.get(5),
				AFPConfig.get(6),AFPConfig.get(7),AFPConfig.get(8),AFPConfig.get(9),AFPConfig.get(10),AFPConfig.get(11),AFPConfig.get(12)};
	
		
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
    	decimalFormatSymbols.setDecimalSeparator('.');
    	decimalFormatSymbols.setGroupingSeparator(',');
    	DecimalFormat decimalFormat = new DecimalFormat("#0.00", decimalFormatSymbols);
		
		
		
		//read exban.txt
		
		
	    String PathOutputBillPrintInfo=CreatePathCMY.byCMYString(setEnv.BillPrintInfo_file_gen, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)+setEnv.folderBillPrintInfo_file_gen;
	    //System.out.println( PathOutput);
	   
		try(BufferedReader readerexban = new BufferedReader(new InputStreamReader(new FileInputStream(PathOutputBillPrintInfo+"exBan.txt"), "TIS620"));){
			String line = null;
			while((line = readerexban.readLine()) != null){
				String[] array = line.split("\\|"); 	
		    	//System.out.println(array[2]);
				exBan.add(new AccountIDExtract(array[0], array[1], array[2], array[3], array[4],
						array[5], array[6], array[7], array[8], array[9], array[10], array[11],
						array[12], array[13], array[14], array[15], array[16], array[17],array[18],array[19]));
			}
		}finally {
			//readerexban.close();
		}
		
		//read charge summary
		
	    String PathOutputCharge=CreatePathCMY.byCMYString(setEnv.Charge_file_gen, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)+setEnv.folderCharge_file_gen;
	    
		//System.out.println(PathOutputCharge);
	    FileReader inputFile=new FileReader(PathOutputCharge+"chargeSummary_sort.txt");
		
		try (BufferedReader br = new BufferedReader(inputFile)) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       // process the line.
		    	//System.out.println(line);
		    	String[] array = line.split("\\|"); 
		    	stCharge.add(new SumChargeOnBill(array[0], array[1], array[2],
		    			array[3],array[4],array[5],array[6],array[7]));
		    	
		    	if(stChargeMap.containsKey(array[0])){
                        
                                ArrayList<SumChargeOnBill>  chargeList = stChargeMap.get(array[0]);
                                
                                chargeList.add(new SumChargeOnBill(array[0], array[1], array[2],
		    			array[3],array[4],array[5],array[6],array[7]));
                            
                        
                        }else{
                                 ArrayList<SumChargeOnBill> chargeList = new ArrayList<SumChargeOnBill>();
                                 stChargeMap.put(array[0], chargeList);
                                 chargeList = stChargeMap.get(array[0]);
                                 
                                 chargeList.add(new SumChargeOnBill(array[0], array[1], array[2],
		    			array[3],array[4],array[5],array[6],array[7]));
                        
                        }
		    }
		}finally {
		    inputFile.close();
		}
                //Create feature map 
                for(structFeature feature:stFeature){
                
                        featureMap.put(feature.getCATEGORY_CODE(), feature.getFEATURE_DESC());
                }
                

                //read Usage
		
	    String PathOutputUsage=CreatePathCMY.byCMYString(setEnv.Usage_file_gen, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)+setEnv.folderUsage_file_gen;
	    
		System.out.println(PathOutputUsage);
	    FileReader inputUsageFile=new FileReader(PathOutputUsage+"exBan.txt");
		
		try (BufferedReader br = new BufferedReader(inputUsageFile)) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       // process the line.
		    	//System.out.println(line);
		    	String[] array = line.split("\\|"); 
                        
                        ArrayList<USAGE_XX>  usageList;
                        if(stUsageMap.containsKey(array[0])){
                            
                            usageList = stUsageMap.get(array[0]);
                            
                        
                        }else{
                            usageList = new ArrayList<USAGE_XX>();
                            stUsageMap.put(array[0], usageList);
                            usageList = stUsageMap.get(array[0]);
                            idUsages.add(array[0]);
                        }
                        USAGE_XX  usage = new USAGE_XX();
                            
                            usage.setACCOUNT_ID(array[0]);
                            usage.setDIALED_TN(array[1]);
                            usage.setCONNECT_DATE(array[2]);
                            usage.setDESTINATION_ON_BILL(array[3]);
                            usage.setCALL_VOL_ROUNDED(array[4]);
                            usage.setCHARGE_AMT(array[5]);
                            
                        usageList.add(usage);
                      		    	
		    }
		}finally {
		    inputFile.close();
		}
                
                //Sort Account by  maxPage and  Post code
                for(AccountIDExtract account:exBan){
                        //Update maxPage
                        int maxPage=2;
                        int itemsCountPage=0;
                        if(stUsageMap.containsKey(account.getAccountID())){
                            
                            ArrayList<USAGE_XX> usageList = stUsageMap.get(account.getAccountID());
                            itemsCountPage+=usageList.size()+2;
                        }
                        
                        if(stChargeMap.containsKey(account.getAccountID())){
                        
                            ArrayList<SumChargeOnBill> chargeList = stChargeMap.get(account.getAccountID());
                            itemsCountPage+=chargeList.size()+2;
                        }
                        itemsCountPage+=54;//Shift from First page logo
                        maxPage+= itemsCountPage/108;
                        if(itemsCountPage%108!=0){
                            maxPage++;
                        }
                        if(itemsCountPage==0){
                            maxPage++;
                        }
                        account.setMaxPage(String.valueOf(maxPage));
                
                }
               
                Comparator<AccountIDExtract> accComparetor = new Comparator<AccountIDExtract>() {

                    @Override
                    public int compare(AccountIDExtract o1, AccountIDExtract o2) {
                        
                        int result = Double.valueOf(o1.getMaxPage()).compareTo(Double.valueOf(o2.getMaxPage()));
                        Integer postCode1 = Integer.valueOf(o1.getADDRESS_BILLING4().split(",")[1]);
                        Integer postCode2 = Integer.valueOf(o2.getADDRESS_BILLING4().split(",")[1]);
                        return  result==0?postCode1.compareTo(postCode2):result;
                        
                    }
                };
                
                Collections.sort(exBan,accComparetor);
                int testNum=1;
                int sumPageNum =0;
                for(AccountIDExtract accTest :exBan){
                
                    sumPageNum+=Integer.valueOf(accTest.getMaxPage());
                    System.out.println("==============max page :"+accTest.getMaxPage()+"\t Post code :"+accTest.getADDRESS_BILLING4().split(",")[1]+"\t"+testNum);
                    testNum++;
                
                }
                System.out.println("====================================Sum pages is :"+sumPageNum);
                
                ///200,000 pages per 1 Gb per file
                
		System.out.println("Start Gen Bill AFP");
		//start gen bill process
		String PathOutputAFPRegular=CreatePathCMY.byCMYString(setEnv.AFP_Regular_file_gen, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)+setEnv.folderAFP_Regular_file_gen;
		System.out.println(PathOutputAFPRegular);
		new File(PathOutputAFPRegular).mkdir();
		String outputFile="";
                int numOfFiles=1;
		if(statusQa.equals("Y")){
			outputFile=PathOutputAFPRegular+"QA_Regular_Template"+String.format("%02d", numOfFiles)+".afp";
		}else{
			outputFile=PathOutputAFPRegular+"Regular_Template"+String.format("%02d", numOfFiles)+".afp";
		}
                AfpOutputStream aout;
		try  {
			
			aout = new AfpOutputStream(new FileOutputStream(outputFile));
			
			//Start Header=============================================
			afpCreateTag.createTagBDT(aout);
			afpCreateTag.createTagIMM(aout,"F20101PA");
			//End 
			//=========================================================
			
			int page_now=1;
                        int countPage=0;
                        int limitPagePerFile=1000;  //Default is 200,000
			for(int countDoc=0;countDoc<1000;countDoc++){
			//for(int countDoc=0;countDoc<exBan.size();countDoc++){	
			page_now=1;
                        //Calculate maxpage
			int currentPage=1;
                        System.out.println("====================Process Account:"+(countDoc+1));
                        
                         
			//Start Doc
			afpCreateTag.createTagBPG(aout);
			SetGnValue.setGNofBAG(aout);		
			
			afpCreateTag.createTagBPT(aout);
			PTX ptx = AfplibFactory.eINSTANCE.createPTX(); 
			
			afpCreateTag.setPTXxy(ptx,2150,1410);
			afpCreateTag.setFontID(ptx,60);
			if(exBan.get(countDoc).getGroupNo().equals("CH")){
				afpCreateTag.setPTX_TRN(ptx,"C"+String.format("%07d", countDoc+1));
			}else if(exBan.get(countDoc).getGroupNo().equals("DD")) {
				afpCreateTag.setPTX_TRN(ptx,"D"+String.format("%07d", countDoc+1));
			}
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagIPS(aout,355,212,"S1BLLTR1");
			
			afpCreateTag.createTagIPS(aout,3545,212,"S1SPACE1");
			
			afpCreateTag.createTagBPT(aout);
			
			ptx = AfplibFactory.eINSTANCE.createPTX(); 
			afpCreateTag.setPTXxy(ptx,4527,587);
			afpCreateTag.setFontID(ptx,57);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(13)+currentPage+" / "+exBan.get(countDoc).getMaxPage());
			
			afpCreateTag.setPTXxy(ptx,4275,587);
			afpCreateTag.setFontID(ptx,57);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(14));
			
			afpCreateTag.setPTXxy(ptx,440,587);
			afpCreateTag.setPTXRelativexy(ptx,1422,125);
			afpCreateTag.setFontID(ptx,82);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(15));
			
			if(exBan.get(countDoc).getGroupNo().equals("DD")){
			afpCreateTag.setPTXxy(ptx,2000,840);
			afpCreateTag.setFontID(ptx,80);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(16));
			}
			
			afpCreateTag.setPTXxy(ptx,3000,980);
			afpCreateTag.setFontID(ptx,60);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(17)+exBan.get(countDoc).getPhoneNumber());
			
			String[] f1=new String[]{exBan.get(countDoc).getInputName(),exBan.get(countDoc).getADDRESS_BILLING1(),
					exBan.get(countDoc).getADDRESS_BILLING2(),exBan.get(countDoc).getADDRESS_BILLING3(),
					exBan.get(countDoc).getADDRESS_BILLING4()};
			int f1_x=357;
			int f1_y=980;
			afpCreateTag.setFontID(ptx,60);
			for(int i=0;i<f1.length;i++){
				afpCreateTag.setPTXxy(ptx,f1_x,f1_y+(120*i));				
				afpCreateTag.setPTX_TRN(ptx,f1[i]);
			}
			
			String[] f2=new String[]{AFPConfig.get(18)+exBan.get(countDoc).getAccountNo(),
					AFPConfig.get(19)+exBan.get(countDoc).getInvoiceNo(),
					AFPConfig.get(20)+exBan.get(countDoc).getBillDate(),
					AFPConfig.get(21)+exBan.get(countDoc).getGroupNo()};
			int f2_x=3000;
			int f2_y=1100;
			afpCreateTag.setFontID(ptx,59);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(120*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			
			afpCreateTag.setPTXxy(ptx,355,1650);
			afpCreateTag.setFontID(ptx,80);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(22)+ThaiMonth[Integer.parseInt(CYCLE_MONTH)]+" "+Integer.toString((Integer.parseInt(CYCLE_YEAR)+543)));
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			SetGnValue.setGrayArea(aout);
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX();
			afpCreateTag.setPTXxy(ptx,357,1700);
			afpCreateTag.setSTC(ptx,8,1);
			afpCreateTag.setPTX_DrowBox(ptx,4350,287,2);
			
			afpCreateTag.setPTXxy(ptx,357,1987);
			afpCreateTag.setSTC(ptx,8,1);
			afpCreateTag.setPTX_DrowBox(ptx,4350,170,2);
			
			afpCreateTag.setPTXxy(ptx,3297,1700);
			afpCreateTag.setSTC(ptx,8,1);
			afpCreateTag.setPTX_DrowBox(ptx,790,457,2);
			
			afpCreateTag.setPTXxy(ptx,2469,1700);
			afpCreateTag.setSTC(ptx,8,1);
			afpCreateTag.setPTX_DrowBox(ptx,828,457,2);
			
			afpCreateTag.setPTXxy(ptx,1782,1700);
			afpCreateTag.setSTC(ptx,8,1);
			afpCreateTag.setPTX_DrowBox(ptx,687,457,2);
			
			afpCreateTag.setPTXxy(ptx,1075,1700);
			afpCreateTag.setSTC(ptx,8,1);
			afpCreateTag.setPTX_DrowBox(ptx,707,457,2);
			
			afpCreateTag.setPTXxy(ptx,583,1832);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(23));
			
			afpCreateTag.setPTXxy(ptx,1160,1832);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(24));
			
			afpCreateTag.setPTXxy(ptx,1960,1832);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(25));
			
			afpCreateTag.setPTXxy(ptx,2498,1832);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(26));
			
			afpCreateTag.setPTXxy(ptx,3340,1832);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(27));
			
			afpCreateTag.setPTXxy(ptx,4129,1832);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(28));
			
			
			afpCreateTag.setPTXxy(ptx,433,1955);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"(Previous Balance)");
			
			afpCreateTag.setPTXxy(ptx,1225,1955);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"(Paid Amount)");
			
			afpCreateTag.setPTXxy(ptx,1810,1955);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"(Post Bill Adjustment)");
			
			afpCreateTag.setPTXxy(ptx,2545,1955);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"(Total Current Charges)");
			
			afpCreateTag.setPTXxy(ptx,3365,1955);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"(Outstanding Balance)");
			
			afpCreateTag.setPTXxy(ptx,4240,1955);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"(Due Date)");
			
			afpCreateTag.setPTXxy(ptx,593,2100);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,exBan.get(countDoc).getPreviousBalance());
			
			afpCreateTag.setPTXxy(ptx,1300,2100);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,exBan.get(countDoc).getPaidAmount());
			
			afpCreateTag.setPTXxy(ptx,2090,2100);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,exBan.get(countDoc).getPostBillAdjustment());
			
			afpCreateTag.setPTXxy(ptx,2815,2100);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,exBan.get(countDoc).getTotalCurrentCharges());
			
			afpCreateTag.setPTXxy(ptx,3619,2100);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,exBan.get(countDoc).getOutstandingBalance());
			
			afpCreateTag.setPTXxy(ptx,4257,2100);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,exBan.get(countDoc).getDueDate());
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX(); 
			String[] f3;
			if(exBan.get(countDoc).getGroupNo().equals("DD")){
				String cardNo=exBan.get(countDoc).getCREDIT_CARD_NO();
				//System.out.println(exBan.get(countDoc).getAccountID()+" "+cardNo+"="+cardNo.length());
				if(cardNo.length()==16){
					cardNo=cardNo.substring(0, 4)+"XXXXXXXX"+cardNo.substring(12, 16);
				}else if(cardNo.length()==15){
					cardNo="XXXXXXXXX"+cardNo.substring(9, 15);
				}else if(cardNo.length()==14){
					cardNo="XXXXXXXX"+cardNo.substring(8, 14);
				}else if(cardNo.length()==12){
					cardNo="XXXXXX"+cardNo.substring(6, 12);
				}else if(cardNo.length()==10){
					cardNo="XXXXXX"+cardNo.substring(6, 10);
				}else{
					cardNo="XXXXXXXX"+cardNo.substring(cardNo.length()/2, cardNo.length());
				}
				
				f3=new String[]{AFPConfig.get(29),AFPConfig.get(30)
						,AFPConfig.get(31)+exBan.get(countDoc).getBANK_NAME()+AFPConfig.get(32)+cardNo+")"};
			}else{
				
				f3=new String[]{AFPConfig.get(33),AFPConfig.get(34)
						,AFPConfig.get(35)};	
			}
			int f3_x=355;
			int f3_y=2277;
			afpCreateTag.setFontID(ptx,59);
			for(int i=0;i<f3.length;i++){
				afpCreateTag.setPTXxy(ptx,f3_x,f3_y+(120*i));				
				afpCreateTag.setPTX_TRN(ptx,f3[i]);
			}
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX(); 
			
			afpCreateTag.setPTXxy(ptx,355,2562);
			//afpCreateTag.setSTC(ptx,8,1);
			afpCreateTag.setPTX_DrowBox(ptx,2400,182,2);
			
			afpCreateTag.setPTXxy(ptx,380,2682);
			//afpCreateTag.setPTXRelativexy(ptx,1422,125);
			afpCreateTag.setFontID(ptx,60);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(36));
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX(); 
			
			afpCreateTag.setPTXxy(ptx,355,2775);
			afpCreateTag.setPTX_DrowBox(ptx,2642,242,2);
			
			afpCreateTag.setPTXxy(ptx,1250,2775);
			afpCreateTag.setPTX_DrowBox(ptx,600,242,2);
			
			afpCreateTag.setPTXxy(ptx,1850,2775);
			afpCreateTag.setPTX_DrowBox(ptx,547,242,2);
			
			afpCreateTag.setPTXxy(ptx,604,2880);
			//afpCreateTag.setPTXRelativexy(ptx,1422,125);
			afpCreateTag.setFontID(ptx,79);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(37));
			afpCreateTag.setPTXxy(ptx,504,2980);
			//afpCreateTag.setPTXRelativexy(ptx,1422,125);
			afpCreateTag.setFontID(ptx,79);
			afpCreateTag.setPTX_TRN(ptx,"(Type of Services)          (Service Charge)     (Discount)          (Amount)");
			
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX(); 
			
		/*	afpCreateTag.setPTXxy(ptx,355,3015);
			afpCreateTag.setPTX_DrowBox(ptx,2642,542,2);
			
			afpCreateTag.setPTXxy(ptx,1250,3015);
			afpCreateTag.setPTX_DrowBox(ptx,600,542,2);
			
			afpCreateTag.setPTXxy(ptx,1850,3015);
			afpCreateTag.setPTX_DrowBox(ptx,547,542,2);
			*/
			afpCreateTag.setPTXxy(ptx,377,3120);
			afpCreateTag.setFontID(ptx,79);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(38)+"1"+AFPConfig.get(39));
			
			//System.out.println(Ban.get(countDoc));
			int f4_x=472;
			int f4_y=3235;
			afpCreateTag.setFontID(ptx,59);
			ArrayList<String> arraySC_AMT = new ArrayList<String>();
			ArrayList<String> arrayDC_AMT = new ArrayList<String>();
			ArrayList<String> arrayAL_AMT = new ArrayList<String>();
			ArrayList<String> arraySC_TAX = new ArrayList<String>();
			ArrayList<String> arrayDC_TAX = new ArrayList<String>();
			ArrayList<String> arrayTAX = new ArrayList<String>();
			ArrayList<String> arrayTAX_CODE = new ArrayList<String>();
			for(int i=0;i<stCharge.size();i++){
				if(exBan.get(countDoc).getAccountID().equals(stCharge.get(0).getACCOUNT_ID())){
					//System.out.println(stCharge.get(0).getfeatureCode());
					String chargeName="";
					for(int y=0;y<stFeature.size();y++){
						//System.out.println(stF.get(y).getfeatureCode());
						if(stCharge.get(0).getCATEGORY_CODE().equals(stFeature.get(y).getCATEGORY_CODE())){
							
							chargeName=stFeature.get(y).getFEATURE_DESC();
							//System.out.println("golf");
							break;
						}
					}
					afpCreateTag.setPTXxy(ptx,f4_x,f4_y+(120*i));				
					afpCreateTag.setPTX_TRN(ptx,chargeName);
					arraySC_AMT.add(stCharge.get(0).getSUM_SC_ACTV_AMT());
					arrayDC_AMT.add(stCharge.get(0).getSUM_DC_ACTV_AMT());
					arraySC_TAX.add(stCharge.get(0).getSUM_SC_TAX_AMT());
					arrayDC_TAX.add(stCharge.get(0).getSUM_DC_TAX_AMT());
					arrayTAX.add(stCharge.get(0).getTAX());
					arrayTAX_CODE.add(stCharge.get(0).getTAX_CODE());
					stCharge.remove(0);
				}else{
					break;
				}
				
			}
			
			/*String[] f4=new String[]{"�?�?าเ�?�?า","�?�?า�?�?�?�?ทรศั�?ท�?","�?�?า�?�?�?ทา�?�?�?ล / เ�?ลื�?อ�?ที�?"};
			int f4_x=472;
			int f4_y=3235;
			afpCreateTag.setFontID(ptx,59);
			for(int i=0;i<f4.length;i++){
				afpCreateTag.setPTXxy(ptx,f4_x,f4_y+(120*i));				
				afpCreateTag.setPTX_TRN(ptx,f4[i]);
			}
			*/
			
			//String[] f5=new String[]{"100.00","12.00","1,641.00"};
			
			String[] f5=arraySC_AMT.toArray(new String[0]);
			ChangeFormatToPrint.formatWithComma(f5);
			
			int f5_x=1700;//start 0.00
			int f5_y=3235;
			SetGnValue.CalPointFont59(ptx,f5,f5_x,f5_y);
			
			f5=arrayDC_AMT.toArray(new String[0]);
			ChangeFormatToPrint.formatWithComma(f5);
			f5_x=2250;//start 0.00
			f5_y=3235;
			SetGnValue.CalPointFont59(ptx,f5,f5_x,f5_y);
			
			for(int countarraySC=0;countarraySC<arraySC_AMT.size();countarraySC++){
				//decimalFormat.format(Double.parseDouble(arraySC_AMT.get(countarraySC))+Double.parseDouble(arrayDC_AMT.get(countarraySC)));
				arrayAL_AMT.add(decimalFormat.format(Double.parseDouble(arraySC_AMT.get(countarraySC))-Double.parseDouble(arrayDC_AMT.get(countarraySC))));
			}
			
			f5=arrayAL_AMT.toArray(new String[0]);
			ChangeFormatToPrint.formatWithComma(f5);
			f5_x=2850;//start 0.00
			f5_y=3235;
			SetGnValue.CalPointFont59(ptx,f5,f5_x,f5_y);
			
			
			afpCreateTag.setPTXxy(ptx,355,3015);
			afpCreateTag.setPTX_DrowBox(ptx,2642,(arraySC_AMT.size()*120)+120,2);
			
			afpCreateTag.setPTXxy(ptx,1250,3015);
			afpCreateTag.setPTX_DrowBox(ptx,600,(arraySC_AMT.size()*120)+120,2);
			
			afpCreateTag.setPTXxy(ptx,1850,3015);
			afpCreateTag.setPTX_DrowBox(ptx,547,(arraySC_AMT.size()*120)+120,2);
			
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBPT(aout);
			
			ptx = AfplibFactory.eINSTANCE.createPTX(); 
			afpCreateTag.setPTXxy(ptx,355,3015+(arraySC_AMT.size()*120)+120);
			afpCreateTag.setPTX_DrowBox(ptx,2642,120,2);
			
			afpCreateTag.setPTXxy(ptx,1250,3015+(arraySC_AMT.size()*120)+120);
			afpCreateTag.setPTX_DrowBox(ptx,600,120,2);
			
			afpCreateTag.setPTXxy(ptx,1850,3015+(arraySC_AMT.size()*120)+120);
			afpCreateTag.setPTX_DrowBox(ptx,547,120,2);
			
			afpCreateTag.setPTXxy(ptx,377,3015+(arraySC_AMT.size()*120)+120+105);
			afpCreateTag.setFontID(ptx,79);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(40));
			
			
			f5=new String[]{"0.00"};
			for (String temp : arraySC_AMT) {
				
				f5[0]=decimalFormat.format(Double.parseDouble(f5[0])+Double.parseDouble(temp));
			}
			ChangeFormatToPrint.formatWithComma(f5);
			//f5=new String[]{"1,753.00"};
			f5_x=1700;//start 0.00
			f5_y=3015+(arraySC_AMT.size()*120)+120+105;
			SetGnValue.CalPointFont79(ptx,f5,f5_x,f5_y);
			
			f5=new String[]{"0.00"};
			for (String temp : arrayDC_AMT) {
				
				f5[0]=decimalFormat.format(Double.parseDouble(f5[0])+Double.parseDouble(temp));
			}
			ChangeFormatToPrint.formatWithComma(f5);
			f5_x=2250;//start 0.00
			f5_y=3015+(arraySC_AMT.size()*120)+120+105;
			SetGnValue.CalPointFont79(ptx,f5,f5_x,f5_y);
			String Sum_DC=f5[0];

			f5=new String[]{"0.00"};
			for (String temp : arrayAL_AMT) {
				
				f5[0]=decimalFormat.format(Double.parseDouble(f5[0])+Double.parseDouble(temp));
			}
			ChangeFormatToPrint.formatWithComma(f5);
			f5_x=2850;//start 0.00
			f5_y=3015+(arraySC_AMT.size()*120)+120+105;
			SetGnValue.CalPointFont79(ptx,f5,f5_x,f5_y);
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX(); 
			afpCreateTag.setPTXxy(ptx,355,3015+(arraySC_AMT.size()*120)+120+120);
			afpCreateTag.setPTX_DrowBox(ptx,2642,370,2);
			
			String taxShow="";
			for (String temp : arrayTAX) {				
				taxShow=temp;
			}
			
			afpCreateTag.setPTXxy(ptx,377,3015+(arraySC_AMT.size()*120)+120+120+100);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(41)+taxShow+"%");
			afpCreateTag.setPTXxy(ptx,377,3015+(arraySC_AMT.size()*120)+120+120+100+120);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(42));
			afpCreateTag.setPTXxy(ptx,377,3015+(arraySC_AMT.size()*120)+120+120+100+120+120);
			afpCreateTag.setFontID(ptx,79);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(43));
			
			f5=new String[]{"0.00","0.00"};
			for (String temp : arrayAL_AMT) {
				
				f5[0]=decimalFormat.format(Double.parseDouble(f5[0])+Double.parseDouble(temp));
			}
			for (String temp : arraySC_TAX) {
				
				f5[1]=decimalFormat.format(Double.parseDouble(f5[1])+Double.parseDouble(temp));
				
			}
			for (String temp : arrayDC_TAX) {
				
				f5[1]=decimalFormat.format(Double.parseDouble(f5[1])-Double.parseDouble(temp));
				
			}
			String[] f6=f5.clone();
			
			ChangeFormatToPrint.formatWithComma(f6);
			
			//f5=new String[]{"1,553.00","3,675.00"};
			f5_x=2850;//start 0.00
			f5_y=3015+(arraySC_AMT.size()*120)+120+120+100;
			SetGnValue.CalPointFont59(ptx,f6,f5_x,f5_y);
			
			String sum_all=decimalFormat.format(Double.parseDouble(f5[0])+Double.parseDouble(f5[1]));
			f5=new String[]{sum_all};
			ChangeFormatToPrint.formatWithComma(f5);
			f5_x=2850;//start 0.00
			f5_y=3015+(arraySC_AMT.size()*120)+120+120+100+120+120;
			SetGnValue.CalPointFont79(ptx,f5,f5_x,f5_y);
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagIPS(aout,355,4698,"S1SLPTR1");
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX(); 
			
			afpCreateTag.setPTXxy(ptx,4555,4768);
			afpCreateTag.setFontID(ptx,57);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(44));
			
			afpCreateTag.setPTXxy(ptx,1560,4753);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(45));
			
			afpCreateTag.setPTXxy(ptx,1560,4835);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"      89/2 Moo 3 Chaengwattana Rd., Thungsonhong, Laksi, Bangkok 10210");
			
			afpCreateTag.setPTXxy(ptx,1560,4915);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(46));
			
			afpCreateTag.setPTXxy(ptx,355,5052);
			afpCreateTag.setFontID(ptx,79);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(47));
			
			afpCreateTag.setPTXxy(ptx,450,5182);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(48)+exBan.get(countDoc).getPhoneNumber());
			
			afpCreateTag.setPTXxy(ptx,450,5289);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(49)+exBan.get(countDoc).getAccountNo());
			
			afpCreateTag.setPTXxy(ptx,450,5398);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(50)+exBan.get(countDoc).getInvoiceNo());
			
			afpCreateTag.setPTXxy(ptx,450,5498);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(51));
			
			afpCreateTag.setPTXRelativexy(ptx, 20, 0);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,exBan.get(countDoc).getInputName());
			
			afpCreateTag.setPTXxy(ptx,450,5605);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(52));
			
			afpCreateTag.setPTXRelativexy(ptx, 35, 0);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,exBan.get(countDoc).getADDRESS_BILLING1());
			
			afpCreateTag.setPTXxy(ptx,950,5705);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,exBan.get(countDoc).getADDRESS_BILLING2());
			
			afpCreateTag.setPTXxy(ptx,950,5804);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,exBan.get(countDoc).getADDRESS_BILLING3());
			
			afpCreateTag.setPTXxy(ptx,950,5904);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,exBan.get(countDoc).getADDRESS_BILLING4());
			
			afpCreateTag.setPTXxy(ptx,355,6021);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(53)+exBan.get(countDoc).getOutstandingBalance());
			
			afpCreateTag.setPTXxy(ptx,355,6133);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(54)+Sum_DC);
			
			afpCreateTag.setPTXxy(ptx,355,6180);
			afpCreateTag.setPTX_DrowBox(ptx,1200,457,2);
			
			
			
			afpCreateTag.setPTXxy(ptx,420,6239+45);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"Service code : TOT");
			String ref1="";
			if(Sum_DC.equals("0.00")){
				ref1="02"+exBan.get(countDoc).getAccountNo().replaceAll("-", "");
				afpCreateTag.setPTXxy(ptx,420,6346+45);
				afpCreateTag.setFontID(ptx,59);
				afpCreateTag.setPTX_TRN(ptx,"Ref1: "+ref1);
				
			}else{
				ref1="92"+exBan.get(countDoc).getAccountNo().replaceAll("-", "");
				afpCreateTag.setPTXxy(ptx,420,6346+45);
				afpCreateTag.setFontID(ptx,59);
				afpCreateTag.setPTX_TRN(ptx,"Ref1: "+ref1);
				
			}
			String ref2="";
			for (String temp : arrayTAX_CODE) {				
				ref2=temp;				
			}
			ref2=ref2+exBan.get(countDoc).getInvoiceNo().substring(0, 13);
			afpCreateTag.setPTXxy(ptx,420,6451+45);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"Ref2: "+ref2);
			
			afpCreateTag.setPTXxy(ptx,420,6555+45);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"Amount: "+exBan.get(countDoc).getOutstandingBalance());
			
			afpCreateTag.setPTXxy(ptx,2562,6182+45);
			afpCreateTag.setFontID(ptx,79);
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(55)+exBan.get(countDoc).getDueDate());
			
			String outstandingWithOutDot="";
			outstandingWithOutDot=exBan.get(countDoc).getOutstandingBalance().replace(".", "");
			outstandingWithOutDot=outstandingWithOutDot.replace(",", "");
			afpCreateTag.setPTXxy(ptx,1172+1155,6386+45);
			afpCreateTag.setFontID(ptx,36);	    
			afpCreateTag.setPTX_TRN_Barcode(ptx,"010754500016100",ref1,ref2,outstandingWithOutDot);
			
			
			afpCreateTag.setPTXxy(ptx,1172+1155,6473+45);
			afpCreateTag.setFontID(ptx,36);
			afpCreateTag.setPTX_TRN_Barcode(ptx,"010754500016100",ref1,ref2,outstandingWithOutDot);
			
			afpCreateTag.setPTXxy(ptx,2585,6602+45);
			afpCreateTag.setFontID(ptx,59);
										 
			afpCreateTag.setPTX_TRN(ptx,"|010754500016100 "+ref1+" "+ref2+" "+outstandingWithOutDot);
			

			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBGR(aout);
			afpCreateTag.createTagBOG(aout);
			afpCreateTag.createTagOBD(aout,2362);
			afpCreateTag.createTagOBP(aout,1,23,4651,11520,11520);
			afpCreateTag.createTagGDD(aout,0);
			afpCreateTag.createTagEOG(aout);
			afpCreateTag.createTagGAD(aout,0);
			afpCreateTag.createTagEGR(aout);
			
			//OMR
			
			afpCreateTag.createTagBPT(aout);
			aout.writeStructuredField(ptx);
			
			int calOddbit=0;
			
			//start bit
			afpCreateTag.setPTXxy(ptx,120,517);
			afpCreateTag.setDIR(ptx,150,7,0);
			calOddbit++;
			
			String printBit=String.format("%5s", Integer.toBinaryString(((countDoc+1)%32))).replace(' ', '0');
			//bit 1 start 877 inc 120 to 1357
			for(int countOMRBit=4;countOMRBit>=0;countOMRBit--){
				if(printBit.charAt(countOMRBit)=='1'){	
					afpCreateTag.setPTXxy(ptx,120,1357-(120*countOMRBit));
					afpCreateTag.setDIR(ptx,150,7,0);
					calOddbit++;
				}
			}
                        
//                        if(maxPage==3){
//                            //stop page
//                            afpCreateTag.setPTXxy(ptx,120,1957);
//                            afpCreateTag.setDIR(ptx,150,7,0);
//                            calOddbit++;
//                        
//                        }
                           
			//stop bit
			afpCreateTag.setPTXxy(ptx,120,2197);
			afpCreateTag.setDIR(ptx,150,7,0);
			calOddbit++;
			
			if(calOddbit%2!=0){
			//check odd bit
			afpCreateTag.setPTXxy(ptx,120,757);
			afpCreateTag.setDIR(ptx,150,7,0);
			}
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagEPG(aout);
                        countPage++;
			//End Doc
			
			
			//Page 2 
			afpCreateTag.createTagBPG(aout);
			SetGnValue.setGNofBAG(aout);
			currentPage++;
			countPage++;
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX(); 
			
			afpCreateTag.setPTXxy(ptx,4522,342);
			afpCreateTag.setFontID(ptx,57);
			afpCreateTag.setPTX_TRN(ptx,"หน้า "+currentPage+" / "+exBan.get(countDoc).getMaxPage());
			
			afpCreateTag.setPTXxy(ptx,4275,342);
			afpCreateTag.setFontID(ptx,57);
			afpCreateTag.setPTX_TRN(ptx,"ส่วนที่  2");
			
			afpCreateTag.setPTXxy(ptx,2173,722);
			afpCreateTag.setFontID(ptx,60);
			afpCreateTag.setPTX_TRN(ptx,"รายละเอียดค่าใช้บริการ");
			
			afpCreateTag.setPTXxy(ptx,390,829);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"คุณ ปวิตเตอร์กอร์ ชาณเจริญลาภ");
			
			afpCreateTag.setPTXxy(ptx,2100,829);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"ประจำเดือน 08/2559");
			
			afpCreateTag.setPTXxy(ptx,2785,829);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"เลขที่ : 6080645901078 (RES)");
			
			afpCreateTag.setPTXxy(ptx,3960,829);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"รหัสลูกค้า : "+exBan.get(countDoc).getAccountNo());
			
			//box1
			int inc_point=0;
			for(int i=0;i<2;i++){
				
				afpCreateTag.setPTXxy(ptx,390+inc_point,984);
				afpCreateTag.setPTX_DrowBox(ptx,2147,237,2);
				
				afpCreateTag.setPTXxy(ptx,805+inc_point,984);
				afpCreateTag.setPTX_DrowBox(ptx,292,237,2);
				
				afpCreateTag.setPTXxy(ptx,1290+inc_point,984);
				afpCreateTag.setPTX_DrowBox(ptx,510,237,2);
				
				afpCreateTag.setPTXxy(ptx,2010+inc_point,984);
				afpCreateTag.setPTX_DrowBox(ptx,257,237,2);
				
				afpCreateTag.setPTXxy(ptx,1814+inc_point,1121);
				afpCreateTag.setFontID(ptx,78);
				afpCreateTag.setPTX_TRN(ptx,"ประเภท");
				
				afpCreateTag.setPTXxy(ptx,492+inc_point,1121);
				afpCreateTag.setFontID(ptx,78);
				afpCreateTag.setPTX_TRN(ptx,"หมายเลข");
				
				afpCreateTag.setPTXxy(ptx,837+inc_point,1121);
				afpCreateTag.setFontID(ptx,78);
				afpCreateTag.setPTX_TRN(ptx,"วันเดือนปี");
				
				afpCreateTag.setPTXxy(ptx,1133+inc_point,1121);
				afpCreateTag.setFontID(ptx,78);
				afpCreateTag.setPTX_TRN(ptx,"เวลา");
				
				afpCreateTag.setPTXxy(ptx,1337+inc_point,1121);
				afpCreateTag.setFontID(ptx,78);
				afpCreateTag.setPTX_TRN(ptx,"เรียกไป/เรียกจาก");
				
				afpCreateTag.setPTXxy(ptx,2029+inc_point,1121);
				afpCreateTag.setFontID(ptx,78);
				afpCreateTag.setPTX_TRN(ptx,"ครั้ง/นาที");
				
				afpCreateTag.setPTXxy(ptx,2276+inc_point,1121);
				afpCreateTag.setFontID(ptx,78);
				afpCreateTag.setPTX_TRN(ptx,"จำนวนเงิน");
				
				inc_point=2190;
			}
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
                        
                        //tail page
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX(); 
			
			afpCreateTag.setPTXxy(ptx,355,4359);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"บริษัทฯ ต้องขออภัยมา ณ ที่นี้หากท่านได้ชำระยอดค้างชำระก่อนได้รับใบแจ้งค่าใช้บริการฉบับนี้");
			
			afpCreateTag.setPTXxy(ptx,355,4479);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"โปรดตรวจสอบรายการที่แจ้งในใบแจ้งค่าใช้บริการก่อนการชำระเงิน");
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagIPS(aout,355,4644,"S1TRPCCS");
                        
                        
                        
			//body
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX(); 
			
			
			int rowCharge=0;
                        if(stChargeMap.containsKey(exBan.get(countDoc).getAccountID())){
                                afpCreateTag.setPTXxy(ptx,360,1329);
                                afpCreateTag.setFontID(ptx,79);
                                afpCreateTag.setPTX_TRN(ptx,"    1. หมายเลข "+exBan.get(countDoc).getPhoneNumber());
                                ArrayList<SumChargeOnBill> chargeList = stChargeMap.get(exBan.get(countDoc).getAccountID());
                                afpCreateTag.setFontID(ptx,58);
                                double sumChargeAmt=0;
                                for(SumChargeOnBill charge :chargeList){

                                        f2_x=420;
                                        f2_y=1440+(106*rowCharge);
                                        afpCreateTag.setPTXxy(ptx,f2_x,f2_y);				
                                        afpCreateTag.setPTX_TRN(ptx,featureMap.get(charge.getCATEGORY_CODE()));
                                        
                                        f2_x=2413;
                                        afpCreateTag.setPTXxy(ptx,f2_x,f2_y);	
                                        double chargeAmt = Double.valueOf(charge.getSUM_SC_ACTV_AMT())-Double.valueOf(charge.getSUM_DC_ACTV_AMT());
                                        sumChargeAmt = sumChargeAmt + chargeAmt;
                                        
                                        //afpCreateTag.setPTX_TRN(ptx,String.format("%,.2f", chargeAmt));
                                        SetGnValue.CalPointFont58Single(ptx, String.format("%,.2f", chargeAmt), f2_x, f2_y);
                                        rowCharge++;

                                }
                                f2_x=420;
                                f2_y=1440+(106*rowCharge);
                                afpCreateTag.setFontID(ptx,78);
                                afpCreateTag.setPTXxy(ptx,f2_x,f2_y);				
                                afpCreateTag.setPTX_TRN(ptx,"รวม");
                                        
                                f2_x=2413;
                                afpCreateTag.setPTXxy(ptx,f2_x,f2_y);	
                                //afpCreateTag.setPTX_TRN(ptx,String.format("%,.2f", sumChargeAmt));
                                SetGnValue.CalPointFont58Single(ptx, String.format("%,.2f", sumChargeAmt), f2_x, f2_y);
                                rowCharge++;
                                
                        }
                        
                        
//			f2=new String[]{"ค่าเช่าเลขหมาย","ค่าใช่โทรศัพท์","ค่าใช้ทางไกล/เคลื่อนที่","ส่วนลดค่าใช้","ส่วนลดค่าทางไกล"};
//			f2_x=420;
//			f2_y=1440;
//			afpCreateTag.setFontID(ptx,58);
//			for(int i=0;i<f2.length;i++){
//				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(106*i));				
//				afpCreateTag.setPTX_TRN(ptx,f2[i]);
//			}
//			
//			f5=new String[]{"100.00","12.00","1,641.00","-1.45","-198.55"};
//			f5_x=2413;//start 0.00
//			f5_y=1440;
//			SetGnValue.CalPointFont58(ptx,f5,f5_x,f5_y);
			
	
			
                        //Split list to balance row
                        if(stUsageMap.containsKey(exBan.get(countDoc).getAccountID())){
                                int numCharge =rowCharge+1;
                                int numRowCol1=0+numCharge;
                                int numRowCol2=0;
                                int numsplit  =0;
                                int numUsage  = stUsageMap.get(exBan.get(countDoc).getAccountID()).size();

                                if((numCharge+numUsage)%2==0){

                                    numsplit = (numCharge+numUsage)/2;
                                    numRowCol1 = numsplit;
                                    numRowCol2 = numsplit;

                                }else if((numCharge+numUsage)%2==1){

                                    numsplit = (numCharge+numUsage)/2;
                                    numRowCol1 = numsplit+1;
                                    numRowCol2 = numsplit;

                                }

                                ArrayList<USAGE_XX> usageList = stUsageMap.get(exBan.get(countDoc).getAccountID());
                                
                                int shiftTitle = 22;
                                int shiftDown = (106*numCharge);
                                if(rowCharge==0){
                                    shiftDown-=106;
                                }
                                if(usageList.size()>numCharge+2){
                                	afpCreateTag.setPTXxy(ptx,420+30,1404+shiftDown);
                                        afpCreateTag.setFontID(ptx,78);
                                        afpCreateTag.setPTX_TRN(ptx,"รายละเอียดค่าใช้ทางไกล/เคลื่อนที่  "+exBan.get(countDoc).getPhoneNumber());
                                
                                
                                }else{
                                        afpCreateTag.setPTXxy(ptx,397+2260,1314);
                                        afpCreateTag.setFontID(ptx,78);
                                        afpCreateTag.setPTX_TRN(ptx,"รายละเอียดค่าใช้ทางไกล/เคลื่อนที่  "+exBan.get(countDoc).getPhoneNumber());
                                        shiftTitle=125;
                                }
                                
                                
                                
                                
                                numRowCol1 = numRowCol1-numCharge-1;
                                if(rowCharge==0){
                                   // numRowCol1+=1;
                                    numCharge--;
                                }
                                afpCreateTag.setFontID(ptx,58);
                                int countUsage1=0;
                                int countUsage2=0;
                                int maxItemsLeft=52-27; //Full is 54
                                int maxItemsRight=54-27;
                                int totalCurentUsage=numUsage;
                                int usageLoop=0;
                                for(USAGE_XX usage:usageList){
                                        usageLoop++;
                                        
                                        if(countUsage1>=maxItemsLeft-numCharge&&countUsage2>=maxItemsRight){ //Check new page
                                            aout.writeStructuredField(ptx);
                                            afpCreateTag.createTagEPT(aout);
                                            afpCreateTag.createTagEPG(aout);
                                            totalCurentUsage -= (maxItemsLeft-numCharge+maxItemsRight);
                                            if((totalCurentUsage)%2==0){

                                                numsplit = (totalCurentUsage)/2;
                                                numRowCol1 = numsplit;
                                                numRowCol2 = numsplit;

                                            }else if((totalCurentUsage)%2==1){

                                                numsplit = (totalCurentUsage)/2;
                                                numRowCol1 = numsplit+1;
                                                numRowCol2 = numsplit;

                                            }
                                            countUsage1=0;
                                            countUsage2=0;
                                            //Next page
                                            afpCreateTag.createTagBPG(aout);
                                            SetGnValue.setGNofBAG(aout);


                                            afpCreateTag.createTagBPT(aout);
                                            ptx = AfplibFactory.eINSTANCE.createPTX(); 
                                            currentPage++;
                                            countPage++;
                                            afpCreateTag.setPTXxy(ptx,4522,342);
                                            afpCreateTag.setFontID(ptx,57);
                                            afpCreateTag.setPTX_TRN(ptx,"หน้า "+currentPage+" / "+exBan.get(countDoc).getMaxPage());

                                            afpCreateTag.setPTXxy(ptx,4275,342);
                                            afpCreateTag.setFontID(ptx,57);
                                            afpCreateTag.setPTX_TRN(ptx,"ส่วนที่  2");

                                            afpCreateTag.setPTXxy(ptx,2173,722);
                                            afpCreateTag.setFontID(ptx,60);
                                            afpCreateTag.setPTX_TRN(ptx,"รายละเอียดค่าใช้บริการ");

                                            afpCreateTag.setPTXxy(ptx,390,829);
                                            afpCreateTag.setFontID(ptx,58);
                                            afpCreateTag.setPTX_TRN(ptx,"คุณ ปวิตเตอร์กอร์ ชาณเจริญลาภ");

                                            afpCreateTag.setPTXxy(ptx,2100,829);
                                            afpCreateTag.setFontID(ptx,58);
                                            afpCreateTag.setPTX_TRN(ptx,"ประจำเดือน 08/2559");

                                            afpCreateTag.setPTXxy(ptx,2785,829);
                                            afpCreateTag.setFontID(ptx,58);
                                            afpCreateTag.setPTX_TRN(ptx,"เลขที่ : 6080645901078 (RES)");

                                            afpCreateTag.setPTXxy(ptx,3960,829);
                                            afpCreateTag.setFontID(ptx,58);
                                            afpCreateTag.setPTX_TRN(ptx,"รหัสลูกค้า : "+exBan.get(countDoc).getAccountNo());
                                            
                                            
                                            if(currentPage%2==1){
                                                    //OMR

                                                 

                                                    calOddbit=0;

                                                    //start bit
                                                    afpCreateTag.setPTXxy(ptx,120,517);
                                                    afpCreateTag.setDIR(ptx,150,7,0);
                                                    calOddbit++;

                                                    printBit=String.format("%5s", Integer.toBinaryString(((countDoc+1)%32))).replace(' ', '0');
                                                    //bit 1 start 877 inc 120 to 1357
                                                    for(int countOMRBit=4;countOMRBit>=0;countOMRBit--){
                                                            if(printBit.charAt(countOMRBit)=='1'){	
                                                                    afpCreateTag.setPTXxy(ptx,120,1357-(120*countOMRBit));
                                                                    afpCreateTag.setDIR(ptx,150,7,0);
                                                                    calOddbit++;
                                                            }
                                                    }
                                                    
                                                        
                                                    //stop bit
                                                    afpCreateTag.setPTXxy(ptx,120,2197);
                                                    afpCreateTag.setDIR(ptx,150,7,0);
                                                    calOddbit++;

                                                    if(calOddbit%2!=0){
                                                    //check odd bit
                                                    afpCreateTag.setPTXxy(ptx,120,757);
                                                    afpCreateTag.setDIR(ptx,150,7,0);
                                                    }

                                            }

                                            //box1
                                            int inc_point2=0;
                                            for(int i=0;i<2;i++){

                                                    afpCreateTag.setPTXxy(ptx,390+inc_point2,984);
                                                    afpCreateTag.setPTX_DrowBox(ptx,2147,237,2);

                                                    afpCreateTag.setPTXxy(ptx,805+inc_point2,984);
                                                    afpCreateTag.setPTX_DrowBox(ptx,292,237,2);

                                                    afpCreateTag.setPTXxy(ptx,1290+inc_point2,984);
                                                    afpCreateTag.setPTX_DrowBox(ptx,510,237,2);

                                                    afpCreateTag.setPTXxy(ptx,2010+inc_point2,984);
                                                    afpCreateTag.setPTX_DrowBox(ptx,257,237,2);

                                                    afpCreateTag.setPTXxy(ptx,1814+inc_point2,1121);
                                                    afpCreateTag.setFontID(ptx,78);
                                                    afpCreateTag.setPTX_TRN(ptx,"ประเภท");

                                                    afpCreateTag.setPTXxy(ptx,492+inc_point2,1121);
                                                    afpCreateTag.setFontID(ptx,78);
                                                    afpCreateTag.setPTX_TRN(ptx,"หมายเลข");

                                                    afpCreateTag.setPTXxy(ptx,837+inc_point2,1121);
                                                    afpCreateTag.setFontID(ptx,78);
                                                    afpCreateTag.setPTX_TRN(ptx,"วันเดือนปี");

                                                    afpCreateTag.setPTXxy(ptx,1133+inc_point2,1121);
                                                    afpCreateTag.setFontID(ptx,78);
                                                    afpCreateTag.setPTX_TRN(ptx,"เวลา");

                                                    afpCreateTag.setPTXxy(ptx,1337+inc_point2,1121);
                                                    afpCreateTag.setFontID(ptx,78);
                                                    afpCreateTag.setPTX_TRN(ptx,"เรียกไป/เรียกจาก");

                                                    afpCreateTag.setPTXxy(ptx,2029+inc_point2,1121);
                                                    afpCreateTag.setFontID(ptx,78);
                                                    afpCreateTag.setPTX_TRN(ptx,"ครั้ง/นาที");

                                                    afpCreateTag.setPTXxy(ptx,2276+inc_point2,1121);
                                                    afpCreateTag.setFontID(ptx,78);
                                                    afpCreateTag.setPTX_TRN(ptx,"จำนวนเงิน");

                                                    inc_point2=2190;
                                            }

                                            aout.writeStructuredField(ptx);
                                            afpCreateTag.createTagEPT(aout);
                                            //body
                                            afpCreateTag.createTagBPT(aout);
                                            ptx = AfplibFactory.eINSTANCE.createPTX(); 

                                            shiftDown=-210;
                                            numCharge=-2;
                                            maxItemsLeft=52;
                                            maxItemsRight=54;
                                        }
                                    
                                        //Writebody data
                                    
                                    
                                        if(numRowCol1>0&&countUsage1<maxItemsLeft-numCharge){//col1
                                            
                                            afpCreateTag.setFontID(ptx,58);
                                            f2_x=397;
                                            f2_y=1546+(countUsage1*105)+shiftDown;
                                            afpCreateTag.setPTXxy(ptx,f2_x,f2_y);				
                                            afpCreateTag.setPTX_TRN(ptx,usage.getDIALED_TN());

                                            
                                            f2_x=875;
                                            afpCreateTag.setPTXxy(ptx,f2_x,f2_y);				
                                            afpCreateTag.setPTX_TRN(ptx,ChangeDateEnglishToThai.YYYYMMDDHH24MISS2DDMMYYHH24MISS(usage.getCONNECT_DATE()));

                                            f2_x=1322;
                                            afpCreateTag.setPTXxy(ptx,f2_x,f2_y);				
                                            afpCreateTag.setPTX_TRN(ptx,usage.getDESTINATION_ON_BILL());

                                            f2_x=2021;
                                            afpCreateTag.setPTXxy(ptx,f2_x,f2_y);				
                                            afpCreateTag.setPTX_TRN(ptx,miniteToHHmmssFormat(Integer.valueOf(usage.getCALL_VOL_ROUNDED()==null?"0":usage.getCALL_VOL_ROUNDED())));

                                            f2_x=2401;
                                            afpCreateTag.setPTXxy(ptx,f2_x,f2_y);				
                                            //afpCreateTag.setPTX_TRN(ptx,String.format("%.2f", Double.valueOf(usage.getCHARGE_AMT())));
                                            SetGnValue.CalPointFont58Single(ptx, String.format("%,.2f", Double.valueOf(usage.getCHARGE_AMT().equals("null")?"0":usage.getCHARGE_AMT())), f2_x, f2_y);
                                            countUsage1++;
                                            numRowCol1--;

                                        }else if(countUsage2<maxItemsRight){//col2
                                            afpCreateTag.setFontID(ptx,58);
                                            f2_x=397+2190;
                                            f2_y=1314+(countUsage2*105)+shiftTitle;
                                            
                                            afpCreateTag.setPTXxy(ptx,f2_x,f2_y);				
                                            afpCreateTag.setPTX_TRN(ptx,usage.getDIALED_TN());

                                            f2_x=875+2190;
                                            afpCreateTag.setPTXxy(ptx,f2_x,f2_y);				
                                            afpCreateTag.setPTX_TRN(ptx,ChangeDateEnglishToThai.YYYYMMDDHH24MISS2DDMMYYHH24MISS(usage.getCONNECT_DATE()));
                                            
                                            f2_x=1322+2190;
                                            afpCreateTag.setPTXxy(ptx,f2_x,f2_y);				
                                            afpCreateTag.setPTX_TRN(ptx,usage.getDESTINATION_ON_BILL());

                                            f2_x=2021+2190;
                                            afpCreateTag.setPTXxy(ptx,f2_x,f2_y);				
                                            afpCreateTag.setPTX_TRN(ptx,String.format("0:%02d:00", Integer.valueOf(usage.getCALL_VOL_ROUNDED())));

                                            f2_x=2401+2190;
                                            afpCreateTag.setPTXxy(ptx,f2_x,f2_y);				
                                            //afpCreateTag.setPTX_TRN(ptx,String.format("%.2f", Double.valueOf(usage.getCHARGE_AMT())));
                                            SetGnValue.CalPointFont58Single(ptx, String.format("%,.2f", Double.valueOf(usage.getCHARGE_AMT().equals("null")?"0":usage.getCHARGE_AMT())), f2_x, f2_y);
                                            countUsage2++;
                                        }
                                        
                                        if(usageLoop==usageList.size()&&currentPage%2==1){
                                            
                                            //write emtry page
                                            afpCreateTag.createTagBPG(aout);
                                            SetGnValue.setGNofBAG(aout);
                                            afpCreateTag.createTagEPG(aout);
                                        
                                        
                                        }
                                        
                                        
                                }
                               
                        
                        }
                        aout.writeStructuredField(ptx);
                        afpCreateTag.createTagEPT(aout);
//			f2=new String[]{"0949938870","0949938870","0949938871","0949938871","0949938876"};
//			f2_x=397;
//			f2_y=2179;
//			afpCreateTag.setFontID(ptx,58);
//			for(int i=0;i<f2.length;i++){
//				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
//				afpCreateTag.setPTX_TRN(ptx,f2[i]);
//			}
//			
//			f2=new String[]{"22/07/59","22/07/59","22/07/59","22/07/59","22/07/59"};
//			f2_x=875;
//			f2_y=2179;
//			afpCreateTag.setFontID(ptx,58);
//			for(int i=0;i<f2.length;i++){
//				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
//				afpCreateTag.setPTX_TRN(ptx,f2[i]);
//			}
//			
//			f2=new String[]{"094941","094941","094941","094941","094941","094941","094941","094941","094941","094941","094941"};
//			f2_x=1110;
//			f2_y=2179;
//			afpCreateTag.setFontID(ptx,58);
//			for(int i=0;i<f2.length;i++){
//				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
//				afpCreateTag.setPTX_TRN(ptx,f2[i]);
//			}
//			
//			f2=new String[]{"Mobile in BKK. Area","Mobile in BKK. Area","MobileArea","Mobile in BKK. Area","Mobile in BKK. Area"};
//			f2_x=1322;
//			f2_y=2179;
//			afpCreateTag.setFontID(ptx,58);
//			for(int i=0;i<f2.length;i++){
//				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
//				afpCreateTag.setPTX_TRN(ptx,f2[i]);
//			}
//			
//			f2=new String[]{" 0:03:00"," 0:03:00"," 0:03:00"," 0:03:00"," 0:03:00"};
//			f2_x=2021;
//			f2_y=2179;
//			afpCreateTag.setFontID(ptx,58);
//			for(int i=0;i<f2.length;i++){
//				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
//				afpCreateTag.setPTX_TRN(ptx,f2[i]);
//			}
//			
//			f5=new String[]{"9.00","12.00","3.00","1.00","124.00"};
//			f5_x=2401;//start 0.00
//			f5_y=2179;
//			SetGnValue.CalPointFont58(ptx,f5,f5_x,f5_y);
//			
//			
//			///row 2
//			
//			
//			f2=new String[]{"0949938870","0949938870","0949938871","0949938871","0949938876"};
//			f2_x=397+2190;
//			f2_y=1314;
//			afpCreateTag.setFontID(ptx,58);
//			for(int i=0;i<f2.length;i++){
//				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
//				afpCreateTag.setPTX_TRN(ptx,f2[i]);
//			}
//			
//			f2=new String[]{"22/07/59","22/07/59","22/07/59","22/07/59","22/07/59"};
//			f2_x=875+2190;
//			f2_y=1314;
//			afpCreateTag.setFontID(ptx,58);
//			for(int i=0;i<f2.length;i++){
//				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
//				afpCreateTag.setPTX_TRN(ptx,f2[i]);
//			}
//			
//			f2=new String[]{"094941","094941","094941","094941","094941"};
//			f2_x=1110+2190;
//			f2_y=1314;
//			afpCreateTag.setFontID(ptx,58);
//			for(int i=0;i<f2.length;i++){
//				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
//				afpCreateTag.setPTX_TRN(ptx,f2[i]);
//			}
//			
//			f2=new String[]{"Mobile in BKK. Area","Mobile in BKK. Area","MobileArea","Mobile in BKK. Area","Mobile in BKK. Area"};
//			f2_x=1322+2190;
//			f2_y=1314;
//			afpCreateTag.setFontID(ptx,58);
//			for(int i=0;i<f2.length;i++){
//				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
//				afpCreateTag.setPTX_TRN(ptx,f2[i]);
//			}
//			
//			f2=new String[]{" 0:03:00"," 0:03:00"," 0:03:00"," 0:03:00"," 0:03:00"};
//			f2_x=2021+2190;
//			f2_y=1314;
//			afpCreateTag.setFontID(ptx,58);
//			for(int i=0;i<f2.length;i++){
//				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
//				afpCreateTag.setPTX_TRN(ptx,f2[i]);
//			}
//			
//			f5=new String[]{"9.00","12.00","3.00","1.00","124.00"};
//			f5_x=2401+2190;//start 0.00
//			f5_y=1314;
//			SetGnValue.CalPointFont58(ptx,f5,f5_x,f5_y);
			
//
//			aout.writeStructuredField(ptx);
//			afpCreateTag.createTagEPT(aout);
			afpCreateTag.createTagEPG(aout);
			
			
			//page3
			afpCreateTag.createTagBPG(aout);
			SetGnValue.setGNofBAG(aout);
			currentPage++;
                        countPage++;
			afpCreateTag.createTagIPS(aout,450,170,"S1NRCTR1");
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX();
			
			afpCreateTag.setPTXxy(ptx,1080,297);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"   บริษัท ทีโอที จำกัด (มหาชน) 89/2 หมู่ 3 ถนนแจ้งวัฒนะ แขวงทุ่งสองห้อง เขตหลักสี่ กรุงเทพมหานคร 10210");
			
			afpCreateTag.setPTXxy(ptx,1080,384);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"   เลขทะเบียนนิติบุคคล/เลขประจำตัวผู้เสียภาษี(Tax ID No.) 0107545000161 สำนักงานใหญ่");
			
			afpCreateTag.setPTXxy(ptx,3625,494);
			afpCreateTag.setFontID(ptx,79);
			afpCreateTag.setPTX_TRN(ptx,"ใบเสร็จรับเงิน / ใบกำกับภาษี");
			
			afpCreateTag.setPTXxy(ptx,445,494+45+22);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"รหัสลูกค้า : "+exBan.get(countDoc).getAccountNo());
			
			afpCreateTag.setPTXxy(ptx,1562,494+45+22);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"หมายเลขโทรศัพท์ : "+exBan.get(countDoc).getPhoneNumber());
			
			afpCreateTag.setPTXxy(ptx,3625,494+45+22+17);
			afpCreateTag.setFontID(ptx,79);
			afpCreateTag.setPTX_TRN(ptx,"Receipt/Tax Invoice");
			
			afpCreateTag.setPTXxy(ptx,445,570+85);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"เลขประจำตัวผู้เสียภาษีอากร :  "+exBan.get(countDoc).getAccountNo());
			
			afpCreateTag.setPTXxy(ptx,445,570+85+100);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"ชื่อ   : "+exBan.get(countDoc).getInputName());
			
			afpCreateTag.setPTXxy(ptx,445,570+85+100+100);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"ที่อยุ่ : ");
			
			List<String> addrs = new ArrayList<String>();
                        addrs.add(exBan.get(countDoc).getADDRESS_BILLING1());
                        addrs.add(exBan.get(countDoc).getADDRESS_BILLING2());
                        addrs.add(exBan.get(countDoc).getADDRESS_BILLING3());
                        addrs.add(exBan.get(countDoc).getADDRESS_BILLING4());
			f2_x=445+180;
			f2_y=570+85+100+100;
			afpCreateTag.setFontID(ptx,58);
                        int rowAddr=0;
			for(String addr : addrs){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(100*rowAddr));				
				afpCreateTag.setPTX_TRN(ptx,addr);
                                rowAddr++;
			}
			int shiftY=100;
			afpCreateTag.setPTXxy(ptx,3630,445+180+100+100);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"เลขที่ : "+exBan.get(countDoc).getInvoiceNo().split("\\(")[0]);
			
			afpCreateTag.setPTXxy(ptx,4250,445+180+100+100);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"วันที่ :  "+exBan.get(countDoc).getBillDate());
			
			afpCreateTag.setPTXxy(ptx,3630,445+180+100+100+100);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"สาขา : B034");
			
			afpCreateTag.setPTXxy(ptx,240+529,1092+85+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"เลขที่ใบแจ้งค่าบริการ");
			
			afpCreateTag.setPTXxy(ptx,445,1092+85+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"ลำดับที่");
			
			afpCreateTag.setPTXxy(ptx,1032+463,1092+85+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"ประจำเดือน");
			
			afpCreateTag.setPTXxy(ptx,1695+411,1092+85+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"มูลค่าสินค้าบริการ");
			
			afpCreateTag.setPTXxy(ptx,2252+538,1092+85+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"ส่วนลด");
			
			afpCreateTag.setPTXxy(ptx,2712+514,1092+85+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"มูลค่าสุทธิ");
			
			afpCreateTag.setPTXxy(ptx,3355+459,1092+85+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"ภาษีมูลค่าเพิ่ม");
			
			afpCreateTag.setPTXxy(ptx,4025+568,1092+85+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"รวม");
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX();
			
			afpCreateTag.setPTXxy(ptx,507,1198+97+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"1");
			
			afpCreateTag.setPTXxy(ptx,840,1198+97+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"2020632900430");
			
			afpCreateTag.setPTXxy(ptx,1580,1198+97+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"02/55");
			
			afpCreateTag.setPTXxy(ptx,1682+570,1198+97+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"460.50");
			
			afpCreateTag.setPTXxy(ptx,2202+601,1198+97+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"57.50");
			
			afpCreateTag.setPTXxy(ptx,2717+570,1198+97+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"403.00");
			
			afpCreateTag.setPTXxy(ptx,3422+601,1198+97+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"28.21");
			
			afpCreateTag.setPTXxy(ptx,3635+121,1198+97+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"  7%");
			
			afpCreateTag.setPTXxy(ptx,3975+570,1198+97+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"431.21");
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX();
			
			afpCreateTag.setPTXxy(ptx,540+568,1327+92+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"รวม");
			
			afpCreateTag.setPTXxy(ptx,1682+570,1327+92+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"460.50");
			
			afpCreateTag.setPTXxy(ptx,2202+601,1327+92+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"57.50");
			
			afpCreateTag.setPTXxy(ptx,2717+570,1327+92+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"403.00");
			
			afpCreateTag.setPTXxy(ptx,3422+601,1327+92+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"28.21");
			
			afpCreateTag.setPTXxy(ptx,3635+121,1327+92+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"  7%");
			
			afpCreateTag.setPTXxy(ptx,3975+570,1327+92+shiftY);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"431.21");
			
			afpCreateTag.setPTXxy(ptx,5+3798,1327+92+125+shiftY);
			afpCreateTag.setFontID(ptx,58);
			String thai_bath=new BathToText().getText("431.21");
			afpCreateTag.setPTX_TRN(ptx,"("+thai_bath+")");
			
			
		     
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX();
			
			f2=new String[]{"บริษัทฯ ได้ดำเนินการหักภาษี ณ.ที่จ่าย  และนำส่งสรรพากรแทนท่านแล้ว","อัตรา 3%","อัตรา 5%","รวม"};
			f2_x=445+180;
			f2_y=1327+92+125+100+shiftY;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(100*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			f2=new String[]{"บาท","บาท","บาท"};
			f2_x=445+180+800;
			f2_y=1327+92+125+200+shiftY;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(100*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX();
			
			afpCreateTag.setPTXxy(ptx,3232+706,1657+87+87+87+55);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"ผู้จัดการส่วนบัญชีที่ 2");
			
			afpCreateTag.setPTXxy(ptx,3545+522,1657+87+87+87+55+32+50);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"ผู้รับเงิน");
			
			afpCreateTag.setPTXxy(ptx,455,1657+87+87+87+55+32+50+37+67);
			afpCreateTag.setFontID(ptx,58);
                        
                        String bankNo="";
                        
                        if(exBan.get(countDoc).getCREDIT_CARD_NO()==null){
                                bankNo = "";
                                   
                        }else{
                                bankNo = exBan.get(countDoc).getCREDIT_CARD_NO().substring(exBan.get(countDoc).getCREDIT_CARD_NO().length()/2);
                            
                        }
                        
			afpCreateTag.setPTX_TRN(ptx,"ชื่อธนาคาร/บริษัท    "+exBan.get(countDoc).getBANK_NAME()+"   เลขที่บัญชี/บัตรเครดิต XXXXXX"+bankNo);
			

			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagIPS(aout,3840,1639,"S1SIGNTR");
			
			afpCreateTag.createTagBGR(aout);
			afpCreateTag.createTagBOG(aout);
			afpCreateTag.createTagOBD(aout,900);
			afpCreateTag.createTagOBP(aout,1,23,1327,11520,11520);
			afpCreateTag.createTagGDD(aout,1);
			afpCreateTag.createTagEOG(aout);
			afpCreateTag.createTagGAD(aout,1);
			afpCreateTag.createTagEGR(aout);
			
			afpCreateTag.setPTXxy(ptx,365,150);
			afpCreateTag.setPTX_DrowBox(ptx,4410,2061,2);
			
			//OMR
			
			afpCreateTag.createTagBPT(aout);
			aout.writeStructuredField(ptx);
			
			calOddbit=0;
			
			//start bit
			afpCreateTag.setPTXxy(ptx,120,517);
			afpCreateTag.setDIR(ptx,150,7,0);
			calOddbit++;
			
			printBit=String.format("%5s", Integer.toBinaryString((countDoc+1)%32)).replace(' ', '0');
			//bit 1 start 877 inc 120 to 1357
			for(int countOMRBit=4;countOMRBit>=0;countOMRBit--){
				if(printBit.charAt(countOMRBit)=='1'){	
					afpCreateTag.setPTXxy(ptx,120,1357-(120*countOMRBit));
					afpCreateTag.setDIR(ptx,150,7,0);
					calOddbit++;
				}
			}

			//stop page
			afpCreateTag.setPTXxy(ptx,120,1957);
			afpCreateTag.setDIR(ptx,150,7,0);
			calOddbit++;
			//stop bit
			afpCreateTag.setPTXxy(ptx,120,2197);
			afpCreateTag.setDIR(ptx,150,7,0);
			calOddbit++;
			
			if(calOddbit%2!=0){
			//check odd bit
			afpCreateTag.setPTXxy(ptx,120,757);
			afpCreateTag.setDIR(ptx,150,7,0);
			}
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			
			afpCreateTag.createTagEPG(aout);
			
			//write emtry page
			afpCreateTag.createTagBPG(aout);
			SetGnValue.setGNofBAG(aout);
			afpCreateTag.createTagEPG(aout);
			
                        
                        //Check new File
                        
                        if(countPage>limitPagePerFile){
                                numOfFiles++;
                                //Start Tailer
                                afpCreateTag.createTagEDT(aout);
                                //End Tailer
                                if(statusQa.equals("Y")){
                                    outputFile=PathOutputAFPRegular+"QA_Regular_Template"+String.format("%02d", numOfFiles)+".afp";
                                }else{
                                    outputFile=PathOutputAFPRegular+"Regular_Template"+String.format("%02d", numOfFiles)+".afp";
                                }
                                
                                aout = new AfpOutputStream(new FileOutputStream(outputFile));
                                //Start Header=============================================
                                afpCreateTag.createTagBDT(aout);
                                afpCreateTag.createTagIMM(aout,"F20101PA");
                                //End 
                                //=========================================================

                                 page_now=1;
                                 countPage=0;
                               
                            
                            
                        }
                        
		    }//for
			
			
			
			//Start Tailer
			afpCreateTag.createTagEDT(aout);
			//End Tailer
		} catch (IOException e) {
                        e.printStackTrace();
                }
		System.out.println("create success");
		long endTime = System.currentTimeMillis();
		
		long elapse = endTime - startTime;
		
		
		System.out.println("Time : " + elapse / 1000.0);
		
		try { conPRM.close(); } catch (Exception ignore) {}
                try { conBILL.close(); } catch (Exception ignore) {}
                System.out.println("END GenBillRegular");
	}

	
}
