
package zimbraaccount;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de memberOfSelector.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="memberOfSelector">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="all"/>
 *     &lt;enumeration value="directOnly"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "memberOfSelector")
@XmlEnum
public enum MemberOfSelector {

    @XmlEnumValue("all")
    ALL("all"),
    @XmlEnumValue("directOnly")
    DIRECT_ONLY("directOnly"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    MemberOfSelector(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MemberOfSelector fromValue(String v) {
        for (MemberOfSelector c: MemberOfSelector.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
