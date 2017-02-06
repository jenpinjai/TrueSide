package tot.bill.table;

public class USAGE_XX {
	private String CYCLE_CODE;
	private String CYCLE_YEAR;
	private String CYCLE_MONTH;
	private String ACCOUNT_ID;
	private String ORIG_TN;
	private String CONNECT_DATE;
	private String CALL_DURATION;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String CALL_VOL_ROUNDED;
	private String PRODUCT_TYPE;
	private String PRODUCT_NO;
	private String DIALED_TN;
	private String PRICE_PLAN_CODE;
	private String FEATURE_CODE;
	private String CHARGE_AMT;
	private String CALL_ADJUSTMENT_IND;
	private String DESTINATION_ON_BILL;
	private String BILL_STATUS;
        public USAGE_XX(){}
	public USAGE_XX(String cYCLE_CODE, String cYCLE_YEAR, String cYCLE_MONTH,
			String aCCOUNT_ID, String oRIG_TN, String cONNECT_DATE,
			String cALL_DURATION, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String cALL_VOL_ROUNDED,
			String pRODUCT_TYPE, String pRODUCT_NO, String dIALED_TN,
			String pRICE_PLAN_CODE, String fEATURE_CODE, String cHARGE_AMT,
			String cALL_ADJUSTMENT_IND, String dESTINATION_ON_BILL,
			String bILL_STATUS) {
		super();
		CYCLE_CODE = cYCLE_CODE;
		CYCLE_YEAR = cYCLE_YEAR;
		CYCLE_MONTH = cYCLE_MONTH;
		ACCOUNT_ID = aCCOUNT_ID;
		ORIG_TN = oRIG_TN;
		CONNECT_DATE = cONNECT_DATE;
		CALL_DURATION = cALL_DURATION;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		CALL_VOL_ROUNDED = cALL_VOL_ROUNDED;
		PRODUCT_TYPE = pRODUCT_TYPE;
		PRODUCT_NO = pRODUCT_NO;
		DIALED_TN = dIALED_TN;
		PRICE_PLAN_CODE = pRICE_PLAN_CODE;
		FEATURE_CODE = fEATURE_CODE;
		CHARGE_AMT = cHARGE_AMT;
		CALL_ADJUSTMENT_IND = cALL_ADJUSTMENT_IND;
		DESTINATION_ON_BILL = dESTINATION_ON_BILL;
		BILL_STATUS = bILL_STATUS;
	}
	public String getCYCLE_CODE() {
		return CYCLE_CODE;
	}
	public void setCYCLE_CODE(String cYCLE_CODE) {
		CYCLE_CODE = cYCLE_CODE;
	}
	public String getCYCLE_YEAR() {
		return CYCLE_YEAR;
	}
	public void setCYCLE_YEAR(String cYCLE_YEAR) {
		CYCLE_YEAR = cYCLE_YEAR;
	}
	public String getCYCLE_MONTH() {
		return CYCLE_MONTH;
	}
	public void setCYCLE_MONTH(String cYCLE_MONTH) {
		CYCLE_MONTH = cYCLE_MONTH;
	}
	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}
	public String getORIG_TN() {
		return ORIG_TN;
	}
	public void setORIG_TN(String oRIG_TN) {
		ORIG_TN = oRIG_TN;
	}
	public String getCONNECT_DATE() {
		return CONNECT_DATE;
	}
	public void setCONNECT_DATE(String cONNECT_DATE) {
		CONNECT_DATE = cONNECT_DATE;
	}
	public String getCALL_DURATION() {
		return CALL_DURATION;
	}
	public void setCALL_DURATION(String cALL_DURATION) {
		CALL_DURATION = cALL_DURATION;
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
	public String getCALL_VOL_ROUNDED() {
		return CALL_VOL_ROUNDED;
	}
	public void setCALL_VOL_ROUNDED(String cALL_VOL_ROUNDED) {
		CALL_VOL_ROUNDED = cALL_VOL_ROUNDED;
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
	public String getDIALED_TN() {
		return DIALED_TN;
	}
	public void setDIALED_TN(String dIALED_TN) {
		DIALED_TN = dIALED_TN;
	}
	public String getPRICE_PLAN_CODE() {
		return PRICE_PLAN_CODE;
	}
	public void setPRICE_PLAN_CODE(String pRICE_PLAN_CODE) {
		PRICE_PLAN_CODE = pRICE_PLAN_CODE;
	}
	public String getFEATURE_CODE() {
		return FEATURE_CODE;
	}
	public void setFEATURE_CODE(String fEATURE_CODE) {
		FEATURE_CODE = fEATURE_CODE;
	}
	public String getCHARGE_AMT() {
		return CHARGE_AMT;
	}
	public void setCHARGE_AMT(String cHARGE_AMT) {
		CHARGE_AMT = cHARGE_AMT;
	}
	public String getCALL_ADJUSTMENT_IND() {
		return CALL_ADJUSTMENT_IND;
	}
	public void setCALL_ADJUSTMENT_IND(String cALL_ADJUSTMENT_IND) {
		CALL_ADJUSTMENT_IND = cALL_ADJUSTMENT_IND;
	}
	public String getDESTINATION_ON_BILL() {
		return DESTINATION_ON_BILL;
	}
	public void setDESTINATION_ON_BILL(String dESTINATION_ON_BILL) {
		DESTINATION_ON_BILL = dESTINATION_ON_BILL;
	}
	public String getBILL_STATUS() {
		return BILL_STATUS;
	}
	public void setBILL_STATUS(String bILL_STATUS) {
		BILL_STATUS = bILL_STATUS;
	}
	

}
