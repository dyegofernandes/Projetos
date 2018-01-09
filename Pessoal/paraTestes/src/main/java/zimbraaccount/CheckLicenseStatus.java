
package zimbraaccount;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de checkLicenseStatus.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="checkLicenseStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ok"/>
 *     &lt;enumeration value="no"/>
 *     &lt;enumeration value="inGracePeriod"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "checkLicenseStatus")
@XmlEnum
public enum CheckLicenseStatus {

    @XmlEnumValue("ok")
    OK("ok"),
    @XmlEnumValue("no")
    NO("no"),
    @XmlEnumValue("inGracePeriod")
    IN_GRACE_PERIOD("inGracePeriod");
    private final String value;

    CheckLicenseStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CheckLicenseStatus fromValue(String v) {
        for (CheckLicenseStatus c: CheckLicenseStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
