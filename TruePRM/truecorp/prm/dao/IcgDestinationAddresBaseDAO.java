
package truecorp.prm.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;
import truecorp.prm.core.dao.SystemBaseDao;
import static truecorp.prm.core.dao.SystemBaseDao.getPrmConnection;
import truecorp.prm.model.Address;
import truecorp.prm.table.IcgDestinationAddres;
import truecorp.prm.table.IcgDestinationAddresPK;

public class IcgDestinationAddresBaseDAO extends SystemBaseDao {

    private static Logger log = Logger.getLogger(IcgDestinationAddresBaseDAO.class);

    /** Creates a new instance of IcgDestinationAddresDAO */
    public IcgDestinationAddresBaseDAO() {
    }

    public int insert( IcgDestinationAddres icgDestinationAddres) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into ICG_DESTINATION_ADDRES(DESTINATION_CD, ADDRESS, EFFECTIVE_DATE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, EXPIRATION_DATE) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public int update( IcgDestinationAddres icgDestinationAddres) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update ICG_DESTINATION_ADDRES set SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , EXPIRATION_DATE = ?  ";
	    SQL_STATEMENT += "where DESTINATION_CD = ?  and ADDRESS = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public int expireDestinationCd(String destinationCd,String address,java.util.Date expireDate) throws SQLException {
        Statement stmt = null;
        String SQL_STATEMENT ="update ICG_DESTINATION_ADDRES set EXPIRATION_DATE = TO_DATE('"+new SimpleDateFormat("dd-MM-yyyy HH:mm:ss",Locale.US).format(expireDate)+"', 'dd-mm-yyyy HH24:MI:SS') "
                            + " where DESTINATION_CD ='"+destinationCd+"' and ADDRESS ='"+address+"' ";
	    //SQL_STATEMENT += "where DESTINATION_CD = ?  and ADDRESS = ?  ";
        try {
                
//            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
//            stmt.setDate( 1, new Date(expireDate.getTime()));
//            stmt.setString( 2, destinationCd);
//            stmt.setString( 3, address);
            
             stmt=  getPrmConnection().createStatement();
             int status = stmt.executeUpdate(SQL_STATEMENT);
            log.info("UPDATE expireDestinationCd SUCCESS:" + destinationCd);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE expireDestinationCd FAIL:" + destinationCd);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE expireDestinationCd FAIL:" + destinationCd);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }   
    public int delete( IcgDestinationAddres icgDestinationAddres) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from ICG_DESTINATION_ADDRES where DESTINATION_CD = ?  and ADDRESS = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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



    public IcgDestinationAddres findByPK( IcgDestinationAddresPK icgDestinationAddresPK) throws SQLException {
        return findByPK( icgDestinationAddresPK.getDestinationCd(),icgDestinationAddresPK.getAddress(),icgDestinationAddresPK.getEffectiveDate());   
    }


    public IcgDestinationAddres findByPK( String destinationCd,String address,java.sql.Date effectiveDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from ICG_DESTINATION_ADDRES where DESTINATION_CD = ?  and ADDRESS = ?  and EFFECTIVE_DATE = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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

    public List findAll() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from ICG_DESTINATION_ADDRES";
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
        String SQL_STATEMENT ="Select * from ICG_DESTINATION_ADDRES where " + whereConditions;
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
    public List getAddrStringByPrmCd( String prmCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "select address from  icg_destination_addres where substr(DESTINATION_CD,1,2)= ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, prmCd );
            rs = stmt.executeQuery();
            List<String>  addressList = new ArrayList<String>();
            while (rs.next()){
                
                addressList.add(rs.getString("ADDRESS").trim());
                
            }
            return addressList;
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
     public List getAddressByPrmCd( String prmCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        
        sql.append("     select destAdd.ADDRESS ,rates.DESTINATION_CD , dest.BILLING_NAME_SEQ ,rcr.RATE_CD_SEQ ,rates.RATE_PER_UNIT_SEQ, rcr.RATE, substr(destDict.TEXT,9) as COUNTRY from icg_destination_addres destAdd   ");

        sql.append("     left join ICG_DESTINATION dest on dest.DESTINATION_CD = destAdd.DESTINATION_CD   ");

        sql.append("     left join IC_DESTINATION_DICT destDict on destDict.SEQUENCE_NO = dest.BILLING_NAME_SEQ   ");

        sql.append("     left join IC_RATES rates on rates.DESTINATION_CD = destAdd.DESTINATION_CD   ");
        sql.append("     left join IC_RATE_CODE_RATES rcr on rcr.RATE_CD_SEQ = rates.RATE_PER_UNIT_SEQ   ");

        sql.append("     where substr(destAdd.DESTINATION_CD,1,2)= '"+prmCd+"'  and destAdd.EXPIRATION_DATE > TO_DATE('01-01-2999','dd-mm-yyyy')  ");
        
        try {
            stmt = getPrmConnection().prepareStatement(sql.toString());
            //stmt.setString(1, prmCd );
            rs = stmt.executeQuery();
            List<Address>  addressList = new ArrayList<Address>();
            while (rs.next()){
                Address  addr = new Address();
                
                addr.setAddress(rs.getString("ADDRESS").trim());
                addr.setDescription(rs.getString("COUNTRY"));
                addr.setDestinationCd(rs.getString("DESTINATION_CD"));
                addr.setCost(rs.getString("RATE"));
                addr.setRateCdSeq(rs.getString("RATE_CD_SEQ"));
                addr.setBillingNameSeq(rs.getString("BILLING_NAME_SEQ"));
                addressList.add(addr);
                
            }
            return addressList;
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION_ADDRES where DESTINATION_CD = ? order by DESTINATION_CD";
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
    public List findByAddress( String address) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from ICG_DESTINATION_ADDRES where ADDRESS = ? order by ADDRESS";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByEffectiveDate( java.sql.Date effectiveDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from ICG_DESTINATION_ADDRES where EFFECTIVE_DATE = ? order by EFFECTIVE_DATE";
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION_ADDRES where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION_ADDRES where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION_ADDRES where OPERATOR_ID = ? order by OPERATOR_ID";
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION_ADDRES where APPLICATION_ID = ? order by APPLICATION_ID";
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION_ADDRES where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
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
        String SQL_STATEMENT = "Select * from ICG_DESTINATION_ADDRES where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
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
    public List findByExpirationDate( java.sql.Date expirationDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from ICG_DESTINATION_ADDRES where EXPIRATION_DATE = ? order by EXPIRATION_DATE";
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

    public List findByCriteriaOR( IcgDestinationAddres criteria) throws SQLException {
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
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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


    public void populateParent(IcgDestinationAddres icgDestinationAddres) throws SQLException {
    }

    public void populateChild(IcgDestinationAddres icgDestinationAddres) throws SQLException {
    }

    public void populateAll(IcgDestinationAddres icgDestinationAddres) throws SQLException {
        populateParent(icgDestinationAddres);
        populateChild(icgDestinationAddres);
    }
    public int deleteAllBy(String prmCd) throws SQLException {
        Statement stmt = null;
        String SQL_STATEMENT ="delete icg_destination_addres where substr(DESTINATION_CD,1,2)= '"+prmCd+"' ";
        try {
            stmt = getPrmConnection().createStatement();
            int status = stmt.executeUpdate(SQL_STATEMENT);
            log.info("DELETE IcgDestinationAddres SUCCESS");
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IcgDestinationAddres FAIL:");
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IcgDestinationAddres FAIL:");
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public boolean contain(String address ,String prmCd) throws Exception{
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="select ADDRESS from  icg_destination_addres where substr(DESTINATION_CD,1,2)= '"+prmCd+"'  and address = '"+address+"' ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stmt.close();
            rs.close();
        }
        return false;
        
    }

}
