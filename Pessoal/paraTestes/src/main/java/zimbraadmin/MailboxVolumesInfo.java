
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de mailboxVolumesInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="mailboxVolumesInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="volume" type="{urn:zimbraAdmin}mailboxVolumeInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="mbxid" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="token" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mailboxVolumesInfo", propOrder = {
    "volume"
})
public class MailboxVolumesInfo {

    protected List<MailboxVolumeInfo> volume;
    @XmlAttribute(name = "mbxid", required = true)
    protected int mbxid;
    @XmlAttribute(name = "token", required = true)
    protected int token;

    /**
     * Gets the value of the volume property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the volume property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVolume().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MailboxVolumeInfo }
     * 
     * 
     */
    public List<MailboxVolumeInfo> getVolume() {
        if (volume == null) {
            volume = new ArrayList<MailboxVolumeInfo>();
        }
        return this.volume;
    }

    /**
     * Obtém o valor da propriedade mbxid.
     * 
     */
    public int getMbxid() {
        return mbxid;
    }

    /**
     * Define o valor da propriedade mbxid.
     * 
     */
    public void setMbxid(int value) {
        this.mbxid = value;
    }

    /**
     * Obtém o valor da propriedade token.
     * 
     */
    public int getToken() {
        return token;
    }

    /**
     * Define o valor da propriedade token.
     * 
     */
    public void setToken(int value) {
        this.token = value;
    }

}
