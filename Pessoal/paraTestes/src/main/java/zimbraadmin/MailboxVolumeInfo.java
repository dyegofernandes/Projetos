
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de mailboxVolumeInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="mailboxVolumeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="rootpath" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mailboxVolumeInfo")
public class MailboxVolumeInfo {

    @XmlAttribute(name = "id", required = true)
    protected short id;
    @XmlAttribute(name = "type", required = true)
    protected short type;
    @XmlAttribute(name = "rootpath", required = true)
    protected String rootpath;

    /**
     * Obtém o valor da propriedade id.
     * 
     */
    public short getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     */
    public void setId(short value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     */
    public short getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     */
    public void setType(short value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade rootpath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRootpath() {
        return rootpath;
    }

    /**
     * Define o valor da propriedade rootpath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRootpath(String value) {
        this.rootpath = value;
    }

}
