
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.table.*;


public class IcRatesAddlInfoBaseDAO {

    private static Logger log = Logger.getLogger(IcRatesAddlInfoBaseDAO.class);

    /** Creates a new instance of IcRatesAddlInfoDAO */
    public IcRatesAddlInfoBaseDAO() {
    }

    public int insert( IcRatesAddlInfo icRatesAddlInfo, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into [IC_RATES_ADDL_INFO](RATE_PLAN_CD, DESTINATION_CD, CHRG_PARAM_ID, QUAL_PARAM_1_ID, QUAL_PARAM_1_CD, QUAL_PARAM_2_ID, QUAL_PARAM_2_CD, QUAL_PARAM_3_ID, QUAL_PARAM_3_CD, QUAL_PARAM_4_ID, QUAL_PARAM_4_CD, QUAL_PARAM_5_ID, QUAL_PARAM_5_CD, QUAL_PARAM_6_ID, QUAL_PARAM_6_CD, QUAL_PARAM_7_ID, QUAL_PARAM_7_CD, EFFECTIVE_DATE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, ROUNDING_UNIT, MIN_CHRG, MIN_CHRG_PARAM, ACCES_CHRG, ACCES_CHRG_SEQ, EXPIRATION_DATE) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icRatesAddlInfo.getRatePlanCd());
            stmt.setString( 2, icRatesAddlInfo.getDestinationCd());
            stmt.setBigDecimal( 3, icRatesAddlInfo.getChrgParamId());
            stmt.setBigDecimal( 4, icRatesAddlInfo.getQualParam1Id());
            stmt.setString( 5, icRatesAddlInfo.getQualParam1Cd());
            stmt.setBigDecimal( 6, icRatesAddlInfo.getQualParam2Id());
            stmt.setString( 7, icRatesAddlInfo.getQualParam2Cd());
            stmt.setBigDecimal( 8, icRatesAddlInfo.getQualParam3Id());
            stmt.setString( 9, icRatesAddlInfo.getQualParam3Cd());
            stmt.setBigDecimal( 10, icRatesAddlInfo.getQualParam4Id());
            stmt.setString( 11, icRatesAddlInfo.getQualParam4Cd());
            stmt.setBigDecimal( 12, icRatesAddlInfo.getQualParam5Id());
            stmt.setString( 13, icRatesAddlInfo.getQualParam5Cd());
            stmt.setBigDecimal( 14, icRatesAddlInfo.getQualParam6Id());
            stmt.setString( 15, icRatesAddlInfo.getQualParam6Cd());
            stmt.setBigDecimal( 16, icRatesAddlInfo.getQualParam7Id());
            stmt.setString( 17, icRatesAddlInfo.getQualParam7Cd());
            stmt.setDate( 18, icRatesAddlInfo.getEffectiveDate());
            stmt.setDate( 19, icRatesAddlInfo.getSysCreationDate());
            stmt.setDate( 20, icRatesAddlInfo.getSysUpdateDate());
            stmt.setBigDecimal( 21, icRatesAddlInfo.getOperatorId());
            stmt.setString( 22, icRatesAddlInfo.getApplicationId());
            stmt.setString( 23, icRatesAddlInfo.getDlServiceCode());
            stmt.setBigDecimal( 24, icRatesAddlInfo.getDlUpdateStamp());
            stmt.setBigDecimal( 25, icRatesAddlInfo.getRoundingUnit());
            stmt.setBigDecimal( 26, icRatesAddlInfo.getMinChrg());
            stmt.setBigDecimal( 27, icRatesAddlInfo.getMinChrgParam());
            stmt.setBigDecimal( 28, icRatesAddlInfo.getAccesChrg());
            stmt.setBigDecimal( 29, icRatesAddlInfo.getAccesChrgSeq());
            stmt.setDate( 30, icRatesAddlInfo.getExpirationDate());
            int status = stmt.executeUpdate();
            log.info("INSERT IcRatesAddlInfo SUCCESS:" + icRatesAddlInfo);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IcRatesAddlInfo FAIL:" + icRatesAddlInfo);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IcRatesAddlInfo FAIL:" + icRatesAddlInfo);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IcRatesAddlInfo icRatesAddlInfo, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update [IC_RATES_ADDL_INFO] set SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , ROUNDING_UNIT = ?  , MIN_CHRG = ?  , MIN_CHRG_PARAM = ?  , ACCES_CHRG = ?  , ACCES_CHRG_SEQ = ?  , EXPIRATION_DATE = ?  ";
	    SQL_STATEMENT += "where RATE_PLAN_CD = ?  and DESTINATION_CD = ?  and CHRG_PARAM_ID = ?  and QUAL_PARAM_1_ID = ?  and QUAL_PARAM_1_CD = ?  and QUAL_PARAM_2_ID = ?  and QUAL_PARAM_2_CD = ?  and QUAL_PARAM_3_ID = ?  and QUAL_PARAM_3_CD = ?  and QUAL_PARAM_4_ID = ?  and QUAL_PARAM_4_CD = ?  and QUAL_PARAM_5_ID = ?  and QUAL_PARAM_5_CD = ?  and QUAL_PARAM_6_ID = ?  and QUAL_PARAM_6_CD = ?  and QUAL_PARAM_7_ID = ?  and QUAL_PARAM_7_CD = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setDate( 1, icRatesAddlInfo.getSysCreationDate());
            stmt.setDate( 2, icRatesAddlInfo.getSysUpdateDate());
            stmt.setBigDecimal( 3, icRatesAddlInfo.getOperatorId());
            stmt.setString( 4, icRatesAddlInfo.getApplicationId());
            stmt.setString( 5, icRatesAddlInfo.getDlServiceCode());
            stmt.setBigDecimal( 6, icRatesAddlInfo.getDlUpdateStamp());
            stmt.setBigDecimal( 7, icRatesAddlInfo.getRoundingUnit());
            stmt.setBigDecimal( 8, icRatesAddlInfo.getMinChrg());
            stmt.setBigDecimal( 9, icRatesAddlInfo.getMinChrgParam());
            stmt.setBigDecimal( 10, icRatesAddlInfo.getAccesChrg());
            stmt.setBigDecimal( 11, icRatesAddlInfo.getAccesChrgSeq());
            stmt.setDate( 12, icRatesAddlInfo.getExpirationDate());
            stmt.setString( 13, icRatesAddlInfo.getRatePlanCd());
            stmt.setString( 14, icRatesAddlInfo.getDestinationCd());
            stmt.setBigDecimal( 15, icRatesAddlInfo.getChrgParamId());
            stmt.setBigDecimal( 16, icRatesAddlInfo.getQualParam1Id());
            stmt.setString( 17, icRatesAddlInfo.getQualParam1Cd());
            stmt.setBigDecimal( 18, icRatesAddlInfo.getQualParam2Id());
            stmt.setString( 19, icRatesAddlInfo.getQualParam2Cd());
            stmt.setBigDecimal( 20, icRatesAddlInfo.getQualParam3Id());
            stmt.setString( 21, icRatesAddlInfo.getQualParam3Cd());
            stmt.setBigDecimal( 22, icRatesAddlInfo.getQualParam4Id());
            stmt.setString( 23, icRatesAddlInfo.getQualParam4Cd());
            stmt.setBigDecimal( 24, icRatesAddlInfo.getQualParam5Id());
            stmt.setString( 25, icRatesAddlInfo.getQualParam5Cd());
            stmt.setBigDecimal( 26, icRatesAddlInfo.getQualParam6Id());
            stmt.setString( 27, icRatesAddlInfo.getQualParam6Cd());
            stmt.setBigDecimal( 28, icRatesAddlInfo.getQualParam7Id());
            stmt.setString( 29, icRatesAddlInfo.getQualParam7Cd());
            stmt.setDate( 30, icRatesAddlInfo.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("UPDATE IcRatesAddlInfo SUCCESS:" + icRatesAddlInfo);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRatesAddlInfo FAIL:" + icRatesAddlInfo);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRatesAddlInfo FAIL:" + icRatesAddlInfo);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IcRatesAddlInfo icRatesAddlInfo, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from [IC_RATES_ADDL_INFO] where RATE_PLAN_CD = ?  and DESTINATION_CD = ?  and CHRG_PARAM_ID = ?  and QUAL_PARAM_1_ID = ?  and QUAL_PARAM_1_CD = ?  and QUAL_PARAM_2_ID = ?  and QUAL_PARAM_2_CD = ?  and QUAL_PARAM_3_ID = ?  and QUAL_PARAM_3_CD = ?  and QUAL_PARAM_4_ID = ?  and QUAL_PARAM_4_CD = ?  and QUAL_PARAM_5_ID = ?  and QUAL_PARAM_5_CD = ?  and QUAL_PARAM_6_ID = ?  and QUAL_PARAM_6_CD = ?  and QUAL_PARAM_7_ID = ?  and QUAL_PARAM_7_CD = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icRatesAddlInfo.getRatePlanCd());
            stmt.setString( 2, icRatesAddlInfo.getDestinationCd());
            stmt.setBigDecimal( 3, icRatesAddlInfo.getChrgParamId());
            stmt.setBigDecimal( 4, icRatesAddlInfo.getQualParam1Id());
            stmt.setString( 5, icRatesAddlInfo.getQualParam1Cd());
            stmt.setBigDecimal( 6, icRatesAddlInfo.getQualParam2Id());
            stmt.setString( 7, icRatesAddlInfo.getQualParam2Cd());
            stmt.setBigDecimal( 8, icRatesAddlInfo.getQualParam3Id());
            stmt.setString( 9, icRatesAddlInfo.getQualParam3Cd());
            stmt.setBigDecimal( 10, icRatesAddlInfo.getQualParam4Id());
            stmt.setString( 11, icRatesAddlInfo.getQualParam4Cd());
            stmt.setBigDecimal( 12, icRatesAddlInfo.getQualParam5Id());
            stmt.setString( 13, icRatesAddlInfo.getQualParam5Cd());
            stmt.setBigDecimal( 14, icRatesAddlInfo.getQualParam6Id());
            stmt.setString( 15, icRatesAddlInfo.getQualParam6Cd());
            stmt.setBigDecimal( 16, icRatesAddlInfo.getQualParam7Id());
            stmt.setString( 17, icRatesAddlInfo.getQualParam7Cd());
            stmt.setDate( 18, icRatesAddlInfo.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("DELETE IcRatesAddlInfo SUCCESS:" + icRatesAddlInfo);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IcRatesAddlInfo FAIL:" + icRatesAddlInfo);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IcRatesAddlInfo FAIL:" + icRatesAddlInfo);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IcRatesAddlInfo findByPK( IcRatesAddlInfoPK icRatesAddlInfoPK, Connection conn) throws SQLException {
        return findByPK( icRatesAddlInfoPK.getRatePlanCd(),icRatesAddlInfoPK.getDestinationCd(),icRatesAddlInfoPK.getChrgParamId(),icRatesAddlInfoPK.getQualParam1Id(),icRatesAddlInfoPK.getQualParam1Cd(),icRatesAddlInfoPK.getQualParam2Id(),icRatesAddlInfoPK.getQualParam2Cd(),icRatesAddlInfoPK.getQualParam3Id(),icRatesAddlInfoPK.getQualParam3Cd(),icRatesAddlInfoPK.getQualParam4Id(),icRatesAddlInfoPK.getQualParam4Cd(),icRatesAddlInfoPK.getQualParam5Id(),icRatesAddlInfoPK.getQualParam5Cd(),icRatesAddlInfoPK.getQualParam6Id(),icRatesAddlInfoPK.getQualParam6Cd(),icRatesAddlInfoPK.getQualParam7Id(),icRatesAddlInfoPK.getQualParam7Cd(),icRatesAddlInfoPK.getEffectiveDate(), conn);   
    }


    public IcRatesAddlInfo findByPK( String ratePlanCd,String destinationCd,java.math.BigDecimal chrgParamId,java.math.BigDecimal qualParam1Id,String qualParam1Cd,java.math.BigDecimal qualParam2Id,String qualParam2Cd,java.math.BigDecimal qualParam3Id,String qualParam3Cd,java.math.BigDecimal qualParam4Id,String qualParam4Cd,java.math.BigDecimal qualParam5Id,String qualParam5Cd,java.math.BigDecimal qualParam6Id,String qualParam6Cd,java.math.BigDecimal qualParam7Id,String qualParam7Cd,java.sql.Date effectiveDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from [IC_RATES_ADDL_INFO] where RATE_PLAN_CD = ?  and DESTINATION_CD = ?  and CHRG_PARAM_ID = ?  and QUAL_PARAM_1_ID = ?  and QUAL_PARAM_1_CD = ?  and QUAL_PARAM_2_ID = ?  and QUAL_PARAM_2_CD = ?  and QUAL_PARAM_3_ID = ?  and QUAL_PARAM_3_CD = ?  and QUAL_PARAM_4_ID = ?  and QUAL_PARAM_4_CD = ?  and QUAL_PARAM_5_ID = ?  and QUAL_PARAM_5_CD = ?  and QUAL_PARAM_6_ID = ?  and QUAL_PARAM_6_CD = ?  and QUAL_PARAM_7_ID = ?  and QUAL_PARAM_7_CD = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, ratePlanCd );
            stmt.setString(2, destinationCd );
            stmt.setBigDecimal(3, chrgParamId );
            stmt.setBigDecimal(4, qualParam1Id );
            stmt.setString(5, qualParam1Cd );
            stmt.setBigDecimal(6, qualParam2Id );
            stmt.setString(7, qualParam2Cd );
            stmt.setBigDecimal(8, qualParam3Id );
            stmt.setString(9, qualParam3Cd );
            stmt.setBigDecimal(10, qualParam4Id );
            stmt.setString(11, qualParam4Cd );
            stmt.setBigDecimal(12, qualParam5Id );
            stmt.setString(13, qualParam5Cd );
            stmt.setBigDecimal(14, qualParam6Id );
            stmt.setString(15, qualParam6Cd );
            stmt.setBigDecimal(16, qualParam7Id );
            stmt.setString(17, qualParam7Cd );
            stmt.setDate(18, effectiveDate );
            rs = stmt.executeQuery();
            return fetch(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }

    public List findAll(Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from [IC_RATES_ADDL_INFO]";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }

    public List findByWhereCondisions(String whereConditions, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from [IC_RATES_ADDL_INFO] where " + whereConditions;
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    
    public List findByRatePlanCd( String ratePlanCd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where RATE_PLAN_CD = ? order by RATE_PLAN_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, ratePlanCd );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByDestinationCd( String destinationCd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where DESTINATION_CD = ? order by DESTINATION_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, destinationCd );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByChrgParamId( java.math.BigDecimal chrgParamId, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where CHRG_PARAM_ID = ? order by CHRG_PARAM_ID";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, chrgParamId );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam1Id( java.math.BigDecimal qualParam1Id, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_1_ID = ? order by QUAL_PARAM_1_ID";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, qualParam1Id );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam1Cd( String qualParam1Cd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_1_CD = ? order by QUAL_PARAM_1_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam1Cd );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam2Id( java.math.BigDecimal qualParam2Id, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_2_ID = ? order by QUAL_PARAM_2_ID";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, qualParam2Id );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam2Cd( String qualParam2Cd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_2_CD = ? order by QUAL_PARAM_2_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam2Cd );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam3Id( java.math.BigDecimal qualParam3Id, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_3_ID = ? order by QUAL_PARAM_3_ID";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, qualParam3Id );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam3Cd( String qualParam3Cd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_3_CD = ? order by QUAL_PARAM_3_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam3Cd );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam4Id( java.math.BigDecimal qualParam4Id, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_4_ID = ? order by QUAL_PARAM_4_ID";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, qualParam4Id );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam4Cd( String qualParam4Cd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_4_CD = ? order by QUAL_PARAM_4_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam4Cd );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam5Id( java.math.BigDecimal qualParam5Id, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_5_ID = ? order by QUAL_PARAM_5_ID";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, qualParam5Id );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam5Cd( String qualParam5Cd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_5_CD = ? order by QUAL_PARAM_5_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam5Cd );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam6Id( java.math.BigDecimal qualParam6Id, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_6_ID = ? order by QUAL_PARAM_6_ID";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, qualParam6Id );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam6Cd( String qualParam6Cd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_6_CD = ? order by QUAL_PARAM_6_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam6Cd );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam7Id( java.math.BigDecimal qualParam7Id, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_7_ID = ? order by QUAL_PARAM_7_ID";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, qualParam7Id );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByQualParam7Cd( String qualParam7Cd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where QUAL_PARAM_7_CD = ? order by QUAL_PARAM_7_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam7Cd );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByEffectiveDate( java.sql.Date effectiveDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where EFFECTIVE_DATE = ? order by EFFECTIVE_DATE";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setDate(1, effectiveDate );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findBySysCreationDate( java.sql.Date sysCreationDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setDate(1, sysCreationDate );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findBySysUpdateDate( java.sql.Date sysUpdateDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setDate(1, sysUpdateDate );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByOperatorId( java.math.BigDecimal operatorId, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where OPERATOR_ID = ? order by OPERATOR_ID";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, operatorId );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByApplicationId( String applicationId, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where APPLICATION_ID = ? order by APPLICATION_ID";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, applicationId );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByDlServiceCode( String dlServiceCode, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, dlServiceCode );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByDlUpdateStamp( java.math.BigDecimal dlUpdateStamp, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, dlUpdateStamp );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByRoundingUnit( java.math.BigDecimal roundingUnit, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where ROUNDING_UNIT = ? order by ROUNDING_UNIT";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, roundingUnit );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByMinChrg( java.math.BigDecimal minChrg, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where MIN_CHRG = ? order by MIN_CHRG";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, minChrg );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByMinChrgParam( java.math.BigDecimal minChrgParam, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where MIN_CHRG_PARAM = ? order by MIN_CHRG_PARAM";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, minChrgParam );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByAccesChrg( java.math.BigDecimal accesChrg, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where ACCES_CHRG = ? order by ACCES_CHRG";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, accesChrg );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByAccesChrgSeq( java.math.BigDecimal accesChrgSeq, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where ACCES_CHRG_SEQ = ? order by ACCES_CHRG_SEQ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, accesChrgSeq );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }
    public List findByExpirationDate( java.sql.Date expirationDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_ADDL_INFO] where EXPIRATION_DATE = ? order by EXPIRATION_DATE";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setDate(1, expirationDate );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }

/*    

    public List findByCriteriaOR( IcRatesAddlInfo criteria, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "";
        StringBuffer bf = new StringBuffer("Select * from SMS_APP_SENDER where ");
        String orString = "";
        
        if (criteria.getString() != null) { 
            bf.append(orString + " (RATE_PLAN_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (DESTINATION_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (CHRG_PARAM_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (QUAL_PARAM_1_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_1_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (QUAL_PARAM_2_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_2_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (QUAL_PARAM_3_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_3_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (QUAL_PARAM_4_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_4_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (QUAL_PARAM_5_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_5_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (QUAL_PARAM_6_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_6_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (QUAL_PARAM_7_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_7_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getDate() != null) { 
            bf.append(orString + " (EFFECTIVE_DATE = ?) ");
            orString = "OR";
        }
        if (criteria.getDate() != null) { 
            bf.append(orString + " (SYS_CREATION_DATE = ?) ");
            orString = "OR";
        }
        if (criteria.getDate() != null) { 
            bf.append(orString + " (SYS_UPDATE_DATE = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (OPERATOR_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (APPLICATION_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (DL_SERVICE_CODE = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (DL_UPDATE_STAMP = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (ROUNDING_UNIT = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (MIN_CHRG = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (MIN_CHRG_PARAM = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (ACCES_CHRG = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (ACCES_CHRG_SEQ = ?) ");
            orString = "OR";
        }
        if (criteria.getDate() != null) { 
            bf.append(orString + " (EXPIRATION_DATE = ?) ");
            orString = "OR";
        }

        
        if (!orString.equals(""))
            SQL_STATEMENT = bf.toString();
        else
            return new ArrayList();

        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            int index = 1;
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getDate() != null) 
                stmt.setString(index++, criteria.getDate() );
            if (criteria.getDate() != null) 
                stmt.setString(index++, criteria.getDate() );
            if (criteria.getDate() != null) 
                stmt.setString(index++, criteria.getDate() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getDate() != null) 
                stmt.setString(index++, criteria.getDate() );
            stmt.set${field_item.statementType}(1, ${field_item.name} );
            rs = stmt.executeQuery();
            return fetchAll(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return null;
    }

*/

    public List fetchAll(ResultSet rs) throws SQLException{
        List list = new ArrayList();
        while (rs.next()){
            IcRatesAddlInfo icRatesAddlInfo = new IcRatesAddlInfo();
            icRatesAddlInfo.setRatePlanCd(rs.getString("RATE_PLAN_CD"));
            icRatesAddlInfo.setDestinationCd(rs.getString("DESTINATION_CD"));
            icRatesAddlInfo.setChrgParamId(rs.getBigDecimal("CHRG_PARAM_ID"));
            icRatesAddlInfo.setQualParam1Id(rs.getBigDecimal("QUAL_PARAM_1_ID"));
            icRatesAddlInfo.setQualParam1Cd(rs.getString("QUAL_PARAM_1_CD"));
            icRatesAddlInfo.setQualParam2Id(rs.getBigDecimal("QUAL_PARAM_2_ID"));
            icRatesAddlInfo.setQualParam2Cd(rs.getString("QUAL_PARAM_2_CD"));
            icRatesAddlInfo.setQualParam3Id(rs.getBigDecimal("QUAL_PARAM_3_ID"));
            icRatesAddlInfo.setQualParam3Cd(rs.getString("QUAL_PARAM_3_CD"));
            icRatesAddlInfo.setQualParam4Id(rs.getBigDecimal("QUAL_PARAM_4_ID"));
            icRatesAddlInfo.setQualParam4Cd(rs.getString("QUAL_PARAM_4_CD"));
            icRatesAddlInfo.setQualParam5Id(rs.getBigDecimal("QUAL_PARAM_5_ID"));
            icRatesAddlInfo.setQualParam5Cd(rs.getString("QUAL_PARAM_5_CD"));
            icRatesAddlInfo.setQualParam6Id(rs.getBigDecimal("QUAL_PARAM_6_ID"));
            icRatesAddlInfo.setQualParam6Cd(rs.getString("QUAL_PARAM_6_CD"));
            icRatesAddlInfo.setQualParam7Id(rs.getBigDecimal("QUAL_PARAM_7_ID"));
            icRatesAddlInfo.setQualParam7Cd(rs.getString("QUAL_PARAM_7_CD"));
            icRatesAddlInfo.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
            icRatesAddlInfo.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            icRatesAddlInfo.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            icRatesAddlInfo.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            icRatesAddlInfo.setApplicationId(rs.getString("APPLICATION_ID"));
            icRatesAddlInfo.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            icRatesAddlInfo.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRatesAddlInfo.setRoundingUnit(rs.getBigDecimal("ROUNDING_UNIT"));
            icRatesAddlInfo.setMinChrg(rs.getBigDecimal("MIN_CHRG"));
            icRatesAddlInfo.setMinChrgParam(rs.getBigDecimal("MIN_CHRG_PARAM"));
            icRatesAddlInfo.setAccesChrg(rs.getBigDecimal("ACCES_CHRG"));
            icRatesAddlInfo.setAccesChrgSeq(rs.getBigDecimal("ACCES_CHRG_SEQ"));
            icRatesAddlInfo.setExpirationDate(rs.getDate("EXPIRATION_DATE"));
            list.add(icRatesAddlInfo);
        }
        return list;
    }

    public IcRatesAddlInfo fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IcRatesAddlInfo icRatesAddlInfo = new IcRatesAddlInfo();
            icRatesAddlInfo.setRatePlanCd( rs.getString("RATE_PLAN_CD"));
            icRatesAddlInfo.setDestinationCd( rs.getString("DESTINATION_CD"));
            icRatesAddlInfo.setChrgParamId( rs.getBigDecimal("CHRG_PARAM_ID"));
            icRatesAddlInfo.setQualParam1Id( rs.getBigDecimal("QUAL_PARAM_1_ID"));
            icRatesAddlInfo.setQualParam1Cd( rs.getString("QUAL_PARAM_1_CD"));
            icRatesAddlInfo.setQualParam2Id( rs.getBigDecimal("QUAL_PARAM_2_ID"));
            icRatesAddlInfo.setQualParam2Cd( rs.getString("QUAL_PARAM_2_CD"));
            icRatesAddlInfo.setQualParam3Id( rs.getBigDecimal("QUAL_PARAM_3_ID"));
            icRatesAddlInfo.setQualParam3Cd( rs.getString("QUAL_PARAM_3_CD"));
            icRatesAddlInfo.setQualParam4Id( rs.getBigDecimal("QUAL_PARAM_4_ID"));
            icRatesAddlInfo.setQualParam4Cd( rs.getString("QUAL_PARAM_4_CD"));
            icRatesAddlInfo.setQualParam5Id( rs.getBigDecimal("QUAL_PARAM_5_ID"));
            icRatesAddlInfo.setQualParam5Cd( rs.getString("QUAL_PARAM_5_CD"));
            icRatesAddlInfo.setQualParam6Id( rs.getBigDecimal("QUAL_PARAM_6_ID"));
            icRatesAddlInfo.setQualParam6Cd( rs.getString("QUAL_PARAM_6_CD"));
            icRatesAddlInfo.setQualParam7Id( rs.getBigDecimal("QUAL_PARAM_7_ID"));
            icRatesAddlInfo.setQualParam7Cd( rs.getString("QUAL_PARAM_7_CD"));
            icRatesAddlInfo.setEffectiveDate( rs.getDate("EFFECTIVE_DATE"));
            icRatesAddlInfo.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            icRatesAddlInfo.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            icRatesAddlInfo.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            icRatesAddlInfo.setApplicationId( rs.getString("APPLICATION_ID"));
            icRatesAddlInfo.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            icRatesAddlInfo.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRatesAddlInfo.setRoundingUnit( rs.getBigDecimal("ROUNDING_UNIT"));
            icRatesAddlInfo.setMinChrg( rs.getBigDecimal("MIN_CHRG"));
            icRatesAddlInfo.setMinChrgParam( rs.getBigDecimal("MIN_CHRG_PARAM"));
            icRatesAddlInfo.setAccesChrg( rs.getBigDecimal("ACCES_CHRG"));
            icRatesAddlInfo.setAccesChrgSeq( rs.getBigDecimal("ACCES_CHRG_SEQ"));
            icRatesAddlInfo.setExpirationDate( rs.getDate("EXPIRATION_DATE"));
            return icRatesAddlInfo;
        }
        return null;
    }

	
    public void populateParent(IcRatesAddlInfo icRatesAddlInfo, Connection conn) throws SQLException {
    }

    public void populateChild(IcRatesAddlInfo icRatesAddlInfo, Connection conn) throws SQLException {
    }

    public void populateAll(IcRatesAddlInfo icRatesAddlInfo, Connection conn) throws SQLException {
        populateParent(icRatesAddlInfo, conn);
        populateChild(icRatesAddlInfo, conn);
    }

}
