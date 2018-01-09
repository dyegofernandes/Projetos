
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getAllEffectiveRightsResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getAllEffectiveRightsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="grantee" type="{urn:zimbraAdmin}granteeInfo" minOccurs="0"/>
 *         &lt;element name="target" type="{urn:zimbraAdmin}effectiveRightsTarget" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllEffectiveRightsResponse", propOrder = {
    "grantee",
    "target"
})
public class GetAllEffectiveRightsResponse {

    protected GranteeInfo grantee;
    protected List<EffectiveRightsTarget> target;

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
     * Gets the value of the target property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the target property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTarget().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EffectiveRightsTarget }
     * 
     * 
     */
    public List<EffectiveRightsTarget> getTarget() {
        if (target == null) {
            target = new ArrayList<EffectiveRightsTarget>();
        }
        return this.target;
    }

}
