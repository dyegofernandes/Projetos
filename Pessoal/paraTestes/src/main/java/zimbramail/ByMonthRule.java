
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de byMonthRule complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="byMonthRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="molist" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "byMonthRule")
public class ByMonthRule {

    @XmlAttribute(name = "molist", required = true)
    protected String molist;

    /**
     * Obtém o valor da propriedade molist.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMolist() {
        return molist;
    }

    /**
     * Define o valor da propriedade molist.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMolist(String value) {
        this.molist = value;
    }

}
