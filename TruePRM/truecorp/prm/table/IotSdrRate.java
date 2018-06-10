
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IotSdrRate implements Serializable {
    
    /** Creates a new instance of IotSdrRate */
    public IotSdrRate() {
    }
    public IotSdrRate(
            String currencyCd	
            , java.math.BigDecimal sdrMonth	
            , java.math.BigDecimal sdrYear	
            , java.math.BigDecimal sdrRate	
            , String userName	
            , java.sql.Date sysCreationDate	
            , java.sql.Date sysUpdateDate	
            , java.math.BigDecimal operatorId	
            , String applicationId	
            , String dlServiceCode	
            , java.math.BigDecimal dlUpdateStamp	
        ) {
        this.currencyCd = currencyCd;	
        this.sdrMonth = sdrMonth;	
        this.sdrYear = sdrYear;	
        this.sdrRate = sdrRate;	
        this.userName = userName;	
        this.sysCreationDate = sysCreationDate;	
        this.sysUpdateDate = sysUpdateDate;	
        this.operatorId = operatorId;	
        this.applicationId = applicationId;	
        this.dlServiceCode = dlServiceCode;	
        this.dlUpdateStamp = dlUpdateStamp;	
    }
    private String currencyCd;	
    private java.math.BigDecimal sdrMonth;	
    private java.math.BigDecimal sdrYear;	
    private java.math.BigDecimal sdrRate;	
    private String userName;	
    private java.sql.Date sysCreationDate;	
    private java.sql.Date sysUpdateDate;	
    private java.math.BigDecimal operatorId;	
    private String applicationId;	
    private String dlServiceCode;	
    private java.math.BigDecimal dlUpdateStamp;	



    public String getCurrencyCd() {
        return this.currencyCd;
    }		
    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd;
    }
    public java.math.BigDecimal getSdrMonth() {
        return this.sdrMonth;
    }		
    public void setSdrMonth(java.math.BigDecimal sdrMonth) {
        this.sdrMonth = sdrMonth;
    }
    public java.math.BigDecimal getSdrYear() {
        return this.sdrYear;
    }		
    public void setSdrYear(java.math.BigDecimal sdrYear) {
        this.sdrYear = sdrYear;
    }
    public java.math.BigDecimal getSdrRate() {
        return this.sdrRate;
    }		
    public void setSdrRate(java.math.BigDecimal sdrRate) {
        this.sdrRate = sdrRate;
    }
    public String getUserName() {
        return this.userName;
    }		
    public void setUserName(String userName) {
        this.userName = userName;
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



    public String toString() {
        return super.toString() + "currencyCd=[" + currencyCd + "]\n" + "sdrMonth=[" + sdrMonth + "]\n" + "sdrYear=[" + sdrYear + "]\n" + "sdrRate=[" + sdrRate + "]\n" + "userName=[" + userName + "]\n" + "sysCreationDate=[" + sysCreationDate + "]\n" + "sysUpdateDate=[" + sysUpdateDate + "]\n" + "operatorId=[" + operatorId + "]\n" + "applicationId=[" + applicationId + "]\n" + "dlServiceCode=[" + dlServiceCode + "]\n" + "dlUpdateStamp=[" + dlUpdateStamp + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IotSdrRate)) {
                return false;
        }
        IotSdrRate that = (IotSdrRate) obj;
        if (!(that.getCurrencyCd() == null ? this.getCurrencyCd() == null
                        : that.getCurrencyCd().equals(this.getCurrencyCd()))) {
                return false;
        }
        if (!(that.getSdrMonth() == null ? this.getSdrMonth() == null
                        : 0 == that.getSdrMonth().compareTo(this.getSdrMonth()))) {
                return false;
        }
        if (!(that.getSdrYear() == null ? this.getSdrYear() == null
                        : 0 == that.getSdrYear().compareTo(this.getSdrYear()))) {
                return false;
        }
        if (!(that.getSdrRate() == null ? this.getSdrRate() == null
                        : 0 == that.getSdrRate().compareTo(this.getSdrRate()))) {
                return false;
        }
        if (!(that.getUserName() == null ? this.getUserName() == null
                        : that.getUserName().equals(this.getUserName()))) {
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
    return true;
    }

}
