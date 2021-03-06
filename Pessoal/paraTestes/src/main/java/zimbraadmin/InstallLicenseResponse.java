
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de installLicenseResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="installLicenseResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="validFrom" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="validUntil" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="serverTime" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "installLicenseResponse")
public class InstallLicenseResponse {

    @XmlAttribute(name = "validFrom", required = true)
    protected long validFrom;
    @XmlAttribute(name = "validUntil", required = true)
    protected long validUntil;
    @XmlAttribute(name = "serverTime", required = true)
    protected long serverTime;

    /**
     * Obtém o valor da propriedade validFrom.
     * 
     */
    public long getValidFrom() {
        return validFrom;
    }

    /**
     * Define o valor da propriedade validFrom.
     * 
     */
    public void setValidFrom(long value) {
        this.validFrom = value;
    }

    /**
     * Obtém o valor da propriedade validUntil.
     * 
     */
    public long getValidUntil() {
        return validUntil;
    }

    /**
     * Define o valor da propriedade validUntil.
     * 
     */
    public void setValidUntil(long value) {
        this.validUntil = value;
    }

    /**
     * Obtém o valor da propriedade serverTime.
     * 
     */
    public long getServerTime() {
        return serverTime;
    }

    /**
     * Define o valor da propriedade serverTime.
     * 
     */
    public void setServerTime(long value) {
        this.serverTime = value;
    }

}
