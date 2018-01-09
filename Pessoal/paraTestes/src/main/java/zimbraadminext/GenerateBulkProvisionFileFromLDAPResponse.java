
package zimbraadminext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de generateBulkProvisionFileFromLDAPResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="generateBulkProvisionFileFromLDAPResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="totalCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="domainCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="skippedAccountCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="skippedDomainCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SMTPHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SMTPPort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "generateBulkProvisionFileFromLDAPResponse", propOrder = {
    "totalCount",
    "domainCount",
    "skippedAccountCount",
    "skippedDomainCount",
    "smtpHost",
    "smtpPort",
    "fileToken"
})
public class GenerateBulkProvisionFileFromLDAPResponse {

    protected Integer totalCount;
    protected Integer domainCount;
    protected Integer skippedAccountCount;
    protected Integer skippedDomainCount;
    @XmlElement(name = "SMTPHost")
    protected String smtpHost;
    @XmlElement(name = "SMTPPort")
    protected String smtpPort;
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
     * Obtém o valor da propriedade domainCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDomainCount() {
        return domainCount;
    }

    /**
     * Define o valor da propriedade domainCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDomainCount(Integer value) {
        this.domainCount = value;
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
     * Obtém o valor da propriedade skippedDomainCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSkippedDomainCount() {
        return skippedDomainCount;
    }

    /**
     * Define o valor da propriedade skippedDomainCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSkippedDomainCount(Integer value) {
        this.skippedDomainCount = value;
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
