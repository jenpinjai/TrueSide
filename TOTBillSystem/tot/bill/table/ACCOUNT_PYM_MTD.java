package tot.bill.table;

public class ACCOUNT_PYM_MTD {
	private String ACCOUNT_ID;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String PYM_MTD;
	private String EFFECTIVE_DATE;
	private String EXPIRATION_DATE;
	private String DD_BANK_CR_CARD_NO;
	private String DD_ACC_NAME;
	private String BANK_CODE;
	private String WITHHOLDING_IND;
	private String WITHHOLDING_EFF_DATE;
	private String WITHHOLDING_EXP_DATE;
	private String WITHHOLDING_TAX_ID;
	public ACCOUNT_PYM_MTD(String aCCOUNT_ID, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String pYM_MTD, String eFFECTIVE_DATE,
			String eXPIRATION_DATE, String dD_BANK_CR_CARD_NO,
			String dD_ACC_NAME, String bANK_CODE, String wITHHOLDING_IND,
			String wITHHOLDING_EFF_DATE, String wITHHOLDING_EXP_DATE,
			String wITHHOLDING_TAX_ID) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		PYM_MTD = pYM_MTD;
		EFFECTIVE_DATE = eFFECTIVE_DATE;
		EXPIRATION_DATE = eXPIRATION_DATE;
		DD_BANK_CR_CARD_NO = dD_BANK_CR_CARD_NO;
		DD_ACC_NAME = dD_ACC_NAME;
		BANK_CODE = bANK_CODE;
		WITHHOLDING_IND = wITHHOLDING_IND;
		WITHHOLDING_EFF_DATE = wITHHOLDING_EFF_DATE;
		WITHHOLDING_EXP_DATE = wITHHOLDING_EXP_DATE;
		WITHHOLDING_TAX_ID = wITHHOLDING_TAX_ID;
	}
	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
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
	public String getPYM_MTD() {
		return PYM_MTD;
	}
	public void setPYM_MTD(String pYM_MTD) {
		PYM_MTD = pYM_MTD;
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
	public String getDD_BANK_CR_CARD_NO() {
		return DD_BANK_CR_CARD_NO;
	}
	public void setDD_BANK_CR_CARD_NO(String dD_BANK_CR_CARD_NO) {
		DD_BANK_CR_CARD_NO = dD_BANK_CR_CARD_NO;
	}
	public String getDD_ACC_NAME() {
		return DD_ACC_NAME;
	}
	public void setDD_ACC_NAME(String dD_ACC_NAME) {
		DD_ACC_NAME = dD_ACC_NAME;
	}
	public String getBANK_CODE() {
		return BANK_CODE;
	}
	public void setBANK_CODE(String bANK_CODE) {
		BANK_CODE = bANK_CODE;
	}
	public String getWITHHOLDING_IND() {
		return WITHHOLDING_IND;
	}
	public void setWITHHOLDING_IND(String wITHHOLDING_IND) {
		WITHHOLDING_IND = wITHHOLDING_IND;
	}
	public String getWITHHOLDING_EFF_DATE() {
		return WITHHOLDING_EFF_DATE;
	}
	public void setWITHHOLDING_EFF_DATE(String wITHHOLDING_EFF_DATE) {
		WITHHOLDING_EFF_DATE = wITHHOLDING_EFF_DATE;
	}
	public String getWITHHOLDING_EXP_DATE() {
		return WITHHOLDING_EXP_DATE;
	}
	public void setWITHHOLDING_EXP_DATE(String wITHHOLDING_EXP_DATE) {
		WITHHOLDING_EXP_DATE = wITHHOLDING_EXP_DATE;
	}
	public String getWITHHOLDING_TAX_ID() {
		return WITHHOLDING_TAX_ID;
	}
	public void setWITHHOLDING_TAX_ID(String wITHHOLDING_TAX_ID) {
		WITHHOLDING_TAX_ID = wITHHOLDING_TAX_ID;
	}




}
