
package zimbraaccount;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getInfoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="crumb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lifetime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="adminDelegated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="rest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="used" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="prevSession" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="accessed" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="recent" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cos" type="{urn:zimbraAccount}cos" minOccurs="0"/>
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
 *         &lt;element name="zimlets" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="zimlet" type="{urn:zimbraAccount}accountZimletInfo" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="props" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="prop" type="{urn:zimbraAccount}prop" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="identities" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="identity" type="{urn:zimbraAccount}identity" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="signatures" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{urn:zimbraAccount}signature" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="dataSources" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                     &lt;element name="imap" type="{urn:zimbraAccount}accountImapDataSource"/>
 *                     &lt;element name="pop3" type="{urn:zimbraAccount}accountPop3DataSource"/>
 *                     &lt;element name="caldav" type="{urn:zimbraAccount}accountCaldavDataSource"/>
 *                     &lt;element name="yab" type="{urn:zimbraAccount}accountYabDataSource"/>
 *                     &lt;element name="rss" type="{urn:zimbraAccount}accountRssDataSource"/>
 *                     &lt;element name="gal" type="{urn:zimbraAccount}accountGalDataSource"/>
 *                     &lt;element name="cal" type="{urn:zimbraAccount}accountCalDataSource"/>
 *                     &lt;element name="unknown" type="{urn:zimbraAccount}accountUnknownDataSource"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="childAccounts" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="childAccount" type="{urn:zimbraAccount}childAccount" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="rights" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="targets" type="{urn:zimbraAccount}discoverRightsInfo" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="soapURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publicURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="changePasswordURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="license" type="{urn:zimbraAccount}licenseInfo" minOccurs="0"/>
 *         &lt;element name="adminURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="boshURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="attSizeLimit" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="docSizeLimit" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getInfoResponse", propOrder = {
    "version",
    "id",
    "name",
    "crumb",
    "lifetime",
    "adminDelegated",
    "rest",
    "used",
    "prevSession",
    "accessed",
    "recent",
    "cos",
    "prefs",
    "attrs",
    "zimlets",
    "props",
    "identities",
    "signatures",
    "dataSources",
    "childAccounts",
    "rights",
    "soapURL",
    "publicURL",
    "changePasswordURL",
    "license",
    "adminURL",
    "boshURL"
})
public class GetInfoResponse {

    @XmlElement(required = true)
    protected String version;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String name;
    protected String crumb;
    protected long lifetime;
    protected Boolean adminDelegated;
    protected String rest;
    protected Long used;
    protected Long prevSession;
    protected Long accessed;
    protected Integer recent;
    protected Cos cos;
    protected GetInfoResponse.Prefs prefs;
    protected GetInfoResponse.Attrs attrs;
    protected GetInfoResponse.Zimlets zimlets;
    protected GetInfoResponse.Props props;
    protected GetInfoResponse.Identities identities;
    protected GetInfoResponse.Signatures signatures;
    protected GetInfoResponse.DataSources dataSources;
    protected GetInfoResponse.ChildAccounts childAccounts;
    protected GetInfoResponse.Rights rights;
    protected String soapURL;
    protected String publicURL;
    protected String changePasswordURL;
    protected LicenseInfo license;
    protected String adminURL;
    protected String boshURL;
    @XmlAttribute(name = "attSizeLimit")
    protected Long attSizeLimit;
    @XmlAttribute(name = "docSizeLimit")
    protected Long docSizeLimit;

    /**
     * Obtém o valor da propriedade version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Define o valor da propriedade version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
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
     * Obtém o valor da propriedade crumb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrumb() {
        return crumb;
    }

    /**
     * Define o valor da propriedade crumb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrumb(String value) {
        this.crumb = value;
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
     * Obtém o valor da propriedade adminDelegated.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAdminDelegated() {
        return adminDelegated;
    }

    /**
     * Define o valor da propriedade adminDelegated.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAdminDelegated(Boolean value) {
        this.adminDelegated = value;
    }

    /**
     * Obtém o valor da propriedade rest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRest() {
        return rest;
    }

    /**
     * Define o valor da propriedade rest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRest(String value) {
        this.rest = value;
    }

    /**
     * Obtém o valor da propriedade used.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUsed() {
        return used;
    }

    /**
     * Define o valor da propriedade used.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUsed(Long value) {
        this.used = value;
    }

    /**
     * Obtém o valor da propriedade prevSession.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrevSession() {
        return prevSession;
    }

    /**
     * Define o valor da propriedade prevSession.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrevSession(Long value) {
        this.prevSession = value;
    }

    /**
     * Obtém o valor da propriedade accessed.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccessed() {
        return accessed;
    }

    /**
     * Define o valor da propriedade accessed.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccessed(Long value) {
        this.accessed = value;
    }

    /**
     * Obtém o valor da propriedade recent.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRecent() {
        return recent;
    }

    /**
     * Define o valor da propriedade recent.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRecent(Integer value) {
        this.recent = value;
    }

    /**
     * Obtém o valor da propriedade cos.
     * 
     * @return
     *     possible object is
     *     {@link Cos }
     *     
     */
    public Cos getCos() {
        return cos;
    }

    /**
     * Define o valor da propriedade cos.
     * 
     * @param value
     *     allowed object is
     *     {@link Cos }
     *     
     */
    public void setCos(Cos value) {
        this.cos = value;
    }

    /**
     * Obtém o valor da propriedade prefs.
     * 
     * @return
     *     possible object is
     *     {@link GetInfoResponse.Prefs }
     *     
     */
    public GetInfoResponse.Prefs getPrefs() {
        return prefs;
    }

    /**
     * Define o valor da propriedade prefs.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInfoResponse.Prefs }
     *     
     */
    public void setPrefs(GetInfoResponse.Prefs value) {
        this.prefs = value;
    }

    /**
     * Obtém o valor da propriedade attrs.
     * 
     * @return
     *     possible object is
     *     {@link GetInfoResponse.Attrs }
     *     
     */
    public GetInfoResponse.Attrs getAttrs() {
        return attrs;
    }

    /**
     * Define o valor da propriedade attrs.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInfoResponse.Attrs }
     *     
     */
    public void setAttrs(GetInfoResponse.Attrs value) {
        this.attrs = value;
    }

    /**
     * Obtém o valor da propriedade zimlets.
     * 
     * @return
     *     possible object is
     *     {@link GetInfoResponse.Zimlets }
     *     
     */
    public GetInfoResponse.Zimlets getZimlets() {
        return zimlets;
    }

    /**
     * Define o valor da propriedade zimlets.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInfoResponse.Zimlets }
     *     
     */
    public void setZimlets(GetInfoResponse.Zimlets value) {
        this.zimlets = value;
    }

    /**
     * Obtém o valor da propriedade props.
     * 
     * @return
     *     possible object is
     *     {@link GetInfoResponse.Props }
     *     
     */
    public GetInfoResponse.Props getProps() {
        return props;
    }

    /**
     * Define o valor da propriedade props.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInfoResponse.Props }
     *     
     */
    public void setProps(GetInfoResponse.Props value) {
        this.props = value;
    }

    /**
     * Obtém o valor da propriedade identities.
     * 
     * @return
     *     possible object is
     *     {@link GetInfoResponse.Identities }
     *     
     */
    public GetInfoResponse.Identities getIdentities() {
        return identities;
    }

    /**
     * Define o valor da propriedade identities.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInfoResponse.Identities }
     *     
     */
    public void setIdentities(GetInfoResponse.Identities value) {
        this.identities = value;
    }

    /**
     * Obtém o valor da propriedade signatures.
     * 
     * @return
     *     possible object is
     *     {@link GetInfoResponse.Signatures }
     *     
     */
    public GetInfoResponse.Signatures getSignatures() {
        return signatures;
    }

    /**
     * Define o valor da propriedade signatures.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInfoResponse.Signatures }
     *     
     */
    public void setSignatures(GetInfoResponse.Signatures value) {
        this.signatures = value;
    }

    /**
     * Obtém o valor da propriedade dataSources.
     * 
     * @return
     *     possible object is
     *     {@link GetInfoResponse.DataSources }
     *     
     */
    public GetInfoResponse.DataSources getDataSources() {
        return dataSources;
    }

    /**
     * Define o valor da propriedade dataSources.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInfoResponse.DataSources }
     *     
     */
    public void setDataSources(GetInfoResponse.DataSources value) {
        this.dataSources = value;
    }

    /**
     * Obtém o valor da propriedade childAccounts.
     * 
     * @return
     *     possible object is
     *     {@link GetInfoResponse.ChildAccounts }
     *     
     */
    public GetInfoResponse.ChildAccounts getChildAccounts() {
        return childAccounts;
    }

    /**
     * Define o valor da propriedade childAccounts.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInfoResponse.ChildAccounts }
     *     
     */
    public void setChildAccounts(GetInfoResponse.ChildAccounts value) {
        this.childAccounts = value;
    }

    /**
     * Obtém o valor da propriedade rights.
     * 
     * @return
     *     possible object is
     *     {@link GetInfoResponse.Rights }
     *     
     */
    public GetInfoResponse.Rights getRights() {
        return rights;
    }

    /**
     * Define o valor da propriedade rights.
     * 
     * @param value
     *     allowed object is
     *     {@link GetInfoResponse.Rights }
     *     
     */
    public void setRights(GetInfoResponse.Rights value) {
        this.rights = value;
    }

    /**
     * Obtém o valor da propriedade soapURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoapURL() {
        return soapURL;
    }

    /**
     * Define o valor da propriedade soapURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoapURL(String value) {
        this.soapURL = value;
    }

    /**
     * Obtém o valor da propriedade publicURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicURL() {
        return publicURL;
    }

    /**
     * Define o valor da propriedade publicURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicURL(String value) {
        this.publicURL = value;
    }

    /**
     * Obtém o valor da propriedade changePasswordURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangePasswordURL() {
        return changePasswordURL;
    }

    /**
     * Define o valor da propriedade changePasswordURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangePasswordURL(String value) {
        this.changePasswordURL = value;
    }

    /**
     * Obtém o valor da propriedade license.
     * 
     * @return
     *     possible object is
     *     {@link LicenseInfo }
     *     
     */
    public LicenseInfo getLicense() {
        return license;
    }

    /**
     * Define o valor da propriedade license.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseInfo }
     *     
     */
    public void setLicense(LicenseInfo value) {
        this.license = value;
    }

    /**
     * Obtém o valor da propriedade adminURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdminURL() {
        return adminURL;
    }

    /**
     * Define o valor da propriedade adminURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdminURL(String value) {
        this.adminURL = value;
    }

    /**
     * Obtém o valor da propriedade boshURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoshURL() {
        return boshURL;
    }

    /**
     * Define o valor da propriedade boshURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoshURL(String value) {
        this.boshURL = value;
    }

    /**
     * Obtém o valor da propriedade attSizeLimit.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAttSizeLimit() {
        return attSizeLimit;
    }

    /**
     * Define o valor da propriedade attSizeLimit.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAttSizeLimit(Long value) {
        this.attSizeLimit = value;
    }

    /**
     * Obtém o valor da propriedade docSizeLimit.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDocSizeLimit() {
        return docSizeLimit;
    }

    /**
     * Define o valor da propriedade docSizeLimit.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDocSizeLimit(Long value) {
        this.docSizeLimit = value;
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
     *         &lt;element name="childAccount" type="{urn:zimbraAccount}childAccount" maxOccurs="unbounded" minOccurs="0"/>
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
        "childAccount"
    })
    public static class ChildAccounts {

        protected List<ChildAccount> childAccount;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the childAccount property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the childAccount property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getChildAccount().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ChildAccount }
         * 
         * 
         */
        public List<ChildAccount> getChildAccount() {
            if (childAccount == null) {
                childAccount = new ArrayList<ChildAccount>();
            }
            return this.childAccount;
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
     *         &lt;choice maxOccurs="unbounded" minOccurs="0">
     *           &lt;element name="imap" type="{urn:zimbraAccount}accountImapDataSource"/>
     *           &lt;element name="pop3" type="{urn:zimbraAccount}accountPop3DataSource"/>
     *           &lt;element name="caldav" type="{urn:zimbraAccount}accountCaldavDataSource"/>
     *           &lt;element name="yab" type="{urn:zimbraAccount}accountYabDataSource"/>
     *           &lt;element name="rss" type="{urn:zimbraAccount}accountRssDataSource"/>
     *           &lt;element name="gal" type="{urn:zimbraAccount}accountGalDataSource"/>
     *           &lt;element name="cal" type="{urn:zimbraAccount}accountCalDataSource"/>
     *           &lt;element name="unknown" type="{urn:zimbraAccount}accountUnknownDataSource"/>
     *         &lt;/choice>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "imapOrPop3OrCaldav"
    })
    public static class DataSources {

        @XmlElements({
            @XmlElement(name = "imap", type = AccountImapDataSource.class),
            @XmlElement(name = "pop3", type = AccountPop3DataSource.class),
            @XmlElement(name = "caldav", type = AccountCaldavDataSource.class),
            @XmlElement(name = "yab", type = AccountYabDataSource.class),
            @XmlElement(name = "rss", type = AccountRssDataSource.class),
            @XmlElement(name = "gal", type = AccountGalDataSource.class),
            @XmlElement(name = "cal", type = AccountCalDataSource.class),
            @XmlElement(name = "unknown", type = AccountUnknownDataSource.class)
        })
        protected List<AccountDataSource> imapOrPop3OrCaldav;

        /**
         * Gets the value of the imapOrPop3OrCaldav property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the imapOrPop3OrCaldav property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getImapOrPop3OrCaldav().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AccountImapDataSource }
         * {@link AccountPop3DataSource }
         * {@link AccountCaldavDataSource }
         * {@link AccountYabDataSource }
         * {@link AccountRssDataSource }
         * {@link AccountGalDataSource }
         * {@link AccountCalDataSource }
         * {@link AccountUnknownDataSource }
         * 
         * 
         */
        public List<AccountDataSource> getImapOrPop3OrCaldav() {
            if (imapOrPop3OrCaldav == null) {
                imapOrPop3OrCaldav = new ArrayList<AccountDataSource>();
            }
            return this.imapOrPop3OrCaldav;
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
     *         &lt;element name="identity" type="{urn:zimbraAccount}identity" maxOccurs="unbounded" minOccurs="0"/>
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
        "identity"
    })
    public static class Identities {

        protected List<Identity> identity;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the identity property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the identity property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIdentity().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Identity }
         * 
         * 
         */
        public List<Identity> getIdentity() {
            if (identity == null) {
                identity = new ArrayList<Identity>();
            }
            return this.identity;
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
     *         &lt;element name="prop" type="{urn:zimbraAccount}prop" maxOccurs="unbounded" minOccurs="0"/>
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
        "prop"
    })
    public static class Props {

        protected List<Prop> prop;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the prop property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the prop property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProp().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Prop }
         * 
         * 
         */
        public List<Prop> getProp() {
            if (prop == null) {
                prop = new ArrayList<Prop>();
            }
            return this.prop;
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
     *         &lt;element name="targets" type="{urn:zimbraAccount}discoverRightsInfo" maxOccurs="unbounded" minOccurs="0"/>
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
        "targets"
    })
    public static class Rights {

        protected List<DiscoverRightsInfo> targets;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the targets property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the targets property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTargets().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DiscoverRightsInfo }
         * 
         * 
         */
        public List<DiscoverRightsInfo> getTargets() {
            if (targets == null) {
                targets = new ArrayList<DiscoverRightsInfo>();
            }
            return this.targets;
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
     *         &lt;element ref="{urn:zimbraAccount}signature" maxOccurs="unbounded" minOccurs="0"/>
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
        "signature"
    })
    public static class Signatures {

        protected List<Signature> signature;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the signature property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the signature property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSignature().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Signature }
         * 
         * 
         */
        public List<Signature> getSignature() {
            if (signature == null) {
                signature = new ArrayList<Signature>();
            }
            return this.signature;
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
     *         &lt;element name="zimlet" type="{urn:zimbraAccount}accountZimletInfo" maxOccurs="unbounded" minOccurs="0"/>
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
        "zimlet"
    })
    public static class Zimlets {

        protected List<AccountZimletInfo> zimlet;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the zimlet property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the zimlet property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getZimlet().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AccountZimletInfo }
         * 
         * 
         */
        public List<AccountZimletInfo> getZimlet() {
            if (zimlet == null) {
                zimlet = new ArrayList<AccountZimletInfo>();
            }
            return this.zimlet;
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
