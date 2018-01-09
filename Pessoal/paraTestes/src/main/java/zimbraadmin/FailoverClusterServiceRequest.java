
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de failoverClusterServiceRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="failoverClusterServiceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="service" type="{urn:zimbraAdmin}failoverClusterServiceSpec" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "failoverClusterServiceRequest", propOrder = {
    "service"
})
public class FailoverClusterServiceRequest {

    protected FailoverClusterServiceSpec service;

    /**
     * Obtém o valor da propriedade service.
     * 
     * @return
     *     possible object is
     *     {@link FailoverClusterServiceSpec }
     *     
     */
    public FailoverClusterServiceSpec getService() {
        return service;
    }

    /**
     * Define o valor da propriedade service.
     * 
     * @param value
     *     allowed object is
     *     {@link FailoverClusterServiceSpec }
     *     
     */
    public void setService(FailoverClusterServiceSpec value) {
        this.service = value;
    }

}
