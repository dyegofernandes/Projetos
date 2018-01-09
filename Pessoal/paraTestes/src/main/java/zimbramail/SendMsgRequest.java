
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de sendMsgRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="sendMsgRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="m" type="{urn:zimbraMail}msgToSend" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="needCalendarSentByFixup" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="isCalendarForward" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="noSave" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="fetchSavedMsg" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="suid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendMsgRequest", propOrder = {
    "m"
})
@XmlSeeAlso({
    SendSecureMsgRequest.class
})
public class SendMsgRequest {

    protected MsgToSend m;
    @XmlAttribute(name = "needCalendarSentByFixup")
    protected Boolean needCalendarSentByFixup;
    @XmlAttribute(name = "isCalendarForward")
    protected Boolean isCalendarForward;
    @XmlAttribute(name = "noSave")
    protected Boolean noSave;
    @XmlAttribute(name = "fetchSavedMsg")
    protected Boolean fetchSavedMsg;
    @XmlAttribute(name = "suid")
    protected String suid;

    /**
     * Obtém o valor da propriedade m.
     * 
     * @return
     *     possible object is
     *     {@link MsgToSend }
     *     
     */
    public MsgToSend getM() {
        return m;
    }

    /**
     * Define o valor da propriedade m.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgToSend }
     *     
     */
    public void setM(MsgToSend value) {
        this.m = value;
    }

    /**
     * Obtém o valor da propriedade needCalendarSentByFixup.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedCalendarSentByFixup() {
        return needCalendarSentByFixup;
    }

    /**
     * Define o valor da propriedade needCalendarSentByFixup.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedCalendarSentByFixup(Boolean value) {
        this.needCalendarSentByFixup = value;
    }

    /**
     * Obtém o valor da propriedade isCalendarForward.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCalendarForward() {
        return isCalendarForward;
    }

    /**
     * Define o valor da propriedade isCalendarForward.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCalendarForward(Boolean value) {
        this.isCalendarForward = value;
    }

    /**
     * Obtém o valor da propriedade noSave.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNoSave() {
        return noSave;
    }

    /**
     * Define o valor da propriedade noSave.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNoSave(Boolean value) {
        this.noSave = value;
    }

    /**
     * Obtém o valor da propriedade fetchSavedMsg.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFetchSavedMsg() {
        return fetchSavedMsg;
    }

    /**
     * Define o valor da propriedade fetchSavedMsg.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFetchSavedMsg(Boolean value) {
        this.fetchSavedMsg = value;
    }

    /**
     * Obtém o valor da propriedade suid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuid() {
        return suid;
    }

    /**
     * Define o valor da propriedade suid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuid(String value) {
        this.suid = value;
    }

}
