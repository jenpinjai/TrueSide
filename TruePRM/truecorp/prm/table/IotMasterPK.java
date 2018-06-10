
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IotMasterPK  implements Serializable {
    
    /** Creates a new instance of IotMaster */
    public IotMasterPK(
            String direction	
            , String myTadig	
            , String countryName	
            , String operatorName	
            , String theirTadig	
            , String yearTadig	
            , String monthTadig	
            , String typeTadig	
            , String callCountry	
            , String desType	
        ) {
        this.direction = direction;	
        this.myTadig = myTadig;	
        this.countryName = countryName;	
        this.operatorName = operatorName;	
        this.theirTadig = theirTadig;	
        this.yearTadig = yearTadig;	
        this.monthTadig = monthTadig;	
        this.typeTadig = typeTadig;	
        this.callCountry = callCountry;	
        this.desType = desType;	
    }
    private String direction;	
    private String myTadig;	
    private String countryName;	
    private String operatorName;	
    private String theirTadig;	
    private String yearTadig;	
    private String monthTadig;	
    private String typeTadig;	
    private String callCountry;	
    private String desType;	

    public String getDirection() {
        return this.direction;
    }		
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getMyTadig() {
        return this.myTadig;
    }		
    public void setMyTadig(String myTadig) {
        this.myTadig = myTadig;
    }
    public String getCountryName() {
        return this.countryName;
    }		
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getOperatorName() {
        return this.operatorName;
    }		
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
    public String getTheirTadig() {
        return this.theirTadig;
    }		
    public void setTheirTadig(String theirTadig) {
        this.theirTadig = theirTadig;
    }
    public String getYearTadig() {
        return this.yearTadig;
    }		
    public void setYearTadig(String yearTadig) {
        this.yearTadig = yearTadig;
    }
    public String getMonthTadig() {
        return this.monthTadig;
    }		
    public void setMonthTadig(String monthTadig) {
        this.monthTadig = monthTadig;
    }
    public String getTypeTadig() {
        return this.typeTadig;
    }		
    public void setTypeTadig(String typeTadig) {
        this.typeTadig = typeTadig;
    }
    public String getCallCountry() {
        return this.callCountry;
    }		
    public void setCallCountry(String callCountry) {
        this.callCountry = callCountry;
    }
    public String getDesType() {
        return this.desType;
    }		
    public void setDesType(String desType) {
        this.desType = desType;
    }

    public String toString() {
        return super.toString() + " " + direction + " " + myTadig + " " + countryName + " " + operatorName + " " + theirTadig + " " + yearTadig + " " + monthTadig + " " + typeTadig + " " + callCountry + " " + desType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IotMaster)) {
                return false;
        }
        IotMaster that = (IotMaster) obj;
        if (!(that.getDirection() == null ? this.getDirection() == null
                        : that.getDirection().equals(this.getDirection()))) {
                return false;
        }
        if (!(that.getMyTadig() == null ? this.getMyTadig() == null
                        : that.getMyTadig().equals(this.getMyTadig()))) {
                return false;
        }
        if (!(that.getCountryName() == null ? this.getCountryName() == null
                        : that.getCountryName().equals(this.getCountryName()))) {
                return false;
        }
        if (!(that.getOperatorName() == null ? this.getOperatorName() == null
                        : that.getOperatorName().equals(this.getOperatorName()))) {
                return false;
        }
        if (!(that.getTheirTadig() == null ? this.getTheirTadig() == null
                        : that.getTheirTadig().equals(this.getTheirTadig()))) {
                return false;
        }
        if (!(that.getYearTadig() == null ? this.getYearTadig() == null
                        : that.getYearTadig().equals(this.getYearTadig()))) {
                return false;
        }
        if (!(that.getMonthTadig() == null ? this.getMonthTadig() == null
                        : that.getMonthTadig().equals(this.getMonthTadig()))) {
                return false;
        }
        if (!(that.getTypeTadig() == null ? this.getTypeTadig() == null
                        : that.getTypeTadig().equals(this.getTypeTadig()))) {
                return false;
        }
        if (!(that.getCallCountry() == null ? this.getCallCountry() == null
                        : that.getCallCountry().equals(this.getCallCountry()))) {
                return false;
        }
        if (!(that.getDesType() == null ? this.getDesType() == null
                        : that.getDesType().equals(this.getDesType()))) {
                return false;
        }
    return true;
    }

}
