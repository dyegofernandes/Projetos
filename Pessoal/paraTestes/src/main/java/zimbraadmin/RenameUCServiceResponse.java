
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de renameUCServiceResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="renameUCServiceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:zimbraAdmin}ucservice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "renameUCServiceResponse", propOrder = {
    "ucservice"
})
public class RenameUCServiceResponse {

    protected UcServiceInfo ucservice;

    /**
     * Obtém o valor da propriedade ucservice.
     * 
     * @return
     *     possible object is
     *     {@link UcServiceInfo }
     *     
     */
    public UcServiceInfo getUcservice() {
        return ucservice;
    }

    /**
     * Define o valor da propriedade ucservice.
     * 
     * @param value
     *     allowed object is
     *     {@link UcServiceInfo }
     *     
     */
    public void setUcservice(UcServiceInfo value) {
        this.ucservice = value;
    }

}
