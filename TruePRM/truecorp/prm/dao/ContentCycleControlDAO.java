/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.log4j.Logger;
import truecorp.prm.model.ContentCycleControl;
import truecorp.prm.service.LogUtills;

/**
 *
 * @author Jennarong Pinjai
 */
public class ContentCycleControlDAO {
    Logger log = LogUtills.getLogger(ContentCycleControlDAO.class);
    public String getContentPartnerRevenueTableName(Connection con,Date date) throws Exception{
        
           try{
               String tableName=null;
               
               Statement state = con.createStatement();
               StringBuilder sql = new StringBuilder();
               SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyyMM",Locale.US);
               String cycleDate = sqlDateFormat.format(date);
               
               sql.append(" select table_name from CONTENT_CYCLE_CONTROL where to_char(START_DATE,'yyyymm')='" + cycleDate + "'  ");
               
               ResultSet rs = state.executeQuery(sql.toString());
               int countResult=0;
               while(rs.next()){
                    countResult++;
                    tableName = rs.getString("table_name");
               }
               
               if(countResult==0){
                    throw new Exception("Can not find content table's name!");
               }
               
               return tableName;
           }catch(Exception ex){
               log.error(ex.getMessage());
               throw ex;
             
           }
        
    }
    
     public ContentCycleControl getContentCycleControl(Connection con,Date date) throws Exception{
        
           try{
               String tableName=null;
               ContentCycleControl ccc = null;
               Statement state = con.createStatement();
               StringBuilder sql = new StringBuilder();
               SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyyMM",Locale.US);
               SimpleDateFormat sqlDateOutputFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.US);
               String cycleDate = sqlDateFormat.format(date);
               
               sql.append(" select table_name,to_char(start_date,'dd/mm/yyyy') as start_date,to_char(end_date,'dd/mm/yyyy') as end_date from CONTENT_CYCLE_CONTROL where to_char(START_DATE,'yyyymm')='" + cycleDate + "'  ");
               
               ResultSet rs = state.executeQuery(sql.toString());
               int countResult=0;
               while(rs.next()){
                    countResult++;
                    ccc =  new ContentCycleControl();
                    ccc.setTableName(rs.getString("table_name"));  
                    ccc.setStartDate(sqlDateOutputFormat.parse(rs.getString("start_date")));
                    ccc.setEndDate(rs.getDate("end_date"));
                    
                    break;
                    
               }
               
               if(countResult==0){
                    throw new Exception("Can not find content table's name!");
               }
               
               return ccc;
           }catch(Exception ex){
               log.error(ex.getMessage());
               throw ex;
             
           }
        
    }
    
}
