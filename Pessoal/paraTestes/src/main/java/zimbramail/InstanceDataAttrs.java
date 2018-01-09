
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de instanceDataAttrs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="instanceDataAttrs">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}commonInstanceDataAttrs">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="dur" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "instanceDataAttrs")
@XmlSeeAlso({
    InstanceDataInfo.class,
    CommonCalendaringData.class
})
public class InstanceDataAttrs
    extends CommonInstanceDataAttrs
{

    @XmlAttribute(name = "dur")
    protected Long dur;

    /**
     * Obtém o valor da propriedade dur.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDur() {
        return dur;
    }

    /**
     * Define o valor da propriedade dur.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDur(Long value) {
        this.dur = value;
    }

}
