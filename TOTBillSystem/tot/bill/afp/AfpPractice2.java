/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tot.bill.afp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import tot.bill.resources.setEnv;
import org.afplib.afplib.*;
import org.afplib.io.AfpOutputStream;
import org.apache.poi.util.StringUtil;
import tot.bill.afp.SetGnValue;
import tot.bill.afp.afpCreateTag;
/**
 *
 * @author Jennarong Pinjai
 */
public class AfpPractice2 {
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
    
        
             System.out.println("Start afp  practice.");
             System.out.println("ทดสอบ output ภาษาไทย");
             
             
             String homePath = setEnv.homePath;
             System.out.println("Get  Text files at :"+homePath);
            
            try{
             
                    FileInputStream inputStreamFile=new FileInputStream(homePath+"TextForConvert.txt");

                    BufferedReader readerFile = new BufferedReader(new InputStreamReader(inputStreamFile,"TIS620"));
                    String textLine;

                    List<String>  lines = new ArrayList<String>();

                    textLine = readerFile.readLine();
                    while(textLine!=null){


                           //System.out.println(textLine);
                           lines.add(textLine);

                            //set nextLine
                           textLine = readerFile.readLine();

                   }    

                   FileOutputStream  outStream = new FileOutputStream(homePath+"BarCodePrint.afp");
                   AfpOutputStream   afpOut    = new AfpOutputStream(outStream);

                   //////////////////////////////////////////////////////Begin doc tag
                   BDT bdt  = AfplibFactory.eINSTANCE.createBDT();
                   afpOut.writeStructuredField(bdt);
                   //////////////////////////////////////////////////////

                        //////////////////////////////////////////////////////Begin page tag
                        BPG  bpg = AfplibFactory.eINSTANCE.createBPG();
                        afpOut.writeStructuredField(bpg);
                        //////////////////////////////////////////////////////
                   
                                
                                
                                    SetGnValue.setGNofBAG(afpOut);//Active environment tag
                                    
//                                    int px=100;
//                                    int py=100;
//                                    int line_height=120;  //pixel of afp
//                                    BPT bpt = AfplibFactory.eINSTANCE.createBPT();//Begin present text tag
//                                    afpOut.writeStructuredField(bpt);
//                                    PTX ptx = AfplibFactory.eINSTANCE.createPTX();//Create present text object
////                                    for(String linePrint : lines){//Set text data from String list
////                                    
////                                            afpCreateTag.setPTXxy(ptx, px, py);
////                                            afpCreateTag.setFontID(ptx, 60);
////                                            afpCreateTag.setPTX_TRN(ptx,linePrint);
////
////                                            py+=line_height;
////                                    }
////                                    afpOut.writeStructuredField(ptx); ///Write present text object
//                                    
//                                    List<String[]> dataStringList = new ArrayList<String[]>();
//                                    
//                                    String[] textDataInput  = {"010751001016100","545400045101005","7371010171007","99991015751124","799776710778161"};
//                                    dataStringList.add(textDataInput);
//                                    String[] textDataInput2 = {"010710100161000","5445870100005","0001121011107","12341010111124","9687577101078161"};
//                                    dataStringList.add(textDataInput2);
//                                    String[] textDataInput3 = {"010754101004578","10101501087005","73775058785978","97644387555756666","666895378278161"};
//                                    dataStringList.add(textDataInput3);
//                                    String[] textDataInput4 = {"877905555016100","99961450750755","97803552871007","99995050505005","799777350505052"};
//                                    dataStringList.add(textDataInput4);
//                                    String[] textDataInput5 = {"4505050R0504505","73750558571505","99910145545124","79977070728161","465462525558161"};
//                                    dataStringList.add(textDataInput5);
//                                    String[] textDataInput6 = {"1324154557802231","54546365454555","7378868686867","99998AS5751124","465463J35827161"};
//                                    dataStringList.add(textDataInput6);
//                                    String[] textDataInput7 = {"010768686633J00","53468686631FD05","3468686668807","99994456845I454","799745I4528161"};
//                                    dataStringList.add(textDataInput7);
//                                    String[] textDataInput8 = {"014J54J45JJ6100","05050505050455","74535754554807","467888845551124","786786786786786"};
//                                    dataStringList.add(textDataInput8);
//                                    String[] textDataInput9 = {"01045J54J544440","54554544564355","73745454555407","987697335922124","35686550078161"};
//                                    dataStringList.add(textDataInput9);
//                                    String[] textDataInput10 = {"01000000000100","55555555555555","50505050050507","950505055055554","50505050505061"};
//                                    dataStringList.add(textDataInput10);
//                                    String[] textDataInput11 = {"04U46I46I6I646","56I566I6505055","75665055656507","5657896778787124","7767672727878"};
//                                    dataStringList.add(textDataInput11);
//                                    String[] textDataInput12 = {"01072234534534","45353435435335","43453453453567","97867867867884","767867666677820"};
//                                    dataStringList.add(textDataInput12);
//                                    int i=0;
//                                    int lineSize=0;
//                                    for(String[] textData:dataStringList){
//                                                String lineData = textData[0]+" "+textData[1]+" "+textData[2]+" "+textData[3]+" "+textData[4];
//                                                lineSize = textData[0].length()+textData[1].length()+textData[2].length()+textData[3].length()+textData[4].length();
//                                                int pxBar =1150;
//                                                int pyBar =500+(i*550);
//                                                
//                                                int pxText=1000;
//                                                int pyText=500+(i*550);
//                                               
//                                                
//                                              
//                                                if(lineSize>71){
//                                                    pxText-= (lineSize-71)*20;
//                                                    pxBar-= (lineSize-71)*20;
//                                                }else if(lineSize<71){
//                                                    pxText+= (71-lineSize)*20;
//                                                    pxBar+= (71-lineSize)*20;
//                                                }
//                                                afpCreateTag.setPTXxy(ptx,pxText+130,pyText+100);
//                                                afpCreateTag.setFontID(ptx,59);
//                                                afpCreateTag.setPTX_TRN(ptx,"|"+lineData);
//                                                
//                                                for(int j=0;j<lineData.length();j++){
//                                                    
//                                                    if(!isNumeric(lineData.substring(j,j+1).trim())&&lineData.substring(j,j+1)!=" "&&lineData.substring(j,j+1)!="|"){
//                                                    
//                                                        pxBar-= 40;
//                                                    
//                                                    }
//                                                }
//                                                afpCreateTag.setPTXxy(ptx,pxBar,pyBar);
//                                                afpCreateTag.setFontID(ptx,36);	    
//                                                afpCreateTag.setPTX_TRN_Barcode5Data(ptx,textData[0],textData[1],textData[2],textData[3],textData[4]);
//
//
//                                                afpCreateTag.setPTXxy(ptx,pxBar,pyBar-150);
//                                                afpCreateTag.setFontID(ptx,36);	    
//                                                afpCreateTag.setPTX_TRN_Barcode5Data(ptx,textData[0],textData[1],textData[2],textData[3],textData[4]);
//
//
//                                             
//                                                   
//                                                i++;
//                                    
//                                    }
//                                    afpOut.writeStructuredField(ptx); 
//
//                                    EPT ept = AfplibFactory.eINSTANCE.createEPT();//End present text tag
//                                    afpOut.writeStructuredField(ept);
//                                    double beginX=1000;
//                                    double beginY=1000;
//                                    double r=100;
//
//                   
                        //////////////////////////////////////////////////////End page tag
                        EPG epg = AfplibFactory.eINSTANCE.createEPG();
                        afpOut.writeStructuredField(epg);
                        //////////////////////////////////////////////////////
                        
                   //////////////////////////////////////////////////////End doc tag     
                   EDT edt  = AfplibFactory.eINSTANCE.createEDT();
                   afpOut.writeStructuredField(edt);
                   //////////////////////////////////////////////////////
                   
                   afpOut.flush();
                   afpOut.close();
            }catch(Exception ex){
            
                  ex.printStackTrace();
                
            }
            
            
           
    }
    public static boolean isNumeric(String str){
    
        try{
        
            Double.valueOf(str);
        
            return true;
        }catch(Exception ex){
        
            return false;
        
        }
        
    }
    
}
