
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de installCertRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="installCertRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="comm_cert" type="{urn:zimbraAdmin}commCert" minOccurs="0"/>
 *         &lt;element name="validation_days" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="digest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subject" type="{urn:zimbraAdmin}csrSubject" minOccurs="0"/>
 *         &lt;element name="SubjectAltName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="keysize" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="server" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="skipCleanup" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "installCertRequest", propOrder = {
    "commCert",
    "validationDays",
    "digest",
    "subject",
    "subjectAltName",
    "keysize"
})
public class InstallCertRequest {

    @XmlElement(name = "comm_cert")
    protected CommCert commCert;
    @XmlElement(name = "validation_days")
    protected String validationDays;
    protected String digest;
    protected CsrSubject subject;
    @XmlElement(name = "SubjectAltName")
    protected List<String> subjectAltName;
    protected String keysize;
    @XmlAttribute(name = "server", required = true)
    protected String server;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "skipCleanup")
    protected Boolean skipCleanup;

    /**
     * Obtém o valor da propriedade commCert.
     * 
     * @return
     *     possible object is
     *     {@link CommCert }
     *     
     */
    public CommCert getCommCert() {
        return commCert;
    }

    /**
     * Define o valor da propriedade commCert.
     * 
     * @param value
     *     allowed object is
     *     {@link CommCert }
     *     
     */
    public void setCommCert(CommCert value) {
        this.commCert = value;
    }

    /**
     * Obtém o valor da propriedade validationDays.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidationDays() {
        return validationDays;
    }

    /**
     * Define o valor da propriedade validationDays.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidationDays(String value) {
        this.validationDays = value;
    }

    /**
     * Obtém o valor da propriedade digest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDigest() {
        return digest;
    }

    /**
     * Define o valor da propriedade digest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDigest(String value) {
        this.digest = value;
    }

    /**
     * Obtém o valor da propriedade subject.
     * 
     * @return
     *     possible object is
     *     {@link CsrSubject }
     *     
     */
    public CsrSubject getSubject() {
        return subject;
    }

    /**
     * Define o valor da propriedade subject.
     * 
     * @param value
     *     allowed object is
     *     {@link CsrSubject }
     *     
     */
    public void setSubject(CsrSubject value) {
        this.subject = value;
    }

    /**
     * Gets the value of the subjectAltName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subjectAltName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubjectAltName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSubjectAltName() {
        if (subjectAltName == null) {
            subjectAltName = new ArrayList<String>();
        }
        return this.subjectAltName;
    }

    /**
     * Obtém o valor da propriedade keysize.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeysize() {
        return keysize;
    }

    /**
     * Define o valor da propriedade keysize.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeysize(String value) {
        this.keysize = value;
    }

    /**
     * Obtém o valor da propriedade server.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServer() {
        return server;
    }

    /**
     * Define o valor da propriedade server.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServer(String value) {
        this.server = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade skipCleanup.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkipCleanup() {
        return skipCleanup;
    }

    /**
     * Define o valor da propriedade skipCleanup.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkipCleanup(Boolean value) {
        this.skipCleanup = value;
    }

}
