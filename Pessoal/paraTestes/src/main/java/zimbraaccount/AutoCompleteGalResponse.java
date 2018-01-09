
package zimbraaccount;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de autoCompleteGalResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="autoCompleteGalResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cn" type="{urn:zimbraAccount}contactInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="more" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="tokenizeKey" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="paginationSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autoCompleteGalResponse", propOrder = {
    "cn"
})
public class AutoCompleteGalResponse {

    protected List<ContactInfo> cn;
    @XmlAttribute(name = "more")
    protected Boolean more;
    @XmlAttribute(name = "tokenizeKey")
    protected Boolean tokenizeKey;
    @XmlAttribute(name = "paginationSupported")
    protected Boolean paginationSupported;

    /**
     * Gets the value of the cn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactInfo }
     * 
     * 
     */
    public List<ContactInfo> getCn() {
        if (cn == null) {
            cn = new ArrayList<ContactInfo>();
        }
        return this.cn;
    }

    /**
     * Obtém o valor da propriedade more.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMore() {
        return more;
    }

    /**
     * Define o valor da propriedade more.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMore(Boolean value) {
        this.more = value;
    }

    /**
     * Obtém o valor da propriedade tokenizeKey.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTokenizeKey() {
        return tokenizeKey;
    }

    /**
     * Define o valor da propriedade tokenizeKey.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTokenizeKey(Boolean value) {
        this.tokenizeKey = value;
    }

    /**
     * Obtém o valor da propriedade paginationSupported.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPaginationSupported() {
        return paginationSupported;
    }

    /**
     * Define o valor da propriedade paginationSupported.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPaginationSupported(Boolean value) {
        this.paginationSupported = value;
    }

}
