
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getHsmStatusResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getHsmStatusResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="running" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="endDate" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="wasAborted" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="aborting" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="error" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="numBlobsMoved" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="numBytesMoved" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="numMailboxes" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="totalMailboxes" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="destVolumeId" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="query" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getHsmStatusResponse")
public class GetHsmStatusResponse {

    @XmlAttribute(name = "running", required = true)
    protected boolean running;
    @XmlAttribute(name = "startDate")
    protected Long startDate;
    @XmlAttribute(name = "endDate")
    protected Long endDate;
    @XmlAttribute(name = "wasAborted")
    protected Boolean wasAborted;
    @XmlAttribute(name = "aborting")
    protected Boolean aborting;
    @XmlAttribute(name = "error")
    protected String error;
    @XmlAttribute(name = "numBlobsMoved")
    protected Integer numBlobsMoved;
    @XmlAttribute(name = "numBytesMoved")
    protected Long numBytesMoved;
    @XmlAttribute(name = "numMailboxes")
    protected Integer numMailboxes;
    @XmlAttribute(name = "totalMailboxes")
    protected Integer totalMailboxes;
    @XmlAttribute(name = "destVolumeId")
    protected Short destVolumeId;
    @XmlAttribute(name = "query")
    protected String query;

    /**
     * Obtém o valor da propriedade running.
     * 
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Define o valor da propriedade running.
     * 
     */
    public void setRunning(boolean value) {
        this.running = value;
    }

    /**
     * Obtém o valor da propriedade startDate.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStartDate() {
        return startDate;
    }

    /**
     * Define o valor da propriedade startDate.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStartDate(Long value) {
        this.startDate = value;
    }

    /**
     * Obtém o valor da propriedade endDate.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEndDate() {
        return endDate;
    }

    /**
     * Define o valor da propriedade endDate.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEndDate(Long value) {
        this.endDate = value;
    }

    /**
     * Obtém o valor da propriedade wasAborted.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWasAborted() {
        return wasAborted;
    }

    /**
     * Define o valor da propriedade wasAborted.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWasAborted(Boolean value) {
        this.wasAborted = value;
    }

    /**
     * Obtém o valor da propriedade aborting.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAborting() {
        return aborting;
    }

    /**
     * Define o valor da propriedade aborting.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAborting(Boolean value) {
        this.aborting = value;
    }

    /**
     * Obtém o valor da propriedade error.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getError() {
        return error;
    }

    /**
     * Define o valor da propriedade error.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setError(String value) {
        this.error = value;
    }

    /**
     * Obtém o valor da propriedade numBlobsMoved.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumBlobsMoved() {
        return numBlobsMoved;
    }

    /**
     * Define o valor da propriedade numBlobsMoved.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumBlobsMoved(Integer value) {
        this.numBlobsMoved = value;
    }

    /**
     * Obtém o valor da propriedade numBytesMoved.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumBytesMoved() {
        return numBytesMoved;
    }

    /**
     * Define o valor da propriedade numBytesMoved.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumBytesMoved(Long value) {
        this.numBytesMoved = value;
    }

    /**
     * Obtém o valor da propriedade numMailboxes.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumMailboxes() {
        return numMailboxes;
    }

    /**
     * Define o valor da propriedade numMailboxes.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumMailboxes(Integer value) {
        this.numMailboxes = value;
    }

    /**
     * Obtém o valor da propriedade totalMailboxes.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalMailboxes() {
        return totalMailboxes;
    }

    /**
     * Define o valor da propriedade totalMailboxes.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalMailboxes(Integer value) {
        this.totalMailboxes = value;
    }

    /**
     * Obtém o valor da propriedade destVolumeId.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getDestVolumeId() {
        return destVolumeId;
    }

    /**
     * Define o valor da propriedade destVolumeId.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setDestVolumeId(Short value) {
        this.destVolumeId = value;
    }

    /**
     * Obtém o valor da propriedade query.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuery() {
        return query;
    }

    /**
     * Define o valor da propriedade query.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuery(String value) {
        this.query = value;
    }

}
