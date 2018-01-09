
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de documentActionSelector complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="documentActionSelector">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}actionSelector">
 *       &lt;sequence>
 *         &lt;element name="grant" type="{urn:zimbraMail}documentActionGrant" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="zid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentActionSelector", propOrder = {
    "grant"
})
public class DocumentActionSelector
    extends ActionSelector
{

    protected DocumentActionGrant grant;
    @XmlAttribute(name = "zid")
    protected String zid;

    /**
     * Obtém o valor da propriedade grant.
     * 
     * @return
     *     possible object is
     *     {@link DocumentActionGrant }
     *     
     */
    public DocumentActionGrant getGrant() {
        return grant;
    }

    /**
     * Define o valor da propriedade grant.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentActionGrant }
     *     
     */
    public void setGrant(DocumentActionGrant value) {
        this.grant = value;
    }

    /**
     * Obtém o valor da propriedade zid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZid() {
        return zid;
    }

    /**
     * Define o valor da propriedade zid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZid(String value) {
        this.zid = value;
    }

}
