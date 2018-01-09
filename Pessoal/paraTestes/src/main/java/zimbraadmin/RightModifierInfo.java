
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Classe Java de rightModifierInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="rightModifierInfo">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="deny" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="canDelegate" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="disinheritSubGroups" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="subDomain" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rightModifierInfo", propOrder = {
    "value"
})
public class RightModifierInfo {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "deny")
    protected Boolean deny;
    @XmlAttribute(name = "canDelegate")
    protected Boolean canDelegate;
    @XmlAttribute(name = "disinheritSubGroups")
    protected Boolean disinheritSubGroups;
    @XmlAttribute(name = "subDomain")
    protected Boolean subDomain;

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
     * Obtém o valor da propriedade deny.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeny() {
        return deny;
    }

    /**
     * Define o valor da propriedade deny.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeny(Boolean value) {
        this.deny = value;
    }

    /**
     * Obtém o valor da propriedade canDelegate.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanDelegate() {
        return canDelegate;
    }

    /**
     * Define o valor da propriedade canDelegate.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanDelegate(Boolean value) {
        this.canDelegate = value;
    }

    /**
     * Obtém o valor da propriedade disinheritSubGroups.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDisinheritSubGroups() {
        return disinheritSubGroups;
    }

    /**
     * Define o valor da propriedade disinheritSubGroups.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisinheritSubGroups(Boolean value) {
        this.disinheritSubGroups = value;
    }

    /**
     * Obtém o valor da propriedade subDomain.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSubDomain() {
        return subDomain;
    }

    /**
     * Define o valor da propriedade subDomain.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSubDomain(Boolean value) {
        this.subDomain = value;
    }

}
