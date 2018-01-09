
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createFolderResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createFolderResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{urn:zimbraMail}folder"/>
 *           &lt;element ref="{urn:zimbraMail}link"/>
 *           &lt;element ref="{urn:zimbraMail}search"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createFolderResponse", propOrder = {
    "folder",
    "link",
    "search"
})
public class CreateFolderResponse {

    protected Folder folder;
    protected Mountpoint link;
    protected SearchFolder search;

    /**
     * Obtém o valor da propriedade folder.
     * 
     * @return
     *     possible object is
     *     {@link Folder }
     *     
     */
    public Folder getFolder() {
        return folder;
    }

    /**
     * Define o valor da propriedade folder.
     * 
     * @param value
     *     allowed object is
     *     {@link Folder }
     *     
     */
    public void setFolder(Folder value) {
        this.folder = value;
    }

    /**
     * Obtém o valor da propriedade link.
     * 
     * @return
     *     possible object is
     *     {@link Mountpoint }
     *     
     */
    public Mountpoint getLink() {
        return link;
    }

    /**
     * Define o valor da propriedade link.
     * 
     * @param value
     *     allowed object is
     *     {@link Mountpoint }
     *     
     */
    public void setLink(Mountpoint value) {
        this.link = value;
    }

    /**
     * Obtém o valor da propriedade search.
     * 
     * @return
     *     possible object is
     *     {@link SearchFolder }
     *     
     */
    public SearchFolder getSearch() {
        return search;
    }

    /**
     * Define o valor da propriedade search.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchFolder }
     *     
     */
    public void setSearch(SearchFolder value) {
        this.search = value;
    }

}
