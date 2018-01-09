
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import zimbra.AccountSelector;


/**
 * <p>Classe Java de enableArchiveRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="enableArchiveRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="account" type="{urn:zimbra}accountSelector"/>
 *         &lt;element name="archive" type="{urn:zimbraAdmin}archiveSpec" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enableArchiveRequest", propOrder = {
    "account",
    "archive"
})
public class EnableArchiveRequest {

    @XmlElement(required = true)
    protected AccountSelector account;
    protected ArchiveSpec archive;

    /**
     * Obtém o valor da propriedade account.
     * 
     * @return
     *     possible object is
     *     {@link AccountSelector }
     *     
     */
    public AccountSelector getAccount() {
        return account;
    }

    /**
     * Define o valor da propriedade account.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountSelector }
     *     
     */
    public void setAccount(AccountSelector value) {
        this.account = value;
    }

    /**
     * Obtém o valor da propriedade archive.
     * 
     * @return
     *     possible object is
     *     {@link ArchiveSpec }
     *     
     */
    public ArchiveSpec getArchive() {
        return archive;
    }

    /**
     * Define o valor da propriedade archive.
     * 
     * @param value
     *     allowed object is
     *     {@link ArchiveSpec }
     *     
     */
    public void setArchive(ArchiveSpec value) {
        this.archive = value;
    }

}
