
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de createSystemRetentionPolicyRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="createSystemRetentionPolicyRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cos" type="{urn:zimbraAdmin}cosSelector" minOccurs="0"/>
 *         &lt;element name="keep" type="{urn:zimbraAdmin}policyHolder" minOccurs="0"/>
 *         &lt;element name="purge" type="{urn:zimbraAdmin}policyHolder" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createSystemRetentionPolicyRequest", propOrder = {
    "cos",
    "keep",
    "purge"
})
public class CreateSystemRetentionPolicyRequest {

    protected CosSelector cos;
    protected PolicyHolder keep;
    protected PolicyHolder purge;

    /**
     * Obtém o valor da propriedade cos.
     * 
     * @return
     *     possible object is
     *     {@link CosSelector }
     *     
     */
    public CosSelector getCos() {
        return cos;
    }

    /**
     * Define o valor da propriedade cos.
     * 
     * @param value
     *     allowed object is
     *     {@link CosSelector }
     *     
     */
    public void setCos(CosSelector value) {
        this.cos = value;
    }

    /**
     * Obtém o valor da propriedade keep.
     * 
     * @return
     *     possible object is
     *     {@link PolicyHolder }
     *     
     */
    public PolicyHolder getKeep() {
        return keep;
    }

    /**
     * Define o valor da propriedade keep.
     * 
     * @param value
     *     allowed object is
     *     {@link PolicyHolder }
     *     
     */
    public void setKeep(PolicyHolder value) {
        this.keep = value;
    }

    /**
     * Obtém o valor da propriedade purge.
     * 
     * @return
     *     possible object is
     *     {@link PolicyHolder }
     *     
     */
    public PolicyHolder getPurge() {
        return purge;
    }

    /**
     * Define o valor da propriedade purge.
     * 
     * @param value
     *     allowed object is
     *     {@link PolicyHolder }
     *     
     */
    public void setPurge(PolicyHolder value) {
        this.purge = value;
    }

}
