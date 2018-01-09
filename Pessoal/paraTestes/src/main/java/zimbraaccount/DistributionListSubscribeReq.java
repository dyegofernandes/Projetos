
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Classe Java de distributionListSubscribeReq complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="distributionListSubscribeReq">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="op" use="required" type="{urn:zimbraAccount}distributionListSubscribeOp" />
 *       &lt;attribute name="bccOwners" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "distributionListSubscribeReq", propOrder = {
    "value"
})
public class DistributionListSubscribeReq {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "op", required = true)
    protected DistributionListSubscribeOp op;
    @XmlAttribute(name = "bccOwners")
    protected Boolean bccOwners;

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
     * Obtém o valor da propriedade op.
     * 
     * @return
     *     possible object is
     *     {@link DistributionListSubscribeOp }
     *     
     */
    public DistributionListSubscribeOp getOp() {
        return op;
    }

    /**
     * Define o valor da propriedade op.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributionListSubscribeOp }
     *     
     */
    public void setOp(DistributionListSubscribeOp value) {
        this.op = value;
    }

    /**
     * Obtém o valor da propriedade bccOwners.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBccOwners() {
        return bccOwners;
    }

    /**
     * Define o valor da propriedade bccOwners.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBccOwners(Boolean value) {
        this.bccOwners = value;
    }

}
