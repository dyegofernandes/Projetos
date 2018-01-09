
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de checkRightResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="checkRightResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="via" type="{urn:zimbraAdmin}rightViaInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="allow" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkRightResponse", propOrder = {
    "via"
})
public class CheckRightResponse {

    protected RightViaInfo via;
    @XmlAttribute(name = "allow", required = true)
    protected boolean allow;

    /**
     * Obtém o valor da propriedade via.
     * 
     * @return
     *     possible object is
     *     {@link RightViaInfo }
     *     
     */
    public RightViaInfo getVia() {
        return via;
    }

    /**
     * Define o valor da propriedade via.
     * 
     * @param value
     *     allowed object is
     *     {@link RightViaInfo }
     *     
     */
    public void setVia(RightViaInfo value) {
        this.via = value;
    }

    /**
     * Obtém o valor da propriedade allow.
     * 
     */
    public boolean isAllow() {
        return allow;
    }

    /**
     * Define o valor da propriedade allow.
     * 
     */
    public void setAllow(boolean value) {
        this.allow = value;
    }

}
