
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import zimbra.NamedElement;


/**
 * <p>Classe Java de fixCalendarTZRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="fixCalendarTZRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="account" type="{urn:zimbra}namedElement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tzfixup" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="fixupRule" type="{urn:zimbraAdmin}tzFixupRule" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="sync" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="after" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fixCalendarTZRequest", propOrder = {
    "account",
    "tzfixup"
})
public class FixCalendarTZRequest {

    protected List<NamedElement> account;
    protected FixCalendarTZRequest.Tzfixup tzfixup;
    @XmlAttribute(name = "sync")
    protected Boolean sync;
    @XmlAttribute(name = "after")
    protected Long after;

    /**
     * Gets the value of the account property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the account property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NamedElement }
     * 
     * 
     */
    public List<NamedElement> getAccount() {
        if (account == null) {
            account = new ArrayList<NamedElement>();
        }
        return this.account;
    }

    /**
     * Obtém o valor da propriedade tzfixup.
     * 
     * @return
     *     possible object is
     *     {@link FixCalendarTZRequest.Tzfixup }
     *     
     */
    public FixCalendarTZRequest.Tzfixup getTzfixup() {
        return tzfixup;
    }

    /**
     * Define o valor da propriedade tzfixup.
     * 
     * @param value
     *     allowed object is
     *     {@link FixCalendarTZRequest.Tzfixup }
     *     
     */
    public void setTzfixup(FixCalendarTZRequest.Tzfixup value) {
        this.tzfixup = value;
    }

    /**
     * Obtém o valor da propriedade sync.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSync() {
        return sync;
    }

    /**
     * Define o valor da propriedade sync.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSync(Boolean value) {
        this.sync = value;
    }

    /**
     * Obtém o valor da propriedade after.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAfter() {
        return after;
    }

    /**
     * Define o valor da propriedade after.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAfter(Long value) {
        this.after = value;
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
     *         &lt;element name="fixupRule" type="{urn:zimbraAdmin}tzFixupRule" maxOccurs="unbounded" minOccurs="0"/>
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
        "fixupRule"
    })
    public static class Tzfixup {

        protected List<TzFixupRule> fixupRule;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the fixupRule property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the fixupRule property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFixupRule().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TzFixupRule }
         * 
         * 
         */
        public List<TzFixupRule> getFixupRule() {
            if (fixupRule == null) {
                fixupRule = new ArrayList<TzFixupRule>();
            }
            return this.fixupRule;
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
