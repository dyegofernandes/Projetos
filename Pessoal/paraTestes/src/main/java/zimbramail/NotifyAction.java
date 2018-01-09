
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de notifyAction complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="notifyAction">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}filterAction">
 *       &lt;sequence>
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="a" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="su" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="maxBodySize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="origHeaders" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notifyAction", propOrder = {
    "content"
})
public class NotifyAction
    extends FilterAction
{

    protected String content;
    @XmlAttribute(name = "a")
    protected String a;
    @XmlAttribute(name = "su")
    protected String su;
    @XmlAttribute(name = "maxBodySize")
    protected Integer maxBodySize;
    @XmlAttribute(name = "origHeaders")
    protected String origHeaders;

    /**
     * Obtém o valor da propriedade content.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Define o valor da propriedade content.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Obtém o valor da propriedade a.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getA() {
        return a;
    }

    /**
     * Define o valor da propriedade a.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setA(String value) {
        this.a = value;
    }

    /**
     * Obtém o valor da propriedade su.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSu() {
        return su;
    }

    /**
     * Define o valor da propriedade su.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSu(String value) {
        this.su = value;
    }

    /**
     * Obtém o valor da propriedade maxBodySize.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxBodySize() {
        return maxBodySize;
    }

    /**
     * Define o valor da propriedade maxBodySize.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxBodySize(Integer value) {
        this.maxBodySize = value;
    }

    /**
     * Obtém o valor da propriedade origHeaders.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigHeaders() {
        return origHeaders;
    }

    /**
     * Define o valor da propriedade origHeaders.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigHeaders(String value) {
        this.origHeaders = value;
    }

}
