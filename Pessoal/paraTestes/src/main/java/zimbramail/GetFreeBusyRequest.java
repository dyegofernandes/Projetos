
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getFreeBusyRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getFreeBusyRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usr" type="{urn:zimbraMail}freeBusyUserSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="s" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="e" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="uid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="excludeUid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFreeBusyRequest", propOrder = {
    "usr"
})
public class GetFreeBusyRequest {

    protected List<FreeBusyUserSpec> usr;
    @XmlAttribute(name = "s", required = true)
    protected long s;
    @XmlAttribute(name = "e", required = true)
    protected long e;
    @XmlAttribute(name = "uid")
    protected String uid;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "excludeUid")
    protected String excludeUid;

    /**
     * Gets the value of the usr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FreeBusyUserSpec }
     * 
     * 
     */
    public List<FreeBusyUserSpec> getUsr() {
        if (usr == null) {
            usr = new ArrayList<FreeBusyUserSpec>();
        }
        return this.usr;
    }

    /**
     * Obtém o valor da propriedade s.
     * 
     */
    public long getS() {
        return s;
    }

    /**
     * Define o valor da propriedade s.
     * 
     */
    public void setS(long value) {
        this.s = value;
    }

    /**
     * Obtém o valor da propriedade e.
     * 
     */
    public long getE() {
        return e;
    }

    /**
     * Define o valor da propriedade e.
     * 
     */
    public void setE(long value) {
        this.e = value;
    }

    /**
     * Obtém o valor da propriedade uid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * Define o valor da propriedade uid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

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
     * Obtém o valor da propriedade excludeUid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExcludeUid() {
        return excludeUid;
    }

    /**
     * Define o valor da propriedade excludeUid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExcludeUid(String value) {
        this.excludeUid = value;
    }

}
