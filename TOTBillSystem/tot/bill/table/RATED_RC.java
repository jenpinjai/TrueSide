package tot.bill.table;

public class RATED_RC {
	private String CYCLE_CODE;
	private String CYCLE_MONTH;
	private String CYCLE_YEAR;
	private String ACCOUNT_ID;
	private String PRODUCT_TYPE;
	private String PRODUCT_NO;
	private String PRICE_PLAN;
	private String FEATURE_CODE;
	private String RC_START_DATE;
	private String RC_END_DATE;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String CHARGE_AMT;
	public RATED_RC(String cYCLE_CODE, String cYCLE_MONTH, String cYCLE_YEAR,
			String aCCOUNT_ID, String pRODUCT_TYPE, String pRODUCT_NO,
			String pRICE_PLAN, String fEATURE_CODE, String rC_START_DATE,
			String rC_END_DATE, String sYS_CREATION_DATE, String sYS_UPDATE_DATE,
			String cHARGE_AMT) {
		super();
		CYCLE_CODE = cYCLE_CODE;
		CYCLE_MONTH = cYCLE_MONTH;
		CYCLE_YEAR = cYCLE_YEAR;
		ACCOUNT_ID = aCCOUNT_ID;
		PRODUCT_TYPE = pRODUCT_TYPE;
		PRODUCT_NO = pRODUCT_NO;
		PRICE_PLAN = pRICE_PLAN;
		FEATURE_CODE = fEATURE_CODE;
		RC_START_DATE = rC_START_DATE;
		RC_END_DATE = rC_END_DATE;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		CHARGE_AMT = cHARGE_AMT;
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
	public String getRC_START_DATE() {
		return RC_START_DATE;
	}
	public void setRC_START_DATE(String rC_START_DATE) {
		RC_START_DATE = rC_START_DATE;
	}
	public String getRC_END_DATE() {
		return RC_END_DATE;
	}
	public void setRC_END_DATE(String rC_END_DATE) {
		RC_END_DATE = rC_END_DATE;
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
	
	

}
