
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de exceptionRuleInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="exceptionRuleInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraAdmin}recurIdInfo">
 *       &lt;sequence>
 *         &lt;element name="add" type="{urn:zimbraAdmin}recurrenceInfo" minOccurs="0"/>
 *         &lt;element name="exclude" type="{urn:zimbraAdmin}recurrenceInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exceptionRuleInfo", propOrder = {
    "add",
    "exclude"
})
public class ExceptionRuleInfo
    extends RecurIdInfo
{

    protected RecurrenceInfo add;
    protected RecurrenceInfo exclude;

    /**
     * Obtém o valor da propriedade add.
     * 
     * @return
     *     possible object is
     *     {@link RecurrenceInfo }
     *     
     */
    public RecurrenceInfo getAdd() {
        return add;
    }

    /**
     * Define o valor da propriedade add.
     * 
     * @param value
     *     allowed object is
     *     {@link RecurrenceInfo }
     *     
     */
    public void setAdd(RecurrenceInfo value) {
        this.add = value;
    }

    /**
     * Obtém o valor da propriedade exclude.
     * 
     * @return
     *     possible object is
     *     {@link RecurrenceInfo }
     *     
     */
    public RecurrenceInfo getExclude() {
        return exclude;
    }

    /**
     * Define o valor da propriedade exclude.
     * 
     * @param value
     *     allowed object is
     *     {@link RecurrenceInfo }
     *     
     */
    public void setExclude(RecurrenceInfo value) {
        this.exclude = value;
    }

}
