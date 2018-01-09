
package zimbravoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de voiceCallItem complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="voiceCallItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="phone" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="l" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sf" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="du" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="d" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voiceCallItem")
@XmlSeeAlso({
    CallLogItem.class,
    VoiceMailItem.class
})
public class VoiceCallItem {

    @XmlAttribute(name = "phone", required = true)
    protected String phone;
    @XmlAttribute(name = "l", required = true)
    protected String l;
    @XmlAttribute(name = "sf", required = true)
    protected String sf;
    @XmlAttribute(name = "du", required = true)
    protected int du;
    @XmlAttribute(name = "d", required = true)
    protected long d;

    /**
     * Obtém o valor da propriedade phone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Define o valor da propriedade phone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Obtém o valor da propriedade l.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getL() {
        return l;
    }

    /**
     * Define o valor da propriedade l.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setL(String value) {
        this.l = value;
    }

    /**
     * Obtém o valor da propriedade sf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSf() {
        return sf;
    }

    /**
     * Define o valor da propriedade sf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSf(String value) {
        this.sf = value;
    }

    /**
     * Obtém o valor da propriedade du.
     * 
     */
    public int getDu() {
        return du;
    }

    /**
     * Define o valor da propriedade du.
     * 
     */
    public void setDu(int value) {
        this.du = value;
    }

    /**
     * Obtém o valor da propriedade d.
     * 
     */
    public long getD() {
        return d;
    }

    /**
     * Define o valor da propriedade d.
     * 
     */
    public void setD(long value) {
        this.d = value;
    }

}
