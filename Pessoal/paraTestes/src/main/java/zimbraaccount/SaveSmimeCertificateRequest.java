
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import zimbra.Id;


/**
 * <p>Classe Java de saveSmimeCertificateRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="saveSmimeCertificateRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="upload" type="{urn:zimbra}id"/>
 *       &lt;/sequence>
 *       &lt;attribute name="password" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="replaceId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveSmimeCertificateRequest", propOrder = {
    "upload"
})
public class SaveSmimeCertificateRequest {

    @XmlElement(required = true)
    protected Id upload;
    @XmlAttribute(name = "password")
    protected String password;
    @XmlAttribute(name = "replaceId")
    protected String replaceId;

    /**
     * Obtém o valor da propriedade upload.
     * 
     * @return
     *     possible object is
     *     {@link Id }
     *     
     */
    public Id getUpload() {
        return upload;
    }

    /**
     * Define o valor da propriedade upload.
     * 
     * @param value
     *     allowed object is
     *     {@link Id }
     *     
     */
    public void setUpload(Id value) {
        this.upload = value;
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
     * Obtém o valor da propriedade replaceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplaceId() {
        return replaceId;
    }

    /**
     * Define o valor da propriedade replaceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplaceId(String value) {
        this.replaceId = value;
    }

}
