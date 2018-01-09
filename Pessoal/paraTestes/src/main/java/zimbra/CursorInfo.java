
package zimbra;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cursorInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cursorInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sortVal" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="endSortVal" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="includeOffset" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cursorInfo")
public class CursorInfo {

    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "sortVal")
    protected String sortVal;
    @XmlAttribute(name = "endSortVal")
    protected String endSortVal;
    @XmlAttribute(name = "includeOffset")
    protected Boolean includeOffset;

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
     * Obtém o valor da propriedade sortVal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortVal() {
        return sortVal;
    }

    /**
     * Define o valor da propriedade sortVal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortVal(String value) {
        this.sortVal = value;
    }

    /**
     * Obtém o valor da propriedade endSortVal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndSortVal() {
        return endSortVal;
    }

    /**
     * Define o valor da propriedade endSortVal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndSortVal(String value) {
        this.endSortVal = value;
    }

    /**
     * Obtém o valor da propriedade includeOffset.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeOffset() {
        return includeOffset;
    }

    /**
     * Define o valor da propriedade includeOffset.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeOffset(Boolean value) {
        this.includeOffset = value;
    }

}
