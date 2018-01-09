
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de simpleRepeatingRule complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="simpleRepeatingRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="until" type="{urn:zimbraMail}dateTimeStringAttr" minOccurs="0"/>
 *         &lt;element name="count" type="{urn:zimbraMail}numAttr" minOccurs="0"/>
 *         &lt;element name="interval" type="{urn:zimbraMail}intervalRule" minOccurs="0"/>
 *         &lt;element name="bysecond" type="{urn:zimbraMail}bySecondRule" minOccurs="0"/>
 *         &lt;element name="byminute" type="{urn:zimbraMail}byMinuteRule" minOccurs="0"/>
 *         &lt;element name="byhour" type="{urn:zimbraMail}byHourRule" minOccurs="0"/>
 *         &lt;element name="byday" type="{urn:zimbraMail}byDayRule" minOccurs="0"/>
 *         &lt;element name="bymonthday" type="{urn:zimbraMail}byMonthDayRule" minOccurs="0"/>
 *         &lt;element name="byyearday" type="{urn:zimbraMail}byYearDayRule" minOccurs="0"/>
 *         &lt;element name="byweekno" type="{urn:zimbraMail}byWeekNoRule" minOccurs="0"/>
 *         &lt;element name="bymonth" type="{urn:zimbraMail}byMonthRule" minOccurs="0"/>
 *         &lt;element name="bysetpos" type="{urn:zimbraMail}bySetPosRule" minOccurs="0"/>
 *         &lt;element name="wkst" type="{urn:zimbraMail}wkstRule" minOccurs="0"/>
 *         &lt;element name="rule-x-name" type="{urn:zimbraMail}xNameRule" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="freq" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simpleRepeatingRule", propOrder = {
    "until",
    "count",
    "interval",
    "bysecond",
    "byminute",
    "byhour",
    "byday",
    "bymonthday",
    "byyearday",
    "byweekno",
    "bymonth",
    "bysetpos",
    "wkst",
    "ruleXName"
})
public class SimpleRepeatingRule {

    protected DateTimeStringAttr until;
    protected NumAttr count;
    protected IntervalRule interval;
    protected BySecondRule bysecond;
    protected ByMinuteRule byminute;
    protected ByHourRule byhour;
    protected ByDayRule byday;
    protected ByMonthDayRule bymonthday;
    protected ByYearDayRule byyearday;
    protected ByWeekNoRule byweekno;
    protected ByMonthRule bymonth;
    protected BySetPosRule bysetpos;
    protected WkstRule wkst;
    @XmlElement(name = "rule-x-name")
    protected List<XNameRule> ruleXName;
    @XmlAttribute(name = "freq", required = true)
    protected String freq;

    /**
     * Obtém o valor da propriedade until.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeStringAttr }
     *     
     */
    public DateTimeStringAttr getUntil() {
        return until;
    }

    /**
     * Define o valor da propriedade until.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeStringAttr }
     *     
     */
    public void setUntil(DateTimeStringAttr value) {
        this.until = value;
    }

    /**
     * Obtém o valor da propriedade count.
     * 
     * @return
     *     possible object is
     *     {@link NumAttr }
     *     
     */
    public NumAttr getCount() {
        return count;
    }

    /**
     * Define o valor da propriedade count.
     * 
     * @param value
     *     allowed object is
     *     {@link NumAttr }
     *     
     */
    public void setCount(NumAttr value) {
        this.count = value;
    }

    /**
     * Obtém o valor da propriedade interval.
     * 
     * @return
     *     possible object is
     *     {@link IntervalRule }
     *     
     */
    public IntervalRule getInterval() {
        return interval;
    }

    /**
     * Define o valor da propriedade interval.
     * 
     * @param value
     *     allowed object is
     *     {@link IntervalRule }
     *     
     */
    public void setInterval(IntervalRule value) {
        this.interval = value;
    }

    /**
     * Obtém o valor da propriedade bysecond.
     * 
     * @return
     *     possible object is
     *     {@link BySecondRule }
     *     
     */
    public BySecondRule getBysecond() {
        return bysecond;
    }

    /**
     * Define o valor da propriedade bysecond.
     * 
     * @param value
     *     allowed object is
     *     {@link BySecondRule }
     *     
     */
    public void setBysecond(BySecondRule value) {
        this.bysecond = value;
    }

    /**
     * Obtém o valor da propriedade byminute.
     * 
     * @return
     *     possible object is
     *     {@link ByMinuteRule }
     *     
     */
    public ByMinuteRule getByminute() {
        return byminute;
    }

    /**
     * Define o valor da propriedade byminute.
     * 
     * @param value
     *     allowed object is
     *     {@link ByMinuteRule }
     *     
     */
    public void setByminute(ByMinuteRule value) {
        this.byminute = value;
    }

    /**
     * Obtém o valor da propriedade byhour.
     * 
     * @return
     *     possible object is
     *     {@link ByHourRule }
     *     
     */
    public ByHourRule getByhour() {
        return byhour;
    }

    /**
     * Define o valor da propriedade byhour.
     * 
     * @param value
     *     allowed object is
     *     {@link ByHourRule }
     *     
     */
    public void setByhour(ByHourRule value) {
        this.byhour = value;
    }

    /**
     * Obtém o valor da propriedade byday.
     * 
     * @return
     *     possible object is
     *     {@link ByDayRule }
     *     
     */
    public ByDayRule getByday() {
        return byday;
    }

    /**
     * Define o valor da propriedade byday.
     * 
     * @param value
     *     allowed object is
     *     {@link ByDayRule }
     *     
     */
    public void setByday(ByDayRule value) {
        this.byday = value;
    }

    /**
     * Obtém o valor da propriedade bymonthday.
     * 
     * @return
     *     possible object is
     *     {@link ByMonthDayRule }
     *     
     */
    public ByMonthDayRule getBymonthday() {
        return bymonthday;
    }

    /**
     * Define o valor da propriedade bymonthday.
     * 
     * @param value
     *     allowed object is
     *     {@link ByMonthDayRule }
     *     
     */
    public void setBymonthday(ByMonthDayRule value) {
        this.bymonthday = value;
    }

    /**
     * Obtém o valor da propriedade byyearday.
     * 
     * @return
     *     possible object is
     *     {@link ByYearDayRule }
     *     
     */
    public ByYearDayRule getByyearday() {
        return byyearday;
    }

    /**
     * Define o valor da propriedade byyearday.
     * 
     * @param value
     *     allowed object is
     *     {@link ByYearDayRule }
     *     
     */
    public void setByyearday(ByYearDayRule value) {
        this.byyearday = value;
    }

    /**
     * Obtém o valor da propriedade byweekno.
     * 
     * @return
     *     possible object is
     *     {@link ByWeekNoRule }
     *     
     */
    public ByWeekNoRule getByweekno() {
        return byweekno;
    }

    /**
     * Define o valor da propriedade byweekno.
     * 
     * @param value
     *     allowed object is
     *     {@link ByWeekNoRule }
     *     
     */
    public void setByweekno(ByWeekNoRule value) {
        this.byweekno = value;
    }

    /**
     * Obtém o valor da propriedade bymonth.
     * 
     * @return
     *     possible object is
     *     {@link ByMonthRule }
     *     
     */
    public ByMonthRule getBymonth() {
        return bymonth;
    }

    /**
     * Define o valor da propriedade bymonth.
     * 
     * @param value
     *     allowed object is
     *     {@link ByMonthRule }
     *     
     */
    public void setBymonth(ByMonthRule value) {
        this.bymonth = value;
    }

    /**
     * Obtém o valor da propriedade bysetpos.
     * 
     * @return
     *     possible object is
     *     {@link BySetPosRule }
     *     
     */
    public BySetPosRule getBysetpos() {
        return bysetpos;
    }

    /**
     * Define o valor da propriedade bysetpos.
     * 
     * @param value
     *     allowed object is
     *     {@link BySetPosRule }
     *     
     */
    public void setBysetpos(BySetPosRule value) {
        this.bysetpos = value;
    }

    /**
     * Obtém o valor da propriedade wkst.
     * 
     * @return
     *     possible object is
     *     {@link WkstRule }
     *     
     */
    public WkstRule getWkst() {
        return wkst;
    }

    /**
     * Define o valor da propriedade wkst.
     * 
     * @param value
     *     allowed object is
     *     {@link WkstRule }
     *     
     */
    public void setWkst(WkstRule value) {
        this.wkst = value;
    }

    /**
     * Gets the value of the ruleXName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ruleXName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRuleXName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XNameRule }
     * 
     * 
     */
    public List<XNameRule> getRuleXName() {
        if (ruleXName == null) {
            ruleXName = new ArrayList<XNameRule>();
        }
        return this.ruleXName;
    }

    /**
     * Obtém o valor da propriedade freq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreq() {
        return freq;
    }

    /**
     * Define o valor da propriedade freq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreq(String value) {
        this.freq = value;
    }

}
