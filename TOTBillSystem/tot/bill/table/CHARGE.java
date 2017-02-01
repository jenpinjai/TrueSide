package tot.bill.table;

public class CHARGE {
	private String ACCOUNT_ID;
	private String CHARGE_SEQ_NO;
	private String INVOICE_SEQ_NO;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String CYCLE_CODE;
	private String CYCLE_YEAR;
	private String CYCLE_MONTH;
	private String PRODUCT_TYPE;
	private String PRODUCT_NO;
	private String CHG_CREATION_DATE;
	private String CHARGE_TYPE;
	private String IMMEDIATE_IND;
	private String PRICE_PLAN;
	private String FEATURE_CODE;
	private String REVENUE_CODE;
	private String DISCOUNT_CODE;
	private String CATEGORY_CODE;
	private String CHARGE_START_DATE;
	private String CHARGE_END_DATE;
	private String ACTV_DATE;
	private String ACTV_AMT;
	private String TAX_CODE;
	private String TAX_AMT;
	private String TOTAL_NUMBER_OF_CALLS;
	public CHARGE(String aCCOUNT_ID, String cHARGE_SEQ_NO,
			String iNVOICE_SEQ_NO, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String cYCLE_CODE, String cYCLE_YEAR,
			String cYCLE_MONTH, String pRODUCT_TYPE, String pRODUCT_NO,
			String cHG_CREATION_DATE, String cHARGE_TYPE, String iMMEDIATE_IND,
			String pRICE_PLAN, String fEATURE_CODE, String rEVENUE_CODE,
			String dISCOUNT_CODE, String cATEGORY_CODE,
			String cHARGE_START_DATE, String cHARGE_END_DATE, String aCTV_DATE,
			String aCTV_AMT, String tAX_CODE, String tAX_AMT,
			String tOTAL_NUMBER_OF_CALLS) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		CHARGE_SEQ_NO = cHARGE_SEQ_NO;
		INVOICE_SEQ_NO = iNVOICE_SEQ_NO;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		CYCLE_CODE = cYCLE_CODE;
		CYCLE_YEAR = cYCLE_YEAR;
		CYCLE_MONTH = cYCLE_MONTH;
		PRODUCT_TYPE = pRODUCT_TYPE;
		PRODUCT_NO = pRODUCT_NO;
		CHG_CREATION_DATE = cHG_CREATION_DATE;
		CHARGE_TYPE = cHARGE_TYPE;
		IMMEDIATE_IND = iMMEDIATE_IND;
		PRICE_PLAN = pRICE_PLAN;
		FEATURE_CODE = fEATURE_CODE;
		REVENUE_CODE = rEVENUE_CODE;
		DISCOUNT_CODE = dISCOUNT_CODE;
		CATEGORY_CODE = cATEGORY_CODE;
		CHARGE_START_DATE = cHARGE_START_DATE;
		CHARGE_END_DATE = cHARGE_END_DATE;
		ACTV_DATE = aCTV_DATE;
		ACTV_AMT = aCTV_AMT;
		TAX_CODE = tAX_CODE;
		TAX_AMT = tAX_AMT;
		TOTAL_NUMBER_OF_CALLS = tOTAL_NUMBER_OF_CALLS;
	}
	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}
	public String getCHARGE_SEQ_NO() {
		return CHARGE_SEQ_NO;
	}
	public void setCHARGE_SEQ_NO(String cHARGE_SEQ_NO) {
		CHARGE_SEQ_NO = cHARGE_SEQ_NO;
	}
	public String getINVOICE_SEQ_NO() {
		return INVOICE_SEQ_NO;
	}
	public void setINVOICE_SEQ_NO(String iNVOICE_SEQ_NO) {
		INVOICE_SEQ_NO = iNVOICE_SEQ_NO;
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
	public String getCHG_CREATION_DATE() {
		return CHG_CREATION_DATE;
	}
	public void setCHG_CREATION_DATE(String cHG_CREATION_DATE) {
		CHG_CREATION_DATE = cHG_CREATION_DATE;
	}
	public String getCHARGE_TYPE() {
		return CHARGE_TYPE;
	}
	public void setCHARGE_TYPE(String cHARGE_TYPE) {
		CHARGE_TYPE = cHARGE_TYPE;
	}
	public String getIMMEDIATE_IND() {
		return IMMEDIATE_IND;
	}
	public void setIMMEDIATE_IND(String iMMEDIATE_IND) {
		IMMEDIATE_IND = iMMEDIATE_IND;
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
	public String getCATEGORY_CODE() {
		return CATEGORY_CODE;
	}
	public void setCATEGORY_CODE(String cATEGORY_CODE) {
		CATEGORY_CODE = cATEGORY_CODE;
	}
	public String getCHARGE_START_DATE() {
		return CHARGE_START_DATE;
	}
	public void setCHARGE_START_DATE(String cHARGE_START_DATE) {
		CHARGE_START_DATE = cHARGE_START_DATE;
	}
	public String getCHARGE_END_DATE() {
		return CHARGE_END_DATE;
	}
	public void setCHARGE_END_DATE(String cHARGE_END_DATE) {
		CHARGE_END_DATE = cHARGE_END_DATE;
	}
	public String getACTV_DATE() {
		return ACTV_DATE;
	}
	public void setACTV_DATE(String aCTV_DATE) {
		ACTV_DATE = aCTV_DATE;
	}
	public String getACTV_AMT() {
		return ACTV_AMT;
	}
	public void setACTV_AMT(String aCTV_AMT) {
		ACTV_AMT = aCTV_AMT;
	}
	public String getTAX_CODE() {
		return TAX_CODE;
	}
	public void setTAX_CODE(String tAX_CODE) {
		TAX_CODE = tAX_CODE;
	}
	public String getTAX_AMT() {
		return TAX_AMT;
	}
	public void setTAX_AMT(String tAX_AMT) {
		TAX_AMT = tAX_AMT;
	}
	public String getTOTAL_NUMBER_OF_CALLS() {
		return TOTAL_NUMBER_OF_CALLS;
	}
	public void setTOTAL_NUMBER_OF_CALLS(String tOTAL_NUMBER_OF_CALLS) {
		TOTAL_NUMBER_OF_CALLS = tOTAL_NUMBER_OF_CALLS;
	}
	
	

}
