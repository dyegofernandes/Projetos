
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getSMIMEPublicCertsResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getSMIMEPublicCertsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="certs" type="{urn:zimbraAccount}smimePublicCertsInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSMIMEPublicCertsResponse", propOrder = {
    "certs"
})
public class GetSMIMEPublicCertsResponse {

    protected SmimePublicCertsInfo certs;

    /**
     * Obtém o valor da propriedade certs.
     * 
     * @return
     *     possible object is
     *     {@link SmimePublicCertsInfo }
     *     
     */
    public SmimePublicCertsInfo getCerts() {
        return certs;
    }

    /**
     * Define o valor da propriedade certs.
     * 
     * @param value
     *     allowed object is
     *     {@link SmimePublicCertsInfo }
     *     
     */
    public void setCerts(SmimePublicCertsInfo value) {
        this.certs = value;
    }

}
