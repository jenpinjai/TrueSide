package tot.bill.service;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDifferentExample {

	public static void main(String[] args) {

		String dateStart = "20200201";
		String dateStop = "20200301";

		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);			
			long diff = d2.getTime() - d1.getTime();			
			long diffDays = diff / (24 * 60 * 60 * 1000);

			System.out.print(diffDays + " days, ");
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}