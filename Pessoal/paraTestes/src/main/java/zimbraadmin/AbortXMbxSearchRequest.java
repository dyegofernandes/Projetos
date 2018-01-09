
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import zimbra.AccountSelector;


/**
 * <p>Classe Java de abortXMbxSearchRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="abortXMbxSearchRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchtask" type="{urn:zimbraAdmin}searchID"/>
 *         &lt;element name="account" type="{urn:zimbra}accountSelector" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "abortXMbxSearchRequest", propOrder = {
    "searchtask",
    "account"
})
public class AbortXMbxSearchRequest {

    @XmlElement(required = true)
    protected SearchID searchtask;
    protected AccountSelector account;

    /**
     * Obtém o valor da propriedade searchtask.
     * 
     * @return
     *     possible object is
     *     {@link SearchID }
     *     
     */
    public SearchID getSearchtask() {
        return searchtask;
    }

    /**
     * Define o valor da propriedade searchtask.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchID }
     *     
     */
    public void setSearchtask(SearchID value) {
        this.searchtask = value;
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

}
