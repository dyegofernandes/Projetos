
package zimbraadminext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de generateBulkProvisionFileFromLDAPRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="generateBulkProvisionFileFromLDAPRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraAdminExt}attrsImpl">
 *       &lt;sequence>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="generatePassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="genPasswordLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fileFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mustChangePassword" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="maxResults" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SMTPHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SMTPPort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importMails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importContacts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importCalendar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importTasks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importJunk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importDeletedItems" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ignorePreviouslyImported" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvalidSSLOk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MapiProfile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MapiServer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MapiLogonUserDN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZimbraAdminLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZimbraAdminPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetDomainName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provisionUsers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generateBulkProvisionFileFromLDAPRequest", propOrder = {
    "password",
    "generatePassword",
    "genPasswordLength",
    "fileFormat",
    "mustChangePassword",
    "maxResults",
    "smtpHost",
    "smtpPort",
    "importMails",
    "importContacts",
    "importCalendar",
    "importTasks",
    "importJunk",
    "importDeletedItems",
    "ignorePreviouslyImported",
    "invalidSSLOk",
    "mapiProfile",
    "mapiServer",
    "mapiLogonUserDN",
    "zimbraAdminLogin",
    "zimbraAdminPassword",
    "targetDomainName",
    "provisionUsers"
})
public class GenerateBulkProvisionFileFromLDAPRequest
    extends AttrsImpl
{

    protected String password;
    protected String generatePassword;
    protected Integer genPasswordLength;
    protected String fileFormat;
    @XmlElement(required = true)
    protected String mustChangePassword;
    protected Integer maxResults;
    @XmlElement(name = "SMTPHost")
    protected String smtpHost;
    @XmlElement(name = "SMTPPort")
    protected String smtpPort;
    protected String importMails;
    protected String importContacts;
    protected String importCalendar;
    protected String importTasks;
    protected String importJunk;
    protected String importDeletedItems;
    protected String ignorePreviouslyImported;
    @XmlElement(name = "InvalidSSLOk")
    protected String invalidSSLOk;
    @XmlElement(name = "MapiProfile")
    protected String mapiProfile;
    @XmlElement(name = "MapiServer")
    protected String mapiServer;
    @XmlElement(name = "MapiLogonUserDN")
    protected String mapiLogonUserDN;
    @XmlElement(name = "ZimbraAdminLogin")
    protected String zimbraAdminLogin;
    @XmlElement(name = "ZimbraAdminPassword")
    protected String zimbraAdminPassword;
    @XmlElement(name = "TargetDomainName")
    protected String targetDomainName;
    protected String provisionUsers;

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
     * Obtém o valor da propriedade generatePassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneratePassword() {
        return generatePassword;
    }

    /**
     * Define o valor da propriedade generatePassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneratePassword(String value) {
        this.generatePassword = value;
    }

    /**
     * Obtém o valor da propriedade genPasswordLength.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGenPasswordLength() {
        return genPasswordLength;
    }

    /**
     * Define o valor da propriedade genPasswordLength.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGenPasswordLength(Integer value) {
        this.genPasswordLength = value;
    }

    /**
     * Obtém o valor da propriedade fileFormat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileFormat() {
        return fileFormat;
    }

    /**
     * Define o valor da propriedade fileFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileFormat(String value) {
        this.fileFormat = value;
    }

    /**
     * Obtém o valor da propriedade mustChangePassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMustChangePassword() {
        return mustChangePassword;
    }

    /**
     * Define o valor da propriedade mustChangePassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMustChangePassword(String value) {
        this.mustChangePassword = value;
    }

    /**
     * Obtém o valor da propriedade maxResults.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxResults() {
        return maxResults;
    }

    /**
     * Define o valor da propriedade maxResults.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxResults(Integer value) {
        this.maxResults = value;
    }

    /**
     * Obtém o valor da propriedade smtpHost.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMTPHost() {
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
    public void setSMTPHost(String value) {
        this.smtpHost = value;
    }

    /**
     * Obtém o valor da propriedade smtpPort.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMTPPort() {
        return smtpPort;
    }

    /**
     * Define o valor da propriedade smtpPort.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMTPPort(String value) {
        this.smtpPort = value;
    }

    /**
     * Obtém o valor da propriedade importMails.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportMails() {
        return importMails;
    }

    /**
     * Define o valor da propriedade importMails.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportMails(String value) {
        this.importMails = value;
    }

    /**
     * Obtém o valor da propriedade importContacts.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportContacts() {
        return importContacts;
    }

    /**
     * Define o valor da propriedade importContacts.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportContacts(String value) {
        this.importContacts = value;
    }

    /**
     * Obtém o valor da propriedade importCalendar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportCalendar() {
        return importCalendar;
    }

    /**
     * Define o valor da propriedade importCalendar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportCalendar(String value) {
        this.importCalendar = value;
    }

    /**
     * Obtém o valor da propriedade importTasks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportTasks() {
        return importTasks;
    }

    /**
     * Define o valor da propriedade importTasks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportTasks(String value) {
        this.importTasks = value;
    }

    /**
     * Obtém o valor da propriedade importJunk.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportJunk() {
        return importJunk;
    }

    /**
     * Define o valor da propriedade importJunk.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportJunk(String value) {
        this.importJunk = value;
    }

    /**
     * Obtém o valor da propriedade importDeletedItems.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportDeletedItems() {
        return importDeletedItems;
    }

    /**
     * Define o valor da propriedade importDeletedItems.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportDeletedItems(String value) {
        this.importDeletedItems = value;
    }

    /**
     * Obtém o valor da propriedade ignorePreviouslyImported.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIgnorePreviouslyImported() {
        return ignorePreviouslyImported;
    }

    /**
     * Define o valor da propriedade ignorePreviouslyImported.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIgnorePreviouslyImported(String value) {
        this.ignorePreviouslyImported = value;
    }

    /**
     * Obtém o valor da propriedade invalidSSLOk.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvalidSSLOk() {
        return invalidSSLOk;
    }

    /**
     * Define o valor da propriedade invalidSSLOk.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvalidSSLOk(String value) {
        this.invalidSSLOk = value;
    }

    /**
     * Obtém o valor da propriedade mapiProfile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapiProfile() {
        return mapiProfile;
    }

    /**
     * Define o valor da propriedade mapiProfile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapiProfile(String value) {
        this.mapiProfile = value;
    }

    /**
     * Obtém o valor da propriedade mapiServer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapiServer() {
        return mapiServer;
    }

    /**
     * Define o valor da propriedade mapiServer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapiServer(String value) {
        this.mapiServer = value;
    }

    /**
     * Obtém o valor da propriedade mapiLogonUserDN.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapiLogonUserDN() {
        return mapiLogonUserDN;
    }

    /**
     * Define o valor da propriedade mapiLogonUserDN.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapiLogonUserDN(String value) {
        this.mapiLogonUserDN = value;
    }

    /**
     * Obtém o valor da propriedade zimbraAdminLogin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZimbraAdminLogin() {
        return zimbraAdminLogin;
    }

    /**
     * Define o valor da propriedade zimbraAdminLogin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZimbraAdminLogin(String value) {
        this.zimbraAdminLogin = value;
    }

    /**
     * Obtém o valor da propriedade zimbraAdminPassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZimbraAdminPassword() {
        return zimbraAdminPassword;
    }

    /**
     * Define o valor da propriedade zimbraAdminPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZimbraAdminPassword(String value) {
        this.zimbraAdminPassword = value;
    }

    /**
     * Obtém o valor da propriedade targetDomainName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetDomainName() {
        return targetDomainName;
    }

    /**
     * Define o valor da propriedade targetDomainName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetDomainName(String value) {
        this.targetDomainName = value;
    }

    /**
     * Obtém o valor da propriedade provisionUsers.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvisionUsers() {
        return provisionUsers;
    }

    /**
     * Define o valor da propriedade provisionUsers.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvisionUsers(String value) {
        this.provisionUsers = value;
    }

}
