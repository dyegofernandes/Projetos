
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Classe Java de adminZimletInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="adminZimletInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zimletContext" type="{urn:zimbraAdmin}adminZimletContext" minOccurs="0"/>
 *         &lt;element name="zimlet" type="{urn:zimbraAdmin}adminZimletDesc" minOccurs="0"/>
 *         &lt;element name="zimletConfig" type="{urn:zimbraAdmin}adminZimletConfigInfo" minOccurs="0"/>
 *         &lt;any processContents='skip' namespace='##other'/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adminZimletInfo", propOrder = {
    "zimletContext",
    "zimlet",
    "zimletConfig",
    "any"
})
public class AdminZimletInfo {

    protected AdminZimletContext zimletContext;
    protected AdminZimletDesc zimlet;
    protected AdminZimletConfigInfo zimletConfig;
    @XmlAnyElement
    protected Element any;

    /**
     * Obtém o valor da propriedade zimletContext.
     * 
     * @return
     *     possible object is
     *     {@link AdminZimletContext }
     *     
     */
    public AdminZimletContext getZimletContext() {
        return zimletContext;
    }

    /**
     * Define o valor da propriedade zimletContext.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminZimletContext }
     *     
     */
    public void setZimletContext(AdminZimletContext value) {
        this.zimletContext = value;
    }

    /**
     * Obtém o valor da propriedade zimlet.
     * 
     * @return
     *     possible object is
     *     {@link AdminZimletDesc }
     *     
     */
    public AdminZimletDesc getZimlet() {
        return zimlet;
    }

    /**
     * Define o valor da propriedade zimlet.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminZimletDesc }
     *     
     */
    public void setZimlet(AdminZimletDesc value) {
        this.zimlet = value;
    }

    /**
     * Obtém o valor da propriedade zimletConfig.
     * 
     * @return
     *     possible object is
     *     {@link AdminZimletConfigInfo }
     *     
     */
    public AdminZimletConfigInfo getZimletConfig() {
        return zimletConfig;
    }

    /**
     * Define o valor da propriedade zimletConfig.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminZimletConfigInfo }
     *     
     */
    public void setZimletConfig(AdminZimletConfigInfo value) {
        this.zimletConfig = value;
    }

    /**
     * Obtém o valor da propriedade any.
     * 
     * @return
     *     possible object is
     *     {@link Element }
     *     
     */
    public Element getAny() {
        return any;
    }

    /**
     * Define o valor da propriedade any.
     * 
     * @param value
     *     allowed object is
     *     {@link Element }
     *     
     */
    public void setAny(Element value) {
        this.any = value;
    }

}
