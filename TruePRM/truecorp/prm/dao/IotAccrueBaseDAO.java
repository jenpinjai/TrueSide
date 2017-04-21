
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.core.dao.SystemBaseDao;
import truecorp.prm.table.IotAccrue;
import truecorp.prm.table.IotAccruePK;


public class IotAccrueBaseDAO  extends SystemBaseDao{

    private static Logger log = Logger.getLogger(IotAccrueBaseDAO.class);

    /** Creates a new instance of IotAccrueDAO */
    public IotAccrueBaseDAO() {
    }

    public int insert( IotAccrue iotAccrue) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into IOT_ACCRUE(DIRECTION, GROUP_TADIG, MY_TADIG, COUNTRY_NAME, OPERATOR_NAME, AGREEMENT_ID, PLMN_GROUP_ID, CALL_TADIG, SHARING_RATE, CHARGE_TAP, CHARGE_IOT, COMMITMENT, DN, CN, REPORT_MONTH, PARAM_DATE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, iotAccrue.getDirection());
            stmt.setString( 2, iotAccrue.getGroupTadig());
            stmt.setString( 3, iotAccrue.getMyTadig());
            stmt.setString( 4, iotAccrue.getCountryName());
            stmt.setString( 5, iotAccrue.getOperatorName());
            stmt.setString( 6, iotAccrue.getAgreementId());
            stmt.setString( 7, iotAccrue.getPlmnGroupId());
            stmt.setBigDecimal( 8, iotAccrue.getCallTadig());
            stmt.setBigDecimal( 9, iotAccrue.getSharingRate());
            stmt.setBigDecimal( 10, iotAccrue.getChargeTap());
            stmt.setBigDecimal( 11, iotAccrue.getChargeIot());
            stmt.setBigDecimal( 12, iotAccrue.getCommitment());
            stmt.setBigDecimal( 13, iotAccrue.getDn());
            stmt.setBigDecimal( 14, iotAccrue.getCn());
            stmt.setString( 15, iotAccrue.getReportMonth());
            stmt.setString( 16, iotAccrue.getParamDate());
            stmt.setDate( 17, iotAccrue.getSysCreationDate());
            stmt.setDate( 18, iotAccrue.getSysUpdateDate());
            stmt.setBigDecimal( 19, iotAccrue.getOperatorId());
            stmt.setString( 20, iotAccrue.getApplicationId());
            stmt.setString( 21, iotAccrue.getDlServiceCode());
            stmt.setBigDecimal( 22, iotAccrue.getDlUpdateStamp());
            int status = stmt.executeUpdate();
            log.info("INSERT IotAccrue SUCCESS:" + iotAccrue);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IotAccrue FAIL:" + iotAccrue);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IotAccrue FAIL:" + iotAccrue);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IotAccrue iotAccrue) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update IOT_ACCRUE set COUNTRY_NAME = ?  , OPERATOR_NAME = ?  , CALL_TADIG = ?  , SHARING_RATE = ?  , CHARGE_TAP = ?  , CHARGE_IOT = ?  , COMMITMENT = ?  , DN = ?  , CN = ?  , PARAM_DATE = ?  , SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  ";
	    SQL_STATEMENT += "where DIRECTION = ?  and GROUP_TADIG = ?  and MY_TADIG = ?  and AGREEMENT_ID = ?  and PLMN_GROUP_ID = ?  and REPORT_MONTH = ? ";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, iotAccrue.getCountryName());
            stmt.setString( 2, iotAccrue.getOperatorName());
            stmt.setBigDecimal( 3, iotAccrue.getCallTadig());
            stmt.setBigDecimal( 4, iotAccrue.getSharingRate());
            stmt.setBigDecimal( 5, iotAccrue.getChargeTap());
            stmt.setBigDecimal( 6, iotAccrue.getChargeIot());
            stmt.setBigDecimal( 7, iotAccrue.getCommitment());
            stmt.setBigDecimal( 8, iotAccrue.getDn());
            stmt.setBigDecimal( 9, iotAccrue.getCn());
            stmt.setString( 10, iotAccrue.getParamDate());
            stmt.setDate( 11, iotAccrue.getSysCreationDate());
            stmt.setDate( 12, iotAccrue.getSysUpdateDate());
            stmt.setBigDecimal( 13, iotAccrue.getOperatorId());
            stmt.setString( 14, iotAccrue.getApplicationId());
            stmt.setString( 15, iotAccrue.getDlServiceCode());
            stmt.setBigDecimal( 16, iotAccrue.getDlUpdateStamp());
            stmt.setString( 17, iotAccrue.getDirection());
            stmt.setString( 18, iotAccrue.getGroupTadig());
            stmt.setString( 19, iotAccrue.getMyTadig());
            stmt.setString( 20, iotAccrue.getAgreementId());
            stmt.setString( 21, iotAccrue.getPlmnGroupId());
            stmt.setString( 22, iotAccrue.getReportMonth());
            int status = stmt.executeUpdate();
            log.info("UPDATE IotAccrue SUCCESS:" + iotAccrue);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IotAccrue FAIL:" + iotAccrue);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IotAccrue FAIL:" + iotAccrue);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IotAccrue iotAccrue) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from IOT_ACCRUE where DIRECTION = ?  and GROUP_TADIG = ?  and MY_TADIG = ?  and AGREEMENT_ID = ?  and PLMN_GROUP_ID = ?  and REPORT_MONTH = ? ";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, iotAccrue.getDirection());
            stmt.setString( 2, iotAccrue.getGroupTadig());
            stmt.setString( 3, iotAccrue.getMyTadig());
            stmt.setString( 4, iotAccrue.getAgreementId());
            stmt.setString( 5, iotAccrue.getPlmnGroupId());
            stmt.setString( 6, iotAccrue.getReportMonth());
            int status = stmt.executeUpdate();
            log.info("DELETE IotAccrue SUCCESS:" + iotAccrue);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IotAccrue FAIL:" + iotAccrue);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IotAccrue FAIL:" + iotAccrue);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IotAccrue findByPK( IotAccruePK iotAccruePK) throws SQLException {
        return findByPK( iotAccruePK.getDirection(),iotAccruePK.getGroupTadig(),iotAccruePK.getMyTadig(),iotAccruePK.getAgreementId(),iotAccruePK.getPlmnGroupId(),iotAccruePK.getReportMonth());   
    }


    public IotAccrue findByPK( String direction,String groupTadig,String myTadig,String agreementId,String plmnGroupId,String reportMonth) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from IOT_ACCRUE where DIRECTION = ?  and GROUP_TADIG = ?  and MY_TADIG = ?  and AGREEMENT_ID = ?  and PLMN_GROUP_ID = ?  and REPORT_MONTH = ? ";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, direction );
            stmt.setString(2, groupTadig );
            stmt.setString(3, myTadig );
            stmt.setString(4, agreementId );
            stmt.setString(5, plmnGroupId );
            stmt.setString(6, reportMonth );
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
        String SQL_STATEMENT ="Select * from IOT_ACCRUE";
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
        String SQL_STATEMENT ="Select * from IOT_ACCRUE where " + whereConditions;
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
    
    public List findByDirection( String direction) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where DIRECTION = ? order by DIRECTION";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, direction );
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
    public List findByGroupTadig( String groupTadig) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where GROUP_TADIG = ? order by GROUP_TADIG";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, groupTadig );
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
    public List findByMyTadig( String myTadig) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where MY_TADIG = ? order by MY_TADIG";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, myTadig );
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
    public List findByCountryName( String countryName) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where COUNTRY_NAME = ? order by COUNTRY_NAME";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, countryName );
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
    public List findByOperatorName( String operatorName) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where OPERATOR_NAME = ? order by OPERATOR_NAME";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, operatorName );
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
    public List findByAgreementId( String agreementId) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where AGREEMENT_ID = ? order by AGREEMENT_ID";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, agreementId );
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
    public List findByPlmnGroupId( String plmnGroupId) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where PLMN_GROUP_ID = ? order by PLMN_GROUP_ID";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, plmnGroupId );
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
    public List findByCallTadig( java.math.BigDecimal callTadig) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where CALL_TADIG = ? order by CALL_TADIG";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, callTadig );
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
    public List findBySharingRate( java.math.BigDecimal sharingRate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where SHARING_RATE = ? order by SHARING_RATE";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, sharingRate );
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
    public List findByChargeTap( java.math.BigDecimal chargeTap) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where CHARGE_TAP = ? order by CHARGE_TAP";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, chargeTap );
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
    public List findByChargeIot( java.math.BigDecimal chargeIot) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where CHARGE_IOT = ? order by CHARGE_IOT";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, chargeIot );
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
    public List findByCommitment( java.math.BigDecimal commitment) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where COMMITMENT = ? order by COMMITMENT";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, commitment );
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
    public List findByDn( java.math.BigDecimal dn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where DN = ? order by DN";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, dn );
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
    public List findByCn( java.math.BigDecimal cn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where CN = ? order by CN";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, cn );
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
    public List findByReportMonth( String reportMonth) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where REPORT_MONTH = ? order by REPORT_MONTH";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, reportMonth );
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
    public List findByParamDate( String paramDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where PARAM_DATE = ? order by PARAM_DATE";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, paramDate );
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
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where OPERATOR_ID = ? order by OPERATOR_ID";
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
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where APPLICATION_ID = ? order by APPLICATION_ID";
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
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
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
        String SQL_STATEMENT = "Select * from IOT_ACCRUE where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
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

    public List findByCriteriaOR( IotAccrue criteria) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "";
        StringBuffer bf = new StringBuffer("Select * from SMS_APP_SENDER where ");
        String orString = "";
        
        if (criteria.getString() != null) { 
            bf.append(orString + " (DIRECTION = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (GROUP_TADIG = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (MY_TADIG = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (COUNTRY_NAME = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (OPERATOR_NAME = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (AGREEMENT_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (PLMN_GROUP_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (CALL_TADIG = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (SHARING_RATE = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (CHARGE_TAP = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (CHARGE_IOT = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (COMMITMENT = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (DN = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (CN = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (REPORT_MONTH = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (PARAM_DATE = ?) ");
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
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
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
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
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
            IotAccrue iotAccrue = new IotAccrue();
            iotAccrue.setDirection(rs.getString("DIRECTION"));
            iotAccrue.setGroupTadig(rs.getString("GROUP_TADIG"));
            iotAccrue.setMyTadig(rs.getString("MY_TADIG"));
            iotAccrue.setCountryName(rs.getString("COUNTRY_NAME"));
            iotAccrue.setOperatorName(rs.getString("OPERATOR_NAME"));
            iotAccrue.setAgreementId(rs.getString("AGREEMENT_ID"));
            iotAccrue.setPlmnGroupId(rs.getString("PLMN_GROUP_ID"));
            iotAccrue.setCallTadig(rs.getBigDecimal("CALL_TADIG"));
            iotAccrue.setSharingRate(rs.getBigDecimal("SHARING_RATE"));
            iotAccrue.setChargeTap(rs.getBigDecimal("CHARGE_TAP"));
            iotAccrue.setChargeIot(rs.getBigDecimal("CHARGE_IOT"));
            iotAccrue.setCommitment(rs.getBigDecimal("COMMITMENT"));
            iotAccrue.setDn(rs.getBigDecimal("DN"));
            iotAccrue.setCn(rs.getBigDecimal("CN"));
            iotAccrue.setReportMonth(rs.getString("REPORT_MONTH"));
            iotAccrue.setParamDate(rs.getString("PARAM_DATE"));
            iotAccrue.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            iotAccrue.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            iotAccrue.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            iotAccrue.setApplicationId(rs.getString("APPLICATION_ID"));
            iotAccrue.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            iotAccrue.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            list.add(iotAccrue);
        }
        return list;
    }

    public IotAccrue fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IotAccrue iotAccrue = new IotAccrue();
            iotAccrue.setDirection( rs.getString("DIRECTION"));
            iotAccrue.setGroupTadig( rs.getString("GROUP_TADIG"));
            iotAccrue.setMyTadig( rs.getString("MY_TADIG"));
            iotAccrue.setCountryName( rs.getString("COUNTRY_NAME"));
            iotAccrue.setOperatorName( rs.getString("OPERATOR_NAME"));
            iotAccrue.setAgreementId( rs.getString("AGREEMENT_ID"));
            iotAccrue.setPlmnGroupId( rs.getString("PLMN_GROUP_ID"));
            iotAccrue.setCallTadig( rs.getBigDecimal("CALL_TADIG"));
            iotAccrue.setSharingRate( rs.getBigDecimal("SHARING_RATE"));
            iotAccrue.setChargeTap( rs.getBigDecimal("CHARGE_TAP"));
            iotAccrue.setChargeIot( rs.getBigDecimal("CHARGE_IOT"));
            iotAccrue.setCommitment( rs.getBigDecimal("COMMITMENT"));
            iotAccrue.setDn( rs.getBigDecimal("DN"));
            iotAccrue.setCn( rs.getBigDecimal("CN"));
            iotAccrue.setReportMonth( rs.getString("REPORT_MONTH"));
            iotAccrue.setParamDate( rs.getString("PARAM_DATE"));
            iotAccrue.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            iotAccrue.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            iotAccrue.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            iotAccrue.setApplicationId( rs.getString("APPLICATION_ID"));
            iotAccrue.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            iotAccrue.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            return iotAccrue;
        }
        return null;
    }


    public void populateParent(IotAccrue iotAccrue) throws SQLException {
    }

    public void populateChild(IotAccrue iotAccrue) throws SQLException {
    }

    public void populateAll(IotAccrue iotAccrue) throws SQLException {
        populateParent(iotAccrue);
        populateChild(iotAccrue);
    }

}
