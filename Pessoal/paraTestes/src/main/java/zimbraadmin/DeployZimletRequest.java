
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de deployZimletRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="deployZimletRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="content" type="{urn:zimbraAdmin}attachmentIdAttrib"/>
 *       &lt;/sequence>
 *       &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="flush" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="synchronous" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deployZimletRequest", propOrder = {
    "content"
})
public class DeployZimletRequest {

    @XmlElement(required = true)
    protected AttachmentIdAttrib content;
    @XmlAttribute(name = "action", required = true)
    protected String action;
    @XmlAttribute(name = "flush")
    protected Boolean flush;
    @XmlAttribute(name = "synchronous")
    protected Boolean synchronous;

    /**
     * Obtém o valor da propriedade content.
     * 
     * @return
     *     possible object is
     *     {@link AttachmentIdAttrib }
     *     
     */
    public AttachmentIdAttrib getContent() {
        return content;
    }

    /**
     * Define o valor da propriedade content.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentIdAttrib }
     *     
     */
    public void setContent(AttachmentIdAttrib value) {
        this.content = value;
    }

    /**
     * Obtém o valor da propriedade action.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Define o valor da propriedade action.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Obtém o valor da propriedade flush.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlush() {
        return flush;
    }

    /**
     * Define o valor da propriedade flush.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlush(Boolean value) {
        this.flush = value;
    }

    /**
     * Obtém o valor da propriedade synchronous.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSynchronous() {
        return synchronous;
    }

    /**
     * Define o valor da propriedade synchronous.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSynchronous(Boolean value) {
        this.synchronous = value;
    }

}
