
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getEffectiveRightsRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getEffectiveRightsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="target" type="{urn:zimbraAdmin}effectiveRightsTargetSelector"/>
 *         &lt;element name="grantee" type="{urn:zimbraAdmin}granteeSelector" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="expandAllAttrs" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEffectiveRightsRequest", propOrder = {
    "target",
    "grantee"
})
public class GetEffectiveRightsRequest {

    @XmlElement(required = true)
    protected EffectiveRightsTargetSelector target;
    protected GranteeSelector grantee;
    @XmlAttribute(name = "expandAllAttrs")
    protected String expandAllAttrs;

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
     * Obtém o valor da propriedade expandAllAttrs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpandAllAttrs() {
        return expandAllAttrs;
    }

    /**
     * Define o valor da propriedade expandAllAttrs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpandAllAttrs(String value) {
        this.expandAllAttrs = value;
    }

}
