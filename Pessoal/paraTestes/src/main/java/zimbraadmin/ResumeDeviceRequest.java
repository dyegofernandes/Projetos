
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import zimbra.AccountSelector;


/**
 * <p>Classe Java de resumeDeviceRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="resumeDeviceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="account" type="{urn:zimbra}accountSelector"/>
 *         &lt;element name="device" type="{urn:zimbraAdmin}deviceId" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resumeDeviceRequest", propOrder = {
    "account",
    "device"
})
public class ResumeDeviceRequest {

    @XmlElement(required = true)
    protected AccountSelector account;
    protected DeviceId device;

    /**
     * Obtém o valor da propriedade account.
     * 
     * @return
     *     possible object is
     *     {@link AccountSelector }
     *     
     */
    public AccountSelector getAccount() {
        return account;
    }

    /**
     * Define o valor da propriedade account.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountSelector }
     *     
     */
    public void setAccount(AccountSelector value) {
        this.account = value;
    }

    /**
     * Obtém o valor da propriedade device.
     * 
     * @return
     *     possible object is
     *     {@link DeviceId }
     *     
     */
    public DeviceId getDevice() {
        return device;
    }

    /**
     * Define o valor da propriedade device.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceId }
     *     
     */
    public void setDevice(DeviceId value) {
        this.device = value;
    }

}
