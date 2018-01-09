
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de setMailboxMetadataRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="setMailboxMetadataRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:zimbraMail}meta" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setMailboxMetadataRequest", propOrder = {
    "meta"
})
public class SetMailboxMetadataRequest {

    protected MailCustomMetadata meta;

    /**
     * Obtém o valor da propriedade meta.
     * 
     * @return
     *     possible object is
     *     {@link MailCustomMetadata }
     *     
     */
    public MailCustomMetadata getMeta() {
        return meta;
    }

    /**
     * Define o valor da propriedade meta.
     * 
     * @param value
     *     allowed object is
     *     {@link MailCustomMetadata }
     *     
     */
    public void setMeta(MailCustomMetadata value) {
        this.meta = value;
    }

}
