
package zimbravoice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de searchVoiceResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="searchVoiceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vfi" type="{urn:zimbraVoice}voiceFolderSummary" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="vm" type="{urn:zimbraVoice}voiceMailItem"/>
 *           &lt;element name="cl" type="{urn:zimbraVoice}callLogItem"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="sortBy" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="offset" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="more" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchVoiceResponse", propOrder = {
    "vfi",
    "vmOrCl"
})
public class SearchVoiceResponse {

    protected List<VoiceFolderSummary> vfi;
    @XmlElements({
        @XmlElement(name = "vm", type = VoiceMailItem.class),
        @XmlElement(name = "cl", type = CallLogItem.class)
    })
    protected List<VoiceCallItem> vmOrCl;
    @XmlAttribute(name = "sortBy", required = true)
    protected String sortBy;
    @XmlAttribute(name = "offset", required = true)
    protected int offset;
    @XmlAttribute(name = "more", required = true)
    protected boolean more;

    /**
     * Gets the value of the vfi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vfi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVfi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VoiceFolderSummary }
     * 
     * 
     */
    public List<VoiceFolderSummary> getVfi() {
        if (vfi == null) {
            vfi = new ArrayList<VoiceFolderSummary>();
        }
        return this.vfi;
    }

    /**
     * Gets the value of the vmOrCl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmOrCl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmOrCl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VoiceMailItem }
     * {@link CallLogItem }
     * 
     * 
     */
    public List<VoiceCallItem> getVmOrCl() {
        if (vmOrCl == null) {
            vmOrCl = new ArrayList<VoiceCallItem>();
        }
        return this.vmOrCl;
    }

    /**
     * Obtém o valor da propriedade sortBy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortBy() {
        return sortBy;
    }

    /**
     * Define o valor da propriedade sortBy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortBy(String value) {
        this.sortBy = value;
    }

    /**
     * Obtém o valor da propriedade offset.
     * 
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Define o valor da propriedade offset.
     * 
     */
    public void setOffset(int value) {
        this.offset = value;
    }

    /**
     * Obtém o valor da propriedade more.
     * 
     */
    public boolean isMore() {
        return more;
    }

    /**
     * Define o valor da propriedade more.
     * 
     */
    public void setMore(boolean value) {
        this.more = value;
    }

}
