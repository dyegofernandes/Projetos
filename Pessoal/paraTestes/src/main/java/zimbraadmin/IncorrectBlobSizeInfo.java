
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de incorrectBlobSizeInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="incorrectBlobSizeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="blob" type="{urn:zimbraAdmin}blobSizeInfo"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="rev" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="s" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="volumeId" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "incorrectBlobSizeInfo", propOrder = {
    "blob"
})
public class IncorrectBlobSizeInfo {

    @XmlElement(required = true)
    protected BlobSizeInfo blob;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "rev", required = true)
    protected int rev;
    @XmlAttribute(name = "s", required = true)
    protected long s;
    @XmlAttribute(name = "volumeId", required = true)
    protected short volumeId;

    /**
     * Obtém o valor da propriedade blob.
     * 
     * @return
     *     possible object is
     *     {@link BlobSizeInfo }
     *     
     */
    public BlobSizeInfo getBlob() {
        return blob;
    }

    /**
     * Define o valor da propriedade blob.
     * 
     * @param value
     *     allowed object is
     *     {@link BlobSizeInfo }
     *     
     */
    public void setBlob(BlobSizeInfo value) {
        this.blob = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade rev.
     * 
     */
    public int getRev() {
        return rev;
    }

    /**
     * Define o valor da propriedade rev.
     * 
     */
    public void setRev(int value) {
        this.rev = value;
    }

    /**
     * Obtém o valor da propriedade s.
     * 
     */
    public long getS() {
        return s;
    }

    /**
     * Define o valor da propriedade s.
     * 
     */
    public void setS(long value) {
        this.s = value;
    }

    /**
     * Obtém o valor da propriedade volumeId.
     * 
     */
    public short getVolumeId() {
        return volumeId;
    }

    /**
     * Define o valor da propriedade volumeId.
     * 
     */
    public void setVolumeId(short value) {
        this.volumeId = value;
    }

}
