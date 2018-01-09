
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de mimePartInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="mimePartInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mp" type="{urn:zimbraMail}mimePartInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="attach" type="{urn:zimbraMail}attachmentsInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ct" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="content" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ci" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mimePartInfo", propOrder = {
    "mp",
    "attach"
})
public class MimePartInfo {

    protected List<MimePartInfo> mp;
    protected AttachmentsInfo attach;
    @XmlAttribute(name = "ct")
    protected String ct;
    @XmlAttribute(name = "content")
    protected String content;
    @XmlAttribute(name = "ci")
    protected String ci;

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
     * Obtém o valor da propriedade content.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Define o valor da propriedade content.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
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