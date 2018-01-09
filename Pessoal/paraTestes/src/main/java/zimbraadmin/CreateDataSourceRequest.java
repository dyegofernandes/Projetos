
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createDataSourceRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createDataSourceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataSource" type="{urn:zimbraAdmin}dataSourceSpecifier"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createDataSourceRequest", propOrder = {
    "dataSource"
})
public class CreateDataSourceRequest {

    @XmlElement(required = true)
    protected DataSourceSpecifier dataSource;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * Obtém o valor da propriedade dataSource.
     * 
     * @return
     *     possible object is
     *     {@link DataSourceSpecifier }
     *     
     */
    public DataSourceSpecifier getDataSource() {
        return dataSource;
    }

    /**
     * Define o valor da propriedade dataSource.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSourceSpecifier }
     *     
     */
    public void setDataSource(DataSourceSpecifier value) {
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
