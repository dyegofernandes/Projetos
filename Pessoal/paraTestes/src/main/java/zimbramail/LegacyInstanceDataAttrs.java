
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de legacyInstanceDataAttrs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="legacyInstanceDataAttrs">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}commonInstanceDataAttrs">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="d" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "legacyInstanceDataAttrs")
@XmlSeeAlso({
    LegacyInstanceDataInfo.class
})
public class LegacyInstanceDataAttrs
    extends CommonInstanceDataAttrs
{

    @XmlAttribute(name = "d")
    protected Long d;

    /**
     * Obtém o valor da propriedade d.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getD() {
        return d;
    }

    /**
     * Define o valor da propriedade d.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setD(Long value) {
        this.d = value;
    }

}
