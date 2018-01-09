
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de modifyContactRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="modifyContactRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cn" type="{urn:zimbraMail}modifyContactSpec"/>
 *       &lt;/sequence>
 *       &lt;attribute name="replace" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="verbose" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyContactRequest", propOrder = {
    "cn"
})
public class ModifyContactRequest {

    @XmlElement(required = true)
    protected ModifyContactSpec cn;
    @XmlAttribute(name = "replace")
    protected Boolean replace;
    @XmlAttribute(name = "verbose")
    protected Boolean verbose;

    /**
     * Obtém o valor da propriedade cn.
     * 
     * @return
     *     possible object is
     *     {@link ModifyContactSpec }
     *     
     */
    public ModifyContactSpec getCn() {
        return cn;
    }

    /**
     * Define o valor da propriedade cn.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyContactSpec }
     *     
     */
    public void setCn(ModifyContactSpec value) {
        this.cn = value;
    }

    /**
     * Obtém o valor da propriedade replace.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReplace() {
        return replace;
    }

    /**
     * Define o valor da propriedade replace.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReplace(Boolean value) {
        this.replace = value;
    }

    /**
     * Obtém o valor da propriedade verbose.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerbose() {
        return verbose;
    }

    /**
     * Define o valor da propriedade verbose.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerbose(Boolean value) {
        this.verbose = value;
    }

}
