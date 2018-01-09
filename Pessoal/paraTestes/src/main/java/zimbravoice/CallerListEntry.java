
package zimbravoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.TrueOrFalse;


/**
 * <p>Classe Java de callerListEntry complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="callerListEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="pn" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="a" use="required" type="{urn:zimbra}trueOrFalse" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "callerListEntry")
public class CallerListEntry {

    @XmlAttribute(name = "pn", required = true)
    protected String pn;
    @XmlAttribute(name = "a", required = true)
    protected TrueOrFalse a;

    /**
     * Obtém o valor da propriedade pn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPn() {
        return pn;
    }

    /**
     * Define o valor da propriedade pn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPn(String value) {
        this.pn = value;
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
