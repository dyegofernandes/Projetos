
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de saveSmimeCertificateResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="saveSmimeCertificateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:zimbraAccount}certificate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveSmimeCertificateResponse", propOrder = {
    "certificate"
})
public class SaveSmimeCertificateResponse {

    protected CertificateInfo certificate;

    /**
     * Obtém o valor da propriedade certificate.
     * 
     * @return
     *     possible object is
     *     {@link CertificateInfo }
     *     
     */
    public CertificateInfo getCertificate() {
        return certificate;
    }

    /**
     * Define o valor da propriedade certificate.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateInfo }
     *     
     */
    public void setCertificate(CertificateInfo value) {
        this.certificate = value;
    }

}
