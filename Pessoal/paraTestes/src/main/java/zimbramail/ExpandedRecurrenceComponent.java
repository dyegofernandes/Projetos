
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de expandedRecurrenceComponent complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="expandedRecurrenceComponent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exceptId" type="{urn:zimbraMail}instanceRecurIdInfo" minOccurs="0"/>
 *         &lt;element name="dur" type="{urn:zimbraMail}durationInfo" minOccurs="0"/>
 *         &lt;element name="recur" type="{urn:zimbraMail}recurrenceInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="e" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "expandedRecurrenceComponent", propOrder = {
    "exceptId",
    "dur",
    "recur"
})
@XmlSeeAlso({
    ExpandedRecurrenceInvite.class,
    ExpandedRecurrenceCancel.class,
    ExpandedRecurrenceException.class
})
public class ExpandedRecurrenceComponent {

    protected InstanceRecurIdInfo exceptId;
    protected DurationInfo dur;
    protected RecurrenceInfo recur;
    @XmlAttribute(name = "s")
    protected Long s;
    @XmlAttribute(name = "e")
    protected Long e;

    /**
     * Obtém o valor da propriedade exceptId.
     * 
     * @return
     *     possible object is
     *     {@link InstanceRecurIdInfo }
     *     
     */
    public InstanceRecurIdInfo getExceptId() {
        return exceptId;
    }

    /**
     * Define o valor da propriedade exceptId.
     * 
     * @param value
     *     allowed object is
     *     {@link InstanceRecurIdInfo }
     *     
     */
    public void setExceptId(InstanceRecurIdInfo value) {
        this.exceptId = value;
    }

    /**
     * Obtém o valor da propriedade dur.
     * 
     * @return
     *     possible object is
     *     {@link DurationInfo }
     *     
     */
    public DurationInfo getDur() {
        return dur;
    }

    /**
     * Define o valor da propriedade dur.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationInfo }
     *     
     */
    public void setDur(DurationInfo value) {
        this.dur = value;
    }

    /**
     * Obtém o valor da propriedade recur.
     * 
     * @return
     *     possible object is
     *     {@link RecurrenceInfo }
     *     
     */
    public RecurrenceInfo getRecur() {
        return recur;
    }

    /**
     * Define o valor da propriedade recur.
     * 
     * @param value
     *     allowed object is
     *     {@link RecurrenceInfo }
     *     
     */
    public void setRecur(RecurrenceInfo value) {
        this.recur = value;
    }

    /**
     * Obtém o valor da propriedade s.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getS() {
        return s;
    }

    /**
     * Define o valor da propriedade s.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setS(Long value) {
        this.s = value;
    }

    /**
     * Obtém o valor da propriedade e.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getE() {
        return e;
    }

    /**
     * Define o valor da propriedade e.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setE(Long value) {
        this.e = value;
    }

}
