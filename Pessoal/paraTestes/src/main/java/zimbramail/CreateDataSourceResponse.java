
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createDataSourceResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createDataSourceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="imap" type="{urn:zimbraMail}imapDataSourceId"/>
 *           &lt;element name="pop3" type="{urn:zimbraMail}pop3DataSourceId"/>
 *           &lt;element name="caldav" type="{urn:zimbraMail}caldavDataSourceId"/>
 *           &lt;element name="yab" type="{urn:zimbraMail}yabDataSourceId"/>
 *           &lt;element name="rss" type="{urn:zimbraMail}rssDataSourceId"/>
 *           &lt;element name="gal" type="{urn:zimbraMail}galDataSourceId"/>
 *           &lt;element name="cal" type="{urn:zimbraMail}calDataSourceId"/>
 *           &lt;element name="unknown" type="{urn:zimbraMail}unknownDataSourceId"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createDataSourceResponse", propOrder = {
    "imap",
    "pop3",
    "caldav",
    "yab",
    "rss",
    "gal",
    "cal",
    "unknown"
})
public class CreateDataSourceResponse {

    protected ImapDataSourceId imap;
    protected Pop3DataSourceId pop3;
    protected CaldavDataSourceId caldav;
    protected YabDataSourceId yab;
    protected RssDataSourceId rss;
    protected GalDataSourceId gal;
    protected CalDataSourceId cal;
    protected UnknownDataSourceId unknown;

    /**
     * Obtém o valor da propriedade imap.
     * 
     * @return
     *     possible object is
     *     {@link ImapDataSourceId }
     *     
     */
    public ImapDataSourceId getImap() {
        return imap;
    }

    /**
     * Define o valor da propriedade imap.
     * 
     * @param value
     *     allowed object is
     *     {@link ImapDataSourceId }
     *     
     */
    public void setImap(ImapDataSourceId value) {
        this.imap = value;
    }

    /**
     * Obtém o valor da propriedade pop3.
     * 
     * @return
     *     possible object is
     *     {@link Pop3DataSourceId }
     *     
     */
    public Pop3DataSourceId getPop3() {
        return pop3;
    }

    /**
     * Define o valor da propriedade pop3.
     * 
     * @param value
     *     allowed object is
     *     {@link Pop3DataSourceId }
     *     
     */
    public void setPop3(Pop3DataSourceId value) {
        this.pop3 = value;
    }

    /**
     * Obtém o valor da propriedade caldav.
     * 
     * @return
     *     possible object is
     *     {@link CaldavDataSourceId }
     *     
     */
    public CaldavDataSourceId getCaldav() {
        return caldav;
    }

    /**
     * Define o valor da propriedade caldav.
     * 
     * @param value
     *     allowed object is
     *     {@link CaldavDataSourceId }
     *     
     */
    public void setCaldav(CaldavDataSourceId value) {
        this.caldav = value;
    }

    /**
     * Obtém o valor da propriedade yab.
     * 
     * @return
     *     possible object is
     *     {@link YabDataSourceId }
     *     
     */
    public YabDataSourceId getYab() {
        return yab;
    }

    /**
     * Define o valor da propriedade yab.
     * 
     * @param value
     *     allowed object is
     *     {@link YabDataSourceId }
     *     
     */
    public void setYab(YabDataSourceId value) {
        this.yab = value;
    }

    /**
     * Obtém o valor da propriedade rss.
     * 
     * @return
     *     possible object is
     *     {@link RssDataSourceId }
     *     
     */
    public RssDataSourceId getRss() {
        return rss;
    }

    /**
     * Define o valor da propriedade rss.
     * 
     * @param value
     *     allowed object is
     *     {@link RssDataSourceId }
     *     
     */
    public void setRss(RssDataSourceId value) {
        this.rss = value;
    }

    /**
     * Obtém o valor da propriedade gal.
     * 
     * @return
     *     possible object is
     *     {@link GalDataSourceId }
     *     
     */
    public GalDataSourceId getGal() {
        return gal;
    }

    /**
     * Define o valor da propriedade gal.
     * 
     * @param value
     *     allowed object is
     *     {@link GalDataSourceId }
     *     
     */
    public void setGal(GalDataSourceId value) {
        this.gal = value;
    }

    /**
     * Obtém o valor da propriedade cal.
     * 
     * @return
     *     possible object is
     *     {@link CalDataSourceId }
     *     
     */
    public CalDataSourceId getCal() {
        return cal;
    }

    /**
     * Define o valor da propriedade cal.
     * 
     * @param value
     *     allowed object is
     *     {@link CalDataSourceId }
     *     
     */
    public void setCal(CalDataSourceId value) {
        this.cal = value;
    }

    /**
     * Obtém o valor da propriedade unknown.
     * 
     * @return
     *     possible object is
     *     {@link UnknownDataSourceId }
     *     
     */
    public UnknownDataSourceId getUnknown() {
        return unknown;
    }

    /**
     * Define o valor da propriedade unknown.
     * 
     * @param value
     *     allowed object is
     *     {@link UnknownDataSourceId }
     *     
     */
    public void setUnknown(UnknownDataSourceId value) {
        this.unknown = value;
    }

}
