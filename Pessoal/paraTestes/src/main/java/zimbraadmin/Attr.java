
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import zimbra.KeyValuePair;


/**
 * <p>Classe Java de attr complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="attr">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:zimbra>keyValuePair">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attr")
@XmlSeeAlso({
    CosInfoAttr.class
})
public class Attr
    extends KeyValuePair
{


}
