
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de moveMailboxInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="moveMailboxInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dest" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="src" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="blobs" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="secondaryBlobs" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="searchIndex" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="maxSyncs" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="syncFinishThreshold" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="sync" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="skipRemoteLockout" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="skipMemcachePurge" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moveMailboxInfo")
public class MoveMailboxInfo {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "dest", required = true)
    protected String dest;
    @XmlAttribute(name = "src", required = true)
    protected String src;
    @XmlAttribute(name = "blobs")
    protected String blobs;
    @XmlAttribute(name = "secondaryBlobs")
    protected String secondaryBlobs;
    @XmlAttribute(name = "searchIndex")
    protected String searchIndex;
    @XmlAttribute(name = "maxSyncs")
    protected Integer maxSyncs;
    @XmlAttribute(name = "syncFinishThreshold")
    protected Long syncFinishThreshold;
    @XmlAttribute(name = "sync")
    protected Boolean sync;
    @XmlAttribute(name = "skipRemoteLockout")
    protected Boolean skipRemoteLockout;
    @XmlAttribute(name = "skipMemcachePurge")
    protected Boolean skipMemcachePurge;

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade dest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDest() {
        return dest;
    }

    /**
     * Define o valor da propriedade dest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDest(String value) {
        this.dest = value;
    }

    /**
     * Obtém o valor da propriedade src.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrc() {
        return src;
    }

    /**
     * Define o valor da propriedade src.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrc(String value) {
        this.src = value;
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
     * Obtém o valor da propriedade maxSyncs.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxSyncs() {
        return maxSyncs;
    }

    /**
     * Define o valor da propriedade maxSyncs.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxSyncs(Integer value) {
        this.maxSyncs = value;
    }

    /**
     * Obtém o valor da propriedade syncFinishThreshold.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSyncFinishThreshold() {
        return syncFinishThreshold;
    }

    /**
     * Define o valor da propriedade syncFinishThreshold.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSyncFinishThreshold(Long value) {
        this.syncFinishThreshold = value;
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
     * Obtém o valor da propriedade skipRemoteLockout.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkipRemoteLockout() {
        return skipRemoteLockout;
    }

    /**
     * Define o valor da propriedade skipRemoteLockout.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkipRemoteLockout(Boolean value) {
        this.skipRemoteLockout = value;
    }

    /**
     * Obtém o valor da propriedade skipMemcachePurge.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkipMemcachePurge() {
        return skipMemcachePurge;
    }

    /**
     * Define o valor da propriedade skipMemcachePurge.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkipMemcachePurge(Boolean value) {
        this.skipMemcachePurge = value;
    }

}
