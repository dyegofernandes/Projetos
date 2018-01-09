
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getCustomMetadataResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getCustomMetadataResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:zimbraMail}meta" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCustomMetadataResponse", propOrder = {
    "meta"
})
public class GetCustomMetadataResponse {

    protected MailCustomMetadata meta;
    @XmlAttribute(name = "id", required = true)
    protected String id;

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

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
