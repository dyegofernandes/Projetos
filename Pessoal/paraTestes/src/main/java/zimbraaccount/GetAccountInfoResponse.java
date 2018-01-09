
package zimbraaccount;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import zimbra.NamedValue;


/**
 * <p>Classe Java de getAccountInfoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getAccountInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="attr" type="{urn:zimbra}namedValue" maxOccurs="unbounded"/>
 *         &lt;element name="soapURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publicURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="changePasswordURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="communityURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adminURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="boshURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAccountInfoResponse", propOrder = {
    "name",
    "attr",
    "soapURL",
    "publicURL",
    "changePasswordURL",
    "communityURL",
    "adminURL",
    "boshURL"
})
public class GetAccountInfoResponse {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected List<NamedValue> attr;
    protected String soapURL;
    protected String publicURL;
    protected String changePasswordURL;
    protected String communityURL;
    protected String adminURL;
    protected String boshURL;

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the attr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NamedValue }
     * 
     * 
     */
    public List<NamedValue> getAttr() {
        if (attr == null) {
            attr = new ArrayList<NamedValue>();
        }
        return this.attr;
    }

    /**
     * Obtém o valor da propriedade soapURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoapURL() {
        return soapURL;
    }

    /**
     * Define o valor da propriedade soapURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoapURL(String value) {
        this.soapURL = value;
    }

    /**
     * Obtém o valor da propriedade publicURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicURL() {
        return publicURL;
    }

    /**
     * Define o valor da propriedade publicURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicURL(String value) {
        this.publicURL = value;
    }

    /**
     * Obtém o valor da propriedade changePasswordURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangePasswordURL() {
        return changePasswordURL;
    }

    /**
     * Define o valor da propriedade changePasswordURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangePasswordURL(String value) {
        this.changePasswordURL = value;
    }

    /**
     * Obtém o valor da propriedade communityURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommunityURL() {
        return communityURL;
    }

    /**
     * Define o valor da propriedade communityURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommunityURL(String value) {
        this.communityURL = value;
    }

    /**
     * Obtém o valor da propriedade adminURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdminURL() {
        return adminURL;
    }

    /**
     * Define o valor da propriedade adminURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdminURL(String value) {
        this.adminURL = value;
    }

    /**
     * Obtém o valor da propriedade boshURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoshURL() {
        return boshURL;
    }

    /**
     * Define o valor da propriedade boshURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoshURL(String value) {
        this.boshURL = value;
    }

}
