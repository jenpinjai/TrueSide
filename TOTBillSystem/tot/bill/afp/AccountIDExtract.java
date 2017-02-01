package tot.bill.afp;




public class AccountIDExtract {
	private String AccountID ;
	private String MaxPage ;
	private String inputName ;
	private String ADDRESS_BILLING1 ;
	private String ADDRESS_BILLING2 ;
	private String ADDRESS_BILLING3 ;
	private String ADDRESS_BILLING4 ;
	private String PhoneNumber ;
	private String AccountNo ;
	private String InvoiceNo ;
	private String BillDate ;
	private String GroupNo ;
	
	private String PreviousBalance ;
	private String PaidAmount ;
	private String PostBillAdjustment ;
	private String TotalCurrentCharges ;
	private String OutstandingBalance ;
	private String DueDate ;
	private String BANK_NAME;
	private String CREDIT_CARD_NO;
	public AccountIDExtract(String accountID, String maxPage, String inputName,
			String aDDRESS_BILLING1, String aDDRESS_BILLING2,
			String aDDRESS_BILLING3, String aDDRESS_BILLING4,
			String phoneNumber, String accountNo, String invoiceNo,
			String billDate, String groupNo, String previousBalance,
			String paidAmount, String postBillAdjustment,
			String totalCurrentCharges, String outstandingBalance,
			String dueDate, String bANK_NAME, String cREDIT_CARD_NO) {
		super();
		AccountID = accountID;
		MaxPage = maxPage;
		this.inputName = inputName;
		ADDRESS_BILLING1 = aDDRESS_BILLING1;
		ADDRESS_BILLING2 = aDDRESS_BILLING2;
		ADDRESS_BILLING3 = aDDRESS_BILLING3;
		ADDRESS_BILLING4 = aDDRESS_BILLING4;
		PhoneNumber = phoneNumber;
		AccountNo = accountNo;
		InvoiceNo = invoiceNo;
		BillDate = billDate;
		GroupNo = groupNo;
		PreviousBalance = previousBalance;
		PaidAmount = paidAmount;
		PostBillAdjustment = postBillAdjustment;
		TotalCurrentCharges = totalCurrentCharges;
		OutstandingBalance = outstandingBalance;
		DueDate = dueDate;
		BANK_NAME = bANK_NAME;
		CREDIT_CARD_NO = cREDIT_CARD_NO;
	}
	public String getAccountID() {
		return AccountID;
	}
	public void setAccountID(String accountID) {
		AccountID = accountID;
	}
	public String getMaxPage() {
		return MaxPage;
	}
	public void setMaxPage(String maxPage) {
		MaxPage = maxPage;
	}
	public String getInputName() {
		return inputName;
	}
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	public String getADDRESS_BILLING1() {
		return ADDRESS_BILLING1;
	}
	public void setADDRESS_BILLING1(String aDDRESS_BILLING1) {
		ADDRESS_BILLING1 = aDDRESS_BILLING1;
	}
	public String getADDRESS_BILLING2() {
		return ADDRESS_BILLING2;
	}
	public void setADDRESS_BILLING2(String aDDRESS_BILLING2) {
		ADDRESS_BILLING2 = aDDRESS_BILLING2;
	}
	public String getADDRESS_BILLING3() {
		return ADDRESS_BILLING3;
	}
	public void setADDRESS_BILLING3(String aDDRESS_BILLING3) {
		ADDRESS_BILLING3 = aDDRESS_BILLING3;
	}
	public String getADDRESS_BILLING4() {
		return ADDRESS_BILLING4;
	}
	public void setADDRESS_BILLING4(String aDDRESS_BILLING4) {
		ADDRESS_BILLING4 = aDDRESS_BILLING4;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(String accountNo) {
		AccountNo = accountNo;
	}
	public String getInvoiceNo() {
		return InvoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		InvoiceNo = invoiceNo;
	}
	public String getBillDate() {
		return BillDate;
	}
	public void setBillDate(String billDate) {
		BillDate = billDate;
	}
	public String getGroupNo() {
		return GroupNo;
	}
	public void setGroupNo(String groupNo) {
		GroupNo = groupNo;
	}
	public String getPreviousBalance() {
		return PreviousBalance;
	}
	public void setPreviousBalance(String previousBalance) {
		PreviousBalance = previousBalance;
	}
	public String getPaidAmount() {
		return PaidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		PaidAmount = paidAmount;
	}
	public String getPostBillAdjustment() {
		return PostBillAdjustment;
	}
	public void setPostBillAdjustment(String postBillAdjustment) {
		PostBillAdjustment = postBillAdjustment;
	}
	public String getTotalCurrentCharges() {
		return TotalCurrentCharges;
	}
	public void setTotalCurrentCharges(String totalCurrentCharges) {
		TotalCurrentCharges = totalCurrentCharges;
	}
	public String getOutstandingBalance() {
		return OutstandingBalance;
	}
	public void setOutstandingBalance(String outstandingBalance) {
		OutstandingBalance = outstandingBalance;
	}
	public String getDueDate() {
		return DueDate;
	}
	public void setDueDate(String dueDate) {
		DueDate = dueDate;
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
	

	
}
