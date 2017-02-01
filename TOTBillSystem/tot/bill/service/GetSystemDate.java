package tot.bill.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class GetSystemDate {
	public static java.sql.Date getDateTime(){
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.ENGLISH);
			Calendar cal = Calendar.getInstance();
			//System.out.println(dateFormat.format(cal.getTime()));
			String sysDateTime=dateFormat.format(cal.getTime());
			Date d1 = dateFormat.parse(sysDateTime);
			java.sql.Date sysDate = new java.sql.Date(d1.getTime());
			return sysDate;
			
		} catch (Exception e) {
		}
		return null;
	}
	
	public static java.sql.Date getDate(){
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd",Locale.ENGLISH);
			Calendar cal = Calendar.getInstance();
			//System.out.println(dateFormat.format(cal.getTime()));
			String sysDateTime=dateFormat.format(cal.getTime());
			Date d1 = dateFormat.parse(sysDateTime);
			java.sql.Date sysDate = new java.sql.Date(d1.getTime());
			return sysDate;
			
		} catch (Exception e) {
		}
		return null;
	}
	
	public static java.sql.Date getDateTime(String date){
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.ENGLISH);
			Date d1 = dateFormat.parse(date);
	    	java.sql.Date sqlDate = new java.sql.Date(d1.getTime());
			return sqlDate;
			
		} catch (Exception e) {
		}
		return null;
	}

}
