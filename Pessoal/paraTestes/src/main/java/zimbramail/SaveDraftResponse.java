
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de saveDraftResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="saveDraftResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="chat" type="{urn:zimbraMail}chatMessageInfo"/>
 *           &lt;element name="m" type="{urn:zimbraMail}messageInfo"/>
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
@XmlType(name = "saveDraftResponse", propOrder = {
    "chat",
    "m"
})
public class SaveDraftResponse {

    protected ChatMessageInfo chat;
    protected MessageInfo m;

    /**
     * Obtém o valor da propriedade chat.
     * 
     * @return
     *     possible object is
     *     {@link ChatMessageInfo }
     *     
     */
    public ChatMessageInfo getChat() {
        return chat;
    }

    /**
     * Define o valor da propriedade chat.
     * 
     * @param value
     *     allowed object is
     *     {@link ChatMessageInfo }
     *     
     */
    public void setChat(ChatMessageInfo value) {
        this.chat = value;
    }

    /**
     * Obtém o valor da propriedade m.
     * 
     * @return
     *     possible object is
     *     {@link MessageInfo }
     *     
     */
    public MessageInfo getM() {
        return m;
    }

    /**
     * Define o valor da propriedade m.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageInfo }
     *     
     */
    public void setM(MessageInfo value) {
        this.m = value;
    }

}
