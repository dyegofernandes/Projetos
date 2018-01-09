
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de checkHealthResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="checkHealthResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="healthy" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkHealthResponse", propOrder = {

})
public class CheckHealthResponse {

    @XmlAttribute(name = "healthy", required = true)
    protected boolean healthy;

    /**
     * Obtém o valor da propriedade healthy.
     * 
     */
    public boolean isHealthy() {
        return healthy;
    }

    /**
     * Define o valor da propriedade healthy.
     * 
     */
    public void setHealthy(boolean value) {
        this.healthy = value;
    }

}
