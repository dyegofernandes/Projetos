
package zimbraaccount;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import zimbra.TargetBy;
import zimbra.TargetType;


/**
 * <p>Classe Java de checkRightsTargetInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="checkRightsTargetInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="right" type="{urn:zimbraAccount}checkRightsRightInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{urn:zimbra}targetType" />
 *       &lt;attribute name="by" use="required" type="{urn:zimbra}targetBy" />
 *       &lt;attribute name="key" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="allow" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkRightsTargetInfo", propOrder = {
    "right"
})
public class CheckRightsTargetInfo {

    @XmlElement(required = true)
    protected List<CheckRightsRightInfo> right;
    @XmlAttribute(name = "type", required = true)
    protected TargetType type;
    @XmlAttribute(name = "by", required = true)
    protected TargetBy by;
    @XmlAttribute(name = "key", required = true)
    protected String key;
    @XmlAttribute(name = "allow", required = true)
    protected boolean allow;

    /**
     * Gets the value of the right property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the right property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRight().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckRightsRightInfo }
     * 
     * 
     */
    public List<CheckRightsRightInfo> getRight() {
        if (right == null) {
            right = new ArrayList<CheckRightsRightInfo>();
        }
        return this.right;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link TargetType }
     *     
     */
    public TargetType getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetType }
     *     
     */
    public void setType(TargetType value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade by.
     * 
     * @return
     *     possible object is
     *     {@link TargetBy }
     *     
     */
    public TargetBy getBy() {
        return by;
    }

    /**
     * Define o valor da propriedade by.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetBy }
     *     
     */
    public void setBy(TargetBy value) {
        this.by = value;
    }

    /**
     * Obtém o valor da propriedade key.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Define o valor da propriedade key.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Obtém o valor da propriedade allow.
     * 
     */
    public boolean isAllow() {
        return allow;
    }

    /**
     * Define o valor da propriedade allow.
     * 
     */
    public void setAllow(boolean value) {
        this.allow = value;
    }

}
