
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createAlwaysOnClusterResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createAlwaysOnClusterResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:zimbraAdmin}alwaysOnCluster" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createAlwaysOnClusterResponse", propOrder = {
    "alwaysOnCluster"
})
public class CreateAlwaysOnClusterResponse {

    protected AlwaysOnClusterInfo alwaysOnCluster;

    /**
     * Obtém o valor da propriedade alwaysOnCluster.
     * 
     * @return
     *     possible object is
     *     {@link AlwaysOnClusterInfo }
     *     
     */
    public AlwaysOnClusterInfo getAlwaysOnCluster() {
        return alwaysOnCluster;
    }

    /**
     * Define o valor da propriedade alwaysOnCluster.
     * 
     * @param value
     *     allowed object is
     *     {@link AlwaysOnClusterInfo }
     *     
     */
    public void setAlwaysOnCluster(AlwaysOnClusterInfo value) {
        this.alwaysOnCluster = value;
    }

}
