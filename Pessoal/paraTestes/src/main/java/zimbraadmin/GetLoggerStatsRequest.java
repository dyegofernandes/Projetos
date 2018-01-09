
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getLoggerStatsRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getLoggerStatsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hostname" type="{urn:zimbraAdmin}hostName" minOccurs="0"/>
 *         &lt;element name="stats" type="{urn:zimbraAdmin}statsSpec" minOccurs="0"/>
 *         &lt;element name="startTime" type="{urn:zimbraAdmin}timeAttr" minOccurs="0"/>
 *         &lt;element name="endTime" type="{urn:zimbraAdmin}timeAttr" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLoggerStatsRequest", propOrder = {
    "hostname",
    "stats",
    "startTime",
    "endTime"
})
public class GetLoggerStatsRequest {

    protected HostName hostname;
    protected StatsSpec stats;
    protected TimeAttr startTime;
    protected TimeAttr endTime;

    /**
     * Obtém o valor da propriedade hostname.
     * 
     * @return
     *     possible object is
     *     {@link HostName }
     *     
     */
    public HostName getHostname() {
        return hostname;
    }

    /**
     * Define o valor da propriedade hostname.
     * 
     * @param value
     *     allowed object is
     *     {@link HostName }
     *     
     */
    public void setHostname(HostName value) {
        this.hostname = value;
    }

    /**
     * Obtém o valor da propriedade stats.
     * 
     * @return
     *     possible object is
     *     {@link StatsSpec }
     *     
     */
    public StatsSpec getStats() {
        return stats;
    }

    /**
     * Define o valor da propriedade stats.
     * 
     * @param value
     *     allowed object is
     *     {@link StatsSpec }
     *     
     */
    public void setStats(StatsSpec value) {
        this.stats = value;
    }

    /**
     * Obtém o valor da propriedade startTime.
     * 
     * @return
     *     possible object is
     *     {@link TimeAttr }
     *     
     */
    public TimeAttr getStartTime() {
        return startTime;
    }

    /**
     * Define o valor da propriedade startTime.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeAttr }
     *     
     */
    public void setStartTime(TimeAttr value) {
        this.startTime = value;
    }

    /**
     * Obtém o valor da propriedade endTime.
     * 
     * @return
     *     possible object is
     *     {@link TimeAttr }
     *     
     */
    public TimeAttr getEndTime() {
        return endTime;
    }

    /**
     * Define o valor da propriedade endTime.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeAttr }
     *     
     */
    public void setEndTime(TimeAttr value) {
        this.endTime = value;
    }

}
