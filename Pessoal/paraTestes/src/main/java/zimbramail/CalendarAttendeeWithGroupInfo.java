
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de calendarAttendeeWithGroupInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="calendarAttendeeWithGroupInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}calendarAttendee">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="isGroup" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="exp" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calendarAttendeeWithGroupInfo")
public class CalendarAttendeeWithGroupInfo
    extends CalendarAttendee
{

    @XmlAttribute(name = "isGroup")
    protected Boolean isGroup;
    @XmlAttribute(name = "exp")
    protected Boolean exp;

    /**
     * Obtém o valor da propriedade isGroup.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsGroup() {
        return isGroup;
    }

    /**
     * Define o valor da propriedade isGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsGroup(Boolean value) {
        this.isGroup = value;
    }

    /**
     * Obtém o valor da propriedade exp.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExp() {
        return exp;
    }

    /**
     * Define o valor da propriedade exp.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExp(Boolean value) {
        this.exp = value;
    }

}
