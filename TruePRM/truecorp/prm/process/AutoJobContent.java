/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.process;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;
import truecorp.prm.core.dao.SystemBaseDao;
import truecorp.prm.model.ContentCycleControl;
import truecorp.prm.service.ContentCycleControlService;
import truecorp.prm.service.ContentRevenueService;
import truecorp.prm.service.LogUtills;
import truecorp.prm.utils.ConstantPaths;
import truecorp.prm.utils.Constants;
import truecorp.prm.utils.ReadSqlUtils;

/**
 *
 * @author Jennarong Pinjai
 */
public class AutoJobContent {
    
    public static Logger  log = LogUtills.getLogger(AutoJobContent.class);
    
    public static void main(String[] args) throws Exception{
    
        log.info("Start AutoJobContent");
        Connection con = null;
      
        try{
            con = SystemBaseDao.getPrmAppConnection();
            con.setAutoCommit(false);
            SimpleDateFormat dd_mm_yyyyFormat = new SimpleDateFormat("dd-MM-yyyy",Locale.US);
            if(con!=null&&con.isValid(60)){
                log.info("PRMAPP DB connected!");
            }
            
            //Prepare date
            Date systemDate = new Date();
            Calendar  systemCarlendar = Calendar.getInstance();
            systemCarlendar.setTime(systemDate);
            
            SimpleDateFormat showDateFormat = new SimpleDateFormat("MM/yyyy",Locale.US);
            List<ContentCycleControl> cycleList = new ArrayList<ContentCycleControl>();
            ContentCycleControlService cycleService = new ContentCycleControlService();
            ContentRevenueService contetnService = new ContentRevenueService();
            Date reportDate=null;
            Date reportedDate=null;
            Date tailReportDate=null;
           
            for(int i=1;i<=6;i++){
                systemCarlendar.add(Calendar.MONTH, -1);
                Date prevDate = systemCarlendar.getTime();
                ContentCycleControl cycle = cycleService.getContentCycleControl(con, prevDate);
                if(i==1){
                    reportDate = prevDate;
                }
                if(i==2){
                    reportedDate = prevDate;
                }
                if(i==6){
                    tailReportDate = prevDate;
                }
                
                cycleList.add(cycle);
                
            }
            
            log.info("Report date :"+dd_mm_yyyyFormat.format(reportDate));
            log.info("Reported date :"+dd_mm_yyyyFormat.format(reportedDate));
            log.info("Oldest report date :"+dd_mm_yyyyFormat.format(tailReportDate));
            
             //reportDate   = systemDate -1Month
             //reportedDate = reportDate -1Month
             //tailReportDate = reportDate -5Month
            int resultPostPaid=0;
            int updateFlagPostPaidResult=0;
            int resultPrepaid=0;
            int updateFlahPrepaidResult=0;
            int resultAdjustment=0;
            
            
            for(ContentCycleControl cycle :cycleList){
          
                log.info("Table for process:"+cycle.getTableName());
                log.info("Start date:"+dd_mm_yyyyFormat.format(cycle.getStartDate()));
                log.info("End Date:"+dd_mm_yyyyFormat.format(cycle.getEndDate()));
                
                
                log.info("Migrating Post paid..");
                resultPostPaid += contetnService.migratePostPaidContentRevenueToSumContentRevenue(con,  cycle,reportDate,reportedDate,tailReportDate);
                //test contetnService.selectContentRevenue(con, cycle, reportDate, reportedDate, tailReportDate);
                log.info("Updating flag Post paid..");
                updateFlagPostPaidResult += contetnService.updateFlagPostPaidContentRevenue(con, cycle, reportDate, reportedDate, tailReportDate);
               
                
                log.info("Migrating Pre paid..");
                resultPrepaid+=contetnService.migratePrepaidContentRevenueToSumContentRevenue(con, cycle);
                 log.info("Updating flag Pre paid..");
                updateFlahPrepaidResult+=contetnService.updateFlagPrepaidContentRevenue(con, cycle);
                
                log.info("Migrating Adjustment..");
                resultAdjustment+=contetnService.migrateAdjustmentContentRevenueToSumContentRevenue(con, cycle);
                log.info("This job will not update Adjustment.");
                
                log.info("-----------------------------------------------\n");
                
            }
            log.info("Migrate Post paid records result:"+resultPostPaid+" , Update flag result:"+updateFlagPostPaidResult);
            log.info("Migrate Pre paid records result:"+resultPrepaid+" , Update flag result:"+updateFlahPrepaidResult);
            log.info("Migrate Adjustment records result:"+resultAdjustment );
            
            log.info("Total Migrated :"+(resultPostPaid+resultPrepaid+resultAdjustment));
            log.info("Total flag updated  :"+(updateFlagPostPaidResult+updateFlahPrepaidResult));
            con.commit();
            log.info("Success Migrate Content");
          
            con.close();
         
        }catch(Exception ex){
            if(con!=null){
                con.rollback();
                con.close();
            }
            log.error(ex.toString());  
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        log.info("End AutoJobContent");
    }
    
}
