
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de renameCalendarResourceResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="renameCalendarResourceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="calresource" type="{urn:zimbraAdmin}calendarResourceInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "renameCalendarResourceResponse", propOrder = {
    "calresource"
})
public class RenameCalendarResourceResponse {

    @XmlElement(required = true)
    protected CalendarResourceInfo calresource;

    /**
     * Obtém o valor da propriedade calresource.
     * 
     * @return
     *     possible object is
     *     {@link CalendarResourceInfo }
     *     
     */
    public CalendarResourceInfo getCalresource() {
        return calresource;
    }

    /**
     * Define o valor da propriedade calresource.
     * 
     * @param value
     *     allowed object is
     *     {@link CalendarResourceInfo }
     *     
     */
    public void setCalresource(CalendarResourceInfo value) {
        this.calresource = value;
    }

}
