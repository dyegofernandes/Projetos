
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de enableTwoFactorAuthRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="enableTwoFactorAuthRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authToken" type="{urn:zimbraAccount}authToken" minOccurs="0"/>
 *         &lt;element name="twoFactorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="csrfTokenSecured" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enableTwoFactorAuthRequest", propOrder = {

})
public class EnableTwoFactorAuthRequest {

    @XmlElement(required = true)
    protected String name;
    protected String password;
    protected AuthToken authToken;
    protected String twoFactorCode;
    @XmlAttribute(name = "csrfTokenSecured")
    protected Boolean csrfTokenSecured;

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Obtém o valor da propriedade authToken.
     * 
     * @return
     *     possible object is
     *     {@link AuthToken }
     *     
     */
    public AuthToken getAuthToken() {
        return authToken;
    }

    /**
     * Define o valor da propriedade authToken.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthToken }
     *     
     */
    public void setAuthToken(AuthToken value) {
        this.authToken = value;
    }

    /**
     * Obtém o valor da propriedade twoFactorCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTwoFactorCode() {
        return twoFactorCode;
    }

    /**
     * Define o valor da propriedade twoFactorCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTwoFactorCode(String value) {
        this.twoFactorCode = value;
    }

    /**
     * Obtém o valor da propriedade csrfTokenSecured.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCsrfTokenSecured() {
        return csrfTokenSecured;
    }

    /**
     * Define o valor da propriedade csrfTokenSecured.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCsrfTokenSecured(Boolean value) {
        this.csrfTokenSecured = value;
    }

}
