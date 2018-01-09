
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de calendarAttendee complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="calendarAttendee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xparam" type="{urn:zimbraMail}xParam" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="a" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="d" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sentBy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dir" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="lang" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cutype" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="role" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ptst" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rsvp" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="member" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="delTo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="delFrom" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calendarAttendee", propOrder = {
    "xparam"
})
@XmlSeeAlso({
    CalendarAttendeeWithGroupInfo.class
})
public class CalendarAttendee {

    protected List<XParam> xparam;
    @XmlAttribute(name = "a")
    protected String a;
    @XmlAttribute(name = "url")
    protected String url;
    @XmlAttribute(name = "d")
    protected String d;
    @XmlAttribute(name = "sentBy")
    protected String sentBy;
    @XmlAttribute(name = "dir")
    protected String dir;
    @XmlAttribute(name = "lang")
    protected String lang;
    @XmlAttribute(name = "cutype")
    protected String cutype;
    @XmlAttribute(name = "role")
    protected String role;
    @XmlAttribute(name = "ptst")
    protected String ptst;
    @XmlAttribute(name = "rsvp")
    protected Boolean rsvp;
    @XmlAttribute(name = "member")
    protected String member;
    @XmlAttribute(name = "delTo")
    protected String delTo;
    @XmlAttribute(name = "delFrom")
    protected String delFrom;

    /**
     * Gets the value of the xparam property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the xparam property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXparam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XParam }
     * 
     * 
     */
    public List<XParam> getXparam() {
        if (xparam == null) {
            xparam = new ArrayList<XParam>();
        }
        return this.xparam;
    }

    /**
     * Obtém o valor da propriedade a.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getA() {
        return a;
    }

    /**
     * Define o valor da propriedade a.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setA(String value) {
        this.a = value;
    }

    /**
     * Obtém o valor da propriedade url.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Define o valor da propriedade url.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Obtém o valor da propriedade d.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getD() {
        return d;
    }

    /**
     * Define o valor da propriedade d.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setD(String value) {
        this.d = value;
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
     * Obtém o valor da propriedade dir.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDir() {
        return dir;
    }

    /**
     * Define o valor da propriedade dir.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDir(String value) {
        this.dir = value;
    }

    /**
     * Obtém o valor da propriedade lang.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Define o valor da propriedade lang.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Obtém o valor da propriedade cutype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCutype() {
        return cutype;
    }

    /**
     * Define o valor da propriedade cutype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCutype(String value) {
        this.cutype = value;
    }

    /**
     * Obtém o valor da propriedade role.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Define o valor da propriedade role.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
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
     * Obtém o valor da propriedade rsvp.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRsvp() {
        return rsvp;
    }

    /**
     * Define o valor da propriedade rsvp.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRsvp(Boolean value) {
        this.rsvp = value;
    }

    /**
     * Obtém o valor da propriedade member.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMember() {
        return member;
    }

    /**
     * Define o valor da propriedade member.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMember(String value) {
        this.member = value;
    }

    /**
     * Obtém o valor da propriedade delTo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelTo() {
        return delTo;
    }

    /**
     * Define o valor da propriedade delTo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelTo(String value) {
        this.delTo = value;
    }

    /**
     * Obtém o valor da propriedade delFrom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelFrom() {
        return delFrom;
    }

    /**
     * Define o valor da propriedade delFrom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelFrom(String value) {
        this.delFrom = value;
    }

}
