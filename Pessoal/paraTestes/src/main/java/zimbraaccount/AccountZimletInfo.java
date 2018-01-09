
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Classe Java de accountZimletInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="accountZimletInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zimletContext" type="{urn:zimbraAccount}accountZimletContext" minOccurs="0"/>
 *         &lt;element name="zimlet" type="{urn:zimbraAccount}accountZimletDesc" minOccurs="0"/>
 *         &lt;element name="zimletConfig" type="{urn:zimbraAccount}accountZimletConfigInfo" minOccurs="0"/>
 *         &lt;any processContents='skip' namespace='##other'/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountZimletInfo", propOrder = {
    "zimletContext",
    "zimlet",
    "zimletConfig",
    "any"
})
public class AccountZimletInfo {

    protected AccountZimletContext zimletContext;
    protected AccountZimletDesc zimlet;
    protected AccountZimletConfigInfo zimletConfig;
    @XmlAnyElement
    protected Element any;

    /**
     * Obtém o valor da propriedade zimletContext.
     * 
     * @return
     *     possible object is
     *     {@link AccountZimletContext }
     *     
     */
    public AccountZimletContext getZimletContext() {
        return zimletContext;
    }

    /**
     * Define o valor da propriedade zimletContext.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountZimletContext }
     *     
     */
    public void setZimletContext(AccountZimletContext value) {
        this.zimletContext = value;
    }

    /**
     * Obtém o valor da propriedade zimlet.
     * 
     * @return
     *     possible object is
     *     {@link AccountZimletDesc }
     *     
     */
    public AccountZimletDesc getZimlet() {
        return zimlet;
    }

    /**
     * Define o valor da propriedade zimlet.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountZimletDesc }
     *     
     */
    public void setZimlet(AccountZimletDesc value) {
        this.zimlet = value;
    }

    /**
     * Obtém o valor da propriedade zimletConfig.
     * 
     * @return
     *     possible object is
     *     {@link AccountZimletConfigInfo }
     *     
     */
    public AccountZimletConfigInfo getZimletConfig() {
        return zimletConfig;
    }

    /**
     * Define o valor da propriedade zimletConfig.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountZimletConfigInfo }
     *     
     */
    public void setZimletConfig(AccountZimletConfigInfo value) {
        this.zimletConfig = value;
    }

    /**
     * Obtém o valor da propriedade any.
     * 
     * @return
     *     possible object is
     *     {@link Element }
     *     
     */
    public Element getAny() {
        return any;
    }

    /**
     * Define o valor da propriedade any.
     * 
     * @param value
     *     allowed object is
     *     {@link Element }
     *     
     */
    public void setAny(Element value) {
        this.any = value;
    }

}
