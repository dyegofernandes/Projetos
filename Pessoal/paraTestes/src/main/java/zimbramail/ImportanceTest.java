
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de importanceTest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="importanceTest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}filterTest">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="imp" use="required" type="{urn:zimbraMail}importance" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "importanceTest")
public class ImportanceTest
    extends FilterTest
{

    @XmlAttribute(name = "imp", required = true)
    protected Importance imp;

    /**
     * Obtém o valor da propriedade imp.
     * 
     * @return
     *     possible object is
     *     {@link Importance }
     *     
     */
    public Importance getImp() {
        return imp;
    }

    /**
     * Define o valor da propriedade imp.
     * 
     * @param value
     *     allowed object is
     *     {@link Importance }
     *     
     */
    public void setImp(Importance value) {
        this.imp = value;
    }

}
