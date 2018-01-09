
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getInfoRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getInfoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="rights" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sections" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getInfoRequest")
public class GetInfoRequest {

    @XmlAttribute(name = "rights")
    protected String rights;
    @XmlAttribute(name = "sections")
    protected String sections;

    /**
     * Obtém o valor da propriedade rights.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRights() {
        return rights;
    }

    /**
     * Define o valor da propriedade rights.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRights(String value) {
        this.rights = value;
    }

    /**
     * Obtém o valor da propriedade sections.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSections() {
        return sections;
    }

    /**
     * Define o valor da propriedade sections.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSections(String value) {
        this.sections = value;
    }

}
