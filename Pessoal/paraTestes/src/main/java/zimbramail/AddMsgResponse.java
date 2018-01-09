
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de addMsgResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="addMsgResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="chat" type="{urn:zimbraMail}chatSummary"/>
 *           &lt;element name="m" type="{urn:zimbraMail}messageSummary"/>
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
@XmlType(name = "addMsgResponse", propOrder = {
    "chat",
    "m"
})
public class AddMsgResponse {

    protected ChatSummary chat;
    protected MessageSummary m;

    /**
     * Obtém o valor da propriedade chat.
     * 
     * @return
     *     possible object is
     *     {@link ChatSummary }
     *     
     */
    public ChatSummary getChat() {
        return chat;
    }

    /**
     * Define o valor da propriedade chat.
     * 
     * @param value
     *     allowed object is
     *     {@link ChatSummary }
     *     
     */
    public void setChat(ChatSummary value) {
        this.chat = value;
    }

    /**
     * Obtém o valor da propriedade m.
     * 
     * @return
     *     possible object is
     *     {@link MessageSummary }
     *     
     */
    public MessageSummary getM() {
        return m;
    }

    /**
     * Define o valor da propriedade m.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageSummary }
     *     
     */
    public void setM(MessageSummary value) {
        this.m = value;
    }

}
