
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getICalResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getICalResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ical" type="{urn:zimbraMail}iCalContent"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getICalResponse", propOrder = {
    "ical"
})
public class GetICalResponse {

    @XmlElement(required = true)
    protected ICalContent ical;

    /**
     * Obtém o valor da propriedade ical.
     * 
     * @return
     *     possible object is
     *     {@link ICalContent }
     *     
     */
    public ICalContent getIcal() {
        return ical;
    }

    /**
     * Define o valor da propriedade ical.
     * 
     * @param value
     *     allowed object is
     *     {@link ICalContent }
     *     
     */
    public void setIcal(ICalContent value) {
        this.ical = value;
    }

}
