
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de recalculateMailboxCountsResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="recalculateMailboxCountsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:zimbraAdmin}mbox"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recalculateMailboxCountsResponse", propOrder = {
    "mbox"
})
public class RecalculateMailboxCountsResponse {

    @XmlElement(required = true)
    protected MailboxQuotaInfo mbox;

    /**
     * Obtém o valor da propriedade mbox.
     * 
     * @return
     *     possible object is
     *     {@link MailboxQuotaInfo }
     *     
     */
    public MailboxQuotaInfo getMbox() {
        return mbox;
    }

    /**
     * Define o valor da propriedade mbox.
     * 
     * @param value
     *     allowed object is
     *     {@link MailboxQuotaInfo }
     *     
     */
    public void setMbox(MailboxQuotaInfo value) {
        this.mbox = value;
    }

}
