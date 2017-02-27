
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcRatingDictPK  implements Serializable {
    
    /** Creates a new instance of IcRatingDict */
    public IcRatingDictPK(
            java.math.BigDecimal sequenceNo	
            , String languageCode	
        ) {
        this.sequenceNo = sequenceNo;	
        this.languageCode = languageCode;	
    }
    private java.math.BigDecimal sequenceNo;	
    private String languageCode;	

    public java.math.BigDecimal getSequenceNo() {
        return this.sequenceNo;
    }		
    public void setSequenceNo(java.math.BigDecimal sequenceNo) {
        this.sequenceNo = sequenceNo;
    }
    public String getLanguageCode() {
        return this.languageCode;
    }		
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String toString() {
        return super.toString() + " " + sequenceNo + " " + languageCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IcRatingDict)) {
                return false;
        }
        IcRatingDict that = (IcRatingDict) obj;
        if (!(that.getSequenceNo() == null ? this.getSequenceNo() == null
                        : that.getSequenceNo().equals(this.getSequenceNo()))) {
                return false;
        }
        if (!(that.getLanguageCode() == null ? this.getLanguageCode() == null
                        : that.getLanguageCode().equals(this.getLanguageCode()))) {
                return false;
        }
    return true;
    }

}
