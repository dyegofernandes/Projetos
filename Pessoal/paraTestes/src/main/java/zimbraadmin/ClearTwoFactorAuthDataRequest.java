
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.AccountSelector;


/**
 * <p>Classe Java de clearTwoFactorAuthDataRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="clearTwoFactorAuthDataRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cos" type="{urn:zimbraAdmin}cosSelector" minOccurs="0"/>
 *         &lt;element name="account" type="{urn:zimbra}accountSelector" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="lazyDelete" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clearTwoFactorAuthDataRequest", propOrder = {
    "cos",
    "account"
})
public class ClearTwoFactorAuthDataRequest {

    protected CosSelector cos;
    protected AccountSelector account;
    @XmlAttribute(name = "lazyDelete")
    protected Boolean lazyDelete;

    /**
     * Obtém o valor da propriedade cos.
     * 
     * @return
     *     possible object is
     *     {@link CosSelector }
     *     
     */
    public CosSelector getCos() {
        return cos;
    }

    /**
     * Define o valor da propriedade cos.
     * 
     * @param value
     *     allowed object is
     *     {@link CosSelector }
     *     
     */
    public void setCos(CosSelector value) {
        this.cos = value;
    }

    /**
     * Obtém o valor da propriedade account.
     * 
     * @return
     *     possible object is
     *     {@link AccountSelector }
     *     
     */
    public AccountSelector getAccount() {
        return account;
    }

    /**
     * Define o valor da propriedade account.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountSelector }
     *     
     */
    public void setAccount(AccountSelector value) {
        this.account = value;
    }

    /**
     * Obtém o valor da propriedade lazyDelete.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLazyDelete() {
        return lazyDelete;
    }

    /**
     * Define o valor da propriedade lazyDelete.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLazyDelete(Boolean value) {
        this.lazyDelete = value;
    }

}
