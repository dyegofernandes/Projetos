
package zimbrasync;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de deviceStatusInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="deviceStatusInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="provisionable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="firstReqReceived" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lastPolicyUpdate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="remoteWipeReqTime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="remoteWipeAckTime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="recoveryPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastUsedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ua" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="protocol" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="model" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="imei" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="friendly_name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="os" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="os_language" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="phone_number" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deviceStatusInfo", propOrder = {
    "provisionable",
    "status",
    "firstReqReceived",
    "lastPolicyUpdate",
    "remoteWipeReqTime",
    "remoteWipeAckTime",
    "recoveryPassword",
    "lastUsedDate"
})
public class DeviceStatusInfo {

    protected boolean provisionable;
    protected byte status;
    protected int firstReqReceived;
    protected Integer lastPolicyUpdate;
    protected Integer remoteWipeReqTime;
    protected Integer remoteWipeAckTime;
    protected String recoveryPassword;
    protected String lastUsedDate;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "ua")
    protected String ua;
    @XmlAttribute(name = "protocol")
    protected String protocol;
    @XmlAttribute(name = "model")
    protected String model;
    @XmlAttribute(name = "imei")
    protected String imei;
    @XmlAttribute(name = "friendly_name")
    protected String friendlyName;
    @XmlAttribute(name = "os")
    protected String os;
    @XmlAttribute(name = "os_language")
    protected String osLanguage;
    @XmlAttribute(name = "phone_number")
    protected String phoneNumber;

    /**
     * Obtém o valor da propriedade provisionable.
     * 
     */
    public boolean isProvisionable() {
        return provisionable;
    }

    /**
     * Define o valor da propriedade provisionable.
     * 
     */
    public void setProvisionable(boolean value) {
        this.provisionable = value;
    }

    /**
     * Obtém o valor da propriedade status.
     * 
     */
    public byte getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     */
    public void setStatus(byte value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade firstReqReceived.
     * 
     */
    public int getFirstReqReceived() {
        return firstReqReceived;
    }

    /**
     * Define o valor da propriedade firstReqReceived.
     * 
     */
    public void setFirstReqReceived(int value) {
        this.firstReqReceived = value;
    }

    /**
     * Obtém o valor da propriedade lastPolicyUpdate.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLastPolicyUpdate() {
        return lastPolicyUpdate;
    }

    /**
     * Define o valor da propriedade lastPolicyUpdate.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLastPolicyUpdate(Integer value) {
        this.lastPolicyUpdate = value;
    }

    /**
     * Obtém o valor da propriedade remoteWipeReqTime.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRemoteWipeReqTime() {
        return remoteWipeReqTime;
    }

    /**
     * Define o valor da propriedade remoteWipeReqTime.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRemoteWipeReqTime(Integer value) {
        this.remoteWipeReqTime = value;
    }

    /**
     * Obtém o valor da propriedade remoteWipeAckTime.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRemoteWipeAckTime() {
        return remoteWipeAckTime;
    }

    /**
     * Define o valor da propriedade remoteWipeAckTime.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRemoteWipeAckTime(Integer value) {
        this.remoteWipeAckTime = value;
    }

    /**
     * Obtém o valor da propriedade recoveryPassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecoveryPassword() {
        return recoveryPassword;
    }

    /**
     * Define o valor da propriedade recoveryPassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecoveryPassword(String value) {
        this.recoveryPassword = value;
    }

    /**
     * Obtém o valor da propriedade lastUsedDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUsedDate() {
        return lastUsedDate;
    }

    /**
     * Define o valor da propriedade lastUsedDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUsedDate(String value) {
        this.lastUsedDate = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

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
     * Obtém o valor da propriedade ua.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUa() {
        return ua;
    }

    /**
     * Define o valor da propriedade ua.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUa(String value) {
        this.ua = value;
    }

    /**
     * Obtém o valor da propriedade protocol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Define o valor da propriedade protocol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocol(String value) {
        this.protocol = value;
    }

    /**
     * Obtém o valor da propriedade model.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Define o valor da propriedade model.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Obtém o valor da propriedade imei.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImei() {
        return imei;
    }

    /**
     * Define o valor da propriedade imei.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImei(String value) {
        this.imei = value;
    }

    /**
     * Obtém o valor da propriedade friendlyName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     * Define o valor da propriedade friendlyName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFriendlyName(String value) {
        this.friendlyName = value;
    }

    /**
     * Obtém o valor da propriedade os.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOs() {
        return os;
    }

    /**
     * Define o valor da propriedade os.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOs(String value) {
        this.os = value;
    }

    /**
     * Obtém o valor da propriedade osLanguage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsLanguage() {
        return osLanguage;
    }

    /**
     * Define o valor da propriedade osLanguage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsLanguage(String value) {
        this.osLanguage = value;
    }

    /**
     * Obtém o valor da propriedade phoneNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Define o valor da propriedade phoneNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

}
