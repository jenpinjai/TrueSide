
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IotSdrRatePK  implements Serializable {
    
    /** Creates a new instance of IotSdrRate */
    public IotSdrRatePK(
            String currencyCd	
            , java.math.BigDecimal sdrMonth	
            , java.math.BigDecimal sdrYear	
        ) {
        this.currencyCd = currencyCd;	
        this.sdrMonth = sdrMonth;	
        this.sdrYear = sdrYear;	
    }
    private String currencyCd;	
    private java.math.BigDecimal sdrMonth;	
    private java.math.BigDecimal sdrYear;	

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

    public String toString() {
        return super.toString() + " " + currencyCd + " " + sdrMonth + " " + sdrYear;
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
                        : that.getSdrMonth().equals(this.getSdrMonth()))) {
                return false;
        }
        if (!(that.getSdrYear() == null ? this.getSdrYear() == null
                        : that.getSdrYear().equals(this.getSdrYear()))) {
                return false;
        }
    return true;
    }

}
