package tot.bill.table;

public class NAME_ADDRESS_INFO {
	private String ACCOUNT_ID;
	private String LINK_SEQ_NO;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String LINK_TYPE;
	private String EFFECTIVE_DATE;
	private String EXPIRATION_DATE;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String NAME_TITLE;
	private String NAME_TITLE_REF;
	private String ADR_CITY;
	private String ADR_CITY_REF;
	private String ADR_SUBURB;
	private String ADR_SUBURB_REF;
	private String ADR_KHWANG;
	private String ADR_KHWANG_REF;
	private String ADR_STREET_NAME;
	private String ADR_FLAT;
	private String ADR_FLOOR;
	private String BUILDING_NAME ;
	private String ADR_SOI;
	private String ADR_MOO;
	private String ADR_HOUSE_NO;
	private String ADR_ZIP;
	private String LANGUAGE_ID;
	public NAME_ADDRESS_INFO(String aCCOUNT_ID, String lINK_SEQ_NO,
			String sYS_CREATION_DATE, String sYS_UPDATE_DATE, String lINK_TYPE,
			String eFFECTIVE_DATE, String eXPIRATION_DATE, String fIRST_NAME,
			String lAST_NAME, String nAME_TITLE, String nAME_TITLE_REF,
			String aDR_CITY, String aDR_CITY_REF, String aDR_SUBURB,
			String aDR_SUBURB_REF, String aDR_KHWANG, String aDR_KHWANG_REF,
			String aDR_STREET_NAME, String aDR_FLAT, String aDR_FLOOR,
			String bUILDING_NAME, String aDR_SOI, String aDR_MOO,
			String aDR_HOUSE_NO, String aDR_ZIP, String lANGUAGE_ID) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		LINK_SEQ_NO = lINK_SEQ_NO;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		LINK_TYPE = lINK_TYPE;
		EFFECTIVE_DATE = eFFECTIVE_DATE;
		EXPIRATION_DATE = eXPIRATION_DATE;
		FIRST_NAME = fIRST_NAME;
		LAST_NAME = lAST_NAME;
		NAME_TITLE = nAME_TITLE;
		NAME_TITLE_REF = nAME_TITLE_REF;
		ADR_CITY = aDR_CITY;
		ADR_CITY_REF = aDR_CITY_REF;
		ADR_SUBURB = aDR_SUBURB;
		ADR_SUBURB_REF = aDR_SUBURB_REF;
		ADR_KHWANG = aDR_KHWANG;
		ADR_KHWANG_REF = aDR_KHWANG_REF;
		ADR_STREET_NAME = aDR_STREET_NAME;
		ADR_FLAT = aDR_FLAT;
		ADR_FLOOR = aDR_FLOOR;
		BUILDING_NAME = bUILDING_NAME;
		ADR_SOI = aDR_SOI;
		ADR_MOO = aDR_MOO;
		ADR_HOUSE_NO = aDR_HOUSE_NO;
		ADR_ZIP = aDR_ZIP;
		LANGUAGE_ID = lANGUAGE_ID;
	}
	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}
	public String getLINK_SEQ_NO() {
		return LINK_SEQ_NO;
	}
	public void setLINK_SEQ_NO(String lINK_SEQ_NO) {
		LINK_SEQ_NO = lINK_SEQ_NO;
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
	public String getLINK_TYPE() {
		return LINK_TYPE;
	}
	public void setLINK_TYPE(String lINK_TYPE) {
		LINK_TYPE = lINK_TYPE;
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
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}
	public String getLAST_NAME() {
		return LAST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}
	public String getNAME_TITLE() {
		return NAME_TITLE;
	}
	public void setNAME_TITLE(String nAME_TITLE) {
		NAME_TITLE = nAME_TITLE;
	}
	public String getNAME_TITLE_REF() {
		return NAME_TITLE_REF;
	}
	public void setNAME_TITLE_REF(String nAME_TITLE_REF) {
		NAME_TITLE_REF = nAME_TITLE_REF;
	}
	public String getADR_CITY() {
		return ADR_CITY;
	}
	public void setADR_CITY(String aDR_CITY) {
		ADR_CITY = aDR_CITY;
	}
	public String getADR_CITY_REF() {
		return ADR_CITY_REF;
	}
	public void setADR_CITY_REF(String aDR_CITY_REF) {
		ADR_CITY_REF = aDR_CITY_REF;
	}
	public String getADR_SUBURB() {
		return ADR_SUBURB;
	}
	public void setADR_SUBURB(String aDR_SUBURB) {
		ADR_SUBURB = aDR_SUBURB;
	}
	public String getADR_SUBURB_REF() {
		return ADR_SUBURB_REF;
	}
	public void setADR_SUBURB_REF(String aDR_SUBURB_REF) {
		ADR_SUBURB_REF = aDR_SUBURB_REF;
	}
	public String getADR_KHWANG() {
		return ADR_KHWANG;
	}
	public void setADR_KHWANG(String aDR_KHWANG) {
		ADR_KHWANG = aDR_KHWANG;
	}
	public String getADR_KHWANG_REF() {
		return ADR_KHWANG_REF;
	}
	public void setADR_KHWANG_REF(String aDR_KHWANG_REF) {
		ADR_KHWANG_REF = aDR_KHWANG_REF;
	}
	public String getADR_STREET_NAME() {
		return ADR_STREET_NAME;
	}
	public void setADR_STREET_NAME(String aDR_STREET_NAME) {
		ADR_STREET_NAME = aDR_STREET_NAME;
	}
	public String getADR_FLAT() {
		return ADR_FLAT;
	}
	public void setADR_FLAT(String aDR_FLAT) {
		ADR_FLAT = aDR_FLAT;
	}
	public String getADR_FLOOR() {
		return ADR_FLOOR;
	}
	public void setADR_FLOOR(String aDR_FLOOR) {
		ADR_FLOOR = aDR_FLOOR;
	}
	public String getBUILDING_NAME() {
		return BUILDING_NAME;
	}
	public void setBUILDING_NAME(String bUILDING_NAME) {
		BUILDING_NAME = bUILDING_NAME;
	}
	public String getADR_SOI() {
		return ADR_SOI;
	}
	public void setADR_SOI(String aDR_SOI) {
		ADR_SOI = aDR_SOI;
	}
	public String getADR_MOO() {
		return ADR_MOO;
	}
	public void setADR_MOO(String aDR_MOO) {
		ADR_MOO = aDR_MOO;
	}
	public String getADR_HOUSE_NO() {
		return ADR_HOUSE_NO;
	}
	public void setADR_HOUSE_NO(String aDR_HOUSE_NO) {
		ADR_HOUSE_NO = aDR_HOUSE_NO;
	}
	public String getADR_ZIP() {
		return ADR_ZIP;
	}
	public void setADR_ZIP(String aDR_ZIP) {
		ADR_ZIP = aDR_ZIP;
	}
	public String getLANGUAGE_ID() {
		return LANGUAGE_ID;
	}
	public void setLANGUAGE_ID(String lANGUAGE_ID) {
		LANGUAGE_ID = lANGUAGE_ID;
	}
	
}
