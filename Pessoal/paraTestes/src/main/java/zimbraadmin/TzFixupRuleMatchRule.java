
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tzFixupRuleMatchRule complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tzFixupRuleMatchRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="mon" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="week" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="wkday" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tzFixupRuleMatchRule")
public class TzFixupRuleMatchRule {

    @XmlAttribute(name = "mon", required = true)
    protected int mon;
    @XmlAttribute(name = "week", required = true)
    protected int week;
    @XmlAttribute(name = "wkday", required = true)
    protected int wkday;

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
     * Obtém o valor da propriedade week.
     * 
     */
    public int getWeek() {
        return week;
    }

    /**
     * Define o valor da propriedade week.
     * 
     */
    public void setWeek(int value) {
        this.week = value;
    }

    /**
     * Obtém o valor da propriedade wkday.
     * 
     */
    public int getWkday() {
        return wkday;
    }

    /**
     * Define o valor da propriedade wkday.
     * 
     */
    public void setWkday(int value) {
        this.wkday = value;
    }

}
