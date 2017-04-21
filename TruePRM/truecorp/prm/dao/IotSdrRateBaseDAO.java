
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.core.dao.SystemBaseDao;
import truecorp.prm.table.IotSdrRate;
import truecorp.prm.table.IotSdrRatePK;

public class IotSdrRateBaseDAO  extends SystemBaseDao{

    private static Logger log = Logger.getLogger(IotSdrRateBaseDAO.class);

    /** Creates a new instance of IotSdrRateDAO */
    public IotSdrRateBaseDAO() {
    }

    public int insert( IotSdrRate iotSdrRate) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into IOT_SDR_RATE(CURRENCY_CD, SDR_MONTH, SDR_YEAR, SDR_RATE, USER_NAME, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, iotSdrRate.getCurrencyCd());
            stmt.setBigDecimal( 2, iotSdrRate.getSdrMonth());
            stmt.setBigDecimal( 3, iotSdrRate.getSdrYear());
            stmt.setBigDecimal( 4, iotSdrRate.getSdrRate());
            stmt.setString( 5, iotSdrRate.getUserName());
            stmt.setDate( 6, iotSdrRate.getSysCreationDate());
            stmt.setDate( 7, iotSdrRate.getSysUpdateDate());
            stmt.setBigDecimal( 8, iotSdrRate.getOperatorId());
            stmt.setString( 9, iotSdrRate.getApplicationId());
            stmt.setString( 10, iotSdrRate.getDlServiceCode());
            stmt.setBigDecimal( 11, iotSdrRate.getDlUpdateStamp());
            int status = stmt.executeUpdate();
            log.info("INSERT IotSdrRate SUCCESS:" + iotSdrRate);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IotSdrRate FAIL:" + iotSdrRate);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IotSdrRate FAIL:" + iotSdrRate);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IotSdrRate iotSdrRate) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update IOT_SDR_RATE set SDR_RATE = ?  , USER_NAME = ?  , SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  ";
	    SQL_STATEMENT += "where CURRENCY_CD = ?  and SDR_MONTH = ?  and SDR_YEAR = ? ";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal( 1, iotSdrRate.getSdrRate());
            stmt.setString( 2, iotSdrRate.getUserName());
            stmt.setDate( 3, iotSdrRate.getSysCreationDate());
            stmt.setDate( 4, iotSdrRate.getSysUpdateDate());
            stmt.setBigDecimal( 5, iotSdrRate.getOperatorId());
            stmt.setString( 6, iotSdrRate.getApplicationId());
            stmt.setString( 7, iotSdrRate.getDlServiceCode());
            stmt.setBigDecimal( 8, iotSdrRate.getDlUpdateStamp());
            stmt.setString( 9, iotSdrRate.getCurrencyCd());
            stmt.setBigDecimal( 10, iotSdrRate.getSdrMonth());
            stmt.setBigDecimal( 11, iotSdrRate.getSdrYear());
            int status = stmt.executeUpdate();
            log.info("UPDATE IotSdrRate SUCCESS:" + iotSdrRate);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IotSdrRate FAIL:" + iotSdrRate);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IotSdrRate FAIL:" + iotSdrRate);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IotSdrRate iotSdrRate) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from IOT_SDR_RATE where CURRENCY_CD = ?  and SDR_MONTH = ?  and SDR_YEAR = ? ";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, iotSdrRate.getCurrencyCd());
            stmt.setBigDecimal( 2, iotSdrRate.getSdrMonth());
            stmt.setBigDecimal( 3, iotSdrRate.getSdrYear());
            int status = stmt.executeUpdate();
            log.info("DELETE IotSdrRate SUCCESS:" + iotSdrRate);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IotSdrRate FAIL:" + iotSdrRate);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IotSdrRate FAIL:" + iotSdrRate);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IotSdrRate findByPK( IotSdrRatePK iotSdrRatePK) throws SQLException {
        return findByPK( iotSdrRatePK.getCurrencyCd(),iotSdrRatePK.getSdrMonth(),iotSdrRatePK.getSdrYear());   
    }


    public IotSdrRate findByPK( String currencyCd,java.math.BigDecimal sdrMonth,java.math.BigDecimal sdrYear) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from IOT_SDR_RATE where CURRENCY_CD = ?  and SDR_MONTH = ?  and SDR_YEAR = ? ";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, currencyCd );
            stmt.setBigDecimal(2, sdrMonth );
            stmt.setBigDecimal(3, sdrYear );
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
        String SQL_STATEMENT ="Select * from IOT_SDR_RATE";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
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
        String SQL_STATEMENT ="Select * from IOT_SDR_RATE where " + whereConditions;
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
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
    
    public List findByCurrencyCd( String currencyCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_SDR_RATE where CURRENCY_CD = ? order by CURRENCY_CD";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, currencyCd );
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
    public List findBySdrMonth( java.math.BigDecimal sdrMonth) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_SDR_RATE where SDR_MONTH = ? order by SDR_MONTH";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, sdrMonth );
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
    public List findBySdrYear( java.math.BigDecimal sdrYear) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_SDR_RATE where SDR_YEAR = ? order by SDR_YEAR";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, sdrYear );
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
    public List findBySdrRate( java.math.BigDecimal sdrRate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_SDR_RATE where SDR_RATE = ? order by SDR_RATE";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, sdrRate );
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
    public List findByUserName( String userName) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_SDR_RATE where USER_NAME = ? order by USER_NAME";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, userName );
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
        String SQL_STATEMENT = "Select * from IOT_SDR_RATE where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
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
        String SQL_STATEMENT = "Select * from IOT_SDR_RATE where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
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
        String SQL_STATEMENT = "Select * from IOT_SDR_RATE where OPERATOR_ID = ? order by OPERATOR_ID";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
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
        String SQL_STATEMENT = "Select * from IOT_SDR_RATE where APPLICATION_ID = ? order by APPLICATION_ID";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
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
        String SQL_STATEMENT = "Select * from IOT_SDR_RATE where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
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
        String SQL_STATEMENT = "Select * from IOT_SDR_RATE where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
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

/*    

    public List findByCriteriaOR( IotSdrRate criteria) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "";
        StringBuffer bf = new StringBuffer("Select * from SMS_APP_SENDER where ");
        String orString = "";
        
        if (criteria.getString() != null) { 
            bf.append(orString + " (CURRENCY_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (SDR_MONTH = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (SDR_YEAR = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (SDR_RATE = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (USER_NAME = ?) ");
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

        
        if (!orString.equals(""))
            SQL_STATEMENT = bf.toString();
        else
            return new ArrayList();

        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            int index = 1;
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
            IotSdrRate iotSdrRate = new IotSdrRate();
            iotSdrRate.setCurrencyCd(rs.getString("CURRENCY_CD"));
            iotSdrRate.setSdrMonth(rs.getBigDecimal("SDR_MONTH"));
            iotSdrRate.setSdrYear(rs.getBigDecimal("SDR_YEAR"));
            iotSdrRate.setSdrRate(rs.getBigDecimal("SDR_RATE"));
            iotSdrRate.setUserName(rs.getString("USER_NAME"));
            iotSdrRate.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            iotSdrRate.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            iotSdrRate.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            iotSdrRate.setApplicationId(rs.getString("APPLICATION_ID"));
            iotSdrRate.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            iotSdrRate.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            list.add(iotSdrRate);
        }
        return list;
    }

    public IotSdrRate fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IotSdrRate iotSdrRate = new IotSdrRate();
            iotSdrRate.setCurrencyCd( rs.getString("CURRENCY_CD"));
            iotSdrRate.setSdrMonth( rs.getBigDecimal("SDR_MONTH"));
            iotSdrRate.setSdrYear( rs.getBigDecimal("SDR_YEAR"));
            iotSdrRate.setSdrRate( rs.getBigDecimal("SDR_RATE"));
            iotSdrRate.setUserName( rs.getString("USER_NAME"));
            iotSdrRate.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            iotSdrRate.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            iotSdrRate.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            iotSdrRate.setApplicationId( rs.getString("APPLICATION_ID"));
            iotSdrRate.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            iotSdrRate.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            return iotSdrRate;
        }
        return null;
    }

    public void populateParent(IotSdrRate iotSdrRate) throws SQLException {
    }

    public void populateChild(IotSdrRate iotSdrRate) throws SQLException {
    }

    public void populateAll(IotSdrRate iotSdrRate) throws SQLException {
        populateParent(iotSdrRate);
        populateChild(iotSdrRate);
    }

}
