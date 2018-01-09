
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.AccountSelector;
import zimbra.GranteeChooser;


/**
 * <p>Classe Java de getShareInfoRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getShareInfoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="grantee" type="{urn:zimbra}granteeChooser" minOccurs="0"/>
 *         &lt;element name="owner" type="{urn:zimbra}accountSelector" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="internal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="includeSelf" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getShareInfoRequest", propOrder = {
    "grantee",
    "owner"
})
public class GetShareInfoRequest {

    protected GranteeChooser grantee;
    protected AccountSelector owner;
    @XmlAttribute(name = "internal")
    protected Boolean internal;
    @XmlAttribute(name = "includeSelf")
    protected Boolean includeSelf;

    /**
     * Obtém o valor da propriedade grantee.
     * 
     * @return
     *     possible object is
     *     {@link GranteeChooser }
     *     
     */
    public GranteeChooser getGrantee() {
        return grantee;
    }

    /**
     * Define o valor da propriedade grantee.
     * 
     * @param value
     *     allowed object is
     *     {@link GranteeChooser }
     *     
     */
    public void setGrantee(GranteeChooser value) {
        this.grantee = value;
    }

    /**
     * Obtém o valor da propriedade owner.
     * 
     * @return
     *     possible object is
     *     {@link AccountSelector }
     *     
     */
    public AccountSelector getOwner() {
        return owner;
    }

    /**
     * Define o valor da propriedade owner.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountSelector }
     *     
     */
    public void setOwner(AccountSelector value) {
        this.owner = value;
    }

    /**
     * Obtém o valor da propriedade internal.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInternal() {
        return internal;
    }

    /**
     * Define o valor da propriedade internal.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInternal(Boolean value) {
        this.internal = value;
    }

    /**
     * Obtém o valor da propriedade includeSelf.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSelf() {
        return includeSelf;
    }

    /**
     * Define o valor da propriedade includeSelf.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSelf(Boolean value) {
        this.includeSelf = value;
    }

}
