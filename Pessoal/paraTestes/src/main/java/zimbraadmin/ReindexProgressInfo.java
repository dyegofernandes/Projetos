
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de reindexProgressInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="reindexProgressInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="numSucceeded" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="numFailed" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="numRemaining" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reindexProgressInfo")
public class ReindexProgressInfo {

    @XmlAttribute(name = "numSucceeded", required = true)
    protected int numSucceeded;
    @XmlAttribute(name = "numFailed", required = true)
    protected int numFailed;
    @XmlAttribute(name = "numRemaining", required = true)
    protected int numRemaining;

    /**
     * Obtém o valor da propriedade numSucceeded.
     * 
     */
    public int getNumSucceeded() {
        return numSucceeded;
    }

    /**
     * Define o valor da propriedade numSucceeded.
     * 
     */
    public void setNumSucceeded(int value) {
        this.numSucceeded = value;
    }

    /**
     * Obtém o valor da propriedade numFailed.
     * 
     */
    public int getNumFailed() {
        return numFailed;
    }

    /**
     * Define o valor da propriedade numFailed.
     * 
     */
    public void setNumFailed(int value) {
        this.numFailed = value;
    }

    /**
     * Obtém o valor da propriedade numRemaining.
     * 
     */
    public int getNumRemaining() {
        return numRemaining;
    }

    /**
     * Define o valor da propriedade numRemaining.
     * 
     */
    public void setNumRemaining(int value) {
        this.numRemaining = value;
    }

}
