
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getMailboxStatsResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getMailboxStatsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stats" type="{urn:zimbraAdmin}mailboxStats"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMailboxStatsResponse", propOrder = {
    "stats"
})
public class GetMailboxStatsResponse {

    @XmlElement(required = true)
    protected MailboxStats stats;

    /**
     * Obtém o valor da propriedade stats.
     * 
     * @return
     *     possible object is
     *     {@link MailboxStats }
     *     
     */
    public MailboxStats getStats() {
        return stats;
    }

    /**
     * Define o valor da propriedade stats.
     * 
     * @param value
     *     allowed object is
     *     {@link MailboxStats }
     *     
     */
    public void setStats(MailboxStats value) {
        this.stats = value;
    }

}
