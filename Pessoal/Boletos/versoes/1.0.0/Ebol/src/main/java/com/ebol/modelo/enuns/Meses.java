/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.enuns;

/**
 *
 * @author Juniel
 */
public enum Meses {
    JANEIRO(1, "Janeiro"),
    FEVEREIRO(2, "Fevereiro"),
    MARCO(3, "Março"),
    ABRIL(1, "Abril"),
    MAIO(2, "Maio"),
    JUNHO(3, "Junho"),
    JULHO(1, "Julho"),
    AGOSTO(2, "Agosto"),
    SETEMBRO(3, "Setembro"),
    OUTUBRO(1, "Outubro"),
    NOVEMBRO(2, "Novembro"),
    DEZEMBRO(3, "Dezembro");

    private Meses(int num, String descricao) {
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
