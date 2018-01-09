
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de searchDirectoryResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="searchDirectoryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="calresource" type="{urn:zimbraAdmin}calendarResourceInfo"/>
 *           &lt;element name="dl" type="{urn:zimbraAdmin}distributionListInfo"/>
 *           &lt;element name="alias" type="{urn:zimbraAdmin}aliasInfo"/>
 *           &lt;element name="account" type="{urn:zimbraAdmin}accountInfo"/>
 *           &lt;element name="domain" type="{urn:zimbraAdmin}domainInfo"/>
 *           &lt;element name="cos" type="{urn:zimbraAdmin}cosInfo"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="num" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="more" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="searchTotal" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchDirectoryResponse", propOrder = {
    "calresourceOrDlOrAlias"
})
public class SearchDirectoryResponse {

    @XmlElements({
        @XmlElement(name = "calresource", type = CalendarResourceInfo.class),
        @XmlElement(name = "dl", type = DistributionListInfo.class),
        @XmlElement(name = "alias", type = AliasInfo.class),
        @XmlElement(name = "account", type = AccountInfo.class),
        @XmlElement(name = "domain", type = DomainInfo.class),
        @XmlElement(name = "cos", type = CosInfo.class)
    })
    protected List<Object> calresourceOrDlOrAlias;
    @XmlAttribute(name = "num")
    protected Long num;
    @XmlAttribute(name = "more")
    protected Boolean more;
    @XmlAttribute(name = "searchTotal")
    protected Long searchTotal;

    /**
     * Gets the value of the calresourceOrDlOrAlias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the calresourceOrDlOrAlias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCalresourceOrDlOrAlias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalendarResourceInfo }
     * {@link DistributionListInfo }
     * {@link AliasInfo }
     * {@link AccountInfo }
     * {@link DomainInfo }
     * {@link CosInfo }
     * 
     * 
     */
    public List<Object> getCalresourceOrDlOrAlias() {
        if (calresourceOrDlOrAlias == null) {
            calresourceOrDlOrAlias = new ArrayList<Object>();
        }
        return this.calresourceOrDlOrAlias;
    }

    /**
     * Obtém o valor da propriedade num.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNum() {
        return num;
    }

    /**
     * Define o valor da propriedade num.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNum(Long value) {
        this.num = value;
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
     * Obtém o valor da propriedade searchTotal.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSearchTotal() {
        return searchTotal;
    }

    /**
     * Define o valor da propriedade searchTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSearchTotal(Long value) {
        this.searchTotal = value;
    }

}
