
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de purgeRevisionSpec complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="purgeRevisionSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ver" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="includeOlderRevisions" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "purgeRevisionSpec")
public class PurgeRevisionSpec {

    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "ver", required = true)
    protected int ver;
    @XmlAttribute(name = "includeOlderRevisions")
    protected Boolean includeOlderRevisions;

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
     * Obtém o valor da propriedade ver.
     * 
     */
    public int getVer() {
        return ver;
    }

    /**
     * Define o valor da propriedade ver.
     * 
     */
    public void setVer(int value) {
        this.ver = value;
    }

    /**
     * Obtém o valor da propriedade includeOlderRevisions.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeOlderRevisions() {
        return includeOlderRevisions;
    }

    /**
     * Define o valor da propriedade includeOlderRevisions.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeOlderRevisions(Boolean value) {
        this.includeOlderRevisions = value;
    }

}
