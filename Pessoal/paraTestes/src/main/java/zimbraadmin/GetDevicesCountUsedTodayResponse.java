
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getDevicesCountUsedTodayResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getDevicesCountUsedTodayResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="count" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDevicesCountUsedTodayResponse")
public class GetDevicesCountUsedTodayResponse {

    @XmlAttribute(name = "count", required = true)
    protected int count;

    /**
     * Obtém o valor da propriedade count.
     * 
     */
    public int getCount() {
        return count;
    }

    /**
     * Define o valor da propriedade count.
     * 
     */
    public void setCount(int value) {
        this.count = value;
    }

}
