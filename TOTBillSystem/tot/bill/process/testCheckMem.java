package tot.bill.process;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import tot.bill.dao.SelectDB;
import tot.bill.dao.createConnectionDB;
import tot.bill.table.CYCLE_CONTROL;
import tot.bill.table.NAME_ADDRESS_INFO;
import tot.bill.table.SERVICE_FEATURE;

public class testCheckMem {


	public static void main(String[] args) throws IOException, SQLException {
		
		
		Connection conPRM = null;
        Connection conBILL = null;
        
        conBILL=createConnectionDB.openConnectBillDB();
        conPRM=createConnectionDB.openConnectPRMDB();
        
        System.out.println("get SERVICE_FEATURE");
        ArrayList<String> idSERVICE_FEATURE = new ArrayList<String>();
        ArrayList<SERVICE_FEATURE> stSERVICE_FEATURE=new ArrayList<SERVICE_FEATURE>();    
	    
        SelectDB.selectSERVICE_FEATURE(conBILL, idSERVICE_FEATURE, stSERVICE_FEATURE);
        //SelectDB.selectSERVICE_FEATURE(conBILL, idSERVICE_FEATURE, stSERVICE_FEATURE);
                
 		
 		
        try { conPRM.close(); } catch (Exception ignore) {}
 	    try { conBILL.close(); } catch (Exception ignore) {}
 	   
 	    System.out.println("end");
	}

}
