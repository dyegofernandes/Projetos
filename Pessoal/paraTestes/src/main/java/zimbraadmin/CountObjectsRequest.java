
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de countObjectsRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="countObjectsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="domain" type="{urn:zimbraAdmin}domainSelector" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ucservice" type="{urn:zimbraAdmin}ucServiceSelector" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{urn:zimbraAdmin}countObjectsType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "countObjectsRequest", propOrder = {
    "domain",
    "ucservice"
})
public class CountObjectsRequest {

    protected List<DomainSelector> domain;
    protected UcServiceSelector ucservice;
    @XmlAttribute(name = "type", required = true)
    protected CountObjectsType type;

    /**
     * Gets the value of the domain property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the domain property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDomain().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DomainSelector }
     * 
     * 
     */
    public List<DomainSelector> getDomain() {
        if (domain == null) {
            domain = new ArrayList<DomainSelector>();
        }
        return this.domain;
    }

    /**
     * Obtém o valor da propriedade ucservice.
     * 
     * @return
     *     possible object is
     *     {@link UcServiceSelector }
     *     
     */
    public UcServiceSelector getUcservice() {
        return ucservice;
    }

    /**
     * Define o valor da propriedade ucservice.
     * 
     * @param value
     *     allowed object is
     *     {@link UcServiceSelector }
     *     
     */
    public void setUcservice(UcServiceSelector value) {
        this.ucservice = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link CountObjectsType }
     *     
     */
    public CountObjectsType getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link CountObjectsType }
     *     
     */
    public void setType(CountObjectsType value) {
        this.type = value;
    }

}
