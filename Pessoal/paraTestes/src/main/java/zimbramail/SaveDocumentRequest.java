
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de saveDocumentRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="saveDocumentRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="doc" type="{urn:zimbraMail}documentSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveDocumentRequest", propOrder = {
    "doc"
})
public class SaveDocumentRequest {

    @XmlElement(required = true)
    protected DocumentSpec doc;

    /**
     * Obtém o valor da propriedade doc.
     * 
     * @return
     *     possible object is
     *     {@link DocumentSpec }
     *     
     */
    public DocumentSpec getDoc() {
        return doc;
    }

    /**
     * Define o valor da propriedade doc.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentSpec }
     *     
     */
    public void setDoc(DocumentSpec value) {
        this.doc = value;
    }

}
