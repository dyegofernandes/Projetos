
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getItemResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getItemResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{urn:zimbraMail}folder"/>
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
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getItemResponse", propOrder = {
    "folder",
    "tag",
    "note",
    "cn",
    "appt",
    "task",
    "c",
    "w",
    "doc",
    "m",
    "chat"
})
public class GetItemResponse {

    protected Folder folder;
    protected TagInfo tag;
    protected NoteInfo note;
    protected ContactInfo cn;
    protected CalendarItemInfo appt;
    protected TaskItemInfo task;
    protected ConversationSummary c;
    protected CommonDocumentInfo w;
    protected DocumentInfo doc;
    protected MessageSummary m;
    protected ChatSummary chat;

    /**
     * Obtém o valor da propriedade folder.
     * 
     * @return
     *     possible object is
     *     {@link Folder }
     *     
     */
    public Folder getFolder() {
        return folder;
    }

    /**
     * Define o valor da propriedade folder.
     * 
     * @param value
     *     allowed object is
     *     {@link Folder }
     *     
     */
    public void setFolder(Folder value) {
        this.folder = value;
    }

    /**
     * Obtém o valor da propriedade tag.
     * 
     * @return
     *     possible object is
     *     {@link TagInfo }
     *     
     */
    public TagInfo getTag() {
        return tag;
    }

    /**
     * Define o valor da propriedade tag.
     * 
     * @param value
     *     allowed object is
     *     {@link TagInfo }
     *     
     */
    public void setTag(TagInfo value) {
        this.tag = value;
    }

    /**
     * Obtém o valor da propriedade note.
     * 
     * @return
     *     possible object is
     *     {@link NoteInfo }
     *     
     */
    public NoteInfo getNote() {
        return note;
    }

    /**
     * Define o valor da propriedade note.
     * 
     * @param value
     *     allowed object is
     *     {@link NoteInfo }
     *     
     */
    public void setNote(NoteInfo value) {
        this.note = value;
    }

    /**
     * Obtém o valor da propriedade cn.
     * 
     * @return
     *     possible object is
     *     {@link ContactInfo }
     *     
     */
    public ContactInfo getCn() {
        return cn;
    }

    /**
     * Define o valor da propriedade cn.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInfo }
     *     
     */
    public void setCn(ContactInfo value) {
        this.cn = value;
    }

    /**
     * Obtém o valor da propriedade appt.
     * 
     * @return
     *     possible object is
     *     {@link CalendarItemInfo }
     *     
     */
    public CalendarItemInfo getAppt() {
        return appt;
    }

    /**
     * Define o valor da propriedade appt.
     * 
     * @param value
     *     allowed object is
     *     {@link CalendarItemInfo }
     *     
     */
    public void setAppt(CalendarItemInfo value) {
        this.appt = value;
    }

    /**
     * Obtém o valor da propriedade task.
     * 
     * @return
     *     possible object is
     *     {@link TaskItemInfo }
     *     
     */
    public TaskItemInfo getTask() {
        return task;
    }

    /**
     * Define o valor da propriedade task.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskItemInfo }
     *     
     */
    public void setTask(TaskItemInfo value) {
        this.task = value;
    }

    /**
     * Obtém o valor da propriedade c.
     * 
     * @return
     *     possible object is
     *     {@link ConversationSummary }
     *     
     */
    public ConversationSummary getC() {
        return c;
    }

    /**
     * Define o valor da propriedade c.
     * 
     * @param value
     *     allowed object is
     *     {@link ConversationSummary }
     *     
     */
    public void setC(ConversationSummary value) {
        this.c = value;
    }

    /**
     * Obtém o valor da propriedade w.
     * 
     * @return
     *     possible object is
     *     {@link CommonDocumentInfo }
     *     
     */
    public CommonDocumentInfo getW() {
        return w;
    }

    /**
     * Define o valor da propriedade w.
     * 
     * @param value
     *     allowed object is
     *     {@link CommonDocumentInfo }
     *     
     */
    public void setW(CommonDocumentInfo value) {
        this.w = value;
    }

    /**
     * Obtém o valor da propriedade doc.
     * 
     * @return
     *     possible object is
     *     {@link DocumentInfo }
     *     
     */
    public DocumentInfo getDoc() {
        return doc;
    }

    /**
     * Define o valor da propriedade doc.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentInfo }
     *     
     */
    public void setDoc(DocumentInfo value) {
        this.doc = value;
    }

    /**
     * Obtém o valor da propriedade m.
     * 
     * @return
     *     possible object is
     *     {@link MessageSummary }
     *     
     */
    public MessageSummary getM() {
        return m;
    }

    /**
     * Define o valor da propriedade m.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageSummary }
     *     
     */
    public void setM(MessageSummary value) {
        this.m = value;
    }

    /**
     * Obtém o valor da propriedade chat.
     * 
     * @return
     *     possible object is
     *     {@link ChatSummary }
     *     
     */
    public ChatSummary getChat() {
        return chat;
    }

    /**
     * Define o valor da propriedade chat.
     * 
     * @param value
     *     allowed object is
     *     {@link ChatSummary }
     *     
     */
    public void setChat(ChatSummary value) {
        this.chat = value;
    }

}
