
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de volumeInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="volumeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rootpath" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="compressBlobs" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="compressionThreshold" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="mgbits" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="mbits" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="fgbits" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="fbits" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="isCurrent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "volumeInfo")
public class VolumeInfo {

    @XmlAttribute(name = "id", required = true)
    protected short id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "rootpath")
    protected String rootpath;
    @XmlAttribute(name = "type", required = true)
    protected short type;
    @XmlAttribute(name = "compressBlobs")
    protected Boolean compressBlobs;
    @XmlAttribute(name = "compressionThreshold", required = true)
    protected long compressionThreshold;
    @XmlAttribute(name = "mgbits", required = true)
    protected short mgbits;
    @XmlAttribute(name = "mbits", required = true)
    protected short mbits;
    @XmlAttribute(name = "fgbits", required = true)
    protected short fgbits;
    @XmlAttribute(name = "fbits", required = true)
    protected short fbits;
    @XmlAttribute(name = "isCurrent")
    protected Boolean isCurrent;

    /**
     * Obtém o valor da propriedade id.
     * 
     */
    public short getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     */
    public void setId(short value) {
        this.id = value;
    }

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
     * Obtém o valor da propriedade rootpath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRootpath() {
        return rootpath;
    }

    /**
     * Define o valor da propriedade rootpath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRootpath(String value) {
        this.rootpath = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     */
    public short getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     */
    public void setType(short value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade compressBlobs.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCompressBlobs() {
        return compressBlobs;
    }

    /**
     * Define o valor da propriedade compressBlobs.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCompressBlobs(Boolean value) {
        this.compressBlobs = value;
    }

    /**
     * Obtém o valor da propriedade compressionThreshold.
     * 
     */
    public long getCompressionThreshold() {
        return compressionThreshold;
    }

    /**
     * Define o valor da propriedade compressionThreshold.
     * 
     */
    public void setCompressionThreshold(long value) {
        this.compressionThreshold = value;
    }

    /**
     * Obtém o valor da propriedade mgbits.
     * 
     */
    public short getMgbits() {
        return mgbits;
    }

    /**
     * Define o valor da propriedade mgbits.
     * 
     */
    public void setMgbits(short value) {
        this.mgbits = value;
    }

    /**
     * Obtém o valor da propriedade mbits.
     * 
     */
    public short getMbits() {
        return mbits;
    }

    /**
     * Define o valor da propriedade mbits.
     * 
     */
    public void setMbits(short value) {
        this.mbits = value;
    }

    /**
     * Obtém o valor da propriedade fgbits.
     * 
     */
    public short getFgbits() {
        return fgbits;
    }

    /**
     * Define o valor da propriedade fgbits.
     * 
     */
    public void setFgbits(short value) {
        this.fgbits = value;
    }

    /**
     * Obtém o valor da propriedade fbits.
     * 
     */
    public short getFbits() {
        return fbits;
    }

    /**
     * Define o valor da propriedade fbits.
     * 
     */
    public void setFbits(short value) {
        this.fbits = value;
    }

    /**
     * Obtém o valor da propriedade isCurrent.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCurrent() {
        return isCurrent;
    }

    /**
     * Define o valor da propriedade isCurrent.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCurrent(Boolean value) {
        this.isCurrent = value;
    }

}
