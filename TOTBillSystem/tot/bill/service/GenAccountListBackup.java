package tot.bill.service;


import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import tot.bill.table.ACCOUNT_LIST_XX;

public class GenAccountListBackup {
	public static int backUpToFile (String tableName,ArrayList<ACCOUNT_LIST_XX> stACCOUNT_LIST_XX,Writer BackUpFile) throws IOException{
		String strSQL="";
		for(int i=0;i<stACCOUNT_LIST_XX.size();i++){
			if(stACCOUNT_LIST_XX.get(i).getACCOUNT_ID()==null)stACCOUNT_LIST_XX.get(i).setACCOUNT_ID("");
	    	if(stACCOUNT_LIST_XX.get(i).getSYS_CREATION_DATE()==null)stACCOUNT_LIST_XX.get(i).setSYS_CREATION_DATE("");
	    	if(stACCOUNT_LIST_XX.get(i).getSYS_UPDATE_DATE()==null)stACCOUNT_LIST_XX.get(i).setSYS_UPDATE_DATE("");
	    	if(stACCOUNT_LIST_XX.get(i).getACCOUNT_TYPE()==null)stACCOUNT_LIST_XX.get(i).setACCOUNT_TYPE("");
	    	if(stACCOUNT_LIST_XX.get(i).getACCOUNT_SUB_TYPE()==null)stACCOUNT_LIST_XX.get(i).setACCOUNT_SUB_TYPE("");
	    	if(stACCOUNT_LIST_XX.get(i).getAR_BALANCE()==null)stACCOUNT_LIST_XX.get(i).setAR_BALANCE("");
	    	if(stACCOUNT_LIST_XX.get(i).getACCOUNT_STATUS()==null)stACCOUNT_LIST_XX.get(i).setACCOUNT_STATUS("");
	    	if(stACCOUNT_LIST_XX.get(i).getSTATUS_LAST_DATE()==null)stACCOUNT_LIST_XX.get(i).setSTATUS_LAST_DATE("");
	    	if(stACCOUNT_LIST_XX.get(i).getSTATUS_ACTV_RSN_CODE()==null)stACCOUNT_LIST_XX.get(i).setSTATUS_ACTV_RSN_CODE("");
	    	if(stACCOUNT_LIST_XX.get(i).getWRITE_OFF_IND()==null)stACCOUNT_LIST_XX.get(i).setWRITE_OFF_IND("");
	    	if(stACCOUNT_LIST_XX.get(i).getCYCLE_CODE()==null)stACCOUNT_LIST_XX.get(i).setCYCLE_CODE("");
	    	if(stACCOUNT_LIST_XX.get(i).getTAX_CODE()==null)stACCOUNT_LIST_XX.get(i).setTAX_CODE("");
	    	if(stACCOUNT_LIST_XX.get(i).getPYM_MTD()==null)stACCOUNT_LIST_XX.get(i).setPYM_MTD("");
	    	if(stACCOUNT_LIST_XX.get(i).getIDENTITY_TYPE()==null)stACCOUNT_LIST_XX.get(i).setIDENTITY_TYPE("");
	    	if(stACCOUNT_LIST_XX.get(i).getIDENTITY()==null)stACCOUNT_LIST_XX.get(i).setIDENTITY("");
	    	if(stACCOUNT_LIST_XX.get(i).getPAYER_IND()==null)stACCOUNT_LIST_XX.get(i).setPAYER_IND("");
	    	if(stACCOUNT_LIST_XX.get(i).getPARENT_ACCOUNT_ID()==null)stACCOUNT_LIST_XX.get(i).setPARENT_ACCOUNT_ID("");
	    	if(stACCOUNT_LIST_XX.get(i).getGOVERNMENT_CODE()==null)stACCOUNT_LIST_XX.get(i).setGOVERNMENT_CODE("");
	    	if(stACCOUNT_LIST_XX.get(i).getSUB_GOV_CODE()==null)stACCOUNT_LIST_XX.get(i).setSUB_GOV_CODE("");
	    	if(stACCOUNT_LIST_XX.get(i).getDEPOSIT_BALANCE_AMT()==null)stACCOUNT_LIST_XX.get(i).setDEPOSIT_BALANCE_AMT("");
	    	if(stACCOUNT_LIST_XX.get(i).getDEPOSIT_REFUND_CHOICE()==null)stACCOUNT_LIST_XX.get(i).setDEPOSIT_REFUND_CHOICE("");
	    	if(stACCOUNT_LIST_XX.get(i).getDEPOSIT_STS_DATE()==null)stACCOUNT_LIST_XX.get(i).setDEPOSIT_STS_DATE("");
	    	if(stACCOUNT_LIST_XX.get(i).getCUST_TAX_ID()==null)stACCOUNT_LIST_XX.get(i).setCUST_TAX_ID("");
	    	if(stACCOUNT_LIST_XX.get(i).getCUST_BRANCH_NO()==null)stACCOUNT_LIST_XX.get(i).setCUST_BRANCH_NO("");
	    	if(stACCOUNT_LIST_XX.get(i).getLAST_CYCLE_MONTH()==null)stACCOUNT_LIST_XX.get(i).setLAST_CYCLE_MONTH("");
	    	if(stACCOUNT_LIST_XX.get(i).getLAST_CYCLE_YEAR()==null)stACCOUNT_LIST_XX.get(i).setLAST_CYCLE_YEAR("");
	    	if(stACCOUNT_LIST_XX.get(i).getBILL_RUN_STATUS()==null)stACCOUNT_LIST_XX.get(i).setBILL_RUN_STATUS("");
	    	if(stACCOUNT_LIST_XX.get(i).getBILL_COMPLETE_DATE()==null)stACCOUNT_LIST_XX.get(i).setBILL_COMPLETE_DATE("");
	    	if(stACCOUNT_LIST_XX.get(i).getPROFILE_CHANGE_IND()==null)stACCOUNT_LIST_XX.get(i).setPROFILE_CHANGE_IND("");

	    	strSQL="INSERT INTO "+tableName+" (" +
	    			"ACCOUNT_ID,"+
	    			"SYS_CREATION_DATE,"+
	    			"SYS_UPDATE_DATE,"+
	    			"ACCOUNT_TYPE,"+
	    			"ACCOUNT_SUB_TYPE,"+
	    			"AR_BALANCE,"+
	    			"ACCOUNT_STATUS,"+
	    			"STATUS_LAST_DATE,"+
	    			"STATUS_ACTV_RSN_CODE,"+
	    			"WRITE_OFF_IND,"+
	    			"CYCLE_CODE,"+
	    			"TAX_CODE,"+
	    			"PYM_MTD,"+
	    			"IDENTITY_TYPE,"+
	    			"IDENTITY,"+
	    			"PAYER_IND,"+
	    			"PARENT_BAN,"+
	    			"GOVERNMENT_CODE,"+
	    			"SUB_GOV_CODE,"+
	    			"DEPOSIT_BALANCE_AMT,"+
	    			"DEPOSIT_REFUND_CHOICE,"+
	    			"DEPOSIT_STS_DATE,"+
	    			"CUST_TAX_ID,"+
	    			"CUST_BRANCH_NO,"+
	    			"LAST_CYCLE_MONTH,"+
	    			"LAST_CYCLE_YEAR,"+
	    			"BILL_RUN_STATUS,"+
	    			"BILL_COMPLETE_DATE,"+
	    			"PROFILE_CHANGE_IND"+
	    			") VALUES (" +
	    			"'"+stACCOUNT_LIST_XX.get(i).getACCOUNT_ID()+"'," +
	    			"to_date('"+stACCOUNT_LIST_XX.get(i).getSYS_CREATION_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"to_date('"+stACCOUNT_LIST_XX.get(i).getSYS_UPDATE_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getACCOUNT_TYPE()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getACCOUNT_SUB_TYPE()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getAR_BALANCE()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getACCOUNT_STATUS()+"'," +
	    			"to_date('"+stACCOUNT_LIST_XX.get(i).getSTATUS_LAST_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getSTATUS_ACTV_RSN_CODE()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getWRITE_OFF_IND()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getCYCLE_CODE()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getTAX_CODE()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getPYM_MTD()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getIDENTITY_TYPE()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getIDENTITY()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getPAYER_IND()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getPARENT_ACCOUNT_ID()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getGOVERNMENT_CODE()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getSUB_GOV_CODE()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getDEPOSIT_BALANCE_AMT()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getDEPOSIT_REFUND_CHOICE()+"'," +
	    			"to_date('"+stACCOUNT_LIST_XX.get(i).getDEPOSIT_STS_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getCUST_TAX_ID()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getCUST_BRANCH_NO()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getLAST_CYCLE_MONTH()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getLAST_CYCLE_YEAR()+"'," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getBILL_RUN_STATUS()+"'," +
	    			"to_date('"+stACCOUNT_LIST_XX.get(i).getBILL_COMPLETE_DATE()+"','YYYYMMDDHH24MISS')," +
	    			"'"+stACCOUNT_LIST_XX.get(i).getPROFILE_CHANGE_IND()+"'," +
	    			")" ;
	
	    	//System.out.println(strSQL);
	    	BackUpFile.write(strSQL+"\r\n");
		}
		
		
		
		return 0;
	}
}
