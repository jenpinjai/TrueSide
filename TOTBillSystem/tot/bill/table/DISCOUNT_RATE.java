package tot.bill.table;

public class DISCOUNT_RATE {
	private String DISCOUNT_CODE;
	private String DISCOUNT_TYPE;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String REVENUE_CODE;
	private String PLAN_RANK;
	private String DISCOUNT_VALUE;
	private String DISCOUNT_MAX;
	public DISCOUNT_RATE(String dISCOUNT_CODE, String dISCOUNT_TYPE,
			String sYS_CREATION_DATE, String sYS_UPDATE_DATE,
			String rEVENUE_CODE, String pLAN_RANK, String dISCOUNT_VALUE,
			String dISCOUNT_MAX) {
		super();
		DISCOUNT_CODE = dISCOUNT_CODE;
		DISCOUNT_TYPE = dISCOUNT_TYPE;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		REVENUE_CODE = rEVENUE_CODE;
		PLAN_RANK = pLAN_RANK;
		DISCOUNT_VALUE = dISCOUNT_VALUE;
		DISCOUNT_MAX = dISCOUNT_MAX;
	}
	public String getDISCOUNT_CODE() {
		return DISCOUNT_CODE;
	}
	public void setDISCOUNT_CODE(String dISCOUNT_CODE) {
		DISCOUNT_CODE = dISCOUNT_CODE;
	}
	public String getDISCOUNT_TYPE() {
		return DISCOUNT_TYPE;
	}
	public void setDISCOUNT_TYPE(String dISCOUNT_TYPE) {
		DISCOUNT_TYPE = dISCOUNT_TYPE;
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
	public String getREVENUE_CODE() {
		return REVENUE_CODE;
	}
	public void setREVENUE_CODE(String rEVENUE_CODE) {
		REVENUE_CODE = rEVENUE_CODE;
	}
	public String getPLAN_RANK() {
		return PLAN_RANK;
	}
	public void setPLAN_RANK(String pLAN_RANK) {
		PLAN_RANK = pLAN_RANK;
	}
	public String getDISCOUNT_VALUE() {
		return DISCOUNT_VALUE;
	}
	public void setDISCOUNT_VALUE(String dISCOUNT_VALUE) {
		DISCOUNT_VALUE = dISCOUNT_VALUE;
	}
	public String getDISCOUNT_MAX() {
		return DISCOUNT_MAX;
	}
	public void setDISCOUNT_MAX(String dISCOUNT_MAX) {
		DISCOUNT_MAX = dISCOUNT_MAX;
	}
	
}
