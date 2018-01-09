
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de backupSpec complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="backupSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileCopier" type="{urn:zimbraAdmin}fileCopierSpec" minOccurs="0"/>
 *         &lt;element name="account" type="{urn:zimbraAdmin}name" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="method" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="target" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="before" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sync" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="searchIndex" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="blobs" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="secondaryBlobs" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="zip" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="zipStore" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backupSpec", propOrder = {
    "fileCopier",
    "account"
})
public class BackupSpec {

    protected FileCopierSpec fileCopier;
    protected List<Name> account;
    @XmlAttribute(name = "method")
    protected String method;
    @XmlAttribute(name = "target")
    protected String target;
    @XmlAttribute(name = "label")
    protected String label;
    @XmlAttribute(name = "before")
    protected String before;
    @XmlAttribute(name = "sync")
    protected Boolean sync;
    @XmlAttribute(name = "searchIndex")
    protected String searchIndex;
    @XmlAttribute(name = "blobs")
    protected String blobs;
    @XmlAttribute(name = "secondaryBlobs")
    protected String secondaryBlobs;
    @XmlAttribute(name = "zip")
    protected Boolean zip;
    @XmlAttribute(name = "zipStore")
    protected Boolean zipStore;

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
     * Obtém o valor da propriedade before.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBefore() {
        return before;
    }

    /**
     * Define o valor da propriedade before.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBefore(String value) {
        this.before = value;
    }

    /**
     * Obtém o valor da propriedade sync.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSync() {
        return sync;
    }

    /**
     * Define o valor da propriedade sync.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSync(Boolean value) {
        this.sync = value;
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
     * Obtém o valor da propriedade zip.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isZip() {
        return zip;
    }

    /**
     * Define o valor da propriedade zip.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setZip(Boolean value) {
        this.zip = value;
    }

    /**
     * Obtém o valor da propriedade zipStore.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isZipStore() {
        return zipStore;
    }

    /**
     * Define o valor da propriedade zipStore.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setZipStore(Boolean value) {
        this.zipStore = value;
    }

}
