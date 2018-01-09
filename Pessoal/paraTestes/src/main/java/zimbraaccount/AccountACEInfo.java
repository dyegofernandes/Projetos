
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.GranteeType;


/**
 * <p>Classe Java de accountACEInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="accountACEInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="zid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="gt" use="required" type="{urn:zimbra}granteeType" />
 *       &lt;attribute name="right" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="d" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pw" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="deny" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="chkgt" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountACEInfo")
public class AccountACEInfo {

    @XmlAttribute(name = "zid")
    protected String zid;
    @XmlAttribute(name = "gt", required = true)
    protected GranteeType gt;
    @XmlAttribute(name = "right", required = true)
    protected String right;
    @XmlAttribute(name = "d")
    protected String d;
    @XmlAttribute(name = "key")
    protected String key;
    @XmlAttribute(name = "pw")
    protected String pw;
    @XmlAttribute(name = "deny")
    protected Boolean deny;
    @XmlAttribute(name = "chkgt")
    protected Boolean chkgt;

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
     * Obtém o valor da propriedade gt.
     * 
     * @return
     *     possible object is
     *     {@link GranteeType }
     *     
     */
    public GranteeType getGt() {
        return gt;
    }

    /**
     * Define o valor da propriedade gt.
     * 
     * @param value
     *     allowed object is
     *     {@link GranteeType }
     *     
     */
    public void setGt(GranteeType value) {
        this.gt = value;
    }

    /**
     * Obtém o valor da propriedade right.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRight() {
        return right;
    }

    /**
     * Define o valor da propriedade right.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRight(String value) {
        this.right = value;
    }

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
     * Obtém o valor da propriedade key.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Define o valor da propriedade key.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Obtém o valor da propriedade pw.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPw() {
        return pw;
    }

    /**
     * Define o valor da propriedade pw.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPw(String value) {
        this.pw = value;
    }

    /**
     * Obtém o valor da propriedade deny.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeny() {
        return deny;
    }

    /**
     * Define o valor da propriedade deny.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeny(Boolean value) {
        this.deny = value;
    }

    /**
     * Obtém o valor da propriedade chkgt.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChkgt() {
        return chkgt;
    }

    /**
     * Define o valor da propriedade chkgt.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChkgt(Boolean value) {
        this.chkgt = value;
    }

}
