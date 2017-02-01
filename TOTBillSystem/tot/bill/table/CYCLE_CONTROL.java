package tot.bill.table;

public class CYCLE_CONTROL {
	private String CYCLE_CODE;  
	private String CYCLE_YEAR;
	private String CYCLE_MONTH;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String CYCLE_START_DATE;
	private String CYCLE_END_DATE;
	private String CYCLE_RUN_STATUS; 
	private String CYCLE_STATUS_DATE;
	private String ACCT_LIST_NAME;
	private String USG_BUCKET;
	private String ACCUM_BUCKET;
	private String CYCLE_DUE_DATE;
	private String DD_DUE_DATE;
	public CYCLE_CONTROL(String cYCLE_CODE, String cYCLE_YEAR,
			String cYCLE_MONTH, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String cYCLE_START_DATE,
			String cYCLE_END_DATE, String cYCLE_RUN_STATUS,
			String cYCLE_STATUS_DATE, String aCCT_LIST_NAME, String uSG_BUCKET,
			String aCCUM_BUCKET, String cYCLE_DUE_DATE, String dD_DUE_DATE) {
		super();
		CYCLE_CODE = cYCLE_CODE;
		CYCLE_YEAR = cYCLE_YEAR;
		CYCLE_MONTH = cYCLE_MONTH;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		CYCLE_START_DATE = cYCLE_START_DATE;
		CYCLE_END_DATE = cYCLE_END_DATE;
		CYCLE_RUN_STATUS = cYCLE_RUN_STATUS;
		CYCLE_STATUS_DATE = cYCLE_STATUS_DATE;
		ACCT_LIST_NAME = aCCT_LIST_NAME;
		USG_BUCKET = uSG_BUCKET;
		ACCUM_BUCKET = aCCUM_BUCKET;
		CYCLE_DUE_DATE = cYCLE_DUE_DATE;
		DD_DUE_DATE = dD_DUE_DATE;
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
	public String getCYCLE_START_DATE() {
		return CYCLE_START_DATE;
	}
	public void setCYCLE_START_DATE(String cYCLE_START_DATE) {
		CYCLE_START_DATE = cYCLE_START_DATE;
	}
	public String getCYCLE_END_DATE() {
		return CYCLE_END_DATE;
	}
	public void setCYCLE_END_DATE(String cYCLE_END_DATE) {
		CYCLE_END_DATE = cYCLE_END_DATE;
	}
	public String getCYCLE_RUN_STATUS() {
		return CYCLE_RUN_STATUS;
	}
	public void setCYCLE_RUN_STATUS(String cYCLE_RUN_STATUS) {
		CYCLE_RUN_STATUS = cYCLE_RUN_STATUS;
	}
	public String getCYCLE_STATUS_DATE() {
		return CYCLE_STATUS_DATE;
	}
	public void setCYCLE_STATUS_DATE(String cYCLE_STATUS_DATE) {
		CYCLE_STATUS_DATE = cYCLE_STATUS_DATE;
	}
	public String getACCT_LIST_NAME() {
		return ACCT_LIST_NAME;
	}
	public void setACCT_LIST_NAME(String aCCT_LIST_NAME) {
		ACCT_LIST_NAME = aCCT_LIST_NAME;
	}
	public String getUSG_BUCKET() {
		return USG_BUCKET;
	}
	public void setUSG_BUCKET(String uSG_BUCKET) {
		USG_BUCKET = uSG_BUCKET;
	}
	public String getACCUM_BUCKET() {
		return ACCUM_BUCKET;
	}
	public void setACCUM_BUCKET(String aCCUM_BUCKET) {
		ACCUM_BUCKET = aCCUM_BUCKET;
	}
	public String getCYCLE_DUE_DATE() {
		return CYCLE_DUE_DATE;
	}
	public void setCYCLE_DUE_DATE(String cYCLE_DUE_DATE) {
		CYCLE_DUE_DATE = cYCLE_DUE_DATE;
	}
	public String getDD_DUE_DATE() {
		return DD_DUE_DATE;
	}
	public void setDD_DUE_DATE(String dD_DUE_DATE) {
		DD_DUE_DATE = dD_DUE_DATE;
	}


}
