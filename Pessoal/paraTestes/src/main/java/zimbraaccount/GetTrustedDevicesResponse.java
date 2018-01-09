
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getTrustedDevicesResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getTrustedDevicesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="nOtherDevices" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="thisDeviceTrusted" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTrustedDevicesResponse")
public class GetTrustedDevicesResponse {

    @XmlAttribute(name = "nOtherDevices")
    protected Integer nOtherDevices;
    @XmlAttribute(name = "thisDeviceTrusted")
    protected Boolean thisDeviceTrusted;

    /**
     * Obtém o valor da propriedade nOtherDevices.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNOtherDevices() {
        return nOtherDevices;
    }

    /**
     * Define o valor da propriedade nOtherDevices.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNOtherDevices(Integer value) {
        this.nOtherDevices = value;
    }

    /**
     * Obtém o valor da propriedade thisDeviceTrusted.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isThisDeviceTrusted() {
        return thisDeviceTrusted;
    }

    /**
     * Define o valor da propriedade thisDeviceTrusted.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setThisDeviceTrusted(Boolean value) {
        this.thisDeviceTrusted = value;
    }

}
