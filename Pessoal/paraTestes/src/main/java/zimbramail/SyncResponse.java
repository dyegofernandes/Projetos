
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de syncResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="syncResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deleted" type="{urn:zimbraMail}syncDeletedInfo" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="folder" type="{urn:zimbraMail}syncFolder"/>
 *           &lt;element name="tag" type="{urn:zimbraMail}tagInfo"/>
 *           &lt;element name="note" type="{urn:zimbraMail}noteInfo"/>
 *           &lt;element name="cn" type="{urn:zimbraMail}contactInfo"/>
 *           &lt;element name="appt" type="{urn:zimbraMail}calendarItemInfo"/>
 *           &lt;element name="task" type="{urn:zimbraMail}taskItemInfo"/>
 *           &lt;element name="c" type="{urn:zimbraMail}conversationSummary"/>
 *           &lt;element name="w" type="{urn:zimbraMail}commonDocumentInfo"/>
 *           &lt;element name="doc" type="{urn:zimbraMail}documentInfo"/>
 *           &lt;element name="m" type="{urn:zimbraMail}messageSummary"/>
 *           &lt;element name="chat" type="{urn:zimbraMail}chatSummary"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="md" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="token" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="more" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "syncResponse", propOrder = {
    "deleted",
    "folderOrTagOrNote"
})
public class SyncResponse {

    protected SyncDeletedInfo deleted;
    @XmlElements({
        @XmlElement(name = "folder", type = SyncFolder.class),
        @XmlElement(name = "tag", type = TagInfo.class),
        @XmlElement(name = "note", type = NoteInfo.class),
        @XmlElement(name = "cn", type = ContactInfo.class),
        @XmlElement(name = "appt", type = CalendarItemInfo.class),
        @XmlElement(name = "task", type = TaskItemInfo.class),
        @XmlElement(name = "c", type = ConversationSummary.class),
        @XmlElement(name = "w", type = CommonDocumentInfo.class),
        @XmlElement(name = "doc", type = DocumentInfo.class),
        @XmlElement(name = "m", type = MessageSummary.class),
        @XmlElement(name = "chat", type = ChatSummary.class)
    })
    protected List<Object> folderOrTagOrNote;
    @XmlAttribute(name = "md", required = true)
    protected long md;
    @XmlAttribute(name = "token")
    protected String token;
    @XmlAttribute(name = "s")
    protected Long s;
    @XmlAttribute(name = "more")
    protected Boolean more;

    /**
     * Obtém o valor da propriedade deleted.
     * 
     * @return
     *     possible object is
     *     {@link SyncDeletedInfo }
     *     
     */
    public SyncDeletedInfo getDeleted() {
        return deleted;
    }

    /**
     * Define o valor da propriedade deleted.
     * 
     * @param value
     *     allowed object is
     *     {@link SyncDeletedInfo }
     *     
     */
    public void setDeleted(SyncDeletedInfo value) {
        this.deleted = value;
    }

    /**
     * Gets the value of the folderOrTagOrNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the folderOrTagOrNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFolderOrTagOrNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SyncFolder }
     * {@link TagInfo }
     * {@link NoteInfo }
     * {@link ContactInfo }
     * {@link CalendarItemInfo }
     * {@link TaskItemInfo }
     * {@link ConversationSummary }
     * {@link CommonDocumentInfo }
     * {@link DocumentInfo }
     * {@link MessageSummary }
     * {@link ChatSummary }
     * 
     * 
     */
    public List<Object> getFolderOrTagOrNote() {
        if (folderOrTagOrNote == null) {
            folderOrTagOrNote = new ArrayList<Object>();
        }
        return this.folderOrTagOrNote;
    }

    /**
     * Obtém o valor da propriedade md.
     * 
     */
    public long getMd() {
        return md;
    }

    /**
     * Define o valor da propriedade md.
     * 
     */
    public void setMd(long value) {
        this.md = value;
    }

    /**
     * Obtém o valor da propriedade token.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Define o valor da propriedade token.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Obtém o valor da propriedade s.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getS() {
        return s;
    }

    /**
     * Define o valor da propriedade s.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setS(Long value) {
        this.s = value;
    }

    /**
     * Obtém o valor da propriedade more.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMore() {
        return more;
    }

    /**
     * Define o valor da propriedade more.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMore(Boolean value) {
        this.more = value;
    }

}
