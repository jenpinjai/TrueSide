/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecorp.prm.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jennarong Pinjai
 */
public class TransactionPartner {
    
    private boolean ealyMonth = false;
    private String  partnerCd;
    private String  prmCd; //From mappping of  partnerCd, first 2 word file name and Titic table
    private String  serviceType;
    private String  ratePlanCode;
    private String  fileName;
    private String  controlFileName;
    private List<RateSheet> rateSheetList = new ArrayList<RateSheet>();
    private List<Destination> destinationList = new ArrayList<Destination>();

    public String getPartnerCd() {
        return partnerCd;
    }

    public void setPartnerCd(String partnerCd) {
        this.partnerCd = partnerCd;
    }

    public String getPrmCd() {
        return prmCd;
    }

    public void setPrmCd(String prmCd) {
        this.prmCd = prmCd;
    }

    public List<RateSheet> getRateSheetList() {
        return rateSheetList;
    }

    public void setRateSheetList(List<RateSheet> rateSheetList) {
        this.rateSheetList = rateSheetList;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public boolean isEalyMonth() {
        return ealyMonth;
    }

    public void setEalyMonth(boolean ealyMonth) {
        this.ealyMonth = ealyMonth;
    }

    public List<Destination> getDestinationList() {
        return destinationList;
    }

    public void setDestinationList(List<Destination> destinationList) {
        this.destinationList = destinationList;
    }

    public String getRatePlanCode() {
        return ratePlanCode;
    }

    public void setRatePlanCode(String ratePlanCode) {
        this.ratePlanCode = ratePlanCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getControlFileName() {
        return controlFileName;
    }

    public void setControlFileName(String controlFileName) {
        this.controlFileName = controlFileName;
    }

    
}
