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
public class PaymentDAO extends SystemBaseDao{
    
    public String getSourceId(String accountId,String pymSeqNo) throws Exception{
        String result="";
                Statement stmt=null;
                ResultSet rs = null;
                StringBuilder sql= new StringBuilder();
                try {


                    sql.append("    select  SOURCE_ID  ");
                    sql.append("    from PAYMENT  ");
                    sql.append("    where account_id = '"+accountId+"' ");
                    sql.append("    and pym_seq_no = '"+pymSeqNo+"'  ");
                    
                    stmt = getBillingConnection().createStatement();
                    rs = stmt.executeQuery(sql.toString());

                    while(rs.next()){
                                result = rs.getString("SOURCE_ID");
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
    public String getPaymentDate(String accountId,String pymSeqNo) throws Exception{
                String result="";
                Statement stmt=null;
                ResultSet rs = null;
                StringBuilder sql= new StringBuilder();
                try {

                    sql.append("      select  to_char(CUSTOMER_PYM_DATE,'YYYYMMDD')  ");
                    sql.append("      from PAYMENT  ");
                    sql.append("      where account_id = '"+accountId+"'  ");
                    sql.append("      and pym_seq_no = '"+pymSeqNo+"'  ");
                    
                    stmt = getBillingConnection().createStatement();
                    rs = stmt.executeQuery(sql.toString());

                    while(rs.next()){
                                result = rs.getString("to_char(CUSTOMER_PYM_DATE,'YYYYMMDD')");
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
    public String getBillMonth(String accountId,String pymSeqNo) throws Exception{
                String result="";
                Statement stmt=null;
                ResultSet rs = null;
                StringBuilder sql= new StringBuilder();
                try {
                    
                    sql.append("      select  BILL_MONTH  ");
                    sql.append("      from PAYMENT  ");
                    sql.append("      where account_id = '"+accountId+"'  ");
                    sql.append("      and pym_seq_no = '"+pymSeqNo+"'  ");
                    
                    stmt = getBillingConnection().createStatement();
                    rs = stmt.executeQuery(sql.toString());

                    while(rs.next()){
                                result = rs.getString("BILL_MONTH");
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
    public String getOutletCode(String accountId,String pymSeqNo) throws Exception{
                String result="";
                Statement stmt=null;
                ResultSet rs = null;
                StringBuilder sql= new StringBuilder();
                try {
                    
                    sql.append("      select substr(PAY_POINT_NO,1,4)  ");
                    sql.append("       from PAYMENT  ");
                    sql.append("      where account_id = '"+accountId+"'   ");
                    sql.append("      and pym_seq_no = '"+pymSeqNo+"'   ");
                    
                    stmt = getBillingConnection().createStatement();
                    rs = stmt.executeQuery(sql.toString());

                    while(rs.next()){
                                result = rs.getString("substr(PAY_POINT_NO,1,4)");
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
    public String getDCPNo(String accountId,String pymSeqNo) throws Exception{
                String result="";
                Statement stmt=null;
                ResultSet rs = null;
                StringBuilder sql= new StringBuilder();
                try {
                    
                    sql.append("      select  DCP_NO  ");
                    sql.append("      from PAYMENT  ");
                    sql.append("      where account_id = '"+accountId+"'   ");
                    sql.append("      and pym_seq_no = '"+pymSeqNo+"'  ");
                    
                    stmt = getBillingConnection().createStatement();
                    rs = stmt.executeQuery(sql.toString());

                    while(rs.next()){
                                result = rs.getString("DCP_NO");
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
    public String getGLCode(String accountId,String pymSeqNo) throws Exception{
                String result="";
                Statement stmt=null;
                ResultSet rs = null;
                StringBuilder sql= new StringBuilder();
                try {
                    
                    sql.append("      select  PYM_GL_CODE  ");
                    sql.append("      from PAYMENT  ");
                    sql.append("      where account_id = '"+accountId+"'  ");
                    sql.append("      and pym_seq_no = '"+pymSeqNo+"'  ");
                    
                    stmt = getBillingConnection().createStatement();
                    rs = stmt.executeQuery(sql.toString());

                    while(rs.next()){
                                result = rs.getString("PYM_GL_CODE");
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
    public String getReceiptNumPos(String accountId,String pymSeqNo) throws Exception{
                String result="";
                Statement stmt=null;
                ResultSet rs = null;
                StringBuilder sql= new StringBuilder();
                try {
                    
                    sql.append("      select  substr(TAX_INV_NUMBER,1,7)  ");
                    sql.append("      from PAYMENT_ACTIVITY  ");
                    sql.append("      where account_id = '"+accountId+"'  ");
                    sql.append("      and pym_seq_no = '"+pymSeqNo+"'  ");
                    
                    stmt = getBillingConnection().createStatement();
                    rs = stmt.executeQuery(sql.toString());

                    while(rs.next()){
                                result = rs.getString("substr(TAX_INV_NUMBER,1,7)");
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
    public String getBatchNo(String accountId,String pymSeqNo) throws Exception{
                String result="";
                Statement stmt=null;
                ResultSet rs = null;
                StringBuilder sql= new StringBuilder();
                try {
                    
                    sql.append("      select  BATCH_NO  ");
                    sql.append("      from PAYMENT  ");
                    sql.append("      where account_id = '"+accountId+"'  ");
                    sql.append("      and pym_seq_no = '"+pymSeqNo+"'  ");
                    
                    stmt = getBillingConnection().createStatement();
                    rs = stmt.executeQuery(sql.toString());

                    while(rs.next()){
                                result = rs.getString("BATCH_NO");
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
    public String getBatchType(String accountId,String pymSeqNo) throws Exception{
                String result="";
                Statement stmt=null;
                ResultSet rs = null;
                StringBuilder sql= new StringBuilder();
                try {
                    
                    sql.append("      select  BATCH_TYPE  ");
                    sql.append("      from PAYMENT  ");
                    sql.append("      where account_id = '"+accountId+"'  ");
                    sql.append("      and pym_seq_no = '"+pymSeqNo+"'  ");
                    
                    stmt = getBillingConnection().createStatement();
                    rs = stmt.executeQuery(sql.toString());

                    while(rs.next()){
                                result = rs.getString("BATCH_TYPE");
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
    public String getZone(String accountId,String pymSeqNo) throws Exception{
                String result="";
                Statement stmt=null;
                ResultSet rs = null;
                StringBuilder sql= new StringBuilder();
                try {
                    
                    sql.append("      select  point.zone ");
                    sql.append("      from PAYMENT pay,PAY_POINT point ");
                    sql.append("      where pay.account_id = '"+accountId+"' ");
                    sql.append("      and pay.pym_seq_no = '"+pymSeqNo+"' ");
                    sql.append("      and pay.pay_point_no = point.pay_point_no ");
                    sql.append("      and pay.source_id = point.source_id  ");
                    
                    stmt = getBillingConnection().createStatement();
                    rs = stmt.executeQuery(sql.toString());

                    while(rs.next()){
                                result = rs.getString("ZONE");
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
