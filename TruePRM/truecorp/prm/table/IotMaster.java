
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class IotMaster implements Serializable {
    
    /** Creates a new instance of IotMaster */
    public IotMaster() {
    }
    public IotMaster(
            String direction	
            , String myTadig	
            , String countryName	
            , String operatorName	
            , String theirTadig	
            , String yearTadig	
            , String monthTadig	
            , String typeTadig	
            , java.math.BigDecimal callTadig	
            , java.math.BigDecimal realDuration	
            , java.math.BigDecimal realGprs	
            , java.math.BigDecimal roundTadig	
            , java.math.BigDecimal chargeLocal	
            , java.math.BigDecimal chargeSdr	
            , String callCountry	
            , String desType	
            , java.math.BigDecimal volumeReal	
            , java.math.BigDecimal volumeRound	
            , String groupTadig	
            , String currencyIot	
            , String volumn	
            , String rateType	
            , java.math.BigDecimal rateIotCurrency	
            , java.math.BigDecimal iotSdr	
            , java.math.BigDecimal rateIotThai	
            , java.math.BigDecimal net	
            , java.math.BigDecimal discount	
            , java.math.BigDecimal tapRate	
            , String tapIm	
            , java.math.BigDecimal realNet	
            , java.math.BigDecimal thbSdr	
            , java.math.BigDecimal revSdr	
            , java.math.BigDecimal dn	
            , java.math.BigDecimal cn	
            , java.math.BigDecimal commitment	
            , java.sql.Date sysCreationDate	
            , java.sql.Date sysUpdateDate	
            , java.math.BigDecimal operatorId	
            , String applicationId	
            , String dlServiceCode	
            , java.math.BigDecimal dlUpdateStamp	
            , String agreementId	
            , String plmnGroupId	
        ) {
        this.direction = direction;	
        this.myTadig = myTadig;	
        this.countryName = countryName;	
        this.operatorName = operatorName;	
        this.theirTadig = theirTadig;	
        this.yearTadig = yearTadig;	
        this.monthTadig = monthTadig;	
        this.typeTadig = typeTadig;	
        this.callTadig = callTadig;	
        this.realDuration = realDuration;	
        this.realGprs = realGprs;	
        this.roundTadig = roundTadig;	
        this.chargeLocal = chargeLocal;	
        this.chargeSdr = chargeSdr;	
        this.callCountry = callCountry;	
        this.desType = desType;	
        this.volumeReal = volumeReal;	
        this.volumeRound = volumeRound;	
        this.groupTadig = groupTadig;	
        this.currencyIot = currencyIot;	
        this.volumn = volumn;	
        this.rateType = rateType;	
        this.rateIotCurrency = rateIotCurrency;	
        this.iotSdr = iotSdr;	
        this.rateIotThai = rateIotThai;	
        this.net = net;	
        this.discount = discount;	
        this.tapRate = tapRate;	
        this.tapIm = tapIm;	
        this.realNet = realNet;	
        this.thbSdr = thbSdr;	
        this.revSdr = revSdr;	
        this.dn = dn;	
        this.cn = cn;	
        this.commitment = commitment;	
        this.sysCreationDate = sysCreationDate;	
        this.sysUpdateDate = sysUpdateDate;	
        this.operatorId = operatorId;	
        this.applicationId = applicationId;	
        this.dlServiceCode = dlServiceCode;	
        this.dlUpdateStamp = dlUpdateStamp;	
        this.agreementId = agreementId;	
        this.plmnGroupId = plmnGroupId;	
    }
    private String direction;	
    private String myTadig;	
    private String countryName;	
    private String operatorName;	
    private String theirTadig;	
    private String yearTadig;	
    private String monthTadig;	
    private String typeTadig;	
    private java.math.BigDecimal callTadig;	
    private java.math.BigDecimal realDuration;	
    private java.math.BigDecimal realGprs;	
    private java.math.BigDecimal roundTadig;	
    private java.math.BigDecimal chargeLocal;	
    private java.math.BigDecimal chargeSdr;	
    private String callCountry;	
    private String desType;	
    private java.math.BigDecimal volumeReal;	
    private java.math.BigDecimal volumeRound;	
    private String groupTadig;	
    private String currencyIot;	
    private String volumn;	
    private String rateType;	
    private java.math.BigDecimal rateIotCurrency;	
    private java.math.BigDecimal iotSdr;	
    private java.math.BigDecimal rateIotThai;	
    private java.math.BigDecimal net;	
    private java.math.BigDecimal discount;	
    private java.math.BigDecimal tapRate;	
    private String tapIm;	
    private java.math.BigDecimal realNet;	
    private java.math.BigDecimal thbSdr;	
    private java.math.BigDecimal revSdr;	
    private java.math.BigDecimal dn;	
    private java.math.BigDecimal cn;	
    private java.math.BigDecimal commitment;	
    private java.sql.Date sysCreationDate;	
    private java.sql.Date sysUpdateDate;	
    private java.math.BigDecimal operatorId;	
    private String applicationId;	
    private String dlServiceCode;	
    private java.math.BigDecimal dlUpdateStamp;	
    private String agreementId;	
    private String plmnGroupId;	



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
    public java.math.BigDecimal getCallTadig() {
        return this.callTadig;
    }		
    public void setCallTadig(java.math.BigDecimal callTadig) {
        this.callTadig = callTadig;
    }
    public java.math.BigDecimal getRealDuration() {
        return this.realDuration;
    }		
    public void setRealDuration(java.math.BigDecimal realDuration) {
        this.realDuration = realDuration;
    }
    public java.math.BigDecimal getRealGprs() {
        return this.realGprs;
    }		
    public void setRealGprs(java.math.BigDecimal realGprs) {
        this.realGprs = realGprs;
    }
    public java.math.BigDecimal getRoundTadig() {
        return this.roundTadig;
    }		
    public void setRoundTadig(java.math.BigDecimal roundTadig) {
        this.roundTadig = roundTadig;
    }
    public java.math.BigDecimal getChargeLocal() {
        return this.chargeLocal;
    }		
    public void setChargeLocal(java.math.BigDecimal chargeLocal) {
        this.chargeLocal = chargeLocal;
    }
    public java.math.BigDecimal getChargeSdr() {
        return this.chargeSdr;
    }		
    public void setChargeSdr(java.math.BigDecimal chargeSdr) {
        this.chargeSdr = chargeSdr;
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
    public java.math.BigDecimal getVolumeReal() {
        return this.volumeReal;
    }		
    public void setVolumeReal(java.math.BigDecimal volumeReal) {
        this.volumeReal = volumeReal;
    }
    public java.math.BigDecimal getVolumeRound() {
        return this.volumeRound;
    }		
    public void setVolumeRound(java.math.BigDecimal volumeRound) {
        this.volumeRound = volumeRound;
    }
    public String getGroupTadig() {
        return this.groupTadig;
    }		
    public void setGroupTadig(String groupTadig) {
        this.groupTadig = groupTadig;
    }
    public String getCurrencyIot() {
        return this.currencyIot;
    }		
    public void setCurrencyIot(String currencyIot) {
        this.currencyIot = currencyIot;
    }
    public String getVolumn() {
        return this.volumn;
    }		
    public void setVolumn(String volumn) {
        this.volumn = volumn;
    }
    public String getRateType() {
        return this.rateType;
    }		
    public void setRateType(String rateType) {
        this.rateType = rateType;
    }
    public java.math.BigDecimal getRateIotCurrency() {
        return this.rateIotCurrency;
    }		
    public void setRateIotCurrency(java.math.BigDecimal rateIotCurrency) {
        this.rateIotCurrency = rateIotCurrency;
    }
    public java.math.BigDecimal getIotSdr() {
        return this.iotSdr;
    }		
    public void setIotSdr(java.math.BigDecimal iotSdr) {
        this.iotSdr = iotSdr;
    }
    public java.math.BigDecimal getRateIotThai() {
        return this.rateIotThai;
    }		
    public void setRateIotThai(java.math.BigDecimal rateIotThai) {
        this.rateIotThai = rateIotThai;
    }
    public java.math.BigDecimal getNet() {
        return this.net;
    }		
    public void setNet(java.math.BigDecimal net) {
        this.net = net;
    }
    public java.math.BigDecimal getDiscount() {
        return this.discount;
    }		
    public void setDiscount(java.math.BigDecimal discount) {
        this.discount = discount;
    }
    public java.math.BigDecimal getTapRate() {
        return this.tapRate;
    }		
    public void setTapRate(java.math.BigDecimal tapRate) {
        this.tapRate = tapRate;
    }
    public String getTapIm() {
        return this.tapIm;
    }		
    public void setTapIm(String tapIm) {
        this.tapIm = tapIm;
    }
    public java.math.BigDecimal getRealNet() {
        return this.realNet;
    }		
    public void setRealNet(java.math.BigDecimal realNet) {
        this.realNet = realNet;
    }
    public java.math.BigDecimal getThbSdr() {
        return this.thbSdr;
    }		
    public void setThbSdr(java.math.BigDecimal thbSdr) {
        this.thbSdr = thbSdr;
    }
    public java.math.BigDecimal getRevSdr() {
        return this.revSdr;
    }		
    public void setRevSdr(java.math.BigDecimal revSdr) {
        this.revSdr = revSdr;
    }
    public java.math.BigDecimal getDn() {
        return this.dn;
    }		
    public void setDn(java.math.BigDecimal dn) {
        this.dn = dn;
    }
    public java.math.BigDecimal getCn() {
        return this.cn;
    }		
    public void setCn(java.math.BigDecimal cn) {
        this.cn = cn;
    }
    public java.math.BigDecimal getCommitment() {
        return this.commitment;
    }		
    public void setCommitment(java.math.BigDecimal commitment) {
        this.commitment = commitment;
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
    public String getAgreementId() {
        return this.agreementId;
    }		
    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }
    public String getPlmnGroupId() {
        return this.plmnGroupId;
    }		
    public void setPlmnGroupId(String plmnGroupId) {
        this.plmnGroupId = plmnGroupId;
    }



    public String toString() {
        return super.toString() + "direction=[" + direction + "]\n" + "myTadig=[" + myTadig + "]\n" + "countryName=[" + countryName + "]\n" + "operatorName=[" + operatorName + "]\n" + "theirTadig=[" + theirTadig + "]\n" + "yearTadig=[" + yearTadig + "]\n" + "monthTadig=[" + monthTadig + "]\n" + "typeTadig=[" + typeTadig + "]\n" + "callTadig=[" + callTadig + "]\n" + "realDuration=[" + realDuration + "]\n" + "realGprs=[" + realGprs + "]\n" + "roundTadig=[" + roundTadig + "]\n" + "chargeLocal=[" + chargeLocal + "]\n" + "chargeSdr=[" + chargeSdr + "]\n" + "callCountry=[" + callCountry + "]\n" + "desType=[" + desType + "]\n" + "volumeReal=[" + volumeReal + "]\n" + "volumeRound=[" + volumeRound + "]\n" + "groupTadig=[" + groupTadig + "]\n" + "currencyIot=[" + currencyIot + "]\n" + "volumn=[" + volumn + "]\n" + "rateType=[" + rateType + "]\n" + "rateIotCurrency=[" + rateIotCurrency + "]\n" + "iotSdr=[" + iotSdr + "]\n" + "rateIotThai=[" + rateIotThai + "]\n" + "net=[" + net + "]\n" + "discount=[" + discount + "]\n" + "tapRate=[" + tapRate + "]\n" + "tapIm=[" + tapIm + "]\n" + "realNet=[" + realNet + "]\n" + "thbSdr=[" + thbSdr + "]\n" + "revSdr=[" + revSdr + "]\n" + "dn=[" + dn + "]\n" + "cn=[" + cn + "]\n" + "commitment=[" + commitment + "]\n" + "sysCreationDate=[" + sysCreationDate + "]\n" + "sysUpdateDate=[" + sysUpdateDate + "]\n" + "operatorId=[" + operatorId + "]\n" + "applicationId=[" + applicationId + "]\n" + "dlServiceCode=[" + dlServiceCode + "]\n" + "dlUpdateStamp=[" + dlUpdateStamp + "]\n" + "agreementId=[" + agreementId + "]\n" + "plmnGroupId=[" + plmnGroupId + "]\n";
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
        if (!(that.getCallTadig() == null ? this.getCallTadig() == null
                        : 0 == that.getCallTadig().compareTo(this.getCallTadig()))) {
                return false;
        }
        if (!(that.getRealDuration() == null ? this.getRealDuration() == null
                        : 0 == that.getRealDuration().compareTo(this.getRealDuration()))) {
                return false;
        }
        if (!(that.getRealGprs() == null ? this.getRealGprs() == null
                        : 0 == that.getRealGprs().compareTo(this.getRealGprs()))) {
                return false;
        }
        if (!(that.getRoundTadig() == null ? this.getRoundTadig() == null
                        : 0 == that.getRoundTadig().compareTo(this.getRoundTadig()))) {
                return false;
        }
        if (!(that.getChargeLocal() == null ? this.getChargeLocal() == null
                        : 0 == that.getChargeLocal().compareTo(this.getChargeLocal()))) {
                return false;
        }
        if (!(that.getChargeSdr() == null ? this.getChargeSdr() == null
                        : 0 == that.getChargeSdr().compareTo(this.getChargeSdr()))) {
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
        if (!(that.getVolumeReal() == null ? this.getVolumeReal() == null
                        : 0 == that.getVolumeReal().compareTo(this.getVolumeReal()))) {
                return false;
        }
        if (!(that.getVolumeRound() == null ? this.getVolumeRound() == null
                        : 0 == that.getVolumeRound().compareTo(this.getVolumeRound()))) {
                return false;
        }
        if (!(that.getGroupTadig() == null ? this.getGroupTadig() == null
                        : that.getGroupTadig().equals(this.getGroupTadig()))) {
                return false;
        }
        if (!(that.getCurrencyIot() == null ? this.getCurrencyIot() == null
                        : that.getCurrencyIot().equals(this.getCurrencyIot()))) {
                return false;
        }
        if (!(that.getVolumn() == null ? this.getVolumn() == null
                        : that.getVolumn().equals(this.getVolumn()))) {
                return false;
        }
        if (!(that.getRateType() == null ? this.getRateType() == null
                        : that.getRateType().equals(this.getRateType()))) {
                return false;
        }
        if (!(that.getRateIotCurrency() == null ? this.getRateIotCurrency() == null
                        : 0 == that.getRateIotCurrency().compareTo(this.getRateIotCurrency()))) {
                return false;
        }
        if (!(that.getIotSdr() == null ? this.getIotSdr() == null
                        : 0 == that.getIotSdr().compareTo(this.getIotSdr()))) {
                return false;
        }
        if (!(that.getRateIotThai() == null ? this.getRateIotThai() == null
                        : 0 == that.getRateIotThai().compareTo(this.getRateIotThai()))) {
                return false;
        }
        if (!(that.getNet() == null ? this.getNet() == null
                        : 0 == that.getNet().compareTo(this.getNet()))) {
                return false;
        }
        if (!(that.getDiscount() == null ? this.getDiscount() == null
                        : 0 == that.getDiscount().compareTo(this.getDiscount()))) {
                return false;
        }
        if (!(that.getTapRate() == null ? this.getTapRate() == null
                        : 0 == that.getTapRate().compareTo(this.getTapRate()))) {
                return false;
        }
        if (!(that.getTapIm() == null ? this.getTapIm() == null
                        : that.getTapIm().equals(this.getTapIm()))) {
                return false;
        }
        if (!(that.getRealNet() == null ? this.getRealNet() == null
                        : 0 == that.getRealNet().compareTo(this.getRealNet()))) {
                return false;
        }
        if (!(that.getThbSdr() == null ? this.getThbSdr() == null
                        : 0 == that.getThbSdr().compareTo(this.getThbSdr()))) {
                return false;
        }
        if (!(that.getRevSdr() == null ? this.getRevSdr() == null
                        : 0 == that.getRevSdr().compareTo(this.getRevSdr()))) {
                return false;
        }
        if (!(that.getDn() == null ? this.getDn() == null
                        : 0 == that.getDn().compareTo(this.getDn()))) {
                return false;
        }
        if (!(that.getCn() == null ? this.getCn() == null
                        : 0 == that.getCn().compareTo(this.getCn()))) {
                return false;
        }
        if (!(that.getCommitment() == null ? this.getCommitment() == null
                        : 0 == that.getCommitment().compareTo(this.getCommitment()))) {
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
        if (!(that.getAgreementId() == null ? this.getAgreementId() == null
                        : that.getAgreementId().equals(this.getAgreementId()))) {
                return false;
        }
        if (!(that.getPlmnGroupId() == null ? this.getPlmnGroupId() == null
                        : that.getPlmnGroupId().equals(this.getPlmnGroupId()))) {
                return false;
        }
    return true;
    }

}
