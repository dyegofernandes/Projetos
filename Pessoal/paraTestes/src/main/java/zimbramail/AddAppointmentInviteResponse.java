
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de addAppointmentInviteResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="addAppointmentInviteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="calItemId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="invId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="compNum" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addAppointmentInviteResponse")
@XmlSeeAlso({
    AddTaskInviteResponse.class
})
public class AddAppointmentInviteResponse {

    @XmlAttribute(name = "calItemId")
    protected Integer calItemId;
    @XmlAttribute(name = "invId")
    protected Integer invId;
    @XmlAttribute(name = "compNum")
    protected Integer compNum;

    /**
     * Obtém o valor da propriedade calItemId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCalItemId() {
        return calItemId;
    }

    /**
     * Define o valor da propriedade calItemId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCalItemId(Integer value) {
        this.calItemId = value;
    }

    /**
     * Obtém o valor da propriedade invId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInvId() {
        return invId;
    }

    /**
     * Define o valor da propriedade invId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInvId(Integer value) {
        this.invId = value;
    }

    /**
     * Obtém o valor da propriedade compNum.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCompNum() {
        return compNum;
    }

    /**
     * Define o valor da propriedade compNum.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCompNum(Integer value) {
        this.compNum = value;
    }

}
