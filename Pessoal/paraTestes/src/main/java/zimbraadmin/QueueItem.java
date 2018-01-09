
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de queueItem complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="queueItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="time" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fromdomain" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="size" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="from" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="to" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="host" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="addr" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="reason" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="filter" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="todomain" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="received" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queueItem")
public class QueueItem {

    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "time", required = true)
    protected String time;
    @XmlAttribute(name = "fromdomain", required = true)
    protected String fromdomain;
    @XmlAttribute(name = "size", required = true)
    protected String size;
    @XmlAttribute(name = "from", required = true)
    protected String from;
    @XmlAttribute(name = "to", required = true)
    protected String to;
    @XmlAttribute(name = "host", required = true)
    protected String host;
    @XmlAttribute(name = "addr", required = true)
    protected String addr;
    @XmlAttribute(name = "reason", required = true)
    protected String reason;
    @XmlAttribute(name = "filter", required = true)
    protected String filter;
    @XmlAttribute(name = "todomain", required = true)
    protected String todomain;
    @XmlAttribute(name = "received", required = true)
    protected String received;

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
     * Obtém o valor da propriedade time.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * Define o valor da propriedade time.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * Obtém o valor da propriedade fromdomain.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromdomain() {
        return fromdomain;
    }

    /**
     * Define o valor da propriedade fromdomain.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromdomain(String value) {
        this.fromdomain = value;
    }

    /**
     * Obtém o valor da propriedade size.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSize() {
        return size;
    }

    /**
     * Define o valor da propriedade size.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSize(String value) {
        this.size = value;
    }

    /**
     * Obtém o valor da propriedade from.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrom() {
        return from;
    }

    /**
     * Define o valor da propriedade from.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrom(String value) {
        this.from = value;
    }

    /**
     * Obtém o valor da propriedade to.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTo() {
        return to;
    }

    /**
     * Define o valor da propriedade to.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTo(String value) {
        this.to = value;
    }

    /**
     * Obtém o valor da propriedade host.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHost() {
        return host;
    }

    /**
     * Define o valor da propriedade host.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHost(String value) {
        this.host = value;
    }

    /**
     * Obtém o valor da propriedade addr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddr() {
        return addr;
    }

    /**
     * Define o valor da propriedade addr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddr(String value) {
        this.addr = value;
    }

    /**
     * Obtém o valor da propriedade reason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Define o valor da propriedade reason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Obtém o valor da propriedade filter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilter() {
        return filter;
    }

    /**
     * Define o valor da propriedade filter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilter(String value) {
        this.filter = value;
    }

    /**
     * Obtém o valor da propriedade todomain.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTodomain() {
        return todomain;
    }

    /**
     * Define o valor da propriedade todomain.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTodomain(String value) {
        this.todomain = value;
    }

    /**
     * Obtém o valor da propriedade received.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceived() {
        return received;
    }

    /**
     * Define o valor da propriedade received.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceived(String value) {
        this.received = value;
    }

}
