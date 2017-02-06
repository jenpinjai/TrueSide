package tot.bill.service;

public class ChangeDateEnglishToThai {
	public static String YYYYMMDD2DDMMYYY(String inputDate){
                    String changeDate="";
                    String split_day=inputDate.substring(6, 8);
                    String split_month=inputDate.substring(4, 6);
                    String split_year=Integer.toString((Integer.parseInt(inputDate.substring(0, 4))+543));

                    changeDate=split_day+"/"+split_month+"/"+split_year;
                    return changeDate;
	}
        public static String YYYYMMDDHH24MISS2DDMMYYHH24MISS(String inputDate){
                    String changeDate="";
                    String split_day=inputDate.substring(6, 8);
                    String split_month=inputDate.substring(4, 6);
                    String split_year=Integer.toString((Integer.parseInt(inputDate.substring(0, 4))+543));

                    changeDate=split_day+"/"+split_month+"/"+split_year.substring(2, 4)+" "+inputDate.substring(8);
                    return changeDate;
	}
	
}
