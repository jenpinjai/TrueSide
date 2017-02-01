package tot.bill.service;

import java.util.ArrayList;

import tot.bill.model.SumCharge;
import tot.bill.model.SumChargeOnBill;
import tot.bill.table.TAX_RATE;

public class readCharge2mini {
	public static int readbyAccountID_SC(String account_id,ArrayList<SumChargeOnBill> stSumChargeOnBillMini,ArrayList<SumCharge> stSumCharge,ArrayList<TAX_RATE> stTAX_RATE){				
		int countpop=0;
		for(int x=0;x<stSumCharge.size();x++){
			if(stSumCharge.get(x).getACCOUNT_ID().equals(account_id)){
				for(int y=0;y<stSumChargeOnBillMini.size();y++){
					if(stSumCharge.get(x).getCATEGORY_CODE().equals(stSumChargeOnBillMini.get(y).getCATEGORY_CODE())){
						stSumChargeOnBillMini.get(y).setACCOUNT_ID(account_id);
						stSumChargeOnBillMini.get(y).setSUM_SC_ACTV_AMT(stSumCharge.get(x).getSUM_ACTV_AMT());
						stSumChargeOnBillMini.get(y).setSUM_SC_TAX_AMT(stSumCharge.get(x).getSUM_TAX_AMT());
						for(int z=0;z<stTAX_RATE.size();z++){
							if(stTAX_RATE.get(z).getTAX_CODE().equals(stSumCharge.get(x).getTAX_CODE())){
								stSumChargeOnBillMini.get(y).setTAX(stTAX_RATE.get(z).getTAX_RATE());
								stSumChargeOnBillMini.get(y).setTAX_CODE(stTAX_RATE.get(z).getTAX_CODE());
							}
						}
						countpop++;
					}
				}
			}else{
				break;
			}
		}
		for(int x=0;x<countpop;x++){
			
			stSumCharge.remove(0);
		}
		
		return 0;
	}
	public static int readbyAccountID_DC(String account_id,ArrayList<SumChargeOnBill> stSumChargeOnBillMini,ArrayList<SumCharge> stSumCharge,ArrayList<TAX_RATE> stTAX_RATE){				
		int countpop=0;
		for(int x=0;x<stSumCharge.size();x++){
			if(stSumCharge.get(x).getACCOUNT_ID().equals(account_id)){
				for(int y=0;y<stSumChargeOnBillMini.size();y++){
					if(stSumCharge.get(x).getCATEGORY_CODE().equals(stSumChargeOnBillMini.get(y).getCATEGORY_CODE())){
						stSumChargeOnBillMini.get(y).setACCOUNT_ID(account_id);
						stSumChargeOnBillMini.get(y).setSUM_DC_ACTV_AMT(stSumCharge.get(x).getSUM_ACTV_AMT());
						stSumChargeOnBillMini.get(y).setSUM_DC_TAX_AMT(stSumCharge.get(x).getSUM_TAX_AMT());
						for(int z=0;z<stTAX_RATE.size();z++){
							if(stTAX_RATE.get(z).getTAX_CODE().equals(stSumCharge.get(x).getTAX_CODE())){
								stSumChargeOnBillMini.get(y).setTAX(stTAX_RATE.get(z).getTAX_RATE());
								stSumChargeOnBillMini.get(y).setTAX_CODE(stTAX_RATE.get(z).getTAX_CODE());
							}
						}
						countpop++;
					}
				}
			}else{
				break;
			}
		}
		for(int x=0;x<countpop;x++){
			
			stSumCharge.remove(0);
		}
		return 0;
	}
	public static int addChargeOnBill(ArrayList<SumChargeOnBill> stSumChargeOnBillMini,ArrayList<SumChargeOnBill> stSumChargeOnBill){				
		for(int i=0;i<stSumChargeOnBillMini.size();i++){
			if(stSumChargeOnBillMini.get(i).getACCOUNT_ID()!=null){
				
				stSumChargeOnBill.add(new SumChargeOnBill(
						stSumChargeOnBillMini.get(i).getACCOUNT_ID(), 					
						stSumChargeOnBillMini.get(i).getCATEGORY_CODE(), 
						stSumChargeOnBillMini.get(i).getSUM_SC_ACTV_AMT(), 
						stSumChargeOnBillMini.get(i).getSUM_SC_TAX_AMT(), 
						stSumChargeOnBillMini.get(i).getSUM_DC_ACTV_AMT(), 
						stSumChargeOnBillMini.get(i).getSUM_DC_TAX_AMT() ,
						stSumChargeOnBillMini.get(i).getTAX(),
						stSumChargeOnBillMini.get(i).getTAX_CODE()
						));
			}
			stSumChargeOnBillMini.get(i).setACCOUNT_ID(null);			
			stSumChargeOnBillMini.get(i).setSUM_DC_ACTV_AMT(null);
			stSumChargeOnBillMini.get(i).setSUM_DC_TAX_AMT(null);
			stSumChargeOnBillMini.get(i).setSUM_SC_ACTV_AMT(null);
			stSumChargeOnBillMini.get(i).setSUM_SC_TAX_AMT(null);
			stSumChargeOnBillMini.get(i).setTAX(null);
			stSumChargeOnBillMini.get(i).setTAX_CODE(null);
			
			
		}
		
		
		
		return 0;
	}
}
