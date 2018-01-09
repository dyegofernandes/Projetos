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
public enum OrigemLancamento {

    MANUAL("M", "Manual"),
    BAIXA_VENCIMENTO_CONTASAPAGAR("P", "Baixa de Vencimento do Contas a Pagar"),
    BAIXA_VENCIMENTO_DIVERSOS("D", "Baixa de Vencimento Diversos"),
    DESCONTO_VENCIMENTO_DIVERSOS("S", "Desconto de Vencimento Diversos"),
    JUROS_DO_CONTAS_A_PAGAR("O","Juros do Contas a Pagar"),
    CHEQUE_AVULSO("A","Cheque Avulso"),
    DESCONTO_DE_CONTAS_A_PAGAR("G","Desconto de Contas a Pagar"),
    JUROS_DE_VENCIMENTOS_DIVERSOS("U","Juros de Vencimento Diversos"),
    BAIXA_DE_VENCIMENTO_DE_CHEQUE("H","Baixa de Vencimento de Cheque"),
    MULTA_DO_CONTAS_A_PAGAR("B","Multa do Contas a Pagar");

    private OrigemLancamento(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    String descricao;
    String sigla;

    public String getDescricao() {
        return descricao;
    }

    public String getSigla() {
        return sigla;
    }
}
