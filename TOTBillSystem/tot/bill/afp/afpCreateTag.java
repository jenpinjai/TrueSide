package tot.bill.afp;

import java.io.IOException;
import org.afplib.afplib.*;
import org.afplib.base.Triplet;
import org.afplib.io.AfpOutputStream;
import org.eclipse.emf.common.util.EList;
public class afpCreateTag {
	public static int createTagBDT(AfpOutputStream aout)throws  IOException {
		BDT bdt = AfplibFactory.eINSTANCE.createBDT();
        aout.writeStructuredField(bdt);
        return 0;
    }
	public static int createTagEDT(AfpOutputStream aout)throws  IOException {
		EDT edt = AfplibFactory.eINSTANCE.createEDT();
        aout.writeStructuredField(edt);
        return 0;
    }
	public static int createTagBPG(AfpOutputStream aout)throws  IOException {
		BPG bpg = AfplibFactory.eINSTANCE.createBPG();
        aout.writeStructuredField(bpg);
        return 0;
    }
	public static int createTagEPG(AfpOutputStream aout)throws  IOException {
		EPG epg = AfplibFactory.eINSTANCE.createEPG();
        aout.writeStructuredField(epg);
        return 0;
    }
	public static int createTagBAG(AfpOutputStream aout)throws  IOException {
		BAG bag = AfplibFactory.eINSTANCE.createBAG();
        aout.writeStructuredField(bag);
        return 0;
    }
	public static int createTagEAG(AfpOutputStream aout)throws  IOException {
		EAG eag = AfplibFactory.eINSTANCE.createEAG();
        aout.writeStructuredField(eag);
        return 0;
    }
	public static int createTagMCF(AfpOutputStream aout,String[] FQName,int[] FQNFormat,int[] FQNType,int[] ResLID,int[] ResType)throws  IOException {
		MCF mcf = AfplibFactory.eINSTANCE.createMCF();
		EList<MCFRG> rgList = mcf.getRG();
		MCFRG mcfrg = AfplibFactory.eINSTANCE.createMCFRG();
		EList<Triplet> tripetList = mcfrg.getTriplets();
		ResourceLocalIdentifier r = AfplibFactory.eINSTANCE.createResourceLocalIdentifier();
		FullyQualifiedName q = AfplibFactory.eINSTANCE.createFullyQualifiedName();
        //=========0======
		for(int i=0;i<FQName.length;i++){
		  //System.out.println(FQName[i]);
          rgList = mcf.getRG();
          mcfrg = AfplibFactory.eINSTANCE.createMCFRG();
          rgList.add(mcfrg);
          tripetList = mcfrg.getTriplets();
          q = AfplibFactory.eINSTANCE.createFullyQualifiedName();
          tripetList.add(q);
          q.setFQName(FQName[i]);
          q.setFQNFormat(FQNFormat[i]);
          q.setFQNType(FQNType[i]);
          r = AfplibFactory.eINSTANCE.createResourceLocalIdentifier();
          tripetList.add(r);
          r.setResLID(ResLID[i]);
          r.setResType(ResType[i]);
          
          mcf.getRG().add(mcfrg);
		}
         
          aout.writeStructuredField(mcf);
        return 0;
    }
	public static int createTagMPS(AfpOutputStream aout,String[] PsegName )throws  IOException {
		MPS mps = AfplibFactory.eINSTANCE.createMPS();
        MPSRG mpsrg = AfplibFactory.eINSTANCE.createMPSRG();
        for(int i=0;i<PsegName.length;i++){
        	mpsrg = AfplibFactory.eINSTANCE.createMPSRG();
	        mpsrg.setPsegName(PsegName[i]);
	        mps.getFixedLengthRG().add(mpsrg);
        }
        aout.writeStructuredField(mps);
        return 0;
    }
	public static int createTagPGD(AfpOutputStream aout,int XpgUnits,int YpgUnits ,int XpgSize,int YpgSize)throws  IOException {
		PGD pgd = AfplibFactory.eINSTANCE.createPGD();
        pgd.setXpgUnits(XpgUnits);
        pgd.setYpgUnits(YpgUnits);
        pgd.setXpgSize(XpgSize);
        pgd.setYpgSize(YpgSize);
        aout.writeStructuredField(pgd);
        return 0;
    }
	public static int createTagPTD1(AfpOutputStream aout,int XPUNITVL,int YPUNITVL ,int XPEXTENT,int YPEXTENT,int RESERVED)throws  IOException {
		PTD1 ptd1 = AfplibFactory.eINSTANCE.createPTD1();
        ptd1.setXPUNITVL(XPUNITVL);
        ptd1.setYPUNITVL(YPUNITVL);
        ptd1.setXPEXTENT(XPEXTENT);
        ptd1.setYPEXTENT(YPEXTENT);
        ptd1.setRESERVED(RESERVED);
        aout.writeStructuredField(ptd1);
        return 0;
    }
	public static int createTagIMM(AfpOutputStream aout,String setMMPName )throws  IOException {
		IMM imm = AfplibFactory.eINSTANCE.createIMM();
        imm.setMMPName(setMMPName);
        aout.writeStructuredField(imm);
        return 0;
    }
	public static int createTagBPT(AfpOutputStream aout)throws  IOException {
		 BPT bpt = AfplibFactory.eINSTANCE.createBPT();
         aout.writeStructuredField(bpt);
        return 0;
    }
	public static int createTagEPT(AfpOutputStream aout)throws  IOException {
		EPT ept = AfplibFactory.eINSTANCE.createEPT();
        aout.writeStructuredField(ept);
       return 0;
	}
	public static int setPTXxy(PTX ptx,int x,int y)throws  IOException {
		AMI ami=AfplibFactory.eINSTANCE.createAMI();
        ami.setDSPLCMNT(x);
        ptx.getCS().add(ami); 
		AMB amb=AfplibFactory.eINSTANCE.createAMB();  
        amb.setDSPLCMNT(y);
        ptx.getCS().add(amb);
       return 0;
	}
	public static int setPTXRelativexy(PTX ptx,int x,int y)throws  IOException {
		RMI rmi=AfplibFactory.eINSTANCE.createRMI();
        rmi.setINCRMENT(x);
        ptx.getCS().add(rmi);
		RMB rmb=AfplibFactory.eINSTANCE.createRMB();
        rmb.setINCRMENT(y);
        ptx.getCS().add(rmb);        
       return 0;
	}
	
	public static int setFontID(PTX ptx,int fontID)throws  IOException {
		 SCFL scfl=AfplibFactory.eINSTANCE.createSCFL();
         scfl.setLID(fontID);
         ptx.getCS().add(scfl); 
       return 0;
	}
	public static int setSTC(PTX ptx,int FRGCOLOR,int PRECSION)throws  IOException {
		 STC stc=AfplibFactory.eINSTANCE.createSTC();
         stc.setFRGCOLOR(FRGCOLOR);
         stc.setPRECSION(PRECSION);
         
        ptx.getCS().add(stc); 
      return 0;
	}
	public static int setDIR(PTX ptx,int RLENGTH,int RWIDTH,int RWIDTHFRACTION)throws  IOException {
		DIR dir=AfplibFactory.eINSTANCE.createDIR();
        dir.setRLENGTH(RLENGTH);
        dir.setRWIDTH(RWIDTH);
        dir.setRWIDTHFRACTION(RWIDTHFRACTION);
        ptx.getCS().add(dir); 
     return 0;
	}
	public static int setDBR(PTX ptx,int RLENGTH,int RWIDTH,int RWIDTHFRACTION)throws  IOException {
		 DBR dbr=AfplibFactory.eINSTANCE.createDBR();
         dbr.setRLENGTH(RLENGTH);
         dbr.setRWIDTH(RWIDTH);
         dbr.setRWIDTHFRACTION(RWIDTHFRACTION);
         ptx.getCS().add(dbr);
     return 0;
	}
	public static int setPTX_DrowBox(PTX ptx,int box_x,int box_y,int box_border)throws  IOException {

		setDIR(ptx,box_x,box_border,0);
		setPTXRelativexy(ptx,box_x,0);
		setDBR(ptx,box_y,box_border,0);
		setPTXRelativexy(ptx,0,box_y-box_border);
		setDIR(ptx,box_x*-1,box_border,0);
		setPTXRelativexy(ptx,box_x*-1,0);
		setDBR(ptx,box_y*-1+box_border,box_border,0);
		return 0;
	}
	public static int setPTX_DrawLine(PTX ptx,int box_x,int box_border)throws  IOException {

		setDIR(ptx,box_x,box_border,0);
		setPTXRelativexy(ptx,box_x,0);
		//setDBR(ptx,box_y,box_border,0);
		//setPTXRelativexy(ptx,0,box_y-box_border);
		//setDIR(ptx,box_x*-1,box_border,0);
		//setPTXRelativexy(ptx,box_x*-1,0);
		//setDBR(ptx,box_y*-1+box_border,box_border,0);
		return 0;
	}
	
	public static int setPTX_TRN(PTX ptx,String writeText)throws  IOException {
		TRN trn =AfplibFactory.eINSTANCE.createTRN();                       
        //byte[] aa = ebcdicToAscii.convertStringToEBCDIC(writeText.getBytes());
        byte[] aa=writeText.getBytes("CP838"); 
        trn.setTRNDATA(aa);
        ptx.getCS().add(trn); 
       return 0;
	}
	public static int setPTX_TRN_Barcode(PTX ptx,String inputStr1,String inputStr2,String inputStr3,String inputStr4)throws  IOException {
		TRN trn =AfplibFactory.eINSTANCE.createTRN();                       
        
        String outputStr="";
        String outputStrMap="";
        outputStr="ฬ|ว";
        
        outputStrMap=mapBarcodAll.Map128ALL(inputStr1);
        outputStr=outputStr+outputStrMap;
        outputStr=outputStr+"ษmว";
        
        outputStrMap=mapBarcodAll.Map128ALL(inputStr2);
        outputStr=outputStr+outputStrMap;
        outputStr=outputStr+"ษmว";
        
        outputStrMap=mapBarcodAll.Map128ALL(inputStr3);
        outputStr=outputStr+outputStrMap;
        outputStr=outputStr+"ษmว";
        
        outputStrMap=mapBarcodAll.Map128ALL(inputStr4);
        outputStr=outputStr+outputStrMap;
        
        outputStr=outputStr+mapBarcodAll.checkSumMap128ALL(outputStr);
        
        outputStr=outputStr+"ฮ";
        //System.out.println(outputStr);

       // byte[] aa = ebcdicToAscii.convertStringToEBCDIC(outputStr.getBytes());
        byte[] aa=outputStr.getBytes("CP838"); 
        trn.setTRNDATA(aa);
        ptx.getCS().add(trn);
       return 0;
	}
        
        public static int setPTX_TRN_Barcode5Data(PTX ptx,String inputStr1,String inputStr2,String inputStr3,String inputStr4,String inputStr5)throws  IOException {
		TRN trn =AfplibFactory.eINSTANCE.createTRN();                       
        
        String outputStr="";
        String outputStrMap="";
        outputStr="ฬ|ว";
        
        outputStrMap=mapBarcodAll.Map128ALL(inputStr1);
        outputStr=outputStr+outputStrMap;
        outputStr=outputStr+"ษmว";
        
        outputStrMap=mapBarcodAll.Map128ALL(inputStr2);
        outputStr=outputStr+outputStrMap;
        outputStr=outputStr+"ษmว";
        
        outputStrMap=mapBarcodAll.Map128ALL(inputStr3);
        outputStr=outputStr+outputStrMap;
        outputStr=outputStr+"ษmว";
        
        outputStrMap=mapBarcodAll.Map128ALL(inputStr4);
        outputStr=outputStr+outputStrMap;
        outputStr=outputStr+"ษmว";
        
        outputStrMap=mapBarcodAll.Map128ALL(inputStr5);
        outputStr=outputStr+outputStrMap;
        
        outputStr=outputStr+mapBarcodAll.checkSumMap128ALL(outputStr);
        
        outputStr=outputStr+"ฮ";
        //System.out.println(outputStr);

       // byte[] aa = ebcdicToAscii.convertStringToEBCDIC(outputStr.getBytes());
        byte[] aa=outputStr.getBytes("CP838"); 
        trn.setTRNDATA(aa);
        ptx.getCS().add(trn);
       return 0;
	}
	
	public static int createTagIPS(AfpOutputStream aout,int x,int y,String PsegName )throws  IOException {
		IPS ips = AfplibFactory.eINSTANCE.createIPS();
        ips.setXpsOset(x);
        ips.setYpsOset(y);
        ips.setPsegName(PsegName);
        aout.writeStructuredField(ips);
       return 0;
	}
	public static int createTagBII(AfpOutputStream aout,String ImoName)throws  IOException {
		BII bii = AfplibFactory.eINSTANCE.createBII();
        bii.setImoName(ImoName);
        aout.writeStructuredField(bii);
       return 0;
	}
	public static int createTagIOC(AfpOutputStream aout,int XoaOset,int YoaOset,int XoaOrent,int YoaOrent,int XMap ,int YMap,byte[] ConData2 )throws  IOException {
		IOC ioc = AfplibFactory.eINSTANCE.createIOC();
        ioc.setXoaOset(XoaOset);
        ioc.setYoaOset(YoaOset);
        ioc.setXoaOrent(XoaOrent);
        ioc.setYoaOrent(YoaOrent);
        ioc.setXMap(XMap);
        ioc.setYMap(YMap);
       
        ioc.setConData2(ConData2);
        aout.writeStructuredField(ioc);
       return 0;
	}
	public static int createTagIID(AfpOutputStream aout,int XUnits,int YUnits,int XSize,int YSize,
			int XCSizeD,int YCSizeD,byte[]ConData1,byte[]ConData2,byte[]ConData3)throws  IOException {
		IID iid = AfplibFactory.eINSTANCE.createIID();
        iid.setXUnits(XUnits);
        iid.setYUnits(YUnits);
        iid.setXSize(XSize);
        iid.setYSize(YSize);
        iid.setXCSizeD(XCSizeD);
        iid.setYCSizeD(YCSizeD);
        iid.setConData1(ConData1);
        iid.setConData2(ConData2);      
        iid.setConData3(ConData3);       
        aout.writeStructuredField(iid);
       return 0;
	}
	public static int createTagICP(AfpOutputStream aout,int XCSize,int YCSize,int XFilSize,int YFilSize)throws  IOException {
		ICP icp = AfplibFactory.eINSTANCE.createICP();
        icp.setXCSize(XCSize);
        icp.setYCSize(YCSize);
        icp.setXFilSize(XFilSize);
        icp.setYFilSize(YFilSize);
        aout.writeStructuredField(icp);
       return 0;
	}
	public static int createTagIRD(AfpOutputStream aout,byte[]IMdata)throws  IOException {
		IRD ird = AfplibFactory.eINSTANCE.createIRD();
        
        ird.setIMdata(IMdata);
        aout.writeStructuredField(ird);
       return 0;
	}
	public static int createTagEII(AfpOutputStream aout,String ImoName)throws  IOException {
		EII eii = AfplibFactory.eINSTANCE.createEII();        
        eii.setImoName(ImoName);       
        aout.writeStructuredField(eii);
       return 0;
	}
	public static int createTagBGR(AfpOutputStream aout)throws  IOException {
		 BGR bgr = AfplibFactory.eINSTANCE.createBGR();
		 aout.writeStructuredField(bgr);
       return 0;
	}
	public static int createTagEGR(AfpOutputStream aout)throws  IOException {
		 EGR egr = AfplibFactory.eINSTANCE.createEGR();
		 aout.writeStructuredField(egr);
      return 0;
	}
	public static int createTagBOG(AfpOutputStream aout)throws  IOException {
		 BOG bog = AfplibFactory.eINSTANCE.createBOG();
		 aout.writeStructuredField(bog);
      return 0;
	}
	public static int createTagEOG(AfpOutputStream aout)throws  IOException {
		 EOG eog = AfplibFactory.eINSTANCE.createEOG();
		 aout.writeStructuredField(eog);
     return 0;
	}
	public static int createTagGDD(AfpOutputStream aout,int useArray)throws  IOException {
		GDD gdd = AfplibFactory.eINSTANCE.createGDD();
		byte[] aa = new byte[] {(byte)0xf6,(byte)0x16,(byte)0x40,(byte)0x00,(byte)0x00,
                (byte)0x00,(byte)0x17,(byte)0x70,(byte)0x17,(byte)0x70,(byte)0x00,(byte)0x00,
                (byte)0xf6,(byte)0x0a,(byte)0x09,(byte)0xf6,(byte)0xfb,(byte)0x64,(byte)0x04,
                (byte)0x9c,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
        };
		if(useArray==0){
        aa = new byte[] {(byte)0xf6,(byte)0x16,(byte)0x40,(byte)0x00,(byte)0x00,
                (byte)0x00,(byte)0x17,(byte)0x70,(byte)0x17,(byte)0x70,(byte)0x00,(byte)0x00,
                (byte)0xf6,(byte)0x0a,(byte)0x09,(byte)0xf6,(byte)0xfb,(byte)0x64,(byte)0x04,
                (byte)0x9c,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
        };
		}else{
        aa = new byte[] {(byte)0xf6,(byte)0x16,(byte)0x40,(byte)0x00,(byte)0x00,
                (byte)0x00,(byte)0x17,(byte)0x70,(byte)0x17,(byte)0x70,(byte)0x00,(byte)0x00,
                (byte)0xf6,(byte)0x0a,(byte)0x09,(byte)0xf6,(byte)0xfe,(byte)0x3e,(byte)0x01,
                (byte)0xc2,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00
        };
		}
        gdd.setGOCAdes(aa);
        aout.writeStructuredField(gdd);
     return 0;
	}
	public static int createTagGAD(AfpOutputStream aout,int useArray)throws  IOException {
		GAD gad = AfplibFactory.eINSTANCE.createGAD();
        byte[] aa = new byte[] {(byte)0x70,(byte)0x0c,(byte)0x00,(byte)0x00,(byte)0x00,
                (byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x0c,(byte)0x00,(byte)0x00,
                (byte)0x00,(byte)0x00,(byte)0x18,(byte)0x02,(byte)0xc1,(byte)0x08,(byte)0xf7,
                (byte)0x6d,(byte)0x04,(byte)0x9c,(byte)0x08,(byte)0x09,(byte)0x04,(byte)0x9c
        };     
        if(useArray==0){
        	aa = new byte[] {(byte)0x70,(byte)0x0c,(byte)0x00,(byte)0x00,(byte)0x00,
                    (byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x0c,(byte)0x00,(byte)0x00,
                    (byte)0x00,(byte)0x00,(byte)0x18,(byte)0x02,(byte)0xc1,(byte)0x08,(byte)0xf7,
                    (byte)0x6d,(byte)0x04,(byte)0x9c,(byte)0x08,(byte)0x09,(byte)0x04,(byte)0x9c
        	};
        }else{
        	aa = new byte[] {(byte)0x70,(byte)0x0c,(byte)0x00,(byte)0x00,(byte)0x00,
                    (byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x0c,(byte)0x00,(byte)0x00,
                    (byte)0x00,(byte)0x00,(byte)0x18,(byte)0x01,(byte)0xc1,(byte)0x08,(byte)0x04,
                    (byte)0x3f,(byte)0xff,(byte)0xa4,(byte)0x08,(byte)0x3b,(byte)0xff,(byte)0xa6
        	};
        }
        gad.setGOCAdat(aa);      
        aout.writeStructuredField(gad);
     return 0;
	}
	public static int createTagOBD(AfpOutputStream aout,int YoaSize)throws  IOException {
		OBD obd = AfplibFactory.eINSTANCE.createOBD();
        EList<Triplet> tripetList = obd.getTriplets();
        DescriptorPosition d= AfplibFactory.eINSTANCE.createDescriptorPosition();
        tripetList.add(d);
        d.setDesPosID(1);
        
        MeasurementUnits m=AfplibFactory.eINSTANCE.createMeasurementUnits();
        tripetList.add(m);
        m.setXoaUnits(6000);
        m.setYoaUnits(6000);
        
        ObjectAreaSize o=AfplibFactory.eINSTANCE.createObjectAreaSize();
        tripetList.add(o);
        o.setSizeType(2);
        o.setXoaSize(5100);
        o.setYoaSize(YoaSize);
        
        obd.getTriplets().add(d);
        obd.getTriplets().add(m);
        obd.getTriplets().add(o);
        
        
        aout.writeStructuredField(obd);
    return 0;
	}
	public static int createTagOBP(AfpOutputStream aout,int OAPosID,int RGLength,int YoaOset,int YoaOrent,int YocaOrent)throws  IOException {
		OBP obp = AfplibFactory.eINSTANCE.createOBP();
        obp.setOAPosID(OAPosID);
        obp.setRGLength(RGLength);
        //obp.setXoaOset(0);
        obp.setYoaOset(YoaOset);
        //obp.setXoaOrent(0);
        obp.setYoaOrent(YoaOrent);
        obp.setYocaOrent(YocaOrent);
        
        aout.writeStructuredField(obp);
     return 0;
	}
	
}
