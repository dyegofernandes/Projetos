
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de mailQueueDetails complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="mailQueueDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="qs" type="{urn:zimbraAdmin}queueSummary" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="qi" type="{urn:zimbraAdmin}queueItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="time" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="scan" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="total" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="more" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mailQueueDetails", propOrder = {
    "qs",
    "qi"
})
public class MailQueueDetails {

    protected List<QueueSummary> qs;
    protected List<QueueItem> qi;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "time", required = true)
    protected long time;
    @XmlAttribute(name = "scan", required = true)
    protected boolean scan;
    @XmlAttribute(name = "total", required = true)
    protected int total;
    @XmlAttribute(name = "more", required = true)
    protected boolean more;

    /**
     * Gets the value of the qs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the qs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QueueSummary }
     * 
     * 
     */
    public List<QueueSummary> getQs() {
        if (qs == null) {
            qs = new ArrayList<QueueSummary>();
        }
        return this.qs;
    }

    /**
     * Gets the value of the qi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the qi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QueueItem }
     * 
     * 
     */
    public List<QueueItem> getQi() {
        if (qi == null) {
            qi = new ArrayList<QueueItem>();
        }
        return this.qi;
    }

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade time.
     * 
     */
    public long getTime() {
        return time;
    }

    /**
     * Define o valor da propriedade time.
     * 
     */
    public void setTime(long value) {
        this.time = value;
    }

    /**
     * Obtém o valor da propriedade scan.
     * 
     */
    public boolean isScan() {
        return scan;
    }

    /**
     * Define o valor da propriedade scan.
     * 
     */
    public void setScan(boolean value) {
        this.scan = value;
    }

    /**
     * Obtém o valor da propriedade total.
     * 
     */
    public int getTotal() {
        return total;
    }

    /**
     * Define o valor da propriedade total.
     * 
     */
    public void setTotal(int value) {
        this.total = value;
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
