
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createLDAPEntryResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createLDAPEntryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LDAPEntry" type="{urn:zimbraAdmin}ldapEntryInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createLDAPEntryResponse", propOrder = {
    "ldapEntry"
})
public class CreateLDAPEntryResponse {

    @XmlElement(name = "LDAPEntry", required = true)
    protected LdapEntryInfo ldapEntry;

    /**
     * Obtém o valor da propriedade ldapEntry.
     * 
     * @return
     *     possible object is
     *     {@link LdapEntryInfo }
     *     
     */
    public LdapEntryInfo getLDAPEntry() {
        return ldapEntry;
    }

    /**
     * Define o valor da propriedade ldapEntry.
     * 
     * @param value
     *     allowed object is
     *     {@link LdapEntryInfo }
     *     
     */
    public void setLDAPEntry(LdapEntryInfo value) {
        this.ldapEntry = value;
    }

}
