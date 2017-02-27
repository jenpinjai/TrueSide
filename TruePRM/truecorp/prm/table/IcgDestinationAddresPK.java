
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcgDestinationAddresPK  implements Serializable {
    
    /** Creates a new instance of IcgDestinationAddres */
    public IcgDestinationAddresPK(
            String destinationCd	
            , String address	
            , java.sql.Date effectiveDate	
        ) {
        this.destinationCd = destinationCd;	
        this.address = address;	
        this.effectiveDate = effectiveDate;	
    }
    private String destinationCd;	
    private String address;	
    private java.sql.Date effectiveDate;	

    public String getDestinationCd() {
        return this.destinationCd;
    }		
    public void setDestinationCd(String destinationCd) {
        this.destinationCd = destinationCd;
    }
    public String getAddress() {
        return this.address;
    }		
    public void setAddress(String address) {
        this.address = address;
    }
    public java.sql.Date getEffectiveDate() {
        return this.effectiveDate;
    }		
    public void setEffectiveDate(java.sql.Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String toString() {
        return super.toString() + " " + destinationCd + " " + address + " " + effectiveDate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IcgDestinationAddres)) {
                return false;
        }
        IcgDestinationAddres that = (IcgDestinationAddres) obj;
        if (!(that.getDestinationCd() == null ? this.getDestinationCd() == null
                        : that.getDestinationCd().equals(this.getDestinationCd()))) {
                return false;
        }
        if (!(that.getAddress() == null ? this.getAddress() == null
                        : that.getAddress().equals(this.getAddress()))) {
                return false;
        }
        if (!(that.getEffectiveDate() == null ? this.getEffectiveDate() == null
                        : that.getEffectiveDate().equals(this.getEffectiveDate()))) {
                return false;
        }
    return true;
    }

}
