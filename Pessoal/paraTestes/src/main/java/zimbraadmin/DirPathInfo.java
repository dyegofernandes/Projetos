
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de dirPathInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dirPathInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="path" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="exists" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="isDirectory" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="readable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="writable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dirPathInfo")
public class DirPathInfo {

    @XmlAttribute(name = "path", required = true)
    protected String path;
    @XmlAttribute(name = "exists", required = true)
    protected boolean exists;
    @XmlAttribute(name = "isDirectory", required = true)
    protected boolean isDirectory;
    @XmlAttribute(name = "readable", required = true)
    protected boolean readable;
    @XmlAttribute(name = "writable", required = true)
    protected boolean writable;

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
     * Obtém o valor da propriedade exists.
     * 
     */
    public boolean isExists() {
        return exists;
    }

    /**
     * Define o valor da propriedade exists.
     * 
     */
    public void setExists(boolean value) {
        this.exists = value;
    }

    /**
     * Obtém o valor da propriedade isDirectory.
     * 
     */
    public boolean isIsDirectory() {
        return isDirectory;
    }

    /**
     * Define o valor da propriedade isDirectory.
     * 
     */
    public void setIsDirectory(boolean value) {
        this.isDirectory = value;
    }

    /**
     * Obtém o valor da propriedade readable.
     * 
     */
    public boolean isReadable() {
        return readable;
    }

    /**
     * Define o valor da propriedade readable.
     * 
     */
    public void setReadable(boolean value) {
        this.readable = value;
    }

    /**
     * Obtém o valor da propriedade writable.
     * 
     */
    public boolean isWritable() {
        return writable;
    }

    /**
     * Define o valor da propriedade writable.
     * 
     */
    public void setWritable(boolean value) {
        this.writable = value;
    }

}
