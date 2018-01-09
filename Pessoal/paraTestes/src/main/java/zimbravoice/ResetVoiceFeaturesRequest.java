
package zimbravoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de resetVoiceFeaturesRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="resetVoiceFeaturesRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="storeprincipal" type="{urn:zimbraVoice}storePrincipalSpec" minOccurs="0"/>
 *         &lt;element name="phone" type="{urn:zimbraVoice}resetPhoneVoiceFeaturesSpec" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resetVoiceFeaturesRequest", propOrder = {
    "storeprincipal",
    "phone"
})
public class ResetVoiceFeaturesRequest {

    protected StorePrincipalSpec storeprincipal;
    protected ResetPhoneVoiceFeaturesSpec phone;

    /**
     * Obtém o valor da propriedade storeprincipal.
     * 
     * @return
     *     possible object is
     *     {@link StorePrincipalSpec }
     *     
     */
    public StorePrincipalSpec getStoreprincipal() {
        return storeprincipal;
    }

    /**
     * Define o valor da propriedade storeprincipal.
     * 
     * @param value
     *     allowed object is
     *     {@link StorePrincipalSpec }
     *     
     */
    public void setStoreprincipal(StorePrincipalSpec value) {
        this.storeprincipal = value;
    }

    /**
     * Obtém o valor da propriedade phone.
     * 
     * @return
     *     possible object is
     *     {@link ResetPhoneVoiceFeaturesSpec }
     *     
     */
    public ResetPhoneVoiceFeaturesSpec getPhone() {
        return phone;
    }

    /**
     * Define o valor da propriedade phone.
     * 
     * @param value
     *     allowed object is
     *     {@link ResetPhoneVoiceFeaturesSpec }
     *     
     */
    public void setPhone(ResetPhoneVoiceFeaturesSpec value) {
        this.phone = value;
    }

}
