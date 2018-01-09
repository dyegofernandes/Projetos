
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getCalendarItemRequestBase complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getCalendarItemRequestBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="sync" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="includeContent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="includeInvites" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="uid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCalendarItemRequestBase")
@XmlSeeAlso({
    GetAppointmentRequest.class,
    GetTaskRequest.class
})
public abstract class GetCalendarItemRequestBase {

    @XmlAttribute(name = "sync")
    protected Boolean sync;
    @XmlAttribute(name = "includeContent")
    protected Boolean includeContent;
    @XmlAttribute(name = "includeInvites")
    protected Boolean includeInvites;
    @XmlAttribute(name = "uid")
    protected String uid;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Obtém o valor da propriedade sync.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSync() {
        return sync;
    }

    /**
     * Define o valor da propriedade sync.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSync(Boolean value) {
        this.sync = value;
    }

    /**
     * Obtém o valor da propriedade includeContent.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeContent() {
        return includeContent;
    }

    /**
     * Define o valor da propriedade includeContent.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeContent(Boolean value) {
        this.includeContent = value;
    }

    /**
     * Obtém o valor da propriedade includeInvites.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeInvites() {
        return includeInvites;
    }

    /**
     * Define o valor da propriedade includeInvites.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeInvites(Boolean value) {
        this.includeInvites = value;
    }

    /**
     * Obtém o valor da propriedade uid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * Define o valor da propriedade uid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
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
