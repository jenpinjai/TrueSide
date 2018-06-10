
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.table.IcRatingDict;
import truecorp.prm.table.IcRatingDictPK;

public class IcRatingDictBaseDAO {

    private static Logger log = Logger.getLogger(IcRatingDictBaseDAO.class);

    /** Creates a new instance of IcRatingDictDAO */
    public IcRatingDictBaseDAO() {
    }

    public int insert( IcRatingDict icRatingDict, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into [IC_RATING_DICT](SEQUENCE_NO, LANGUAGE_CODE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, TEXT) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal( 1, icRatingDict.getSequenceNo());
            stmt.setString( 2, icRatingDict.getLanguageCode());
            stmt.setDate( 3, icRatingDict.getSysCreationDate());
            stmt.setDate( 4, icRatingDict.getSysUpdateDate());
            stmt.setBigDecimal( 5, icRatingDict.getOperatorId());
            stmt.setString( 6, icRatingDict.getApplicationId());
            stmt.setString( 7, icRatingDict.getDlServiceCode());
            stmt.setBigDecimal( 8, icRatingDict.getDlUpdateStamp());
            stmt.setString( 9, icRatingDict.getText());
            int status = stmt.executeUpdate();
            log.info("INSERT IcRatingDict SUCCESS:" + icRatingDict);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IcRatingDict FAIL:" + icRatingDict);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IcRatingDict FAIL:" + icRatingDict);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IcRatingDict icRatingDict, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update [IC_RATING_DICT] set SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , TEXT = ?  ";
	    SQL_STATEMENT += "where SEQUENCE_NO = ?  and LANGUAGE_CODE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setDate( 1, icRatingDict.getSysCreationDate());
            stmt.setDate( 2, icRatingDict.getSysUpdateDate());
            stmt.setBigDecimal( 3, icRatingDict.getOperatorId());
            stmt.setString( 4, icRatingDict.getApplicationId());
            stmt.setString( 5, icRatingDict.getDlServiceCode());
            stmt.setBigDecimal( 6, icRatingDict.getDlUpdateStamp());
            stmt.setString( 7, icRatingDict.getText());
            stmt.setBigDecimal( 8, icRatingDict.getSequenceNo());
            stmt.setString( 9, icRatingDict.getLanguageCode());
            int status = stmt.executeUpdate();
            log.info("UPDATE IcRatingDict SUCCESS:" + icRatingDict);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRatingDict FAIL:" + icRatingDict);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRatingDict FAIL:" + icRatingDict);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IcRatingDict icRatingDict, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from [IC_RATING_DICT] where SEQUENCE_NO = ?  and LANGUAGE_CODE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal( 1, icRatingDict.getSequenceNo());
            stmt.setString( 2, icRatingDict.getLanguageCode());
            int status = stmt.executeUpdate();
            log.info("DELETE IcRatingDict SUCCESS:" + icRatingDict);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IcRatingDict FAIL:" + icRatingDict);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IcRatingDict FAIL:" + icRatingDict);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IcRatingDict findByPK( IcRatingDictPK icRatingDictPK, Connection conn) throws SQLException {
        return findByPK( icRatingDictPK.getSequenceNo(),icRatingDictPK.getLanguageCode(), conn);   
    }


    public IcRatingDict findByPK( java.math.BigDecimal sequenceNo,String languageCode, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from [IC_RATING_DICT] where SEQUENCE_NO = ?  and LANGUAGE_CODE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, sequenceNo );
            stmt.setString(2, languageCode );
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
        String SQL_STATEMENT ="Select * from [IC_RATING_DICT]";
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
        String SQL_STATEMENT ="Select * from [IC_RATING_DICT] where " + whereConditions;
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
    
    public List findBySequenceNo( java.math.BigDecimal sequenceNo, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATING_DICT] where SEQUENCE_NO = ? order by SEQUENCE_NO";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, sequenceNo );
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
    public List findByLanguageCode( String languageCode, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATING_DICT] where LANGUAGE_CODE = ? order by LANGUAGE_CODE";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, languageCode );
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
        String SQL_STATEMENT = "Select * from [IC_RATING_DICT] where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATING_DICT] where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATING_DICT] where OPERATOR_ID = ? order by OPERATOR_ID";
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
        String SQL_STATEMENT = "Select * from [IC_RATING_DICT] where APPLICATION_ID = ? order by APPLICATION_ID";
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
        String SQL_STATEMENT = "Select * from [IC_RATING_DICT] where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
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
        String SQL_STATEMENT = "Select * from [IC_RATING_DICT] where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
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
    public List findByText( String text, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATING_DICT] where TEXT = ? order by TEXT";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, text );
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

    public List findByCriteriaOR( IcRatingDict criteria, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "";
        StringBuffer bf = new StringBuffer("Select * from SMS_APP_SENDER where ");
        String orString = "";
        
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (SEQUENCE_NO = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (LANGUAGE_CODE = ?) ");
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
            bf.append(orString + " (TEXT = ?) ");
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
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
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
            IcRatingDict icRatingDict = new IcRatingDict();
            icRatingDict.setSequenceNo(rs.getBigDecimal("SEQUENCE_NO"));
            icRatingDict.setLanguageCode(rs.getString("LANGUAGE_CODE"));
            icRatingDict.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            icRatingDict.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            icRatingDict.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            icRatingDict.setApplicationId(rs.getString("APPLICATION_ID"));
            icRatingDict.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            icRatingDict.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRatingDict.setText(rs.getString("TEXT"));
            list.add(icRatingDict);
        }
        return list;
    }

    public IcRatingDict fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IcRatingDict icRatingDict = new IcRatingDict();
            icRatingDict.setSequenceNo( rs.getBigDecimal("SEQUENCE_NO"));
            icRatingDict.setLanguageCode( rs.getString("LANGUAGE_CODE"));
            icRatingDict.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            icRatingDict.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            icRatingDict.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            icRatingDict.setApplicationId( rs.getString("APPLICATION_ID"));
            icRatingDict.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            icRatingDict.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRatingDict.setText( rs.getString("TEXT"));
            return icRatingDict;
        }
        return null;
    }

    public void populateParent(IcRatingDict icRatingDict, Connection conn) throws SQLException {
    }

    public void populateChild(IcRatingDict icRatingDict, Connection conn) throws SQLException {
    }

    public void populateAll(IcRatingDict icRatingDict, Connection conn) throws SQLException {
        populateParent(icRatingDict, conn);
        populateChild(icRatingDict, conn);
    }

}
