
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de conversationSummary complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="conversationSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:zimbraMail}meta" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="su" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="e" type="{urn:zimbraMail}emailInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="n" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="u" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="total" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="f" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="t" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tn" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="d" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="elided" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="md" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="ms" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conversationSummary", propOrder = {
    "meta",
    "su",
    "fr",
    "e"
})
@XmlSeeAlso({
    ConversationHitInfo.class
})
public class ConversationSummary {

    protected List<MailCustomMetadata> meta;
    protected String su;
    protected String fr;
    protected List<EmailInfo> e;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "n")
    protected Integer n;
    @XmlAttribute(name = "u")
    protected Integer u;
    @XmlAttribute(name = "total")
    protected Integer total;
    @XmlAttribute(name = "f")
    protected String f;
    @XmlAttribute(name = "t")
    protected String t;
    @XmlAttribute(name = "tn")
    protected String tn;
    @XmlAttribute(name = "d")
    protected Long d;
    @XmlAttribute(name = "elided")
    protected Boolean elided;
    @XmlAttribute(name = "md")
    protected Long md;
    @XmlAttribute(name = "ms")
    protected Integer ms;

    /**
     * Gets the value of the meta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MailCustomMetadata }
     * 
     * 
     */
    public List<MailCustomMetadata> getMeta() {
        if (meta == null) {
            meta = new ArrayList<MailCustomMetadata>();
        }
        return this.meta;
    }

    /**
     * Obtém o valor da propriedade su.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSu() {
        return su;
    }

    /**
     * Define o valor da propriedade su.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSu(String value) {
        this.su = value;
    }

    /**
     * Obtém o valor da propriedade fr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFr() {
        return fr;
    }

    /**
     * Define o valor da propriedade fr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFr(String value) {
        this.fr = value;
    }

    /**
     * Gets the value of the e property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the e property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmailInfo }
     * 
     * 
     */
    public List<EmailInfo> getE() {
        if (e == null) {
            e = new ArrayList<EmailInfo>();
        }
        return this.e;
    }

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
     * Obtém o valor da propriedade n.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getN() {
        return n;
    }

    /**
     * Define o valor da propriedade n.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setN(Integer value) {
        this.n = value;
    }

    /**
     * Obtém o valor da propriedade u.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getU() {
        return u;
    }

    /**
     * Define o valor da propriedade u.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setU(Integer value) {
        this.u = value;
    }

    /**
     * Obtém o valor da propriedade total.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Define o valor da propriedade total.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotal(Integer value) {
        this.total = value;
    }

    /**
     * Obtém o valor da propriedade f.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getF() {
        return f;
    }

    /**
     * Define o valor da propriedade f.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setF(String value) {
        this.f = value;
    }

    /**
     * Obtém o valor da propriedade t.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getT() {
        return t;
    }

    /**
     * Define o valor da propriedade t.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setT(String value) {
        this.t = value;
    }

    /**
     * Obtém o valor da propriedade tn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTn() {
        return tn;
    }

    /**
     * Define o valor da propriedade tn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTn(String value) {
        this.tn = value;
    }

    /**
     * Obtém o valor da propriedade d.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getD() {
        return d;
    }

    /**
     * Define o valor da propriedade d.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setD(Long value) {
        this.d = value;
    }

    /**
     * Obtém o valor da propriedade elided.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isElided() {
        return elided;
    }

    /**
     * Define o valor da propriedade elided.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setElided(Boolean value) {
        this.elided = value;
    }

    /**
     * Obtém o valor da propriedade md.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMd() {
        return md;
    }

    /**
     * Define o valor da propriedade md.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMd(Long value) {
        this.md = value;
    }

    /**
     * Obtém o valor da propriedade ms.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMs() {
        return ms;
    }

    /**
     * Define o valor da propriedade ms.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMs(Integer value) {
        this.ms = value;
    }

}
