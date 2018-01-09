
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de sendSecureMsgRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="sendSecureMsgRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}sendMsgRequest">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="sign" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="encrypt" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="certId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendSecureMsgRequest")
public class SendSecureMsgRequest
    extends SendMsgRequest
{

    @XmlAttribute(name = "sign")
    protected Boolean sign;
    @XmlAttribute(name = "encrypt")
    protected Boolean encrypt;
    @XmlAttribute(name = "certId")
    protected String certId;

    /**
     * Obtém o valor da propriedade sign.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSign() {
        return sign;
    }

    /**
     * Define o valor da propriedade sign.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSign(Boolean value) {
        this.sign = value;
    }

    /**
     * Obtém o valor da propriedade encrypt.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEncrypt() {
        return encrypt;
    }

    /**
     * Define o valor da propriedade encrypt.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEncrypt(Boolean value) {
        this.encrypt = value;
    }

    /**
     * Obtém o valor da propriedade certId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertId() {
        return certId;
    }

    /**
     * Define o valor da propriedade certId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertId(String value) {
        this.certId = value;
    }

}
