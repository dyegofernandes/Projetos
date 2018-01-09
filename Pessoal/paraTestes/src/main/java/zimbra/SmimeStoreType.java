
package zimbra;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de smimeStoreType.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="smimeStoreType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CONTACT"/>
 *     &lt;enumeration value="GAL"/>
 *     &lt;enumeration value="LDAP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "smimeStoreType")
@XmlEnum
public enum SmimeStoreType {

    CONTACT,
    GAL,
    LDAP;

    public String value() {
        return name();
    }

    public static SmimeStoreType fromValue(String v) {
        return valueOf(v);
    }

}