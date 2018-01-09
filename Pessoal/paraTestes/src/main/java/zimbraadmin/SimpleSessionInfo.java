
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de simpleSessionInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="simpleSessionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="zid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cd" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="ld" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simpleSessionInfo")
public class SimpleSessionInfo {

    @XmlAttribute(name = "zid", required = true)
    protected String zid;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "sid", required = true)
    protected String sid;
    @XmlAttribute(name = "cd", required = true)
    protected long cd;
    @XmlAttribute(name = "ld", required = true)
    protected long ld;

    /**
     * Obtém o valor da propriedade zid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZid() {
        return zid;
    }

    /**
     * Define o valor da propriedade zid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZid(String value) {
        this.zid = value;
    }

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade sid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSid() {
        return sid;
    }

    /**
     * Define o valor da propriedade sid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSid(String value) {
        this.sid = value;
    }

    /**
     * Obtém o valor da propriedade cd.
     * 
     */
    public long getCd() {
        return cd;
    }

    /**
     * Define o valor da propriedade cd.
     * 
     */
    public void setCd(long value) {
        this.cd = value;
    }

    /**
     * Obtém o valor da propriedade ld.
     * 
     */
    public long getLd() {
        return ld;
    }

    /**
     * Define o valor da propriedade ld.
     * 
     */
    public void setLd(long value) {
        this.ld = value;
    }

}
