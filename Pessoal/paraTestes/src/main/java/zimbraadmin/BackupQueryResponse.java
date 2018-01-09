
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de backupQueryResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="backupQueryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="backup" type="{urn:zimbraAdmin}backupQueryInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="totalSpace" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="freeSpace" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="more" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backupQueryResponse", propOrder = {
    "backup"
})
public class BackupQueryResponse {

    protected List<BackupQueryInfo> backup;
    @XmlAttribute(name = "totalSpace", required = true)
    protected long totalSpace;
    @XmlAttribute(name = "freeSpace", required = true)
    protected long freeSpace;
    @XmlAttribute(name = "more")
    protected Boolean more;

    /**
     * Gets the value of the backup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the backup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBackup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BackupQueryInfo }
     * 
     * 
     */
    public List<BackupQueryInfo> getBackup() {
        if (backup == null) {
            backup = new ArrayList<BackupQueryInfo>();
        }
        return this.backup;
    }

    /**
     * Obtém o valor da propriedade totalSpace.
     * 
     */
    public long getTotalSpace() {
        return totalSpace;
    }

    /**
     * Define o valor da propriedade totalSpace.
     * 
     */
    public void setTotalSpace(long value) {
        this.totalSpace = value;
    }

    /**
     * Obtém o valor da propriedade freeSpace.
     * 
     */
    public long getFreeSpace() {
        return freeSpace;
    }

    /**
     * Define o valor da propriedade freeSpace.
     * 
     */
    public void setFreeSpace(long value) {
        this.freeSpace = value;
    }

    /**
     * Obtém o valor da propriedade more.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMore() {
        return more;
    }

    /**
     * Define o valor da propriedade more.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMore(Boolean value) {
        this.more = value;
    }

}
