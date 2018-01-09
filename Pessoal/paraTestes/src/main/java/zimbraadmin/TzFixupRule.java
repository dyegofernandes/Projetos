
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tzFixupRule complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tzFixupRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="match" type="{urn:zimbraAdmin}tzFixupRuleMatch"/>
 *         &lt;element name="touch" type="{urn:zimbraAdmin}simpleElement" minOccurs="0"/>
 *         &lt;element name="replace" type="{urn:zimbraAdmin}tzReplaceInfo" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tzFixupRule", propOrder = {

})
public class TzFixupRule {

    @XmlElement(required = true)
    protected TzFixupRuleMatch match;
    protected SimpleElement touch;
    protected TzReplaceInfo replace;

    /**
     * Obtém o valor da propriedade match.
     * 
     * @return
     *     possible object is
     *     {@link TzFixupRuleMatch }
     *     
     */
    public TzFixupRuleMatch getMatch() {
        return match;
    }

    /**
     * Define o valor da propriedade match.
     * 
     * @param value
     *     allowed object is
     *     {@link TzFixupRuleMatch }
     *     
     */
    public void setMatch(TzFixupRuleMatch value) {
        this.match = value;
    }

    /**
     * Obtém o valor da propriedade touch.
     * 
     * @return
     *     possible object is
     *     {@link SimpleElement }
     *     
     */
    public SimpleElement getTouch() {
        return touch;
    }

    /**
     * Define o valor da propriedade touch.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleElement }
     *     
     */
    public void setTouch(SimpleElement value) {
        this.touch = value;
    }

    /**
     * Obtém o valor da propriedade replace.
     * 
     * @return
     *     possible object is
     *     {@link TzReplaceInfo }
     *     
     */
    public TzReplaceInfo getReplace() {
        return replace;
    }

    /**
     * Define o valor da propriedade replace.
     * 
     * @param value
     *     allowed object is
     *     {@link TzReplaceInfo }
     *     
     */
    public void setReplace(TzReplaceInfo value) {
        this.replace = value;
    }

}
