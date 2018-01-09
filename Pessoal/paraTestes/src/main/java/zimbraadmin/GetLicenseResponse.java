
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getLicenseResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getLicenseResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="license" type="{urn:zimbraAdmin}adminAttrsImpl"/>
 *         &lt;element name="activation" type="{urn:zimbraAdmin}adminAttrsImpl" minOccurs="0"/>
 *         &lt;element name="info" type="{urn:zimbraAdmin}adminAttrsImpl"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLicenseResponse", propOrder = {

})
public class GetLicenseResponse {

    @XmlElement(required = true)
    protected AdminAttrsImpl license;
    protected AdminAttrsImpl activation;
    @XmlElement(required = true)
    protected AdminAttrsImpl info;

    /**
     * Obtém o valor da propriedade license.
     * 
     * @return
     *     possible object is
     *     {@link AdminAttrsImpl }
     *     
     */
    public AdminAttrsImpl getLicense() {
        return license;
    }

    /**
     * Define o valor da propriedade license.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminAttrsImpl }
     *     
     */
    public void setLicense(AdminAttrsImpl value) {
        this.license = value;
    }

    /**
     * Obtém o valor da propriedade activation.
     * 
     * @return
     *     possible object is
     *     {@link AdminAttrsImpl }
     *     
     */
    public AdminAttrsImpl getActivation() {
        return activation;
    }

    /**
     * Define o valor da propriedade activation.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminAttrsImpl }
     *     
     */
    public void setActivation(AdminAttrsImpl value) {
        this.activation = value;
    }

    /**
     * Obtém o valor da propriedade info.
     * 
     * @return
     *     possible object is
     *     {@link AdminAttrsImpl }
     *     
     */
    public AdminAttrsImpl getInfo() {
        return info;
    }

    /**
     * Define o valor da propriedade info.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminAttrsImpl }
     *     
     */
    public void setInfo(AdminAttrsImpl value) {
        this.info = value;
    }

}
