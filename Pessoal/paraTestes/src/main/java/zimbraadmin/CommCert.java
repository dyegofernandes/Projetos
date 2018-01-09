
package zimbraadmin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de commCert complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="commCert">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cert" type="{urn:zimbraAdmin}aidAndFilename" minOccurs="0"/>
 *         &lt;element name="rootCA" type="{urn:zimbraAdmin}aidAndFilename" minOccurs="0"/>
 *         &lt;element name="intermediateCA" type="{urn:zimbraAdmin}aidAndFilename" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "commCert", propOrder = {
    "cert",
    "rootCA",
    "intermediateCA"
})
public class CommCert {

    protected AidAndFilename cert;
    protected AidAndFilename rootCA;
    protected List<AidAndFilename> intermediateCA;

    /**
     * Obtém o valor da propriedade cert.
     * 
     * @return
     *     possible object is
     *     {@link AidAndFilename }
     *     
     */
    public AidAndFilename getCert() {
        return cert;
    }

    /**
     * Define o valor da propriedade cert.
     * 
     * @param value
     *     allowed object is
     *     {@link AidAndFilename }
     *     
     */
    public void setCert(AidAndFilename value) {
        this.cert = value;
    }

    /**
     * Obtém o valor da propriedade rootCA.
     * 
     * @return
     *     possible object is
     *     {@link AidAndFilename }
     *     
     */
    public AidAndFilename getRootCA() {
        return rootCA;
    }

    /**
     * Define o valor da propriedade rootCA.
     * 
     * @param value
     *     allowed object is
     *     {@link AidAndFilename }
     *     
     */
    public void setRootCA(AidAndFilename value) {
        this.rootCA = value;
    }

    /**
     * Gets the value of the intermediateCA property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intermediateCA property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntermediateCA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AidAndFilename }
     * 
     * 
     */
    public List<AidAndFilename> getIntermediateCA() {
        if (intermediateCA == null) {
            intermediateCA = new ArrayList<AidAndFilename>();
        }
        return this.intermediateCA;
    }

}
