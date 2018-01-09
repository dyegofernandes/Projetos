
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de diffDocumentVersionSpec complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="diffDocumentVersionSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="v1" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="v2" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diffDocumentVersionSpec")
public class DiffDocumentVersionSpec {

    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "v1")
    protected Integer v1;
    @XmlAttribute(name = "v2")
    protected Integer v2;

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
     * Obtém o valor da propriedade v1.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getV1() {
        return v1;
    }

    /**
     * Define o valor da propriedade v1.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setV1(Integer value) {
        this.v1 = value;
    }

    /**
     * Obtém o valor da propriedade v2.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getV2() {
        return v2;
    }

    /**
     * Define o valor da propriedade v2.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setV2(Integer value) {
        this.v2 = value;
    }

}
