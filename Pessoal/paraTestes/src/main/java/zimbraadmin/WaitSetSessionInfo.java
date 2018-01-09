
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de waitSetSessionInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="waitSetSessionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="interestMask" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="highestChangeId" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="lastAccessTime" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="creationTime" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="sessionId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="token" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "waitSetSessionInfo")
public class WaitSetSessionInfo {

    @XmlAttribute(name = "interestMask", required = true)
    protected String interestMask;
    @XmlAttribute(name = "highestChangeId", required = true)
    protected int highestChangeId;
    @XmlAttribute(name = "lastAccessTime", required = true)
    protected long lastAccessTime;
    @XmlAttribute(name = "creationTime", required = true)
    protected long creationTime;
    @XmlAttribute(name = "sessionId", required = true)
    protected String sessionId;
    @XmlAttribute(name = "token")
    protected String token;

    /**
     * Obtém o valor da propriedade interestMask.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterestMask() {
        return interestMask;
    }

    /**
     * Define o valor da propriedade interestMask.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterestMask(String value) {
        this.interestMask = value;
    }

    /**
     * Obtém o valor da propriedade highestChangeId.
     * 
     */
    public int getHighestChangeId() {
        return highestChangeId;
    }

    /**
     * Define o valor da propriedade highestChangeId.
     * 
     */
    public void setHighestChangeId(int value) {
        this.highestChangeId = value;
    }

    /**
     * Obtém o valor da propriedade lastAccessTime.
     * 
     */
    public long getLastAccessTime() {
        return lastAccessTime;
    }

    /**
     * Define o valor da propriedade lastAccessTime.
     * 
     */
    public void setLastAccessTime(long value) {
        this.lastAccessTime = value;
    }

    /**
     * Obtém o valor da propriedade creationTime.
     * 
     */
    public long getCreationTime() {
        return creationTime;
    }

    /**
     * Define o valor da propriedade creationTime.
     * 
     */
    public void setCreationTime(long value) {
        this.creationTime = value;
    }

    /**
     * Obtém o valor da propriedade sessionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Define o valor da propriedade sessionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

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

}
