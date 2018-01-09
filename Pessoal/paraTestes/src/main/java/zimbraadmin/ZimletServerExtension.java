
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de zimletServerExtension complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="zimletServerExtension">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="hasKeyword" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="extensionClass" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="regex" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zimletServerExtension")
public class ZimletServerExtension {

    @XmlAttribute(name = "hasKeyword")
    protected String hasKeyword;
    @XmlAttribute(name = "extensionClass")
    protected String extensionClass;
    @XmlAttribute(name = "regex")
    protected String regex;

    /**
     * Obtém o valor da propriedade hasKeyword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHasKeyword() {
        return hasKeyword;
    }

    /**
     * Define o valor da propriedade hasKeyword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHasKeyword(String value) {
        this.hasKeyword = value;
    }

    /**
     * Obtém o valor da propriedade extensionClass.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtensionClass() {
        return extensionClass;
    }

    /**
     * Define o valor da propriedade extensionClass.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtensionClass(String value) {
        this.extensionClass = value;
    }

    /**
     * Obtém o valor da propriedade regex.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegex() {
        return regex;
    }

    /**
     * Define o valor da propriedade regex.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegex(String value) {
        this.regex = value;
    }

}
