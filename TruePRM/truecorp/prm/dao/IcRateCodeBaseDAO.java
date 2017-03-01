
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.table.*;


public class IcRateCodeBaseDAO {

    private static Logger log = Logger.getLogger(IcRateCodeBaseDAO.class);

    /** Creates a new instance of IcRateCodeDAO */
    public IcRateCodeBaseDAO() {
    }

    public int insert( IcRateCode icRateCode, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into [IC_RATE_CODE](RATE_CD_SEQ, EFFECTIVE_DATE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, RATE_CD, DESCRIPTION_SEQ, EXPIRATION_DATE) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal( 1, icRateCode.getRateCdSeq());
            stmt.setDate( 2, icRateCode.getEffectiveDate());
            stmt.setDate( 3, icRateCode.getSysCreationDate());
            stmt.setDate( 4, icRateCode.getSysUpdateDate());
            stmt.setBigDecimal( 5, icRateCode.getOperatorId());
            stmt.setString( 6, icRateCode.getApplicationId());
            stmt.setString( 7, icRateCode.getDlServiceCode());
            stmt.setBigDecimal( 8, icRateCode.getDlUpdateStamp());
            stmt.setString( 9, icRateCode.getRateCd());
            stmt.setBigDecimal( 10, icRateCode.getDescriptionSeq());
            stmt.setDate( 11, icRateCode.getExpirationDate());
            int status = stmt.executeUpdate();
            log.info("INSERT IcRateCode SUCCESS:" + icRateCode);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IcRateCode FAIL:" + icRateCode);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IcRateCode FAIL:" + icRateCode);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IcRateCode icRateCode, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update [IC_RATE_CODE] set SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , RATE_CD = ?  , DESCRIPTION_SEQ = ?  , EXPIRATION_DATE = ?  ";
	    SQL_STATEMENT += "where RATE_CD_SEQ = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setDate( 1, icRateCode.getSysCreationDate());
            stmt.setDate( 2, icRateCode.getSysUpdateDate());
            stmt.setBigDecimal( 3, icRateCode.getOperatorId());
            stmt.setString( 4, icRateCode.getApplicationId());
            stmt.setString( 5, icRateCode.getDlServiceCode());
            stmt.setBigDecimal( 6, icRateCode.getDlUpdateStamp());
            stmt.setString( 7, icRateCode.getRateCd());
            stmt.setBigDecimal( 8, icRateCode.getDescriptionSeq());
            stmt.setDate( 9, icRateCode.getExpirationDate());
            stmt.setBigDecimal( 10, icRateCode.getRateCdSeq());
            stmt.setDate( 11, icRateCode.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("UPDATE IcRateCode SUCCESS:" + icRateCode);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRateCode FAIL:" + icRateCode);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRateCode FAIL:" + icRateCode);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IcRateCode icRateCode, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from [IC_RATE_CODE] where RATE_CD_SEQ = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal( 1, icRateCode.getRateCdSeq());
            stmt.setDate( 2, icRateCode.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("DELETE IcRateCode SUCCESS:" + icRateCode);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IcRateCode FAIL:" + icRateCode);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IcRateCode FAIL:" + icRateCode);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IcRateCode findByPK( IcRateCodePK icRateCodePK, Connection conn) throws SQLException {
        return findByPK( icRateCodePK.getRateCdSeq(),icRateCodePK.getEffectiveDate(), conn);   
    }


    public IcRateCode findByPK( java.math.BigDecimal rateCdSeq,java.sql.Date effectiveDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from [IC_RATE_CODE] where RATE_CD_SEQ = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, rateCdSeq );
            stmt.setDate(2, effectiveDate );
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
        String SQL_STATEMENT ="Select * from [IC_RATE_CODE]";
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
        String SQL_STATEMENT ="Select * from [IC_RATE_CODE] where " + whereConditions;
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
    
    public List findByRateCdSeq( java.math.BigDecimal rateCdSeq, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE] where RATE_CD_SEQ = ? order by RATE_CD_SEQ";
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE] where EFFECTIVE_DATE = ? order by EFFECTIVE_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE] where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE] where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE] where OPERATOR_ID = ? order by OPERATOR_ID";
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE] where APPLICATION_ID = ? order by APPLICATION_ID";
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE] where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE] where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
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
    public List findByRateCd( String rateCd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE] where RATE_CD = ? order by RATE_CD";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, rateCd );
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
    public List findByDescriptionSeq( java.math.BigDecimal descriptionSeq, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE] where DESCRIPTION_SEQ = ? order by DESCRIPTION_SEQ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, descriptionSeq );
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
        String SQL_STATEMENT = "Select * from [IC_RATE_CODE] where EXPIRATION_DATE = ? order by EXPIRATION_DATE";
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

    public List findByCriteriaOR( IcRateCode criteria, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "";
        StringBuffer bf = new StringBuffer("Select * from SMS_APP_SENDER where ");
        String orString = "";
        
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
        if (criteria.getString() != null) { 
            bf.append(orString + " (RATE_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (DESCRIPTION_SEQ = ?) ");
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
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
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
            IcRateCode icRateCode = new IcRateCode();
            icRateCode.setRateCdSeq(rs.getBigDecimal("RATE_CD_SEQ"));
            icRateCode.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
            icRateCode.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            icRateCode.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            icRateCode.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            icRateCode.setApplicationId(rs.getString("APPLICATION_ID"));
            icRateCode.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            icRateCode.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRateCode.setRateCd(rs.getString("RATE_CD"));
            icRateCode.setDescriptionSeq(rs.getBigDecimal("DESCRIPTION_SEQ"));
            icRateCode.setExpirationDate(rs.getDate("EXPIRATION_DATE"));
            list.add(icRateCode);
        }
        return list;
    }

    public IcRateCode fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IcRateCode icRateCode = new IcRateCode();
            icRateCode.setRateCdSeq( rs.getBigDecimal("RATE_CD_SEQ"));
            icRateCode.setEffectiveDate( rs.getDate("EFFECTIVE_DATE"));
            icRateCode.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            icRateCode.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            icRateCode.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            icRateCode.setApplicationId( rs.getString("APPLICATION_ID"));
            icRateCode.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            icRateCode.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRateCode.setRateCd( rs.getString("RATE_CD"));
            icRateCode.setDescriptionSeq( rs.getBigDecimal("DESCRIPTION_SEQ"));
            icRateCode.setExpirationDate( rs.getDate("EXPIRATION_DATE"));
            return icRateCode;
        }
        return null;
    }


	

    public void populateParent(IcRateCode icRateCode, Connection conn) throws SQLException {
    }

    public void populateChild(IcRateCode icRateCode, Connection conn) throws SQLException {
    }

    public void populateAll(IcRateCode icRateCode, Connection conn) throws SQLException {
        populateParent(icRateCode, conn);
        populateChild(icRateCode, conn);
    }

}
