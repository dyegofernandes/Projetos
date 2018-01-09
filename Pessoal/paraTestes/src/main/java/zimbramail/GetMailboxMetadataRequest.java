
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import zimbra.SectionAttr;


/**
 * <p>Classe Java de getMailboxMetadataRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getMailboxMetadataRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meta" type="{urn:zimbra}sectionAttr" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMailboxMetadataRequest", propOrder = {
    "meta"
})
public class GetMailboxMetadataRequest {

    protected SectionAttr meta;

    /**
     * Obtém o valor da propriedade meta.
     * 
     * @return
     *     possible object is
     *     {@link SectionAttr }
     *     
     */
    public SectionAttr getMeta() {
        return meta;
    }

    /**
     * Define o valor da propriedade meta.
     * 
     * @param value
     *     allowed object is
     *     {@link SectionAttr }
     *     
     */
    public void setMeta(SectionAttr value) {
        this.meta = value;
    }

}
