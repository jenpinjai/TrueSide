
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcRateCode implements Serializable {
    
    /** Creates a new instance of IcRateCode */
    public IcRateCode() {
    }
    public IcRateCode(
            java.math.BigDecimal rateCdSeq	
            , java.sql.Date effectiveDate	
            , java.sql.Date sysCreationDate	
            , java.sql.Date sysUpdateDate	
            , java.math.BigDecimal operatorId	
            , String applicationId	
            , String dlServiceCode	
            , java.math.BigDecimal dlUpdateStamp	
            , String rateCd	
            , java.math.BigDecimal descriptionSeq	
            , java.sql.Date expirationDate	
        ) {
        this.rateCdSeq = rateCdSeq;	
        this.effectiveDate = effectiveDate;	
        this.sysCreationDate = sysCreationDate;	
        this.sysUpdateDate = sysUpdateDate;	
        this.operatorId = operatorId;	
        this.applicationId = applicationId;	
        this.dlServiceCode = dlServiceCode;	
        this.dlUpdateStamp = dlUpdateStamp;	
        this.rateCd = rateCd;	
        this.descriptionSeq = descriptionSeq;	
        this.expirationDate = expirationDate;	
    }
    private java.math.BigDecimal rateCdSeq;	
    private java.sql.Date effectiveDate;	
    private java.sql.Date sysCreationDate;	
    private java.sql.Date sysUpdateDate;	
    private java.math.BigDecimal operatorId;	
    private String applicationId;	
    private String dlServiceCode;	
    private java.math.BigDecimal dlUpdateStamp;	
    private String rateCd;	
    private java.math.BigDecimal descriptionSeq;	
    private java.sql.Date expirationDate;	



    public java.math.BigDecimal getRateCdSeq() {
        return this.rateCdSeq;
    }		
    public void setRateCdSeq(java.math.BigDecimal rateCdSeq) {
        this.rateCdSeq = rateCdSeq;
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
    public String getRateCd() {
        return this.rateCd;
    }		
    public void setRateCd(String rateCd) {
        this.rateCd = rateCd;
    }
    public java.math.BigDecimal getDescriptionSeq() {
        return this.descriptionSeq;
    }		
    public void setDescriptionSeq(java.math.BigDecimal descriptionSeq) {
        this.descriptionSeq = descriptionSeq;
    }
    public java.sql.Date getExpirationDate() {
        return this.expirationDate;
    }		
    public void setExpirationDate(java.sql.Date expirationDate) {
        this.expirationDate = expirationDate;
    }



    public String toString() {
        return super.toString() + "rateCdSeq=[" + rateCdSeq + "]\n" + "effectiveDate=[" + effectiveDate + "]\n" + "sysCreationDate=[" + sysCreationDate + "]\n" + "sysUpdateDate=[" + sysUpdateDate + "]\n" + "operatorId=[" + operatorId + "]\n" + "applicationId=[" + applicationId + "]\n" + "dlServiceCode=[" + dlServiceCode + "]\n" + "dlUpdateStamp=[" + dlUpdateStamp + "]\n" + "rateCd=[" + rateCd + "]\n" + "descriptionSeq=[" + descriptionSeq + "]\n" + "expirationDate=[" + expirationDate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IcRateCode)) {
                return false;
        }
        IcRateCode that = (IcRateCode) obj;
        if (!(that.getRateCdSeq() == null ? this.getRateCdSeq() == null
                        : 0 == that.getRateCdSeq().compareTo(this.getRateCdSeq()))) {
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
        if (!(that.getRateCd() == null ? this.getRateCd() == null
                        : that.getRateCd().equals(this.getRateCd()))) {
                return false;
        }
        if (!(that.getDescriptionSeq() == null ? this.getDescriptionSeq() == null
                        : 0 == that.getDescriptionSeq().compareTo(this.getDescriptionSeq()))) {
                return false;
        }
        if (!(that.getExpirationDate() == null ? this.getExpirationDate() == null
                        : that.getExpirationDate().equals(this.getExpirationDate()))) {
                return false;
        }
    return true;
    }

}
