
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de grantInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="grantInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="target" type="{urn:zimbraAdmin}typeIdName"/>
 *         &lt;element name="grantee" type="{urn:zimbraAdmin}granteeInfo"/>
 *         &lt;element name="right" type="{urn:zimbraAdmin}rightModifierInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "grantInfo", propOrder = {
    "target",
    "grantee",
    "right"
})
public class GrantInfo {

    @XmlElement(required = true)
    protected TypeIdName target;
    @XmlElement(required = true)
    protected GranteeInfo grantee;
    @XmlElement(required = true)
    protected RightModifierInfo right;

    /**
     * Obtém o valor da propriedade target.
     * 
     * @return
     *     possible object is
     *     {@link TypeIdName }
     *     
     */
    public TypeIdName getTarget() {
        return target;
    }

    /**
     * Define o valor da propriedade target.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeIdName }
     *     
     */
    public void setTarget(TypeIdName value) {
        this.target = value;
    }

    /**
     * Obtém o valor da propriedade grantee.
     * 
     * @return
     *     possible object is
     *     {@link GranteeInfo }
     *     
     */
    public GranteeInfo getGrantee() {
        return grantee;
    }

    /**
     * Define o valor da propriedade grantee.
     * 
     * @param value
     *     allowed object is
     *     {@link GranteeInfo }
     *     
     */
    public void setGrantee(GranteeInfo value) {
        this.grantee = value;
    }

    /**
     * Obtém o valor da propriedade right.
     * 
     * @return
     *     possible object is
     *     {@link RightModifierInfo }
     *     
     */
    public RightModifierInfo getRight() {
        return right;
    }

    /**
     * Define o valor da propriedade right.
     * 
     * @param value
     *     allowed object is
     *     {@link RightModifierInfo }
     *     
     */
    public void setRight(RightModifierInfo value) {
        this.right = value;
    }

}
