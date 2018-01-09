
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de dumpSessionsResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dumpSessionsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="soap" type="{urn:zimbraAdmin}infoForSessionType" minOccurs="0"/>
 *         &lt;element name="imap" type="{urn:zimbraAdmin}infoForSessionType" minOccurs="0"/>
 *         &lt;element name="admin" type="{urn:zimbraAdmin}infoForSessionType" minOccurs="0"/>
 *         &lt;element name="wiki" type="{urn:zimbraAdmin}infoForSessionType" minOccurs="0"/>
 *         &lt;element name="synclistener" type="{urn:zimbraAdmin}infoForSessionType" minOccurs="0"/>
 *         &lt;element name="waitset" type="{urn:zimbraAdmin}infoForSessionType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="activeSessions" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dumpSessionsResponse", propOrder = {
    "soap",
    "imap",
    "admin",
    "wiki",
    "synclistener",
    "waitset"
})
public class DumpSessionsResponse {

    protected InfoForSessionType soap;
    protected InfoForSessionType imap;
    protected InfoForSessionType admin;
    protected InfoForSessionType wiki;
    protected InfoForSessionType synclistener;
    protected InfoForSessionType waitset;
    @XmlAttribute(name = "activeSessions", required = true)
    protected int activeSessions;

    /**
     * Obtém o valor da propriedade soap.
     * 
     * @return
     *     possible object is
     *     {@link InfoForSessionType }
     *     
     */
    public InfoForSessionType getSoap() {
        return soap;
    }

    /**
     * Define o valor da propriedade soap.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoForSessionType }
     *     
     */
    public void setSoap(InfoForSessionType value) {
        this.soap = value;
    }

    /**
     * Obtém o valor da propriedade imap.
     * 
     * @return
     *     possible object is
     *     {@link InfoForSessionType }
     *     
     */
    public InfoForSessionType getImap() {
        return imap;
    }

    /**
     * Define o valor da propriedade imap.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoForSessionType }
     *     
     */
    public void setImap(InfoForSessionType value) {
        this.imap = value;
    }

    /**
     * Obtém o valor da propriedade admin.
     * 
     * @return
     *     possible object is
     *     {@link InfoForSessionType }
     *     
     */
    public InfoForSessionType getAdmin() {
        return admin;
    }

    /**
     * Define o valor da propriedade admin.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoForSessionType }
     *     
     */
    public void setAdmin(InfoForSessionType value) {
        this.admin = value;
    }

    /**
     * Obtém o valor da propriedade wiki.
     * 
     * @return
     *     possible object is
     *     {@link InfoForSessionType }
     *     
     */
    public InfoForSessionType getWiki() {
        return wiki;
    }

    /**
     * Define o valor da propriedade wiki.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoForSessionType }
     *     
     */
    public void setWiki(InfoForSessionType value) {
        this.wiki = value;
    }

    /**
     * Obtém o valor da propriedade synclistener.
     * 
     * @return
     *     possible object is
     *     {@link InfoForSessionType }
     *     
     */
    public InfoForSessionType getSynclistener() {
        return synclistener;
    }

    /**
     * Define o valor da propriedade synclistener.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoForSessionType }
     *     
     */
    public void setSynclistener(InfoForSessionType value) {
        this.synclistener = value;
    }

    /**
     * Obtém o valor da propriedade waitset.
     * 
     * @return
     *     possible object is
     *     {@link InfoForSessionType }
     *     
     */
    public InfoForSessionType getWaitset() {
        return waitset;
    }

    /**
     * Define o valor da propriedade waitset.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoForSessionType }
     *     
     */
    public void setWaitset(InfoForSessionType value) {
        this.waitset = value;
    }

    /**
     * Obtém o valor da propriedade activeSessions.
     * 
     */
    public int getActiveSessions() {
        return activeSessions;
    }

    /**
     * Define o valor da propriedade activeSessions.
     * 
     */
    public void setActiveSessions(int value) {
        this.activeSessions = value;
    }

}
