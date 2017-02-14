package tot.bill.afp;

import java.io.IOException;

import org.afplib.afplib.PTX;
import org.afplib.io.AfpOutputStream;


public class SetGnValue {
	
	public static int setGNofMCF(AfpOutputStream aout)throws  IOException {
		String[] FQName = new String[]{"X0TTABD0","X0TTAB80","X0TTAB00","X0TTABB0","X0TTCB00","X0TTCBD0","X0TTCBF0","X0TTCBH0","X0TTCBB0","X0BC05  ","X0C128B0"};	
		int[] FQNFormat= new int[]{0,0,0,0,0,0,0,0,0,0,0};
		int[] FQNType= new int[]{142,142,142,142,142,142,142,142,142,142,142};
		int[] ResLID= new int[]{60,57,58,59,78,80,81,82,79,28,36};
		int[] ResType= new int[]{5,5,5,5,5,5,5,5,5,5,5};
		afpCreateTag.createTagMCF(aout,FQName,FQNFormat,FQNType,ResLID,ResType);
        return 0;
    }
	public static int setGNofBAG(AfpOutputStream aout)throws  IOException {
		afpCreateTag.createTagBAG(aout);
		
		setGNofMCF(aout);

		String[] PsegName = new String[]{"S1BLLTR1","S1SPACE1","S1TRAD01","S1SLPTR1"};
		afpCreateTag.createTagMPS(aout,PsegName );
		afpCreateTag.createTagPGD(aout,6000,6000,5100,7015);
		afpCreateTag.createTagPTD1(aout,6000,6000,5100,7015,0);
		
		afpCreateTag.createTagEAG(aout);
        return 0;
    }
	public static int setGrayArea(AfpOutputStream aout)throws  IOException {
		afpCreateTag.createTagBII(aout,"IMLS    ");
		byte[] ConData2=new byte[] {(byte)0xFF,(byte)0xFF};
		afpCreateTag.createTagIOC(aout,3297,1700,0,11520,1000,1000,ConData2);
		byte[] ConData1 = new byte[] {(byte)0x00,(byte)0x00,(byte)0x09,(byte)0x60,(byte)0x09,
                (byte)0x60,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00};
        ConData2 = new byte[] {(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x2d,
                (byte)0x00};
        byte[] ConData3 = new byte[] {(byte)0x00,(byte)0x01};
		afpCreateTag.createTagIID(aout,6000,6000,1,1,1,1,ConData1,ConData2,ConData3);
		afpCreateTag.createTagICP(aout,32,8,1410,460);
		byte[] IMdata = new byte[] {(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x26,
                (byte)0x26,(byte)0x26,(byte)0x26,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
                ,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
                ,(byte)0x62,(byte)0x62,(byte)0x62,(byte)0x62
                ,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
        };
		afpCreateTag.createTagIRD(aout,IMdata);
		afpCreateTag.createTagEII(aout,"IMLS    ");
        return 0;
    }
    	public static int setGovernorGrayArea(AfpOutputStream aout,int px ,int py)throws  IOException {
		afpCreateTag.createTagBII(aout,"IMLS    ");
		byte[] ConData2=new byte[] {(byte)0xFF,(byte)0xFF};
		afpCreateTag.createTagIOC(aout,px,py,0,11520,1000,1000,ConData2);
		byte[] ConData1 = new byte[] {(byte)0x00,(byte)0x00,(byte)0x09,(byte)0x60,(byte)0x09,
                (byte)0x60,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00};
        ConData2 = new byte[] {(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x2d,
                (byte)0x00};
        byte[] ConData3 = new byte[] {(byte)0x00,(byte)0x01};
		afpCreateTag.createTagIID(aout,6000,6000,2,2,1,1,ConData1,ConData2,ConData3);
		afpCreateTag.createTagICP(aout,32,8,2100,100);
		byte[] IMdata = new byte[] {(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x26,
                (byte)0x26,(byte)0x26,(byte)0x26,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
                ,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
                ,(byte)0x62,(byte)0x62,(byte)0x62,(byte)0x62
                ,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
        };
		afpCreateTag.createTagIRD(aout,IMdata);
		afpCreateTag.createTagEII(aout,"IMLS    ");
        return 0;
    }    
	public static int CalPointFont59(PTX ptx,String[] f5,int f5_x,int f5_y)throws  IOException {
		int cal_start_point=0;
		int check_minus=0;
		afpCreateTag.setFontID(ptx,59);
		for(int i=0;i<f5.length;i++){
			cal_start_point=0;
			check_minus=0;
			if(f5[i].contains("-")){
				f5[i]=f5[i].substring(1, f5[i].length());
				check_minus=1;
			}
			if(f5[i].length()==5){
				cal_start_point=cal_start_point+37;
			}else if(f5[i].length()==6){
				cal_start_point=cal_start_point+(37*2);
			}else if(f5[i].length()==8){
				cal_start_point=cal_start_point+(37*3)+14;
			}else if(f5[i].length()==9){
				cal_start_point=cal_start_point+(37*4)+14;
			}else if(f5[i].length()==10){
				cal_start_point=cal_start_point+(37*5)+14;
			}else if(f5[i].length()==12){
				cal_start_point=cal_start_point+(37*6)+(14*2);
			}else if(f5[i].length()==13){
				cal_start_point=cal_start_point+(37*7)+(14*2);
			}else if(f5[i].length()==14){
				cal_start_point=cal_start_point+(37*8)+(14*2);
			}
			
			afpCreateTag.setPTXxy(ptx,f5_x-cal_start_point,f5_y+(120*i));
			afpCreateTag.setPTX_TRN(ptx,f5[i]);
			if(check_minus==1){
				afpCreateTag.setPTXxy(ptx,f5_x-cal_start_point-23,f5_y+(120*i));
				afpCreateTag.setPTX_TRN(ptx,"-");
			}
		}
        return 0;
    }
	public static int CalPointFont79(PTX ptx,String[] f5,int f5_x,int f5_y)throws  IOException {
		int cal_start_point=0;
		int check_minus=0;
		afpCreateTag.setFontID(ptx,79);
		for(int i=0;i<f5.length;i++){
			cal_start_point=0;
			check_minus=0;
			if(f5[i].contains("-")){
				f5[i]=f5[i].substring(1, f5[i].length());
				check_minus=1;
			}
			if(f5[i].length()==5){
				cal_start_point=cal_start_point+37;
			}else if(f5[i].length()==6){
				cal_start_point=cal_start_point+(37*2);
			}else if(f5[i].length()==8){
				cal_start_point=cal_start_point+(37*3)+14;
			}else if(f5[i].length()==9){
				cal_start_point=cal_start_point+(37*4)+14;
			}else if(f5[i].length()==10){
				cal_start_point=cal_start_point+(37*5)+14;
			}else if(f5[i].length()==12){
				cal_start_point=cal_start_point+(37*6)+(14*2);
			}else if(f5[i].length()==13){
				cal_start_point=cal_start_point+(37*7)+(14*2);
			}else if(f5[i].length()==14){
				cal_start_point=cal_start_point+(37*8)+(14*2);
			}

			afpCreateTag.setPTXxy(ptx,f5_x-cal_start_point,f5_y+(120*i));
			afpCreateTag.setPTX_TRN(ptx,f5[i]);
			if(check_minus==1){
				afpCreateTag.setPTXxy(ptx,f5_x-cal_start_point-23,f5_y+(120*i));
				afpCreateTag.setPTX_TRN(ptx,"-");
			}
		}
        return 0;
    }
	public static int CalPointFont58(PTX ptx,String[] f5,int f5_x,int f5_y)throws  IOException {
		int cal_start_point=0;
		int check_minus=0;
		afpCreateTag.setFontID(ptx,58);
		for(int i=0;i<f5.length;i++){
			cal_start_point=0;
			check_minus=0;
			if(f5[i].contains("-")){
				//cal_start_point=cal_start_point+23;
				f5[i]=f5[i].substring(1, f5[i].length());
				
				check_minus=1;
			}
			if(f5[i].length()==5){
				cal_start_point=cal_start_point+30;
			}else if(f5[i].length()==6){
				cal_start_point=cal_start_point+(30*2);
			}else if(f5[i].length()==8){
				cal_start_point=cal_start_point+(30*3)+15;
			}else if(f5[i].length()==9){
				cal_start_point=cal_start_point+(30*4)+15;
			}else if(f5[i].length()==10){
				cal_start_point=cal_start_point+(30*5)+15;
			}else if(f5[i].length()==12){
				cal_start_point=cal_start_point+(30*6)+(15*2);
			}else if(f5[i].length()==13){
				cal_start_point=cal_start_point+(30*7)+(15*2);
			}else if(f5[i].length()==14){
				cal_start_point=cal_start_point+(30*8)+(15*2);
			}
			
			
			//System.out.println((f5_x-cal_start_point)+" "+(f5_y+(106*i)));
			afpCreateTag.setPTXxy(ptx,f5_x-cal_start_point,f5_y+(106*i));
			afpCreateTag.setPTX_TRN(ptx,f5[i]);
			if(check_minus==1){
				afpCreateTag.setPTXxy(ptx,f5_x-cal_start_point-23,f5_y+(106*i));
				afpCreateTag.setPTX_TRN(ptx,"-");
			}
		}
        return 0;
    }
    public static int CalPointFont58Single(PTX ptx,String number,int f5_x,int f5_y)throws  IOException {
		int cal_start_point=0;
		int check_minus=0;
		afpCreateTag.setFontID(ptx,58);
		
		 cal_start_point=0;
			check_minus=0;
			if(number.contains("-")){
				//cal_start_point=cal_start_point+23;
				number=number.substring(1, number.length());
				
				check_minus=1;
			}
			if(number.length()==5){
				cal_start_point=cal_start_point+30;
			}else if(number.length()==6){
				cal_start_point=cal_start_point+(30*2);
			}else if(number.length()==8){
				cal_start_point=cal_start_point+(30*3)+15;
			}else if(number.length()==9){
				cal_start_point=cal_start_point+(30*4)+15;
			}else if(number.length()==10){
				cal_start_point=cal_start_point+(30*5)+15;
			}else if(number.length()==12){
				cal_start_point=cal_start_point+(30*6)+(15*2);
			}else if(number.length()==13){
				cal_start_point=cal_start_point+(30*7)+(15*2);
			}else if(number.length()==14){
				cal_start_point=cal_start_point+(30*8)+(15*2);
			}
			
			
			//System.out.println((f5_x-cal_start_point)+" "+(f5_y+(106*i)));
			afpCreateTag.setPTXxy(ptx,f5_x-cal_start_point,f5_y);
			afpCreateTag.setPTX_TRN(ptx,number);
			if(check_minus==1){
				afpCreateTag.setPTXxy(ptx,f5_x-cal_start_point-23,f5_y);
				afpCreateTag.setPTX_TRN(ptx,"-");
			}
		
        return 0;
    }
	

}
