
package zimbrarepl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de replicationMasterStatus complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="replicationMasterStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="catchupStatus" type="{urn:zimbraRepl}replicationMasterCatchupStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="masterOperatingMode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "replicationMasterStatus", propOrder = {
    "catchupStatus"
})
public class ReplicationMasterStatus {

    protected ReplicationMasterCatchupStatus catchupStatus;
    @XmlAttribute(name = "masterOperatingMode", required = true)
    protected String masterOperatingMode;

    /**
     * Obtém o valor da propriedade catchupStatus.
     * 
     * @return
     *     possible object is
     *     {@link ReplicationMasterCatchupStatus }
     *     
     */
    public ReplicationMasterCatchupStatus getCatchupStatus() {
        return catchupStatus;
    }

    /**
     * Define o valor da propriedade catchupStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplicationMasterCatchupStatus }
     *     
     */
    public void setCatchupStatus(ReplicationMasterCatchupStatus value) {
        this.catchupStatus = value;
    }

    /**
     * Obtém o valor da propriedade masterOperatingMode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterOperatingMode() {
        return masterOperatingMode;
    }

    /**
     * Define o valor da propriedade masterOperatingMode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterOperatingMode(String value) {
        this.masterOperatingMode = value;
    }

}
