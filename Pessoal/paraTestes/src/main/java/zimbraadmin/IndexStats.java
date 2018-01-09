
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de indexStats complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="indexStats">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *       &lt;/all>
 *       &lt;attribute name="maxDocs" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="deletedDocs" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "indexStats", propOrder = {

})
public class IndexStats {

    @XmlAttribute(name = "maxDocs", required = true)
    protected int maxDocs;
    @XmlAttribute(name = "deletedDocs", required = true)
    protected int deletedDocs;

    /**
     * Obtém o valor da propriedade maxDocs.
     * 
     */
    public int getMaxDocs() {
        return maxDocs;
    }

    /**
     * Define o valor da propriedade maxDocs.
     * 
     */
    public void setMaxDocs(int value) {
        this.maxDocs = value;
    }

    /**
     * Obtém o valor da propriedade deletedDocs.
     * 
     */
    public int getDeletedDocs() {
        return deletedDocs;
    }

    /**
     * Define o valor da propriedade deletedDocs.
     * 
     */
    public void setDeletedDocs(int value) {
        this.deletedDocs = value;
    }

}
