
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcSubjectVersionsPK  implements Serializable {
    
    /** Creates a new instance of IcSubjectVersions */
    public IcSubjectVersionsPK(
            String subject	
            , String code	
            , java.sql.Date effectiveDate	
        ) {
        this.subject = subject;	
        this.code = code;	
        this.effectiveDate = effectiveDate;	
    }
    private String subject;	
    private String code;	
    private java.sql.Date effectiveDate;	

    public String getSubject() {
        return this.subject;
    }		
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getCode() {
        return this.code;
    }		
    public void setCode(String code) {
        this.code = code;
    }
    public java.sql.Date getEffectiveDate() {
        return this.effectiveDate;
    }		
    public void setEffectiveDate(java.sql.Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String toString() {
        return super.toString() + " " + subject + " " + code + " " + effectiveDate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IcSubjectVersions)) {
                return false;
        }
        IcSubjectVersions that = (IcSubjectVersions) obj;
        if (!(that.getSubject() == null ? this.getSubject() == null
                        : that.getSubject().equals(this.getSubject()))) {
                return false;
        }
        if (!(that.getCode() == null ? this.getCode() == null
                        : that.getCode().equals(this.getCode()))) {
                return false;
        }
        if (!(that.getEffectiveDate() == null ? this.getEffectiveDate() == null
                        : that.getEffectiveDate().equals(this.getEffectiveDate()))) {
                return false;
        }
    return true;
    }

}
