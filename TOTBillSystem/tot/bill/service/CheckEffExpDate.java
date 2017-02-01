package tot.bill.service;

public class CheckEffExpDate {
	public static boolean checkByBetweenDate(String startDate,String endDate,String compareDate) {
		int startDateI=0;
		int endDateI=30001231;
		int compareDateI=Integer.parseInt(compareDate);		
		
		if(startDate==null || startDate.equals("") || startDate.equals("null")){
			startDateI=0;
		}else{
			startDateI=Integer.parseInt(startDate);
		}
		
		if(endDate==null || endDate.equals("") || endDate.equals("null")){
			endDateI=30001231;
		}else{
			endDateI=Integer.parseInt(endDate);
		}
		
		
		if(startDateI<=compareDateI && compareDateI<=endDateI){
			return true;
		}else{
			return false;
		}
	
	}
	
	public static boolean checkByStartEndDate(String startDate,String endDate,String compareStartDate,String compareEndDate) {
		int startDateI=0;
		int endDateI=30001231;
		int compareStartDateI=Integer.parseInt(compareStartDate);	
		int compareEndDateI=Integer.parseInt(compareEndDate);	
		
		
		
		if(startDate==null || startDate.equals("") || startDate.equals("null")){
			startDateI=0;
		}else{
			startDateI=Integer.parseInt(startDate);
		}
		
		if(endDate==null || endDate.equals("") || endDate.equals("null")){
			endDateI=30001231;
		}else{
			endDateI=Integer.parseInt(endDate);
		}
		
		/*System.out.println("startDateI="+startDateI);
		System.out.println("endDateI="+endDateI);
		System.out.println("compareStartDateI="+compareStartDateI);
		System.out.println("compareEndDateI="+compareEndDateI);
		*/
		
		if(startDateI<=compareStartDateI && compareEndDateI<=endDateI){
			return true;
		}else{
			return false;
		}
		
		
	}
	public static void main(String[] argv) {
		System.out.println(checkByBetweenDate("20161001","20161031","20161031"));
		
		System.out.println(checkByStartEndDate(null,"20161031","20160912","20161015"));
	}    

}
