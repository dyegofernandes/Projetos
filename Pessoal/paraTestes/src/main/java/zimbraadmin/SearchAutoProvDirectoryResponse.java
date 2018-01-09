
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de searchAutoProvDirectoryResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="searchAutoProvDirectoryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="entry" type="{urn:zimbraAdmin}autoProvDirectoryEntry" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="more" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="searchTotal" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchAutoProvDirectoryResponse", propOrder = {
    "entry"
})
public class SearchAutoProvDirectoryResponse {

    protected List<AutoProvDirectoryEntry> entry;
    @XmlAttribute(name = "more", required = true)
    protected boolean more;
    @XmlAttribute(name = "searchTotal", required = true)
    protected int searchTotal;

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
     * {@link AutoProvDirectoryEntry }
     * 
     * 
     */
    public List<AutoProvDirectoryEntry> getEntry() {
        if (entry == null) {
            entry = new ArrayList<AutoProvDirectoryEntry>();
        }
        return this.entry;
    }

    /**
     * Obtém o valor da propriedade more.
     * 
     */
    public boolean isMore() {
        return more;
    }

    /**
     * Define o valor da propriedade more.
     * 
     */
    public void setMore(boolean value) {
        this.more = value;
    }

    /**
     * Obtém o valor da propriedade searchTotal.
     * 
     */
    public int getSearchTotal() {
        return searchTotal;
    }

    /**
     * Define o valor da propriedade searchTotal.
     * 
     */
    public void setSearchTotal(int value) {
        this.searchTotal = value;
    }

}
