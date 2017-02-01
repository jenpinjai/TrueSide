package tot.bill.afp;

import java.util.Comparator;


class structCharge {
	private String chargeBan;
	private String chargeNumber;
	private String featureCode;
	private double chargeService;
	private double chargeDiscount;
	private double chargeAmt;
	public structCharge(String chargeBan,String chargeNumber,String featureCode,double chargeService,double chargeDiscount,double chargeAmt) {
		   this.chargeBan = chargeBan;
		   this.chargeNumber = chargeNumber;
		   this.featureCode = featureCode;
		   this.chargeService = chargeService;
		   this.chargeDiscount = chargeDiscount;
		   this.chargeAmt = chargeAmt;
	}
	public String getchargeBan() { return chargeBan; }
	public String getchargeNumber() { return chargeNumber; }
	public String getfeatureCode() { return featureCode; }
	public double getchargeService() { return chargeService; }
	public double getchargeDiscount() { return chargeDiscount; }
	public double getchargeAmt() { return chargeAmt; }
	
	public void setchargeBan(String chargeBan) { this.chargeBan = chargeBan; }
	public void setchargeNumber(String chargeNumber) { this.chargeNumber = chargeNumber; }
	public void setfeatureCode(String featureCode) { this.featureCode = featureCode; }
	public void setchargeService(double chargeService) { this.chargeService = chargeService; }
	public void setchargeDiscount(double chargeDiscount) { this.chargeDiscount = chargeDiscount; }
	public void setchargeAmt(double chargeAmt) { this.chargeAmt = chargeAmt; }

}
