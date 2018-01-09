
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de mimePartAttachSpec complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="mimePartAttachSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}attachSpec">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="mid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="part" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mimePartAttachSpec")
public class MimePartAttachSpec
    extends AttachSpec
{

    @XmlAttribute(name = "mid", required = true)
    protected String mid;
    @XmlAttribute(name = "part", required = true)
    protected String part;

    /**
     * Obtém o valor da propriedade mid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMid() {
        return mid;
    }

    /**
     * Define o valor da propriedade mid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMid(String value) {
        this.mid = value;
    }

    /**
     * Obtém o valor da propriedade part.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPart() {
        return part;
    }

    /**
     * Define o valor da propriedade part.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPart(String value) {
        this.part = value;
    }

}
