package tot.bill.service;

import tot.bill.table.ACCUM_USAGE_XX;
import tot.bill.table.DISCOUNT_RATE;
import tot.bill.table.RATED_RC;

public class DiscountFN {
	public static double findDiscountAcuu (DISCOUNT_RATE stDISCOUNT_RATE,ACCUM_USAGE_XX stACCUM_USAGE_XX) {
		
		double returnDiscount=0;
		if(stDISCOUNT_RATE.getDISCOUNT_TYPE().equals("PD")){
			System.out.println("     Discount by %  value="+stDISCOUNT_RATE.getDISCOUNT_VALUE()+",Max="+stDISCOUNT_RATE.getDISCOUNT_MAX());
			returnDiscount=Double.parseDouble(stACCUM_USAGE_XX.getCHARGE_AMT())* 
					Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_VALUE())/100;
			
			if(stDISCOUNT_RATE.getDISCOUNT_MAX()!=null && 
					returnDiscount>Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_MAX())){
				returnDiscount=Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_MAX());
			}
		}else{
			System.out.println("     Discount by cash value="+stDISCOUNT_RATE.getDISCOUNT_VALUE()+",Max="+stDISCOUNT_RATE.getDISCOUNT_MAX());
			
			if(Double.parseDouble(stACCUM_USAGE_XX.getCHARGE_AMT())>Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_VALUE())){
				returnDiscount=Double.parseDouble(stACCUM_USAGE_XX.getCHARGE_AMT())-Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_VALUE());
			}else if(Double.parseDouble(stACCUM_USAGE_XX.getCHARGE_AMT())<Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_VALUE())){
				returnDiscount=Double.parseDouble(stACCUM_USAGE_XX.getCHARGE_AMT());
			}else{
				returnDiscount=Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_VALUE());
			}
			
			
		}
		
		
		
		
		return returnDiscount;
	}
	
	public static double findDiscountAcuuAVG(DISCOUNT_RATE stDISCOUNT_RATE, ACCUM_USAGE_XX stACCUM_USAGE_XX,double sumCharge) {

		double returnDiscount = 0;
		double bas = 0;
		double disSum = 0;
		double discount = Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_VALUE());
		Double discountMax = Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_MAX());
		double charge = Double.parseDouble(stACCUM_USAGE_XX.getCHARGE_AMT());
		if (stDISCOUNT_RATE.getDISCOUNT_TYPE().equals("PD")) {
			System.out.println("     Discount by %  value=" + discount + ",Max="+ stDISCOUNT_RATE.getDISCOUNT_MAX());
			
			disSum = sumCharge * (discount / 100);
			if (discountMax != null
					&& disSum > discountMax) {
				disSum = discountMax;
			}
			bas = (charge * 100) / sumCharge;
			returnDiscount = disSum * (bas / 100);
			
		} else {
			System.out.println("     Discount by cash value="+discount+",Max="+discountMax);
			
			if( sumCharge > discount){
				bas = (charge * 100) / sumCharge;
				disSum = bas * (discount / 100);
				returnDiscount = charge - disSum;
			}else if( sumCharge < discount){
				returnDiscount = charge;
			}else{
				returnDiscount = discount;
			}
		}
		return returnDiscount;
	}

public static double findDiscountRatedRC (DISCOUNT_RATE stDISCOUNT_RATE,RATED_RC stRATED_RC) {
		
		double returnDiscount=0;
		if(stDISCOUNT_RATE.getDISCOUNT_TYPE().equals("PD")){
			System.out.println("     Discount by %  value="+stDISCOUNT_RATE.getDISCOUNT_VALUE()+",Max="+stDISCOUNT_RATE.getDISCOUNT_MAX());
			
			returnDiscount=Double.parseDouble(stRATED_RC.getCHARGE_AMT())* 
					Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_VALUE())/100;
			
			if(stDISCOUNT_RATE.getDISCOUNT_MAX()!=null && 
					returnDiscount>Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_MAX())){
				returnDiscount=Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_MAX());
			}
		}else{
			System.out.println("     Discount by cash value="+stDISCOUNT_RATE.getDISCOUNT_VALUE()+",Max="+stDISCOUNT_RATE.getDISCOUNT_MAX());
			
			
			if(Double.parseDouble(stRATED_RC.getCHARGE_AMT())>Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_VALUE())){
				returnDiscount=Double.parseDouble(stRATED_RC.getCHARGE_AMT())-Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_VALUE());
			}else if(Double.parseDouble(stRATED_RC.getCHARGE_AMT())<Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_VALUE())){
				returnDiscount=Double.parseDouble(stRATED_RC.getCHARGE_AMT());
			}else{
				returnDiscount=Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_VALUE());
			}
			
			
		}
		
		
		
		
		return returnDiscount;
	}

	public static double findDiscountRatedRCAVG(DISCOUNT_RATE stDISCOUNT_RATE, RATED_RC stRATED_RC, double sumCharge) {

		double returnDiscount = 0;
		double bas = 0;
		double disSum = 0;
		double discount = Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_VALUE());
		Double discountMax = Double.parseDouble(stDISCOUNT_RATE.getDISCOUNT_MAX());
		double charge = Double.parseDouble(stRATED_RC.getCHARGE_AMT());
		if (stDISCOUNT_RATE.getDISCOUNT_TYPE().equals("PD")) {
			System.out.println("     Discount by %  value=" + discount + ",Max="+ stDISCOUNT_RATE.getDISCOUNT_MAX());
			
			disSum = sumCharge * (discount / 100);
			if (discountMax != null
					&& disSum > discountMax) {
				disSum = discountMax;
			}
			bas = (charge * 100) / sumCharge;
			returnDiscount = disSum * (bas / 100);
			
		} else {
			System.out.println("     Discount by cash value="+discount+",Max="+discountMax);
			
			if( sumCharge > discount){
				bas = (charge * 100) / sumCharge;
				disSum = bas * (discount / 100);
				returnDiscount = charge - disSum;
			}else if( sumCharge < discount){
				returnDiscount = charge;
			}else{
				returnDiscount = discount;
			}
		}
		return returnDiscount;
	}
}
