
package zimbra;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de shareInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="shareInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="ownerId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ownerEmail" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ownerName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="folderId" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="folderUuid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="folderPath" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="view" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rights" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="granteeType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="granteeId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="granteeName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="granteeDisplayName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shareInfo")
public class ShareInfo {

    @XmlAttribute(name = "ownerId", required = true)
    protected String ownerId;
    @XmlAttribute(name = "ownerEmail", required = true)
    protected String ownerEmail;
    @XmlAttribute(name = "ownerName", required = true)
    protected String ownerName;
    @XmlAttribute(name = "folderId", required = true)
    protected int folderId;
    @XmlAttribute(name = "folderUuid", required = true)
    protected String folderUuid;
    @XmlAttribute(name = "folderPath", required = true)
    protected String folderPath;
    @XmlAttribute(name = "view", required = true)
    protected String view;
    @XmlAttribute(name = "rights", required = true)
    protected String rights;
    @XmlAttribute(name = "granteeType", required = true)
    protected String granteeType;
    @XmlAttribute(name = "granteeId", required = true)
    protected String granteeId;
    @XmlAttribute(name = "granteeName", required = true)
    protected String granteeName;
    @XmlAttribute(name = "granteeDisplayName", required = true)
    protected String granteeDisplayName;
    @XmlAttribute(name = "mid")
    protected String mid;

    /**
     * Obtém o valor da propriedade ownerId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Define o valor da propriedade ownerId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerId(String value) {
        this.ownerId = value;
    }

    /**
     * Obtém o valor da propriedade ownerEmail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerEmail() {
        return ownerEmail;
    }

    /**
     * Define o valor da propriedade ownerEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerEmail(String value) {
        this.ownerEmail = value;
    }

    /**
     * Obtém o valor da propriedade ownerName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Define o valor da propriedade ownerName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerName(String value) {
        this.ownerName = value;
    }

    /**
     * Obtém o valor da propriedade folderId.
     * 
     */
    public int getFolderId() {
        return folderId;
    }

    /**
     * Define o valor da propriedade folderId.
     * 
     */
    public void setFolderId(int value) {
        this.folderId = value;
    }

    /**
     * Obtém o valor da propriedade folderUuid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolderUuid() {
        return folderUuid;
    }

    /**
     * Define o valor da propriedade folderUuid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolderUuid(String value) {
        this.folderUuid = value;
    }

    /**
     * Obtém o valor da propriedade folderPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolderPath() {
        return folderPath;
    }

    /**
     * Define o valor da propriedade folderPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolderPath(String value) {
        this.folderPath = value;
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
     * Obtém o valor da propriedade rights.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRights() {
        return rights;
    }

    /**
     * Define o valor da propriedade rights.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRights(String value) {
        this.rights = value;
    }

    /**
     * Obtém o valor da propriedade granteeType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGranteeType() {
        return granteeType;
    }

    /**
     * Define o valor da propriedade granteeType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGranteeType(String value) {
        this.granteeType = value;
    }

    /**
     * Obtém o valor da propriedade granteeId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGranteeId() {
        return granteeId;
    }

    /**
     * Define o valor da propriedade granteeId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGranteeId(String value) {
        this.granteeId = value;
    }

    /**
     * Obtém o valor da propriedade granteeName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGranteeName() {
        return granteeName;
    }

    /**
     * Define o valor da propriedade granteeName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGranteeName(String value) {
        this.granteeName = value;
    }

    /**
     * Obtém o valor da propriedade granteeDisplayName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGranteeDisplayName() {
        return granteeDisplayName;
    }

    /**
     * Define o valor da propriedade granteeDisplayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGranteeDisplayName(String value) {
        this.granteeDisplayName = value;
    }

    /**
     * Obtém o valor da propriedade mid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMid() {
        return mid;
    }

    /**
     * Define o valor da propriedade mid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMid(String value) {
        this.mid = value;
    }

}
