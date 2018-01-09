
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.GalSearchType;


/**
 * <p>Classe Java de autoCompleteRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="autoCompleteRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="t" type="{urn:zimbra}galSearchType" />
 *       &lt;attribute name="needExp" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="folders" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="includeGal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autoCompleteRequest")
public class AutoCompleteRequest {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "t")
    protected GalSearchType t;
    @XmlAttribute(name = "needExp")
    protected Boolean needExp;
    @XmlAttribute(name = "folders")
    protected String folders;
    @XmlAttribute(name = "includeGal")
    protected Boolean includeGal;

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade t.
     * 
     * @return
     *     possible object is
     *     {@link GalSearchType }
     *     
     */
    public GalSearchType getT() {
        return t;
    }

    /**
     * Define o valor da propriedade t.
     * 
     * @param value
     *     allowed object is
     *     {@link GalSearchType }
     *     
     */
    public void setT(GalSearchType value) {
        this.t = value;
    }

    /**
     * Obtém o valor da propriedade needExp.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedExp() {
        return needExp;
    }

    /**
     * Define o valor da propriedade needExp.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedExp(Boolean value) {
        this.needExp = value;
    }

    /**
     * Obtém o valor da propriedade folders.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolders() {
        return folders;
    }

    /**
     * Define o valor da propriedade folders.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolders(String value) {
        this.folders = value;
    }

    /**
     * Obtém o valor da propriedade includeGal.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeGal() {
        return includeGal;
    }

    /**
     * Define o valor da propriedade includeGal.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeGal(Boolean value) {
        this.includeGal = value;
    }

}
