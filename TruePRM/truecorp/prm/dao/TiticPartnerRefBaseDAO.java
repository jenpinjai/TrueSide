
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.core.dao.SystemBaseDao;
import static truecorp.prm.core.dao.SystemBaseDao.getPrmConnection;
import truecorp.prm.table.TiticPartnerRef;
import truecorp.prm.table.TiticPartnerRefPK;

public class TiticPartnerRefBaseDAO extends SystemBaseDao {

    private static Logger log = Logger.getLogger(TiticPartnerRefBaseDAO.class);

    /** Creates a new instance of TiticPartnerRefDAO */
    public TiticPartnerRefBaseDAO() {
    }

    public int insert( TiticPartnerRef titicPartnerRef) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into TITIC_PARTNER_REF(PRODUCT_CD, PARTNER_CD, PRM_CD, PARTNER_NAME, SYS_CREATION_DATE, SYS_UPDATE_DATE) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?)";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, titicPartnerRef.getProductCd());
            stmt.setString( 2, titicPartnerRef.getPartnerCd());
            stmt.setString( 3, titicPartnerRef.getPrmCd());
            stmt.setString( 4, titicPartnerRef.getPartnerName());
            stmt.setDate( 5, titicPartnerRef.getSysCreationDate());
            stmt.setDate( 6, titicPartnerRef.getSysUpdateDate());
            int status = stmt.executeUpdate();
            log.info("INSERT TiticPartnerRef SUCCESS:" + titicPartnerRef);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT TiticPartnerRef FAIL:" + titicPartnerRef);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT TiticPartnerRef FAIL:" + titicPartnerRef);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( TiticPartnerRef titicPartnerRef) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update TITIC_PARTNER_REF set PARTNER_NAME = ?  , SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  ";
	    SQL_STATEMENT += "where PRODUCT_CD = ?  and PARTNER_CD = ?  and PRM_CD = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, titicPartnerRef.getPartnerName());
            stmt.setDate( 2, titicPartnerRef.getSysCreationDate());
            stmt.setDate( 3, titicPartnerRef.getSysUpdateDate());
            stmt.setString( 4, titicPartnerRef.getProductCd());
            stmt.setString( 5, titicPartnerRef.getPartnerCd());
            stmt.setString( 6, titicPartnerRef.getPrmCd());
            int status = stmt.executeUpdate();
            log.info("UPDATE TiticPartnerRef SUCCESS:" + titicPartnerRef);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE TiticPartnerRef FAIL:" + titicPartnerRef);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE TiticPartnerRef FAIL:" + titicPartnerRef);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( TiticPartnerRef titicPartnerRef) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from TITIC_PARTNER_REF where PRODUCT_CD = ?  and PARTNER_CD = ?  and PRM_CD = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, titicPartnerRef.getProductCd());
            stmt.setString( 2, titicPartnerRef.getPartnerCd());
            stmt.setString( 3, titicPartnerRef.getPrmCd());
            int status = stmt.executeUpdate();
            log.info("DELETE TiticPartnerRef SUCCESS:" + titicPartnerRef);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE TiticPartnerRef FAIL:" + titicPartnerRef);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE TiticPartnerRef FAIL:" + titicPartnerRef);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public TiticPartnerRef findByPK( TiticPartnerRefPK titicPartnerRefPK) throws SQLException {
        return findByPK( titicPartnerRefPK.getProductCd(),titicPartnerRefPK.getPartnerCd(),titicPartnerRefPK.getPrmCd());   
    }


    public TiticPartnerRef findByPK( String productCd,String partnerCd,String prmCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from TITIC_PARTNER_REF where PRODUCT_CD = ?  and PARTNER_CD = ?  and PRM_CD = ? ";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, productCd );
            stmt.setString(2, partnerCd );
            stmt.setString(3, prmCd );
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
        String SQL_STATEMENT ="Select * from TITIC_PARTNER_REF";
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
        String SQL_STATEMENT ="Select * from TITIC_PARTNER_REF where " + whereConditions;
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
    
    public List findByProductCd( String productCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from TITIC_PARTNER_REF where PRODUCT_CD = ? order by PRODUCT_CD";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, productCd );
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
    public List findByPartnerCd( String partnerCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from TITIC_PARTNER_REF where PARTNER_CD = ? order by PARTNER_CD";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, partnerCd );
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
    public List findByPrmCd( String prmCd) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from TITIC_PARTNER_REF where PRM_CD = ? order by PRM_CD";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, prmCd );
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
    public List findByPartnerName( String partnerName) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from TITIC_PARTNER_REF where PARTNER_NAME = ? order by PARTNER_NAME";
        try {
            stmt = getPrmConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, partnerName );
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
        String SQL_STATEMENT = "Select * from TITIC_PARTNER_REF where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from TITIC_PARTNER_REF where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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

/*    

    public List findByCriteriaOR( TiticPartnerRef criteria) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "";
        StringBuffer bf = new StringBuffer("Select * from SMS_APP_SENDER where ");
        String orString = "";
        
        if (criteria.getString() != null) { 
            bf.append(orString + " (PRODUCT_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (PARTNER_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (PRM_CD = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (PARTNER_NAME = ?) ");
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
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getDate() != null) 
                stmt.setString(index++, criteria.getDate() );
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
            TiticPartnerRef titicPartnerRef = new TiticPartnerRef();
            titicPartnerRef.setProductCd(rs.getString("PRODUCT_CD"));
            titicPartnerRef.setPartnerCd(rs.getString("PARTNER_CD"));
            titicPartnerRef.setPrmCd(rs.getString("PRM_CD"));
            titicPartnerRef.setPartnerName(rs.getString("PARTNER_NAME"));
            titicPartnerRef.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            titicPartnerRef.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            list.add(titicPartnerRef);
        }
        return list;
    }

    public TiticPartnerRef fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            TiticPartnerRef titicPartnerRef = new TiticPartnerRef();
            titicPartnerRef.setProductCd( rs.getString("PRODUCT_CD"));
            titicPartnerRef.setPartnerCd( rs.getString("PARTNER_CD"));
            titicPartnerRef.setPrmCd( rs.getString("PRM_CD"));
            titicPartnerRef.setPartnerName( rs.getString("PARTNER_NAME"));
            titicPartnerRef.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            titicPartnerRef.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            return titicPartnerRef;
        }
        return null;
    }


    public void populateParent(TiticPartnerRef titicPartnerRef) throws SQLException {
    }

    public void populateChild(TiticPartnerRef titicPartnerRef) throws SQLException {
    }

    public void populateAll(TiticPartnerRef titicPartnerRef) throws SQLException {
        populateParent(titicPartnerRef);
        populateChild(titicPartnerRef);
    }

}
