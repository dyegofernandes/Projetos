
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getCreateObjectAttrsResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getCreateObjectAttrsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="setAttrs" type="{urn:zimbraAdmin}effectiveAttrsInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCreateObjectAttrsResponse", propOrder = {
    "setAttrs"
})
public class GetCreateObjectAttrsResponse {

    @XmlElement(required = true)
    protected EffectiveAttrsInfo setAttrs;

    /**
     * Obtém o valor da propriedade setAttrs.
     * 
     * @return
     *     possible object is
     *     {@link EffectiveAttrsInfo }
     *     
     */
    public EffectiveAttrsInfo getSetAttrs() {
        return setAttrs;
    }

    /**
     * Define o valor da propriedade setAttrs.
     * 
     * @param value
     *     allowed object is
     *     {@link EffectiveAttrsInfo }
     *     
     */
    public void setSetAttrs(EffectiveAttrsInfo value) {
        this.setAttrs = value;
    }

}
