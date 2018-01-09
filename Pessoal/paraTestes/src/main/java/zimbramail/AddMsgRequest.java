
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de addMsgRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="addMsgRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="m" type="{urn:zimbraMail}addMsgSpec"/>
 *       &lt;/sequence>
 *       &lt;attribute name="filterSent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addMsgRequest", propOrder = {
    "m"
})
public class AddMsgRequest {

    @XmlElement(required = true)
    protected AddMsgSpec m;
    @XmlAttribute(name = "filterSent")
    protected Boolean filterSent;

    /**
     * Obtém o valor da propriedade m.
     * 
     * @return
     *     possible object is
     *     {@link AddMsgSpec }
     *     
     */
    public AddMsgSpec getM() {
        return m;
    }

    /**
     * Define o valor da propriedade m.
     * 
     * @param value
     *     allowed object is
     *     {@link AddMsgSpec }
     *     
     */
    public void setM(AddMsgSpec value) {
        this.m = value;
    }

    /**
     * Obtém o valor da propriedade filterSent.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFilterSent() {
        return filterSent;
    }

    /**
     * Define o valor da propriedade filterSent.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFilterSent(Boolean value) {
        this.filterSent = value;
    }

}
