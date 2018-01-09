
package zimbravoice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de voiceInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="voiceInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="folder" type="{urn:zimbraVoice}rootVoiceFolder"/>
 *         &lt;element name="callfeatures" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="callfeature" type="{urn:zimbraVoice}callFeature" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="label" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="callable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="editable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="c2cDeviceId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="vm" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="used" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="limit" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voiceInfo", propOrder = {
    "folder",
    "callfeatures"
})
public class VoiceInfo {

    @XmlElement(required = true)
    protected RootVoiceFolder folder;
    protected VoiceInfo.Callfeatures callfeatures;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "label", required = true)
    protected String label;
    @XmlAttribute(name = "callable", required = true)
    protected boolean callable;
    @XmlAttribute(name = "editable", required = true)
    protected boolean editable;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "c2cDeviceId")
    protected String c2CDeviceId;
    @XmlAttribute(name = "vm", required = true)
    protected boolean vm;
    @XmlAttribute(name = "used")
    protected Long used;
    @XmlAttribute(name = "limit")
    protected Long limit;

    /**
     * Obtém o valor da propriedade folder.
     * 
     * @return
     *     possible object is
     *     {@link RootVoiceFolder }
     *     
     */
    public RootVoiceFolder getFolder() {
        return folder;
    }

    /**
     * Define o valor da propriedade folder.
     * 
     * @param value
     *     allowed object is
     *     {@link RootVoiceFolder }
     *     
     */
    public void setFolder(RootVoiceFolder value) {
        this.folder = value;
    }

    /**
     * Obtém o valor da propriedade callfeatures.
     * 
     * @return
     *     possible object is
     *     {@link VoiceInfo.Callfeatures }
     *     
     */
    public VoiceInfo.Callfeatures getCallfeatures() {
        return callfeatures;
    }

    /**
     * Define o valor da propriedade callfeatures.
     * 
     * @param value
     *     allowed object is
     *     {@link VoiceInfo.Callfeatures }
     *     
     */
    public void setCallfeatures(VoiceInfo.Callfeatures value) {
        this.callfeatures = value;
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
     * Obtém o valor da propriedade label.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Define o valor da propriedade label.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Obtém o valor da propriedade callable.
     * 
     */
    public boolean isCallable() {
        return callable;
    }

    /**
     * Define o valor da propriedade callable.
     * 
     */
    public void setCallable(boolean value) {
        this.callable = value;
    }

    /**
     * Obtém o valor da propriedade editable.
     * 
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * Define o valor da propriedade editable.
     * 
     */
    public void setEditable(boolean value) {
        this.editable = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade c2CDeviceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getC2CDeviceId() {
        return c2CDeviceId;
    }

    /**
     * Define o valor da propriedade c2CDeviceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setC2CDeviceId(String value) {
        this.c2CDeviceId = value;
    }

    /**
     * Obtém o valor da propriedade vm.
     * 
     */
    public boolean isVm() {
        return vm;
    }

    /**
     * Define o valor da propriedade vm.
     * 
     */
    public void setVm(boolean value) {
        this.vm = value;
    }

    /**
     * Obtém o valor da propriedade used.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUsed() {
        return used;
    }

    /**
     * Define o valor da propriedade used.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUsed(Long value) {
        this.used = value;
    }

    /**
     * Obtém o valor da propriedade limit.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLimit() {
        return limit;
    }

    /**
     * Define o valor da propriedade limit.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLimit(Long value) {
        this.limit = value;
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
     *         &lt;element name="callfeature" type="{urn:zimbraVoice}callFeature" maxOccurs="unbounded" minOccurs="0"/>
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
        "callfeature"
    })
    public static class Callfeatures {

        protected List<CallFeature> callfeature;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the callfeature property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the callfeature property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCallfeature().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CallFeature }
         * 
         * 
         */
        public List<CallFeature> getCallfeature() {
            if (callfeature == null) {
                callfeature = new ArrayList<CallFeature>();
            }
            return this.callfeature;
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
