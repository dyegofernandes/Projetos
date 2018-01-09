
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de registerMobileGatewayAppRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="registerMobileGatewayAppRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zmgDevice" type="{urn:zimbraAccount}zmgDeviceSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerMobileGatewayAppRequest", propOrder = {
    "zmgDevice"
})
public class RegisterMobileGatewayAppRequest {

    @XmlElement(required = true)
    protected ZmgDeviceSpec zmgDevice;

    /**
     * Obtém o valor da propriedade zmgDevice.
     * 
     * @return
     *     possible object is
     *     {@link ZmgDeviceSpec }
     *     
     */
    public ZmgDeviceSpec getZmgDevice() {
        return zmgDevice;
    }

    /**
     * Define o valor da propriedade zmgDevice.
     * 
     * @param value
     *     allowed object is
     *     {@link ZmgDeviceSpec }
     *     
     */
    public void setZmgDevice(ZmgDeviceSpec value) {
        this.zmgDevice = value;
    }

}
