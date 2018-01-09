
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de verifyStoreManagerResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="verifyStoreManagerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="storeManagerClass" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="incomingTime" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="stageTime" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="linkTime" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="fetchTime" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="deleteTime" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifyStoreManagerResponse")
public class VerifyStoreManagerResponse {

    @XmlAttribute(name = "storeManagerClass")
    protected String storeManagerClass;
    @XmlAttribute(name = "incomingTime")
    protected Long incomingTime;
    @XmlAttribute(name = "stageTime")
    protected Long stageTime;
    @XmlAttribute(name = "linkTime")
    protected Long linkTime;
    @XmlAttribute(name = "fetchTime")
    protected Long fetchTime;
    @XmlAttribute(name = "deleteTime")
    protected Long deleteTime;

    /**
     * Obtém o valor da propriedade storeManagerClass.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoreManagerClass() {
        return storeManagerClass;
    }

    /**
     * Define o valor da propriedade storeManagerClass.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoreManagerClass(String value) {
        this.storeManagerClass = value;
    }

    /**
     * Obtém o valor da propriedade incomingTime.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIncomingTime() {
        return incomingTime;
    }

    /**
     * Define o valor da propriedade incomingTime.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIncomingTime(Long value) {
        this.incomingTime = value;
    }

    /**
     * Obtém o valor da propriedade stageTime.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStageTime() {
        return stageTime;
    }

    /**
     * Define o valor da propriedade stageTime.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStageTime(Long value) {
        this.stageTime = value;
    }

    /**
     * Obtém o valor da propriedade linkTime.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLinkTime() {
        return linkTime;
    }

    /**
     * Define o valor da propriedade linkTime.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLinkTime(Long value) {
        this.linkTime = value;
    }

    /**
     * Obtém o valor da propriedade fetchTime.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFetchTime() {
        return fetchTime;
    }

    /**
     * Define o valor da propriedade fetchTime.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFetchTime(Long value) {
        this.fetchTime = value;
    }

    /**
     * Obtém o valor da propriedade deleteTime.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeleteTime() {
        return deleteTime;
    }

    /**
     * Define o valor da propriedade deleteTime.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeleteTime(Long value) {
        this.deleteTime = value;
    }

}
