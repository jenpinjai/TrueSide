package tot.bill.table;

public class FEATURE {
	private String FEATURE_CODE;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String FEATURE_DESC;
	private String CHARGE_DESC;
	private String CATEGORY_CODE;
	private String EFFECTIVE_DATE;
	private String EXPIRATION_DATE;
	public FEATURE(String fEATURE_CODE, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String fEATURE_DESC, String cHARGE_DESC,
			String cATEGORY_CODE, String eFFECTIVE_DATE, String eXPIRATION_DATE) {
		super();
		FEATURE_CODE = fEATURE_CODE;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		FEATURE_DESC = fEATURE_DESC;
		CHARGE_DESC = cHARGE_DESC;
		CATEGORY_CODE = cATEGORY_CODE;
		EFFECTIVE_DATE = eFFECTIVE_DATE;
		EXPIRATION_DATE = eXPIRATION_DATE;
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
	public String getFEATURE_DESC() {
		return FEATURE_DESC;
	}
	public void setFEATURE_DESC(String fEATURE_DESC) {
		FEATURE_DESC = fEATURE_DESC;
	}
	public String getCHARGE_DESC() {
		return CHARGE_DESC;
	}
	public void setCHARGE_DESC(String cHARGE_DESC) {
		CHARGE_DESC = cHARGE_DESC;
	}
	public String getCATEGORY_CODE() {
		return CATEGORY_CODE;
	}
	public void setCATEGORY_CODE(String cATEGORY_CODE) {
		CATEGORY_CODE = cATEGORY_CODE;
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
	
}
