
package zimbraadmin;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de dedupStatus.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="dedupStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="running"/>
 *     &lt;enumeration value="stopped"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dedupStatus")
@XmlEnum
public enum DedupStatus {

    @XmlEnumValue("running")
    RUNNING("running"),
    @XmlEnumValue("stopped")
    STOPPED("stopped");
    private final String value;

    DedupStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DedupStatus fromValue(String v) {
        for (DedupStatus c: DedupStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
