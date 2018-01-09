
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de nestedRule complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="nestedRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="filterTests" type="{urn:zimbraMail}filterTests"/>
 *         &lt;element name="filterActions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                     &lt;element name="actionKeep" type="{urn:zimbraMail}keepAction"/>
 *                     &lt;element name="actionDiscard" type="{urn:zimbraMail}discardAction"/>
 *                     &lt;element name="actionFileInto" type="{urn:zimbraMail}fileIntoAction"/>
 *                     &lt;element name="actionFlag" type="{urn:zimbraMail}flagAction"/>
 *                     &lt;element name="actionTag" type="{urn:zimbraMail}tagAction"/>
 *                     &lt;element name="actionRedirect" type="{urn:zimbraMail}redirectAction"/>
 *                     &lt;element name="actionReply" type="{urn:zimbraMail}replyAction"/>
 *                     &lt;element name="actionNotify" type="{urn:zimbraMail}notifyAction"/>
 *                     &lt;element name="actionStop" type="{urn:zimbraMail}stopAction"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="nestedRule" type="{urn:zimbraMail}nestedRule" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nestedRule", propOrder = {
    "filterTests",
    "filterActions",
    "nestedRule"
})
public class NestedRule {

    @XmlElement(required = true)
    protected FilterTests filterTests;
    protected NestedRule.FilterActions filterActions;
    protected NestedRule nestedRule;

    /**
     * Obtém o valor da propriedade filterTests.
     * 
     * @return
     *     possible object is
     *     {@link FilterTests }
     *     
     */
    public FilterTests getFilterTests() {
        return filterTests;
    }

    /**
     * Define o valor da propriedade filterTests.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterTests }
     *     
     */
    public void setFilterTests(FilterTests value) {
        this.filterTests = value;
    }

    /**
     * Obtém o valor da propriedade filterActions.
     * 
     * @return
     *     possible object is
     *     {@link NestedRule.FilterActions }
     *     
     */
    public NestedRule.FilterActions getFilterActions() {
        return filterActions;
    }

    /**
     * Define o valor da propriedade filterActions.
     * 
     * @param value
     *     allowed object is
     *     {@link NestedRule.FilterActions }
     *     
     */
    public void setFilterActions(NestedRule.FilterActions value) {
        this.filterActions = value;
    }

    /**
     * Obtém o valor da propriedade nestedRule.
     * 
     * @return
     *     possible object is
     *     {@link NestedRule }
     *     
     */
    public NestedRule getNestedRule() {
        return nestedRule;
    }

    /**
     * Define o valor da propriedade nestedRule.
     * 
     * @param value
     *     allowed object is
     *     {@link NestedRule }
     *     
     */
    public void setNestedRule(NestedRule value) {
        this.nestedRule = value;
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
     *         &lt;choice maxOccurs="unbounded" minOccurs="0">
     *           &lt;element name="actionKeep" type="{urn:zimbraMail}keepAction"/>
     *           &lt;element name="actionDiscard" type="{urn:zimbraMail}discardAction"/>
     *           &lt;element name="actionFileInto" type="{urn:zimbraMail}fileIntoAction"/>
     *           &lt;element name="actionFlag" type="{urn:zimbraMail}flagAction"/>
     *           &lt;element name="actionTag" type="{urn:zimbraMail}tagAction"/>
     *           &lt;element name="actionRedirect" type="{urn:zimbraMail}redirectAction"/>
     *           &lt;element name="actionReply" type="{urn:zimbraMail}replyAction"/>
     *           &lt;element name="actionNotify" type="{urn:zimbraMail}notifyAction"/>
     *           &lt;element name="actionStop" type="{urn:zimbraMail}stopAction"/>
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
    @XmlType(name = "", propOrder = {
        "actionKeepOrActionDiscardOrActionFileInto"
    })
    public static class FilterActions {

        @XmlElements({
            @XmlElement(name = "actionKeep", type = KeepAction.class),
            @XmlElement(name = "actionDiscard", type = DiscardAction.class),
            @XmlElement(name = "actionFileInto", type = FileIntoAction.class),
            @XmlElement(name = "actionFlag", type = FlagAction.class),
            @XmlElement(name = "actionTag", type = TagAction.class),
            @XmlElement(name = "actionRedirect", type = RedirectAction.class),
            @XmlElement(name = "actionReply", type = ReplyAction.class),
            @XmlElement(name = "actionNotify", type = NotifyAction.class),
            @XmlElement(name = "actionStop", type = StopAction.class)
        })
        protected List<FilterAction> actionKeepOrActionDiscardOrActionFileInto;

        /**
         * Gets the value of the actionKeepOrActionDiscardOrActionFileInto property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the actionKeepOrActionDiscardOrActionFileInto property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getActionKeepOrActionDiscardOrActionFileInto().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link KeepAction }
         * {@link DiscardAction }
         * {@link FileIntoAction }
         * {@link FlagAction }
         * {@link TagAction }
         * {@link RedirectAction }
         * {@link ReplyAction }
         * {@link NotifyAction }
         * {@link StopAction }
         * 
         * 
         */
        public List<FilterAction> getActionKeepOrActionDiscardOrActionFileInto() {
            if (actionKeepOrActionDiscardOrActionFileInto == null) {
                actionKeepOrActionDiscardOrActionFileInto = new ArrayList<FilterAction>();
            }
            return this.actionKeepOrActionDiscardOrActionFileInto;
        }

    }

}
