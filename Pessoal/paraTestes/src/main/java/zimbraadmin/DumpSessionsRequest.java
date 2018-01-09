
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de dumpSessionsRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dumpSessionsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="listSessions" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="groupByAccount" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dumpSessionsRequest")
public class DumpSessionsRequest {

    @XmlAttribute(name = "listSessions")
    protected Boolean listSessions;
    @XmlAttribute(name = "groupByAccount")
    protected Boolean groupByAccount;

    /**
     * Obtém o valor da propriedade listSessions.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isListSessions() {
        return listSessions;
    }

    /**
     * Define o valor da propriedade listSessions.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setListSessions(Boolean value) {
        this.listSessions = value;
    }

    /**
     * Obtém o valor da propriedade groupByAccount.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGroupByAccount() {
        return groupByAccount;
    }

    /**
     * Define o valor da propriedade groupByAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGroupByAccount(Boolean value) {
        this.groupByAccount = value;
    }

}
