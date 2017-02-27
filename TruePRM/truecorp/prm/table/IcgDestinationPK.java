
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcgDestinationPK  implements Serializable {
    
    /** Creates a new instance of IcgDestination */
    public IcgDestinationPK(
            String destinationCd	
            , java.sql.Date effectiveDate	
        ) {
        this.destinationCd = destinationCd;	
        this.effectiveDate = effectiveDate;	
    }
    private String destinationCd;	
    private java.sql.Date effectiveDate;	

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

    public String toString() {
        return super.toString() + " " + destinationCd + " " + effectiveDate;
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
    return true;
    }

}
