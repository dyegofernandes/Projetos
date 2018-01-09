
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getAttributeInfoRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getAttributeInfoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="attrs" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="entryTypes" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAttributeInfoRequest")
public class GetAttributeInfoRequest {

    @XmlAttribute(name = "attrs")
    protected String attrs;
    @XmlAttribute(name = "entryTypes")
    protected String entryTypes;

    /**
     * Obtém o valor da propriedade attrs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrs() {
        return attrs;
    }

    /**
     * Define o valor da propriedade attrs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrs(String value) {
        this.attrs = value;
    }

    /**
     * Obtém o valor da propriedade entryTypes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntryTypes() {
        return entryTypes;
    }

    /**
     * Define o valor da propriedade entryTypes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntryTypes(String value) {
        this.entryTypes = value;
    }

}
