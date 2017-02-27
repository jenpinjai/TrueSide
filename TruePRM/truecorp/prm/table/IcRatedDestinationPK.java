
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcRatedDestinationPK  implements Serializable {
    
    /** Creates a new instance of IcRatedDestination */
    public IcRatedDestinationPK(
            String ratePlanCd	
            , String destinationCd	
            , java.math.BigDecimal chrgParamId	
            , java.sql.Date effectiveDate	
        ) {
        this.ratePlanCd = ratePlanCd;	
        this.destinationCd = destinationCd;	
        this.chrgParamId = chrgParamId;	
        this.effectiveDate = effectiveDate;	
    }
    private String ratePlanCd;	
    private String destinationCd;	
    private java.math.BigDecimal chrgParamId;	
    private java.sql.Date effectiveDate;	

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
    public java.sql.Date getEffectiveDate() {
        return this.effectiveDate;
    }		
    public void setEffectiveDate(java.sql.Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String toString() {
        return super.toString() + " " + ratePlanCd + " " + destinationCd + " " + chrgParamId + " " + effectiveDate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IcRatedDestination)) {
                return false;
        }
        IcRatedDestination that = (IcRatedDestination) obj;
        if (!(that.getRatePlanCd() == null ? this.getRatePlanCd() == null
                        : that.getRatePlanCd().equals(this.getRatePlanCd()))) {
                return false;
        }
        if (!(that.getDestinationCd() == null ? this.getDestinationCd() == null
                        : that.getDestinationCd().equals(this.getDestinationCd()))) {
                return false;
        }
        if (!(that.getChrgParamId() == null ? this.getChrgParamId() == null
                        : that.getChrgParamId().equals(this.getChrgParamId()))) {
                return false;
        }
        if (!(that.getEffectiveDate() == null ? this.getEffectiveDate() == null
                        : that.getEffectiveDate().equals(this.getEffectiveDate()))) {
                return false;
        }
    return true;
    }

}
