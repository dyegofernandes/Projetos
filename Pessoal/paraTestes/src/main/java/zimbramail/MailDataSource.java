
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de mailDataSource complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="mailDataSource">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lastError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="l" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="importOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="host" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="port" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="connectionType" type="{urn:zimbraMail}mdsConnectionType" />
 *       &lt;attribute name="username" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="password" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pollingInterval" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="emailAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="smtpEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="smtpHost" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="smtpPort" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="smtpConnectionType" type="{urn:zimbraMail}mdsConnectionType" />
 *       &lt;attribute name="smtpAuthRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="smtpUsername" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="smtpPassword" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="useAddressForForwardReply" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="defaultSignature" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="forwardReplySignature" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fromDisplay" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="replyToAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="replyToDisplay" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="importClass" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="failingSince" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mailDataSource", propOrder = {
    "lastError",
    "a"
})
@XmlSeeAlso({
    MailImapDataSource.class,
    MailGalDataSource.class,
    MailCalDataSource.class,
    MailYabDataSource.class,
    MailUnknownDataSource.class,
    MailPop3DataSource.class,
    MailRssDataSource.class,
    MailCaldavDataSource.class
})
public abstract class MailDataSource {

    protected String lastError;
    protected List<String> a;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "l")
    protected String l;
    @XmlAttribute(name = "isEnabled")
    protected Boolean isEnabled;
    @XmlAttribute(name = "importOnly")
    protected Boolean importOnly;
    @XmlAttribute(name = "host")
    protected String host;
    @XmlAttribute(name = "port")
    protected Integer port;
    @XmlAttribute(name = "connectionType")
    protected MdsConnectionType connectionType;
    @XmlAttribute(name = "username")
    protected String username;
    @XmlAttribute(name = "password")
    protected String password;
    @XmlAttribute(name = "pollingInterval")
    protected String pollingInterval;
    @XmlAttribute(name = "emailAddress")
    protected String emailAddress;
    @XmlAttribute(name = "smtpEnabled")
    protected Boolean smtpEnabled;
    @XmlAttribute(name = "smtpHost")
    protected String smtpHost;
    @XmlAttribute(name = "smtpPort")
    protected Integer smtpPort;
    @XmlAttribute(name = "smtpConnectionType")
    protected MdsConnectionType smtpConnectionType;
    @XmlAttribute(name = "smtpAuthRequired")
    protected Boolean smtpAuthRequired;
    @XmlAttribute(name = "smtpUsername")
    protected String smtpUsername;
    @XmlAttribute(name = "smtpPassword")
    protected String smtpPassword;
    @XmlAttribute(name = "useAddressForForwardReply")
    protected Boolean useAddressForForwardReply;
    @XmlAttribute(name = "defaultSignature")
    protected String defaultSignature;
    @XmlAttribute(name = "forwardReplySignature")
    protected String forwardReplySignature;
    @XmlAttribute(name = "fromDisplay")
    protected String fromDisplay;
    @XmlAttribute(name = "replyToAddress")
    protected String replyToAddress;
    @XmlAttribute(name = "replyToDisplay")
    protected String replyToDisplay;
    @XmlAttribute(name = "importClass")
    protected String importClass;
    @XmlAttribute(name = "failingSince")
    protected Long failingSince;

    /**
     * Obtém o valor da propriedade lastError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastError() {
        return lastError;
    }

    /**
     * Define o valor da propriedade lastError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastError(String value) {
        this.lastError = value;
    }

    /**
     * Gets the value of the a property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the a property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getA() {
        if (a == null) {
            a = new ArrayList<String>();
        }
        return this.a;
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
     * Obtém o valor da propriedade l.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getL() {
        return l;
    }

    /**
     * Define o valor da propriedade l.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setL(String value) {
        this.l = value;
    }

    /**
     * Obtém o valor da propriedade isEnabled.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsEnabled() {
        return isEnabled;
    }

    /**
     * Define o valor da propriedade isEnabled.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsEnabled(Boolean value) {
        this.isEnabled = value;
    }

    /**
     * Obtém o valor da propriedade importOnly.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isImportOnly() {
        return importOnly;
    }

    /**
     * Define o valor da propriedade importOnly.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setImportOnly(Boolean value) {
        this.importOnly = value;
    }

    /**
     * Obtém o valor da propriedade host.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHost() {
        return host;
    }

    /**
     * Define o valor da propriedade host.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHost(String value) {
        this.host = value;
    }

    /**
     * Obtém o valor da propriedade port.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Define o valor da propriedade port.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPort(Integer value) {
        this.port = value;
    }

    /**
     * Obtém o valor da propriedade connectionType.
     * 
     * @return
     *     possible object is
     *     {@link MdsConnectionType }
     *     
     */
    public MdsConnectionType getConnectionType() {
        return connectionType;
    }

    /**
     * Define o valor da propriedade connectionType.
     * 
     * @param value
     *     allowed object is
     *     {@link MdsConnectionType }
     *     
     */
    public void setConnectionType(MdsConnectionType value) {
        this.connectionType = value;
    }

    /**
     * Obtém o valor da propriedade username.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Define o valor da propriedade username.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
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
     * Obtém o valor da propriedade pollingInterval.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPollingInterval() {
        return pollingInterval;
    }

    /**
     * Define o valor da propriedade pollingInterval.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPollingInterval(String value) {
        this.pollingInterval = value;
    }

    /**
     * Obtém o valor da propriedade emailAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Define o valor da propriedade emailAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Obtém o valor da propriedade smtpEnabled.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSmtpEnabled() {
        return smtpEnabled;
    }

    /**
     * Define o valor da propriedade smtpEnabled.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSmtpEnabled(Boolean value) {
        this.smtpEnabled = value;
    }

    /**
     * Obtém o valor da propriedade smtpHost.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmtpHost() {
        return smtpHost;
    }

    /**
     * Define o valor da propriedade smtpHost.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmtpHost(String value) {
        this.smtpHost = value;
    }

    /**
     * Obtém o valor da propriedade smtpPort.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSmtpPort() {
        return smtpPort;
    }

    /**
     * Define o valor da propriedade smtpPort.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSmtpPort(Integer value) {
        this.smtpPort = value;
    }

    /**
     * Obtém o valor da propriedade smtpConnectionType.
     * 
     * @return
     *     possible object is
     *     {@link MdsConnectionType }
     *     
     */
    public MdsConnectionType getSmtpConnectionType() {
        return smtpConnectionType;
    }

    /**
     * Define o valor da propriedade smtpConnectionType.
     * 
     * @param value
     *     allowed object is
     *     {@link MdsConnectionType }
     *     
     */
    public void setSmtpConnectionType(MdsConnectionType value) {
        this.smtpConnectionType = value;
    }

    /**
     * Obtém o valor da propriedade smtpAuthRequired.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSmtpAuthRequired() {
        return smtpAuthRequired;
    }

    /**
     * Define o valor da propriedade smtpAuthRequired.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSmtpAuthRequired(Boolean value) {
        this.smtpAuthRequired = value;
    }

    /**
     * Obtém o valor da propriedade smtpUsername.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmtpUsername() {
        return smtpUsername;
    }

    /**
     * Define o valor da propriedade smtpUsername.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmtpUsername(String value) {
        this.smtpUsername = value;
    }

    /**
     * Obtém o valor da propriedade smtpPassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmtpPassword() {
        return smtpPassword;
    }

    /**
     * Define o valor da propriedade smtpPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmtpPassword(String value) {
        this.smtpPassword = value;
    }

    /**
     * Obtém o valor da propriedade useAddressForForwardReply.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseAddressForForwardReply() {
        return useAddressForForwardReply;
    }

    /**
     * Define o valor da propriedade useAddressForForwardReply.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseAddressForForwardReply(Boolean value) {
        this.useAddressForForwardReply = value;
    }

    /**
     * Obtém o valor da propriedade defaultSignature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultSignature() {
        return defaultSignature;
    }

    /**
     * Define o valor da propriedade defaultSignature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultSignature(String value) {
        this.defaultSignature = value;
    }

    /**
     * Obtém o valor da propriedade forwardReplySignature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForwardReplySignature() {
        return forwardReplySignature;
    }

    /**
     * Define o valor da propriedade forwardReplySignature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForwardReplySignature(String value) {
        this.forwardReplySignature = value;
    }

    /**
     * Obtém o valor da propriedade fromDisplay.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromDisplay() {
        return fromDisplay;
    }

    /**
     * Define o valor da propriedade fromDisplay.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromDisplay(String value) {
        this.fromDisplay = value;
    }

    /**
     * Obtém o valor da propriedade replyToAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplyToAddress() {
        return replyToAddress;
    }

    /**
     * Define o valor da propriedade replyToAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplyToAddress(String value) {
        this.replyToAddress = value;
    }

    /**
     * Obtém o valor da propriedade replyToDisplay.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplyToDisplay() {
        return replyToDisplay;
    }

    /**
     * Define o valor da propriedade replyToDisplay.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplyToDisplay(String value) {
        this.replyToDisplay = value;
    }

    /**
     * Obtém o valor da propriedade importClass.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportClass() {
        return importClass;
    }

    /**
     * Define o valor da propriedade importClass.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportClass(String value) {
        this.importClass = value;
    }

    /**
     * Obtém o valor da propriedade failingSince.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFailingSince() {
        return failingSince;
    }

    /**
     * Define o valor da propriedade failingSince.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFailingSince(Long value) {
        this.failingSince = value;
    }

}
