
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de msgToSend complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="msgToSend">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}msg">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="did" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sfd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="dsId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "msgToSend")
public class MsgToSend
    extends Msg
{

    @XmlAttribute(name = "did")
    protected String did;
    @XmlAttribute(name = "sfd")
    protected Boolean sfd;
    @XmlAttribute(name = "dsId")
    protected String dsId;

    /**
     * Obtém o valor da propriedade did.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDid() {
        return did;
    }

    /**
     * Define o valor da propriedade did.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDid(String value) {
        this.did = value;
    }

    /**
     * Obtém o valor da propriedade sfd.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSfd() {
        return sfd;
    }

    /**
     * Define o valor da propriedade sfd.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSfd(Boolean value) {
        this.sfd = value;
    }

    /**
     * Obtém o valor da propriedade dsId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsId() {
        return dsId;
    }

    /**
     * Define o valor da propriedade dsId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsId(String value) {
        this.dsId = value;
    }

}
