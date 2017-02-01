package tot.bill.table;

public class PAYMENT {
	private String ACCOUNT_ID;
	private String PYM_SEQ_NO;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String CUSTOMER_PYM_DATE;
	private String PYM_MTD;
	private String PYM_SUB_MTD;
	private String BANK_CODE;
	private String DD_BANK_CR_CARD_NO;
	private String CREDIT_CARD_NO;
	private String SOURCE_ID;
	private String PYM_GL_CODE;
	private String BILL_MONTH;
	private String PAY_POINT_NO;
	private String DCP_NO;
	private String ORIGINAL_AMOUNT;
	private String TAX_CODE;
	public PAYMENT(String aCCOUNT_ID, String pYM_SEQ_NO,
			String sYS_CREATION_DATE, String sYS_UPDATE_DATE,
			String cUSTOMER_PYM_DATE, String pYM_MTD, String pYM_SUB_MTD,
			String bANK_CODE, String dD_BANK_CR_CARD_NO, String cREDIT_CARD_NO,
			String sOURCE_ID, String pYM_GL_CODE, String bILL_MONTH,
			String pAY_POINT_NO, String dCP_NO, String oRIGINAL_AMOUNT,
			String tAX_CODE) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		PYM_SEQ_NO = pYM_SEQ_NO;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		CUSTOMER_PYM_DATE = cUSTOMER_PYM_DATE;
		PYM_MTD = pYM_MTD;
		PYM_SUB_MTD = pYM_SUB_MTD;
		BANK_CODE = bANK_CODE;
		DD_BANK_CR_CARD_NO = dD_BANK_CR_CARD_NO;
		CREDIT_CARD_NO = cREDIT_CARD_NO;
		SOURCE_ID = sOURCE_ID;
		PYM_GL_CODE = pYM_GL_CODE;
		BILL_MONTH = bILL_MONTH;
		PAY_POINT_NO = pAY_POINT_NO;
		DCP_NO = dCP_NO;
		ORIGINAL_AMOUNT = oRIGINAL_AMOUNT;
		TAX_CODE = tAX_CODE;
	}
	public String getACCOUNT_ID() {
		return ACCOUNT_ID;
	}
	public void setACCOUNT_ID(String aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}
	public String getPYM_SEQ_NO() {
		return PYM_SEQ_NO;
	}
	public void setPYM_SEQ_NO(String pYM_SEQ_NO) {
		PYM_SEQ_NO = pYM_SEQ_NO;
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
	public String getCUSTOMER_PYM_DATE() {
		return CUSTOMER_PYM_DATE;
	}
	public void setCUSTOMER_PYM_DATE(String cUSTOMER_PYM_DATE) {
		CUSTOMER_PYM_DATE = cUSTOMER_PYM_DATE;
	}
	public String getPYM_MTD() {
		return PYM_MTD;
	}
	public void setPYM_MTD(String pYM_MTD) {
		PYM_MTD = pYM_MTD;
	}
	public String getPYM_SUB_MTD() {
		return PYM_SUB_MTD;
	}
	public void setPYM_SUB_MTD(String pYM_SUB_MTD) {
		PYM_SUB_MTD = pYM_SUB_MTD;
	}
	public String getBANK_CODE() {
		return BANK_CODE;
	}
	public void setBANK_CODE(String bANK_CODE) {
		BANK_CODE = bANK_CODE;
	}
	public String getDD_BANK_CR_CARD_NO() {
		return DD_BANK_CR_CARD_NO;
	}
	public void setDD_BANK_CR_CARD_NO(String dD_BANK_CR_CARD_NO) {
		DD_BANK_CR_CARD_NO = dD_BANK_CR_CARD_NO;
	}
	public String getCREDIT_CARD_NO() {
		return CREDIT_CARD_NO;
	}
	public void setCREDIT_CARD_NO(String cREDIT_CARD_NO) {
		CREDIT_CARD_NO = cREDIT_CARD_NO;
	}
	public String getSOURCE_ID() {
		return SOURCE_ID;
	}
	public void setSOURCE_ID(String sOURCE_ID) {
		SOURCE_ID = sOURCE_ID;
	}
	public String getPYM_GL_CODE() {
		return PYM_GL_CODE;
	}
	public void setPYM_GL_CODE(String pYM_GL_CODE) {
		PYM_GL_CODE = pYM_GL_CODE;
	}
	public String getBILL_MONTH() {
		return BILL_MONTH;
	}
	public void setBILL_MONTH(String bILL_MONTH) {
		BILL_MONTH = bILL_MONTH;
	}
	public String getPAY_POINT_NO() {
		return PAY_POINT_NO;
	}
	public void setPAY_POINT_NO(String pAY_POINT_NO) {
		PAY_POINT_NO = pAY_POINT_NO;
	}
	public String getDCP_NO() {
		return DCP_NO;
	}
	public void setDCP_NO(String dCP_NO) {
		DCP_NO = dCP_NO;
	}
	public String getORIGINAL_AMOUNT() {
		return ORIGINAL_AMOUNT;
	}
	public void setORIGINAL_AMOUNT(String oRIGINAL_AMOUNT) {
		ORIGINAL_AMOUNT = oRIGINAL_AMOUNT;
	}
	public String getTAX_CODE() {
		return TAX_CODE;
	}
	public void setTAX_CODE(String tAX_CODE) {
		TAX_CODE = tAX_CODE;
	} 


}
