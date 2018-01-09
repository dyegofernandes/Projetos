
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getDomainResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getDomainResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="domain" type="{urn:zimbraAdmin}domainInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDomainResponse", propOrder = {
    "domain"
})
public class GetDomainResponse {

    protected DomainInfo domain;

    /**
     * Obtém o valor da propriedade domain.
     * 
     * @return
     *     possible object is
     *     {@link DomainInfo }
     *     
     */
    public DomainInfo getDomain() {
        return domain;
    }

    /**
     * Define o valor da propriedade domain.
     * 
     * @param value
     *     allowed object is
     *     {@link DomainInfo }
     *     
     */
    public void setDomain(DomainInfo value) {
        this.domain = value;
    }

}
