
package zimbramail;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de legacyInstanceDataInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="legacyInstanceDataInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}legacyInstanceDataAttrs">
 *       &lt;sequence>
 *         &lt;element name="or" type="{urn:zimbraMail}calOrganizer" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="geo" type="{urn:zimbraMail}geoInfo" minOccurs="0"/>
 *         &lt;element name="fr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="ex" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "legacyInstanceDataInfo", propOrder = {
    "or",
    "category",
    "geo",
    "fr"
})
public class LegacyInstanceDataInfo
    extends LegacyInstanceDataAttrs
{

    protected CalOrganizer or;
    protected List<String> category;
    protected GeoInfo geo;
    protected String fr;
    @XmlAttribute(name = "s")
    protected Long s;
    @XmlAttribute(name = "ex")
    protected Boolean ex;

    /**
     * Obtém o valor da propriedade or.
     * 
     * @return
     *     possible object is
     *     {@link CalOrganizer }
     *     
     */
    public CalOrganizer getOr() {
        return or;
    }

    /**
     * Define o valor da propriedade or.
     * 
     * @param value
     *     allowed object is
     *     {@link CalOrganizer }
     *     
     */
    public void setOr(CalOrganizer value) {
        this.or = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the category property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCategory() {
        if (category == null) {
            category = new ArrayList<String>();
        }
        return this.category;
    }

    /**
     * Obtém o valor da propriedade geo.
     * 
     * @return
     *     possible object is
     *     {@link GeoInfo }
     *     
     */
    public GeoInfo getGeo() {
        return geo;
    }

    /**
     * Define o valor da propriedade geo.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoInfo }
     *     
     */
    public void setGeo(GeoInfo value) {
        this.geo = value;
    }

    /**
     * Obtém o valor da propriedade fr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFr() {
        return fr;
    }

    /**
     * Define o valor da propriedade fr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFr(String value) {
        this.fr = value;
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
     * Obtém o valor da propriedade ex.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEx() {
        return ex;
    }

    /**
     * Define o valor da propriedade ex.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEx(Boolean value) {
        this.ex = value;
    }

}
