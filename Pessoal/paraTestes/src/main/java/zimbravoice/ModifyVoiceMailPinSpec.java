
package zimbravoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de modifyVoiceMailPinSpec complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="modifyVoiceMailPinSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="oldPin" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pin" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyVoiceMailPinSpec")
public class ModifyVoiceMailPinSpec {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "oldPin", required = true)
    protected String oldPin;
    @XmlAttribute(name = "pin", required = true)
    protected String pin;

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade oldPin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldPin() {
        return oldPin;
    }

    /**
     * Define o valor da propriedade oldPin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldPin(String value) {
        this.oldPin = value;
    }

    /**
     * Obtém o valor da propriedade pin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPin() {
        return pin;
    }

    /**
     * Define o valor da propriedade pin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPin(String value) {
        this.pin = value;
    }

}
