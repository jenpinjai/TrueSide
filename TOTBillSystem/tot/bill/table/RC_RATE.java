package tot.bill.table;

public class RC_RATE {
	private String PRICE_PLAN;
	private String FEATURE_CODE;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String EFFECTIVE_DATE;
	private String EXPIRATION_DATE;
	private Double RATE;
	public RC_RATE(String pRICE_PLAN, String fEATURE_CODE,
			String sYS_CREATION_DATE, String sYS_UPDATE_DATE,
			String eFFECTIVE_DATE, String eXPIRATION_DATE, Double rATE) {
		super();
		PRICE_PLAN = pRICE_PLAN;
		FEATURE_CODE = fEATURE_CODE;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		EFFECTIVE_DATE = eFFECTIVE_DATE;
		EXPIRATION_DATE = eXPIRATION_DATE;
		RATE = rATE;
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
	public String getEFFECTIVE_DATE() {
		return EFFECTIVE_DATE;
	}
	public void setEFFECTIVE_DATE(String eFFECTIVE_DATE) {
		EFFECTIVE_DATE = eFFECTIVE_DATE;
	}
	public String getEXPIRATION_DATE() {
		return EXPIRATION_DATE;
	}
	public void setEXPIRATION_DATE(String eXPIRATION_DATE) {
		EXPIRATION_DATE = eXPIRATION_DATE;
	}
	public Double getRATE() {
		return RATE;
	}
	public void setRATE(Double rATE) {
		RATE = rATE;
	}
	
}
