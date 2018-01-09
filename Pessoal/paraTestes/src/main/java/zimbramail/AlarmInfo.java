
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de alarmInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="alarmInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trigger" type="{urn:zimbraMail}alarmTriggerInfo" minOccurs="0"/>
 *         &lt;element name="repeat" type="{urn:zimbraMail}durationInfo" minOccurs="0"/>
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attach" type="{urn:zimbraMail}calendarAttach" minOccurs="0"/>
 *         &lt;element name="summary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="at" type="{urn:zimbraMail}calendarAttendee" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="xprop" type="{urn:zimbraMail}xProp" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alarmInfo", propOrder = {
    "trigger",
    "repeat",
    "desc",
    "attach",
    "summary",
    "at",
    "xprop"
})
public class AlarmInfo {

    protected AlarmTriggerInfo trigger;
    protected DurationInfo repeat;
    protected String desc;
    protected CalendarAttach attach;
    protected String summary;
    protected List<CalendarAttendee> at;
    protected List<XProp> xprop;
    @XmlAttribute(name = "action", required = true)
    protected String action;

    /**
     * Obtém o valor da propriedade trigger.
     * 
     * @return
     *     possible object is
     *     {@link AlarmTriggerInfo }
     *     
     */
    public AlarmTriggerInfo getTrigger() {
        return trigger;
    }

    /**
     * Define o valor da propriedade trigger.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmTriggerInfo }
     *     
     */
    public void setTrigger(AlarmTriggerInfo value) {
        this.trigger = value;
    }

    /**
     * Obtém o valor da propriedade repeat.
     * 
     * @return
     *     possible object is
     *     {@link DurationInfo }
     *     
     */
    public DurationInfo getRepeat() {
        return repeat;
    }

    /**
     * Define o valor da propriedade repeat.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationInfo }
     *     
     */
    public void setRepeat(DurationInfo value) {
        this.repeat = value;
    }

    /**
     * Obtém o valor da propriedade desc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Define o valor da propriedade desc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Obtém o valor da propriedade attach.
     * 
     * @return
     *     possible object is
     *     {@link CalendarAttach }
     *     
     */
    public CalendarAttach getAttach() {
        return attach;
    }

    /**
     * Define o valor da propriedade attach.
     * 
     * @param value
     *     allowed object is
     *     {@link CalendarAttach }
     *     
     */
    public void setAttach(CalendarAttach value) {
        this.attach = value;
    }

    /**
     * Obtém o valor da propriedade summary.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Define o valor da propriedade summary.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSummary(String value) {
        this.summary = value;
    }

    /**
     * Gets the value of the at property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the at property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalendarAttendee }
     * 
     * 
     */
    public List<CalendarAttendee> getAt() {
        if (at == null) {
            at = new ArrayList<CalendarAttendee>();
        }
        return this.at;
    }

    /**
     * Gets the value of the xprop property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the xprop property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXprop().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XProp }
     * 
     * 
     */
    public List<XProp> getXprop() {
        if (xprop == null) {
            xprop = new ArrayList<XProp>();
        }
        return this.xprop;
    }

    /**
     * Obtém o valor da propriedade action.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Define o valor da propriedade action.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

}
