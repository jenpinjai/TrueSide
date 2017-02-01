package tot.bill.model;

public class SumCharge {
	private String ACCOUNT_ID;	
	private String CATEGORY_CODE;
	private String SUM_ACTV_AMT;
	private String SUM_TAX_AMT;
	private String TAX_CODE;
	public SumCharge(String aCCOUNT_ID, String cATEGORY_CODE,
			String sUM_ACTV_AMT, String sUM_TAX_AMT, String tAX_CODE) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		CATEGORY_CODE = cATEGORY_CODE;
		SUM_ACTV_AMT = sUM_ACTV_AMT;
		SUM_TAX_AMT = sUM_TAX_AMT;
		TAX_CODE = tAX_CODE;
	}
	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}
	public String getCATEGORY_CODE() {
		return CATEGORY_CODE;
	}
	public void setCATEGORY_CODE(String cATEGORY_CODE) {
		CATEGORY_CODE = cATEGORY_CODE;
	}
	public String getSUM_ACTV_AMT() {
		return SUM_ACTV_AMT;
	}
	public void setSUM_ACTV_AMT(String sUM_ACTV_AMT) {
		SUM_ACTV_AMT = sUM_ACTV_AMT;
	}
	public String getSUM_TAX_AMT() {
		return SUM_TAX_AMT;
	}
	public void setSUM_TAX_AMT(String sUM_TAX_AMT) {
		SUM_TAX_AMT = sUM_TAX_AMT;
	}
	public String getTAX_CODE() {
		return TAX_CODE;
	}
	public void setTAX_CODE(String tAX_CODE) {
		TAX_CODE = tAX_CODE;
	}
	
	
}
