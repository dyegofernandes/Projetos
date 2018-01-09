
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de moveBlobsResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="moveBlobsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="numBlobsMoved" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="numBytesMoved" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="totalMailboxes" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moveBlobsResponse")
public class MoveBlobsResponse {

    @XmlAttribute(name = "numBlobsMoved")
    protected Integer numBlobsMoved;
    @XmlAttribute(name = "numBytesMoved")
    protected Long numBytesMoved;
    @XmlAttribute(name = "totalMailboxes")
    protected Integer totalMailboxes;

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

}
