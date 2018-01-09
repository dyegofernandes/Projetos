
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de xmppComponentInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="xmppComponentInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraAdmin}adminAttrsImpl">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="x-domainName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="x-serverName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xmppComponentInfo")
public class XmppComponentInfo
    extends AdminAttrsImpl
{

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "x-domainName")
    protected String xDomainName;
    @XmlAttribute(name = "x-serverName")
    protected String xServerName;

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
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade xDomainName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXDomainName() {
        return xDomainName;
    }

    /**
     * Define o valor da propriedade xDomainName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXDomainName(String value) {
        this.xDomainName = value;
    }

    /**
     * Obtém o valor da propriedade xServerName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXServerName() {
        return xServerName;
    }

    /**
     * Define o valor da propriedade xServerName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXServerName(String value) {
        this.xServerName = value;
    }

}
