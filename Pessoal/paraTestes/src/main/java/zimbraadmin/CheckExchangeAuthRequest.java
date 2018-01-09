
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de checkExchangeAuthRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="checkExchangeAuthRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auth" type="{urn:zimbraAdmin}exchangeAuthSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkExchangeAuthRequest", propOrder = {
    "auth"
})
public class CheckExchangeAuthRequest {

    @XmlElement(required = true)
    protected ExchangeAuthSpec auth;

    /**
     * Obtém o valor da propriedade auth.
     * 
     * @return
     *     possible object is
     *     {@link ExchangeAuthSpec }
     *     
     */
    public ExchangeAuthSpec getAuth() {
        return auth;
    }

    /**
     * Define o valor da propriedade auth.
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangeAuthSpec }
     *     
     */
    public void setAuth(ExchangeAuthSpec value) {
        this.auth = value;
    }

}
