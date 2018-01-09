
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de restoreRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="restoreRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="restore" type="{urn:zimbraAdmin}restoreSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "restoreRequest", propOrder = {
    "restore"
})
public class RestoreRequest {

    @XmlElement(required = true)
    protected RestoreSpec restore;

    /**
     * Obtém o valor da propriedade restore.
     * 
     * @return
     *     possible object is
     *     {@link RestoreSpec }
     *     
     */
    public RestoreSpec getRestore() {
        return restore;
    }

    /**
     * Define o valor da propriedade restore.
     * 
     * @param value
     *     allowed object is
     *     {@link RestoreSpec }
     *     
     */
    public void setRestore(RestoreSpec value) {
        this.restore = value;
    }

}
