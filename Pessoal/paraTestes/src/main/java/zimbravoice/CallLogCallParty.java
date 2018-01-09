
package zimbravoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de callLogCallParty complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="callLogCallParty">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraVoice}voiceMailCallParty">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="ci" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="st" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="co" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "callLogCallParty")
public class CallLogCallParty
    extends VoiceMailCallParty
{

    @XmlAttribute(name = "ci", required = true)
    protected String ci;
    @XmlAttribute(name = "st", required = true)
    protected String st;
    @XmlAttribute(name = "co", required = true)
    protected String co;

    /**
     * Obtém o valor da propriedade ci.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCi() {
        return ci;
    }

    /**
     * Define o valor da propriedade ci.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCi(String value) {
        this.ci = value;
    }

    /**
     * Obtém o valor da propriedade st.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSt() {
        return st;
    }

    /**
     * Define o valor da propriedade st.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSt(String value) {
        this.st = value;
    }

    /**
     * Obtém o valor da propriedade co.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCo() {
        return co;
    }

    /**
     * Define o valor da propriedade co.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCo(String value) {
        this.co = value;
    }

}
