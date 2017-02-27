
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcRatesSlabs implements Serializable {
    
    /** Creates a new instance of IcRatesSlabs */
    public IcRatesSlabs() {
    }
    public IcRatesSlabs(
            String ratePlanCd	
            , String destinationCd	
            , java.math.BigDecimal chrgParamId	
            , java.math.BigDecimal slabNum	
            , java.sql.Date effectiveDate	
            , java.sql.Date sysCreationDate	
            , java.sql.Date sysUpdateDate	
            , java.math.BigDecimal operatorId	
            , String applicationId	
            , String dlServiceCode	
            , java.math.BigDecimal dlUpdateStamp	
            , java.math.BigDecimal fromSlab	
            , java.math.BigDecimal toSlab	
            , java.sql.Date expirationDate	
        ) {
        this.ratePlanCd = ratePlanCd;	
        this.destinationCd = destinationCd;	
        this.chrgParamId = chrgParamId;	
        this.slabNum = slabNum;	
        this.effectiveDate = effectiveDate;	
        this.sysCreationDate = sysCreationDate;	
        this.sysUpdateDate = sysUpdateDate;	
        this.operatorId = operatorId;	
        this.applicationId = applicationId;	
        this.dlServiceCode = dlServiceCode;	
        this.dlUpdateStamp = dlUpdateStamp;	
        this.fromSlab = fromSlab;	
        this.toSlab = toSlab;	
        this.expirationDate = expirationDate;	
    }
    private String ratePlanCd;	
    private String destinationCd;	
    private java.math.BigDecimal chrgParamId;	
    private java.math.BigDecimal slabNum;	
    private java.sql.Date effectiveDate;	
    private java.sql.Date sysCreationDate;	
    private java.sql.Date sysUpdateDate;	
    private java.math.BigDecimal operatorId;	
    private String applicationId;	
    private String dlServiceCode;	
    private java.math.BigDecimal dlUpdateStamp;	
    private java.math.BigDecimal fromSlab;	
    private java.math.BigDecimal toSlab;	
    private java.sql.Date expirationDate;	



    public String getRatePlanCd() {
        return this.ratePlanCd;
    }		
    public void setRatePlanCd(String ratePlanCd) {
        this.ratePlanCd = ratePlanCd;
    }
    public String getDestinationCd() {
        return this.destinationCd;
    }		
    public void setDestinationCd(String destinationCd) {
        this.destinationCd = destinationCd;
    }
    public java.math.BigDecimal getChrgParamId() {
        return this.chrgParamId;
    }		
    public void setChrgParamId(java.math.BigDecimal chrgParamId) {
        this.chrgParamId = chrgParamId;
    }
    public java.math.BigDecimal getSlabNum() {
        return this.slabNum;
    }		
    public void setSlabNum(java.math.BigDecimal slabNum) {
        this.slabNum = slabNum;
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
    public java.math.BigDecimal getFromSlab() {
        return this.fromSlab;
    }		
    public void setFromSlab(java.math.BigDecimal fromSlab) {
        this.fromSlab = fromSlab;
    }
    public java.math.BigDecimal getToSlab() {
        return this.toSlab;
    }		
    public void setToSlab(java.math.BigDecimal toSlab) {
        this.toSlab = toSlab;
    }
    public java.sql.Date getExpirationDate() {
        return this.expirationDate;
    }		
    public void setExpirationDate(java.sql.Date expirationDate) {
        this.expirationDate = expirationDate;
    }



    public String toString() {
        return super.toString() + "ratePlanCd=[" + ratePlanCd + "]\n" + "destinationCd=[" + destinationCd + "]\n" + "chrgParamId=[" + chrgParamId + "]\n" + "slabNum=[" + slabNum + "]\n" + "effectiveDate=[" + effectiveDate + "]\n" + "sysCreationDate=[" + sysCreationDate + "]\n" + "sysUpdateDate=[" + sysUpdateDate + "]\n" + "operatorId=[" + operatorId + "]\n" + "applicationId=[" + applicationId + "]\n" + "dlServiceCode=[" + dlServiceCode + "]\n" + "dlUpdateStamp=[" + dlUpdateStamp + "]\n" + "fromSlab=[" + fromSlab + "]\n" + "toSlab=[" + toSlab + "]\n" + "expirationDate=[" + expirationDate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IcRatesSlabs)) {
                return false;
        }
        IcRatesSlabs that = (IcRatesSlabs) obj;
        if (!(that.getRatePlanCd() == null ? this.getRatePlanCd() == null
                        : that.getRatePlanCd().equals(this.getRatePlanCd()))) {
                return false;
        }
        if (!(that.getDestinationCd() == null ? this.getDestinationCd() == null
                        : that.getDestinationCd().equals(this.getDestinationCd()))) {
                return false;
        }
        if (!(that.getChrgParamId() == null ? this.getChrgParamId() == null
                        : 0 == that.getChrgParamId().compareTo(this.getChrgParamId()))) {
                return false;
        }
        if (!(that.getSlabNum() == null ? this.getSlabNum() == null
                        : 0 == that.getSlabNum().compareTo(this.getSlabNum()))) {
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
        if (!(that.getFromSlab() == null ? this.getFromSlab() == null
                        : 0 == that.getFromSlab().compareTo(this.getFromSlab()))) {
                return false;
        }
        if (!(that.getToSlab() == null ? this.getToSlab() == null
                        : 0 == that.getToSlab().compareTo(this.getToSlab()))) {
                return false;
        }
        if (!(that.getExpirationDate() == null ? this.getExpirationDate() == null
                        : that.getExpirationDate().equals(this.getExpirationDate()))) {
                return false;
        }
    return true;
    }

}
