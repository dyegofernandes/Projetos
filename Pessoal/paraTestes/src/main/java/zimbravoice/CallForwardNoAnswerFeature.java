
package zimbravoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de callForwardNoAnswerFeature complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="callForwardNoAnswerFeature">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraVoice}callFeatureInfo">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="ft" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "callForwardNoAnswerFeature")
public class CallForwardNoAnswerFeature
    extends CallFeatureInfo
{

    @XmlAttribute(name = "ft")
    protected String ft;
    @XmlAttribute(name = "nr")
    protected String nr;

    /**
     * Obtém o valor da propriedade ft.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFt() {
        return ft;
    }

    /**
     * Define o valor da propriedade ft.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFt(String value) {
        this.ft = value;
    }

    /**
     * Obtém o valor da propriedade nr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNr() {
        return nr;
    }

    /**
     * Define o valor da propriedade nr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNr(String value) {
        this.nr = value;
    }

}
