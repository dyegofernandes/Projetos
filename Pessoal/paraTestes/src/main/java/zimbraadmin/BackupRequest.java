
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de backupRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="backupRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="backup" type="{urn:zimbraAdmin}backupSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backupRequest", propOrder = {
    "backup"
})
public class BackupRequest {

    @XmlElement(required = true)
    protected BackupSpec backup;

    /**
     * Obtém o valor da propriedade backup.
     * 
     * @return
     *     possible object is
     *     {@link BackupSpec }
     *     
     */
    public BackupSpec getBackup() {
        return backup;
    }

    /**
     * Define o valor da propriedade backup.
     * 
     * @param value
     *     allowed object is
     *     {@link BackupSpec }
     *     
     */
    public void setBackup(BackupSpec value) {
        this.backup = value;
    }

}
