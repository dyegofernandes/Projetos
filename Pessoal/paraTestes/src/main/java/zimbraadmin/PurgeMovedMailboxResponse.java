
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de purgeMovedMailboxResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="purgeMovedMailboxResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mbox" type="{urn:zimbraAdmin}purgeMovedMailboxInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "purgeMovedMailboxResponse", propOrder = {
    "mbox"
})
public class PurgeMovedMailboxResponse {

    @XmlElement(required = true)
    protected PurgeMovedMailboxInfo mbox;

    /**
     * Obtém o valor da propriedade mbox.
     * 
     * @return
     *     possible object is
     *     {@link PurgeMovedMailboxInfo }
     *     
     */
    public PurgeMovedMailboxInfo getMbox() {
        return mbox;
    }

    /**
     * Define o valor da propriedade mbox.
     * 
     * @param value
     *     allowed object is
     *     {@link PurgeMovedMailboxInfo }
     *     
     */
    public void setMbox(PurgeMovedMailboxInfo value) {
        this.mbox = value;
    }

}
