package mig.process;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import tot.bill.table.*;
import tot.bill.process.*;

public class CallCreateCharge {

	
	public static void main(String[] args) throws SQLException, IOException {
		
		
		ArrayList<CHARGE> stCHARGE=new ArrayList<CHARGE>();   
		stCHARGE.add(new CHARGE("111111111111", null, null, "20161229105342",
				null, "1", "2016", "11", "A", "026426945",
				"20161130", "DBT", "N","POTBAS","RPSTN ","R",
				null, "A", null, null, null, null, null, null, null));
		
		
		tot.bill.process.CreateCharge.CreateCharge(stCHARGE);
		
		System.out.println("End");

	}

}
