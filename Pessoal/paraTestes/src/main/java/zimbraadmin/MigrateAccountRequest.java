
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de migrateAccountRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="migrateAccountRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="migrate" type="{urn:zimbraAdmin}idAndAction"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "migrateAccountRequest", propOrder = {
    "migrate"
})
public class MigrateAccountRequest {

    @XmlElement(required = true)
    protected IdAndAction migrate;

    /**
     * Obtém o valor da propriedade migrate.
     * 
     * @return
     *     possible object is
     *     {@link IdAndAction }
     *     
     */
    public IdAndAction getMigrate() {
        return migrate;
    }

    /**
     * Define o valor da propriedade migrate.
     * 
     * @param value
     *     allowed object is
     *     {@link IdAndAction }
     *     
     */
    public void setMigrate(IdAndAction value) {
        this.migrate = value;
    }

}
