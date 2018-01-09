
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import zimbra.Id;


/**
 * <p>Classe Java de setAppointmentResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="setAppointmentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="default" type="{urn:zimbra}id" minOccurs="0"/>
 *         &lt;element name="except" type="{urn:zimbraMail}exceptIdInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="calItemId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="apptId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setAppointmentResponse", propOrder = {
    "_default",
    "except"
})
@XmlSeeAlso({
    SetTaskResponse.class
})
public class SetAppointmentResponse {

    @XmlElement(name = "default")
    protected Id _default;
    protected List<ExceptIdInfo> except;
    @XmlAttribute(name = "calItemId")
    protected String calItemId;
    @XmlAttribute(name = "apptId")
    protected String apptId;

    /**
     * Obtém o valor da propriedade default.
     * 
     * @return
     *     possible object is
     *     {@link Id }
     *     
     */
    public Id getDefault() {
        return _default;
    }

    /**
     * Define o valor da propriedade default.
     * 
     * @param value
     *     allowed object is
     *     {@link Id }
     *     
     */
    public void setDefault(Id value) {
        this._default = value;
    }

    /**
     * Gets the value of the except property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the except property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExcept().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExceptIdInfo }
     * 
     * 
     */
    public List<ExceptIdInfo> getExcept() {
        if (except == null) {
            except = new ArrayList<ExceptIdInfo>();
        }
        return this.except;
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

}
