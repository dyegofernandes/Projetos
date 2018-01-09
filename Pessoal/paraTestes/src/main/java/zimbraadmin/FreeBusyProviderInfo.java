
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de freeBusyProviderInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="freeBusyProviderInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="propagate" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="start" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="end" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="queue" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="prefix" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "freeBusyProviderInfo")
public class FreeBusyProviderInfo {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "propagate", required = true)
    protected boolean propagate;
    @XmlAttribute(name = "start", required = true)
    protected long start;
    @XmlAttribute(name = "end", required = true)
    protected long end;
    @XmlAttribute(name = "queue", required = true)
    protected String queue;
    @XmlAttribute(name = "prefix", required = true)
    protected String prefix;

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
     * Obtém o valor da propriedade propagate.
     * 
     */
    public boolean isPropagate() {
        return propagate;
    }

    /**
     * Define o valor da propriedade propagate.
     * 
     */
    public void setPropagate(boolean value) {
        this.propagate = value;
    }

    /**
     * Obtém o valor da propriedade start.
     * 
     */
    public long getStart() {
        return start;
    }

    /**
     * Define o valor da propriedade start.
     * 
     */
    public void setStart(long value) {
        this.start = value;
    }

    /**
     * Obtém o valor da propriedade end.
     * 
     */
    public long getEnd() {
        return end;
    }

    /**
     * Define o valor da propriedade end.
     * 
     */
    public void setEnd(long value) {
        this.end = value;
    }

    /**
     * Obtém o valor da propriedade queue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueue() {
        return queue;
    }

    /**
     * Define o valor da propriedade queue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueue(String value) {
        this.queue = value;
    }

    /**
     * Obtém o valor da propriedade prefix.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Define o valor da propriedade prefix.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefix(String value) {
        this.prefix = value;
    }

}
