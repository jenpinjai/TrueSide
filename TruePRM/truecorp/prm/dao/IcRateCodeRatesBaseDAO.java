
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.table.*;


public class IcRateCodeRatesBaseDAO {

    private static Logger log = Logger.getLogger(IcRateCodeRatesBaseDAO.class);

    /** Creates a new instance of IcRateCodeRatesDAO */
    public IcRateCodeRatesBaseDAO() {
    }

    public int insert( IcRateCodeRates icRateCodeRates, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into [IC_RATE_CODE_RATES](RATE_CLASS_SET_CD, RATE_CD_SEQ, EFFECTIVE_DATE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, RATING_UNIT, RATE, UOM, EXPIRATION_DATE) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icRateCodeRates.getRateClassSetCd());
            stmt.setBigDecimal( 2, icRateCodeRates.getRateCdSeq());
            stmt.setDate( 3, icRateCodeRates.getEffectiveDate());
            stmt.setDate( 4, icRateCodeRates.getSysCreationDate());
            stmt.setDate( 5, icRateCodeRates.getSysUpdateDate());
            stmt.setBigDecimal( 6, icRateCodeRates.getOperatorId());
            stmt.setString( 7, icRateCodeRates.getApplicationId());
            stmt.setString( 8, icRateCodeRates.getDlServiceCode());
            stmt.setBigDecimal( 9, icRateCodeRates.getDlUpdateStamp());
            stmt.setBigDecimal( 10, icRateCodeRates.getRatingUnit());
            stmt.setBigDecimal( 11, icRateCodeRates.getRate());
            stmt.setString( 12, icRateCodeRates.getUom());
            stmt.setDate( 13, icRateCodeRates.getExpirationDate());
            int status = stmt.executeUpdate();
            log.info("INSERT IcRateCodeRates SUCCESS:" + icRateCodeRates);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IcRateCodeRates FAIL:" + icRateCodeRates);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IcRateCodeRates FAIL:" + icRateCodeRates);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IcRateCodeRates icRateCodeRates, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update [IC_RATE_CODE_RATES] set SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , RATING_UNIT = ?  , RATE = ?  , UOM = ?  , EXPIRATION_DATE = ?  ";
	    SQL_STATEMENT += "where RATE_CLASS_SET_CD = ?  and RATE_CD_SEQ = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setDate( 1, icRateCodeRates.getSysCreationDate());
            stmt.setDate( 2, icRateCodeRates.getSysUpdateDate());
            stmt.setBigDecimal( 3, icRateCodeRates.getOperatorId());
            stmt.setString( 4, icRateCodeRates.getApplicationId());
            stmt.setString( 5, icRateCodeRates.getDlServiceCode());
            stmt.setBigDecimal( 6, icRateCodeRates.getDlUpdateStamp());
            stmt.setBigDecimal( 7, icRateCodeRates.getRatingUnit());
            stmt.setBigDecimal( 8, icRateCodeRates.getRate());
            stmt.setString( 9, icRateCodeRates.getUom());
            stmt.setDate( 10, icRateCodeRates.getExpirationDate());
            stmt.setString( 11, icRateCodeRates.getRateClassSetCd());
            stmt.setBigDecimal( 12, icRateCodeRates.getRateCdSeq());
            stmt.setDate( 13, icRateCodeRates.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("UPDATE IcRateCodeRates SUCCESS:" + icRateCodeRates);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRateCodeRates FAIL:" + icRateCodeRates);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRateCodeRates FAIL:" + icRateCodeRates);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IcRateCodeRates icRateCodeRates, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from [IC_RATE_CODE_RATES] where RATE_CLASS_SET_CD = ?  and RATE_CD_SEQ = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icRateCodeRates.getRateClassSetCd());
            stmt.setBigDecimal( 2, icRateCodeRates.getRateCdSeq());
            stmt.setDate( 3, icRateCodeRates.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("DELETE IcRateCodeRates SUCCESS:" + icRateCodeRates);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IcRateCodeRates FAIL:" + icRateCodeRates);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IcRateCodeRates FAIL:" + icRateCodeRates);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IcRateCodeRates findByPK( IcRateCodeRatesPK icRateCodeRatesPK, Connection conn) throws SQLException {
        return findByPK( icRateCodeRatesPK.getRateClassSetCd(),icRateCodeRatesPK.getRateCdSeq(),icRateCodeRatesPK.getEffectiveDate(), conn);   
    }


    public IcRateCodeRates findByPK( String rateClassSetCd,java.math.BigDecimal rateCdSeq,java.sql.Date effectiveDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from [IC_RATE_CODE_RATES] where RATE_CLASS_SET_CD = ?  and RATE_CD_SEQ = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, rateClassSetCd );
            stmt.setBigDecimal(2, rateCdSeq );
            stmt.setDate(3, effectiveDate );
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
        String SQL_STATEMENT ="Select * from [IC_RATE_CODE_RATES]";
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
        String SQL_STATEMENT ="Select * from [IC_RATE_CODE_RATES] where " + whereConditions;
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
    
    public List findByRateClassSetCd( String rateClassSetCd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE_RATES] where RATE_CLASS_SET_CD = ? order by RATE_CLASS_SET_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, rateClassSetCd );
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
    public List findByRateCdSeq( java.math.BigDecimal rateCdSeq, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE_RATES] where RATE_CD_SEQ = ? order by RATE_CD_SEQ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, rateCdSeq );
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE_RATES] where EFFECTIVE_DATE = ? order by EFFECTIVE_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE_RATES] where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE_RATES] where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE_RATES] where OPERATOR_ID = ? order by OPERATOR_ID";
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE_RATES] where APPLICATION_ID = ? order by APPLICATION_ID";
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE_RATES] where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE_RATES] where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
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
    public List findByRatingUnit( java.math.BigDecimal ratingUnit, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE_RATES] where RATING_UNIT = ? order by RATING_UNIT";
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
    public List findByRate( java.math.BigDecimal rate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE_RATES] where RATE = ? order by RATE";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, rate );
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE_RATES] where UOM = ? order by UOM";
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
    public List findByExpirationDate( java.sql.Date expirationDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE_RATES] where EXPIRATION_DATE = ? order by EXPIRATION_DATE";
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

    public List findByCriteriaOR( IcRateCodeRates criteria, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "";
        StringBuffer bf = new StringBuffer("Select * from SMS_APP_SENDER where ");
        String orString = "";
        
        if (criteria.getString() != null) { 
            bf.append(orString + " (RATE_CLASS_SET_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (RATE_CD_SEQ = ?) ");
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
            bf.append(orString + " (RATING_UNIT = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (RATE = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (UOM = ?) ");
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
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
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
            IcRateCodeRates icRateCodeRates = new IcRateCodeRates();
            icRateCodeRates.setRateClassSetCd(rs.getString("RATE_CLASS_SET_CD"));
            icRateCodeRates.setRateCdSeq(rs.getBigDecimal("RATE_CD_SEQ"));
            icRateCodeRates.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
            icRateCodeRates.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            icRateCodeRates.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            icRateCodeRates.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            icRateCodeRates.setApplicationId(rs.getString("APPLICATION_ID"));
            icRateCodeRates.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            icRateCodeRates.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRateCodeRates.setRatingUnit(rs.getBigDecimal("RATING_UNIT"));
            icRateCodeRates.setRate(rs.getBigDecimal("RATE"));
            icRateCodeRates.setUom(rs.getString("UOM"));
            icRateCodeRates.setExpirationDate(rs.getDate("EXPIRATION_DATE"));
            list.add(icRateCodeRates);
        }
        return list;
    }

    public IcRateCodeRates fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IcRateCodeRates icRateCodeRates = new IcRateCodeRates();
            icRateCodeRates.setRateClassSetCd( rs.getString("RATE_CLASS_SET_CD"));
            icRateCodeRates.setRateCdSeq( rs.getBigDecimal("RATE_CD_SEQ"));
            icRateCodeRates.setEffectiveDate( rs.getDate("EFFECTIVE_DATE"));
            icRateCodeRates.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            icRateCodeRates.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            icRateCodeRates.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            icRateCodeRates.setApplicationId( rs.getString("APPLICATION_ID"));
            icRateCodeRates.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            icRateCodeRates.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRateCodeRates.setRatingUnit( rs.getBigDecimal("RATING_UNIT"));
            icRateCodeRates.setRate( rs.getBigDecimal("RATE"));
            icRateCodeRates.setUom( rs.getString("UOM"));
            icRateCodeRates.setExpirationDate( rs.getDate("EXPIRATION_DATE"));
            return icRateCodeRates;
        }
        return null;
    }



    public void populateParent(IcRateCodeRates icRateCodeRates, Connection conn) throws SQLException {
    }

    public void populateChild(IcRateCodeRates icRateCodeRates, Connection conn) throws SQLException {
    }

    public void populateAll(IcRateCodeRates icRateCodeRates, Connection conn) throws SQLException {
        populateParent(icRateCodeRates, conn);
        populateChild(icRateCodeRates, conn);
    }

}
