
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de calReply complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="calReply">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}recurIdInfo">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="at" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sentBy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ptst" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="seq" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="d" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calReply")
public class CalReply
    extends RecurIdInfo
{

    @XmlAttribute(name = "at", required = true)
    protected String at;
    @XmlAttribute(name = "sentBy")
    protected String sentBy;
    @XmlAttribute(name = "ptst")
    protected String ptst;
    @XmlAttribute(name = "seq", required = true)
    protected int seq;
    @XmlAttribute(name = "d", required = true)
    protected int d;

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
    public int getD() {
        return d;
    }

    /**
     * Define o valor da propriedade d.
     * 
     */
    public void setD(int value) {
        this.d = value;
    }

}
