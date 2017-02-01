package tot.bill.table;

public class ACCOUNT_TYPE {
	private String ACCOUNT_TYPE;
	private String ACCOUNT_SUB_TYPE;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String DESCRIPTION;
	private String GOVERNMENT_ACC_IND ;
	private String TAX_CODE;
	public ACCOUNT_TYPE(String aCCOUNT_TYPE, String aCCOUNT_SUB_TYPE,
			String sYS_CREATION_DATE, String sYS_UPDATE_DATE,
			String dESCRIPTION, String gOVERNMENT_ACC_IND, String tAX_CODE) {
		super();
		ACCOUNT_TYPE = aCCOUNT_TYPE;
		ACCOUNT_SUB_TYPE = aCCOUNT_SUB_TYPE;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		DESCRIPTION = dESCRIPTION;
		GOVERNMENT_ACC_IND = gOVERNMENT_ACC_IND;
		TAX_CODE = tAX_CODE;
	}
	public String getACCOUNT_TYPE() {
		return ACCOUNT_TYPE;
	}
	public void setACCOUNT_TYPE(String aCCOUNT_TYPE) {
		ACCOUNT_TYPE = aCCOUNT_TYPE;
	}
	public String getACCOUNT_SUB_TYPE() {
		return ACCOUNT_SUB_TYPE;
	}
	public void setACCOUNT_SUB_TYPE(String aCCOUNT_SUB_TYPE) {
		ACCOUNT_SUB_TYPE = aCCOUNT_SUB_TYPE;
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
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public String getGOVERNMENT_ACC_IND() {
		return GOVERNMENT_ACC_IND;
	}
	public void setGOVERNMENT_ACC_IND(String gOVERNMENT_ACC_IND) {
		GOVERNMENT_ACC_IND = gOVERNMENT_ACC_IND;
	}
	public String getTAX_CODE() {
		return TAX_CODE;
	}
	public void setTAX_CODE(String tAX_CODE) {
		TAX_CODE = tAX_CODE;
	}
	

}
