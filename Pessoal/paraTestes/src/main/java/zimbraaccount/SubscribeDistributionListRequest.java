
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import zimbra.DistributionListSelector;


/**
 * <p>Classe Java de subscribeDistributionListRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="subscribeDistributionListRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dl" type="{urn:zimbra}distributionListSelector"/>
 *       &lt;/sequence>
 *       &lt;attribute name="op" use="required" type="{urn:zimbraAccount}distributionListSubscribeOp" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subscribeDistributionListRequest", propOrder = {
    "dl"
})
public class SubscribeDistributionListRequest {

    @XmlElement(required = true)
    protected DistributionListSelector dl;
    @XmlAttribute(name = "op", required = true)
    protected DistributionListSubscribeOp op;

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

}
