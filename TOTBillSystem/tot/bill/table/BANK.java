package tot.bill.table;

public class BANK {
	private String BANK_CODE;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String BANK_DESC;
	private String COMPANY_ACC_NO;
	private String COMPANY_ACC_NAME;
	private String CREDIT_CARD_IND;
	public BANK(String bANK_CODE, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String bANK_DESC, String cOMPANY_ACC_NO,
			String cOMPANY_ACC_NAME, String cREDIT_CARD_IND) {
		super();
		BANK_CODE = bANK_CODE;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		BANK_DESC = bANK_DESC;
		COMPANY_ACC_NO = cOMPANY_ACC_NO;
		COMPANY_ACC_NAME = cOMPANY_ACC_NAME;
		CREDIT_CARD_IND = cREDIT_CARD_IND;
	}
	public String getBANK_CODE() {
		return BANK_CODE;
	}
	public void setBANK_CODE(String bANK_CODE) {
		BANK_CODE = bANK_CODE;
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
	public String getBANK_DESC() {
		return BANK_DESC;
	}
	public void setBANK_DESC(String bANK_DESC) {
		BANK_DESC = bANK_DESC;
	}
	public String getCOMPANY_ACC_NO() {
		return COMPANY_ACC_NO;
	}
	public void setCOMPANY_ACC_NO(String cOMPANY_ACC_NO) {
		COMPANY_ACC_NO = cOMPANY_ACC_NO;
	}
	public String getCOMPANY_ACC_NAME() {
		return COMPANY_ACC_NAME;
	}
	public void setCOMPANY_ACC_NAME(String cOMPANY_ACC_NAME) {
		COMPANY_ACC_NAME = cOMPANY_ACC_NAME;
	}
	public String getCREDIT_CARD_IND() {
		return CREDIT_CARD_IND;
	}
	public void setCREDIT_CARD_IND(String cREDIT_CARD_IND) {
		CREDIT_CARD_IND = cREDIT_CARD_IND;
	}
	

}
