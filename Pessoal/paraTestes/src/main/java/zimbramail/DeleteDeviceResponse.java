
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de deleteDeviceResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="deleteDeviceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="device" type="{urn:zimbraMail}nameId"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteDeviceResponse", propOrder = {
    "device"
})
public class DeleteDeviceResponse {

    @XmlElement(required = true)
    protected NameId device;

    /**
     * Obtém o valor da propriedade device.
     * 
     * @return
     *     possible object is
     *     {@link NameId }
     *     
     */
    public NameId getDevice() {
        return device;
    }

    /**
     * Define o valor da propriedade device.
     * 
     * @param value
     *     allowed object is
     *     {@link NameId }
     *     
     */
    public void setDevice(NameId value) {
        this.device = value;
    }

}
