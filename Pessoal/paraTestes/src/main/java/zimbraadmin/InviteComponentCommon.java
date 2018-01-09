
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de inviteComponentCommon complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="inviteComponentCommon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="method" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="compNum" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="rsvp" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="loc" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="percentComplete" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="completed" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="noBlob" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="fba" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fb" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="transp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isOrg" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="x_uid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="uid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="seq" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="d" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="calItemId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="apptId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ciFolder" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ex" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ridZ" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="allDay" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="draft" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="neverSent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="changes" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inviteComponentCommon")
@XmlSeeAlso({
    InviteComponent.class
})
public class InviteComponentCommon {

    @XmlAttribute(name = "method", required = true)
    protected String method;
    @XmlAttribute(name = "compNum", required = true)
    protected int compNum;
    @XmlAttribute(name = "rsvp", required = true)
    protected boolean rsvp;
    @XmlAttribute(name = "priority")
    protected String priority;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "loc")
    protected String loc;
    @XmlAttribute(name = "percentComplete")
    protected String percentComplete;
    @XmlAttribute(name = "completed")
    protected String completed;
    @XmlAttribute(name = "noBlob")
    protected Boolean noBlob;
    @XmlAttribute(name = "fba")
    protected String fba;
    @XmlAttribute(name = "fb")
    protected String fb;
    @XmlAttribute(name = "transp")
    protected String transp;
    @XmlAttribute(name = "isOrg")
    protected Boolean isOrg;
    @XmlAttribute(name = "x_uid")
    protected String xUid;
    @XmlAttribute(name = "uid")
    protected String uid;
    @XmlAttribute(name = "seq")
    protected Integer seq;
    @XmlAttribute(name = "d")
    protected Long d;
    @XmlAttribute(name = "calItemId")
    protected String calItemId;
    @XmlAttribute(name = "apptId")
    protected String apptId;
    @XmlAttribute(name = "ciFolder")
    protected String ciFolder;
    @XmlAttribute(name = "status")
    protected String status;
    @XmlAttribute(name = "class")
    protected String clazz;
    @XmlAttribute(name = "url")
    protected String url;
    @XmlAttribute(name = "ex")
    protected Boolean ex;
    @XmlAttribute(name = "ridZ")
    protected String ridZ;
    @XmlAttribute(name = "allDay")
    protected Boolean allDay;
    @XmlAttribute(name = "draft")
    protected Boolean draft;
    @XmlAttribute(name = "neverSent")
    protected Boolean neverSent;
    @XmlAttribute(name = "changes")
    protected String changes;

    /**
     * Obtém o valor da propriedade method.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethod() {
        return method;
    }

    /**
     * Define o valor da propriedade method.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethod(String value) {
        this.method = value;
    }

    /**
     * Obtém o valor da propriedade compNum.
     * 
     */
    public int getCompNum() {
        return compNum;
    }

    /**
     * Define o valor da propriedade compNum.
     * 
     */
    public void setCompNum(int value) {
        this.compNum = value;
    }

    /**
     * Obtém o valor da propriedade rsvp.
     * 
     */
    public boolean isRsvp() {
        return rsvp;
    }

    /**
     * Define o valor da propriedade rsvp.
     * 
     */
    public void setRsvp(boolean value) {
        this.rsvp = value;
    }

    /**
     * Obtém o valor da propriedade priority.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Define o valor da propriedade priority.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriority(String value) {
        this.priority = value;
    }

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade loc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoc() {
        return loc;
    }

    /**
     * Define o valor da propriedade loc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoc(String value) {
        this.loc = value;
    }

    /**
     * Obtém o valor da propriedade percentComplete.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPercentComplete() {
        return percentComplete;
    }

    /**
     * Define o valor da propriedade percentComplete.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPercentComplete(String value) {
        this.percentComplete = value;
    }

    /**
     * Obtém o valor da propriedade completed.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompleted() {
        return completed;
    }

    /**
     * Define o valor da propriedade completed.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompleted(String value) {
        this.completed = value;
    }

    /**
     * Obtém o valor da propriedade noBlob.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNoBlob() {
        return noBlob;
    }

    /**
     * Define o valor da propriedade noBlob.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNoBlob(Boolean value) {
        this.noBlob = value;
    }

    /**
     * Obtém o valor da propriedade fba.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFba() {
        return fba;
    }

    /**
     * Define o valor da propriedade fba.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFba(String value) {
        this.fba = value;
    }

    /**
     * Obtém o valor da propriedade fb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFb() {
        return fb;
    }

    /**
     * Define o valor da propriedade fb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFb(String value) {
        this.fb = value;
    }

    /**
     * Obtém o valor da propriedade transp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransp() {
        return transp;
    }

    /**
     * Define o valor da propriedade transp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransp(String value) {
        this.transp = value;
    }

    /**
     * Obtém o valor da propriedade isOrg.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOrg() {
        return isOrg;
    }

    /**
     * Define o valor da propriedade isOrg.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOrg(Boolean value) {
        this.isOrg = value;
    }

    /**
     * Obtém o valor da propriedade xUid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXUid() {
        return xUid;
    }

    /**
     * Define o valor da propriedade xUid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXUid(String value) {
        this.xUid = value;
    }

    /**
     * Obtém o valor da propriedade uid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * Define o valor da propriedade uid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
    }

    /**
     * Obtém o valor da propriedade seq.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * Define o valor da propriedade seq.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSeq(Integer value) {
        this.seq = value;
    }

    /**
     * Obtém o valor da propriedade d.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getD() {
        return d;
    }

    /**
     * Define o valor da propriedade d.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setD(Long value) {
        this.d = value;
    }

    /**
     * Obtém o valor da propriedade calItemId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalItemId() {
        return calItemId;
    }

    /**
     * Define o valor da propriedade calItemId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalItemId(String value) {
        this.calItemId = value;
    }

    /**
     * Obtém o valor da propriedade apptId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApptId() {
        return apptId;
    }

    /**
     * Define o valor da propriedade apptId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApptId(String value) {
        this.apptId = value;
    }

    /**
     * Obtém o valor da propriedade ciFolder.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiFolder() {
        return ciFolder;
    }

    /**
     * Define o valor da propriedade ciFolder.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiFolder(String value) {
        this.ciFolder = value;
    }

    /**
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade clazz.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Define o valor da propriedade clazz.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Obtém o valor da propriedade url.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Define o valor da propriedade url.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Obtém o valor da propriedade ex.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEx() {
        return ex;
    }

    /**
     * Define o valor da propriedade ex.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEx(Boolean value) {
        this.ex = value;
    }

    /**
     * Obtém o valor da propriedade ridZ.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRidZ() {
        return ridZ;
    }

    /**
     * Define o valor da propriedade ridZ.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRidZ(String value) {
        this.ridZ = value;
    }

    /**
     * Obtém o valor da propriedade allDay.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllDay() {
        return allDay;
    }

    /**
     * Define o valor da propriedade allDay.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllDay(Boolean value) {
        this.allDay = value;
    }

    /**
     * Obtém o valor da propriedade draft.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDraft() {
        return draft;
    }

    /**
     * Define o valor da propriedade draft.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDraft(Boolean value) {
        this.draft = value;
    }

    /**
     * Obtém o valor da propriedade neverSent.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeverSent() {
        return neverSent;
    }

    /**
     * Define o valor da propriedade neverSent.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeverSent(Boolean value) {
        this.neverSent = value;
    }

    /**
     * Obtém o valor da propriedade changes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChanges() {
        return changes;
    }

    /**
     * Define o valor da propriedade changes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChanges(String value) {
        this.changes = value;
    }

}
