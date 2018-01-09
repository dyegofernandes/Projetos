
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de currentTimeTest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="currentTimeTest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}filterTest">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="dateComparison" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "currentTimeTest")
public class CurrentTimeTest
    extends FilterTest
{

    @XmlAttribute(name = "dateComparison")
    protected String dateComparison;
    @XmlAttribute(name = "time")
    protected String time;

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
     * Obtém o valor da propriedade time.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * Define o valor da propriedade time.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

}
