package tot.bill.table;

public class PAYMENT_ACTIVITY {
	private String ACCOUNT_ID;
	private String PYM_SEQ_NO;
	private String ACTV_SEQ_NO;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String ACTV_DATE;
	private String ACTV_CODE;
	private String ACTV_AMT;
	private String ACTV_RSN_CODE;
	private String FNT_ACCOUNT;
	private String TAX_INV_NUMBER;
	public PAYMENT_ACTIVITY(String aCCOUNT_ID, String pYM_SEQ_NO,
			String aCTV_SEQ_NO, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String aCTV_DATE, String aCTV_CODE,
			String aCTV_AMT, String aCTV_RSN_CODE, String fNT_ACCOUNT,
			String tAX_INV_NUMBER) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		PYM_SEQ_NO = pYM_SEQ_NO;
		ACTV_SEQ_NO = aCTV_SEQ_NO;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		ACTV_DATE = aCTV_DATE;
		ACTV_CODE = aCTV_CODE;
		ACTV_AMT = aCTV_AMT;
		ACTV_RSN_CODE = aCTV_RSN_CODE;
		FNT_ACCOUNT = fNT_ACCOUNT;
		TAX_INV_NUMBER = tAX_INV_NUMBER;
	}
	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}
	public String getPYM_SEQ_NO() {
		return PYM_SEQ_NO;
	}
	public void setPYM_SEQ_NO(String pYM_SEQ_NO) {
		PYM_SEQ_NO = pYM_SEQ_NO;
	}
	public String getACTV_SEQ_NO() {
		return ACTV_SEQ_NO;
	}
	public void setACTV_SEQ_NO(String aCTV_SEQ_NO) {
		ACTV_SEQ_NO = aCTV_SEQ_NO;
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
	public String getACTV_DATE() {
		return ACTV_DATE;
	}
	public void setACTV_DATE(String aCTV_DATE) {
		ACTV_DATE = aCTV_DATE;
	}
	public String getACTV_CODE() {
		return ACTV_CODE;
	}
	public void setACTV_CODE(String aCTV_CODE) {
		ACTV_CODE = aCTV_CODE;
	}
	public String getACTV_AMT() {
		return ACTV_AMT;
	}
	public void setACTV_AMT(String aCTV_AMT) {
		ACTV_AMT = aCTV_AMT;
	}
	public String getACTV_RSN_CODE() {
		return ACTV_RSN_CODE;
	}
	public void setACTV_RSN_CODE(String aCTV_RSN_CODE) {
		ACTV_RSN_CODE = aCTV_RSN_CODE;
	}
	public String getFNT_ACCOUNT() {
		return FNT_ACCOUNT;
	}
	public void setFNT_ACCOUNT(String fNT_ACCOUNT) {
		FNT_ACCOUNT = fNT_ACCOUNT;
	}
	public String getTAX_INV_NUMBER() {
		return TAX_INV_NUMBER;
	}
	public void setTAX_INV_NUMBER(String tAX_INV_NUMBER) {
		TAX_INV_NUMBER = tAX_INV_NUMBER;
	}

}
