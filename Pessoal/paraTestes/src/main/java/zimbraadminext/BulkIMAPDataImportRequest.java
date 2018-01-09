
package zimbraadminext;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de bulkIMAPDataImportRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="bulkIMAPDataImportRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sourceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="account" type="{urn:zimbraAdminExt}name" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ConnectionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceServerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IMAPHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IMAPPort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indexBatchSize" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UseAdminLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IMAPAdminLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IMAPAdminPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="op" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bulkIMAPDataImportRequest", propOrder = {
    "sourceType",
    "aid",
    "account",
    "connectionType",
    "sourceServerType",
    "imapHost",
    "imapPort",
    "indexBatchSize",
    "useAdminLogin",
    "imapAdminLogin",
    "imapAdminPassword"
})
public class BulkIMAPDataImportRequest {

    protected String sourceType;
    protected String aid;
    protected List<Name> account;
    @XmlElement(name = "ConnectionType")
    protected String connectionType;
    protected String sourceServerType;
    @XmlElement(name = "IMAPHost")
    protected String imapHost;
    @XmlElement(name = "IMAPPort")
    protected String imapPort;
    protected String indexBatchSize;
    @XmlElement(name = "UseAdminLogin")
    protected String useAdminLogin;
    @XmlElement(name = "IMAPAdminLogin")
    protected String imapAdminLogin;
    @XmlElement(name = "IMAPAdminPassword")
    protected String imapAdminPassword;
    @XmlAttribute(name = "op")
    protected String op;

    /**
     * Obtém o valor da propriedade sourceType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * Define o valor da propriedade sourceType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceType(String value) {
        this.sourceType = value;
    }

    /**
     * Obtém o valor da propriedade aid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAid() {
        return aid;
    }

    /**
     * Define o valor da propriedade aid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAid(String value) {
        this.aid = value;
    }

    /**
     * Gets the value of the account property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the account property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Name }
     * 
     * 
     */
    public List<Name> getAccount() {
        if (account == null) {
            account = new ArrayList<Name>();
        }
        return this.account;
    }

    /**
     * Obtém o valor da propriedade connectionType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectionType() {
        return connectionType;
    }

    /**
     * Define o valor da propriedade connectionType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectionType(String value) {
        this.connectionType = value;
    }

    /**
     * Obtém o valor da propriedade sourceServerType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceServerType() {
        return sourceServerType;
    }

    /**
     * Define o valor da propriedade sourceServerType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceServerType(String value) {
        this.sourceServerType = value;
    }

    /**
     * Obtém o valor da propriedade imapHost.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMAPHost() {
        return imapHost;
    }

    /**
     * Define o valor da propriedade imapHost.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMAPHost(String value) {
        this.imapHost = value;
    }

    /**
     * Obtém o valor da propriedade imapPort.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMAPPort() {
        return imapPort;
    }

    /**
     * Define o valor da propriedade imapPort.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMAPPort(String value) {
        this.imapPort = value;
    }

    /**
     * Obtém o valor da propriedade indexBatchSize.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexBatchSize() {
        return indexBatchSize;
    }

    /**
     * Define o valor da propriedade indexBatchSize.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexBatchSize(String value) {
        this.indexBatchSize = value;
    }

    /**
     * Obtém o valor da propriedade useAdminLogin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUseAdminLogin() {
        return useAdminLogin;
    }

    /**
     * Define o valor da propriedade useAdminLogin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUseAdminLogin(String value) {
        this.useAdminLogin = value;
    }

    /**
     * Obtém o valor da propriedade imapAdminLogin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMAPAdminLogin() {
        return imapAdminLogin;
    }

    /**
     * Define o valor da propriedade imapAdminLogin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMAPAdminLogin(String value) {
        this.imapAdminLogin = value;
    }

    /**
     * Obtém o valor da propriedade imapAdminPassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMAPAdminPassword() {
        return imapAdminPassword;
    }

    /**
     * Define o valor da propriedade imapAdminPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMAPAdminPassword(String value) {
        this.imapAdminPassword = value;
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

}
