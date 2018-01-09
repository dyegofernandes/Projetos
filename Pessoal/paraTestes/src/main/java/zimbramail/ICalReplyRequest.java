
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de iCalReplyRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="iCalReplyRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ical" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iCalReplyRequest", propOrder = {
    "ical"
})
public class ICalReplyRequest {

    @XmlElement(required = true)
    protected String ical;

    /**
     * Obtém o valor da propriedade ical.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcal() {
        return ical;
    }

    /**
     * Define o valor da propriedade ical.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcal(String value) {
        this.ical = value;
    }

}
