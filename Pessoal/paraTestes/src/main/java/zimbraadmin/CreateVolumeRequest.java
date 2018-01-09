
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createVolumeRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createVolumeRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="volume" type="{urn:zimbraAdmin}volumeInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createVolumeRequest", propOrder = {
    "volume"
})
public class CreateVolumeRequest {

    @XmlElement(required = true)
    protected VolumeInfo volume;

    /**
     * Obtém o valor da propriedade volume.
     * 
     * @return
     *     possible object is
     *     {@link VolumeInfo }
     *     
     */
    public VolumeInfo getVolume() {
        return volume;
    }

    /**
     * Define o valor da propriedade volume.
     * 
     * @param value
     *     allowed object is
     *     {@link VolumeInfo }
     *     
     */
    public void setVolume(VolumeInfo value) {
        this.volume = value;
    }

}
