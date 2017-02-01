package tot.bill.process;

import java.io.BufferedWriter;
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

import tot.bill.afp.structFeature;
import tot.bill.dao.CHARGE_DB;
import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.model.SumCharge;
import tot.bill.model.SumChargeOnBill;
import tot.bill.resources.setEnv;
import tot.bill.service.CreatePathCMY;
import tot.bill.service.readCharge2mini;
import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.TAX_RATE;

public class ExtractCharge2File {

	public static void main(String[] args) throws IOException, SQLException {
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
        
        // get SumCharge  DBT  - CRD    
        ArrayList<SumCharge> stSumCharge_SC=new ArrayList<SumCharge>();    
        CHARGE_DB.selectSUM_CHARGE_SeviceCharge(conBILL, "in('DBT','CRD')", CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, stSumCharge_SC);
        
        // get SumCharge  DSC   
        ArrayList<SumCharge> stSumCharge_DC=new ArrayList<SumCharge>();    
        CHARGE_DB.selectSUM_CHARGE_SeviceCharge(conBILL, "='DSC'", CYCLE_CODE, CYCLE_MONTH, CYCLE_YEAR, stSumCharge_DC);
        
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

}
