
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getFolderRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getFolderRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="folder" type="{urn:zimbraMail}getFolderSpec" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="visible" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="needGranteeName" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="view" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="depth" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="tr" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFolderRequest", propOrder = {
    "folder"
})
public class GetFolderRequest {

    protected GetFolderSpec folder;
    @XmlAttribute(name = "visible")
    protected Boolean visible;
    @XmlAttribute(name = "needGranteeName")
    protected Boolean needGranteeName;
    @XmlAttribute(name = "view")
    protected String view;
    @XmlAttribute(name = "depth")
    protected Integer depth;
    @XmlAttribute(name = "tr")
    protected Boolean tr;

    /**
     * Obtém o valor da propriedade folder.
     * 
     * @return
     *     possible object is
     *     {@link GetFolderSpec }
     *     
     */
    public GetFolderSpec getFolder() {
        return folder;
    }

    /**
     * Define o valor da propriedade folder.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFolderSpec }
     *     
     */
    public void setFolder(GetFolderSpec value) {
        this.folder = value;
    }

    /**
     * Obtém o valor da propriedade visible.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVisible() {
        return visible;
    }

    /**
     * Define o valor da propriedade visible.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVisible(Boolean value) {
        this.visible = value;
    }

    /**
     * Obtém o valor da propriedade needGranteeName.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedGranteeName() {
        return needGranteeName;
    }

    /**
     * Define o valor da propriedade needGranteeName.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedGranteeName(Boolean value) {
        this.needGranteeName = value;
    }

    /**
     * Obtém o valor da propriedade view.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getView() {
        return view;
    }

    /**
     * Define o valor da propriedade view.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setView(String value) {
        this.view = value;
    }

    /**
     * Obtém o valor da propriedade depth.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDepth() {
        return depth;
    }

    /**
     * Define o valor da propriedade depth.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDepth(Integer value) {
        this.depth = value;
    }

    /**
     * Obtém o valor da propriedade tr.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTr() {
        return tr;
    }

    /**
     * Define o valor da propriedade tr.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTr(Boolean value) {
        this.tr = value;
    }

}
