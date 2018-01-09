
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createSearchFolderRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createSearchFolderRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="search" type="{urn:zimbraMail}newSearchFolderSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createSearchFolderRequest", propOrder = {
    "search"
})
public class CreateSearchFolderRequest {

    @XmlElement(required = true)
    protected NewSearchFolderSpec search;

    /**
     * Obtém o valor da propriedade search.
     * 
     * @return
     *     possible object is
     *     {@link NewSearchFolderSpec }
     *     
     */
    public NewSearchFolderSpec getSearch() {
        return search;
    }

    /**
     * Define o valor da propriedade search.
     * 
     * @param value
     *     allowed object is
     *     {@link NewSearchFolderSpec }
     *     
     */
    public void setSearch(NewSearchFolderSpec value) {
        this.search = value;
    }

}
