package tot.bill.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CreatePathCMY {
	public static int byCMY (String homePath,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR) throws IOException{
		String result = String.format("%04d%02d%02d",
				Integer.parseInt(CYCLE_YEAR), Integer.parseInt(CYCLE_MONTH), Integer.parseInt(CYCLE_CODE));				
		try {
			if (Files.isDirectory(Paths.get(homePath))) {
				System.out.println("Create PATH "+homePath+result);
				new File(homePath+result).mkdir();
			}else{
//				System.out.println("Can't create PATH");
//				return -1;
                                System.out.println("Create PATH "+homePath);
				new File(homePath).mkdir();
                                new File(homePath+result).mkdir();
			}
			
		} catch (Exception ex) {
			System.out.println("Can't create PATH");
			return -1;
	    }
		
		return 0;
	}
	public static String byCMYString (String homePath,String CYCLE_CODE,String CYCLE_MONTH,String CYCLE_YEAR) throws IOException{
		
		String result = String.format("%04d%02d%02d",
				Integer.parseInt(CYCLE_YEAR), Integer.parseInt(CYCLE_MONTH), Integer.parseInt(CYCLE_CODE));		
		
		
		
	//	System.out.println("Create PATH "+homePath+result);
		return homePath+result;
	}
	
}
