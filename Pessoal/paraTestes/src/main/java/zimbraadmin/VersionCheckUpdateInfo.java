
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de versionCheckUpdateInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="versionCheckUpdateInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="critical" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="updateURL" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="shortversion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="release" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="buildtype" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="platform" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "versionCheckUpdateInfo")
public class VersionCheckUpdateInfo {

    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "critical")
    protected Boolean critical;
    @XmlAttribute(name = "updateURL")
    protected String updateURL;
    @XmlAttribute(name = "description")
    protected String description;
    @XmlAttribute(name = "shortversion")
    protected String shortversion;
    @XmlAttribute(name = "release")
    protected String release;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "buildtype")
    protected String buildtype;
    @XmlAttribute(name = "platform")
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
     * Obtém o valor da propriedade critical.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCritical() {
        return critical;
    }

    /**
     * Define o valor da propriedade critical.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCritical(Boolean value) {
        this.critical = value;
    }

    /**
     * Obtém o valor da propriedade updateURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateURL() {
        return updateURL;
    }

    /**
     * Define o valor da propriedade updateURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateURL(String value) {
        this.updateURL = value;
    }

    /**
     * Obtém o valor da propriedade description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define o valor da propriedade description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtém o valor da propriedade shortversion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortversion() {
        return shortversion;
    }

    /**
     * Define o valor da propriedade shortversion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortversion(String value) {
        this.shortversion = value;
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
     * Obtém o valor da propriedade buildtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildtype() {
        return buildtype;
    }

    /**
     * Define o valor da propriedade buildtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildtype(String value) {
        this.buildtype = value;
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
