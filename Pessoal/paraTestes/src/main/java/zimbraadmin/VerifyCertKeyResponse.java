
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de verifyCertKeyResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="verifyCertKeyResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="verifyResult" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifyCertKeyResponse")
public class VerifyCertKeyResponse {

    @XmlAttribute(name = "verifyResult", required = true)
    protected String verifyResult;

    /**
     * Obtém o valor da propriedade verifyResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerifyResult() {
        return verifyResult;
    }

    /**
     * Define o valor da propriedade verifyResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerifyResult(String value) {
        this.verifyResult = value;
    }

}
