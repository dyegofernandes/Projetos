/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.modelo.enums;

/**
 *
 * @author ti05
 */
public enum SituacaoOp {

    NAOGERADA(0, "Não Gerada"),
    GERADA(1, "Gerada"),
    CANCELADA(2, "Cancelada");

    private SituacaoOp(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }

    String descricao;
    int num;

    public String getDescricao() {
        return descricao;
    }

    public int getNum() {
        return num;
    }

}
