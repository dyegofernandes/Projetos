
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de reIndexResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="reIndexResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="progress" type="{urn:zimbraAdmin}reindexProgressInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="status" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reIndexResponse", propOrder = {
    "progress"
})
public class ReIndexResponse {

    protected ReindexProgressInfo progress;
    @XmlAttribute(name = "status", required = true)
    protected String status;

    /**
     * Obtém o valor da propriedade progress.
     * 
     * @return
     *     possible object is
     *     {@link ReindexProgressInfo }
     *     
     */
    public ReindexProgressInfo getProgress() {
        return progress;
    }

    /**
     * Define o valor da propriedade progress.
     * 
     * @param value
     *     allowed object is
     *     {@link ReindexProgressInfo }
     *     
     */
    public void setProgress(ReindexProgressInfo value) {
        this.progress = value;
    }

    /**
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
