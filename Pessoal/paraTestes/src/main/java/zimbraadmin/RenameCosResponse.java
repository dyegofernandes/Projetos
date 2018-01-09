
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de renameCosResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="renameCosResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cos" type="{urn:zimbraAdmin}cosInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "renameCosResponse", propOrder = {
    "cos"
})
public class RenameCosResponse {

    @XmlElement(required = true)
    protected CosInfo cos;

    /**
     * Obtém o valor da propriedade cos.
     * 
     * @return
     *     possible object is
     *     {@link CosInfo }
     *     
     */
    public CosInfo getCos() {
        return cos;
    }

    /**
     * Define o valor da propriedade cos.
     * 
     * @param value
     *     allowed object is
     *     {@link CosInfo }
     *     
     */
    public void setCos(CosInfo value) {
        this.cos = value;
    }

}
