/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.enums;

/**
 *
 * @author ti05
 */
public enum OrdenacaoContasAPagar {

    CENTRO_RESULTADO_FORNECEDOR("Centro de Resultados/Fornecedor", "cr.id, fn.id"),
    CENTRO_RESULTADO_VENCIMENTO("Centro de Resultados/Vencimento", "cr.id, cpv.data desc"),
    FORNECEDOR_DOCUMENTO("Fornecedor/Documento", "fn.id, cp.documento"),
    FORNECEDOR_CODIGO("Fornecedor/Código", "fn.id, cpv.id"),
    FORNECEDOR_VENCIMENTO("Fornecedor/Vencimento", "fn.id, cpv.data desc"),
    FORNECEDOR_ENTRADA("Fornecedor/Entrada", "fn.id, cp.entrada desc"),
    FORNECEDOR_CANCELAMENTO("Fornecedor/Cancelamento", "fn.id, cpv.dataCancelamento desc"),
    FORNECEDOR_CENTRO_DE_RESULTADO("Fornecedor/Centro de Resultado", "fn.id, cr.id"),
    CONTAFINANCEIRA_VALOR("Conta Financeira/Valor", "cf.id, cpv.valor desc"),
    CONTAFINANCEIRA_FORNECEDOR("Conta Financeira/Fornecedor", "cf.id, fn.id"),
    CONTAFINANCEIRA_VENCIMENTO("Conta Financeira/Vencimento", "cf.id, cpv.data desc"),
    CONTAS_A_PAGAR_VENCIMENTO("Contas a Pagar/Vencimento", "cp.id, cpv.data desc"),
    DESPESA_FORNECEDOR("Despesa/Fornecedor", "rd.id, fn.id"),
    DESPESA_VENCIMENTO("Despesa/Vencimento", "rd.id, cpv.data desc");

    private OrdenacaoContasAPagar(String descricao, String order) {
        this.descricao = descricao;
        this.ordenacao = order;
    }

    String descricao;
    String ordenacao;

    public String getDescricao() {
        return descricao;
    }

    public String getOrdenacao() {
        return ordenacao;
    }

    public void setOrdenacao(String ordenacao) {
        this.ordenacao = ordenacao;
    }

}