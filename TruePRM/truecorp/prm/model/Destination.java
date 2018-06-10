/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.model;

import java.util.Date;

/**
 *
 * @author Jennarong Pinjai
 */
public class Destination {
    
    private String code;
    private String ratePlanCode;
    private Date   effectiveDate;
    private int sequenceNo;
    private Country country;
    private RateCodePack rateCodePack;
    private String minCharge;
    private String roundingUnit;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public RateCodePack getRateCodePack() {
        return rateCodePack;
    }

    public void setRateCodePack(RateCodePack rateCodePack) {
        this.rateCodePack = rateCodePack;
    }

    public String getRatePlanCode() {
        return ratePlanCode;
    }

    public void setRatePlanCode(String ratePlanCode) {
        this.ratePlanCode = ratePlanCode;
    }

    public String getMinCharge() {
        return minCharge;
    }

    public void setMinCharge(String minCharge) {
        this.minCharge = minCharge;
    }

    public String getRoundingUnit() {
        return roundingUnit;
    }

    public void setRoundingUnit(String roundingUnit) {
        this.roundingUnit = roundingUnit;
    }
    
    
}
