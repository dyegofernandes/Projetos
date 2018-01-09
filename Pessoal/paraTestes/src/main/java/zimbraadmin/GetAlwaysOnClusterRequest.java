
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import zimbra.AttributeSelectorImpl;


/**
 * <p>Classe Java de getAlwaysOnClusterRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getAlwaysOnClusterRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbra}attributeSelectorImpl">
 *       &lt;sequence>
 *         &lt;element name="alwaysOnCluster" type="{urn:zimbraAdmin}alwaysOnClusterSelector" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAlwaysOnClusterRequest", propOrder = {
    "alwaysOnCluster"
})
public class GetAlwaysOnClusterRequest
    extends AttributeSelectorImpl
{

    protected AlwaysOnClusterSelector alwaysOnCluster;

    /**
     * Obtém o valor da propriedade alwaysOnCluster.
     * 
     * @return
     *     possible object is
     *     {@link AlwaysOnClusterSelector }
     *     
     */
    public AlwaysOnClusterSelector getAlwaysOnCluster() {
        return alwaysOnCluster;
    }

    /**
     * Define o valor da propriedade alwaysOnCluster.
     * 
     * @param value
     *     allowed object is
     *     {@link AlwaysOnClusterSelector }
     *     
     */
    public void setAlwaysOnCluster(AlwaysOnClusterSelector value) {
        this.alwaysOnCluster = value;
    }

}
