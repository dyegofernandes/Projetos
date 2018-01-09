
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de searchRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="searchRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}mailSearchParams">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="warmup" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchRequest")
public class SearchRequest
    extends MailSearchParams
{

    @XmlAttribute(name = "warmup")
    protected Boolean warmup;

    /**
     * Obtém o valor da propriedade warmup.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWarmup() {
        return warmup;
    }

    /**
     * Define o valor da propriedade warmup.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWarmup(Boolean value) {
        this.warmup = value;
    }

}
