package tot.bill.service;

import java.util.ArrayList;

import tot.bill.model.BillUnknowValue;
import tot.bill.table.ACCOUNT_LIST_XX;
import tot.bill.table.ACCOUNT_PYM_MTD;
import tot.bill.table.BILL;
import tot.bill.table.CHARGE;
import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.PAYMENT_ACTIVITY;

public class findBillUnknowValue {
	public static int findPREVIOUS_AMT (BillUnknowValue stBillUnknowValue,ArrayList<String> idBILL_Before, ArrayList<BILL> stBILL_Before,ACCOUNT_LIST_XX stACCOUNT_LIST_XX){
		int indexFirstBILL_Before=idBILL_Before.indexOf(stBillUnknowValue.getACCOUNT_ID());
		if(indexFirstBILL_Before>=0){
			stBillUnknowValue.setPREVIOUS_AMT(stBILL_Before.get(indexFirstBILL_Before).getOUTSTANDING_AMT());
			
			if(stACCOUNT_LIST_XX.getACCOUNT_STATUS().equals("N")){
				stBillUnknowValue.setBILL_TYPE("F");
			}else if(stBILL_Before.get(indexFirstBILL_Before).getBILL_TYPE().equals("F") ||
			   stBILL_Before.get(indexFirstBILL_Before).getBILL_TYPE().equals("V")				   
			  ){
				stBillUnknowValue.setBILL_TYPE("V");
			}else{
				stBillUnknowValue.setBILL_TYPE("R");
			}
		}else{
			stBillUnknowValue.setPREVIOUS_AMT(null);
			stBillUnknowValue.setBILL_TYPE("I");
		}
		return 0;
		
	}
	public static int findCHARGE(BillUnknowValue stBillUnknowValue,ArrayList<String> idCHARGE, ArrayList<CHARGE> stCHARGE){
		
		double CUR_CHARGE_AMT=0;
		double CUR_CREDIT_AMT=0;
		double CUR_DISCOUNT_AMT=0;
		double CUR_RC_AMT=0;
		double CUR_OC_AMT=0;
		double CUR_UC_AMT=0;
		
		double TOTAL_CHARGE_AMT=0;
		double TOTAL_TAX_AMT=0;
		
		double TOTAL_ADJUST_AMT=0;
		double TOTAL_ADJUST_TAX_AMT=0;
		
		double PREVIOUS_AMT=0;
		double PAYMENT_AMT=0;
		double OUTSTANDING_AMT=0;

		if( idCHARGE.contains(stBillUnknowValue.getACCOUNT_ID())==true ){
		
			int indexFirstCHARGE=idCHARGE.indexOf(stBillUnknowValue.getACCOUNT_ID());
			int indexLastCHARGE=idCHARGE.lastIndexOf(stBillUnknowValue.getACCOUNT_ID());
			stBillUnknowValue.setPRESENT_PRODUCT_NO(stCHARGE.get(indexFirstCHARGE).getPRODUCT_NO());
			for(int x=indexFirstCHARGE;x<=indexLastCHARGE;x++){
				if(stCHARGE.get(x).getIMMEDIATE_IND().equals("N")){
					
					if(stCHARGE.get(x).getCHARGE_TYPE().equals("DBT")){
						
						CUR_RC_AMT=CUR_RC_AMT+Double.parseDouble(stCHARGE.get(x).getACTV_AMT());
						TOTAL_CHARGE_AMT=TOTAL_CHARGE_AMT+Double.parseDouble(stCHARGE.get(x).getACTV_AMT());
						TOTAL_TAX_AMT=TOTAL_TAX_AMT+Double.parseDouble(stCHARGE.get(x).getTAX_AMT());
					}else if(stCHARGE.get(x).getCHARGE_TYPE().equals("CRD")){
						CUR_CREDIT_AMT=CUR_CREDIT_AMT+Double.parseDouble(stCHARGE.get(x).getACTV_AMT());
						TOTAL_CHARGE_AMT=TOTAL_CHARGE_AMT+Double.parseDouble(stCHARGE.get(x).getACTV_AMT());
						TOTAL_TAX_AMT=TOTAL_TAX_AMT+Double.parseDouble(stCHARGE.get(x).getTAX_AMT());
					}else if(stCHARGE.get(x).getCHARGE_TYPE().equals("DSC")){
						CUR_DISCOUNT_AMT=CUR_DISCOUNT_AMT+Double.parseDouble(stCHARGE.get(x).getACTV_AMT());
						TOTAL_CHARGE_AMT=TOTAL_CHARGE_AMT+Double.parseDouble(stCHARGE.get(x).getACTV_AMT());
						TOTAL_TAX_AMT=TOTAL_TAX_AMT+Double.parseDouble(stCHARGE.get(x).getTAX_AMT());
					}
					
					if(stCHARGE.get(x).getREVENUE_CODE().equals("R")){
						CUR_CHARGE_AMT=CUR_CHARGE_AMT+Double.parseDouble(stCHARGE.get(x).getACTV_AMT());
					}else if(stCHARGE.get(x).getREVENUE_CODE().equals("O")){
						CUR_OC_AMT=CUR_OC_AMT+Double.parseDouble(stCHARGE.get(x).getACTV_AMT());
					}else if(stCHARGE.get(x).getREVENUE_CODE().equals("U")){
						CUR_UC_AMT=CUR_UC_AMT+Double.parseDouble(stCHARGE.get(x).getACTV_AMT());
					}
					
				}else if(stCHARGE.get(x).getIMMEDIATE_IND().equals("Y")){
					TOTAL_ADJUST_AMT=TOTAL_ADJUST_AMT+Double.parseDouble(stCHARGE.get(x).getACTV_AMT());
					TOTAL_ADJUST_TAX_AMT=TOTAL_ADJUST_TAX_AMT+Double.parseDouble(stCHARGE.get(x).getTAX_AMT());
					
				}
				
			}//for
			
			
		}
		
		stBillUnknowValue.setCUR_CHARGE_AMT(Double.toString(CUR_CHARGE_AMT));
		stBillUnknowValue.setCUR_CREDIT_AMT(Double.toString(CUR_CREDIT_AMT));
		stBillUnknowValue.setCUR_DISCOUNT_AMT(Double.toString(CUR_DISCOUNT_AMT));
		stBillUnknowValue.setCUR_RC_AMT(Double.toString(CUR_RC_AMT));
		stBillUnknowValue.setCUR_OC_AMT(Double.toString(CUR_OC_AMT));
		stBillUnknowValue.setCUR_UC_AMT(Double.toString(CUR_UC_AMT));
		
		stBillUnknowValue.setTOTAL_CHARGE_AMT(Double.toString(TOTAL_CHARGE_AMT));
		stBillUnknowValue.setTOTAL_TAX_AMT(Double.toString(TOTAL_TAX_AMT));
		stBillUnknowValue.setTOTAL_NET_AMT(Double.toString(TOTAL_CHARGE_AMT+TOTAL_TAX_AMT));
		
		stBillUnknowValue.setTOTAL_ADJUST_AMT(Double.toString(TOTAL_ADJUST_AMT));
		stBillUnknowValue.setTOTAL_ADJUST_TAX_AMT(Double.toString(TOTAL_ADJUST_TAX_AMT));
		stBillUnknowValue.setTOTAL_ADJUST_NET_AMT(Double.toString(TOTAL_ADJUST_AMT+TOTAL_ADJUST_TAX_AMT));
		//System.out.println(stBillUnknowValue.getPREVIOUS_AMT());
		if(stBillUnknowValue.getPREVIOUS_AMT()==null){
			PREVIOUS_AMT=0;
		}else{
			PREVIOUS_AMT=Double.parseDouble(stBillUnknowValue.getPREVIOUS_AMT());
		}
		PAYMENT_AMT=Double.parseDouble(stBillUnknowValue.getPAYMENT_AMT());
		OUTSTANDING_AMT=PREVIOUS_AMT-PAYMENT_AMT+(TOTAL_CHARGE_AMT+TOTAL_TAX_AMT)+(TOTAL_ADJUST_AMT+TOTAL_ADJUST_TAX_AMT);
		
		stBillUnknowValue.setOUTSTANDING_AMT(Double.toString(OUTSTANDING_AMT));
		
		return 0;
		
	}
	public static int findACCOUNT_PYM_MTD (BillUnknowValue stBillUnknowValue,CYCLE_CONTROL stCYCLE_CONTROL,ArrayList<String> idACCOUNT_PYM_MTD, ArrayList<ACCOUNT_PYM_MTD> stACCOUNT_PYM_MTD){
		
		if( idACCOUNT_PYM_MTD.contains(stBillUnknowValue.getACCOUNT_ID())==true ){
			int indexFirstACCOUNT_PYM_MTD=idACCOUNT_PYM_MTD.indexOf(stBillUnknowValue.getACCOUNT_ID());
			int indexLastACCOUNT_PYM_MTD=idACCOUNT_PYM_MTD.lastIndexOf(stBillUnknowValue.getACCOUNT_ID());
			for(int i=indexFirstACCOUNT_PYM_MTD;i<=indexLastACCOUNT_PYM_MTD;i++){
				if(CheckEffExpDate.checkByStartEndDate(
						stACCOUNT_PYM_MTD.get(i).getEFFECTIVE_DATE(), 
						stACCOUNT_PYM_MTD.get(i).getEXPIRATION_DATE(), 
						stCYCLE_CONTROL.getCYCLE_START_DATE(), 
						stCYCLE_CONTROL.getCYCLE_END_DATE()
				   )){
					stBillUnknowValue.setPYM_MTD(stACCOUNT_PYM_MTD.get(i).getPYM_MTD());
					stBillUnknowValue.setBANK_CODE(stACCOUNT_PYM_MTD.get(i).getBANK_CODE());
					stBillUnknowValue.setBANK_ACCOUNT_NO(stACCOUNT_PYM_MTD.get(i).getDD_BANK_CR_CARD_NO());
					break;
					
				}
				
			}
		}
		
		
		return 0;
		
	}
	public static int findDUE_DATE (BillUnknowValue stBillUnknowValue,CYCLE_CONTROL stCYCLE_CONTROL){
		//System.out.println(stBillUnknowValue.getPYM_MTD());
		if(stBillUnknowValue.getPYM_MTD()==null){
			
		}else if(stBillUnknowValue.getPYM_MTD().equals("DD")){
			stBillUnknowValue.setDUE_DATE(stCYCLE_CONTROL.getDD_DUE_DATE());
		}else{
			stBillUnknowValue.setDUE_DATE(stCYCLE_CONTROL.getCYCLE_DUE_DATE());
		}
		
		return 0;
		
	}
	
	public static int findPAYMENT_ACTIVITY(BillUnknowValue stBillUnknowValue,CYCLE_CONTROL stCYCLE_CONTROL,ArrayList<String> idPAYMENT_ACTIVITY, ArrayList<PAYMENT_ACTIVITY> stPAYMENT_ACTIVITY){
		
		double PAYMENT_AMT=0;
		
		if( idPAYMENT_ACTIVITY.contains(stBillUnknowValue.getACCOUNT_ID())==true ){
			int indexFirstPAYMENT_ACTIVITY=idPAYMENT_ACTIVITY.indexOf(stBillUnknowValue.getACCOUNT_ID());
			int indexLastPAYMENT_ACTIVITY=idPAYMENT_ACTIVITY.lastIndexOf(stBillUnknowValue.getACCOUNT_ID());
			for(int i=indexFirstPAYMENT_ACTIVITY;i<=indexLastPAYMENT_ACTIVITY;i++){
				if(CheckEffExpDate.checkByBetweenDate(						
						stCYCLE_CONTROL.getCYCLE_START_DATE(), 
						stCYCLE_CONTROL.getCYCLE_END_DATE(),
						stPAYMENT_ACTIVITY.get(i).getACTV_DATE()
				   )){
					PAYMENT_AMT=PAYMENT_AMT+Double.parseDouble(stPAYMENT_ACTIVITY.get(i).getACTV_AMT());
				}
				
			}
		}
		
		stBillUnknowValue.setPAYMENT_AMT(Double.toString(PAYMENT_AMT));
		return 0;
		
	}

}
