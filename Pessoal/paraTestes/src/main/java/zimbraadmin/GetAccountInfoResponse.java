
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{urn:zimbraAdmin}a" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cos" type="{urn:zimbraAdmin}cosInfo" minOccurs="0"/>
 *         &lt;element name="soapURL" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adminSoapURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publicMailURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "a",
    "cos",
    "soapURL",
    "adminSoapURL",
    "publicMailURL"
})
public class GetAccountInfoResponse {

    @XmlElement(required = true)
    protected String name;
    protected List<Attr> a;
    protected CosInfo cos;
    protected List<String> soapURL;
    protected String adminSoapURL;
    protected String publicMailURL;

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
     * Gets the value of the a property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the a property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attr }
     * 
     * 
     */
    public List<Attr> getA() {
        if (a == null) {
            a = new ArrayList<Attr>();
        }
        return this.a;
    }

    /**
     * Obtém o valor da propriedade cos.
     * 
     * @return
     *     possible object is
     *     {@link CosInfo }
     *     
     */
    public CosInfo getCos() {
        return cos;
    }

    /**
     * Define o valor da propriedade cos.
     * 
     * @param value
     *     allowed object is
     *     {@link CosInfo }
     *     
     */
    public void setCos(CosInfo value) {
        this.cos = value;
    }

    /**
     * Gets the value of the soapURL property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soapURL property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoapURL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSoapURL() {
        if (soapURL == null) {
            soapURL = new ArrayList<String>();
        }
        return this.soapURL;
    }

    /**
     * Obtém o valor da propriedade adminSoapURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdminSoapURL() {
        return adminSoapURL;
    }

    /**
     * Define o valor da propriedade adminSoapURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdminSoapURL(String value) {
        this.adminSoapURL = value;
    }

    /**
     * Obtém o valor da propriedade publicMailURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicMailURL() {
        return publicMailURL;
    }

    /**
     * Define o valor da propriedade publicMailURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicMailURL(String value) {
        this.publicMailURL = value;
    }

}
