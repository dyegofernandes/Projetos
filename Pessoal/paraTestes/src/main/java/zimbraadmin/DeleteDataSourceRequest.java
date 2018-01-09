
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import zimbra.Id;


/**
 * <p>Classe Java de deleteDataSourceRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="deleteDataSourceRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraAdmin}adminAttrsImpl">
 *       &lt;sequence>
 *         &lt;element name="dataSource" type="{urn:zimbra}id"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteDataSourceRequest", propOrder = {
    "dataSource"
})
public class DeleteDataSourceRequest
    extends AdminAttrsImpl
{

    @XmlElement(required = true)
    protected Id dataSource;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * Obtém o valor da propriedade dataSource.
     * 
     * @return
     *     possible object is
     *     {@link Id }
     *     
     */
    public Id getDataSource() {
        return dataSource;
    }

    /**
     * Define o valor da propriedade dataSource.
     * 
     * @param value
     *     allowed object is
     *     {@link Id }
     *     
     */
    public void setDataSource(Id value) {
        this.dataSource = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
