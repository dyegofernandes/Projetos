
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import zimbra.KeyValuePair;


/**
 * <p>Classe Java de updatePresenceSessionIdResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="updatePresenceSessionIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="a" type="{urn:zimbra}keyValuePair" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePresenceSessionIdResponse", propOrder = {
    "a"
})
public class UpdatePresenceSessionIdResponse {

    protected KeyValuePair a;

    /**
     * Obtém o valor da propriedade a.
     * 
     * @return
     *     possible object is
     *     {@link KeyValuePair }
     *     
     */
    public KeyValuePair getA() {
        return a;
    }

    /**
     * Define o valor da propriedade a.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyValuePair }
     *     
     */
    public void setA(KeyValuePair value) {
        this.a = value;
    }

}
