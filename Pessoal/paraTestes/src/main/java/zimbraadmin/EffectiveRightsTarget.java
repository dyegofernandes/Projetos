
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.TargetType;


/**
 * <p>Classe Java de effectiveRightsTarget complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="effectiveRightsTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="all" type="{urn:zimbraAdmin}effectiveRightsInfo" minOccurs="0"/>
 *         &lt;element name="inDomains" type="{urn:zimbraAdmin}inDomainInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="entries" type="{urn:zimbraAdmin}rightsEntriesInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{urn:zimbra}targetType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "effectiveRightsTarget", propOrder = {
    "all",
    "inDomains",
    "entries"
})
public class EffectiveRightsTarget {

    protected EffectiveRightsInfo all;
    protected List<InDomainInfo> inDomains;
    protected List<RightsEntriesInfo> entries;
    @XmlAttribute(name = "type", required = true)
    protected TargetType type;

    /**
     * Obtém o valor da propriedade all.
     * 
     * @return
     *     possible object is
     *     {@link EffectiveRightsInfo }
     *     
     */
    public EffectiveRightsInfo getAll() {
        return all;
    }

    /**
     * Define o valor da propriedade all.
     * 
     * @param value
     *     allowed object is
     *     {@link EffectiveRightsInfo }
     *     
     */
    public void setAll(EffectiveRightsInfo value) {
        this.all = value;
    }

    /**
     * Gets the value of the inDomains property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inDomains property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInDomains().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InDomainInfo }
     * 
     * 
     */
    public List<InDomainInfo> getInDomains() {
        if (inDomains == null) {
            inDomains = new ArrayList<InDomainInfo>();
        }
        return this.inDomains;
    }

    /**
     * Gets the value of the entries property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entries property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntries().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RightsEntriesInfo }
     * 
     * 
     */
    public List<RightsEntriesInfo> getEntries() {
        if (entries == null) {
            entries = new ArrayList<RightsEntriesInfo>();
        }
        return this.entries;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link TargetType }
     *     
     */
    public TargetType getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetType }
     *     
     */
    public void setType(TargetType value) {
        this.type = value;
    }

}
