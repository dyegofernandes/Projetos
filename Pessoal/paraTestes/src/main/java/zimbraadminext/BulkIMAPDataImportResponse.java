
package zimbraadminext;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de bulkIMAPDataImportResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="bulkIMAPDataImportResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="runningAccounts" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="account" type="{urn:zimbraAdminExt}nameId" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="totalCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idleCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="runningCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="finishedCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ConnectionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IMAPHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IMAPPort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indexBatchSize" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UseAdminLogin" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IMAPAdminLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IMAPAdminPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bulkIMAPDataImportResponse", propOrder = {
    "runningAccounts",
    "totalCount",
    "idleCount",
    "runningCount",
    "finishedCount",
    "connectionType",
    "imapHost",
    "imapPort",
    "indexBatchSize",
    "useAdminLogin",
    "imapAdminLogin",
    "imapAdminPassword"
})
public class BulkIMAPDataImportResponse {

    protected BulkIMAPDataImportResponse.RunningAccounts runningAccounts;
    protected Integer totalCount;
    protected Integer idleCount;
    protected Integer runningCount;
    protected Integer finishedCount;
    @XmlElement(name = "ConnectionType")
    protected String connectionType;
    @XmlElement(name = "IMAPHost")
    protected String imapHost;
    @XmlElement(name = "IMAPPort")
    protected String imapPort;
    protected String indexBatchSize;
    @XmlElement(name = "UseAdminLogin")
    protected Integer useAdminLogin;
    @XmlElement(name = "IMAPAdminLogin")
    protected String imapAdminLogin;
    @XmlElement(name = "IMAPAdminPassword")
    protected String imapAdminPassword;

    /**
     * Obtém o valor da propriedade runningAccounts.
     * 
     * @return
     *     possible object is
     *     {@link BulkIMAPDataImportResponse.RunningAccounts }
     *     
     */
    public BulkIMAPDataImportResponse.RunningAccounts getRunningAccounts() {
        return runningAccounts;
    }

    /**
     * Define o valor da propriedade runningAccounts.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkIMAPDataImportResponse.RunningAccounts }
     *     
     */
    public void setRunningAccounts(BulkIMAPDataImportResponse.RunningAccounts value) {
        this.runningAccounts = value;
    }

    /**
     * Obtém o valor da propriedade totalCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * Define o valor da propriedade totalCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalCount(Integer value) {
        this.totalCount = value;
    }

    /**
     * Obtém o valor da propriedade idleCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdleCount() {
        return idleCount;
    }

    /**
     * Define o valor da propriedade idleCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdleCount(Integer value) {
        this.idleCount = value;
    }

    /**
     * Obtém o valor da propriedade runningCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRunningCount() {
        return runningCount;
    }

    /**
     * Define o valor da propriedade runningCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRunningCount(Integer value) {
        this.runningCount = value;
    }

    /**
     * Obtém o valor da propriedade finishedCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFinishedCount() {
        return finishedCount;
    }

    /**
     * Define o valor da propriedade finishedCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFinishedCount(Integer value) {
        this.finishedCount = value;
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
     *     {@link Integer }
     *     
     */
    public Integer getUseAdminLogin() {
        return useAdminLogin;
    }

    /**
     * Define o valor da propriedade useAdminLogin.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUseAdminLogin(Integer value) {
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
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="account" type="{urn:zimbraAdminExt}nameId" maxOccurs="unbounded" minOccurs="0"/>
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
        "account"
    })
    public static class RunningAccounts {

        protected List<NameId> account;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

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
         * {@link NameId }
         * 
         * 
         */
        public List<NameId> getAccount() {
            if (account == null) {
                account = new ArrayList<NameId>();
            }
            return this.account;
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
