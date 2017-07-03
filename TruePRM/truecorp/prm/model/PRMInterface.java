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
public class PRMInterface {
    private String accountId;
    private String productType;
    private String productId;
    private String pymSeqNo;
    private String featureCode;
    private String revenueCode;
    private Date   actvDate;
    private String actvCode;
    private String actvAmt;
    private String taxAmt;
    private String phaseCode;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPymSeqNo() {
        return pymSeqNo;
    }

    public void setPymSeqNo(String pymSeqNo) {
        this.pymSeqNo = pymSeqNo;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getRevenueCode() {
        return revenueCode;
    }

    public void setRevenueCode(String revenueCode) {
        this.revenueCode = revenueCode;
    }

    public Date getActvDate() {
        return actvDate;
    }

    public void setActvDate(Date actvDate) {
        this.actvDate = actvDate;
    }

    public String getActvCode() {
        return actvCode;
    }

    public void setActvCode(String actvCode) {
        this.actvCode = actvCode;
    }

    public String getActvAmt() {
        return actvAmt;
    }

    public void setActvAmt(String actvAmt) {
        this.actvAmt = actvAmt;
    }

    public String getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(String taxAmt) {
        this.taxAmt = taxAmt;
    }

    

    public String getPhaseCode() {
        return phaseCode;
    }

    public void setPhaseCode(String phaseCode) {
        this.phaseCode = phaseCode;
    }
    
    
    
}
