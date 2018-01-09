
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de alarmTriggerInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="alarmTriggerInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="abs" type="{urn:zimbraMail}dateAttr" minOccurs="0"/>
 *         &lt;element name="rel" type="{urn:zimbraMail}durationInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alarmTriggerInfo", propOrder = {
    "abs",
    "rel"
})
public class AlarmTriggerInfo {

    protected DateAttr abs;
    protected DurationInfo rel;

    /**
     * Obtém o valor da propriedade abs.
     * 
     * @return
     *     possible object is
     *     {@link DateAttr }
     *     
     */
    public DateAttr getAbs() {
        return abs;
    }

    /**
     * Define o valor da propriedade abs.
     * 
     * @param value
     *     allowed object is
     *     {@link DateAttr }
     *     
     */
    public void setAbs(DateAttr value) {
        this.abs = value;
    }

    /**
     * Obtém o valor da propriedade rel.
     * 
     * @return
     *     possible object is
     *     {@link DurationInfo }
     *     
     */
    public DurationInfo getRel() {
        return rel;
    }

    /**
     * Define o valor da propriedade rel.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationInfo }
     *     
     */
    public void setRel(DurationInfo value) {
        this.rel = value;
    }

}
