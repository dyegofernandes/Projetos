/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facilpagar.modelo.dados.vos;

import java.io.Serializable;

/**
 *
 * @author Juniel
 */
public class RespostaArquivoBancoVO implements Serializable{
    
    private String siglaSistemaMensagem;
    
    private String codigoRetornoPrograma;
    
    private String nomeProgramaErro;
    
    private String textoMensagemErro;
    
    private String numeroPosicaoErroPrograma;
    
    private String codigoTipoRetornoPrograma;
    
    private String textoNumeroTituloCobrancaBb;
    
    private String numeroCarteiraCobranca;
    
    private String numeroVariacaoCarteiraCobranca;
    
    private String codigoPrefixoDependenciaBeneficiario;
    
    private String numeroContaCorrenteBeneficiario;
    
    private String codigoCliente;
    
    private String linhaDigitavel;
    
    private String codigoBarraNumerico;
    
    private String codigoTipoEnderecoBeneficiario;
    
    private String nomeLogradouroBeneficiario;
    
    private String nomeBairroBeneficiario;
    
    private String nomeMunicipioBeneficiario;
    
    private String codigoMunicipioBeneficiario;
    
    private String siglaUfBeneficiario;
    
    private String codigoCepBeneficiario;
    
    private String indicadorComprovacaoBeneficiario;
    
    private String numeroContratoCobranca;

    public String getSiglaSistemaMensagem() {
        return siglaSistemaMensagem;
    }

    public void setSiglaSistemaMensagem(String siglaSistemaMensagem) {
        this.siglaSistemaMensagem = siglaSistemaMensagem;
    }

    public String getCodigoRetornoPrograma() {
        return codigoRetornoPrograma;
    }

    public void setCodigoRetornoPrograma(String codigoRetornoPrograma) {
        this.codigoRetornoPrograma = codigoRetornoPrograma;
    }

    public String getNomeProgramaErro() {
        return nomeProgramaErro;
    }

    public void setNomeProgramaErro(String nomeProgramaErro) {
        this.nomeProgramaErro = nomeProgramaErro;
    }

    public String getTextoMensagemErro() {
        return textoMensagemErro;
    }

    public void setTextoMensagemErro(String textoMensagemErro) {
        this.textoMensagemErro = textoMensagemErro;
    }

    public String getNumeroPosicaoErroPrograma() {
        return numeroPosicaoErroPrograma;
    }

    public void setNumeroPosicaoErroPrograma(String numeroPosicaoErroPrograma) {
        this.numeroPosicaoErroPrograma = numeroPosicaoErroPrograma;
    }

    public String getCodigoTipoRetornoPrograma() {
        return codigoTipoRetornoPrograma;
    }

    public void setCodigoTipoRetornoPrograma(String codigoTipoRetornoPrograma) {
        this.codigoTipoRetornoPrograma = codigoTipoRetornoPrograma;
    }

    public String getTextoNumeroTituloCobrancaBb() {
        return textoNumeroTituloCobrancaBb;
    }

    public void setTextoNumeroTituloCobrancaBb(String textoNumeroTituloCobrancaBb) {
        this.textoNumeroTituloCobrancaBb = textoNumeroTituloCobrancaBb;
    }

    public String getNumeroCarteiraCobranca() {
        return numeroCarteiraCobranca;
    }

    public void setNumeroCarteiraCobranca(String numeroCarteiraCobranca) {
        this.numeroCarteiraCobranca = numeroCarteiraCobranca;
    }

    public String getNumeroVariacaoCarteiraCobranca() {
        return numeroVariacaoCarteiraCobranca;
    }

    public void setNumeroVariacaoCarteiraCobranca(String numeroVariacaoCarteiraCobranca) {
        this.numeroVariacaoCarteiraCobranca = numeroVariacaoCarteiraCobranca;
    }

    public String getCodigoPrefixoDependenciaBeneficiario() {
        return codigoPrefixoDependenciaBeneficiario;
    }

    public void setCodigoPrefixoDependenciaBeneficiario(String codigoPrefixoDependenciaBeneficiario) {
        this.codigoPrefixoDependenciaBeneficiario = codigoPrefixoDependenciaBeneficiario;
    }

    public String getNumeroContaCorrenteBeneficiario() {
        return numeroContaCorrenteBeneficiario;
    }

    public void setNumeroContaCorrenteBeneficiario(String numeroContaCorrenteBeneficiario) {
        this.numeroContaCorrenteBeneficiario = numeroContaCorrenteBeneficiario;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getLinhaDigitavel() {
        return linhaDigitavel;
    }

    public void setLinhaDigitavel(String linhaDigitavel) {
        this.linhaDigitavel = linhaDigitavel;
    }

    public String getCodigoBarraNumerico() {
        return codigoBarraNumerico;
    }

    public void setCodigoBarraNumerico(String codigoBarraNumerico) {
        this.codigoBarraNumerico = codigoBarraNumerico;
    }

    public String getCodigoTipoEnderecoBeneficiario() {
        return codigoTipoEnderecoBeneficiario;
    }

    public void setCodigoTipoEnderecoBeneficiario(String codigoTipoEnderecoBeneficiario) {
        this.codigoTipoEnderecoBeneficiario = codigoTipoEnderecoBeneficiario;
    }

    public String getNomeLogradouroBeneficiario() {
        return nomeLogradouroBeneficiario;
    }

    public void setNomeLogradouroBeneficiario(String nomeLogradouroBeneficiario) {
        this.nomeLogradouroBeneficiario = nomeLogradouroBeneficiario;
    }

    public String getNomeBairroBeneficiario() {
        return nomeBairroBeneficiario;
    }

    public void setNomeBairroBeneficiario(String nomeBairroBeneficiario) {
        this.nomeBairroBeneficiario = nomeBairroBeneficiario;
    }

    public String getNomeMunicipioBeneficiario() {
        return nomeMunicipioBeneficiario;
    }

    public void setNomeMunicipioBeneficiario(String nomeMunicipioBeneficiario) {
        this.nomeMunicipioBeneficiario = nomeMunicipioBeneficiario;
    }

    public String getCodigoMunicipioBeneficiario() {
        return codigoMunicipioBeneficiario;
    }

    public void setCodigoMunicipioBeneficiario(String codigoMunicipioBeneficiario) {
        this.codigoMunicipioBeneficiario = codigoMunicipioBeneficiario;
    }

    public String getSiglaUfBeneficiario() {
        return siglaUfBeneficiario;
    }

    public void setSiglaUfBeneficiario(String siglaUfBeneficiario) {
        this.siglaUfBeneficiario = siglaUfBeneficiario;
    }

    public String getCodigoCepBeneficiario() {
        return codigoCepBeneficiario;
    }

    public void setCodigoCepBeneficiario(String codigoCepBeneficiario) {
        this.codigoCepBeneficiario = codigoCepBeneficiario;
    }

    public String getIndicadorComprovacaoBeneficiario() {
        return indicadorComprovacaoBeneficiario;
    }

    public void setIndicadorComprovacaoBeneficiario(String indicadorComprovacaoBeneficiario) {
        this.indicadorComprovacaoBeneficiario = indicadorComprovacaoBeneficiario;
    }

    public String getNumeroContratoCobranca() {
        return numeroContratoCobranca;
    }

    public void setNumeroContratoCobranca(String numeroContratoCobranca) {
        this.numeroContratoCobranca = numeroContratoCobranca;
    }
    
    
}
