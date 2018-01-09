
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de byHourRule complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="byHourRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="hrlist" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "byHourRule")
public class ByHourRule {

    @XmlAttribute(name = "hrlist", required = true)
    protected String hrlist;

    /**
     * Obtém o valor da propriedade hrlist.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHrlist() {
        return hrlist;
    }

    /**
     * Define o valor da propriedade hrlist.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHrlist(String value) {
        this.hrlist = value;
    }

}
