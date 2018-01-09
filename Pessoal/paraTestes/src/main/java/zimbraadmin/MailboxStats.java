
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de mailboxStats complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="mailboxStats">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="numMboxes" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="totalSize" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mailboxStats", propOrder = {

})
public class MailboxStats {

    @XmlAttribute(name = "numMboxes", required = true)
    protected long numMboxes;
    @XmlAttribute(name = "totalSize", required = true)
    protected long totalSize;

    /**
     * Obtém o valor da propriedade numMboxes.
     * 
     */
    public long getNumMboxes() {
        return numMboxes;
    }

    /**
     * Define o valor da propriedade numMboxes.
     * 
     */
    public void setNumMboxes(long value) {
        this.numMboxes = value;
    }

    /**
     * Obtém o valor da propriedade totalSize.
     * 
     */
    public long getTotalSize() {
        return totalSize;
    }

    /**
     * Define o valor da propriedade totalSize.
     * 
     */
    public void setTotalSize(long value) {
        this.totalSize = value;
    }

}
