
package zimbraadmin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de runUnitTestsResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="runUnitTestsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="results" type="{urn:zimbraAdmin}testResultInfo"/>
 *       &lt;/sequence>
 *       &lt;attribute name="numExecuted" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="numFailed" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "runUnitTestsResponse", propOrder = {
    "results"
})
public class RunUnitTestsResponse {

    @XmlElement(required = true)
    protected TestResultInfo results;
    @XmlAttribute(name = "numExecuted", required = true)
    protected int numExecuted;
    @XmlAttribute(name = "numFailed", required = true)
    protected int numFailed;

    /**
     * Obtém o valor da propriedade results.
     * 
     * @return
     *     possible object is
     *     {@link TestResultInfo }
     *     
     */
    public TestResultInfo getResults() {
        return results;
    }

    /**
     * Define o valor da propriedade results.
     * 
     * @param value
     *     allowed object is
     *     {@link TestResultInfo }
     *     
     */
    public void setResults(TestResultInfo value) {
        this.results = value;
    }

    /**
     * Obtém o valor da propriedade numExecuted.
     * 
     */
    public int getNumExecuted() {
        return numExecuted;
    }

    /**
     * Define o valor da propriedade numExecuted.
     * 
     */
    public void setNumExecuted(int value) {
        this.numExecuted = value;
    }

    /**
     * Obtém o valor da propriedade numFailed.
     * 
     */
    public int getNumFailed() {
        return numFailed;
    }

    /**
     * Define o valor da propriedade numFailed.
     * 
     */
    public void setNumFailed(int value) {
        this.numFailed = value;
    }

}
