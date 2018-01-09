
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de zimletInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="zimletInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraAdmin}adminObjectInfo">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="hasKeyword" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zimletInfo")
public class ZimletInfo
    extends AdminObjectInfo
{

    @XmlAttribute(name = "hasKeyword")
    protected String hasKeyword;

    /**
     * Obtém o valor da propriedade hasKeyword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHasKeyword() {
        return hasKeyword;
    }

    /**
     * Define o valor da propriedade hasKeyword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHasKeyword(String value) {
        this.hasKeyword = value;
    }

}
