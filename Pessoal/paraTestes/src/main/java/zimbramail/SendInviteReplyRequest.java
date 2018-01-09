
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de sendInviteReplyRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="sendInviteReplyRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exceptId" type="{urn:zimbraMail}dtTimeInfo" minOccurs="0"/>
 *         &lt;element name="tz" type="{urn:zimbraMail}calTZInfo" minOccurs="0"/>
 *         &lt;element name="m" type="{urn:zimbraMail}msg" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="compNum" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="verb" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="updateOrganizer" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="idnt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendInviteReplyRequest", propOrder = {
    "exceptId",
    "tz",
    "m"
})
public class SendInviteReplyRequest {

    protected DtTimeInfo exceptId;
    protected CalTZInfo tz;
    protected Msg m;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "compNum", required = true)
    protected int compNum;
    @XmlAttribute(name = "verb", required = true)
    protected String verb;
    @XmlAttribute(name = "updateOrganizer")
    protected Boolean updateOrganizer;
    @XmlAttribute(name = "idnt")
    protected String idnt;

    /**
     * Obtém o valor da propriedade exceptId.
     * 
     * @return
     *     possible object is
     *     {@link DtTimeInfo }
     *     
     */
    public DtTimeInfo getExceptId() {
        return exceptId;
    }

    /**
     * Define o valor da propriedade exceptId.
     * 
     * @param value
     *     allowed object is
     *     {@link DtTimeInfo }
     *     
     */
    public void setExceptId(DtTimeInfo value) {
        this.exceptId = value;
    }

    /**
     * Obtém o valor da propriedade tz.
     * 
     * @return
     *     possible object is
     *     {@link CalTZInfo }
     *     
     */
    public CalTZInfo getTz() {
        return tz;
    }

    /**
     * Define o valor da propriedade tz.
     * 
     * @param value
     *     allowed object is
     *     {@link CalTZInfo }
     *     
     */
    public void setTz(CalTZInfo value) {
        this.tz = value;
    }

    /**
     * Obtém o valor da propriedade m.
     * 
     * @return
     *     possible object is
     *     {@link Msg }
     *     
     */
    public Msg getM() {
        return m;
    }

    /**
     * Define o valor da propriedade m.
     * 
     * @param value
     *     allowed object is
     *     {@link Msg }
     *     
     */
    public void setM(Msg value) {
        this.m = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade compNum.
     * 
     */
    public int getCompNum() {
        return compNum;
    }

    /**
     * Define o valor da propriedade compNum.
     * 
     */
    public void setCompNum(int value) {
        this.compNum = value;
    }

    /**
     * Obtém o valor da propriedade verb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerb() {
        return verb;
    }

    /**
     * Define o valor da propriedade verb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerb(String value) {
        this.verb = value;
    }

    /**
     * Obtém o valor da propriedade updateOrganizer.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUpdateOrganizer() {
        return updateOrganizer;
    }

    /**
     * Define o valor da propriedade updateOrganizer.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUpdateOrganizer(Boolean value) {
        this.updateOrganizer = value;
    }

    /**
     * Obtém o valor da propriedade idnt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdnt() {
        return idnt;
    }

    /**
     * Define o valor da propriedade idnt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdnt(String value) {
        this.idnt = value;
    }

}
