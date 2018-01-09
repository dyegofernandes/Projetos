
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de mailboxVersionInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="mailboxVersionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="mbxid" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="majorVer" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="minorVer" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="dbVer" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="indexVer" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mailboxVersionInfo")
public class MailboxVersionInfo {

    @XmlAttribute(name = "mbxid", required = true)
    protected int mbxid;
    @XmlAttribute(name = "majorVer", required = true)
    protected short majorVer;
    @XmlAttribute(name = "minorVer", required = true)
    protected short minorVer;
    @XmlAttribute(name = "dbVer", required = true)
    protected int dbVer;
    @XmlAttribute(name = "indexVer", required = true)
    protected int indexVer;

    /**
     * Obtém o valor da propriedade mbxid.
     * 
     */
    public int getMbxid() {
        return mbxid;
    }

    /**
     * Define o valor da propriedade mbxid.
     * 
     */
    public void setMbxid(int value) {
        this.mbxid = value;
    }

    /**
     * Obtém o valor da propriedade majorVer.
     * 
     */
    public short getMajorVer() {
        return majorVer;
    }

    /**
     * Define o valor da propriedade majorVer.
     * 
     */
    public void setMajorVer(short value) {
        this.majorVer = value;
    }

    /**
     * Obtém o valor da propriedade minorVer.
     * 
     */
    public short getMinorVer() {
        return minorVer;
    }

    /**
     * Define o valor da propriedade minorVer.
     * 
     */
    public void setMinorVer(short value) {
        this.minorVer = value;
    }

    /**
     * Obtém o valor da propriedade dbVer.
     * 
     */
    public int getDbVer() {
        return dbVer;
    }

    /**
     * Define o valor da propriedade dbVer.
     * 
     */
    public void setDbVer(int value) {
        this.dbVer = value;
    }

    /**
     * Obtém o valor da propriedade indexVer.
     * 
     */
    public int getIndexVer() {
        return indexVer;
    }

    /**
     * Define o valor da propriedade indexVer.
     * 
     */
    public void setIndexVer(int value) {
        this.indexVer = value;
    }

}
