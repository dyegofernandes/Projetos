
package zimbravoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de uploadVoiceMailRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="uploadVoiceMailRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="storeprincipal" type="{urn:zimbraVoice}storePrincipalSpec" minOccurs="0"/>
 *         &lt;element name="vm" type="{urn:zimbraVoice}voiceMsgUploadSpec" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uploadVoiceMailRequest", propOrder = {
    "storeprincipal",
    "vm"
})
public class UploadVoiceMailRequest {

    protected StorePrincipalSpec storeprincipal;
    protected VoiceMsgUploadSpec vm;

    /**
     * Obtém o valor da propriedade storeprincipal.
     * 
     * @return
     *     possible object is
     *     {@link StorePrincipalSpec }
     *     
     */
    public StorePrincipalSpec getStoreprincipal() {
        return storeprincipal;
    }

    /**
     * Define o valor da propriedade storeprincipal.
     * 
     * @param value
     *     allowed object is
     *     {@link StorePrincipalSpec }
     *     
     */
    public void setStoreprincipal(StorePrincipalSpec value) {
        this.storeprincipal = value;
    }

    /**
     * Obtém o valor da propriedade vm.
     * 
     * @return
     *     possible object is
     *     {@link VoiceMsgUploadSpec }
     *     
     */
    public VoiceMsgUploadSpec getVm() {
        return vm;
    }

    /**
     * Define o valor da propriedade vm.
     * 
     * @param value
     *     allowed object is
     *     {@link VoiceMsgUploadSpec }
     *     
     */
    public void setVm(VoiceMsgUploadSpec value) {
        this.vm = value;
    }

}
