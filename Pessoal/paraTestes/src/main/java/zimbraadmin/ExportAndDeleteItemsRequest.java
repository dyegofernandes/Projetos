
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de exportAndDeleteItemsRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="exportAndDeleteItemsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mbox" type="{urn:zimbraAdmin}exportAndDeleteMailboxSpec"/>
 *       &lt;/sequence>
 *       &lt;attribute name="exportDir" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="exportFilenamePrefix" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportAndDeleteItemsRequest", propOrder = {
    "mbox"
})
public class ExportAndDeleteItemsRequest {

    @XmlElement(required = true)
    protected ExportAndDeleteMailboxSpec mbox;
    @XmlAttribute(name = "exportDir")
    protected String exportDir;
    @XmlAttribute(name = "exportFilenamePrefix")
    protected String exportFilenamePrefix;

    /**
     * Obtém o valor da propriedade mbox.
     * 
     * @return
     *     possible object is
     *     {@link ExportAndDeleteMailboxSpec }
     *     
     */
    public ExportAndDeleteMailboxSpec getMbox() {
        return mbox;
    }

    /**
     * Define o valor da propriedade mbox.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportAndDeleteMailboxSpec }
     *     
     */
    public void setMbox(ExportAndDeleteMailboxSpec value) {
        this.mbox = value;
    }

    /**
     * Obtém o valor da propriedade exportDir.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportDir() {
        return exportDir;
    }

    /**
     * Define o valor da propriedade exportDir.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportDir(String value) {
        this.exportDir = value;
    }

    /**
     * Obtém o valor da propriedade exportFilenamePrefix.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportFilenamePrefix() {
        return exportFilenamePrefix;
    }

    /**
     * Define o valor da propriedade exportFilenamePrefix.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportFilenamePrefix(String value) {
        this.exportFilenamePrefix = value;
    }

}
