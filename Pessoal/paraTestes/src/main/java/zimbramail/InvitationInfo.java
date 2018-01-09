
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de invitationInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="invitationInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}inviteComponent">
 *       &lt;sequence>
 *         &lt;element name="content" type="{urn:zimbraMail}rawInvite" minOccurs="0"/>
 *         &lt;element name="comp" type="{urn:zimbraMail}inviteComponent" minOccurs="0"/>
 *         &lt;element name="tz" type="{urn:zimbraMail}calTZInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="mp" type="{urn:zimbraMail}mimePartInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="attach" type="{urn:zimbraMail}attachmentsInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ct" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ci" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invitationInfo", propOrder = {
    "content",
    "comp",
    "tz",
    "mp",
    "attach"
})
public class InvitationInfo
    extends InviteComponent
{

    protected RawInvite content;
    protected InviteComponent comp;
    protected List<CalTZInfo> tz;
    protected List<MimePartInfo> mp;
    protected AttachmentsInfo attach;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "ct")
    protected String ct;
    @XmlAttribute(name = "ci")
    protected String ci;

    /**
     * Obtém o valor da propriedade content.
     * 
     * @return
     *     possible object is
     *     {@link RawInvite }
     *     
     */
    public RawInvite getContent() {
        return content;
    }

    /**
     * Define o valor da propriedade content.
     * 
     * @param value
     *     allowed object is
     *     {@link RawInvite }
     *     
     */
    public void setContent(RawInvite value) {
        this.content = value;
    }

    /**
     * Obtém o valor da propriedade comp.
     * 
     * @return
     *     possible object is
     *     {@link InviteComponent }
     *     
     */
    public InviteComponent getComp() {
        return comp;
    }

    /**
     * Define o valor da propriedade comp.
     * 
     * @param value
     *     allowed object is
     *     {@link InviteComponent }
     *     
     */
    public void setComp(InviteComponent value) {
        this.comp = value;
    }

    /**
     * Gets the value of the tz property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tz property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTz().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalTZInfo }
     * 
     * 
     */
    public List<CalTZInfo> getTz() {
        if (tz == null) {
            tz = new ArrayList<CalTZInfo>();
        }
        return this.tz;
    }

    /**
     * Gets the value of the mp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MimePartInfo }
     * 
     * 
     */
    public List<MimePartInfo> getMp() {
        if (mp == null) {
            mp = new ArrayList<MimePartInfo>();
        }
        return this.mp;
    }

    /**
     * Obtém o valor da propriedade attach.
     * 
     * @return
     *     possible object is
     *     {@link AttachmentsInfo }
     *     
     */
    public AttachmentsInfo getAttach() {
        return attach;
    }

    /**
     * Define o valor da propriedade attach.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentsInfo }
     *     
     */
    public void setAttach(AttachmentsInfo value) {
        this.attach = value;
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
     * Obtém o valor da propriedade ct.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCt() {
        return ct;
    }

    /**
     * Define o valor da propriedade ct.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCt(String value) {
        this.ct = value;
    }

    /**
     * Obtém o valor da propriedade ci.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCi() {
        return ci;
    }

    /**
     * Define o valor da propriedade ci.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCi(String value) {
        this.ci = value;
    }

}
