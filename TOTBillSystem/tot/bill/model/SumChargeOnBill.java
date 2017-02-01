package tot.bill.model;

public class SumChargeOnBill {
	private String ACCOUNT_ID;	
	private String CATEGORY_CODE;
	private String SUM_SC_ACTV_AMT;
	private String SUM_SC_TAX_AMT;
	private String SUM_DC_ACTV_AMT;
	private String SUM_DC_TAX_AMT;
	private String TAX;
	private String TAX_CODE;
	public SumChargeOnBill(String aCCOUNT_ID, String cATEGORY_CODE,
			String sUM_SC_ACTV_AMT, String sUM_SC_TAX_AMT,
			String sUM_DC_ACTV_AMT, String sUM_DC_TAX_AMT, String tAX,
			String tAX_CODE) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		CATEGORY_CODE = cATEGORY_CODE;
		SUM_SC_ACTV_AMT = sUM_SC_ACTV_AMT;
		SUM_SC_TAX_AMT = sUM_SC_TAX_AMT;
		SUM_DC_ACTV_AMT = sUM_DC_ACTV_AMT;
		SUM_DC_TAX_AMT = sUM_DC_TAX_AMT;
		TAX = tAX;
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
	public String getSUM_SC_ACTV_AMT() {
		return SUM_SC_ACTV_AMT;
	}
	public void setSUM_SC_ACTV_AMT(String sUM_SC_ACTV_AMT) {
		SUM_SC_ACTV_AMT = sUM_SC_ACTV_AMT;
	}
	public String getSUM_SC_TAX_AMT() {
		return SUM_SC_TAX_AMT;
	}
	public void setSUM_SC_TAX_AMT(String sUM_SC_TAX_AMT) {
		SUM_SC_TAX_AMT = sUM_SC_TAX_AMT;
	}
	public String getSUM_DC_ACTV_AMT() {
		return SUM_DC_ACTV_AMT;
	}
	public void setSUM_DC_ACTV_AMT(String sUM_DC_ACTV_AMT) {
		SUM_DC_ACTV_AMT = sUM_DC_ACTV_AMT;
	}
	public String getSUM_DC_TAX_AMT() {
		return SUM_DC_TAX_AMT;
	}
	public void setSUM_DC_TAX_AMT(String sUM_DC_TAX_AMT) {
		SUM_DC_TAX_AMT = sUM_DC_TAX_AMT;
	}
	public String getTAX() {
		return TAX;
	}
	public void setTAX(String tAX) {
		TAX = tAX;
	}
	public String getTAX_CODE() {
		return TAX_CODE;
	}
	public void setTAX_CODE(String tAX_CODE) {
		TAX_CODE = tAX_CODE;
	}
	
	
	
}
