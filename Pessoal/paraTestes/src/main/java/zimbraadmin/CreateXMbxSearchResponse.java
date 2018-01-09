
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createXMbxSearchResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createXMbxSearchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchtask" type="{urn:zimbraAdmin}searchNode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createXMbxSearchResponse", propOrder = {
    "searchtask"
})
public class CreateXMbxSearchResponse {

    @XmlElement(required = true)
    protected SearchNode searchtask;

    /**
     * Obtém o valor da propriedade searchtask.
     * 
     * @return
     *     possible object is
     *     {@link SearchNode }
     *     
     */
    public SearchNode getSearchtask() {
        return searchtask;
    }

    /**
     * Define o valor da propriedade searchtask.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchNode }
     *     
     */
    public void setSearchtask(SearchNode value) {
        this.searchtask = value;
    }

}
