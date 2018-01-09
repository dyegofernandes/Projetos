
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getMailQueueInfoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getMailQueueInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="server" type="{urn:zimbraAdmin}serverQueues"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMailQueueInfoResponse", propOrder = {
    "server"
})
public class GetMailQueueInfoResponse {

    @XmlElement(required = true)
    protected ServerQueues server;

    /**
     * Obtém o valor da propriedade server.
     * 
     * @return
     *     possible object is
     *     {@link ServerQueues }
     *     
     */
    public ServerQueues getServer() {
        return server;
    }

    /**
     * Define o valor da propriedade server.
     * 
     * @param value
     *     allowed object is
     *     {@link ServerQueues }
     *     
     */
    public void setServer(ServerQueues value) {
        this.server = value;
    }

}
