package tot.bill.model;

import java.util.ArrayList;

import tot.bill.table.BANK;
import tot.bill.table.NAME_ADDRESS_INFO;

public class CreateNameAddress4 {
	private String NAME;
	private String ADDRESS1;
	private String ADDRESS2;
	private String ADDRESS3;
	private String ADDRESS4;
	public CreateNameAddress4(String nAME, String aDDRESS1, String aDDRESS2,
			String aDDRESS3, String aDDRESS4) {
		super();
		NAME = nAME;
		ADDRESS1 = aDDRESS1;
		ADDRESS2 = aDDRESS2;
		ADDRESS3 = aDDRESS3;
		ADDRESS4 = aDDRESS4;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getADDRESS1() {
		return ADDRESS1;
	}
	public void setADDRESS1(String aDDRESS1) {
		ADDRESS1 = aDDRESS1;
	}
	public String getADDRESS2() {
		return ADDRESS2;
	}
	public void setADDRESS2(String aDDRESS2) {
		ADDRESS2 = aDDRESS2;
	}
	public String getADDRESS3() {
		return ADDRESS3;
	}
	public void setADDRESS3(String aDDRESS3) {
		ADDRESS3 = aDDRESS3;
	}
	public String getADDRESS4() {
		return ADDRESS4;
	}
	public void setADDRESS4(String aDDRESS4) {
		ADDRESS4 = aDDRESS4;
	}
	
	public static int addNameAddress(CreateNameAddress4 stNameAddress4,NAME_ADDRESS_INFO stNAME_ADDRESS_INFO){
		String FIRST_NAME="";
		String LAST_NAME="";
		String NAME_TITLE="";	
		String ADR_CITY="";		
		String ADR_SUBURB="";		
		String ADR_KHWANG="";		
		String ADR_STREET_NAME="";
		String ADR_FLAT="";
		String ADR_FLOOR="";
		String BUILDING_NAME=""; 
		String ADR_SOI="";
		String ADR_MOO="";
		String ADR_HOUSE_NO="";
		String ADR_ZIP="";
 
		//line name
		if(stNAME_ADDRESS_INFO.getNAME_TITLE()!=null){
			NAME_TITLE=stNAME_ADDRESS_INFO.getNAME_TITLE();
		}else{
			NAME_TITLE="คุณ";
		}
		
		if(stNAME_ADDRESS_INFO.getFIRST_NAME()!=null){
			FIRST_NAME=stNAME_ADDRESS_INFO.getFIRST_NAME();
		}else{
			FIRST_NAME="";
		}
		
		if(stNAME_ADDRESS_INFO.getLAST_NAME()!=null){
			LAST_NAME=stNAME_ADDRESS_INFO.getLAST_NAME();
		}else{
			LAST_NAME="";
		}
		stNameAddress4.setNAME(NAME_TITLE+" "+
				   FIRST_NAME+" "+
				   LAST_NAME+" "
				   );
		//line address 1
		if(stNAME_ADDRESS_INFO.getADR_HOUSE_NO()!=null){
			ADR_HOUSE_NO=stNAME_ADDRESS_INFO.getADR_HOUSE_NO();
		}else{
			ADR_HOUSE_NO="-";
		}
		
		if(stNAME_ADDRESS_INFO.getADR_MOO()!=null){
			ADR_MOO=stNAME_ADDRESS_INFO.getADR_MOO();
		}else{
			ADR_MOO="-";
		}
		
		if(stNAME_ADDRESS_INFO.getADR_SOI()!=null){
			ADR_SOI=stNAME_ADDRESS_INFO.getADR_SOI();
		}else{
			ADR_SOI="-";
		}
		
		stNameAddress4.setADDRESS1(ADR_HOUSE_NO+" หมู่ "+
					ADR_MOO+" ซอย "+ADR_SOI
					);
		
		//line address 2
		if(stNAME_ADDRESS_INFO.getBUILDING_NAME()!=null){
			BUILDING_NAME=stNAME_ADDRESS_INFO.getBUILDING_NAME();
		}else{
			BUILDING_NAME="-";
		}
		if(stNAME_ADDRESS_INFO.getADR_FLOOR()!=null){
			ADR_FLOOR=stNAME_ADDRESS_INFO.getADR_FLOOR();
		}else{
			ADR_FLOOR="-";
		}
		if(stNAME_ADDRESS_INFO.getADR_FLAT()!=null){
			ADR_FLAT=stNAME_ADDRESS_INFO.getADR_FLAT();
		}else{
			ADR_FLAT="-";
		}
		if(stNAME_ADDRESS_INFO.getADR_STREET_NAME()!=null){
			ADR_STREET_NAME=stNAME_ADDRESS_INFO.getADR_STREET_NAME();
		}else{
			ADR_STREET_NAME="-";
		}
		
		stNameAddress4.setADDRESS2("หมู่บ้าน/อาคาร "+BUILDING_NAME+" ชั้น "+ADR_FLOOR+
					" ห้อง "+ADR_FLAT+" ถนน "+ADR_STREET_NAME				
					);
		
		//line address 3
		if(stNAME_ADDRESS_INFO.getADR_KHWANG()!=null){
			ADR_KHWANG=stNAME_ADDRESS_INFO.getADR_KHWANG();
		}else{
			ADR_KHWANG="-";
		}
		if(stNAME_ADDRESS_INFO.getADR_SUBURB()!=null){
			ADR_SUBURB=stNAME_ADDRESS_INFO.getADR_SUBURB();
		}else{
			ADR_SUBURB="-";
		}
		stNameAddress4.setADDRESS3("แขวง/ตำบล"+ADR_KHWANG+" เขต/อำเภอ "+ADR_SUBURB);
		
		//line address 4
		if(stNAME_ADDRESS_INFO.getADR_CITY()!=null){
			ADR_CITY=stNAME_ADDRESS_INFO.getADR_CITY();
		}else{
			ADR_CITY="-";
		}
		if(stNAME_ADDRESS_INFO.getADR_ZIP()!=null){
			ADR_ZIP=stNAME_ADDRESS_INFO.getADR_ZIP();
		}else{
			ADR_ZIP="-";
		}
		stNameAddress4.setADDRESS4(ADR_CITY+","+ADR_ZIP);
		
		return 0;
		
	}
	
}
