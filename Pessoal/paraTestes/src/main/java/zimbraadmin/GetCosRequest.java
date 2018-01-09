
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import zimbra.AttributeSelectorImpl;


/**
 * <p>Classe Java de getCosRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getCosRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbra}attributeSelectorImpl">
 *       &lt;sequence>
 *         &lt;element name="cos" type="{urn:zimbraAdmin}cosSelector" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCosRequest", propOrder = {
    "cos"
})
public class GetCosRequest
    extends AttributeSelectorImpl
{

    protected CosSelector cos;

    /**
     * Obtém o valor da propriedade cos.
     * 
     * @return
     *     possible object is
     *     {@link CosSelector }
     *     
     */
    public CosSelector getCos() {
        return cos;
    }

    /**
     * Define o valor da propriedade cos.
     * 
     * @param value
     *     allowed object is
     *     {@link CosSelector }
     *     
     */
    public void setCos(CosSelector value) {
        this.cos = value;
    }

}
