
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Classe Java de checkSpellingRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="checkSpellingRequest">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="dictionary" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ignore" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkSpellingRequest", propOrder = {
    "value"
})
public class CheckSpellingRequest {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "dictionary")
    protected String dictionary;
    @XmlAttribute(name = "ignore")
    protected String ignore;

    /**
     * Obtém o valor da propriedade value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define o valor da propriedade value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtém o valor da propriedade dictionary.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDictionary() {
        return dictionary;
    }

    /**
     * Define o valor da propriedade dictionary.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDictionary(String value) {
        this.dictionary = value;
    }

    /**
     * Obtém o valor da propriedade ignore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIgnore() {
        return ignore;
    }

    /**
     * Define o valor da propriedade ignore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIgnore(String value) {
        this.ignore = value;
    }

}
