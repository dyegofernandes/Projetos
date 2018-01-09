
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.TzOnsetInfo;


/**
 * <p>Classe Java de calTZInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="calTZInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="standard" type="{urn:zimbra}tzOnsetInfo" minOccurs="0"/>
 *         &lt;element name="daylight" type="{urn:zimbra}tzOnsetInfo" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="stdoff" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="dayoff" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="stdname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dayname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calTZInfo", propOrder = {

})
public class CalTZInfo {

    protected TzOnsetInfo standard;
    protected TzOnsetInfo daylight;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "stdoff", required = true)
    protected int stdoff;
    @XmlAttribute(name = "dayoff", required = true)
    protected int dayoff;
    @XmlAttribute(name = "stdname")
    protected String stdname;
    @XmlAttribute(name = "dayname")
    protected String dayname;

    /**
     * Obtém o valor da propriedade standard.
     * 
     * @return
     *     possible object is
     *     {@link TzOnsetInfo }
     *     
     */
    public TzOnsetInfo getStandard() {
        return standard;
    }

    /**
     * Define o valor da propriedade standard.
     * 
     * @param value
     *     allowed object is
     *     {@link TzOnsetInfo }
     *     
     */
    public void setStandard(TzOnsetInfo value) {
        this.standard = value;
    }

    /**
     * Obtém o valor da propriedade daylight.
     * 
     * @return
     *     possible object is
     *     {@link TzOnsetInfo }
     *     
     */
    public TzOnsetInfo getDaylight() {
        return daylight;
    }

    /**
     * Define o valor da propriedade daylight.
     * 
     * @param value
     *     allowed object is
     *     {@link TzOnsetInfo }
     *     
     */
    public void setDaylight(TzOnsetInfo value) {
        this.daylight = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade stdoff.
     * 
     */
    public int getStdoff() {
        return stdoff;
    }

    /**
     * Define o valor da propriedade stdoff.
     * 
     */
    public void setStdoff(int value) {
        this.stdoff = value;
    }

    /**
     * Obtém o valor da propriedade dayoff.
     * 
     */
    public int getDayoff() {
        return dayoff;
    }

    /**
     * Define o valor da propriedade dayoff.
     * 
     */
    public void setDayoff(int value) {
        this.dayoff = value;
    }

    /**
     * Obtém o valor da propriedade stdname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStdname() {
        return stdname;
    }

    /**
     * Define o valor da propriedade stdname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStdname(String value) {
        this.stdname = value;
    }

    /**
     * Obtém o valor da propriedade dayname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayname() {
        return dayname;
    }

    /**
     * Define o valor da propriedade dayname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayname(String value) {
        this.dayname = value;
    }

}
