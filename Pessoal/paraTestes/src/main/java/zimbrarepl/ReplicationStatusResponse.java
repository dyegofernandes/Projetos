
package zimbrarepl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de replicationStatusResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="replicationStatusResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="masterStatus" type="{urn:zimbraRepl}replicationMasterStatus" minOccurs="0"/>
 *         &lt;element name="slaveStatus" type="{urn:zimbraRepl}replicationSlaveStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="replicationEnabled" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="currentRole" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="originalRole" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "replicationStatusResponse", propOrder = {
    "masterStatus",
    "slaveStatus"
})
public class ReplicationStatusResponse {

    protected ReplicationMasterStatus masterStatus;
    protected ReplicationSlaveStatus slaveStatus;
    @XmlAttribute(name = "replicationEnabled", required = true)
    protected boolean replicationEnabled;
    @XmlAttribute(name = "currentRole")
    protected String currentRole;
    @XmlAttribute(name = "originalRole")
    protected String originalRole;

    /**
     * Obtém o valor da propriedade masterStatus.
     * 
     * @return
     *     possible object is
     *     {@link ReplicationMasterStatus }
     *     
     */
    public ReplicationMasterStatus getMasterStatus() {
        return masterStatus;
    }

    /**
     * Define o valor da propriedade masterStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplicationMasterStatus }
     *     
     */
    public void setMasterStatus(ReplicationMasterStatus value) {
        this.masterStatus = value;
    }

    /**
     * Obtém o valor da propriedade slaveStatus.
     * 
     * @return
     *     possible object is
     *     {@link ReplicationSlaveStatus }
     *     
     */
    public ReplicationSlaveStatus getSlaveStatus() {
        return slaveStatus;
    }

    /**
     * Define o valor da propriedade slaveStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplicationSlaveStatus }
     *     
     */
    public void setSlaveStatus(ReplicationSlaveStatus value) {
        this.slaveStatus = value;
    }

    /**
     * Obtém o valor da propriedade replicationEnabled.
     * 
     */
    public boolean isReplicationEnabled() {
        return replicationEnabled;
    }

    /**
     * Define o valor da propriedade replicationEnabled.
     * 
     */
    public void setReplicationEnabled(boolean value) {
        this.replicationEnabled = value;
    }

    /**
     * Obtém o valor da propriedade currentRole.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentRole() {
        return currentRole;
    }

    /**
     * Define o valor da propriedade currentRole.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentRole(String value) {
        this.currentRole = value;
    }

    /**
     * Obtém o valor da propriedade originalRole.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalRole() {
        return originalRole;
    }

    /**
     * Define o valor da propriedade originalRole.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalRole(String value) {
        this.originalRole = value;
    }

}
