
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de activateLicenseResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="activateLicenseResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="serverTime" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activateLicenseResponse")
public class ActivateLicenseResponse {

    @XmlAttribute(name = "serverTime", required = true)
    protected long serverTime;

    /**
     * Obtém o valor da propriedade serverTime.
     * 
     */
    public long getServerTime() {
        return serverTime;
    }

    /**
     * Define o valor da propriedade serverTime.
     * 
     */
    public void setServerTime(long value) {
        this.serverTime = value;
    }

}
