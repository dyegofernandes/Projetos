
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de messageHitInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="messageHitInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}messageInfo">
 *       &lt;sequence>
 *         &lt;element name="hp" type="{urn:zimbraMail}part" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="sf" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cm" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageHitInfo", propOrder = {
    "hp"
})
@XmlSeeAlso({
    ChatHitInfo.class
})
public class MessageHitInfo
    extends MessageInfo
{

    protected List<Part> hp;
    @XmlAttribute(name = "sf")
    protected String sf;
    @XmlAttribute(name = "cm")
    protected Boolean cm;

    /**
     * Gets the value of the hp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Part }
     * 
     * 
     */
    public List<Part> getHp() {
        if (hp == null) {
            hp = new ArrayList<Part>();
        }
        return this.hp;
    }

    /**
     * Obtém o valor da propriedade sf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSf() {
        return sf;
    }

    /**
     * Define o valor da propriedade sf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSf(String value) {
        this.sf = value;
    }

    /**
     * Obtém o valor da propriedade cm.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCm() {
        return cm;
    }

    /**
     * Define o valor da propriedade cm.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCm(Boolean value) {
        this.cm = value;
    }

}
