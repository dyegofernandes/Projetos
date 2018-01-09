
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.IdAndType;


/**
 * <p>Classe Java de waitSetInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="waitSetInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="session" type="{urn:zimbraAdmin}sessionForWaitSet" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="errors" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="error" type="{urn:zimbra}idAndType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ready" type="{urn:zimbraAdmin}accountsAttrib" minOccurs="0"/>
 *         &lt;element name="buffered" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="commit" type="{urn:zimbraAdmin}bufferedCommitInfo" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="owner" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="defTypes" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ld" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="cbSeqNo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="currentSeqNo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nextSeqNo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "waitSetInfo", propOrder = {
    "session",
    "errors",
    "ready",
    "buffered"
})
public class WaitSetInfo {

    protected List<SessionForWaitSet> session;
    protected WaitSetInfo.Errors errors;
    protected AccountsAttrib ready;
    protected WaitSetInfo.Buffered buffered;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "owner", required = true)
    protected String owner;
    @XmlAttribute(name = "defTypes", required = true)
    protected String defTypes;
    @XmlAttribute(name = "ld", required = true)
    protected long ld;
    @XmlAttribute(name = "cbSeqNo")
    protected String cbSeqNo;
    @XmlAttribute(name = "currentSeqNo")
    protected String currentSeqNo;
    @XmlAttribute(name = "nextSeqNo")
    protected String nextSeqNo;

    /**
     * Gets the value of the session property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the session property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSession().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SessionForWaitSet }
     * 
     * 
     */
    public List<SessionForWaitSet> getSession() {
        if (session == null) {
            session = new ArrayList<SessionForWaitSet>();
        }
        return this.session;
    }

    /**
     * Obtém o valor da propriedade errors.
     * 
     * @return
     *     possible object is
     *     {@link WaitSetInfo.Errors }
     *     
     */
    public WaitSetInfo.Errors getErrors() {
        return errors;
    }

    /**
     * Define o valor da propriedade errors.
     * 
     * @param value
     *     allowed object is
     *     {@link WaitSetInfo.Errors }
     *     
     */
    public void setErrors(WaitSetInfo.Errors value) {
        this.errors = value;
    }

    /**
     * Obtém o valor da propriedade ready.
     * 
     * @return
     *     possible object is
     *     {@link AccountsAttrib }
     *     
     */
    public AccountsAttrib getReady() {
        return ready;
    }

    /**
     * Define o valor da propriedade ready.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountsAttrib }
     *     
     */
    public void setReady(AccountsAttrib value) {
        this.ready = value;
    }

    /**
     * Obtém o valor da propriedade buffered.
     * 
     * @return
     *     possible object is
     *     {@link WaitSetInfo.Buffered }
     *     
     */
    public WaitSetInfo.Buffered getBuffered() {
        return buffered;
    }

    /**
     * Define o valor da propriedade buffered.
     * 
     * @param value
     *     allowed object is
     *     {@link WaitSetInfo.Buffered }
     *     
     */
    public void setBuffered(WaitSetInfo.Buffered value) {
        this.buffered = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade owner.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Define o valor da propriedade owner.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Obtém o valor da propriedade defTypes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefTypes() {
        return defTypes;
    }

    /**
     * Define o valor da propriedade defTypes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefTypes(String value) {
        this.defTypes = value;
    }

    /**
     * Obtém o valor da propriedade ld.
     * 
     */
    public long getLd() {
        return ld;
    }

    /**
     * Define o valor da propriedade ld.
     * 
     */
    public void setLd(long value) {
        this.ld = value;
    }

    /**
     * Obtém o valor da propriedade cbSeqNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCbSeqNo() {
        return cbSeqNo;
    }

    /**
     * Define o valor da propriedade cbSeqNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCbSeqNo(String value) {
        this.cbSeqNo = value;
    }

    /**
     * Obtém o valor da propriedade currentSeqNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentSeqNo() {
        return currentSeqNo;
    }

    /**
     * Define o valor da propriedade currentSeqNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentSeqNo(String value) {
        this.currentSeqNo = value;
    }

    /**
     * Obtém o valor da propriedade nextSeqNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextSeqNo() {
        return nextSeqNo;
    }

    /**
     * Define o valor da propriedade nextSeqNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextSeqNo(String value) {
        this.nextSeqNo = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="commit" type="{urn:zimbraAdmin}bufferedCommitInfo" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "commit"
    })
    public static class Buffered {

        protected List<BufferedCommitInfo> commit;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the commit property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the commit property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCommit().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BufferedCommitInfo }
         * 
         * 
         */
        public List<BufferedCommitInfo> getCommit() {
            if (commit == null) {
                commit = new ArrayList<BufferedCommitInfo>();
            }
            return this.commit;
        }

        /**
         * Obtém o valor da propriedade unusedCodeGenHelper.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnusedCodeGenHelper() {
            return unusedCodeGenHelper;
        }

        /**
         * Define o valor da propriedade unusedCodeGenHelper.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnusedCodeGenHelper(String value) {
            this.unusedCodeGenHelper = value;
        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="error" type="{urn:zimbra}idAndType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "error"
    })
    public static class Errors {

        protected List<IdAndType> error;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the error property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the error property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getError().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IdAndType }
         * 
         * 
         */
        public List<IdAndType> getError() {
            if (error == null) {
                error = new ArrayList<IdAndType>();
            }
            return this.error;
        }

        /**
         * Obtém o valor da propriedade unusedCodeGenHelper.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnusedCodeGenHelper() {
            return unusedCodeGenHelper;
        }

        /**
         * Define o valor da propriedade unusedCodeGenHelper.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnusedCodeGenHelper(String value) {
            this.unusedCodeGenHelper = value;
        }

    }

}
