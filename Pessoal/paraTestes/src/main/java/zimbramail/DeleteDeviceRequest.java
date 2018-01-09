
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import zimbra.Id;


/**
 * <p>Classe Java de deleteDeviceRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="deleteDeviceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="device" type="{urn:zimbra}id"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteDeviceRequest", propOrder = {
    "device"
})
public class DeleteDeviceRequest {

    @XmlElement(required = true)
    protected Id device;

    /**
     * Obtém o valor da propriedade device.
     * 
     * @return
     *     possible object is
     *     {@link Id }
     *     
     */
    public Id getDevice() {
        return device;
    }

    /**
     * Define o valor da propriedade device.
     * 
     * @param value
     *     allowed object is
     *     {@link Id }
     *     
     */
    public void setDevice(Id value) {
        this.device = value;
    }

}
