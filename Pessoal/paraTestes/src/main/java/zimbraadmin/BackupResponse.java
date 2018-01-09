
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de backupResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="backupResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="backup" type="{urn:zimbraAdmin}backupInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backupResponse", propOrder = {
    "backup"
})
public class BackupResponse {

    @XmlElement(required = true)
    protected BackupInfo backup;

    /**
     * Obtém o valor da propriedade backup.
     * 
     * @return
     *     possible object is
     *     {@link BackupInfo }
     *     
     */
    public BackupInfo getBackup() {
        return backup;
    }

    /**
     * Define o valor da propriedade backup.
     * 
     * @param value
     *     allowed object is
     *     {@link BackupInfo }
     *     
     */
    public void setBackup(BackupInfo value) {
        this.backup = value;
    }

}
