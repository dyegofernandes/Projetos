
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de commonInstanceDataAttrs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="commonInstanceDataAttrs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="ptst" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ridZ" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tzo" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="fba" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="percentComplete" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="recur" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="hasEx" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fb" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="transp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="loc" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="otherAtt" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="alarm" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="isOrg" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="invId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="compNum" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="allDay" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="draft" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="neverSent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="dueDate" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="tzoDue" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "commonInstanceDataAttrs")
@XmlSeeAlso({
    LegacyInstanceDataAttrs.class,
    InstanceDataAttrs.class
})
public class CommonInstanceDataAttrs {

    @XmlAttribute(name = "ptst")
    protected String ptst;
    @XmlAttribute(name = "ridZ")
    protected String ridZ;
    @XmlAttribute(name = "tzo")
    protected Long tzo;
    @XmlAttribute(name = "fba")
    protected String fba;
    @XmlAttribute(name = "percentComplete")
    protected String percentComplete;
    @XmlAttribute(name = "recur")
    protected Boolean recur;
    @XmlAttribute(name = "hasEx")
    protected Boolean hasEx;
    @XmlAttribute(name = "priority")
    protected String priority;
    @XmlAttribute(name = "fb")
    protected String fb;
    @XmlAttribute(name = "transp")
    protected String transp;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "loc")
    protected String loc;
    @XmlAttribute(name = "otherAtt")
    protected Boolean otherAtt;
    @XmlAttribute(name = "alarm")
    protected Boolean alarm;
    @XmlAttribute(name = "isOrg")
    protected Boolean isOrg;
    @XmlAttribute(name = "invId")
    protected String invId;
    @XmlAttribute(name = "compNum")
    protected Integer compNum;
    @XmlAttribute(name = "status")
    protected String status;
    @XmlAttribute(name = "class")
    protected String clazz;
    @XmlAttribute(name = "allDay")
    protected Boolean allDay;
    @XmlAttribute(name = "draft")
    protected Boolean draft;
    @XmlAttribute(name = "neverSent")
    protected Boolean neverSent;
    @XmlAttribute(name = "dueDate")
    protected Long dueDate;
    @XmlAttribute(name = "tzoDue")
    protected Integer tzoDue;

    /**
     * Obtém o valor da propriedade ptst.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPtst() {
        return ptst;
    }

    /**
     * Define o valor da propriedade ptst.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPtst(String value) {
        this.ptst = value;
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
     * Obtém o valor da propriedade tzo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTzo() {
        return tzo;
    }

    /**
     * Define o valor da propriedade tzo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTzo(Long value) {
        this.tzo = value;
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
     * Obtém o valor da propriedade recur.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecur() {
        return recur;
    }

    /**
     * Define o valor da propriedade recur.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecur(Boolean value) {
        this.recur = value;
    }

    /**
     * Obtém o valor da propriedade hasEx.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasEx() {
        return hasEx;
    }

    /**
     * Define o valor da propriedade hasEx.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasEx(Boolean value) {
        this.hasEx = value;
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
     * Obtém o valor da propriedade otherAtt.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOtherAtt() {
        return otherAtt;
    }

    /**
     * Define o valor da propriedade otherAtt.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOtherAtt(Boolean value) {
        this.otherAtt = value;
    }

    /**
     * Obtém o valor da propriedade alarm.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAlarm() {
        return alarm;
    }

    /**
     * Define o valor da propriedade alarm.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAlarm(Boolean value) {
        this.alarm = value;
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
     * Obtém o valor da propriedade invId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvId() {
        return invId;
    }

    /**
     * Define o valor da propriedade invId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvId(String value) {
        this.invId = value;
    }

    /**
     * Obtém o valor da propriedade compNum.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCompNum() {
        return compNum;
    }

    /**
     * Define o valor da propriedade compNum.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCompNum(Integer value) {
        this.compNum = value;
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
     * Obtém o valor da propriedade dueDate.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDueDate() {
        return dueDate;
    }

    /**
     * Define o valor da propriedade dueDate.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDueDate(Long value) {
        this.dueDate = value;
    }

    /**
     * Obtém o valor da propriedade tzoDue.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTzoDue() {
        return tzoDue;
    }

    /**
     * Define o valor da propriedade tzoDue.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTzoDue(Integer value) {
        this.tzoDue = value;
    }

}
