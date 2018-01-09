
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de backupQuerySpec complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="backupQuerySpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="target" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="from" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="to" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="stats" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="backupListOffset" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="backupListCount" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="accountListStatus" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="accountListOffset" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="accountListCount" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backupQuerySpec")
public class BackupQuerySpec {

    @XmlAttribute(name = "target")
    protected String target;
    @XmlAttribute(name = "label")
    protected String label;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "from")
    protected Long from;
    @XmlAttribute(name = "to")
    protected Long to;
    @XmlAttribute(name = "stats")
    protected Boolean stats;
    @XmlAttribute(name = "backupListOffset")
    protected Integer backupListOffset;
    @XmlAttribute(name = "backupListCount")
    protected Integer backupListCount;
    @XmlAttribute(name = "accountListStatus")
    protected String accountListStatus;
    @XmlAttribute(name = "accountListOffset")
    protected Integer accountListOffset;
    @XmlAttribute(name = "accountListCount")
    protected Integer accountListCount;

    /**
     * Obtém o valor da propriedade target.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarget() {
        return target;
    }

    /**
     * Define o valor da propriedade target.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarget(String value) {
        this.target = value;
    }

    /**
     * Obtém o valor da propriedade label.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Define o valor da propriedade label.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade from.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFrom() {
        return from;
    }

    /**
     * Define o valor da propriedade from.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFrom(Long value) {
        this.from = value;
    }

    /**
     * Obtém o valor da propriedade to.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTo() {
        return to;
    }

    /**
     * Define o valor da propriedade to.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTo(Long value) {
        this.to = value;
    }

    /**
     * Obtém o valor da propriedade stats.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStats() {
        return stats;
    }

    /**
     * Define o valor da propriedade stats.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStats(Boolean value) {
        this.stats = value;
    }

    /**
     * Obtém o valor da propriedade backupListOffset.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBackupListOffset() {
        return backupListOffset;
    }

    /**
     * Define o valor da propriedade backupListOffset.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBackupListOffset(Integer value) {
        this.backupListOffset = value;
    }

    /**
     * Obtém o valor da propriedade backupListCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBackupListCount() {
        return backupListCount;
    }

    /**
     * Define o valor da propriedade backupListCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBackupListCount(Integer value) {
        this.backupListCount = value;
    }

    /**
     * Obtém o valor da propriedade accountListStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountListStatus() {
        return accountListStatus;
    }

    /**
     * Define o valor da propriedade accountListStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountListStatus(String value) {
        this.accountListStatus = value;
    }

    /**
     * Obtém o valor da propriedade accountListOffset.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAccountListOffset() {
        return accountListOffset;
    }

    /**
     * Define o valor da propriedade accountListOffset.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAccountListOffset(Integer value) {
        this.accountListOffset = value;
    }

    /**
     * Obtém o valor da propriedade accountListCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAccountListCount() {
        return accountListCount;
    }

    /**
     * Define o valor da propriedade accountListCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAccountListCount(Integer value) {
        this.accountListCount = value;
    }

}
