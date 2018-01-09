
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de byMinuteRule complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="byMinuteRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="minlist" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "byMinuteRule")
public class ByMinuteRule {

    @XmlAttribute(name = "minlist", required = true)
    protected String minlist;

    /**
     * Obtém o valor da propriedade minlist.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinlist() {
        return minlist;
    }

    /**
     * Define o valor da propriedade minlist.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinlist(String value) {
        this.minlist = value;
    }

}
