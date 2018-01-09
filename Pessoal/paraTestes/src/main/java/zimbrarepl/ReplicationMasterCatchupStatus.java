
package zimbrarepl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de replicationMasterCatchupStatus complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="replicationMasterCatchupStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="remainingFiles" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="remainingBytes" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "replicationMasterCatchupStatus")
public class ReplicationMasterCatchupStatus {

    @XmlAttribute(name = "remainingFiles", required = true)
    protected int remainingFiles;
    @XmlAttribute(name = "remainingBytes", required = true)
    protected long remainingBytes;

    /**
     * Obtém o valor da propriedade remainingFiles.
     * 
     */
    public int getRemainingFiles() {
        return remainingFiles;
    }

    /**
     * Define o valor da propriedade remainingFiles.
     * 
     */
    public void setRemainingFiles(int value) {
        this.remainingFiles = value;
    }

    /**
     * Obtém o valor da propriedade remainingBytes.
     * 
     */
    public long getRemainingBytes() {
        return remainingBytes;
    }

    /**
     * Define o valor da propriedade remainingBytes.
     * 
     */
    public void setRemainingBytes(long value) {
        this.remainingBytes = value;
    }

}
