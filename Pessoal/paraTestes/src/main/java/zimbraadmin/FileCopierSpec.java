
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de fileCopierSpec complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="fileCopierSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="fcMethod" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fcIOType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fcOIOCopyBufferSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="fcAsyncQueueCapacity" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="fcParallelWorkers" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="fcPipes" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="fcPipeBufferSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="fcPipeReadersPerPipe" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="fcPipeWritersPerPipe" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fileCopierSpec")
public class FileCopierSpec {

    @XmlAttribute(name = "fcMethod")
    protected String fcMethod;
    @XmlAttribute(name = "fcIOType")
    protected String fcIOType;
    @XmlAttribute(name = "fcOIOCopyBufferSize")
    protected Integer fcOIOCopyBufferSize;
    @XmlAttribute(name = "fcAsyncQueueCapacity")
    protected Integer fcAsyncQueueCapacity;
    @XmlAttribute(name = "fcParallelWorkers")
    protected Integer fcParallelWorkers;
    @XmlAttribute(name = "fcPipes")
    protected Integer fcPipes;
    @XmlAttribute(name = "fcPipeBufferSize")
    protected Integer fcPipeBufferSize;
    @XmlAttribute(name = "fcPipeReadersPerPipe")
    protected Integer fcPipeReadersPerPipe;
    @XmlAttribute(name = "fcPipeWritersPerPipe")
    protected Integer fcPipeWritersPerPipe;

    /**
     * Obtém o valor da propriedade fcMethod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcMethod() {
        return fcMethod;
    }

    /**
     * Define o valor da propriedade fcMethod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcMethod(String value) {
        this.fcMethod = value;
    }

    /**
     * Obtém o valor da propriedade fcIOType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcIOType() {
        return fcIOType;
    }

    /**
     * Define o valor da propriedade fcIOType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcIOType(String value) {
        this.fcIOType = value;
    }

    /**
     * Obtém o valor da propriedade fcOIOCopyBufferSize.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFcOIOCopyBufferSize() {
        return fcOIOCopyBufferSize;
    }

    /**
     * Define o valor da propriedade fcOIOCopyBufferSize.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFcOIOCopyBufferSize(Integer value) {
        this.fcOIOCopyBufferSize = value;
    }

    /**
     * Obtém o valor da propriedade fcAsyncQueueCapacity.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFcAsyncQueueCapacity() {
        return fcAsyncQueueCapacity;
    }

    /**
     * Define o valor da propriedade fcAsyncQueueCapacity.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFcAsyncQueueCapacity(Integer value) {
        this.fcAsyncQueueCapacity = value;
    }

    /**
     * Obtém o valor da propriedade fcParallelWorkers.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFcParallelWorkers() {
        return fcParallelWorkers;
    }

    /**
     * Define o valor da propriedade fcParallelWorkers.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFcParallelWorkers(Integer value) {
        this.fcParallelWorkers = value;
    }

    /**
     * Obtém o valor da propriedade fcPipes.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFcPipes() {
        return fcPipes;
    }

    /**
     * Define o valor da propriedade fcPipes.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFcPipes(Integer value) {
        this.fcPipes = value;
    }

    /**
     * Obtém o valor da propriedade fcPipeBufferSize.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFcPipeBufferSize() {
        return fcPipeBufferSize;
    }

    /**
     * Define o valor da propriedade fcPipeBufferSize.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFcPipeBufferSize(Integer value) {
        this.fcPipeBufferSize = value;
    }

    /**
     * Obtém o valor da propriedade fcPipeReadersPerPipe.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFcPipeReadersPerPipe() {
        return fcPipeReadersPerPipe;
    }

    /**
     * Define o valor da propriedade fcPipeReadersPerPipe.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFcPipeReadersPerPipe(Integer value) {
        this.fcPipeReadersPerPipe = value;
    }

    /**
     * Obtém o valor da propriedade fcPipeWritersPerPipe.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFcPipeWritersPerPipe() {
        return fcPipeWritersPerPipe;
    }

    /**
     * Define o valor da propriedade fcPipeWritersPerPipe.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFcPipeWritersPerPipe(Integer value) {
        this.fcPipeWritersPerPipe = value;
    }

}
