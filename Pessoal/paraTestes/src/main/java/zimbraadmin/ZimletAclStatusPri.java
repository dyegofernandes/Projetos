
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de zimletAclStatusPri complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="zimletAclStatusPri">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="acl" type="{urn:zimbraAdmin}zimletAcl" minOccurs="0"/>
 *         &lt;element name="status" type="{urn:zimbraAdmin}valueAttrib" minOccurs="0"/>
 *         &lt;element name="priority" type="{urn:zimbraAdmin}integerValueAttrib" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zimletAclStatusPri", propOrder = {
    "acl",
    "status",
    "priority"
})
public class ZimletAclStatusPri {

    protected ZimletAcl acl;
    protected ValueAttrib status;
    protected IntegerValueAttrib priority;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Obtém o valor da propriedade acl.
     * 
     * @return
     *     possible object is
     *     {@link ZimletAcl }
     *     
     */
    public ZimletAcl getAcl() {
        return acl;
    }

    /**
     * Define o valor da propriedade acl.
     * 
     * @param value
     *     allowed object is
     *     {@link ZimletAcl }
     *     
     */
    public void setAcl(ZimletAcl value) {
        this.acl = value;
    }

    /**
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link ValueAttrib }
     *     
     */
    public ValueAttrib getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueAttrib }
     *     
     */
    public void setStatus(ValueAttrib value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade priority.
     * 
     * @return
     *     possible object is
     *     {@link IntegerValueAttrib }
     *     
     */
    public IntegerValueAttrib getPriority() {
        return priority;
    }

    /**
     * Define o valor da propriedade priority.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegerValueAttrib }
     *     
     */
    public void setPriority(IntegerValueAttrib value) {
        this.priority = value;
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

}
