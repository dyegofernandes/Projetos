
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createMountpointRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createMountpointRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="link" type="{urn:zimbraMail}newMountpointSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createMountpointRequest", propOrder = {
    "link"
})
public class CreateMountpointRequest {

    @XmlElement(required = true)
    protected NewMountpointSpec link;

    /**
     * Obtém o valor da propriedade link.
     * 
     * @return
     *     possible object is
     *     {@link NewMountpointSpec }
     *     
     */
    public NewMountpointSpec getLink() {
        return link;
    }

    /**
     * Define o valor da propriedade link.
     * 
     * @param value
     *     allowed object is
     *     {@link NewMountpointSpec }
     *     
     */
    public void setLink(NewMountpointSpec value) {
        this.link = value;
    }

}
