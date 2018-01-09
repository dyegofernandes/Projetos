
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de deleteIdentityRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="deleteIdentityRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identity" type="{urn:zimbraAccount}nameId"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteIdentityRequest", propOrder = {
    "identity"
})
public class DeleteIdentityRequest {

    @XmlElement(required = true)
    protected NameId identity;

    /**
     * Obtém o valor da propriedade identity.
     * 
     * @return
     *     possible object is
     *     {@link NameId }
     *     
     */
    public NameId getIdentity() {
        return identity;
    }

    /**
     * Define o valor da propriedade identity.
     * 
     * @param value
     *     allowed object is
     *     {@link NameId }
     *     
     */
    public void setIdentity(NameId value) {
        this.identity = value;
    }

}
