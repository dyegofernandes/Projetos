
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de bySecondRule complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="bySecondRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="seclist" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bySecondRule")
public class BySecondRule {

    @XmlAttribute(name = "seclist", required = true)
    protected String seclist;

    /**
     * Obtém o valor da propriedade seclist.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeclist() {
        return seclist;
    }

    /**
     * Define o valor da propriedade seclist.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeclist(String value) {
        this.seclist = value;
    }

}
