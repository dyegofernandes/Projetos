
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de durationInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="durationInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="neg" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="w" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="d" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="h" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="m" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="related" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "durationInfo")
public class DurationInfo {

    @XmlAttribute(name = "neg")
    protected Boolean neg;
    @XmlAttribute(name = "w")
    protected Integer w;
    @XmlAttribute(name = "d")
    protected Integer d;
    @XmlAttribute(name = "h")
    protected Integer h;
    @XmlAttribute(name = "m")
    protected Integer m;
    @XmlAttribute(name = "s")
    protected Integer s;
    @XmlAttribute(name = "related")
    protected String related;
    @XmlAttribute(name = "count")
    protected Integer count;

    /**
     * Obtém o valor da propriedade neg.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeg() {
        return neg;
    }

    /**
     * Define o valor da propriedade neg.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeg(Boolean value) {
        this.neg = value;
    }

    /**
     * Obtém o valor da propriedade w.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getW() {
        return w;
    }

    /**
     * Define o valor da propriedade w.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setW(Integer value) {
        this.w = value;
    }

    /**
     * Obtém o valor da propriedade d.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getD() {
        return d;
    }

    /**
     * Define o valor da propriedade d.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setD(Integer value) {
        this.d = value;
    }

    /**
     * Obtém o valor da propriedade h.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getH() {
        return h;
    }

    /**
     * Define o valor da propriedade h.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setH(Integer value) {
        this.h = value;
    }

    /**
     * Obtém o valor da propriedade m.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getM() {
        return m;
    }

    /**
     * Define o valor da propriedade m.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setM(Integer value) {
        this.m = value;
    }

    /**
     * Obtém o valor da propriedade s.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getS() {
        return s;
    }

    /**
     * Define o valor da propriedade s.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setS(Integer value) {
        this.s = value;
    }

    /**
     * Obtém o valor da propriedade related.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelated() {
        return related;
    }

    /**
     * Define o valor da propriedade related.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelated(String value) {
        this.related = value;
    }

    /**
     * Obtém o valor da propriedade count.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Define o valor da propriedade count.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCount(Integer value) {
        this.count = value;
    }

}
