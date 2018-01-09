
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de backupQueryCounter complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="backupQueryCounter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="unit" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sum" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="numSamples" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backupQueryCounter")
public class BackupQueryCounter {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "unit", required = true)
    protected String unit;
    @XmlAttribute(name = "sum", required = true)
    protected long sum;
    @XmlAttribute(name = "numSamples", required = true)
    protected long numSamples;

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
     * Obtém o valor da propriedade unit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Define o valor da propriedade unit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * Obtém o valor da propriedade sum.
     * 
     */
    public long getSum() {
        return sum;
    }

    /**
     * Define o valor da propriedade sum.
     * 
     */
    public void setSum(long value) {
        this.sum = value;
    }

    /**
     * Obtém o valor da propriedade numSamples.
     * 
     */
    public long getNumSamples() {
        return numSamples;
    }

    /**
     * Define o valor da propriedade numSamples.
     * 
     */
    public void setNumSamples(long value) {
        this.numSamples = value;
    }

}
