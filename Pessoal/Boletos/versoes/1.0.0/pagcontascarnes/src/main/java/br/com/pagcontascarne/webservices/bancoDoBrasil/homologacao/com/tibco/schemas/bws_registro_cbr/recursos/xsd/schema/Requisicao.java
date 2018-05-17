
package br.com.pagcontascarne.webservices.bancoDoBrasil.homologacao.com.tibco.schemas.bws_registro_cbr.recursos.xsd.schema;

import java.math.BigDecimal;
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
 *         &lt;element name="numeroConvenio" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="9"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="numeroCarteira" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;totalDigits value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="numeroVariacaoCarteira" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;totalDigits value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codigoModalidadeTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;totalDigits value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dataEmissaoTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dataVencimentoTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="valorOriginalTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="17"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codigoTipoDesconto" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;totalDigits value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dataDescontoTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="percentualDescontoTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="5"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="valorDescontoTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="17"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="valorAbatimentoTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="17"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="quantidadeDiaProtesto" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;totalDigits value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codigoTipoJuroMora" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;totalDigits value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="percentualJuroMoraTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="5"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="valorJuroMoraTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="17"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codigoTipoMulta" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;totalDigits value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dataMultaTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="percentualMultaTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="5"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="valorMultaTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="17"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codigoAceiteTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codigoTipoTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;totalDigits value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="textoDescricaoTipoTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="indicadorPermissaoRecebimentoParcial" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="textoNumeroTituloBeneficiario" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="textoCampoUtilizacaoBeneficiario" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="25"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codigoTipoContaCaucao" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;totalDigits value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="textoNumeroTituloCliente" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="textoMensagemBloquetoOcorrencia" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="220"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codigoTipoInscricaoPagador" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;totalDigits value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="numeroInscricaoPagador" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nomePagador" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="textoEnderecoPagador" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="numeroCepPagador" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nomeMunicipioPagador" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nomeBairroPagador" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="siglaUfPagador" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="textoNumeroTelefonePagador" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codigoTipoInscricaoAvalista" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;totalDigits value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="numeroInscricaoAvalista" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;totalDigits value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nomeAvalistaTitulo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codigoChaveUsuario" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="codigoTipoCanalSolicitacao" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *               &lt;totalDigits value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
    "numeroConvenio",
    "numeroCarteira",
    "numeroVariacaoCarteira",
    "codigoModalidadeTitulo",
    "dataEmissaoTitulo",
    "dataVencimentoTitulo",
    "valorOriginalTitulo",
    "codigoTipoDesconto",
    "dataDescontoTitulo",
    "percentualDescontoTitulo",
    "valorDescontoTitulo",
    "valorAbatimentoTitulo",
    "quantidadeDiaProtesto",
    "codigoTipoJuroMora",
    "percentualJuroMoraTitulo",
    "valorJuroMoraTitulo",
    "codigoTipoMulta",
    "dataMultaTitulo",
    "percentualMultaTitulo",
    "valorMultaTitulo",
    "codigoAceiteTitulo",
    "codigoTipoTitulo",
    "textoDescricaoTipoTitulo",
    "indicadorPermissaoRecebimentoParcial",
    "textoNumeroTituloBeneficiario",
    "textoCampoUtilizacaoBeneficiario",
    "codigoTipoContaCaucao",
    "textoNumeroTituloCliente",
    "textoMensagemBloquetoOcorrencia",
    "codigoTipoInscricaoPagador",
    "numeroInscricaoPagador",
    "nomePagador",
    "textoEnderecoPagador",
    "numeroCepPagador",
    "nomeMunicipioPagador",
    "nomeBairroPagador",
    "siglaUfPagador",
    "textoNumeroTelefonePagador",
    "codigoTipoInscricaoAvalista",
    "numeroInscricaoAvalista",
    "nomeAvalistaTitulo",
    "codigoChaveUsuario",
    "codigoTipoCanalSolicitacao"
})
@XmlRootElement(name = "requisicao")
public class Requisicao {

    protected Integer numeroConvenio;
    protected Short numeroCarteira;
    protected Short numeroVariacaoCarteira;
    protected Short codigoModalidadeTitulo;
    protected String dataEmissaoTitulo;
    protected String dataVencimentoTitulo;
    @XmlElement(defaultValue = "0.0")
    protected BigDecimal valorOriginalTitulo;
    protected Short codigoTipoDesconto;
    protected String dataDescontoTitulo;
    @XmlElement(defaultValue = "0.0")
    protected BigDecimal percentualDescontoTitulo;
    @XmlElement(defaultValue = "0.0")
    protected BigDecimal valorDescontoTitulo;
    @XmlElement(defaultValue = "0.0")
    protected BigDecimal valorAbatimentoTitulo;
    @XmlElement(defaultValue = "0")
    protected Short quantidadeDiaProtesto;
    protected Short codigoTipoJuroMora;
    @XmlElement(defaultValue = "0.0")
    protected BigDecimal percentualJuroMoraTitulo;
    @XmlElement(defaultValue = "0.0")
    protected BigDecimal valorJuroMoraTitulo;
    protected Short codigoTipoMulta;
    protected String dataMultaTitulo;
    @XmlElement(defaultValue = "0.0")
    protected BigDecimal percentualMultaTitulo;
    @XmlElement(defaultValue = "0.0")
    protected BigDecimal valorMultaTitulo;
    protected String codigoAceiteTitulo;
    @XmlElement(defaultValue = "0")
    protected Short codigoTipoTitulo;
    protected String textoDescricaoTipoTitulo;
    protected String indicadorPermissaoRecebimentoParcial;
    protected String textoNumeroTituloBeneficiario;
    protected String textoCampoUtilizacaoBeneficiario;
    @XmlElement(defaultValue = "0")
    protected Short codigoTipoContaCaucao;
    protected String textoNumeroTituloCliente;
    protected String textoMensagemBloquetoOcorrencia;
    @XmlElement(defaultValue = "0")
    protected Short codigoTipoInscricaoPagador;
    @XmlElement(defaultValue = "0")
    protected Long numeroInscricaoPagador;
    protected String nomePagador;
    protected String textoEnderecoPagador;
    @XmlElement(defaultValue = "0")
    protected Integer numeroCepPagador;
    protected String nomeMunicipioPagador;
    protected String nomeBairroPagador;
    protected String siglaUfPagador;
    protected String textoNumeroTelefonePagador;
    @XmlElement(defaultValue = "0")
    protected Short codigoTipoInscricaoAvalista;
    @XmlElement(defaultValue = "0")
    protected Long numeroInscricaoAvalista;
    protected String nomeAvalistaTitulo;
    protected String codigoChaveUsuario;
    @XmlElement(defaultValue = "5")
    protected Short codigoTipoCanalSolicitacao;

    /**
     * Obtém o valor da propriedade numeroConvenio.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroConvenio() {
        return numeroConvenio;
    }

    /**
     * Define o valor da propriedade numeroConvenio.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroConvenio(Integer value) {
        this.numeroConvenio = value;
    }

    /**
     * Obtém o valor da propriedade numeroCarteira.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNumeroCarteira() {
        return numeroCarteira;
    }

    /**
     * Define o valor da propriedade numeroCarteira.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNumeroCarteira(Short value) {
        this.numeroCarteira = value;
    }

    /**
     * Obtém o valor da propriedade numeroVariacaoCarteira.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNumeroVariacaoCarteira() {
        return numeroVariacaoCarteira;
    }

    /**
     * Define o valor da propriedade numeroVariacaoCarteira.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNumeroVariacaoCarteira(Short value) {
        this.numeroVariacaoCarteira = value;
    }

    /**
     * Obtém o valor da propriedade codigoModalidadeTitulo.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodigoModalidadeTitulo() {
        return codigoModalidadeTitulo;
    }

    /**
     * Define o valor da propriedade codigoModalidadeTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodigoModalidadeTitulo(Short value) {
        this.codigoModalidadeTitulo = value;
    }

    /**
     * Obtém o valor da propriedade dataEmissaoTitulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataEmissaoTitulo() {
        return dataEmissaoTitulo;
    }

    /**
     * Define o valor da propriedade dataEmissaoTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataEmissaoTitulo(String value) {
        this.dataEmissaoTitulo = value;
    }

    /**
     * Obtém o valor da propriedade dataVencimentoTitulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataVencimentoTitulo() {
        return dataVencimentoTitulo;
    }

    /**
     * Define o valor da propriedade dataVencimentoTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataVencimentoTitulo(String value) {
        this.dataVencimentoTitulo = value;
    }

    /**
     * Obtém o valor da propriedade valorOriginalTitulo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorOriginalTitulo() {
        return valorOriginalTitulo;
    }

    /**
     * Define o valor da propriedade valorOriginalTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorOriginalTitulo(BigDecimal value) {
        this.valorOriginalTitulo = value;
    }

    /**
     * Obtém o valor da propriedade codigoTipoDesconto.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodigoTipoDesconto() {
        return codigoTipoDesconto;
    }

    /**
     * Define o valor da propriedade codigoTipoDesconto.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodigoTipoDesconto(Short value) {
        this.codigoTipoDesconto = value;
    }

    /**
     * Obtém o valor da propriedade dataDescontoTitulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataDescontoTitulo() {
        return dataDescontoTitulo;
    }

    /**
     * Define o valor da propriedade dataDescontoTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataDescontoTitulo(String value) {
        this.dataDescontoTitulo = value;
    }

    /**
     * Obtém o valor da propriedade percentualDescontoTitulo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentualDescontoTitulo() {
        return percentualDescontoTitulo;
    }

    /**
     * Define o valor da propriedade percentualDescontoTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentualDescontoTitulo(BigDecimal value) {
        this.percentualDescontoTitulo = value;
    }

    /**
     * Obtém o valor da propriedade valorDescontoTitulo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorDescontoTitulo() {
        return valorDescontoTitulo;
    }

    /**
     * Define o valor da propriedade valorDescontoTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorDescontoTitulo(BigDecimal value) {
        this.valorDescontoTitulo = value;
    }

    /**
     * Obtém o valor da propriedade valorAbatimentoTitulo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorAbatimentoTitulo() {
        return valorAbatimentoTitulo;
    }

    /**
     * Define o valor da propriedade valorAbatimentoTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorAbatimentoTitulo(BigDecimal value) {
        this.valorAbatimentoTitulo = value;
    }

    /**
     * Obtém o valor da propriedade quantidadeDiaProtesto.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getQuantidadeDiaProtesto() {
        return quantidadeDiaProtesto;
    }

    /**
     * Define o valor da propriedade quantidadeDiaProtesto.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setQuantidadeDiaProtesto(Short value) {
        this.quantidadeDiaProtesto = value;
    }

    /**
     * Obtém o valor da propriedade codigoTipoJuroMora.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodigoTipoJuroMora() {
        return codigoTipoJuroMora;
    }

    /**
     * Define o valor da propriedade codigoTipoJuroMora.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodigoTipoJuroMora(Short value) {
        this.codigoTipoJuroMora = value;
    }

    /**
     * Obtém o valor da propriedade percentualJuroMoraTitulo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentualJuroMoraTitulo() {
        return percentualJuroMoraTitulo;
    }

    /**
     * Define o valor da propriedade percentualJuroMoraTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentualJuroMoraTitulo(BigDecimal value) {
        this.percentualJuroMoraTitulo = value;
    }

    /**
     * Obtém o valor da propriedade valorJuroMoraTitulo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorJuroMoraTitulo() {
        return valorJuroMoraTitulo;
    }

    /**
     * Define o valor da propriedade valorJuroMoraTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorJuroMoraTitulo(BigDecimal value) {
        this.valorJuroMoraTitulo = value;
    }

    /**
     * Obtém o valor da propriedade codigoTipoMulta.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodigoTipoMulta() {
        return codigoTipoMulta;
    }

    /**
     * Define o valor da propriedade codigoTipoMulta.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodigoTipoMulta(Short value) {
        this.codigoTipoMulta = value;
    }

    /**
     * Obtém o valor da propriedade dataMultaTitulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataMultaTitulo() {
        return dataMultaTitulo;
    }

    /**
     * Define o valor da propriedade dataMultaTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataMultaTitulo(String value) {
        this.dataMultaTitulo = value;
    }

    /**
     * Obtém o valor da propriedade percentualMultaTitulo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentualMultaTitulo() {
        return percentualMultaTitulo;
    }

    /**
     * Define o valor da propriedade percentualMultaTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentualMultaTitulo(BigDecimal value) {
        this.percentualMultaTitulo = value;
    }

    /**
     * Obtém o valor da propriedade valorMultaTitulo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorMultaTitulo() {
        return valorMultaTitulo;
    }

    /**
     * Define o valor da propriedade valorMultaTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorMultaTitulo(BigDecimal value) {
        this.valorMultaTitulo = value;
    }

    /**
     * Obtém o valor da propriedade codigoAceiteTitulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoAceiteTitulo() {
        return codigoAceiteTitulo;
    }

    /**
     * Define o valor da propriedade codigoAceiteTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoAceiteTitulo(String value) {
        this.codigoAceiteTitulo = value;
    }

    /**
     * Obtém o valor da propriedade codigoTipoTitulo.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodigoTipoTitulo() {
        return codigoTipoTitulo;
    }

    /**
     * Define o valor da propriedade codigoTipoTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodigoTipoTitulo(Short value) {
        this.codigoTipoTitulo = value;
    }

    /**
     * Obtém o valor da propriedade textoDescricaoTipoTitulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextoDescricaoTipoTitulo() {
        return textoDescricaoTipoTitulo;
    }

    /**
     * Define o valor da propriedade textoDescricaoTipoTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextoDescricaoTipoTitulo(String value) {
        this.textoDescricaoTipoTitulo = value;
    }

    /**
     * Obtém o valor da propriedade indicadorPermissaoRecebimentoParcial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorPermissaoRecebimentoParcial() {
        return indicadorPermissaoRecebimentoParcial;
    }

    /**
     * Define o valor da propriedade indicadorPermissaoRecebimentoParcial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorPermissaoRecebimentoParcial(String value) {
        this.indicadorPermissaoRecebimentoParcial = value;
    }

    /**
     * Obtém o valor da propriedade textoNumeroTituloBeneficiario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextoNumeroTituloBeneficiario() {
        return textoNumeroTituloBeneficiario;
    }

    /**
     * Define o valor da propriedade textoNumeroTituloBeneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextoNumeroTituloBeneficiario(String value) {
        this.textoNumeroTituloBeneficiario = value;
    }

    /**
     * Obtém o valor da propriedade textoCampoUtilizacaoBeneficiario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextoCampoUtilizacaoBeneficiario() {
        return textoCampoUtilizacaoBeneficiario;
    }

    /**
     * Define o valor da propriedade textoCampoUtilizacaoBeneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextoCampoUtilizacaoBeneficiario(String value) {
        this.textoCampoUtilizacaoBeneficiario = value;
    }

    /**
     * Obtém o valor da propriedade codigoTipoContaCaucao.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodigoTipoContaCaucao() {
        return codigoTipoContaCaucao;
    }

    /**
     * Define o valor da propriedade codigoTipoContaCaucao.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodigoTipoContaCaucao(Short value) {
        this.codigoTipoContaCaucao = value;
    }

    /**
     * Obtém o valor da propriedade textoNumeroTituloCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextoNumeroTituloCliente() {
        return textoNumeroTituloCliente;
    }

    /**
     * Define o valor da propriedade textoNumeroTituloCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextoNumeroTituloCliente(String value) {
        this.textoNumeroTituloCliente = value;
    }

    /**
     * Obtém o valor da propriedade textoMensagemBloquetoOcorrencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextoMensagemBloquetoOcorrencia() {
        return textoMensagemBloquetoOcorrencia;
    }

    /**
     * Define o valor da propriedade textoMensagemBloquetoOcorrencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextoMensagemBloquetoOcorrencia(String value) {
        this.textoMensagemBloquetoOcorrencia = value;
    }

    /**
     * Obtém o valor da propriedade codigoTipoInscricaoPagador.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodigoTipoInscricaoPagador() {
        return codigoTipoInscricaoPagador;
    }

    /**
     * Define o valor da propriedade codigoTipoInscricaoPagador.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodigoTipoInscricaoPagador(Short value) {
        this.codigoTipoInscricaoPagador = value;
    }

    /**
     * Obtém o valor da propriedade numeroInscricaoPagador.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroInscricaoPagador() {
        return numeroInscricaoPagador;
    }

    /**
     * Define o valor da propriedade numeroInscricaoPagador.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroInscricaoPagador(Long value) {
        this.numeroInscricaoPagador = value;
    }

    /**
     * Obtém o valor da propriedade nomePagador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomePagador() {
        return nomePagador;
    }

    /**
     * Define o valor da propriedade nomePagador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomePagador(String value) {
        this.nomePagador = value;
    }

    /**
     * Obtém o valor da propriedade textoEnderecoPagador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextoEnderecoPagador() {
        return textoEnderecoPagador;
    }

    /**
     * Define o valor da propriedade textoEnderecoPagador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextoEnderecoPagador(String value) {
        this.textoEnderecoPagador = value;
    }

    /**
     * Obtém o valor da propriedade numeroCepPagador.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroCepPagador() {
        return numeroCepPagador;
    }

    /**
     * Define o valor da propriedade numeroCepPagador.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroCepPagador(Integer value) {
        this.numeroCepPagador = value;
    }

    /**
     * Obtém o valor da propriedade nomeMunicipioPagador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeMunicipioPagador() {
        return nomeMunicipioPagador;
    }

    /**
     * Define o valor da propriedade nomeMunicipioPagador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeMunicipioPagador(String value) {
        this.nomeMunicipioPagador = value;
    }

    /**
     * Obtém o valor da propriedade nomeBairroPagador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeBairroPagador() {
        return nomeBairroPagador;
    }

    /**
     * Define o valor da propriedade nomeBairroPagador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeBairroPagador(String value) {
        this.nomeBairroPagador = value;
    }

    /**
     * Obtém o valor da propriedade siglaUfPagador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaUfPagador() {
        return siglaUfPagador;
    }

    /**
     * Define o valor da propriedade siglaUfPagador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaUfPagador(String value) {
        this.siglaUfPagador = value;
    }

    /**
     * Obtém o valor da propriedade textoNumeroTelefonePagador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextoNumeroTelefonePagador() {
        return textoNumeroTelefonePagador;
    }

    /**
     * Define o valor da propriedade textoNumeroTelefonePagador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextoNumeroTelefonePagador(String value) {
        this.textoNumeroTelefonePagador = value;
    }

    /**
     * Obtém o valor da propriedade codigoTipoInscricaoAvalista.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodigoTipoInscricaoAvalista() {
        return codigoTipoInscricaoAvalista;
    }

    /**
     * Define o valor da propriedade codigoTipoInscricaoAvalista.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodigoTipoInscricaoAvalista(Short value) {
        this.codigoTipoInscricaoAvalista = value;
    }

    /**
     * Obtém o valor da propriedade numeroInscricaoAvalista.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroInscricaoAvalista() {
        return numeroInscricaoAvalista;
    }

    /**
     * Define o valor da propriedade numeroInscricaoAvalista.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroInscricaoAvalista(Long value) {
        this.numeroInscricaoAvalista = value;
    }

    /**
     * Obtém o valor da propriedade nomeAvalistaTitulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeAvalistaTitulo() {
        return nomeAvalistaTitulo;
    }

    /**
     * Define o valor da propriedade nomeAvalistaTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeAvalistaTitulo(String value) {
        this.nomeAvalistaTitulo = value;
    }

    /**
     * Obtém o valor da propriedade codigoChaveUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoChaveUsuario() {
        return codigoChaveUsuario;
    }

    /**
     * Define o valor da propriedade codigoChaveUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoChaveUsuario(String value) {
        this.codigoChaveUsuario = value;
    }

    /**
     * Obtém o valor da propriedade codigoTipoCanalSolicitacao.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodigoTipoCanalSolicitacao() {
        return codigoTipoCanalSolicitacao;
    }

    /**
     * Define o valor da propriedade codigoTipoCanalSolicitacao.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodigoTipoCanalSolicitacao(Short value) {
        this.codigoTipoCanalSolicitacao = value;
    }

}
