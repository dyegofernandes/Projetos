
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de freeBusySlot complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="freeBusySlot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="s" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="e" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "freeBusySlot")
@XmlSeeAlso({
    FreeBusyFREEslot.class,
    FreeBusyBUSYslot.class,
    FreeBusyBUSYTENTATIVEslot.class,
    FreeBusyBUSYUNAVAILABLEslot.class,
    FreeBusyNODATAslot.class
})
public class FreeBusySlot {

    @XmlAttribute(name = "s", required = true)
    protected long s;
    @XmlAttribute(name = "e", required = true)
    protected long e;

    /**
     * Obtém o valor da propriedade s.
     * 
     */
    public long getS() {
        return s;
    }

    /**
     * Define o valor da propriedade s.
     * 
     */
    public void setS(long value) {
        this.s = value;
    }

    /**
     * Obtém o valor da propriedade e.
     * 
     */
    public long getE() {
        return e;
    }

    /**
     * Define o valor da propriedade e.
     * 
     */
    public void setE(long value) {
        this.e = value;
    }

}
