
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de versionCheckResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="versionCheckResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="versionCheck" type="{urn:zimbraAdmin}versionCheckInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "versionCheckResponse", propOrder = {
    "versionCheck"
})
public class VersionCheckResponse {

    protected VersionCheckInfo versionCheck;

    /**
     * Obtém o valor da propriedade versionCheck.
     * 
     * @return
     *     possible object is
     *     {@link VersionCheckInfo }
     *     
     */
    public VersionCheckInfo getVersionCheck() {
        return versionCheck;
    }

    /**
     * Define o valor da propriedade versionCheck.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionCheckInfo }
     *     
     */
    public void setVersionCheck(VersionCheckInfo value) {
        this.versionCheck = value;
    }

}
