
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de mailboxInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="mailboxInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="groupId" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="accountId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="indexVolumeId" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="itemIdCheckPoint" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="contactCount" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="sizeCheckPoint" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="changeCheckPoint" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="trackingSync" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="trackingImap" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="lastbackupat" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="lastSoapAccess" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="newMessages" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mailboxInfo", propOrder = {

})
public class MailboxInfo {

    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "groupId", required = true)
    protected int groupId;
    @XmlAttribute(name = "accountId", required = true)
    protected String accountId;
    @XmlAttribute(name = "indexVolumeId", required = true)
    protected short indexVolumeId;
    @XmlAttribute(name = "itemIdCheckPoint", required = true)
    protected int itemIdCheckPoint;
    @XmlAttribute(name = "contactCount", required = true)
    protected int contactCount;
    @XmlAttribute(name = "sizeCheckPoint", required = true)
    protected long sizeCheckPoint;
    @XmlAttribute(name = "changeCheckPoint", required = true)
    protected int changeCheckPoint;
    @XmlAttribute(name = "trackingSync", required = true)
    protected int trackingSync;
    @XmlAttribute(name = "trackingImap", required = true)
    protected boolean trackingImap;
    @XmlAttribute(name = "lastbackupat")
    protected Integer lastbackupat;
    @XmlAttribute(name = "lastSoapAccess", required = true)
    protected int lastSoapAccess;
    @XmlAttribute(name = "newMessages", required = true)
    protected int newMessages;

    /**
     * Obtém o valor da propriedade id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade groupId.
     * 
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * Define o valor da propriedade groupId.
     * 
     */
    public void setGroupId(int value) {
        this.groupId = value;
    }

    /**
     * Obtém o valor da propriedade accountId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Define o valor da propriedade accountId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountId(String value) {
        this.accountId = value;
    }

    /**
     * Obtém o valor da propriedade indexVolumeId.
     * 
     */
    public short getIndexVolumeId() {
        return indexVolumeId;
    }

    /**
     * Define o valor da propriedade indexVolumeId.
     * 
     */
    public void setIndexVolumeId(short value) {
        this.indexVolumeId = value;
    }

    /**
     * Obtém o valor da propriedade itemIdCheckPoint.
     * 
     */
    public int getItemIdCheckPoint() {
        return itemIdCheckPoint;
    }

    /**
     * Define o valor da propriedade itemIdCheckPoint.
     * 
     */
    public void setItemIdCheckPoint(int value) {
        this.itemIdCheckPoint = value;
    }

    /**
     * Obtém o valor da propriedade contactCount.
     * 
     */
    public int getContactCount() {
        return contactCount;
    }

    /**
     * Define o valor da propriedade contactCount.
     * 
     */
    public void setContactCount(int value) {
        this.contactCount = value;
    }

    /**
     * Obtém o valor da propriedade sizeCheckPoint.
     * 
     */
    public long getSizeCheckPoint() {
        return sizeCheckPoint;
    }

    /**
     * Define o valor da propriedade sizeCheckPoint.
     * 
     */
    public void setSizeCheckPoint(long value) {
        this.sizeCheckPoint = value;
    }

    /**
     * Obtém o valor da propriedade changeCheckPoint.
     * 
     */
    public int getChangeCheckPoint() {
        return changeCheckPoint;
    }

    /**
     * Define o valor da propriedade changeCheckPoint.
     * 
     */
    public void setChangeCheckPoint(int value) {
        this.changeCheckPoint = value;
    }

    /**
     * Obtém o valor da propriedade trackingSync.
     * 
     */
    public int getTrackingSync() {
        return trackingSync;
    }

    /**
     * Define o valor da propriedade trackingSync.
     * 
     */
    public void setTrackingSync(int value) {
        this.trackingSync = value;
    }

    /**
     * Obtém o valor da propriedade trackingImap.
     * 
     */
    public boolean isTrackingImap() {
        return trackingImap;
    }

    /**
     * Define o valor da propriedade trackingImap.
     * 
     */
    public void setTrackingImap(boolean value) {
        this.trackingImap = value;
    }

    /**
     * Obtém o valor da propriedade lastbackupat.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLastbackupat() {
        return lastbackupat;
    }

    /**
     * Define o valor da propriedade lastbackupat.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLastbackupat(Integer value) {
        this.lastbackupat = value;
    }

    /**
     * Obtém o valor da propriedade lastSoapAccess.
     * 
     */
    public int getLastSoapAccess() {
        return lastSoapAccess;
    }

    /**
     * Define o valor da propriedade lastSoapAccess.
     * 
     */
    public void setLastSoapAccess(int value) {
        this.lastSoapAccess = value;
    }

    /**
     * Obtém o valor da propriedade newMessages.
     * 
     */
    public int getNewMessages() {
        return newMessages;
    }

    /**
     * Define o valor da propriedade newMessages.
     * 
     */
    public void setNewMessages(int value) {
        this.newMessages = value;
    }

}
