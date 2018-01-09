
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import zimbra.Id;


/**
 * <p>Classe Java de createCalendarItemResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createCalendarItemResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="m" type="{urn:zimbra}id" minOccurs="0"/>
 *         &lt;element name="echo" type="{urn:zimbraMail}calEcho" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="calItemId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="apptId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="invId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ms" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="rev" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createCalendarItemResponse", propOrder = {
    "m",
    "echo"
})
@XmlSeeAlso({
    SendInviteReplyResponse.class,
    CreateTaskResponse.class,
    ModifyAppointmentResponse.class,
    CreateTaskExceptionResponse.class,
    CreateAppointmentResponse.class,
    CreateAppointmentExceptionResponse.class
})
public class CreateCalendarItemResponse {

    protected Id m;
    protected CalEcho echo;
    @XmlAttribute(name = "calItemId")
    protected String calItemId;
    @XmlAttribute(name = "apptId")
    protected String apptId;
    @XmlAttribute(name = "invId")
    protected String invId;
    @XmlAttribute(name = "ms")
    protected Integer ms;
    @XmlAttribute(name = "rev")
    protected Integer rev;

    /**
     * Obtém o valor da propriedade m.
     * 
     * @return
     *     possible object is
     *     {@link Id }
     *     
     */
    public Id getM() {
        return m;
    }

    /**
     * Define o valor da propriedade m.
     * 
     * @param value
     *     allowed object is
     *     {@link Id }
     *     
     */
    public void setM(Id value) {
        this.m = value;
    }

    /**
     * Obtém o valor da propriedade echo.
     * 
     * @return
     *     possible object is
     *     {@link CalEcho }
     *     
     */
    public CalEcho getEcho() {
        return echo;
    }

    /**
     * Define o valor da propriedade echo.
     * 
     * @param value
     *     allowed object is
     *     {@link CalEcho }
     *     
     */
    public void setEcho(CalEcho value) {
        this.echo = value;
    }

    /**
     * Obtém o valor da propriedade calItemId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalItemId() {
        return calItemId;
    }

    /**
     * Define o valor da propriedade calItemId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalItemId(String value) {
        this.calItemId = value;
    }

    /**
     * Obtém o valor da propriedade apptId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApptId() {
        return apptId;
    }

    /**
     * Define o valor da propriedade apptId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApptId(String value) {
        this.apptId = value;
    }

    /**
     * Obtém o valor da propriedade invId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvId() {
        return invId;
    }

    /**
     * Define o valor da propriedade invId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvId(String value) {
        this.invId = value;
    }

    /**
     * Obtém o valor da propriedade ms.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMs() {
        return ms;
    }

    /**
     * Define o valor da propriedade ms.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMs(Integer value) {
        this.ms = value;
    }

    /**
     * Obtém o valor da propriedade rev.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRev() {
        return rev;
    }

    /**
     * Define o valor da propriedade rev.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRev(Integer value) {
        this.rev = value;
    }

}
