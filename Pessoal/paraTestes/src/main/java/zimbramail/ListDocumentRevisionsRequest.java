
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de listDocumentRevisionsRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="listDocumentRevisionsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="doc" type="{urn:zimbraMail}listDocumentRevisionsSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listDocumentRevisionsRequest", propOrder = {
    "doc"
})
public class ListDocumentRevisionsRequest {

    @XmlElement(required = true)
    protected ListDocumentRevisionsSpec doc;

    /**
     * Obtém o valor da propriedade doc.
     * 
     * @return
     *     possible object is
     *     {@link ListDocumentRevisionsSpec }
     *     
     */
    public ListDocumentRevisionsSpec getDoc() {
        return doc;
    }

    /**
     * Define o valor da propriedade doc.
     * 
     * @param value
     *     allowed object is
     *     {@link ListDocumentRevisionsSpec }
     *     
     */
    public void setDoc(ListDocumentRevisionsSpec value) {
        this.doc = value;
    }

}
