
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de idsAttr complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="idsAttr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="ids" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "idsAttr")
@XmlSeeAlso({
    ContactIdsAttr.class,
    ConvIdsAttr.class,
    DocIdsAttr.class,
    WikiIdsAttr.class,
    TagIdsAttr.class,
    MsgIdsAttr.class,
    ChatIdsAttr.class,
    SearchFolderIdsAttr.class,
    FolderIdsAttr.class,
    ApptIdsAttr.class,
    TaskIdsAttr.class,
    NoteIdsAttr.class,
    MountIdsAttr.class
})
public class IdsAttr {

    @XmlAttribute(name = "ids", required = true)
    protected String ids;

    /**
     * Obtém o valor da propriedade ids.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIds() {
        return ids;
    }

    /**
     * Define o valor da propriedade ids.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIds(String value) {
        this.ids = value;
    }

}
