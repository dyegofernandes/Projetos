
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.MailboxMoveType;


/**
 * <p>Classe Java de mailboxMoveInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="mailboxMoveInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="start" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="type" use="required" type="{urn:zimbra}mailboxMoveType" />
 *       &lt;attribute name="src" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dest" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="noPeer" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mailboxMoveInfo")
public class MailboxMoveInfo {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "start", required = true)
    protected long start;
    @XmlAttribute(name = "type", required = true)
    protected MailboxMoveType type;
    @XmlAttribute(name = "src", required = true)
    protected String src;
    @XmlAttribute(name = "dest", required = true)
    protected String dest;
    @XmlAttribute(name = "noPeer")
    protected Boolean noPeer;

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
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link MailboxMoveType }
     *     
     */
    public MailboxMoveType getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link MailboxMoveType }
     *     
     */
    public void setType(MailboxMoveType value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade src.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrc() {
        return src;
    }

    /**
     * Define o valor da propriedade src.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrc(String value) {
        this.src = value;
    }

    /**
     * Obtém o valor da propriedade dest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDest() {
        return dest;
    }

    /**
     * Define o valor da propriedade dest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDest(String value) {
        this.dest = value;
    }

    /**
     * Obtém o valor da propriedade noPeer.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNoPeer() {
        return noPeer;
    }

    /**
     * Define o valor da propriedade noPeer.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNoPeer(Boolean value) {
        this.noPeer = value;
    }

}
