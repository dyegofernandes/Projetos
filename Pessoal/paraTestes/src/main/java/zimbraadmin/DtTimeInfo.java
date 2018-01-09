
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de dtTimeInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dtTimeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="d" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tz" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="u" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtTimeInfo")
public class DtTimeInfo {

    @XmlAttribute(name = "d")
    protected String d;
    @XmlAttribute(name = "tz")
    protected String tz;
    @XmlAttribute(name = "u")
    protected Long u;

    /**
     * Obtém o valor da propriedade d.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getD() {
        return d;
    }

    /**
     * Define o valor da propriedade d.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setD(String value) {
        this.d = value;
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
     * Obtém o valor da propriedade u.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getU() {
        return u;
    }

    /**
     * Define o valor da propriedade u.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setU(Long value) {
        this.u = value;
    }

}
