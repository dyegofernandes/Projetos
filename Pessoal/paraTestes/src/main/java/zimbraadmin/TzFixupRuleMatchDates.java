
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tzFixupRuleMatchDates complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tzFixupRuleMatchDates">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="standard" type="{urn:zimbraAdmin}tzFixupRuleMatchDate"/>
 *         &lt;element name="daylight" type="{urn:zimbraAdmin}tzFixupRuleMatchDate"/>
 *       &lt;/all>
 *       &lt;attribute name="stdoff" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="dayoff" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tzFixupRuleMatchDates", propOrder = {

})
public class TzFixupRuleMatchDates {

    @XmlElement(required = true)
    protected TzFixupRuleMatchDate standard;
    @XmlElement(required = true)
    protected TzFixupRuleMatchDate daylight;
    @XmlAttribute(name = "stdoff", required = true)
    protected long stdoff;
    @XmlAttribute(name = "dayoff", required = true)
    protected long dayoff;

    /**
     * Obtém o valor da propriedade standard.
     * 
     * @return
     *     possible object is
     *     {@link TzFixupRuleMatchDate }
     *     
     */
    public TzFixupRuleMatchDate getStandard() {
        return standard;
    }

    /**
     * Define o valor da propriedade standard.
     * 
     * @param value
     *     allowed object is
     *     {@link TzFixupRuleMatchDate }
     *     
     */
    public void setStandard(TzFixupRuleMatchDate value) {
        this.standard = value;
    }

    /**
     * Obtém o valor da propriedade daylight.
     * 
     * @return
     *     possible object is
     *     {@link TzFixupRuleMatchDate }
     *     
     */
    public TzFixupRuleMatchDate getDaylight() {
        return daylight;
    }

    /**
     * Define o valor da propriedade daylight.
     * 
     * @param value
     *     allowed object is
     *     {@link TzFixupRuleMatchDate }
     *     
     */
    public void setDaylight(TzFixupRuleMatchDate value) {
        this.daylight = value;
    }

    /**
     * Obtém o valor da propriedade stdoff.
     * 
     */
    public long getStdoff() {
        return stdoff;
    }

    /**
     * Define o valor da propriedade stdoff.
     * 
     */
    public void setStdoff(long value) {
        this.stdoff = value;
    }

    /**
     * Obtém o valor da propriedade dayoff.
     * 
     */
    public long getDayoff() {
        return dayoff;
    }

    /**
     * Define o valor da propriedade dayoff.
     * 
     */
    public void setDayoff(long value) {
        this.dayoff = value;
    }

}
