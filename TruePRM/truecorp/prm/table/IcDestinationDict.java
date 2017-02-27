
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcDestinationDict implements Serializable {
    
    /** Creates a new instance of IcDestinationDict */
    public IcDestinationDict() {
    }
    public IcDestinationDict(
            java.math.BigDecimal sequenceNo	
            , String languageCode	
            , java.sql.Date sysCreationDate	
            , java.sql.Date sysUpdateDate	
            , java.math.BigDecimal operatorId	
            , String applicationId	
            , String dlServiceCode	
            , java.math.BigDecimal dlUpdateStamp	
            , String text	
        ) {
        this.sequenceNo = sequenceNo;	
        this.languageCode = languageCode;	
        this.sysCreationDate = sysCreationDate;	
        this.sysUpdateDate = sysUpdateDate;	
        this.operatorId = operatorId;	
        this.applicationId = applicationId;	
        this.dlServiceCode = dlServiceCode;	
        this.dlUpdateStamp = dlUpdateStamp;	
        this.text = text;	
    }
    private java.math.BigDecimal sequenceNo;	
    private String languageCode;	
    private java.sql.Date sysCreationDate;	
    private java.sql.Date sysUpdateDate;	
    private java.math.BigDecimal operatorId;	
    private String applicationId;	
    private String dlServiceCode;	
    private java.math.BigDecimal dlUpdateStamp;	
    private String text;	



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
    public String getText() {
        return this.text;
    }		
    public void setText(String text) {
        this.text = text;
    }



    public String toString() {
        return super.toString() + "sequenceNo=[" + sequenceNo + "]\n" + "languageCode=[" + languageCode + "]\n" + "sysCreationDate=[" + sysCreationDate + "]\n" + "sysUpdateDate=[" + sysUpdateDate + "]\n" + "operatorId=[" + operatorId + "]\n" + "applicationId=[" + applicationId + "]\n" + "dlServiceCode=[" + dlServiceCode + "]\n" + "dlUpdateStamp=[" + dlUpdateStamp + "]\n" + "text=[" + text + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IcDestinationDict)) {
                return false;
        }
        IcDestinationDict that = (IcDestinationDict) obj;
        if (!(that.getSequenceNo() == null ? this.getSequenceNo() == null
                        : 0 == that.getSequenceNo().compareTo(this.getSequenceNo()))) {
                return false;
        }
        if (!(that.getLanguageCode() == null ? this.getLanguageCode() == null
                        : that.getLanguageCode().equals(this.getLanguageCode()))) {
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
        if (!(that.getText() == null ? this.getText() == null
                        : that.getText().equals(this.getText()))) {
                return false;
        }
    return true;
    }

}
