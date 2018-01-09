
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de byWeekNoRule complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="byWeekNoRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="wklist" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "byWeekNoRule")
public class ByWeekNoRule {

    @XmlAttribute(name = "wklist", required = true)
    protected String wklist;

    /**
     * Obtém o valor da propriedade wklist.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWklist() {
        return wklist;
    }

    /**
     * Define o valor da propriedade wklist.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWklist(String value) {
        this.wklist = value;
    }

}
