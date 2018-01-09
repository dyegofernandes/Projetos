
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.AttributeSelectorImpl;


/**
 * <p>Classe Java de getCalendarResourceRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getCalendarResourceRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbra}attributeSelectorImpl">
 *       &lt;sequence>
 *         &lt;element name="calresource" type="{urn:zimbraAdmin}calendarResourceSelector" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="applyCos" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCalendarResourceRequest", propOrder = {
    "calresource"
})
public class GetCalendarResourceRequest
    extends AttributeSelectorImpl
{

    protected CalendarResourceSelector calresource;
    @XmlAttribute(name = "applyCos")
    protected Boolean applyCos;

    /**
     * Obtém o valor da propriedade calresource.
     * 
     * @return
     *     possible object is
     *     {@link CalendarResourceSelector }
     *     
     */
    public CalendarResourceSelector getCalresource() {
        return calresource;
    }

    /**
     * Define o valor da propriedade calresource.
     * 
     * @param value
     *     allowed object is
     *     {@link CalendarResourceSelector }
     *     
     */
    public void setCalresource(CalendarResourceSelector value) {
        this.calresource = value;
    }

    /**
     * Obtém o valor da propriedade applyCos.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isApplyCos() {
        return applyCos;
    }

    /**
     * Define o valor da propriedade applyCos.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setApplyCos(Boolean value) {
        this.applyCos = value;
    }

}
