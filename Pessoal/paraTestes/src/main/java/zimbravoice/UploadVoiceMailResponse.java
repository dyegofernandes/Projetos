
package zimbravoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de uploadVoiceMailResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="uploadVoiceMailResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="upload" type="{urn:zimbraVoice}voiceMsgUploadInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uploadVoiceMailResponse", propOrder = {
    "upload"
})
public class UploadVoiceMailResponse {

    protected VoiceMsgUploadInfo upload;

    /**
     * Obtém o valor da propriedade upload.
     * 
     * @return
     *     possible object is
     *     {@link VoiceMsgUploadInfo }
     *     
     */
    public VoiceMsgUploadInfo getUpload() {
        return upload;
    }

    /**
     * Define o valor da propriedade upload.
     * 
     * @param value
     *     allowed object is
     *     {@link VoiceMsgUploadInfo }
     *     
     */
    public void setUpload(VoiceMsgUploadInfo value) {
        this.upload = value;
    }

}
