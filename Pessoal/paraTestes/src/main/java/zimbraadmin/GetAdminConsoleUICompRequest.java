
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import zimbra.AccountSelector;


/**
 * <p>Classe Java de getAdminConsoleUICompRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getAdminConsoleUICompRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="account" type="{urn:zimbra}accountSelector" minOccurs="0"/>
 *         &lt;element name="dl" type="{urn:zimbraAdmin}distributionListSelector" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAdminConsoleUICompRequest", propOrder = {
    "account",
    "dl"
})
public class GetAdminConsoleUICompRequest {

    protected AccountSelector account;
    protected DistributionListSelector dl;

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
     * Obtém o valor da propriedade dl.
     * 
     * @return
     *     possible object is
     *     {@link DistributionListSelector }
     *     
     */
    public DistributionListSelector getDl() {
        return dl;
    }

    /**
     * Define o valor da propriedade dl.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributionListSelector }
     *     
     */
    public void setDl(DistributionListSelector value) {
        this.dl = value;
    }

}
