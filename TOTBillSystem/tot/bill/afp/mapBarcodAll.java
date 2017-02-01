package tot.bill.afp;


public class mapBarcodAll {
	private static char[] CodeC2CHAR = new char[256];
	static{
		CodeC2CHAR[0]='ย';
		CodeC2CHAR[1]='!';
		CodeC2CHAR[2]='"';
		CodeC2CHAR[3]='#';
		CodeC2CHAR[4]='$';
		CodeC2CHAR[5]='%';
		CodeC2CHAR[6]='&';
		CodeC2CHAR[7]='\'';
		CodeC2CHAR[8]='(';
		CodeC2CHAR[9]=')';
		CodeC2CHAR[10]='*';
		CodeC2CHAR[11]='+';
		CodeC2CHAR[12]=',';
		CodeC2CHAR[13]='-';
		CodeC2CHAR[14]='.';
		CodeC2CHAR[15]='/';
		CodeC2CHAR[16]='0';
		CodeC2CHAR[17]='1';
		CodeC2CHAR[18]='2';
		CodeC2CHAR[19]='3';
		CodeC2CHAR[20]='4';
		CodeC2CHAR[21]='5';
		CodeC2CHAR[22]='6';
		CodeC2CHAR[23]='7';
		CodeC2CHAR[24]='8';
		CodeC2CHAR[25]='9';
		CodeC2CHAR[26]=':';
		CodeC2CHAR[27]=';';
		CodeC2CHAR[28]='<';
		CodeC2CHAR[29]='=';
		CodeC2CHAR[30]='>';
		CodeC2CHAR[31]='?';
		CodeC2CHAR[32]='@';
		CodeC2CHAR[33]='A';
		CodeC2CHAR[34]='B';
		CodeC2CHAR[35]='C';
		CodeC2CHAR[36]='D';
		CodeC2CHAR[37]='E';
		CodeC2CHAR[38]='F';
		CodeC2CHAR[39]='G';
		CodeC2CHAR[40]='H';
		CodeC2CHAR[41]='I';
		CodeC2CHAR[42]='J';
		CodeC2CHAR[43]='K';
		CodeC2CHAR[44]='L';
		CodeC2CHAR[45]='M';
		CodeC2CHAR[46]='N';
		CodeC2CHAR[47]='O';
		CodeC2CHAR[48]='P';
		CodeC2CHAR[49]='Q';
		CodeC2CHAR[50]='R';
		CodeC2CHAR[51]='S';
		CodeC2CHAR[52]='T';
		CodeC2CHAR[53]='U';
		CodeC2CHAR[54]='V';
		CodeC2CHAR[55]='W';
		CodeC2CHAR[56]='X';
		CodeC2CHAR[57]='Y';
		CodeC2CHAR[58]='Z';
		CodeC2CHAR[59]='[';
		CodeC2CHAR[60]='\\';
		CodeC2CHAR[61]=']';
		CodeC2CHAR[62]='^';
		CodeC2CHAR[63]='_';
		CodeC2CHAR[64]='`';
		CodeC2CHAR[65]='a';
		CodeC2CHAR[66]='b';
		CodeC2CHAR[67]='c';
		CodeC2CHAR[68]='d';
		CodeC2CHAR[69]='e';
		CodeC2CHAR[70]='f';
		CodeC2CHAR[71]='g';
		CodeC2CHAR[72]='h';
		CodeC2CHAR[73]='i';
		CodeC2CHAR[74]='j';
		CodeC2CHAR[75]='k';
		CodeC2CHAR[76]='l';
		CodeC2CHAR[77]='m';
		CodeC2CHAR[78]='n';
		CodeC2CHAR[79]='o';
		CodeC2CHAR[80]='p';
		CodeC2CHAR[81]='q';
		CodeC2CHAR[82]='r';
		CodeC2CHAR[83]='s';
		CodeC2CHAR[84]='t';
		CodeC2CHAR[85]='u';
		CodeC2CHAR[86]='v';
		CodeC2CHAR[87]='w';
		CodeC2CHAR[88]='x';
		CodeC2CHAR[89]='y';
		CodeC2CHAR[90]='z';
		CodeC2CHAR[91]='{';
		CodeC2CHAR[92]='|';
		CodeC2CHAR[93]='}';
		CodeC2CHAR[94]='~';
		CodeC2CHAR[95]='ร';
		CodeC2CHAR[96]='ฤ';
		CodeC2CHAR[97]='ล';
		CodeC2CHAR[98]='ฦ';
		CodeC2CHAR[99]='ว';
		CodeC2CHAR[100]='ศ';
		CodeC2CHAR[101]='ษ';
		CodeC2CHAR[102]='ส';
		CodeC2CHAR[103]='ห';
		CodeC2CHAR[104]='ฬ';
		CodeC2CHAR[105]='อ';
		CodeC2CHAR[106]='ฮ';


	}
	
	public static String checkSumMap128ALL(String inputStr) {
		
		int valueMap=0;
		long checkSum=104;
		String checkSumOut="";
		for(int i=0;i<inputStr.length();i++){
			if((int)inputStr.charAt(i)<=126){
				valueMap=(int)inputStr.charAt(i)-32;
			}else{
				valueMap=(int)inputStr.charAt(i)-3524;
				if(valueMap==94){
					valueMap=0;
				}
			}
			//System.out.println(inputStr.charAt(i)+"="+valueMap+"="+(valueMap*i));
			checkSum=checkSum+(valueMap*i);
		}
		//System.out.println(checkSum);
		checkSum=checkSum%103;
		//System.out.println(checkSum);
		checkSumOut=""+CodeC2CHAR[(int)checkSum];
		//System.out.println("end="+checkSumOut);
		return checkSumOut;
	}
	public static String Map128ALL(String inputStr) {
		
		String cutInput="";
		String outputStr="";
		String regex = "\\d+";
		int arrayMap=0;
		char Startcode='C';
		while(inputStr.length()>=2){
			cutInput=inputStr.substring(0, 2);
			inputStr=inputStr.substring(2, inputStr.length());
			//System.out.print(cutInput);
			if(cutInput.matches(regex)){
				//System.out.println(" mode c");
				arrayMap = Integer.parseInt(cutInput);
				outputStr=outputStr+CodeC2CHAR[arrayMap];
				
			}else{
				if(Startcode=='C'){
					Startcode='B';
					outputStr=outputStr+"ศ";
				}
				
				//System.out.println("mode b-"+cutInput+"-"+cutInput.charAt(0)+"-"+cutInput.charAt(1)+"-");
				arrayMap=(int)cutInput.charAt(0);
				//System.out.println(arrayMap-32);
				outputStr=outputStr+CodeC2CHAR[arrayMap-32];
				arrayMap=(int)cutInput.charAt(1);
				//System.out.println(arrayMap-32);
				outputStr=outputStr+CodeC2CHAR[arrayMap-32];
				
			}
		}
		//System.out.println(inputStr.length());
		if(inputStr.length()==1){
			if(Startcode=='C'){
				Startcode='B';
				outputStr=outputStr+"ศ";
			}
			arrayMap=(int)inputStr.charAt(0);
			outputStr=outputStr+CodeC2CHAR[arrayMap-32];
		}
		
		
		//System.out.println("output="+outputStr);
		return outputStr;
	}
}
