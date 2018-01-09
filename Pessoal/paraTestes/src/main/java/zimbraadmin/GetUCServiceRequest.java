
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import zimbra.AttributeSelectorImpl;


/**
 * <p>Classe Java de getUCServiceRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getUCServiceRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbra}attributeSelectorImpl">
 *       &lt;sequence>
 *         &lt;element name="ucservice" type="{urn:zimbraAdmin}ucServiceSelector" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUCServiceRequest", propOrder = {
    "ucservice"
})
public class GetUCServiceRequest
    extends AttributeSelectorImpl
{

    protected UcServiceSelector ucservice;

    /**
     * Obtém o valor da propriedade ucservice.
     * 
     * @return
     *     possible object is
     *     {@link UcServiceSelector }
     *     
     */
    public UcServiceSelector getUcservice() {
        return ucservice;
    }

    /**
     * Define o valor da propriedade ucservice.
     * 
     * @param value
     *     allowed object is
     *     {@link UcServiceSelector }
     *     
     */
    public void setUcservice(UcServiceSelector value) {
        this.ucservice = value;
    }

}
