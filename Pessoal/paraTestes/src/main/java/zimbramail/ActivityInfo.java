
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.NamedValue;


/**
 * <p>Classe Java de activityInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="activityInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg" type="{urn:zimbra}namedValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="op" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ts" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="itemId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ver" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ua" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="email" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activityInfo", propOrder = {
    "arg"
})
public class ActivityInfo {

    protected List<NamedValue> arg;
    @XmlAttribute(name = "op", required = true)
    protected String op;
    @XmlAttribute(name = "ts", required = true)
    protected long ts;
    @XmlAttribute(name = "itemId", required = true)
    protected String itemId;
    @XmlAttribute(name = "ver")
    protected Integer ver;
    @XmlAttribute(name = "ua")
    protected String ua;
    @XmlAttribute(name = "email")
    protected String email;

    /**
     * Gets the value of the arg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NamedValue }
     * 
     * 
     */
    public List<NamedValue> getArg() {
        if (arg == null) {
            arg = new ArrayList<NamedValue>();
        }
        return this.arg;
    }

    /**
     * Obtém o valor da propriedade op.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOp() {
        return op;
    }

    /**
     * Define o valor da propriedade op.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOp(String value) {
        this.op = value;
    }

    /**
     * Obtém o valor da propriedade ts.
     * 
     */
    public long getTs() {
        return ts;
    }

    /**
     * Define o valor da propriedade ts.
     * 
     */
    public void setTs(long value) {
        this.ts = value;
    }

    /**
     * Obtém o valor da propriedade itemId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Define o valor da propriedade itemId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemId(String value) {
        this.itemId = value;
    }

    /**
     * Obtém o valor da propriedade ver.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVer() {
        return ver;
    }

    /**
     * Define o valor da propriedade ver.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVer(Integer value) {
        this.ver = value;
    }

    /**
     * Obtém o valor da propriedade ua.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUa() {
        return ua;
    }

    /**
     * Define o valor da propriedade ua.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUa(String value) {
        this.ua = value;
    }

    /**
     * Obtém o valor da propriedade email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o valor da propriedade email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

}
