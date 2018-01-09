
package zimbra;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import zimbramail.CalDataSourceId;
import zimbramail.CaldavDataSourceId;
import zimbramail.GalDataSourceId;
import zimbramail.ImapDataSourceId;
import zimbramail.Pop3DataSourceId;
import zimbramail.RssDataSourceId;
import zimbramail.UnknownDataSourceId;
import zimbramail.YabDataSourceId;


/**
 * <p>Classe Java de id complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="id">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "id")
@XmlSeeAlso({
    GalDataSourceId.class,
    Pop3DataSourceId.class,
    CalDataSourceId.class,
    ImapDataSourceId.class,
    UnknownDataSourceId.class,
    YabDataSourceId.class,
    CaldavDataSourceId.class,
    RssDataSourceId.class
})
public class Id {

    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
