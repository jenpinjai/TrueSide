/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.log4j.Logger;
import truecorp.prm.model.ContentCycleControl;
import truecorp.prm.service.LogUtills;
import truecorp.prm.utils.ConstantPaths;
import truecorp.prm.utils.ReadSqlUtils;

/**
 *
 * @author Jennarong Pinjai
 */
public class ContentRevenueDAO {

    Logger log = LogUtills.getLogger(ContentRevenueDAO.class);

    public int migrateContentRevenueToSumContentRevenue(Connection con, ContentCycleControl cycle, Date reportDate, Date reportedDate, Date oldestReportDate) throws Exception {

        int result = 0;
        String sql = null;
        try {
            SimpleDateFormat yyyymmddhhmmssFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.US);
            Date sysDate = new Date();
            sql = ReadSqlUtils.getSQLString(ConstantPaths.CONTENT_REVENUE_SQL, "insertPostPaidSumContentRevenue");
            sql = sql.replace("$tableName", cycle.getTableName());
            sql = sql.replace("$sysDate", "'"+yyyymmddhhmmssFormat.format(sysDate)+"'");
            PreparedStatement prepareSt = con.prepareStatement(sql);
            SimpleDateFormat yyyymmddParamFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
            SimpleDateFormat yyyymmParamFormat = new SimpleDateFormat("yyyyMM", Locale.US);

            String startDateParam = yyyymmddParamFormat.format(cycle.getStartDate());
            String endDateParam = yyyymmddParamFormat.format(cycle.getEndDate());
            String reportDateParam = yyyymmParamFormat.format(reportDate);
            String oldestDateParam = yyyymmParamFormat.format(oldestReportDate);
            String reportedDateParam = yyyymmParamFormat.format(reportedDate);

            int index = 1;
            prepareSt.setString(index++, startDateParam);
            prepareSt.setString(index++, endDateParam);
            prepareSt.setString(index++, reportDateParam);
            prepareSt.setString(index++, oldestDateParam);
            prepareSt.setString(index++, reportedDateParam);

            result = prepareSt.executeUpdate();

            return result;
        } catch (Exception ex) {
            log.error("Error sql:" + sql);
            log.error(ex.getMessage());
            throw ex;
        }

    }

      public int updateFlagContentRevenue(Connection con, ContentCycleControl cycle, Date reportDate, Date reportedDate, Date oldestReportDate) throws Exception {

        int result = 0;
        String sql = null;
        try {
            SimpleDateFormat yyyymmddhhmmssFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.US);
            Date sysDate = new Date();
            sql = ReadSqlUtils.getSQLString(ConstantPaths.CONTENT_REVENUE_SQL, "updateFlagPostPaidContentRevenue");
            sql = sql.replace("$tableName", cycle.getTableName());
            PreparedStatement prepareSt = con.prepareStatement(sql);
            SimpleDateFormat yyyymmddParamFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
            SimpleDateFormat yyyymmParamFormat = new SimpleDateFormat("yyyyMM", Locale.US);

            String startDateParam = yyyymmddParamFormat.format(cycle.getStartDate());
            String endDateParam = yyyymmddParamFormat.format(cycle.getEndDate());
            String reportDateParam = yyyymmParamFormat.format(reportDate);
            String oldestDateParam = yyyymmParamFormat.format(oldestReportDate);
            String reportedDateParam = yyyymmParamFormat.format(reportedDate);

            int index = 1;
            prepareSt.setString(index++, startDateParam);
            prepareSt.setString(index++, endDateParam);
            prepareSt.setString(index++, reportDateParam);
            prepareSt.setString(index++, oldestDateParam);
            prepareSt.setString(index++, reportedDateParam);

            result = prepareSt.executeUpdate();

            return result;
        } catch (Exception ex) {
            log.error("Error sql:" + sql);
            log.error(ex.getMessage());
            throw ex;
        }

    }
    
    public void selectContentRevenue(Connection con, ContentCycleControl cycle, Date reportDate, Date reportedDate, Date oldestReportDate) throws Exception {

        int result = 0;
        String sql = null;
        try {
            SimpleDateFormat yyyymmddhhmmssFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.US);
            Date sysDate = new Date();
            
            sql = ReadSqlUtils.getSQLString(ConstantPaths.CONTENT_REVENUE_SQL, "insertPostPaidSumContentRevenue");
            sql = "select "+sql.split("select")[1];
            sql = sql.replace("$sysDate", "'"+yyyymmddhhmmssFormat.format(sysDate)+"'");
            sql = sql.replace("$tableName", cycle.getTableName());
            PreparedStatement prepareSt = con.prepareStatement(sql);
            ResultSet resultSet =null;
            
            SimpleDateFormat yyyymmddParamFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
            SimpleDateFormat yyyymmParamFormat = new SimpleDateFormat("yyyyMM", Locale.US);

            String startDateParam = yyyymmddParamFormat.format(cycle.getStartDate());
            String endDateParam = yyyymmddParamFormat.format(cycle.getEndDate());
            String reportDateParam = yyyymmParamFormat.format(reportDate);
            String oldestDateParam = yyyymmParamFormat.format(oldestReportDate);
            String reportedDateParam = yyyymmParamFormat.format(reportedDate);

            int index = 1;
            prepareSt.setString(index++, startDateParam);
            prepareSt.setString(index++, endDateParam);
            prepareSt.setString(index++, reportDateParam);
            prepareSt.setString(index++, oldestDateParam);
            prepareSt.setString(index++, reportedDateParam);

            resultSet = prepareSt.executeQuery();

            
            while(resultSet.next()){
            
                    boolean lastCol=false;
                    for(int i=1;!lastCol;i++){
                        String content =null;
                        try{content = resultSet.getString(i);}catch(Exception ex){lastCol=true;}
                        
                        System.out.print(content+"\t");
                        
                    }
                    System.out.println();
                
            }
            
           
        } catch (Exception ex) {
            log.error("Error sql:" + sql);
            log.error(ex.getMessage());
            throw ex;
        }

    }

}
