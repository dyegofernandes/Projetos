
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getAccountDistributionListsRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getAccountDistributionListsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="ownerOf" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="memberOf" type="{urn:zimbraAccount}memberOfSelector" />
 *       &lt;attribute name="attrs" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAccountDistributionListsRequest")
public class GetAccountDistributionListsRequest {

    @XmlAttribute(name = "ownerOf")
    protected Boolean ownerOf;
    @XmlAttribute(name = "memberOf")
    protected MemberOfSelector memberOf;
    @XmlAttribute(name = "attrs")
    protected String attrs;

    /**
     * Obtém o valor da propriedade ownerOf.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOwnerOf() {
        return ownerOf;
    }

    /**
     * Define o valor da propriedade ownerOf.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOwnerOf(Boolean value) {
        this.ownerOf = value;
    }

    /**
     * Obtém o valor da propriedade memberOf.
     * 
     * @return
     *     possible object is
     *     {@link MemberOfSelector }
     *     
     */
    public MemberOfSelector getMemberOf() {
        return memberOf;
    }

    /**
     * Define o valor da propriedade memberOf.
     * 
     * @param value
     *     allowed object is
     *     {@link MemberOfSelector }
     *     
     */
    public void setMemberOf(MemberOfSelector value) {
        this.memberOf = value;
    }

    /**
     * Obtém o valor da propriedade attrs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrs() {
        return attrs;
    }

    /**
     * Define o valor da propriedade attrs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrs(String value) {
        this.attrs = value;
    }

}
