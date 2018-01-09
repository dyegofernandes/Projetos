
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de missingBlobInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="missingBlobInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="rev" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="s" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="volumeId" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="blobPath" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="external" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "missingBlobInfo")
public class MissingBlobInfo {

    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "rev", required = true)
    protected int rev;
    @XmlAttribute(name = "s", required = true)
    protected long s;
    @XmlAttribute(name = "volumeId", required = true)
    protected short volumeId;
    @XmlAttribute(name = "blobPath", required = true)
    protected String blobPath;
    @XmlAttribute(name = "external", required = true)
    protected boolean external;
    @XmlAttribute(name = "version", required = true)
    protected int version;

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

    /**
     * Obtém o valor da propriedade blobPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlobPath() {
        return blobPath;
    }

    /**
     * Define o valor da propriedade blobPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlobPath(String value) {
        this.blobPath = value;
    }

    /**
     * Obtém o valor da propriedade external.
     * 
     */
    public boolean isExternal() {
        return external;
    }

    /**
     * Define o valor da propriedade external.
     * 
     */
    public void setExternal(boolean value) {
        this.external = value;
    }

    /**
     * Obtém o valor da propriedade version.
     * 
     */
    public int getVersion() {
        return version;
    }

    /**
     * Define o valor da propriedade version.
     * 
     */
    public void setVersion(int value) {
        this.version = value;
    }

}
