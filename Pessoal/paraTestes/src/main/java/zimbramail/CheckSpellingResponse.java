
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de checkSpellingResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="checkSpellingResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="misspelled" type="{urn:zimbraMail}misspelling" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="available" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkSpellingResponse", propOrder = {
    "misspelled"
})
public class CheckSpellingResponse {

    protected List<Misspelling> misspelled;
    @XmlAttribute(name = "available", required = true)
    protected boolean available;

    /**
     * Gets the value of the misspelled property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the misspelled property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMisspelled().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Misspelling }
     * 
     * 
     */
    public List<Misspelling> getMisspelled() {
        if (misspelled == null) {
            misspelled = new ArrayList<Misspelling>();
        }
        return this.misspelled;
    }

    /**
     * Obtém o valor da propriedade available.
     * 
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Define o valor da propriedade available.
     * 
     */
    public void setAvailable(boolean value) {
        this.available = value;
    }

}
