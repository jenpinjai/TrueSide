
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.table.IcRatedDestination;
import truecorp.prm.table.IcRatedDestinationPK;


public class IcRatedDestinationBaseDAO {

    private static Logger log = Logger.getLogger(IcRatedDestinationBaseDAO.class);

    /** Creates a new instance of IcRatedDestinationDAO */
    public IcRatedDestinationBaseDAO() {
    }

    public int insert( IcRatedDestination icRatedDestination, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into [IC_RATED_DESTINATION](RATE_PLAN_CD, DESTINATION_CD, CHRG_PARAM_ID, EFFECTIVE_DATE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, QUAL_PARAM_1_ID, QUAL_PARAM_1_SET_CD, QUAL_PARAM_2_ID, QUAL_PARAM_2_SET_CD, QUAL_PARAM_3_ID, QUAL_PARAM_3_SET_CD, QUAL_PARAM_4_ID, QUAL_PARAM_4_SET_CD, QUAL_PARAM_5_ID, QUAL_PARAM_5_SET_CD, QUAL_PARAM_6_ID, QUAL_PARAM_6_SET_CD, QUAL_PARAM_7_ID, QUAL_PARAM_7_SET_CD, DEST_SORT_ORDER_CD, RATES_PRES_IND, UOM, MIN_CHRG_PARAM, ROUNDING_UNIT, RATING_UNIT, RATE_SCHEME_IND, MIN_CHRG, PARAM_DSP_ORDER, ONE_TIME_CHRG, ACCES_CHRG, EXPIRATION_DATE) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icRatedDestination.getRatePlanCd());
            stmt.setString( 2, icRatedDestination.getDestinationCd());
            stmt.setBigDecimal( 3, icRatedDestination.getChrgParamId());
            stmt.setDate( 4, icRatedDestination.getEffectiveDate());
            stmt.setDate( 5, icRatedDestination.getSysCreationDate());
            stmt.setDate( 6, icRatedDestination.getSysUpdateDate());
            stmt.setBigDecimal( 7, icRatedDestination.getOperatorId());
            stmt.setString( 8, icRatedDestination.getApplicationId());
            stmt.setString( 9, icRatedDestination.getDlServiceCode());
            stmt.setBigDecimal( 10, icRatedDestination.getDlUpdateStamp());
            stmt.setBigDecimal( 11, icRatedDestination.getQualParam1Id());
            stmt.setString( 12, icRatedDestination.getQualParam1SetCd());
            stmt.setBigDecimal( 13, icRatedDestination.getQualParam2Id());
            stmt.setString( 14, icRatedDestination.getQualParam2SetCd());
            stmt.setBigDecimal( 15, icRatedDestination.getQualParam3Id());
            stmt.setString( 16, icRatedDestination.getQualParam3SetCd());
            stmt.setBigDecimal( 17, icRatedDestination.getQualParam4Id());
            stmt.setString( 18, icRatedDestination.getQualParam4SetCd());
            stmt.setBigDecimal( 19, icRatedDestination.getQualParam5Id());
            stmt.setString( 20, icRatedDestination.getQualParam5SetCd());
            stmt.setBigDecimal( 21, icRatedDestination.getQualParam6Id());
            stmt.setString( 22, icRatedDestination.getQualParam6SetCd());
            stmt.setBigDecimal( 23, icRatedDestination.getQualParam7Id());
            stmt.setString( 24, icRatedDestination.getQualParam7SetCd());
            stmt.setBigDecimal( 25, icRatedDestination.getDestSortOrderCd());
            stmt.setString( 26, icRatedDestination.getRatesPresInd());
            stmt.setString( 27, icRatedDestination.getUom());
            stmt.setBigDecimal( 28, icRatedDestination.getMinChrgParam());
            stmt.setBigDecimal( 29, icRatedDestination.getRoundingUnit());
            stmt.setBigDecimal( 30, icRatedDestination.getRatingUnit());
            stmt.setString( 31, icRatedDestination.getRateSchemeInd());
            stmt.setBigDecimal( 32, icRatedDestination.getMinChrg());
            stmt.setString( 33, icRatedDestination.getParamDspOrder());
            stmt.setBigDecimal( 34, icRatedDestination.getOneTimeChrg());
            stmt.setBigDecimal( 35, icRatedDestination.getAccesChrg());
            stmt.setDate( 36, icRatedDestination.getExpirationDate());
            int status = stmt.executeUpdate();
            log.info("INSERT IcRatedDestination SUCCESS:" + icRatedDestination);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IcRatedDestination FAIL:" + icRatedDestination);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IcRatedDestination FAIL:" + icRatedDestination);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IcRatedDestination icRatedDestination, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update [IC_RATED_DESTINATION] set SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , QUAL_PARAM_1_ID = ?  , QUAL_PARAM_1_SET_CD = ?  , QUAL_PARAM_2_ID = ?  , QUAL_PARAM_2_SET_CD = ?  , QUAL_PARAM_3_ID = ?  , QUAL_PARAM_3_SET_CD = ?  , QUAL_PARAM_4_ID = ?  , QUAL_PARAM_4_SET_CD = ?  , QUAL_PARAM_5_ID = ?  , QUAL_PARAM_5_SET_CD = ?  , QUAL_PARAM_6_ID = ?  , QUAL_PARAM_6_SET_CD = ?  , QUAL_PARAM_7_ID = ?  , QUAL_PARAM_7_SET_CD = ?  , DEST_SORT_ORDER_CD = ?  , RATES_PRES_IND = ?  , UOM = ?  , MIN_CHRG_PARAM = ?  , ROUNDING_UNIT = ?  , RATING_UNIT = ?  , RATE_SCHEME_IND = ?  , MIN_CHRG = ?  , PARAM_DSP_ORDER = ?  , ONE_TIME_CHRG = ?  , ACCES_CHRG = ?  , EXPIRATION_DATE = ?  ";
	    SQL_STATEMENT += "where RATE_PLAN_CD = ?  and DESTINATION_CD = ?  and CHRG_PARAM_ID = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setDate( 1, icRatedDestination.getSysCreationDate());
            stmt.setDate( 2, icRatedDestination.getSysUpdateDate());
            stmt.setBigDecimal( 3, icRatedDestination.getOperatorId());
            stmt.setString( 4, icRatedDestination.getApplicationId());
            stmt.setString( 5, icRatedDestination.getDlServiceCode());
            stmt.setBigDecimal( 6, icRatedDestination.getDlUpdateStamp());
            stmt.setBigDecimal( 7, icRatedDestination.getQualParam1Id());
            stmt.setString( 8, icRatedDestination.getQualParam1SetCd());
            stmt.setBigDecimal( 9, icRatedDestination.getQualParam2Id());
            stmt.setString( 10, icRatedDestination.getQualParam2SetCd());
            stmt.setBigDecimal( 11, icRatedDestination.getQualParam3Id());
            stmt.setString( 12, icRatedDestination.getQualParam3SetCd());
            stmt.setBigDecimal( 13, icRatedDestination.getQualParam4Id());
            stmt.setString( 14, icRatedDestination.getQualParam4SetCd());
            stmt.setBigDecimal( 15, icRatedDestination.getQualParam5Id());
            stmt.setString( 16, icRatedDestination.getQualParam5SetCd());
            stmt.setBigDecimal( 17, icRatedDestination.getQualParam6Id());
            stmt.setString( 18, icRatedDestination.getQualParam6SetCd());
            stmt.setBigDecimal( 19, icRatedDestination.getQualParam7Id());
            stmt.setString( 20, icRatedDestination.getQualParam7SetCd());
            stmt.setBigDecimal( 21, icRatedDestination.getDestSortOrderCd());
            stmt.setString( 22, icRatedDestination.getRatesPresInd());
            stmt.setString( 23, icRatedDestination.getUom());
            stmt.setBigDecimal( 24, icRatedDestination.getMinChrgParam());
            stmt.setBigDecimal( 25, icRatedDestination.getRoundingUnit());
            stmt.setBigDecimal( 26, icRatedDestination.getRatingUnit());
            stmt.setString( 27, icRatedDestination.getRateSchemeInd());
            stmt.setBigDecimal( 28, icRatedDestination.getMinChrg());
            stmt.setString( 29, icRatedDestination.getParamDspOrder());
            stmt.setBigDecimal( 30, icRatedDestination.getOneTimeChrg());
            stmt.setBigDecimal( 31, icRatedDestination.getAccesChrg());
            stmt.setDate( 32, icRatedDestination.getExpirationDate());
            stmt.setString( 33, icRatedDestination.getRatePlanCd());
            stmt.setString( 34, icRatedDestination.getDestinationCd());
            stmt.setBigDecimal( 35, icRatedDestination.getChrgParamId());
            stmt.setDate( 36, icRatedDestination.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("UPDATE IcRatedDestination SUCCESS:" + icRatedDestination);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRatedDestination FAIL:" + icRatedDestination);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRatedDestination FAIL:" + icRatedDestination);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IcRatedDestination icRatedDestination, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from [IC_RATED_DESTINATION] where RATE_PLAN_CD = ?  and DESTINATION_CD = ?  and CHRG_PARAM_ID = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icRatedDestination.getRatePlanCd());
            stmt.setString( 2, icRatedDestination.getDestinationCd());
            stmt.setBigDecimal( 3, icRatedDestination.getChrgParamId());
            stmt.setDate( 4, icRatedDestination.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("DELETE IcRatedDestination SUCCESS:" + icRatedDestination);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IcRatedDestination FAIL:" + icRatedDestination);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IcRatedDestination FAIL:" + icRatedDestination);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IcRatedDestination findByPK( IcRatedDestinationPK icRatedDestinationPK, Connection conn) throws SQLException {
        return findByPK( icRatedDestinationPK.getRatePlanCd(),icRatedDestinationPK.getDestinationCd(),icRatedDestinationPK.getChrgParamId(),icRatedDestinationPK.getEffectiveDate(), conn);   
    }


    public IcRatedDestination findByPK( String ratePlanCd,String destinationCd,java.math.BigDecimal chrgParamId,java.sql.Date effectiveDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from [IC_RATED_DESTINATION] where RATE_PLAN_CD = ?  and DESTINATION_CD = ?  and CHRG_PARAM_ID = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, ratePlanCd );
            stmt.setString(2, destinationCd );
            stmt.setBigDecimal(3, chrgParamId );
            stmt.setDate(4, effectiveDate );
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
        String SQL_STATEMENT ="Select * from [IC_RATED_DESTINATION]";
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
        String SQL_STATEMENT ="Select * from [IC_RATED_DESTINATION] where " + whereConditions;
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where RATE_PLAN_CD = ? order by RATE_PLAN_CD";
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where DESTINATION_CD = ? order by DESTINATION_CD";
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where CHRG_PARAM_ID = ? order by CHRG_PARAM_ID";
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
    public List findByEffectiveDate( java.sql.Date effectiveDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where EFFECTIVE_DATE = ? order by EFFECTIVE_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where OPERATOR_ID = ? order by OPERATOR_ID";
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where APPLICATION_ID = ? order by APPLICATION_ID";
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
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
    public List findByQualParam1Id( java.math.BigDecimal qualParam1Id, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_1_ID = ? order by QUAL_PARAM_1_ID";
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
    public List findByQualParam1SetCd( String qualParam1SetCd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_1_SET_CD = ? order by QUAL_PARAM_1_SET_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam1SetCd );
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_2_ID = ? order by QUAL_PARAM_2_ID";
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
    public List findByQualParam2SetCd( String qualParam2SetCd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_2_SET_CD = ? order by QUAL_PARAM_2_SET_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam2SetCd );
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_3_ID = ? order by QUAL_PARAM_3_ID";
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
    public List findByQualParam3SetCd( String qualParam3SetCd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_3_SET_CD = ? order by QUAL_PARAM_3_SET_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam3SetCd );
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_4_ID = ? order by QUAL_PARAM_4_ID";
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
    public List findByQualParam4SetCd( String qualParam4SetCd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_4_SET_CD = ? order by QUAL_PARAM_4_SET_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam4SetCd );
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_5_ID = ? order by QUAL_PARAM_5_ID";
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
    public List findByQualParam5SetCd( String qualParam5SetCd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_5_SET_CD = ? order by QUAL_PARAM_5_SET_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam5SetCd );
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_6_ID = ? order by QUAL_PARAM_6_ID";
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
    public List findByQualParam6SetCd( String qualParam6SetCd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_6_SET_CD = ? order by QUAL_PARAM_6_SET_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam6SetCd );
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_7_ID = ? order by QUAL_PARAM_7_ID";
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
    public List findByQualParam7SetCd( String qualParam7SetCd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where QUAL_PARAM_7_SET_CD = ? order by QUAL_PARAM_7_SET_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, qualParam7SetCd );
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
    public List findByDestSortOrderCd( java.math.BigDecimal destSortOrderCd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where DEST_SORT_ORDER_CD = ? order by DEST_SORT_ORDER_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, destSortOrderCd );
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
    public List findByRatesPresInd( String ratesPresInd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where RATES_PRES_IND = ? order by RATES_PRES_IND";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, ratesPresInd );
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
    public List findByUom( String uom, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where UOM = ? order by UOM";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, uom );
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where MIN_CHRG_PARAM = ? order by MIN_CHRG_PARAM";
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
    public List findByRoundingUnit( java.math.BigDecimal roundingUnit, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where ROUNDING_UNIT = ? order by ROUNDING_UNIT";
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
    public List findByRatingUnit( java.math.BigDecimal ratingUnit, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where RATING_UNIT = ? order by RATING_UNIT";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, ratingUnit );
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
    public List findByRateSchemeInd( String rateSchemeInd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where RATE_SCHEME_IND = ? order by RATE_SCHEME_IND";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, rateSchemeInd );
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where MIN_CHRG = ? order by MIN_CHRG";
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
    public List findByParamDspOrder( String paramDspOrder, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where PARAM_DSP_ORDER = ? order by PARAM_DSP_ORDER";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, paramDspOrder );
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
    public List findByOneTimeChrg( java.math.BigDecimal oneTimeChrg, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where ONE_TIME_CHRG = ? order by ONE_TIME_CHRG";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, oneTimeChrg );
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
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where ACCES_CHRG = ? order by ACCES_CHRG";
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
    public List findByExpirationDate( java.sql.Date expirationDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATED_DESTINATION] where EXPIRATION_DATE = ? order by EXPIRATION_DATE";
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

    public List findByCriteriaOR( IcRatedDestination criteria, Connection conn) throws SQLException {
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
            bf.append(orString + " (QUAL_PARAM_1_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_1_SET_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (QUAL_PARAM_2_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_2_SET_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (QUAL_PARAM_3_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_3_SET_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (QUAL_PARAM_4_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_4_SET_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (QUAL_PARAM_5_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_5_SET_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (QUAL_PARAM_6_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_6_SET_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (QUAL_PARAM_7_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (QUAL_PARAM_7_SET_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (DEST_SORT_ORDER_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (RATES_PRES_IND = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (UOM = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (MIN_CHRG_PARAM = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (ROUNDING_UNIT = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (RATING_UNIT = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (RATE_SCHEME_IND = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (MIN_CHRG = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (PARAM_DSP_ORDER = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (ONE_TIME_CHRG = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (ACCES_CHRG = ?) ");
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
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
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
            IcRatedDestination icRatedDestination = new IcRatedDestination();
            icRatedDestination.setRatePlanCd(rs.getString("RATE_PLAN_CD"));
            icRatedDestination.setDestinationCd(rs.getString("DESTINATION_CD"));
            icRatedDestination.setChrgParamId(rs.getBigDecimal("CHRG_PARAM_ID"));
            icRatedDestination.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
            icRatedDestination.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            icRatedDestination.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            icRatedDestination.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            icRatedDestination.setApplicationId(rs.getString("APPLICATION_ID"));
            icRatedDestination.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            icRatedDestination.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRatedDestination.setQualParam1Id(rs.getBigDecimal("QUAL_PARAM_1_ID"));
            icRatedDestination.setQualParam1SetCd(rs.getString("QUAL_PARAM_1_SET_CD"));
            icRatedDestination.setQualParam2Id(rs.getBigDecimal("QUAL_PARAM_2_ID"));
            icRatedDestination.setQualParam2SetCd(rs.getString("QUAL_PARAM_2_SET_CD"));
            icRatedDestination.setQualParam3Id(rs.getBigDecimal("QUAL_PARAM_3_ID"));
            icRatedDestination.setQualParam3SetCd(rs.getString("QUAL_PARAM_3_SET_CD"));
            icRatedDestination.setQualParam4Id(rs.getBigDecimal("QUAL_PARAM_4_ID"));
            icRatedDestination.setQualParam4SetCd(rs.getString("QUAL_PARAM_4_SET_CD"));
            icRatedDestination.setQualParam5Id(rs.getBigDecimal("QUAL_PARAM_5_ID"));
            icRatedDestination.setQualParam5SetCd(rs.getString("QUAL_PARAM_5_SET_CD"));
            icRatedDestination.setQualParam6Id(rs.getBigDecimal("QUAL_PARAM_6_ID"));
            icRatedDestination.setQualParam6SetCd(rs.getString("QUAL_PARAM_6_SET_CD"));
            icRatedDestination.setQualParam7Id(rs.getBigDecimal("QUAL_PARAM_7_ID"));
            icRatedDestination.setQualParam7SetCd(rs.getString("QUAL_PARAM_7_SET_CD"));
            icRatedDestination.setDestSortOrderCd(rs.getBigDecimal("DEST_SORT_ORDER_CD"));
            icRatedDestination.setRatesPresInd(rs.getString("RATES_PRES_IND"));
            icRatedDestination.setUom(rs.getString("UOM"));
            icRatedDestination.setMinChrgParam(rs.getBigDecimal("MIN_CHRG_PARAM"));
            icRatedDestination.setRoundingUnit(rs.getBigDecimal("ROUNDING_UNIT"));
            icRatedDestination.setRatingUnit(rs.getBigDecimal("RATING_UNIT"));
            icRatedDestination.setRateSchemeInd(rs.getString("RATE_SCHEME_IND"));
            icRatedDestination.setMinChrg(rs.getBigDecimal("MIN_CHRG"));
            icRatedDestination.setParamDspOrder(rs.getString("PARAM_DSP_ORDER"));
            icRatedDestination.setOneTimeChrg(rs.getBigDecimal("ONE_TIME_CHRG"));
            icRatedDestination.setAccesChrg(rs.getBigDecimal("ACCES_CHRG"));
            icRatedDestination.setExpirationDate(rs.getDate("EXPIRATION_DATE"));
            list.add(icRatedDestination);
        }
        return list;
    }

    public IcRatedDestination fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IcRatedDestination icRatedDestination = new IcRatedDestination();
            icRatedDestination.setRatePlanCd( rs.getString("RATE_PLAN_CD"));
            icRatedDestination.setDestinationCd( rs.getString("DESTINATION_CD"));
            icRatedDestination.setChrgParamId( rs.getBigDecimal("CHRG_PARAM_ID"));
            icRatedDestination.setEffectiveDate( rs.getDate("EFFECTIVE_DATE"));
            icRatedDestination.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            icRatedDestination.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            icRatedDestination.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            icRatedDestination.setApplicationId( rs.getString("APPLICATION_ID"));
            icRatedDestination.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            icRatedDestination.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRatedDestination.setQualParam1Id( rs.getBigDecimal("QUAL_PARAM_1_ID"));
            icRatedDestination.setQualParam1SetCd( rs.getString("QUAL_PARAM_1_SET_CD"));
            icRatedDestination.setQualParam2Id( rs.getBigDecimal("QUAL_PARAM_2_ID"));
            icRatedDestination.setQualParam2SetCd( rs.getString("QUAL_PARAM_2_SET_CD"));
            icRatedDestination.setQualParam3Id( rs.getBigDecimal("QUAL_PARAM_3_ID"));
            icRatedDestination.setQualParam3SetCd( rs.getString("QUAL_PARAM_3_SET_CD"));
            icRatedDestination.setQualParam4Id( rs.getBigDecimal("QUAL_PARAM_4_ID"));
            icRatedDestination.setQualParam4SetCd( rs.getString("QUAL_PARAM_4_SET_CD"));
            icRatedDestination.setQualParam5Id( rs.getBigDecimal("QUAL_PARAM_5_ID"));
            icRatedDestination.setQualParam5SetCd( rs.getString("QUAL_PARAM_5_SET_CD"));
            icRatedDestination.setQualParam6Id( rs.getBigDecimal("QUAL_PARAM_6_ID"));
            icRatedDestination.setQualParam6SetCd( rs.getString("QUAL_PARAM_6_SET_CD"));
            icRatedDestination.setQualParam7Id( rs.getBigDecimal("QUAL_PARAM_7_ID"));
            icRatedDestination.setQualParam7SetCd( rs.getString("QUAL_PARAM_7_SET_CD"));
            icRatedDestination.setDestSortOrderCd( rs.getBigDecimal("DEST_SORT_ORDER_CD"));
            icRatedDestination.setRatesPresInd( rs.getString("RATES_PRES_IND"));
            icRatedDestination.setUom( rs.getString("UOM"));
            icRatedDestination.setMinChrgParam( rs.getBigDecimal("MIN_CHRG_PARAM"));
            icRatedDestination.setRoundingUnit( rs.getBigDecimal("ROUNDING_UNIT"));
            icRatedDestination.setRatingUnit( rs.getBigDecimal("RATING_UNIT"));
            icRatedDestination.setRateSchemeInd( rs.getString("RATE_SCHEME_IND"));
            icRatedDestination.setMinChrg( rs.getBigDecimal("MIN_CHRG"));
            icRatedDestination.setParamDspOrder( rs.getString("PARAM_DSP_ORDER"));
            icRatedDestination.setOneTimeChrg( rs.getBigDecimal("ONE_TIME_CHRG"));
            icRatedDestination.setAccesChrg( rs.getBigDecimal("ACCES_CHRG"));
            icRatedDestination.setExpirationDate( rs.getDate("EXPIRATION_DATE"));
            return icRatedDestination;
        }
        return null;
    }

    public void populateParent(IcRatedDestination icRatedDestination, Connection conn) throws SQLException {
    }

    public void populateChild(IcRatedDestination icRatedDestination, Connection conn) throws SQLException {
    }

    public void populateAll(IcRatedDestination icRatedDestination, Connection conn) throws SQLException {
        populateParent(icRatedDestination, conn);
        populateChild(icRatedDestination, conn);
    }

}
