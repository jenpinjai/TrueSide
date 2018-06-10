
package truecorp.prm.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;
import truecorp.prm.core.dao.SystemBaseDao;
import static truecorp.prm.core.dao.SystemBaseDao.getPrmConnection;
import static truecorp.prm.process.ProcessPRMData.logWriter;
import truecorp.prm.table.IcRates;
import truecorp.prm.table.IcRatesPK;

public class IcRatesBaseDAO extends SystemBaseDao{

    private static Logger log = Logger.getLogger(IcRatesBaseDAO.class);

    /** Creates a new instance of IcRatesDAO */
    public IcRatesBaseDAO() {
    }

    public int insert( IcRates icRates) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into IC_RATES(RATE_PLAN_CD, DESTINATION_CD, CHRG_PARAM_ID, QUAL_PARAM_1_ID, QUAL_PARAM_1_CD, QUAL_PARAM_2_ID, QUAL_PARAM_2_CD, QUAL_PARAM_3_ID, QUAL_PARAM_3_CD, QUAL_PARAM_4_ID, QUAL_PARAM_4_CD, QUAL_PARAM_5_ID, QUAL_PARAM_5_CD, QUAL_PARAM_6_ID, QUAL_PARAM_6_CD, QUAL_PARAM_7_ID, QUAL_PARAM_7_CD, SLAB_NUM, EFFECTIVE_DATE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, RATE_PER_UNIT, RATING_UNIT, RATE_PER_UNIT_SEQ, ONE_TIME_CHRG, ONE_TIME_CHRG_SEQ, EXPIRATION_DATE) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icRates.getRatePlanCd());
            stmt.setString( 2, icRates.getDestinationCd());
            stmt.setBigDecimal( 3, icRates.getChrgParamId());
            stmt.setBigDecimal( 4, icRates.getQualParam1Id());
            stmt.setString( 5, icRates.getQualParam1Cd());
            stmt.setBigDecimal( 6, icRates.getQualParam2Id());
            stmt.setString( 7, icRates.getQualParam2Cd());
            stmt.setBigDecimal( 8, icRates.getQualParam3Id());
            stmt.setString( 9, icRates.getQualParam3Cd());
            stmt.setBigDecimal( 10, icRates.getQualParam4Id());
            stmt.setString( 11, icRates.getQualParam4Cd());
            stmt.setBigDecimal( 12, icRates.getQualParam5Id());
            stmt.setString( 13, icRates.getQualParam5Cd());
            stmt.setBigDecimal( 14, icRates.getQualParam6Id());
            stmt.setString( 15, icRates.getQualParam6Cd());
            stmt.setBigDecimal( 16, icRates.getQualParam7Id());
            stmt.setString( 17, icRates.getQualParam7Cd());
            stmt.setBigDecimal( 18, icRates.getSlabNum());
            stmt.setDate( 19, icRates.getEffectiveDate());
            stmt.setDate( 20, icRates.getSysCreationDate());
            stmt.setDate( 21, icRates.getSysUpdateDate());
            stmt.setBigDecimal( 22, icRates.getOperatorId());
            stmt.setString( 23, icRates.getApplicationId());
            stmt.setString( 24, icRates.getDlServiceCode());
            stmt.setBigDecimal( 25, icRates.getDlUpdateStamp());
            stmt.setBigDecimal( 26, icRates.getRatePerUnit());
            stmt.setBigDecimal( 27, icRates.getRatingUnit());
            stmt.setBigDecimal( 28, icRates.getRatePerUnitSeq());
            stmt.setBigDecimal( 29, icRates.getOneTimeChrg());
            stmt.setBigDecimal( 30, icRates.getOneTimeChrgSeq());
            stmt.setDate( 31, icRates.getExpirationDate());
            int status = stmt.executeUpdate();
            log.info("INSERT IcRates SUCCESS:" + icRates);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IcRates FAIL:" + icRates);
            try{ logWriter.write("Insert IcRates fail:"+icRates.getDestinationCd()+"\t "+icRates.getRatePlanCd()+"\r\n"); } catch(Exception ex2){}
           
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IcRates FAIL:" + icRates);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IcRates icRates) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update IC_RATES set SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , RATE_PER_UNIT = ?  , RATING_UNIT = ?  , RATE_PER_UNIT_SEQ = ?  , ONE_TIME_CHRG = ?  , ONE_TIME_CHRG_SEQ = ?  , EXPIRATION_DATE = ?  ";
	    SQL_STATEMENT += "where RATE_PLAN_CD = ?  and DESTINATION_CD = ?  and CHRG_PARAM_ID = ?  and QUAL_PARAM_1_ID = ?  and QUAL_PARAM_1_CD = ?  and QUAL_PARAM_2_ID = ?  and QUAL_PARAM_2_CD = ?  and QUAL_PARAM_3_ID = ?  and QUAL_PARAM_3_CD = ?  and QUAL_PARAM_4_ID = ?  and QUAL_PARAM_4_CD = ?  and QUAL_PARAM_5_ID = ?  and QUAL_PARAM_5_CD = ?  and QUAL_PARAM_6_ID = ?  and QUAL_PARAM_6_CD = ?  and QUAL_PARAM_7_ID = ?  and QUAL_PARAM_7_CD = ?  and SLAB_NUM = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setDate( 1, icRates.getSysCreationDate());
            stmt.setDate( 2, icRates.getSysUpdateDate());
            stmt.setBigDecimal( 3, icRates.getOperatorId());
            stmt.setString( 4, icRates.getApplicationId());
            stmt.setString( 5, icRates.getDlServiceCode());
            stmt.setBigDecimal( 6, icRates.getDlUpdateStamp());
            stmt.setBigDecimal( 7, icRates.getRatePerUnit());
            stmt.setBigDecimal( 8, icRates.getRatingUnit());
            stmt.setBigDecimal( 9, icRates.getRatePerUnitSeq());
            stmt.setBigDecimal( 10, icRates.getOneTimeChrg());
            stmt.setBigDecimal( 11, icRates.getOneTimeChrgSeq());
            stmt.setDate( 12, icRates.getExpirationDate());
            stmt.setString( 13, icRates.getRatePlanCd());
            stmt.setString( 14, icRates.getDestinationCd());
            stmt.setBigDecimal( 15, icRates.getChrgParamId());
            stmt.setBigDecimal( 16, icRates.getQualParam1Id());
            stmt.setString( 17, icRates.getQualParam1Cd());
            stmt.setBigDecimal( 18, icRates.getQualParam2Id());
            stmt.setString( 19, icRates.getQualParam2Cd());
            stmt.setBigDecimal( 20, icRates.getQualParam3Id());
            stmt.setString( 21, icRates.getQualParam3Cd());
            stmt.setBigDecimal( 22, icRates.getQualParam4Id());
            stmt.setString( 23, icRates.getQualParam4Cd());
            stmt.setBigDecimal( 24, icRates.getQualParam5Id());
            stmt.setString( 25, icRates.getQualParam5Cd());
            stmt.setBigDecimal( 26, icRates.getQualParam6Id());
            stmt.setString( 27, icRates.getQualParam6Cd());
            stmt.setBigDecimal( 28, icRates.getQualParam7Id());
            stmt.setString( 29, icRates.getQualParam7Cd());
            stmt.setBigDecimal( 30, icRates.getSlabNum());
            stmt.setDate( 31, icRates.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("UPDATE IcRates SUCCESS:" + icRates);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRates FAIL:" + icRates);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRates FAIL:" + icRates);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
        public int expireDestinationCd(String destinationCd,java.util.Date expireDate) throws SQLException {
        Statement stmt = null;
        String SQL_STATEMENT ="update IC_RATES set EXPIRATION_DATE = TO_DATE('"+new SimpleDateFormat("dd-MM-yyyy HH:mm:ss",Locale.US).format(expireDate)+"', 'dd-mm-yyyy HH24:MI:SS') "
                            + " where DESTINATION_CD ='"+destinationCd+"'  ";
        try {
                
             stmt=  getPrmConnection().createStatement();
             int status = stmt.executeUpdate(SQL_STATEMENT);
            log.info("UPDATE expireDestinationCd SUCCESS:" + destinationCd);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE expireDestinationCd FAIL:" + destinationCd);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE expireDestinationCd FAIL:" + destinationCd);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int delete( IcRates icRates) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from IC_RATES where RATE_PLAN_CD = ?  and DESTINATION_CD = ?  and CHRG_PARAM_ID = ?  and QUAL_PARAM_1_ID = ?  and QUAL_PARAM_1_CD = ?  and QUAL_PARAM_2_ID = ?  and QUAL_PARAM_2_CD = ?  and QUAL_PARAM_3_ID = ?  and QUAL_PARAM_3_CD = ?  and QUAL_PARAM_4_ID = ?  and QUAL_PARAM_4_CD = ?  and QUAL_PARAM_5_ID = ?  and QUAL_PARAM_5_CD = ?  and QUAL_PARAM_6_ID = ?  and QUAL_PARAM_6_CD = ?  and QUAL_PARAM_7_ID = ?  and QUAL_PARAM_7_CD = ?  and SLAB_NUM = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icRates.getRatePlanCd());
            stmt.setString( 2, icRates.getDestinationCd());
            stmt.setBigDecimal( 3, icRates.getChrgParamId());
            stmt.setBigDecimal( 4, icRates.getQualParam1Id());
            stmt.setString( 5, icRates.getQualParam1Cd());
            stmt.setBigDecimal( 6, icRates.getQualParam2Id());
            stmt.setString( 7, icRates.getQualParam2Cd());
            stmt.setBigDecimal( 8, icRates.getQualParam3Id());
            stmt.setString( 9, icRates.getQualParam3Cd());
            stmt.setBigDecimal( 10, icRates.getQualParam4Id());
            stmt.setString( 11, icRates.getQualParam4Cd());
            stmt.setBigDecimal( 12, icRates.getQualParam5Id());
            stmt.setString( 13, icRates.getQualParam5Cd());
            stmt.setBigDecimal( 14, icRates.getQualParam6Id());
            stmt.setString( 15, icRates.getQualParam6Cd());
            stmt.setBigDecimal( 16, icRates.getQualParam7Id());
            stmt.setString( 17, icRates.getQualParam7Cd());
            stmt.setBigDecimal( 18, icRates.getSlabNum());
            stmt.setDate( 19, icRates.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("DELETE IcRates SUCCESS:" + icRates);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IcRates FAIL:" + icRates);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IcRates FAIL:" + icRates);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IcRates findByPK( IcRatesPK icRatesPK) throws SQLException {
        return findByPK( icRatesPK.getRatePlanCd(),icRatesPK.getDestinationCd(),icRatesPK.getChrgParamId(),icRatesPK.getQualParam1Id(),icRatesPK.getQualParam1Cd(),icRatesPK.getQualParam2Id(),icRatesPK.getQualParam2Cd(),icRatesPK.getQualParam3Id(),icRatesPK.getQualParam3Cd(),icRatesPK.getQualParam4Id(),icRatesPK.getQualParam4Cd(),icRatesPK.getQualParam5Id(),icRatesPK.getQualParam5Cd(),icRatesPK.getQualParam6Id(),icRatesPK.getQualParam6Cd(),icRatesPK.getQualParam7Id(),icRatesPK.getQualParam7Cd(),icRatesPK.getSlabNum(),icRatesPK.getEffectiveDate());   
    }


    public IcRates findByPK( String ratePlanCd,String destinationCd,java.math.BigDecimal chrgParamId,java.math.BigDecimal qualParam1Id,String qualParam1Cd,java.math.BigDecimal qualParam2Id,String qualParam2Cd,java.math.BigDecimal qualParam3Id,String qualParam3Cd,java.math.BigDecimal qualParam4Id,String qualParam4Cd,java.math.BigDecimal qualParam5Id,String qualParam5Cd,java.math.BigDecimal qualParam6Id,String qualParam6Cd,java.math.BigDecimal qualParam7Id,String qualParam7Cd,java.math.BigDecimal slabNum,java.sql.Date effectiveDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from IC_RATES where RATE_PLAN_CD = ?  and DESTINATION_CD = ?  and CHRG_PARAM_ID = ?  and QUAL_PARAM_1_ID = ?  and QUAL_PARAM_1_CD = ?  and QUAL_PARAM_2_ID = ?  and QUAL_PARAM_2_CD = ?  and QUAL_PARAM_3_ID = ?  and QUAL_PARAM_3_CD = ?  and QUAL_PARAM_4_ID = ?  and QUAL_PARAM_4_CD = ?  and QUAL_PARAM_5_ID = ?  and QUAL_PARAM_5_CD = ?  and QUAL_PARAM_6_ID = ?  and QUAL_PARAM_6_CD = ?  and QUAL_PARAM_7_ID = ?  and QUAL_PARAM_7_CD = ?  and SLAB_NUM = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
            stmt.setBigDecimal(18, slabNum );
            stmt.setDate(19, effectiveDate );
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

    public List findAll() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from IC_RATES";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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

    public List findByWhereCondisions(String whereConditions) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from IC_RATES where " + whereConditions;
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    
    public List findByRatePlanCd( String ratePlanCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where RATE_PLAN_CD = ? order by RATE_PLAN_CD";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByDestinationCd( String destinationCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where DESTINATION_CD = ? order by DESTINATION_CD";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByChrgParamId( java.math.BigDecimal chrgParamId) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where CHRG_PARAM_ID = ? order by CHRG_PARAM_ID";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam1Id( java.math.BigDecimal qualParam1Id) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_1_ID = ? order by QUAL_PARAM_1_ID";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam1Cd( String qualParam1Cd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_1_CD = ? order by QUAL_PARAM_1_CD";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam2Id( java.math.BigDecimal qualParam2Id) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_2_ID = ? order by QUAL_PARAM_2_ID";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam2Cd( String qualParam2Cd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_2_CD = ? order by QUAL_PARAM_2_CD";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam3Id( java.math.BigDecimal qualParam3Id) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_3_ID = ? order by QUAL_PARAM_3_ID";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam3Cd( String qualParam3Cd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_3_CD = ? order by QUAL_PARAM_3_CD";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam4Id( java.math.BigDecimal qualParam4Id) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_4_ID = ? order by QUAL_PARAM_4_ID";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam4Cd( String qualParam4Cd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_4_CD = ? order by QUAL_PARAM_4_CD";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam5Id( java.math.BigDecimal qualParam5Id) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_5_ID = ? order by QUAL_PARAM_5_ID";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam5Cd( String qualParam5Cd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_5_CD = ? order by QUAL_PARAM_5_CD";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam6Id( java.math.BigDecimal qualParam6Id) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_6_ID = ? order by QUAL_PARAM_6_ID";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam6Cd( String qualParam6Cd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_6_CD = ? order by QUAL_PARAM_6_CD";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam7Id( java.math.BigDecimal qualParam7Id) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_7_ID = ? order by QUAL_PARAM_7_ID";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByQualParam7Cd( String qualParam7Cd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where QUAL_PARAM_7_CD = ? order by QUAL_PARAM_7_CD";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findBySlabNum( java.math.BigDecimal slabNum) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where SLAB_NUM = ? order by SLAB_NUM";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, slabNum );
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
    public List findByEffectiveDate( java.sql.Date effectiveDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where EFFECTIVE_DATE = ? order by EFFECTIVE_DATE";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findBySysCreationDate( java.sql.Date sysCreationDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findBySysUpdateDate( java.sql.Date sysUpdateDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByOperatorId( java.math.BigDecimal operatorId) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where OPERATOR_ID = ? order by OPERATOR_ID";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByApplicationId( String applicationId) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where APPLICATION_ID = ? order by APPLICATION_ID";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByDlServiceCode( String dlServiceCode) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByDlUpdateStamp( java.math.BigDecimal dlUpdateStamp) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByRatePerUnit( java.math.BigDecimal ratePerUnit) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where RATE_PER_UNIT = ? order by RATE_PER_UNIT";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, ratePerUnit );
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
    public List findByRatingUnit( java.math.BigDecimal ratingUnit) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where RATING_UNIT = ? order by RATING_UNIT";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByRatePerUnitSeq( java.math.BigDecimal ratePerUnitSeq) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where RATE_PER_UNIT_SEQ = ? order by RATE_PER_UNIT_SEQ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, ratePerUnitSeq );
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
    public List findByOneTimeChrg( java.math.BigDecimal oneTimeChrg) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where ONE_TIME_CHRG = ? order by ONE_TIME_CHRG";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByOneTimeChrgSeq( java.math.BigDecimal oneTimeChrgSeq) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where ONE_TIME_CHRG_SEQ = ? order by ONE_TIME_CHRG_SEQ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, oneTimeChrgSeq );
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
    public List findByExpirationDate( java.sql.Date expirationDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_RATES where EXPIRATION_DATE = ? order by EXPIRATION_DATE";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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

    public List findByCriteriaOR( IcRates criteria) throws SQLException {
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
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (SLAB_NUM = ?) ");
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
            bf.append(orString + " (RATE_PER_UNIT = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (RATING_UNIT = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (RATE_PER_UNIT_SEQ = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (ONE_TIME_CHRG = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (ONE_TIME_CHRG_SEQ = ?) ");
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
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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

    public List<IcRates> fetchAll(ResultSet rs) throws SQLException{
        List<IcRates> list = new ArrayList<IcRates>();
        while (rs.next()){
            IcRates icRates = new IcRates();
            icRates.setRatePlanCd(rs.getString("RATE_PLAN_CD"));
            icRates.setDestinationCd(rs.getString("DESTINATION_CD"));
            icRates.setChrgParamId(rs.getBigDecimal("CHRG_PARAM_ID"));
            icRates.setQualParam1Id(rs.getBigDecimal("QUAL_PARAM_1_ID"));
            icRates.setQualParam1Cd(rs.getString("QUAL_PARAM_1_CD"));
            icRates.setQualParam2Id(rs.getBigDecimal("QUAL_PARAM_2_ID"));
            icRates.setQualParam2Cd(rs.getString("QUAL_PARAM_2_CD"));
            icRates.setQualParam3Id(rs.getBigDecimal("QUAL_PARAM_3_ID"));
            icRates.setQualParam3Cd(rs.getString("QUAL_PARAM_3_CD"));
            icRates.setQualParam4Id(rs.getBigDecimal("QUAL_PARAM_4_ID"));
            icRates.setQualParam4Cd(rs.getString("QUAL_PARAM_4_CD"));
            icRates.setQualParam5Id(rs.getBigDecimal("QUAL_PARAM_5_ID"));
            icRates.setQualParam5Cd(rs.getString("QUAL_PARAM_5_CD"));
            icRates.setQualParam6Id(rs.getBigDecimal("QUAL_PARAM_6_ID"));
            icRates.setQualParam6Cd(rs.getString("QUAL_PARAM_6_CD"));
            icRates.setQualParam7Id(rs.getBigDecimal("QUAL_PARAM_7_ID"));
            icRates.setQualParam7Cd(rs.getString("QUAL_PARAM_7_CD"));
            icRates.setSlabNum(rs.getBigDecimal("SLAB_NUM"));
            icRates.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
            icRates.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            icRates.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            icRates.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            icRates.setApplicationId(rs.getString("APPLICATION_ID"));
            icRates.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            icRates.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRates.setRatePerUnit(rs.getBigDecimal("RATE_PER_UNIT"));
            icRates.setRatingUnit(rs.getBigDecimal("RATING_UNIT"));
            icRates.setRatePerUnitSeq(rs.getBigDecimal("RATE_PER_UNIT_SEQ"));
            icRates.setOneTimeChrg(rs.getBigDecimal("ONE_TIME_CHRG"));
            icRates.setOneTimeChrgSeq(rs.getBigDecimal("ONE_TIME_CHRG_SEQ"));
            icRates.setExpirationDate(rs.getDate("EXPIRATION_DATE"));
            list.add(icRates);
        }
        return list;
    }

    public IcRates fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IcRates icRates = new IcRates();
            icRates.setRatePlanCd( rs.getString("RATE_PLAN_CD"));
            icRates.setDestinationCd( rs.getString("DESTINATION_CD"));
            icRates.setChrgParamId( rs.getBigDecimal("CHRG_PARAM_ID"));
            icRates.setQualParam1Id( rs.getBigDecimal("QUAL_PARAM_1_ID"));
            icRates.setQualParam1Cd( rs.getString("QUAL_PARAM_1_CD"));
            icRates.setQualParam2Id( rs.getBigDecimal("QUAL_PARAM_2_ID"));
            icRates.setQualParam2Cd( rs.getString("QUAL_PARAM_2_CD"));
            icRates.setQualParam3Id( rs.getBigDecimal("QUAL_PARAM_3_ID"));
            icRates.setQualParam3Cd( rs.getString("QUAL_PARAM_3_CD"));
            icRates.setQualParam4Id( rs.getBigDecimal("QUAL_PARAM_4_ID"));
            icRates.setQualParam4Cd( rs.getString("QUAL_PARAM_4_CD"));
            icRates.setQualParam5Id( rs.getBigDecimal("QUAL_PARAM_5_ID"));
            icRates.setQualParam5Cd( rs.getString("QUAL_PARAM_5_CD"));
            icRates.setQualParam6Id( rs.getBigDecimal("QUAL_PARAM_6_ID"));
            icRates.setQualParam6Cd( rs.getString("QUAL_PARAM_6_CD"));
            icRates.setQualParam7Id( rs.getBigDecimal("QUAL_PARAM_7_ID"));
            icRates.setQualParam7Cd( rs.getString("QUAL_PARAM_7_CD"));
            icRates.setSlabNum( rs.getBigDecimal("SLAB_NUM"));
            icRates.setEffectiveDate( rs.getDate("EFFECTIVE_DATE"));
            icRates.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            icRates.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            icRates.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            icRates.setApplicationId( rs.getString("APPLICATION_ID"));
            icRates.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            icRates.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRates.setRatePerUnit( rs.getBigDecimal("RATE_PER_UNIT"));
            icRates.setRatingUnit( rs.getBigDecimal("RATING_UNIT"));
            icRates.setRatePerUnitSeq( rs.getBigDecimal("RATE_PER_UNIT_SEQ"));
            icRates.setOneTimeChrg( rs.getBigDecimal("ONE_TIME_CHRG"));
            icRates.setOneTimeChrgSeq( rs.getBigDecimal("ONE_TIME_CHRG_SEQ"));
            icRates.setExpirationDate( rs.getDate("EXPIRATION_DATE"));
            return icRates;
        }
        return null;
    }


    public void populateParent(IcRates icRates) throws SQLException {
    }

    public void populateChild(IcRates icRates) throws SQLException {
    }

    public void populateAll(IcRates icRates) throws SQLException {
        populateParent(icRates);
        populateChild(icRates);
    }
    public int deleteAllBy(String prmCd ,String ratePlanCode) throws SQLException {
        Statement stmt = null;
        String SQL_STATEMENT ="delete ic_rates where substr(DESTINATION_CD,1,2)= '"+prmCd+"' and RATE_PLAN_CD= '"+ratePlanCode+"'  ";
        try {
            stmt = getPrmConnection().createStatement();
            int status = stmt.executeUpdate(SQL_STATEMENT);
            log.info("DELETE IcRates SUCCESS");
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IcRates FAIL");
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IcRates FAIL");
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }

}
