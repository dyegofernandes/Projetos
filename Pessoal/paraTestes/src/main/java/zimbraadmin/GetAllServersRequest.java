
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getAllServersRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getAllServersRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="service" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="alwaysOnClusterId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="applyConfig" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllServersRequest")
public class GetAllServersRequest {

    @XmlAttribute(name = "service")
    protected String service;
    @XmlAttribute(name = "alwaysOnClusterId")
    protected String alwaysOnClusterId;
    @XmlAttribute(name = "applyConfig")
    protected Boolean applyConfig;

    /**
     * Obtém o valor da propriedade service.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getService() {
        return service;
    }

    /**
     * Define o valor da propriedade service.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setService(String value) {
        this.service = value;
    }

    /**
     * Obtém o valor da propriedade alwaysOnClusterId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlwaysOnClusterId() {
        return alwaysOnClusterId;
    }

    /**
     * Define o valor da propriedade alwaysOnClusterId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlwaysOnClusterId(String value) {
        this.alwaysOnClusterId = value;
    }

    /**
     * Obtém o valor da propriedade applyConfig.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isApplyConfig() {
        return applyConfig;
    }

    /**
     * Define o valor da propriedade applyConfig.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setApplyConfig(Boolean value) {
        this.applyConfig = value;
    }

}
