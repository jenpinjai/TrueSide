package tot.bill.table;

public class SERVICE_DISCOUNT {
	private String ACCOUNT_ID;
	private String PRODUCT_TYPE;
	private String PRODUCT_NO;
	private String DISCOUNT_CODE;
	private String DISCOUNT_TYPE;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String EFFECTIVE_DATE;
	private String EXPIRATION_DATE;
	public SERVICE_DISCOUNT(String aCCOUNT_ID, String pRODUCT_TYPE,
			String pRODUCT_NO, String dISCOUNT_CODE, String dISCOUNT_TYPE,
			String sYS_CREATION_DATE, String sYS_UPDATE_DATE,
			String eFFECTIVE_DATE, String eXPIRATION_DATE) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		PRODUCT_TYPE = pRODUCT_TYPE;
		PRODUCT_NO = pRODUCT_NO;
		DISCOUNT_CODE = dISCOUNT_CODE;
		DISCOUNT_TYPE = dISCOUNT_TYPE;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		EFFECTIVE_DATE = eFFECTIVE_DATE;
		EXPIRATION_DATE = eXPIRATION_DATE;
	}
	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}
	public String getPRODUCT_TYPE() {
		return PRODUCT_TYPE;
	}
	public void setPRODUCT_TYPE(String pRODUCT_TYPE) {
		PRODUCT_TYPE = pRODUCT_TYPE;
	}
	public String getPRODUCT_NO() {
		return PRODUCT_NO;
	}
	public void setPRODUCT_NO(String pRODUCT_NO) {
		PRODUCT_NO = pRODUCT_NO;
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
