
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de exportContactsRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="exportContactsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="ct" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="l" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="csvfmt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="csvlocale" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="csvsep" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportContactsRequest")
public class ExportContactsRequest {

    @XmlAttribute(name = "ct", required = true)
    protected String ct;
    @XmlAttribute(name = "l")
    protected String l;
    @XmlAttribute(name = "csvfmt")
    protected String csvfmt;
    @XmlAttribute(name = "csvlocale")
    protected String csvlocale;
    @XmlAttribute(name = "csvsep")
    protected String csvsep;

    /**
     * Obtém o valor da propriedade ct.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCt() {
        return ct;
    }

    /**
     * Define o valor da propriedade ct.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCt(String value) {
        this.ct = value;
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
     * Obtém o valor da propriedade csvfmt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsvfmt() {
        return csvfmt;
    }

    /**
     * Define o valor da propriedade csvfmt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsvfmt(String value) {
        this.csvfmt = value;
    }

    /**
     * Obtém o valor da propriedade csvlocale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsvlocale() {
        return csvlocale;
    }

    /**
     * Define o valor da propriedade csvlocale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsvlocale(String value) {
        this.csvlocale = value;
    }

    /**
     * Obtém o valor da propriedade csvsep.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsvsep() {
        return csvsep;
    }

    /**
     * Define o valor da propriedade csvsep.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsvsep(String value) {
        this.csvsep = value;
    }

}
