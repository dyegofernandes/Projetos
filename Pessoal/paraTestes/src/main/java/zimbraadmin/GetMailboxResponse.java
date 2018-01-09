
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getMailboxResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getMailboxResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mbox" type="{urn:zimbraAdmin}mailboxWithMailboxId"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMailboxResponse", propOrder = {
    "mbox"
})
public class GetMailboxResponse {

    @XmlElement(required = true)
    protected MailboxWithMailboxId mbox;

    /**
     * Obtém o valor da propriedade mbox.
     * 
     * @return
     *     possible object is
     *     {@link MailboxWithMailboxId }
     *     
     */
    public MailboxWithMailboxId getMbox() {
        return mbox;
    }

    /**
     * Define o valor da propriedade mbox.
     * 
     * @param value
     *     allowed object is
     *     {@link MailboxWithMailboxId }
     *     
     */
    public void setMbox(MailboxWithMailboxId value) {
        this.mbox = value;
    }

}
