package tot.bill.table;

public class BILL_QA {
	private String ACCOUNT_ID;
	private String CYCLE_CODE;
	private String CYCLE_YEAR;
	private String CYCLE_MONTH;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String DESCRIPTION;
	public BILL_QA(String aCCOUNT_ID, String cYCLE_CODE, String cYCLE_YEAR,
			String cYCLE_MONTH, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String dESCRIPTION) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		CYCLE_CODE = cYCLE_CODE;
		CYCLE_YEAR = cYCLE_YEAR;
		CYCLE_MONTH = cYCLE_MONTH;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		DESCRIPTION = dESCRIPTION;
	}
	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
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

}
