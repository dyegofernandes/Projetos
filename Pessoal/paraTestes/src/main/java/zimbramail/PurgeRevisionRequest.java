
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de purgeRevisionRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="purgeRevisionRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="revision" type="{urn:zimbraMail}purgeRevisionSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "purgeRevisionRequest", propOrder = {
    "revision"
})
public class PurgeRevisionRequest {

    @XmlElement(required = true)
    protected PurgeRevisionSpec revision;

    /**
     * Obtém o valor da propriedade revision.
     * 
     * @return
     *     possible object is
     *     {@link PurgeRevisionSpec }
     *     
     */
    public PurgeRevisionSpec getRevision() {
        return revision;
    }

    /**
     * Define o valor da propriedade revision.
     * 
     * @param value
     *     allowed object is
     *     {@link PurgeRevisionSpec }
     *     
     */
    public void setRevision(PurgeRevisionSpec value) {
        this.revision = value;
    }

}
