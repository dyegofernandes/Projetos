
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de versionInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="versionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="release" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="buildDate" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="host" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="majorversion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="minorversion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="microversion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="platform" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "versionInfo")
public class VersionInfo {

    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "version", required = true)
    protected String version;
    @XmlAttribute(name = "release", required = true)
    protected String release;
    @XmlAttribute(name = "buildDate", required = true)
    protected String buildDate;
    @XmlAttribute(name = "host", required = true)
    protected String host;
    @XmlAttribute(name = "majorversion", required = true)
    protected String majorversion;
    @XmlAttribute(name = "minorversion", required = true)
    protected String minorversion;
    @XmlAttribute(name = "microversion", required = true)
    protected String microversion;
    @XmlAttribute(name = "platform", required = true)
    protected String platform;

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Define o valor da propriedade version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Obtém o valor da propriedade release.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelease() {
        return release;
    }

    /**
     * Define o valor da propriedade release.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelease(String value) {
        this.release = value;
    }

    /**
     * Obtém o valor da propriedade buildDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildDate() {
        return buildDate;
    }

    /**
     * Define o valor da propriedade buildDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildDate(String value) {
        this.buildDate = value;
    }

    /**
     * Obtém o valor da propriedade host.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHost() {
        return host;
    }

    /**
     * Define o valor da propriedade host.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHost(String value) {
        this.host = value;
    }

    /**
     * Obtém o valor da propriedade majorversion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMajorversion() {
        return majorversion;
    }

    /**
     * Define o valor da propriedade majorversion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajorversion(String value) {
        this.majorversion = value;
    }

    /**
     * Obtém o valor da propriedade minorversion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinorversion() {
        return minorversion;
    }

    /**
     * Define o valor da propriedade minorversion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinorversion(String value) {
        this.minorversion = value;
    }

    /**
     * Obtém o valor da propriedade microversion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMicroversion() {
        return microversion;
    }

    /**
     * Define o valor da propriedade microversion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMicroversion(String value) {
        this.microversion = value;
    }

    /**
     * Obtém o valor da propriedade platform.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Define o valor da propriedade platform.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatform(String value) {
        this.platform = value;
    }

}
