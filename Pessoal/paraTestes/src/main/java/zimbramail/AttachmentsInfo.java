
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Classe Java de attachmentsInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="attachmentsInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{urn:zimbraMail}mp"/>
 *           &lt;element ref="{urn:zimbraMail}m"/>
 *           &lt;element ref="{urn:zimbraMail}cn"/>
 *           &lt;element ref="{urn:zimbraMail}doc"/>
 *         &lt;/choice>
 *         &lt;any processContents='skip' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="aid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attachmentsInfo", propOrder = {
    "mpOrMOrCn",
    "any"
})
public class AttachmentsInfo {

    @XmlElements({
        @XmlElement(name = "mp", type = MimePartAttachSpec.class),
        @XmlElement(name = "m", type = MsgAttachSpec.class),
        @XmlElement(name = "cn", type = ContactAttachSpec.class),
        @XmlElement(name = "doc", type = DocAttachSpec.class)
    })
    protected List<AttachSpec> mpOrMOrCn;
    @XmlAnyElement
    protected List<Element> any;
    @XmlAttribute(name = "aid")
    protected String aid;

    /**
     * Gets the value of the mpOrMOrCn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mpOrMOrCn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMpOrMOrCn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MimePartAttachSpec }
     * {@link MsgAttachSpec }
     * {@link ContactAttachSpec }
     * {@link DocAttachSpec }
     * 
     * 
     */
    public List<AttachSpec> getMpOrMOrCn() {
        if (mpOrMOrCn == null) {
            mpOrMOrCn = new ArrayList<AttachSpec>();
        }
        return this.mpOrMOrCn;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * 
     * 
     */
    public List<Element> getAny() {
        if (any == null) {
            any = new ArrayList<Element>();
        }
        return this.any;
    }

    /**
     * Obtém o valor da propriedade aid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAid() {
        return aid;
    }

    /**
     * Define o valor da propriedade aid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAid(String value) {
        this.aid = value;
    }

}