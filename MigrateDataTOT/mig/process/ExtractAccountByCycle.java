package mig.process;

import mig.oracle8i.Sql8i;
import mig.resources.Constants;

public class ExtractAccountByCycle {
//ExtractAccountByCycle_sh 1
	public static void main(String[] args) {
			System.out.println("Start ExtractAccountByCycle");
			try {
				int cycle = Integer.parseInt(args[0]);
				
				Sql8i.loadAccountCycleToFile(Constants.ExteactCyclePath, cycle);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("End ExtractAccountByCycle");
	}

}
