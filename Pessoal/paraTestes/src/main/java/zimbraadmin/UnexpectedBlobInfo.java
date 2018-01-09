
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de unexpectedBlobInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="unexpectedBlobInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="volumeId" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="path" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fileSize" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="external" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unexpectedBlobInfo")
public class UnexpectedBlobInfo {

    @XmlAttribute(name = "volumeId", required = true)
    protected short volumeId;
    @XmlAttribute(name = "path", required = true)
    protected String path;
    @XmlAttribute(name = "fileSize", required = true)
    protected long fileSize;
    @XmlAttribute(name = "external", required = true)
    protected boolean external;

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
     * Obtém o valor da propriedade path.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * Define o valor da propriedade path.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Obtém o valor da propriedade fileSize.
     * 
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * Define o valor da propriedade fileSize.
     * 
     */
    public void setFileSize(long value) {
        this.fileSize = value;
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

}
