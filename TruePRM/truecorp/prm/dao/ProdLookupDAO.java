/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import truecorp.prm.core.dao.SystemBaseDao;
import static truecorp.prm.core.dao.SystemBaseDao.getPrmAppConnection;

/**
 *
 * @author Jennarong Pinjai
 */
public class ProdLookupDAO extends SystemBaseDao{
    
    public String getResultParam1(String productId) throws Exception{
            String resultParam1="";
            Statement stmt=null;
            ResultSet rs = null;
            StringBuilder sql= new StringBuilder();
            try {
                
                sql.append("      select  result_param_1  ");
                sql.append("      from prm_prod_lookup   ");
                sql.append("      where record_type = 'NAT'   ");
                sql.append("      and lookup_param_2 = substr('"+productId+"',2,4)   ");
                sql.append("      And ( lookup_param_3 >= substr('"+productId+"',6,4))  ");
                
                stmt = getBillingConnection().createStatement();
                rs = stmt.executeQuery(sql.toString());
                
                while(rs.next()){
                            resultParam1 = rs.getString("result_param_1");
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                rs.close();
            }
            return resultParam1;
    }
    
}
