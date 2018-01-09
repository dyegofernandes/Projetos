
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de backupQueryInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="backupQueryInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currentAccounts" type="{urn:zimbraAdmin}currentAccounts" minOccurs="0"/>
 *         &lt;element name="accounts" type="{urn:zimbraAdmin}backupQueryAccounts" minOccurs="0"/>
 *         &lt;element name="error" type="{urn:zimbraAdmin}backupQueryError" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="stats" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="counter" type="{urn:zimbraAdmin}backupQueryCounter" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="aborted" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="start" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="end" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="minRedoSeq" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="maxRedoSeq" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="live" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backupQueryInfo", propOrder = {
    "currentAccounts",
    "accounts",
    "error",
    "stats"
})
public class BackupQueryInfo {

    protected CurrentAccounts currentAccounts;
    protected BackupQueryAccounts accounts;
    protected List<BackupQueryError> error;
    protected BackupQueryInfo.Stats stats;
    @XmlAttribute(name = "label")
    protected String label;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "aborted")
    protected Boolean aborted;
    @XmlAttribute(name = "start")
    protected Long start;
    @XmlAttribute(name = "end")
    protected Long end;
    @XmlAttribute(name = "minRedoSeq")
    protected Long minRedoSeq;
    @XmlAttribute(name = "maxRedoSeq")
    protected Long maxRedoSeq;
    @XmlAttribute(name = "live")
    protected Boolean live;

    /**
     * Obtém o valor da propriedade currentAccounts.
     * 
     * @return
     *     possible object is
     *     {@link CurrentAccounts }
     *     
     */
    public CurrentAccounts getCurrentAccounts() {
        return currentAccounts;
    }

    /**
     * Define o valor da propriedade currentAccounts.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentAccounts }
     *     
     */
    public void setCurrentAccounts(CurrentAccounts value) {
        this.currentAccounts = value;
    }

    /**
     * Obtém o valor da propriedade accounts.
     * 
     * @return
     *     possible object is
     *     {@link BackupQueryAccounts }
     *     
     */
    public BackupQueryAccounts getAccounts() {
        return accounts;
    }

    /**
     * Define o valor da propriedade accounts.
     * 
     * @param value
     *     allowed object is
     *     {@link BackupQueryAccounts }
     *     
     */
    public void setAccounts(BackupQueryAccounts value) {
        this.accounts = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the error property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getError().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BackupQueryError }
     * 
     * 
     */
    public List<BackupQueryError> getError() {
        if (error == null) {
            error = new ArrayList<BackupQueryError>();
        }
        return this.error;
    }

    /**
     * Obtém o valor da propriedade stats.
     * 
     * @return
     *     possible object is
     *     {@link BackupQueryInfo.Stats }
     *     
     */
    public BackupQueryInfo.Stats getStats() {
        return stats;
    }

    /**
     * Define o valor da propriedade stats.
     * 
     * @param value
     *     allowed object is
     *     {@link BackupQueryInfo.Stats }
     *     
     */
    public void setStats(BackupQueryInfo.Stats value) {
        this.stats = value;
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
     * Obtém o valor da propriedade aborted.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAborted() {
        return aborted;
    }

    /**
     * Define o valor da propriedade aborted.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAborted(Boolean value) {
        this.aborted = value;
    }

    /**
     * Obtém o valor da propriedade start.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStart() {
        return start;
    }

    /**
     * Define o valor da propriedade start.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStart(Long value) {
        this.start = value;
    }

    /**
     * Obtém o valor da propriedade end.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEnd() {
        return end;
    }

    /**
     * Define o valor da propriedade end.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEnd(Long value) {
        this.end = value;
    }

    /**
     * Obtém o valor da propriedade minRedoSeq.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMinRedoSeq() {
        return minRedoSeq;
    }

    /**
     * Define o valor da propriedade minRedoSeq.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMinRedoSeq(Long value) {
        this.minRedoSeq = value;
    }

    /**
     * Obtém o valor da propriedade maxRedoSeq.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxRedoSeq() {
        return maxRedoSeq;
    }

    /**
     * Define o valor da propriedade maxRedoSeq.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxRedoSeq(Long value) {
        this.maxRedoSeq = value;
    }

    /**
     * Obtém o valor da propriedade live.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLive() {
        return live;
    }

    /**
     * Define o valor da propriedade live.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLive(Boolean value) {
        this.live = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="counter" type="{urn:zimbraAdmin}backupQueryCounter" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "counter"
    })
    public static class Stats {

        protected List<BackupQueryCounter> counter;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the counter property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the counter property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCounter().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BackupQueryCounter }
         * 
         * 
         */
        public List<BackupQueryCounter> getCounter() {
            if (counter == null) {
                counter = new ArrayList<BackupQueryCounter>();
            }
            return this.counter;
        }

        /**
         * Obtém o valor da propriedade unusedCodeGenHelper.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnusedCodeGenHelper() {
            return unusedCodeGenHelper;
        }

        /**
         * Define o valor da propriedade unusedCodeGenHelper.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnusedCodeGenHelper(String value) {
            this.unusedCodeGenHelper = value;
        }

    }

}
