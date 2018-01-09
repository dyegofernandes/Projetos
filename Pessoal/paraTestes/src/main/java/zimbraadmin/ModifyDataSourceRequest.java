
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de modifyDataSourceRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="modifyDataSourceRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraAdmin}adminAttrsImpl">
 *       &lt;sequence>
 *         &lt;element name="dataSource" type="{urn:zimbraAdmin}dataSourceInfo"/>
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
@XmlType(name = "modifyDataSourceRequest", propOrder = {
    "dataSource"
})
public class ModifyDataSourceRequest
    extends AdminAttrsImpl
{

    @XmlElement(required = true)
    protected DataSourceInfo dataSource;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * Obtém o valor da propriedade dataSource.
     * 
     * @return
     *     possible object is
     *     {@link DataSourceInfo }
     *     
     */
    public DataSourceInfo getDataSource() {
        return dataSource;
    }

    /**
     * Define o valor da propriedade dataSource.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSourceInfo }
     *     
     */
    public void setDataSource(DataSourceInfo value) {
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
