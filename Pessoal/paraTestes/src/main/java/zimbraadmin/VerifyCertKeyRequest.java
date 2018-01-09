
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de verifyCertKeyRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="verifyCertKeyRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="cert" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="privkey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifyCertKeyRequest")
public class VerifyCertKeyRequest {

    @XmlAttribute(name = "cert")
    protected String cert;
    @XmlAttribute(name = "privkey")
    protected String privkey;

    /**
     * Obtém o valor da propriedade cert.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCert() {
        return cert;
    }

    /**
     * Define o valor da propriedade cert.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCert(String value) {
        this.cert = value;
    }

    /**
     * Obtém o valor da propriedade privkey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivkey() {
        return privkey;
    }

    /**
     * Define o valor da propriedade privkey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivkey(String value) {
        this.privkey = value;
    }

}
