package tot.bill.table;

public class DISCOUNT {
	private String CYCLE_CODE;
	private String CYCLE_MONTH;
	private String CYCLE_YEAR;
	private String ACCOUNT_ID;
	private String PRODUCT_TYPE;
	private String PRODUCT_NO;
	private String PRICE_PLAN;
	private String FEATURE_CODE;
	private String REVENUE_CODE;
	private String DISCOUNT_CODE;
	private String DISCOUNT_TYPE;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String DISCOUNT_AMT;
	public DISCOUNT(String cYCLE_CODE, String cYCLE_MONTH, String cYCLE_YEAR,
			String aCCOUNT_ID, String pRODUCT_TYPE, String pRODUCT_NO,
			String pRICE_PLAN, String fEATURE_CODE, String rEVENUE_CODE,
			String dISCOUNT_CODE, String dISCOUNT_TYPE, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String dISCOUNT_AMT) {
		super();
		CYCLE_CODE = cYCLE_CODE;
		CYCLE_MONTH = cYCLE_MONTH;
		CYCLE_YEAR = cYCLE_YEAR;
		ACCOUNT_ID = aCCOUNT_ID;
		PRODUCT_TYPE = pRODUCT_TYPE;
		PRODUCT_NO = pRODUCT_NO;
		PRICE_PLAN = pRICE_PLAN;
		FEATURE_CODE = fEATURE_CODE;
		REVENUE_CODE = rEVENUE_CODE;
		DISCOUNT_CODE = dISCOUNT_CODE;
		DISCOUNT_TYPE = dISCOUNT_TYPE;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		DISCOUNT_AMT = dISCOUNT_AMT;
	}
	public String getCYCLE_CODE() {
		return CYCLE_CODE;
	}
	public void setCYCLE_CODE(String cYCLE_CODE) {
		CYCLE_CODE = cYCLE_CODE;
	}
	public String getCYCLE_MONTH() {
		return CYCLE_MONTH;
	}
	public void setCYCLE_MONTH(String cYCLE_MONTH) {
		CYCLE_MONTH = cYCLE_MONTH;
	}
	public String getCYCLE_YEAR() {
		return CYCLE_YEAR;
	}
	public void setCYCLE_YEAR(String cYCLE_YEAR) {
		CYCLE_YEAR = cYCLE_YEAR;
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
	public String getREVENUE_CODE() {
		return REVENUE_CODE;
	}
	public void setREVENUE_CODE(String rEVENUE_CODE) {
		REVENUE_CODE = rEVENUE_CODE;
	}
	public String getDISCOUNT_CODE() {
		return DISCOUNT_CODE;
	}
	public void setDISCOUNT_CODE(String dISCOUNT_CODE) {
		DISCOUNT_CODE = dISCOUNT_CODE;
	}
	public String getDISCOUNT_TYPE() {
		return DISCOUNT_TYPE;
	}
	public void setDISCOUNT_TYPE(String dISCOUNT_TYPE) {
		DISCOUNT_TYPE = dISCOUNT_TYPE;
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
	public String getDISCOUNT_AMT() {
		return DISCOUNT_AMT;
	}
	public void setDISCOUNT_AMT(String dISCOUNT_AMT) {
		DISCOUNT_AMT = dISCOUNT_AMT;
	}
	
}
