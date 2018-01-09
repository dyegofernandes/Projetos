
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de browseRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="browseRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="browseBy" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="regex" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="maxToReturn" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "browseRequest")
public class BrowseRequest {

    @XmlAttribute(name = "browseBy", required = true)
    protected String browseBy;
    @XmlAttribute(name = "regex")
    protected String regex;
    @XmlAttribute(name = "maxToReturn")
    protected Integer maxToReturn;

    /**
     * Obtém o valor da propriedade browseBy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowseBy() {
        return browseBy;
    }

    /**
     * Define o valor da propriedade browseBy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowseBy(String value) {
        this.browseBy = value;
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

    /**
     * Obtém o valor da propriedade maxToReturn.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxToReturn() {
        return maxToReturn;
    }

    /**
     * Define o valor da propriedade maxToReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxToReturn(Integer value) {
        this.maxToReturn = value;
    }

}
