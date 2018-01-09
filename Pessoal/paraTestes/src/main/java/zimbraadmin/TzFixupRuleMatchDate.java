
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tzFixupRuleMatchDate complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tzFixupRuleMatchDate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="mon" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="mday" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tzFixupRuleMatchDate")
public class TzFixupRuleMatchDate {

    @XmlAttribute(name = "mon", required = true)
    protected int mon;
    @XmlAttribute(name = "mday", required = true)
    protected int mday;

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
     */
    public int getMday() {
        return mday;
    }

    /**
     * Define o valor da propriedade mday.
     * 
     */
    public void setMday(int value) {
        this.mday = value;
    }

}
