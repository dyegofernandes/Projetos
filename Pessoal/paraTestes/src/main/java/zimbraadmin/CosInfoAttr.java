
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cosInfoAttr complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cosInfoAttr">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:zimbraAdmin>attr">
 *       &lt;attribute name="c" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="pd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cosInfoAttr")
public class CosInfoAttr
    extends Attr
{

    @XmlAttribute(name = "c")
    protected Boolean c;
    @XmlAttribute(name = "pd")
    protected Boolean pd;

    /**
     * Obtém o valor da propriedade c.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isC() {
        return c;
    }

    /**
     * Define o valor da propriedade c.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setC(Boolean value) {
        this.c = value;
    }

    /**
     * Obtém o valor da propriedade pd.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPd() {
        return pd;
    }

    /**
     * Define o valor da propriedade pd.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPd(Boolean value) {
        this.pd = value;
    }

}
