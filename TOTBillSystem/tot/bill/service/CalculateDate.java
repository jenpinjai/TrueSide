package tot.bill.service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CalculateDate {
	private final String patternDate = "yyyyMMdd";

	public int findDiffDate(String dateStart , String dateStop , String pattern){
	
		int day=0;
		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);			
			long diff = d2.getTime() - d1.getTime();			
			long diffDays = diff / (24 * 60 * 60 * 1000);

			//System.out.print(diffDays + " days, ");
			day=(int)diffDays;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return day+1;
	}
	public static void main(String args[]){
		CalculateDate call = new CalculateDate();
		int x=call.findDiffDate("20160619", "20160718", null );
		System.out.println(x);
		 x=call.findDiffDate("20161002", "20161003", null );
		System.out.println(x);
		
	}

}
