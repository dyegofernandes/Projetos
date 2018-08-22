/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facilpagar.modelo.dados.vos;

import br.com.facilpagar.util.Utils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Juniel
 */
public class BoletoVO implements Serializable {

    private String beneficiario;
    private String agenciaBeneficiario;
    private String numeroDocumento;
    private String nossoNumero;
    private String vencimento;
    private String valorDocumento;
    private String desconto;
    private String outrosAcrescimos;
    private String valorCobrado;
    private String pagador;
    private String localPagamento;
    private String dataDocumento;
    private String especieDoc;
    private String aceite;
    private String dataProcesso;
    private String usoDoBanco;
    private String carteira;
    private String especie;
    private String quantidade;
    private String xValor;
    private String instrucoes;
    private String codBaixa;
    private String outrasDeducoes;
    private String multa;
    private String codigoBarras;
    private String referenteA;
    private String enderecoPagador;
    private String beneficiarioAvalista;
    private String linhaDigitavel;
    private String descontoTexto;
    private String multaTexto;
    private String juros;
    private String jurosTexto;
    private String nomeConvenio;

    public BoletoVO() {
    }

    public BoletoVO(String nomeConvenio, String numeroDocumento, Long nossoNumero, Date vencimento, BigDecimal valorDocumento,
            BigDecimal multa, BigDecimal desconto, BigDecimal juros, String pagador, String localPagamento,
            Date dataDocumento, String instrucoes, String referenteA,
            String enderecoPagador, String linhaDigitavel, String codigoBarras) {
        this.beneficiario = "Fácil Pagar - ".concat(nomeConvenio).concat(" Rua Desembargador Freitas, 1900 - Teresina Piauí");
        this.agenciaBeneficiario = "2345-0/23456-7";
        this.numeroDocumento = Utils.inserirZeroEsquerda(nossoNumero.toString(), 11);
        this.nossoNumero = Utils.inserirZeroEsquerda(nossoNumero.toString(), 11); // boleto.nossonumero formato 00000000001
        this.vencimento = Utils.convertDateToString(vencimento, "dd/MM/yyyy");
        this.valorDocumento = Utils.moeda(valorDocumento);
        this.desconto = Utils.moeda(desconto); // Texto: "Conceder desconto de R$ boleto.vl_desconto até o vencimento!" A ser exibido na área de instruções 
        this.descontoTexto = desconto.compareTo(BigDecimal.ZERO) > 0 ? "Conceder desconto de R$ " + Utils.moeda(desconto) + " até o vencimento!" : "";
        this.pagador = pagador; // Dados do cliente: cliente.nome_fantasia cliente.completo_razaosocial - cliente.cpf 
        this.localPagamento = localPagamento; // convenio.localpagto
        this.dataDocumento = Utils.convertDateToString(dataDocumento, "dd/MM/yyyy"); // boleto.dt_criacao
        this.especieDoc = "DS";
        this.aceite = "N";
        this.dataProcesso = Utils.convertDateToString(new Date(), "dd/MM/yyyy");; // Data do sistema
        this.carteira = "1";
        this.especie = "R$";
        this.instrucoes = instrucoes; // Vários textos. Quer colocar tudo em um único campo?
        this.multa = Utils.moeda(multa); // Texto: "Cobrar multa de R$ boleto.vl_multa após o vencimento."
        this.multaTexto = multa.compareTo(BigDecimal.ZERO) > 0 ? "Cobrar multa de R$ " + Utils.moeda(multa) + " após o vencimento." : "";
        this.codigoBarras = codigoBarras; //boleto.cb
        this.referenteA = referenteA; // boleto.referentea
        this.enderecoPagador = enderecoPagador; //cliente. endereco cliente.bairro CEP:cliente.cep cidade.nome-uf.sigla
        this.linhaDigitavel = linhaDigitavel; // calculada a partir de ou obtida do BB
        this.juros = Utils.moeda(juros);
        this.jurosTexto = juros.compareTo(BigDecimal.ZERO) > 0 ? "Juros R$: ".concat(Utils.moeda(juros)) : "";
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public String getAgenciaBeneficiario() {
        return agenciaBeneficiario;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public String getVencimento() {
        return vencimento;
    }

    public String getValorDocumento() {
        return valorDocumento;
    }

    public String getDesconto() {
        return desconto;
    }

    public String getOutrosAcrescimos() {
        return outrosAcrescimos;
    }

    public String getValorCobrado() {
        return valorCobrado;
    }

    public String getPagador() {
        return pagador;
    }

    public String getLocalPagamento() {
        return localPagamento;
    }

    public String getDataDocumento() {
        return dataDocumento;
    }

    public String getEspecieDoc() {
        return especieDoc;
    }

    public String getAceite() {
        return aceite;
    }

    public String getDataProcesso() {
        return dataProcesso;
    }

    public String getUsoDoBanco() {
        return usoDoBanco;
    }

    public String getCarteira() {
        return carteira;
    }

    public String getEspecie() {
        return especie;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public String getxValor() {
        return xValor;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public String getCodBaixa() {
        return codBaixa;
    }

    public String getOutrasDeducoes() {
        return outrasDeducoes;
    }

    public String getMulta() {
        return multa;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public String getReferenteA() {
        return referenteA;
    }

    public String getEnderecoPagador() {
        return enderecoPagador;
    }

    public String getBeneficiarioAvalista() {
        return beneficiarioAvalista;
    }

    public String getLinhaDigitavel() {
        return linhaDigitavel;
    }

    public String getDescontoTexto() {
        return descontoTexto;
    }

    public String getMultaTexto() {
        return multaTexto;
    }

    public String getJuros() {
        return juros;
    }

    public void setJuros(String juros) {
        this.juros = juros;
    }

    public String getJurosTexto() {
        return jurosTexto;
    }

    public void setJurosTexto(String jurosTexto) {
        this.jurosTexto = jurosTexto;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

}
