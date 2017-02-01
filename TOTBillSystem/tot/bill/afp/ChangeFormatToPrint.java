package tot.bill.afp;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChangeFormatToPrint {
	public static int formatWithComma(String[] inputArray){
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
    	decimalFormatSymbols.setDecimalSeparator('.');
    	decimalFormatSymbols.setGroupingSeparator(',');
    	DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", decimalFormatSymbols);
    	String changeFormatVal="";
    	
    	for(int i=0;i<inputArray.length;i++){
    		//System.out.print(inputArray[i]+"=>");
    		changeFormatVal=decimalFormat.format(Double.parseDouble(inputArray[i]));
    		inputArray[i]=changeFormatVal;
    		//System.out.println(inputArray[i]);
    	}
		
		return 0;
	}
}
