/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum AssuntoRequerimento {

    FERIAS(1, "Férias"),
    COMPENSACAO(2, "Compensação de dias trabalhados"),
    SOLICITACAO_VALE(3, "Solicitação de Vale Transporte"),
    JUSTIFICATIVA_FALTA(4, "Justificativa de faltas"),
    OUTROS(5, "Outros");

    private AssuntoRequerimento(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }
    private String descricao;
    private int num;

    public String getDescricao() {
        return descricao;
    }

    public int getNum() {
        return num;
    }

}
