
package zimbraaccount;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="account" type="{urn:zimbra}accountSelector" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preauth" type="{urn:zimbraAccount}preAuth" minOccurs="0"/>
 *         &lt;element name="authToken" type="{urn:zimbraAccount}authToken" minOccurs="0"/>
 *         &lt;element name="virtualHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prefs" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="pref" type="{urn:zimbraAccount}pref" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="attrs" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="attr" type="{urn:zimbraAccount}attr" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="requestedSkin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="twoFactorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trustedToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deviceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="persistAuthTokenCookie" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="csrfTokenSecured" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="deviceTrusted" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="generateDeviceId" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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

    protected AccountSelector account;
    protected String password;
    protected PreAuth preauth;
    protected AuthToken authToken;
    protected String virtualHost;
    protected AuthRequest.Prefs prefs;
    protected AuthRequest.Attrs attrs;
    protected String requestedSkin;
    protected String twoFactorCode;
    protected String trustedToken;
    protected String deviceId;
    @XmlAttribute(name = "persistAuthTokenCookie")
    protected Boolean persistAuthTokenCookie;
    @XmlAttribute(name = "csrfTokenSecured")
    protected Boolean csrfTokenSecured;
    @XmlAttribute(name = "deviceTrusted")
    protected Boolean deviceTrusted;
    @XmlAttribute(name = "generateDeviceId")
    protected Boolean generateDeviceId;

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

    /**
     * Obtém o valor da propriedade preauth.
     * 
     * @return
     *     possible object is
     *     {@link PreAuth }
     *     
     */
    public PreAuth getPreauth() {
        return preauth;
    }

    /**
     * Define o valor da propriedade preauth.
     * 
     * @param value
     *     allowed object is
     *     {@link PreAuth }
     *     
     */
    public void setPreauth(PreAuth value) {
        this.preauth = value;
    }

    /**
     * Obtém o valor da propriedade authToken.
     * 
     * @return
     *     possible object is
     *     {@link AuthToken }
     *     
     */
    public AuthToken getAuthToken() {
        return authToken;
    }

    /**
     * Define o valor da propriedade authToken.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthToken }
     *     
     */
    public void setAuthToken(AuthToken value) {
        this.authToken = value;
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
     * Obtém o valor da propriedade prefs.
     * 
     * @return
     *     possible object is
     *     {@link AuthRequest.Prefs }
     *     
     */
    public AuthRequest.Prefs getPrefs() {
        return prefs;
    }

    /**
     * Define o valor da propriedade prefs.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthRequest.Prefs }
     *     
     */
    public void setPrefs(AuthRequest.Prefs value) {
        this.prefs = value;
    }

    /**
     * Obtém o valor da propriedade attrs.
     * 
     * @return
     *     possible object is
     *     {@link AuthRequest.Attrs }
     *     
     */
    public AuthRequest.Attrs getAttrs() {
        return attrs;
    }

    /**
     * Define o valor da propriedade attrs.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthRequest.Attrs }
     *     
     */
    public void setAttrs(AuthRequest.Attrs value) {
        this.attrs = value;
    }

    /**
     * Obtém o valor da propriedade requestedSkin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedSkin() {
        return requestedSkin;
    }

    /**
     * Define o valor da propriedade requestedSkin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedSkin(String value) {
        this.requestedSkin = value;
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
     * Obtém o valor da propriedade trustedToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrustedToken() {
        return trustedToken;
    }

    /**
     * Define o valor da propriedade trustedToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrustedToken(String value) {
        this.trustedToken = value;
    }

    /**
     * Obtém o valor da propriedade deviceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Define o valor da propriedade deviceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceId(String value) {
        this.deviceId = value;
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
     * Obtém o valor da propriedade deviceTrusted.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeviceTrusted() {
        return deviceTrusted;
    }

    /**
     * Define o valor da propriedade deviceTrusted.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeviceTrusted(Boolean value) {
        this.deviceTrusted = value;
    }

    /**
     * Obtém o valor da propriedade generateDeviceId.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGenerateDeviceId() {
        return generateDeviceId;
    }

    /**
     * Define o valor da propriedade generateDeviceId.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGenerateDeviceId(Boolean value) {
        this.generateDeviceId = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="attr" type="{urn:zimbraAccount}attr" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "attr"
    })
    public static class Attrs {

        protected List<Attr> attr;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the attr property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the attr property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAttr().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Attr }
         * 
         * 
         */
        public List<Attr> getAttr() {
            if (attr == null) {
                attr = new ArrayList<Attr>();
            }
            return this.attr;
        }

        /**
         * Obtém o valor da propriedade unusedCodeGenHelper.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnusedCodeGenHelper() {
            return unusedCodeGenHelper;
        }

        /**
         * Define o valor da propriedade unusedCodeGenHelper.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnusedCodeGenHelper(String value) {
            this.unusedCodeGenHelper = value;
        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="pref" type="{urn:zimbraAccount}pref" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "pref"
    })
    public static class Prefs {

        protected List<Pref> pref;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the pref property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the pref property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPref().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Pref }
         * 
         * 
         */
        public List<Pref> getPref() {
            if (pref == null) {
                pref = new ArrayList<Pref>();
            }
            return this.pref;
        }

        /**
         * Obtém o valor da propriedade unusedCodeGenHelper.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnusedCodeGenHelper() {
            return unusedCodeGenHelper;
        }

        /**
         * Define o valor da propriedade unusedCodeGenHelper.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnusedCodeGenHelper(String value) {
            this.unusedCodeGenHelper = value;
        }

    }

}
