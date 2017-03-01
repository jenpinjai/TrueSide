
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.core.dao.SystemBaseDao;
import truecorp.prm.table.IcgDestination;
import truecorp.prm.table.IcgDestinationPK;

public class IcgDestinationBaseDAO extends SystemBaseDao{

    private static Logger log = Logger.getLogger(IcgDestinationBaseDAO.class);

    /** Creates a new instance of IcgDestinationDAO */
    public IcgDestinationBaseDAO() {
    }

    public int insert( IcgDestination icgDestination) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into ICG_DESTINATION(DESTINATION_CD, EFFECTIVE_DATE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, BILLING_NAME_SEQ, JURISDICTION, GUI_DSP_IND, EXPIRATION_DATE) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icgDestination.getDestinationCd());
            stmt.setDate( 2, icgDestination.getEffectiveDate());
            stmt.setDate( 3, icgDestination.getSysCreationDate());
            stmt.setDate( 4, icgDestination.getSysUpdateDate());
            stmt.setBigDecimal( 5, icgDestination.getOperatorId());
            stmt.setString( 6, icgDestination.getApplicationId());
            stmt.setString( 7, icgDestination.getDlServiceCode());
            stmt.setBigDecimal( 8, icgDestination.getDlUpdateStamp());
            stmt.setBigDecimal( 9, icgDestination.getBillingNameSeq());
            stmt.setString( 10, icgDestination.getJurisdiction());
            stmt.setString( 11, icgDestination.getGuiDspInd());
            stmt.setDate( 12, icgDestination.getExpirationDate());
            int status = stmt.executeUpdate();
            log.info("INSERT IcgDestination SUCCESS:" + icgDestination);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IcgDestination FAIL:" + icgDestination);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IcgDestination FAIL:" + icgDestination);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IcgDestination icgDestination) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update ICG_DESTINATION set SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , BILLING_NAME_SEQ = ?  , JURISDICTION = ?  , GUI_DSP_IND = ?  , EXPIRATION_DATE = ?  ";
	    SQL_STATEMENT += "where DESTINATION_CD = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setDate( 1, icgDestination.getSysCreationDate());
            stmt.setDate( 2, icgDestination.getSysUpdateDate());
            stmt.setBigDecimal( 3, icgDestination.getOperatorId());
            stmt.setString( 4, icgDestination.getApplicationId());
            stmt.setString( 5, icgDestination.getDlServiceCode());
            stmt.setBigDecimal( 6, icgDestination.getDlUpdateStamp());
            stmt.setBigDecimal( 7, icgDestination.getBillingNameSeq());
            stmt.setString( 8, icgDestination.getJurisdiction());
            stmt.setString( 9, icgDestination.getGuiDspInd());
            stmt.setDate( 10, icgDestination.getExpirationDate());
            stmt.setString( 11, icgDestination.getDestinationCd());
            stmt.setDate( 12, icgDestination.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("UPDATE IcgDestination SUCCESS:" + icgDestination);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IcgDestination FAIL:" + icgDestination);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IcgDestination FAIL:" + icgDestination);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IcgDestination icgDestination) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from ICG_DESTINATION where DESTINATION_CD = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icgDestination.getDestinationCd());
            stmt.setDate( 2, icgDestination.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("DELETE IcgDestination SUCCESS:" + icgDestination);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IcgDestination FAIL:" + icgDestination);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IcgDestination FAIL:" + icgDestination);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IcgDestination findByPK( IcgDestinationPK icgDestinationPK) throws SQLException {
        return findByPK( icgDestinationPK.getDestinationCd(),icgDestinationPK.getEffectiveDate());   
    }


    public IcgDestination findByPK( String destinationCd,java.sql.Date effectiveDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from ICG_DESTINATION where DESTINATION_CD = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, destinationCd );
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

    public List findAll() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from ICG_DESTINATION";
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
        String SQL_STATEMENT ="Select * from ICG_DESTINATION where " + whereConditions;
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
    
    public List findByDestinationCd( String destinationCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from ICG_DESTINATION where DESTINATION_CD = ? order by DESTINATION_CD";
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
    public List findByEffectiveDate( java.sql.Date effectiveDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from ICG_DESTINATION where EFFECTIVE_DATE = ? order by EFFECTIVE_DATE";
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION where OPERATOR_ID = ? order by OPERATOR_ID";
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION where APPLICATION_ID = ? order by APPLICATION_ID";
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
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
    public List findByBillingNameSeq( java.math.BigDecimal billingNameSeq) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from ICG_DESTINATION where BILLING_NAME_SEQ = ? order by BILLING_NAME_SEQ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, billingNameSeq );
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
    public List findByJurisdiction( String jurisdiction) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from ICG_DESTINATION where JURISDICTION = ? order by JURISDICTION";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, jurisdiction );
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
    public List findByGuiDspInd( String guiDspInd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from ICG_DESTINATION where GUI_DSP_IND = ? order by GUI_DSP_IND";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, guiDspInd );
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION where EXPIRATION_DATE = ? order by EXPIRATION_DATE";
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

    public List findByCriteriaOR( IcgDestination criteria) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "";
        StringBuffer bf = new StringBuffer("Select * from SMS_APP_SENDER where ");
        String orString = "";
        
        if (criteria.getString() != null) { 
            bf.append(orString + " (DESTINATION_CD = ?) ");
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
            bf.append(orString + " (BILLING_NAME_SEQ = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (JURISDICTION = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (GUI_DSP_IND = ?) ");
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
            IcgDestination icgDestination = new IcgDestination();
            icgDestination.setDestinationCd(rs.getString("DESTINATION_CD"));
            icgDestination.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
            icgDestination.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            icgDestination.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            icgDestination.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            icgDestination.setApplicationId(rs.getString("APPLICATION_ID"));
            icgDestination.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            icgDestination.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            icgDestination.setBillingNameSeq(rs.getBigDecimal("BILLING_NAME_SEQ"));
            icgDestination.setJurisdiction(rs.getString("JURISDICTION"));
            icgDestination.setGuiDspInd(rs.getString("GUI_DSP_IND"));
            icgDestination.setExpirationDate(rs.getDate("EXPIRATION_DATE"));
            list.add(icgDestination);
        }
        return list;
    }

    public IcgDestination fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IcgDestination icgDestination = new IcgDestination();
            icgDestination.setDestinationCd( rs.getString("DESTINATION_CD"));
            icgDestination.setEffectiveDate( rs.getDate("EFFECTIVE_DATE"));
            icgDestination.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            icgDestination.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            icgDestination.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            icgDestination.setApplicationId( rs.getString("APPLICATION_ID"));
            icgDestination.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            icgDestination.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            icgDestination.setBillingNameSeq( rs.getBigDecimal("BILLING_NAME_SEQ"));
            icgDestination.setJurisdiction( rs.getString("JURISDICTION"));
            icgDestination.setGuiDspInd( rs.getString("GUI_DSP_IND"));
            icgDestination.setExpirationDate( rs.getDate("EXPIRATION_DATE"));
            return icgDestination;
        }
        return null;
    }

    public void populateParent(IcgDestination icgDestination) throws SQLException {
    }

    public void populateChild(IcgDestination icgDestination) throws SQLException {
    }

    public void populateAll(IcgDestination icgDestination) throws SQLException {
        populateParent(icgDestination);
        populateChild(icgDestination);
    }

}
