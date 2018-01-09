
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createDataSourceResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createDataSourceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataSource" type="{urn:zimbraAdmin}dataSourceInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createDataSourceResponse", propOrder = {
    "dataSource"
})
public class CreateDataSourceResponse {

    @XmlElement(required = true)
    protected DataSourceInfo dataSource;

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

}
