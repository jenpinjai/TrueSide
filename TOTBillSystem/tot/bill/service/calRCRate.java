package tot.bill.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class calRCRate {
	public static double calProRate (String startDate,String endDate,String startBillDate,String endBillDate,double rate,int rateQty){
		CalculateDate call = new CalculateDate();
		//int diffDay=call.findDiffDate(startDate,endDate, null );
		//int billDay=call.findDiffDate(startBillDate,endBillDate, null );
		int diffDay=0;
		int billDay=0;
		System.out.println("startDate="+startDate);
		System.out.println("endDate="+endDate);
		System.out.println("Bill Cycle Start="+startBillDate);
		System.out.println("Bill Cycle End="+endBillDate);
		
		System.out.println("rate="+rate);
		System.out.println("rate QTY="+rateQty);

		if(startDate.substring(0, 6).equals(endDate.substring(0, 6))){
			// proRate in month
			diffDay=call.findDiffDate(startDate,endDate, null );
			System.out.println("diff day="+diffDay);
			billDay=call.findDiffDate(startDate.substring(0, 6)+"01",getEndOfMonth(startDate), null );
			System.out.println("bill day="+billDay);
			return (diffDay*rate*rateQty)/billDay;
		}else{
			diffDay=call.findDiffDate(startDate,getEndOfMonth(startDate), null );
			System.out.println("diff day first="+diffDay);
			billDay=call.findDiffDate(startDate.substring(0, 6)+"01",getEndOfMonth(startDate), null );
			System.out.println("bill day first="+billDay);
			double rateFirst=(diffDay*rate*rateQty)/billDay;
			System.out.println("Rate first="+rateFirst);
			
			
			diffDay=call.findDiffDate(endDate.substring(0, 6)+"01",endDate, null );
			System.out.println("diff day last="+diffDay);
			billDay=call.findDiffDate(endDate.substring(0, 6)+"01",getEndOfMonth(endDate), null );
			System.out.println("bill day last="+billDay);
			double ratelast=(diffDay*rate*rateQty)/billDay;
			System.out.println("Rate last="+ratelast);
			
			return rateFirst+ratelast;
		}
		
		
	//	return 0;
		
	}
	public static double calRateNormal (double rate,int rateQty){
		return rate*rateQty;
	}
	private static String getEndOfMonth(String date) {
		String lastDayOfTheMonth = "";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        try{
        java.util.Date dt= formatter.parse(date);
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(dt);  

        calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        calendar.add(Calendar.DATE, -1);  

        java.util.Date lastDay = calendar.getTime();  

        lastDayOfTheMonth = formatter.format(lastDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return lastDayOfTheMonth;
		
	}

}
