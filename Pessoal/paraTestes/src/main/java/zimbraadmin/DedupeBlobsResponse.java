
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de dedupeBlobsResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dedupeBlobsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="volumeBlobsProgress" type="{urn:zimbraAdmin}volumeIdAndProgress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="blobDigestsProgress" type="{urn:zimbraAdmin}volumeIdAndProgress" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="status" type="{urn:zimbraAdmin}dedupStatus" />
 *       &lt;attribute name="totalSize" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="totalCount" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dedupeBlobsResponse", propOrder = {
    "volumeBlobsProgress",
    "blobDigestsProgress"
})
public class DedupeBlobsResponse {

    protected List<VolumeIdAndProgress> volumeBlobsProgress;
    protected List<VolumeIdAndProgress> blobDigestsProgress;
    @XmlAttribute(name = "status")
    protected DedupStatus status;
    @XmlAttribute(name = "totalSize")
    protected Long totalSize;
    @XmlAttribute(name = "totalCount")
    protected Integer totalCount;

    /**
     * Gets the value of the volumeBlobsProgress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the volumeBlobsProgress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVolumeBlobsProgress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VolumeIdAndProgress }
     * 
     * 
     */
    public List<VolumeIdAndProgress> getVolumeBlobsProgress() {
        if (volumeBlobsProgress == null) {
            volumeBlobsProgress = new ArrayList<VolumeIdAndProgress>();
        }
        return this.volumeBlobsProgress;
    }

    /**
     * Gets the value of the blobDigestsProgress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the blobDigestsProgress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlobDigestsProgress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VolumeIdAndProgress }
     * 
     * 
     */
    public List<VolumeIdAndProgress> getBlobDigestsProgress() {
        if (blobDigestsProgress == null) {
            blobDigestsProgress = new ArrayList<VolumeIdAndProgress>();
        }
        return this.blobDigestsProgress;
    }

    /**
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link DedupStatus }
     *     
     */
    public DedupStatus getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link DedupStatus }
     *     
     */
    public void setStatus(DedupStatus value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade totalSize.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalSize() {
        return totalSize;
    }

    /**
     * Define o valor da propriedade totalSize.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalSize(Long value) {
        this.totalSize = value;
    }

    /**
     * Obtém o valor da propriedade totalCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * Define o valor da propriedade totalCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalCount(Integer value) {
        this.totalCount = value;
    }

}
