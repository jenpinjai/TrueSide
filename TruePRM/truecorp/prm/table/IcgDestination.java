
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcgDestination implements Serializable {
    
    /** Creates a new instance of IcgDestination */
    public IcgDestination() {
    }
    public IcgDestination(
            String destinationCd	
            , java.sql.Date effectiveDate	
            , java.sql.Date sysCreationDate	
            , java.sql.Date sysUpdateDate	
            , java.math.BigDecimal operatorId	
            , String applicationId	
            , String dlServiceCode	
            , java.math.BigDecimal dlUpdateStamp	
            , java.math.BigDecimal billingNameSeq	
            , String jurisdiction	
            , String guiDspInd	
            , java.sql.Date expirationDate	
        ) {
        this.destinationCd = destinationCd;	
        this.effectiveDate = effectiveDate;	
        this.sysCreationDate = sysCreationDate;	
        this.sysUpdateDate = sysUpdateDate;	
        this.operatorId = operatorId;	
        this.applicationId = applicationId;	
        this.dlServiceCode = dlServiceCode;	
        this.dlUpdateStamp = dlUpdateStamp;	
        this.billingNameSeq = billingNameSeq;	
        this.jurisdiction = jurisdiction;	
        this.guiDspInd = guiDspInd;	
        this.expirationDate = expirationDate;	
    }
    private String destinationCd;	
    private java.sql.Date effectiveDate;	
    private java.sql.Date sysCreationDate;	
    private java.sql.Date sysUpdateDate;	
    private java.math.BigDecimal operatorId;	
    private String applicationId;	
    private String dlServiceCode;	
    private java.math.BigDecimal dlUpdateStamp;	
    private java.math.BigDecimal billingNameSeq;	
    private String jurisdiction;	
    private String guiDspInd;	
    private java.sql.Date expirationDate;	



    public String getDestinationCd() {
        return this.destinationCd;
    }		
    public void setDestinationCd(String destinationCd) {
        this.destinationCd = destinationCd;
    }
    public java.sql.Date getEffectiveDate() {
        return this.effectiveDate;
    }		
    public void setEffectiveDate(java.sql.Date effectiveDate) {
        this.effectiveDate = effectiveDate;
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
    public java.math.BigDecimal getBillingNameSeq() {
        return this.billingNameSeq;
    }		
    public void setBillingNameSeq(java.math.BigDecimal billingNameSeq) {
        this.billingNameSeq = billingNameSeq;
    }
    public String getJurisdiction() {
        return this.jurisdiction;
    }		
    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
    public String getGuiDspInd() {
        return this.guiDspInd;
    }		
    public void setGuiDspInd(String guiDspInd) {
        this.guiDspInd = guiDspInd;
    }
    public java.sql.Date getExpirationDate() {
        return this.expirationDate;
    }		
    public void setExpirationDate(java.sql.Date expirationDate) {
        this.expirationDate = expirationDate;
    }



    public String toString() {
        return super.toString() + "destinationCd=[" + destinationCd + "]\n" + "effectiveDate=[" + effectiveDate + "]\n" + "sysCreationDate=[" + sysCreationDate + "]\n" + "sysUpdateDate=[" + sysUpdateDate + "]\n" + "operatorId=[" + operatorId + "]\n" + "applicationId=[" + applicationId + "]\n" + "dlServiceCode=[" + dlServiceCode + "]\n" + "dlUpdateStamp=[" + dlUpdateStamp + "]\n" + "billingNameSeq=[" + billingNameSeq + "]\n" + "jurisdiction=[" + jurisdiction + "]\n" + "guiDspInd=[" + guiDspInd + "]\n" + "expirationDate=[" + expirationDate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IcgDestination)) {
                return false;
        }
        IcgDestination that = (IcgDestination) obj;
        if (!(that.getDestinationCd() == null ? this.getDestinationCd() == null
                        : that.getDestinationCd().equals(this.getDestinationCd()))) {
                return false;
        }
        if (!(that.getEffectiveDate() == null ? this.getEffectiveDate() == null
                        : that.getEffectiveDate().equals(this.getEffectiveDate()))) {
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
        if (!(that.getBillingNameSeq() == null ? this.getBillingNameSeq() == null
                        : 0 == that.getBillingNameSeq().compareTo(this.getBillingNameSeq()))) {
                return false;
        }
        if (!(that.getJurisdiction() == null ? this.getJurisdiction() == null
                        : that.getJurisdiction().equals(this.getJurisdiction()))) {
                return false;
        }
        if (!(that.getGuiDspInd() == null ? this.getGuiDspInd() == null
                        : that.getGuiDspInd().equals(this.getGuiDspInd()))) {
                return false;
        }
        if (!(that.getExpirationDate() == null ? this.getExpirationDate() == null
                        : that.getExpirationDate().equals(this.getExpirationDate()))) {
                return false;
        }
    return true;
    }

}
