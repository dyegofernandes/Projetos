
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de checkBlobConsistencyRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="checkBlobConsistencyRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="volume" type="{urn:zimbraAdmin}intIdAttr" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="mbox" type="{urn:zimbraAdmin}intIdAttr" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="checkSize" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="reportUsedBlobs" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkBlobConsistencyRequest", propOrder = {
    "volume",
    "mbox"
})
public class CheckBlobConsistencyRequest {

    protected List<IntIdAttr> volume;
    protected List<IntIdAttr> mbox;
    @XmlAttribute(name = "checkSize")
    protected Boolean checkSize;
    @XmlAttribute(name = "reportUsedBlobs")
    protected Boolean reportUsedBlobs;

    /**
     * Gets the value of the volume property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the volume property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVolume().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntIdAttr }
     * 
     * 
     */
    public List<IntIdAttr> getVolume() {
        if (volume == null) {
            volume = new ArrayList<IntIdAttr>();
        }
        return this.volume;
    }

    /**
     * Gets the value of the mbox property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mbox property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMbox().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntIdAttr }
     * 
     * 
     */
    public List<IntIdAttr> getMbox() {
        if (mbox == null) {
            mbox = new ArrayList<IntIdAttr>();
        }
        return this.mbox;
    }

    /**
     * Obtém o valor da propriedade checkSize.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCheckSize() {
        return checkSize;
    }

    /**
     * Define o valor da propriedade checkSize.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCheckSize(Boolean value) {
        this.checkSize = value;
    }

    /**
     * Obtém o valor da propriedade reportUsedBlobs.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReportUsedBlobs() {
        return reportUsedBlobs;
    }

    /**
     * Define o valor da propriedade reportUsedBlobs.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReportUsedBlobs(Boolean value) {
        this.reportUsedBlobs = value;
    }

}
