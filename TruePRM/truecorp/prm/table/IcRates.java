
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcRates implements Serializable {
    
    /** Creates a new instance of IcRates */
    public IcRates() {
    }
    public IcRates(
            String ratePlanCd	
            , String destinationCd	
            , java.math.BigDecimal chrgParamId	
            , java.math.BigDecimal qualParam1Id	
            , String qualParam1Cd	
            , java.math.BigDecimal qualParam2Id	
            , String qualParam2Cd	
            , java.math.BigDecimal qualParam3Id	
            , String qualParam3Cd	
            , java.math.BigDecimal qualParam4Id	
            , String qualParam4Cd	
            , java.math.BigDecimal qualParam5Id	
            , String qualParam5Cd	
            , java.math.BigDecimal qualParam6Id	
            , String qualParam6Cd	
            , java.math.BigDecimal qualParam7Id	
            , String qualParam7Cd	
            , java.math.BigDecimal slabNum	
            , java.sql.Date effectiveDate	
            , java.sql.Date sysCreationDate	
            , java.sql.Date sysUpdateDate	
            , java.math.BigDecimal operatorId	
            , String applicationId	
            , String dlServiceCode	
            , java.math.BigDecimal dlUpdateStamp	
            , java.math.BigDecimal ratePerUnit	
            , java.math.BigDecimal ratingUnit	
            , java.math.BigDecimal ratePerUnitSeq	
            , java.math.BigDecimal oneTimeChrg	
            , java.math.BigDecimal oneTimeChrgSeq	
            , java.sql.Date expirationDate	
        ) {
        this.ratePlanCd = ratePlanCd;	
        this.destinationCd = destinationCd;	
        this.chrgParamId = chrgParamId;	
        this.qualParam1Id = qualParam1Id;	
        this.qualParam1Cd = qualParam1Cd;	
        this.qualParam2Id = qualParam2Id;	
        this.qualParam2Cd = qualParam2Cd;	
        this.qualParam3Id = qualParam3Id;	
        this.qualParam3Cd = qualParam3Cd;	
        this.qualParam4Id = qualParam4Id;	
        this.qualParam4Cd = qualParam4Cd;	
        this.qualParam5Id = qualParam5Id;	
        this.qualParam5Cd = qualParam5Cd;	
        this.qualParam6Id = qualParam6Id;	
        this.qualParam6Cd = qualParam6Cd;	
        this.qualParam7Id = qualParam7Id;	
        this.qualParam7Cd = qualParam7Cd;	
        this.slabNum = slabNum;	
        this.effectiveDate = effectiveDate;	
        this.sysCreationDate = sysCreationDate;	
        this.sysUpdateDate = sysUpdateDate;	
        this.operatorId = operatorId;	
        this.applicationId = applicationId;	
        this.dlServiceCode = dlServiceCode;	
        this.dlUpdateStamp = dlUpdateStamp;	
        this.ratePerUnit = ratePerUnit;	
        this.ratingUnit = ratingUnit;	
        this.ratePerUnitSeq = ratePerUnitSeq;	
        this.oneTimeChrg = oneTimeChrg;	
        this.oneTimeChrgSeq = oneTimeChrgSeq;	
        this.expirationDate = expirationDate;	
    }
    private String ratePlanCd;	
    private String destinationCd;	
    private java.math.BigDecimal chrgParamId;	
    private java.math.BigDecimal qualParam1Id;	
    private String qualParam1Cd;	
    private java.math.BigDecimal qualParam2Id;	
    private String qualParam2Cd;	
    private java.math.BigDecimal qualParam3Id;	
    private String qualParam3Cd;	
    private java.math.BigDecimal qualParam4Id;	
    private String qualParam4Cd;	
    private java.math.BigDecimal qualParam5Id;	
    private String qualParam5Cd;	
    private java.math.BigDecimal qualParam6Id;	
    private String qualParam6Cd;	
    private java.math.BigDecimal qualParam7Id;	
    private String qualParam7Cd;	
    private java.math.BigDecimal slabNum;	
    private java.sql.Date effectiveDate;	
    private java.sql.Date sysCreationDate;	
    private java.sql.Date sysUpdateDate;	
    private java.math.BigDecimal operatorId;	
    private String applicationId;	
    private String dlServiceCode;	
    private java.math.BigDecimal dlUpdateStamp;	
    private java.math.BigDecimal ratePerUnit;	
    private java.math.BigDecimal ratingUnit;	
    private java.math.BigDecimal ratePerUnitSeq;	
    private java.math.BigDecimal oneTimeChrg;	
    private java.math.BigDecimal oneTimeChrgSeq;	
    private java.sql.Date expirationDate;	



    public String getRatePlanCd() {
        return this.ratePlanCd;
    }		
    public void setRatePlanCd(String ratePlanCd) {
        this.ratePlanCd = ratePlanCd;
    }
    public String getDestinationCd() {
        return this.destinationCd;
    }		
    public void setDestinationCd(String destinationCd) {
        this.destinationCd = destinationCd;
    }
    public java.math.BigDecimal getChrgParamId() {
        return this.chrgParamId;
    }		
    public void setChrgParamId(java.math.BigDecimal chrgParamId) {
        this.chrgParamId = chrgParamId;
    }
    public java.math.BigDecimal getQualParam1Id() {
        return this.qualParam1Id;
    }		
    public void setQualParam1Id(java.math.BigDecimal qualParam1Id) {
        this.qualParam1Id = qualParam1Id;
    }
    public String getQualParam1Cd() {
        return this.qualParam1Cd;
    }		
    public void setQualParam1Cd(String qualParam1Cd) {
        this.qualParam1Cd = qualParam1Cd;
    }
    public java.math.BigDecimal getQualParam2Id() {
        return this.qualParam2Id;
    }		
    public void setQualParam2Id(java.math.BigDecimal qualParam2Id) {
        this.qualParam2Id = qualParam2Id;
    }
    public String getQualParam2Cd() {
        return this.qualParam2Cd;
    }		
    public void setQualParam2Cd(String qualParam2Cd) {
        this.qualParam2Cd = qualParam2Cd;
    }
    public java.math.BigDecimal getQualParam3Id() {
        return this.qualParam3Id;
    }		
    public void setQualParam3Id(java.math.BigDecimal qualParam3Id) {
        this.qualParam3Id = qualParam3Id;
    }
    public String getQualParam3Cd() {
        return this.qualParam3Cd;
    }		
    public void setQualParam3Cd(String qualParam3Cd) {
        this.qualParam3Cd = qualParam3Cd;
    }
    public java.math.BigDecimal getQualParam4Id() {
        return this.qualParam4Id;
    }		
    public void setQualParam4Id(java.math.BigDecimal qualParam4Id) {
        this.qualParam4Id = qualParam4Id;
    }
    public String getQualParam4Cd() {
        return this.qualParam4Cd;
    }		
    public void setQualParam4Cd(String qualParam4Cd) {
        this.qualParam4Cd = qualParam4Cd;
    }
    public java.math.BigDecimal getQualParam5Id() {
        return this.qualParam5Id;
    }		
    public void setQualParam5Id(java.math.BigDecimal qualParam5Id) {
        this.qualParam5Id = qualParam5Id;
    }
    public String getQualParam5Cd() {
        return this.qualParam5Cd;
    }		
    public void setQualParam5Cd(String qualParam5Cd) {
        this.qualParam5Cd = qualParam5Cd;
    }
    public java.math.BigDecimal getQualParam6Id() {
        return this.qualParam6Id;
    }		
    public void setQualParam6Id(java.math.BigDecimal qualParam6Id) {
        this.qualParam6Id = qualParam6Id;
    }
    public String getQualParam6Cd() {
        return this.qualParam6Cd;
    }		
    public void setQualParam6Cd(String qualParam6Cd) {
        this.qualParam6Cd = qualParam6Cd;
    }
    public java.math.BigDecimal getQualParam7Id() {
        return this.qualParam7Id;
    }		
    public void setQualParam7Id(java.math.BigDecimal qualParam7Id) {
        this.qualParam7Id = qualParam7Id;
    }
    public String getQualParam7Cd() {
        return this.qualParam7Cd;
    }		
    public void setQualParam7Cd(String qualParam7Cd) {
        this.qualParam7Cd = qualParam7Cd;
    }
    public java.math.BigDecimal getSlabNum() {
        return this.slabNum;
    }		
    public void setSlabNum(java.math.BigDecimal slabNum) {
        this.slabNum = slabNum;
    }
    public java.sql.Date getEffectiveDate() {
        return this.effectiveDate;
    }		
    public void setEffectiveDate(java.sql.Date effectiveDate) {
        this.effectiveDate = effectiveDate;
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
    public java.math.BigDecimal getRatePerUnit() {
        return this.ratePerUnit;
    }		
    public void setRatePerUnit(java.math.BigDecimal ratePerUnit) {
        this.ratePerUnit = ratePerUnit;
    }
    public java.math.BigDecimal getRatingUnit() {
        return this.ratingUnit;
    }		
    public void setRatingUnit(java.math.BigDecimal ratingUnit) {
        this.ratingUnit = ratingUnit;
    }
    public java.math.BigDecimal getRatePerUnitSeq() {
        return this.ratePerUnitSeq;
    }		
    public void setRatePerUnitSeq(java.math.BigDecimal ratePerUnitSeq) {
        this.ratePerUnitSeq = ratePerUnitSeq;
    }
    public java.math.BigDecimal getOneTimeChrg() {
        return this.oneTimeChrg;
    }		
    public void setOneTimeChrg(java.math.BigDecimal oneTimeChrg) {
        this.oneTimeChrg = oneTimeChrg;
    }
    public java.math.BigDecimal getOneTimeChrgSeq() {
        return this.oneTimeChrgSeq;
    }		
    public void setOneTimeChrgSeq(java.math.BigDecimal oneTimeChrgSeq) {
        this.oneTimeChrgSeq = oneTimeChrgSeq;
    }
    public java.sql.Date getExpirationDate() {
        return this.expirationDate;
    }		
    public void setExpirationDate(java.sql.Date expirationDate) {
        this.expirationDate = expirationDate;
    }



    public String toString() {
        return super.toString() + "ratePlanCd=[" + ratePlanCd + "]\n" + "destinationCd=[" + destinationCd + "]\n" + "chrgParamId=[" + chrgParamId + "]\n" + "qualParam1Id=[" + qualParam1Id + "]\n" + "qualParam1Cd=[" + qualParam1Cd + "]\n" + "qualParam2Id=[" + qualParam2Id + "]\n" + "qualParam2Cd=[" + qualParam2Cd + "]\n" + "qualParam3Id=[" + qualParam3Id + "]\n" + "qualParam3Cd=[" + qualParam3Cd + "]\n" + "qualParam4Id=[" + qualParam4Id + "]\n" + "qualParam4Cd=[" + qualParam4Cd + "]\n" + "qualParam5Id=[" + qualParam5Id + "]\n" + "qualParam5Cd=[" + qualParam5Cd + "]\n" + "qualParam6Id=[" + qualParam6Id + "]\n" + "qualParam6Cd=[" + qualParam6Cd + "]\n" + "qualParam7Id=[" + qualParam7Id + "]\n" + "qualParam7Cd=[" + qualParam7Cd + "]\n" + "slabNum=[" + slabNum + "]\n" + "effectiveDate=[" + effectiveDate + "]\n" + "sysCreationDate=[" + sysCreationDate + "]\n" + "sysUpdateDate=[" + sysUpdateDate + "]\n" + "operatorId=[" + operatorId + "]\n" + "applicationId=[" + applicationId + "]\n" + "dlServiceCode=[" + dlServiceCode + "]\n" + "dlUpdateStamp=[" + dlUpdateStamp + "]\n" + "ratePerUnit=[" + ratePerUnit + "]\n" + "ratingUnit=[" + ratingUnit + "]\n" + "ratePerUnitSeq=[" + ratePerUnitSeq + "]\n" + "oneTimeChrg=[" + oneTimeChrg + "]\n" + "oneTimeChrgSeq=[" + oneTimeChrgSeq + "]\n" + "expirationDate=[" + expirationDate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IcRates)) {
                return false;
        }
        IcRates that = (IcRates) obj;
        if (!(that.getRatePlanCd() == null ? this.getRatePlanCd() == null
                        : that.getRatePlanCd().equals(this.getRatePlanCd()))) {
                return false;
        }
        if (!(that.getDestinationCd() == null ? this.getDestinationCd() == null
                        : that.getDestinationCd().equals(this.getDestinationCd()))) {
                return false;
        }
        if (!(that.getChrgParamId() == null ? this.getChrgParamId() == null
                        : 0 == that.getChrgParamId().compareTo(this.getChrgParamId()))) {
                return false;
        }
        if (!(that.getQualParam1Id() == null ? this.getQualParam1Id() == null
                        : 0 == that.getQualParam1Id().compareTo(this.getQualParam1Id()))) {
                return false;
        }
        if (!(that.getQualParam1Cd() == null ? this.getQualParam1Cd() == null
                        : that.getQualParam1Cd().equals(this.getQualParam1Cd()))) {
                return false;
        }
        if (!(that.getQualParam2Id() == null ? this.getQualParam2Id() == null
                        : 0 == that.getQualParam2Id().compareTo(this.getQualParam2Id()))) {
                return false;
        }
        if (!(that.getQualParam2Cd() == null ? this.getQualParam2Cd() == null
                        : that.getQualParam2Cd().equals(this.getQualParam2Cd()))) {
                return false;
        }
        if (!(that.getQualParam3Id() == null ? this.getQualParam3Id() == null
                        : 0 == that.getQualParam3Id().compareTo(this.getQualParam3Id()))) {
                return false;
        }
        if (!(that.getQualParam3Cd() == null ? this.getQualParam3Cd() == null
                        : that.getQualParam3Cd().equals(this.getQualParam3Cd()))) {
                return false;
        }
        if (!(that.getQualParam4Id() == null ? this.getQualParam4Id() == null
                        : 0 == that.getQualParam4Id().compareTo(this.getQualParam4Id()))) {
                return false;
        }
        if (!(that.getQualParam4Cd() == null ? this.getQualParam4Cd() == null
                        : that.getQualParam4Cd().equals(this.getQualParam4Cd()))) {
                return false;
        }
        if (!(that.getQualParam5Id() == null ? this.getQualParam5Id() == null
                        : 0 == that.getQualParam5Id().compareTo(this.getQualParam5Id()))) {
                return false;
        }
        if (!(that.getQualParam5Cd() == null ? this.getQualParam5Cd() == null
                        : that.getQualParam5Cd().equals(this.getQualParam5Cd()))) {
                return false;
        }
        if (!(that.getQualParam6Id() == null ? this.getQualParam6Id() == null
                        : 0 == that.getQualParam6Id().compareTo(this.getQualParam6Id()))) {
                return false;
        }
        if (!(that.getQualParam6Cd() == null ? this.getQualParam6Cd() == null
                        : that.getQualParam6Cd().equals(this.getQualParam6Cd()))) {
                return false;
        }
        if (!(that.getQualParam7Id() == null ? this.getQualParam7Id() == null
                        : 0 == that.getQualParam7Id().compareTo(this.getQualParam7Id()))) {
                return false;
        }
        if (!(that.getQualParam7Cd() == null ? this.getQualParam7Cd() == null
                        : that.getQualParam7Cd().equals(this.getQualParam7Cd()))) {
                return false;
        }
        if (!(that.getSlabNum() == null ? this.getSlabNum() == null
                        : 0 == that.getSlabNum().compareTo(this.getSlabNum()))) {
                return false;
        }
        if (!(that.getEffectiveDate() == null ? this.getEffectiveDate() == null
                        : that.getEffectiveDate().equals(this.getEffectiveDate()))) {
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
        if (!(that.getRatePerUnit() == null ? this.getRatePerUnit() == null
                        : 0 == that.getRatePerUnit().compareTo(this.getRatePerUnit()))) {
                return false;
        }
        if (!(that.getRatingUnit() == null ? this.getRatingUnit() == null
                        : 0 == that.getRatingUnit().compareTo(this.getRatingUnit()))) {
                return false;
        }
        if (!(that.getRatePerUnitSeq() == null ? this.getRatePerUnitSeq() == null
                        : 0 == that.getRatePerUnitSeq().compareTo(this.getRatePerUnitSeq()))) {
                return false;
        }
        if (!(that.getOneTimeChrg() == null ? this.getOneTimeChrg() == null
                        : 0 == that.getOneTimeChrg().compareTo(this.getOneTimeChrg()))) {
                return false;
        }
        if (!(that.getOneTimeChrgSeq() == null ? this.getOneTimeChrgSeq() == null
                        : 0 == that.getOneTimeChrgSeq().compareTo(this.getOneTimeChrgSeq()))) {
                return false;
        }
        if (!(that.getExpirationDate() == null ? this.getExpirationDate() == null
                        : that.getExpirationDate().equals(this.getExpirationDate()))) {
                return false;
        }
    return true;
    }

}