
package zimbra;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de wildcardExpansionQueryInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="wildcardExpansionQueryInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="str" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="expanded" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="numExpanded" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wildcardExpansionQueryInfo")
public class WildcardExpansionQueryInfo {

    @XmlAttribute(name = "str", required = true)
    protected String str;
    @XmlAttribute(name = "expanded", required = true)
    protected boolean expanded;
    @XmlAttribute(name = "numExpanded", required = true)
    protected int numExpanded;

    /**
     * Obtém o valor da propriedade str.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStr() {
        return str;
    }

    /**
     * Define o valor da propriedade str.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStr(String value) {
        this.str = value;
    }

    /**
     * Obtém o valor da propriedade expanded.
     * 
     */
    public boolean isExpanded() {
        return expanded;
    }

    /**
     * Define o valor da propriedade expanded.
     * 
     */
    public void setExpanded(boolean value) {
        this.expanded = value;
    }

    /**
     * Obtém o valor da propriedade numExpanded.
     * 
     */
    public int getNumExpanded() {
        return numExpanded;
    }

    /**
     * Define o valor da propriedade numExpanded.
     * 
     */
    public void setNumExpanded(int value) {
        this.numExpanded = value;
    }

}
