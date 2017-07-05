/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import truecorp.prm.core.dao.SystemBaseDao;
import static truecorp.prm.core.dao.SystemBaseDao.getPrmAppConnection;

/**
 *
 * @author Jennarong Pinjai
 */
public class CustomerAccountDAO extends SystemBaseDao{
    
    public String getPymMtd(String accountId) throws Exception{
    String result="";
            Statement stmt=null;
            ResultSet rs = null;
            StringBuilder sql= new StringBuilder();
            try {
                
                sql.append("    select  PYM_MTD  ");
                sql.append("    from CUSTOMER_ACCOUNT  ");
                sql.append("     where account_id = '"+accountId+"' ");
                
                stmt = getBillingConnection().createStatement();
                rs = stmt.executeQuery(sql.toString());
                
                while(rs.next()){
                            result = rs.getString("PYM_MTD");
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                rs.close();
                stmt.close();
            }
            return result;
    
    
    }
    public String getBankCode(String accountId) throws Exception{
    String result="";
            Statement stmt=null;
            ResultSet rs = null;
            StringBuilder sql= new StringBuilder();
            try {
                    
                sql.append("    select  BANK_CODE  ");
                sql.append("    from ACCOUNT_PYM_MTD  ");
                sql.append("    where account_id = '"+accountId+"'  ");
                
                stmt = getBillingConnection().createStatement();
                rs = stmt.executeQuery(sql.toString());
                
                while(rs.next()){
                            result = rs.getString("BANK_CODE");
                }
                if(result==null||result.equals("null")){
                    result="";
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                rs.close();
                stmt.close();
            }
            return result;
    
    
    }
    public String getPymSubMtd(String accountId) throws Exception{
    String result="";
            Statement stmt=null;
            ResultSet rs = null;
            StringBuilder sql= new StringBuilder();
            try {
                
                sql.append("    select  PYM_SUB_MTD  ");
                sql.append("    from ACCOUNT_PYM_MTD  ");
                sql.append("    where account_id = '"+accountId+"'  ");
                
                stmt = getBillingConnection().createStatement();
                rs = stmt.executeQuery(sql.toString());
                
                while(rs.next()){
                            result = rs.getString("PYM_SUB_MTD");
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                rs.close();
                stmt.close();
            }
            return result;
    
    
    }
    public String getTaxCode(String accountId) throws Exception{
    String result="";
            Statement stmt=null;
            ResultSet rs = null;
            StringBuilder sql= new StringBuilder();
            try {
                    
                sql.append("    select  TAX_CODE  ");
                sql.append("    from CUSTOMER_ACCOUNT   ");
                sql.append("    where account_id = '"+accountId+"'  ");
                
                stmt = getBillingConnection().createStatement();
                rs = stmt.executeQuery(sql.toString());
                
                while(rs.next()){
                            result = rs.getString("TAX_CODE");
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                rs.close();
                stmt.close();
            }
            return result;
    }
    public String getAccountFullType(String accountId) throws Exception{
    String result="";
            Statement stmt=null;
            ResultSet rs = null;
            StringBuilder sql= new StringBuilder();
            try {
                
                sql.append("    select ACCOUNT_TYPE||ACCOUNT_SUB_TYPE as ACCOUNT_FULL_TYPE  ");
                sql.append("    from CUSTOMER_ACCOUNT   ");
                sql.append("    where account_id = '"+accountId+"'  ");
                
                stmt = getBillingConnection().createStatement();
                rs = stmt.executeQuery(sql.toString());
                
                while(rs.next()){
                            result = rs.getString("ACCOUNT_FULL_TYPE");
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                rs.close();
                stmt.close();
            }
            return result;
    }
    
}
