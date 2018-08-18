/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facilpagar.modelo.dados.vos;

import br.com.facilpagar.modelo.dados.Boleto;
import br.com.facilpagar.modelo.dados.Cliente;
import br.com.facilpagar.modelo.dados.Sistema;
import br.com.facilpagar.util.Utils;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Juniel
 */
public class ArquivoBancoVO implements Serializable {

    private String numeroConvenio; //sistema.numeroconvenio_bb
    private String numeroCarteira; //sistema.numerocarteira_bb
    private String numeroVariacaoCarteira; //sistema.numerovariacaocarteira_bb
    private String codigoModalidadeTitulo = "1"; //1
    private String dataEmissaoTitulo; //boleto.dt_criacao,'DD.MM.YYYY'
    private String dataVencimentoTitulo; //boleto.dt_vencimento,'DD.MM.YYYY'
    private String valorOriginalTitulo; //boleto.vl_nominal as numeric(15,2)
    private String codigoTipoDesconto;//1 se boleto.vl_desconto>0 se não 0
    private String dataDescontoTitulo; //boleto.dt_vencimento,'DD.MM.YYYY' se boleto.vl_desconto>0
    private String valorDescontoTitulo; //boleto.vl_desconto as numeric(15,2) se boleto.vl_desconto>0
    private String codigoTipoJuroMora = "1"; //1
    private String valorJuroMoraTitulo;//boleto.vl_juros as numeric(3,2)
    private String codigoTipoMulta = "1";//1
    private String dataMultaTitulo;//boleto.dt_vencimento+1,'DD.MM.YYYY'
    private String valorMultaTitulo;//boleto.vl_multa as numeric(15,2)
    private String codigoAceiteTitulo = "N";//N
    private String codigoTipoTitulo = "2";//2
    private String textoDescricaoTipoTitulo = "DM";//DM
    private String indicadorPermissaoRecebimentoParcial = "N";//N
    private String textoNumeroTituloCliente;//'000'||sistema.numeroconvenio_bb||lpad(cast(boleto.nossonumero as varchar(10)),10,'0')
    private String codigoTipoInscricaoPagador;//cliente.tipo_pessoa.num
    private String numeroInscricaoPagador; //cliente.cpf_cnpj
    private String nomePagador;//substring(cliente.completo_razao_social,1,60)
    private String textoEnderecoPagador = "Não informado";//coalesce(trim(cliente.endereco),'Não informado') 
    private String numeroCepPagador = "00000000";//coalesce(REGEXP_REPLACE(c.cep,'[-]','','g'),'00000000')
    private String nomeMunicipioPagador = "Não Informado";//coalesce(cliente.cidade.nome,'Não Informado')
    private String nomeBairroPagador = "Não Informado";//coalesce(c.bairro,'Não Informado')
    private String siglaUfPagador = "NN"; //coalesce(cliente.cidade.uf.sigla,'NN')
    private String codigoChaveUsuario;//sistema.chaveusuario_bb
    private String codigoTipoCanalSolicitacao = "5";//5

    public ArquivoBancoVO(Sistema sistema, Boleto boleto, Cliente cliente, String cidade, String estado) {
        this.numeroConvenio = sistema.getNumeroConvenio_BB(); //sistema.numeroconvenio_bb=null=null;
        this.numeroCarteira = sistema.getNumeroCarteira_BB(); //sistema.numerocarteira_bb
        this.numeroVariacaoCarteira = sistema.getNumeroVariacaoCarteira_BB(); //sistema.numerovariacaocarteira_bb
        this.codigoModalidadeTitulo = "1"; //1
        this.dataEmissaoTitulo = Utils.convertDateToString(boleto.getDt_criacao(), "dd.MM.yyyy"); //boleto.dt_criacao,'DD.MM.YYYY'
        this.dataVencimentoTitulo = Utils.convertDateToString(boleto.getDt_vencimento(), "dd.MM.yyyy"); //boleto.dt_vencimento,'DD.MM.YYYY'
        this.valorOriginalTitulo = boleto.getVl_nominal().toString(); //boleto.vl_nominal as numeric(15,2)
        this.codigoTipoDesconto = boleto.getVl_desconto() != null ? boleto.getVl_desconto().compareTo(BigDecimal.ZERO) > 0 ? "1" : "0" : "0";//1 se boleto.vl_desconto>0 se não 0
        this.dataDescontoTitulo = boleto.getVl_desconto() != null ? boleto.getVl_desconto().compareTo(BigDecimal.ZERO) > 0 ? Utils.convertDateToString(boleto.getDt_vencimento(), "dd.MM.yyyy") : "" : "";; //boleto.dt_vencimento,'DD.MM.YYYY' se boleto.vl_desconto>0
        this.valorDescontoTitulo = boleto.getVl_desconto() != null ? boleto.getVl_desconto().compareTo(BigDecimal.ZERO) > 0 ? boleto.getVl_desconto() != null ? boleto.getVl_desconto().toString() : "" : "" : ""; //boleto.vl_desconto as numeric(15,2) se boleto.vl_desconto>0
        this.codigoTipoJuroMora = "1"; //1
        this.valorJuroMoraTitulo = boleto.getVl_juros().toString();//boleto.vl_juros as numeric(3,2)
        this.codigoTipoMulta = "1";//1
        this.dataMultaTitulo = null;//boleto.dt_vencimento+1,'DD.MM.YYYY'
        this.valorMultaTitulo = boleto.getVl_multa().toString();//boleto.vl_multa as numeric(15,2)
        this.codigoAceiteTitulo = "N";//N
        this.codigoTipoTitulo = "2";//2
        this.textoDescricaoTipoTitulo = "DM";//DM
        this.indicadorPermissaoRecebimentoParcial = "N";//N
        this.textoNumeroTituloCliente = null;//'000'||sistema.numeroconvenio_bb||lpad(cast(boleto.nossonumero as varchar(10)),10,'0')
        this.codigoTipoInscricaoPagador = null;//cliente.tipo_pessoa.num
        this.numeroInscricaoPagador = null; //cliente.cpf_cnpj
        this.nomePagador = null;//substring(cliente.completo_razao_social,1,60)
        this.textoEnderecoPagador = null;//coalesce(trim(cliente.endereco),'Não informado') 
        this.numeroCepPagador = null;//coalesce(REGEXP_REPLACE(c.cep,'[-]','','g'),'00000000')
        this.nomeMunicipioPagador = null;//coalesce(cliente.cidade.nome,'Não Informado')
        this.nomeBairroPagador = null;//coalesce(c.bairro,'Não Informado')
        this.siglaUfPagador = null; //coalesce(cliente.cidade.uf.sigla,'NN')
        this.codigoChaveUsuario = null;//sistema.chaveusuario_bb
        this.codigoTipoCanalSolicitacao = "5";//5
    }

    //        this.codigoChaveUsuario = Utils.isNullOrEmpty(codigoChaveUsuario) ? "5" : codigoChaveUsuario;
    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public String getNumeroCarteira() {
        return numeroCarteira;
    }

    public void setNumeroCarteira(String numeroCarteira) {
        this.numeroCarteira = numeroCarteira;
    }

    public String getNumeroVariacaoCarteira() {
        return numeroVariacaoCarteira;
    }

    public void setNumeroVariacaoCarteira(String numeroVariacaoCarteira) {
        this.numeroVariacaoCarteira = numeroVariacaoCarteira;
    }

    public String getCodigoModalidadeTitulo() {
        return codigoModalidadeTitulo;
    }

    public void setCodigoModalidadeTitulo(String codigoModalidadeTitulo) {
        this.codigoModalidadeTitulo = codigoModalidadeTitulo;
    }

    public String getDataEmissaoTitulo() {
        return dataEmissaoTitulo;
    }

    public void setDataEmissaoTitulo(String dataEmissaoTitulo) {
        this.dataEmissaoTitulo = dataEmissaoTitulo;
    }

    public String getDataVencimentoTitulo() {
        return dataVencimentoTitulo;
    }

    public void setDataVencimentoTitulo(String dataVencimentoTitulo) {
        this.dataVencimentoTitulo = dataVencimentoTitulo;
    }

    public String getValorOriginalTitulo() {
        return valorOriginalTitulo;
    }

    public void setValorOriginalTitulo(String valorOriginalTitulo) {
        this.valorOriginalTitulo = valorOriginalTitulo;
    }

    public String getCodigoTipoDesconto() {
        return codigoTipoDesconto;
    }

    public void setCodigoTipoDesconto(String codigoTipoDesconto) {
        this.codigoTipoDesconto = codigoTipoDesconto;
    }

    public String getDataDescontoTitulo() {
        return dataDescontoTitulo;
    }

    public void setDataDescontoTitulo(String dataDescontoTitulo) {
        this.dataDescontoTitulo = dataDescontoTitulo;
    }

    public String getValorDescontoTitulo() {
        return valorDescontoTitulo;
    }

    public void setValorDescontoTitulo(String valorDescontoTitulo) {
        this.valorDescontoTitulo = valorDescontoTitulo;
    }

    public String getCodigoTipoJuroMora() {
        return codigoTipoJuroMora;
    }

    public void setCodigoTipoJuroMora(String codigoTipoJuroMora) {
        this.codigoTipoJuroMora = codigoTipoJuroMora;
    }

    public String getValorJuroMoraTitulo() {
        return valorJuroMoraTitulo;
    }

    public void setValorJuroMoraTitulo(String valorJuroMoraTitulo) {
        this.valorJuroMoraTitulo = valorJuroMoraTitulo;
    }

    public String getCodigoTipoMulta() {
        return codigoTipoMulta;
    }

    public void setCodigoTipoMulta(String codigoTipoMulta) {
        this.codigoTipoMulta = codigoTipoMulta;
    }

    public String getDataMultaTitulo() {
        return dataMultaTitulo;
    }

    public void setDataMultaTitulo(String dataMultaTitulo) {
        this.dataMultaTitulo = dataMultaTitulo;
    }

    public String getValorMultaTitulo() {
        return valorMultaTitulo;
    }

    public void setValorMultaTitulo(String valorMultaTitulo) {
        this.valorMultaTitulo = valorMultaTitulo;
    }

    public String getCodigoAceiteTitulo() {
        return codigoAceiteTitulo;
    }

    public void setCodigoAceiteTitulo(String codigoAceiteTitulo) {
        this.codigoAceiteTitulo = codigoAceiteTitulo;
    }

    public String getCodigoTipoTitulo() {
        return codigoTipoTitulo;
    }

    public void setCodigoTipoTitulo(String codigoTipoTitulo) {
        this.codigoTipoTitulo = codigoTipoTitulo;
    }

    public String getTextoDescricaoTipoTitulo() {
        return textoDescricaoTipoTitulo;
    }

    public void setTextoDescricaoTipoTitulo(String textoDescricaoTipoTitulo) {
        this.textoDescricaoTipoTitulo = textoDescricaoTipoTitulo;
    }

    public String getIndicadorPermissaoRecebimentoParcial() {
        return indicadorPermissaoRecebimentoParcial;
    }

    public void setIndicadorPermissaoRecebimentoParcial(String indicadorPermissaoRecebimentoParcial) {
        this.indicadorPermissaoRecebimentoParcial = indicadorPermissaoRecebimentoParcial;
    }

    public String getTextoNumeroTituloCliente() {
        return textoNumeroTituloCliente;
    }

    public void setTextoNumeroTituloCliente(String textoNumeroTituloCliente) {
        this.textoNumeroTituloCliente = textoNumeroTituloCliente;
    }

    public String getCodigoTipoInscricaoPagador() {
        return codigoTipoInscricaoPagador;
    }

    public void setCodigoTipoInscricaoPagador(String codigoTipoInscricaoPagador) {
        this.codigoTipoInscricaoPagador = codigoTipoInscricaoPagador;
    }

    public String getNumeroInscricaoPagador() {
        return numeroInscricaoPagador;
    }

    public void setNumeroInscricaoPagador(String numeroInscricaoPagador) {
        this.numeroInscricaoPagador = numeroInscricaoPagador;
    }

    public String getNomePagador() {
        return nomePagador;
    }

    public void setNomePagador(String nomePagador) {
        this.nomePagador = nomePagador;
    }

    public String getTextoEnderecoPagador() {
        return textoEnderecoPagador;
    }

    public void setTextoEnderecoPagador(String textoEnderecoPagador) {
        this.textoEnderecoPagador = textoEnderecoPagador;
    }

    public String getNumeroCepPagador() {
        return numeroCepPagador;
    }

    public void setNumeroCepPagador(String numeroCepPagador) {
        this.numeroCepPagador = numeroCepPagador;
    }

    public String getNomeMunicipioPagador() {
        return nomeMunicipioPagador;
    }

    public void setNomeMunicipioPagador(String nomeMunicipioPagador) {
        this.nomeMunicipioPagador = nomeMunicipioPagador;
    }

    public String getNomeBairroPagador() {
        return nomeBairroPagador;
    }

    public void setNomeBairroPagador(String nomeBairroPagador) {
        this.nomeBairroPagador = nomeBairroPagador;
    }

    public String getSiglaUfPagador() {
        return siglaUfPagador;
    }

    public void setSiglaUfPagador(String siglaUfPagador) {
        this.siglaUfPagador = siglaUfPagador;
    }

    public String getCodigoChaveUsuario() {
        return codigoChaveUsuario;
    }

    public void setCodigoChaveUsuario(String codigoChaveUsuario) {
        this.codigoChaveUsuario = codigoChaveUsuario;
    }

    public String getCodigoTipoCanalSolicitacao() {
        return codigoTipoCanalSolicitacao;
    }

    public void setCodigoTipoCanalSolicitacao(String codigoTipoCanalSolicitacao) {
        this.codigoTipoCanalSolicitacao = codigoTipoCanalSolicitacao;
    }

}
