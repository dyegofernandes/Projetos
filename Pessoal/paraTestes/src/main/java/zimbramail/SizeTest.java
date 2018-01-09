
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de sizeTest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="sizeTest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}filterTest">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="numberComparison" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sizeTest")
public class SizeTest
    extends FilterTest
{

    @XmlAttribute(name = "numberComparison")
    protected String numberComparison;
    @XmlAttribute(name = "s")
    protected String s;

    /**
     * Obtém o valor da propriedade numberComparison.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberComparison() {
        return numberComparison;
    }

    /**
     * Define o valor da propriedade numberComparison.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberComparison(String value) {
        this.numberComparison = value;
    }

    /**
     * Obtém o valor da propriedade s.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getS() {
        return s;
    }

    /**
     * Define o valor da propriedade s.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setS(String value) {
        this.s = value;
    }

}
