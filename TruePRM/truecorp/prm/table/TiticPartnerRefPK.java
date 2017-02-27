
package truecorp.prm.table;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TiticPartnerRefPK  implements Serializable {
    
    /** Creates a new instance of TiticPartnerRef */
    public TiticPartnerRefPK(
            String productCd	
            , String partnerCd	
            , String prmCd	
        ) {
        this.productCd = productCd;	
        this.partnerCd = partnerCd;	
        this.prmCd = prmCd;	
    }
    private String productCd;	
    private String partnerCd;	
    private String prmCd;	

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

    public String toString() {
        return super.toString() + " " + productCd + " " + partnerCd + " " + prmCd;
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
    return true;
    }

}
