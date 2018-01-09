
package zimbraaccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de certificateValidity complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="certificateValidity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "certificateValidity", propOrder = {
    "startDate",
    "endDate"
})
public class CertificateValidity {

    protected long startDate;
    protected long endDate;

    /**
     * Obtém o valor da propriedade startDate.
     * 
     */
    public long getStartDate() {
        return startDate;
    }

    /**
     * Define o valor da propriedade startDate.
     * 
     */
    public void setStartDate(long value) {
        this.startDate = value;
    }

    /**
     * Obtém o valor da propriedade endDate.
     * 
     */
    public long getEndDate() {
        return endDate;
    }

    /**
     * Define o valor da propriedade endDate.
     * 
     */
    public void setEndDate(long value) {
        this.endDate = value;
    }

}
