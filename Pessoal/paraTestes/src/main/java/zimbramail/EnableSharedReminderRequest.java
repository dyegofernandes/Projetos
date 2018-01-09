
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de enableSharedReminderRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="enableSharedReminderRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="link" type="{urn:zimbraMail}sharedReminderMount"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enableSharedReminderRequest", propOrder = {
    "link"
})
public class EnableSharedReminderRequest {

    @XmlElement(required = true)
    protected SharedReminderMount link;

    /**
     * Obtém o valor da propriedade link.
     * 
     * @return
     *     possible object is
     *     {@link SharedReminderMount }
     *     
     */
    public SharedReminderMount getLink() {
        return link;
    }

    /**
     * Define o valor da propriedade link.
     * 
     * @param value
     *     allowed object is
     *     {@link SharedReminderMount }
     *     
     */
    public void setLink(SharedReminderMount value) {
        this.link = value;
    }

}
