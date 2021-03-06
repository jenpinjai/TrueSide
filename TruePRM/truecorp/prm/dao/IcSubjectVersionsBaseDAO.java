
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.table.IcSubjectVersions;
import truecorp.prm.table.IcSubjectVersionsPK;


public class IcSubjectVersionsBaseDAO {

    private static Logger log = Logger.getLogger(IcSubjectVersionsBaseDAO.class);

    /** Creates a new instance of IcSubjectVersionsDAO */
    public IcSubjectVersionsBaseDAO() {
    }

    public int insert( IcSubjectVersions icSubjectVersions, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into [IC_SUBJECT_VERSIONS](SUBJECT, CODE, EFFECTIVE_DATE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, REMARK_SEQ_NO, EXPIRATION_DATE) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icSubjectVersions.getSubject());
            stmt.setString( 2, icSubjectVersions.getCode());
            stmt.setDate( 3, icSubjectVersions.getEffectiveDate());
            stmt.setDate( 4, icSubjectVersions.getSysCreationDate());
            stmt.setDate( 5, icSubjectVersions.getSysUpdateDate());
            stmt.setBigDecimal( 6, icSubjectVersions.getOperatorId());
            stmt.setString( 7, icSubjectVersions.getApplicationId());
            stmt.setString( 8, icSubjectVersions.getDlServiceCode());
            stmt.setBigDecimal( 9, icSubjectVersions.getDlUpdateStamp());
            stmt.setBigDecimal( 10, icSubjectVersions.getRemarkSeqNo());
            stmt.setDate( 11, icSubjectVersions.getExpirationDate());
            int status = stmt.executeUpdate();
            log.info("INSERT IcSubjectVersions SUCCESS:" + icSubjectVersions);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IcSubjectVersions FAIL:" + icSubjectVersions);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IcSubjectVersions FAIL:" + icSubjectVersions);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IcSubjectVersions icSubjectVersions, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update [IC_SUBJECT_VERSIONS] set SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , REMARK_SEQ_NO = ?  , EXPIRATION_DATE = ?  ";
	    SQL_STATEMENT += "where SUBJECT = ?  and CODE = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setDate( 1, icSubjectVersions.getSysCreationDate());
            stmt.setDate( 2, icSubjectVersions.getSysUpdateDate());
            stmt.setBigDecimal( 3, icSubjectVersions.getOperatorId());
            stmt.setString( 4, icSubjectVersions.getApplicationId());
            stmt.setString( 5, icSubjectVersions.getDlServiceCode());
            stmt.setBigDecimal( 6, icSubjectVersions.getDlUpdateStamp());
            stmt.setBigDecimal( 7, icSubjectVersions.getRemarkSeqNo());
            stmt.setDate( 8, icSubjectVersions.getExpirationDate());
            stmt.setString( 9, icSubjectVersions.getSubject());
            stmt.setString( 10, icSubjectVersions.getCode());
            stmt.setDate( 11, icSubjectVersions.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("UPDATE IcSubjectVersions SUCCESS:" + icSubjectVersions);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IcSubjectVersions FAIL:" + icSubjectVersions);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IcSubjectVersions FAIL:" + icSubjectVersions);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IcSubjectVersions icSubjectVersions, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from [IC_SUBJECT_VERSIONS] where SUBJECT = ?  and CODE = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icSubjectVersions.getSubject());
            stmt.setString( 2, icSubjectVersions.getCode());
            stmt.setDate( 3, icSubjectVersions.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("DELETE IcSubjectVersions SUCCESS:" + icSubjectVersions);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IcSubjectVersions FAIL:" + icSubjectVersions);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IcSubjectVersions FAIL:" + icSubjectVersions);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IcSubjectVersions findByPK( IcSubjectVersionsPK icSubjectVersionsPK, Connection conn) throws SQLException {
        return findByPK( icSubjectVersionsPK.getSubject(),icSubjectVersionsPK.getCode(),icSubjectVersionsPK.getEffectiveDate(), conn);   
    }


    public IcSubjectVersions findByPK( String subject,String code,java.sql.Date effectiveDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from [IC_SUBJECT_VERSIONS] where SUBJECT = ?  and CODE = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, subject );
            stmt.setString(2, code );
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
        String SQL_STATEMENT ="Select * from [IC_SUBJECT_VERSIONS]";
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
        String SQL_STATEMENT ="Select * from [IC_SUBJECT_VERSIONS] where " + whereConditions;
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
    
    public List findBySubject( String subject, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_SUBJECT_VERSIONS] where SUBJECT = ? order by SUBJECT";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, subject );
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
    public List findByCode( String code, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_SUBJECT_VERSIONS] where CODE = ? order by CODE";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, code );
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
        String SQL_STATEMENT = "Select * from [IC_SUBJECT_VERSIONS] where EFFECTIVE_DATE = ? order by EFFECTIVE_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_SUBJECT_VERSIONS] where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_SUBJECT_VERSIONS] where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_SUBJECT_VERSIONS] where OPERATOR_ID = ? order by OPERATOR_ID";
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
        String SQL_STATEMENT = "Select * from [IC_SUBJECT_VERSIONS] where APPLICATION_ID = ? order by APPLICATION_ID";
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
        String SQL_STATEMENT = "Select * from [IC_SUBJECT_VERSIONS] where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
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
        String SQL_STATEMENT = "Select * from [IC_SUBJECT_VERSIONS] where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
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
    public List findByRemarkSeqNo( java.math.BigDecimal remarkSeqNo, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_SUBJECT_VERSIONS] where REMARK_SEQ_NO = ? order by REMARK_SEQ_NO";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, remarkSeqNo );
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
        String SQL_STATEMENT = "Select * from [IC_SUBJECT_VERSIONS] where EXPIRATION_DATE = ? order by EXPIRATION_DATE";
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

    public List findByCriteriaOR( IcSubjectVersions criteria, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "";
        StringBuffer bf = new StringBuffer("Select * from SMS_APP_SENDER where ");
        String orString = "";
        
        if (criteria.getString() != null) { 
            bf.append(orString + " (SUBJECT = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (CODE = ?) ");
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
            bf.append(orString + " (REMARK_SEQ_NO = ?) ");
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
            IcSubjectVersions icSubjectVersions = new IcSubjectVersions();
            icSubjectVersions.setSubject(rs.getString("SUBJECT"));
            icSubjectVersions.setCode(rs.getString("CODE"));
            icSubjectVersions.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
            icSubjectVersions.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            icSubjectVersions.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            icSubjectVersions.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            icSubjectVersions.setApplicationId(rs.getString("APPLICATION_ID"));
            icSubjectVersions.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            icSubjectVersions.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            icSubjectVersions.setRemarkSeqNo(rs.getBigDecimal("REMARK_SEQ_NO"));
            icSubjectVersions.setExpirationDate(rs.getDate("EXPIRATION_DATE"));
            list.add(icSubjectVersions);
        }
        return list;
    }

    public IcSubjectVersions fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IcSubjectVersions icSubjectVersions = new IcSubjectVersions();
            icSubjectVersions.setSubject( rs.getString("SUBJECT"));
            icSubjectVersions.setCode( rs.getString("CODE"));
            icSubjectVersions.setEffectiveDate( rs.getDate("EFFECTIVE_DATE"));
            icSubjectVersions.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            icSubjectVersions.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            icSubjectVersions.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            icSubjectVersions.setApplicationId( rs.getString("APPLICATION_ID"));
            icSubjectVersions.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            icSubjectVersions.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            icSubjectVersions.setRemarkSeqNo( rs.getBigDecimal("REMARK_SEQ_NO"));
            icSubjectVersions.setExpirationDate( rs.getDate("EXPIRATION_DATE"));
            return icSubjectVersions;
        }
        return null;
    }
	
    public void populateParent(IcSubjectVersions icSubjectVersions, Connection conn) throws SQLException {
    }

    public void populateChild(IcSubjectVersions icSubjectVersions, Connection conn) throws SQLException {
    }

    public void populateAll(IcSubjectVersions icSubjectVersions, Connection conn) throws SQLException {
        populateParent(icSubjectVersions, conn);
        populateChild(icSubjectVersions, conn);
    }

}
