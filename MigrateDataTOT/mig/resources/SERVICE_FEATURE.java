package mig.resources;

public class SERVICE_FEATURE {
	private String ACCOUNT_ID;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String PRODUCT_TYPE;
	private String PRODUCT_NO;
	private String PRICE_PLAN;
	private String FEATURE_CODE;
	private String EFFECTIVE_DATE;
	private String EXPIRATION_DATE;
	private int FIRST_VAR_RATE_QTY;
	private String ISSUE_DATE;
	public SERVICE_FEATURE(String aCCOUNT_ID, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String pRODUCT_TYPE, String pRODUCT_NO,
			String pRICE_PLAN, String fEATURE_CODE, String eFFECTIVE_DATE,
			String eXPIRATION_DATE, int fIRST_VAR_RATE_QTY, String iSSUE_DATE) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		PRODUCT_TYPE = pRODUCT_TYPE;
		PRODUCT_NO = pRODUCT_NO;
		PRICE_PLAN = pRICE_PLAN;
		FEATURE_CODE = fEATURE_CODE;
		EFFECTIVE_DATE = eFFECTIVE_DATE;
		EXPIRATION_DATE = eXPIRATION_DATE;
		FIRST_VAR_RATE_QTY = fIRST_VAR_RATE_QTY;
		ISSUE_DATE = iSSUE_DATE;
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
	public String getEFFECTIVE_DATE() {
		return EFFECTIVE_DATE;
	}
	public void setEFFECTIVE_DATE(String eFFECTIVE_DATE) {
		EFFECTIVE_DATE = eFFECTIVE_DATE;
	}
	public String getEXPIRATION_DATE() {
		return EXPIRATION_DATE;
	}
	public void setEXPIRATION_DATE(String eXPIRATION_DATE) {
		EXPIRATION_DATE = eXPIRATION_DATE;
	}
	public int getFIRST_VAR_RATE_QTY() {
		return FIRST_VAR_RATE_QTY;
	}
	public void setFIRST_VAR_RATE_QTY(int fIRST_VAR_RATE_QTY) {
		FIRST_VAR_RATE_QTY = fIRST_VAR_RATE_QTY;
	}
	public String getISSUE_DATE() {
		return ISSUE_DATE;
	}
	public void setISSUE_DATE(String iSSUE_DATE) {
		ISSUE_DATE = iSSUE_DATE;
	}
	
}
