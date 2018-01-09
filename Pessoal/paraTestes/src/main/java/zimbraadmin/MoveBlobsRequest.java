
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de moveBlobsRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="moveBlobsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="query" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="types" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sourceVolumeIds" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="destVolumeId" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="maxBytes" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moveBlobsRequest", propOrder = {
    "query"
})
public class MoveBlobsRequest {

    protected String query;
    @XmlAttribute(name = "types", required = true)
    protected String types;
    @XmlAttribute(name = "sourceVolumeIds", required = true)
    protected String sourceVolumeIds;
    @XmlAttribute(name = "destVolumeId", required = true)
    protected short destVolumeId;
    @XmlAttribute(name = "maxBytes")
    protected Long maxBytes;

    /**
     * Obtém o valor da propriedade query.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuery() {
        return query;
    }

    /**
     * Define o valor da propriedade query.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuery(String value) {
        this.query = value;
    }

    /**
     * Obtém o valor da propriedade types.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypes() {
        return types;
    }

    /**
     * Define o valor da propriedade types.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypes(String value) {
        this.types = value;
    }

    /**
     * Obtém o valor da propriedade sourceVolumeIds.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceVolumeIds() {
        return sourceVolumeIds;
    }

    /**
     * Define o valor da propriedade sourceVolumeIds.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceVolumeIds(String value) {
        this.sourceVolumeIds = value;
    }

    /**
     * Obtém o valor da propriedade destVolumeId.
     * 
     */
    public short getDestVolumeId() {
        return destVolumeId;
    }

    /**
     * Define o valor da propriedade destVolumeId.
     * 
     */
    public void setDestVolumeId(short value) {
        this.destVolumeId = value;
    }

    /**
     * Obtém o valor da propriedade maxBytes.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxBytes() {
        return maxBytes;
    }

    /**
     * Define o valor da propriedade maxBytes.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxBytes(Long value) {
        this.maxBytes = value;
    }

}
