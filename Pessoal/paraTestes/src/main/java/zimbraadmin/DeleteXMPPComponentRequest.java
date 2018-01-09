
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de deleteXMPPComponentRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="deleteXMPPComponentRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xmppcomponent" type="{urn:zimbraAdmin}xmppComponentSelector"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteXMPPComponentRequest", propOrder = {
    "xmppcomponent"
})
public class DeleteXMPPComponentRequest {

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
