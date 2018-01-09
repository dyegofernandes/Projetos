
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de documentInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="documentInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}commonDocumentInfo">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="loid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="loe" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="lt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentInfo")
@XmlSeeAlso({
    DocumentHitInfo.class
})
public class DocumentInfo
    extends CommonDocumentInfo
{

    @XmlAttribute(name = "loid")
    protected String loid;
    @XmlAttribute(name = "loe")
    protected String loe;
    @XmlAttribute(name = "lt")
    protected String lt;

    /**
     * Obtém o valor da propriedade loid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoid() {
        return loid;
    }

    /**
     * Define o valor da propriedade loid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoid(String value) {
        this.loid = value;
    }

    /**
     * Obtém o valor da propriedade loe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoe() {
        return loe;
    }

    /**
     * Define o valor da propriedade loe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoe(String value) {
        this.loe = value;
    }

    /**
     * Obtém o valor da propriedade lt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLt() {
        return lt;
    }

    /**
     * Define o valor da propriedade lt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLt(String value) {
        this.lt = value;
    }

}
