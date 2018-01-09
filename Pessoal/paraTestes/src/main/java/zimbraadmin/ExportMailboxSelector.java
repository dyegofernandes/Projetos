
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de exportMailboxSelector complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="exportMailboxSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dest" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="destPort" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="tempDir" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="overwrite" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportMailboxSelector")
public class ExportMailboxSelector {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "dest", required = true)
    protected String dest;
    @XmlAttribute(name = "destPort")
    protected Integer destPort;
    @XmlAttribute(name = "tempDir")
    protected String tempDir;
    @XmlAttribute(name = "overwrite")
    protected Boolean overwrite;

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
     * Obtém o valor da propriedade destPort.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDestPort() {
        return destPort;
    }

    /**
     * Define o valor da propriedade destPort.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDestPort(Integer value) {
        this.destPort = value;
    }

    /**
     * Obtém o valor da propriedade tempDir.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTempDir() {
        return tempDir;
    }

    /**
     * Define o valor da propriedade tempDir.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTempDir(String value) {
        this.tempDir = value;
    }

    /**
     * Obtém o valor da propriedade overwrite.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOverwrite() {
        return overwrite;
    }

    /**
     * Define o valor da propriedade overwrite.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOverwrite(Boolean value) {
        this.overwrite = value;
    }

}
