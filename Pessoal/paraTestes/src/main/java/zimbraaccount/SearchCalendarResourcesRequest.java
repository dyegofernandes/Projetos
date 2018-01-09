
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.AttributeSelectorImpl;
import zimbra.CursorInfo;


/**
 * <p>Classe Java de searchCalendarResourcesRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="searchCalendarResourcesRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbra}attributeSelectorImpl">
 *       &lt;sequence>
 *         &lt;element name="locale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cursor" type="{urn:zimbra}cursorInfo" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="searchFilter" type="{urn:zimbraAccount}entrySearchFilterInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="quick" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="sortBy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="limit" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="offset" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="galAcctId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchCalendarResourcesRequest", propOrder = {
    "locale",
    "cursor",
    "name",
    "searchFilter"
})
public class SearchCalendarResourcesRequest
    extends AttributeSelectorImpl
{

    protected String locale;
    protected CursorInfo cursor;
    protected String name;
    protected EntrySearchFilterInfo searchFilter;
    @XmlAttribute(name = "quick")
    protected Boolean quick;
    @XmlAttribute(name = "sortBy")
    protected String sortBy;
    @XmlAttribute(name = "limit")
    protected Integer limit;
    @XmlAttribute(name = "offset")
    protected Integer offset;
    @XmlAttribute(name = "galAcctId")
    protected String galAcctId;

    /**
     * Obtém o valor da propriedade locale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Define o valor da propriedade locale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocale(String value) {
        this.locale = value;
    }

    /**
     * Obtém o valor da propriedade cursor.
     * 
     * @return
     *     possible object is
     *     {@link CursorInfo }
     *     
     */
    public CursorInfo getCursor() {
        return cursor;
    }

    /**
     * Define o valor da propriedade cursor.
     * 
     * @param value
     *     allowed object is
     *     {@link CursorInfo }
     *     
     */
    public void setCursor(CursorInfo value) {
        this.cursor = value;
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
     * Obtém o valor da propriedade searchFilter.
     * 
     * @return
     *     possible object is
     *     {@link EntrySearchFilterInfo }
     *     
     */
    public EntrySearchFilterInfo getSearchFilter() {
        return searchFilter;
    }

    /**
     * Define o valor da propriedade searchFilter.
     * 
     * @param value
     *     allowed object is
     *     {@link EntrySearchFilterInfo }
     *     
     */
    public void setSearchFilter(EntrySearchFilterInfo value) {
        this.searchFilter = value;
    }

    /**
     * Obtém o valor da propriedade quick.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isQuick() {
        return quick;
    }

    /**
     * Define o valor da propriedade quick.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setQuick(Boolean value) {
        this.quick = value;
    }

    /**
     * Obtém o valor da propriedade sortBy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortBy() {
        return sortBy;
    }

    /**
     * Define o valor da propriedade sortBy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortBy(String value) {
        this.sortBy = value;
    }

    /**
     * Obtém o valor da propriedade limit.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Define o valor da propriedade limit.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLimit(Integer value) {
        this.limit = value;
    }

    /**
     * Obtém o valor da propriedade offset.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Define o valor da propriedade offset.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOffset(Integer value) {
        this.offset = value;
    }

    /**
     * Obtém o valor da propriedade galAcctId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGalAcctId() {
        return galAcctId;
    }

    /**
     * Define o valor da propriedade galAcctId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGalAcctId(String value) {
        this.galAcctId = value;
    }

}
