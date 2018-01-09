
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createNoteResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createNoteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="note" type="{urn:zimbraMail}noteInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createNoteResponse", propOrder = {
    "note"
})
public class CreateNoteResponse {

    protected NoteInfo note;

    /**
     * Obtém o valor da propriedade note.
     * 
     * @return
     *     possible object is
     *     {@link NoteInfo }
     *     
     */
    public NoteInfo getNote() {
        return note;
    }

    /**
     * Define o valor da propriedade note.
     * 
     * @param value
     *     allowed object is
     *     {@link NoteInfo }
     *     
     */
    public void setNote(NoteInfo value) {
        this.note = value;
    }

}
