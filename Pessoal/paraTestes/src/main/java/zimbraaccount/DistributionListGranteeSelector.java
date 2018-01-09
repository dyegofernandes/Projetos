
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import zimbra.DistributionListGranteeBy;
import zimbra.GranteeType;


/**
 * <p>Classe Java de distributionListGranteeSelector complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="distributionListGranteeSelector">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="type" use="required" type="{urn:zimbra}granteeType" />
 *       &lt;attribute name="by" use="required" type="{urn:zimbra}distributionListGranteeBy" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "distributionListGranteeSelector", propOrder = {
    "value"
})
public class DistributionListGranteeSelector {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "type", required = true)
    protected GranteeType type;
    @XmlAttribute(name = "by", required = true)
    protected DistributionListGranteeBy by;

    /**
     * Obtém o valor da propriedade value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define o valor da propriedade value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link GranteeType }
     *     
     */
    public GranteeType getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link GranteeType }
     *     
     */
    public void setType(GranteeType value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade by.
     * 
     * @return
     *     possible object is
     *     {@link DistributionListGranteeBy }
     *     
     */
    public DistributionListGranteeBy getBy() {
        return by;
    }

    /**
     * Define o valor da propriedade by.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributionListGranteeBy }
     *     
     */
    public void setBy(DistributionListGranteeBy value) {
        this.by = value;
    }

}
