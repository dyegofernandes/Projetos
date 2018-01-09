
package zimbraaccount;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de getAppSpecificPasswordsResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="getAppSpecificPasswordsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="appSpecificPasswords" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="passwordData" type="{urn:zimbraAccount}appSpecificPasswordData" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="maxAppPasswords" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAppSpecificPasswordsResponse", propOrder = {

})
public class GetAppSpecificPasswordsResponse {

    protected GetAppSpecificPasswordsResponse.AppSpecificPasswords appSpecificPasswords;
    protected Integer maxAppPasswords;

    /**
     * Obtém o valor da propriedade appSpecificPasswords.
     * 
     * @return
     *     possible object is
     *     {@link GetAppSpecificPasswordsResponse.AppSpecificPasswords }
     *     
     */
    public GetAppSpecificPasswordsResponse.AppSpecificPasswords getAppSpecificPasswords() {
        return appSpecificPasswords;
    }

    /**
     * Define o valor da propriedade appSpecificPasswords.
     * 
     * @param value
     *     allowed object is
     *     {@link GetAppSpecificPasswordsResponse.AppSpecificPasswords }
     *     
     */
    public void setAppSpecificPasswords(GetAppSpecificPasswordsResponse.AppSpecificPasswords value) {
        this.appSpecificPasswords = value;
    }

    /**
     * Obtém o valor da propriedade maxAppPasswords.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxAppPasswords() {
        return maxAppPasswords;
    }

    /**
     * Define o valor da propriedade maxAppPasswords.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxAppPasswords(Integer value) {
        this.maxAppPasswords = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="passwordData" type="{urn:zimbraAccount}appSpecificPasswordData" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="unusedCodeGenHelper" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "passwordData"
    })
    public static class AppSpecificPasswords {

        protected List<AppSpecificPasswordData> passwordData;
        @XmlAttribute(name = "unusedCodeGenHelper")
        protected String unusedCodeGenHelper;

        /**
         * Gets the value of the passwordData property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the passwordData property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPasswordData().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AppSpecificPasswordData }
         * 
         * 
         */
        public List<AppSpecificPasswordData> getPasswordData() {
            if (passwordData == null) {
                passwordData = new ArrayList<AppSpecificPasswordData>();
            }
            return this.passwordData;
        }

        /**
         * Obtém o valor da propriedade unusedCodeGenHelper.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnusedCodeGenHelper() {
            return unusedCodeGenHelper;
        }

        /**
         * Define o valor da propriedade unusedCodeGenHelper.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnusedCodeGenHelper(String value) {
            this.unusedCodeGenHelper = value;
        }

    }

}
