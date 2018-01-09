
package zimbramail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de mailImapDataSource complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="mailImapDataSource">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:zimbraMail}mailDataSource">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="oauthToken" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="clientId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="clientSecret" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="refreshToken" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="refreshTokenUrl" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="test" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mailImapDataSource")
public class MailImapDataSource
    extends MailDataSource
{

    @XmlAttribute(name = "oauthToken")
    protected String oauthToken;
    @XmlAttribute(name = "clientId")
    protected String clientId;
    @XmlAttribute(name = "clientSecret")
    protected String clientSecret;
    @XmlAttribute(name = "refreshToken")
    protected String refreshToken;
    @XmlAttribute(name = "refreshTokenUrl")
    protected String refreshTokenUrl;
    @XmlAttribute(name = "test")
    protected Boolean test;

    /**
     * Obtém o valor da propriedade oauthToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOauthToken() {
        return oauthToken;
    }

    /**
     * Define o valor da propriedade oauthToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOauthToken(String value) {
        this.oauthToken = value;
    }

    /**
     * Obtém o valor da propriedade clientId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Define o valor da propriedade clientId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientId(String value) {
        this.clientId = value;
    }

    /**
     * Obtém o valor da propriedade clientSecret.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * Define o valor da propriedade clientSecret.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientSecret(String value) {
        this.clientSecret = value;
    }

    /**
     * Obtém o valor da propriedade refreshToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Define o valor da propriedade refreshToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefreshToken(String value) {
        this.refreshToken = value;
    }

    /**
     * Obtém o valor da propriedade refreshTokenUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefreshTokenUrl() {
        return refreshTokenUrl;
    }

    /**
     * Define o valor da propriedade refreshTokenUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefreshTokenUrl(String value) {
        this.refreshTokenUrl = value;
    }

    /**
     * Obtém o valor da propriedade test.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTest() {
        return test;
    }

    /**
     * Define o valor da propriedade test.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTest(Boolean value) {
        this.test = value;
    }

}
