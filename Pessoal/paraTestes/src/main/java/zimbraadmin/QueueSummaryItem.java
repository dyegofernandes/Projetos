
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de queueSummaryItem complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="queueSummaryItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="n" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="t" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queueSummaryItem")
public class QueueSummaryItem {

    @XmlAttribute(name = "n", required = true)
    protected int n;
    @XmlAttribute(name = "t", required = true)
    protected String t;

    /**
     * Obtém o valor da propriedade n.
     * 
     */
    public int getN() {
        return n;
    }

    /**
     * Define o valor da propriedade n.
     * 
     */
    public void setN(int value) {
        this.n = value;
    }

    /**
     * Obtém o valor da propriedade t.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getT() {
        return t;
    }

    /**
     * Define o valor da propriedade t.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setT(String value) {
        this.t = value;
    }

}
