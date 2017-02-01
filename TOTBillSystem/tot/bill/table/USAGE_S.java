package tot.bill.table;

public class USAGE_S {
	private String ACCOUNT_ID;
	private String COUNT_RECORD;
	public USAGE_S(String aCCOUNT_ID, String cOUNT_RECORD) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		COUNT_RECORD = cOUNT_RECORD;
	}
	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}
	public String getCOUNT_RECORD() {
		return COUNT_RECORD;
	}
	public void setCOUNT_RECORD(String cOUNT_RECORD) {
		COUNT_RECORD = cOUNT_RECORD;
	}
	
}
