
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de calendarItemRecur complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="calendarItemRecur">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exceptId" type="{urn:zimbraMail}exceptionRecurIdInfo" minOccurs="0"/>
 *         &lt;element name="s" type="{urn:zimbraMail}dtTimeInfo" minOccurs="0"/>
 *         &lt;element name="e" type="{urn:zimbraMail}dtTimeInfo" minOccurs="0"/>
 *         &lt;element name="dur" type="{urn:zimbraMail}durationInfo" minOccurs="0"/>
 *         &lt;element name="recur" type="{urn:zimbraMail}recurrenceInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calendarItemRecur", propOrder = {
    "exceptId",
    "s",
    "e",
    "dur",
    "recur"
})
@XmlSeeAlso({
    CancelItemRecur.class,
    ExceptionItemRecur.class,
    InviteItemRecur.class
})
public class CalendarItemRecur {

    protected ExceptionRecurIdInfo exceptId;
    protected DtTimeInfo s;
    protected DtTimeInfo e;
    protected DurationInfo dur;
    protected RecurrenceInfo recur;

    /**
     * Obtém o valor da propriedade exceptId.
     * 
     * @return
     *     possible object is
     *     {@link ExceptionRecurIdInfo }
     *     
     */
    public ExceptionRecurIdInfo getExceptId() {
        return exceptId;
    }

    /**
     * Define o valor da propriedade exceptId.
     * 
     * @param value
     *     allowed object is
     *     {@link ExceptionRecurIdInfo }
     *     
     */
    public void setExceptId(ExceptionRecurIdInfo value) {
        this.exceptId = value;
    }

    /**
     * Obtém o valor da propriedade s.
     * 
     * @return
     *     possible object is
     *     {@link DtTimeInfo }
     *     
     */
    public DtTimeInfo getS() {
        return s;
    }

    /**
     * Define o valor da propriedade s.
     * 
     * @param value
     *     allowed object is
     *     {@link DtTimeInfo }
     *     
     */
    public void setS(DtTimeInfo value) {
        this.s = value;
    }

    /**
     * Obtém o valor da propriedade e.
     * 
     * @return
     *     possible object is
     *     {@link DtTimeInfo }
     *     
     */
    public DtTimeInfo getE() {
        return e;
    }

    /**
     * Define o valor da propriedade e.
     * 
     * @param value
     *     allowed object is
     *     {@link DtTimeInfo }
     *     
     */
    public void setE(DtTimeInfo value) {
        this.e = value;
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

}
