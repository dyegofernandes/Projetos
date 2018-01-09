
package zimbraadminext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de bulkImportAccountsResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="bulkImportAccountsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="totalCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="skippedAccountCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SMTPHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SMTPPort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="provisionedCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="skippedCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="errorCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fileToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bulkImportAccountsResponse", propOrder = {
    "totalCount",
    "skippedAccountCount",
    "smtpHost",
    "smtpPort",
    "status",
    "provisionedCount",
    "skippedCount",
    "errorCount",
    "fileToken"
})
public class BulkImportAccountsResponse {

    protected Integer totalCount;
    protected Integer skippedAccountCount;
    @XmlElement(name = "SMTPHost")
    protected String smtpHost;
    @XmlElement(name = "SMTPPort")
    protected String smtpPort;
    protected Integer status;
    protected Integer provisionedCount;
    protected Integer skippedCount;
    protected Integer errorCount;
    protected String fileToken;

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
     * Obtém o valor da propriedade skippedAccountCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSkippedAccountCount() {
        return skippedAccountCount;
    }

    /**
     * Define o valor da propriedade skippedAccountCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSkippedAccountCount(Integer value) {
        this.skippedAccountCount = value;
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
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade provisionedCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProvisionedCount() {
        return provisionedCount;
    }

    /**
     * Define o valor da propriedade provisionedCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProvisionedCount(Integer value) {
        this.provisionedCount = value;
    }

    /**
     * Obtém o valor da propriedade skippedCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSkippedCount() {
        return skippedCount;
    }

    /**
     * Define o valor da propriedade skippedCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSkippedCount(Integer value) {
        this.skippedCount = value;
    }

    /**
     * Obtém o valor da propriedade errorCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErrorCount() {
        return errorCount;
    }

    /**
     * Define o valor da propriedade errorCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErrorCount(Integer value) {
        this.errorCount = value;
    }

    /**
     * Obtém o valor da propriedade fileToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileToken() {
        return fileToken;
    }

    /**
     * Define o valor da propriedade fileToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileToken(String value) {
        this.fileToken = value;
    }

}
