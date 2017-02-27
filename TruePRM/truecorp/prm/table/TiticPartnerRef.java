
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TiticPartnerRef implements Serializable {
    
    /** Creates a new instance of TiticPartnerRef */
    public TiticPartnerRef() {
    }
    public TiticPartnerRef(
            String productCd	
            , String partnerCd	
            , String prmCd	
            , String partnerName	
            , java.sql.Date sysCreationDate	
            , java.sql.Date sysUpdateDate	
        ) {
        this.productCd = productCd;	
        this.partnerCd = partnerCd;	
        this.prmCd = prmCd;	
        this.partnerName = partnerName;	
        this.sysCreationDate = sysCreationDate;	
        this.sysUpdateDate = sysUpdateDate;	
    }
    private String productCd;	
    private String partnerCd;	
    private String prmCd;	
    private String partnerName;	
    private java.sql.Date sysCreationDate;	
    private java.sql.Date sysUpdateDate;	



    public String getProductCd() {
        return this.productCd;
    }		
    public void setProductCd(String productCd) {
        this.productCd = productCd;
    }
    public String getPartnerCd() {
        return this.partnerCd;
    }		
    public void setPartnerCd(String partnerCd) {
        this.partnerCd = partnerCd;
    }
    public String getPrmCd() {
        return this.prmCd;
    }		
    public void setPrmCd(String prmCd) {
        this.prmCd = prmCd;
    }
    public String getPartnerName() {
        return this.partnerName;
    }		
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
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



    public String toString() {
        return super.toString() + "productCd=[" + productCd + "]\n" + "partnerCd=[" + partnerCd + "]\n" + "prmCd=[" + prmCd + "]\n" + "partnerName=[" + partnerName + "]\n" + "sysCreationDate=[" + sysCreationDate + "]\n" + "sysUpdateDate=[" + sysUpdateDate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TiticPartnerRef)) {
                return false;
        }
        TiticPartnerRef that = (TiticPartnerRef) obj;
        if (!(that.getProductCd() == null ? this.getProductCd() == null
                        : that.getProductCd().equals(this.getProductCd()))) {
                return false;
        }
        if (!(that.getPartnerCd() == null ? this.getPartnerCd() == null
                        : that.getPartnerCd().equals(this.getPartnerCd()))) {
                return false;
        }
        if (!(that.getPrmCd() == null ? this.getPrmCd() == null
                        : that.getPrmCd().equals(this.getPrmCd()))) {
                return false;
        }
        if (!(that.getPartnerName() == null ? this.getPartnerName() == null
                        : that.getPartnerName().equals(this.getPartnerName()))) {
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
    return true;
    }

}
