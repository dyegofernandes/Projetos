
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createTagRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createTagRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tag" type="{urn:zimbraMail}tagSpec" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createTagRequest", propOrder = {
    "tag"
})
public class CreateTagRequest {

    protected TagSpec tag;

    /**
     * Obtém o valor da propriedade tag.
     * 
     * @return
     *     possible object is
     *     {@link TagSpec }
     *     
     */
    public TagSpec getTag() {
        return tag;
    }

    /**
     * Define o valor da propriedade tag.
     * 
     * @param value
     *     allowed object is
     *     {@link TagSpec }
     *     
     */
    public void setTag(TagSpec value) {
        this.tag = value;
    }

}
