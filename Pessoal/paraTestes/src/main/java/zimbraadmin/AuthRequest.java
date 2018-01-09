
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.AccountSelector;


/**
 * <p>Classe Java de authRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="authRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="authToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="account" type="{urn:zimbra}accountSelector" minOccurs="0"/>
 *         &lt;element name="virtualHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="twoFactorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="persistAuthTokenCookie" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="csrfTokenSecured" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="password" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authRequest", propOrder = {

})
public class AuthRequest {

    protected String authToken;
    protected AccountSelector account;
    protected String virtualHost;
    protected String twoFactorCode;
    @XmlAttribute(name = "persistAuthTokenCookie")
    protected Boolean persistAuthTokenCookie;
    @XmlAttribute(name = "csrfTokenSecured")
    protected Boolean csrfTokenSecured;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "password")
    protected String password;

    /**
     * Obtém o valor da propriedade authToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * Define o valor da propriedade authToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthToken(String value) {
        this.authToken = value;
    }

    /**
     * Obtém o valor da propriedade account.
     * 
     * @return
     *     possible object is
     *     {@link AccountSelector }
     *     
     */
    public AccountSelector getAccount() {
        return account;
    }

    /**
     * Define o valor da propriedade account.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountSelector }
     *     
     */
    public void setAccount(AccountSelector value) {
        this.account = value;
    }

    /**
     * Obtém o valor da propriedade virtualHost.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVirtualHost() {
        return virtualHost;
    }

    /**
     * Define o valor da propriedade virtualHost.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVirtualHost(String value) {
        this.virtualHost = value;
    }

    /**
     * Obtém o valor da propriedade twoFactorCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTwoFactorCode() {
        return twoFactorCode;
    }

    /**
     * Define o valor da propriedade twoFactorCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTwoFactorCode(String value) {
        this.twoFactorCode = value;
    }

    /**
     * Obtém o valor da propriedade persistAuthTokenCookie.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPersistAuthTokenCookie() {
        return persistAuthTokenCookie;
    }

    /**
     * Define o valor da propriedade persistAuthTokenCookie.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPersistAuthTokenCookie(Boolean value) {
        this.persistAuthTokenCookie = value;
    }

    /**
     * Obtém o valor da propriedade csrfTokenSecured.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCsrfTokenSecured() {
        return csrfTokenSecured;
    }

    /**
     * Define o valor da propriedade csrfTokenSecured.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCsrfTokenSecured(Boolean value) {
        this.csrfTokenSecured = value;
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
     * Obtém o valor da propriedade password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define o valor da propriedade password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

}
