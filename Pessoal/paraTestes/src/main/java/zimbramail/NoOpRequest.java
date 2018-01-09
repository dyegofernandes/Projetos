
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de noOpRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="noOpRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="wait" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="delegate" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="limitToOneBlocked" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="timeout" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "noOpRequest")
public class NoOpRequest {

    @XmlAttribute(name = "wait")
    protected Boolean wait;
    @XmlAttribute(name = "delegate")
    protected Boolean delegate;
    @XmlAttribute(name = "limitToOneBlocked")
    protected Boolean limitToOneBlocked;
    @XmlAttribute(name = "timeout")
    protected Long timeout;

    /**
     * Obtém o valor da propriedade wait.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWait() {
        return wait;
    }

    /**
     * Define o valor da propriedade wait.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWait(Boolean value) {
        this.wait = value;
    }

    /**
     * Obtém o valor da propriedade delegate.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDelegate() {
        return delegate;
    }

    /**
     * Define o valor da propriedade delegate.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDelegate(Boolean value) {
        this.delegate = value;
    }

    /**
     * Obtém o valor da propriedade limitToOneBlocked.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLimitToOneBlocked() {
        return limitToOneBlocked;
    }

    /**
     * Define o valor da propriedade limitToOneBlocked.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLimitToOneBlocked(Boolean value) {
        this.limitToOneBlocked = value;
    }

    /**
     * Obtém o valor da propriedade timeout.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTimeout() {
        return timeout;
    }

    /**
     * Define o valor da propriedade timeout.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTimeout(Long value) {
        this.timeout = value;
    }

}
