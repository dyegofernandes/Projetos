
package zimbrarepl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de replicationSlaveStatus complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="replicationSlaveStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="catchupStatus" type="{urn:zimbraRepl}replicationSlaveCatchupStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "replicationSlaveStatus", propOrder = {
    "catchupStatus"
})
public class ReplicationSlaveStatus {

    protected ReplicationSlaveCatchupStatus catchupStatus;

    /**
     * Obtém o valor da propriedade catchupStatus.
     * 
     * @return
     *     possible object is
     *     {@link ReplicationSlaveCatchupStatus }
     *     
     */
    public ReplicationSlaveCatchupStatus getCatchupStatus() {
        return catchupStatus;
    }

    /**
     * Define o valor da propriedade catchupStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplicationSlaveCatchupStatus }
     *     
     */
    public void setCatchupStatus(ReplicationSlaveCatchupStatus value) {
        this.catchupStatus = value;
    }

}
