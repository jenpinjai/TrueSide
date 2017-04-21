
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IotAccruePK  implements Serializable {
    
    /** Creates a new instance of IotAccrue */
    public IotAccruePK(
            String direction	
            , String groupTadig	
            , String myTadig	
            , String agreementId	
            , String plmnGroupId	
            , String reportMonth	
        ) {
        this.direction = direction;	
        this.groupTadig = groupTadig;	
        this.myTadig = myTadig;	
        this.agreementId = agreementId;	
        this.plmnGroupId = plmnGroupId;	
        this.reportMonth = reportMonth;	
    }
    private String direction;	
    private String groupTadig;	
    private String myTadig;	
    private String agreementId;	
    private String plmnGroupId;	
    private String reportMonth;	

    public String getDirection() {
        return this.direction;
    }		
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getGroupTadig() {
        return this.groupTadig;
    }		
    public void setGroupTadig(String groupTadig) {
        this.groupTadig = groupTadig;
    }
    public String getMyTadig() {
        return this.myTadig;
    }		
    public void setMyTadig(String myTadig) {
        this.myTadig = myTadig;
    }
    public String getAgreementId() {
        return this.agreementId;
    }		
    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }
    public String getPlmnGroupId() {
        return this.plmnGroupId;
    }		
    public void setPlmnGroupId(String plmnGroupId) {
        this.plmnGroupId = plmnGroupId;
    }
    public String getReportMonth() {
        return this.reportMonth;
    }		
    public void setReportMonth(String reportMonth) {
        this.reportMonth = reportMonth;
    }

    public String toString() {
        return super.toString() + " " + direction + " " + groupTadig + " " + myTadig + " " + agreementId + " " + plmnGroupId + " " + reportMonth;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IotAccrue)) {
                return false;
        }
        IotAccrue that = (IotAccrue) obj;
        if (!(that.getDirection() == null ? this.getDirection() == null
                        : that.getDirection().equals(this.getDirection()))) {
                return false;
        }
        if (!(that.getGroupTadig() == null ? this.getGroupTadig() == null
                        : that.getGroupTadig().equals(this.getGroupTadig()))) {
                return false;
        }
        if (!(that.getMyTadig() == null ? this.getMyTadig() == null
                        : that.getMyTadig().equals(this.getMyTadig()))) {
                return false;
        }
        if (!(that.getAgreementId() == null ? this.getAgreementId() == null
                        : that.getAgreementId().equals(this.getAgreementId()))) {
                return false;
        }
        if (!(that.getPlmnGroupId() == null ? this.getPlmnGroupId() == null
                        : that.getPlmnGroupId().equals(this.getPlmnGroupId()))) {
                return false;
        }
        if (!(that.getReportMonth() == null ? this.getReportMonth() == null
                        : that.getReportMonth().equals(this.getReportMonth()))) {
                return false;
        }
    return true;
    }

}
