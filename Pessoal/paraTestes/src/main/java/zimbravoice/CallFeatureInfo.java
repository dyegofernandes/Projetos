
package zimbravoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import zimbra.TrueOrFalse;


/**
 * <p>Classe Java de callFeatureInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="callFeatureInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="s" use="required" type="{urn:zimbra}trueOrFalse" />
 *       &lt;attribute name="a" use="required" type="{urn:zimbra}trueOrFalse" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "callFeatureInfo")
@XmlSeeAlso({
    CallWaitingFeature.class,
    CallForwardNoAnswerFeature.class,
    VoiceMailPrefsFeature.class,
    CallForwardFeature.class,
    AnonCallRejectionFeature.class,
    CallerIdBlockingFeature.class,
    FeatureWithCallerList.class,
    CallForwardBusyLineFeature.class
})
public abstract class CallFeatureInfo {

    @XmlAttribute(name = "s", required = true)
    protected TrueOrFalse s;
    @XmlAttribute(name = "a", required = true)
    protected TrueOrFalse a;

    /**
     * Obtém o valor da propriedade s.
     * 
     * @return
     *     possible object is
     *     {@link TrueOrFalse }
     *     
     */
    public TrueOrFalse getS() {
        return s;
    }

    /**
     * Define o valor da propriedade s.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueOrFalse }
     *     
     */
    public void setS(TrueOrFalse value) {
        this.s = value;
    }

    /**
     * Obtém o valor da propriedade a.
     * 
     * @return
     *     possible object is
     *     {@link TrueOrFalse }
     *     
     */
    public TrueOrFalse getA() {
        return a;
    }

    /**
     * Define o valor da propriedade a.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueOrFalse }
     *     
     */
    public void setA(TrueOrFalse value) {
        this.a = value;
    }

}
