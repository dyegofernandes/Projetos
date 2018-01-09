
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import zimbra.NamedElement;


/**
 * <p>Classe Java de rightsEntriesInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="rightsEntriesInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="entry" type="{urn:zimbra}namedElement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rights" type="{urn:zimbraAdmin}effectiveRightsInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rightsEntriesInfo", propOrder = {
    "entry",
    "rights"
})
public class RightsEntriesInfo {

    protected List<NamedElement> entry;
    @XmlElement(required = true)
    protected EffectiveRightsInfo rights;

    /**
     * Gets the value of the entry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NamedElement }
     * 
     * 
     */
    public List<NamedElement> getEntry() {
        if (entry == null) {
            entry = new ArrayList<NamedElement>();
        }
        return this.entry;
    }

    /**
     * Obtém o valor da propriedade rights.
     * 
     * @return
     *     possible object is
     *     {@link EffectiveRightsInfo }
     *     
     */
    public EffectiveRightsInfo getRights() {
        return rights;
    }

    /**
     * Define o valor da propriedade rights.
     * 
     * @param value
     *     allowed object is
     *     {@link EffectiveRightsInfo }
     *     
     */
    public void setRights(EffectiveRightsInfo value) {
        this.rights = value;
    }

}