
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de diffDocumentRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="diffDocumentRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="doc" type="{urn:zimbraMail}diffDocumentVersionSpec" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diffDocumentRequest", propOrder = {
    "doc"
})
public class DiffDocumentRequest {

    protected DiffDocumentVersionSpec doc;

    /**
     * Obtém o valor da propriedade doc.
     * 
     * @return
     *     possible object is
     *     {@link DiffDocumentVersionSpec }
     *     
     */
    public DiffDocumentVersionSpec getDoc() {
        return doc;
    }

    /**
     * Define o valor da propriedade doc.
     * 
     * @param value
     *     allowed object is
     *     {@link DiffDocumentVersionSpec }
     *     
     */
    public void setDoc(DiffDocumentVersionSpec value) {
        this.doc = value;
    }

}
