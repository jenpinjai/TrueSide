
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.core.dao.SystemBaseDao;
import static truecorp.prm.core.dao.SystemBaseDao.getPrmConnection;
import truecorp.prm.model.Country;
import truecorp.prm.model.RateCodePack;
import truecorp.prm.table.*;


public class IcDestinationDictBaseDAO extends SystemBaseDao{

    private static Logger log = Logger.getLogger(IcDestinationDictBaseDAO.class);

    /** Creates a new instance of IcDestinationDictDAO */
    public IcDestinationDictBaseDAO() {
    }

    public int insert( IcDestinationDict icDestinationDict) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into IC_DESTINATION_DICT(SEQUENCE_NO, LANGUAGE_CODE, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, TEXT) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal( 1, icDestinationDict.getSequenceNo());
            stmt.setString( 2, icDestinationDict.getLanguageCode());
            stmt.setDate( 3, icDestinationDict.getSysCreationDate());
            stmt.setDate( 4, icDestinationDict.getSysUpdateDate());
            stmt.setBigDecimal( 5, icDestinationDict.getOperatorId());
            stmt.setString( 6, icDestinationDict.getApplicationId());
            stmt.setString( 7, icDestinationDict.getDlServiceCode());
            stmt.setBigDecimal( 8, icDestinationDict.getDlUpdateStamp());
            stmt.setString( 9, icDestinationDict.getText());
            int status = stmt.executeUpdate();
            log.info("INSERT IcDestinationDict SUCCESS:" + icDestinationDict);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IcDestinationDict FAIL:" + icDestinationDict);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IcDestinationDict FAIL:" + icDestinationDict);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IcDestinationDict icDestinationDict) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update IC_DESTINATION_DICT set SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , TEXT = ?  ";
	    SQL_STATEMENT += "where SEQUENCE_NO = ?  and LANGUAGE_CODE = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setDate( 1, icDestinationDict.getSysCreationDate());
            stmt.setDate( 2, icDestinationDict.getSysUpdateDate());
            stmt.setBigDecimal( 3, icDestinationDict.getOperatorId());
            stmt.setString( 4, icDestinationDict.getApplicationId());
            stmt.setString( 5, icDestinationDict.getDlServiceCode());
            stmt.setBigDecimal( 6, icDestinationDict.getDlUpdateStamp());
            stmt.setString( 7, icDestinationDict.getText());
            stmt.setBigDecimal( 8, icDestinationDict.getSequenceNo());
            stmt.setString( 9, icDestinationDict.getLanguageCode());
            int status = stmt.executeUpdate();
            log.info("UPDATE IcDestinationDict SUCCESS:" + icDestinationDict);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IcDestinationDict FAIL:" + icDestinationDict);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IcDestinationDict FAIL:" + icDestinationDict);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IcDestinationDict icDestinationDict) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from IC_DESTINATION_DICT where SEQUENCE_NO = ?  and LANGUAGE_CODE = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal( 1, icDestinationDict.getSequenceNo());
            stmt.setString( 2, icDestinationDict.getLanguageCode());
            int status = stmt.executeUpdate();
            log.info("DELETE IcDestinationDict SUCCESS:" + icDestinationDict);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IcDestinationDict FAIL:" + icDestinationDict);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IcDestinationDict FAIL:" + icDestinationDict);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IcDestinationDict findByPK( IcDestinationDictPK icDestinationDictPK) throws SQLException {
        return findByPK( icDestinationDictPK.getSequenceNo(),icDestinationDictPK.getLanguageCode());   
    }


    public IcDestinationDict findByPK( java.math.BigDecimal sequenceNo,String languageCode) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from IC_DESTINATION_DICT where SEQUENCE_NO = ?  and LANGUAGE_CODE = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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

    public List findAll() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from IC_DESTINATION_DICT";
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
        String SQL_STATEMENT ="Select * from IC_DESTINATION_DICT where " + whereConditions;
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
    public List getStringCountry(String prmCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "select substr(TEXT,9) as TEXT from ic_destination_dict where substr(TEXT,1,2)=? and substr(TEXT,3,2)= ' T' ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, prmCd );
            rs = stmt.executeQuery();
            List<String>  addressList = new ArrayList<String>();
            while (rs.next()){
                
                addressList.add(rs.getString("TEXT").trim());
                
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
    public List findBySequenceNo( java.math.BigDecimal sequenceNo) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_DESTINATION_DICT where SEQUENCE_NO = ? order by SEQUENCE_NO";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findByLanguageCode( String languageCode) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_DESTINATION_DICT where LANGUAGE_CODE = ? order by LANGUAGE_CODE";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
    public List findBySysCreationDate( java.sql.Date sysCreationDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_DESTINATION_DICT where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from IC_DESTINATION_DICT where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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
        String SQL_STATEMENT = "Select * from IC_DESTINATION_DICT where OPERATOR_ID = ? order by OPERATOR_ID";
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
        String SQL_STATEMENT = "Select * from IC_DESTINATION_DICT where APPLICATION_ID = ? order by APPLICATION_ID";
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
        String SQL_STATEMENT = "Select * from IC_DESTINATION_DICT where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
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
        String SQL_STATEMENT = "Select * from IC_DESTINATION_DICT where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
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
    public List findByText( String text) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IC_DESTINATION_DICT where TEXT = ? order by TEXT";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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

    public List findByCriteriaOR( IcDestinationDict criteria) throws SQLException {
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
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
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
            IcDestinationDict icDestinationDict = new IcDestinationDict();
            icDestinationDict.setSequenceNo(rs.getBigDecimal("SEQUENCE_NO"));
            icDestinationDict.setLanguageCode(rs.getString("LANGUAGE_CODE"));
            icDestinationDict.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            icDestinationDict.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            icDestinationDict.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            icDestinationDict.setApplicationId(rs.getString("APPLICATION_ID"));
            icDestinationDict.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            icDestinationDict.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            icDestinationDict.setText(rs.getString("TEXT"));
            list.add(icDestinationDict);
        }
        return list;
    }

    public IcDestinationDict fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IcDestinationDict icDestinationDict = new IcDestinationDict();
            icDestinationDict.setSequenceNo( rs.getBigDecimal("SEQUENCE_NO"));
            icDestinationDict.setLanguageCode( rs.getString("LANGUAGE_CODE"));
            icDestinationDict.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            icDestinationDict.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            icDestinationDict.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            icDestinationDict.setApplicationId( rs.getString("APPLICATION_ID"));
            icDestinationDict.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            icDestinationDict.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            icDestinationDict.setText( rs.getString("TEXT"));
            return icDestinationDict;
        }
        return null;
    }

    public void populateParent(IcDestinationDict icDestinationDict) throws SQLException {
    }

    public void populateChild(IcDestinationDict icDestinationDict) throws SQLException {
    }

    public void populateAll(IcDestinationDict icDestinationDict) throws SQLException {
        populateParent(icDestinationDict);
        populateChild(icDestinationDict);
    }
    
    public int getMaxSequenceNo() throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="select max(sequence_no) as sequence_no from ic_destination_dict ";
	
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            ResultSet   resultSet = stmt.executeQuery();
            log.info("getMaxSequenceNo SUCCESS");
            resultSet.next();
            return resultSet.getInt("sequence_no");
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int deleteAllBy(String prmCd) throws SQLException {
        Statement stmt = null;
        String SQL_STATEMENT ="delete ic_destination_dict where substr(TEXT,1,2)='"+prmCd+"' and substr(TEXT,3,2)= ' T' ";
        try {
            stmt = getPrmConnection().createStatement();
            int status = stmt.executeUpdate(SQL_STATEMENT);
            log.info("DELETE ic_destination_dict SUCCESS");
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE ic_destination_dict FAIL:");
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE ic_destination_dict FAIL:");
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int getCountCounties(String prmCd) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="select count(rownum) as count from ic_rate_code_rates where rate_class_set_cd like '%"+prmCd+"' ";
	
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            ResultSet   resultSet = stmt.executeQuery();
            log.info("getCountRates SUCCESS");
            resultSet.next();
            return resultSet.getInt("COUNT");
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public List getCountryByPrmCd( String prmCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        
        sql.append(" select substr(TEXT,9) as TEXT from ic_destination_dict where substr(TEXT,1,2)='"+prmCd+"'  order by sequence_no asc   ");
        
        
        try {
            stmt = getPrmConnection().prepareStatement(sql.toString());
            //stmt.setString(1, prmCd );
            rs = stmt.executeQuery();
            List<Country>  countryList = new ArrayList<Country>();
            while (rs.next()){
                Country  country = new Country();
                
                
                country.setName(rs.getString("TEXT"));
                countryList.add(country);
                
            }
            return countryList;
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
}
