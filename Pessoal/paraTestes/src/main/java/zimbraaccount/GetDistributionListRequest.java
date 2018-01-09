
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import zimbra.DistributionListSelector;


/**
 * <p>Classe Java de getDistributionListRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getDistributionListRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraAccount}attrsImpl">
 *       &lt;sequence>
 *         &lt;element name="dl" type="{urn:zimbra}distributionListSelector"/>
 *       &lt;/sequence>
 *       &lt;attribute name="needOwners" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="needRights" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDistributionListRequest", propOrder = {
    "dl"
})
public class GetDistributionListRequest
    extends AttrsImpl
{

    @XmlElement(required = true)
    protected DistributionListSelector dl;
    @XmlAttribute(name = "needOwners")
    protected Boolean needOwners;
    @XmlAttribute(name = "needRights")
    protected String needRights;

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

    /**
     * Obtém o valor da propriedade needOwners.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedOwners() {
        return needOwners;
    }

    /**
     * Define o valor da propriedade needOwners.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedOwners(Boolean value) {
        this.needOwners = value;
    }

    /**
     * Obtém o valor da propriedade needRights.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNeedRights() {
        return needRights;
    }

    /**
     * Define o valor da propriedade needRights.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNeedRights(String value) {
        this.needRights = value;
    }

}
