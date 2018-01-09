
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de checkRightRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="checkRightRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraAdmin}adminAttrsImpl">
 *       &lt;sequence>
 *         &lt;element name="target" type="{urn:zimbraAdmin}effectiveRightsTargetSelector"/>
 *         &lt;element name="grantee" type="{urn:zimbraAdmin}granteeSelector"/>
 *         &lt;element name="right" type="{urn:zimbraAdmin}checkedRight"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkRightRequest", propOrder = {
    "target",
    "grantee",
    "right"
})
public class CheckRightRequest
    extends AdminAttrsImpl
{

    @XmlElement(required = true)
    protected EffectiveRightsTargetSelector target;
    @XmlElement(required = true)
    protected GranteeSelector grantee;
    @XmlElement(required = true)
    protected String right;

    /**
     * Obtém o valor da propriedade target.
     * 
     * @return
     *     possible object is
     *     {@link EffectiveRightsTargetSelector }
     *     
     */
    public EffectiveRightsTargetSelector getTarget() {
        return target;
    }

    /**
     * Define o valor da propriedade target.
     * 
     * @param value
     *     allowed object is
     *     {@link EffectiveRightsTargetSelector }
     *     
     */
    public void setTarget(EffectiveRightsTargetSelector value) {
        this.target = value;
    }

    /**
     * Obtém o valor da propriedade grantee.
     * 
     * @return
     *     possible object is
     *     {@link GranteeSelector }
     *     
     */
    public GranteeSelector getGrantee() {
        return grantee;
    }

    /**
     * Define o valor da propriedade grantee.
     * 
     * @param value
     *     allowed object is
     *     {@link GranteeSelector }
     *     
     */
    public void setGrantee(GranteeSelector value) {
        this.grantee = value;
    }

    /**
     * Obtém o valor da propriedade right.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRight() {
        return right;
    }

    /**
     * Define o valor da propriedade right.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRight(String value) {
        this.right = value;
    }

}
