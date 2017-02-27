
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcRateCodePK  implements Serializable {
    
    /** Creates a new instance of IcRateCode */
    public IcRateCodePK(
            java.math.BigDecimal rateCdSeq	
            , java.sql.Date effectiveDate	
        ) {
        this.rateCdSeq = rateCdSeq;	
        this.effectiveDate = effectiveDate;	
    }
    private java.math.BigDecimal rateCdSeq;	
    private java.sql.Date effectiveDate;	

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
        return super.toString() + " " + rateCdSeq + " " + effectiveDate;
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
