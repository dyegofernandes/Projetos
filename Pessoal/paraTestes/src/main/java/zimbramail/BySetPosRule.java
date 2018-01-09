
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de bySetPosRule complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="bySetPosRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="poslist" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bySetPosRule")
public class BySetPosRule {

    @XmlAttribute(name = "poslist", required = true)
    protected String poslist;

    /**
     * Obtém o valor da propriedade poslist.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoslist() {
        return poslist;
    }

    /**
     * Define o valor da propriedade poslist.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoslist(String value) {
        this.poslist = value;
    }

}
