
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de sessionForWaitSet complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="sessionForWaitSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WaitSetSession" type="{urn:zimbraAdmin}waitSetSessionInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="account" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="types" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="token" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mboxSyncToken" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="mboxSyncTokenDiff" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sessionForWaitSet", propOrder = {
    "waitSetSession"
})
public class SessionForWaitSet {

    @XmlElement(name = "WaitSetSession")
    protected WaitSetSessionInfo waitSetSession;
    @XmlAttribute(name = "account", required = true)
    protected String account;
    @XmlAttribute(name = "types", required = true)
    protected String types;
    @XmlAttribute(name = "token")
    protected String token;
    @XmlAttribute(name = "mboxSyncToken")
    protected Integer mboxSyncToken;
    @XmlAttribute(name = "mboxSyncTokenDiff")
    protected Integer mboxSyncTokenDiff;

    /**
     * Obtém o valor da propriedade waitSetSession.
     * 
     * @return
     *     possible object is
     *     {@link WaitSetSessionInfo }
     *     
     */
    public WaitSetSessionInfo getWaitSetSession() {
        return waitSetSession;
    }

    /**
     * Define o valor da propriedade waitSetSession.
     * 
     * @param value
     *     allowed object is
     *     {@link WaitSetSessionInfo }
     *     
     */
    public void setWaitSetSession(WaitSetSessionInfo value) {
        this.waitSetSession = value;
    }

    /**
     * Obtém o valor da propriedade account.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccount() {
        return account;
    }

    /**
     * Define o valor da propriedade account.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     * Obtém o valor da propriedade types.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypes() {
        return types;
    }

    /**
     * Define o valor da propriedade types.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypes(String value) {
        this.types = value;
    }

    /**
     * Obtém o valor da propriedade token.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Define o valor da propriedade token.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Obtém o valor da propriedade mboxSyncToken.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMboxSyncToken() {
        return mboxSyncToken;
    }

    /**
     * Define o valor da propriedade mboxSyncToken.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMboxSyncToken(Integer value) {
        this.mboxSyncToken = value;
    }

    /**
     * Obtém o valor da propriedade mboxSyncTokenDiff.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMboxSyncTokenDiff() {
        return mboxSyncTokenDiff;
    }

    /**
     * Define o valor da propriedade mboxSyncTokenDiff.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMboxSyncTokenDiff(Integer value) {
        this.mboxSyncTokenDiff = value;
    }

}
