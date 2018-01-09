
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import zimbra.Id;


/**
 * <p>Classe Java de tzReplaceInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tzReplaceInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="wellKnownTz" type="{urn:zimbra}id" minOccurs="0"/>
 *         &lt;element name="tz" type="{urn:zimbraAdmin}calTZInfo" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tzReplaceInfo", propOrder = {

})
public class TzReplaceInfo {

    protected Id wellKnownTz;
    protected CalTZInfo tz;

    /**
     * Obtém o valor da propriedade wellKnownTz.
     * 
     * @return
     *     possible object is
     *     {@link Id }
     *     
     */
    public Id getWellKnownTz() {
        return wellKnownTz;
    }

    /**
     * Define o valor da propriedade wellKnownTz.
     * 
     * @param value
     *     allowed object is
     *     {@link Id }
     *     
     */
    public void setWellKnownTz(Id value) {
        this.wellKnownTz = value;
    }

    /**
     * Obtém o valor da propriedade tz.
     * 
     * @return
     *     possible object is
     *     {@link CalTZInfo }
     *     
     */
    public CalTZInfo getTz() {
        return tz;
    }

    /**
     * Define o valor da propriedade tz.
     * 
     * @param value
     *     allowed object is
     *     {@link CalTZInfo }
     *     
     */
    public void setTz(CalTZInfo value) {
        this.tz = value;
    }

}
