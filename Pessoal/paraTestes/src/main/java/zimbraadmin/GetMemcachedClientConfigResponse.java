
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getMemcachedClientConfigResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getMemcachedClientConfigResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="serverList" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="hashAlgorithm" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="binaryProtocol" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="defaultExpirySeconds" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="defaultTimeoutMillis" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMemcachedClientConfigResponse")
public class GetMemcachedClientConfigResponse {

    @XmlAttribute(name = "serverList")
    protected String serverList;
    @XmlAttribute(name = "hashAlgorithm")
    protected String hashAlgorithm;
    @XmlAttribute(name = "binaryProtocol")
    protected Boolean binaryProtocol;
    @XmlAttribute(name = "defaultExpirySeconds")
    protected Integer defaultExpirySeconds;
    @XmlAttribute(name = "defaultTimeoutMillis")
    protected Long defaultTimeoutMillis;

    /**
     * Obtém o valor da propriedade serverList.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerList() {
        return serverList;
    }

    /**
     * Define o valor da propriedade serverList.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerList(String value) {
        this.serverList = value;
    }

    /**
     * Obtém o valor da propriedade hashAlgorithm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHashAlgorithm() {
        return hashAlgorithm;
    }

    /**
     * Define o valor da propriedade hashAlgorithm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHashAlgorithm(String value) {
        this.hashAlgorithm = value;
    }

    /**
     * Obtém o valor da propriedade binaryProtocol.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBinaryProtocol() {
        return binaryProtocol;
    }

    /**
     * Define o valor da propriedade binaryProtocol.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBinaryProtocol(Boolean value) {
        this.binaryProtocol = value;
    }

    /**
     * Obtém o valor da propriedade defaultExpirySeconds.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDefaultExpirySeconds() {
        return defaultExpirySeconds;
    }

    /**
     * Define o valor da propriedade defaultExpirySeconds.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDefaultExpirySeconds(Integer value) {
        this.defaultExpirySeconds = value;
    }

    /**
     * Obtém o valor da propriedade defaultTimeoutMillis.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDefaultTimeoutMillis() {
        return defaultTimeoutMillis;
    }

    /**
     * Define o valor da propriedade defaultTimeoutMillis.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDefaultTimeoutMillis(Long value) {
        this.defaultTimeoutMillis = value;
    }

}
