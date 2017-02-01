package tot.bill.table;

public class TAX_RATE {
	private String TAX_CODE;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String TAX_RATE;
	public TAX_RATE(String tAX_CODE, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String tAX_RATE) {
		super();
		TAX_CODE = tAX_CODE;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		TAX_RATE = tAX_RATE;
	}
	public String getTAX_CODE() {
		return TAX_CODE;
	}
	public void setTAX_CODE(String tAX_CODE) {
		TAX_CODE = tAX_CODE;
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
	public String getTAX_RATE() {
		return TAX_RATE;
	}
	public void setTAX_RATE(String tAX_RATE) {
		TAX_RATE = tAX_RATE;
	}
	
	

}
