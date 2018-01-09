
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de calendarItemHitInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="calendarItemHitInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}commonCalendaringData">
 *       &lt;sequence>
 *         &lt;element name="or" type="{urn:zimbraMail}calOrganizer" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="geo" type="{urn:zimbraMail}geoInfo" minOccurs="0"/>
 *         &lt;element name="fr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inst" type="{urn:zimbraMail}instanceDataInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="alarmData" type="{urn:zimbraMail}alarmDataInfo" minOccurs="0"/>
 *         &lt;element name="inv" type="{urn:zimbraMail}invitation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="replies" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="reply" type="{urn:zimbraMail}calReply" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="sf" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="d" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="cm" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="nextAlarm" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calendarItemHitInfo", propOrder = {
    "or",
    "category",
    "geo",
    "fr",
    "inst",
    "alarmData",
    "inv",
    "replies"
})
@XmlSeeAlso({
    TaskHitInfo.class,
    AppointmentHitInfo.class
})
public abstract class CalendarItemHitInfo
    extends CommonCalendaringData
{

    protected CalOrganizer or;
    protected List<String> category;
    protected GeoInfo geo;
    protected String fr;
    protected List<InstanceDataInfo> inst;
    protected AlarmDataInfo alarmData;
    protected List<Invitation> inv;
    protected CalendarItemHitInfo.Replies replies;
    @XmlAttribute(name = "sf")
    protected String sf;
    @XmlAttribute(name = "d", required = true)
    protected long d;
    @XmlAttribute(name = "cm")
    protected Boolean cm;
    @XmlAttribute(name = "nextAlarm")
    protected Long nextAlarm;

    /**
     * Obtém o valor da propriedade or.
     * 
     * @return
     *     possible object is
     *     {@link CalOrganizer }
     *     
     */
    public CalOrganizer getOr() {
        return or;
    }

    /**
     * Define o valor da propriedade or.
     * 
     * @param value
     *     allowed object is
     *     {@link CalOrganizer }
     *     
     */
    public void setOr(CalOrganizer value) {
        this.or = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the category property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCategory() {
        if (category == null) {
            category = new ArrayList<String>();
        }
        return this.category;
    }

    /**
     * Obtém o valor da propriedade geo.
     * 
     * @return
     *     possible object is
     *     {@link GeoInfo }
     *     
     */
    public GeoInfo getGeo() {
        return geo;
    }

    /**
     * Define o valor da propriedade geo.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoInfo }
     *     
     */
    public void setGeo(GeoInfo value) {
        this.geo = value;
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
     * Gets the value of the inst property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inst property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInst().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InstanceDataInfo }
     * 
     * 
     */
    public List<InstanceDataInfo> getInst() {
        if (inst == null) {
            inst = new ArrayList<InstanceDataInfo>();
        }
        return this.inst;
    }

    /**
     * Obtém o valor da propriedade alarmData.
     * 
     * @return
     *     possible object is
     *     {@link AlarmDataInfo }
     *     
     */
    public AlarmDataInfo getAlarmData() {
        return alarmData;
    }

    /**
     * Define o valor da propriedade alarmData.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmDataInfo }
     *     
     */
    public void setAlarmData(AlarmDataInfo value) {
        this.alarmData = value;
    }

    /**
     * Gets the value of the inv property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inv property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInv().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Invitation }
     * 
     * 
     */
    public List<Invitation> getInv() {
        if (inv == null) {
            inv = new ArrayList<Invitation>();
        }
        return this.inv;
    }

    /**
     * Obtém o valor da propriedade replies.
     * 
     * @return
     *     possible object is
     *     {@link CalendarItemHitInfo.Replies }
     *     
     */
    public CalendarItemHitInfo.Replies getReplies() {
        return replies;
    }

    /**
     * Define o valor da propriedade replies.
     * 
     * @param value
     *     allowed object is
     *     {@link CalendarItemHitInfo.Replies }
     *     
     */
    public void setReplies(CalendarItemHitInfo.Replies value) {
        this.replies = value;
    }

    /**
     * Obtém o valor da propriedade sf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSf() {
        return sf;
    }

    /**
     * Define o valor da propriedade sf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSf(String value) {
        this.sf = value;
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
     * Obtém o valor da propriedade cm.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCm() {
        return cm;
    }

    /**
     * Define o valor da propriedade cm.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCm(Boolean value) {
        this.cm = value;
    }

    /**
     * Obtém o valor da propriedade nextAlarm.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNextAlarm() {
        return nextAlarm;
    }

    /**
     * Define o valor da propriedade nextAlarm.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNextAlarm(Long value) {
        this.nextAlarm = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="reply" type="{urn:zimbraMail}calReply" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "reply"
    })
    public static class Replies {

        protected List<CalReply> reply;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the reply property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the reply property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReply().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CalReply }
         * 
         * 
         */
        public List<CalReply> getReply() {
            if (reply == null) {
                reply = new ArrayList<CalReply>();
            }
            return this.reply;
        }

        /**
         * Obtém o valor da propriedade unusedCodeGenHelper.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnusedCodeGenHelper() {
            return unusedCodeGenHelper;
        }

        /**
         * Define o valor da propriedade unusedCodeGenHelper.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnusedCodeGenHelper(String value) {
            this.unusedCodeGenHelper = value;
        }

    }

}
