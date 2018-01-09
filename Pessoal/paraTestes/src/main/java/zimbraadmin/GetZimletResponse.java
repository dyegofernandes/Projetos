
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getZimletResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getZimletResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zimlet" type="{urn:zimbraAdmin}zimletInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getZimletResponse", propOrder = {
    "zimlet"
})
public class GetZimletResponse {

    @XmlElement(required = true)
    protected ZimletInfo zimlet;

    /**
     * Obtém o valor da propriedade zimlet.
     * 
     * @return
     *     possible object is
     *     {@link ZimletInfo }
     *     
     */
    public ZimletInfo getZimlet() {
        return zimlet;
    }

    /**
     * Define o valor da propriedade zimlet.
     * 
     * @param value
     *     allowed object is
     *     {@link ZimletInfo }
     *     
     */
    public void setZimlet(ZimletInfo value) {
        this.zimlet = value;
    }

}
