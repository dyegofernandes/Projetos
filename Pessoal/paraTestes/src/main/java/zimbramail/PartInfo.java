
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de partInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="partInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mp" type="{urn:zimbraMail}partInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="part" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ct" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="cd" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="filename" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ci" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cl" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="body" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="truncated" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "partInfo", propOrder = {
    "content",
    "mp"
})
public class PartInfo {

    protected String content;
    protected List<PartInfo> mp;
    @XmlAttribute(name = "part", required = true)
    protected String part;
    @XmlAttribute(name = "ct", required = true)
    protected String ct;
    @XmlAttribute(name = "s")
    protected Integer s;
    @XmlAttribute(name = "cd")
    protected String cd;
    @XmlAttribute(name = "filename")
    protected String filename;
    @XmlAttribute(name = "ci")
    protected String ci;
    @XmlAttribute(name = "cl")
    protected String cl;
    @XmlAttribute(name = "body")
    protected Boolean body;
    @XmlAttribute(name = "truncated")
    protected Boolean truncated;

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
     * Gets the value of the mp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartInfo }
     * 
     * 
     */
    public List<PartInfo> getMp() {
        if (mp == null) {
            mp = new ArrayList<PartInfo>();
        }
        return this.mp;
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

    /**
     * Obtém o valor da propriedade ct.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCt() {
        return ct;
    }

    /**
     * Define o valor da propriedade ct.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCt(String value) {
        this.ct = value;
    }

    /**
     * Obtém o valor da propriedade s.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getS() {
        return s;
    }

    /**
     * Define o valor da propriedade s.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setS(Integer value) {
        this.s = value;
    }

    /**
     * Obtém o valor da propriedade cd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCd() {
        return cd;
    }

    /**
     * Define o valor da propriedade cd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCd(String value) {
        this.cd = value;
    }

    /**
     * Obtém o valor da propriedade filename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Define o valor da propriedade filename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilename(String value) {
        this.filename = value;
    }

    /**
     * Obtém o valor da propriedade ci.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCi() {
        return ci;
    }

    /**
     * Define o valor da propriedade ci.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCi(String value) {
        this.ci = value;
    }

    /**
     * Obtém o valor da propriedade cl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCl() {
        return cl;
    }

    /**
     * Define o valor da propriedade cl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCl(String value) {
        this.cl = value;
    }

    /**
     * Obtém o valor da propriedade body.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBody() {
        return body;
    }

    /**
     * Define o valor da propriedade body.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBody(Boolean value) {
        this.body = value;
    }

    /**
     * Obtém o valor da propriedade truncated.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTruncated() {
        return truncated;
    }

    /**
     * Define o valor da propriedade truncated.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTruncated(Boolean value) {
        this.truncated = value;
    }

}
