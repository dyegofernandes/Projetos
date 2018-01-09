
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de setCalendarItemInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="setCalendarItemInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="m" type="{urn:zimbraMail}msg" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ptst" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setCalendarItemInfo", propOrder = {
    "m"
})
@XmlSeeAlso({
    AddAppointmentInviteRequest.class,
    AddTaskInviteRequest.class
})
public class SetCalendarItemInfo {

    protected Msg m;
    @XmlAttribute(name = "ptst")
    protected String ptst;

    /**
     * Obtém o valor da propriedade m.
     * 
     * @return
     *     possible object is
     *     {@link Msg }
     *     
     */
    public Msg getM() {
        return m;
    }

    /**
     * Define o valor da propriedade m.
     * 
     * @param value
     *     allowed object is
     *     {@link Msg }
     *     
     */
    public void setM(Msg value) {
        this.m = value;
    }

    /**
     * Obtém o valor da propriedade ptst.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPtst() {
        return ptst;
    }

    /**
     * Define o valor da propriedade ptst.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPtst(String value) {
        this.ptst = value;
    }

}
