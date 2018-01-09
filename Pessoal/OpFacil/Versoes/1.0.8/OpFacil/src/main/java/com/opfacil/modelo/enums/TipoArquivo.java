/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.modelo.enums;

/**
 *
 * @author KillerBeeTwo
 */
public enum TipoArquivo {

    GERADA(0, "Gerada"),
    CANCELADA(1, "Cancelada"),
    TESTE(2, "Teste"),
    CULPOM(3,"Culpom");

    private TipoArquivo(int num, String descricao) {
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
