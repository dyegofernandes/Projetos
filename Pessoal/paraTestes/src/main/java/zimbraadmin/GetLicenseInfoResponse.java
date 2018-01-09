
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getLicenseInfoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getLicenseInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="expiration" type="{urn:zimbraAdmin}licenseExpirationInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLicenseInfoResponse", propOrder = {
    "expiration"
})
public class GetLicenseInfoResponse {

    @XmlElement(required = true)
    protected LicenseExpirationInfo expiration;

    /**
     * Obtém o valor da propriedade expiration.
     * 
     * @return
     *     possible object is
     *     {@link LicenseExpirationInfo }
     *     
     */
    public LicenseExpirationInfo getExpiration() {
        return expiration;
    }

    /**
     * Define o valor da propriedade expiration.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseExpirationInfo }
     *     
     */
    public void setExpiration(LicenseExpirationInfo value) {
        this.expiration = value;
    }

}
