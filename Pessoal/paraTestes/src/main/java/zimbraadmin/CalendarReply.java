
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de calendarReply complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="calendarReply">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraAdmin}recurIdInfo">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="seq" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="d" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="at" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sentBy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ptst" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calendarReply")
public class CalendarReply
    extends RecurIdInfo
{

    @XmlAttribute(name = "seq", required = true)
    protected int seq;
    @XmlAttribute(name = "d", required = true)
    protected long d;
    @XmlAttribute(name = "at", required = true)
    protected String at;
    @XmlAttribute(name = "sentBy")
    protected String sentBy;
    @XmlAttribute(name = "ptst")
    protected String ptst;

    /**
     * Obtém o valor da propriedade seq.
     * 
     */
    public int getSeq() {
        return seq;
    }

    /**
     * Define o valor da propriedade seq.
     * 
     */
    public void setSeq(int value) {
        this.seq = value;
    }

    /**
     * Obtém o valor da propriedade d.
     * 
     */
    public long getD() {
        return d;
    }

    /**
     * Define o valor da propriedade d.
     * 
     */
    public void setD(long value) {
        this.d = value;
    }

    /**
     * Obtém o valor da propriedade at.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAt() {
        return at;
    }

    /**
     * Define o valor da propriedade at.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAt(String value) {
        this.at = value;
    }

    /**
     * Obtém o valor da propriedade sentBy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSentBy() {
        return sentBy;
    }

    /**
     * Define o valor da propriedade sentBy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSentBy(String value) {
        this.sentBy = value;
    }

    /**
     * Obtém o valor da propriedade ptst.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPtst() {
        return ptst;
    }

    /**
     * Define o valor da propriedade ptst.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPtst(String value) {
        this.ptst = value;
    }

}
