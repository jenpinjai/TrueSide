/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.service;

import java.sql.Connection;
import java.util.Date;
import truecorp.prm.dao.ContentCycleControlDAO;
import truecorp.prm.model.ContentCycleControl;

/**
 *
 * @author Jennarong Pinjai
 */
public class ContentCycleControlService {
    
    private ContentCycleControlDAO  dao = new ContentCycleControlDAO();
    
    public String getContentPartnerRevenueTableName(Connection con,Date date) throws Exception{
    
        return dao.getContentPartnerRevenueTableName(con, date);
                
    }
    
    public ContentCycleControl getContentCycleControl(Connection con,Date date) throws Exception{
    
        return dao.getContentCycleControl(con, date);
    
    }
    
    
}
