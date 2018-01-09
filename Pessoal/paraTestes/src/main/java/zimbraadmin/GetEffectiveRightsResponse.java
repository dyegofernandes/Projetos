
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getEffectiveRightsResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getEffectiveRightsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="grantee" type="{urn:zimbraAdmin}granteeInfo"/>
 *         &lt;element name="target" type="{urn:zimbraAdmin}effectiveRightsTargetInfo"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEffectiveRightsResponse", propOrder = {

})
public class GetEffectiveRightsResponse {

    @XmlElement(required = true)
    protected GranteeInfo grantee;
    @XmlElement(required = true)
    protected EffectiveRightsTargetInfo target;

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
     * Obtém o valor da propriedade target.
     * 
     * @return
     *     possible object is
     *     {@link EffectiveRightsTargetInfo }
     *     
     */
    public EffectiveRightsTargetInfo getTarget() {
        return target;
    }

    /**
     * Define o valor da propriedade target.
     * 
     * @param value
     *     allowed object is
     *     {@link EffectiveRightsTargetInfo }
     *     
     */
    public void setTarget(EffectiveRightsTargetInfo value) {
        this.target = value;
    }

}
