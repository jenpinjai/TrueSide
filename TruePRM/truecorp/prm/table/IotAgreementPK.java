
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IotAgreementPK  implements Serializable {
    
    /** Creates a new instance of IotAgreement */
    public IotAgreementPK(
            String agreementId	
            , java.sql.Date effectiveDate	
        ) {
        this.agreementId = agreementId;	
        this.effectiveDate = effectiveDate;	
    }
    private String agreementId;	
    private java.sql.Date effectiveDate;	

    public String getAgreementId() {
        return this.agreementId;
    }		
    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }
    public java.sql.Date getEffectiveDate() {
        return this.effectiveDate;
    }		
    public void setEffectiveDate(java.sql.Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String toString() {
        return super.toString() + " " + agreementId + " " + effectiveDate;
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
        if (!(that.getEffectiveDate() == null ? this.getEffectiveDate() == null
                        : that.getEffectiveDate().equals(this.getEffectiveDate()))) {
                return false;
        }
    return true;
    }

}
