
package zimbravoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de voiceFolderSummary complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="voiceFolderSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="u" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="n" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voiceFolderSummary")
public class VoiceFolderSummary {

    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "u", required = true)
    protected long u;
    @XmlAttribute(name = "n", required = true)
    protected long n;

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
     * Obtém o valor da propriedade u.
     * 
     */
    public long getU() {
        return u;
    }

    /**
     * Define o valor da propriedade u.
     * 
     */
    public void setU(long value) {
        this.u = value;
    }

    /**
     * Obtém o valor da propriedade n.
     * 
     */
    public long getN() {
        return n;
    }

    /**
     * Define o valor da propriedade n.
     * 
     */
    public void setN(long value) {
        this.n = value;
    }

}
