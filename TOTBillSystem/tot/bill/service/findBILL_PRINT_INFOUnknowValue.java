package tot.bill.service;

import java.util.ArrayList;

import tot.bill.model.BILL_PRINT_INFOUnknowValue;
import tot.bill.model.CreateNameAddress4;
import tot.bill.table.ACCOUNT_LIST_XX;
import tot.bill.table.ACCOUNT_TYPE;
import tot.bill.table.BANK;
import tot.bill.table.BILL;
import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.NAME_ADDRESS_INFO;
import tot.bill.table.USAGE_S;

public class findBILL_PRINT_INFOUnknowValue {
	public static int findNAME_ADDRESS_INFO (BILL_PRINT_INFOUnknowValue BPIUnkonwValue,CYCLE_CONTROL stCYCLE_CONTROL,ArrayList<String> idNAME_ADDRESS_INFO, ArrayList<NAME_ADDRESS_INFO> stNAME_ADDRESS_INFO){
		int setStatus=-1;
		
		
		
		if( idNAME_ADDRESS_INFO.contains(BPIUnkonwValue.getACCOUNT_ID())==true ){
			//System.out.println("x"+BPIUnkonwValue.getACCOUNT_ID());
			int indexFirstNAME_ADDRESS_INFO=idNAME_ADDRESS_INFO.indexOf(BPIUnkonwValue.getACCOUNT_ID());
			int indexLastNAME_ADDRESS_INFO=idNAME_ADDRESS_INFO.lastIndexOf(BPIUnkonwValue.getACCOUNT_ID());
			for(int x=indexFirstNAME_ADDRESS_INFO;x<=indexLastNAME_ADDRESS_INFO;x++){	
				
				if(CheckEffExpDate.checkByStartEndDate(
						stNAME_ADDRESS_INFO.get(x).getEFFECTIVE_DATE(), 
						stNAME_ADDRESS_INFO.get(x).getEXPIRATION_DATE(), 
						stCYCLE_CONTROL.getCYCLE_START_DATE(), 
						stCYCLE_CONTROL.getCYCLE_END_DATE()
				   )){
					
					System.out.println("addzip="+BPIUnkonwValue.getACCOUNT_ID());
					BPIUnkonwValue.setZIP_CODE(stNAME_ADDRESS_INFO.get(x).getADR_ZIP());
					
					CreateNameAddress4 stNameAddress4=new CreateNameAddress4(null, null, null, null, null);
					
					CreateNameAddress4.addNameAddress(stNameAddress4, stNAME_ADDRESS_INFO.get(x));
					
					BPIUnkonwValue.setNAME(stNameAddress4.getNAME());
					BPIUnkonwValue.setNAME_R(stNameAddress4.getNAME());
					BPIUnkonwValue.setADDRESS1(stNameAddress4.getADDRESS1());
					BPIUnkonwValue.setADDRESS2(stNameAddress4.getADDRESS2());
					BPIUnkonwValue.setADDRESS3(stNameAddress4.getADDRESS3());
					BPIUnkonwValue.setADDRESS4(stNameAddress4.getADDRESS4());
					
					setStatus=0;
					break;
					
				}
			}
		}
		
		
		return setStatus;
		
	}
	public static int findNAME_ADDRESS_INFO_R (BILL_PRINT_INFOUnknowValue BPIUnkonwValue,CYCLE_CONTROL stCYCLE_CONTROL,ArrayList<String> idNAME_ADDRESS_INFO, ArrayList<NAME_ADDRESS_INFO> stNAME_ADDRESS_INFO){
		int setStatus=-1;
		
		
		
		if( idNAME_ADDRESS_INFO.contains(BPIUnkonwValue.getACCOUNT_ID())==true ){
			//System.out.println("x"+BPIUnkonwValue.getACCOUNT_ID());
			int indexFirstNAME_ADDRESS_INFO=idNAME_ADDRESS_INFO.indexOf(BPIUnkonwValue.getACCOUNT_ID());
			int indexLastNAME_ADDRESS_INFO=idNAME_ADDRESS_INFO.lastIndexOf(BPIUnkonwValue.getACCOUNT_ID());
			for(int x=indexFirstNAME_ADDRESS_INFO;x<=indexLastNAME_ADDRESS_INFO;x++){	
				
				if(CheckEffExpDate.checkByStartEndDate(
						stNAME_ADDRESS_INFO.get(x).getEFFECTIVE_DATE(), 
						stNAME_ADDRESS_INFO.get(x).getEXPIRATION_DATE(), 
						stCYCLE_CONTROL.getCYCLE_START_DATE(), 
						stCYCLE_CONTROL.getCYCLE_END_DATE()
				   )){
					
					System.out.println("addzip="+BPIUnkonwValue.getACCOUNT_ID());
					//BPIUnkonwValue.setZIP_CODE(stNAME_ADDRESS_INFO.get(x).getADR_ZIP());
					
					CreateNameAddress4 stNameAddress4=new CreateNameAddress4(null, null, null, null, null);
					
					CreateNameAddress4.addNameAddress(stNameAddress4, stNAME_ADDRESS_INFO.get(x));
					
					BPIUnkonwValue.setNAME_R(stNameAddress4.getNAME());
					BPIUnkonwValue.setADDRESS1_R(stNameAddress4.getADDRESS1());
					BPIUnkonwValue.setADDRESS2_R(stNameAddress4.getADDRESS2());
					BPIUnkonwValue.setADDRESS3_R(stNameAddress4.getADDRESS3());
					BPIUnkonwValue.setADDRESS4_R(stNameAddress4.getADDRESS4());
					
					setStatus=0;
					break;
					
				}
			}
		}
		
		
		return setStatus;
		
	}
	public static int findBANK(BILL_PRINT_INFOUnknowValue BPIUnkonwValue,ArrayList<String> idBANK, ArrayList<BANK> stBANK){
		int setStatus=-1;
		
		if( idBANK.contains(BPIUnkonwValue.getBANK_NO())==true ){
			int indexFirstNAME_ADDRESS_INFO=idBANK.indexOf(BPIUnkonwValue.getBANK_NO());
					BPIUnkonwValue.setBANK_NO(stBANK.get(indexFirstNAME_ADDRESS_INFO).getBANK_DESC());					
					setStatus=0;			
		}		
		return setStatus;
		
	}
	public static int findMAX_PAGE(BILL_PRINT_INFOUnknowValue BPIUnkonwValue,ArrayList<String> idUSAGE_S, ArrayList<USAGE_S> stUSAGE_S){
		
		
		if( idUSAGE_S.contains(BPIUnkonwValue.getACCOUNT_ID())==true ){
			int indexFirstUSAGE_S=idUSAGE_S.indexOf(BPIUnkonwValue.getACCOUNT_ID());
			BPIUnkonwValue.setMAX_PAGE(stUSAGE_S.get(indexFirstUSAGE_S).getCOUNT_RECORD());					
							
		}else{
			BPIUnkonwValue.setMAX_PAGE("2");	
		}
		return 0;
		
	}
	public static int findACCOUNT_LIST_XX(BILL_PRINT_INFOUnknowValue BPIUnkonwValue,ArrayList<String> idACCOUNT_LIST_XX, ArrayList<ACCOUNT_LIST_XX> stACCOUNT_LIST_XX){
		
		
		if( idACCOUNT_LIST_XX.contains(BPIUnkonwValue.getACCOUNT_ID())==true ){
			int indexFirstACCOUNT_LIST_XX=idACCOUNT_LIST_XX.indexOf(BPIUnkonwValue.getACCOUNT_ID());
			BPIUnkonwValue.setGOVERNMENT_CODE(stACCOUNT_LIST_XX.get(indexFirstACCOUNT_LIST_XX).getGOVERNMENT_CODE());
			BPIUnkonwValue.setSUB_GOV_CODE(stACCOUNT_LIST_XX.get(indexFirstACCOUNT_LIST_XX).getSUB_GOV_CODE());
			BPIUnkonwValue.setPRINT_CATEGORY(stACCOUNT_LIST_XX.get(indexFirstACCOUNT_LIST_XX).getPRINT_CATEGORY());
							
		}else{
			return -1;
		}
		return 0;
		
	}
	public static int findACCOUNT_TYPE(BILL_PRINT_INFOUnknowValue BPIUnkonwValue,String AccounTypeAndSub ,ArrayList<String> idACCOUNT_TYPE, ArrayList<ACCOUNT_TYPE> stACCOUNT_TYPE){
		
		
		if( idACCOUNT_TYPE.contains(AccounTypeAndSub)==true ){
			int indexFirstACCOUNT_TYPE=idACCOUNT_TYPE.indexOf(AccounTypeAndSub);
			String ACCOUNT_TYPE_DES=stACCOUNT_TYPE.get(indexFirstACCOUNT_TYPE).getDESCRIPTION();
			BPIUnkonwValue.setACCOUNT_TYPE_DES(ACCOUNT_TYPE_DES.substring(0,3));
							
		}else{
			return -1;
		}
		return 0;
		
	}
}
