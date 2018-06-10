package truecorp.prm.utils;

import java.nio.charset.Charset;

public class Constants {
	public static int LEVEL_LOG = 2;
	public static final Charset UTF_8 = Charset.forName("UTF-8");
	public static String NEWLINE = System.getProperty("line.separator");
	public static String FILE_TYPE = ".AUD";
	public static String PAYMENT_INPUT_FILE_TYPE = ".comp.PY1.DAT";
	public static String DDMMYYYY = "ddMMyyyy";
	public static String YYYYMMDD = "yyyyMMdd";
	public static String YYYYMM = "yyyyMM";
	public static String SOURCE_OCTMONEY = "OCTMONEY";
	public static String SOURCE_MTMBNK = "MTMBNK";
	public static String SOURCE_TRMD = "TRMD";
	public static String SOURCE_ORQB = "ORQB";
	public static String SOURCE_MORQB = "MORQB";
	public static String SOURCE_PFT = "PFT";
	public static String DDMMYYYY_HHMISS = "ddMMyyyy_HHmmss";
        
        
        public static String INSERT_POST_PAID_SUM_CONTENT_REVENUE = "insertPostPaidSumContentRevenue";
}
