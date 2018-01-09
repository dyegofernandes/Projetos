
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de appSpecificPasswordData complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="appSpecificPasswordData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="appName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="created" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="lastUsed" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appSpecificPasswordData")
public class AppSpecificPasswordData {

    @XmlAttribute(name = "appName")
    protected String appName;
    @XmlAttribute(name = "created")
    protected Long created;
    @XmlAttribute(name = "lastUsed")
    protected Long lastUsed;

    /**
     * Obtém o valor da propriedade appName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppName() {
        return appName;
    }

    /**
     * Define o valor da propriedade appName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppName(String value) {
        this.appName = value;
    }

    /**
     * Obtém o valor da propriedade created.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreated() {
        return created;
    }

    /**
     * Define o valor da propriedade created.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreated(Long value) {
        this.created = value;
    }

    /**
     * Obtém o valor da propriedade lastUsed.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLastUsed() {
        return lastUsed;
    }

    /**
     * Define o valor da propriedade lastUsed.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLastUsed(Long value) {
        this.lastUsed = value;
    }

}
