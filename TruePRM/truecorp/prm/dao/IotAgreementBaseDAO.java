
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.core.dao.SystemBaseDao;
import truecorp.prm.table.IotAgreement;
import truecorp.prm.table.IotAgreementPK;

public class IotAgreementBaseDAO  extends SystemBaseDao{

    private static Logger log = Logger.getLogger(IotAgreementBaseDAO.class);

    /** Creates a new instance of IotAgreementDAO */
    public IotAgreementBaseDAO() {
    }

    public int insert( IotAgreement iotAgreement) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into IOT_AGREEMENT(AGREEMENT_ID, PLMN_GROUP_ID, RENEW_IND, STATUS_ID, IB_CURRENCY_CD, OB_CURRENCY_CD, EFFECTIVE_DATE, EXPIRE_DATE, USER_NAME, AGREEMENT_NOTE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, IB_COMMITMENT_AMT, OB_COMMITMENT_AMT) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, iotAgreement.getAgreementId());
            stmt.setString( 2, iotAgreement.getPlmnGroupId());
            stmt.setString( 3, iotAgreement.getRenewInd());
            stmt.setBigDecimal( 4, iotAgreement.getStatusId());
            stmt.setString( 5, iotAgreement.getIbCurrencyCd());
            stmt.setString( 6, iotAgreement.getObCurrencyCd());
            stmt.setDate( 7, iotAgreement.getEffectiveDate());
            stmt.setDate( 8, iotAgreement.getExpireDate());
            stmt.setString( 9, iotAgreement.getUserName());
            stmt.setString( 10, iotAgreement.getAgreementNote());
            stmt.setDate( 11, iotAgreement.getSysCreationDate());
            stmt.setDate( 12, iotAgreement.getSysUpdateDate());
            stmt.setBigDecimal( 13, iotAgreement.getOperatorId());
            stmt.setString( 14, iotAgreement.getApplicationId());
            stmt.setString( 15, iotAgreement.getDlServiceCode());
            stmt.setBigDecimal( 16, iotAgreement.getDlUpdateStamp());
            stmt.setBigDecimal( 17, iotAgreement.getIbCommitmentAmt());
            stmt.setBigDecimal( 18, iotAgreement.getObCommitmentAmt());
            int status = stmt.executeUpdate();
            log.info("INSERT IotAgreement SUCCESS:" + iotAgreement);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IotAgreement FAIL:" + iotAgreement);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IotAgreement FAIL:" + iotAgreement);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IotAgreement iotAgreement) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update IOT_AGREEMENT set PLMN_GROUP_ID = ?  , RENEW_IND = ?  , STATUS_ID = ?  , IB_CURRENCY_CD = ?  , OB_CURRENCY_CD = ?  , EXPIRE_DATE = ?  , USER_NAME = ?  , AGREEMENT_NOTE = ?  , SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , IB_COMMITMENT_AMT = ?  , OB_COMMITMENT_AMT = ?  ";
	    SQL_STATEMENT += "where AGREEMENT_ID = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, iotAgreement.getPlmnGroupId());
            stmt.setString( 2, iotAgreement.getRenewInd());
            stmt.setBigDecimal( 3, iotAgreement.getStatusId());
            stmt.setString( 4, iotAgreement.getIbCurrencyCd());
            stmt.setString( 5, iotAgreement.getObCurrencyCd());
            stmt.setDate( 6, iotAgreement.getExpireDate());
            stmt.setString( 7, iotAgreement.getUserName());
            stmt.setString( 8, iotAgreement.getAgreementNote());
            stmt.setDate( 9, iotAgreement.getSysCreationDate());
            stmt.setDate( 10, iotAgreement.getSysUpdateDate());
            stmt.setBigDecimal( 11, iotAgreement.getOperatorId());
            stmt.setString( 12, iotAgreement.getApplicationId());
            stmt.setString( 13, iotAgreement.getDlServiceCode());
            stmt.setBigDecimal( 14, iotAgreement.getDlUpdateStamp());
            stmt.setBigDecimal( 15, iotAgreement.getIbCommitmentAmt());
            stmt.setBigDecimal( 16, iotAgreement.getObCommitmentAmt());
            stmt.setString( 17, iotAgreement.getAgreementId());
            stmt.setDate( 18, iotAgreement.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("UPDATE IotAgreement SUCCESS:" + iotAgreement);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IotAgreement FAIL:" + iotAgreement);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IotAgreement FAIL:" + iotAgreement);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IotAgreement iotAgreement) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from IOT_AGREEMENT where AGREEMENT_ID = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, iotAgreement.getAgreementId());
            stmt.setDate( 2, iotAgreement.getEffectiveDate());
            int status = stmt.executeUpdate();
            log.info("DELETE IotAgreement SUCCESS:" + iotAgreement);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IotAgreement FAIL:" + iotAgreement);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IotAgreement FAIL:" + iotAgreement);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IotAgreement findByPK( IotAgreementPK iotAgreementPK) throws SQLException {
        return findByPK( iotAgreementPK.getAgreementId(),iotAgreementPK.getEffectiveDate());   
    }


    public IotAgreement findByPK( String agreementId,java.sql.Date effectiveDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from IOT_AGREEMENT where AGREEMENT_ID = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, agreementId );
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
        String SQL_STATEMENT ="Select * from IOT_AGREEMENT";
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

    public List<IotAgreement> findByWhereCondisions(String whereConditions) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from IOT_AGREEMENT where " + whereConditions;
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
    
    public List findByAgreementId( String agreementId) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where AGREEMENT_ID = ? order by AGREEMENT_ID";
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
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where PLMN_GROUP_ID = ? order by PLMN_GROUP_ID";
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
    public List findByRenewInd( String renewInd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where RENEW_IND = ? order by RENEW_IND";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, renewInd );
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
    public List findByStatusId( java.math.BigDecimal statusId) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where STATUS_ID = ? order by STATUS_ID";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, statusId );
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
    public List findByIbCurrencyCd( String ibCurrencyCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where IB_CURRENCY_CD = ? order by IB_CURRENCY_CD";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, ibCurrencyCd );
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
    public List findByObCurrencyCd( String obCurrencyCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where OB_CURRENCY_CD = ? order by OB_CURRENCY_CD";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, obCurrencyCd );
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
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where EFFECTIVE_DATE = ? order by EFFECTIVE_DATE";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByExpireDate( java.sql.Date expireDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where EXPIRE_DATE = ? order by EXPIRE_DATE";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setDate(1, expireDate );
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
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where USER_NAME = ? order by USER_NAME";
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
    public List findByAgreementNote( String agreementNote) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where AGREEMENT_NOTE = ? order by AGREEMENT_NOTE";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, agreementNote );
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
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where OPERATOR_ID = ? order by OPERATOR_ID";
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
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where APPLICATION_ID = ? order by APPLICATION_ID";
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
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
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
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
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
    public List findByIbCommitmentAmt( java.math.BigDecimal ibCommitmentAmt) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where IB_COMMITMENT_AMT = ? order by IB_COMMITMENT_AMT";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, ibCommitmentAmt );
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
    public List findByObCommitmentAmt( java.math.BigDecimal obCommitmentAmt) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_AGREEMENT where OB_COMMITMENT_AMT = ? order by OB_COMMITMENT_AMT";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, obCommitmentAmt );
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

    public List findByCriteriaOR( IotAgreement criteria) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "";
        StringBuffer bf = new StringBuffer("Select * from SMS_APP_SENDER where ");
        String orString = "";
        
        if (criteria.getString() != null) { 
            bf.append(orString + " (AGREEMENT_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (PLMN_GROUP_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (RENEW_IND = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (STATUS_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (IB_CURRENCY_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (OB_CURRENCY_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getDate() != null) { 
            bf.append(orString + " (EFFECTIVE_DATE = ?) ");
            orString = "OR";
        }
        if (criteria.getDate() != null) { 
            bf.append(orString + " (EXPIRE_DATE = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (USER_NAME = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (AGREEMENT_NOTE = ?) ");
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
            bf.append(orString + " (IB_COMMITMENT_AMT = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (OB_COMMITMENT_AMT = ?) ");
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
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
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

    public List<IotAgreement> fetchAll(ResultSet rs) throws SQLException{
        List<IotAgreement> list = new ArrayList<IotAgreement>();
        while (rs.next()){
            IotAgreement iotAgreement = new IotAgreement();
            iotAgreement.setAgreementId(rs.getString("AGREEMENT_ID"));
            iotAgreement.setPlmnGroupId(rs.getString("PLMN_GROUP_ID"));
            iotAgreement.setRenewInd(rs.getString("RENEW_IND"));
            iotAgreement.setStatusId(rs.getBigDecimal("STATUS_ID"));
            iotAgreement.setIbCurrencyCd(rs.getString("IB_CURRENCY_CD"));
            iotAgreement.setObCurrencyCd(rs.getString("OB_CURRENCY_CD"));
            iotAgreement.setEffectiveDate(rs.getDate("EFFECTIVE_DATE"));
            iotAgreement.setExpireDate(rs.getDate("EXPIRE_DATE"));
            iotAgreement.setUserName(rs.getString("USER_NAME"));
            iotAgreement.setAgreementNote(rs.getString("AGREEMENT_NOTE"));
            iotAgreement.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            iotAgreement.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            iotAgreement.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            iotAgreement.setApplicationId(rs.getString("APPLICATION_ID"));
            iotAgreement.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            iotAgreement.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            iotAgreement.setIbCommitmentAmt(rs.getBigDecimal("IB_COMMITMENT_AMT"));
            iotAgreement.setObCommitmentAmt(rs.getBigDecimal("OB_COMMITMENT_AMT"));
            list.add(iotAgreement);
        }
        return list;
    }

    public IotAgreement fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IotAgreement iotAgreement = new IotAgreement();
            iotAgreement.setAgreementId( rs.getString("AGREEMENT_ID"));
            iotAgreement.setPlmnGroupId( rs.getString("PLMN_GROUP_ID"));
            iotAgreement.setRenewInd( rs.getString("RENEW_IND"));
            iotAgreement.setStatusId( rs.getBigDecimal("STATUS_ID"));
            iotAgreement.setIbCurrencyCd( rs.getString("IB_CURRENCY_CD"));
            iotAgreement.setObCurrencyCd( rs.getString("OB_CURRENCY_CD"));
            iotAgreement.setEffectiveDate( rs.getDate("EFFECTIVE_DATE"));
            iotAgreement.setExpireDate( rs.getDate("EXPIRE_DATE"));
            iotAgreement.setUserName( rs.getString("USER_NAME"));
            iotAgreement.setAgreementNote( rs.getString("AGREEMENT_NOTE"));
            iotAgreement.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            iotAgreement.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            iotAgreement.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            iotAgreement.setApplicationId( rs.getString("APPLICATION_ID"));
            iotAgreement.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            iotAgreement.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            iotAgreement.setIbCommitmentAmt( rs.getBigDecimal("IB_COMMITMENT_AMT"));
            iotAgreement.setObCommitmentAmt( rs.getBigDecimal("OB_COMMITMENT_AMT"));
            return iotAgreement;
        }
        return null;
    }

    public void populateParent(IotAgreement iotAgreement) throws SQLException {
    }

    public void populateChild(IotAgreement iotAgreement) throws SQLException {
    }

    public void populateAll(IotAgreement iotAgreement) throws SQLException {
        populateParent(iotAgreement);
        populateChild(iotAgreement);
    }

}
