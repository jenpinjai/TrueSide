
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.table.IcRatesSlabs;
import truecorp.prm.table.IcRatesSlabsPK;

public class IcRatesSlabsBaseDAO {

    private static Logger log = Logger.getLogger(IcRatesSlabsBaseDAO.class);

    /** Creates a new instance of IcRatesSlabsDAO */
    public IcRatesSlabsBaseDAO() {
    }

    public int insert( IcRatesSlabs icRatesSlabs, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into [IC_RATES_SLABS](RATE_PLAN_CD, DESTINATION_CD, CHRG_PARAM_ID, SLAB_NUM, EFFECTIVE_DATE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, FROM_SLAB, TO_SLAB, EXPIRATION_DATE) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icRatesSlabs.getRatePlanCd());
            stmt.setString( 2, icRatesSlabs.getDestinationCd());
            stmt.setBigDecimal( 3, icRatesSlabs.getChrgParamId());
            stmt.setBigDecimal( 4, icRatesSlabs.getSlabNum());
            stmt.setDate( 5, icRatesSlabs.getEffectiveDate());
            stmt.setDate( 6, icRatesSlabs.getSysCreationDate());
            stmt.setDate( 7, icRatesSlabs.getSysUpdateDate());
            stmt.setBigDecimal( 8, icRatesSlabs.getOperatorId());
            stmt.setString( 9, icRatesSlabs.getApplicationId());
            stmt.setString( 10, icRatesSlabs.getDlServiceCode());
            stmt.setBigDecimal( 11, icRatesSlabs.getDlUpdateStamp());
            stmt.setBigDecimal( 12, icRatesSlabs.getFromSlab());
            stmt.setBigDecimal( 13, icRatesSlabs.getToSlab());
            stmt.setDate( 14, icRatesSlabs.getExpirationDate());
            int status = stmt.executeUpdate();
            log.info("INSERT IcRatesSlabs SUCCESS:" + icRatesSlabs);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IcRatesSlabs FAIL:" + icRatesSlabs);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IcRatesSlabs FAIL:" + icRatesSlabs);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IcRatesSlabs icRatesSlabs, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update [IC_RATES_SLABS] set SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , FROM_SLAB = ?  , TO_SLAB = ?  , EXPIRATION_DATE = ?  ";
	    SQL_STATEMENT += "where RATE_PLAN_CD = ?  and DESTINATION_CD = ?  and CHRG_PARAM_ID = ?  and SLAB_NUM = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setDate( 1, icRatesSlabs.getSysCreationDate());
            stmt.setDate( 2, icRatesSlabs.getSysUpdateDate());
            stmt.setBigDecimal( 3, icRatesSlabs.getOperatorId());
            stmt.setString( 4, icRatesSlabs.getApplicationId());
            stmt.setString( 5, icRatesSlabs.getDlServiceCode());
            stmt.setBigDecimal( 6, icRatesSlabs.getDlUpdateStamp());
            stmt.setBigDecimal( 7, icRatesSlabs.getFromSlab());
            stmt.setBigDecimal( 8, icRatesSlabs.getToSlab());
            stmt.setDate( 9, icRatesSlabs.getExpirationDate());
            stmt.setString( 10, icRatesSlabs.getRatePlanCd());
            stmt.setString( 11, icRatesSlabs.getDestinationCd());
            stmt.setBigDecimal( 12, icRatesSlabs.getChrgParamId());
            stmt.setBigDecimal( 13, icRatesSlabs.getSlabNum());
            stmt.setDate( 14, icRatesSlabs.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("UPDATE IcRatesSlabs SUCCESS:" + icRatesSlabs);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRatesSlabs FAIL:" + icRatesSlabs);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IcRatesSlabs FAIL:" + icRatesSlabs);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IcRatesSlabs icRatesSlabs, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from [IC_RATES_SLABS] where RATE_PLAN_CD = ?  and DESTINATION_CD = ?  and CHRG_PARAM_ID = ?  and SLAB_NUM = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, icRatesSlabs.getRatePlanCd());
            stmt.setString( 2, icRatesSlabs.getDestinationCd());
            stmt.setBigDecimal( 3, icRatesSlabs.getChrgParamId());
            stmt.setBigDecimal( 4, icRatesSlabs.getSlabNum());
            stmt.setDate( 5, icRatesSlabs.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("DELETE IcRatesSlabs SUCCESS:" + icRatesSlabs);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IcRatesSlabs FAIL:" + icRatesSlabs);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IcRatesSlabs FAIL:" + icRatesSlabs);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IcRatesSlabs findByPK( IcRatesSlabsPK icRatesSlabsPK, Connection conn) throws SQLException {
        return findByPK( icRatesSlabsPK.getRatePlanCd(),icRatesSlabsPK.getDestinationCd(),icRatesSlabsPK.getChrgParamId(),icRatesSlabsPK.getSlabNum(),icRatesSlabsPK.getEffectiveDate(), conn);   
    }


    public IcRatesSlabs findByPK( String ratePlanCd,String destinationCd,java.math.BigDecimal chrgParamId,java.math.BigDecimal slabNum,java.sql.Date effectiveDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from [IC_RATES_SLABS] where RATE_PLAN_CD = ?  and DESTINATION_CD = ?  and CHRG_PARAM_ID = ?  and SLAB_NUM = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setString(1, ratePlanCd );
            stmt.setString(2, destinationCd );
            stmt.setBigDecimal(3, chrgParamId );
            stmt.setBigDecimal(4, slabNum );
            stmt.setDate(5, effectiveDate );
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
        String SQL_STATEMENT ="Select * from [IC_RATES_SLABS]";
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
        String SQL_STATEMENT ="Select * from [IC_RATES_SLABS] where " + whereConditions;
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
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where RATE_PLAN_CD = ? order by RATE_PLAN_CD";
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
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where DESTINATION_CD = ? order by DESTINATION_CD";
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
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where CHRG_PARAM_ID = ? order by CHRG_PARAM_ID";
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
    public List findBySlabNum( java.math.BigDecimal slabNum, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where SLAB_NUM = ? order by SLAB_NUM";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
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
    public List findByEffectiveDate( java.sql.Date effectiveDate, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where EFFECTIVE_DATE = ? order by EFFECTIVE_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where OPERATOR_ID = ? order by OPERATOR_ID";
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
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where APPLICATION_ID = ? order by APPLICATION_ID";
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
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
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
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
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
    public List findByFromSlab( java.math.BigDecimal fromSlab, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where FROM_SLAB = ? order by FROM_SLAB";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, fromSlab );
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
    public List findByToSlab( java.math.BigDecimal toSlab, Connection conn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where TO_SLAB = ? order by TO_SLAB";
        try {
            stmt = conn.prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, toSlab );
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
        String SQL_STATEMENT = "Select * from [IC_RATES_SLABS] where EXPIRATION_DATE = ? order by EXPIRATION_DATE";
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

    public List findByCriteriaOR( IcRatesSlabs criteria, Connection conn) throws SQLException {
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
            bf.append(orString + " (FROM_SLAB = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (TO_SLAB = ?) ");
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
            IcRatesSlabs icRatesSlabs = new IcRatesSlabs();
            icRatesSlabs.setRatePlanCd(rs.getString("RATE_PLAN_CD"));
            icRatesSlabs.setDestinationCd(rs.getString("DESTINATION_CD"));
            icRatesSlabs.setChrgParamId(rs.getBigDecimal("CHRG_PARAM_ID"));
            icRatesSlabs.setSlabNum(rs.getBigDecimal("SLAB_NUM"));
            icRatesSlabs.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
            icRatesSlabs.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            icRatesSlabs.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            icRatesSlabs.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            icRatesSlabs.setApplicationId(rs.getString("APPLICATION_ID"));
            icRatesSlabs.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            icRatesSlabs.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRatesSlabs.setFromSlab(rs.getBigDecimal("FROM_SLAB"));
            icRatesSlabs.setToSlab(rs.getBigDecimal("TO_SLAB"));
            icRatesSlabs.setExpirationDate(rs.getDate("EXPIRATION_DATE"));
            list.add(icRatesSlabs);
        }
        return list;
    }

    public IcRatesSlabs fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IcRatesSlabs icRatesSlabs = new IcRatesSlabs();
            icRatesSlabs.setRatePlanCd( rs.getString("RATE_PLAN_CD"));
            icRatesSlabs.setDestinationCd( rs.getString("DESTINATION_CD"));
            icRatesSlabs.setChrgParamId( rs.getBigDecimal("CHRG_PARAM_ID"));
            icRatesSlabs.setSlabNum( rs.getBigDecimal("SLAB_NUM"));
            icRatesSlabs.setEffectiveDate( rs.getDate("EFFECTIVE_DATE"));
            icRatesSlabs.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            icRatesSlabs.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            icRatesSlabs.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            icRatesSlabs.setApplicationId( rs.getString("APPLICATION_ID"));
            icRatesSlabs.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            icRatesSlabs.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            icRatesSlabs.setFromSlab( rs.getBigDecimal("FROM_SLAB"));
            icRatesSlabs.setToSlab( rs.getBigDecimal("TO_SLAB"));
            icRatesSlabs.setExpirationDate( rs.getDate("EXPIRATION_DATE"));
            return icRatesSlabs;
        }
        return null;
    }

    public void populateParent(IcRatesSlabs icRatesSlabs, Connection conn) throws SQLException {
    }

    public void populateChild(IcRatesSlabs icRatesSlabs, Connection conn) throws SQLException {
    }

    public void populateAll(IcRatesSlabs icRatesSlabs, Connection conn) throws SQLException {
        populateParent(icRatesSlabs, conn);
        populateChild(icRatesSlabs, conn);
    }

}
