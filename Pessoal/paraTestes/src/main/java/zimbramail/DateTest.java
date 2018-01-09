
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de dateTest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dateTest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}filterTest">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="dateComparison" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="d" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dateTest")
public class DateTest
    extends FilterTest
{

    @XmlAttribute(name = "dateComparison")
    protected String dateComparison;
    @XmlAttribute(name = "d")
    protected Long d;

    /**
     * Obtém o valor da propriedade dateComparison.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateComparison() {
        return dateComparison;
    }

    /**
     * Define o valor da propriedade dateComparison.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateComparison(String value) {
        this.dateComparison = value;
    }

    /**
     * Obtém o valor da propriedade d.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getD() {
        return d;
    }

    /**
     * Define o valor da propriedade d.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setD(Long value) {
        this.d = value;
    }

}
