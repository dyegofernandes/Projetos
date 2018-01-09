
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de searchConvRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="searchConvRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}mailSearchParams">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="cid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nest" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchConvRequest")
public class SearchConvRequest
    extends MailSearchParams
{

    @XmlAttribute(name = "cid", required = true)
    protected String cid;
    @XmlAttribute(name = "nest")
    protected Boolean nest;

    /**
     * Obtém o valor da propriedade cid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCid() {
        return cid;
    }

    /**
     * Define o valor da propriedade cid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCid(String value) {
        this.cid = value;
    }

    /**
     * Obtém o valor da propriedade nest.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNest() {
        return nest;
    }

    /**
     * Define o valor da propriedade nest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNest(Boolean value) {
        this.nest = value;
    }

}
