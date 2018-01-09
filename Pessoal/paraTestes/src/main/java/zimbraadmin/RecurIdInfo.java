
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de recurIdInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="recurIdInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="rangeType" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="recurId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tz" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ridZ" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recurIdInfo")
@XmlSeeAlso({
    CancelRuleInfo.class,
    CalendarReply.class,
    ExceptionRuleInfo.class
})
public class RecurIdInfo {

    @XmlAttribute(name = "rangeType", required = true)
    protected int rangeType;
    @XmlAttribute(name = "recurId", required = true)
    protected String recurId;
    @XmlAttribute(name = "tz")
    protected String tz;
    @XmlAttribute(name = "ridZ")
    protected String ridZ;

    /**
     * Obtém o valor da propriedade rangeType.
     * 
     */
    public int getRangeType() {
        return rangeType;
    }

    /**
     * Define o valor da propriedade rangeType.
     * 
     */
    public void setRangeType(int value) {
        this.rangeType = value;
    }

    /**
     * Obtém o valor da propriedade recurId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecurId() {
        return recurId;
    }

    /**
     * Define o valor da propriedade recurId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecurId(String value) {
        this.recurId = value;
    }

    /**
     * Obtém o valor da propriedade tz.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTz() {
        return tz;
    }

    /**
     * Define o valor da propriedade tz.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTz(String value) {
        this.tz = value;
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
