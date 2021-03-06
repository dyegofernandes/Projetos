
package zimbra;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de storeLookupOpt.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="storeLookupOpt">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ANY"/>
 *     &lt;enumeration value="ALL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "storeLookupOpt")
@XmlEnum
public enum StoreLookupOpt {

    ANY,
    ALL;

    public String value() {
        return name();
    }

    public static StoreLookupOpt fromValue(String v) {
        return valueOf(v);
    }

}
