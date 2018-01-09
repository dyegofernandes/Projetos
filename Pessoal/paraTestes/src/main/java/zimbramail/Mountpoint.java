
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de mountpoint complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="mountpoint">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}folder">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="owner" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="zid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rid" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ruuid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="oname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="reminder" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="broken" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mountpoint")
public class Mountpoint
    extends Folder
{

    @XmlAttribute(name = "owner")
    protected String owner;
    @XmlAttribute(name = "zid")
    protected String zid;
    @XmlAttribute(name = "rid", required = true)
    protected int rid;
    @XmlAttribute(name = "ruuid")
    protected String ruuid;
    @XmlAttribute(name = "oname")
    protected String oname;
    @XmlAttribute(name = "reminder")
    protected Boolean reminder;
    @XmlAttribute(name = "broken")
    protected Boolean broken;

    /**
     * Obtém o valor da propriedade owner.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Define o valor da propriedade owner.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Obtém o valor da propriedade zid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZid() {
        return zid;
    }

    /**
     * Define o valor da propriedade zid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZid(String value) {
        this.zid = value;
    }

    /**
     * Obtém o valor da propriedade rid.
     * 
     */
    public int getRid() {
        return rid;
    }

    /**
     * Define o valor da propriedade rid.
     * 
     */
    public void setRid(int value) {
        this.rid = value;
    }

    /**
     * Obtém o valor da propriedade ruuid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuuid() {
        return ruuid;
    }

    /**
     * Define o valor da propriedade ruuid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuuid(String value) {
        this.ruuid = value;
    }

    /**
     * Obtém o valor da propriedade oname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOname() {
        return oname;
    }

    /**
     * Define o valor da propriedade oname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOname(String value) {
        this.oname = value;
    }

    /**
     * Obtém o valor da propriedade reminder.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReminder() {
        return reminder;
    }

    /**
     * Define o valor da propriedade reminder.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReminder(Boolean value) {
        this.reminder = value;
    }

    /**
     * Obtém o valor da propriedade broken.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBroken() {
        return broken;
    }

    /**
     * Define o valor da propriedade broken.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBroken(Boolean value) {
        this.broken = value;
    }

}
