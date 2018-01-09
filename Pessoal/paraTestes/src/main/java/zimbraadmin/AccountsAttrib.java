
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de accountsAttrib complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="accountsAttrib">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="accounts" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountsAttrib")
public class AccountsAttrib {

    @XmlAttribute(name = "accounts", required = true)
    protected String accounts;

    /**
     * Obtém o valor da propriedade accounts.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccounts() {
        return accounts;
    }

    /**
     * Define o valor da propriedade accounts.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccounts(String value) {
        this.accounts = value;
    }

}
