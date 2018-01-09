
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de syncRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="syncRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="token" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="calCutoff" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="msgCutoff" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="l" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="typed" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="deleteLimit" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="changeLimit" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "syncRequest")
public class SyncRequest {

    @XmlAttribute(name = "token")
    protected String token;
    @XmlAttribute(name = "calCutoff")
    protected Long calCutoff;
    @XmlAttribute(name = "msgCutoff")
    protected Integer msgCutoff;
    @XmlAttribute(name = "l")
    protected String l;
    @XmlAttribute(name = "typed")
    protected Boolean typed;
    @XmlAttribute(name = "deleteLimit", required = true)
    protected int deleteLimit;
    @XmlAttribute(name = "changeLimit", required = true)
    protected int changeLimit;

    /**
     * Obtém o valor da propriedade token.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Define o valor da propriedade token.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Obtém o valor da propriedade calCutoff.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCalCutoff() {
        return calCutoff;
    }

    /**
     * Define o valor da propriedade calCutoff.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCalCutoff(Long value) {
        this.calCutoff = value;
    }

    /**
     * Obtém o valor da propriedade msgCutoff.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMsgCutoff() {
        return msgCutoff;
    }

    /**
     * Define o valor da propriedade msgCutoff.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMsgCutoff(Integer value) {
        this.msgCutoff = value;
    }

    /**
     * Obtém o valor da propriedade l.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getL() {
        return l;
    }

    /**
     * Define o valor da propriedade l.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setL(String value) {
        this.l = value;
    }

    /**
     * Obtém o valor da propriedade typed.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTyped() {
        return typed;
    }

    /**
     * Define o valor da propriedade typed.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTyped(Boolean value) {
        this.typed = value;
    }

    /**
     * Obtém o valor da propriedade deleteLimit.
     * 
     */
    public int getDeleteLimit() {
        return deleteLimit;
    }

    /**
     * Define o valor da propriedade deleteLimit.
     * 
     */
    public void setDeleteLimit(int value) {
        this.deleteLimit = value;
    }

    /**
     * Obtém o valor da propriedade changeLimit.
     * 
     */
    public int getChangeLimit() {
        return changeLimit;
    }

    /**
     * Define o valor da propriedade changeLimit.
     * 
     */
    public void setChangeLimit(int value) {
        this.changeLimit = value;
    }

}
