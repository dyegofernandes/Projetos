
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tzFixupRuleMatchRules complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tzFixupRuleMatchRules">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="standard" type="{urn:zimbraAdmin}tzFixupRuleMatchRule"/>
 *         &lt;element name="daylight" type="{urn:zimbraAdmin}tzFixupRuleMatchRule"/>
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
@XmlType(name = "tzFixupRuleMatchRules", propOrder = {

})
public class TzFixupRuleMatchRules {

    @XmlElement(required = true)
    protected TzFixupRuleMatchRule standard;
    @XmlElement(required = true)
    protected TzFixupRuleMatchRule daylight;
    @XmlAttribute(name = "stdoff", required = true)
    protected long stdoff;
    @XmlAttribute(name = "dayoff", required = true)
    protected long dayoff;

    /**
     * Obtém o valor da propriedade standard.
     * 
     * @return
     *     possible object is
     *     {@link TzFixupRuleMatchRule }
     *     
     */
    public TzFixupRuleMatchRule getStandard() {
        return standard;
    }

    /**
     * Define o valor da propriedade standard.
     * 
     * @param value
     *     allowed object is
     *     {@link TzFixupRuleMatchRule }
     *     
     */
    public void setStandard(TzFixupRuleMatchRule value) {
        this.standard = value;
    }

    /**
     * Obtém o valor da propriedade daylight.
     * 
     * @return
     *     possible object is
     *     {@link TzFixupRuleMatchRule }
     *     
     */
    public TzFixupRuleMatchRule getDaylight() {
        return daylight;
    }

    /**
     * Define o valor da propriedade daylight.
     * 
     * @param value
     *     allowed object is
     *     {@link TzFixupRuleMatchRule }
     *     
     */
    public void setDaylight(TzFixupRuleMatchRule value) {
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
