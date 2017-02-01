package tot.bill.service;
import java.util.ArrayList;

import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.RC_RATE;


public class getRCRate {
	public static double getRCRateDouble(String pricePlan,String featureCode,ArrayList<String> idRC_RATE,ArrayList<RC_RATE> stRC_RATE,ArrayList<CYCLE_CONTROL> stCYCLE_CONTROL){
		
		if(idRC_RATE.contains(pricePlan)){
			
			for(int i=idRC_RATE.indexOf(pricePlan);i<=idRC_RATE.lastIndexOf(pricePlan);i++){
				
				
				if(featureCode.equals(stRC_RATE.get(i).getFEATURE_CODE()) &&  
					CheckEffExpDate.checkByStartEndDate(stRC_RATE.get(i).getEFFECTIVE_DATE()
					,stRC_RATE.get(i).getEXPIRATION_DATE(),stCYCLE_CONTROL.get(0).getCYCLE_START_DATE(),
					stCYCLE_CONTROL.get(0).getCYCLE_END_DATE()) 
					){									
					
					return stRC_RATE.get(i).getRATE();					
				}	
			}
		}
				
		return -1;
	}

}
