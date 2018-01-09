
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de modifyDistributionListResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="modifyDistributionListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dl" type="{urn:zimbraAdmin}distributionListInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyDistributionListResponse", propOrder = {
    "dl"
})
public class ModifyDistributionListResponse {

    protected DistributionListInfo dl;

    /**
     * Obtém o valor da propriedade dl.
     * 
     * @return
     *     possible object is
     *     {@link DistributionListInfo }
     *     
     */
    public DistributionListInfo getDl() {
        return dl;
    }

    /**
     * Define o valor da propriedade dl.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributionListInfo }
     *     
     */
    public void setDl(DistributionListInfo value) {
        this.dl = value;
    }

}
