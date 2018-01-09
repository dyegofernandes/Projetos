
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createDataSourceRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createDataSourceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="imap" type="{urn:zimbraMail}mailImapDataSource"/>
 *           &lt;element name="pop3" type="{urn:zimbraMail}mailPop3DataSource"/>
 *           &lt;element name="caldav" type="{urn:zimbraMail}mailCaldavDataSource"/>
 *           &lt;element name="yab" type="{urn:zimbraMail}mailYabDataSource"/>
 *           &lt;element name="rss" type="{urn:zimbraMail}mailRssDataSource"/>
 *           &lt;element name="gal" type="{urn:zimbraMail}mailGalDataSource"/>
 *           &lt;element name="cal" type="{urn:zimbraMail}mailCalDataSource"/>
 *           &lt;element name="unknown" type="{urn:zimbraMail}mailUnknownDataSource"/>
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
@XmlType(name = "createDataSourceRequest", propOrder = {
    "imap",
    "pop3",
    "caldav",
    "yab",
    "rss",
    "gal",
    "cal",
    "unknown"
})
public class CreateDataSourceRequest {

    protected MailImapDataSource imap;
    protected MailPop3DataSource pop3;
    protected MailCaldavDataSource caldav;
    protected MailYabDataSource yab;
    protected MailRssDataSource rss;
    protected MailGalDataSource gal;
    protected MailCalDataSource cal;
    protected MailUnknownDataSource unknown;

    /**
     * Obtém o valor da propriedade imap.
     * 
     * @return
     *     possible object is
     *     {@link MailImapDataSource }
     *     
     */
    public MailImapDataSource getImap() {
        return imap;
    }

    /**
     * Define o valor da propriedade imap.
     * 
     * @param value
     *     allowed object is
     *     {@link MailImapDataSource }
     *     
     */
    public void setImap(MailImapDataSource value) {
        this.imap = value;
    }

    /**
     * Obtém o valor da propriedade pop3.
     * 
     * @return
     *     possible object is
     *     {@link MailPop3DataSource }
     *     
     */
    public MailPop3DataSource getPop3() {
        return pop3;
    }

    /**
     * Define o valor da propriedade pop3.
     * 
     * @param value
     *     allowed object is
     *     {@link MailPop3DataSource }
     *     
     */
    public void setPop3(MailPop3DataSource value) {
        this.pop3 = value;
    }

    /**
     * Obtém o valor da propriedade caldav.
     * 
     * @return
     *     possible object is
     *     {@link MailCaldavDataSource }
     *     
     */
    public MailCaldavDataSource getCaldav() {
        return caldav;
    }

    /**
     * Define o valor da propriedade caldav.
     * 
     * @param value
     *     allowed object is
     *     {@link MailCaldavDataSource }
     *     
     */
    public void setCaldav(MailCaldavDataSource value) {
        this.caldav = value;
    }

    /**
     * Obtém o valor da propriedade yab.
     * 
     * @return
     *     possible object is
     *     {@link MailYabDataSource }
     *     
     */
    public MailYabDataSource getYab() {
        return yab;
    }

    /**
     * Define o valor da propriedade yab.
     * 
     * @param value
     *     allowed object is
     *     {@link MailYabDataSource }
     *     
     */
    public void setYab(MailYabDataSource value) {
        this.yab = value;
    }

    /**
     * Obtém o valor da propriedade rss.
     * 
     * @return
     *     possible object is
     *     {@link MailRssDataSource }
     *     
     */
    public MailRssDataSource getRss() {
        return rss;
    }

    /**
     * Define o valor da propriedade rss.
     * 
     * @param value
     *     allowed object is
     *     {@link MailRssDataSource }
     *     
     */
    public void setRss(MailRssDataSource value) {
        this.rss = value;
    }

    /**
     * Obtém o valor da propriedade gal.
     * 
     * @return
     *     possible object is
     *     {@link MailGalDataSource }
     *     
     */
    public MailGalDataSource getGal() {
        return gal;
    }

    /**
     * Define o valor da propriedade gal.
     * 
     * @param value
     *     allowed object is
     *     {@link MailGalDataSource }
     *     
     */
    public void setGal(MailGalDataSource value) {
        this.gal = value;
    }

    /**
     * Obtém o valor da propriedade cal.
     * 
     * @return
     *     possible object is
     *     {@link MailCalDataSource }
     *     
     */
    public MailCalDataSource getCal() {
        return cal;
    }

    /**
     * Define o valor da propriedade cal.
     * 
     * @param value
     *     allowed object is
     *     {@link MailCalDataSource }
     *     
     */
    public void setCal(MailCalDataSource value) {
        this.cal = value;
    }

    /**
     * Obtém o valor da propriedade unknown.
     * 
     * @return
     *     possible object is
     *     {@link MailUnknownDataSource }
     *     
     */
    public MailUnknownDataSource getUnknown() {
        return unknown;
    }

    /**
     * Define o valor da propriedade unknown.
     * 
     * @param value
     *     allowed object is
     *     {@link MailUnknownDataSource }
     *     
     */
    public void setUnknown(MailUnknownDataSource value) {
        this.unknown = value;
    }

}
