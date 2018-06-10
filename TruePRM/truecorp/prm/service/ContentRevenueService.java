/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.service;

import java.sql.Connection;
import java.util.Date;
import org.apache.log4j.Logger;
import truecorp.prm.dao.ContentRevenueDAO;
import truecorp.prm.model.ContentCycleControl;

/**
 *
 * @author Jennarong Pinjai
 */
public class ContentRevenueService {
    
    private ContentRevenueDAO dao = new ContentRevenueDAO();
    Logger log = LogUtills.getLogger(ContentRevenueService.class);
    
    public int migratePostPaidContentRevenueToSumContentRevenue(Connection con,ContentCycleControl cycle,Date reportDate,Date reportedDate,Date oldestReportDate) throws Exception {
    
           
          if(cycle==null){
                throw new Exception("Cycle control is null!");
          }
          if(cycle.getStartDate()==null){
                throw new Exception("Cycle control's StartDate is null!");
          }
          if(cycle.getEndDate()==null){
                throw new Exception("Cycle control's EndDate is null!");
          }
          if(cycle.getTableName()==null){
                throw new Exception("Cycle control's TableName is null!");
          }
          if(reportDate==null){
                throw new Exception("Report date is null!");
          }
        
        
          return dao.migratePostPaidContentRevenueToSumContentRevenue(con, cycle,reportDate,reportedDate,oldestReportDate);
    
    }
    
    public void selectContentRevenue(Connection con, ContentCycleControl cycle, Date reportDate, Date reportedDate, Date oldestReportDate) throws Exception {

         dao.selectContentRevenue(con, cycle, reportDate, reportedDate, oldestReportDate);
    
    }
    
      public int updateFlagPostPaidContentRevenue(Connection con, ContentCycleControl cycle, Date reportDate, Date reportedDate, Date oldestReportDate) throws Exception {

           if(cycle==null){
                throw new Exception("Cycle control is null!");
          }
          if(cycle.getStartDate()==null){
                throw new Exception("Cycle control's StartDate is null!");
          }
          if(cycle.getEndDate()==null){
                throw new Exception("Cycle control's EndDate is null!");
          }
          if(cycle.getTableName()==null){
                throw new Exception("Cycle control's TableName is null!");
          }
          if(reportDate==null){
                throw new Exception("Report date is null!");
          }
          
          return dao.updateFlagPostPaidContentRevenue(con, cycle, reportDate, reportedDate, oldestReportDate);
      
      }
      
       public int migratePrepaidContentRevenueToSumContentRevenue(Connection con, ContentCycleControl cycle) throws Exception {
       
           
          if(cycle==null){
                throw new Exception("Cycle control is null!");
          }
          if(cycle.getStartDate()==null){
                throw new Exception("Cycle control's StartDate is null!");
          }
          if(cycle.getEndDate()==null){
                throw new Exception("Cycle control's EndDate is null!");
          }
          if(cycle.getTableName()==null){
                throw new Exception("Cycle control's TableName is null!");
          }
      
           
           return dao.migratePrepaidContentRevenueToSumContentRevenue(con, cycle);
       
       }
       
        public int updateFlagPrepaidContentRevenue(Connection con, ContentCycleControl cycle) throws Exception {
            
            
            return dao.updateFlagPrepaidContentRevenue(con, cycle);
            
        }
        
        
        public int migrateAdjustmentContentRevenueToSumContentRevenue(Connection con, ContentCycleControl cycle) throws Exception {
           
            if(cycle==null){
                  throw new Exception("Cycle control is null!");
            }
            if(cycle.getStartDate()==null){
                  throw new Exception("Cycle control's StartDate is null!");
            }
            if(cycle.getEndDate()==null){
                  throw new Exception("Cycle control's EndDate is null!");
            }
            if(cycle.getTableName()==null){
                  throw new Exception("Cycle control's TableName is null!");
            }
            return dao.migrateAdjustmentContentRevenueToSumContentRevenue(con, cycle);
            
        }
      
      
}
