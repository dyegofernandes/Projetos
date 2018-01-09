
package zimbraaccount;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de authResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="authResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="authToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lifetime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="trustLifetime" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="session" type="{urn:zimbraAccount}session" minOccurs="0"/>
 *         &lt;element name="refer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="skin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csrfToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deviceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trustedToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="twoFactorAuthRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="trustedDevicesEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="zmgProxy" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authResponse", propOrder = {

})
public class AuthResponse {

    @XmlElement(required = true)
    protected String authToken;
    protected long lifetime;
    protected Long trustLifetime;
    protected Session session;
    protected String refer;
    protected String skin;
    protected String csrfToken;
    protected String deviceId;
    protected String trustedToken;
    protected AuthResponse.Prefs prefs;
    protected AuthResponse.Attrs attrs;
    protected Boolean twoFactorAuthRequired;
    protected Boolean trustedDevicesEnabled;
    @XmlAttribute(name = "zmgProxy")
    protected Boolean zmgProxy;

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
     * Obtém o valor da propriedade lifetime.
     * 
     */
    public long getLifetime() {
        return lifetime;
    }

    /**
     * Define o valor da propriedade lifetime.
     * 
     */
    public void setLifetime(long value) {
        this.lifetime = value;
    }

    /**
     * Obtém o valor da propriedade trustLifetime.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTrustLifetime() {
        return trustLifetime;
    }

    /**
     * Define o valor da propriedade trustLifetime.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTrustLifetime(Long value) {
        this.trustLifetime = value;
    }

    /**
     * Obtém o valor da propriedade session.
     * 
     * @return
     *     possible object is
     *     {@link Session }
     *     
     */
    public Session getSession() {
        return session;
    }

    /**
     * Define o valor da propriedade session.
     * 
     * @param value
     *     allowed object is
     *     {@link Session }
     *     
     */
    public void setSession(Session value) {
        this.session = value;
    }

    /**
     * Obtém o valor da propriedade refer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefer() {
        return refer;
    }

    /**
     * Define o valor da propriedade refer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefer(String value) {
        this.refer = value;
    }

    /**
     * Obtém o valor da propriedade skin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkin() {
        return skin;
    }

    /**
     * Define o valor da propriedade skin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkin(String value) {
        this.skin = value;
    }

    /**
     * Obtém o valor da propriedade csrfToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsrfToken() {
        return csrfToken;
    }

    /**
     * Define o valor da propriedade csrfToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsrfToken(String value) {
        this.csrfToken = value;
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
     * Obtém o valor da propriedade prefs.
     * 
     * @return
     *     possible object is
     *     {@link AuthResponse.Prefs }
     *     
     */
    public AuthResponse.Prefs getPrefs() {
        return prefs;
    }

    /**
     * Define o valor da propriedade prefs.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthResponse.Prefs }
     *     
     */
    public void setPrefs(AuthResponse.Prefs value) {
        this.prefs = value;
    }

    /**
     * Obtém o valor da propriedade attrs.
     * 
     * @return
     *     possible object is
     *     {@link AuthResponse.Attrs }
     *     
     */
    public AuthResponse.Attrs getAttrs() {
        return attrs;
    }

    /**
     * Define o valor da propriedade attrs.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthResponse.Attrs }
     *     
     */
    public void setAttrs(AuthResponse.Attrs value) {
        this.attrs = value;
    }

    /**
     * Obtém o valor da propriedade twoFactorAuthRequired.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTwoFactorAuthRequired() {
        return twoFactorAuthRequired;
    }

    /**
     * Define o valor da propriedade twoFactorAuthRequired.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTwoFactorAuthRequired(Boolean value) {
        this.twoFactorAuthRequired = value;
    }

    /**
     * Obtém o valor da propriedade trustedDevicesEnabled.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTrustedDevicesEnabled() {
        return trustedDevicesEnabled;
    }

    /**
     * Define o valor da propriedade trustedDevicesEnabled.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTrustedDevicesEnabled(Boolean value) {
        this.trustedDevicesEnabled = value;
    }

    /**
     * Obtém o valor da propriedade zmgProxy.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isZmgProxy() {
        return zmgProxy;
    }

    /**
     * Define o valor da propriedade zmgProxy.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setZmgProxy(Boolean value) {
        this.zmgProxy = value;
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
