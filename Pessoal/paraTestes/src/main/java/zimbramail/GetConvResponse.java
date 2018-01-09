
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getConvResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getConvResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="c" type="{urn:zimbraMail}conversationInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getConvResponse", propOrder = {
    "c"
})
public class GetConvResponse {

    @XmlElement(required = true)
    protected ConversationInfo c;

    /**
     * Obtém o valor da propriedade c.
     * 
     * @return
     *     possible object is
     *     {@link ConversationInfo }
     *     
     */
    public ConversationInfo getC() {
        return c;
    }

    /**
     * Define o valor da propriedade c.
     * 
     * @param value
     *     allowed object is
     *     {@link ConversationInfo }
     *     
     */
    public void setC(ConversationInfo value) {
        this.c = value;
    }

}
