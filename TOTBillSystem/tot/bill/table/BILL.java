package tot.bill.table;

public class BILL {
	private String ACCOUNT_ID;
	private String CYCLE_CODE;
	private String CYCLE_MONTH;
	private String CYCLE_YEAR;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String BILL_CREATE_DATE;
	private String BILL_EXTRACT_DATE;
	private String BILL_CONFIRM_DATE;
	private String PREVIOUS_AMT;
	private String PAYMENT_AMT;
	private String CUR_CHARGE_AMT;
	private String CUR_CREDIT_AMT;
	private String CUR_DISCOUNT_AMT;
	private String CUR_RC_AMT;
	private String CUR_OC_AMT;
	private String CUR_UC_AMT;
	private String TOTAL_CHARGE_AMT;
	private String TOTAL_TAX_AMT;
	private String TOTAL_NET_AMT;
	private String TOTAL_ADJUST_AMT;
	private String TOTAL_ADJUST_TAX_AMT;
	private String TOTAL_ADJUST_NET_AMT; 
	private String OUTSTANDING_AMT; 
	private String INVOICE_NUMBER; 
	private String ACCOUNT_TYPE; 
	private String ACCOUNT_SUB_TYPE;
	private String PYM_MTD; 
	private String BANK_CODE;
	private String BANK_ACCOUNT_NO; 
	private String DUE_DATE;
	private String BILL_TYPE; 
	private String PRESENT_PRODUCT_NO; 
	private String BILL_STATUS;
	public BILL(String aCCOUNT_ID, String cYCLE_CODE, String cYCLE_MONTH,
			String cYCLE_YEAR, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String bILL_CREATE_DATE,
			String bILL_EXTRACT_DATE, String bILL_CONFIRM_DATE,
			String pREVIOUS_AMT, String pAYMENT_AMT, String cUR_CHARGE_AMT,
			String cUR_CREDIT_AMT, String cUR_DISCOUNT_AMT, String cUR_RC_AMT,
			String cUR_OC_AMT, String cUR_UC_AMT, String tOTAL_CHARGE_AMT,
			String tOTAL_TAX_AMT, String tOTAL_NET_AMT,
			String tOTAL_ADJUST_AMT, String tOTAL_ADJUST_TAX_AMT,
			String tOTAL_ADJUST_NET_AMT, String oUTSTANDING_AMT,
			String iNVOICE_NUMBER, String aCCOUNT_TYPE,
			String aCCOUNT_SUB_TYPE, String pYM_MTD, String bANK_CODE,
			String bANK_ACCOUNT_NO, String dUE_DATE, String bILL_TYPE,
			String pRESENT_PRODUCT_NO, String bILL_STATUS) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		CYCLE_CODE = cYCLE_CODE;
		CYCLE_MONTH = cYCLE_MONTH;
		CYCLE_YEAR = cYCLE_YEAR;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		BILL_CREATE_DATE = bILL_CREATE_DATE;
		BILL_EXTRACT_DATE = bILL_EXTRACT_DATE;
		BILL_CONFIRM_DATE = bILL_CONFIRM_DATE;
		PREVIOUS_AMT = pREVIOUS_AMT;
		PAYMENT_AMT = pAYMENT_AMT;
		CUR_CHARGE_AMT = cUR_CHARGE_AMT;
		CUR_CREDIT_AMT = cUR_CREDIT_AMT;
		CUR_DISCOUNT_AMT = cUR_DISCOUNT_AMT;
		CUR_RC_AMT = cUR_RC_AMT;
		CUR_OC_AMT = cUR_OC_AMT;
		CUR_UC_AMT = cUR_UC_AMT;
		TOTAL_CHARGE_AMT = tOTAL_CHARGE_AMT;
		TOTAL_TAX_AMT = tOTAL_TAX_AMT;
		TOTAL_NET_AMT = tOTAL_NET_AMT;
		TOTAL_ADJUST_AMT = tOTAL_ADJUST_AMT;
		TOTAL_ADJUST_TAX_AMT = tOTAL_ADJUST_TAX_AMT;
		TOTAL_ADJUST_NET_AMT = tOTAL_ADJUST_NET_AMT;
		OUTSTANDING_AMT = oUTSTANDING_AMT;
		INVOICE_NUMBER = iNVOICE_NUMBER;
		ACCOUNT_TYPE = aCCOUNT_TYPE;
		ACCOUNT_SUB_TYPE = aCCOUNT_SUB_TYPE;
		PYM_MTD = pYM_MTD;
		BANK_CODE = bANK_CODE;
		BANK_ACCOUNT_NO = bANK_ACCOUNT_NO;
		DUE_DATE = dUE_DATE;
		BILL_TYPE = bILL_TYPE;
		PRESENT_PRODUCT_NO = pRESENT_PRODUCT_NO;
		BILL_STATUS = bILL_STATUS;
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
	public String getCYCLE_MONTH() {
		return CYCLE_MONTH;
	}
	public void setCYCLE_MONTH(String cYCLE_MONTH) {
		CYCLE_MONTH = cYCLE_MONTH;
	}
	public String getCYCLE_YEAR() {
		return CYCLE_YEAR;
	}
	public void setCYCLE_YEAR(String cYCLE_YEAR) {
		CYCLE_YEAR = cYCLE_YEAR;
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
	public String getBILL_CREATE_DATE() {
		return BILL_CREATE_DATE;
	}
	public void setBILL_CREATE_DATE(String bILL_CREATE_DATE) {
		BILL_CREATE_DATE = bILL_CREATE_DATE;
	}
	public String getBILL_EXTRACT_DATE() {
		return BILL_EXTRACT_DATE;
	}
	public void setBILL_EXTRACT_DATE(String bILL_EXTRACT_DATE) {
		BILL_EXTRACT_DATE = bILL_EXTRACT_DATE;
	}
	public String getBILL_CONFIRM_DATE() {
		return BILL_CONFIRM_DATE;
	}
	public void setBILL_CONFIRM_DATE(String bILL_CONFIRM_DATE) {
		BILL_CONFIRM_DATE = bILL_CONFIRM_DATE;
	}
	public String getPREVIOUS_AMT() {
		return PREVIOUS_AMT;
	}
	public void setPREVIOUS_AMT(String pREVIOUS_AMT) {
		PREVIOUS_AMT = pREVIOUS_AMT;
	}
	public String getPAYMENT_AMT() {
		return PAYMENT_AMT;
	}
	public void setPAYMENT_AMT(String pAYMENT_AMT) {
		PAYMENT_AMT = pAYMENT_AMT;
	}
	public String getCUR_CHARGE_AMT() {
		return CUR_CHARGE_AMT;
	}
	public void setCUR_CHARGE_AMT(String cUR_CHARGE_AMT) {
		CUR_CHARGE_AMT = cUR_CHARGE_AMT;
	}
	public String getCUR_CREDIT_AMT() {
		return CUR_CREDIT_AMT;
	}
	public void setCUR_CREDIT_AMT(String cUR_CREDIT_AMT) {
		CUR_CREDIT_AMT = cUR_CREDIT_AMT;
	}
	public String getCUR_DISCOUNT_AMT() {
		return CUR_DISCOUNT_AMT;
	}
	public void setCUR_DISCOUNT_AMT(String cUR_DISCOUNT_AMT) {
		CUR_DISCOUNT_AMT = cUR_DISCOUNT_AMT;
	}
	public String getCUR_RC_AMT() {
		return CUR_RC_AMT;
	}
	public void setCUR_RC_AMT(String cUR_RC_AMT) {
		CUR_RC_AMT = cUR_RC_AMT;
	}
	public String getCUR_OC_AMT() {
		return CUR_OC_AMT;
	}
	public void setCUR_OC_AMT(String cUR_OC_AMT) {
		CUR_OC_AMT = cUR_OC_AMT;
	}
	public String getCUR_UC_AMT() {
		return CUR_UC_AMT;
	}
	public void setCUR_UC_AMT(String cUR_UC_AMT) {
		CUR_UC_AMT = cUR_UC_AMT;
	}
	public String getTOTAL_CHARGE_AMT() {
		return TOTAL_CHARGE_AMT;
	}
	public void setTOTAL_CHARGE_AMT(String tOTAL_CHARGE_AMT) {
		TOTAL_CHARGE_AMT = tOTAL_CHARGE_AMT;
	}
	public String getTOTAL_TAX_AMT() {
		return TOTAL_TAX_AMT;
	}
	public void setTOTAL_TAX_AMT(String tOTAL_TAX_AMT) {
		TOTAL_TAX_AMT = tOTAL_TAX_AMT;
	}
	public String getTOTAL_NET_AMT() {
		return TOTAL_NET_AMT;
	}
	public void setTOTAL_NET_AMT(String tOTAL_NET_AMT) {
		TOTAL_NET_AMT = tOTAL_NET_AMT;
	}
	public String getTOTAL_ADJUST_AMT() {
		return TOTAL_ADJUST_AMT;
	}
	public void setTOTAL_ADJUST_AMT(String tOTAL_ADJUST_AMT) {
		TOTAL_ADJUST_AMT = tOTAL_ADJUST_AMT;
	}
	public String getTOTAL_ADJUST_TAX_AMT() {
		return TOTAL_ADJUST_TAX_AMT;
	}
	public void setTOTAL_ADJUST_TAX_AMT(String tOTAL_ADJUST_TAX_AMT) {
		TOTAL_ADJUST_TAX_AMT = tOTAL_ADJUST_TAX_AMT;
	}
	public String getTOTAL_ADJUST_NET_AMT() {
		return TOTAL_ADJUST_NET_AMT;
	}
	public void setTOTAL_ADJUST_NET_AMT(String tOTAL_ADJUST_NET_AMT) {
		TOTAL_ADJUST_NET_AMT = tOTAL_ADJUST_NET_AMT;
	}
	public String getOUTSTANDING_AMT() {
		return OUTSTANDING_AMT;
	}
	public void setOUTSTANDING_AMT(String oUTSTANDING_AMT) {
		OUTSTANDING_AMT = oUTSTANDING_AMT;
	}
	public String getINVOICE_NUMBER() {
		return INVOICE_NUMBER;
	}
	public void setINVOICE_NUMBER(String iNVOICE_NUMBER) {
		INVOICE_NUMBER = iNVOICE_NUMBER;
	}
	public String getACCOUNT_TYPE() {
		return ACCOUNT_TYPE;
	}
	public void setACCOUNT_TYPE(String aCCOUNT_TYPE) {
		ACCOUNT_TYPE = aCCOUNT_TYPE;
	}
	public String getACCOUNT_SUB_TYPE() {
		return ACCOUNT_SUB_TYPE;
	}
	public void setACCOUNT_SUB_TYPE(String aCCOUNT_SUB_TYPE) {
		ACCOUNT_SUB_TYPE = aCCOUNT_SUB_TYPE;
	}
	public String getPYM_MTD() {
		return PYM_MTD;
	}
	public void setPYM_MTD(String pYM_MTD) {
		PYM_MTD = pYM_MTD;
	}
	public String getBANK_CODE() {
		return BANK_CODE;
	}
	public void setBANK_CODE(String bANK_CODE) {
		BANK_CODE = bANK_CODE;
	}
	public String getBANK_ACCOUNT_NO() {
		return BANK_ACCOUNT_NO;
	}
	public void setBANK_ACCOUNT_NO(String bANK_ACCOUNT_NO) {
		BANK_ACCOUNT_NO = bANK_ACCOUNT_NO;
	}
	public String getDUE_DATE() {
		return DUE_DATE;
	}
	public void setDUE_DATE(String dUE_DATE) {
		DUE_DATE = dUE_DATE;
	}
	public String getBILL_TYPE() {
		return BILL_TYPE;
	}
	public void setBILL_TYPE(String bILL_TYPE) {
		BILL_TYPE = bILL_TYPE;
	}
	public String getPRESENT_PRODUCT_NO() {
		return PRESENT_PRODUCT_NO;
	}
	public void setPRESENT_PRODUCT_NO(String pRESENT_PRODUCT_NO) {
		PRESENT_PRODUCT_NO = pRESENT_PRODUCT_NO;
	}
	public String getBILL_STATUS() {
		return BILL_STATUS;
	}
	public void setBILL_STATUS(String bILL_STATUS) {
		BILL_STATUS = bILL_STATUS;
	} 


}
