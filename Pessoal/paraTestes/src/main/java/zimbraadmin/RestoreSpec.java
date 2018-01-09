
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de restoreSpec complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="restoreSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileCopier" type="{urn:zimbraAdmin}fileCopierSpec" minOccurs="0"/>
 *         &lt;element name="account" type="{urn:zimbraAdmin}name" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="method" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="searchIndex" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="blobs" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="secondaryBlobs" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="target" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sysData" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="includeIncrementals" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="replayRedo" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="continue" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="prefix" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="restoreToTime" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="restoreToRedoSeq" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="restoreToIncrLabel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ignoreRedoErrors" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="skipDeleteOps" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="skipDeletedAccounts" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "restoreSpec", propOrder = {
    "fileCopier",
    "account"
})
public class RestoreSpec {

    protected FileCopierSpec fileCopier;
    protected List<Name> account;
    @XmlAttribute(name = "method")
    protected String method;
    @XmlAttribute(name = "searchIndex")
    protected String searchIndex;
    @XmlAttribute(name = "blobs")
    protected String blobs;
    @XmlAttribute(name = "secondaryBlobs")
    protected String secondaryBlobs;
    @XmlAttribute(name = "target")
    protected String target;
    @XmlAttribute(name = "label")
    protected String label;
    @XmlAttribute(name = "sysData")
    protected Boolean sysData;
    @XmlAttribute(name = "includeIncrementals")
    protected Boolean includeIncrementals;
    @XmlAttribute(name = "replayRedo")
    protected Boolean replayRedo;
    @XmlAttribute(name = "continue")
    protected Boolean _continue;
    @XmlAttribute(name = "prefix")
    protected String prefix;
    @XmlAttribute(name = "restoreToTime")
    protected Long restoreToTime;
    @XmlAttribute(name = "restoreToRedoSeq")
    protected Long restoreToRedoSeq;
    @XmlAttribute(name = "restoreToIncrLabel")
    protected String restoreToIncrLabel;
    @XmlAttribute(name = "ignoreRedoErrors")
    protected Boolean ignoreRedoErrors;
    @XmlAttribute(name = "skipDeleteOps")
    protected Boolean skipDeleteOps;
    @XmlAttribute(name = "skipDeletedAccounts")
    protected Boolean skipDeletedAccounts;

    /**
     * Obtém o valor da propriedade fileCopier.
     * 
     * @return
     *     possible object is
     *     {@link FileCopierSpec }
     *     
     */
    public FileCopierSpec getFileCopier() {
        return fileCopier;
    }

    /**
     * Define o valor da propriedade fileCopier.
     * 
     * @param value
     *     allowed object is
     *     {@link FileCopierSpec }
     *     
     */
    public void setFileCopier(FileCopierSpec value) {
        this.fileCopier = value;
    }

    /**
     * Gets the value of the account property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the account property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Name }
     * 
     * 
     */
    public List<Name> getAccount() {
        if (account == null) {
            account = new ArrayList<Name>();
        }
        return this.account;
    }

    /**
     * Obtém o valor da propriedade method.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethod() {
        return method;
    }

    /**
     * Define o valor da propriedade method.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethod(String value) {
        this.method = value;
    }

    /**
     * Obtém o valor da propriedade searchIndex.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchIndex() {
        return searchIndex;
    }

    /**
     * Define o valor da propriedade searchIndex.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchIndex(String value) {
        this.searchIndex = value;
    }

    /**
     * Obtém o valor da propriedade blobs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlobs() {
        return blobs;
    }

    /**
     * Define o valor da propriedade blobs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlobs(String value) {
        this.blobs = value;
    }

    /**
     * Obtém o valor da propriedade secondaryBlobs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondaryBlobs() {
        return secondaryBlobs;
    }

    /**
     * Define o valor da propriedade secondaryBlobs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondaryBlobs(String value) {
        this.secondaryBlobs = value;
    }

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
     * Obtém o valor da propriedade sysData.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSysData() {
        return sysData;
    }

    /**
     * Define o valor da propriedade sysData.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSysData(Boolean value) {
        this.sysData = value;
    }

    /**
     * Obtém o valor da propriedade includeIncrementals.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeIncrementals() {
        return includeIncrementals;
    }

    /**
     * Define o valor da propriedade includeIncrementals.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeIncrementals(Boolean value) {
        this.includeIncrementals = value;
    }

    /**
     * Obtém o valor da propriedade replayRedo.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReplayRedo() {
        return replayRedo;
    }

    /**
     * Define o valor da propriedade replayRedo.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReplayRedo(Boolean value) {
        this.replayRedo = value;
    }

    /**
     * Obtém o valor da propriedade continue.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isContinue() {
        return _continue;
    }

    /**
     * Define o valor da propriedade continue.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContinue(Boolean value) {
        this._continue = value;
    }

    /**
     * Obtém o valor da propriedade prefix.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Define o valor da propriedade prefix.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefix(String value) {
        this.prefix = value;
    }

    /**
     * Obtém o valor da propriedade restoreToTime.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRestoreToTime() {
        return restoreToTime;
    }

    /**
     * Define o valor da propriedade restoreToTime.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRestoreToTime(Long value) {
        this.restoreToTime = value;
    }

    /**
     * Obtém o valor da propriedade restoreToRedoSeq.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRestoreToRedoSeq() {
        return restoreToRedoSeq;
    }

    /**
     * Define o valor da propriedade restoreToRedoSeq.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRestoreToRedoSeq(Long value) {
        this.restoreToRedoSeq = value;
    }

    /**
     * Obtém o valor da propriedade restoreToIncrLabel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestoreToIncrLabel() {
        return restoreToIncrLabel;
    }

    /**
     * Define o valor da propriedade restoreToIncrLabel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestoreToIncrLabel(String value) {
        this.restoreToIncrLabel = value;
    }

    /**
     * Obtém o valor da propriedade ignoreRedoErrors.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIgnoreRedoErrors() {
        return ignoreRedoErrors;
    }

    /**
     * Define o valor da propriedade ignoreRedoErrors.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIgnoreRedoErrors(Boolean value) {
        this.ignoreRedoErrors = value;
    }

    /**
     * Obtém o valor da propriedade skipDeleteOps.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkipDeleteOps() {
        return skipDeleteOps;
    }

    /**
     * Define o valor da propriedade skipDeleteOps.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkipDeleteOps(Boolean value) {
        this.skipDeleteOps = value;
    }

    /**
     * Obtém o valor da propriedade skipDeletedAccounts.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkipDeletedAccounts() {
        return skipDeletedAccounts;
    }

    /**
     * Define o valor da propriedade skipDeletedAccounts.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkipDeletedAccounts(Boolean value) {
        this.skipDeletedAccounts = value;
    }

}
