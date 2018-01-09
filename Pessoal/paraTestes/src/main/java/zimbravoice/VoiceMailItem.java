
package zimbravoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de voiceMailItem complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="voiceMailItem">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraVoice}voiceCallItem">
 *       &lt;sequence>
 *         &lt;element name="cp" type="{urn:zimbraVoice}voiceMailCallParty" minOccurs="0"/>
 *         &lt;element name="content" type="{urn:zimbraVoice}voiceMailContent" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="f" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voiceMailItem", propOrder = {
    "cp",
    "content"
})
public class VoiceMailItem
    extends VoiceCallItem
{

    protected VoiceMailCallParty cp;
    protected VoiceMailContent content;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "f")
    protected String f;

    /**
     * Obtém o valor da propriedade cp.
     * 
     * @return
     *     possible object is
     *     {@link VoiceMailCallParty }
     *     
     */
    public VoiceMailCallParty getCp() {
        return cp;
    }

    /**
     * Define o valor da propriedade cp.
     * 
     * @param value
     *     allowed object is
     *     {@link VoiceMailCallParty }
     *     
     */
    public void setCp(VoiceMailCallParty value) {
        this.cp = value;
    }

    /**
     * Obtém o valor da propriedade content.
     * 
     * @return
     *     possible object is
     *     {@link VoiceMailContent }
     *     
     */
    public VoiceMailContent getContent() {
        return content;
    }

    /**
     * Define o valor da propriedade content.
     * 
     * @param value
     *     allowed object is
     *     {@link VoiceMailContent }
     *     
     */
    public void setContent(VoiceMailContent value) {
        this.content = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade f.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getF() {
        return f;
    }

    /**
     * Define o valor da propriedade f.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setF(String value) {
        this.f = value;
    }

}
