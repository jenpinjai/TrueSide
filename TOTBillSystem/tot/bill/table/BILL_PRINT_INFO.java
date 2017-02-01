package tot.bill.table;

public class BILL_PRINT_INFO {
	private String ACCOUNT_ID;
	private String CYCLE_CODE;
	private String CYCLE_YEAR;
	private String CYCLE_MONTH;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String ZIP_CODE;
	private String PYM_MTD; 
	private String BILL_TYPE;
	private String MAX_PAGE;
	private String NAME;
	private String ADDRESS1;
	private String ADDRESS2;
	private String ADDRESS3;
	private String ADDRESS4;
	private String NAME_R;
	private String ADDRESS1_R;
	private String ADDRESS2_R;
	private String ADDRESS3_R;
	private String ADDRESS4_R;
	private String PRODUCT_NO;
	private String INVOICE_NO;
	private String ACCOUNT_TYPE_DES;
	private String BILL_DATE;
	private String PREVIOUS_BALANCE;
	private String PAID_AMOUNT;
	private String POST_BILL_ADJUSTMENT;
	private String TOTAL_CURRENT_CHARGES;
	private String OUTSTANDING_BALANCE; 
	private String BANK_NAME;
	private String CREDIT_CARD_NO;
	private String DUE_DATE;
	private String BILL_EXTRACT_DATE;
	private String QA_ACCOUNT_IND;
	private String BILL_PRINT_IND;
	private String GOVERNMENT_CODE;
	private String SUB_GOV_CODE;
	private String PRINT_CATEGORY;
	public BILL_PRINT_INFO(String aCCOUNT_ID, String cYCLE_CODE,
			String cYCLE_YEAR, String cYCLE_MONTH, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String zIP_CODE, String pYM_MTD,
			String bILL_TYPE, String mAX_PAGE, String nAME, String aDDRESS1,
			String aDDRESS2, String aDDRESS3, String aDDRESS4, String nAME_R,
			String aDDRESS1_R, String aDDRESS2_R, String aDDRESS3_R,
			String aDDRESS4_R, String pRODUCT_NO, String iNVOICE_NO,
			String aCCOUNT_TYPE_DES, String bILL_DATE, String pREVIOUS_BALANCE,
			String pAID_AMOUNT, String pOST_BILL_ADJUSTMENT,
			String tOTAL_CURRENT_CHARGES, String oUTSTANDING_BALANCE,
			String bANK_NAME, String cREDIT_CARD_NO, String dUE_DATE,
			String bILL_EXTRACT_DATE, String qA_ACCOUNT_IND,
			String bILL_PRINT_IND, String gOVERNMENT_CODE, String sUB_GOV_CODE,
			String pRINT_CATEGORY) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		CYCLE_CODE = cYCLE_CODE;
		CYCLE_YEAR = cYCLE_YEAR;
		CYCLE_MONTH = cYCLE_MONTH;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		ZIP_CODE = zIP_CODE;
		PYM_MTD = pYM_MTD;
		BILL_TYPE = bILL_TYPE;
		MAX_PAGE = mAX_PAGE;
		NAME = nAME;
		ADDRESS1 = aDDRESS1;
		ADDRESS2 = aDDRESS2;
		ADDRESS3 = aDDRESS3;
		ADDRESS4 = aDDRESS4;
		NAME_R = nAME_R;
		ADDRESS1_R = aDDRESS1_R;
		ADDRESS2_R = aDDRESS2_R;
		ADDRESS3_R = aDDRESS3_R;
		ADDRESS4_R = aDDRESS4_R;
		PRODUCT_NO = pRODUCT_NO;
		INVOICE_NO = iNVOICE_NO;
		ACCOUNT_TYPE_DES = aCCOUNT_TYPE_DES;
		BILL_DATE = bILL_DATE;
		PREVIOUS_BALANCE = pREVIOUS_BALANCE;
		PAID_AMOUNT = pAID_AMOUNT;
		POST_BILL_ADJUSTMENT = pOST_BILL_ADJUSTMENT;
		TOTAL_CURRENT_CHARGES = tOTAL_CURRENT_CHARGES;
		OUTSTANDING_BALANCE = oUTSTANDING_BALANCE;
		BANK_NAME = bANK_NAME;
		CREDIT_CARD_NO = cREDIT_CARD_NO;
		DUE_DATE = dUE_DATE;
		BILL_EXTRACT_DATE = bILL_EXTRACT_DATE;
		QA_ACCOUNT_IND = qA_ACCOUNT_IND;
		BILL_PRINT_IND = bILL_PRINT_IND;
		GOVERNMENT_CODE = gOVERNMENT_CODE;
		SUB_GOV_CODE = sUB_GOV_CODE;
		PRINT_CATEGORY = pRINT_CATEGORY;
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
	public String getZIP_CODE() {
		return ZIP_CODE;
	}
	public void setZIP_CODE(String zIP_CODE) {
		ZIP_CODE = zIP_CODE;
	}
	public String getPYM_MTD() {
		return PYM_MTD;
	}
	public void setPYM_MTD(String pYM_MTD) {
		PYM_MTD = pYM_MTD;
	}
	public String getBILL_TYPE() {
		return BILL_TYPE;
	}
	public void setBILL_TYPE(String bILL_TYPE) {
		BILL_TYPE = bILL_TYPE;
	}
	public String getMAX_PAGE() {
		return MAX_PAGE;
	}
	public void setMAX_PAGE(String mAX_PAGE) {
		MAX_PAGE = mAX_PAGE;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getADDRESS1() {
		return ADDRESS1;
	}
	public void setADDRESS1(String aDDRESS1) {
		ADDRESS1 = aDDRESS1;
	}
	public String getADDRESS2() {
		return ADDRESS2;
	}
	public void setADDRESS2(String aDDRESS2) {
		ADDRESS2 = aDDRESS2;
	}
	public String getADDRESS3() {
		return ADDRESS3;
	}
	public void setADDRESS3(String aDDRESS3) {
		ADDRESS3 = aDDRESS3;
	}
	public String getADDRESS4() {
		return ADDRESS4;
	}
	public void setADDRESS4(String aDDRESS4) {
		ADDRESS4 = aDDRESS4;
	}
	public String getNAME_R() {
		return NAME_R;
	}
	public void setNAME_R(String nAME_R) {
		NAME_R = nAME_R;
	}
	public String getADDRESS1_R() {
		return ADDRESS1_R;
	}
	public void setADDRESS1_R(String aDDRESS1_R) {
		ADDRESS1_R = aDDRESS1_R;
	}
	public String getADDRESS2_R() {
		return ADDRESS2_R;
	}
	public void setADDRESS2_R(String aDDRESS2_R) {
		ADDRESS2_R = aDDRESS2_R;
	}
	public String getADDRESS3_R() {
		return ADDRESS3_R;
	}
	public void setADDRESS3_R(String aDDRESS3_R) {
		ADDRESS3_R = aDDRESS3_R;
	}
	public String getADDRESS4_R() {
		return ADDRESS4_R;
	}
	public void setADDRESS4_R(String aDDRESS4_R) {
		ADDRESS4_R = aDDRESS4_R;
	}
	public String getPRODUCT_NO() {
		return PRODUCT_NO;
	}
	public void setPRODUCT_NO(String pRODUCT_NO) {
		PRODUCT_NO = pRODUCT_NO;
	}
	public String getINVOICE_NO() {
		return INVOICE_NO;
	}
	public void setINVOICE_NO(String iNVOICE_NO) {
		INVOICE_NO = iNVOICE_NO;
	}
	public String getACCOUNT_TYPE_DES() {
		return ACCOUNT_TYPE_DES;
	}
	public void setACCOUNT_TYPE_DES(String aCCOUNT_TYPE_DES) {
		ACCOUNT_TYPE_DES = aCCOUNT_TYPE_DES;
	}
	public String getBILL_DATE() {
		return BILL_DATE;
	}
	public void setBILL_DATE(String bILL_DATE) {
		BILL_DATE = bILL_DATE;
	}
	public String getPREVIOUS_BALANCE() {
		return PREVIOUS_BALANCE;
	}
	public void setPREVIOUS_BALANCE(String pREVIOUS_BALANCE) {
		PREVIOUS_BALANCE = pREVIOUS_BALANCE;
	}
	public String getPAID_AMOUNT() {
		return PAID_AMOUNT;
	}
	public void setPAID_AMOUNT(String pAID_AMOUNT) {
		PAID_AMOUNT = pAID_AMOUNT;
	}
	public String getPOST_BILL_ADJUSTMENT() {
		return POST_BILL_ADJUSTMENT;
	}
	public void setPOST_BILL_ADJUSTMENT(String pOST_BILL_ADJUSTMENT) {
		POST_BILL_ADJUSTMENT = pOST_BILL_ADJUSTMENT;
	}
	public String getTOTAL_CURRENT_CHARGES() {
		return TOTAL_CURRENT_CHARGES;
	}
	public void setTOTAL_CURRENT_CHARGES(String tOTAL_CURRENT_CHARGES) {
		TOTAL_CURRENT_CHARGES = tOTAL_CURRENT_CHARGES;
	}
	public String getOUTSTANDING_BALANCE() {
		return OUTSTANDING_BALANCE;
	}
	public void setOUTSTANDING_BALANCE(String oUTSTANDING_BALANCE) {
		OUTSTANDING_BALANCE = oUTSTANDING_BALANCE;
	}
	public String getBANK_NAME() {
		return BANK_NAME;
	}
	public void setBANK_NAME(String bANK_NAME) {
		BANK_NAME = bANK_NAME;
	}
	public String getCREDIT_CARD_NO() {
		return CREDIT_CARD_NO;
	}
	public void setCREDIT_CARD_NO(String cREDIT_CARD_NO) {
		CREDIT_CARD_NO = cREDIT_CARD_NO;
	}
	public String getDUE_DATE() {
		return DUE_DATE;
	}
	public void setDUE_DATE(String dUE_DATE) {
		DUE_DATE = dUE_DATE;
	}
	public String getBILL_EXTRACT_DATE() {
		return BILL_EXTRACT_DATE;
	}
	public void setBILL_EXTRACT_DATE(String bILL_EXTRACT_DATE) {
		BILL_EXTRACT_DATE = bILL_EXTRACT_DATE;
	}
	public String getQA_ACCOUNT_IND() {
		return QA_ACCOUNT_IND;
	}
	public void setQA_ACCOUNT_IND(String qA_ACCOUNT_IND) {
		QA_ACCOUNT_IND = qA_ACCOUNT_IND;
	}
	public String getBILL_PRINT_IND() {
		return BILL_PRINT_IND;
	}
	public void setBILL_PRINT_IND(String bILL_PRINT_IND) {
		BILL_PRINT_IND = bILL_PRINT_IND;
	}
	public String getGOVERNMENT_CODE() {
		return GOVERNMENT_CODE;
	}
	public void setGOVERNMENT_CODE(String gOVERNMENT_CODE) {
		GOVERNMENT_CODE = gOVERNMENT_CODE;
	}
	public String getSUB_GOV_CODE() {
		return SUB_GOV_CODE;
	}
	public void setSUB_GOV_CODE(String sUB_GOV_CODE) {
		SUB_GOV_CODE = sUB_GOV_CODE;
	}
	public String getPRINT_CATEGORY() {
		return PRINT_CATEGORY;
	}
	public void setPRINT_CATEGORY(String pRINT_CATEGORY) {
		PRINT_CATEGORY = pRINT_CATEGORY;
	}
	
	
}
