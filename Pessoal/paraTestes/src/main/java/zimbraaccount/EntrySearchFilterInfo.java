
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de entrySearchFilterInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="entrySearchFilterInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="conds" type="{urn:zimbraAccount}entrySearchFilterMultiCond"/>
 *           &lt;element name="cond" type="{urn:zimbraAccount}entrySearchFilterSingleCond"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entrySearchFilterInfo", propOrder = {
    "conds",
    "cond"
})
public class EntrySearchFilterInfo {

    protected EntrySearchFilterMultiCond conds;
    protected EntrySearchFilterSingleCond cond;

    /**
     * Obtém o valor da propriedade conds.
     * 
     * @return
     *     possible object is
     *     {@link EntrySearchFilterMultiCond }
     *     
     */
    public EntrySearchFilterMultiCond getConds() {
        return conds;
    }

    /**
     * Define o valor da propriedade conds.
     * 
     * @param value
     *     allowed object is
     *     {@link EntrySearchFilterMultiCond }
     *     
     */
    public void setConds(EntrySearchFilterMultiCond value) {
        this.conds = value;
    }

    /**
     * Obtém o valor da propriedade cond.
     * 
     * @return
     *     possible object is
     *     {@link EntrySearchFilterSingleCond }
     *     
     */
    public EntrySearchFilterSingleCond getCond() {
        return cond;
    }

    /**
     * Define o valor da propriedade cond.
     * 
     * @param value
     *     allowed object is
     *     {@link EntrySearchFilterSingleCond }
     *     
     */
    public void setCond(EntrySearchFilterSingleCond value) {
        this.cond = value;
    }

}
