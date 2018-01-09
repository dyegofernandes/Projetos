
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getRecurResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getRecurResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tz" type="{urn:zimbraMail}calTZInfo" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="cancel" type="{urn:zimbraMail}cancelItemRecur"/>
 *           &lt;element name="except" type="{urn:zimbraMail}exceptionItemRecur"/>
 *           &lt;element name="comp" type="{urn:zimbraMail}inviteItemRecur"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRecurResponse", propOrder = {
    "tz",
    "cancelOrExceptOrComp"
})
public class GetRecurResponse {

    protected CalTZInfo tz;
    @XmlElements({
        @XmlElement(name = "cancel", type = CancelItemRecur.class),
        @XmlElement(name = "except", type = ExceptionItemRecur.class),
        @XmlElement(name = "comp", type = InviteItemRecur.class)
    })
    protected List<CalendarItemRecur> cancelOrExceptOrComp;

    /**
     * Obtém o valor da propriedade tz.
     * 
     * @return
     *     possible object is
     *     {@link CalTZInfo }
     *     
     */
    public CalTZInfo getTz() {
        return tz;
    }

    /**
     * Define o valor da propriedade tz.
     * 
     * @param value
     *     allowed object is
     *     {@link CalTZInfo }
     *     
     */
    public void setTz(CalTZInfo value) {
        this.tz = value;
    }

    /**
     * Gets the value of the cancelOrExceptOrComp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cancelOrExceptOrComp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCancelOrExceptOrComp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CancelItemRecur }
     * {@link ExceptionItemRecur }
     * {@link InviteItemRecur }
     * 
     * 
     */
    public List<CalendarItemRecur> getCancelOrExceptOrComp() {
        if (cancelOrExceptOrComp == null) {
            cancelOrExceptOrComp = new ArrayList<CalendarItemRecur>();
        }
        return this.cancelOrExceptOrComp;
    }

}
