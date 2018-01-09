
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de byMonthDayRule complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="byMonthDayRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="modaylist" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "byMonthDayRule")
public class ByMonthDayRule {

    @XmlAttribute(name = "modaylist", required = true)
    protected String modaylist;

    /**
     * Obtém o valor da propriedade modaylist.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModaylist() {
        return modaylist;
    }

    /**
     * Define o valor da propriedade modaylist.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModaylist(String value) {
        this.modaylist = value;
    }

}
