package truecorp.prm.resource;

public class setEnv {
	//windoes
	/*
	//RC Process	 
		public static String ErrPathRc="D:\\AFP_OUT\\RC_RATING\\Error\\";	
		public static String folderErrRC="\\";	
	//Discount Process
		public static String ErrPathDc="D:\\AFP_OUT\\DISCOUNT\\Error\\";	
		public static String folderErrDc="\\";
	// ExtractAccountList
		public static String homeBK="D:\\AFP_OUT\\ExtractAccountList\\BackUp\\";	
		public static String folderErrEAL="\\";
	// ExtractBillPrintInfo
		public static String BillPrintInfo_file_gen="D:\\AFP_OUT\\BillPrintInfo\\";	
		public static String folderBillPrintInfo_file_gen="\\";
	// ExtractCharge
		public static String Charge_file_gen="D:\\AFP_OUT\\Charge\\";	
		public static String folderCharge_file_gen="\\";
	
	// AFP OUT Regular
		public static String AFP_Regular_file_gen="D:\\AFP_OUT\\AFP\\Regular\\";	
		public static String folderAFP_Regular_file_gen="\\";	
	
		public static String AFP_Config_file="D:\\AFP_OUT\\AFP\\ConfigAFP.txt";
		
		public static String homePath="D:\\AFP_OUT\\";
	*/
	//linux
	
	//RC Process	
	public static String ErrPathRc=System.getenv("HOME")+"/var/tea/RC_RATING/Error/";
	public static String folderErrRC="/";
	
	//Discount Process	
	public static String ErrPathDc=System.getenv("HOME")+"/var/tea/DISCOUNT/Error/";
	public static String folderErrDc="/";
	
	// ExtractAccountList	
	public static String homeBK=System.getenv("HOME")+"/var/tea/ExtractAccountList/BackUp/";
	public static String folderErrEAL="/";
	
	// ExtractBillPrintInfo
	public static String BillPrintInfo_file_gen=System.getenv("HOME")+"/var/tea/BillPrintInfo/";
	public static String folderBillPrintInfo_file_gen="/"; 
	
	// ExtractCharge
	public static String Charge_file_gen=System.getenv("HOME")+"/var/tea/Charge/";
	public static String folderCharge_file_gen="/"; 
        
        //ExtractUsage
        public static String Usage_file_gen=System.getenv("HOME")+"/var/tea/Usage/";
	public static String folderUsage_file_gen="/"; 
	
	// AFP OUT Regular
	public static String AFP_Regular_file_gen=System.getenv("HOME")+"/var/tea/AFP/Regular/";
	public static String folderAFP_Regular_file_gen="/"; 
        
        // AFP OUT Governor
	public static String AFP_Governor_file_gen=System.getenv("HOME")+"/var/tea/AFP/Governor/";
	public static String folderAFP_Governor_file_gen="/"; 
        
        // AFP OUT Governor
	public static String AFP_Letter_file_gen=System.getenv("HOME")+"/var/tea/AFP/Letter/";
	public static String folderAFP_Letter_file_gen="/"; 
        
        // EXCEL IN Bill_QA
	public static String EXCEL_BILL_QA_file_INPUT=System.getenv("HOME")+"/var/tea/BillQAWeb/input";
        public static String EXCEL_BILL_QA_file_OUTPUT=System.getenv("HOME")+"/var/tea/BillQAWeb/output";
        public static String folderEXEL_BILL_QA_file_input="/"; 
        
        
        // EXCEL IN Bill_QA
	public static String EXCEL_RATESHEET_file_INPUT=System.getenv("HOME")+"/var/tea/AUTO_RATESHEET";
        public static String EXCEL_RATESHEET_OUTPUT=System.getenv("HOME")+"/var/tea/AUTO_RATESHEET/BK_SHEET";
        public static String folderRATESHEET_file_input="/"; 
        
	public static String AFP_Config_file=System.getenv("HOME")+"/var/tea/AFP/ConfigAFP.txt";
	
	public static String homePath=System.getenv("HOME")+"/";
	
	
	
}
