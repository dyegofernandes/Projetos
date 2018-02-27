/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pagcontascarne.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum SituacaoBoleto {

    EM_ABERTO(1, "Em Aberto"),
    BAIXADO(2, "Baixado"),
    CANCELADO(3, "Cancelado"),
    RENEGOCIADO(4, "Renegociado");

    private SituacaoBoleto(int num, String descricao) {
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
