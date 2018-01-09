
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de purgeMovedMailboxRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="purgeMovedMailboxRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mbox" type="{urn:zimbraAdmin}name"/>
 *       &lt;/sequence>
 *       &lt;attribute name="forceDeleteBlobs" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "purgeMovedMailboxRequest", propOrder = {
    "mbox"
})
public class PurgeMovedMailboxRequest {

    @XmlElement(required = true)
    protected Name mbox;
    @XmlAttribute(name = "forceDeleteBlobs")
    protected Boolean forceDeleteBlobs;

    /**
     * Obtém o valor da propriedade mbox.
     * 
     * @return
     *     possible object is
     *     {@link Name }
     *     
     */
    public Name getMbox() {
        return mbox;
    }

    /**
     * Define o valor da propriedade mbox.
     * 
     * @param value
     *     allowed object is
     *     {@link Name }
     *     
     */
    public void setMbox(Name value) {
        this.mbox = value;
    }

    /**
     * Obtém o valor da propriedade forceDeleteBlobs.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isForceDeleteBlobs() {
        return forceDeleteBlobs;
    }

    /**
     * Define o valor da propriedade forceDeleteBlobs.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForceDeleteBlobs(Boolean value) {
        this.forceDeleteBlobs = value;
    }

}
