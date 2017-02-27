
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IcRatedDestination implements Serializable {
    
    /** Creates a new instance of IcRatedDestination */
    public IcRatedDestination() {
    }
    public IcRatedDestination(
            String ratePlanCd	
            , String destinationCd	
            , java.math.BigDecimal chrgParamId	
            , java.sql.Date effectiveDate	
            , java.sql.Date sysCreationDate	
            , java.sql.Date sysUpdateDate	
            , java.math.BigDecimal operatorId	
            , String applicationId	
            , String dlServiceCode	
            , java.math.BigDecimal dlUpdateStamp	
            , java.math.BigDecimal qualParam1Id	
            , String qualParam1SetCd	
            , java.math.BigDecimal qualParam2Id	
            , String qualParam2SetCd	
            , java.math.BigDecimal qualParam3Id	
            , String qualParam3SetCd	
            , java.math.BigDecimal qualParam4Id	
            , String qualParam4SetCd	
            , java.math.BigDecimal qualParam5Id	
            , String qualParam5SetCd	
            , java.math.BigDecimal qualParam6Id	
            , String qualParam6SetCd	
            , java.math.BigDecimal qualParam7Id	
            , String qualParam7SetCd	
            , java.math.BigDecimal destSortOrderCd	
            , String ratesPresInd	
            , String uom	
            , java.math.BigDecimal minChrgParam	
            , java.math.BigDecimal roundingUnit	
            , java.math.BigDecimal ratingUnit	
            , String rateSchemeInd	
            , java.math.BigDecimal minChrg	
            , String paramDspOrder	
            , java.math.BigDecimal oneTimeChrg	
            , java.math.BigDecimal accesChrg	
            , java.sql.Date expirationDate	
        ) {
        this.ratePlanCd = ratePlanCd;	
        this.destinationCd = destinationCd;	
        this.chrgParamId = chrgParamId;	
        this.effectiveDate = effectiveDate;	
        this.sysCreationDate = sysCreationDate;	
        this.sysUpdateDate = sysUpdateDate;	
        this.operatorId = operatorId;	
        this.applicationId = applicationId;	
        this.dlServiceCode = dlServiceCode;	
        this.dlUpdateStamp = dlUpdateStamp;	
        this.qualParam1Id = qualParam1Id;	
        this.qualParam1SetCd = qualParam1SetCd;	
        this.qualParam2Id = qualParam2Id;	
        this.qualParam2SetCd = qualParam2SetCd;	
        this.qualParam3Id = qualParam3Id;	
        this.qualParam3SetCd = qualParam3SetCd;	
        this.qualParam4Id = qualParam4Id;	
        this.qualParam4SetCd = qualParam4SetCd;	
        this.qualParam5Id = qualParam5Id;	
        this.qualParam5SetCd = qualParam5SetCd;	
        this.qualParam6Id = qualParam6Id;	
        this.qualParam6SetCd = qualParam6SetCd;	
        this.qualParam7Id = qualParam7Id;	
        this.qualParam7SetCd = qualParam7SetCd;	
        this.destSortOrderCd = destSortOrderCd;	
        this.ratesPresInd = ratesPresInd;	
        this.uom = uom;	
        this.minChrgParam = minChrgParam;	
        this.roundingUnit = roundingUnit;	
        this.ratingUnit = ratingUnit;	
        this.rateSchemeInd = rateSchemeInd;	
        this.minChrg = minChrg;	
        this.paramDspOrder = paramDspOrder;	
        this.oneTimeChrg = oneTimeChrg;	
        this.accesChrg = accesChrg;	
        this.expirationDate = expirationDate;	
    }
    private String ratePlanCd;	
    private String destinationCd;	
    private java.math.BigDecimal chrgParamId;	
    private java.sql.Date effectiveDate;	
    private java.sql.Date sysCreationDate;	
    private java.sql.Date sysUpdateDate;	
    private java.math.BigDecimal operatorId;	
    private String applicationId;	
    private String dlServiceCode;	
    private java.math.BigDecimal dlUpdateStamp;	
    private java.math.BigDecimal qualParam1Id;	
    private String qualParam1SetCd;	
    private java.math.BigDecimal qualParam2Id;	
    private String qualParam2SetCd;	
    private java.math.BigDecimal qualParam3Id;	
    private String qualParam3SetCd;	
    private java.math.BigDecimal qualParam4Id;	
    private String qualParam4SetCd;	
    private java.math.BigDecimal qualParam5Id;	
    private String qualParam5SetCd;	
    private java.math.BigDecimal qualParam6Id;	
    private String qualParam6SetCd;	
    private java.math.BigDecimal qualParam7Id;	
    private String qualParam7SetCd;	
    private java.math.BigDecimal destSortOrderCd;	
    private String ratesPresInd;	
    private String uom;	
    private java.math.BigDecimal minChrgParam;	
    private java.math.BigDecimal roundingUnit;	
    private java.math.BigDecimal ratingUnit;	
    private String rateSchemeInd;	
    private java.math.BigDecimal minChrg;	
    private String paramDspOrder;	
    private java.math.BigDecimal oneTimeChrg;	
    private java.math.BigDecimal accesChrg;	
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
    public java.math.BigDecimal getQualParam1Id() {
        return this.qualParam1Id;
    }		
    public void setQualParam1Id(java.math.BigDecimal qualParam1Id) {
        this.qualParam1Id = qualParam1Id;
    }
    public String getQualParam1SetCd() {
        return this.qualParam1SetCd;
    }		
    public void setQualParam1SetCd(String qualParam1SetCd) {
        this.qualParam1SetCd = qualParam1SetCd;
    }
    public java.math.BigDecimal getQualParam2Id() {
        return this.qualParam2Id;
    }		
    public void setQualParam2Id(java.math.BigDecimal qualParam2Id) {
        this.qualParam2Id = qualParam2Id;
    }
    public String getQualParam2SetCd() {
        return this.qualParam2SetCd;
    }		
    public void setQualParam2SetCd(String qualParam2SetCd) {
        this.qualParam2SetCd = qualParam2SetCd;
    }
    public java.math.BigDecimal getQualParam3Id() {
        return this.qualParam3Id;
    }		
    public void setQualParam3Id(java.math.BigDecimal qualParam3Id) {
        this.qualParam3Id = qualParam3Id;
    }
    public String getQualParam3SetCd() {
        return this.qualParam3SetCd;
    }		
    public void setQualParam3SetCd(String qualParam3SetCd) {
        this.qualParam3SetCd = qualParam3SetCd;
    }
    public java.math.BigDecimal getQualParam4Id() {
        return this.qualParam4Id;
    }		
    public void setQualParam4Id(java.math.BigDecimal qualParam4Id) {
        this.qualParam4Id = qualParam4Id;
    }
    public String getQualParam4SetCd() {
        return this.qualParam4SetCd;
    }		
    public void setQualParam4SetCd(String qualParam4SetCd) {
        this.qualParam4SetCd = qualParam4SetCd;
    }
    public java.math.BigDecimal getQualParam5Id() {
        return this.qualParam5Id;
    }		
    public void setQualParam5Id(java.math.BigDecimal qualParam5Id) {
        this.qualParam5Id = qualParam5Id;
    }
    public String getQualParam5SetCd() {
        return this.qualParam5SetCd;
    }		
    public void setQualParam5SetCd(String qualParam5SetCd) {
        this.qualParam5SetCd = qualParam5SetCd;
    }
    public java.math.BigDecimal getQualParam6Id() {
        return this.qualParam6Id;
    }		
    public void setQualParam6Id(java.math.BigDecimal qualParam6Id) {
        this.qualParam6Id = qualParam6Id;
    }
    public String getQualParam6SetCd() {
        return this.qualParam6SetCd;
    }		
    public void setQualParam6SetCd(String qualParam6SetCd) {
        this.qualParam6SetCd = qualParam6SetCd;
    }
    public java.math.BigDecimal getQualParam7Id() {
        return this.qualParam7Id;
    }		
    public void setQualParam7Id(java.math.BigDecimal qualParam7Id) {
        this.qualParam7Id = qualParam7Id;
    }
    public String getQualParam7SetCd() {
        return this.qualParam7SetCd;
    }		
    public void setQualParam7SetCd(String qualParam7SetCd) {
        this.qualParam7SetCd = qualParam7SetCd;
    }
    public java.math.BigDecimal getDestSortOrderCd() {
        return this.destSortOrderCd;
    }		
    public void setDestSortOrderCd(java.math.BigDecimal destSortOrderCd) {
        this.destSortOrderCd = destSortOrderCd;
    }
    public String getRatesPresInd() {
        return this.ratesPresInd;
    }		
    public void setRatesPresInd(String ratesPresInd) {
        this.ratesPresInd = ratesPresInd;
    }
    public String getUom() {
        return this.uom;
    }		
    public void setUom(String uom) {
        this.uom = uom;
    }
    public java.math.BigDecimal getMinChrgParam() {
        return this.minChrgParam;
    }		
    public void setMinChrgParam(java.math.BigDecimal minChrgParam) {
        this.minChrgParam = minChrgParam;
    }
    public java.math.BigDecimal getRoundingUnit() {
        return this.roundingUnit;
    }		
    public void setRoundingUnit(java.math.BigDecimal roundingUnit) {
        this.roundingUnit = roundingUnit;
    }
    public java.math.BigDecimal getRatingUnit() {
        return this.ratingUnit;
    }		
    public void setRatingUnit(java.math.BigDecimal ratingUnit) {
        this.ratingUnit = ratingUnit;
    }
    public String getRateSchemeInd() {
        return this.rateSchemeInd;
    }		
    public void setRateSchemeInd(String rateSchemeInd) {
        this.rateSchemeInd = rateSchemeInd;
    }
    public java.math.BigDecimal getMinChrg() {
        return this.minChrg;
    }		
    public void setMinChrg(java.math.BigDecimal minChrg) {
        this.minChrg = minChrg;
    }
    public String getParamDspOrder() {
        return this.paramDspOrder;
    }		
    public void setParamDspOrder(String paramDspOrder) {
        this.paramDspOrder = paramDspOrder;
    }
    public java.math.BigDecimal getOneTimeChrg() {
        return this.oneTimeChrg;
    }		
    public void setOneTimeChrg(java.math.BigDecimal oneTimeChrg) {
        this.oneTimeChrg = oneTimeChrg;
    }
    public java.math.BigDecimal getAccesChrg() {
        return this.accesChrg;
    }		
    public void setAccesChrg(java.math.BigDecimal accesChrg) {
        this.accesChrg = accesChrg;
    }
    public java.sql.Date getExpirationDate() {
        return this.expirationDate;
    }		
    public void setExpirationDate(java.sql.Date expirationDate) {
        this.expirationDate = expirationDate;
    }



    public String toString() {
        return super.toString() + "ratePlanCd=[" + ratePlanCd + "]\n" + "destinationCd=[" + destinationCd + "]\n" + "chrgParamId=[" + chrgParamId + "]\n" + "effectiveDate=[" + effectiveDate + "]\n" + "sysCreationDate=[" + sysCreationDate + "]\n" + "sysUpdateDate=[" + sysUpdateDate + "]\n" + "operatorId=[" + operatorId + "]\n" + "applicationId=[" + applicationId + "]\n" + "dlServiceCode=[" + dlServiceCode + "]\n" + "dlUpdateStamp=[" + dlUpdateStamp + "]\n" + "qualParam1Id=[" + qualParam1Id + "]\n" + "qualParam1SetCd=[" + qualParam1SetCd + "]\n" + "qualParam2Id=[" + qualParam2Id + "]\n" + "qualParam2SetCd=[" + qualParam2SetCd + "]\n" + "qualParam3Id=[" + qualParam3Id + "]\n" + "qualParam3SetCd=[" + qualParam3SetCd + "]\n" + "qualParam4Id=[" + qualParam4Id + "]\n" + "qualParam4SetCd=[" + qualParam4SetCd + "]\n" + "qualParam5Id=[" + qualParam5Id + "]\n" + "qualParam5SetCd=[" + qualParam5SetCd + "]\n" + "qualParam6Id=[" + qualParam6Id + "]\n" + "qualParam6SetCd=[" + qualParam6SetCd + "]\n" + "qualParam7Id=[" + qualParam7Id + "]\n" + "qualParam7SetCd=[" + qualParam7SetCd + "]\n" + "destSortOrderCd=[" + destSortOrderCd + "]\n" + "ratesPresInd=[" + ratesPresInd + "]\n" + "uom=[" + uom + "]\n" + "minChrgParam=[" + minChrgParam + "]\n" + "roundingUnit=[" + roundingUnit + "]\n" + "ratingUnit=[" + ratingUnit + "]\n" + "rateSchemeInd=[" + rateSchemeInd + "]\n" + "minChrg=[" + minChrg + "]\n" + "paramDspOrder=[" + paramDspOrder + "]\n" + "oneTimeChrg=[" + oneTimeChrg + "]\n" + "accesChrg=[" + accesChrg + "]\n" + "expirationDate=[" + expirationDate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof IcRatedDestination)) {
                return false;
        }
        IcRatedDestination that = (IcRatedDestination) obj;
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
        if (!(that.getQualParam1Id() == null ? this.getQualParam1Id() == null
                        : 0 == that.getQualParam1Id().compareTo(this.getQualParam1Id()))) {
                return false;
        }
        if (!(that.getQualParam1SetCd() == null ? this.getQualParam1SetCd() == null
                        : that.getQualParam1SetCd().equals(this.getQualParam1SetCd()))) {
                return false;
        }
        if (!(that.getQualParam2Id() == null ? this.getQualParam2Id() == null
                        : 0 == that.getQualParam2Id().compareTo(this.getQualParam2Id()))) {
                return false;
        }
        if (!(that.getQualParam2SetCd() == null ? this.getQualParam2SetCd() == null
                        : that.getQualParam2SetCd().equals(this.getQualParam2SetCd()))) {
                return false;
        }
        if (!(that.getQualParam3Id() == null ? this.getQualParam3Id() == null
                        : 0 == that.getQualParam3Id().compareTo(this.getQualParam3Id()))) {
                return false;
        }
        if (!(that.getQualParam3SetCd() == null ? this.getQualParam3SetCd() == null
                        : that.getQualParam3SetCd().equals(this.getQualParam3SetCd()))) {
                return false;
        }
        if (!(that.getQualParam4Id() == null ? this.getQualParam4Id() == null
                        : 0 == that.getQualParam4Id().compareTo(this.getQualParam4Id()))) {
                return false;
        }
        if (!(that.getQualParam4SetCd() == null ? this.getQualParam4SetCd() == null
                        : that.getQualParam4SetCd().equals(this.getQualParam4SetCd()))) {
                return false;
        }
        if (!(that.getQualParam5Id() == null ? this.getQualParam5Id() == null
                        : 0 == that.getQualParam5Id().compareTo(this.getQualParam5Id()))) {
                return false;
        }
        if (!(that.getQualParam5SetCd() == null ? this.getQualParam5SetCd() == null
                        : that.getQualParam5SetCd().equals(this.getQualParam5SetCd()))) {
                return false;
        }
        if (!(that.getQualParam6Id() == null ? this.getQualParam6Id() == null
                        : 0 == that.getQualParam6Id().compareTo(this.getQualParam6Id()))) {
                return false;
        }
        if (!(that.getQualParam6SetCd() == null ? this.getQualParam6SetCd() == null
                        : that.getQualParam6SetCd().equals(this.getQualParam6SetCd()))) {
                return false;
        }
        if (!(that.getQualParam7Id() == null ? this.getQualParam7Id() == null
                        : 0 == that.getQualParam7Id().compareTo(this.getQualParam7Id()))) {
                return false;
        }
        if (!(that.getQualParam7SetCd() == null ? this.getQualParam7SetCd() == null
                        : that.getQualParam7SetCd().equals(this.getQualParam7SetCd()))) {
                return false;
        }
        if (!(that.getDestSortOrderCd() == null ? this.getDestSortOrderCd() == null
                        : 0 == that.getDestSortOrderCd().compareTo(this.getDestSortOrderCd()))) {
                return false;
        }
        if (!(that.getRatesPresInd() == null ? this.getRatesPresInd() == null
                        : that.getRatesPresInd().equals(this.getRatesPresInd()))) {
                return false;
        }
        if (!(that.getUom() == null ? this.getUom() == null
                        : that.getUom().equals(this.getUom()))) {
                return false;
        }
        if (!(that.getMinChrgParam() == null ? this.getMinChrgParam() == null
                        : 0 == that.getMinChrgParam().compareTo(this.getMinChrgParam()))) {
                return false;
        }
        if (!(that.getRoundingUnit() == null ? this.getRoundingUnit() == null
                        : 0 == that.getRoundingUnit().compareTo(this.getRoundingUnit()))) {
                return false;
        }
        if (!(that.getRatingUnit() == null ? this.getRatingUnit() == null
                        : 0 == that.getRatingUnit().compareTo(this.getRatingUnit()))) {
                return false;
        }
        if (!(that.getRateSchemeInd() == null ? this.getRateSchemeInd() == null
                        : that.getRateSchemeInd().equals(this.getRateSchemeInd()))) {
                return false;
        }
        if (!(that.getMinChrg() == null ? this.getMinChrg() == null
                        : 0 == that.getMinChrg().compareTo(this.getMinChrg()))) {
                return false;
        }
        if (!(that.getParamDspOrder() == null ? this.getParamDspOrder() == null
                        : that.getParamDspOrder().equals(this.getParamDspOrder()))) {
                return false;
        }
        if (!(that.getOneTimeChrg() == null ? this.getOneTimeChrg() == null
                        : 0 == that.getOneTimeChrg().compareTo(this.getOneTimeChrg()))) {
                return false;
        }
        if (!(that.getAccesChrg() == null ? this.getAccesChrg() == null
                        : 0 == that.getAccesChrg().compareTo(this.getAccesChrg()))) {
                return false;
        }
        if (!(that.getExpirationDate() == null ? this.getExpirationDate() == null
                        : that.getExpirationDate().equals(this.getExpirationDate()))) {
                return false;
        }
    return true;
    }

}
