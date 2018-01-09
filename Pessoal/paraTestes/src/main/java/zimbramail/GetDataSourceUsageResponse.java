
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getDataSourceUsageResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getDataSourceUsageResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataSourceUsage" type="{urn:zimbraMail}dataSourceUsage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dsQuota" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="dsTotalQuota" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDataSourceUsageResponse", propOrder = {
    "dataSourceUsage",
    "dsQuota",
    "dsTotalQuota"
})
public class GetDataSourceUsageResponse {

    protected List<DataSourceUsage> dataSourceUsage;
    protected long dsQuota;
    protected long dsTotalQuota;

    /**
     * Gets the value of the dataSourceUsage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataSourceUsage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataSourceUsage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataSourceUsage }
     * 
     * 
     */
    public List<DataSourceUsage> getDataSourceUsage() {
        if (dataSourceUsage == null) {
            dataSourceUsage = new ArrayList<DataSourceUsage>();
        }
        return this.dataSourceUsage;
    }

    /**
     * Obtém o valor da propriedade dsQuota.
     * 
     */
    public long getDsQuota() {
        return dsQuota;
    }

    /**
     * Define o valor da propriedade dsQuota.
     * 
     */
    public void setDsQuota(long value) {
        this.dsQuota = value;
    }

    /**
     * Obtém o valor da propriedade dsTotalQuota.
     * 
     */
    public long getDsTotalQuota() {
        return dsTotalQuota;
    }

    /**
     * Define o valor da propriedade dsTotalQuota.
     * 
     */
    public void setDsTotalQuota(long value) {
        this.dsTotalQuota = value;
    }

}
