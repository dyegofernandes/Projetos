
package zimbra;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tzOnsetInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tzOnsetInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="week" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="wkday" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="mon" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="mday" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="hour" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="min" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="sec" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tzOnsetInfo")
public class TzOnsetInfo {

    @XmlAttribute(name = "week")
    protected Integer week;
    @XmlAttribute(name = "wkday")
    protected Integer wkday;
    @XmlAttribute(name = "mon", required = true)
    protected int mon;
    @XmlAttribute(name = "mday")
    protected Integer mday;
    @XmlAttribute(name = "hour", required = true)
    protected int hour;
    @XmlAttribute(name = "min", required = true)
    protected int min;
    @XmlAttribute(name = "sec", required = true)
    protected int sec;

    /**
     * Obtém o valor da propriedade week.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWeek() {
        return week;
    }

    /**
     * Define o valor da propriedade week.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWeek(Integer value) {
        this.week = value;
    }

    /**
     * Obtém o valor da propriedade wkday.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWkday() {
        return wkday;
    }

    /**
     * Define o valor da propriedade wkday.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWkday(Integer value) {
        this.wkday = value;
    }

    /**
     * Obtém o valor da propriedade mon.
     * 
     */
    public int getMon() {
        return mon;
    }

    /**
     * Define o valor da propriedade mon.
     * 
     */
    public void setMon(int value) {
        this.mon = value;
    }

    /**
     * Obtém o valor da propriedade mday.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMday() {
        return mday;
    }

    /**
     * Define o valor da propriedade mday.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMday(Integer value) {
        this.mday = value;
    }

    /**
     * Obtém o valor da propriedade hour.
     * 
     */
    public int getHour() {
        return hour;
    }

    /**
     * Define o valor da propriedade hour.
     * 
     */
    public void setHour(int value) {
        this.hour = value;
    }

    /**
     * Obtém o valor da propriedade min.
     * 
     */
    public int getMin() {
        return min;
    }

    /**
     * Define o valor da propriedade min.
     * 
     */
    public void setMin(int value) {
        this.min = value;
    }

    /**
     * Obtém o valor da propriedade sec.
     * 
     */
    public int getSec() {
        return sec;
    }

    /**
     * Define o valor da propriedade sec.
     * 
     */
    public void setSec(int value) {
        this.sec = value;
    }

}
