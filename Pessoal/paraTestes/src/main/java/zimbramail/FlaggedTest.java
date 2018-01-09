
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de flaggedTest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="flaggedTest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}filterTest">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="flagName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flaggedTest")
public class FlaggedTest
    extends FilterTest
{

    @XmlAttribute(name = "flagName", required = true)
    protected String flagName;

    /**
     * Obtém o valor da propriedade flagName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagName() {
        return flagName;
    }

    /**
     * Define o valor da propriedade flagName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagName(String value) {
        this.flagName = value;
    }

}
