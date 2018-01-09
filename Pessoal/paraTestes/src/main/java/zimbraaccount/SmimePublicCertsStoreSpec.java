
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import zimbra.SourceLookupOpt;
import zimbra.StoreLookupOpt;


/**
 * <p>Classe Java de smimePublicCertsStoreSpec complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="smimePublicCertsStoreSpec">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="storeLookupOpt" type="{urn:zimbra}storeLookupOpt" />
 *       &lt;attribute name="sourceLookupOpt" type="{urn:zimbra}sourceLookupOpt" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "smimePublicCertsStoreSpec", propOrder = {
    "value"
})
public class SmimePublicCertsStoreSpec {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "storeLookupOpt")
    protected StoreLookupOpt storeLookupOpt;
    @XmlAttribute(name = "sourceLookupOpt")
    protected SourceLookupOpt sourceLookupOpt;

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
     * Obtém o valor da propriedade storeLookupOpt.
     * 
     * @return
     *     possible object is
     *     {@link StoreLookupOpt }
     *     
     */
    public StoreLookupOpt getStoreLookupOpt() {
        return storeLookupOpt;
    }

    /**
     * Define o valor da propriedade storeLookupOpt.
     * 
     * @param value
     *     allowed object is
     *     {@link StoreLookupOpt }
     *     
     */
    public void setStoreLookupOpt(StoreLookupOpt value) {
        this.storeLookupOpt = value;
    }

    /**
     * Obtém o valor da propriedade sourceLookupOpt.
     * 
     * @return
     *     possible object is
     *     {@link SourceLookupOpt }
     *     
     */
    public SourceLookupOpt getSourceLookupOpt() {
        return sourceLookupOpt;
    }

    /**
     * Define o valor da propriedade sourceLookupOpt.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceLookupOpt }
     *     
     */
    public void setSourceLookupOpt(SourceLookupOpt value) {
        this.sourceLookupOpt = value;
    }

}
