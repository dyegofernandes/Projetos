
package com.tibco.schemas.bws_registro_cbr.recursos.xsd.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd}requisicao"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd}resposta"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd}erro"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "requisicao",
    "resposta",
    "erro"
})
@XmlRootElement(name = "root")
public class Root {

    @XmlElement(required = true)
    protected Requisicao requisicao;
    @XmlElement(required = true)
    protected Resposta resposta;
    @XmlElement(required = true)
    protected Erro erro;

    /**
     * Obtém o valor da propriedade requisicao.
     * 
     * @return
     *     possible object is
     *     {@link Requisicao }
     *     
     */
    public Requisicao getRequisicao() {
        return requisicao;
    }

    /**
     * Define o valor da propriedade requisicao.
     * 
     * @param value
     *     allowed object is
     *     {@link Requisicao }
     *     
     */
    public void setRequisicao(Requisicao value) {
        this.requisicao = value;
    }

    /**
     * Obtém o valor da propriedade resposta.
     * 
     * @return
     *     possible object is
     *     {@link Resposta }
     *     
     */
    public Resposta getResposta() {
        return resposta;
    }

    /**
     * Define o valor da propriedade resposta.
     * 
     * @param value
     *     allowed object is
     *     {@link Resposta }
     *     
     */
    public void setResposta(Resposta value) {
        this.resposta = value;
    }

    /**
     * Obtém o valor da propriedade erro.
     * 
     * @return
     *     possible object is
     *     {@link Erro }
     *     
     */
    public Erro getErro() {
        return erro;
    }

    /**
     * Define o valor da propriedade erro.
     * 
     * @param value
     *     allowed object is
     *     {@link Erro }
     *     
     */
    public void setErro(Erro value) {
        this.erro = value;
    }

}
