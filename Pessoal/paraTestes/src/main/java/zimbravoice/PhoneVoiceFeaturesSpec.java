
package zimbravoice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de phoneVoiceFeaturesSpec complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="phoneVoiceFeaturesSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="voicemailprefs" type="{urn:zimbraVoice}voiceMailPrefsReq"/>
 *           &lt;element name="anoncallrejection" type="{urn:zimbraVoice}anonCallRejectionReq"/>
 *           &lt;element name="calleridblocking" type="{urn:zimbraVoice}callerIdBlockingReq"/>
 *           &lt;element name="callforward" type="{urn:zimbraVoice}callForwardReq"/>
 *           &lt;element name="callforwardbusyline" type="{urn:zimbraVoice}callForwardBusyLineReq"/>
 *           &lt;element name="callforwardnoanswer" type="{urn:zimbraVoice}callForwardNoAnswerReq"/>
 *           &lt;element name="callwaiting" type="{urn:zimbraVoice}callWaitingReq"/>
 *           &lt;element name="selectivecallforward" type="{urn:zimbraVoice}selectiveCallForwardReq"/>
 *           &lt;element name="selectivecallacceptance" type="{urn:zimbraVoice}selectiveCallAcceptanceReq"/>
 *           &lt;element name="selectivecallrejection" type="{urn:zimbraVoice}selectiveCallRejectionReq"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "phoneVoiceFeaturesSpec", propOrder = {
    "voicemailprefsOrAnoncallrejectionOrCalleridblocking"
})
public class PhoneVoiceFeaturesSpec {

    @XmlElements({
        @XmlElement(name = "voicemailprefs", type = VoiceMailPrefsReq.class),
        @XmlElement(name = "anoncallrejection", type = AnonCallRejectionReq.class),
        @XmlElement(name = "calleridblocking", type = CallerIdBlockingReq.class),
        @XmlElement(name = "callforward", type = CallForwardReq.class),
        @XmlElement(name = "callforwardbusyline", type = CallForwardBusyLineReq.class),
        @XmlElement(name = "callforwardnoanswer", type = CallForwardNoAnswerReq.class),
        @XmlElement(name = "callwaiting", type = CallWaitingReq.class),
        @XmlElement(name = "selectivecallforward", type = SelectiveCallForwardReq.class),
        @XmlElement(name = "selectivecallacceptance", type = SelectiveCallAcceptanceReq.class),
        @XmlElement(name = "selectivecallrejection", type = SelectiveCallRejectionReq.class)
    })
    protected List<Object> voicemailprefsOrAnoncallrejectionOrCalleridblocking;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the voicemailprefsOrAnoncallrejectionOrCalleridblocking property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the voicemailprefsOrAnoncallrejectionOrCalleridblocking property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVoicemailprefsOrAnoncallrejectionOrCalleridblocking().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VoiceMailPrefsReq }
     * {@link AnonCallRejectionReq }
     * {@link CallerIdBlockingReq }
     * {@link CallForwardReq }
     * {@link CallForwardBusyLineReq }
     * {@link CallForwardNoAnswerReq }
     * {@link CallWaitingReq }
     * {@link SelectiveCallForwardReq }
     * {@link SelectiveCallAcceptanceReq }
     * {@link SelectiveCallRejectionReq }
     * 
     * 
     */
    public List<Object> getVoicemailprefsOrAnoncallrejectionOrCalleridblocking() {
        if (voicemailprefsOrAnoncallrejectionOrCalleridblocking == null) {
            voicemailprefsOrAnoncallrejectionOrCalleridblocking = new ArrayList<Object>();
        }
        return this.voicemailprefsOrAnoncallrejectionOrCalleridblocking;
    }

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
