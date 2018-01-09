
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de scheduleBackupsRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="scheduleBackupsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="server" type="{urn:zimbraAdmin}name"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "scheduleBackupsRequest", propOrder = {
    "server"
})
public class ScheduleBackupsRequest {

    @XmlElement(required = true)
    protected Name server;

    /**
     * Obtém o valor da propriedade server.
     * 
     * @return
     *     possible object is
     *     {@link Name }
     *     
     */
    public Name getServer() {
        return server;
    }

    /**
     * Define o valor da propriedade server.
     * 
     * @param value
     *     allowed object is
     *     {@link Name }
     *     
     */
    public void setServer(Name value) {
        this.server = value;
    }

}
