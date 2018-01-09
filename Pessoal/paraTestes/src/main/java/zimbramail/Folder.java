
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de folder complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="folder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:zimbraMail}meta" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="acl" type="{urn:zimbraMail}acl" minOccurs="0"/>
 *         &lt;element ref="{urn:zimbraMail}retentionPolicy" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{urn:zimbraMail}folder"/>
 *           &lt;element ref="{urn:zimbraMail}link"/>
 *           &lt;element ref="{urn:zimbraMail}search"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="uuid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="absFolderPath" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="l" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="luuid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="f" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="rgb" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="u" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="i4u" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="view" type="{urn:zimbraMail}view" />
 *       &lt;attribute name="rev" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ms" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="md" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="n" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="i4n" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="i4ms" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="i4next" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="activesyncdisabled" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="webOfflineSyncDays" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="perm" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="recursive" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="rest" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "folder", propOrder = {
    "meta",
    "acl",
    "retentionPolicy",
    "folderOrLinkOrSearch"
})
@XmlSeeAlso({
    SearchFolder.class,
    Mountpoint.class,
    SyncFolder.class
})
public class Folder {

    protected List<MailCustomMetadata> meta;
    protected Acl acl;
    protected RetentionPolicy retentionPolicy;
    @XmlElements({
        @XmlElement(name = "folder"),
        @XmlElement(name = "link", type = Mountpoint.class),
        @XmlElement(name = "search", type = SearchFolder.class)
    })
    protected List<Folder> folderOrLinkOrSearch;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "uuid", required = true)
    protected String uuid;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "absFolderPath")
    protected String absFolderPath;
    @XmlAttribute(name = "l")
    protected String l;
    @XmlAttribute(name = "luuid")
    protected String luuid;
    @XmlAttribute(name = "f")
    protected String f;
    @XmlAttribute(name = "color")
    protected Integer color;
    @XmlAttribute(name = "rgb")
    protected String rgb;
    @XmlAttribute(name = "u")
    protected Integer u;
    @XmlAttribute(name = "i4u")
    protected Integer i4U;
    @XmlAttribute(name = "view")
    protected String view;
    @XmlAttribute(name = "rev")
    protected Integer rev;
    @XmlAttribute(name = "ms")
    protected Integer ms;
    @XmlAttribute(name = "md")
    protected Long md;
    @XmlAttribute(name = "n")
    protected Integer n;
    @XmlAttribute(name = "i4n")
    protected Integer i4N;
    @XmlAttribute(name = "s")
    protected Long s;
    @XmlAttribute(name = "i4ms")
    protected Integer i4Ms;
    @XmlAttribute(name = "i4next")
    protected Integer i4Next;
    @XmlAttribute(name = "url")
    protected String url;
    @XmlAttribute(name = "activesyncdisabled")
    protected Boolean activesyncdisabled;
    @XmlAttribute(name = "webOfflineSyncDays")
    protected Integer webOfflineSyncDays;
    @XmlAttribute(name = "perm")
    protected String perm;
    @XmlAttribute(name = "recursive")
    protected Boolean recursive;
    @XmlAttribute(name = "rest")
    protected String rest;

    /**
     * Gets the value of the meta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MailCustomMetadata }
     * 
     * 
     */
    public List<MailCustomMetadata> getMeta() {
        if (meta == null) {
            meta = new ArrayList<MailCustomMetadata>();
        }
        return this.meta;
    }

    /**
     * Obtém o valor da propriedade acl.
     * 
     * @return
     *     possible object is
     *     {@link Acl }
     *     
     */
    public Acl getAcl() {
        return acl;
    }

    /**
     * Define o valor da propriedade acl.
     * 
     * @param value
     *     allowed object is
     *     {@link Acl }
     *     
     */
    public void setAcl(Acl value) {
        this.acl = value;
    }

    /**
     * Obtém o valor da propriedade retentionPolicy.
     * 
     * @return
     *     possible object is
     *     {@link RetentionPolicy }
     *     
     */
    public RetentionPolicy getRetentionPolicy() {
        return retentionPolicy;
    }

    /**
     * Define o valor da propriedade retentionPolicy.
     * 
     * @param value
     *     allowed object is
     *     {@link RetentionPolicy }
     *     
     */
    public void setRetentionPolicy(RetentionPolicy value) {
        this.retentionPolicy = value;
    }

    /**
     * Gets the value of the folderOrLinkOrSearch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the folderOrLinkOrSearch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFolderOrLinkOrSearch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Folder }
     * {@link Mountpoint }
     * {@link SearchFolder }
     * 
     * 
     */
    public List<Folder> getFolderOrLinkOrSearch() {
        if (folderOrLinkOrSearch == null) {
            folderOrLinkOrSearch = new ArrayList<Folder>();
        }
        return this.folderOrLinkOrSearch;
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
     * Obtém o valor da propriedade uuid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Define o valor da propriedade uuid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade absFolderPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbsFolderPath() {
        return absFolderPath;
    }

    /**
     * Define o valor da propriedade absFolderPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbsFolderPath(String value) {
        this.absFolderPath = value;
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
     * Obtém o valor da propriedade luuid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLuuid() {
        return luuid;
    }

    /**
     * Define o valor da propriedade luuid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLuuid(String value) {
        this.luuid = value;
    }

    /**
     * Obtém o valor da propriedade f.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getF() {
        return f;
    }

    /**
     * Define o valor da propriedade f.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setF(String value) {
        this.f = value;
    }

    /**
     * Obtém o valor da propriedade color.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getColor() {
        return color;
    }

    /**
     * Define o valor da propriedade color.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColor(Integer value) {
        this.color = value;
    }

    /**
     * Obtém o valor da propriedade rgb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRgb() {
        return rgb;
    }

    /**
     * Define o valor da propriedade rgb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRgb(String value) {
        this.rgb = value;
    }

    /**
     * Obtém o valor da propriedade u.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getU() {
        return u;
    }

    /**
     * Define o valor da propriedade u.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setU(Integer value) {
        this.u = value;
    }

    /**
     * Obtém o valor da propriedade i4U.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getI4U() {
        return i4U;
    }

    /**
     * Define o valor da propriedade i4U.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setI4U(Integer value) {
        this.i4U = value;
    }

    /**
     * Obtém o valor da propriedade view.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getView() {
        return view;
    }

    /**
     * Define o valor da propriedade view.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setView(String value) {
        this.view = value;
    }

    /**
     * Obtém o valor da propriedade rev.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRev() {
        return rev;
    }

    /**
     * Define o valor da propriedade rev.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRev(Integer value) {
        this.rev = value;
    }

    /**
     * Obtém o valor da propriedade ms.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMs() {
        return ms;
    }

    /**
     * Define o valor da propriedade ms.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMs(Integer value) {
        this.ms = value;
    }

    /**
     * Obtém o valor da propriedade md.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMd() {
        return md;
    }

    /**
     * Define o valor da propriedade md.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMd(Long value) {
        this.md = value;
    }

    /**
     * Obtém o valor da propriedade n.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getN() {
        return n;
    }

    /**
     * Define o valor da propriedade n.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setN(Integer value) {
        this.n = value;
    }

    /**
     * Obtém o valor da propriedade i4N.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getI4N() {
        return i4N;
    }

    /**
     * Define o valor da propriedade i4N.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setI4N(Integer value) {
        this.i4N = value;
    }

    /**
     * Obtém o valor da propriedade s.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getS() {
        return s;
    }

    /**
     * Define o valor da propriedade s.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setS(Long value) {
        this.s = value;
    }

    /**
     * Obtém o valor da propriedade i4Ms.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getI4Ms() {
        return i4Ms;
    }

    /**
     * Define o valor da propriedade i4Ms.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setI4Ms(Integer value) {
        this.i4Ms = value;
    }

    /**
     * Obtém o valor da propriedade i4Next.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getI4Next() {
        return i4Next;
    }

    /**
     * Define o valor da propriedade i4Next.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setI4Next(Integer value) {
        this.i4Next = value;
    }

    /**
     * Obtém o valor da propriedade url.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Define o valor da propriedade url.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Obtém o valor da propriedade activesyncdisabled.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActivesyncdisabled() {
        return activesyncdisabled;
    }

    /**
     * Define o valor da propriedade activesyncdisabled.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActivesyncdisabled(Boolean value) {
        this.activesyncdisabled = value;
    }

    /**
     * Obtém o valor da propriedade webOfflineSyncDays.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWebOfflineSyncDays() {
        return webOfflineSyncDays;
    }

    /**
     * Define o valor da propriedade webOfflineSyncDays.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWebOfflineSyncDays(Integer value) {
        this.webOfflineSyncDays = value;
    }

    /**
     * Obtém o valor da propriedade perm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerm() {
        return perm;
    }

    /**
     * Define o valor da propriedade perm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerm(String value) {
        this.perm = value;
    }

    /**
     * Obtém o valor da propriedade recursive.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecursive() {
        return recursive;
    }

    /**
     * Define o valor da propriedade recursive.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecursive(Boolean value) {
        this.recursive = value;
    }

    /**
     * Obtém o valor da propriedade rest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRest() {
        return rest;
    }

    /**
     * Define o valor da propriedade rest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRest(String value) {
        this.rest = value;
    }

}
