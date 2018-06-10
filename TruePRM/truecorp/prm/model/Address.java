/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.model;

/**
 *
 * @author Jennarong Pinjai
 */
public class Address {
    
    private String address;
    private String destinationCd;
    private String description;
    private String cost;
    private String rateCdSeq;
    private String billingNameSeq; //Sequence_No

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getDestinationCd() {
        return destinationCd;
    }

    public void setDestinationCd(String destinationCd) {
        this.destinationCd = destinationCd;
    }

    public String getRateCdSeq() {
        return rateCdSeq;
    }

    public void setRateCdSeq(String rateCdSeq) {
        this.rateCdSeq = rateCdSeq;
    }

    public String getBillingNameSeq() {
        return billingNameSeq;
    }

    public void setBillingNameSeq(String billingNameSeq) {
        this.billingNameSeq = billingNameSeq;
    }
    
    
    
    
}
