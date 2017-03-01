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
public class RateSheet {
    
    private String prmPartnerCd;
    private String prefix;
    private String description;
    private String cost;
    private Date effective;
    private String serviceType;
    private String minChrg;
    private String roundingUnit;
    private String isChange;

    public String getPrmPartnerCd() {
        return prmPartnerCd;
    }

    public void setPrmPartnerCd(String prmPartnerCd) {
        this.prmPartnerCd = prmPartnerCd;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Date getEffective() {
        return effective;
    }

    public void setEffective(Date effective) {
        this.effective = effective;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getMinChrg() {
        return minChrg;
    }

    public void setMinChrg(String minChrg) {
        this.minChrg = minChrg;
    }

    public String getRoundingUnit() {
        return roundingUnit;
    }

    public void setRoundingUnit(String roundingUnit) {
        this.roundingUnit = roundingUnit;
    }

    public String getIsChange() {
        return isChange;
    }

    public void setIsChange(String isChange) {
        this.isChange = isChange;
    }
    
    
}
