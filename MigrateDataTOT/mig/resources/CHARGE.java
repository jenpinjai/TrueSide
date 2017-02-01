package mig.resources;

public class CHARGE {
	private String ACCOUNT_ID;
	private String PRODUCT_NO;
	private String CHARGE_TYPE;
	private String REVENUE_CODE;
	private String ACTV_AMT;
	private String TAX_AMT;
	private String TAX_CODE;
	private String PRICE_PLAN;
	private String FEATURE_CODE;
	public CHARGE(String aCCOUNT_ID, String pRODUCT_NO, String cHARGE_TYPE,
			String rEVENUE_CODE, String aCTV_AMT, String tAX_AMT,
			String tAX_CODE, String pRICE_PLAN, String fEATURE_CODE) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		PRODUCT_NO = pRODUCT_NO;
		CHARGE_TYPE = cHARGE_TYPE;
		REVENUE_CODE = rEVENUE_CODE;
		ACTV_AMT = aCTV_AMT;
		TAX_AMT = tAX_AMT;
		TAX_CODE = tAX_CODE;
		PRICE_PLAN = pRICE_PLAN;
		FEATURE_CODE = fEATURE_CODE;
	}
	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}
	public String getPRODUCT_NO() {
		return PRODUCT_NO;
	}
	public void setPRODUCT_NO(String pRODUCT_NO) {
		PRODUCT_NO = pRODUCT_NO;
	}
	public String getCHARGE_TYPE() {
		return CHARGE_TYPE;
	}
	public void setCHARGE_TYPE(String cHARGE_TYPE) {
		CHARGE_TYPE = cHARGE_TYPE;
	}
	public String getREVENUE_CODE() {
		return REVENUE_CODE;
	}
	public void setREVENUE_CODE(String rEVENUE_CODE) {
		REVENUE_CODE = rEVENUE_CODE;
	}
	public String getACTV_AMT() {
		return ACTV_AMT;
	}
	public void setACTV_AMT(String aCTV_AMT) {
		ACTV_AMT = aCTV_AMT;
	}
	public String getTAX_AMT() {
		return TAX_AMT;
	}
	public void setTAX_AMT(String tAX_AMT) {
		TAX_AMT = tAX_AMT;
	}
	public String getTAX_CODE() {
		return TAX_CODE;
	}
	public void setTAX_CODE(String tAX_CODE) {
		TAX_CODE = tAX_CODE;
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

}
