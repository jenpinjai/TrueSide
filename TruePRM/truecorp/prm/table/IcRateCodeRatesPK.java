
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcRateCodeRatesPK  implements Serializable {
    
    /** Creates a new instance of IcRateCodeRates */
    public IcRateCodeRatesPK(
            String rateClassSetCd	
            , java.math.BigDecimal rateCdSeq	
            , java.sql.Date effectiveDate	
        ) {
        this.rateClassSetCd = rateClassSetCd;	
        this.rateCdSeq = rateCdSeq;	
        this.effectiveDate = effectiveDate;	
    }
    private String rateClassSetCd;	
    private java.math.BigDecimal rateCdSeq;	
    private java.sql.Date effectiveDate;	

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

    public String toString() {
        return super.toString() + " " + rateClassSetCd + " " + rateCdSeq + " " + effectiveDate;
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
                        : that.getRateCdSeq().equals(this.getRateCdSeq()))) {
                return false;
        }
        if (!(that.getEffectiveDate() == null ? this.getEffectiveDate() == null
                        : that.getEffectiveDate().equals(this.getEffectiveDate()))) {
                return false;
        }
    return true;
    }

}
