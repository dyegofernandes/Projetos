
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de queryMailboxMoveRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="queryMailboxMoveRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="account" type="{urn:zimbraAdmin}name" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="checkPeer" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryMailboxMoveRequest", propOrder = {
    "account"
})
public class QueryMailboxMoveRequest {

    protected List<Name> account;
    @XmlAttribute(name = "checkPeer")
    protected Boolean checkPeer;

    /**
     * Gets the value of the account property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the account property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Name }
     * 
     * 
     */
    public List<Name> getAccount() {
        if (account == null) {
            account = new ArrayList<Name>();
        }
        return this.account;
    }

    /**
     * Obtém o valor da propriedade checkPeer.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCheckPeer() {
        return checkPeer;
    }

    /**
     * Define o valor da propriedade checkPeer.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCheckPeer(Boolean value) {
        this.checkPeer = value;
    }

}