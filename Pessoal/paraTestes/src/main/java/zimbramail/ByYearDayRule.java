
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de byYearDayRule complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="byYearDayRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="yrdaylist" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "byYearDayRule")
public class ByYearDayRule {

    @XmlAttribute(name = "yrdaylist", required = true)
    protected String yrdaylist;

    /**
     * Obtém o valor da propriedade yrdaylist.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYrdaylist() {
        return yrdaylist;
    }

    /**
     * Define o valor da propriedade yrdaylist.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYrdaylist(String value) {
        this.yrdaylist = value;
    }

}
