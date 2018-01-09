
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de modifyVolumeRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="modifyVolumeRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="volume" type="{urn:zimbraAdmin}volumeInfo"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyVolumeRequest", propOrder = {
    "volume"
})
public class ModifyVolumeRequest {

    @XmlElement(required = true)
    protected VolumeInfo volume;
    @XmlAttribute(name = "id", required = true)
    protected short id;

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

    /**
     * Obtém o valor da propriedade id.
     * 
     */
    public short getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     */
    public void setId(short value) {
        this.id = value;
    }

}
