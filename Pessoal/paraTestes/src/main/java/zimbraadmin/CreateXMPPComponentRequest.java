
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createXMPPComponentRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createXMPPComponentRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xmppcomponent" type="{urn:zimbraAdmin}xmppComponentSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createXMPPComponentRequest", propOrder = {
    "xmppcomponent"
})
public class CreateXMPPComponentRequest {

    @XmlElement(required = true)
    protected XmppComponentSpec xmppcomponent;

    /**
     * Obtém o valor da propriedade xmppcomponent.
     * 
     * @return
     *     possible object is
     *     {@link XmppComponentSpec }
     *     
     */
    public XmppComponentSpec getXmppcomponent() {
        return xmppcomponent;
    }

    /**
     * Define o valor da propriedade xmppcomponent.
     * 
     * @param value
     *     allowed object is
     *     {@link XmppComponentSpec }
     *     
     */
    public void setXmppcomponent(XmppComponentSpec value) {
        this.xmppcomponent = value;
    }

}
