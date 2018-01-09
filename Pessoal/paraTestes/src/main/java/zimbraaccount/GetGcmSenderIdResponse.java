
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getGcmSenderIdResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getGcmSenderIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gcmSenderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getGcmSenderIdResponse", propOrder = {
    "gcmSenderId"
})
public class GetGcmSenderIdResponse {

    @XmlElement(required = true)
    protected String gcmSenderId;

    /**
     * Obtém o valor da propriedade gcmSenderId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGcmSenderId() {
        return gcmSenderId;
    }

    /**
     * Define o valor da propriedade gcmSenderId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGcmSenderId(String value) {
        this.gcmSenderId = value;
    }

}
