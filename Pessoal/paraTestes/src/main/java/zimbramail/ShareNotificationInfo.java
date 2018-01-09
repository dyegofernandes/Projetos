
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de shareNotificationInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="shareNotificationInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="grantor" type="{urn:zimbraMail}grantor"/>
 *         &lt;element name="link" type="{urn:zimbraMail}linkInfo"/>
 *       &lt;/sequence>
 *       &lt;attribute name="status" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="d" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shareNotificationInfo", propOrder = {
    "grantor",
    "link"
})
public class ShareNotificationInfo {

    @XmlElement(required = true)
    protected Grantor grantor;
    @XmlElement(required = true)
    protected LinkInfo link;
    @XmlAttribute(name = "status", required = true)
    protected String status;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "d", required = true)
    protected long d;

    /**
     * Obtém o valor da propriedade grantor.
     * 
     * @return
     *     possible object is
     *     {@link Grantor }
     *     
     */
    public Grantor getGrantor() {
        return grantor;
    }

    /**
     * Define o valor da propriedade grantor.
     * 
     * @param value
     *     allowed object is
     *     {@link Grantor }
     *     
     */
    public void setGrantor(Grantor value) {
        this.grantor = value;
    }

    /**
     * Obtém o valor da propriedade link.
     * 
     * @return
     *     possible object is
     *     {@link LinkInfo }
     *     
     */
    public LinkInfo getLink() {
        return link;
    }

    /**
     * Define o valor da propriedade link.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkInfo }
     *     
     */
    public void setLink(LinkInfo value) {
        this.link = value;
    }

    /**
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
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

    /**
     * Obtém o valor da propriedade d.
     * 
     */
    public long getD() {
        return d;
    }

    /**
     * Define o valor da propriedade d.
     * 
     */
    public void setD(long value) {
        this.d = value;
    }

}
