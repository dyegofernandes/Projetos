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
public enum SituacaoOpRealizadas {

    PAGA(0, "Paga"),
    EXPIRADA(1, "Expirada"),
    DISPONIVEL(2, "Disponível"),
    CANCELADA(3,"Cancelada"),
    DEVOLVIDA(4, "Devolvida");

    private SituacaoOpRealizadas(int num, String descricao) {
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
