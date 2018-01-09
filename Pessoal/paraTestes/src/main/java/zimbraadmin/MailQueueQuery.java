
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de mailQueueQuery complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="mailQueueQuery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:zimbraAdmin}query"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="scan" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="wait" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mailQueueQuery", propOrder = {
    "query"
})
public class MailQueueQuery {

    @XmlElement(required = true)
    protected QueueQuery query;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "scan")
    protected Boolean scan;
    @XmlAttribute(name = "wait")
    protected Long wait;

    /**
     * Obtém o valor da propriedade query.
     * 
     * @return
     *     possible object is
     *     {@link QueueQuery }
     *     
     */
    public QueueQuery getQuery() {
        return query;
    }

    /**
     * Define o valor da propriedade query.
     * 
     * @param value
     *     allowed object is
     *     {@link QueueQuery }
     *     
     */
    public void setQuery(QueueQuery value) {
        this.query = value;
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
     * Obtém o valor da propriedade scan.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isScan() {
        return scan;
    }

    /**
     * Define o valor da propriedade scan.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setScan(Boolean value) {
        this.scan = value;
    }

    /**
     * Obtém o valor da propriedade wait.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWait() {
        return wait;
    }

    /**
     * Define o valor da propriedade wait.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWait(Long value) {
        this.wait = value;
    }

}
