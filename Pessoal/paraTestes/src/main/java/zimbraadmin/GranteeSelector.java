
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import zimbra.GranteeType;


/**
 * <p>Classe Java de granteeSelector complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="granteeSelector">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="type" type="{urn:zimbra}granteeType" />
 *       &lt;attribute name="by" type="{urn:zimbraAdmin}granteeBy" />
 *       &lt;attribute name="secret" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "granteeSelector", propOrder = {
    "value"
})
public class GranteeSelector {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "type")
    protected GranteeType type;
    @XmlAttribute(name = "by")
    protected GranteeBy by;
    @XmlAttribute(name = "secret")
    protected String secret;
    @XmlAttribute(name = "all")
    protected Boolean all;

    /**
     * Obtém o valor da propriedade value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define o valor da propriedade value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link GranteeType }
     *     
     */
    public GranteeType getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link GranteeType }
     *     
     */
    public void setType(GranteeType value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade by.
     * 
     * @return
     *     possible object is
     *     {@link GranteeBy }
     *     
     */
    public GranteeBy getBy() {
        return by;
    }

    /**
     * Define o valor da propriedade by.
     * 
     * @param value
     *     allowed object is
     *     {@link GranteeBy }
     *     
     */
    public void setBy(GranteeBy value) {
        this.by = value;
    }

    /**
     * Obtém o valor da propriedade secret.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecret() {
        return secret;
    }

    /**
     * Define o valor da propriedade secret.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecret(String value) {
        this.secret = value;
    }

    /**
     * Obtém o valor da propriedade all.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAll() {
        return all;
    }

    /**
     * Define o valor da propriedade all.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAll(Boolean value) {
        this.all = value;
    }

}
