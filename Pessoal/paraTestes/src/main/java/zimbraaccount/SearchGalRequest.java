
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.CursorInfo;
import zimbra.GalSearchType;


/**
 * <p>Classe Java de searchGalRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="searchGalRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="locale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cursor" type="{urn:zimbra}cursorInfo" minOccurs="0"/>
 *         &lt;element name="searchFilter" type="{urn:zimbraAccount}entrySearchFilterInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{urn:zimbra}galSearchType" />
 *       &lt;attribute name="needExp" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="needIsOwner" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="needIsMember" type="{urn:zimbraAccount}memberOfSelector" />
 *       &lt;attribute name="needSMIMECerts" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="galAcctId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="quick" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="sortBy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="limit" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="offset" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchGalRequest", propOrder = {
    "locale",
    "cursor",
    "searchFilter"
})
public class SearchGalRequest {

    protected String locale;
    protected CursorInfo cursor;
    protected EntrySearchFilterInfo searchFilter;
    @XmlAttribute(name = "ref")
    protected String ref;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "type")
    protected GalSearchType type;
    @XmlAttribute(name = "needExp")
    protected Boolean needExp;
    @XmlAttribute(name = "needIsOwner")
    protected Boolean needIsOwner;
    @XmlAttribute(name = "needIsMember")
    protected MemberOfSelector needIsMember;
    @XmlAttribute(name = "needSMIMECerts")
    protected Boolean needSMIMECerts;
    @XmlAttribute(name = "galAcctId")
    protected String galAcctId;
    @XmlAttribute(name = "quick")
    protected Boolean quick;
    @XmlAttribute(name = "sortBy")
    protected String sortBy;
    @XmlAttribute(name = "limit")
    protected Integer limit;
    @XmlAttribute(name = "offset")
    protected Integer offset;

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
     * Obtém o valor da propriedade ref.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRef() {
        return ref;
    }

    /**
     * Define o valor da propriedade ref.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRef(String value) {
        this.ref = value;
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
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link GalSearchType }
     *     
     */
    public GalSearchType getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link GalSearchType }
     *     
     */
    public void setType(GalSearchType value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade needExp.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedExp() {
        return needExp;
    }

    /**
     * Define o valor da propriedade needExp.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedExp(Boolean value) {
        this.needExp = value;
    }

    /**
     * Obtém o valor da propriedade needIsOwner.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedIsOwner() {
        return needIsOwner;
    }

    /**
     * Define o valor da propriedade needIsOwner.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedIsOwner(Boolean value) {
        this.needIsOwner = value;
    }

    /**
     * Obtém o valor da propriedade needIsMember.
     * 
     * @return
     *     possible object is
     *     {@link MemberOfSelector }
     *     
     */
    public MemberOfSelector getNeedIsMember() {
        return needIsMember;
    }

    /**
     * Define o valor da propriedade needIsMember.
     * 
     * @param value
     *     allowed object is
     *     {@link MemberOfSelector }
     *     
     */
    public void setNeedIsMember(MemberOfSelector value) {
        this.needIsMember = value;
    }

    /**
     * Obtém o valor da propriedade needSMIMECerts.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedSMIMECerts() {
        return needSMIMECerts;
    }

    /**
     * Define o valor da propriedade needSMIMECerts.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedSMIMECerts(Boolean value) {
        this.needSMIMECerts = value;
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

}
