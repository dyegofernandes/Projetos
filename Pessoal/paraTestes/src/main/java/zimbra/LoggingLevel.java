
package zimbra;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de loggingLevel.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="loggingLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="error"/>
 *     &lt;enumeration value="warn"/>
 *     &lt;enumeration value="info"/>
 *     &lt;enumeration value="debug"/>
 *     &lt;enumeration value="trace"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "loggingLevel")
@XmlEnum
public enum LoggingLevel {

    @XmlEnumValue("error")
    ERROR("error"),
    @XmlEnumValue("warn")
    WARN("warn"),
    @XmlEnumValue("info")
    INFO("info"),
    @XmlEnumValue("debug")
    DEBUG("debug"),
    @XmlEnumValue("trace")
    TRACE("trace");
    private final String value;

    LoggingLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LoggingLevel fromValue(String v) {
        for (LoggingLevel c: LoggingLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
