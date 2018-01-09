
package zimbra;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de HeaderContext complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="HeaderContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="authToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="session" type="{urn:zimbra}headerSessionInfo" minOccurs="0"/>
 *         &lt;element name="sessionId" type="{urn:zimbra}headerSessionInfo" minOccurs="0"/>
 *         &lt;element name="nosession" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="account" type="{urn:zimbra}headerAccountInfo" minOccurs="0"/>
 *         &lt;element name="change" type="{urn:zimbra}headerChangeInfo" minOccurs="0"/>
 *         &lt;element name="targetServer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userAgent" type="{urn:zimbra}headerUserAgentInfo" minOccurs="0"/>
 *         &lt;element name="authTokenControl" type="{urn:zimbra}authTokenControl" minOccurs="0"/>
 *         &lt;element name="format" type="{urn:zimbra}headerFormatInfo" minOccurs="0"/>
 *         &lt;element name="notify" type="{urn:zimbra}headerNotifyInfo" minOccurs="0"/>
 *         &lt;element name="nonotify" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noqualify" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="via" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="soapId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="csrfToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="hops" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderContext", propOrder = {

})
public class HeaderContext {

    protected String authToken;
    protected HeaderSessionInfo session;
    protected HeaderSessionInfo sessionId;
    protected String nosession;
    protected HeaderAccountInfo account;
    protected HeaderChangeInfo change;
    protected String targetServer;
    protected HeaderUserAgentInfo userAgent;
    protected AuthTokenControl authTokenControl;
    protected HeaderFormatInfo format;
    protected HeaderNotifyInfo notify;
    protected String nonotify;
    protected String noqualify;
    protected String via;
    protected String soapId;
    protected String csrfToken;
    @XmlAttribute(name = "hops")
    protected Integer hops;

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
     * Obtém o valor da propriedade session.
     * 
     * @return
     *     possible object is
     *     {@link HeaderSessionInfo }
     *     
     */
    public HeaderSessionInfo getSession() {
        return session;
    }

    /**
     * Define o valor da propriedade session.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderSessionInfo }
     *     
     */
    public void setSession(HeaderSessionInfo value) {
        this.session = value;
    }

    /**
     * Obtém o valor da propriedade sessionId.
     * 
     * @return
     *     possible object is
     *     {@link HeaderSessionInfo }
     *     
     */
    public HeaderSessionInfo getSessionId() {
        return sessionId;
    }

    /**
     * Define o valor da propriedade sessionId.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderSessionInfo }
     *     
     */
    public void setSessionId(HeaderSessionInfo value) {
        this.sessionId = value;
    }

    /**
     * Obtém o valor da propriedade nosession.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNosession() {
        return nosession;
    }

    /**
     * Define o valor da propriedade nosession.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNosession(String value) {
        this.nosession = value;
    }

    /**
     * Obtém o valor da propriedade account.
     * 
     * @return
     *     possible object is
     *     {@link HeaderAccountInfo }
     *     
     */
    public HeaderAccountInfo getAccount() {
        return account;
    }

    /**
     * Define o valor da propriedade account.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderAccountInfo }
     *     
     */
    public void setAccount(HeaderAccountInfo value) {
        this.account = value;
    }

    /**
     * Obtém o valor da propriedade change.
     * 
     * @return
     *     possible object is
     *     {@link HeaderChangeInfo }
     *     
     */
    public HeaderChangeInfo getChange() {
        return change;
    }

    /**
     * Define o valor da propriedade change.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderChangeInfo }
     *     
     */
    public void setChange(HeaderChangeInfo value) {
        this.change = value;
    }

    /**
     * Obtém o valor da propriedade targetServer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetServer() {
        return targetServer;
    }

    /**
     * Define o valor da propriedade targetServer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetServer(String value) {
        this.targetServer = value;
    }

    /**
     * Obtém o valor da propriedade userAgent.
     * 
     * @return
     *     possible object is
     *     {@link HeaderUserAgentInfo }
     *     
     */
    public HeaderUserAgentInfo getUserAgent() {
        return userAgent;
    }

    /**
     * Define o valor da propriedade userAgent.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderUserAgentInfo }
     *     
     */
    public void setUserAgent(HeaderUserAgentInfo value) {
        this.userAgent = value;
    }

    /**
     * Obtém o valor da propriedade authTokenControl.
     * 
     * @return
     *     possible object is
     *     {@link AuthTokenControl }
     *     
     */
    public AuthTokenControl getAuthTokenControl() {
        return authTokenControl;
    }

    /**
     * Define o valor da propriedade authTokenControl.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthTokenControl }
     *     
     */
    public void setAuthTokenControl(AuthTokenControl value) {
        this.authTokenControl = value;
    }

    /**
     * Obtém o valor da propriedade format.
     * 
     * @return
     *     possible object is
     *     {@link HeaderFormatInfo }
     *     
     */
    public HeaderFormatInfo getFormat() {
        return format;
    }

    /**
     * Define o valor da propriedade format.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderFormatInfo }
     *     
     */
    public void setFormat(HeaderFormatInfo value) {
        this.format = value;
    }

    /**
     * Obtém o valor da propriedade notify.
     * 
     * @return
     *     possible object is
     *     {@link HeaderNotifyInfo }
     *     
     */
    public HeaderNotifyInfo getNotify() {
        return notify;
    }

    /**
     * Define o valor da propriedade notify.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderNotifyInfo }
     *     
     */
    public void setNotify(HeaderNotifyInfo value) {
        this.notify = value;
    }

    /**
     * Obtém o valor da propriedade nonotify.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonotify() {
        return nonotify;
    }

    /**
     * Define o valor da propriedade nonotify.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonotify(String value) {
        this.nonotify = value;
    }

    /**
     * Obtém o valor da propriedade noqualify.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoqualify() {
        return noqualify;
    }

    /**
     * Define o valor da propriedade noqualify.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoqualify(String value) {
        this.noqualify = value;
    }

    /**
     * Obtém o valor da propriedade via.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVia() {
        return via;
    }

    /**
     * Define o valor da propriedade via.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVia(String value) {
        this.via = value;
    }

    /**
     * Obtém o valor da propriedade soapId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoapId() {
        return soapId;
    }

    /**
     * Define o valor da propriedade soapId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoapId(String value) {
        this.soapId = value;
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
     * Obtém o valor da propriedade hops.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHops() {
        return hops;
    }

    /**
     * Define o valor da propriedade hops.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHops(Integer value) {
        this.hops = value;
    }

}
