
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de saveDocumentResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="saveDocumentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="doc" type="{urn:zimbraMail}idVersionName" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveDocumentResponse", propOrder = {
    "doc"
})
public class SaveDocumentResponse {

    protected IdVersionName doc;

    /**
     * Obtém o valor da propriedade doc.
     * 
     * @return
     *     possible object is
     *     {@link IdVersionName }
     *     
     */
    public IdVersionName getDoc() {
        return doc;
    }

    /**
     * Define o valor da propriedade doc.
     * 
     * @param value
     *     allowed object is
     *     {@link IdVersionName }
     *     
     */
    public void setDoc(IdVersionName value) {
        this.doc = value;
    }

}
