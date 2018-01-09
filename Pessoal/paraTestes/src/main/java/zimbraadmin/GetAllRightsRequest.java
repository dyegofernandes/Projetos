
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getAllRightsRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getAllRightsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="targetType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="expandAllAttrs" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="rightClass" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllRightsRequest")
public class GetAllRightsRequest {

    @XmlAttribute(name = "targetType")
    protected String targetType;
    @XmlAttribute(name = "expandAllAttrs")
    protected Boolean expandAllAttrs;
    @XmlAttribute(name = "rightClass")
    protected String rightClass;

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
     * Obtém o valor da propriedade expandAllAttrs.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExpandAllAttrs() {
        return expandAllAttrs;
    }

    /**
     * Define o valor da propriedade expandAllAttrs.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExpandAllAttrs(Boolean value) {
        this.expandAllAttrs = value;
    }

    /**
     * Obtém o valor da propriedade rightClass.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRightClass() {
        return rightClass;
    }

    /**
     * Define o valor da propriedade rightClass.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRightClass(String value) {
        this.rightClass = value;
    }

}
