
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de expandedRecurrenceInstance complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="expandedRecurrenceInstance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="dur" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="allDay" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="tzo" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ridZ" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "expandedRecurrenceInstance")
@XmlSeeAlso({
    ConflictRecurrenceInstance.class
})
public class ExpandedRecurrenceInstance {

    @XmlAttribute(name = "s")
    protected Long s;
    @XmlAttribute(name = "dur")
    protected Long dur;
    @XmlAttribute(name = "allDay")
    protected Boolean allDay;
    @XmlAttribute(name = "tzo")
    protected Integer tzo;
    @XmlAttribute(name = "ridZ")
    protected String ridZ;

    /**
     * Obtém o valor da propriedade s.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getS() {
        return s;
    }

    /**
     * Define o valor da propriedade s.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setS(Long value) {
        this.s = value;
    }

    /**
     * Obtém o valor da propriedade dur.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDur() {
        return dur;
    }

    /**
     * Define o valor da propriedade dur.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDur(Long value) {
        this.dur = value;
    }

    /**
     * Obtém o valor da propriedade allDay.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllDay() {
        return allDay;
    }

    /**
     * Define o valor da propriedade allDay.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllDay(Boolean value) {
        this.allDay = value;
    }

    /**
     * Obtém o valor da propriedade tzo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTzo() {
        return tzo;
    }

    /**
     * Define o valor da propriedade tzo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTzo(Integer value) {
        this.tzo = value;
    }

    /**
     * Obtém o valor da propriedade ridZ.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRidZ() {
        return ridZ;
    }

    /**
     * Define o valor da propriedade ridZ.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRidZ(String value) {
        this.ridZ = value;
    }

}
