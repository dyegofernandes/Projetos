
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de convActionSelector complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="convActionSelector">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}actionSelector">
 *       &lt;sequence>
 *         &lt;element name="acctRelPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "convActionSelector", propOrder = {
    "acctRelPath"
})
public class ConvActionSelector
    extends ActionSelector
{

    protected String acctRelPath;

    /**
     * Obtém o valor da propriedade acctRelPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctRelPath() {
        return acctRelPath;
    }

    /**
     * Define o valor da propriedade acctRelPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctRelPath(String value) {
        this.acctRelPath = value;
    }

}
