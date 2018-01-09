
package zimbravoice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getVoiceFolderRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getVoiceFolderRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="storeprincipal" type="{urn:zimbraVoice}storePrincipalSpec" minOccurs="0"/>
 *         &lt;element name="phone" type="{urn:zimbraVoice}phoneSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getVoiceFolderRequest", propOrder = {
    "storeprincipal",
    "phone"
})
public class GetVoiceFolderRequest {

    protected StorePrincipalSpec storeprincipal;
    protected List<PhoneSpec> phone;

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
     * Gets the value of the phone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhoneSpec }
     * 
     * 
     */
    public List<PhoneSpec> getPhone() {
        if (phone == null) {
            phone = new ArrayList<PhoneSpec>();
        }
        return this.phone;
    }

}
