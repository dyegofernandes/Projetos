/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.enuns;

/**
 *
 * @author KillerBeeTwo
 */
public enum SituacaoDebito {

    NAOEFETIVADO(1, "Não Efetivado"),
    EFETIVADO(2, "Efetivado");

    private SituacaoDebito(int num, String descricao) {
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
