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

import org.afplib.afplib.*;
import org.afplib.io.AfpOutputStream;

import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.model.SumChargeOnBill;
import tot.bill.resources.setEnv;
import tot.bill.service.CreatePathCMY;
import tot.bill.table.CYCLE_CONTROL;

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
		    	
		    	
		    }
		}finally {
		    inputFile.close();
		}

		System.out.println("Start Gen Bill AFP");
		//start gen bill process
		String PathOutputAFPRegular=CreatePathCMY.byCMYString(setEnv.AFP_Regular_file_gen, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)+setEnv.folderAFP_Regular_file_gen;
		System.out.println(PathOutputAFPRegular);
		new File(PathOutputAFPRegular).mkdir();
		String outputFile="";
		if(statusQa.equals("Y")){
			outputFile=PathOutputAFPRegular+"QA_Regular_Template01.afp";
		}else{
			outputFile=PathOutputAFPRegular+"Regular_Template01.afp";
		}
		try (AfpOutputStream aout = new AfpOutputStream(new FileOutputStream(outputFile))) {
			
			
			
			//Start Header=============================================
			afpCreateTag.createTagBDT(aout);
			afpCreateTag.createTagIMM(aout,"F20101PA");
			//End Header
			//=========================================================
			
			int page_now=1;
			for(int countDoc=0;countDoc<exBan.size();countDoc++){
				
			page_now=1;
			
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
			afpCreateTag.setPTX_TRN(ptx,AFPConfig.get(13)+page_now+" / "+exBan.get(countDoc).getMaxPage());
			
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
					cardNo="XXXXXXXX"+cardNo.substring(8, cardNo.length());
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
			
			String printBit=String.format("%5s", Integer.toBinaryString(3)).replace(' ', '0');
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
			//End Doc
			
			
			//Page 2 
			afpCreateTag.createTagBPG(aout);
			SetGnValue.setGNofBAG(aout);
			
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX(); 
			
			afpCreateTag.setPTXxy(ptx,4522,342);
			afpCreateTag.setFontID(ptx,57);
			afpCreateTag.setPTX_TRN(ptx,"หน้า 1 / 8");
			
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
			afpCreateTag.setPTX_TRN(ptx,"รหัสลูกค้า : 17-00251-11117");
			
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
			//body
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX(); 
			
			afpCreateTag.setPTXxy(ptx,360,1329);
			afpCreateTag.setFontID(ptx,79);
			afpCreateTag.setPTX_TRN(ptx,"    1. หมายเลข 0-2711-2726");
			
			f2=new String[]{"ค่าเช่าเลขหมาย","ค่าใช่โทรศัพท์","ค่าใช้ทางไกล/เคลื่อนที่","ส่วนลดค่าใช้","ส่วนลดค่าทางไกล"};
			f2_x=420;
			f2_y=1440;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(106*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			f5=new String[]{"100.00","12.00","1,641.00","-1.45","-198.55"};
			f5_x=2413;//start 0.00
			f5_y=1440;
			SetGnValue.CalPointFont58(ptx,f5,f5_x,f5_y);
			
			afpCreateTag.setPTXxy(ptx,420,2073);
			afpCreateTag.setFontID(ptx,78);
			afpCreateTag.setPTX_TRN(ptx,"รายละเอียดค่าใช้ทางไกล/เคลื่อนที่  0-2711-2726");
			
			f2=new String[]{"0949938870","0949938870","0949938871","0949938871","0949938876"};
			f2_x=397;
			f2_y=2179;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			f2=new String[]{"22/07/59","22/07/59","22/07/59","22/07/59","22/07/59"};
			f2_x=875;
			f2_y=2179;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			f2=new String[]{"094941","094941","094941","094941","094941"};
			f2_x=1110;
			f2_y=2179;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			f2=new String[]{"Mobile in BKK. Area","Mobile in BKK. Area","MobileArea","Mobile in BKK. Area","Mobile in BKK. Area"};
			f2_x=1322;
			f2_y=2179;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			f2=new String[]{" 0:03:00"," 0:03:00"," 0:03:00"," 0:03:00"," 0:03:00"};
			f2_x=2021;
			f2_y=2179;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			f5=new String[]{"9.00","12.00","3.00","1.00","124.00"};
			f5_x=2401;//start 0.00
			f5_y=2179;
			SetGnValue.CalPointFont58(ptx,f5,f5_x,f5_y);
			
			
			///row 2
			
			
			f2=new String[]{"0949938870","0949938870","0949938871","0949938871","0949938876"};
			f2_x=397+2190;
			f2_y=1314;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			f2=new String[]{"22/07/59","22/07/59","22/07/59","22/07/59","22/07/59"};
			f2_x=875+2190;
			f2_y=1314;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			f2=new String[]{"094941","094941","094941","094941","094941"};
			f2_x=1110+2190;
			f2_y=1314;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			f2=new String[]{"Mobile in BKK. Area","Mobile in BKK. Area","MobileArea","Mobile in BKK. Area","Mobile in BKK. Area"};
			f2_x=1322+2190;
			f2_y=1314;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			f2=new String[]{" 0:03:00"," 0:03:00"," 0:03:00"," 0:03:00"," 0:03:00"};
			f2_x=2021+2190;
			f2_y=1314;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(105*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			f5=new String[]{"9.00","12.00","3.00","1.00","124.00"};
			f5_x=2401+2190;//start 0.00
			f5_y=1314;
			SetGnValue.CalPointFont58(ptx,f5,f5_x,f5_y);
			

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
			
			afpCreateTag.createTagEPG(aout);
			
			
			//page3
			afpCreateTag.createTagBPG(aout);
			SetGnValue.setGNofBAG(aout);
			
			afpCreateTag.createTagIPS(aout,450,170,"S1NRCTR1");
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX();
			
			afpCreateTag.setPTXxy(ptx,1080,297);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"   �?ริษัท ที�?อที �?ำ�?ัด (มหา�?�?) 89/2 หมู�? 3 ถ�?�?�?�?�?�?วัฒ�?ะ �?�?ว�?ทุ�?�?สอ�?ห�?อ�? เ�?ตทุ�?�?สอ�?ห�?อ�? �?รุ�?เท�?มหา�?�?ร 10210");
			
			afpCreateTag.setPTXxy(ptx,1080,384);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"   เล�?ทะเ�?ีย�?�?ิติ�?ุ�?�?ล/เล�?�?ระ�?ำตัว�?ู�?เสียภาษี(Tax ID No.) 0107545000161 สำ�?ั�?�?า�?�?ห�?�?");
			
			afpCreateTag.setPTXxy(ptx,3625,494);
			afpCreateTag.setFontID(ptx,79);
			afpCreateTag.setPTX_TRN(ptx,"�?�?เสร�?�?รั�?เ�?ิ�? / �?�?�?ำ�?ั�?ภาษี");
			
			afpCreateTag.setPTXxy(ptx,445,494+45+22);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"รหัสลู�?�?�?า :  12-00070-06912");
			
			afpCreateTag.setPTXxy(ptx,1562,494+45+22);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"หมายเล�?�?ทรศั�?ท�? : 0-2965-1821");
			
			afpCreateTag.setPTXxy(ptx,3625,494+45+22+17);
			afpCreateTag.setFontID(ptx,79);
			afpCreateTag.setPTX_TRN(ptx,"Receipt/Tax Invoice");
			
			afpCreateTag.setPTXxy(ptx,445,570+85);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"เล�?�?ระ�?ำตัว�?ู�?เสียภาษีอา�?ร :  1200070069129");
			
			afpCreateTag.setPTXxy(ptx,445,570+85+100);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"�?ื�?อ   :");
			
			afpCreateTag.setPTXxy(ptx,445,570+85+100+100);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"ที�?อยู�? :");
			
			f2=new String[]{"�?าย ทดสอ�? 242799590","123/29 หมู�? หมู�?ที�?6 �?อย สวัสดิ�?�?ิ�?  ถ�?�? �?รุ�?เท�?-�?�?ท�?ุรี1","�?�?ว�?/ตำ�?ล �?า�?เ�?�? เ�?ต/อำเภอ เมือ�?�?�?ท�?ุรี","�?�?ท�?ุรี 11000"};
			f2_x=445+180;
			f2_y=570+85+100;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(100*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			afpCreateTag.setPTXxy(ptx,3630,445+180+100+100);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"เล�?ที�? : 123274227");
			
			afpCreateTag.setPTXxy(ptx,4250,445+180+100+100);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"วั�?ที�? :  08/03/2555");
			
			afpCreateTag.setPTXxy(ptx,3630,445+180+100+100+100);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"สา�?า : B034");
			
			afpCreateTag.setPTXxy(ptx,240+529,1092+85);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"เล�?ที�?�?�?�?�?�?�?�?�?า�?ริ�?าร");
			
			afpCreateTag.setPTXxy(ptx,445,1092+85);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"ลำดั�?ที�?");
			
			afpCreateTag.setPTXxy(ptx,1032+463,1092+85);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"�?ระ�?ำเดือ�?");
			
			afpCreateTag.setPTXxy(ptx,1695+411,1092+85);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"มูล�?�?าสิ�?�?�?า�?ริ�?าร");
			
			afpCreateTag.setPTXxy(ptx,2252+538,1092+85);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"ส�?ว�?ลด");
			
			afpCreateTag.setPTXxy(ptx,2712+514,1092+85);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"มูล�?�?าสุท�?ิ");
			
			afpCreateTag.setPTXxy(ptx,3355+459,1092+85);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"ภาษีมูล�?�?าเ�?ิ�?ม");
			
			afpCreateTag.setPTXxy(ptx,4025+568,1092+85);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"รวม");
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX();
			
			afpCreateTag.setPTXxy(ptx,507,1198+97);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"1");
			
			afpCreateTag.setPTXxy(ptx,840,1198+97);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"2020632900430");
			
			afpCreateTag.setPTXxy(ptx,1580,1198+97);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"02/55");
			
			afpCreateTag.setPTXxy(ptx,1682+570,1198+97);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"460.50");
			
			afpCreateTag.setPTXxy(ptx,2202+601,1198+97);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"57.50");
			
			afpCreateTag.setPTXxy(ptx,2717+570,1198+97);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"403.00");
			
			afpCreateTag.setPTXxy(ptx,3422+601,1198+97);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"28.21");
			
			afpCreateTag.setPTXxy(ptx,3635+121,1198+97);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"  7%");
			
			afpCreateTag.setPTXxy(ptx,3975+570,1198+97);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"431.21");
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX();
			
			afpCreateTag.setPTXxy(ptx,540+568,1327+92);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"รวม");
			
			afpCreateTag.setPTXxy(ptx,1682+570,1327+92);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"460.50");
			
			afpCreateTag.setPTXxy(ptx,2202+601,1327+92);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"57.50");
			
			afpCreateTag.setPTXxy(ptx,2717+570,1327+92);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"403.00");
			
			afpCreateTag.setPTXxy(ptx,3422+601,1327+92);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"28.21");
			
			afpCreateTag.setPTXxy(ptx,3635+121,1327+92);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"  7%");
			
			afpCreateTag.setPTXxy(ptx,3975+570,1327+92);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"431.21");
			
			afpCreateTag.setPTXxy(ptx,5+3798,1327+92+125);
			afpCreateTag.setFontID(ptx,58);
			String thai_bath=new BathToText().getText("431.21");
			afpCreateTag.setPTX_TRN(ptx,"("+thai_bath+")");
			
			
		     
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			afpCreateTag.createTagBPT(aout);
			ptx = AfplibFactory.eINSTANCE.createPTX();
			
			f2=new String[]{"�?ริษัทฯ �?ด�?ดำเ�?ิ�?�?ารหั�?ภาษี ณ.ที�?�?�?าย  �?ละ�?ำส�?�?สรร�?า�?ร�?ท�?ท�?า�?�?ล�?ว","อัตรา 3%","อัตรา 5%","รวม"};
			f2_x=445+180;
			f2_y=1327+92+125+100;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f2.length;i++){
				afpCreateTag.setPTXxy(ptx,f2_x,f2_y+(100*i));				
				afpCreateTag.setPTX_TRN(ptx,f2[i]);
			}
			
			f2=new String[]{"�?าท","�?าท","�?าท"};
			f2_x=445+180+800;
			f2_y=1327+92+125+200;
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
			afpCreateTag.setPTX_TRN(ptx,"�?ู�?�?ัด�?ารส�?ว�?�?ั�?�?ีที�? 2");
			
			afpCreateTag.setPTXxy(ptx,3545+522,1657+87+87+87+55+32+50);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"�?ู�?รั�?เ�?ิ�?");
			
			afpCreateTag.setPTXxy(ptx,455,1657+87+87+87+55+32+50+37+67);
			afpCreateTag.setFontID(ptx,58);
			afpCreateTag.setPTX_TRN(ptx,"�?ื�?อ�?�?า�?าร/�?ริษัท   �?.�?.ส.   เล�?ที�?�?ั�?�?ี/�?ัตรเ�?รดิต");
			

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
			
			printBit=String.format("%5s", Integer.toBinaryString(3)).replace(' ', '0');
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
	    System.out.println("END");
	}

	
}
