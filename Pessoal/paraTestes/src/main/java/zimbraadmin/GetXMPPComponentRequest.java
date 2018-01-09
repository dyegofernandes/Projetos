
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import zimbra.AttributeSelectorImpl;


/**
 * <p>Classe Java de getXMPPComponentRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getXMPPComponentRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbra}attributeSelectorImpl">
 *       &lt;sequence>
 *         &lt;element name="xmppcomponent" type="{urn:zimbraAdmin}xmppComponentSelector"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getXMPPComponentRequest", propOrder = {
    "xmppcomponent"
})
public class GetXMPPComponentRequest
    extends AttributeSelectorImpl
{

    @XmlElement(required = true)
    protected XmppComponentSelector xmppcomponent;

    /**
     * Obtém o valor da propriedade xmppcomponent.
     * 
     * @return
     *     possible object is
     *     {@link XmppComponentSelector }
     *     
     */
    public XmppComponentSelector getXmppcomponent() {
        return xmppcomponent;
    }

    /**
     * Define o valor da propriedade xmppcomponent.
     * 
     * @param value
     *     allowed object is
     *     {@link XmppComponentSelector }
     *     
     */
    public void setXmppcomponent(XmppComponentSelector value) {
        this.xmppcomponent = value;
    }

}
