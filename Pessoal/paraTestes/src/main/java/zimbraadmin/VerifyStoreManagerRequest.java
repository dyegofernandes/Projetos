
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de verifyStoreManagerRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="verifyStoreManagerRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="fileSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="num" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="checkBlobs" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifyStoreManagerRequest")
public class VerifyStoreManagerRequest {

    @XmlAttribute(name = "fileSize")
    protected Integer fileSize;
    @XmlAttribute(name = "num")
    protected Integer num;
    @XmlAttribute(name = "checkBlobs")
    protected Boolean checkBlobs;

    /**
     * Obtém o valor da propriedade fileSize.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     * Define o valor da propriedade fileSize.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFileSize(Integer value) {
        this.fileSize = value;
    }

    /**
     * Obtém o valor da propriedade num.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNum() {
        return num;
    }

    /**
     * Define o valor da propriedade num.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNum(Integer value) {
        this.num = value;
    }

    /**
     * Obtém o valor da propriedade checkBlobs.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCheckBlobs() {
        return checkBlobs;
    }

    /**
     * Define o valor da propriedade checkBlobs.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCheckBlobs(Boolean value) {
        this.checkBlobs = value;
    }

}
