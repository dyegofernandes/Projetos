
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de authResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="authResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="csrfToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lifetime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authResponse", propOrder = {
    "authToken",
    "csrfToken",
    "lifetime"
})
public class AuthResponse {

    @XmlElement(required = true)
    protected String authToken;
    protected String csrfToken;
    protected long lifetime;

    /**
     * Obtém o valor da propriedade authToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * Define o valor da propriedade authToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthToken(String value) {
        this.authToken = value;
    }

    /**
     * Obtém o valor da propriedade csrfToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsrfToken() {
        return csrfToken;
    }

    /**
     * Define o valor da propriedade csrfToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsrfToken(String value) {
        this.csrfToken = value;
    }

    /**
     * Obtém o valor da propriedade lifetime.
     * 
     */
    public long getLifetime() {
        return lifetime;
    }

    /**
     * Define o valor da propriedade lifetime.
     * 
     */
    public void setLifetime(long value) {
        this.lifetime = value;
    }

}
