
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
 * <p>Classe Java de phoneVoiceFeaturesInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="phoneVoiceFeaturesInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="voicemailprefs" type="{urn:zimbraVoice}voiceMailPrefsFeature"/>
 *           &lt;element name="anoncallrejection" type="{urn:zimbraVoice}anonCallRejectionFeature"/>
 *           &lt;element name="calleridblocking" type="{urn:zimbraVoice}callerIdBlockingFeature"/>
 *           &lt;element name="callforward" type="{urn:zimbraVoice}callForwardFeature"/>
 *           &lt;element name="callforwardbusyline" type="{urn:zimbraVoice}callForwardBusyLineFeature"/>
 *           &lt;element name="callforwardnoanswer" type="{urn:zimbraVoice}callForwardNoAnswerFeature"/>
 *           &lt;element name="callwaiting" type="{urn:zimbraVoice}callWaitingFeature"/>
 *           &lt;element name="selectivecallforward" type="{urn:zimbraVoice}selectiveCallForwardFeature"/>
 *           &lt;element name="selectivecallacceptance" type="{urn:zimbraVoice}selectiveCallAcceptanceFeature"/>
 *           &lt;element name="selectivecallrejection" type="{urn:zimbraVoice}selectiveCallRejectionFeature"/>
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
@XmlType(name = "phoneVoiceFeaturesInfo", propOrder = {
    "voicemailprefsOrAnoncallrejectionOrCalleridblocking"
})
public class PhoneVoiceFeaturesInfo {

    @XmlElements({
        @XmlElement(name = "voicemailprefs", type = VoiceMailPrefsFeature.class),
        @XmlElement(name = "anoncallrejection", type = AnonCallRejectionFeature.class),
        @XmlElement(name = "calleridblocking", type = CallerIdBlockingFeature.class),
        @XmlElement(name = "callforward", type = CallForwardFeature.class),
        @XmlElement(name = "callforwardbusyline", type = CallForwardBusyLineFeature.class),
        @XmlElement(name = "callforwardnoanswer", type = CallForwardNoAnswerFeature.class),
        @XmlElement(name = "callwaiting", type = CallWaitingFeature.class),
        @XmlElement(name = "selectivecallforward", type = SelectiveCallForwardFeature.class),
        @XmlElement(name = "selectivecallacceptance", type = SelectiveCallAcceptanceFeature.class),
        @XmlElement(name = "selectivecallrejection", type = SelectiveCallRejectionFeature.class)
    })
    protected List<CallFeatureInfo> voicemailprefsOrAnoncallrejectionOrCalleridblocking;
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
     * {@link VoiceMailPrefsFeature }
     * {@link AnonCallRejectionFeature }
     * {@link CallerIdBlockingFeature }
     * {@link CallForwardFeature }
     * {@link CallForwardBusyLineFeature }
     * {@link CallForwardNoAnswerFeature }
     * {@link CallWaitingFeature }
     * {@link SelectiveCallForwardFeature }
     * {@link SelectiveCallAcceptanceFeature }
     * {@link SelectiveCallRejectionFeature }
     * 
     * 
     */
    public List<CallFeatureInfo> getVoicemailprefsOrAnoncallrejectionOrCalleridblocking() {
        if (voicemailprefsOrAnoncallrejectionOrCalleridblocking == null) {
            voicemailprefsOrAnoncallrejectionOrCalleridblocking = new ArrayList<CallFeatureInfo>();
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
