
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de dtVal complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dtVal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="s" type="{urn:zimbraAdmin}dtTimeInfo" minOccurs="0"/>
 *         &lt;element name="e" type="{urn:zimbraAdmin}dtTimeInfo" minOccurs="0"/>
 *         &lt;element name="dur" type="{urn:zimbraAdmin}durationInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtVal", propOrder = {
    "s",
    "e",
    "dur"
})
public class DtVal {

    protected DtTimeInfo s;
    protected DtTimeInfo e;
    protected DurationInfo dur;

    /**
     * Obtém o valor da propriedade s.
     * 
     * @return
     *     possible object is
     *     {@link DtTimeInfo }
     *     
     */
    public DtTimeInfo getS() {
        return s;
    }

    /**
     * Define o valor da propriedade s.
     * 
     * @param value
     *     allowed object is
     *     {@link DtTimeInfo }
     *     
     */
    public void setS(DtTimeInfo value) {
        this.s = value;
    }

    /**
     * Obtém o valor da propriedade e.
     * 
     * @return
     *     possible object is
     *     {@link DtTimeInfo }
     *     
     */
    public DtTimeInfo getE() {
        return e;
    }

    /**
     * Define o valor da propriedade e.
     * 
     * @param value
     *     allowed object is
     *     {@link DtTimeInfo }
     *     
     */
    public void setE(DtTimeInfo value) {
        this.e = value;
    }

    /**
     * Obtém o valor da propriedade dur.
     * 
     * @return
     *     possible object is
     *     {@link DurationInfo }
     *     
     */
    public DurationInfo getDur() {
        return dur;
    }

    /**
     * Define o valor da propriedade dur.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationInfo }
     *     
     */
    public void setDur(DurationInfo value) {
        this.dur = value;
    }

}
