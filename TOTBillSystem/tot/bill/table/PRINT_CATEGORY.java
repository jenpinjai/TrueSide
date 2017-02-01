package tot.bill.table;

public class PRINT_CATEGORY {
	private String PRINT_CATEGORIES;
	private String SYS_CREATION_DATE;
	private String SYS_UPDATE_DATE;
	private String PRINT_CAT_DESC;
	private String GOV_FORMAT;
	public PRINT_CATEGORY(String pRINT_CATEGORIES, String sYS_CREATION_DATE,
			String sYS_UPDATE_DATE, String pRINT_CAT_DESC, String gOV_FORMAT) {
		super();
		PRINT_CATEGORIES = pRINT_CATEGORIES;
		SYS_CREATION_DATE = sYS_CREATION_DATE;
		SYS_UPDATE_DATE = sYS_UPDATE_DATE;
		PRINT_CAT_DESC = pRINT_CAT_DESC;
		GOV_FORMAT = gOV_FORMAT;
	}
	public String getPRINT_CATEGORIES() {
		return PRINT_CATEGORIES;
	}
	public void setPRINT_CATEGORIES(String pRINT_CATEGORIES) {
		PRINT_CATEGORIES = pRINT_CATEGORIES;
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
	public String getPRINT_CAT_DESC() {
		return PRINT_CAT_DESC;
	}
	public void setPRINT_CAT_DESC(String pRINT_CAT_DESC) {
		PRINT_CAT_DESC = pRINT_CAT_DESC;
	}
	public String getGOV_FORMAT() {
		return GOV_FORMAT;
	}
	public void setGOV_FORMAT(String gOV_FORMAT) {
		GOV_FORMAT = gOV_FORMAT;
	}
	
}
