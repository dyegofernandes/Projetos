
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de rightInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="rightInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="attrs" type="{urn:zimbraAdmin}rightsAttrs" minOccurs="0"/>
 *         &lt;element name="rights" type="{urn:zimbraAdmin}comboRights" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{urn:zimbraAdmin}rightType" />
 *       &lt;attribute name="targetType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rightClass" use="required" type="{urn:zimbraAdmin}rightClass" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rightInfo", propOrder = {
    "desc",
    "attrs",
    "rights"
})
public class RightInfo {

    @XmlElement(required = true)
    protected String desc;
    protected RightsAttrs attrs;
    protected ComboRights rights;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "type", required = true)
    protected RightType type;
    @XmlAttribute(name = "targetType")
    protected String targetType;
    @XmlAttribute(name = "rightClass", required = true)
    protected RightClass rightClass;

    /**
     * Obtém o valor da propriedade desc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Define o valor da propriedade desc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Obtém o valor da propriedade attrs.
     * 
     * @return
     *     possible object is
     *     {@link RightsAttrs }
     *     
     */
    public RightsAttrs getAttrs() {
        return attrs;
    }

    /**
     * Define o valor da propriedade attrs.
     * 
     * @param value
     *     allowed object is
     *     {@link RightsAttrs }
     *     
     */
    public void setAttrs(RightsAttrs value) {
        this.attrs = value;
    }

    /**
     * Obtém o valor da propriedade rights.
     * 
     * @return
     *     possible object is
     *     {@link ComboRights }
     *     
     */
    public ComboRights getRights() {
        return rights;
    }

    /**
     * Define o valor da propriedade rights.
     * 
     * @param value
     *     allowed object is
     *     {@link ComboRights }
     *     
     */
    public void setRights(ComboRights value) {
        this.rights = value;
    }

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link RightType }
     *     
     */
    public RightType getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link RightType }
     *     
     */
    public void setType(RightType value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade targetType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetType() {
        return targetType;
    }

    /**
     * Define o valor da propriedade targetType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetType(String value) {
        this.targetType = value;
    }

    /**
     * Obtém o valor da propriedade rightClass.
     * 
     * @return
     *     possible object is
     *     {@link RightClass }
     *     
     */
    public RightClass getRightClass() {
        return rightClass;
    }

    /**
     * Define o valor da propriedade rightClass.
     * 
     * @param value
     *     allowed object is
     *     {@link RightClass }
     *     
     */
    public void setRightClass(RightClass value) {
        this.rightClass = value;
    }

}
