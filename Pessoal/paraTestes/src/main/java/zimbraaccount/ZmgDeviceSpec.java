
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de zmgDeviceSpec complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="zmgDeviceSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="appId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="registrationId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pushProvider" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="osName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="osVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="maxPayloadSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zmgDeviceSpec")
public class ZmgDeviceSpec {

    @XmlAttribute(name = "appId", required = true)
    protected String appId;
    @XmlAttribute(name = "registrationId", required = true)
    protected String registrationId;
    @XmlAttribute(name = "pushProvider", required = true)
    protected String pushProvider;
    @XmlAttribute(name = "osName")
    protected String osName;
    @XmlAttribute(name = "osVersion")
    protected String osVersion;
    @XmlAttribute(name = "maxPayloadSize")
    protected Integer maxPayloadSize;

    /**
     * Obtém o valor da propriedade appId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Define o valor da propriedade appId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppId(String value) {
        this.appId = value;
    }

    /**
     * Obtém o valor da propriedade registrationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * Define o valor da propriedade registrationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationId(String value) {
        this.registrationId = value;
    }

    /**
     * Obtém o valor da propriedade pushProvider.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPushProvider() {
        return pushProvider;
    }

    /**
     * Define o valor da propriedade pushProvider.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPushProvider(String value) {
        this.pushProvider = value;
    }

    /**
     * Obtém o valor da propriedade osName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsName() {
        return osName;
    }

    /**
     * Define o valor da propriedade osName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsName(String value) {
        this.osName = value;
    }

    /**
     * Obtém o valor da propriedade osVersion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * Define o valor da propriedade osVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsVersion(String value) {
        this.osVersion = value;
    }

    /**
     * Obtém o valor da propriedade maxPayloadSize.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxPayloadSize() {
        return maxPayloadSize;
    }

    /**
     * Define o valor da propriedade maxPayloadSize.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxPayloadSize(Integer value) {
        this.maxPayloadSize = value;
    }

}
