
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de alarmDataInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="alarmDataInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarm" type="{urn:zimbraMail}alarmInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nextAlarm" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="alarmInstStart" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="invId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="compNum" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="loc" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alarmDataInfo", propOrder = {
    "alarm"
})
public class AlarmDataInfo {

    protected AlarmInfo alarm;
    @XmlAttribute(name = "nextAlarm")
    protected Long nextAlarm;
    @XmlAttribute(name = "alarmInstStart")
    protected Long alarmInstStart;
    @XmlAttribute(name = "invId")
    protected Integer invId;
    @XmlAttribute(name = "compNum")
    protected Integer compNum;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "loc")
    protected String loc;

    /**
     * Obtém o valor da propriedade alarm.
     * 
     * @return
     *     possible object is
     *     {@link AlarmInfo }
     *     
     */
    public AlarmInfo getAlarm() {
        return alarm;
    }

    /**
     * Define o valor da propriedade alarm.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmInfo }
     *     
     */
    public void setAlarm(AlarmInfo value) {
        this.alarm = value;
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
     * Obtém o valor da propriedade alarmInstStart.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAlarmInstStart() {
        return alarmInstStart;
    }

    /**
     * Define o valor da propriedade alarmInstStart.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAlarmInstStart(Long value) {
        this.alarmInstStart = value;
    }

    /**
     * Obtém o valor da propriedade invId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInvId() {
        return invId;
    }

    /**
     * Define o valor da propriedade invId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInvId(Integer value) {
        this.invId = value;
    }

    /**
     * Obtém o valor da propriedade compNum.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCompNum() {
        return compNum;
    }

    /**
     * Define o valor da propriedade compNum.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCompNum(Integer value) {
        this.compNum = value;
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
     * Obtém o valor da propriedade loc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoc() {
        return loc;
    }

    /**
     * Define o valor da propriedade loc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoc(String value) {
        this.loc = value;
    }

}
