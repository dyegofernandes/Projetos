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
public enum TipoPessoa {

    PJ(1, "Pessoa Jurídica"),
    PF(2, "Pessoa Física");

    private TipoPessoa(int num, String descricao) {
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
