
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Classe Java de authToken complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="authToken">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="verifyAccount" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="lifetime" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authToken", propOrder = {
    "value"
})
public class AuthToken {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "verifyAccount")
    protected Boolean verifyAccount;
    @XmlAttribute(name = "lifetime")
    protected Long lifetime;

    /**
     * Obtém o valor da propriedade value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define o valor da propriedade value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtém o valor da propriedade verifyAccount.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifyAccount() {
        return verifyAccount;
    }

    /**
     * Define o valor da propriedade verifyAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifyAccount(Boolean value) {
        this.verifyAccount = value;
    }

    /**
     * Obtém o valor da propriedade lifetime.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLifetime() {
        return lifetime;
    }

    /**
     * Define o valor da propriedade lifetime.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLifetime(Long value) {
        this.lifetime = value;
    }

}
