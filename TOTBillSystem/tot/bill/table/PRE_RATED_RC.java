package tot.bill.table;

public class PRE_RATED_RC {
	private String ACCOUNT_ID;
	private String PRODUCT_TYPE;
	private String PRODUCT_NO;
	private String CYCLE_CODE;
	private String PRICE_PLAN;
	private String FEATURE_CODE;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String CHARGE_AMT;
	private String FIRST_BILL_IND;
	private String LAST_BILL_IND;
	private String IGNORE_IND;
	public PRE_RATED_RC(String aCCOUNT_ID, String pRODUCT_TYPE,
			String pRODUCT_NO, String cYCLE_CODE, String pRICE_PLAN,
			String fEATURE_CODE, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String cHARGE_AMT, String fIRST_BILL_IND,
			String lAST_BILL_IND, String iGNORE_IND) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		PRODUCT_TYPE = pRODUCT_TYPE;
		PRODUCT_NO = pRODUCT_NO;
		CYCLE_CODE = cYCLE_CODE;
		PRICE_PLAN = pRICE_PLAN;
		FEATURE_CODE = fEATURE_CODE;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		CHARGE_AMT = cHARGE_AMT;
		FIRST_BILL_IND = fIRST_BILL_IND;
		LAST_BILL_IND = lAST_BILL_IND;
		IGNORE_IND = iGNORE_IND;
	}
	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}
	public String getPRODUCT_TYPE() {
		return PRODUCT_TYPE;
	}
	public void setPRODUCT_TYPE(String pRODUCT_TYPE) {
		PRODUCT_TYPE = pRODUCT_TYPE;
	}
	public String getPRODUCT_NO() {
		return PRODUCT_NO;
	}
	public void setPRODUCT_NO(String pRODUCT_NO) {
		PRODUCT_NO = pRODUCT_NO;
	}
	public String getCYCLE_CODE() {
		return CYCLE_CODE;
	}
	public void setCYCLE_CODE(String cYCLE_CODE) {
		CYCLE_CODE = cYCLE_CODE;
	}
	public String getPRICE_PLAN() {
		return PRICE_PLAN;
	}
	public void setPRICE_PLAN(String pRICE_PLAN) {
		PRICE_PLAN = pRICE_PLAN;
	}
	public String getFEATURE_CODE() {
		return FEATURE_CODE;
	}
	public void setFEATURE_CODE(String fEATURE_CODE) {
		FEATURE_CODE = fEATURE_CODE;
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
	public String getCHARGE_AMT() {
		return CHARGE_AMT;
	}
	public void setCHARGE_AMT(String cHARGE_AMT) {
		CHARGE_AMT = cHARGE_AMT;
	}
	public String getFIRST_BILL_IND() {
		return FIRST_BILL_IND;
	}
	public void setFIRST_BILL_IND(String fIRST_BILL_IND) {
		FIRST_BILL_IND = fIRST_BILL_IND;
	}
	public String getLAST_BILL_IND() {
		return LAST_BILL_IND;
	}
	public void setLAST_BILL_IND(String lAST_BILL_IND) {
		LAST_BILL_IND = lAST_BILL_IND;
	}
	public String getIGNORE_IND() {
		return IGNORE_IND;
	}
	public void setIGNORE_IND(String iGNORE_IND) {
		IGNORE_IND = iGNORE_IND;
	}
	


}
