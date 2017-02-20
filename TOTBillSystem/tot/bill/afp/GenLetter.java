package tot.bill.afp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.afplib.afplib.*;
import org.afplib.io.AfpOutputStream;
import java.sql.*;
import tot.bill.resources.setEnv;
import tot.bill.service.CreatePathCMY;



public class GenLetter {
	public static String getTagValue(String xml, String tagName){
	    return xml.split("<"+tagName+">")[1].split("</"+tagName+">")[0];
	}
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, FileNotFoundException, IOException{
		
		
		ArrayList<String> LETTER_CREATION_DATE = new ArrayList<String>();
		ArrayList<String> ADDRESS_BILLING1 = new ArrayList<String>();
		ArrayList<String> ADDRESS_BILLING2 = new ArrayList<String>();
		ArrayList<String> ADDRESS_BILLING3 = new ArrayList<String>();
		ArrayList<String> ADDRESS_BILLING4 = new ArrayList<String>();
		ArrayList<String> PRODUCT_ID = new ArrayList<String>();
		ArrayList<String> LAST_INVOICE_DATE = new ArrayList<String>();
		ArrayList<String> AR_BALANCE = new ArrayList<String>();
		ArrayList<String> LAST_INVOICE_DUE_DATE = new ArrayList<String>();
		ArrayList<String> LAST_PAYMENT_DATE = new ArrayList<String>();
		
		
		long startTime = System.currentTimeMillis();
		
		//Read from DB
		
		System.out.println("-------- Oracle JDBC Connection Testing ------");
        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
                System.out.println("Where is your Oracle JDBC Driver?");
                e.printStackTrace();
                return;
        }
        System.out.println("Oracle JDBC Driver Registered!");
        Connection conn = null;
        try {
//                conn = DriverManager.getConnection(
//                                "jdbc:oracle:thin:@172.19.208.69:1555:SBLDEV", "SBLAPPC",
//                                "SBLAPPC_DEV");
        		conn = DriverManager.getConnection(
                                 "jdbc:oracle:thin:@172.19.194.177:1541:PRMDEV", "prmuatapp",
                                 "prmdb#01");
                try {
                        Statement stmt = conn.createStatement();
                        ResultSet rset = null;
                        try {
                                rset = stmt.executeQuery("select VARS1 from LETTER_REQUESTS ");
                                while (rset.next()){
                                        System.out.println (rset.getString("VARS1")); 
                                        String[] arrayAddress = getTagValue(rset.getString("VARS1"), "ADDRESS_BILLING").split("\n"); 

                                        LETTER_CREATION_DATE.add(getTagValue(rset.getString("VARS1"), "LETTER_CREATION_DATE"));
                        				ADDRESS_BILLING1.add(arrayAddress[0]);
                        				ADDRESS_BILLING2.add(arrayAddress[1]);
                        				ADDRESS_BILLING3.add(arrayAddress[2]);
                        				ADDRESS_BILLING4.add(arrayAddress[3]);
                        				PRODUCT_ID.add(getTagValue(rset.getString("VARS1"), "PRODUCT_ID"));
                        				LAST_INVOICE_DATE.add(getTagValue(rset.getString("VARS1"), "LAST_INVOICE_DATE"));
                        				AR_BALANCE.add(getTagValue(rset.getString("VARS1"), "AR_BALANCE"));
                        				LAST_INVOICE_DUE_DATE.add(getTagValue(rset.getString("VARS1"), "LAST_INVOICE_DUE_DATE"));
                        				LAST_PAYMENT_DATE.add(getTagValue(rset.getString("VARS1"), "LAST_PAYMENT_DATE"));
                                        
                                }

                        }finally {
                                try { rset.close(); stmt.close(); } catch (Exception ignore) {}
                        }
                } finally {
                        try { conn.close(); } catch (Exception ignore) {}
                }
        } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return;
        }

        if (conn != null) {
                System.out.println("You made it, take control your database now!");
        } else {
        	System.out.println("Failed to make connection!");
        }
		
        
       
       
        
		
		
		// Read from file
		
		/*
		FileReader inputFile=new FileReader("D:\\AFP_OUT\\letter.txt");
		try (BufferedReader br = new BufferedReader(inputFile)) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] array = line.split("\\|"); 
		    	LETTER_CREATION_DATE.add(array[0]);
				ADDRESS_BILLING1.add(array[1]);
				ADDRESS_BILLING2.add(array[2]);
				ADDRESS_BILLING3.add(array[3]);
				ADDRESS_BILLING4.add(array[4]);
				PRODUCT_ID.add(array[5]);
				LAST_INVOICE_DATE.add(array[6]);
				AR_BALANCE.add(array[7]);
				LAST_INVOICE_DUE_DATE.add(array[8]);
				LAST_PAYMENT_DATE.add(array[9]);
		    	
		    }
		}finally {
		    inputFile.close();
		}
		*/
		System.out.println("Start Gen AFP");
		String outputFile="Letter.afp";
                String letterFolderPath = setEnv.AFP_Letter_file_gen;
                String PathOutputBillPrintInfo=letterFolderPath+outputFile;
                
                File letterFolder = new File(letterFolderPath);
                if(!letterFolder.isDirectory()){
                
                        letterFolder.mkdir();
                }
                
                
		try (AfpOutputStream aout = new AfpOutputStream(new FileOutputStream(PathOutputBillPrintInfo))) {
			
			
			
			//Start Header=============================================
			afpCreateTag.createTagBDT(aout);
			afpCreateTag.createTagIMM(aout,"F20101PA");
			//End Header
			//=========================================================
			
			
			for(int countDoc=0;countDoc<LETTER_CREATION_DATE.size();countDoc++){
			
			//Start Doc
			afpCreateTag.createTagBPG(aout);
			SetGnValue.setGNofBAG(aout);			
			//afpCreateTag.createTagIPS(aout,355,212,"S1BLLTR1");
			afpCreateTag.createTagBPT(aout);
			PTX ptx = AfplibFactory.eINSTANCE.createPTX(); 
			
			afpCreateTag.setPTXxy(ptx,2940,728);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"วันที่ "+LETTER_CREATION_DATE.get(countDoc));
			
			String[] f1=new String[]{ADDRESS_BILLING1.get(countDoc),ADDRESS_BILLING2.get(countDoc),ADDRESS_BILLING3.get(countDoc),
					ADDRESS_BILLING4.get(countDoc)};
			int f1_x=630;
			int f1_y=1027;
			afpCreateTag.setFontID(ptx,59);
			for(int i=0;i<f1.length;i++){
				afpCreateTag.setPTXxy(ptx,f1_x,f1_y+(120*i));				
				afpCreateTag.setPTX_TRN(ptx,f1[i]);
			}
			
			afpCreateTag.setPTXxy(ptx,2290,1930);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"(เลขหมาย "+PRODUCT_ID.get(countDoc)+")");
			
			f1=new String[]{
					"เรียน		         ท่านผู้ใช้บริการโทรศัพท์ที่นับถือ",
					" ",
					"                 บริษัท ทีโอที จำกัด (มหาชน) ขอขอบคุณที่ท่านได้ใช้บริการของ บมจ. ทีโอที และมีประวัติการชำระเงินที่ดีตลอด",
					"ระยะเวลาที่ผ่านมา แต่บัดนี้ บมจ. ทีโอที ขอเรียนให้ท่านทราบว่า จากการตรวจสอบการชำระค่าบริการ หมายเลขของท่านมียอด",
					"ค้างชำระค่าบริการโทรศัพท์",
					"                 บมจ. ทีโอที จึงหวังเป็นอย่างยิ่งว่าเมื่อท่านได้รับจดหมายฉบับนี้ ท่านจะดำเนินการชำระยอดเงินดังกล่าวเต็ม",
					"จำนวนทันที โดยท่านสามารถชำระค่าบริการ ณ ศูนย์บริการลูกค้า ทีโอที ทุกแห่ง ภายใน 15 วันนับตั้งแต่วันที่ระบุในเอกสาร",
					"ฉบับนี้และเพื่อความสะดวกของท่านโปรดกรุณานำใบแจ้งหนี้ที่ค้างชำระมาด้วย เมื่อพ้นกำหนดเวลาข้างต้น ",
					"บมจ. ทีโอที จำเป็นต้องงดการให้บริการหมายเลขนี้ หากท่านไม่ดำเนินการดังกล่าว บมจ. ทีโอที จะแจ้งเลิกสัญญาต่อไป",
					"                 อนึ่ง บมจ. ทีโอที ต้องขออภัยในกรณีที่ท่านได้ชำระค่าบริการเป็นที่เรียบร้อยแล้วก่อนได้รับเอกสารฉบับนี้ และ",
					"กรุณาติดต่อศูนย์บริการลูกค้า ทีโอที หรือหมายเลขโทรศัพท์ที่ระบุในเอกสารฉบับนี้เพื่อยืนยันการชำระเงิน",
					"                 จึงเรียนมาเพื่อโปรดทราบและขอขอบคุณล่วงหน้ามา ณ โอกาสนี้",
					" ",
					"                                                                                       ขอแสดงความนับถือ",
					"                                                                                    บริษัท ทีโอที จำกัด (มหาชน)"};
			f1_x=630;
			f1_y=2140;
			afpCreateTag.setFontID(ptx,60);
			for(int i=0;i<f1.length;i++){
				afpCreateTag.setPTXxy(ptx,f1_x,f1_y+(140*i));				
				afpCreateTag.setPTX_TRN(ptx,f1[i]);
			}
                        
                        afpCreateTag.setPTXxy(ptx,f1_x+2640,f1_y+845);//Set Line spawn
                        afpCreateTag.setPTX_DrawLine(ptx, 1360, 1);//Write Underline
                        
                        afpCreateTag.setPTXxy(ptx,f1_x,f1_y+985);//Set Line spawn
                        afpCreateTag.setPTX_DrawLine(ptx, 2560, 1);//Write Underline
                        
                        int shifDown=200;
                        
                        
			
			
			afpCreateTag.setPTXxy(ptx,1635,4305+shifDown);
			afpCreateTag.setFontID(ptx,80);
			afpCreateTag.setPTX_TRN(ptx,"รายละเอียดค่าเช่าและค่าบริการโทรศัพท์ค้างชำระ");
			
                        afpCreateTag.setPTXxy(ptx,1635,4315+shifDown);//Set Line spawn
                        afpCreateTag.setPTX_DrawLine(ptx, 1710, 1);//Write Underline
                        
			afpCreateTag.setPTXxy(ptx,1020,4475+shifDown);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"ณ วันที่	                        รวมยอดค้างชำระทั้งสิ้น	                       วันที่ครบกำหนดชำระ");
			
			afpCreateTag.setPTXxy(ptx,1020,4480+shifDown);//Set Line spawn
                        afpCreateTag.setPTX_DrawLine(ptx, 210, 1);//Write Underline
                        
                        afpCreateTag.setPTXxy(ptx,1815,4480+shifDown);//Set Line spawn
                        afpCreateTag.setPTX_DrawLine(ptx, 670, 1);//Write Underline
                        
                        afpCreateTag.setPTXxy(ptx,3030,4480+shifDown);//Set Line spawn
                        afpCreateTag.setPTX_DrawLine(ptx, 600, 1);//Write Underline
			
			afpCreateTag.setPTXxy(ptx,950,4595+shifDown);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,LAST_INVOICE_DATE.get(countDoc));
			
                        
                        int shifNumCenter =0;
                        /////Cal shif center
                        String balaceAmount = String.format("%,.2f", Double.valueOf("78678678670.33"));
                        if(balaceAmount.length()>4){
                            for(int s=balaceAmount.length()-5;s>=0;s--){
                                
                                if(balaceAmount.charAt(s)==','){
                                
                                        shifNumCenter+=3;
                                }else{
                                        shifNumCenter+=20;
                                }
                            }
                        }
                        
			afpCreateTag.setPTXxy(ptx,2085-shifNumCenter,4595+shifDown);
			afpCreateTag.setFontID(ptx,59);
			//afpCreateTag.setPTX_TRN(ptx,String.format("%,.2f", Double.valueOf(AR_BALANCE.get(countDoc))));
			afpCreateTag.setPTX_TRN(ptx,balaceAmount);
                        
			afpCreateTag.setPTXxy(ptx,3170,4595+shifDown);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,LAST_INVOICE_DUE_DATE.get(countDoc));
			
			
			f1=new String[]{
					"ท่านสามารถชำระเงินพร้อมกันได้ที่ ศูนย์บริการลูกค้าของ บมจ. ทีโอที วันจันทร์ถึงศุกร์เวลา 08:00 - 17:00 น. และ วันเสาร์เวลา 09:00 - 13:00 น. หรือ ร้านทรูช็อป,",
					"ทรูเคาน์เตอร์เซอร์วิส (เทเลคอมเอเซีย เดิม) โดยไม่เสียค่าธรรมเนียมใดๆ รวดเร็วและไม่มีปัญหาตัดสาย ทุกวันไม่เว้นวันหยุดราชการ ที่ CP ทาวเวอร์สีลม, ไอทีมอลล์ รัชดา,",
					"อิมพีเรียล สำโรง, แฟชั่น ไอซ์แลนด์, ซีคอนแสควร์, เดอะมอลล์(งามวงศ์วาน,บางกะปิ,ท่าพระ,บางแค) , ฟิวเจอร์ปาร์ค รังสิต, โลตัส(แจ้งวัฒนะ,พระราม 1,ศรีนครินทร์),",
					"เซ็นทรัล(บางนา,ลาดพร้าว,ปิ่นเกล้า,พระราม 2,พระราม 3) , ยูไนเต็ดเซ็นเตอร์"};
			f1_x=630;
			f1_y=4855+shifDown;
			afpCreateTag.setFontID(ptx,58);
			for(int i=0;i<f1.length;i++){
				afpCreateTag.setPTXxy(ptx,f1_x,f1_y+(100*i));				
				afpCreateTag.setPTX_TRN(ptx,f1[i]);
			}
			
			afpCreateTag.setPTXxy(ptx,630,5320+shifDown);
			afpCreateTag.setFontID(ptx,59);
			afpCreateTag.setPTX_TRN(ptx,"หมายเหตุ");
					
			f1=new String[]{"บริษัทฯ ได้รับการชำระเงินค่าบริการโทรศัพท์ และ/หรือ บริการเสริมอื่น ครั้งล่าสุดเมื่อวันที่"+LAST_PAYMENT_DATE.get(countDoc)+"",
					"หากท่านมีข้อสงสัยประการใดสามารถติดต่อสอบถามได้ที่ โทร 0-2900-9000 ระหว่างเวลา 08:00 - 18:00  น.",
					"ทุกวันไม่เว้นวันหยุดราชการ"};
			f1_x=1000;
			f1_y=5320+shifDown;
			afpCreateTag.setFontID(ptx,59);
			for(int i=0;i<f1.length;i++){
				afpCreateTag.setPTXxy(ptx,f1_x,f1_y+(120*i));				
				afpCreateTag.setPTX_TRN(ptx,f1[i]);
			}

			afpCreateTag.setPTXxy(ptx,1000,5750+shifDown);
			afpCreateTag.setFontID(ptx,80);
			afpCreateTag.setPTX_TRN(ptx,"ขอขอบพระคุณที่ใช้บริการ บริษัท ทรู คอร์ปอเรชั่น จำกัด (มหาชน)");
			
			aout.writeStructuredField(ptx);
			afpCreateTag.createTagEPT(aout);
			
			
			afpCreateTag.createTagEPG(aout);
			//End Doc
			}
			
			
			
			//Start Tailer
			afpCreateTag.createTagEDT(aout);
			//End Tailer
		} catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("create success");
		long endTime = System.currentTimeMillis();
		
		long elapse = endTime - startTime;
		
		
		System.out.println("Time : " + elapse / 1000.0);
	}

}
