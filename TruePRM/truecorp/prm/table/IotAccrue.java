
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IotAccrue implements Serializable {
    
    /** Creates a new instance of IotAccrue */
    public IotAccrue() {
    }
    public IotAccrue(
            String direction	
            , String groupTadig	
            , String myTadig	
            , String countryName	
            , String operatorName	
            , String agreementId	
            , String plmnGroupId	
            , java.math.BigDecimal callTadig	
            , java.math.BigDecimal sharingRate	
            , java.math.BigDecimal chargeTap	
            , java.math.BigDecimal chargeIot	
            , java.math.BigDecimal commitment	
            , java.math.BigDecimal dn	
            , java.math.BigDecimal cn	
            , String reportMonth	
            , String paramDate	
            , java.sql.Date sysCreationDate	
            , java.sql.Date sysUpdateDate	
            , java.math.BigDecimal operatorId	
            , String applicationId	
            , String dlServiceCode	
            , java.math.BigDecimal dlUpdateStamp	
        ) {
        this.direction = direction;	
        this.groupTadig = groupTadig;	
        this.myTadig = myTadig;	
        this.countryName = countryName;	
        this.operatorName = operatorName;	
        this.agreementId = agreementId;	
        this.plmnGroupId = plmnGroupId;	
        this.callTadig = callTadig;	
        this.sharingRate = sharingRate;	
        this.chargeTap = chargeTap;	
        this.chargeIot = chargeIot;	
        this.commitment = commitment;	
        this.dn = dn;	
        this.cn = cn;	
        this.reportMonth = reportMonth;	
        this.paramDate = paramDate;	
        this.sysCreationDate = sysCreationDate;	
        this.sysUpdateDate = sysUpdateDate;	
        this.operatorId = operatorId;	
        this.applicationId = applicationId;	
        this.dlServiceCode = dlServiceCode;	
        this.dlUpdateStamp = dlUpdateStamp;	
    }
    private String direction;	
    private String groupTadig;	
    private String myTadig;	
    private String countryName;	
    private String operatorName;	
    private String agreementId;	
    private String plmnGroupId;	
    private java.math.BigDecimal callTadig;	
    private java.math.BigDecimal sharingRate;	
    private java.math.BigDecimal chargeTap;	
    private java.math.BigDecimal chargeIot;	
    private java.math.BigDecimal commitment;	
    private java.math.BigDecimal dn;	
    private java.math.BigDecimal cn;	
    private String reportMonth;	
    private String paramDate;	
    private java.sql.Date sysCreationDate;	
    private java.sql.Date sysUpdateDate;	
    private java.math.BigDecimal operatorId;	
    private String applicationId;	
    private String dlServiceCode;	
    private java.math.BigDecimal dlUpdateStamp;	



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
    public String getCountryName() {
        return this.countryName;
    }		
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getOperatorName() {
        return this.operatorName;
    }		
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
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
    public java.math.BigDecimal getCallTadig() {
        return this.callTadig;
    }		
    public void setCallTadig(java.math.BigDecimal callTadig) {
        this.callTadig = callTadig;
    }
    public java.math.BigDecimal getSharingRate() {
        return this.sharingRate;
    }		
    public void setSharingRate(java.math.BigDecimal sharingRate) {
        this.sharingRate = sharingRate;
    }
    public java.math.BigDecimal getChargeTap() {
        return this.chargeTap;
    }		
    public void setChargeTap(java.math.BigDecimal chargeTap) {
        this.chargeTap = chargeTap;
    }
    public java.math.BigDecimal getChargeIot() {
        return this.chargeIot;
    }		
    public void setChargeIot(java.math.BigDecimal chargeIot) {
        this.chargeIot = chargeIot;
    }
    public java.math.BigDecimal getCommitment() {
        return this.commitment;
    }		
    public void setCommitment(java.math.BigDecimal commitment) {
        this.commitment = commitment;
    }
    public java.math.BigDecimal getDn() {
        return this.dn;
    }		
    public void setDn(java.math.BigDecimal dn) {
        this.dn = dn;
    }
    public java.math.BigDecimal getCn() {
        return this.cn;
    }		
    public void setCn(java.math.BigDecimal cn) {
        this.cn = cn;
    }
    public String getReportMonth() {
        return this.reportMonth;
    }		
    public void setReportMonth(String reportMonth) {
        this.reportMonth = reportMonth;
    }
    public String getParamDate() {
        return this.paramDate;
    }		
    public void setParamDate(String paramDate) {
        this.paramDate = paramDate;
    }
    public java.sql.Date getSysCreationDate() {
        return this.sysCreationDate;
    }		
    public void setSysCreationDate(java.sql.Date sysCreationDate) {
        this.sysCreationDate = sysCreationDate;
    }
    public java.sql.Date getSysUpdateDate() {
        return this.sysUpdateDate;
    }		
    public void setSysUpdateDate(java.sql.Date sysUpdateDate) {
        this.sysUpdateDate = sysUpdateDate;
    }
    public java.math.BigDecimal getOperatorId() {
        return this.operatorId;
    }		
    public void setOperatorId(java.math.BigDecimal operatorId) {
        this.operatorId = operatorId;
    }
    public String getApplicationId() {
        return this.applicationId;
    }		
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
    public String getDlServiceCode() {
        return this.dlServiceCode;
    }		
    public void setDlServiceCode(String dlServiceCode) {
        this.dlServiceCode = dlServiceCode;
    }
    public java.math.BigDecimal getDlUpdateStamp() {
        return this.dlUpdateStamp;
    }		
    public void setDlUpdateStamp(java.math.BigDecimal dlUpdateStamp) {
        this.dlUpdateStamp = dlUpdateStamp;
    }



    public String toString() {
        return super.toString() + "direction=[" + direction + "]\n" + "groupTadig=[" + groupTadig + "]\n" + "myTadig=[" + myTadig + "]\n" + "countryName=[" + countryName + "]\n" + "operatorName=[" + operatorName + "]\n" + "agreementId=[" + agreementId + "]\n" + "plmnGroupId=[" + plmnGroupId + "]\n" + "callTadig=[" + callTadig + "]\n" + "sharingRate=[" + sharingRate + "]\n" + "chargeTap=[" + chargeTap + "]\n" + "chargeIot=[" + chargeIot + "]\n" + "commitment=[" + commitment + "]\n" + "dn=[" + dn + "]\n" + "cn=[" + cn + "]\n" + "reportMonth=[" + reportMonth + "]\n" + "paramDate=[" + paramDate + "]\n" + "sysCreationDate=[" + sysCreationDate + "]\n" + "sysUpdateDate=[" + sysUpdateDate + "]\n" + "operatorId=[" + operatorId + "]\n" + "applicationId=[" + applicationId + "]\n" + "dlServiceCode=[" + dlServiceCode + "]\n" + "dlUpdateStamp=[" + dlUpdateStamp + "]\n";
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
        if (!(that.getCountryName() == null ? this.getCountryName() == null
                        : that.getCountryName().equals(this.getCountryName()))) {
                return false;
        }
        if (!(that.getOperatorName() == null ? this.getOperatorName() == null
                        : that.getOperatorName().equals(this.getOperatorName()))) {
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
        if (!(that.getCallTadig() == null ? this.getCallTadig() == null
                        : 0 == that.getCallTadig().compareTo(this.getCallTadig()))) {
                return false;
        }
        if (!(that.getSharingRate() == null ? this.getSharingRate() == null
                        : 0 == that.getSharingRate().compareTo(this.getSharingRate()))) {
                return false;
        }
        if (!(that.getChargeTap() == null ? this.getChargeTap() == null
                        : 0 == that.getChargeTap().compareTo(this.getChargeTap()))) {
                return false;
        }
        if (!(that.getChargeIot() == null ? this.getChargeIot() == null
                        : 0 == that.getChargeIot().compareTo(this.getChargeIot()))) {
                return false;
        }
        if (!(that.getCommitment() == null ? this.getCommitment() == null
                        : 0 == that.getCommitment().compareTo(this.getCommitment()))) {
                return false;
        }
        if (!(that.getDn() == null ? this.getDn() == null
                        : 0 == that.getDn().compareTo(this.getDn()))) {
                return false;
        }
        if (!(that.getCn() == null ? this.getCn() == null
                        : 0 == that.getCn().compareTo(this.getCn()))) {
                return false;
        }
        if (!(that.getReportMonth() == null ? this.getReportMonth() == null
                        : that.getReportMonth().equals(this.getReportMonth()))) {
                return false;
        }
        if (!(that.getParamDate() == null ? this.getParamDate() == null
                        : that.getParamDate().equals(this.getParamDate()))) {
                return false;
        }
        if (!(that.getSysCreationDate() == null ? this.getSysCreationDate() == null
                        : that.getSysCreationDate().equals(this.getSysCreationDate()))) {
                return false;
        }
        if (!(that.getSysUpdateDate() == null ? this.getSysUpdateDate() == null
                        : that.getSysUpdateDate().equals(this.getSysUpdateDate()))) {
                return false;
        }
        if (!(that.getOperatorId() == null ? this.getOperatorId() == null
                        : 0 == that.getOperatorId().compareTo(this.getOperatorId()))) {
                return false;
        }
        if (!(that.getApplicationId() == null ? this.getApplicationId() == null
                        : that.getApplicationId().equals(this.getApplicationId()))) {
                return false;
        }
        if (!(that.getDlServiceCode() == null ? this.getDlServiceCode() == null
                        : that.getDlServiceCode().equals(this.getDlServiceCode()))) {
                return false;
        }
        if (!(that.getDlUpdateStamp() == null ? this.getDlUpdateStamp() == null
                        : 0 == that.getDlUpdateStamp().compareTo(this.getDlUpdateStamp()))) {
                return false;
        }
    return true;
    }

}
