
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de queryWaitSetResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="queryWaitSetResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="waitSet" type="{urn:zimbraAdmin}waitSetInfo" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "queryWaitSetResponse", propOrder = {
    "waitSet"
})
public class QueryWaitSetResponse {

    protected List<WaitSetInfo> waitSet;
    @XmlAttribute(name = "unusedCodeGenHelper")
    protected String unusedCodeGenHelper;

    /**
     * Gets the value of the waitSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the waitSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWaitSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WaitSetInfo }
     * 
     * 
     */
    public List<WaitSetInfo> getWaitSet() {
        if (waitSet == null) {
            waitSet = new ArrayList<WaitSetInfo>();
        }
        return this.waitSet;
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