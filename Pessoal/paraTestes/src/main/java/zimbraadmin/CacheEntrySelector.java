
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Classe Java de cacheEntrySelector complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cacheEntrySelector">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="by" type="{urn:zimbraAdmin}cacheEntryBy" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cacheEntrySelector", propOrder = {
    "value"
})
public class CacheEntrySelector {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "by")
    protected CacheEntryBy by;

    /**
     * Obtém o valor da propriedade value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define o valor da propriedade value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtém o valor da propriedade by.
     * 
     * @return
     *     possible object is
     *     {@link CacheEntryBy }
     *     
     */
    public CacheEntryBy getBy() {
        return by;
    }

    /**
     * Define o valor da propriedade by.
     * 
     * @param value
     *     allowed object is
     *     {@link CacheEntryBy }
     *     
     */
    public void setBy(CacheEntryBy value) {
        this.by = value;
    }

}