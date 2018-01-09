
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createXMPPComponentResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createXMPPComponentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xmppcomponent" type="{urn:zimbraAdmin}xmppComponentInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createXMPPComponentResponse", propOrder = {
    "xmppcomponent"
})
public class CreateXMPPComponentResponse {

    @XmlElement(required = true)
    protected XmppComponentInfo xmppcomponent;

    /**
     * Obtém o valor da propriedade xmppcomponent.
     * 
     * @return
     *     possible object is
     *     {@link XmppComponentInfo }
     *     
     */
    public XmppComponentInfo getXmppcomponent() {
        return xmppcomponent;
    }

    /**
     * Define o valor da propriedade xmppcomponent.
     * 
     * @param value
     *     allowed object is
     *     {@link XmppComponentInfo }
     *     
     */
    public void setXmppcomponent(XmppComponentInfo value) {
        this.xmppcomponent = value;
    }

}
