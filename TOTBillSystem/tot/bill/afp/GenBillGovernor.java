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

import org.afplib.afplib.*;
import org.afplib.io.AfpOutputStream;

import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.model.LinePrint;
import tot.bill.model.SumChargeOnBill;
import tot.bill.model.WordPrint;
import tot.bill.resources.setEnv;
import tot.bill.service.ChangeDateEnglishToThai;
import tot.bill.service.CreatePathCMY;
import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.TAX_RATE;
import tot.bill.table.USAGE_XX;

public class GenBillGovernor {
    
        public static int pageNumX=4572;
        public static int pageNumY=142;
        public static int lastPageNum =0;
        public static int currPageNum =0;
        public static String goverName="กรม ประชาสัมพันธ์";
    
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


			
			int f2_x;
                        int f2_y;
			List<LinePrint> linePrints = new ArrayList<LinePrint>();
                        //Add data to LinePrintList
                        Map<String,Double> sumCateMap = new HashMap<String,Double>();
                        List<String> cateCodeList = new ArrayList<String>();
                        int countCharge=0;
                        for(int countDoc=0;countDoc<exBan.size();countDoc++){	
                                int rowCharge=0;
                                if(stChargeMap.containsKey(exBan.get(countDoc).getAccountID())){
                                        countCharge++;
                                        LinePrint line = new LinePrint();
                                        line.setFontId(79);
                                        line.setBlockHead(true);
                                        
                                        WordPrint word = new WordPrint();
                                        word.setText("    "+(countCharge)+". หมายเลข "+exBan.get(countDoc).getPhoneNumber());
                                        word.setPx(0);
                                        line.getWords().add(word);

                                        word = new WordPrint();
                                        word.setText("รหัสลูกค้า : "+exBan.get(countDoc).getAccountNo());
                                        word.setPx(1200);
                                        line.getWords().add(word);

                                        linePrints.add(line);

                                        LinePrint govGName = new LinePrint();
                                        govGName.setFontId(79);
                                        govGName.setBlock(true);
                                        word = new WordPrint();
                                        word.setPx(200);
                                        word.setText("กรม ประชาสัมพันธ์");
                                        govGName.getWords().add(word);
                                        linePrints.add(govGName);

                                        ArrayList<SumChargeOnBill> chargeList = stChargeMap.get(exBan.get(countDoc).getAccountID());

                                        double sumChargeAmt=0;
                                        for(SumChargeOnBill charge :chargeList){
                                                LinePrint lineCharge = new LinePrint();
                                                lineCharge.setFontId(58);
                                                lineCharge.setBlock(true);
                                                WordPrint word1 = new WordPrint();
                                                word1.setPx(0);
                                                word1.setText(featureMap.get(charge.getCATEGORY_CODE()));
                                                lineCharge.getWords().add(word1);

                                                
                                                
                                                
                                                
                                                double chargeAmt = Double.valueOf(charge.getSUM_SC_ACTV_AMT())-Double.valueOf(charge.getSUM_DC_ACTV_AMT());
                                                sumChargeAmt = sumChargeAmt + chargeAmt;
                                                
                                                if(sumCateMap.containsKey(charge.getCATEGORY_CODE())){
                                                    
                                                    double chargeAmtS = sumCateMap.get(charge.getCATEGORY_CODE());
                                                    
                                                    chargeAmtS+= chargeAmt;
                                                
                                                    sumCateMap.put(charge.getCATEGORY_CODE(), chargeAmtS);
                                                }else{
                                                    cateCodeList.add(charge.getCATEGORY_CODE());
                                                    sumCateMap.put(charge.getCATEGORY_CODE(), chargeAmt);
                                                
                                                }
                                                
                                                WordPrint word2 = new WordPrint();
                                                word2.setPx(1993);
                                                word2.setText(String.format("%,.2f", chargeAmt));
                                                word2.setIsPullRight(true);
                                                lineCharge.getWords().add(word2);

                                                linePrints.add(lineCharge);

                                        }

                                        LinePrint lineSum = new LinePrint();
                                        lineSum.setFontId(78);
                                        lineSum.setBlock(true);
                                        word = new WordPrint();
                                        word.setPx(800);
                                        word.setText("รวมก่อนภาษีมูลค่าเพิ่ม "+chargeList.get(0).getTAX()+"%");
                                        lineSum.getWords().add(word);

                                        word = new WordPrint();
                                        word.setPx(1993);
                                        word.setText(String.format("%,.2f", sumChargeAmt));
                                        word.setIsPullRight(true);
                                        lineSum.getWords().add(word);
                                        linePrints.add(lineSum);
                                        ////////////////////////////ภาษีมูลค่าเพิ่ม
                                        lineSum = new LinePrint();
                                        lineSum.setFontId(78);
                                        lineSum.setBlock(true);
                                        word = new WordPrint();
                                        word.setPx(800);
                                        word.setText("ภาษีมูลค่าเพิ่ม");
                                        lineSum.getWords().add(word);

                                        word = new WordPrint();
                                        word.setPx(1993);
                                        word.setText(String.format("%,.2f", sumChargeAmt*0.07));
                                        word.setIsPullRight(true);
                                        lineSum.getWords().add(word);
                                        linePrints.add(lineSum);
                                        //////////////////////////////รวมค่าใช้บริการรอบปัจจุบัน
                                        lineSum = new LinePrint();
                                        lineSum.setFontId(78);
                                        lineSum.setBlock(true);
                                        word = new WordPrint();
                                        word.setPx(800);
                                        word.setText("รวมค่าใช้บริการรอบปัจจุบัน");
                                        lineSum.getWords().add(word);

                                        word = new WordPrint();
                                        word.setPx(1993);
                                        word.setText(String.format("%,.2f", sumChargeAmt*1.07));
                                        word.setIsPullRight(true);
                                        lineSum.getWords().add(word);
                                        linePrints.add(lineSum);

                                }

                                //Add data to LinePrintList
                                if(stUsageMap.containsKey(exBan.get(countDoc).getAccountID())){

                                        ArrayList<USAGE_XX> usageList = stUsageMap.get(exBan.get(countDoc).getAccountID());
                                        WordPrint word;

                                        LinePrint titleLine = new LinePrint();
                                        titleLine.setFontId(78);

                                        word = new WordPrint();
                                        word.setPx(30);
                                        word.setText("รายละเอียดค่าใช้ทางไกล/เคลื่อนที่  "+exBan.get(countDoc).getPhoneNumber());
                                        titleLine.getWords().add(word);
                                        linePrints.add(titleLine);

                                        for(USAGE_XX usage:usageList){

                                                    LinePrint usageLine = new LinePrint();
                                                    usageLine.setFontId(58);

                                                    word = new WordPrint();
                                                    word.setPx(0);
                                                    word.setText(usage.getDIALED_TN());
                                                    usageLine.getWords().add(word);

                                                    word = new WordPrint();
                                                    word.setPx(478);
                                                    word.setText(ChangeDateEnglishToThai.YYYYMMDDHH24MISS2DDMMYYHH24MISS(usage.getCONNECT_DATE()));
                                                    usageLine.getWords().add(word);

                                                    word = new WordPrint();
                                                    word.setPx(925);
                                                    word.setText(usage.getDESTINATION_ON_BILL());
                                                    usageLine.getWords().add(word);

                                                    word = new WordPrint();
                                                    word.setPx(1624);
                                                    word.setIsPullRight(false);
                                                    word.setText(miniteToHHmmssFormat(Integer.valueOf(usage.getCALL_VOL_ROUNDED()==null?"0":usage.getCALL_VOL_ROUNDED())));
                                                    usageLine.getWords().add(word);

                                                    word = new WordPrint();
                                                    word.setPx(2004);
                                                    word.setText(String.format("%,.2f", Double.valueOf(usage.getCHARGE_AMT().equals("null")?"0":usage.getCHARGE_AMT())));
                                                    word.setIsPullRight(true);
                                                    usageLine.getWords().add(word);

                                                    linePrints.add(usageLine);

                                        }

                                }

                            }//for
                            LinePrint lineResult = new LinePrint();
                            lineResult.setFontId(79);
                            lineResult.setBlockHead(true);
                            WordPrint wordresult = new WordPrint();
                            wordresult.setText("รวมค่าบริการทั้งสิ้น");
                            wordresult.setPx(40);
                            lineResult.getWords().add(wordresult);

                            linePrints.add(lineResult);
                            /////////////////////////////////////////รวมจำนวน
                            LinePrint resultLine = new LinePrint();
                            resultLine.setFontId(58);
                            resultLine.setBlock(true);
                            
                            wordresult = new WordPrint();
                            wordresult.setPx(400);
                            wordresult.setText("รวม จำนวน     "+exBan.size()+" เลขหมาย");
                            resultLine.getWords().add(wordresult);

                            linePrints.add(resultLine);                
                            /////////////////////////////////////Charge List Result
                            double sumOfResult=0;
                            for(String cateCode :cateCodeList){
                                
                                double sumCateResult =  sumCateMap.get(cateCode);
                                String cateDesc      =  featureMap.get(cateCode);
                                
                                
                                resultLine = new LinePrint();
                                resultLine.setFontId(58);
                                resultLine.setBlock(true);
                                
                                wordresult = new WordPrint();
                                wordresult.setPx(400);
                                wordresult.setText("รวม "+cateDesc);
                                resultLine.getWords().add(wordresult);

                                wordresult = new WordPrint();
                                wordresult.setPx(2004);
                                wordresult.setText(String.format("%,.2f", sumCateResult));
                                wordresult.setIsPullRight(true);
                                resultLine.getWords().add(wordresult);

                                linePrints.add(resultLine);
                                
                                sumOfResult+=sumCateResult;
                            
                            }
                             LinePrint  lineSum = new LinePrint();
                                        lineSum.setFontId(78);
                                        lineSum.setBlock(true);
                             WordPrint  word = new WordPrint();
                                        word.setPx(800);
                                        word.setText("รวมก่อนภาษีมูลค่าเพิ่ม 7%");
                                        lineSum.getWords().add(word);

                                        word = new WordPrint();
                                        word.setPx(1993);
                                        word.setText(String.format("%,.2f", sumOfResult));
                                        word.setIsPullRight(true);
                                        lineSum.getWords().add(word);
                                        linePrints.add(lineSum);
                                        ////////////////////////////ภาษีมูลค่าเพิ่ม
                                        lineSum = new LinePrint();
                                        lineSum.setFontId(78);
                                        lineSum.setBlock(true);
                                        word = new WordPrint();
                                        word.setPx(800);
                                        word.setText("ภาษีมูลค่าเพิ่ม");
                                        lineSum.getWords().add(word);

                                        word = new WordPrint();
                                        word.setPx(1993);
                                        word.setText(String.format("%,.2f", sumOfResult*0.07));
                                        word.setIsPullRight(true);
                                        lineSum.getWords().add(word);
                                        linePrints.add(lineSum);
                                        //////////////////////////////รวมค่าใช้บริการรอบปัจจุบัน
                                        lineSum = new LinePrint();
                                        lineSum.setFontId(78);
                                        lineSum.setBlock(true);
                                        word = new WordPrint();
                                        word.setPx(800);
                                        word.setText("รวมค่าใช้บริการรอบปัจจุบัน");
                                        lineSum.getWords().add(word);

                                        word = new WordPrint();
                                        word.setPx(1993);
                                        word.setText(String.format("%,.2f", sumOfResult*1.07));
                                        word.setIsPullRight(true);
                                        lineSum.getWords().add(word);
                                        linePrints.add(lineSum);
                            
                        //Cal page number
                        
                       if(linePrints.size()%108>0){
                           lastPageNum =linePrints.size()/108 +1;
                       }else{
                            lastPageNum =linePrints.size()/108;
                       }
                       
                       //Cal Max file number
                       
                       int maxFileNumber =0;
                       int numForSplitFile = 1000; //Config number for new file when page more than
                       int lastFileLastPage=0;
                       maxFileNumber = lastPageNum/numForSplitFile;
                       lastFileLastPage = lastPageNum%numForSplitFile;
                       if(lastPageNum%numForSplitFile>0){
                       
                           maxFileNumber++;
                       }
                       
                       System.out.println("Start Gen Bill AFP");
                       //start gen bill process
                       String PathOutputAFPRegular=CreatePathCMY.byCMYString(setEnv.AFP_Governor_file_gen, CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR)+setEnv.folderAFP_Governor_file_gen;
                       System.out.println(PathOutputAFPRegular);
                       new File(PathOutputAFPRegular).mkdir();

                       String outputFile="";
                       for(int fileNum=1;fileNum<=maxFileNumber;fileNum++){
                           
                                lastPageNum =numForSplitFile;
                                currPageNum =0;
                           
                                if(fileNum==maxFileNumber){
                                    lastPageNum = lastFileLastPage;
                                }
                           
                                if(statusQa.equals("Y")){
                                         outputFile=PathOutputAFPRegular+"QA_Governor_Template"+String.format("%02d", fileNum)+".afp";
                                }else{
                                         outputFile=PathOutputAFPRegular+"Governor_Template"+String.format("%02d", fileNum)+".afp";
                                }

                                try (AfpOutputStream aout = new AfpOutputStream(new FileOutputStream(outputFile))) {

                                 //Start Header=============================================
                                 afpCreateTag.createTagBDT(aout);
                                 afpCreateTag.createTagIMM(aout,"F20101PA");
                                 //End 
                                 //=========================================================

                                 int page_now=1;

                                 //for(int countDoc=0;countDoc<exBan.size();countDoc++){	
                                 page_now=1;

                                 //Start Doc
         //                      afpCreateTag.createTagBPG(aout);
         //			SetGnValue.setGNofBAG(aout);	//TOT head banner		

                                 afpCreateTag.createTagBPT(aout);
                                 PTX ptx = AfplibFactory.eINSTANCE.createPTX(); 


                                 //aout.writeStructuredField(ptx);
                                 //Page 2 
                                 createNextInfoPage(aout,ptx);
                                 //body
                                 afpCreateTag.createTagBPT(aout);
                                 ptx = AfplibFactory.eINSTANCE.createPTX(); 
                                 ////////////////////////////////////Head banner
                                 afpCreateTag.createTagEPT(aout);

                                 afpCreateTag.createTagIPS(aout,355,212,"S1BLLTR1");

                                 afpCreateTag.createTagIPS(aout,3545,212,"S1SPACE1");

                                 afpCreateTag.createTagBPT(aout);
                                 ////////////////////////////////////////////
                                 aout.writeStructuredField(ptx);
                                 afpCreateTag.createTagEPT(aout);//Write

                             
                             //Cal sup lineList
                             int headList=0;
                             int tailList=0;
                             headList = (fileNum-1)*numForSplitFile*108;
                             tailList = fileNum*numForSplitFile*108;
                             
                             if(fileNum==maxFileNumber){
                             
                                 tailList = linePrints.size();
                             }


                             int countLine1=0;
                             int countLine2=0;
                             int numRowCol1=0;
                             int numRowCol2=0;
                             int numsplit  =0;
                             int lineSize  = linePrints.subList(headList, tailList).size();

                             if(lineSize%2==0){

                                 numsplit = lineSize/2;
                                 numRowCol1 = numsplit;
                                 numRowCol2 = numsplit;

                             }else if((lineSize)%2==1){

                                 numsplit = lineSize/2;
                                 numRowCol1 = numsplit+1;
                                 numRowCol2 = numsplit;

                             }
                             //Begin set AFP file
                             afpCreateTag.createTagBPT(aout);
                             ptx = AfplibFactory.eINSTANCE.createPTX(); 

                             int fx=0;
                             int fy=0;
                             int numLinePrinted=0;
                             int grayPx=0;
                             int grayPy=0;
                             boolean startBlocking=false;
                             
                            
                             
                             for(LinePrint line:linePrints.subList(headList, tailList)){



                                         if(countLine1>=54&&countLine2>=54){
                                             aout.writeStructuredField(ptx);
                                             afpCreateTag.createTagEPT(aout);
                                             afpCreateTag.createTagEPG(aout);
                                             int totalCurentUsage = lineSize-numLinePrinted;
                                             if((totalCurentUsage)%2==0){

                                                     numsplit = (totalCurentUsage)/2;
                                                     numRowCol1 = numsplit;
                                                     numRowCol2 = numsplit;

                                             }else if((totalCurentUsage)%2==1){

                                                     numsplit = (totalCurentUsage)/2;
                                                     numRowCol1 = numsplit+1;
                                                     numRowCol2 = numsplit;

                                             }
                                                     countLine1=0;
                                                     countLine2=0;
                                                     //Next page
                                                     createNextInfoPage(aout,ptx);

                                                     afpCreateTag.createTagBPT(aout);
                                                     ptx = AfplibFactory.eINSTANCE.createPTX();
                                         }
                                         if(!line.isBlock()){
                                             startBlocking=false;
                                         }

                                         if((numRowCol1>0||startBlocking)&&countLine1<54){//col1
                                             fx=397;
                                             fy=1336+(countLine1*105);       
                                             numRowCol1--;
                                             countLine1++;
                                         }else if(countLine2<54){//col2
                                             fx=397+2190;
                                             fy=1336+(countLine2*105); 
                                             countLine2++;
                                         }
                                         for(WordPrint wordPrint:line.getWords()){
                                                 afpCreateTag.setFontID(ptx,line.getFontId());
                                                 if(!wordPrint.isIsPullRight()){

                                                     afpCreateTag.setPTXxy(ptx,fx+wordPrint.getPx(),fy);				
                                                     afpCreateTag.setPTX_TRN(ptx,wordPrint.getText());

                                                 }else{

                                                     afpCreateTag.setPTXxy(ptx,fx+wordPrint.getPx(),fy);
                                                     SetGnValue.CalPointFont58Single(ptx, wordPrint.getText(), fx+wordPrint.getPx(), fy);

                                                 }

                                                 if(wordPrint.getText().equals("รวมค่าบริการทั้งสิ้น")){

                                                     grayPx = fx;
                                                     grayPy = fy;

                                                 }
                                         }

                                         if(line.isBlockHead()&&countLine2<=0){

                                             startBlocking=true;

                                         }


                                         numLinePrinted++;

                             }
                             //LastPage

                             aout.writeStructuredField(ptx);
                             afpCreateTag.createTagEPT(aout);


                             SetGnValue.setGovernorGrayArea(aout,grayPx,grayPy-75);

                                 afpCreateTag.createTagBPT(aout);
                                 ptx = AfplibFactory.eINSTANCE.createPTX();


                                 aout.writeStructuredField(ptx);
                                 afpCreateTag.createTagEPT(aout);

                             //tail page
                             afpCreateTag.createTagBPT(aout);
                             ptx = AfplibFactory.eINSTANCE.createPTX(); 

                             afpCreateTag.setPTXxy(ptx,355,4359);



                             afpCreateTag.createTagEPG(aout);

                             if(lastPageNum%2==1){
                                 //write emtry page
                                 afpCreateTag.createTagBPG(aout);
                                 SetGnValue.setGNofBAG(aout);
                                 afpCreateTag.createTagEPG(aout);
                             }

                             //Start Tailer
                             afpCreateTag.createTagEDT(aout);
                             //End Tailer
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                }               
		System.out.println("create success");
		long endTime = System.currentTimeMillis();
		
		long elapse = endTime - startTime;
		
		
		System.out.println("Time : " + elapse / 1000.0);
		
		try { conPRM.close(); } catch (Exception ignore) {}
                try { conBILL.close(); } catch (Exception ignore) {}
                System.out.println("END");
	}

	public static void createNextInfoPage(AfpOutputStream aout,PTX ptx) throws IOException{
                                            
                                            afpCreateTag.createTagBPG(aout);
                                            SetGnValue.setGNofBAG(aout);
                                            currPageNum++;

                                            afpCreateTag.createTagBPT(aout);
                                            ptx = AfplibFactory.eINSTANCE.createPTX(); 

                                            
                                            //OMR
                                            if(currPageNum%2==1){
                                                    int calOddbit=0;

                                                    //start bit
                                                    afpCreateTag.setPTXxy(ptx,120,517);
                                                    afpCreateTag.setDIR(ptx,150,7,0);
                                                    calOddbit++;

                                                    String printBit=String.format("%5s", Integer.toBinaryString(5)).replace(' ', '0');
                                                    //bit 1 start 877 inc 120 to 1357
                                                    for(int countOMRBit=4;countOMRBit>=0;countOMRBit--){
                                                            if(printBit.charAt(countOMRBit)=='1'){	
                                                                    afpCreateTag.setPTXxy(ptx,120,1357-(120*countOMRBit));
                                                                    afpCreateTag.setDIR(ptx,150,7,0);
                                                                    calOddbit++;
                                                            }
                                                    }
                                                    if(lastPageNum%2==0&&currPageNum==lastPageNum-1){
                                                         //stop page
                                                        afpCreateTag.setPTXxy(ptx,120,1957);
                                                        afpCreateTag.setDIR(ptx,150,7,0);
                                                        calOddbit++;
                                                    
                                                    }else if(lastPageNum%2==1&&currPageNum==lastPageNum){
                                                    
                                                         //stop page
                                                        afpCreateTag.setPTXxy(ptx,120,1957);
                                                        afpCreateTag.setDIR(ptx,150,7,0);
                                                        calOddbit++;
                                                    
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

                                                    aout.writeStructuredField(ptx);
                                                    //afpCreateTag.createTagEPT(aout);
                                                    //afpCreateTag.createTagEPG(aout);
                                                    //End OMR
                                            }
                                            
                                            afpCreateTag.setPTXxy(ptx,pageNumX,pageNumY);
                                            afpCreateTag.setFontID(ptx,57);
                                            afpCreateTag.setPTX_TRN(ptx,"หน้า "+String.format("%,d", currPageNum)+" / "+String.format("%,d", lastPageNum));
                                            //SetGnValue.CalPointFont58Single(ptx,"หน้า "+currPageNum+" / "+lastPageNum,pageNumX, pageNumY);
                                            
                                            
                                            afpCreateTag.setPTXxy(ptx,2173,722);
                                            afpCreateTag.setFontID(ptx,60);
                                            afpCreateTag.setPTX_TRN(ptx,"รายละเอียดค่าใช้บริการ");

                                            afpCreateTag.setPTXxy(ptx,390,829);
                                            afpCreateTag.setFontID(ptx,58);
                                            afpCreateTag.setPTX_TRN(ptx,goverName);

                                            afpCreateTag.setPTXxy(ptx,2100,829);
                                            afpCreateTag.setFontID(ptx,58);
                                            afpCreateTag.setPTX_TRN(ptx,"ประจำเดือน 08/2559");

                                            afpCreateTag.setPTXxy(ptx,2785,829);
                                            afpCreateTag.setFontID(ptx,58);
                                            afpCreateTag.setPTX_TRN(ptx,"เลขที่ : 6080645901078 (RES)");

                                            afpCreateTag.setPTXxy(ptx,3960,829);
                                            afpCreateTag.setFontID(ptx,58);
                                            afpCreateTag.setPTX_TRN(ptx,"รหัสกลุ่มลูกค้า : GV");

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
        
        
        
        
        }
        
        public static String miniteToHHmmssFormat(int minutes){
        
                int hh =0;
                int mm =0;
                String hhmmss="";
                hh=minutes/60;
                mm=minutes%60;
                
                hhmmss = String.format("%d:%02d:00",hh,mm);
                
        
                return hhmmss;
     }
}
