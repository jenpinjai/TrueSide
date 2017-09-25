
package truecorp.prm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import truecorp.prm.core.dao.SystemBaseDao;
import truecorp.prm.table.IotMaster;
import truecorp.prm.table.IotMasterPK;

public class IotMasterBaseDAO  extends SystemBaseDao{

    private static Logger log = Logger.getLogger(IotMasterBaseDAO.class);

    /** Creates a new instance of IotMasterDAO */
    public IotMasterBaseDAO() {
    }

    public int insert( IotMaster iotMaster) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Insert into IOT_MASTER(DIRECTION, MY_TADIG, COUNTRY_NAME, OPERATOR_NAME, THEIR_TADIG, YEAR_TADIG, MONTH_TADIG, TYPE_TADIG, CALL_TADIG, REAL_DURATION, REAL_GPRS, ROUND_TADIG, CHARGE_LOCAL, CHARGE_SDR, CALL_COUNTRY, DES_TYPE, VOLUME_REAL, VOLUME_ROUND, GROUP_TADIG, CURRENCY_IOT, VOLUMN, RATE_TYPE, RATE_IOT_CURRENCY, IOT_SDR, RATE_IOT_THAI, NET, DISCOUNT, TAP_RATE, TAP_IM, REAL_NET, THB_SDR, REV_SDR, DN, CN, COMMITMENT, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID, APPLICATION_ID, DL_SERVICE_CODE, DL_UPDATE_STAMP, AGREEMENT_ID, PLMN_GROUP_ID) ";
	SQL_STATEMENT += "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, iotMaster.getDirection());
            stmt.setString( 2, iotMaster.getMyTadig());
            stmt.setString( 3, iotMaster.getCountryName());
            stmt.setString( 4, iotMaster.getOperatorName());
            stmt.setString( 5, iotMaster.getTheirTadig());
            stmt.setString( 6, iotMaster.getYearTadig());
            stmt.setString( 7, iotMaster.getMonthTadig());
            stmt.setString( 8, iotMaster.getTypeTadig());
            stmt.setBigDecimal( 9, iotMaster.getCallTadig());
            stmt.setBigDecimal( 10, iotMaster.getRealDuration());
            stmt.setBigDecimal( 11, iotMaster.getRealGprs());
            stmt.setBigDecimal( 12, iotMaster.getRoundTadig());
            stmt.setBigDecimal( 13, iotMaster.getChargeLocal());
            stmt.setBigDecimal( 14, iotMaster.getChargeSdr());
            stmt.setString( 15, iotMaster.getCallCountry());
            stmt.setString( 16, iotMaster.getDesType());
            stmt.setBigDecimal( 17, iotMaster.getVolumeReal());
            stmt.setBigDecimal( 18, iotMaster.getVolumeRound());
            stmt.setString( 19, iotMaster.getGroupTadig());
            stmt.setString( 20, iotMaster.getCurrencyIot());
            stmt.setString( 21, iotMaster.getVolumn());
            stmt.setString( 22, iotMaster.getRateType());
            stmt.setBigDecimal( 23, iotMaster.getRateIotCurrency());
            stmt.setBigDecimal( 24, iotMaster.getIotSdr());
            stmt.setBigDecimal( 25, iotMaster.getRateIotThai());
            stmt.setBigDecimal( 26, iotMaster.getNet());
            stmt.setBigDecimal( 27, iotMaster.getDiscount());
            stmt.setBigDecimal( 28, iotMaster.getTapRate());
            stmt.setString( 29, iotMaster.getTapIm());
            stmt.setBigDecimal( 30, iotMaster.getRealNet());
            stmt.setBigDecimal( 31, iotMaster.getThbSdr());
            stmt.setBigDecimal( 32, iotMaster.getRevSdr());
            stmt.setBigDecimal( 33, iotMaster.getDn());
            stmt.setBigDecimal( 34, iotMaster.getCn());
            stmt.setBigDecimal( 35, iotMaster.getCommitment());
            stmt.setDate( 36, iotMaster.getSysCreationDate());
            stmt.setDate( 37, iotMaster.getSysUpdateDate());
            stmt.setBigDecimal( 38, iotMaster.getOperatorId());
            stmt.setString( 39, iotMaster.getApplicationId());
            stmt.setString( 40, iotMaster.getDlServiceCode());
            stmt.setBigDecimal( 41, iotMaster.getDlUpdateStamp());
            stmt.setString( 42, iotMaster.getAgreementId());
            stmt.setString( 43, iotMaster.getPlmnGroupId());
            int status = stmt.executeUpdate();
            log.info("INSERT IotMaster SUCCESS:" + iotMaster);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("INSERT IotMaster FAIL:" + iotMaster);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("INSERT IotMaster FAIL:" + iotMaster);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }
    public int update( IotMaster iotMaster) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Update IOT_MASTER set CALL_TADIG = ?  , REAL_DURATION = ?  , REAL_GPRS = ?  , ROUND_TADIG = ?  , CHARGE_LOCAL = ?  , CHARGE_SDR = ?  , VOLUME_REAL = ?  , VOLUME_ROUND = ?  , GROUP_TADIG = ?  , CURRENCY_IOT = ?  , VOLUMN = ?  , RATE_TYPE = ?  , RATE_IOT_CURRENCY = ?  , IOT_SDR = ?  , RATE_IOT_THAI = ?  , NET = ?  , DISCOUNT = ?  , TAP_RATE = ?  , TAP_IM = ?  , REAL_NET = ?  , THB_SDR = ?  , REV_SDR = ?  , DN = ?  , CN = ?  , COMMITMENT = ?  , SYS_CREATION_DATE = ?  , SYS_UPDATE_DATE = ?  , OPERATOR_ID = ?  , APPLICATION_ID = ?  , DL_SERVICE_CODE = ?  , DL_UPDATE_STAMP = ?  , AGREEMENT_ID = ?  , PLMN_GROUP_ID = ?  ";
	    SQL_STATEMENT += "where DIRECTION = ?  and MY_TADIG = ?  and COUNTRY_NAME = ?  and OPERATOR_NAME = ?  and THEIR_TADIG = ?  and YEAR_TADIG = ?  and MONTH_TADIG = ?  and TYPE_TADIG = ?  and CALL_COUNTRY = ?  and DES_TYPE = ? ";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal( 1, iotMaster.getCallTadig());
            stmt.setBigDecimal( 2, iotMaster.getRealDuration());
            stmt.setBigDecimal( 3, iotMaster.getRealGprs());
            stmt.setBigDecimal( 4, iotMaster.getRoundTadig());
            stmt.setBigDecimal( 5, iotMaster.getChargeLocal());
            stmt.setBigDecimal( 6, iotMaster.getChargeSdr());
            stmt.setBigDecimal( 7, iotMaster.getVolumeReal());
            stmt.setBigDecimal( 8, iotMaster.getVolumeRound());
            stmt.setString( 9, iotMaster.getGroupTadig());
            stmt.setString( 10, iotMaster.getCurrencyIot());
            stmt.setString( 11, iotMaster.getVolumn());
            stmt.setString( 12, iotMaster.getRateType());
            stmt.setBigDecimal( 13, iotMaster.getRateIotCurrency());
            stmt.setBigDecimal( 14, iotMaster.getIotSdr());
            stmt.setBigDecimal( 15, iotMaster.getRateIotThai());
            stmt.setBigDecimal( 16, iotMaster.getNet());
            stmt.setBigDecimal( 17, iotMaster.getDiscount());
            stmt.setBigDecimal( 18, iotMaster.getTapRate());
            stmt.setString( 19, iotMaster.getTapIm());
            stmt.setBigDecimal( 20, iotMaster.getRealNet());
            stmt.setBigDecimal( 21, iotMaster.getThbSdr());
            stmt.setBigDecimal( 22, iotMaster.getRevSdr());
            stmt.setBigDecimal( 23, iotMaster.getDn());
            stmt.setBigDecimal( 24, iotMaster.getCn());
            stmt.setBigDecimal( 25, iotMaster.getCommitment());
            stmt.setDate( 26, iotMaster.getSysCreationDate());
            stmt.setDate( 27, iotMaster.getSysUpdateDate());
            stmt.setBigDecimal( 28, iotMaster.getOperatorId());
            stmt.setString( 29, iotMaster.getApplicationId());
            stmt.setString( 30, iotMaster.getDlServiceCode());
            stmt.setBigDecimal( 31, iotMaster.getDlUpdateStamp());
            stmt.setString( 32, iotMaster.getAgreementId());
            stmt.setString( 33, iotMaster.getPlmnGroupId());
            stmt.setString( 34, iotMaster.getDirection());
            stmt.setString( 35, iotMaster.getMyTadig());
            stmt.setString( 36, iotMaster.getCountryName());
            stmt.setString( 37, iotMaster.getOperatorName());
            stmt.setString( 38, iotMaster.getTheirTadig());
            stmt.setString( 39, iotMaster.getYearTadig());
            stmt.setString( 40, iotMaster.getMonthTadig());
            stmt.setString( 41, iotMaster.getTypeTadig());
            stmt.setString( 42, iotMaster.getCallCountry());
            stmt.setString( 43, iotMaster.getDesType());
            int status = stmt.executeUpdate();
            log.info("UPDATE IotMaster SUCCESS:" + iotMaster);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("UPDATE IotMaster FAIL:" + iotMaster);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("UPDATE IotMaster FAIL:" + iotMaster);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }    
    
    public int delete( IotMaster iotMaster) throws SQLException {
        PreparedStatement stmt = null;
        String SQL_STATEMENT ="Delete from IOT_MASTER where DIRECTION = ?  and MY_TADIG = ?  and COUNTRY_NAME = ?  and OPERATOR_NAME = ?  and THEIR_TADIG = ?  and YEAR_TADIG = ?  and MONTH_TADIG = ?  and TYPE_TADIG = ?  and CALL_COUNTRY = ?  and DES_TYPE = ? ";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString( 1, iotMaster.getDirection());
            stmt.setString( 2, iotMaster.getMyTadig());
            stmt.setString( 3, iotMaster.getCountryName());
            stmt.setString( 4, iotMaster.getOperatorName());
            stmt.setString( 5, iotMaster.getTheirTadig());
            stmt.setString( 6, iotMaster.getYearTadig());
            stmt.setString( 7, iotMaster.getMonthTadig());
            stmt.setString( 8, iotMaster.getTypeTadig());
            stmt.setString( 9, iotMaster.getCallCountry());
            stmt.setString( 10, iotMaster.getDesType());
            int status = stmt.executeUpdate();
            log.info("DELETE IotMaster SUCCESS:" + iotMaster);
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("DELETE IotMaster FAIL:" + iotMaster);
            log.error(ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("DELETE IotMaster FAIL:" + iotMaster);
            log.error(ex.toString());
        } finally {
            stmt.close();
        }
        return -1;
    }



    public IotMaster findByPK( IotMasterPK iotMasterPK) throws SQLException {
        return findByPK( iotMasterPK.getDirection(),iotMasterPK.getMyTadig(),iotMasterPK.getCountryName(),iotMasterPK.getOperatorName(),iotMasterPK.getTheirTadig(),iotMasterPK.getYearTadig(),iotMasterPK.getMonthTadig(),iotMasterPK.getTypeTadig(),iotMasterPK.getCallCountry(),iotMasterPK.getDesType());   
    }


    public IotMaster findByPK( String direction,String myTadig,String countryName,String operatorName,String theirTadig,String yearTadig,String monthTadig,String typeTadig,String callCountry,String desType) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select * from IOT_MASTER where DIRECTION = ?  and MY_TADIG = ?  and COUNTRY_NAME = ?  and OPERATOR_NAME = ?  and THEIR_TADIG = ?  and YEAR_TADIG = ?  and MONTH_TADIG = ?  and TYPE_TADIG = ?  and CALL_COUNTRY = ?  and DES_TYPE = ? ";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, direction );
            stmt.setString(2, myTadig );
            stmt.setString(3, countryName );
            stmt.setString(4, operatorName );
            stmt.setString(5, theirTadig );
            stmt.setString(6, yearTadig );
            stmt.setString(7, monthTadig );
            stmt.setString(8, typeTadig );
            stmt.setString(9, callCountry );
            stmt.setString(10, desType );
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
        String SQL_STATEMENT ="Select * from IOT_MASTER";
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
    public List<IotMaster> findByDirection(String direction) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        
        try {
            
//            sql.append("    select direction,group_tadig,MY_TADIG,COUNTRY_NAME,OPERATOR_NAME,agreement_id,plmn_group_id,sum(CALL_TADIG),sum(charge_local),sum(net)  ");
//            sql.append("    from iot_master   ");
//            sql.append("    where direction = '"+direction+"'   ");
//            sql.append("       ");
//            sql.append("    group by direction,group_tadig,MY_TADIG,COUNTRY_NAME,OPERATOR_NAME,agreement_id,plmn_group_id   ");
//            sql.append("    order by direction,group_tadig asc   ");
            
                            
              sql.append("      select direction,group_tadig,MY_TADIG,COUNTRY_NAME,OPERATOR_NAME,agreement_id,plmn_group_id,sum(CALL_TADIG),sum(charge_local),sum(net)   ");
              sql.append("                from (select mas.group_tadig ,mas2.direction,mas2.MY_TADIG,  ");
              sql.append("                            mas2.COUNTRY_NAME,mas2.OPERATOR_NAME,mas2.YEAR_TADIG,mas2.MONTH_TADIG,  ");
              sql.append("                            mas2.agreement_id,mas2.plmn_group_id,mas2.call_tadig,(mas2.charge_local + (mas2.charge_local/25)*(mas2.days_of_month-25)) as charge_local,  ");
              sql.append("                            (mas2.net + (mas2.net/25)*(mas2.days_of_month-25)) as net  ");
              sql.append("                      from (  select group_tadig,direction,my_tadig,country_name,max(year_tadig) as recent_year_tadig,max(month_tadig) as recent_month_tadig from iot_master   ");
              sql.append("                              group by group_tadig,direction,my_tadig,country_name   ");
              sql.append("                              order by group_tadig  ");
              sql.append("                           )  mas   ");
              sql.append("                     left join (  ");
              sql.append("                                      select direction,group_tadig,MY_TADIG,COUNTRY_NAME,OPERATOR_NAME,YEAR_TADIG,  ");
              sql.append("                                             MONTH_TADIG,agreement_id,plmn_group_id,operator_id,sum(CALL_TADIG) as call_tadig,sum(charge_local) as charge_local,sum(net)  as net ,  ");
              sql.append("                                             to_number(TO_CHAR(LAST_DAY(to_date(YEAR_TADIG||MONTH_TADIG,'yyyymm')), 'DD')) as days_of_month  ");
              sql.append("                                      from iot_master     ");
              sql.append("                                      where  AGREEMENT_ID is not null  ");
              sql.append("                                      group by direction,group_tadig,MY_TADIG,COUNTRY_NAME,OPERATOR_NAME,agreement_id,plmn_group_id,YEAR_TADIG,MONTH_TADIG,operator_id  ");
              sql.append("                                      order by direction,group_tadig,my_tadig,YEAR_TADIG,MONTH_TADIG asc   ");

              sql.append("                               ) mas2 on mas2.GROUP_TADIG = mas.GROUP_TADIG and mas2.direction = mas.direction  ");
              sql.append("                                          and mas2.my_tadig = mas.my_tadig   and mas2.country_name = mas.country_name  ");
              sql.append("                                          and mas2.year_tadig = mas.recent_year_tadig and mas2.month_tadig = mas.recent_month_tadig  ");
              sql.append("                      where mas2.DIRECTION='"+direction+"' and mas2.AGREEMENT_ID is not null and mas2.operator_id=1  ");

              sql.append("                      UNION  ");

              sql.append("                      select mas.group_tadig ,mas2.direction,mas2.MY_TADIG,  ");
              sql.append("                            mas2.COUNTRY_NAME,mas2.OPERATOR_NAME,mas2.YEAR_TADIG,mas2.MONTH_TADIG,  ");
              sql.append("                            mas2.agreement_id,mas2.plmn_group_id,mas2.call_tadig,mas2.charge_local,mas2.net  ");
              sql.append("                      from (  select group_tadig,direction,my_tadig,country_name,max(year_tadig) as recent_year_tadig,max(month_tadig) as recent_month_tadig from iot_master   ");
              sql.append("                              group by group_tadig,direction,my_tadig,country_name   ");
              sql.append("                              order by group_tadig  ");
              sql.append("                           )  mas   ");
              sql.append("                      left join (  ");
              sql.append("                                      select direction,group_tadig,MY_TADIG,COUNTRY_NAME,OPERATOR_NAME,YEAR_TADIG,  ");
              sql.append("                                             MONTH_TADIG,agreement_id,plmn_group_id,operator_id,sum(CALL_TADIG) as call_tadig,sum(charge_local) as charge_local,sum(net)  as net   ");
              sql.append("                                      from iot_master     ");
              sql.append("                                      where  AGREEMENT_ID is not null  ");
              sql.append("                                      group by direction,group_tadig,MY_TADIG,COUNTRY_NAME,OPERATOR_NAME,agreement_id,plmn_group_id,YEAR_TADIG,MONTH_TADIG,operator_id  ");
              sql.append("                                      order by direction,group_tadig,my_tadig,YEAR_TADIG,MONTH_TADIG asc   ");

              sql.append("                                ) mas2 on mas2.GROUP_TADIG = mas.GROUP_TADIG and mas2.direction = mas.direction  ");
              sql.append("                                          and mas2.my_tadig = mas.my_tadig   and mas2.country_name = mas.country_name  ");
              sql.append("                                          and ( mas2.year_tadig != mas.recent_year_tadig or mas2.month_tadig != mas.recent_month_tadig)  ");
              sql.append("                      where mas2.DIRECTION='"+direction+"' and mas2.AGREEMENT_ID is not null and mas2.operator_id=1  ");
              sql.append("      )   ");
              sql.append("      group by direction,group_tadig,MY_TADIG,COUNTRY_NAME,OPERATOR_NAME,agreement_id,plmn_group_id  ");
              sql.append("      order by direction,group_tadig asc  ");
            
            
            stmt = getPrmAppConnection().prepareStatement(sql.toString());
            rs = stmt.executeQuery();
            
            List<IotMaster> list = new ArrayList<IotMaster>();
            while (rs.next()){
                IotMaster iotMaster = new IotMaster();
                iotMaster.setDirection(rs.getString("DIRECTION"));
                iotMaster.setGroupTadig(rs.getString("GROUP_TADIG"));
                iotMaster.setOperatorName(rs.getString("OPERATOR_NAME"));
                iotMaster.setMyTadig(rs.getString("MY_TADIG"));
                iotMaster.setCountryName(rs.getString("COUNTRY_NAME"));
                iotMaster.setAgreementId(rs.getString("AGREEMENT_ID"));
                iotMaster.setPlmnGroupId(rs.getString("PLMN_GROUP_ID"));
                iotMaster.setCallTadig(rs.getBigDecimal("SUM(CALL_TADIG)"));
                iotMaster.setChargeLocal(rs.getBigDecimal("SUM(CHARGE_LOCAL)"));
                iotMaster.setNet(rs.getBigDecimal("SUM(NET)"));
                list.add(iotMaster);
            }
            
            
            return list;
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
        String SQL_STATEMENT ="Select * from IOT_MASTER where " + whereConditions;
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
    
//    public List findByDirection( String direction) throws SQLException {
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        String SQL_STATEMENT = "Select * from IOT_MASTER where DIRECTION = ? order by DIRECTION";
//        try {
//            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
//            stmt.setString(1, direction );
//            rs = stmt.executeQuery();
//            return fetchAll(rs);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            stmt.close();
//            rs.close();
//        }
//        return null;
//    }
    public List findByMyTadig( String myTadig) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where MY_TADIG = ? order by MY_TADIG";
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
        String SQL_STATEMENT = "Select * from IOT_MASTER where COUNTRY_NAME = ? order by COUNTRY_NAME";
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
        String SQL_STATEMENT = "Select * from IOT_MASTER where OPERATOR_NAME = ? order by OPERATOR_NAME";
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
    public List findByTheirTadig( String theirTadig) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where THEIR_TADIG = ? order by THEIR_TADIG";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, theirTadig );
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
    public List findByYearTadig( String yearTadig) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where YEAR_TADIG = ? order by YEAR_TADIG";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, yearTadig );
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
    public List findByMonthTadig( String monthTadig) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where MONTH_TADIG = ? order by MONTH_TADIG";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, monthTadig );
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
    public List findByTypeTadig( String typeTadig) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where TYPE_TADIG = ? order by TYPE_TADIG";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, typeTadig );
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
        String SQL_STATEMENT = "Select * from IOT_MASTER where CALL_TADIG = ? order by CALL_TADIG";
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
    public List findByRealDuration( java.math.BigDecimal realDuration) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where REAL_DURATION = ? order by REAL_DURATION";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, realDuration );
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
    public List findByRealGprs( java.math.BigDecimal realGprs) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where REAL_GPRS = ? order by REAL_GPRS";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, realGprs );
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
    public List findByRoundTadig( java.math.BigDecimal roundTadig) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where ROUND_TADIG = ? order by ROUND_TADIG";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, roundTadig );
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
    public List findByChargeLocal( java.math.BigDecimal chargeLocal) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where CHARGE_LOCAL = ? order by CHARGE_LOCAL";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, chargeLocal );
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
    public List findByChargeSdr( java.math.BigDecimal chargeSdr) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where CHARGE_SDR = ? order by CHARGE_SDR";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, chargeSdr );
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
    public List findByCallCountry( String callCountry) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where CALL_COUNTRY = ? order by CALL_COUNTRY";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, callCountry );
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
    public List findByDesType( String desType) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where DES_TYPE = ? order by DES_TYPE";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, desType );
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
    public List findByVolumeReal( java.math.BigDecimal volumeReal) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where VOLUME_REAL = ? order by VOLUME_REAL";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, volumeReal );
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
    public List findByVolumeRound( java.math.BigDecimal volumeRound) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where VOLUME_ROUND = ? order by VOLUME_ROUND";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, volumeRound );
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
        String SQL_STATEMENT = "Select * from IOT_MASTER where GROUP_TADIG = ? order by GROUP_TADIG";
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
    public List findByCurrencyIot( String currencyIot) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where CURRENCY_IOT = ? order by CURRENCY_IOT";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, currencyIot );
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
    public List findByVolumn( String volumn) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where VOLUMN = ? order by VOLUMN";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, volumn );
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
    public List findByRateType( String rateType) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where RATE_TYPE = ? order by RATE_TYPE";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, rateType );
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
    public List findByRateIotCurrency( java.math.BigDecimal rateIotCurrency) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where RATE_IOT_CURRENCY = ? order by RATE_IOT_CURRENCY";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, rateIotCurrency );
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
    public List findByIotSdr( java.math.BigDecimal iotSdr) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where IOT_SDR = ? order by IOT_SDR";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, iotSdr );
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
    public List findByRateIotThai( java.math.BigDecimal rateIotThai) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where RATE_IOT_THAI = ? order by RATE_IOT_THAI";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, rateIotThai );
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
    public List findByNet( java.math.BigDecimal net) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where NET = ? order by NET";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, net );
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
    public List findByDiscount( java.math.BigDecimal discount) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where DISCOUNT = ? order by DISCOUNT";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, discount );
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
    public List findByTapRate( java.math.BigDecimal tapRate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where TAP_RATE = ? order by TAP_RATE";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, tapRate );
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
    public List findByTapIm( String tapIm) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where TAP_IM = ? order by TAP_IM";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setString(1, tapIm );
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
    public List findByRealNet( java.math.BigDecimal realNet) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where REAL_NET = ? order by REAL_NET";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, realNet );
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
    public List findByThbSdr( java.math.BigDecimal thbSdr) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where THB_SDR = ? order by THB_SDR";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, thbSdr );
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
    public List findByRevSdr( java.math.BigDecimal revSdr) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where REV_SDR = ? order by REV_SDR";
        try {
            stmt = getPrmAppConnection().prepareStatement(SQL_STATEMENT);
            stmt.setBigDecimal(1, revSdr );
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
        String SQL_STATEMENT = "Select * from IOT_MASTER where DN = ? order by DN";
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
        String SQL_STATEMENT = "Select * from IOT_MASTER where CN = ? order by CN";
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
    public List findByCommitment( java.math.BigDecimal commitment) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where COMMITMENT = ? order by COMMITMENT";
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
    public List findBySysCreationDate( java.sql.Date sysCreationDate) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where SYS_CREATION_DATE = ? order by SYS_CREATION_DATE";
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
        String SQL_STATEMENT = "Select * from IOT_MASTER where SYS_UPDATE_DATE = ? order by SYS_UPDATE_DATE";
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
        String SQL_STATEMENT = "Select * from IOT_MASTER where OPERATOR_ID = ? order by OPERATOR_ID";
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
        String SQL_STATEMENT = "Select * from IOT_MASTER where APPLICATION_ID = ? order by APPLICATION_ID";
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
        String SQL_STATEMENT = "Select * from IOT_MASTER where DL_SERVICE_CODE = ? order by DL_SERVICE_CODE";
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
        String SQL_STATEMENT = "Select * from IOT_MASTER where DL_UPDATE_STAMP = ? order by DL_UPDATE_STAMP";
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
    public List findByAgreementId( String agreementId) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT = "Select * from IOT_MASTER where AGREEMENT_ID = ? order by AGREEMENT_ID";
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
        String SQL_STATEMENT = "Select * from IOT_MASTER where PLMN_GROUP_ID = ? order by PLMN_GROUP_ID";
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

/*    

    public List findByCriteriaOR( IotMaster criteria) throws SQLException {
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
            bf.append(orString + " (THEIR_TADIG = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (YEAR_TADIG = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (MONTH_TADIG = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (TYPE_TADIG = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (CALL_TADIG = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (REAL_DURATION = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (REAL_GPRS = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (ROUND_TADIG = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (CHARGE_LOCAL = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (CHARGE_SDR = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (CALL_COUNTRY = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (DES_TYPE = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (VOLUME_REAL = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (VOLUME_ROUND = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (GROUP_TADIG = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (CURRENCY_IOT = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (VOLUMN = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (RATE_TYPE = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (RATE_IOT_CURRENCY = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (IOT_SDR = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (RATE_IOT_THAI = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (NET = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (DISCOUNT = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (TAP_RATE = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (TAP_IM = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (REAL_NET = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (THB_SDR = ?) ");
            orString = "OR";
        }
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (REV_SDR = ?) ");
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
        if (criteria.getBigDecimal() != null) { 
            bf.append(orString + " (COMMITMENT = ?) ");
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
            bf.append(orString + " (AGREEMENT_ID = ?) ");
            orString = "OR";
        }
        if (criteria.getString() != null) { 
            bf.append(orString + " (PLMN_GROUP_ID = ?) ");
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
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getString() != null) 
                stmt.setString(index++, criteria.getString() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
            if (criteria.getBigDecimal() != null) 
                stmt.setString(index++, criteria.getBigDecimal() );
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

    public List<IotMaster> fetchAll(ResultSet rs) throws SQLException{
        List<IotMaster> list = new ArrayList<IotMaster>();
        while (rs.next()){
            IotMaster iotMaster = new IotMaster();
            iotMaster.setDirection(rs.getString("DIRECTION"));
            iotMaster.setMyTadig(rs.getString("MY_TADIG"));
            iotMaster.setCountryName(rs.getString("COUNTRY_NAME"));
            iotMaster.setOperatorName(rs.getString("OPERATOR_NAME"));
            iotMaster.setTheirTadig(rs.getString("THEIR_TADIG"));
            iotMaster.setYearTadig(rs.getString("YEAR_TADIG"));
            iotMaster.setMonthTadig(rs.getString("MONTH_TADIG"));
            iotMaster.setTypeTadig(rs.getString("TYPE_TADIG"));
            iotMaster.setCallTadig(rs.getBigDecimal("CALL_TADIG"));
            iotMaster.setRealDuration(rs.getBigDecimal("REAL_DURATION"));
            iotMaster.setRealGprs(rs.getBigDecimal("REAL_GPRS"));
            iotMaster.setRoundTadig(rs.getBigDecimal("ROUND_TADIG"));
            iotMaster.setChargeLocal(rs.getBigDecimal("CHARGE_LOCAL"));
            iotMaster.setChargeSdr(rs.getBigDecimal("CHARGE_SDR"));
            iotMaster.setCallCountry(rs.getString("CALL_COUNTRY"));
            iotMaster.setDesType(rs.getString("DES_TYPE"));
            iotMaster.setVolumeReal(rs.getBigDecimal("VOLUME_REAL"));
            iotMaster.setVolumeRound(rs.getBigDecimal("VOLUME_ROUND"));
            iotMaster.setGroupTadig(rs.getString("GROUP_TADIG"));
            iotMaster.setCurrencyIot(rs.getString("CURRENCY_IOT"));
            iotMaster.setVolumn(rs.getString("VOLUMN"));
            iotMaster.setRateType(rs.getString("RATE_TYPE"));
            iotMaster.setRateIotCurrency(rs.getBigDecimal("RATE_IOT_CURRENCY"));
            iotMaster.setIotSdr(rs.getBigDecimal("IOT_SDR"));
            iotMaster.setRateIotThai(rs.getBigDecimal("RATE_IOT_THAI"));
            iotMaster.setNet(rs.getBigDecimal("NET"));
            iotMaster.setDiscount(rs.getBigDecimal("DISCOUNT"));
            iotMaster.setTapRate(rs.getBigDecimal("TAP_RATE"));
            iotMaster.setTapIm(rs.getString("TAP_IM"));
            iotMaster.setRealNet(rs.getBigDecimal("REAL_NET"));
            iotMaster.setThbSdr(rs.getBigDecimal("THB_SDR"));
            iotMaster.setRevSdr(rs.getBigDecimal("REV_SDR"));
            iotMaster.setDn(rs.getBigDecimal("DN"));
            iotMaster.setCn(rs.getBigDecimal("CN"));
            iotMaster.setCommitment(rs.getBigDecimal("COMMITMENT"));
            iotMaster.setSysCreationDate(rs.getDate("SYS_CREATION_DATE"));
            iotMaster.setSysUpdateDate(rs.getDate("SYS_UPDATE_DATE"));
            iotMaster.setOperatorId(rs.getBigDecimal("OPERATOR_ID"));
            iotMaster.setApplicationId(rs.getString("APPLICATION_ID"));
            iotMaster.setDlServiceCode(rs.getString("DL_SERVICE_CODE"));
            iotMaster.setDlUpdateStamp(rs.getBigDecimal("DL_UPDATE_STAMP"));
            iotMaster.setAgreementId(rs.getString("AGREEMENT_ID"));
            iotMaster.setPlmnGroupId(rs.getString("PLMN_GROUP_ID"));
            list.add(iotMaster);
        }
        return list;
    }

    public IotMaster fetch(ResultSet rs) throws SQLException{
        if (rs.next()){
            IotMaster iotMaster = new IotMaster();
            iotMaster.setDirection( rs.getString("DIRECTION"));
            iotMaster.setMyTadig( rs.getString("MY_TADIG"));
            iotMaster.setCountryName( rs.getString("COUNTRY_NAME"));
            iotMaster.setOperatorName( rs.getString("OPERATOR_NAME"));
            iotMaster.setTheirTadig( rs.getString("THEIR_TADIG"));
            iotMaster.setYearTadig( rs.getString("YEAR_TADIG"));
            iotMaster.setMonthTadig( rs.getString("MONTH_TADIG"));
            iotMaster.setTypeTadig( rs.getString("TYPE_TADIG"));
            iotMaster.setCallTadig( rs.getBigDecimal("CALL_TADIG"));
            iotMaster.setRealDuration( rs.getBigDecimal("REAL_DURATION"));
            iotMaster.setRealGprs( rs.getBigDecimal("REAL_GPRS"));
            iotMaster.setRoundTadig( rs.getBigDecimal("ROUND_TADIG"));
            iotMaster.setChargeLocal( rs.getBigDecimal("CHARGE_LOCAL"));
            iotMaster.setChargeSdr( rs.getBigDecimal("CHARGE_SDR"));
            iotMaster.setCallCountry( rs.getString("CALL_COUNTRY"));
            iotMaster.setDesType( rs.getString("DES_TYPE"));
            iotMaster.setVolumeReal( rs.getBigDecimal("VOLUME_REAL"));
            iotMaster.setVolumeRound( rs.getBigDecimal("VOLUME_ROUND"));
            iotMaster.setGroupTadig( rs.getString("GROUP_TADIG"));
            iotMaster.setCurrencyIot( rs.getString("CURRENCY_IOT"));
            iotMaster.setVolumn( rs.getString("VOLUMN"));
            iotMaster.setRateType( rs.getString("RATE_TYPE"));
            iotMaster.setRateIotCurrency( rs.getBigDecimal("RATE_IOT_CURRENCY"));
            iotMaster.setIotSdr( rs.getBigDecimal("IOT_SDR"));
            iotMaster.setRateIotThai( rs.getBigDecimal("RATE_IOT_THAI"));
            iotMaster.setNet( rs.getBigDecimal("NET"));
            iotMaster.setDiscount( rs.getBigDecimal("DISCOUNT"));
            iotMaster.setTapRate( rs.getBigDecimal("TAP_RATE"));
            iotMaster.setTapIm( rs.getString("TAP_IM"));
            iotMaster.setRealNet( rs.getBigDecimal("REAL_NET"));
            iotMaster.setThbSdr( rs.getBigDecimal("THB_SDR"));
            iotMaster.setRevSdr( rs.getBigDecimal("REV_SDR"));
            iotMaster.setDn( rs.getBigDecimal("DN"));
            iotMaster.setCn( rs.getBigDecimal("CN"));
            iotMaster.setCommitment( rs.getBigDecimal("COMMITMENT"));
            iotMaster.setSysCreationDate( rs.getDate("SYS_CREATION_DATE"));
            iotMaster.setSysUpdateDate( rs.getDate("SYS_UPDATE_DATE"));
            iotMaster.setOperatorId( rs.getBigDecimal("OPERATOR_ID"));
            iotMaster.setApplicationId( rs.getString("APPLICATION_ID"));
            iotMaster.setDlServiceCode( rs.getString("DL_SERVICE_CODE"));
            iotMaster.setDlUpdateStamp( rs.getBigDecimal("DL_UPDATE_STAMP"));
            iotMaster.setAgreementId( rs.getString("AGREEMENT_ID"));
            iotMaster.setPlmnGroupId( rs.getString("PLMN_GROUP_ID"));
            return iotMaster;
        }
        return null;
    }

    public void populateParent(IotMaster iotMaster) throws SQLException {
    }

    public void populateChild(IotMaster iotMaster) throws SQLException {
    }

    public void populateAll(IotMaster iotMaster) throws SQLException {
        populateParent(iotMaster);
        populateChild(iotMaster);
    }

}
