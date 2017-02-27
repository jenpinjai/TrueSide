
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcRateCodeRates implements Serializable {
    
    /** Creates a new instance of IcRateCodeRates */
    public IcRateCodeRates() {
    }
    public IcRateCodeRates(
            String rateClassSetCd	
            , java.math.BigDecimal rateCdSeq	
            , java.sql.Date effectiveDate	
            , java.sql.Date sysCreationDate	
            , java.sql.Date sysUpdateDate	
            , java.math.BigDecimal operatorId	
            , String applicationId	
            , String dlServiceCode	
            , java.math.BigDecimal dlUpdateStamp	
            , java.math.BigDecimal ratingUnit	
            , java.math.BigDecimal rate	
            , String uom	
            , java.sql.Date expirationDate	
        ) {
        this.rateClassSetCd = rateClassSetCd;	
        this.rateCdSeq = rateCdSeq;	
        this.effectiveDate = effectiveDate;	
        this.sysCreationDate = sysCreationDate;	
        this.sysUpdateDate = sysUpdateDate;	
        this.operatorId = operatorId;	
        this.applicationId = applicationId;	
        this.dlServiceCode = dlServiceCode;	
        this.dlUpdateStamp = dlUpdateStamp;	
        this.ratingUnit = ratingUnit;	
        this.rate = rate;	
        this.uom = uom;	
        this.expirationDate = expirationDate;	
    }
    private String rateClassSetCd;	
    private java.math.BigDecimal rateCdSeq;	
    private java.sql.Date effectiveDate;	
    private java.sql.Date sysCreationDate;	
    private java.sql.Date sysUpdateDate;	
    private java.math.BigDecimal operatorId;	
    private String applicationId;	
    private String dlServiceCode;	
    private java.math.BigDecimal dlUpdateStamp;	
    private java.math.BigDecimal ratingUnit;	
    private java.math.BigDecimal rate;	
    private String uom;	
    private java.sql.Date expirationDate;	



    public String getRateClassSetCd() {
        return this.rateClassSetCd;
    }		
    public void setRateClassSetCd(String rateClassSetCd) {
        this.rateClassSetCd = rateClassSetCd;
    }
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
    public java.math.BigDecimal getRatingUnit() {
        return this.ratingUnit;
    }		
    public void setRatingUnit(java.math.BigDecimal ratingUnit) {
        this.ratingUnit = ratingUnit;
    }
    public java.math.BigDecimal getRate() {
        return this.rate;
    }		
    public void setRate(java.math.BigDecimal rate) {
        this.rate = rate;
    }
    public String getUom() {
        return this.uom;
    }		
    public void setUom(String uom) {
        this.uom = uom;
    }
    public java.sql.Date getExpirationDate() {
        return this.expirationDate;
    }		
    public void setExpirationDate(java.sql.Date expirationDate) {
        this.expirationDate = expirationDate;
    }



    public String toString() {
        return super.toString() + "rateClassSetCd=[" + rateClassSetCd + "]\n" + "rateCdSeq=[" + rateCdSeq + "]\n" + "effectiveDate=[" + effectiveDate + "]\n" + "sysCreationDate=[" + sysCreationDate + "]\n" + "sysUpdateDate=[" + sysUpdateDate + "]\n" + "operatorId=[" + operatorId + "]\n" + "applicationId=[" + applicationId + "]\n" + "dlServiceCode=[" + dlServiceCode + "]\n" + "dlUpdateStamp=[" + dlUpdateStamp + "]\n" + "ratingUnit=[" + ratingUnit + "]\n" + "rate=[" + rate + "]\n" + "uom=[" + uom + "]\n" + "expirationDate=[" + expirationDate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IcRateCodeRates)) {
                return false;
        }
        IcRateCodeRates that = (IcRateCodeRates) obj;
        if (!(that.getRateClassSetCd() == null ? this.getRateClassSetCd() == null
                        : that.getRateClassSetCd().equals(this.getRateClassSetCd()))) {
                return false;
        }
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
        if (!(that.getRatingUnit() == null ? this.getRatingUnit() == null
                        : 0 == that.getRatingUnit().compareTo(this.getRatingUnit()))) {
                return false;
        }
        if (!(that.getRate() == null ? this.getRate() == null
                        : 0 == that.getRate().compareTo(this.getRate()))) {
                return false;
        }
        if (!(that.getUom() == null ? this.getUom() == null
                        : that.getUom().equals(this.getUom()))) {
                return false;
        }
        if (!(that.getExpirationDate() == null ? this.getExpirationDate() == null
                        : that.getExpirationDate().equals(this.getExpirationDate()))) {
                return false;
        }
    return true;
    }

}
