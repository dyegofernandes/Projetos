
package zimbraadmin;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de galMode.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="galMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="both"/>
 *     &lt;enumeration value="ldap"/>
 *     &lt;enumeration value="zimbra"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "galMode")
@XmlEnum
public enum GalMode {

    @XmlEnumValue("both")
    BOTH("both"),
    @XmlEnumValue("ldap")
    LDAP("ldap"),
    @XmlEnumValue("zimbra")
    ZIMBRA("zimbra");
    private final String value;

    GalMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GalMode fromValue(String v) {
        for (GalMode c: GalMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
