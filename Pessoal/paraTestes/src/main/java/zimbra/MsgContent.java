
package zimbra;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de msgContent.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="msgContent">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="full"/>
 *     &lt;enumeration value="original"/>
 *     &lt;enumeration value="both"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "msgContent")
@XmlEnum
public enum MsgContent {

    @XmlEnumValue("full")
    FULL("full"),
    @XmlEnumValue("original")
    ORIGINAL("original"),
    @XmlEnumValue("both")
    BOTH("both");
    private final String value;

    MsgContent(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MsgContent fromValue(String v) {
        for (MsgContent c: MsgContent.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
