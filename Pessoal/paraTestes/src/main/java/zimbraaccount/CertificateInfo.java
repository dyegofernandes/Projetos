
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de certificateInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="certificateInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="issuedTo" type="{urn:zimbraAccount}certificateDN"/>
 *         &lt;element name="issuedBy" type="{urn:zimbraAccount}certificateDN" minOccurs="0"/>
 *         &lt;element name="validity" type="{urn:zimbraAccount}certificateValidity" minOccurs="0"/>
 *         &lt;element name="signature" type="{urn:zimbraAccount}certificateSignature" minOccurs="0"/>
 *         &lt;element name="subjectAltName" type="{urn:zimbraAccount}certificateAltNames" minOccurs="0"/>
 *         &lt;element name="issuerAltName" type="{urn:zimbraAccount}certificateAltNames" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="pubCertId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pvtKeyId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "certificateInfo", propOrder = {
    "errorCode",
    "emailAddress",
    "issuedTo",
    "issuedBy",
    "validity",
    "signature",
    "subjectAltName",
    "issuerAltName"
})
public class CertificateInfo {

    protected String errorCode;
    @XmlElement(required = true)
    protected String emailAddress;
    @XmlElement(required = true)
    protected CertificateDN issuedTo;
    protected CertificateDN issuedBy;
    protected CertificateValidity validity;
    protected CertificateSignature signature;
    protected CertificateAltNames subjectAltName;
    protected CertificateAltNames issuerAltName;
    @XmlAttribute(name = "pubCertId", required = true)
    protected String pubCertId;
    @XmlAttribute(name = "pvtKeyId", required = true)
    protected String pvtKeyId;
    @XmlAttribute(name = "default")
    protected Boolean _default;

    /**
     * Obtém o valor da propriedade errorCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Define o valor da propriedade errorCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
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
     * Obtém o valor da propriedade issuedTo.
     * 
     * @return
     *     possible object is
     *     {@link CertificateDN }
     *     
     */
    public CertificateDN getIssuedTo() {
        return issuedTo;
    }

    /**
     * Define o valor da propriedade issuedTo.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateDN }
     *     
     */
    public void setIssuedTo(CertificateDN value) {
        this.issuedTo = value;
    }

    /**
     * Obtém o valor da propriedade issuedBy.
     * 
     * @return
     *     possible object is
     *     {@link CertificateDN }
     *     
     */
    public CertificateDN getIssuedBy() {
        return issuedBy;
    }

    /**
     * Define o valor da propriedade issuedBy.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateDN }
     *     
     */
    public void setIssuedBy(CertificateDN value) {
        this.issuedBy = value;
    }

    /**
     * Obtém o valor da propriedade validity.
     * 
     * @return
     *     possible object is
     *     {@link CertificateValidity }
     *     
     */
    public CertificateValidity getValidity() {
        return validity;
    }

    /**
     * Define o valor da propriedade validity.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateValidity }
     *     
     */
    public void setValidity(CertificateValidity value) {
        this.validity = value;
    }

    /**
     * Obtém o valor da propriedade signature.
     * 
     * @return
     *     possible object is
     *     {@link CertificateSignature }
     *     
     */
    public CertificateSignature getSignature() {
        return signature;
    }

    /**
     * Define o valor da propriedade signature.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateSignature }
     *     
     */
    public void setSignature(CertificateSignature value) {
        this.signature = value;
    }

    /**
     * Obtém o valor da propriedade subjectAltName.
     * 
     * @return
     *     possible object is
     *     {@link CertificateAltNames }
     *     
     */
    public CertificateAltNames getSubjectAltName() {
        return subjectAltName;
    }

    /**
     * Define o valor da propriedade subjectAltName.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateAltNames }
     *     
     */
    public void setSubjectAltName(CertificateAltNames value) {
        this.subjectAltName = value;
    }

    /**
     * Obtém o valor da propriedade issuerAltName.
     * 
     * @return
     *     possible object is
     *     {@link CertificateAltNames }
     *     
     */
    public CertificateAltNames getIssuerAltName() {
        return issuerAltName;
    }

    /**
     * Define o valor da propriedade issuerAltName.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateAltNames }
     *     
     */
    public void setIssuerAltName(CertificateAltNames value) {
        this.issuerAltName = value;
    }

    /**
     * Obtém o valor da propriedade pubCertId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPubCertId() {
        return pubCertId;
    }

    /**
     * Define o valor da propriedade pubCertId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPubCertId(String value) {
        this.pubCertId = value;
    }

    /**
     * Obtém o valor da propriedade pvtKeyId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPvtKeyId() {
        return pvtKeyId;
    }

    /**
     * Define o valor da propriedade pvtKeyId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPvtKeyId(String value) {
        this.pvtKeyId = value;
    }

    /**
     * Obtém o valor da propriedade default.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDefault() {
        return _default;
    }

    /**
     * Define o valor da propriedade default.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDefault(Boolean value) {
        this._default = value;
    }

}
