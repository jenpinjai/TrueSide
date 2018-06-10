
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IotAgreement implements Serializable {
    
    /** Creates a new instance of IotAgreement */
    public IotAgreement() {
    }
    public IotAgreement(
            String agreementId	
            , String plmnGroupId	
            , String renewInd	
            , java.math.BigDecimal statusId	
            , String ibCurrencyCd	
            , String obCurrencyCd	
            , java.sql.Date effectiveDate	
            , java.sql.Date expireDate	
            , String userName	
            , String agreementNote	
            , java.sql.Date sysCreationDate	
            , java.sql.Date sysUpdateDate	
            , java.math.BigDecimal operatorId	
            , String applicationId	
            , String dlServiceCode	
            , java.math.BigDecimal dlUpdateStamp	
            , java.math.BigDecimal ibCommitmentAmt	
            , java.math.BigDecimal obCommitmentAmt	
        ) {
        this.agreementId = agreementId;	
        this.plmnGroupId = plmnGroupId;	
        this.renewInd = renewInd;	
        this.statusId = statusId;	
        this.ibCurrencyCd = ibCurrencyCd;	
        this.obCurrencyCd = obCurrencyCd;	
        this.effectiveDate = effectiveDate;	
        this.expireDate = expireDate;	
        this.userName = userName;	
        this.agreementNote = agreementNote;	
        this.sysCreationDate = sysCreationDate;	
        this.sysUpdateDate = sysUpdateDate;	
        this.operatorId = operatorId;	
        this.applicationId = applicationId;	
        this.dlServiceCode = dlServiceCode;	
        this.dlUpdateStamp = dlUpdateStamp;	
        this.ibCommitmentAmt = ibCommitmentAmt;	
        this.obCommitmentAmt = obCommitmentAmt;	
    }
    private String agreementId;	
    private String plmnGroupId;	
    private String renewInd;	
    private java.math.BigDecimal statusId;	
    private String ibCurrencyCd;	
    private String obCurrencyCd;	
    private java.sql.Date effectiveDate;	
    private java.sql.Date expireDate;	
    private String userName;	
    private String agreementNote;	
    private java.sql.Date sysCreationDate;	
    private java.sql.Date sysUpdateDate;	
    private java.math.BigDecimal operatorId;	
    private String applicationId;	
    private String dlServiceCode;	
    private java.math.BigDecimal dlUpdateStamp;	
    private java.math.BigDecimal ibCommitmentAmt;	
    private java.math.BigDecimal obCommitmentAmt;	



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
    public String getRenewInd() {
        return this.renewInd;
    }		
    public void setRenewInd(String renewInd) {
        this.renewInd = renewInd;
    }
    public java.math.BigDecimal getStatusId() {
        return this.statusId;
    }		
    public void setStatusId(java.math.BigDecimal statusId) {
        this.statusId = statusId;
    }
    public String getIbCurrencyCd() {
        return this.ibCurrencyCd;
    }		
    public void setIbCurrencyCd(String ibCurrencyCd) {
        this.ibCurrencyCd = ibCurrencyCd;
    }
    public String getObCurrencyCd() {
        return this.obCurrencyCd;
    }		
    public void setObCurrencyCd(String obCurrencyCd) {
        this.obCurrencyCd = obCurrencyCd;
    }
    public java.sql.Date getEffectiveDate() {
        return this.effectiveDate;
    }		
    public void setEffectiveDate(java.sql.Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
    public java.sql.Date getExpireDate() {
        return this.expireDate;
    }		
    public void setExpireDate(java.sql.Date expireDate) {
        this.expireDate = expireDate;
    }
    public String getUserName() {
        return this.userName;
    }		
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getAgreementNote() {
        return this.agreementNote;
    }		
    public void setAgreementNote(String agreementNote) {
        this.agreementNote = agreementNote;
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
    public java.math.BigDecimal getIbCommitmentAmt() {
        return this.ibCommitmentAmt;
    }		
    public void setIbCommitmentAmt(java.math.BigDecimal ibCommitmentAmt) {
        this.ibCommitmentAmt = ibCommitmentAmt;
    }
    public java.math.BigDecimal getObCommitmentAmt() {
        return this.obCommitmentAmt;
    }		
    public void setObCommitmentAmt(java.math.BigDecimal obCommitmentAmt) {
        this.obCommitmentAmt = obCommitmentAmt;
    }



    public String toString() {
        return super.toString() + "agreementId=[" + agreementId + "]\n" + "plmnGroupId=[" + plmnGroupId + "]\n" + "renewInd=[" + renewInd + "]\n" + "statusId=[" + statusId + "]\n" + "ibCurrencyCd=[" + ibCurrencyCd + "]\n" + "obCurrencyCd=[" + obCurrencyCd + "]\n" + "effectiveDate=[" + effectiveDate + "]\n" + "expireDate=[" + expireDate + "]\n" + "userName=[" + userName + "]\n" + "agreementNote=[" + agreementNote + "]\n" + "sysCreationDate=[" + sysCreationDate + "]\n" + "sysUpdateDate=[" + sysUpdateDate + "]\n" + "operatorId=[" + operatorId + "]\n" + "applicationId=[" + applicationId + "]\n" + "dlServiceCode=[" + dlServiceCode + "]\n" + "dlUpdateStamp=[" + dlUpdateStamp + "]\n" + "ibCommitmentAmt=[" + ibCommitmentAmt + "]\n" + "obCommitmentAmt=[" + obCommitmentAmt + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IotAgreement)) {
                return false;
        }
        IotAgreement that = (IotAgreement) obj;
        if (!(that.getAgreementId() == null ? this.getAgreementId() == null
                        : that.getAgreementId().equals(this.getAgreementId()))) {
                return false;
        }
        if (!(that.getPlmnGroupId() == null ? this.getPlmnGroupId() == null
                        : that.getPlmnGroupId().equals(this.getPlmnGroupId()))) {
                return false;
        }
        if (!(that.getRenewInd() == null ? this.getRenewInd() == null
                        : that.getRenewInd().equals(this.getRenewInd()))) {
                return false;
        }
        if (!(that.getStatusId() == null ? this.getStatusId() == null
                        : 0 == that.getStatusId().compareTo(this.getStatusId()))) {
                return false;
        }
        if (!(that.getIbCurrencyCd() == null ? this.getIbCurrencyCd() == null
                        : that.getIbCurrencyCd().equals(this.getIbCurrencyCd()))) {
                return false;
        }
        if (!(that.getObCurrencyCd() == null ? this.getObCurrencyCd() == null
                        : that.getObCurrencyCd().equals(this.getObCurrencyCd()))) {
                return false;
        }
        if (!(that.getEffectiveDate() == null ? this.getEffectiveDate() == null
                        : that.getEffectiveDate().equals(this.getEffectiveDate()))) {
                return false;
        }
        if (!(that.getExpireDate() == null ? this.getExpireDate() == null
                        : that.getExpireDate().equals(this.getExpireDate()))) {
                return false;
        }
        if (!(that.getUserName() == null ? this.getUserName() == null
                        : that.getUserName().equals(this.getUserName()))) {
                return false;
        }
        if (!(that.getAgreementNote() == null ? this.getAgreementNote() == null
                        : that.getAgreementNote().equals(this.getAgreementNote()))) {
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
        if (!(that.getIbCommitmentAmt() == null ? this.getIbCommitmentAmt() == null
                        : 0 == that.getIbCommitmentAmt().compareTo(this.getIbCommitmentAmt()))) {
                return false;
        }
        if (!(that.getObCommitmentAmt() == null ? this.getObCommitmentAmt() == null
                        : 0 == that.getObCommitmentAmt().compareTo(this.getObCommitmentAmt()))) {
                return false;
        }
    return true;
    }

}
