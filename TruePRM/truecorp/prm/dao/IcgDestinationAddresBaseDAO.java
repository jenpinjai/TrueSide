
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.table.IcgDestinationAddres;
import truecorp.prm.table.IcgDestinationAddresPK;

public class IcgDestinationAddresBaseDAO {

    private static Logger log = Logger.getLogger(IcgDestinationAddresBaseDAO.class);

    /** Creates a new instance of IcgDestinationAddresDAO */
    public IcgDestinationAddresBaseDAO() {
    }

    public int insert( IcgDestinationAddres icgDestinationAddres, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into [ICG_DESTINATION_ADDRES](DESTINATION_CD, ADDRESS, EFFECTIVE_DATE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, EXPIRATION_DATE) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icgDestinationAddres.getDestinationCd());
            stmt.setString( 2, icgDestinationAddres.getAddress());
            stmt.setDate( 3, icgDestinationAddres.getEffectiveDate());
            stmt.setDate( 4, icgDestinationAddres.getSysCreationDate());
            stmt.setDate( 5, icgDestinationAddres.getSysUpdateDate());
            stmt.setBigDecimal( 6, icgDestinationAddres.getOperatorId());
            stmt.setString( 7, icgDestinationAddres.getApplicationId());
            stmt.setString( 8, icgDestinationAddres.getDlServiceCode());
            stmt.setBigDecimal( 9, icgDestinationAddres.getDlUpdateStamp());
            stmt.setDate( 10, icgDestinationAddres.getExpirationDate());
            int status = stmt.executeUpdate();
            log.info("INSERT IcgDestinationAddres SUCCESS:" + icgDestinationAddres);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IcgDestinationAddres FAIL:" + icgDestinationAddres);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IcgDestinationAddres FAIL:" + icgDestinationAddres);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IcgDestinationAddres icgDestinationAddres, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update [ICG_DESTINATION_ADDRES] set SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , EXPIRATION_DATE = ?  ";
	    SQL_STATEMENT += "where DESTINATION_CD = ?  and ADDRESS = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setDate( 1, icgDestinationAddres.getSysCreationDate());
            stmt.setDate( 2, icgDestinationAddres.getSysUpdateDate());
            stmt.setBigDecimal( 3, icgDestinationAddres.getOperatorId());
            stmt.setString( 4, icgDestinationAddres.getApplicationId());
            stmt.setString( 5, icgDestinationAddres.getDlServiceCode());
            stmt.setBigDecimal( 6, icgDestinationAddres.getDlUpdateStamp());
            stmt.setDate( 7, icgDestinationAddres.getExpirationDate());
            stmt.setString( 8, icgDestinationAddres.getDestinationCd());
            stmt.setString( 9, icgDestinationAddres.getAddress());
            stmt.setDate( 10, icgDestinationAddres.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("UPDATE IcgDestinationAddres SUCCESS:" + icgDestinationAddres);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IcgDestinationAddres FAIL:" + icgDestinationAddres);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IcgDestinationAddres FAIL:" + icgDestinationAddres);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IcgDestinationAddres icgDestinationAddres, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from [ICG_DESTINATION_ADDRES] where DESTINATION_CD = ?  and ADDRESS = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icgDestinationAddres.getDestinationCd());
            stmt.setString( 2, icgDestinationAddres.getAddress());
            stmt.setDate( 3, icgDestinationAddres.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("DELETE IcgDestinationAddres SUCCESS:" + icgDestinationAddres);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IcgDestinationAddres FAIL:" + icgDestinationAddres);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IcgDestinationAddres FAIL:" + icgDestinationAddres);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IcgDestinationAddres findByPK( IcgDestinationAddresPK icgDestinationAddresPK, Connection conn) throws SQLException {
        return findByPK( icgDestinationAddresPK.getDestinationCd(),icgDestinationAddresPK.getAddress(),icgDestinationAddresPK.getEffectiveDate(), conn);   
    }


    public IcgDestinationAddres findByPK( String destinationCd,String address,java.sql.Date effectiveDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from [ICG_DESTINATION_ADDRES] where DESTINATION_CD = ?  and ADDRESS = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, destinationCd );
            stmt.setString(2, address );
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
        String SQL_STATEMENT ="Select * from [ICG_DESTINATION_ADDRES]";
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
        String SQL_STATEMENT ="Select * from [ICG_DESTINATION_ADDRES] where " + whereConditions;
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
    
    public List findByDestinationCd( String destinationCd, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [ICG_DESTINATION_ADDRES] where DESTINATION_CD = ? order by DESTINATION_CD";
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
    public List findByAddress( String address, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [ICG_DESTINATION_ADDRES] where ADDRESS = ? order by ADDRESS";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, address );
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
        String SQL_STATEMENT = "Select * from [ICG_DESTINATION_ADDRES] where EFFECTIVE_DATE = ? order by EFFECTIVE_DATE";
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
        String SQL_STATEMENT = "Select * from [ICG_DESTINATION_ADDRES] where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from [ICG_DESTINATION_ADDRES] where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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
        String SQL_STATEMENT = "Select * from [ICG_DESTINATION_ADDRES] where OPERATOR_ID = ? order by OPERATOR_ID";
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
        String SQL_STATEMENT = "Select * from [ICG_DESTINATION_ADDRES] where APPLICATION_ID = ? order by APPLICATION_ID";
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
        String SQL_STATEMENT = "Select * from [ICG_DESTINATION_ADDRES] where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
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
        String SQL_STATEMENT = "Select * from [ICG_DESTINATION_ADDRES] where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
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
    public List findByExpirationDate( java.sql.Date expirationDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [ICG_DESTINATION_ADDRES] where EXPIRATION_DATE = ? order by EXPIRATION_DATE";
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

    public List findByCriteriaOR( IcgDestinationAddres criteria, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "";
        StringBuffer bf = new StringBuffer("Select * from SMS_APP_SENDER where ");
        String orString = "";
        
        if (criteria.getString() != null) { 
            bf.append(orString + " (DESTINATION_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (ADDRESS = ?) ");
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
            IcgDestinationAddres icgDestinationAddres = new IcgDestinationAddres();
            icgDestinationAddres.setDestinationCd(rs.getString("DESTINATION_CD"));
            icgDestinationAddres.setAddress(rs.getString("ADDRESS"));
            icgDestinationAddres.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
            icgDestinationAddres.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            icgDestinationAddres.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            icgDestinationAddres.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            icgDestinationAddres.setApplicationId(rs.getString("APPLICATION_ID"));
            icgDestinationAddres.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            icgDestinationAddres.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            icgDestinationAddres.setExpirationDate(rs.getDate("EXPIRATION_DATE"));
            list.add(icgDestinationAddres);
        }
        return list;
    }

    public IcgDestinationAddres fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IcgDestinationAddres icgDestinationAddres = new IcgDestinationAddres();
            icgDestinationAddres.setDestinationCd( rs.getString("DESTINATION_CD"));
            icgDestinationAddres.setAddress( rs.getString("ADDRESS"));
            icgDestinationAddres.setEffectiveDate( rs.getDate("EFFECTIVE_DATE"));
            icgDestinationAddres.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            icgDestinationAddres.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            icgDestinationAddres.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            icgDestinationAddres.setApplicationId( rs.getString("APPLICATION_ID"));
            icgDestinationAddres.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            icgDestinationAddres.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            icgDestinationAddres.setExpirationDate( rs.getDate("EXPIRATION_DATE"));
            return icgDestinationAddres;
        }
        return null;
    }


    public void populateParent(IcgDestinationAddres icgDestinationAddres, Connection conn) throws SQLException {
    }

    public void populateChild(IcgDestinationAddres icgDestinationAddres, Connection conn) throws SQLException {
    }

    public void populateAll(IcgDestinationAddres icgDestinationAddres, Connection conn) throws SQLException {
        populateParent(icgDestinationAddres, conn);
        populateChild(icgDestinationAddres, conn);
    }

}
