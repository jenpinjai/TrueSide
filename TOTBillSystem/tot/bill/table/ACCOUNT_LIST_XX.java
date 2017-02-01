package tot.bill.table;

public class ACCOUNT_LIST_XX {
	private String ACCOUNT_ID;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String ACCOUNT_TYPE;
	private String ACCOUNT_SUB_TYPE;
	private String AR_BALANCE;
	private String ACCOUNT_STATUS;
	private String STATUS_LAST_DATE;
	private String STATUS_ACTV_RSN_CODE;
	private String WRITE_OFF_IND;
	private String CYCLE_CODE;
	private String TAX_CODE;
	private String PYM_MTD;
	private String IDENTITY_TYPE;
	private String IDENTITY;
	private String PAYER_IND;
	private String PARENT_ACCOUNT_ID;
	private String GOVERNMENT_CODE;
	private String SUB_GOV_CODE;
	private String DEPOSIT_BALANCE_AMT;
	private String DEPOSIT_REFUND_CHOICE;
	private String DEPOSIT_STS_DATE;
	private String CUST_TAX_ID;
	private String CUST_BRANCH_NO;
	private String LAST_CYCLE_MONTH;
	private String LAST_CYCLE_YEAR;
	private String BILL_RUN_STATUS;
	private String BILL_COMPLETE_DATE;
	private String PROFILE_CHANGE_IND;
	private String PRINT_CATEGORY;
	public ACCOUNT_LIST_XX(String aCCOUNT_ID, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String aCCOUNT_TYPE,
			String aCCOUNT_SUB_TYPE, String aR_BALANCE, String aCCOUNT_STATUS,
			String sTATUS_LAST_DATE, String sTATUS_ACTV_RSN_CODE,
			String wRITE_OFF_IND, String cYCLE_CODE, String tAX_CODE,
			String pYM_MTD, String iDENTITY_TYPE, String iDENTITY,
			String pAYER_IND, String pARENT_ACCOUNT_ID, String gOVERNMENT_CODE,
			String sUB_GOV_CODE, String dEPOSIT_BALANCE_AMT,
			String dEPOSIT_REFUND_CHOICE, String dEPOSIT_STS_DATE,
			String cUST_TAX_ID, String cUST_BRANCH_NO, String lAST_CYCLE_MONTH,
			String lAST_CYCLE_YEAR, String bILL_RUN_STATUS,
			String bILL_COMPLETE_DATE, String pROFILE_CHANGE_IND,
			String pRINT_CATEGORY) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		ACCOUNT_TYPE = aCCOUNT_TYPE;
		ACCOUNT_SUB_TYPE = aCCOUNT_SUB_TYPE;
		AR_BALANCE = aR_BALANCE;
		ACCOUNT_STATUS = aCCOUNT_STATUS;
		STATUS_LAST_DATE = sTATUS_LAST_DATE;
		STATUS_ACTV_RSN_CODE = sTATUS_ACTV_RSN_CODE;
		WRITE_OFF_IND = wRITE_OFF_IND;
		CYCLE_CODE = cYCLE_CODE;
		TAX_CODE = tAX_CODE;
		PYM_MTD = pYM_MTD;
		IDENTITY_TYPE = iDENTITY_TYPE;
		IDENTITY = iDENTITY;
		PAYER_IND = pAYER_IND;
		PARENT_ACCOUNT_ID = pARENT_ACCOUNT_ID;
		GOVERNMENT_CODE = gOVERNMENT_CODE;
		SUB_GOV_CODE = sUB_GOV_CODE;
		DEPOSIT_BALANCE_AMT = dEPOSIT_BALANCE_AMT;
		DEPOSIT_REFUND_CHOICE = dEPOSIT_REFUND_CHOICE;
		DEPOSIT_STS_DATE = dEPOSIT_STS_DATE;
		CUST_TAX_ID = cUST_TAX_ID;
		CUST_BRANCH_NO = cUST_BRANCH_NO;
		LAST_CYCLE_MONTH = lAST_CYCLE_MONTH;
		LAST_CYCLE_YEAR = lAST_CYCLE_YEAR;
		BILL_RUN_STATUS = bILL_RUN_STATUS;
		BILL_COMPLETE_DATE = bILL_COMPLETE_DATE;
		PROFILE_CHANGE_IND = pROFILE_CHANGE_IND;
		PRINT_CATEGORY = pRINT_CATEGORY;
	}
	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}
	public String getSYS_CREATION_DATE() {
		return SYS_CREATION_DATE;
	}
	public void setSYS_CREATION_DATE(String sYS_CREATION_DATE) {
		SYS_CREATION_DATE = sYS_CREATION_DATE;
	}
	public String getSYS_UPDATE_DATE() {
		return SYS_UPDATE_DATE;
	}
	public void setSYS_UPDATE_DATE(String sYS_UPDATE_DATE) {
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
	}
	public String getACCOUNT_TYPE() {
		return ACCOUNT_TYPE;
	}
	public void setACCOUNT_TYPE(String aCCOUNT_TYPE) {
		ACCOUNT_TYPE = aCCOUNT_TYPE;
	}
	public String getACCOUNT_SUB_TYPE() {
		return ACCOUNT_SUB_TYPE;
	}
	public void setACCOUNT_SUB_TYPE(String aCCOUNT_SUB_TYPE) {
		ACCOUNT_SUB_TYPE = aCCOUNT_SUB_TYPE;
	}
	public String getAR_BALANCE() {
		return AR_BALANCE;
	}
	public void setAR_BALANCE(String aR_BALANCE) {
		AR_BALANCE = aR_BALANCE;
	}
	public String getACCOUNT_STATUS() {
		return ACCOUNT_STATUS;
	}
	public void setACCOUNT_STATUS(String aCCOUNT_STATUS) {
		ACCOUNT_STATUS = aCCOUNT_STATUS;
	}
	public String getSTATUS_LAST_DATE() {
		return STATUS_LAST_DATE;
	}
	public void setSTATUS_LAST_DATE(String sTATUS_LAST_DATE) {
		STATUS_LAST_DATE = sTATUS_LAST_DATE;
	}
	public String getSTATUS_ACTV_RSN_CODE() {
		return STATUS_ACTV_RSN_CODE;
	}
	public void setSTATUS_ACTV_RSN_CODE(String sTATUS_ACTV_RSN_CODE) {
		STATUS_ACTV_RSN_CODE = sTATUS_ACTV_RSN_CODE;
	}
	public String getWRITE_OFF_IND() {
		return WRITE_OFF_IND;
	}
	public void setWRITE_OFF_IND(String wRITE_OFF_IND) {
		WRITE_OFF_IND = wRITE_OFF_IND;
	}
	public String getCYCLE_CODE() {
		return CYCLE_CODE;
	}
	public void setCYCLE_CODE(String cYCLE_CODE) {
		CYCLE_CODE = cYCLE_CODE;
	}
	public String getTAX_CODE() {
		return TAX_CODE;
	}
	public void setTAX_CODE(String tAX_CODE) {
		TAX_CODE = tAX_CODE;
	}
	public String getPYM_MTD() {
		return PYM_MTD;
	}
	public void setPYM_MTD(String pYM_MTD) {
		PYM_MTD = pYM_MTD;
	}
	public String getIDENTITY_TYPE() {
		return IDENTITY_TYPE;
	}
	public void setIDENTITY_TYPE(String iDENTITY_TYPE) {
		IDENTITY_TYPE = iDENTITY_TYPE;
	}
	public String getIDENTITY() {
		return IDENTITY;
	}
	public void setIDENTITY(String iDENTITY) {
		IDENTITY = iDENTITY;
	}
	public String getPAYER_IND() {
		return PAYER_IND;
	}
	public void setPAYER_IND(String pAYER_IND) {
		PAYER_IND = pAYER_IND;
	}
	public String getPARENT_ACCOUNT_ID() {
		return PARENT_ACCOUNT_ID;
	}
	public void setPARENT_ACCOUNT_ID(String pARENT_ACCOUNT_ID) {
		PARENT_ACCOUNT_ID = pARENT_ACCOUNT_ID;
	}
	public String getGOVERNMENT_CODE() {
		return GOVERNMENT_CODE;
	}
	public void setGOVERNMENT_CODE(String gOVERNMENT_CODE) {
		GOVERNMENT_CODE = gOVERNMENT_CODE;
	}
	public String getSUB_GOV_CODE() {
		return SUB_GOV_CODE;
	}
	public void setSUB_GOV_CODE(String sUB_GOV_CODE) {
		SUB_GOV_CODE = sUB_GOV_CODE;
	}
	public String getDEPOSIT_BALANCE_AMT() {
		return DEPOSIT_BALANCE_AMT;
	}
	public void setDEPOSIT_BALANCE_AMT(String dEPOSIT_BALANCE_AMT) {
		DEPOSIT_BALANCE_AMT = dEPOSIT_BALANCE_AMT;
	}
	public String getDEPOSIT_REFUND_CHOICE() {
		return DEPOSIT_REFUND_CHOICE;
	}
	public void setDEPOSIT_REFUND_CHOICE(String dEPOSIT_REFUND_CHOICE) {
		DEPOSIT_REFUND_CHOICE = dEPOSIT_REFUND_CHOICE;
	}
	public String getDEPOSIT_STS_DATE() {
		return DEPOSIT_STS_DATE;
	}
	public void setDEPOSIT_STS_DATE(String dEPOSIT_STS_DATE) {
		DEPOSIT_STS_DATE = dEPOSIT_STS_DATE;
	}
	public String getCUST_TAX_ID() {
		return CUST_TAX_ID;
	}
	public void setCUST_TAX_ID(String cUST_TAX_ID) {
		CUST_TAX_ID = cUST_TAX_ID;
	}
	public String getCUST_BRANCH_NO() {
		return CUST_BRANCH_NO;
	}
	public void setCUST_BRANCH_NO(String cUST_BRANCH_NO) {
		CUST_BRANCH_NO = cUST_BRANCH_NO;
	}
	public String getLAST_CYCLE_MONTH() {
		return LAST_CYCLE_MONTH;
	}
	public void setLAST_CYCLE_MONTH(String lAST_CYCLE_MONTH) {
		LAST_CYCLE_MONTH = lAST_CYCLE_MONTH;
	}
	public String getLAST_CYCLE_YEAR() {
		return LAST_CYCLE_YEAR;
	}
	public void setLAST_CYCLE_YEAR(String lAST_CYCLE_YEAR) {
		LAST_CYCLE_YEAR = lAST_CYCLE_YEAR;
	}
	public String getBILL_RUN_STATUS() {
		return BILL_RUN_STATUS;
	}
	public void setBILL_RUN_STATUS(String bILL_RUN_STATUS) {
		BILL_RUN_STATUS = bILL_RUN_STATUS;
	}
	public String getBILL_COMPLETE_DATE() {
		return BILL_COMPLETE_DATE;
	}
	public void setBILL_COMPLETE_DATE(String bILL_COMPLETE_DATE) {
		BILL_COMPLETE_DATE = bILL_COMPLETE_DATE;
	}
	public String getPROFILE_CHANGE_IND() {
		return PROFILE_CHANGE_IND;
	}
	public void setPROFILE_CHANGE_IND(String pROFILE_CHANGE_IND) {
		PROFILE_CHANGE_IND = pROFILE_CHANGE_IND;
	}
	public String getPRINT_CATEGORY() {
		return PRINT_CATEGORY;
	}
	public void setPRINT_CATEGORY(String pRINT_CATEGORY) {
		PRINT_CATEGORY = pRINT_CATEGORY;
	}
	

}
