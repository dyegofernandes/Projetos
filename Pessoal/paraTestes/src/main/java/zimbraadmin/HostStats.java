
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de hostStats complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="hostStats">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stats" type="{urn:zimbraAdmin}statsInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="hn" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hostStats", propOrder = {
    "stats"
})
public class HostStats {

    protected StatsInfo stats;
    @XmlAttribute(name = "hn", required = true)
    protected String hn;

    /**
     * Obtém o valor da propriedade stats.
     * 
     * @return
     *     possible object is
     *     {@link StatsInfo }
     *     
     */
    public StatsInfo getStats() {
        return stats;
    }

    /**
     * Define o valor da propriedade stats.
     * 
     * @param value
     *     allowed object is
     *     {@link StatsInfo }
     *     
     */
    public void setStats(StatsInfo value) {
        this.stats = value;
    }

    /**
     * Obtém o valor da propriedade hn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHn() {
        return hn;
    }

    /**
     * Define o valor da propriedade hn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHn(String value) {
        this.hn = value;
    }

}
