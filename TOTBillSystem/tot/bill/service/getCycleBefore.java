package tot.bill.service;

import tot.bill.table.CYCLE_CONTROL;

public class getCycleBefore {
	public static int getCycleBefore(CYCLE_CONTROL stCYCLE_CONTROL){
		
		
		int cycleMonth=Integer.parseInt(stCYCLE_CONTROL.getCYCLE_MONTH());
		int cycleYear=Integer.parseInt(stCYCLE_CONTROL.getCYCLE_YEAR());
		
		if(cycleMonth==1){
			cycleMonth=12;
			cycleYear--;
		}else{
			cycleMonth--;
		}
		stCYCLE_CONTROL.setCYCLE_MONTH(String.valueOf(cycleMonth));
		stCYCLE_CONTROL.setCYCLE_YEAR(String.valueOf(cycleYear));
		
		return 0;		
	}
	
	

}
