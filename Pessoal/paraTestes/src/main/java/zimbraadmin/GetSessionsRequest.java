
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getSessionsRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getSessionsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sortBy" type="{urn:zimbraAdmin}getSessionsSortBy" />
 *       &lt;attribute name="offset" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="limit" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="refresh" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSessionsRequest")
public class GetSessionsRequest {

    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "sortBy")
    protected GetSessionsSortBy sortBy;
    @XmlAttribute(name = "offset")
    protected Long offset;
    @XmlAttribute(name = "limit")
    protected Long limit;
    @XmlAttribute(name = "refresh")
    protected Boolean refresh;

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade sortBy.
     * 
     * @return
     *     possible object is
     *     {@link GetSessionsSortBy }
     *     
     */
    public GetSessionsSortBy getSortBy() {
        return sortBy;
    }

    /**
     * Define o valor da propriedade sortBy.
     * 
     * @param value
     *     allowed object is
     *     {@link GetSessionsSortBy }
     *     
     */
    public void setSortBy(GetSessionsSortBy value) {
        this.sortBy = value;
    }

    /**
     * Obtém o valor da propriedade offset.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOffset() {
        return offset;
    }

    /**
     * Define o valor da propriedade offset.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOffset(Long value) {
        this.offset = value;
    }

    /**
     * Obtém o valor da propriedade limit.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLimit() {
        return limit;
    }

    /**
     * Define o valor da propriedade limit.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLimit(Long value) {
        this.limit = value;
    }

    /**
     * Obtém o valor da propriedade refresh.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRefresh() {
        return refresh;
    }

    /**
     * Define o valor da propriedade refresh.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRefresh(Boolean value) {
        this.refresh = value;
    }

}
