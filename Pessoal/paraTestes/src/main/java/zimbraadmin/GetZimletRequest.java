
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import zimbra.AttributeSelectorImpl;
import zimbra.NamedElement;


/**
 * <p>Classe Java de getZimletRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getZimletRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbra}attributeSelectorImpl">
 *       &lt;sequence>
 *         &lt;element name="zimlet" type="{urn:zimbra}namedElement"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getZimletRequest", propOrder = {
    "zimlet"
})
public class GetZimletRequest
    extends AttributeSelectorImpl
{

    @XmlElement(required = true)
    protected NamedElement zimlet;

    /**
     * Obtém o valor da propriedade zimlet.
     * 
     * @return
     *     possible object is
     *     {@link NamedElement }
     *     
     */
    public NamedElement getZimlet() {
        return zimlet;
    }

    /**
     * Define o valor da propriedade zimlet.
     * 
     * @param value
     *     allowed object is
     *     {@link NamedElement }
     *     
     */
    public void setZimlet(NamedElement value) {
        this.zimlet = value;
    }

}
